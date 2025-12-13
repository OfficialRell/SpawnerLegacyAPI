package mc.rellox.spawnerlegacyapi.entity.state;

import org.bukkit.entity.LivingEntity;

import mc.rellox.spawnerlegacyapi.entity.IStackedEntity;

public interface IEntityState {
	
	/**
	 * @param stacked - stacked entity
	 * @return {@code true} if the entity has this state
	 */
	
	default boolean match(IStackedEntity stacked) {
		return match(stacked.entity());
	}
	
	/**
	 * @param entity - entity
	 * @return {@code true} if the entity has this state
	 */
	
	boolean match(LivingEntity entity);

}
