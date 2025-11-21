package mc.rellox.spawnerlegacyapi.manager;

import java.util.function.Consumer;

import mc.rellox.spawnerlegacyapi.price.Group;
import mc.rellox.spawnerlegacyapi.price.IPrice;

public interface IPriceManager {
	
	/**
	 * Returned price is 100 x experience points.
	 * 
	 * @return Default price
	 */
	
	IPrice defaulted();

	/**
	 * Parses the key into a price.
	 * 
	 * @param group - group
	 * @param key - key
	 * @return Parsed price or default
	 */
	
	IPrice parse(Group group, String key);

	/**
	 * @param group - group
	 * @param key - key
	 * @param error - error consumer
	 * @return Parsed price or default
	 */
	
	IPrice parse(Group group, String key, Consumer<String> error);

	/**
	 * @param key - key
	 * @return Price provider or {@code null}
	 */
	
	IPriceProvider of(String key);

	/**
	 * @param group - group
	 * @return Price provider, never {@code null}
	 */
	
	IPriceProvider of(Group group);

	/**
	 * @param group - group
	 * @param value - value
	 * @return Created price
	 */
	
	IPrice price(Group group, double value);

	public static interface IPriceProvider {

		IPrice of(double value);

	}

}
