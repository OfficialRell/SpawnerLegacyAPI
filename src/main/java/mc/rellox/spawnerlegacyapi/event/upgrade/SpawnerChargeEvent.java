package mc.rellox.spawnerlegacyapi.event.upgrade;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.IPriceEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event called when a player purchases charges for a spawner.
 */

public class SpawnerChargeEvent extends SpawnerModifyEvent implements IPriceEvent {
	
	public int charges;
	
	private IPrice price;

	public SpawnerChargeEvent(Player player, IGenerator generator, IPrice price, int charges) {
		super(player, ModifyType.CHARGE, generator);
		this.price = price;
		this.charges = charges;
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
