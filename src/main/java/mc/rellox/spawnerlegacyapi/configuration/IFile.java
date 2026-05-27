package mc.rellox.spawnerlegacyapi.configuration;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IFile extends IFileValues {
	
	/**
	 * Creates or initializes this file.
	 */
	
	void create();
	
	/**
	 * @return The configuration file
	 */
	
	FileConfiguration file();
	
	/**
	 * @return File name
	 */
	
	String name();
	
	/**
	 * @return {@code true} if this file was just created
	 */
	
	boolean newly();

	/**
	 * Saves all changes to the file.
	 */
	
	void save();
	
	/**
	 * Sets an object to the path, without saving this file.
	 * 
	 * @param path - path
	 * @param object - object to set
	 */
	
	default void hold(String path, Object object) {
		file().set(path, object);
	}
	
	/**
	 * Removes specified path, without saving this file.
	 * 
	 * @param path path to remove
	 */
	
	default void delete(String path) {
		file().set(path, null);
	}
	
	/**
	 * Sets an object to the path and saves this file.
	 * 
	 * @param path path
	 * @param object object to set
	 */
	
	default void set(String path, Object object) {
		file().set(path, object);
		save();
	}
	
	/**
	 * Removes specified path and saved this file.
	 * 
	 * @param path path to remove
	 */
	
	default void clear(String path) {
		file().set(path, null);
		save();
	}
	
	/**
	 * Copies the object from the specified path to a different path,
	 *  removing the previous path, without saving
	 * 
	 * @param from path from
	 * @param to path to copy
	 */
	
	default void copy(String from, String to) {
		copy(from, to, false);
	}
	
	/**
	 * Copies the object from the specified path to a different path,
	 *  removing the previous path.
	 * 
	 * @param from path from
	 * @param to path to copy
	 * @param save should save
	 */
	
	default void copy(String from, String to, boolean save) {
		Object o = file().get(from);
		if(save) clear(from);
		else delete(from);
		if(o != null) {
			if(save) set(to, o);
			else hold(to, o);
		}
	}
	
	/**
	 * @param path path
	 * @return {@code true} if this path has a value, otherwise {@code false}
	 */
	
	default boolean exists(String path) {
		return file().isSet(path);
	}
	
	/**
	 * Get all keys from the specified path.
	 * 
	 * @param path path
	 * @return Set of path keys
	 */
	
	default Set<String> keys(String path) {
		ConfigurationSection cs = file().getConfigurationSection(path);
		return cs == null ? new HashSet<>() : cs.getKeys(false);
	}
	
	/**
	 * Sets a default value.
	 * 
	 * @param path path
	 * @param value default value
	 */
	
	default void defaulted(String path, Object value) {
		file().addDefault(path, value);
	}
	
	/**
	 * Clears file memory. After using this method most other methods will throw {@link NullPointerException}.
	 */
	
	void free();
	
	/**
	 * Sets a header to this file.
	 * 
	 * @param header header separated by '\n'
	 */
	
	default void header(String header) {
		header(header.split("\\n"));
	}
	
	/**
	 * Sets a header to this file.
	 * 
	 * @param header file header
	 */
	
	default void header(String... header) {
		FileConfigurationOptions options = file().options();
		options.setHeader(List.of(header));
		options.parseComments(true);
	}

	/**
	 * @return New commenter for this file
	 */

	default Commenter commenter() {
		return new Commenter(this);
	}

	record Commenter(IFile file) {

		/**
		 * Adds comments to this path.
		 *
		 * @param path path
		 * @param comments comments
		 */

		public void comment(String path, String... comments) {
			comment(path, List.of(comments));
		}

		/**
		 * Adds comments to this path.
		 *
		 * @param path path
		 * @param list comments
		 */

		public void comment(String path, List<String> list) {
			file.file().setComments(path, list);
		}

	}

}
