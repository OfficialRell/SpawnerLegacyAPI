package mc.rellox.spawnerlegacyapi.modifier.parameter;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ParameterTypeBoolean implements IParameterType<Boolean> {

    @Override
    public Boolean parse(String value) {
        return Boolean.parseBoolean(value);
    }

    @Override
    public boolean valid(Object value) {
        return value instanceof Boolean;
    }

    @Override
    public void replace(ItemBuilder builder, String placeholder, Object value) {
        if(value instanceof Boolean b)
            builder.replace(placeholder, b);
    }

    @Override
    public Boolean read(PersistentDataContainer container, NamespacedKey key, Boolean fallback) {
        return container.getOrDefault(key, PersistentDataType.BYTE, (byte) (fallback ? 1 : 0)) == 1;
    }

    @Override
    public void write(PersistentDataContainer container, NamespacedKey key, Object value) {
        if(value instanceof Boolean b)
            container.set(key, PersistentDataType.BYTE, (byte) (b ? 1 : 0));
    }

    @Override
    public Boolean fallback() {
        return false;
    }

    @Override
    public List<String> defaults() {
        return List.of("true", "false");
    }
}
