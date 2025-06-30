package mc.rellox.spawnerlegacyapi.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface IItemCollector {
	
	void add(Player player, ItemStack item);
	
	boolean exists(Player player);
	
	void execute(Player player);
	
	void unregister(Player player);
	
	ICollected get(Player player);
	
	interface ICollected {
		
		Player player();
		
		boolean get(boolean silent);
		
	}

}
