package mc.rellox.spawnerlegacyapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * Spawner Legacy API class
 */

public final class SLAPI {
	
	private static final ISpawnerLegacy INSTANCE;
	static {
		var plugin = Bukkit.getPluginManager().getPlugin("SpawnerLegacy");
		if(plugin == null)
			throw new NullPointerException("Cannot initialize SpawnerLegacy API");
		INSTANCE = ((ISpawnerLegacyPlugin) plugin).instance();
	}
	
	public static ISpawnerLegacy get() {
		return INSTANCE;
	}
	
	public interface ISpawnerLegacyPlugin extends Plugin {
		
		ISpawnerLegacy instance();
		
	}

}
