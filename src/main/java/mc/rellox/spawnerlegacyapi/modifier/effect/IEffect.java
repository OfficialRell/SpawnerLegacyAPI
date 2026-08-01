package mc.rellox.spawnerlegacyapi.modifier.effect;

import mc.rellox.spawnerlegacyapi.modifier.effect.parameter.IParameterMap;
import mc.rellox.spawnerlegacyapi.modifier.instance.IEffectInstance;
import mc.rellox.spawnerlegacyapi.modifier.instance.IModifierInstance;
import org.bukkit.persistence.PersistentDataContainer;

public interface IEffect {

    /**
     * @return Modifier effect type
     */

    ModifierEffectType type();

    /**
     * Reads the modifier effect instance from the specified persistent data container.
     *
     * @param instance  instance
     * @param container container
     * @return Modifier effect instance
     */

    IEffectInstance<? extends IEffect> read(IModifierInstance instance, PersistentDataContainer container);

    /**
     * @return Required effect parameters
     */

    IParameterMap parameters();

}
