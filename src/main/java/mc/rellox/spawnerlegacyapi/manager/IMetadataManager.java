package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITraitBuilder;

public interface IMetadataManager {

    /**
     * @param id trait identifier
     * @return New trait builder
     */

    ITraitBuilder builder(String id);

}
