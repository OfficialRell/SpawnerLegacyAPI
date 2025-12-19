package mc.rellox.spawnerlegacyapi.version;

import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.version.Version.VersionType;

public record NullVersion(VersionType type) implements IVersion {

	@Override
	public void send(Collection<? extends Player> players, Object... os) {}

	@Override
	public void send(Player player, Object... os) {}

	@Override
	public Object spawn(Object entity) {
		return null;
	}

	@Override
	public Object meta(Object entity) {
		return null;
	}

	@Override
	public Object destroy(Object entity) {
		return null;
	}

	@Override
	public Object hologram(Location location, String name) {
		return null;
	}

	@Override
	public Object component(String name) {
		return null;
	}

	@Override
	public void name(Object entity, Object component) {}

}
