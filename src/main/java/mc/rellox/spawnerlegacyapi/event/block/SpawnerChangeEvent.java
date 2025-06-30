package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

/**
 *  An event that is called when a player changes the type of a spawner.
 */

public class SpawnerChangeEvent extends SpawnerInteractEvent {
	
	private SpawnerType type;
	public final boolean empty;

	public SpawnerChangeEvent(Player player, IGenerator generator, IPrice price,
			SpawnerType type, boolean empty) {
		super(player, generator, InteractAction.CHANGE, price);
		this.type = type;
		this.empty = empty;
	}
	
	/**
	 * @return New spawner type
	 */
	
	public SpawnerType changed() {
		return type;
	}
	
	/**
	 * Sets the new spawner type.
	 * {@code null} value will be changed to {@code SpawnerType.PIG} type.
	 * 
	 * @param type - type
	 */
	
	public void changed(SpawnerType type) {
		this.type = type == null ? SpawnerType.PIG : type;
	}


}
