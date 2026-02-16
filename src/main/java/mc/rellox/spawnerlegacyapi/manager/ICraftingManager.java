package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.crafting.ISpawnerCraft;
import mc.rellox.spawnerlegacyapi.crafting.ISpawnerRecipe;

public interface ICraftingManager {
	
	/**
	 * Gets all registered recipes.
	 * 
	 * @return List of recipes
	 */
	
	List<ISpawnerRecipe> recipes();
	
	/**
	 * Gets the active craft for a player by UUID.
	 * 
	 * @param id - player id
	 * @return Craft, or {@code null} if none exists
	 */
	
	ISpawnerCraft craft(UUID id);
	
	/**
	 * Gets the active craft for a player.
	 * 
	 * @param player - player
	 * @return Craft, or {@code null} if none exists
	 */
	
	ISpawnerCraft craft(Player player);
	
	/**
	 * Checks if the player is currently crafting.
	 * 
	 * @param id - player id
	 * @return {@code true} if crafting
	 */
	
	boolean crafting(UUID id);
	
	/**
	 * Checks if the player is currently crafting.
	 * 
	 * @param player - player
	 * @return {@code true} if crafting
	 */
	
	boolean crafting(Player player);
	
	/**
	 * Starts the new craft.
	 * 
	 * @param craft - craft to start
	 */
	
	void start(ISpawnerCraft craft);
	
	/**
	 * Cancels and removes the craft, if any.
	 * 
	 * @param id - player id
	 */
	
	void remove(UUID id);
	
	/**
	 * Cancels and removes the craft, if any.
	 * 
	 * @param player - player
	 */
	
	void remove(Player player);
	
	/**
	 * Gets the crafting result.
	 * 
	 * @param id - player id
	 * @return Crafting result, or {@code null} if none exists
	 */
	
	ISpawnerRecipe result(UUID id);
	
	/**
	 * Gets the crafting result.
	 * 
	 * @param player - player
	 * @return Crafting result, or {@code null} if none exists
	 */
	
	ISpawnerRecipe result(Player player);
	
	/**
	 * Takes the crafting result, removing it.
	 * 
	 * @param id - player id
	 * @return Crafting result, or {@code null} if none exists
	 */
	
	ISpawnerRecipe take(UUID id);
	
	/**
	 * Takes the crafting result, removing it.
	 * 
	 * @param player - player
	 * @return Crafting result, or {@code null} if none exists
	 */
	
	ISpawnerRecipe take(Player player);
	
}
