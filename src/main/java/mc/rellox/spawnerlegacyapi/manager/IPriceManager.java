package mc.rellox.spawnerlegacyapi.manager;

import java.util.function.Consumer;

import mc.rellox.spawnerlegacyapi.price.Group;
import mc.rellox.spawnerlegacyapi.price.IPrice;

public interface IPriceManager {

	IPrice parse(Group group, String key);

	IPrice parse(Group group, String key, Consumer<String> error);

	IPriceProvider of(String key);

	IPriceProvider of(Group group);

	IPrice price(Group group, double value);

	public static interface IPriceProvider {

		IPrice of(double i);

	}

}
