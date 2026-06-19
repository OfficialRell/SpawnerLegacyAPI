package mc.rellox.spawnerlegacyapi.spawner.meta;

import mc.rellox.spawnerlegacyapi.spawner.display.IGeneratorName;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

/**
 * Deprecated, use {@link IGeneratorName} instead.
 */

@Deprecated(since = "2.0.0", forRemoval = true)
public interface IDisplay {

	@Deprecated(since = "2.0.0", forRemoval = true)
	static IDisplay of(SpawnerType type) {
		IContent name = type.formatted();
		return () -> name;
	}

	@Deprecated(since = "2.0.0", forRemoval = true)
	IContent display();
	
}
