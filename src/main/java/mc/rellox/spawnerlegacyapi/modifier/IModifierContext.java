package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.modifier.instance.IModifierInstance;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IModifierContext {

    IGenerator generator();

    IModifierDefinition definition();

    IModifierInstance instance();

    IModifierData data();

    Object source();

}

