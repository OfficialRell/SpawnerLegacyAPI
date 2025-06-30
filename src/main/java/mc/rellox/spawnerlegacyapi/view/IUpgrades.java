package mc.rellox.spawnerlegacyapi.view;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.ISpawner;

public interface IUpgrades extends IInventory {
	
	/**
	 * @return Entity generator
	 */
	
	IGenerator generator();
	
	/**
	 * @return Spawner
	 */
	
	ISpawner spawner();

}
