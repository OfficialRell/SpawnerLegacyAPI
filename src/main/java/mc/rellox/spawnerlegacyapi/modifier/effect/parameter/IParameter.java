package mc.rellox.spawnerlegacyapi.modifier.effect.parameter;

import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;

public interface IParameter<T> {
	
	/**
	 * @return Parameter name
	 */
	
	String name();
	
	/**
	 * Tries to parse the argument to the correct type.<br>
	 * Returns {@code null} if failed.
	 * 
	 * @param argument - argument
	 * @return Parsed value or {@code null}
	 */
	
	T parse(String argument);
	
	/**
	 * @return {@code true} if the value is valid
	 */
	
	boolean valid(T value);
	
	/**
	 * @return List of default values for tab completion
	 */
	
	List<String> defaults();
	
	/**
	 * Replaces all placeholders with the value.
	 * 
	 * @param builder - builder
	 * @param value - value
	 */
	
	void replace(ItemBuilder builder, T value);
	
	/**
	 * @return Parameter namespaced key
	 */
	
	NamespacedKey key();
	
	/**
	 * @return Parameter data type
	 */
	
	PersistentDataType<?, T> type();
	
	/**
	 * Writes the value to the container.
	 * 
	 * @param container - container
	 * @param value - value
	 */
	
	void write(PersistentDataContainer container, T value);
	
	/**
	 * Reads the value from the container, never {@code null}.
	 * 
	 * @param container - container
	 * @return Read value
	 */
	
	T read(PersistentDataContainer container);

}
