package mc.rellox.spawnerlegacyapi.modifier.instance;

import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.modifier.IModifier;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IModifierInstance {
	
	/**
	 * If this modifier instance is not applied to any generator
	 * then it will return {@code null}.
	 * 
	 * @return Generator or {@code null}
	 */
	
	IGenerator generator();
	
	/**
	 * @return {@code true} if this modifier instance is applied to a generator
	 */
	
	default boolean applied() {
		return generator() != null;
	}
	
	/**
	 * @return The modifier of this instance
	 */
	
	IModifier modifier();
	
	/**
	 * @return The modifier effect instance
	 */
	
	IEffectInstance<? extends IEffect> effect();
	
	/**
	 * @return Item stack with data about this modifier instance
	 */
	
	default ItemStack item() {
		return SLAPI.modifiers().item(this);
	}

}
