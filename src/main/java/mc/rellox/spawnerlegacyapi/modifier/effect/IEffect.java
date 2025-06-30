package mc.rellox.spawnerlegacyapi.modifier.effect;

import org.bukkit.potion.PotionEffectType;

import mc.rellox.spawnerlegacyapi.spawner.type.UpgradeType;

public interface IEffect {

	/**
	 * @return Modifier effect type
	 */

	ModifierEffectType type();

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

	interface IEffectGivePotion extends IEffectEvaluate {

		@Override
		default ModifierEffectType type() {
			return ModifierEffectType.GIVE_POTION;
		}

		/**
		 * @return Potion effect type
		 */

		PotionEffectType potion();

	}

}
