package mc.rellox.spawnerlegacyapi.spawner.meta.entity;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;

public interface IEntityModifierAge extends IEntityModifier {
	
	/**
	 * @return Is adult, otherwise a baby
	 */
	
	boolean adult();
	
	@Override
	default void modify(Entity entity) {
		if(entity instanceof Ageable ageable) {
			if(adult() == true) ageable.setAdult();
			else ageable.setBaby();
		}
	}

}
