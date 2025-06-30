package mc.rellox.spawnerlegacyapi.event;

/**
 * An event that can be cancelled.
 */

public abstract class SpawnerEvent implements IEvent {
	
	private boolean cancelled;

	/**
	 * Should this event be cancelled.
	 * 
	 * @param cancel - cancel
	 */
	
	public final void cancel(boolean cancel) {
		cancelled = cancel;
	}

	/**
	 * @return {@code true} if the event should be cancelled
	 */
	
	public final boolean cancelled() {
		return cancelled;
	}

}
