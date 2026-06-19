package mc.rellox.spawnerlegacyapi.event.upgrade;

import mc.rellox.spawnerlegacyapi.event.SpawnerGeneratorEvent;
import mc.rellox.spawnerlegacyapi.view.IUpgrades;
import org.bukkit.entity.Player;

public class SpawnerTypesGUIOpenEvent extends SpawnerGeneratorEvent {
	
	private final IUpgrades upgrades;

	public SpawnerTypesGUIOpenEvent(Player player, IUpgrades upgrades) {
		super(player, upgrades.generator());
		this.upgrades = upgrades;
	}
	
	/**
	 * @return The opened upgrades GUI.
	 */
	
	public IUpgrades upgrades() {
		return upgrades;
	}

}
