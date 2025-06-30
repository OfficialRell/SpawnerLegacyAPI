package mc.rellox.spawnerlegacyapi.item.tool;

import java.util.Set;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ICrowbarIgnore {
	
	/**
	 * @return Set of ignored spawner types
	 */
	
	Set<SpawnerType> types();
	
	/**
	 * @return Set of ignored worlds
	 */
	
	Set<String> worlds();

}
