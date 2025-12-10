package mc.rellox.spawnerlegacyapi.spawner.meta.item;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.spawner.meta.IDisplay;
import mc.rellox.spawnerlegacyapi.utility.Calculate;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IItemData extends ISave, IDisplay {
	
	/**
	 * @return Data id
	 */
	
	String id();
	
	/**
	 * @return The item rotating inside the spawner
	 */
	
	IMetaItem inside();
	
	/**
	 * @return Weighted item list
	 */
	
	List<IWeightedItem> items();
	
	/**
	 * @return Total item weight
	 */
	
	int total();
	
	/**
	 * Rolls a specific count of random items.
	 * 
	 * @param count - item count
	 * @return List of rolled items
	 */
	
	default List<ItemStack> rolls(int count) {
		return Stream.generate(this::roll)
				.limit(count)
				.collect(Collectors.toList());
	}
	
	/**
	 * @return Randomly rolled item from the list
	 */
	
	default ItemStack roll() {
		List<IWeightedItem> items = items();
		if(items.size() == 1) return items.get(0).roll();
		
		int weight = Calculate.random(total());
		for(IWeightedItem item : items) if((weight -= item.weight()) < 0) return item.roll();
		return items.get(0).roll(); // should never get here
	}
	
	@Override
	default void save(IFile file, String path) {
		var key = display().key();
		if(key != null) file.set(path + "." + id() + ".display-name", key);
		file.set(path + "." + id() + ".display-inside", inside().id());
		items().forEach(item -> item.save(file, path + "." + id() + ".list"));
	}

}
