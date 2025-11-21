package mc.rellox.spawnerlegacyapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import mc.rellox.spawnerlegacyapi.manager.ICacheManager;
import mc.rellox.spawnerlegacyapi.manager.IDataManager;
import mc.rellox.spawnerlegacyapi.manager.IEntityManager;
import mc.rellox.spawnerlegacyapi.manager.IEventManager;
import mc.rellox.spawnerlegacyapi.manager.IGeneratorManager;
import mc.rellox.spawnerlegacyapi.manager.IHologramManager;
import mc.rellox.spawnerlegacyapi.manager.ILangaugeManager;
import mc.rellox.spawnerlegacyapi.manager.ILayoutManager;
import mc.rellox.spawnerlegacyapi.manager.IModifierManager;
import mc.rellox.spawnerlegacyapi.manager.IPriceManager;
import mc.rellox.spawnerlegacyapi.manager.ISpawnerManager;
import mc.rellox.spawnerlegacyapi.manager.IToolManager;
import mc.rellox.spawnerlegacyapi.manager.IValueManager;
import mc.rellox.spawnerlegacyapi.manager.IViewManager;

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
	
	/**
	 * @return SpawnerLegacy plugin instance
	 */
	
	public static JavaPlugin plugin() {
		return INSTANCE.plugin();
	}
	
	/**
	 * @return SpawnerLegacy instance class
	 */
	
	public static ISpawnerLegacy get() {
		return INSTANCE;
	}
	
	/**
	 * @return Generator manager
	 */
	
	public static IGeneratorManager generators() {
		return INSTANCE.generators();
	}
	
	/**
	 * @return Hologram manager
	 */
	
	public static IHologramManager holograms() {
		return INSTANCE.holograms();
	}
	
	/**
	 * @return Setting value manager
	 */
	
	public static IValueManager values() {
		return INSTANCE.values();
	}
	
	/**
	 * @return Cache type manager
	 */
	
	public static ICacheManager cache() {
		return INSTANCE.cache();
	}
	
	/**
	 * @return Modifier manager
	 */
	
	public static IModifierManager modifiers() {
		return INSTANCE.modifiers();
	}
	
	/**
	 * @return Spawner value and item manager
	 */
	
	public static ISpawnerManager spawners() {
		return INSTANCE.spawners();
	}
	
	/**
	 * @return Inventory view manager
	 */
	
	public static IViewManager views() {
		return INSTANCE.views();
	}
	
	/**
	 * @return Language/translation manager
	 */
	
	public static ILangaugeManager language() {
		return INSTANCE.language();
	}
	
	/**
	 * @return Layout manager
	 */
	
	public static ILayoutManager layouts() {
		return INSTANCE.layouts();
	}
	
	/**
	 * @return Data manager
	 */
	
	public static IDataManager data() {
		return INSTANCE.data();
	}
	
	/**
	 * @return Tool manager
	 */
	
	public static IToolManager tools() {
		return INSTANCE.tools();
	}
	
	/**
	 * @return Entity stacking manager
	 */
	
	public static IEntityManager entities() {
		return INSTANCE.entities();
	}
	
	/**
	 * @return Event manager
	 */
	
	public static IEventManager events() {
		return INSTANCE.events();
	}
	
	/**
	 * @return Price manager
	 */
	
	public static IPriceManager prices() {
		return INSTANCE.prices();
	}
	
	public interface ISpawnerLegacyPlugin extends Plugin {
		
		ISpawnerLegacy instance();
		
	}

}
