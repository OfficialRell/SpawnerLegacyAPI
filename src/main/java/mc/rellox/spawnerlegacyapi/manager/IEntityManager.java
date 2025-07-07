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
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IEntityManager {
	
	IEntityWorld world(World world);
	
	IStackedEntity get(Entity entity);
	
	IStackedEntity get(LivingEntity living, boolean validate);
	
	IStackedEntity get(LivingEntity living);
	
	Set<IStackedEntity> find(Location location, double x, double y, double z);
	
	Set<IStackedEntity> find(Location location, double x, double y, double z,
			Predicate<IStackedEntity> filter);
	
	Set<IStackedEntity> find(IStackedEntity stacked, double x, double y, double z,
			Predicate<IStackedEntity> filter);
	
	int size(LivingEntity entity);
	
	void size(LivingEntity entity, int stack);
	
	String name(IStackedEntity stacked);
	
	IStackedEntity unstack(IStackedEntity stacked, boolean update);
	
	void transfer(LivingEntity from, LivingEntity to);
	
	/**
	 * @param type - type to match
	 * @return Entity filter that checks for matching entity type
	 */
	
	static Predicate<IStackedEntity> type(SpawnerType type) {
		return entity -> entity.type() == type;
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
