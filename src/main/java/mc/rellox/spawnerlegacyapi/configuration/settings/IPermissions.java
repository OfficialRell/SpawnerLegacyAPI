package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;
import org.bukkit.entity.Player;

public interface IPermissions extends ILoad {

	boolean has(Player player, IFilterContext context);

}
