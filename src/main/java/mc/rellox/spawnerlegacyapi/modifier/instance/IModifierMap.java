package mc.rellox.spawnerlegacyapi.modifier.instance;

import java.util.List;
import java.util.Map;

import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IModifierMap {
	
	/**
	 * @return Generator
	 */
	
	IGenerator generator();
	
	/**
	 * @return List of all modifier instances
	 */
	
	List<IModifierInstance> modifiers();
	
	/**
	 * Adds a modifier instance to this generator.
	 * 
	 * @param instance - modifier instance
	 */
	
	void add(IModifierInstance instance);
	
	/**
	 * Removes this modifier instance from the generator.
	 * 
	 * @param instance - modifier instance
	 */
	
	void remove(IModifierInstance instance);
	
	/**
	 * Returns a map for all modifier instance and effect that match the specified class.
	 * 
	 * @param <E> - effect instance type
	 * @param clazz - effect instance class
	 * @return Modifier instance and effect map
	 */
	
	<E extends IEffectInstance<? extends IEffect>> Map<IModifierInstance, List<E>> find(Class<E> clazz);

}
