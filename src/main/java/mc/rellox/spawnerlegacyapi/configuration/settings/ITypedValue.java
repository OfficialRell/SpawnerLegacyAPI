package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.stream.Stream;

public interface ITypedValue<T> extends ILoad {

	T get(SpawnerType type);

	Stream<T> stream();

}
