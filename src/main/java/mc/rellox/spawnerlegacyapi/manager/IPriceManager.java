package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;
import java.util.function.Consumer;

import mc.rellox.spawnerlegacyapi.price.Group;
import mc.rellox.spawnerlegacyapi.price.IDefinedItem;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.price.IPriceSupplier;
import mc.rellox.spawnerlegacyapi.price.PriceType;

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
	 * @return Price supplier or {@code null}
	 */
	
	IPriceSupplier of(String key);

	/**
	 * @param group - group
	 * @return Price supplier, never {@code null}
	 */
	
	IPriceSupplier of(Group group);
	
	/**
	 * @param type - price type
	 * @return Price supplier or {@code null}
	 */
	
	IPriceSupplier of(PriceType type);

	/**
	 * @param group - group
	 * @param value - value
	 * @return Created price
	 */
	
	IPrice price(Group group, double value);
	
	/**
	 * @return All defined items
	 */
	
	List<IDefinedItem> items();
	
	/**
	 * @param key - item key
	 * @return Defined item or {@code null}
	 */
	
	IDefinedItem item(String key);

	/**
	 * Use {@link IPriceSupplier} instead.
	 */
	
	@Deprecated(since = "1.4.12", forRemoval = true)
	public static interface IPriceProvider {

		@Deprecated(since = "1.4.12", forRemoval = true)
		IPrice of(double value);

	}

}
