package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;

import java.util.stream.IntStream;

public interface IIntValue extends ILoad {

	int get(IFilterContext context);

	IntStream stream();
	
}
