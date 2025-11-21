package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;
import java.util.Optional;

import org.bukkit.World;
import org.bukkit.block.Block;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;
import mc.rellox.spawnerlegacyapi.spawner.info.IInfo;
import mc.rellox.spawnerlegacyapi.spawner.world.IGeneratorWorld;

public interface IGeneratorManager {
	
	/**
	 * @param world - world
	 * @return Information about generator in a world
	 */
	
	IInfo info(World world);
	
	/**
	 * @param world - world
	 * @return Generator world or {@code null} if disabled
	 */
	
	IGeneratorWorld get(World world);
	
	/**
	 * Created a new generator at the block from virtual data.<br>
	 * Returns {@code null} if generators in that world are disabled.
	 * 
	 * @param block - block
	 * @param virtual - virtual data
	 * @return New generator
	 */
	
	IGenerator put(Block block, IVirtual virtual);
	
	/**
	 * Gets existing generator at the block or creates a new one if absent.<br>
	 * Returns {@code null} if generators in that world are disabled.
	 * 
	 * @param block - block
	 * @param create - create if absent
	 * @return New or existing generator
	 */
	
	IGenerator get(Block block, boolean create);
	
	/**
	 * Gets existing generator at the block.<br>
	 * Does not create a new one.
	 * 
	 * @param block - block
	 * @return Existing generator or {@code null} if absent
	 */
	
	IGenerator raw(Block block);
	
	/**
	 * Returns a list of all active generators in a world or in all worlds if {@code null} is given.
	 * 
	 * @param world - world
	 * @return List of all generators in a world
	 */
	
	List<IGenerator> list(World world);
	
	/**
	 * Returns a list of all active generators in all worlds.
	 * 
	 * @return List of all generators in all worlds
	 */
	
	default List<IGenerator> list() {
		return list(null);
	}
	
	/**
	 * @param block - block
	 * @return Optional generator at the block or empty if absent or inactive
	 */
	
	Optional<IGenerator> nullable(Block block);
	
	/**
	 * Updates generator at the block.
	 * 
	 * @param block - block
	 */
	
	void update(Block block);
	
	/**
	 * Updates all generators in all worlds.
	 */
	
	void update();
	
	/**
	 * Removes generator at the block.<br>
	 * Does not remove the spawner block.
	 * 
	 * @param block - block
	 */
	
	void remove(Block block);
	
	/**
	 * Removes generator at the block.
	 * 
	 * @param block - block
	 * @param fully - if {@code true}, removes spawner block
	 */
	
	void remove(Block block, boolean fully);
	
	/**
	 * Same as {@link #raw(Block)} but deprecated to avoid confusion.
	 * 
	 * @param block - block
	 */
	
	@Deprecated(since = "1.4.11", forRemoval = true)
	void removeRaw(Block block);

}
