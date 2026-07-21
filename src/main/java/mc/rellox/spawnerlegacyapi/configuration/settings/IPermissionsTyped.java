package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import org.bukkit.entity.Player;

public interface IPermissionsTyped extends ILoad {

	boolean has(Player player, SpawnerType type);

}
