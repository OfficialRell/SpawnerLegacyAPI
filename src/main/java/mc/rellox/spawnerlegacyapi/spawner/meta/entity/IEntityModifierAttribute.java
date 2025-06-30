package mc.rellox.spawnerlegacyapi.spawner.meta.entity;

import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;

public interface IEntityModifierAttribute extends IEntityModifier {
	
	/**
	 * @return Attribute type
	 */
	
	Attribute type();
	
	/**
	 * @return New base value
	 */
	
	double value();

	@Override
	default void modify(Entity entity) {
		if(entity instanceof Attributable attributable) {
			AttributeInstance attribute = attributable.getAttribute(type());
			if(attribute == null) return;
			attribute.setBaseValue(value());
		}
	}
	
}
