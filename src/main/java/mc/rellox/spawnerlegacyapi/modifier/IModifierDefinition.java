package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.item.IItemConstant;
import mc.rellox.spawnerlegacyapi.modifier.effect.parameter.IParameterMap;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import org.bukkit.NamespacedKey;

public interface IModifierDefinition {

    String key();

    NamespacedKey namespaced();

    IContent display();

    IModifierRequirements requirements();

    IParameterMap parameters();

    IModifierHandler handler();

    IItemConstant item();

}

