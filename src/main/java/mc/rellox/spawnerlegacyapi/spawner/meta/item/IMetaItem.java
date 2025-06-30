package mc.rellox.spawnerlegacyapi.spawner.meta.item;

import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.KeyedContent;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IMetaItem extends ISave {
	
	/**
	 * @return Item material
	 */
	
	Material material();
	
	/**
	 * @return Item name or {@code null}
	 */
	
	IContent name();
	
	/**
	 * @return Item lore
	 */
	
	List<IContent> lore();
	
	/**
	 * @return Item enchantments
	 */
	
	Map<Enchantment, Integer> enchantments();
	
	/**
	 * @return Item model data
	 */
	
	int model();
	
	/**
	 * @return Item id
	 */
	
	String id();
	
	/**
	 * @return Created item stack
	 */
	
	default ItemStack item() {
		return item(1);
	}
	
	/**
	 * @param amount - amount
	 * @return Created item stack
	 */
	
	default ItemStack item(int amount) {
		return ItemBuilder.of(material())
				.named(name())
				.describe(lore())
				.modelled(model())
				.enchanted(enchantments())
				.build(amount);
	}

	@SuppressWarnings("deprecation")
	@Override
	default void save(IFile file, String p) {
		String path = p + "." + id();
		file.set(path + ".material", material().name());
		if(name() != null) file.set(path + ".name", ((KeyedContent) name()).key());
		if(lore().isEmpty() == false) file.set(path + ".lore", lore().stream()
				.map(KeyedContent.class::cast)
				.map(KeyedContent::key)
				.toList());
		if(enchantments().isEmpty() == false) {
			enchantments().forEach((e, i) -> {
				NamespacedKey key = e.getKey();
				if(key == null) return;
				file.set(path + ".enchantments." + key.getKey(), i);
			});
		}
		if(model() > 0) file.set(path + ".model", model());
	}

}
