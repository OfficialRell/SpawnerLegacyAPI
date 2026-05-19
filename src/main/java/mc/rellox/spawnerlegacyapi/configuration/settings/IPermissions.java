package mc.rellox.spawnerlegacyapi.configuration.settings;

import org.bukkit.entity.Player;

public interface IPermissions extends ILoad {
	
	int get(Player player, int fallback);
	
	double get(Player player, double fallback);
	
	boolean empty();

}
