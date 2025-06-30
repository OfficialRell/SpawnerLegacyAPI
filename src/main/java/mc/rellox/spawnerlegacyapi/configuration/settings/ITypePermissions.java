package mc.rellox.spawnerlegacyapi.configuration.settings;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ITypePermissions extends ILoad {
	
	boolean has(Player player, SpawnerType type);

}
