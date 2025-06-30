package mc.rellox.spawnerlegacyapi.spawner.meta.entity;

import org.bukkit.entity.Breedable;
import org.bukkit.entity.Entity;

public interface IEntityModifierBreedable extends IEntityModifier {
	
	/**
	 * @return Should the grow age be locked,
	 * denying the ability to become an adult
	 */
	
	boolean locked();
	
	/**
	 * @return Can this entity breed
	 */
	
	boolean breed();

	@Override
	default void modify(Entity entity) {
		if(entity instanceof Breedable breedable) {
			breedable.setAgeLock(locked());
			breedable.setBreed(breed());
		}
	}
	
}
