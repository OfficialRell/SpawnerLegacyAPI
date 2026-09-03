package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffectInstance;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import org.bukkit.inventory.ItemStack;

public interface IModifierInstance {

    /**
     * @return Modifier definition of this instance
     */

    IModifierDefinition definition();

    /**
     * @return Effect instance of this instance
     */

    IEffectInstance effect();

    /**
     * @return Generator or {@code null} if this modifier instance is not connected to a generator
     */

    IGenerator generator();

    /**
     * @return {@code true} if this modifier instance is connected to a generator
     */

    default boolean connected() {
        return generator() != null;
    }

    /**
     * Saves this modifier instance to the generator it is connected to.
     *
     * @throws IllegalStateException if this modifier instance is not connected to a generator
     */

    void save();

    /**
     * Will return {@code false} if this modifier has reached 0 usage,
     * otherwise {@code true}.
     *
     * @return {@code true} if this modifier still has usage
     */

    boolean active();

    /**
     * @return {@code true} if this modifier has run out of usage
     */

    default boolean inactive() {
        return !active();
    }

    /**
     * @return The item of this modifier instance
     */

    default ItemStack item() {
        return SLAPI.modifiers().item(this);
    }

}
