package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.view.IInventory;

public interface IViewManager {
	
	/**
	 * Adds the inventory to active list.
	 * 
	 * @param inventory - inventory
	 * @return {@code true} if added
	 */
	
	boolean add(IInventory inventory);
	
	/**
	 * Removes the inventory from active list.
	 * 
	 * @param inventory - inventory
	 * @return {@code true} if removed
	 */
	
	boolean remove(IInventory inventory);

}
