package mc.rellox.spawnerlegacyapi;

import mc.rellox.spawnerlegacyapi.manager.*;
import mc.rellox.spawnerlegacyapi.version.IVersion;
import org.bukkit.plugin.java.JavaPlugin;

public interface ISpawnerLegacy {
	
	/**
	 * @return SpawnerLegacy plugin
	 */

	JavaPlugin plugin();

	/**
	 * @return Server version instance
	 */

	IVersion version();
	
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
