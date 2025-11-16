package mc.rellox.spawnerlegacyapi.event.upgrade;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.SpawnerGeneratorEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event called when a player modifies (upgrades, switches or charges) a spawner.
 */

public class SpawnerModifyEvent extends SpawnerGeneratorEvent {
	
	public final ModifyType type;
	
	public SpawnerModifyEvent(Player player, ModifyType type, IGenerator generator) {
		super(player, generator);
		this.type = type;
	}
	
	public static enum ModifyType {
		
		SWITCH, UPGRADE, CHARGE;

	}

}
