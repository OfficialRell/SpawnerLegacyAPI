package mc.rellox.spawnerlegacyapi.spawner.location;

import mc.rellox.spawnerlegacyapi.spawner.requirement.ErrorCounter;
import mc.rellox.spawnerlegacyapi.spawner.requirement.IRequirements;
import org.bukkit.Location;

import java.util.List;

public interface IFinder {
	
	/**
	 * Updates spawner entity changes.
	 */
	
	void update();
	
	/**
	 * @return Spawner requirements to spawn
	 */
	
	IRequirements requirements();
	
	/**
	 * @return Horizontal find radius
	 */
	
	int horizontal();
	
	/**
	 * @return Vertical find radius
	 */
	
	int vertical();
	
	/**
	 * Returns a list of valid spawn locations.
	 * This will return an empty list if no valid locations can be found.
	 * 
	 * @param count count
	 * @return Returns all valid spawn locations
	 */
	
	List<Location> find(int count);
	
	/**
	 * This method can be called only once after method {@link #find(int)}.
	 * 
	 * @return Finder error counter 
	 * @throws IllegalStateException if method {@link #find(int)} has not been run
	 *  or this method is run twice
	 */
	
	ErrorCounter errors() throws IllegalStateException;

}
