package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.SpawnerGeneratorEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event that is called when a player opens the spawner upgrade inventory.
 */

public class SpawnerOpenEvent extends SpawnerGeneratorEvent {

	public SpawnerOpenEvent(Player player, IGenerator generator) {
		super(player, generator);
	}

}
