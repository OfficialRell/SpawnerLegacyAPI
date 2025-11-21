package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.hologram.IHologram;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IHologramManager {
	
	/**
	 * Creates a new identity hologram.
	 * 
	 * @param generator - generator
	 * @return New identity hologram
	 */
	
	IHologram identity(IGenerator generator);
	
	/**
	 * Creates a new warning hologram.
	 * 
	 * @param generator - generator
	 * @return New warning hologram
	 */
	
	IHologram warning(IGenerator generator);
	
	/**
	 * Creates a new countdown hologram.
	 * 
	 * @param generator - generator
	 * @return New countdown hologram
	 */
	
	IHologram countdown(IGenerator generator);

}
