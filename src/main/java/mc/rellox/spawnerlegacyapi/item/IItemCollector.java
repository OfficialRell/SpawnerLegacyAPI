package mc.rellox.spawnerlegacyapi.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface IItemCollector {

    /**
     * @param player player
     * @param item   item to add
     */

    void add(Player player, ItemStack item);

    /**
     * @param player player
     * @return {@code true} if the player has collected items
     */

    boolean exists(Player player);

    /**
     * Gives all the collected items to the player.<br>
     * If not all items were given, the player will be reminded to collect them again.
     *
     * @param player player
     */

    void execute(Player player);

    /**
     * Unregisters the player from the collector.<br>
     * This will delete all items that were collected.
     *
     * @param player player
     */

    void unregister(Player player);

    /**
     * @param player player
     * @return Collected items of the player, can be {@code null}
     */

    ICollected get(Player player);

    interface ICollected {

        /**
         * @return Player that owns the items
         */

        Player player();

        /**
         * @return Mutable list of collected items
         */

        List<ItemStack> items();

        /**
         * Tries to give all items to the player.<br>
         * If not all items were given, the player will be reminded to collect them again
         * if silent is {@code false}.
         *
         * @param silent should not remind again
         * @return Whether all items were given to the player
         */

        boolean get(boolean silent);

        /**
         * Reminds the player to collect the items again
         * by playing a sound and sending a chat message.
         */

        void remind();

    }

}
