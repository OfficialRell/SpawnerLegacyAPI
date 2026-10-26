package mc.rellox.spawnerlegacyapi.spawner.virtual;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import org.bukkit.Material;

import java.util.Map;

public interface IVirtualStorage {

    /**
     * @return Generator
     */

    IGenerator generator();

    /**
     * @return Whether this storage has any items or xp
     */

    boolean empty();

    /**
     * This method will return {@code false} if both items and xp
     * is configured to not be stored in this storage but rather
     * to be dropped near the generator.
     *
     * @return Whether this storage stores any items and xp
     */

    boolean storing();

    /**
     * @return Stored items
     */

    IStoredItems items();

    /**
     * @return Stored XP
     */

    IStoredXp xp();

    /**
     * Adds all the generated items and xp to this storage.<br>
     * This will also check required configuration settings.
     *
     * @param rolls generated virtual rolls
     */

    void add(IVirtualRolls rolls);

    /**
     * @return Last time (in milliseconds) drops were calculated, or 0 if never
     */

    long time();

    /**
     * Sets the last time (in milliseconds) drops were calculated.<br>
     * For an active generator, this will automatically calculate the time difference
     * and generate drops accordingly.
     *
     * @param time last time
     */

    void time(long time);

    /**
     * Flushes the storage.
     *
     * @param force whether to force the flush
     */

    void flush(boolean force);

    /**
     * Drops all items and xp at the center of the generator.<br>
     * This is mostly called when a generator is removed.
     */

    void drop();

    interface IStoredItems {

        /**
         * @return The amount of the item stored
         */

        long total();

        /**
         * @return The maximum amount of the item that can be stored
         */

        long limit();

        /**
         * @return The amount of the item that can still be stored
         */

        long available();

        /**
         * @return An immutable view of the stored items and their amounts
         */

        Map<Material, Long> items();

        /**
         * @return The number of different types of items stored
         */

        int count();

        /**
         * Adds the specified amount of the given material to the storage.
         *
         * @param material material to add
         * @param amount   amount to add
         * @return The amount that was actually added
         */

        long add(Material material, long amount);

        /**
         * Adds the specified items to the storage.
         *
         * @param items items to add
         */

        void add(Map<Material, Long> items);

        /**
         * Gets the amount of the specified material in the storage.
         *
         * @param material material to get
         * @return The amount of the material in the storage
         */

        long get(Material material);

        /**
         * Removes the specified amount of the given material from the storage.
         *
         * @param material material to remove
         * @param amount   amount to remove
         * @return The amount that was actually removed
         */

        long take(Material material, long amount);

    }

    interface IStoredXp {

        /**
         * @return The amount of XP stored
         */

        long get();

        /**
         * @return The maximum amount of XP that can be stored
         */

        long limit();

        /**
         * @return The amount of XP that can still be stored
         */

        long available();

        /**
         * Adds the specified amount of XP to the storage.
         *
         * @param amount amount to add
         * @return The amount that was actually added
         */

        long add(long amount);

        /**
         * Removes the specified amount of XP from the storage.
         *
         * @param amount amount to remove
         * @return The amount that was actually removed
         */

        long take(long amount);

    }

}
