package mc.rellox.spawnerlegacyapi.metadata.entity.trait.type;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITrait;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ITraitTransform extends ITrait {

    /**
     * @return Type to transform into
     */

    SpawnerType to();

}
