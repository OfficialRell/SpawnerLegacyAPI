package mc.rellox.spawnerlegacyapi.event;

/**
 * An event that can be canceled.
 */

public abstract class SpawnerEvent implements IEvent {
	
	private boolean cancelled;

	/**
	 * Should this event be canceled.
	 * 
	 * @param cancel - cancel
	 */
	
	public final void cancel(boolean cancel) {
		cancelled = cancel;
	}

	/**
	 * @return {@code true} if the event should be canceled
	 */
	
	public final boolean cancelled() {
		return cancelled;
	}

}
