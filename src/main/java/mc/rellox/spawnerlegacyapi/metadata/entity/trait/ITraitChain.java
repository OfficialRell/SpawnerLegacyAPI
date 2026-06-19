package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.trigger.ITrigger;

import java.util.List;

public interface ITraitChain {

    /**
     * @return Trigger that activates the chain
     */

    ITrigger trigger();

    /**
     * @return List of traits that will be executed when the trigger is activated
     */

    List<ITrait> traits();

    /**
     * @return Whether the chain is empty (has no traits)
     */

    boolean empty();

}