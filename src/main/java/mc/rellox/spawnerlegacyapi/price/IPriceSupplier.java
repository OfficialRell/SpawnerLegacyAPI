package mc.rellox.spawnerlegacyapi.price;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface IPriceSupplier {

    /**
     * Creates a price with the given value.
     *
     * @param value value
     * @return Created price
     */

    IPrice of(double value);

    /**
     * @param player player
     * @return Player balance
     */

    double balance(Player player);

    /**
     * @param id player ID
     * @return Player balance or -1 if it cannot be determined
     */

    double balance(UUID id);

}
