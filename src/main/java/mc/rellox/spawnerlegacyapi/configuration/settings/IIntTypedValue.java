package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.stream.IntStream;

public interface IIntTypedValue extends ILoad {

	int get(SpawnerType type);

	IntStream stream();
	
}
