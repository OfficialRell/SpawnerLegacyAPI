package mc.rellox.spawnerlegacyapi.event.spawn;

import java.util.List;

import org.bukkit.entity.Entity;

import mc.rellox.spawnerlegacyapi.event.IEvent;
import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event called when a spawner has spawned entities.
 */

public class SpawnerPostSpawnEvent implements IEvent, IGeneratorEvent {
	
	private final IGenerator generator;
	private final List<Entity> entities;
	
	public SpawnerPostSpawnEvent(IGenerator generator, List<Entity> entities) {
		this.generator = generator;
		this.entities = entities;
	}
	
	@Override
	public IGenerator generator() {
		return generator;	
	}
	
	/**
	 * @return Mutable entity list
	 */
	
	public List<Entity> entities() {
		return entities;
	}

}
