package mc.rellox.spawnerlegacyapi.event;

public interface EventExecutor<E> {
	
	void execute(E event);

}
