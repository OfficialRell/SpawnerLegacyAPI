package mc.rellox.spawnerlegacyapi.event.upgrade;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerPlayerEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event called when a player modifies (upgrades, switches or charges) a spawner.
 */

public class SpawnerModifyEvent extends SpawnerPlayerEvent implements IGeneratorEvent {
	
	public final ModifyType type;
	private final IGenerator generator;
	
	public SpawnerModifyEvent(Player player, ModifyType type, IGenerator generator) {
		super(player);
		this.type = type;
		this.generator = generator;
	}
	
	@Override
	public final IGenerator generator() {
		return generator;
	}
	
	public static enum ModifyType {
		
		SWITCH, UPGRADE, CHARGE;

	}

}
