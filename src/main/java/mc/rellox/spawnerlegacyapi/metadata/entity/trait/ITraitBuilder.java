package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import mc.rellox.spawnerlegacyapi.configuration.IMemory;

import java.util.function.Function;

public interface ITraitBuilder {

    /**
     * Adds a value reader that is executed when a trait definition is created.
     *
     * @param id     value id
     * @param reader value reader
     * @param <T>    type of the value
     * @return This builder
     */

    <T> ITraitBuilder value(String id, Function<IMemory, T> reader);

    /**
     * Sets the executor to this trait builder.
     *
     * @param executor executor instance
     * @return This builder
     */

    ITraitBuilder executor(ITraitExecutor executor);

    /**
     * Registers this trait builder.
     */

    void register();

    interface ITraitExecutor {

        ITraitResult execute(ITraitDefinition definition, ITraitContext context, ITraitEntry entry);

    }

}
