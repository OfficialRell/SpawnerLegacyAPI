package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.stream.Stream;

public interface IBooleanTypedValue extends ILoad {

	boolean get(SpawnerType type);
	
	boolean any(boolean b);

	Stream<Boolean> stream();
	
}
