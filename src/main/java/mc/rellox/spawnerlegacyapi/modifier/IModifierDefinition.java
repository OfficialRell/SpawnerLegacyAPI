package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.item.IItemConstant;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffectDefinition;
import mc.rellox.spawnerlegacyapi.modifier.requirement.IRequirement;
import mc.rellox.spawnerlegacyapi.registry.IKey;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

import java.util.List;

public interface IModifierDefinition {

    /**
     * @return Unique identifier
     */

    String id();

    /**
     * @return Unique key (NamespacedKey)
     */

    IKey key();

    /**
     * @return Display content
     */

    IContent display();

    /**
     * @return Effect definition
     */

    IEffectDefinition effect();

    /**
     * @return Item constant
     */

    IItemConstant item();

    /**
     * @return List of requirements
     */

    List<IRequirement> requirements();

}
