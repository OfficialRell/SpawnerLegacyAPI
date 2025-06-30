package mc.rellox.spawnerlegacyapi.entity;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IStackedEntity {
	
	/**
	 * @return Entity ID
	 */
	
	int id();
	
	/**
	 * @return The stacked entity
	 */
	
	LivingEntity entity();
	
	/**
	 * @return World the entity is in
	 */
	
	World world();	
	
	/**
	 * @return Location of this entity
	 */
	
	Location location();
	
	/**
	 * @return {@code true} if this entity exists in the world
	 */
	
	boolean exists();
	
	/**
	 * @return Current entity stack size
	 */
	
	int size();
	
	/**
	 * @return The stacking limit or {@link Integer#MAX_VALUE} if limit is disabled
	 */
	
	int limit();
	
	/**
	 * @return {@code true} if this entity has reached its stacking limit
	 */
	
	boolean limited();
	
	/**
	 * @return Ticks the entity has lived for
	 */
	
	int life();
	
	/**
	 * @return The spawner type of this entity
	 */
	
	SpawnerType type();
	
	/**
	 * Updates the name of this entity.
	 */
	
	void update();
	
	/**
	 * Subtracts the value from the current stack size.
	 * 
	 * @param value - value
	 * @return The new stack size, will return {@code 0} if negative
	 */
	
	int reduce(int value);
	
	/**
	 * Adds the value to the current stack size.
	 * 
	 * @param value - value
	 * @param force - should ignore limits
	 * @return The new stack size, might be limited if {@code force} is false
	 */
	
	int increase(int value, boolean force);
	
	/**
	 * Adds the value to the current stack size with limit checking.
	 * 
	 * @param value - value
	 * @return The new stack size or limit
	 */
	
	default int increase(int value) {
		return increase(value, false);
	}
	
	/**
	 * Sets the new stack size.
	 * 
	 * @param value - value 
	 * @param force - should ignore limits
	 * @return The new stack size, might be limited if {@code force} is false
	 */
	
	int set(int value, boolean force);
	
	/**
	 * Sets the new stack size with limit checking.
	 * 
	 * @param value - value 
	 * @return The new stack size or limit
	 */
	
	default int set(int value) {
		return set(value, false);
	}
	
	/**
	 * Removes this entity from the world.
	 * 
	 * @param drop - should drop loot
	 */
	
	void kill(boolean drop);
	
	/**
	 * Clears entity stack size.<br>
	 * 
	 * If update is {@code true} then all values will be updated (Stack size value, name and tags)<br>
	 * Does not remove from the stacked entity list instantly.
	 * 
	 * @param update - update 
	 */
	
	void clear(boolean update);
	
	/**
	 * Clears entity stack size and updates all values.<br>
	 * Does not remove from the stacked entity list instantly.
	 */
	
	default void clear() {
		clear(true);
	}

}
