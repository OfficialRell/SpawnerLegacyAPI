package mc.rellox.spawnerlegacyapi.event.spawn;

import mc.rellox.spawnerlegacyapi.event.IEvent;
import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.summoner.ISummonResult;
import org.bukkit.entity.Entity;

import java.util.List;

/**
 * An event called when a spawner has spawned entities.
 */

public record SpawnerPostSpawnEvent(
		IGenerator generator,
		ISummonResult result
) implements IEvent, IGeneratorEvent {

	/**
	 * @return Mutable entity list
	 */

	public List<Entity> entities() {
		return result.entities();
	}

}
