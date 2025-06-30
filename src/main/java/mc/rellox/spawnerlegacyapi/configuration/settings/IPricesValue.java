package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.List;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IPricesValue extends ILoad {
	
	List<IPrice> get(SpawnerType type);

}
