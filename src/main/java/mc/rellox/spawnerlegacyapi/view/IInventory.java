package mc.rellox.spawnerlegacyapi.view;

import java.util.List;
import java.util.Set;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.view.layout.ILayout;

public interface IInventory {
	
	/**
	 * @return If this inventory is still active
	 */
	
	boolean active();
	
	/**
	 * @return This inventory
	 */
	
	IInventory get();
	
	/**
	 * @return Inventory interface
	 */
	
	Inventory inventory();
	
	/**
	 * @return Inventory layout
	 */
	
	ILayout layout();
	
	/**
	 * Returns set of players who are viewing this inventory.
	 * 
	 * @return Set of viewers
	 */
	
	Set<Player> viewers();
	
	/**
	 * @param player - player who clicked
	 * @param click - click type
	 * @param s - slot
	 * @param bottom - if bottom inventory was clicked
	 */
	
	void click(Player player, ClickType click, int s, boolean bottom);
	
	/**
	 * Updates this inventory.
	 */
	
	void update();
	
	/**
	 * Registers and opens this inventory for the player.
	 * 
	 * @param player - player
	 */
	
	default void open(Player player) {
		register();
		player.openInventory(inventory());
		viewers().add(player);
		update();
		opening(player);
	}
	
	/**
	 * This method is called when a player has opened this inventory.
	 * 
	 * @param player - player
	 */
	
	default void opening(Player player) {}
	
	/**
	 * This does not close the inventory for this player.
	 * Does check or gives items to the player who is exiting
	 * this inventory.
	 * 
	 * @param player - player
	 */
	
	default void closing(Player player) {}
	
	/**
	 * Removes this player from this inventory.
	 * 
	 * @param player - player
	 */
	
	default void exit(Player player) {
		if(!viewers().contains(player)) return;
		player.closeInventory();
		closing(player);
		viewers().remove(player);
	}
	
	/**
	 * Unregisters and closes this inventory.
	 */
	
	default void exit() {
		close();
		unregister();
	}
	
	private void close() {
		List<HumanEntity> list = inventory().getViewers();
		if(!list.isEmpty()) {
			int i = list.size() - 1;
			do {
				HumanEntity human = list.get(i);
				closing((Player) human);
				human.closeInventory();
			} while(--i >= 0);
		}
		viewers().clear();
	}
	
	/**
	 * Should the {@code click()} method be called when a player
	 * clicks on the bottom inventory.
	 * 
	 * @return {@code true} or {@code false}
	 */
	
	default boolean bottom() {
		return false;
	}
	
	/**
	 * Registers events for this inventory.
	 */
	
	default IInventory register() {
		SLAPI.get().views().add(this);
		return this;
	}
	
	/**
	 * Unregisters events for this inventory.
	 */
	
	default IInventory unregister() {
		close();
		SLAPI.get().views().remove(this);
		return this;
	}

}
