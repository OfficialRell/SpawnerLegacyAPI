package mc.rellox.spawnerlegacyapi.utility;

import mc.rellox.spawnerlegacyapi.configuration.IFile;

public interface ISave {
	
	/**
	 * Saves this object at the specified path.
	 * 
	 * @param file - configuration file
	 * @param path - path to save to
	 */
	
	void save(IFile file, String path);

}
