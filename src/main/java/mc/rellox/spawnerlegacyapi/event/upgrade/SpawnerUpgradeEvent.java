package mc.rellox.spawnerlegacyapi.event.upgrade;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.IPriceEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.type.UpgradeType;

/**
 * An event called when a player upgrades a spawner.
 */

public class SpawnerUpgradeEvent extends SpawnerModifyEvent implements IPriceEvent {
	
	/**
	 * Upgrade type.
	 */
	public final UpgradeType upgrade;
	/**
	 * The next upgrade level.
	 */
	public int upgrade_level;
	/**
	 * The maximum upgrade level.
	 */
	public final int upgrade_maximum;
	
	private IPrice price;

	public SpawnerUpgradeEvent(Player player, IGenerator generator, UpgradeType upgrade,
			int upgrade_level, int upgrade_maximum, IPrice price) {
		super(player, ModifyType.UPGRADE, generator);
		this.upgrade = upgrade;
		this.upgrade_level = upgrade_level;
		this.upgrade_maximum = upgrade_maximum;
		this.price = price;
	}

	@Override
	public IPrice price() {
		return price;
	}

	@Override
	public void price(IPrice price) {
		this.price = price;
	}

}
