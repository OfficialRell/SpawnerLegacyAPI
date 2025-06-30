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
	
	IGenerator put(Block block, IVirtual virtual);
	
	IGenerator get(Block block, boolean create);
	
	IGenerator raw(Block block);
	
	List<IGenerator> list(World world);
	
	Optional<IGenerator> nullable(Block block);
	
	void update(Block block);
	
	void update();
	
	void remove(Block block);
	
	void removeRaw(Block block);

}
