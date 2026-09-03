package mc.rellox.spawnerlegacyapi.registry;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public final class Keys {

    public static <Z> void set(ItemStack item, NamespacedKey key, PersistentDataType<?, Z> data, Z value) {
        if(item == null) return;
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, data, value);
        item.setItemMeta(meta);
    }

    public static void set(ItemStack item, NamespacedKey key, String value) {
        set(item, key, PersistentDataType.STRING, value);
    }

    public static void set(ItemStack item, NamespacedKey key, int value) {
        set(item, key, PersistentDataType.INTEGER, value);
    }

    public static void set(ItemStack item, NamespacedKey key, double value) {
        set(item, key, PersistentDataType.DOUBLE, value);
    }

    public static void set(ItemStack item, NamespacedKey key, long value) {
        set(item, key, PersistentDataType.LONG, value);
    }

    public static void set(ItemStack item, NamespacedKey key, byte value) {
        set(item, key, PersistentDataType.BYTE, value);
    }

    public static void set(ItemStack item, NamespacedKey key, boolean value) {
        set(item, key, PersistentDataType.BYTE, (byte) (value ? 1 : 0));
    }

    public static <Z> Z get(ItemStack item, NamespacedKey key, PersistentDataType<?, Z> data, Z fallback) {
        if(item == null || !item.hasItemMeta()) return fallback;
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().getOrDefault(key, data, fallback);
    }

    public static String getString(ItemStack item, NamespacedKey key) {
        return get(item, key, PersistentDataType.STRING, null);
    }

    public static int getInteger(ItemStack item, NamespacedKey key) {
        return get(item, key, PersistentDataType.INTEGER, 0);
    }

    public static double getDouble(ItemStack item, NamespacedKey key) {
        return get(item, key, PersistentDataType.DOUBLE, 0.0);
    }

    public static long getLong(ItemStack item, NamespacedKey key) {
        return get(item, key, PersistentDataType.LONG, 0L);
    }

    public static byte getByte(ItemStack item, NamespacedKey key) {
        return get(item, key, PersistentDataType.BYTE, (byte) 0);
    }

    public static boolean getBoolean(ItemStack item, NamespacedKey key) {
        return get(item, key, PersistentDataType.BYTE, (byte) 0) == 1;
    }

}
