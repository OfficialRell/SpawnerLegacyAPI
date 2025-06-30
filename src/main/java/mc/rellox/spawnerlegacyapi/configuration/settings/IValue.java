package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IValue<T> extends ILoad {
	
	T get(SpawnerType type);
	
}
