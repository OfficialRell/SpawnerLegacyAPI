package mc.rellox.spawnerlegacyapi.metadata.entity;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.Set;

public interface IMetadataApplicable {

    static IMetadataApplicable any() {
        return type -> true;
    }

    static IMetadataApplicable include(Set<SpawnerType> types) {
        return types::contains;
    }

    static IMetadataApplicable exclude(Set<SpawnerType> types) {
        return type -> !types.contains(type);
    }

    /**
     * @param type type to test
     * @return Whether this metadata is applicable to the given spawner type
     */

    boolean allow(SpawnerType type);

}
