package mc.rellox.spawnerlegacyapi.event.block;

import mc.rellox.spawnerlegacyapi.event.IPriceEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerPlayerEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGeneratorSnapshot;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * An event that is called when a player places a new spawner.
 */

public class SpawnerPlaceEvent extends SpawnerPlayerEvent implements IPriceEvent {
	
	private final Block block;
	private final IGeneratorSnapshot snapshot;
	
	private IPrice price;

	public SpawnerPlaceEvent(Player player, Block block, IPrice price, IGeneratorSnapshot snapshot) {
		super(player);
		this.block = block;
		this.snapshot = snapshot;
		
		this.price = price;
	}
	
	/**
	 * @return The new spawner block
	 */
	
	public final Block block() {
		return block;
	}

	/**
	 * @return Generator snapshot that is being placed
	 */

	public IGeneratorSnapshot snapshot() {
		return snapshot;
	}
	
	/**
	 * Deprecated, use {@link #snapshot()} instead.
	 *
	 * @return New virtual spawner
	 */
	
	public final IVirtual virtual() {
		return snapshot;
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
