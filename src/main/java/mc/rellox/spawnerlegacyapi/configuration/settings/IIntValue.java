package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IIntValue extends ILoad {

	int get(SpawnerType type);
	
}
