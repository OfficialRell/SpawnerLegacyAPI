package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.item.IItemConstant;
import mc.rellox.spawnerlegacyapi.modifier.effect.parameter.IParameterMap;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import org.bukkit.NamespacedKey;

public interface IModifierBuilder {

    IModifierBuilder key(String key);

    IModifierBuilder namespaced(NamespacedKey namespaced);

    IModifierBuilder display(IContent display);

    IModifierBuilder requirements(IModifierRequirements requirements);

    IModifierBuilder parameters(IParameterMap parameters);

    IModifierBuilder handler(IModifierHandler handler);

    IModifierBuilder item(IItemConstant item);

    IModifierDefinition build();

}

