package mc.rellox.spawnerlegacyapi.configuration;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public interface INaturalData extends ICommit {
	
	/**
	 * @return World that is linked to this file
	 */
	
	World world();
	
	/**
	 * Returns an unmodifiable set of spawner locations.
	 * 
	 * @return Set of locations
	 */
	
	Set<Location> get();
	
	/**
	 * @return Amount of spawner locations
	 */
	
	int amount();
	
	/**
	 * Clears all spawner locations.
	 * 
	 * @return Amount of cleared spawner locations
	 */
	
	int clear();
	
	/**
	 * Clears the specifier amount of spawner locations.
	 * 
	 * @param limit - limit
	 * @return Amount of successfully cleared spawner locations
	 */
	
	int clear(int limit);
	
	/**
	 * Checks and removes any invalid spawner locations.
	 * 
	 * @return Amount of invalid spawner locations removed
	 */
	
	int validate();
	
	/**
	 * Adds the spawner to the natural spawner list.
	 * 
	 * @param block - spawner block
	 */
	
	void add(Block block);
	
	/**
	 * Removed the spawner from the natural spawner list.
	 * 
	 * @param block - spawner block
	 */
	
	void remove(Block block);
	
	/**
	 * Loads all values from the file if not loaded already.
	 */
	
	void load();

}
