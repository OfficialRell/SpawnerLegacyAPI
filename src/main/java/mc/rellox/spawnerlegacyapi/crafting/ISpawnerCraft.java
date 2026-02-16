package mc.rellox.spawnerlegacyapi.crafting;

import java.util.UUID;

public interface ISpawnerCraft {
	
	/**
	 * Gets the player UUID crafting this spawner.
	 * 
	 * @return Player UUID
	 */
	
	UUID player();
	
	/**
	 * Gets the spawner recipe being crafted.
	 * 
	 * @return Spawner recipe
	 */
	
	ISpawnerRecipe recipe();
	
	/**
	 * Checks if the craft is complete.
	 * 
	 * @return {@code true} if complete
	 */
	
	boolean completed();
	
	/**
	 * Marks the craft as complete.
	 */
	
	void complete();
	
	/**
	 * @return Starting timestamp in milliseconds
	 */
	
	long start();
	
	/**
	 * Gets the remaining craft duration in seconds.
	 * 
	 * @return Seconds remaining
	 */
	
	int remaining();
	
	/**
	 * Gets the total craft duration in seconds.
	 * 
	 * @return Total craft duration in seconds
	 */
	
	int duration();
	
	/**
	 * Increases the craft duration.
	 * 
	 * @param seconds - seconds to add
	 */
	
	void increase(int seconds);
	
	/**
	 * Decreases the craft duration.
	 * 
	 * @param seconds - seconds to subtract
	 */
	
	void decrease(int seconds);
	
	/**
	 * Gets the ending timestamp of this craft.
	 * 
	 * @return Ending timestamp in milliseconds
	 */
	
	long ending();
	
}
