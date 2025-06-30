package mc.rellox.spawnerlegacyapi.modifier.instance;

import org.bukkit.entity.LivingEntity;

import mc.rellox.spawnerlegacyapi.modifier.IModifier;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectEvaluateDamage;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectEvaluateHealth;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectEvaluateUpgrade;
import mc.rellox.spawnerlegacyapi.modifier.effect.IEffect.IEffectGivePotion;

public interface IEffectInstance<E extends IEffect> {
	
	IModifier modifier();
	
	E effect();
	
	interface IEffectInstanceEvaluateEntity<E extends IEffect> extends IEffectInstance<E> {
		
		void modify(LivingEntity entity);
	}
	
	interface IEffectInstanceEvaluateHealth extends IEffectInstanceEvaluateEntity<IEffectEvaluateHealth> {
		
		double value();
		
	}
	
	interface IEffectInstanceEvaluateDamage extends IEffectInstanceEvaluateEntity<IEffectEvaluateDamage> {
		
		double value();
		
	}
	
	interface IEffectInstanceEvaluateUpgrade extends IEffectInstance<IEffectEvaluateUpgrade> {
		
		double value();
		
		double modify(double input);
		
	}
	
	interface IEffectInstanceGivePotion extends IEffectInstance<IEffectGivePotion> {
		
		int duration();
		
		int aplifier();
		
		void modify(LivingEntity entity);
		
	}
	
}
