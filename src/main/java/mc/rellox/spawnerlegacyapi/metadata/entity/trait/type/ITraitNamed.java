package mc.rellox.spawnerlegacyapi.metadata.entity.trait.type;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITrait;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface ITraitNamed extends ITrait {

    /**
     * @return Name to set to the entity
     */

    IContent name();

    /**
     * @return Whether the name is visible
     */

    boolean visible();

}
