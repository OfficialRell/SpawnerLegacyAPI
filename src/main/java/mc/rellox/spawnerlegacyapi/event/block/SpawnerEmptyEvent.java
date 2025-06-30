package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerPlayerEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event that is called when a player empties a spawner (removed the spawn eggs).
 */

public class SpawnerEmptyEvent extends SpawnerPlayerEvent implements IGeneratorEvent {
	
	private final IGenerator generator;
	private ItemStack refund;

	public SpawnerEmptyEvent(Player player, IGenerator generator, ItemStack refund) {
		super(player);
		this.generator = generator;
		this.refund = refund;
	}

	@Override
	public IGenerator generator() {
		return generator;
	}
	
	/**
	 * @return Refund item or {@code null}
	 */
	
	public ItemStack refund() {
		return refund;
	}
	
	/**
	 * Sets the refund item.
	 * 
	 * @param item - refund item
	 */
	
	public void refund(ItemStack item) {
		this.refund = item.clone();
	}
	
}
