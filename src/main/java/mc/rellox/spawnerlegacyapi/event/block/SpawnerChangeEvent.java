package mc.rellox.spawnerlegacyapi.event.block;

import mc.rellox.spawnerlegacyapi.event.ISpawnerTypeChangeEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import org.bukkit.entity.Player;

/**
 *  An event that is called when a player changes the type of spawner.
 */

public class SpawnerChangeEvent extends SpawnerInteractEvent implements ISpawnerTypeChangeEvent {
	
	private final SpawnerType from;
	private SpawnerType to;
	
	public SpawnerChangeEvent(Player player, IGenerator generator, IPrice price,
			SpawnerType from, SpawnerType to) {
		super(player, generator, InteractAction.CHANGE, price);
		this.from = from;
		this.to = to;
	}
	
	@Override
	public ChangeCauseType cause() {
		return ChangeCauseType.SPAWN_EGG;
	}

	@Override
	public SpawnerType from() {
		return from;
	}

	@Override
	public SpawnerType to() {
		return to;
	}

	@Override
	public void to(SpawnerType to) {
		this.to = to == null ? SpawnerType.PIG : to;
	}


}
