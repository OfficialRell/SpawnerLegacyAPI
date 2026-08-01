package mc.rellox.spawnerlegacyapi.modifier;

import java.util.List;

public interface IModifierRegistry {

    IModifierBuilder builder();

    void register(IModifierDefinition definition);

    void unregister(String key);

    IModifierDefinition get(String key);

    List<IModifierDefinition> list();

    boolean has(String key);

}

