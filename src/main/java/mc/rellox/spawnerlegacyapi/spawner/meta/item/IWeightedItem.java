package mc.rellox.spawnerlegacyapi.spawner.meta.item;

import mc.rellox.spawnerlegacyapi.metadata.item.IBuildableItem;
import mc.rellox.spawnerlegacyapi.utility.IRange;
import mc.rellox.spawnerlegacyapi.utility.ISave;
import org.bukkit.inventory.ItemStack;

@Deprecated(since = "2.0.0", forRemoval = true)
public interface IWeightedItem extends ISave {

    IBuildableItem item();

    int weight();

    IRange amount();

    ItemStack roll();


}
