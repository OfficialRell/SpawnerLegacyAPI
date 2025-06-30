package mc.rellox.spawnerlegacyapi.utility.region;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.utility.region.type.CubicBox;
import mc.rellox.spawnerlegacyapi.utility.region.type.SphereBox;

public interface IBox {
	
	static IBox empty = new IBox() {
		@Override
		public int z() {return 0;}
		@Override
		public int y() {return 0;}
		@Override
		public int x() {return 0;}
		@Override
		public int radius() {return 0;}
		@Override
		public boolean in(int x, int y, int z) {return false;}
	};
	
	public static IBox cube(Block block, int r) {
		return cube(block.getX(), block.getY(), block.getZ(), r);
	}
	
	public static IBox cube(int x, int z, int y, int r) {
		return new CubicBox(x, y, z, r);
	}
	
	public static IBox sphere(Block block, int r) {
		return sphere(block.getX(), block.getY(), block.getZ(), r);
	}
	
	public static IBox sphere(int x, int z, int y, int r) {
		return new SphereBox(x, y, z, r);
	}
	
	/**
	 * @param x - x
	 * @param y - y
	 * @param z - z
	 * @return {@code true} if these coordenates are in this box
	 */
	
	boolean in(int x, int y, int z);
	
	/**
	 * @param player - player
	 * @return {@code true} if this player is in this box
	 */
	
	default boolean in(Player player) {
		return in(player.getLocation());
	}
	
	/**
	 * @param player - player
	 * @return {@code true} if this block is in this box
	 */
	
	default boolean in(Block block) {
		return in(block.getX(), block.getY(), block.getZ());
	}
	
	/**
	 * @param player - player
	 * @return {@code true} if this location is in this box
	 */
	
	default boolean in(Location loc) {
		return in(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}
	
	/**
	 * @return x coordenate
	 */
	
	int x();
	
	/**
	 * @return y coordenate
	 */
	
	int y();
	
	/**
	 * @return z coordenate
	 */
	
	int z();
	
	/**
	 * @return Radius of this box
	 */
	
	int radius();
	
	/**
	 * @param players - players
	 * @return {@code true} if any of the given players are in this box
	 */
	
	default boolean any(Iterable<? extends Player> players) {
		for(Player player : players)
			if(in(player) == true
			&& player.getGameMode() != GameMode.SPECTATOR) return true;
		return false;
	}

}
