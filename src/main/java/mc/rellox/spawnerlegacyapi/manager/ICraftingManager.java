package mc.rellox.spawnerlegacyapi.manager;

import java.util.UUID;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.crafting.ISpawnerCraft;

public interface ICraftingManager {
	
	/**
	 * Gets the active craft for a player by UUID.
	 * 
	 * @param id - player id
	 * @return Active craft, or {@code null} if none exists
	 */
	
	ISpawnerCraft craft(UUID id);
	
	/**
	 * Gets the active craft for a player.
	 * 
	 * @param player - player
	 * @return Active craft, or {@code null} if none exists
	 */
	
	ISpawnerCraft craft(Player player);
	
	/**
	 * Checks if the player is currently crafting.
	 * 
	 * @param id - player id
	 * @return {@code true} if crafting, {@code false} otherwise
	 */
	
	boolean crafting(UUID id);
	
	/**
	 * Checks if the player is currently crafting.
	 * 
	 * @param player - player
	 * @return {@code true} if crafting, {@code false} otherwise
	 */
	
	boolean crafting(Player player);
	
	/**
	 * Starts the new craft.
	 * 
	 * @param craft - craft to start
	 */
	
	void start(ISpawnerCraft craft);
	
	/**
	 * Removes the craft.
	 * 
	 * @param id - player id
	 */
	
	void remove(UUID id);
	
}
