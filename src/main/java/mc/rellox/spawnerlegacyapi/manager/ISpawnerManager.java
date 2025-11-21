package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.item.IItemCollector;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;
import mc.rellox.spawnerlegacyapi.spawner.location.ISelector;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.utility.region.type.EntityBox;

public interface ISpawnerManager {
	
	/**
	 * Creates a virtual spawner from the given spawner item.
	 * 
	 * @param item - spawner item
	 * @return Virtual spawner or {@code null} if item is invalid
	 */
	
	IVirtual of(ItemStack item);
	
	/**
	 * Creates a virtual spawner from the given spawner item.
	 * 
	 * @param item - spawner item
	 * @param nullable - whether to return {@code null} if unable to parse spawner type
	 * @return Virtual spawner or {@code null} if item is invalid
	 */
	
	IVirtual of(ItemStack item, boolean nullable);
	
	/**
	 * @param generator - generator
	 * @return Virtual spawner
	 */
	
	IVirtual of(IGenerator generator);

	/**
	 * @param type - spawner type
	 * @param levels - levels
	 * @param charges - charges
	 * @param spawnable - spawnable
	 * @param empty - empty
	 * @param meta - meta
	 * @param tags - tags
	 * @return Virtual spawner
	 */
	
	IVirtual of(SpawnerType type, int[] levels, int charges,
			int spawnable, boolean empty, String meta, int tags);
	
	/**
	 * @param block - block
	 * @param player - player
	 * @param virtual - virtual spawner
	 * @return Whether placement was successful
	 */
	
	boolean place(Block block, Player player, IVirtual virtual);
	
	/**
	 * @return Spawner item collector
	 */
	
	IItemCollector collector();
	
	/**
	 * @return Slime entity box
	 */
	
	EntityBox slimeBox();
	
	/**
	 * @return Magma entity box
	 */
	
	EntityBox magmaBox();
	
	/**
	 * @param type - spawner type
	 * @param def - default material
	 * @return Spawn egg material for the given spawner type
	 */
	
	Material material(SpawnerType type, Material def);
	
	/**
	 * @param type - spawner type
	 * @return Whether the given spawner type is disabled
	 */
	
	boolean disabled(SpawnerType type);
	
	/**
	 * @param type - spawner type
	 * @param list - list of blocks
	 * @return Spawner location selector for the given spawner type and list of blocks
	 */
	
	ISelector selector(SpawnerType type, List<Block> list);
	
}
