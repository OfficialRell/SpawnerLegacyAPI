package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IValueHeld<J> extends IValue<IHeldValue<J>> {
	
	default J get(SpawnerType type, HolderType holder) {
		return get(type).get(holder);
	}
	
}
