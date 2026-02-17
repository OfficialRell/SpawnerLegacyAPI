package mc.rellox.spawnerlegacyapi.price;

import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface IDefinedItem {
	
	/**
	 * @return Item key
	 */
	
	String key();
	
	/**
	 * @return Item name
	 */
	
	IContent name();
	
	/**
	 * @return Item builder
	 */
	
	ItemBuilder item();
	
	/**
	 * @param item - item
	 * @return {@code true} if item matches this item
	 */
	
	boolean matches(ItemStack item);
	
	/**
	 * @param amount - price amount
	 * @return Price of this item with given amount
	 */
	
	IPrice price(double amount);

}
