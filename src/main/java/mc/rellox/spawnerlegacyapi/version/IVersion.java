package mc.rellox.spawnerlegacyapi.version;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import mc.rellox.spawnerlegacyapi.version.Version.VersionType;

public interface IVersion {
	
	/**
	 * @return The version type implemented by this class
	 */
	
	VersionType type();
	
	/**
	 * @param players - players to send to
	 * @param os - packets to send
	 */
	
	void send(Collection<? extends Player> players, Object... os);
	
	/**
	 * @param player - player to send to
	 * @param os - packets to send
	 */
	
	void send(Player player, Object... os);
	
	/**
	 * @param entity - entity to spawn
	 * @return The spawn packet for the entity
	 */
	
	Object spawn(Object entity);
	
	/**
	 * @param entity - entity to get metadata for
	 * @return The entity metadata packet
	 */
	
	Object meta(Object entity);
	
	/**
	 * @param entity - entity to destroy
	 * @return The entity destroy packet
	 */
	
	Object destroy(Object entity);
	
	/**
	 * @param location - hologram location
	 * @param name - hologram text
	 * @return The hologram entity
	 */
	
	Object hologram(Location location, String name);
	
	/**
	 * @param name - component name
	 * @return The component object
	 */
	
	Object component(String name);
	
	/**
	 * @param entity - entity to name
	 * @param component - component to set as name
	 */
	
	void name(Object entity, Object component);
	
	/**
	 * @param entity - entity to name
	 * @param name - name to set
	 */
	
	default void name(Object entity, String name) {
		name(entity, component(name));
	}
	
	/**
	 * @param entity - entity to name
	 * @param name - name to set
	 */
	
	default void name(Entity entity, String name) {
		name(handled(entity), name);
	}
	
	/**
	 * @param os - packets to send
	 */
	
	default void send(Object... os) {
		send(Bukkit.getOnlinePlayers(), os);
	}
	
	/**
	 * @param entity - entity to handle
	 * @return The NMS handle of the entity
	 */
	
	default Object handled(Entity entity) {
		return RF.direct(entity, "getHandle");
	}

}
