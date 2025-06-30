package mc.rellox.spawnerlegacyapi.event;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.ISpawner;

public interface IGeneratorEvent extends IEvent {
	
	/**
	 * @return Generator associated with this event
	 */
	
	IGenerator generator();
	
	/**
	 * @return Spawner of this generator
	 */
	
	default ISpawner spawner() {
		return generator().spawner();
	}

}
