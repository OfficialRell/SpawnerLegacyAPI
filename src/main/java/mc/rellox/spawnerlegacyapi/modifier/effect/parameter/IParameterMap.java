package mc.rellox.spawnerlegacyapi.modifier.effect.parameter;

import java.util.List;

import org.bukkit.persistence.PersistentDataContainer;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;

public interface IParameterMap {
	
	/**
	 * @return Copy of list of parameters
	 */
	
	List<IParameter<?>> parameters();
	
	/**
	 * Replaces all placeholders the values.
	 * 
	 * @param builder - builder
	 * @param values - values
	 */
	
	void replace(ItemBuilder builder, Object... values);
	
	/**
	 * Writes all parameter values.
	 * 
	 * @param container - container
	 * @param values - values
	 * 
	 * @throws IllegalArgumentException if parameter count does not
	 * match specified value count
	 */
	
	void write(PersistentDataContainer container, Object... values);
	
	/**
	 * Reads all parameter values.
	 * 
	 * @param container - container
	 * @return Read values
	 */
	
	Object[] read(PersistentDataContainer container);

}
