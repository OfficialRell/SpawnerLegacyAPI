package mc.rellox.spawnerlegacyapi.modifier.effect;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.modifier.IModifierInstance;
import mc.rellox.spawnerlegacyapi.modifier.parameter.IParameter;
import mc.rellox.spawnerlegacyapi.modifier.parameter.IParameterMap;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

import java.util.Objects;

public interface IEffectInstance {

    /**
     * @return Effect definition of this instance
     */

    IEffectDefinition definition();

    /**
     * @return Modifier instance
     */

    IModifierInstance modifier();

    /**
     * @return Parameter map
     */

    IParameterMap parameters();

    /**
     * @param clazz executor class
     * @param <T>   executor type
     * @return Executor or {@code null} if not found
     */

    <T extends IEffectExecutor> T executor(Class<T> clazz);

    /**
     * @param parameter parameter
     * @param <T>       parameter type
     * @return Parameter value or {@code null} if not found
     */

    default <T> T get(IParameter<T> parameter) {
        Objects.requireNonNull(parameter, "parameter cannot be null");
        return parameters().get(parameter);
    }

    /**
     * @param parameter parameter
     * @param value     value to set
     * @param <T>       parameter type
     */

    default <T> void set(IParameter<T> parameter, T value) {
        Objects.requireNonNull(parameter, "parameter cannot be null");
        parameters().set(parameter, value);
    }

    /**
     * Replaces all placeholders in the item builder for each parameter.
     *
     * @param builder builder
     */

    default void replace(ItemBuilder builder) {
        Objects.requireNonNull(builder, "builder cannot be null");
        parameters().replace(builder);
    }

    /**
     * @return Generator or {@code null} if not connected to a generator
     */

    default IGenerator generator() {
        return modifier().generator();
    }

    /**
     * Saves the modifier instance to the generator.
     */

    default void save() {
        modifier().save();
    }

    /**
     * @return Usage of this effect instance if enabled
     */

    int usage();

    /**
     * Reduces the usage of this effect instance by the specified amount if available.
     *
     * @param amount amount to reduce
     */

    void reduce(int amount);

    /**
     * Reduces the usage of this effect instance by 1 if available.
     */

    default void reduce() {
        reduce(1);
    }

    /**
     * @return Chance if enabled or 100.0 if not enabled
     */

    double chance();

    /**
     * Rolls the chance of this effect instance and returns {@code true} if successful.
     *
     * @return {@code true} if successful
     */

    boolean roll();

    /**
     * @return {@code true} if this effect instance is executable
     */

    boolean executable();

}
