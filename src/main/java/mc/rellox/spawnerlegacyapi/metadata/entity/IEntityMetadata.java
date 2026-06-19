package mc.rellox.spawnerlegacyapi.metadata.entity;

import mc.rellox.spawnerlegacyapi.metadata.IMetadata;
import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITrait;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import org.bukkit.entity.Entity;

import java.util.List;

public interface IEntityMetadata extends IMetadata {

    /**
     * Applies all traits to the given list of entities.
     *
     * @param generator generator
     * @param entities  list of entities
     * @return Execution result
     */

    IMetadataExecution apply(IGenerator generator, List<Entity> entities);

    /**
     * @return Metadata applicability predicate
     */

    IMetadataApplicable applicable();

    /**
     * @return List of traits
     */

    List<ITrait> traits();

}
