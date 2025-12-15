package mc.rellox.spawnerlegacyapi.manager;

import java.util.Comparator;
import java.util.Set;
import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import mc.rellox.spawnerlegacyapi.entity.IEntityWorld;
import mc.rellox.spawnerlegacyapi.entity.IStackedEntity;
import mc.rellox.spawnerlegacyapi.entity.state.IEntityState;
import mc.rellox.spawnerlegacyapi.entity.state.IStates;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IEntityManager {
	
	/**
	 * @param world - world
	 * @return Entity world or {@code null}
	 */
	
	IEntityWorld world(World world);
	
	/**
	 * @param entity - entity
	 * @return Stacked entity or {@code null}
	 */
	
	IStackedEntity get(Entity entity);
	
	/**
	 * @param living - entity
	 * @param validate - would validate entity
	 * @return Stacked entity or {@code null}
	 */
	
	IStackedEntity get(LivingEntity living, boolean validate);
	
	/**
	 * @param living - entity
	 * @return Stacked entity or {@code null}
	 */
	
	IStackedEntity get(LivingEntity living);
	
	/**
	 * Spawns a new stacked entity and applies any generator upgrade values (xp, drops).
	 * 
	 * @param generator - spawner generator
	 * @param type - spawner type
	 * @param location - spawn location
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(IGenerator generator, SpawnerType type, Location location);
	
	/**
	 * Spawns a new stacked entity and applies any generator upgrade values (xp, drops).
	 * 
	 * @param generator - spawner generator
	 * @param type - spawner type
	 * @param location - spawn location
	 * @param states - entity states to apply
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(IGenerator generator, SpawnerType type, Location location,
			Set<IEntityState> states);
	
	/**
	 * Spawns a new stacked entity and applies any generator upgrade values (xp, drops).
	 * 
	 * @param generator - spawner generator
	 * @param type - spawner type
	 * @param location - spawn location
	 * @param stack - initial stack size
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(IGenerator generator, SpawnerType type, Location location,
			int stack);
	
	/**
	 * Spawns a new stacked entity and applies any generator upgrade values (xp, drops).
	 * 
	 * @param generator - spawner generator
	 * @param type - spawner type
	 * @param location - spawn location
	 * @param states - entity states to apply
	 * @param stack - initial stack size
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(IGenerator generator, SpawnerType type, Location location,
			Set<IEntityState> states, int stack);
	
	/**
	 * Spawns a new stacked entity.
	 * 
	 * @param type - spawner type
	 * @param location - spawn location
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(SpawnerType type, Location location);
	
	/**
	 * Spawns a new stacked entity.
	 * 
	 * @param type - spawner type
	 * @param location - spawn location
	 * @param states - entity states to apply
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(SpawnerType type, Location location,
			Set<IEntityState> states);
	
	/**
	 * Spawns a new stacked entity.
	 * 
	 * @param type - spawner type
	 * @param location - spawn location
	 * @param stack - initial stack size
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(SpawnerType type, Location location, int stack);
	
	/**
	 * Spawns a new stacked entity.
	 * 
	 * @param type - spawner type
	 * @param location - spawn location
	 * @param states - entity states to apply
	 * @param stack - initial stack size
	 * @return Newly spawned stacked entity or {@code null} if spawn failed
	 */
	
	IStackedEntity spawn(SpawnerType type, Location location,
			Set<IEntityState> states, int stack);
	
	/**
	 * @param location - center location
	 * @param x - x radius
	 * @param y - y radius
	 * @param z - z radius
	 * @return Set of all nearby stacked entities
	 */
	
	Set<IStackedEntity> find(Location location, double x, double y, double z);
	
	/**
	 * @param location - center location
	 * @param x - x radius
	 * @param y - y radius
	 * @param z - z radius
	 * @param filter - entity filter
	 * @return Set of filtered nearby stacked entities
	 */
	Set<IStackedEntity> find(Location location, double x, double y, double z,
			Predicate<IStackedEntity> filter);
	
	/**
	 * @param stacked - center location entity
	 * @param x - x radius
	 * @param y - y radius
	 * @param z - z radius
	 * @param filter - entity filter
	 * @return Set of filtered nearby stacked entities
	 */
	
	Set<IStackedEntity> find(IStackedEntity stacked, double x, double y, double z,
			Predicate<IStackedEntity> filter);
	
	/**
	 * @param entity - entity
	 * @return Current entity stack size
	 */
	
	int size(LivingEntity entity);
	
	/**
	 * @param entity - entity
	 * @param stack - new stack size
	 */
	
	void size(LivingEntity entity, int stack);
	
	/**
	 * @param type - spawner type
	 * @return Stack limit for the type or {@link Integer#MAX_VALUE} if unlimited
	 */
	
	int limit(SpawnerType type);
	
	/**
	 * @param stacked - stacked entity
	 * @return Display name for the stacked entity
	 */
	
	String name(IStackedEntity stacked);
	
	/**
	 * @param stacked - stacked entity
	 * @param update - whether to update the entity after unstacking
	 * @return Newly unstacked entity or {@code null} if size was 1
	 */
	
	IStackedEntity unstack(IStackedEntity stacked, boolean update);
	
	/**
	 * Transfers data from one entity to another.
	 * 
	 * @param from - source entity
	 * @param to - target entity
	 */
	
	void transfer(LivingEntity from, LivingEntity to);
	
	/**
	 * @return Entity states manager
	 */
	
	IStates states();
	
	/**
	 * @param type - type to match
	 * @return Entity filter that checks for matching entity type
	 */
	
	static Predicate<IStackedEntity> type(SpawnerType type) {
		return entity -> entity.type() == type;
	}
	
	/**
	 * @param state - entity state
	 * @return Entity filter that check if the entity
	 *  matches with the state
	 */
	
	static Predicate<IStackedEntity> matching(IEntityState state) {
		return entity -> entity.matching(state);
	}
	
	/**
	 * @param states - entity states
	 * @return Entity filter that check if the entity
	 *  matches with all states
	 */
	
	static Predicate<IStackedEntity> matching(IEntityState... states) {
		return entity -> entity.matching(states);
	}
	
	/**
	 * @param states - entity states
	 * @return Entity filter that check if the entity
	 *  matches with all states
	 */
	
	static Predicate<IStackedEntity> matching(Set<IEntityState> states) {
		return entity -> entity.matching(states);
	}
	
	/**
	 * @param other - other stacked entity
	 * @return Entity filter that check if the entity
	 *  matches with the other stacked entity
	 */
	
	static Predicate<IStackedEntity> matching(IStackedEntity other) {
		var states = other.states(); // cache states once
		return matching(states);
	}
	
	/**
	 * Checks if type and states are matching.
	 * 
	 * @param other - other entity
	 * @return Entity filter that check if the entity
	 *  can stack with the other entity
	 */
	
	static Predicate<IStackedEntity> stackable(LivingEntity other) {
		return entity -> entity.stackable(other);
	}
	
	/**
	 * Checks if type and states are matching.
	 * 
	 * @param other - other stacked entity
	 * @return Entity filter that check if the entity
	 *  can stack with the other stacked entity
	 */
	
	static Predicate<IStackedEntity> stackable(IStackedEntity other) {
		return entity -> entity.stackable(other);
	}
	
	/**
	 * @return Entity filter that check if the entity
	 *  has reached its stack limit
	 */
	
	static Predicate<IStackedEntity> limited() {
		return IStackedEntity::limited;
	}
	
	/**
	 * @return Entity filter that check if the entity
	 *  has not reached its stack limit
	 */
	
	static Predicate<IStackedEntity> stackable() {
		return limited().negate();
	}
	
	/**
	 * @return Entity comparator that sorts by size first
	 *  and then life time
	 */

	static Comparator<IStackedEntity> priority() {
		return Comparator
				.comparingInt(IStackedEntity::size)
				.reversed()
				.thenComparingInt(IStackedEntity::life);
	}

}
