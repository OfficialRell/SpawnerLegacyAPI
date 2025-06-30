package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.IPriceEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerPlayerEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;

/**
 * An event that is called when a player places a new spawner.
 */

public class SpawnerPlaceEvent extends SpawnerPlayerEvent implements IPriceEvent {
	
	private final Block block;
	private final IVirtual virtual;
	
	private IPrice price;

	public SpawnerPlaceEvent(Player player, Block block, IPrice price, IVirtual virtual) {
		super(player);
		this.block = block;
		this.virtual = virtual;
		
		this.price = price;
	}
	
	/**
	 * @return The new spawner block
	 */
	
	public final Block block() {
		return block;
	}
	
	/**
	 * @return New virtual spawner
	 */
	
	public final IVirtual virtual() {
		return virtual;
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
