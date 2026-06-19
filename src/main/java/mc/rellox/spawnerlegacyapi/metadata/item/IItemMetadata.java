package mc.rellox.spawnerlegacyapi.metadata.item;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.metadata.IMetadata;
import mc.rellox.spawnerlegacyapi.spawner.meta.item.IItemData;
import mc.rellox.spawnerlegacyapi.utility.Calculate;
import mc.rellox.spawnerlegacyapi.utility.ISave;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IItemMetadata extends IMetadata, ISave,
        IItemData {

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
     * @param count item count
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
        if(items.size() == 1) return items.getFirst().roll();

        int weight = Calculate.random(total());
        for(IWeightedItem item : items)
            if((weight -= item.weight()) < 0)
                return item.roll();
        return items.getFirst().roll(); // should never get here
    }

    @Override
    default void save(IFile file, String path) {
        if(name() != null) name().save(file, path + "." + id() + ".display");
        if(inside() != null) inside().save(file, path + "." + id() + ".display");
        items().forEach(item -> item.save(file, path + "." + id() + ".list"));
    }

}
