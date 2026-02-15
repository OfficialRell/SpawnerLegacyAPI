package mc.rellox.spawnerlegacyapi.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public interface IFileValues {

	/**
	 * @return File or file section
	 */
	
	ConfigurationSection file();
	
	/**
	 * @param path - path
	 * @return Object value
	 */
	
	default Object get(String path) {
		return file().get(path);
	}
	
	/**
	 * @param path - path
	 * @return Integer value
	 */
	
	default int getInteger(String path) {
		return file().getInt(path);
	}
	
	/**
	 * @param path - path
	 * @param fallback - fallback value
	 * @return Integer value or fallback if not found
	 */
	
	default int getInteger(String path, int fallback) {
		return file().getInt(path, fallback);
	}
	
	/**
	 * @param path - path
	 * @param min - minimum value
	 * @param max - maximum value
	 * @return Safe integer value
	 */
	
	default int getInteger(String path, int min, int max) {
		int i = file().getInt(path);
		return i < min ? min : i > max ? max : i;
	}
	
	/**
	 * @param path - path
	 * @return Integer list value
	 */
	
	default List<Integer> getIntegers(String path) {
		return file().getIntegerList(path);
	}
	
	/**
	 * @param path - path
	 * @return Double value
	 */
	
	default double getDouble(String path) {
		return file().getDouble(path);
	}
	
	/**
	 * @param path - path
	 * @param fallback - fallback value
	 * @return Double value or fallback if not found
	 */
	
	default double getDouble(String path, double fallback) {
		return file().getDouble(path, fallback);
	}
	
	/**
	 * @param path - path
	 * @param min - minimum value
	 * @param max - maximum value
	 * @return Safe double value
	 */
	
	default double getDouble(String path, double min, double max) {
		double i = file().getDouble(path);
		return i < min ? min : i > max ? max : i;
	}
	
	/**
	 * @param path - path
	 * @return Long value
	 */
	
	default long getLong(String path) {
		return file().getLong(path);
	}
	
	/**
	 * @param path - path
	 * @param fallback - fallback value
	 * @return Long value or fallback if not found
	 */
	
	default long getLong(String path, int fallback) {
		return file().getLong(path, fallback);
	}
	
	/**
	 * @param path - path
	 * @param min - minimum value
	 * @param max - maximum value
	 * @return Safe long value
	 */
	
	default long getLong(String path, long min, long max) {
		long i = file().getLong(path);
		return i < min ? min : i > max ? max : i;
	}
	
	/**
	 * @param path - path
	 * @return Long list value
	 */
	
	default List<Long> getLongs(String path) {
		return file().getLongList(path);
	}
	
	/**
	 * @param path - path
	 * @return String value
	 */
	
	default String getString(String path) {
		return file().getString(path);
	}
	
	/**
	 * @param path - path
	 * @param fallback - fallback value
	 * @return String value or fallback if not found
	 */
	
	default String getString(String path, String fallback) {
		return file().getString(path, fallback);
	}
	
	/**
	 * @param path - path
	 * @return Boolean value
	 */
	
	default boolean getBoolean(String path) {
		return file().getBoolean(path);
	}
	
	/**
	 * @param path - path
	 * @param fallback - fallback value
	 * @return Boolean value or fallback if not found
	 */
	
	default boolean getBoolean(String path, boolean fallback) {
		return file().getBoolean(path, fallback);
	}
	
	/**
	 * @param path - path
	 * @return String list value
	 */
	
	default List<String> getStrings(String path) {
		return file().getStringList(path);
	}
	
	/**
	 * @param path - path
	 * @return String set value
	 */
	
	default Set<String> getStringsAsSet(String path) {
		return new HashSet<>(getStrings(path));
	}
	
	/**
	 * Returns a list of strings even if this path is a single string.
	 * 
	 * @param path - path
	 * @return String list value
	 */
	
	default List<String> getStringOrStrings(String path) {
		List<String> list = new ArrayList<>();
		if(file().isList(path)) list.addAll(file().getStringList(path));
		else {
			String value = file().getString(path);
			if(value != null && !value.isEmpty()) list.add(value);
		}
		return list;
	}
	
	/**
	 * @param <E> - enum type
	 * @param path - path
	 * @param clazz - enum class
	 * @param def - default value
	 * @return Enum value or {@code default} value
	 */
	
	default <E extends Enum<E>> E getEnum(String path, Class<E> clazz, E def) {
		return RF.enumerate(clazz, getString(path), def);
	}
	
	/**
	 * @param <E> - enum type
	 * @param path - path
	 * @param clazz - enum class
	 * @return Enum value or {@code null}
	 */
	
	default <E extends Enum<E>> E getEnum(String path, Class<E> clazz) {
		return getEnum(path, clazz, null);
	}
	
	/**
	 * @param <E> - enum type
	 * @param path - path
	 * @param clazz - enum class
	 * @return Enum value list, can be empty
	 */
	
	default <E extends Enum<E>> List<E> getEnums(String path, Class<E> clazz) {
		return RF.enumerates(clazz, getStrings(path));
	}
	
	/**
	 * @param <E> - enum type
	 * @param path - path
	 * @param clazz - enum class
	 * @return Enum value set, can be empty
	 */
	
	default <E extends Enum<E>> Set<E> getEnumsAsSet(String path, Class<E> clazz) {
		return new HashSet<>(RF.enumerates(clazz, getStrings(path)));
	}
	
	/**
	 * @param path - path
	 * @param def - default value
	 * @return Material or {@code default} value
	 */
	
	default Material getMaterial(String path, Material def) {
		return getEnum(path, Material.class, def);
	}
	
	/**
	 * @param path - path
	 * @return Material or {@code null}
	 */
	
	default Material getMaterial(String path) {
		return getMaterial(path, null);
	}
	
	/**
	 * @param path - path
	 * @return IContent value or {@code null}
	 */
	
	default IContent getContent(String path) {
		String value = getString(path);
		return value == null ? null : IContent.parse(value);
	}
	
	/**
	 * @param path - path
	 * @return IContent value list
	 */
	
	default List<IContent> getContents(String path) {
		return getStringOrStrings(path).stream()
				.map(IContent::parse)
				.collect(Collectors.toList());
	}
	
	/**
	 * Sets a value at the specified path.<br>
	 * Does not update the file.
	 * 
	 * @param path - path
	 * @param value - value
	 */
	
	default void set(String path, Object value) {
		file().set(path, value);
	}
	
	/**
	 * Deletes a value at the specified path.<br>
	 * Does not update the file.
	 * 
	 * @param path - path
	 */
	
	default void delete(String path) {
		file().set(path, null);
	}
	
	/**
	 * Replaces a value from one path to another.<br>
	 * Does not update the file.
	 * 
	 * @param from - source path
	 * @param to - destination path
	 */
	
	default void replace(String from, String to) {
		var value = get(from);
		if(value == null) return;
		set(to, value);
		delete(from);
	}
	
}
