package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;

import java.util.stream.DoubleStream;

public interface IDoubleValue extends ILoad {

	double get(IFilterContext context);

	DoubleStream stream();

}
