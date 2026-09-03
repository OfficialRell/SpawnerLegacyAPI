package mc.rellox.spawnerlegacyapi.modifier.parameter;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Set;

public interface IParameterMap {

    /**
     * @return Immutable set of all parameters
     */

    Set<IParameter<?>> parameters();

    /**
     * @param parameter parameter
     * @param <T>       parameter type
     * @return Value of the parameter, or {@code null} if not set
     */

    <T> T get(IParameter<T> parameter);

    /**
     * Sets the value of a parameter.
     *
     * @param parameter parameter
     * @param value     value to set
     */

    void set(IParameter<?> parameter, Object value);

    /**
     * Writes all parameter values to a persistent data container.
     *
     * @param container persistent data container
     */

    void save(PersistentDataContainer container);

    /**
     * Replaces all parameter placeholders with parameter values in an item builder.
     *
     * @param builder item builder
     */

    void replace(ItemBuilder builder);

}
