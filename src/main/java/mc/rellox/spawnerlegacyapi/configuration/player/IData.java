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
	
	/**
	 * When set to {@code true}, this data will be automatically saved when the player file is cleared from cache.
	 * When {@code false}, the data will only be saved when using {@link IPlayerData#set(IData, Object)}
	 * or other method (not guaranteed) that writes to the file.
	 * 
	 * @return Autosave this data when clearing player file from cache
	 */
	
	default boolean autosave() {
		return false;
	}

}
