package mc.rellox.spawnerlegacyapi.utility;

import java.util.regex.Pattern;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import mc.rellox.spawnerlegacyapi.version.Version;
import mc.rellox.spawnerlegacyapi.version.Version.VersionType;

public final class Utility {
	
	private static final Pattern uuid_validation =
			Pattern.compile("[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}");
	
	public static boolean isUUID(String s) {
		return uuid_validation.matcher(s).matches();
	}
	
	public static boolean op(Player player) {
		return player.isOp() && player.getGameMode() == GameMode.CREATIVE;
	}
	
	public static Location center(Block block) {
		return block.getLocation().add(0.5, 0.5, 0.5);
	}
	
	public static int[] location(Block block) {
		return new int[] {block.getX(), block.getY(), block.getZ()};
	}
	
	public static int dist2(Location first, Location second) {
		if(first == null || second == null) return Integer.MAX_VALUE;
		if(!first.getWorld().equals(second.getWorld())) return Integer.MAX_VALUE;
		return (int) first.distanceSquared(second);
	}
	
	// Particles
	
	public static final Particle particle_sharpness = RF.enumerate(Particle.class, "CRIT_MAGIC", "ENCHANTED_HIT");
	public static final Particle particle_redstone = RF.enumerate(Particle.class, "REDSTONE", "DUST");
	public static final Particle particle_happy = RF.enumerate(Particle.class, "VILLAGER_HAPPY", "HAPPY_VILLAGER");
	public static final Particle particle_angry = RF.enumerate(Particle.class, "VILLAGER_ANGRY", "ANGRY_VILLAGER");
	public static final Particle particle_firework = RF.enumerate(Particle.class, "FIREWORKS_SPARK", "FIREWORK");
	
	// Attributes

	public static final Attribute attribute_damage = RF.fielded(Attribute.class, "GENERIC_ATTACK_DAMAGE", "ATTACK_DAMAGE");
	public static final Attribute attribute_speed = RF.fielded(Attribute.class, "GENERIC_MOVEMENT_SPEED", "MOVEMENT_SPEED");

	public static boolean isWindCharge(Entity entity) {
		if(!Version.version.high(VersionType.v_21_1)) return false;
		return switch (entity.getType().name()) {
		case "WIND_CHARGE", "BREEZE_WIND_CHARGE" -> true;
		default -> false;
		};
	}

}
