package mc.rellox.spawnerlegacyapi.metadata.entity.trait.trigger;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITrait;
import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITraitEntry;
import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITraitResult;

public interface ITriggerContext {

    /**
     * @return Trait that was applied
     */

    ITrait trait();

    /**
     * @return Trait result after application
     */

    ITraitResult result();

    /**
     * @return Trait entry that was applied
     */

    ITraitEntry entry();

    /**
     * @return Index of the trait entry
     */

    default int index() {
        return entry().index();
    }

}
