package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IDoubleArrayValue extends ILoad {

	double[] get(SpawnerType type);

}
