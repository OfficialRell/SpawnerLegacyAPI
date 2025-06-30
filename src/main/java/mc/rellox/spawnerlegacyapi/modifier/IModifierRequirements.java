package mc.rellox.spawnerlegacyapi.modifier;

import java.util.Set;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IModifierRequirements {
	
	int level();
	
	Set<SpawnerType> types();
	
	boolean invert();
	
	default boolean allow(SpawnerType type) {
		return types().contains(type) == invert();
	}

}
