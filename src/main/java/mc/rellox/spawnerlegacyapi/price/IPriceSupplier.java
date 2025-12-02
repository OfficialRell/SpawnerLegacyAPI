package mc.rellox.spawnerlegacyapi.price;

import java.util.UUID;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.manager.IPriceManager.IPriceProvider;

@SuppressWarnings("removal")
public interface IPriceSupplier extends IPriceProvider {
	
	/**
	 * Creates a price with the given value.
	 * 
	 * @param value - value
	 * 
	 * @return Created price
	 */
	
	IPrice of(double value);
	
	/**
	 * @param player - player
	 * @return Player balance
	 */
	
	double balance(Player player);
	
	/**
	 * @param id - player id
	 * @return Player balance or -1 if cannot be determined
	 */
	
	double balance(UUID id);

}
