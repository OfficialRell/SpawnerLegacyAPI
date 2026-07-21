package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.stream.Stream;

public interface IPriceTypedValue extends ILoad {

	IPrice get(SpawnerType type);

	Stream<IPrice> stream();

}
