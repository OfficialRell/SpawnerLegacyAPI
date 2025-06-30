package mc.rellox.spawnerlegacyapi;

import org.bukkit.plugin.java.JavaPlugin;

import mc.rellox.spawnerlegacyapi.manager.ICacheManager;
import mc.rellox.spawnerlegacyapi.manager.IGeneratorManager;
import mc.rellox.spawnerlegacyapi.manager.IHologramManager;
import mc.rellox.spawnerlegacyapi.manager.ILangaugeManager;
import mc.rellox.spawnerlegacyapi.manager.ILayoutManager;
import mc.rellox.spawnerlegacyapi.manager.ISettingsManager;
import mc.rellox.spawnerlegacyapi.manager.ISpawnerManager;
import mc.rellox.spawnerlegacyapi.manager.IValueManager;
import mc.rellox.spawnerlegacyapi.manager.IViewManager;

public interface ISpawnerLegacy {
	
	/**
	 * @return SpawnerLegacy plugin
	 */
	
	JavaPlugin plugin();
	
	/**
	 * @return Generator manager
	 */
	
	IGeneratorManager generators();
	
	/**
	 * @return Hologram manager
	 */
	
	IHologramManager holograms();
	
	/**
	 * @return Setting value manager
	 */
	
	IValueManager values();
	
	/**
	 * @return Cache type manager
	 */
	
	ICacheManager cache();
	
	/**
	 * @return Spawner value and item manager
	 */
	
	ISpawnerManager spawners();
	
	/**
	 * @return Inventory view manager
	 */
	
	IViewManager views();
	
	/**
	 * @return Language/translation manager
	 */
	
	ILangaugeManager language();
	
	/**
	 * @return Layout manager
	 */
	
	ILayoutManager layouts();
	
	/**
	 * @return Settings manager
	 */
	
	ISettingsManager settings();

}
