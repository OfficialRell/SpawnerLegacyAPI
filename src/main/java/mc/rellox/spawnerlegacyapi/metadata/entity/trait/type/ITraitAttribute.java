package mc.rellox.spawnerlegacyapi.metadata.entity.trait.type;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITrait;
import mc.rellox.spawnerlegacyapi.utility.IShift;
import org.bukkit.attribute.Attribute;

public interface ITraitAttribute extends ITrait {

    /**
     * @return Attribute to modify
     */

    Attribute attribute();

    /**
     * @return Value changes to apply to the attribute
     */

    IShift shift();

}
