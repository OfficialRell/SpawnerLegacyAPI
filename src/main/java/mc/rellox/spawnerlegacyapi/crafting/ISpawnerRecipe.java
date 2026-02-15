package mc.rellox.spawnerlegacyapi.crafting;

import java.util.List;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;

public interface ISpawnerRecipe {
	
	/**
	 * @return Recipe key
	 */
	
	String key();
	
	/**
	 * Get the recipe display item.
	 * 
	 * @return Item builder for display
	 */
	
	ItemBuilder item();
	
	/**
	 * Get the required permissions.<br>
	 * Player will be able to craft this recipe if they
	 * have at least one of the required permissions.
	 * 
	 * @return List of permissions
	 */
	
	List<String> permissions();
	
	/**
	 * @return List of prices
	 */
	
	List<IPrice> prices();
	
	/**
	 * @return Crafting duration in seconds
	 */
	
	int duration();
	
	/**
	 * @return Virtual spawner result
	 */
	
	IVirtual result();
	
	/**
	 * @return Crafted spawner amount
	 */
	
	int amount();
	
}
