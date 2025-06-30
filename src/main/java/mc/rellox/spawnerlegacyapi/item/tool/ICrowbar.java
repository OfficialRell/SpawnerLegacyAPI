package mc.rellox.spawnerlegacyapi.item.tool;

import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.configuration.settings.HolderType;
import mc.rellox.spawnerlegacyapi.item.IItemConstant;
import mc.rellox.spawnerlegacyapi.price.IPrice;

public interface ICrowbar {
	
	/**
	 * @return Unique crowbar ID
	 */
	
	String key();
	
	/**
	 * @return Crowbar items builder
	 */
	
	IItemConstant item();
	
	/**
	 * @param usage - crowbar usage
	 * @param chance - success chance
	 * @return Newly created crowbar item
	 */
	
	ItemStack build(int usage, int chance);
	
	/**
	 * @return Newly created crowbar item with default values
	 */
	
	default ItemStack build() {
		return build(usage(), chance());
	}
	
	/**
	 * Updates the item with all the new values.
	 * 
	 * @param item - item
	 * @param usage - new usage
	 * @param chance - new chance
	 */
	
	default void update(ItemStack item, int usage, int chance) {
		item.setItemMeta(build(usage, chance).getItemMeta());
	}
	
	/**
	 * @param item - item
	 * @return {@code true} if this item is this crowbar
	 */
	
	boolean match(ItemStack item);
	
	/**
	 * @return Crowbar ignored values
	 */
	
	ICrowbarIgnore ignore();
	
	/**
	 * @return This crowbar price or {@code null}
	 */
	
	IPrice price();
	
	/**
	 * @return Times this crowbar can be used
	 */
	
	int usage();
	
	/**
	 * @return The chance the spawner will be removed
	 */
	
	int chance();
	
	/**
	 * @return Should the spawner be destroyed if it fails to break it
	 */
	
	boolean destroy();
	
	/**
	 * @return Type of usage this crowbar can be used
	 */
	
	UseType use();
	
	/**
	 * @param holder - holder type
	 * @return {@code true} if this crowbar allows the specified holder type
	 */
	
	boolean allow(HolderType holder);

}