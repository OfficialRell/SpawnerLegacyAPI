package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;
import java.util.UUID;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.configuration.INaturalData;
import mc.rellox.spawnerlegacyapi.configuration.player.ILimitData;
import mc.rellox.spawnerlegacyapi.configuration.player.IPlayerData;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.location.ILocationMutable;

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
	
	IPlayerData fromIDExisting(UUID id);
	
	/**
	 * Returns player data file of the specified player.
	 * {@code null} if a file for this player does not exist.
	 * 
	 * @param player - player
	 * @return Player data file
	 */
	
	default IPlayerData fromPlayerExisting(Player player) {
		return fromIDExisting(player.getUniqueId());
	}
	
	/**
	 * Tries to find a player data file from the specified player name.
	 * 
	 * @param player - player
	 * @return Player data file
	 */
	
	IPlayerData find(String player);
	
	/**
	 * Tries to find a player data file from the specified generator
	 * where the spawner owner is the player.
	 * 
	 * @param block - spawner block
	 * @return Player data file
	 */
	
	IPlayerData fromGenerator(IGenerator generator);
	
	/**
	 * Tries to find a player data file from the specified spawner block
	 * where the spawner owner is the player.
	 * 
	 * @param block - spawner block
	 * @return Player data file
	 */
	
	IPlayerData fromBlock(Block block);
	
	/**
	 * @return Player limit data file
	 */
	
	ILimitData limits();
	
	/**
	 * @param player - player
	 * @return If a file for the specified player exists
	 */
	
	boolean exists(Player player);
	
	/**
	 * @param id - player's ID
	 * @return If a file for the specified player exists
	 */
	
	boolean exists(UUID id);
	
	/**
	 * Returns the natural data file of the specified world. <br>
	 * Never {@code null}.
	 * 
	 * @param world - world
	 * @return Natural data file
	 */
	
	INaturalData fromWorld(World world);
	
	/**
	 * Returns an interface containing multiple natural data files. <br>
	 * Useful to change natural spawner values for mulitple worlds. <br>
	 * Never {@code null}.
	 * 
	 * @param worlds - worlds
	 * @return Multiple natural data file interface
	 */
	
	ILocationMutable fromWorlds(List<World> worlds);

}
