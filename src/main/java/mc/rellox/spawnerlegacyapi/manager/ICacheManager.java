package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;
import java.util.function.Consumer;

import org.bukkit.block.CreatureSpawner;

import mc.rellox.spawnerlegacyapi.spawner.cache.ICacheType;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ICacheManager {
	
	/**
	 * Returns the cache type by its index.<br>
	 * Should not be used, instead use the constants in {@link ICacheType}.
	 * 
	 * @param <T> - type of cache
	 * @param index - index
	 * @return Cache type by index
	 */
	
	<T> ICacheType<T> of(int index);
	
	/**
	 * @return List of all cache types
	 */
	
	List<ICacheType<?>> all();
	
	/**
	 * Loops through all cache types and performs the given action.
	 * 
	 * @param action - action
	 */
	
	void loop(Consumer<ICacheType<?>> action);
	
	/**
	 * @return Number of cache types
	 */
	
	int size();
	
	/**
	 * Tried to get the spawner type of the given spawner.<br>
	 * This will check both the vanilla spawner type and the custom spawner type set by the plugin.
	 * 
	 * @param spawner - spawner
	 * @return Spawner type of the spawner
	 */
	
	SpawnerType type(CreatureSpawner spawner);
	
}
