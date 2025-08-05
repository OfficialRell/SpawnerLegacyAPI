package mc.rellox.spawnerlegacyapi.modifier.executor;

import org.bukkit.entity.LivingEntity;

public interface IExecutor {
	
	interface IExecutorEntity extends IExecutor {
		
		boolean activate();
		
		void execute(LivingEntity entity);
		
		void reduce();
		
	}
	
	interface IExecutorUpgrades extends IExecutor {
		
		void execute(int[] values);
		
	}

}
