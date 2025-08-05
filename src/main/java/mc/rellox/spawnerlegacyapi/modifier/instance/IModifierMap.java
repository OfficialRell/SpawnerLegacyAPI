package mc.rellox.spawnerlegacyapi.modifier.instance;

import java.util.List;
import java.util.function.Consumer;

import mc.rellox.spawnerlegacyapi.modifier.IModifier;
import mc.rellox.spawnerlegacyapi.modifier.executor.IExecutor;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IModifierMap {
	
	/**
	 * @return Generator
	 */
	
	IGenerator generator();
	
	/**
	 * @return Copy of the list of all modifier instances
	 */
	
	List<IModifierInstance> modifiers();
	
	/**
	 * @param modifier - modifier
	 * @return {@code true} if a modifier instance with the specified modifier exists
	 */
	
	boolean exists(IModifier modifier);
	
	/**
	 * Adds a modifier instance to this generator.
	 * 
	 * @param instance - modifier instance
	 * 
	 * @throws IllegalArgumentException if an instance with the same
	 * modifier already exists
	 * @throws IllegalStateException if the specified modifier is attached
	 * to a different generator
	 * 
	 */
	
	void add(IModifierInstance instance);
	
	/**
	 * Removes this modifier instance from the generator.
	 * 
	 * @param instance - modifier instance
	 */
	
	void remove(IModifierInstance instance);
	
	/**
	 * Runs the action for all matching executor type classes.
	 * 
	 * @param <E> - executor type
	 * @param clazz - executor class
	 * @param action - action to perform
	 */
	
	<E extends IExecutor> void execute(Class<E> clazz, Consumer<E> action);
	
//	/**
//	 * Returns a map for all modifier instance and effect that match the specified class.
//	 * 
//	 * @param <E> - effect instance type
//	 * @param clazz - effect instance class
//	 * @return Modifier instance and effect map
//	 */
//	
//	<E extends IEffectInstance<? extends IEffect>> Map<IModifierInstance, List<E>> find(Class<E> clazz);

}
