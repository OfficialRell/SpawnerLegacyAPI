package mc.rellox.spawnerlegacyapi.modifier.effect;

import mc.rellox.spawnerlegacyapi.spawner.cache.IUpgradeValues;
import org.bukkit.entity.LivingEntity;

public sealed interface IEffectExecutor
        permits IEffectExecutor.IEffectExecutorEntity, IEffectExecutor.IEffectExecutorUpgrades {

    non-sealed interface IEffectExecutorEntity extends IEffectExecutor {

        void execute(IEffectInstance instance, LivingEntity entity);

    }

    non-sealed interface IEffectExecutorUpgrades extends IEffectExecutor {

        void execute(IEffectInstance instance, IUpgradeValues values);

    }

}
