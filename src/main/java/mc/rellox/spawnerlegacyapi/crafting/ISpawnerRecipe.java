package mc.rellox.spawnerlegacyapi.crafting;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGeneratorSnapshot;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ISpawnerRecipe {

    /**
     * @return Recipe key
     */

    String key();

    /**
     * @return Recipe name
     */

    IContent name();

    /**
     * @return Recipe description
     */

    List<IContent> description();

    /**
     * Get the recipe display item.
     *
     * @return Item builder for display
     */

    ItemBuilder item();

    /**
     * Get the required permissions.<br>
     * Player will be able to craft this recipe if they
     * have at least one of the required permissions.
     *
     * @return List of permissions
     */

    List<String> permissions();

    /**
     * @return List of prices
     */

    List<IPrice> prices();

    /**
     * @return Crafted spawner amount
     */

    int amount();

    /**
     * @return Crafting duration in seconds
     */

    int duration();

    /**
     * @return Resulting generator snapshot
     */

    IGeneratorSnapshot snapshot();

    /**
     * @return Crafted spawner result as item stack
     */

    default ItemStack result() {
        return snapshot().toItem(amount());
    }

}
