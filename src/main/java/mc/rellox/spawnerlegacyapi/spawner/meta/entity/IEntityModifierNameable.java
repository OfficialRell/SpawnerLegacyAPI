package mc.rellox.spawnerlegacyapi.spawner.meta.entity;

import org.bukkit.entity.Entity;

import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface IEntityModifierNameable extends IEntityModifier {
	
	/**
	 * @return Name content
	 */
	
	IContent name();
	
	/**
	 * @return If the name is always visible
	 */
	
	boolean visible();
	
	@Override
	default void modify(Entity entity) {
		entity.setCustomName(name().text());
		entity.setCustomNameVisible(visible());
	}

}
