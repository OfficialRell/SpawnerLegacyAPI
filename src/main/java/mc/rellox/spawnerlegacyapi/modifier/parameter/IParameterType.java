package mc.rellox.spawnerlegacyapi.modifier.parameter;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public interface IParameterType<T> {

    IParameterType<Integer> INTEGER = new ParameterTypeInteger();
    IParameterType<Double> DOUBLE = new ParameterTypeDouble();
    IParameterType<Boolean> BOOLEAN = new ParameterTypeBoolean();

    /**
     * Parses a string value into the corresponding type.
     *
     * @param value string value to parse.
     * @return The parsed value
     */

    T parse(String value);

    /**
     * Validates if the given value is valid for this parameter type.<br>
     * This method is usually called after the parse method.
     *
     * @param value value to validate
     * @return {@code true} if the value is valid
     */

    boolean valid(Object value);

    /**
     * Replaces the given placeholder in the item builder.
     *
     * @param builder     item builder
     * @param placeholder placeholder
     * @param value       value to replace with
     */

    void replace(ItemBuilder builder, String placeholder, Object value);

    /**
     * Reads the value from the persistent data container.
     *
     * @param container persistent data container
     * @param key       namespaced key
     * @param fallback  fallback value if the key is not found
     * @return The read value
     */

    T read(PersistentDataContainer container, NamespacedKey key, T fallback);

    /**
     * Writes the value to the persistent data container.
     *
     * @param container persistent data container
     * @param key       namespaced key
     * @param value     value to write
     */

    void write(PersistentDataContainer container, NamespacedKey key, Object value);

    /**
     * @return The fallback value
     */

    T fallback();

    /**
     * These values are provided as a command auto-completions when a player is giving a modifier.
     *
     * @return The default values for this parameter type
     */

    default List<String> defaults() {
        return List.of();
    }

}
