package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event that is called when a player breaks a spawner.
 */

public class SpawnerBreakEvent extends SpawnerInteractEvent {
	
	public double chance;

	public SpawnerBreakEvent(Player player, IGenerator generator, IPrice price, double chance) {
		super(player, generator, InteractAction.BREAK, price);
		this.chance = chance;
	}

}
