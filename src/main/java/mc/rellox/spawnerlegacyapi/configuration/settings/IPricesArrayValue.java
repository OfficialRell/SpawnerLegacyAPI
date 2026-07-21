package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;
import mc.rellox.spawnerlegacyapi.price.IPrice;

import java.util.List;
import java.util.stream.Stream;

public interface IPricesArrayValue extends ILoad {

	List<IPrice[]> get(IFilterContext context);

	Stream<List<IPrice[]>> stream();

}
