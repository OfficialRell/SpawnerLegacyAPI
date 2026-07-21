package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.List;
import java.util.stream.Stream;

public interface IPricesTypedValue extends ILoad {

	List<IPrice> get(SpawnerType type);

	Stream<List<IPrice>> stream();

}
