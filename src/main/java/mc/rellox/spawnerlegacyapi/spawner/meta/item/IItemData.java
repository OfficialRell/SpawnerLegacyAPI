package mc.rellox.spawnerlegacyapi.spawner.meta.item;

import mc.rellox.spawnerlegacyapi.metadata.item.IWeightedItem;
import mc.rellox.spawnerlegacyapi.spawner.meta.IDisplay;
import mc.rellox.spawnerlegacyapi.utility.ISave;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Deprecated(since = "2.0.0", forRemoval = true)
public interface IItemData extends ISave, IDisplay {

    List<IWeightedItem> items();

    int total();

    List<ItemStack> rolls(int count);

    ItemStack roll();

}
