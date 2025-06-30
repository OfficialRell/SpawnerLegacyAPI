package mc.rellox.spawnerlegacyapi.spawner;

import mc.rellox.spawnerlegacyapi.entity.IStackedEntity;

public interface ILinkable {
	
	/**
	 * @return Is linking enabled
	 */
	
	boolean linkable();
	
	/**
	 * @return Linking radius or {@code 0} if disabled
	 */
	
	int radius();
	
	/**
	 * Returns and checks the linked stacked entity.
	 * 
	 * @return Linked stacked entity or {@code null}
	 */
	
	IStackedEntity linked();
	
	/**
	 * Sets the new linked entity.
	 * 
	 * @param stacked - stacked entity
	 */
	
	void link(IStackedEntity stacked);
	
	/**
	 * Clears the linked entity.
	 */
	
	void unlink();

}
