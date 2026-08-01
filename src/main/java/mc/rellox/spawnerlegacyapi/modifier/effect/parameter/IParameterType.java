package mc.rellox.spawnerlegacyapi.modifier.effect.parameter;

import org.bukkit.persistence.PersistentDataType;

public interface IParameterType<T> {

    PersistentDataType<?, T> type();

    T empty();

}

