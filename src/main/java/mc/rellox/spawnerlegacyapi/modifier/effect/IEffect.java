package mc.rellox.spawnerlegacyapi.modifier.effect;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffectType;

import mc.rellox.spawnerlegacyapi.modifier.effect.parameter.IParameterMap;
import mc.rellox.spawnerlegacyapi.modifier.instance.IEffectInstance;
import mc.rellox.spawnerlegacyapi.modifier.instance.IModifierInstance;
import mc.rellox.spawnerlegacyapi.spawner.type.UpgradeType;

public interface IEffect {

	/**
	 * @return Modifier effect type
	 */

	ModifierEffectType type();
	
	/**
	 * Reads the modifier effect instance from the specified persistent data container.
	 * 
	 * @param instance - instance
	 * @param container - container
	 * @return Modifier effect instance
	 */
	
	IEffectInstance<? extends IEffect> read(IModifierInstance instance, PersistentDataContainer container);
	
	/**
	 * @return Required effect parameters
	 */
	
	IParameterMap parameters();

	interface IEffectEvaluate extends IEffect {

		/**
		 * @return Evaluation type
		 */

		EvaluateType evaluate();
	}

	interface IEffectEvaluateDamage extends IEffectEvaluate {

		@Override
		default ModifierEffectType type() {
			return ModifierEffectType.EVALUATE_DAMAGE;
		}

	}

	interface IEffectEvaluateHealth extends IEffectEvaluate {

		@Override
		default ModifierEffectType type() {
			return ModifierEffectType.EVALUATE_HEALTH;
		}

	}

	interface IEffectEvaluateUpgrade extends IEffectEvaluate {

		@Override
		default ModifierEffectType type() {
			return ModifierEffectType.EVALUATE_UPGRADE;
		}

		/**
		 * @return Upgrade type
		 */

		UpgradeType upgrade();

	}

	interface IEffectGivePotion extends IEffect {

		@Override
		default ModifierEffectType type() {
			return ModifierEffectType.GIVE_POTION;
		}

		/**
		 * @return Potion effect type
		 */

		PotionEffectType potion();

	}
	
	interface IEffectEvaluateScale extends IEffectEvaluate {

		@Override
		default ModifierEffectType type() {
			return ModifierEffectType.EVALUATE_SCALE;
		}

	}

}
