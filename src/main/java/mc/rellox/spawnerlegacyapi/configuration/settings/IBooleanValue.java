package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IBooleanValue extends ILoad {

	boolean get(SpawnerType type);
	
	boolean any(boolean b);
	
}
