package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.event.EventExecutor;
import mc.rellox.spawnerlegacyapi.event.IEvent;

public interface IEventManager {
	
	/**
	 * Registers an event of the speficied class type.
	 * 
	 * @param <E> - event class type
	 * @param clazz - event class
	 * @param executor - event executor
	 * 
	 * @throws NullPointerException if event class or executor is {@code null}
	 */
	
	<E extends IEvent> void register(Class<E> clazz, EventExecutor<E> executor);

}
