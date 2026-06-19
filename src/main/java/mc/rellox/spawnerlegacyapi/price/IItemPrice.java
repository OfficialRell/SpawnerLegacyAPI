package mc.rellox.spawnerlegacyapi.price;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;

public interface IItemPrice {

	/**
	 * @return Item that will be created from this price
	 */
	
	ItemBuilder item();

}
