package mc.rellox.spawnerlegacyapi.modifier.parameter;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ParameterTypeDouble implements IParameterType<Double> {

    @Override
    public Double parse(String value) {
        try {
            return Double.parseDouble(value);
        } catch(NumberFormatException e) {
            return null;
        }
    }

    @Override
    public boolean valid(Object value) {
        return value instanceof Double;
    }

    @Override
    public void replace(ItemBuilder builder, String placeholder, Object value) {
        if(value instanceof Double d)
            builder.replace(placeholder, d);
    }

    @Override
    public Double read(PersistentDataContainer container, NamespacedKey key, Double fallback) {
        return container.getOrDefault(key, PersistentDataType.DOUBLE, fallback);
    }

    @Override
    public void write(PersistentDataContainer container, NamespacedKey key, Object value) {
        if(value instanceof Double d)
            container.set(key, PersistentDataType.DOUBLE, d);
    }

    @Override
    public Double fallback() {
        return 0.0;
    }
}
