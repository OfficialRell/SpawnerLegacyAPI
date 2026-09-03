package mc.rellox.spawnerlegacyapi.modifier.parameter;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.registry.IKey;
import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.utility.Calculate;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public interface IParameter<T> {

    static <T> IParameterBuilder<T> builder(String id, IParameterType<T> type) {
        return SLAPI.modifiers().builder(id, type);
    }

    IParameter<Double> VALUE = builder("value", IParameterType.DOUBLE)
            .defaults("10", "25", "50", "75", "100")
            .validator(value -> value instanceof Double d && d > 0.0)
            .build();
    IParameter<Integer> USAGE = builder("usage", IParameterType.INTEGER)
            .defaults("50", "100", "500", "#infinite")
            .parser(value -> value.equalsIgnoreCase("#infinite")
                    ? Calculate.INFINITE
                    : IParameterType.INTEGER.parse(value))
            .validator(value -> value instanceof Integer i && i > 0)
            .replacer((builder, id, value) -> {
                if(value instanceof Integer i)
                    builder.replace(id, i >= Calculate.INFINITE ? Text.infinity : i);
            })
            .build();
    IParameter<Double> CHANCE = builder("chance", IParameterType.DOUBLE)
            .defaults("25", "50", "75", "100")
            .validator(value -> value instanceof Double d && d > 0.0 && d <= 100.0)
            .fallback(100.0)
            .build();
    IParameter<Integer> DURATION = builder("duration", IParameterType.INTEGER)
            .defaults("20", "40", "80", "100", "#infinite")
            .parser(value -> value.equalsIgnoreCase("#infinite")
                    ? Calculate.INFINITE
                    : IParameterType.INTEGER.parse(value))
            .validator(value -> value instanceof Integer i && i > 0)
            .replacer((builder, id, value) -> {
                if(value instanceof Integer i)
                    builder.replace(id, i >= Calculate.INFINITE ? Text.infinity : Text.format(i / 20.0, 1));
            })
            .build();
    IParameter<Integer> AMPLIFIER = builder("amplifier", IParameterType.INTEGER)
            .defaults("1", "2", "3", "4", "5")
            .validator(value -> value instanceof Integer i && i > 0)
            .build();
    IParameter<Boolean> AMBIENT = builder("ambient", IParameterType.BOOLEAN).build();
    IParameter<Boolean> PARTICLES = builder("particles", IParameterType.BOOLEAN).build();

    /**
     * @return Parameter unique identifier
     */

    String id();

    /**
     * @return Parameter unique key
     */

    IKey key();

    /**
     * @return Parameter type
     */

    IParameterType<T> type();

    /**
     * @return Parameter default values
     */

    List<String> defaults();

    /**
     * Parses a string value into the parameter type.
     *
     * @param value value to parse
     * @return Parsed value
     */

    T parse(String value);

    /**
     * Validates a value for the parameter type.
     *
     * @param value value to validate
     * @return {@code true} if the value is valid
     */

    boolean valid(Object value);

    /**
     * Replaces placeholders in an item builder with the parameter value.
     *
     * @param builder item builder
     * @param value   parameter value
     */

    void replace(ItemBuilder builder, Object value);

    /**
     * @return Parameter fallback value
     */

    T fallback();

    /**
     * Reads the parameter value from a persistent data container.
     *
     * @param container persistent data container
     * @return Parameter value
     */

    T read(PersistentDataContainer container);

    /**
     * Writes the parameter value to a persistent data container.
     *
     * @param container persistent data container
     * @param value     parameter value
     */

    void write(PersistentDataContainer container, Object value);

}
