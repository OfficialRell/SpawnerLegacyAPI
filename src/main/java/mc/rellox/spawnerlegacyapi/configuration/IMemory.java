package mc.rellox.spawnerlegacyapi.configuration;

import mc.rellox.spawnerlegacyapi.text.content.ContentParser;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.*;
import java.util.stream.Collectors;

public interface IMemory {

    /**
     * @return Parent memory or {@code null} if this is the root memory
     */

    IMemory parent();

    /**
     * @return File or file section
     */

    ConfigurationSection file();

    /**
     * @return Full path of this memory
     */

    default String path() {
        return file().getCurrentPath();
    }

    /**
     * This is the final part of the path, which is the key of this memory.<br>
     * Root memory has no key, and will return an empty string.<br>
     * Orphaned/replaced memory sections will return {@code null}.
     *
     * @return Key of this memory
     */

    default String key() {
        return file().getName();
    }

    /**
     * @param path path
     * @return Child memory or {@code null} if this section does not exist
     */

    default IMemory child(String path) {
        return child(path, false);
    }

    /**
     * @param path   path
     * @param create {@code true} to create this section if it does not exist
     * @return Child memory or {@code null} if this section does not exist and {@code create} is {@code false}
     */

    default IMemory child(String path, boolean create) {
        ConfigurationSection section = file().getConfigurationSection(path);
        if(section == null) {
            if(create) section = file().createSection(path);
            else return null;
        }
        return new Memory(this, section);
    }

    /**
     * @param path path
     * @return {@code true} if this path has a value
     */

    default boolean exists(String path) {
        return file().isSet(path);
    }

    /**
     * Sets an object to the path.<br>
     * Does not update the file.
     *
     * @param path   path
     * @param object object to set
     */

    default void hold(String path, Object object) {
        file().set(path, object);
    }

    /**
     * Removes specified path, without saving this file.<br>
     * Does not update the file.
     *
     * @param path path to remove
     */

    default void delete(String path) {
        file().set(path, null);
    }

    /**
     * Replaces a value from one path to another.<br>
     * Does not update the file.
     *
     * @param from source path
     * @param to   destination path
     */

    default void replace(String from, String to) {
        var value = get(from);
        if(value == null) return;
        hold(to, value);
        delete(from);
    }

    /**
     * Adds comments to this path.
     *
     * @param path     path
     * @param comments comments
     */

    default void comment(String path, String... comments) {
        comment(path, List.of(comments));
    }

    /**
     * Adds comments to this path.
     *
     * @param path path
     * @param list comments
     */

    default void comment(String path, List<String> list) {
        file().setComments(path, list);
    }

    /**
     * Get all keys from the specified path.
     *
     * @param path path
     * @return Set of path keys
     */

    default Set<String> keys(String path) {
        ConfigurationSection section = file().getConfigurationSection(path);
        return section == null ? new HashSet<>() : section.getKeys(false);
    }

    /**
     * Get all keys from the root path.
     *
     * @return Set of root keys
     */

    default Set<String> keys() {
        return file().getKeys(false);
    }

    /**
     * Get all keys from the specified path, including child keys.
     *
     * @param path path
     * @return Set of path keys
     */

    default Set<String> allKeys(String path) {
        ConfigurationSection section = file().getConfigurationSection(path);
        return section == null ? new HashSet<>() : section.getKeys(true);
    }

    /**
     * Get all keys from the root path, including child keys.
     *
     * @return Set of root keys
     */

    default Set<String> allKeys() {
        return file().getKeys(true);
    }

    /**
     * Get all child memories from the specified path.
     *
     * @param path path
     * @return Set of child memories
     */

    default Set<IMemory> children(String path) {
        Set<IMemory> children = new LinkedHashSet<>();
        keys(path).forEach(key -> {
            IMemory child = child(path + "." + key);
            if(child != null) children.add(child);
        });
        return children;
    }

    /**
     * Sets a default value.
     *
     * @param path  path
     * @param value default value
     */

    default void defaulted(String path, Object value) {
        file().addDefault(path, value);
    }

    /**
     * @param path path
     * @return Object value
     */

    default Object get(String path) {
        return file().get(path);
    }

    /**
     * @param path path
     * @return Integer value
     */

    default int getInteger(String path) {
        return file().getInt(path);
    }

    /**
     * @param path     path
     * @param fallback fallback value
     * @return Integer value or fallback if not found
     */

    default int getInteger(String path, int fallback) {
        return file().getInt(path, fallback);
    }

    /**
     * @param path path
     * @param min  minimum value
     * @param max  maximum value
     * @return Safe integer value
     */

    default int getInteger(String path, int min, int max) {
        int i = file().getInt(path);
        return Math.clamp(i, min, max);
    }

    /**
     * @param path path
     * @return Integer list value
     */

    default List<Integer> getIntegers(String path) {
        return file().getIntegerList(path);
    }

    /**
     * @param path path
     * @return Double value
     */

    default double getDouble(String path) {
        return file().getDouble(path);
    }

    /**
     * @param path     path
     * @param fallback fallback value
     * @return Double value or fallback if not found
     */

    default double getDouble(String path, double fallback) {
        return file().getDouble(path, fallback);
    }

    /**
     * @param path path
     * @param min  minimum value
     * @param max  maximum value
     * @return Safe double value
     */

    default double getDouble(String path, double min, double max) {
        double i = file().getDouble(path);
        return Math.clamp(i, min, max);
    }

    /**
     * @param path path
     * @return Double list value
     */

    default List<Double> getDoubles(String path) {
        return file().getDoubleList(path);
    }

    /**
     * @param path path
     * @return Long value
     */

    default long getLong(String path) {
        return file().getLong(path);
    }

    /**
     * @param path     path
     * @param fallback fallback value
     * @return Long value or fallback if not found
     */

    default long getLong(String path, int fallback) {
        return file().getLong(path, fallback);
    }

    /**
     * @param path path
     * @param min  minimum value
     * @param max  maximum value
     * @return Safe long value
     */

    default long getLong(String path, long min, long max) {
        long i = file().getLong(path);
        return Math.clamp(i, min, max);
    }

    /**
     * @param path path
     * @return Long list value
     */

    default List<Long> getLongs(String path) {
        return file().getLongList(path);
    }

    /**
     * @param path path
     * @return String value
     */

    default String getString(String path) {
        return file().getString(path);
    }

    /**
     * @param path     path
     * @param fallback fallback value
     * @return String value or fallback if not found
     */

    default String getString(String path, String fallback) {
        return file().getString(path, fallback);
    }

    /**
     * @param path path
     * @return Boolean value
     */

    default boolean getBoolean(String path) {
        return file().getBoolean(path);
    }

    /**
     * @param path     path
     * @param fallback fallback value
     * @return Boolean value or fallback if not found
     */

    default boolean getBoolean(String path, boolean fallback) {
        return file().getBoolean(path, fallback);
    }

    /**
     * @param path path
     * @return String list value
     */

    default List<String> getStrings(String path) {
        return file().getStringList(path);
    }

    /**
     * @param path path
     * @return String set value
     */

    default Set<String> getStringsAsSet(String path) {
        return new HashSet<>(getStrings(path));
    }

    /**
     * Returns a list of strings even if this path is a single string.
     *
     * @param path path
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
     * Returns a set of strings even if this path is a single string.
     *
     * @param path path
     * @return String set value
     */

    default Set<String> getStringOrStringsAsSet(String path) {
        return new HashSet<>(getStringOrStrings(path));
    }

    /**
     * @param <E>      enum type
     * @param path     path
     * @param clazz    enum class
     * @param fallback fallback value
     * @return Enum value or {@code default} value
     */

    default <E extends Enum<E>> E getEnum(String path, Class<E> clazz, E fallback) {
        return Reflect.RF.enumerate(clazz, getString(path), fallback);
    }

    /**
     * @param <E>   enum type
     * @param path  path
     * @param clazz enum class
     * @return Enum value or {@code null}
     */

    default <E extends Enum<E>> E getEnum(String path, Class<E> clazz) {
        return getEnum(path, clazz, null);
    }

    /**
     * @param <E>   enum type
     * @param path  path
     * @param clazz enum class
     * @return Enum value list, can be empty
     */

    default <E extends Enum<E>> List<E> getEnums(String path, Class<E> clazz) {
        return Reflect.RF.enumerates(clazz, getStrings(path));
    }

    /**
     * @param <E>   enum type
     * @param path  path
     * @param clazz enum class
     * @return Enum value set, can be empty
     */

    default <E extends Enum<E>> Set<E> getEnumsAsSet(String path, Class<E> clazz) {
        List<E> list = Reflect.RF.enumerates(clazz, getStrings(path));
        return list.isEmpty() ? EnumSet.noneOf(clazz) : EnumSet.copyOf(list);
    }

    /**
     * @param path     path
     * @param fallback fallback value
     * @return Material or {@code fallback} value
     */

    default Material getMaterial(String path, Material fallback) {
        return getEnum(path, Material.class, fallback);
    }

    /**
     * @param path path
     * @return Material or {@code null}
     */

    default Material getMaterial(String path) {
        return getMaterial(path, null);
    }

    /**
     * @param path path
     * @return IContent value or {@code null}
     */

    default IContent getContent(String path) {
        String value = getString(path);
        return value == null ? null : IContent.parse(value);
    }

    /**
     * @param path path
     * @return IContent value list
     */

    default List<IContent> getContents(String path) {
        return getStringOrStrings(path).stream()
                .map(IContent::parse)
                .collect(Collectors.toList());
    }

    /**
     * Gets a keyed IContent value or {@code null} if the string
     * to parse is {@code null} or empty.
     *
     * @param path path
     * @return Keyed IContent value or {@code null}
     */

    default IContent getKeyedContent(String path) {
        String value = getString(path);
        return value == null || value.isEmpty() ? null : ContentParser.parseAndKey(value);
    }

    /**
     * @param path path
     * @return Keyed IContent value list
     */

    default List<IContent> getKeyedContents(String path) {
        return getStringOrStrings(path).stream()
                .map(ContentParser::parseAndKey)
                .collect(Collectors.toList());
    }

    /**
     * @param path path
     * @return List of maps, can be empty
     */

    default List<Map<?, ?>> getMaps(String path) {
        return file().getMapList(path);
    }

    record Memory(IMemory parent, ConfigurationSection file) implements IMemory {
    }

}
