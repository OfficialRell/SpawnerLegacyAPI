package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.event.SpawnerGeneratorEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event that is called when a player empties a spawner (removed the spawn eggs).
 */

public class SpawnerEmptyEvent extends SpawnerGeneratorEvent {
	
	private ItemStack refund;

	public SpawnerEmptyEvent(Player player, IGenerator generator, ItemStack refund) {
		super(player, generator);
		this.refund = refund;
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
