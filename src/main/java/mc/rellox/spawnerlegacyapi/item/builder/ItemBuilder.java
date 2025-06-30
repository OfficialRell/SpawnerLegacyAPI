package mc.rellox.spawnerlegacyapi.item.builder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.item.ItemManager;
import mc.rellox.spawnerlegacyapi.registry.KeyType;
import mc.rellox.spawnerlegacyapi.registry.Keys;
import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.IContent.Variables;
import mc.rellox.spawnerlegacyapi.utility.Calculate;
import mc.rellox.spawnerlegacyapi.utility.Utility;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import mc.rellox.spawnerlegacyapi.version.Version;
import mc.rellox.spawnerlegacyapi.version.Version.VersionType;

public final class ItemBuilder {
	
	/**
	 * Creates a new item builder for this material type.
	 * 
	 * @param material - item material
	 * @return New item builder
	 */
	
	public static ItemBuilder of(Material material) {
		return new ItemBuilder(material);
	}
	
	/**
	 * Creates a new item builder using a copy of this item.
	 * The new item builder will not modify the original item,
	 * it will be a copy.
	 * 
	 * @param item - original item
	 * @return New item builder
	 */
	
	public static ItemBuilder of(ItemStack item) {
		return new ItemBuilder(item.clone());
	}
	
	private final ItemStack item;
	
	private final List<Modifier> modifiers;
	
	private final ItemIContent content;
	
	private ItemBuilder(Material material) {
		this(new ItemStack(material));
	}
	
	private ItemBuilder(ItemBuilder builder) {
		this.item = builder.item;
		this.modifiers = new LinkedList<>(builder.modifiers);
		this.content = builder.content.clone();
	}
	
	private ItemBuilder(ItemStack item) {
		this.item = item;
		this.modifiers = new LinkedList<>();
		this.content = new ItemIContent();
	}
	
	private ItemBuilder modify(Modifier m) {
		modifiers.add(m);
		return this;
	}
	
	/**
	 * @return Returns an item stack with amount of 1
	 */
	
	public ItemStack build() {
		return build(1);
	}
	
	/**
	 * @param a - item amount
	 * @return Returns an item stack with a specific amount
	 */
	
	public ItemStack build(int a) {
		ItemStack clone = item.clone();
		clone.setAmount(a);
		ItemMeta meta = clone.getItemMeta();
		modifiers.forEach(m -> m.modify(meta));
		content.modify(meta);
		clone.setItemMeta(meta);
		return clone;
	}
	
	/**
	 * Drops this item at the specified location.
	 * 
	 * @param loc - drop location
	 */
	
	public void drop(Location loc) {
		drop(1, loc);
	}
	
	/**
	 * Drops this item with a specific amount at the specified location.
	 * 
	 * @param a - item amount
	 * @param loc - drop location
	 */
	
	public void drop(int a, Location loc) {
		loc.getWorld().dropItem(loc, build(a)).setVelocity(new Vector());
	}
	
	// Modifiers
	
	/**
	 * Sets the type of the item.
	 * 
	 * @param type - material type
	 * @return This item builder
	 */
	
	public ItemBuilder type(Material type) {
		if(type == null || item.getType() == type) return this;
		item.setType(type);
		return this;
	}

	/**
	 * Sets the name of the item.
	 * 
	 * @param name - item name
	 * @return This item builder
	 */
	
	public ItemBuilder named(IContent name) {
		content.name = name;
		return this;
	}

	/**
	 * Sets the name of the item and all the leftover contents
	 * adds to the start of the lore.
	 * 
	 * @param name - item name list
	 * @return This item builder
	 */
	
	public ItemBuilder named(List<IContent> name) {
		if(name.isEmpty() == true) return this;
		List<IContent> copy = new ArrayList<>(name);
		content.name = copy.remove(0);
		content.lore.addAll(0, copy);
		return this;
	}

	/**
	 * Sets the name of the item depending on the boolean value.
	 * 
	 * @param value - boolean value
	 * @param if_true - name if {@code true}
	 * @param if_false - name if {@code false}
	 * @return This item builder
	 */
	
	public ItemBuilder named(boolean value, IContent if_true, IContent if_false) {
		content.name = value ? if_true : if_false;
		return this;
	}

	/**
	 * Sets an empty name ({@code " "}).
	 * 
	 * @return This item builder
	 */
	
	public ItemBuilder unnamed() {
		content.name = IContent.space();
		return this;
	}
	
	/**
	 * Adds glint to this item.
	 * 
	 * @return This item builder
	 */
	
	public ItemBuilder shining() {
		return shining(true);
	}
	
	/**
	 * Adds glint to this item if {@code true}, otherwise does nothing. 
	 * 
	 * @param b - if shining 
	 * @return This item builder
	 */
	
	public ItemBuilder shining(boolean b) {
		return b ? modify(meta -> {
			ItemManager.glint(meta);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}) : this;
	}
	
	/**
	 * Sets all item flags.
	 * 
	 * @return This item builder
	 */

	public ItemBuilder flaged() {
		return modify(meta -> {
			if(Version.version.high(VersionType.v_20_4) == true)
				meta.addAttributeModifier(Utility.attribute_damage, attribute());
			meta.addItemFlags(ItemFlag.values());
			if(Version.version.high(VersionType.v_21_4) == true) {
				for(var i : ItemFlag.values()) {
					if(i.name().equals("HIDE_LORE") == true) {
						meta.removeItemFlags(i);
						break;
					}
				}
			}
		});
	}
	
	private AttributeModifier attribute() {
		return RF.build(AttributeModifier.class, NamespacedKey.class,
				double.class, Operation.class, EquipmentSlotGroup.class)
				.instance(new NamespacedKey(SLAPI.get().plugin(), "hidden"),
						0, Operation.ADD_SCALAR, EquipmentSlotGroup.ANY);
	}
	
	/**
	 * Hides the tooltip on this item.
	 * 
	 * @return This item builder
	 */
	
	public ItemBuilder hidden() {
		if(Version.version.high(VersionType.v_20_4) == false) return this;
		return modify(meta -> {
			RF.order(meta, "setHideTooltip", boolean.class).invoke(true);
		});
	}
	
	/**
	 * Sets a persistent data value on this item.
	 * 
	 * @param <Z> - value type
	 * @param key - namespace key
	 * @param type - data type
	 * @param value - data value
	 * @return This item builder
	 */
	
	public <Z> ItemBuilder keyed(NamespacedKey key, PersistentDataType<?, Z> type, Z value) {
		return value == null ? this : modify(meta -> {
			PersistentDataContainer p = meta.getPersistentDataContainer();
			p.set(key, type, value);
		});
	}
	
	/**
	 * Sets a persistent data string value on this item.
	 * 
	 * @param key - namespace key
	 * @param value - data value
	 * @return This item builder
	 */
	
	public ItemBuilder keyed(NamespacedKey key, String value) {
		return keyed(key, PersistentDataType.STRING, value);
	}
	
	/**
	 * Sets a persistent data integer value on this item.
	 * 
	 * @param key - namespace key
	 * @param value - data value
	 * @return This item builder
	 */
	
	public ItemBuilder keyed(NamespacedKey key, int value) {
		return keyed(key, PersistentDataType.INTEGER, value);
	}
	
	/**
	 * Sets a persistent data double value on this item.
	 * 
	 * @param key - namespace key
	 * @param value - data value
	 * @return This item builder
	 */
	
	public ItemBuilder keyed(NamespacedKey key, double value) {
		return keyed(key, PersistentDataType.DOUBLE, value);
	}
	
	/**
	 * Sets a persistent data long value on this item.
	 * 
	 * @param key - namespace key
	 * @param value - data value
	 * @return This item builder
	 */
	
	public ItemBuilder keyed(NamespacedKey key, long value) {
		return keyed(key, PersistentDataType.LONG, value);
	}
	
	/**
	 * Sets a persistent data boolean value on this item.<br>
	 * Value is saved as type {@code PersistentDataType.BYTE}
	 * ({@code true} is 1, {@code false} is 0)
	 * 
	 * @param key - namespace key
	 * @param value - data value
	 * @return This item builder
	 */
	
	public ItemBuilder keyed(NamespacedKey key, boolean value) {
		return keyed(key, PersistentDataType.BYTE, (byte) (value ? 1 : 0));
	}
	
	/**
	 * Sets a persistent data integer array value on this item.
	 * 
	 * @param key - namespace key
	 * @param value - data value
	 * @return This item builder
	 */
	
	public ItemBuilder keyed(NamespacedKey key, int[] value) {
		return keyed(key, PersistentDataType.INTEGER_ARRAY, value);
	}
	
	/**
	 * Adds a random key to this item with an arbitrary integer to ensure randomness
	 * and disable item stacking.
	 * 
	 * @return This item builder
	 */
	
	public ItemBuilder randomize() {
		return keyed(Keys.of(KeyType.RANDOM), Calculate.random());
	}
	
	/**
	 * Colors this item, only if it is:<br>
	 * - leather armor<br>
	 * - firework star<br>
	 * - potion
	 * 
	 * @param color - color
	 * @return This item builder
	 */
	
	public ItemBuilder colored(Color color) {
		return modify(meta -> {
			if(meta instanceof LeatherArmorMeta m) m.setColor(color);
			else if(meta instanceof FireworkEffectMeta m) m.setEffect(FireworkEffect.builder().withColor(color).build());
			else if(meta instanceof PotionMeta m) m.setColor(color);
		});
	}
	
	/**
	 * Colors this item. {@link #colored(Color)}
	 * 
	 * @param hex - rgb color hex value
	 * @return This item builder
	 */
	
	public ItemBuilder colored(String hex) {
		Color color = Color.fromRGB(Integer.parseInt(hex, 16));
		return color == null ? this : colored(color);
	}
	
	/**
	 * Sets the specified uuid as the skull skin.
	 * 
	 * @param sid - uuid value as string
	 * @return This item builder
	 */
	
	public ItemBuilder skull(String sid) {
		try {
			UUID id = UUID.fromString(sid);
			return skull(id);
		} catch (Exception e) {}
		return this;
	}
	
	/**
	 * Sets the specified uuid as the skull skin.
	 * 
	 * @param id - uuid
	 * @return This item builder
	 */
	
	public ItemBuilder skull(UUID id) {
		return modify(meta -> {
			if(meta instanceof SkullMeta skull) {
				OfflinePlayer op = Bukkit.getOfflinePlayer(id);
				skull.setOwningPlayer(op);
			}
		});
	}
	
	/**
	 * Adds this list to the lore.
	 * 
	 * @param list - contents
	 * @return This item builder
	 */
	
	public ItemBuilder describe(List<IContent> list) {
		content.lore.addAll(list);
		return this;
	}
	
	/**
	 * Adds this line to the list.
	 * 
	 * @param line - content
	 * @return This item builder
	 */
	
	public ItemBuilder describe(IContent line) {
		content.lore.add(line);
		return this;
	}
	
	/**
	 * Adds this list to the lore if the boolean value is {@code true}.
	 * 
	 * @param b - boolean value
	 * @param list - contents
	 * @return This item builder
	 */
	
	public ItemBuilder describe(boolean b, IContent... lines) {
		return b ? describe(lines) : this;
	}
	
	/**
	 * Adds this array to the lore.
	 * 
	 * @param lines - contents
	 * @return This item builder
	 */
	
	public ItemBuilder describe(IContent... lines) {
		return describe(List.of(lines));
	}
	
	/**
	 * Parses this object list and adds the contents to the lore.
	 * 
	 * @param <A> - object type
	 * @param list - object list
	 * @param f - content parser
	 * @return This item builder
	 */
	
	public <A> ItemBuilder describe(List<A> list, Function<A, IContent> f) {
		return list.isEmpty() == true ? this : describe(list, f, null);
	}
	
	/**
	 * Parses this object list and adds the contents to the lore.
	 * If the list was empty then adds the specified value.
	 * 
	 * @param <A> - object type
	 * @param list - object list
	 * @param f - content parser
	 * @param or - content if the list is empty
	 * @return This item builder
	 */
	
	public <A> ItemBuilder describe(List<A> list, Function<A, IContent> f, IContent or) {
		return list.isEmpty() == true ? (or == null ? this : describe(or))
				: describe(list.stream()
						.map(f)
						.collect(Collectors.toList()));
	}
	
	/**
	 * Allows to modify this item depending on the boolean value.
	 * 
	 * @param value - boolean value
	 * @param if_true - item consumer function if {@code true}
	 * @param if_false - item consumer function if {@code false}
	 * @return This item builder
	 */
	
	public ItemBuilder variate(boolean value, Consumer<ItemBuilder> if_true,
			Consumer<ItemBuilder> if_false) {
		if(value == true) if_true.accept(this);
		else if_false.accept(this);
		return this;
	}
	
	/**
	 * Sets the custom item model data.
	 * 
	 * @param m - custom item model data
	 * @return This item builder
	 */
	
	@SuppressWarnings("deprecation")
	public ItemBuilder modelled(int m) {
		return m > 0 ? modify(meta -> meta.setCustomModelData(m)) : this;
	}
	
	/**
	 * Adds enchantments to this item.
	 * 
	 * @param enchantments - map of enchantments and levels
	 * @return This item builder
	 */
	
	public ItemBuilder enchanted(Map<Enchantment, Integer> enchantments) {
		return modify(meta -> {
			enchantments.forEach((enchantment, level)
					-> meta.addEnchant(enchantment, level, true));
		});
	}
	
	/**
	 * Adds an enchantment to this item.
	 * 
	 * @param enchantment - enchantment
	 * @param level - level
	 * @return This item builder
	 */
	
	public ItemBuilder enchanted(Enchantment enchantment, int level) {
		return modify(meta -> meta.addEnchant(enchantment, level, true));
	}
	
	/**
	 * Adds the specified item content variable.
	 * 
	 * @param var - variable
	 * @param to - value
	 * @return This item builder
	 */
	
	public ItemBuilder replace(String var, Object to) {
		return replace(var, IContent.of(to));
	}
	
	/**
	 * Adds the specified item content variable.
	 * 
	 * @param var - variable
	 * @param to - value
	 * @return This item builder
	 */
	
	public ItemBuilder replace(String var, IContent to) {
		content.replace(var, to);
		return this;
	}
	
	/**
	 * Adds the specified item content variable if boolean value is {@code true}.
	 * 
	 * @param b - boolean value
	 * @param var - variable
	 * @param to - value supplier
	 * @return This item builder
	 */
	
	public ItemBuilder replace(boolean b, String var, Supplier<IContent> to) {
		return b ? replace(var, to.get()) : this;
	}
	
	@Override
	public ItemBuilder clone() {
		return new ItemBuilder(this);
	}

	public static interface Modifier {
		void modify(ItemMeta m);
	}
	
	protected class ItemIContent {
		
		private final List<Object> replace;
		
		private IContent name;
		private final List<IContent> lore;
		
		public ItemIContent() {
			this.lore = new ArrayList<>();
			this.replace = new ArrayList<>();
		}
		
		public void replace(String var, IContent c) {
			replace.add(var);
			replace.add(c);
		}
		
		private void modify(ItemMeta meta) {
			Variables vars = replace.isEmpty() == true
					? Variables.empty : Variables.with(replace.toArray());
			if(name != null) meta.setDisplayName(name.text(vars));
			List<String> previous = meta.getLore();
			if(lore.isEmpty() == false) {
				List<String> list = lore.stream()
					.map(c -> c.text(vars))
					.collect(Collectors.toList());
				Text.clean(list);
				if(previous != null) list.addAll(0, previous);
				meta.setLore(list.isEmpty() == true ? null : list);
			}
		}
		
		@Override
		protected ItemIContent clone() {
			ItemIContent copy = new ItemIContent();
			copy.name = name;
			copy.lore.addAll(lore);
			return copy;
		}
		
	}

}
