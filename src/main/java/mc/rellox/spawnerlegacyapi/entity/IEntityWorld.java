package mc.rellox.spawnerlegacyapi.entity;

import java.util.Set;
import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public interface IEntityWorld {
	
	/**
	 * @return The world
	 */
	
	World world();
	
	/**
	 * @return Set of all stacked entities
	 */
	
	Set<IStackedEntity> entities();
	
	/**
	 * This method will also try to initialise a stacked
	 * entity if it was not already created.<br>
	 * If validate is {@code true} then null will be returned
	 * if the entity is dead or invalid.
	 * 
	 * @param living - living entity
	 * @param validate - validate entity state
	 * @return Stacked entity or {@code null}
	 */
	
	IStackedEntity get(LivingEntity living, boolean validate);

	/**
	 * This method will also try to initialise a stacked
	 * entity if it was not already created.
	 * 
	 * @param living - living entity
	 * @return Stacked entity or {@code null}
	 */
	
	default IStackedEntity get(LivingEntity living) {
		return get(living, true);
	}
	
	/**
	 * This method will also try to initialise a stacked
	 * entity if it was not already created.
	 * 
	 * @param entity - entity
	 * @return Stacked entity or {@code null}
	 */
	
	default IStackedEntity get(Entity entity) {
		if(entity instanceof LivingEntity living) return get(living);
		return null;
	}
	
	/**
	 * This method will not create any stacked entity.
	 * 
	 * @param living - living entity
	 * @return Stacked entity or {@code null}
	 */
	
	IStackedEntity raw(LivingEntity living);
	
	/**
	 * Caches all stackable entities.
	 */
	
	void cache();
	
	/**
	 * Tries to join all stackable entities if possible.<br>
	 * This method should mostly only be called when a world loads
	 * for the first time.
	 */
	
	void join();
	
	/**
	 * Validates all stacked entities to remove invalid ones. 
	 */
	
	void validate();
	
	/**
	 * Creates a new stacked entity if possible.<br>
	 * Note, that this will override previous entity data.
	 * 
	 * @param living - living entity
	 * @param stack - stack size
	 * @return Newly created stacked entity or {@code null}
	 */
	
	IStackedEntity create(LivingEntity living, int stack);
	
	/**
	 * Removed this entity from the stacked list.
	 * The unstacked entity will not be able to stack again.<br>
	 * Returns a new stacked entity with the previous stack size - 1
	 * or {@code null} if stack size was 1.<br>
	 * If update is {@code true} then the previous entity will be updated. 
	 * 
	 * @param stacked - stacked entity
	 * @param update - update clearing
	 * @return Newly spawned entity or {@code null}
	 */
	
	IStackedEntity unstack(IStackedEntity stacked, boolean update);
	
	/**
	 * @param location - center location
	 * @param x - x radius
	 * @param y - y radius
	 * @param z - z radius
	 * @param filter - filter
	 * @return Set of filtered stacked entities
	 */
	
	Set<IStackedEntity> find(Location location, double x, double y, double z,
			Predicate<IStackedEntity> filter);
	
	/**
	 * @param location - center location
	 * @param radius - search radius
	 * @param filter - filter
	 * @return Set of filtered stacked entities
	 */
	
	default Set<IStackedEntity> find(Location location, double radius,
			Predicate<IStackedEntity> filter) {
		return find(location, radius, radius, radius, filter);
	}
	
	/**
	 * @param stacked - stacked entity
	 * @param x - x radius
	 * @param y - y radius
	 * @param z - z radius
	 * @param filter - filter
	 * @return Set of filtered stacked entities
	 */
	
	Set<IStackedEntity> find(IStackedEntity stacked, double x, double y, double z,
			Predicate<IStackedEntity> filter);
	
	/**
	 * @param stacked - stacked entity
	 * @param radius - search radius
	 * @param filter - filter
	 * @return Set of filtered stacked entities
	 */
	
	default Set<IStackedEntity> find(IStackedEntity stacked, double radius,
			Predicate<IStackedEntity> filter) {
		return find(stacked, radius, radius, radius, filter);
	}

}
