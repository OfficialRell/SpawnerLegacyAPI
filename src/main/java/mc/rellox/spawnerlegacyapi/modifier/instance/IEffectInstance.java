package mc.rellox.spawnerlegacyapi.modifier.instance;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.modifier.IModifierDefinition;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;
import org.bukkit.persistence.PersistentDataContainer;

/**
 * Represents a modifier item that is inserted into spawner upgrade menu.
 *
 * @param <E> effect type
 */

public interface IEffectInstance<E extends IEffect> {

    /**
     * @return Modifier
     */

    IModifierDefinition definition();

    /**
     * @return Modifier instance
     */

    IModifierInstance instance();

    /**
     * @return Modifier effect
     */

    E effect();

    /**
     * Write all data to the specified persistent data container.
     *
     * @param container container
     */

    void write(PersistentDataContainer container);

    /**
     * Inserts all modifier values into the specified item builders placeholders.
     *
     * @param builder item builder
     */

    void replace(ItemBuilder builder);

}
