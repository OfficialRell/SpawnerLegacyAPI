package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.view.IInventory;

public interface IViewManager {
	
	boolean add(IInventory i);
	
	boolean remove(IInventory i);

}
