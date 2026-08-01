package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.modifier.effect.parameter.IParameterMap;
import org.bukkit.persistence.PersistentDataContainer;

public interface IModifierHandler {

    IModifierData create();

    IModifierData load(PersistentDataContainer container, IParameterMap parameters);

    void save(PersistentDataContainer container, IModifierData data, IParameterMap parameters);

    void apply(IModifierContext context);

    void reduce(IModifierContext context);

    boolean active(IModifierContext context);

}

