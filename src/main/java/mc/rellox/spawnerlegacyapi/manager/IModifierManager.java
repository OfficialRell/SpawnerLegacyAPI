package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.configuration.IMemory;
import mc.rellox.spawnerlegacyapi.modifier.IModifierDefinition;
import mc.rellox.spawnerlegacyapi.modifier.IModifierInstance;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffectBuilder;
import mc.rellox.spawnerlegacyapi.modifier.parameter.IParameter;
import mc.rellox.spawnerlegacyapi.modifier.parameter.IParameterBuilder;
import mc.rellox.spawnerlegacyapi.modifier.parameter.IParameterType;
import mc.rellox.spawnerlegacyapi.modifier.requirement.IRequirement;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Function;

public interface IModifierManager {

    /**
     * @param key key
     * @return Modifier by the specified key or {@code null}
     */

    IModifierDefinition of(String key);

    /**
     * @return List of all existing modifiers
     */

    List<IModifierDefinition> all();

    /**
     * Tries to load the modifier instance specified by the modifier from this generator.
     *
     * @param generator generator
     * @param modifier  modifier
     * @return Modifier instance or {@code null}
     */

    IModifierInstance load(IGenerator generator, IModifierDefinition modifier);

    /**
     * Loads all modifier instances saved on the specified generator.
     *
     * @param generator generator
     * @return List of all saved modifier instances
     */

    List<IModifierInstance> load(IGenerator generator);

    /**
     * Saves all modifier instance values.
     *
     * @param instance instance
     */

    void save(IModifierInstance instance);

    /**
     * Removes the modifier instance specified by the modifier.
     *
     * @param generator generator
     * @param modifier  modifier
     */

    void remove(IGenerator generator, IModifierDefinition modifier);

    /**
     * Removes the modifier instance.
     *
     * @param instance instance
     */

    void remove(IModifierInstance instance);

    /**
     * @param instance instance
     * @return Item stack with data about the modifier instance
     */

    ItemStack item(IModifierInstance instance);

    /**
     * Gets the modifier of the specified item or {@code null}
     * if not a modifier item.
     *
     * @param item item
     * @return Modifier from this item or {@code null}
     */

    IModifierDefinition modifier(ItemStack item);

    /**
     * Tries to read the modifier instance from the specified item.
     *
     * @param item item
     * @return Modifier instance from this item or {@code null}
     */

    IModifierInstance instance(ItemStack item);

    /**
     * Creates a new effect builder with the specified id and parameters.
     *
     * @param id         effect id
     * @param parameters effect parameters
     * @return Effect builder
     */

    IEffectBuilder builder(String id, IParameter<?>... parameters);

    /**
     * Creates a new parameter builder with the specified id and type.
     *
     * @param id   parameter id
     * @param type parameter type
     * @return Parameter builder
     */

    <T> IParameterBuilder<T> builder(String id, IParameterType<T> type);

    /**
     * Registers a new requirement builder.
     *
     * @param id      requirement builder id
     * @param builder requirement builder
     */

    void register(String id, Function<IMemory, IRequirement> builder);

}
