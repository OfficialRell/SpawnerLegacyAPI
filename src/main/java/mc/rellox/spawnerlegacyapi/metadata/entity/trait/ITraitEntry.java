package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import org.bukkit.entity.Entity;

public interface ITraitEntry {

    /**
     * @return Index of this entry in the list of entities
     */

    int index();

    /**
     * @return Total number of entities in the list
     */

    int total();

    /**
     * @return Original entity before applying the trait
     */

    Entity original();

    /**
     * Most traits will not change the entity, they both will be the same.
     *
     * @return Entity after applying the trait
     */

    Entity current();

    /**
     * Replaces the original entity with the given entity.<br>
     * This will also replace the entity in the spawned entity list.
     *
     * @param entity entity to set as current
     */

    void current(Entity entity);

    /**
     * Creates a new {@link ITraitResult} with the given success value.
     *
     * @param success whether the trait was successfully applied
     * @return Result instance
     */

    ITraitResult result(boolean success);

    /**
     * @return Successful result instance
     */

    default ITraitResult success() {
        return result(true);
    }

    /**
     * @return Failed result instance
     */

    default ITraitResult failure() {
        return result(false);
    }

}
