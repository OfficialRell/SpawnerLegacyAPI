package mc.rellox.spawnerlegacyapi;

import org.bukkit.plugin.java.JavaPlugin;

import mc.rellox.spawnerlegacyapi.manager.ICacheManager;
import mc.rellox.spawnerlegacyapi.manager.ICraftingManager;
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
	 * @return Modifier manager
	 */
	
	IModifierManager modifiers();
	
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
	 * @return Data manager
	 */
	
	IDataManager data();
	
	/**
	 * @return Tool manager
	 */
	
	IToolManager tools();
	
	/**
	 * @return Entity stacking manager
	 */
	
	IEntityManager entities();
	
	/**
	 * @return Event manager
	 */
	
	IEventManager events();
	
	/**
	 * @return Price manager
	 */
	
	IPriceManager prices();
	
	/**
	 * @return Crafting manager
	 */
	
	ICraftingManager crafting();

}
