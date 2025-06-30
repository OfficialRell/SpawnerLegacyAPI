package mc.rellox.spawnerlegacyapi.event.upgrade;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event called when a player switches a spawner on or off.
 */

public class SpawnerSwitchEvent extends SpawnerModifyEvent {
	
	/**
	 * {@code true} if this spawner was switched on, otherwise {@code false}.
	 */
	public final boolean switched;

	public SpawnerSwitchEvent(Player player, IGenerator generator, boolean switched) {
		super(player, ModifyType.SWITCH, generator);
		this.switched = switched;
	}

}
