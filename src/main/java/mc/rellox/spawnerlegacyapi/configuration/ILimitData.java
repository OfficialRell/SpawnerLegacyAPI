package mc.rellox.spawnerlegacyapi.configuration;

import org.bukkit.entity.Player;

public interface ILimitData extends ICommit {
	
	/**
	 * Loads limit data.
	 */
	
	void load();
	
	/**
	 * Gets the time in minutes until the next limit reset.<br>
	 * If the limit has never been reset then {@code 0} is returned,
	 * but if the reset time has been overreached then {@code -1} is returned.
	 * 
	 * @param limit - limit type
	 * 
	 * @return The time until the next reset
	 */
	
	long until(LimitType limit);
	
	/**
	 * Resets the specified limit values for all players.<br>
	 * And updates the last reset date for this limit.
	 * 
	 * @param limit - limit type
	 */
	
	void reset(LimitType limit);
	
	/**
	 * Adds this player to the reset waiting list.
	 * 
	 * @param player - player
	 * @param limit - limit type
	 */
	
	void waiting(Player player, LimitType limit);

}
