package mc.rellox.spawnerlegacyapi.hologram;

import java.util.Set;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IHologram {
	
	/**
	 * @return Type of the hologram
	 */
	
	HologramType type();
	
	/**
	 * @return Entity generator
	 */
	
	IGenerator generator();
	
	/**
	 * @return Set of players who sees this spawner hologram
	 */
	
	Set<Player> viewers();
	
	/**
	 * Updates spawner hologram players.
	 */
	
	void update();
	
	/**
	 * Resizes hologram view box.
	 */
	
	void resize();
	
	/**
	 * @return Hologram view radius
	 */
	
	int radius();
	
	/**
	 * Hides or shows this hologram.
	 * Automatically updates this hologram.
	 * 
	 * @param hidden - is hidden
	 */
	
	void hide(boolean hidden);
	
	/**
	 * @return Is this hologram hidden
	 */
	
	boolean hidden();
	
	/**
	 * Updates spawner hologram text.
	 */
	
	void rewrite();
	
	/**
	 * Shows this hologram to the specified player.
	 * 
	 * @param player - player
	 */
	
	void show(Player player);
	
	/**
	 * Hides this hologram from the specified player.
	 * 
	 * @param player - player
	 */
	
	void hide(Player player);
	
	/**
	 * Hides this hologram from all players who sees it.
	 */
	
	void clear();

}
