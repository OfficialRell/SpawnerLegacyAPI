package mc.rellox.spawnerlegacyapi.spawner.meta.item;

import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.utility.IRange;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IWeightedItem extends ISave {
	
	/**
	 * @return Item to drop
	 */
	
	IMetaItem item();
	
	/**
	 * @return Item drop weight
	 */
	
	int weight();
	
	/**
	 * @return Item amount range to drop
	 */
	
	IRange amount();
	
	/**
	 * @return Rolled item stack to drop
	 */
	
	default ItemStack roll() {
		return item().item(amount().roll());
	}
	
	@Override
	default void save(IFile file, String path) {
		path += "." + item().id();
		file.set(path + ".weight", weight());
		file.set(path + ".amount", amount().key());
	}

}
