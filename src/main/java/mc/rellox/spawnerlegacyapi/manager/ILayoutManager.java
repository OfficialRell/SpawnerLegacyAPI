package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.view.layout.ILayout;
import mc.rellox.spawnerlegacyapi.view.layout.IViewItem;
import mc.rellox.spawnerlegacyapi.view.layout.order.IOrder;

public interface ILayoutManager {
	
	/**
	 * Gets the layout item that is saved in the global item list.
	 * 
	 * @param key - layout item key
	 * @return Layout item
	 */
	
	IViewItem item(String key);
	
	/**
	 * Gets the layout for the upgrade GUI of the given spawner type.
	 * 
	 * @param type - type
	 * @return Layout for upgrade GUI
	 */
	
	ILayout upgrades(SpawnerType type);
	
	/**
	 * @return Layout for purchase shop GUI
	 */
	
	ILayout purchase();
	
	/**
	 * @return Layout for sell shop GUI
	 */
	
	ILayout sell();
	
	/**
	 * @return Layout for spawner types GUI
	 */
	
	ILayout types();
	
	/**
	 * 
	 * @param key - order key
	 * @return Item orderer, never {@code null}
	 */
	
	IOrder order(String key);

}
