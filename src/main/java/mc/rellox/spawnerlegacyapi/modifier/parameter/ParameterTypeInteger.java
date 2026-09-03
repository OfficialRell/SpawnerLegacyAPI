package mc.rellox.spawnerlegacyapi.modifier.parameter;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ParameterTypeInteger implements IParameterType<Integer> {

    @Override
    public Integer parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch(NumberFormatException e) {
            return null;
        }
    }

    @Override
    public boolean valid(Object value) {
        return value instanceof Integer;
    }

    @Override
    public void replace(ItemBuilder builder, String placeholder, Object value) {
        if(value instanceof Integer i)
            builder.replace(placeholder, i);
    }

    @Override
    public Integer read(PersistentDataContainer container, NamespacedKey key, Integer fallback) {
        return container.getOrDefault(key, PersistentDataType.INTEGER, fallback);
    }

    @Override
    public void write(PersistentDataContainer container, NamespacedKey key, Object value) {
        if(value instanceof Integer i)
            container.set(key, PersistentDataType.INTEGER, i);
    }

    @Override
    public Integer fallback() {
        return 0;
    }
}
