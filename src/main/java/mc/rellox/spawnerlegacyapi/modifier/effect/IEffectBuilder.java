package mc.rellox.spawnerlegacyapi.modifier.effect;

import mc.rellox.spawnerlegacyapi.configuration.IMemory;

import java.util.function.Function;
import java.util.function.Predicate;

public interface IEffectBuilder {

    /**
     * Sets the effect to be executable only if the specified predicate returns true.<br>
     * This predicate is called every time the effect is executed.
     *
     * @param predicate predicate to check
     * @return This builder
     */

    IEffectBuilder executable(Predicate<IEffectInstance> predicate);

    /**
     * Adds a value reader that is executed when an effect definition is created.
     *
     * @param id     value id
     * @param reader value reader
     * @param <T>    type of the value
     * @return This builder
     */

    <T> IEffectBuilder value(String id, Function<IMemory, T> reader);

    /**
     * Adds an executor to this effect builder.
     *
     * @param clazz    executor class
     * @param executor executor instance
     * @param <T>      type of the executor
     * @return This builder
     * @throws IllegalArgumentException if the executor is not a direct subclass of {@link IEffectExecutor}
     */

    <T extends IEffectExecutor> IEffectBuilder executor(Class<T> clazz, T executor);

    /**
     * Registers this effect builder.
     */

    void register();

}
