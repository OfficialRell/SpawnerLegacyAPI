package mc.rellox.spawnerlegacyapi.spawner.info;

public interface IInfo {
	
	/**
	 * @return Amount of active spawners
	 */
	
	int active();
	
	/**
	 * @return Amount of active owned spawners
	 */
	
	int owned();
	
	/**
	 * @return Amount of active owned spawners
	 */
	
	int natural();
	
	/**
	 * @return Amount of active ticking spawners
	 */
	
	int ticking();
	
	/**
	 * @return Amount of active warned spawners
	 */
	
	int warned();

}
