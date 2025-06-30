package mc.rellox.spawnerlegacyapi.spawner.location;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.World;

public interface ILocationMutable {
	
	/**
	 * Returns an unmodifiable set of spawner locations in the specified world.
	 * 
	 * @param world - world
	 * @return Set of locations
	 */
	
	Set<Location> get(World world);
	
	/**
	 * Returns an unmodifiable set of all spawner locations.
	 * 
	 * @return Set of locations
	 */
	
	Set<Location> all();
	
	/**
	 * @return Amount of spawner locations in the specified world
	 */
	
	int amount(World world);
	
	/**
	 * @return Amount of all spawner locations
	 */
	
	int amount();
	
	/**
	 * Clears spawner locations in the specified world.
	 * 
	 * @param world - world
	 * @return Amount of cleared spawner locations
	 */
	
	int clear(World world);
	
	/**
	 * Clears the specified amount of spawner locations in the specified world.
	 * 
	 * @param world - world
	 * @param limit - limit
	 * @return Amount of successfully cleared spawner locations
	 */
	
	int clear(World world, int limit);
	
	/**
	 * Clears all spawner locations.
	 * 
	 * @return Amount of cleared spawner locations
	 */
	
	int clear();
	
	/**
	 * Clears the specified amount of spawner locations.
	 * 
	 * @param limit - limit
	 * @return Amount of successfully cleared spawner locations
	 */
	
	int clear(int limit);
	
	/**
	 * Checks and removes any invalid spawner locations in the specified world.
	 * 
	 * @param world - world
	 * @return Amount of invalid spawner locations removed
	 */
	
	int validate(World world);
	
	/**
	 * Checks and removes any invalid spawner locations.
	 * 
	 * @return Amount of invalid spawner locations removed
	 */
	
	int validate();

}
