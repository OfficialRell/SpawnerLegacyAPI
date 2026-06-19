package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import java.util.List;

public interface ITraitExecution {

    /**
     * @return Trait that was executed
     */

    ITrait trait();

    /**
     * @return Total number of entities the trait was attempted to be applied to
     */

    int attempted();

    /**
     * @return Number of entities the trait was successfully applied to
     */

    int succeeded();

    /**
     * @return List of all results for each entity the trait was applied to
     */

    List<ITraitResult> results();

    /**
     * @return Whether the trait was successfully applied to at least one entity
     */

    default boolean success() {
        return succeeded() > 0;
    }

}
