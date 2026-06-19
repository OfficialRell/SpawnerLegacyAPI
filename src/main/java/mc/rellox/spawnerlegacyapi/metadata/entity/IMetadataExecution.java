package mc.rellox.spawnerlegacyapi.metadata.entity;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITraitExecution;

import java.util.List;

public interface IMetadataExecution {

    /**
     * @return The metadata that was executed
     */

    IEntityMetadata meta();

    /**
     * @return The trait execution results
     */

    List<ITraitExecution> executions();

    /**
     * @return If at least one trait execution was successful
     */

    default boolean success() {
        return executions().stream().anyMatch(ITraitExecution::success);
    }

}