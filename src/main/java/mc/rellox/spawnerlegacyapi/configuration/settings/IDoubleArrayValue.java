package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;

import java.util.stream.Stream;

public interface IDoubleArrayValue extends ILoad {

	double[] get(IFilterContext context);

	Stream<double[]> stream();

}
