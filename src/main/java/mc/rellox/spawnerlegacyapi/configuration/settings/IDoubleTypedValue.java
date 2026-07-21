package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.stream.DoubleStream;

public interface IDoubleTypedValue extends ILoad {

	double get(SpawnerType type);

	DoubleStream stream();

}
