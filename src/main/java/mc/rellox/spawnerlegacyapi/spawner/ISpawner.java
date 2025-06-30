package mc.rellox.spawnerlegacyapi.spawner;

import java.util.List;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.inventory.ItemStack;

public interface ISpawner {
	
	/**
	 * @return Generator
	 */
	
	IGenerator generator();
	
	/**
	 * @return CreatureSpawner or {@code null} if not a spawner
	 */
	
	default CreatureSpawner asCreatureSpawner() {
		return generator().block().getState() instanceof CreatureSpawner cs ? cs : null;
	}
	
	/**
	 * Sets the spawner rotating or not.
	 * 
	 * @param rotate - is rotating
	 */
	
	void rotating(boolean rotate);
	
	/**
	 * @return {@code true} if rotating
	 */
	
	boolean rotating();
	
	/**
	 * Sets the new spawner delay.
	 * If full is {@code true} then will update spawner
	 * minimum and maximum delay values.
	 * 
	 * @param delay - spawn delay
	 * @param full - should update delay constants
	 */
	
	void redelay(int delay, boolean full);
	
	/**
	 * Sets the spawner delay that is cached.
	 * If full is {@code true} then will update spawner
	 * minimum and maximum delay values.
	 * 
	 * @param full - should update delay constants
	 */
	
	default void redelay(boolean full) {
		redelay(generator().cache().delay(), full);
	}
	
	/**
	 * Sets the spawner entity spawn count to 1,
	 * as SpawnerMeta uses a custom spawning system.
	 */
	
	void singulate();
	
	/**
	 * @return Total spawner upgrade level
	 */
	
	int level();
	
	/**
	 * @return List of spawner items
	 */
	
	List<ItemStack> toItems();

}
