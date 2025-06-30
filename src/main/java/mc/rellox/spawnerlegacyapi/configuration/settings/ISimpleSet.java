package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.Set;

public interface ISimpleSet<T> extends ILoad {
	
	Set<T> set();
	
	default boolean is(T value) {
		return set().contains(value) == true;
	}
	
	default boolean not(T value) {
		return set().contains(value) == false;
	}

}
