package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IDoubleValue extends ILoad {

	double get(SpawnerType type);

}
