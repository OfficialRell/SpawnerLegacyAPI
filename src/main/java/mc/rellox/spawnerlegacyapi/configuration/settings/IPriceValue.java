package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;
import mc.rellox.spawnerlegacyapi.price.IPrice;

import java.util.stream.Stream;

public interface IPriceValue extends ILoad {

	IPrice get(IFilterContext context);

	Stream<IPrice> stream();

}
