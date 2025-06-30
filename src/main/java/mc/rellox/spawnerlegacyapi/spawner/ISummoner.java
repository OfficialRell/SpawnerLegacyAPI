package mc.rellox.spawnerlegacyapi.spawner;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ISummoner {
	
	/**
	 * @return Spawner type
	 */
	
	SpawnerType type();
	
	/**
	 * Summons entities in the world and returns a list of them.
	 * 
	 * @param locations - list of location
	 * @param count - entity count
	 * @return List of newly spawned entities
	 */
	
	List<Entity> summon(List<Location> locations, int count);

}
