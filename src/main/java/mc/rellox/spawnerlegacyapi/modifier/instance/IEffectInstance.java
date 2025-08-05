package mc.rellox.spawnerlegacyapi.modifier.instance;

import org.bukkit.persistence.PersistentDataContainer;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.modifier.IModifier;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectEvaluateDamage;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectEvaluateHealth;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectEvaluateUpgrade;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectGivePotion;
import mc.rellox.spawnerlegacyapi.modifier.executor.IExecutor.IExecutorEntity;
import mc.rellox.spawnerlegacyapi.modifier.executor.IExecutor.IExecutorUpgrades;

/**
 * Represents an modifier item that is inserted into spawner upgrade menu.
 * 
 * @param <E> - effect type
 */

public interface IEffectInstance<E extends IEffect> {
	
	/**
	 * @return Modifier
	 */
	
	IModifier modifier();
	
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
	 * @param container - container
	 */
	
	void write(PersistentDataContainer container);
	
	/**
	 * Inserts all modifier values into the specified item builders placeholders.
	 * 
	 * @param builder - item builder
	 */
	
	void replace(ItemBuilder builder);
	
	interface IEffectInstanceEvaluateHealth extends IEffectInstance<IEffectEvaluateHealth>, IExecutorEntity {
		
		double value();
		
		int usage();
		
		double chance();
		
	}
	
	interface IEffectInstanceEvaluateDamage extends IEffectInstance<IEffectEvaluateDamage>, IExecutorEntity {
		
		double value();
		
		int usage();
		
		double chance();
		
	}
	
	interface IEffectInstanceEvaluateUpgrade extends IEffectInstance<IEffectEvaluateUpgrade>, IExecutorUpgrades {
		
		double value();
		
	}
	
	interface IEffectInstanceGivePotion extends IEffectInstance<IEffectGivePotion>, IExecutorEntity {
		
		int duration();
		
		int amplifier();
		
		int usage();
		
		double chance();
		
	}
	
}
