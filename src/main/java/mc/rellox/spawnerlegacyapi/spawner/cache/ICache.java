package mc.rellox.spawnerlegacyapi.spawner.cache;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ICache {

	// static methods

	public static <T> T read(Block block, ICacheType<T> type) {
		if(block.getState() instanceof CreatureSpawner spawner)
			return type.read(spawner);
		return null;
	}

	public static <T> void write(Block block, ICacheType<T> type, T value) {
		if(block.getState() instanceof CreatureSpawner spawner)
			type.write(spawner, value);
	}

	// class methods

	/**
	 * @return Generator
	 */

	IGenerator generator();

	/**
	 * Updates specified spawner types. No types will update all.
	 * 
	 * @param types - types to update
	 */

	void update(ICacheType<?>... types);

	/**
	 * Gets the cached value.
	 * 
	 * @param <T> - value type
	 * @param type - type
	 * @return Cached type value
	 */

	<T> T get(ICacheType<T> type);

	/**
	 * Gets the cached value.
	 * 
	 * @param <T> - value type
	 * @param type - type
	 * @param def - default value
	 * @return Cached type value
	 */

	default <T> T get(ICacheType<T> type, T def) {
		T t = get(type);
		return t == null ? def : t;
	}

	/**
	 * Writes and updates the new value.
	 * 
	 * @param <T> - type value
	 * @param type - type
	 * @param value - value
	 */

	<T> void write(ICacheType<T> type, T value);

	/**
	 * Updates spawner attribute values.
	 */

	void refresh();

	/**
	 * @return Cached spawner type
	 */
	
	default SpawnerType type() {
		return get(ICacheType.TYPE);
	}

	/**
	 * @return Cached spawner stack size
	 */
	
	default int stack() {
		return get(ICacheType.STACK);
	}

	/**
	 * @return {@code true} if is a naturally generated spawner
	 */
	
	default boolean natural() {
		return get(ICacheType.OWNER) == null;
	}

	/**
	 * @return {@code true} if is an empty spawner
	 */
	
	default boolean empty() {
		return get(ICacheType.EMPTY, false);
	}

	/**
	 * @return Cached spawner meta data
	 */
	
	default String metadata() {
		return get(ICacheType.METADATA);
	}
	
	/**
	 * @return Cached spawner tags
	 */
	
	default int tags() {
		return get(ICacheType.TAGS, 0);
	}

	/**
	 * @return Range upgrade value
	 */
	
	default int range() {
		return (int) upgrade(0);
	}

	/**
	 * @return Delay upgrade value
	 */
	
	default int delay() {
		return (int) upgrade(1);
	}

	/**
	 * @return Amount upgrade value
	 */
	
	default int amount() {
		return (int) upgrade(2);
	}

	/**
	 * @return Limit upgrade value
	 */
	
	default int nearby() {
		return (int) upgrade(3);
	}

	/**
	 * @return Wisdom upgrade value
	 */
	
	default double xp() {
		return upgrade(4);
	}

	/**
	 * @return Looting upgrade value
	 */
	
	default double drops() {
		return upgrade(5);
	}

	/**
	 * @return Spawner charges
	 */
	
	default int charges() {
		return get(ICacheType.CHARGES);
	}

	/**
	 * @return Spawnable entity amount
	 */
	
	default int spawnable() {
		return get(ICacheType.SPAWNABLE);
	}

	/**
	 * @return {@code true} if enabled
	 */
	
	default boolean enabled() {
		return get(ICacheType.ENABLED);
	}

	/**
	 * @return {@code true} if owned by a player
	 */
	
	default boolean owned() {
		return id() != null;
	}

	/**
	 * @return Owner UUID or {@code null} if this is a natural spawner
	 */
	
	default UUID id() {
		return get(ICacheType.OWNER);
	}

	/**
	 * @return Online player owned or {@code null} if player not online
	 * or this is a natural spawner
	 */
	
	default Player owner() {
		UUID id = id();
		return id == null ? null : Bukkit.getPlayer(id);
	}

	/**
	 * @param player - player
	 * @param def - defualt value
	 * @return {@code true} if this spawner is owned by the specified player
	 * or the default value
	 * 
	 */
	default boolean owner(Player player, boolean def) {
		UUID id = id();
		return id == null ? def : player.getUniqueId().equals(id);
	}

	/**
	 * @param i - upgrade type index
	 * @return The upgrade value at the specified upgrade type index
	 */
	
	default double upgrade(int i) {
		double[] is = get(ICacheType.UPGRADES);
		return is == null ? 0 : is[i];
	}

}
