package mc.rellox.spawnerlegacyapi.utility.region;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public record FinalPos(World world, int x, int y, int z) {
	
	/**
	 * @param block - block
	 * @return FinalPos object of this block
	 */
	
	public static FinalPos of(Block block) {
		return new FinalPos(block.getWorld(),
				block.getX(), block.getY(), block.getZ());
	}
	
	/**
	 * @param loc - location
	 * @return FinalPos object of this location
	 */
	
	public static FinalPos of(Location loc) {
		return new FinalPos(loc.getWorld(),
				loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}
	
	/**
	 * @return Fixed x coordinate
	 */
	
	public String fx() {
		return to(x);
	}
	
	/**
	 * @return Fixed y coordinate
	 */
	
	public String fy() {
		return to(y);
	}
	
	/**
	 * @return Fixed z coordinate
	 */
	
	public String fz() {
		return to(z);
	}
	
	/**
	 * @return Location of this position
	 */
	
	public Location location() {
		return new Location(world, x, y, z);
	}
	
	/**
	 * @return Block at this position
	 */
	
	public Block block() {
		return world.getBlockAt(x, y, z);
	}
	
	/**
	 * Convents this position to Minecraft position as showed when
	 * pressed F3.
	 * 
	 * @return Minecraft coordinates - 'x, y, z'
	 */
	
	public String toFixed() {
		return fx() + ", " + fy() + ", " + fz();
	}
	
	public String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}
	
	/**
	 * Tries to parse the given string to FinalPos object.
	 * May return {@code null}.
	 * 
	 * @param world - world
	 * @param s - coordinates
	 * @return New block position or {@code null} if was not able to parse
	 */
	
	public static FinalPos parse(World world, String s) {
		try {
			if(s.matches("(-?\\d+)((,\\s?)(-?\\d+)){2}") == false)
				return null;
			String[] ps = s.replace(" ", "").split(",");
			if(ps.length != 3) return null;
			return new FinalPos(world, from(ps[0]), from(ps[1]), from(ps[2]));
		} catch (Exception e) {
			RF.debug(e);
		}
		return null;
	}
	
	private static String to(int i) {
		return i < 0 ? i == -1 ? "-0" : "" + (i + 1) : "" + i;
	}
	
	private static int from(String s) {
		if(s.equals("-0") == true) return -1;
		int i = Integer.parseInt(s);
		return i < 0 ? (i - 1) : i;
	}

}
