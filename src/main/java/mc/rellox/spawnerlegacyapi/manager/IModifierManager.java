package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;

import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.modifier.IModifier;
import mc.rellox.spawnerlegacyapi.modifier.instance.IModifierInstance;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IModifierManager {
	
	/**
	 * @param key - key
	 * @return Modifier by the specified key or {@code null}
	 */
	
	IModifier of(String key);
	
	/**
	 * @return List of all existing modifiers
	 */
	
	List<IModifier> all();
	
	/**
	 * Tries to load the modifier instance specified by the modifier from this generator.
	 * 
	 * @param generator - generator
	 * @param modifier - modifier
	 * @return Modifier instance or {@code null}
	 */
	
	IModifierInstance load(IGenerator generator, IModifier modifier);
	
	/**
	 * Loads all modifier instances saved on the specified generator.
	 * 
	 * @param generator - generator
	 * @return List of all saved modifier instances
	 */
	
	List<IModifierInstance> load(IGenerator generator);
	
	/**
	 * Saves all modifier instance values.
	 * 
	 * @param instance - instance
	 */
	
	void save(IModifierInstance instance);
	
	/**
	 * Removes the modifier instance specified by the modifier.
	 * 
	 * @param generator - generator
	 * @param modifier - modifier
	 */
	
	void remove(IGenerator generator, IModifier modifier);
	
	/**
	 * Removes the modifier instance.
	 * 
	 * @param instance - instance
	 */
	
	void remove(IModifierInstance instance);
	
	/**
	 * @param instance - instance
	 * @return Item stack with data about the modifier instance
	 */
	
	ItemStack item(IModifierInstance instance);
	
	/**
	 * Gets the modifier of the specified item or {@code null}
	 * if not a modifier item.
	 * 
	 * @param item - item
	 * @return Modifier from this item or {@code null}
	 */
	
	IModifier modifier(ItemStack item);
	
	/**
	 * Tries to read the modifier instance from the specified item.
	 * 
	 * @param item - item
	 * @return Modifier instance from this item or {@code null}
	 */
	
	IModifierInstance instance(ItemStack item);

}
