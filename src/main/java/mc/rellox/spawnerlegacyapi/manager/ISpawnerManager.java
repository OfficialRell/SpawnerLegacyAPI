package mc.rellox.spawnerlegacyapi.manager;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.IVirtual;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ISpawnerManager {
	
	IVirtual of(ItemStack item);
	
	IVirtual of(ItemStack item, boolean nullable);
	
	IVirtual of(IGenerator generator);

	IVirtual of(SpawnerType type, int[] levels, int charges,
			int spawnable, boolean empty, String meta, int tags);
	
	boolean place(Block block, Player player, IVirtual virtual);
	
}
