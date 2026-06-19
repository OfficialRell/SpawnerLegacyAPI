package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import mc.rellox.spawnerlegacyapi.utility.IChance;
import mc.rellox.spawnerlegacyapi.utility.ILimit;

import java.util.Map;

public interface ITraitBuilder {

    /**
     * Reads the values from the configuration map and creates a new trait instance.
     *
     * @param data trait data
     * @param map  trait configuration map
     * @return Newly created trait
     * @throws RuntimeException if the trait could not be created
     */

    ITrait build(TraitData data, Map<?, ?> map);

    record TraitData(String id,
                     IChance chance,
                     ILimit limit,
                     ITraitChain chain) {
    }

}
