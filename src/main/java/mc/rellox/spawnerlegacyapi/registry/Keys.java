package mc.rellox.spawnerlegacyapi.registry;

import java.util.EnumMap;
import java.util.Map;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import mc.rellox.spawnerlegacyapi.SLAPI;

public final class Keys {

	private static final Map<KeyType, NamespacedKey> KEYS = new EnumMap<>(KeyType.class);
	
	public static NamespacedKey of(KeyType key) {
		return KEYS.computeIfAbsent(key, k -> new NamespacedKey(SLAPI.plugin(), k.key));
	}
	
	public static <Z> void set(ItemStack item, KeyType key, PersistentDataType<?, Z> data, Z value) {
		if(item == null) return;
		ItemMeta meta = item.getItemMeta();
		meta.getPersistentDataContainer().set(of(key), data, value);
		item.setItemMeta(meta);
	}
	
	public static void set(ItemStack item, KeyType key, String value) {
		set(item, key, PersistentDataType.STRING, value);
	}
	
	public static void set(ItemStack item, KeyType key, int value) {
		set(item, key, PersistentDataType.INTEGER, value);
	}
	
	public static void set(ItemStack item, KeyType key, double value) {
		set(item, key, PersistentDataType.DOUBLE, value);
	}
	
	public static void set(ItemStack item, KeyType key, long value) {
		set(item, key, PersistentDataType.LONG, value);
	}
	
	public static void set(ItemStack item, KeyType key, byte value) {
		set(item, key, PersistentDataType.BYTE, value);
	}
	
	public static void set(ItemStack item, KeyType key, boolean value) {
		set(item, key, PersistentDataType.BYTE, (byte) (value ? 1 : 0));
	}
	
	public static <Z> Z get(ItemStack item, KeyType key, PersistentDataType<?, Z> data, Z fallback) {
		if(item == null || !item.hasItemMeta()) return fallback;
		ItemMeta meta = item.getItemMeta();
		return meta.getPersistentDataContainer().getOrDefault(of(key), data, fallback);
	}
	
	public static String getString(ItemStack item, KeyType key) {
		return get(item, key, PersistentDataType.STRING, null);
	}
	
	public static int getInteger(ItemStack item, KeyType key) {
		return get(item, key, PersistentDataType.INTEGER, 0);
	}
	
	public static double getDouble(ItemStack item, KeyType key) {
		return get(item, key, PersistentDataType.DOUBLE, 0.0);
	}
	
	public static long getLong(ItemStack item, KeyType key) {
		return get(item, key, PersistentDataType.LONG, 0l);
	}
	
	public static byte getByte(ItemStack item, KeyType key) {
		return get(item, key, PersistentDataType.BYTE, (byte) 0);
	}
	
	public static boolean getBoolean(ItemStack item, KeyType key) {
		return get(item, key, PersistentDataType.BYTE, (byte) 0) == 1 ? true : false;
	}
	
}
