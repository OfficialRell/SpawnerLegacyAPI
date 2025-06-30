package mc.rellox.spawnerlegacyapi.event;

import org.bukkit.entity.Player;

/**
 * An event that is called when a player interacts with a spawner.
 */

public abstract class SpawnerPlayerEvent extends SpawnerEvent {
	
	protected final Player player;

	public SpawnerPlayerEvent(Player player) {
		this.player = player;
	}
	
	/**
	 * @return Player who interacted
	 */
	
	public final Player player() {
		return player;
	}

}
