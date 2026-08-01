package mc.rellox.spawnerlegacyapi.modifier;

public interface IModifierDataBuilder {

    IModifierDataBuilder put(String key, Object value);

    IModifierData build();

}

