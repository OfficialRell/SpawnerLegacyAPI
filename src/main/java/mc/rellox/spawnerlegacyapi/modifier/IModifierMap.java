package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.modifier.effect.IEffectExecutor;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffectInstance;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

import java.util.List;
import java.util.function.BiConsumer;

public interface IModifierMap {

    /**
     * @return Generator
     */

    IGenerator generator();

    /**
     * @return Copy of the list of all modifier instances
     */

    List<IModifierInstance> modifiers();

    /**
     * @param modifier modifier
     * @return {@code true} if a modifier instance with the specified modifier exists
     */

    boolean exists(IModifierDefinition modifier);

    /**
     * Adds a modifier instance to this generator.
     *
     * @param instance modifier instance
     * @throws IllegalArgumentException if an instance with the same
     *                                  modifier already exists
     * @throws IllegalStateException    if the specified modifier is attached
     *                                  to a different generator
     *
     */

    void add(IModifierInstance instance);

    /**
     * Removes this modifier instance from the generator.
     *
     * @param instance modifier instance
     */

    void remove(IModifierInstance instance);

    /**
     * @param clazz executor class
     * @return {@code true} if an effect instance with the specified executor class exists
     */

    boolean has(Class<? extends IEffectExecutor> clazz);

    /**
     * Runs the action for all matching executor type classes.
     *
     * @param <E>    executor type
     * @param clazz  executor class
     * @param action action to perform
     */

    <E extends IEffectExecutor> void execute(Class<E> clazz, BiConsumer<IEffectInstance, E> action);

}
