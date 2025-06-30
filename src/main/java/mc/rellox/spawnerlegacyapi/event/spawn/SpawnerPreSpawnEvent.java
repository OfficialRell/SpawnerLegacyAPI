package mc.rellox.spawnerlegacyapi.event.spawn;

import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event called when a spawner tries to spawn entities.
 */

public class SpawnerPreSpawnEvent extends SpawnerEvent implements IGeneratorEvent {
	
	private final IGenerator generator;
	
	/**
	 * Entity spawn count.
	 */
	public int count;
	/**
	 * If {@code true} then this spawner will bypass charges
	 * and will not remove them.
	 */
	public boolean bypass_charges;
	/**
	 * If {@code true} then this spawner will bypass spawnable entity limit
	 * and will not remove them.
	 */
	public boolean bypass_spawnable;
	
	public SpawnerPreSpawnEvent(IGenerator generator, int count) {
		this.generator = generator;
		this.count = count;
	}
	
	@Override
	public final IGenerator generator() {
		return generator;
	}

}
