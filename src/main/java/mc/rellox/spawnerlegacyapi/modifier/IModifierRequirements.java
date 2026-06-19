package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.Set;

public interface IModifierRequirements {

    /**
     * @return Required spawner level to work
     */

    int level();

    /**
     * Only will work on spawner who are in this list,
     * or is not if {@link #invert} is true.
     *
     * @return Spawner type set
     */

    Set<SpawnerType> types();

    /**
     * @return Should invert the type list check
     */

    boolean invert();

    /**
     * @param type type
     * @return If this type is allowed
     */

    default boolean allow(SpawnerType type) {
        var types = types();
        return types.isEmpty() || types().contains(type) ^ invert();
    }

}
