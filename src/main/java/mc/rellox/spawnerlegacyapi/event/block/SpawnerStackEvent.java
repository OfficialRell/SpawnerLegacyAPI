package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;

/**
 * An event that is called a player stacks a spawner.
 */

public class SpawnerStackEvent extends SpawnerInteractEvent {
	
	private final IVirtual virtual;
	public final boolean direct;

	public SpawnerStackEvent(Player player, IGenerator generator, IPrice price,
			IVirtual virtual, boolean direct) {
		super(player, generator, InteractAction.STACK, price);
		this.virtual = virtual;
		this.direct = direct;
	}
	
	/**
	 * @return Virtual spawner that is stacked
	 */
	
	public final IVirtual virtual() {
		return virtual;
	}

}
