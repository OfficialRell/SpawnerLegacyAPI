package mc.rellox.spawnerlegacyapi.spawner.virtual;

import org.bukkit.Material;

import java.util.Map;

public interface IVirtualRolls {

    /**
     * Number of rolls that were used to generate the items and XP.
     *
     * @return Number of rolls
     */

    long rolls();

    /**
     * Returns the generated items and their amounts.
     *
     * @return Map of items and their amounts
     */

    Map<Material, Long> items();

    /**
     * Returns the amount of XP generated.
     *
     * @return Amount of XP generated
     */

    long xp();

}
