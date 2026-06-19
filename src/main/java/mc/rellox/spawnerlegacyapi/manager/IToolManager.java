package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.item.tool.ICrowbar;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface IToolManager {

    /**
     * @param item item
     * @return If this item is a tool
     */

    boolean tool(ItemStack item);

    /**
     * @return List of all crowbar keys
     */

    List<String> crowbars();

    /**
     * @param key key
     * @return Crowbar from the specified key
     */

    ICrowbar crowbar(String key);

    /**
     * @param item item
     * @return Crowbar from the specified item
     */

    ICrowbar crowbar(ItemStack item);

}
