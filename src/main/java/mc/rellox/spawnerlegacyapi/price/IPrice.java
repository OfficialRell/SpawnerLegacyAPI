package mc.rellox.spawnerlegacyapi.price;

import java.util.UUID;
import java.util.function.DoubleUnaryOperator;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface IPrice {
	
	/**
	 * @return Type of this price
	 */
	
	PriceType type();
	
	/**
	 * @return Rounded price integer value
	 */
	
	int value();
	
	/**
	 * @return Precise price value
	 */
	
	double precise();
	
	/**
	 * @param player - player
	 * @return The balance the player has
	 */
	
	int balance(Player player);
	
	/**
	 * @param id - player id
	 * @return The balance the player has or -1 if cannot be determined
	 */
	
	int balance(UUID id);
	
	/**
	 * @param player - player
	 * @return {@code true} if this player has the price value in their balance
	 */
	
	boolean has(Player player);
	
	/**
	 * Removes the price value from the player's balance.
	 * 
	 * @param player - player
	 */
	
	void remove(Player player);
	
	/**
	 * @return Insufficient text
	 */
	
	IContent insufficient();
	
	/**
	 * @return Formatted value text
	 */
	
	IContent text();
	
	/**
	 * @param player - player
	 * @return Text with the required balance
	 */
	
	IContent requires(Player player);
	
	/**
	 * Adds this price value to the player's balance.
	 * 
	 * @param player - player
	 */
	
	void refund(Player player);
	
	/**
	 * Returns a new price object using the unary operator.
	 * 
	 * @param operator - value operator
	 * @return The new price object
	 */
	
	IPrice copy(DoubleUnaryOperator operator);
	
	/**
	 * @param value - value to set
	 * @return Price with the value
	 */
	
	default IPrice set(double value) {
		return copy(i -> value);
	}
	
	/**
	 * @param value - value to add
	 * @return Price with the added value
	 */
	
	default IPrice add(double value) {
		return copy(i -> i + value);
	}
	
	/**
	 * @param value - value to subtract
	 * @return Price with the substracted value
	 */
	
	default IPrice subtract(double value) {
		return copy(i -> i - value);
	}
	
	/**
	 * @param value - value to multiply
	 * @return Price with the multiplied value
	 */
	
	default IPrice multiply(double value) {
		return copy(i -> i * value);
	}
	
	/**
	 * @param price - price to add
	 * @return Price with the other price added
	 */
	
	default IPrice add(IPrice price) {
		return copy(i -> i + price.precise());
	}

}
