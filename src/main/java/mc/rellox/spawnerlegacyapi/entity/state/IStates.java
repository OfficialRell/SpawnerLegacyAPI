package mc.rellox.spawnerlegacyapi.entity.state;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import mc.rellox.spawnerlegacyapi.entity.state.IEntityState.IAgeableState;
import mc.rellox.spawnerlegacyapi.entity.state.IEntityState.IChargedState;
import mc.rellox.spawnerlegacyapi.entity.state.IEntityState.IColorableState;
import mc.rellox.spawnerlegacyapi.entity.state.IEntityState.ISlimeSizeState;

public interface IStates {
	
	/**
	 * @param entity - entity
	 * @return Set of all states that the entity has
	 */
	
	default Set<IEntityState> get(Entity entity) {
		if(entity instanceof LivingEntity living) return get(living);
		return new HashSet<>();
	}
	
	/**
	 * @param living - living entity
	 * @return Set of all states that the living entity has
	 */

	Set<IEntityState> get(LivingEntity living);
	
	/**
	 * @param size - slime size
	 * @return Slime size state
	 */
	
	ISlimeSizeState ofSlimeSize(int size);
	
	/**
	 * @param color - dye color
	 * @return Colorable state
	 */
	
	IColorableState ofColor(DyeColor color);
	
	/**
	 * @param adult - {@code true} for adult, {@code false} for baby
	 * @return Ageable state
	 */
	
	IAgeableState ofAgeable(boolean adult);
	
	/**
	 * @param charged - {@code true} for charged, {@code false} for uncharged
	 * @return Charged state
	 */
	
	IChargedState ofCharged(boolean charged);
	
}
