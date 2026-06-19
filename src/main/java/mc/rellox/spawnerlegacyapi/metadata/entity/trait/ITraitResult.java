package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import org.bukkit.entity.Entity;

public interface ITraitResult {

    /**
     * @return Trait that was executed
     */

    ITrait trait();

    /**
     * @return Entry that was executed
     */

    Entity original();

    /**
     * @return Current entity after execution, may be the same as original if not modified
     */

    Entity current();

    /**
     * @return Whether the trait was attempted to be applied
     */

    boolean attempted();

    /**
     * @return Whether the trait was successfully applied
     */

    boolean success();

    /**
     * @return Whether the trait chance to apply this trait was rolled successfully
     */

    boolean rolled();

    /**
     * @return Whether the trait was not applied due to reaching the limit for this trait
     */

    boolean limited();

}
