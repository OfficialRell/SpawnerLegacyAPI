package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.ISpawnerTypeChangeEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.cache.ICache;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

/**
 *  An event that is called when a player changes the type of a spawner.
 */

public class SpawnerChangeEvent extends SpawnerInteractEvent implements ISpawnerTypeChangeEvent {
	
	private final SpawnerType from;
	private SpawnerType to;
	/**
	 * Use {@link ICache#empty()} instead.
	 */
	@Deprecated(since = "1.4.9")
	public final boolean empty;
	
	public SpawnerChangeEvent(Player player, IGenerator generator, IPrice price,
			SpawnerType from, SpawnerType to) {
		super(player, generator, InteractAction.CHANGE, price);
		this.from = from;
		this.to = to;
		this.empty = generator.cache().empty();
	}
	
	/**
	 * Use {@link #to()} instead.
	 */
	@Deprecated(since = "1.4.9")
	public SpawnerType changed() {
		return to;
	}

	/**
	 * Use {@link #to(SpawnerType)} instead.
	 * 
	 * @param type - new type
	 */
	@Deprecated(since = "1.4.9")
	public void changed(SpawnerType type) {
		to(type);
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
