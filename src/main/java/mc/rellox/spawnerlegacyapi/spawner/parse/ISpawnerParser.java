package mc.rellox.spawnerlegacyapi.spawner.parse;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.inventory.ItemStack;

public interface ISpawnerParser {
	
	/**
	 * @return Unique parser ID
	 */
	
	String id();
	
	/**
	 * Checks if this spawner has old values and should be parsed.
	 * 
	 * @param spawner - spawner block
	 * @return If this spawner should be parsed
	 */
	
	boolean is(CreatureSpawner spawner);
	
	/**
	 * Parses all old spawner values to the new spawner values.
	 * 
	 * @param spawner - spawner block
	 */
	
	void parse(CreatureSpawner spawner);
	
	/**
	 * Checks if this item has old values and should be parsed.
	 * 
	 * @param item - item
	 * @return If this item should be parsed
	 */
	
	boolean is(ItemStack item);
	
	/**
	 * Parses all old spawner item values to the new spawner item values.
	 * 
	 * @param item - item
	 */
	
	void parse(ItemStack item);

}
