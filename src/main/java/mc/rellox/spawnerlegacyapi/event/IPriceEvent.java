package mc.rellox.spawnerlegacyapi.event;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.price.IPrice;

public interface IPriceEvent extends IEvent {
	
	/**
	 * @return Price or {@code null}
	 */
	
	IPrice price();
	
	/**
	 * Sets a price to this event, can be {@code null}.
	 * 
	 * @param price - price
	 */
	
	void price(IPrice price);
	
	/**
	 * Tries to withdraw the price from the player.
	 * If not price present returns {@code true}.
	 * 
	 * @param player - player
	 * @return {@code true} if the withdraw was successful
	 */
	
	default boolean withdraw(Player player) {
		IPrice price = price();
		if(price == null) return true;
		boolean has = price.has(player);
		if(has) price.remove(player);
		return has;
	}

}
