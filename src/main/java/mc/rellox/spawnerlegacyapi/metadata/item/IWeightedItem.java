package mc.rellox.spawnerlegacyapi.metadata.item;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.utility.IRange;
import mc.rellox.spawnerlegacyapi.utility.ISave;
import org.bukkit.inventory.ItemStack;

public interface IWeightedItem extends ISave,
        mc.rellox.spawnerlegacyapi.spawner.meta.item.IWeightedItem {

    /**
     * @return Item to drop
     */

    IBuildableItem item();

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
