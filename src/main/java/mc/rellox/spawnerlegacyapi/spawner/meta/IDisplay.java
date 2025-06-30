package mc.rellox.spawnerlegacyapi.spawner.meta;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface IDisplay {
	
	static IDisplay of(SpawnerType type) {
		IContent name = type.formatted();
		return () -> name;
	}

	/**
	 * @return Spawner disaply name
	 */
	
	IContent display();
	
}
