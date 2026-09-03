package mc.rellox.spawnerlegacyapi.modifier.effect;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.modifier.IModifierInstance;
import mc.rellox.spawnerlegacyapi.modifier.parameter.IParameter;
import mc.rellox.spawnerlegacyapi.modifier.parameter.IParameterMap;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Map;
import java.util.Set;

public interface IEffectDefinition {

    static IEffectBuilder builder(String id, IParameter<?>... parameters) {
        return SLAPI.modifiers().builder(id, parameters);
    }

    /**
     * @return Unique effect identifier
     */

    String id();

    /**
     * @return Set of all effect parameters
     */

    Set<IParameter<?>> parameters();

    /**
     * @return Map of all read values
     */

    Map<String, Object> values();

    /**
     * @param id value identifier
     * @return {@code true} if the effect has the specified value by the identifier
     */

    boolean has(String id);

    /**
     * @param id  value identifier
     * @param <T> value type
     * @return Value by the specified identifier or {@code null}
     */

    <T> T value(String id);

    /**
     * Creates a new parameter map from the specified persistent data container.
     *
     * @param container persistent data container
     * @return New parameter map
     */

    IParameterMap map(PersistentDataContainer container);

    /**
     * Creates a new effect instance with the specified modifier and parameters.
     *
     * @param modifier   modifier instance
     * @param parameters parameter map
     * @return New effect instance
     */

    IEffectInstance instance(IModifierInstance modifier, IParameterMap parameters);

}
