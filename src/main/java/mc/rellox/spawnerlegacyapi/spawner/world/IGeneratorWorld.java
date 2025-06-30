package mc.rellox.spawnerlegacyapi.spawner.world;

import java.util.List;
import java.util.stream.Stream;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;
import mc.rellox.spawnerlegacyapi.spawner.info.IInfo;

public interface IGeneratorWorld {
	
	/**
	 * @return World
	 */
	
	World world();
	
	/**
	 * Loads all generators.
	 */
	
	void load();
	
	/**
	 * Loads all generators in a chunk.
	 * 
	 * @param chunk - chunk
	 */
	
	void load(Chunk chunk);
	
	/**
	 * Unloads all generators in a chunk.
	 * 
	 * @param chunk - chunk
	 */
	
	void unload(Chunk chunk);
	
	/**
	 * Clears all generators.<br>
	 * This does not remove them, only removes holograms.
	 */
	
	void clear();
	
	/**
	 * @return List of generators
	 */
	
	List<IGenerator> list();
	
	/**
	 * @return Stream of generators
	 */
	
	Stream<IGenerator> stream();
	
	/**
	 * @return Information about generators
	 */
	
	IInfo info();
	
	/**
	 * Updates all generators.<br>
	 * This includes spawner delay, upgrades and other.
	 */
	
	void update();
	
	/**
	 * Refreshes all generators.<br>
	 * This includes spawner updates and checks.
	 */
	
	void refresh();
	
	/**
	 * Ticks all generators.
	 */
	
	void tick();
	
	/**
	 * Removes all invalid or inactive generators.
	 */
	
	void reduce();
	
	/**
	 * Creates a new generator and adds it to the list.
	 * Never {@code null}.
	 * 
	 * @param block - block
	 * @param virtual - virtual spawner
	 * @return Newly created generator
	 */
	
	IGenerator put(Block block, IVirtual virtual);
	
	/**
	 * Adds this generator to the list only if it does not already exist.
	 * 
	 * @param generator - generator
	 */
	
	void put(IGenerator generator);
	
	/**
	 * Tries to create a new generator if none present.
	 * 
	 * @param block - block
	 * @param create - should create if none present
	 * @return Current generator or new generator, or {@code null}
	 */
	
	IGenerator get(Block block, boolean create);
	
	/**
	 * Returns the current generator or tries to create a new.<br>
	 * If fails, returns {@code null}.<br>
	 * The newly created generator is not added to generator list.
	 * 
	 * @param block - block
	 * @return Existing or new generator, or {@code null}
	 */
	
	IGenerator force(Block block);
	
	/**
	 * Returns the current generator or {@code null} if none present.
	 * 
	 * @param block - block
	 * @return Existing generator or {@code null}
	 */
	
	IGenerator raw(Block block);

}
