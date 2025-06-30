package mc.rellox.spawnerlegacyapi.spawner.warning;

import java.util.List;

import org.bukkit.Location;

import mc.rellox.spawnerlegacyapi.hologram.IHologram;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.location.IFinder;

public interface IValidation {
	
	/**
	 * @return Generator
	 */
	
	IGenerator generator();
	
	/**
	 * @return Location finder
	 */
	
	IFinder finder();
	
	/**
	 * Updates validation values. Does not validate the spawner.
	 */
	
	void update();
	
	/**
	 * @return Warning hologram
	 */
	
	IHologram hologram();
	
	/**
	 * Adds this warning to the spawner, making it unable to spawn
	 * until the spawner gets updated.
	 * 
	 * @param warning - warning type
	 */
	
	void warn(WarningType warning);
	
	/**
	 * @param warning - warning type
	 * @return If this spawner has this warning
	 */
	
	boolean warned(WarningType warning);
	
	/**
	 * @return If this spawner has any warnings
	 */
	
	boolean warned();
	
	/**
	 * @return Amount of warnings this spawner has
	 */
	
	int warnings();
	
	/**
	 * Validates the spawner.
	 * 
	 * @return True if the spawner can spawn
	 */
	
	boolean validate();
	
	/**
	 * Validates and find all valid spawning locations.
	 * 
	 * @param count - entity count
	 * @return List of valid locations, can be empty
	 */
	
	List<Location> find(int count);
	
	/**
	 * Clears all warnings and the hologram.
	 */
	
	void clear();

}
