package mc.rellox.spawnerlegacyapi.modifier;

import org.bukkit.NamespacedKey;

import mc.rellox.spawnerlegacyapi.item.IItemConstant;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;
import mc.rellox.spawnerlegacyapi.modifier.effect.ModifierEffectType;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface IModifier {
	
	/**
	 * @return Modifier key
	 */
	
	String key();
	
	/**
	 * @return Modifier display name
	 */
	
	IContent display();
	
	/**
	 * @return Namespaced key of this modifier
	 */
	
	NamespacedKey namespaced();
	
	/**
	 * @return Modifier requirements
	 */
	
	IModifierRequirements requirements();
	
	/**
	 * @return Modifier effect
	 */
	
	IEffect effect();
	
	/**
	 * @return Modifier item
	 */
	
	IItemConstant item();
	
	/**
	 * @return Modifier effect type
	 */
	
	default ModifierEffectType type() {
		return effect().type();
	}

}
