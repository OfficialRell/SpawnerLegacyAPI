package mc.rellox.spawnerlegacyapi.event;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ISpawnerTypeChangeEvent extends IEvent {
	
	/**
	 * @return Cause of the spawner type change
	 */
	
	ChangeCauseType cause();
	
	/**
	 * @return Original spawner type
	 */
	
	SpawnerType from();
	
	/**
	 * @return New spawner type
	 */
	
	SpawnerType to();
	
	/**
	 * Sets the new spawner type.
	 * 
	 * @param to - new type
	 */
	
	void to(SpawnerType to);
	
	public enum ChangeCauseType {
		
		SPAWN_EGG,
		TYPES_GUI,
		COMMAND;
		
	}

}
