package mc.rellox.spawnerlegacyapi.manager;

import org.bukkit.Material;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.utility.region.type.EntityBox;

public interface ISettingsManager {
	
	EntityBox slimeMultibox();
	
	EntityBox magmaMultibox();
	
	Material material(SpawnerType type, Material def);

}
