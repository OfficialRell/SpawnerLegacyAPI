package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.hologram.IHologram;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public interface IHologramManager {
	
	IHologram identity(IGenerator generator);
	
	IHologram warning(IGenerator generator);
	
	IHologram countdown(IGenerator generator);

}
