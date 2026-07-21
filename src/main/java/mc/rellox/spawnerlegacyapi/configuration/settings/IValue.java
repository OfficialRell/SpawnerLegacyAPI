package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;

import java.util.stream.Stream;

public interface IValue<T> extends ILoad {

	T get(IFilterContext context);

	Stream<T> stream();

}
