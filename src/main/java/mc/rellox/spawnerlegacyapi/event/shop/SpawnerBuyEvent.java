package mc.rellox.spawnerlegacyapi.event.shop;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.IPriceEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerPlayerEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

/**
 * An event called when a player purchases spawners.
 */

public class SpawnerBuyEvent extends SpawnerPlayerEvent implements IPriceEvent {
	
	/**
	 * Purchased spawner type.
	 */
	public final SpawnerType type;
	/**
	 * Spawner amount.
	 */
	public int amount;
	
	private IPrice price;

	public SpawnerBuyEvent(Player player, IPrice price, SpawnerType type, int amount) {
		super(player);
		this.price = price;
		this.type = type;
		this.amount = amount;
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
