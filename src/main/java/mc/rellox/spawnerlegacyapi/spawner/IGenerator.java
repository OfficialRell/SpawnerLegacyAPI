package mc.rellox.spawnerlegacyapi.spawner;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.hologram.IHologramHolder;
import mc.rellox.spawnerlegacyapi.spawner.cache.ICache;
import mc.rellox.spawnerlegacyapi.spawner.location.Pos;
import mc.rellox.spawnerlegacyapi.spawner.meta.IDisplay;
import mc.rellox.spawnerlegacyapi.spawner.warning.IValidation;
import mc.rellox.spawnerlegacyapi.view.IUpgrades;

/**
 * Represents an entity generator.
 */

public interface IGenerator extends IGeneratorTags {
	
	/**
	 * @return This spawner
	 */
	
	ISpawner spawner();
	
	/**
	 * @return Spawner block
	 */
	
	Block block();
	
	/**
	 * @return Generator world
	 */
	
	World world();
	
	/**
	 * @return Center location, as {@code loc.add(0.5, 0.5, 0.5)}
	 */
	
	Location center();
	
	/**
	 * @return Spawner cache
	 */
	
	ICache cache();
	
	/**
	 * @return Entity summoner
	 */
	
	ISummoner summoner();
	
	/**
	 * @return Display name of this spawner
	 */
	
	IDisplay display();
	
	/**
	 * @return Spawner validation and warning manager
	 */
	
	IValidation validation();
	
	/**
	 * @return All hologram holder
	 */
	
	IHologramHolder holograms();
	
	/**
	 * @return {@code true} if this generator is active (not removed), otherwise {@code false}
	 */
	
	boolean active();
	
	/**
	 * @return {@code true} if this spawner currently is ticking, otherwise {@code false}
	 */
	
	boolean ticking();
	
	/**
	 * @return {@code true} if spawner tags has been changed
	 */
	
	boolean changed();
	
	/**
	 * @return {@code true} if this generator ia a spawner block, otherwise {@code false}
	 */
	
	boolean present();
	
	/**
	 * @return {@code true} if this spawner is rotating
	 */
	
	boolean rotating();
	
	/**
	 * Always returns {@code true} if the owner is online or option 'spawn-if-online'
	 * is set to true, otherwise checks if the owner is offline or has been offline
	 * for more then the 'offline-timout' time.
	 * 
	 * @return {@code true} or {@code false}
	 */
	
	boolean online();
	
	/**
	 * Removes this generator.<br>
	 * If fully is {@code true} then this generator will be
	 *  fully removed including the block and location.
	 * 
	 * @param fully - should this generator be removed fully
	 */
	
	void remove(boolean fully);
	
	/**
	 * Removes this generator.<br>
	 * If fully is {@code true} then this generator will be
	 *  fully removed including the block.<br>
	 * If files is {@code true} then it will remove this generator from files,
	 *  only if fully is {@code true}.
	 *  
	 * @param fully - should this generator be removed fully
	 * @param files - should this generator be removed from locatation files
	 */
	
	void remove(boolean fully, boolean files);
	
	/**
	 * Ticks this spawner.
	 */
	
	void tick();
	
	/**
	 * @return The remaining ticks until spawning entities
	 */
	
	int ticks();
	
	/**
	 * @return The time the spawner can spawn again
	 */
	
	int delay();
	
	/**
	 * Updates spawner delay, upgrades and other.
	 */
	
	void update();
	
	/**
	 * Updates hologram and warning text, if exists.
	 */
	
	void rewrite();
	
	/**
	 * Does all spawner updates and checks.
	 */
	
	void refresh();
	
	/**
	 * Updates spawner options that might control it.
	 */
	
	void control();
	
	/**
	 * Updates spawner summoner.
	 */
	
	void resummon();
	
	/**
	 * Tries to spawn entities from this spawner.
	 */
	
	boolean spawn();
	
	/**
	 * @return Spawner upgrade GUI or {@code null} if not opened
	 */
	
	IUpgrades upgrades();
	
	/**
	 * Opens upgrade GUI for the specific player.
	 * 
	 * @param player - player
	 * @return Spawner upgrade GUI
	 */
	
	void open(Player player);
	
	/**
	 * Closes and unregisters upgrade GUI.
	 */
	
	void close();
	
	/**
	 * Closes spawner upgrade GUI if active.
	 */
	
	void clear();
	
	/**
	 * @return Position of this spawner
	 */
	
	default Pos position() {
		return Pos.of(block());
	}
	
	/**
	 * @param chunk - chunk
	 * @return {@code true} if this spawner is in the specified chunk
	 */
	
	default boolean in(Chunk chunk) {
		Block block = block();
		if(block.getWorld().equals(chunk.getWorld()) == false) return false;
		return chunk.getX() == (block.getX() >> 4) && chunk.getZ() == (block.getZ() >> 4);
	}

}
