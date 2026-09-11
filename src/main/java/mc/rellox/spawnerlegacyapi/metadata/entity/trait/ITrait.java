package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.utility.IChance;
import mc.rellox.spawnerlegacyapi.utility.ILimit;
import org.bukkit.entity.Entity;

import java.util.List;

public interface ITrait {

    static ITraitBuilder builder(String id) {
        return SLAPI.metadata().builder(id);
    }

    /**
     * @return Trait identifier
     */

    String id();

    /**
     * @return Trait definition
     */

    ITraitDefinition definition();

    /**
     * @return Trait execution chance
     */

    IChance chance();

    /**
     * @return Limit of how many times this trait can be applied
     */

    ILimit limit();

    /**
     * @return Traits to execute after
     */

    ITraitChain chain();

    /**
     * Applies the trait to the entities.
     *
     * @param context  trait context
     * @param entities entities to affect
     * @return Trait execution result
     */

    ITraitExecution apply(ITraitContext context, List<Entity> entities);

    /**
     * Applies the trait to a single entity (trait entry).
     *
     * @param context trait context
     * @param entry   trait entry
     * @return Trait entry execution result
     */

    ITraitResult apply(ITraitContext context, ITraitEntry entry);

}
