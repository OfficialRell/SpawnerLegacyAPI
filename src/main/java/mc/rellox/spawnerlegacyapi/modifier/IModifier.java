package mc.rellox.spawnerlegacyapi.modifier;

import mc.rellox.spawnerlegacyapi.item.IItemConstant;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;

public interface IModifier {
	
	/**
	 * @return Modifier key
	 */
	
	String key();
	
	/**
	 * @return Modifier requirements
	 */
	
	IModifierRequirements requirements();
	
	/**
	 * @return Modifier effect
	 */
	
	IEffect effect();
	
	/**
	 * @return Default modifier usage
	 */
	
	int usage();
	
	/**
	 * @return Activation chance
	 */
	
	int chance();
	
	/**
	 * @return Modifier item
	 */
	
	IItemConstant item();

}
