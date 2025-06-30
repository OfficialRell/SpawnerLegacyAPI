package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerPlayerEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event that is called when a player opens the spawner upgrade inventory.
 */

public class SpawnerOpenEvent extends SpawnerPlayerEvent implements IGeneratorEvent {
	
	private final IGenerator generator;

	public SpawnerOpenEvent(Player player, IGenerator generator) {
		super(player);
		this.generator = generator;
	}
	
	@Override
	public IGenerator generator() {
		return generator;
	}


}
