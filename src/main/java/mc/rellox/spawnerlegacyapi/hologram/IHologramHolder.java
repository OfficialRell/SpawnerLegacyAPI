package mc.rellox.spawnerlegacyapi.hologram;

public interface IHologramHolder {

	/**
	 * Updates hologram state.
	 */
	
	void update();
	
	/**
	 * Forces all holograms to be updated.
	 */
	
	void force();
	
	/**
	 * Updates hologram text.
	 */
	
	void rewrite();
	
	/**
	 * Removes and clears all holograms.
	 */
	
	void clear();
	
	/**
	 * Hides the countdown hologram from all players.
	 * 
	 * @param hidden - hidden
	 */
	
	void hide(boolean hidden);
	
	/**
	 * Updates the text for the countdown hologram.
	 */
	
	void count();
	
}
