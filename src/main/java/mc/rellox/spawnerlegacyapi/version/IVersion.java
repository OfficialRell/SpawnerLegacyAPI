package mc.rellox.spawnerlegacyapi.version;

import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public interface IVersion {
	
	void send(Collection<? extends Player> players, Object... os);
	
	Object spawn(Object entity);
	
	Object meta(Object entity);
	
	Object destroy(Object entity);
	
	Object hologram(Location l, String name);
	
	void name(Object entity, String name);
	
	default void name(Entity entity, String name) {
		name(handled(entity), name);
	}
	
	default void send(Player player, Object... os) {
		send(List.of(player), os);
	}
	
	default void send(Object... os) {
		send(Bukkit.getOnlinePlayers(), os);
	}
	
	default Object handled(Entity entity) {
		return RF.direct(entity, "getHandle");
	}

}
