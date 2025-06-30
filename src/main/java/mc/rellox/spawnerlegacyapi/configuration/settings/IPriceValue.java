package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IPriceValue extends ILoad {
	
	IPrice get(SpawnerType type);

}
