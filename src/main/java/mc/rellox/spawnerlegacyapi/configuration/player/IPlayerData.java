package mc.rellox.spawnerlegacyapi.configuration.player;

import java.util.Set;
import java.util.UUID;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.configuration.ICommit;
import mc.rellox.spawnerlegacyapi.spawner.location.ILocationMutable;

public interface IPlayerData extends ILocationMutable, ICommit {
	
	/**
	 * Loads all values from the file if not loaded already.
	 */
	
	void load();

	
	/**
	 * @return {@code true} if the player is online, otherwise {@code false}
	 */
	
	boolean online();
	
	/**
	 * If this file has not been used in the last 5 minutes then
	 *  {@code false} is returned, otherwise {@code true}.
	 * 
	 * @return {@code true} if this file is in use
	 */
	
	boolean using();
	
	/**
	 * Refreshes the use time to disable this file from unloading.
	 */
	
	void use();
	
	/**
	 * @return Id of the player
	 */
	
	UUID id();
	
	/**
	 * @return Player object or {@code null} if offline
	 */
	
	Player player();
	
	/**
	 * Returns an unmodifiable set of all trusted player IDs.
	 * <p> Trusted players can manipulate with spawners the same as their owner.
	 * 
	 * @return Set of player IDs
	 */
	
	Set<UUID> trusted();
	
	/**
	 * Tried to find the UUID from the player name.
	 * 
	 * @param name - trusted player name
	 * @return UUID of the player or {@code null} if no player found
	 */
	
	UUID trusted(String name);
	
	/**
	 * @param id - player id
	 * @return {@code true} if this player is trusted
	 */
	
	boolean trusts(UUID id);
	
	/**
	 * @param player - player
	 * @return {@code true} if this player is trusted
	 */
	
	boolean trusts(Player player);
	
	/**
	 * Adds this player to the trust list.
	 * 
	 * @param id - player id
	 * @return {@code true} if this player was not trusted before, otherwise {@code false}
	 */
	
	boolean trust(UUID id);
	
	/**
	 * Adds this player to the trust list.
	 * 
	 * @param player - player
	 * @return {@code true} if this player was not trusted before, otherwise {@code false}
	 */
	
	boolean trust(Player player);
	
	/**
	 * Removes this player from the trust list.
	 * 
	 * @param id - player id
	 * @return {@code true} if this player was trusted before, otherwise {@code false}
	 */
	
	boolean untrust(UUID id);
	
	/**
	 * Removes this player from the trust list.
	 * 
	 * @param player - player
	 * @return {@code true} if this player was trusted before, otherwise {@code false}
	 */
	
	boolean untrust(Player player);
	
	/**
	 * Clears all trusted players.
	 * 
	 * @return Amount of removed trusted players
	 */
	
	int untrust();
	
	/**
	 * Removes the specified spawner location.
	 * 
	 * @param block - spawner block
	 * @return {@code true} if this location did not exists
	 */
	
	boolean remove(Block block);
	
	/**
	 * Adds the specified spawner location.
	 * 
	 * @param block - spawner block
	 * @return {@code true} if this location was added, otherwise {@code false}
	 */
	
	boolean add(Block block);
	
	/**
	 * @param limit - limit type
	 * @return The specified limit value
	 */
	
	int limit(LimitType limit);
	
	/**
	 * Adds or subtracts the value from the limit.
	 * 
	 * @param limit - limit type
	 * @param value - value
	 */
	
	void limit(LimitType limit, int value);
	
	/**
	 * Resets the limit value.
	 * 
	 * @param limit - limit type
	 * @return Previous limit value
	 */
	
	int reset(LimitType limit);
	
}
