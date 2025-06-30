package mc.rellox.spawnerlegacyapi.modifier.instance;

import java.util.List;

import mc.rellox.spawnerlegacyapi.modifier.IModifier;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IModifierInstance {
	
	/**
	 * @return Generator
	 */
	
	IGenerator generator();
	
	/**
	 * @return The modifier of this instance
	 */
	
	IModifier modifier();
	
	/**
	 * @return The modifier effect instance
	 */
	
	List<IEffectInstance<? extends IEffect>> effects();
	
	/**
	 * @return Current modifier usage
	 */
	
	int usage();
	
	/**
	 * Removed the specified modifier usage.
	 * 
	 * @param usage - usage to remove
	 */
	
	void reduce(int usage);

}
