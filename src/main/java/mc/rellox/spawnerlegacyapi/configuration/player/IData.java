package mc.rellox.spawnerlegacyapi.configuration.player;

import mc.rellox.spawnerlegacyapi.configuration.IFile;

public interface IData<T> {
	
	/**
	 * @return ID of this data provider
	 */
	
	String id();
	
	/**
	 * @param file - file
	 * @return The loaded data
	 */
	
	T load(IFile file);
	
	/**
	 * Saves the data to this file.
	 * 
	 * @param file - file
	 * @param data - data
	 */
	
	void save(IFile file, T data);
	
	/**
	 * This value is returned if the value in a player file is absent ({@link IPlayerData#get(IData)}).
	 * 
	 * @return Default value for this data
	 */
	
	default T defaulted() {
		return null;
	}

}
