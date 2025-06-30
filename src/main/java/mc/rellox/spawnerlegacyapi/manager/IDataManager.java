package mc.rellox.spawnerlegacyapi.manager;

import java.util.UUID;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.configuration.IPlayerData;

public interface IDataManager {
	
	/**
	 * Returns player data file of the specified player. Never {@code null}.
	 * 
	 * @param id - player's ID
	 * @return Player data file
	 *
	 * @throws IllegalArgumentException thrown if the player with
	 *  the specified ID has never player before
	 */
	
	IPlayerData fromID(UUID id) throws IllegalArgumentException;
	
	/**
	 * Returns player data file of the specified player. Never {@code null}.
	 * 
	 * @param player - player
	 * @return Player data file
	 */
	
	default IPlayerData fromPlayer(Player player) {
		return fromID(player.getUniqueId());
	}
	
	/**
	 * Returns player data file of the specified player.
	 * {@code null} if a file for this player does not exist.
	 * 
	 * @param id - player's ID
	 * @return Player data file
	 */
	
	IPlayerData fromIDRaw(UUID id);

}
