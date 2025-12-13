package mc.rellox.spawnerlegacyapi.entity.state;

import org.bukkit.DyeColor;
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
	
	/**
	 * @param stacked - stacked entity
	 * @return {@code true} if this state was applied to the entity
	 */
	
	default boolean apply(IStackedEntity stacked) {
		return apply(stacked.entity());
	}
	
	/**
	 * @param entity - entity
	 * @return {@code true} if this state was applied to the entity
	 */
	
	boolean apply(LivingEntity entity);
	
	interface ISlimeSizeState extends IEntityState {
		
		/**
		 * @return Slime size
		 */
		
		int size();
		
	}
	
	interface IColorableState extends IEntityState {
		
		/**
		 * @return Color
		 */
		
		DyeColor color();
		
	}
	
	interface IAgeableState extends IEntityState {
		
		/**
		 * @return {@code true} if the entity is an adult
		 */
		
		boolean adult();
		
		/**
		 * @return {@code true} if the entity is a baby
		 */
		
		default boolean baby() {
			return !adult();
		}
		
	}
	
	interface IChargedState extends IEntityState {
		
		/**
		 * @return {@code true} if the entity is charged, applies to Creepers
		 */
		
		boolean charged();
		
	}

}
