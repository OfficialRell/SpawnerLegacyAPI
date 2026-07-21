package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;

import java.util.stream.Stream;

public interface IBooleanValue extends ILoad {

	boolean get(IFilterContext context);
	
	boolean any(boolean b);

	Stream<Boolean> stream();
	
}
