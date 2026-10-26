package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.spawner.virtual.IVirtualRolls;
import mc.rellox.spawnerlegacyapi.utility.IRange;

public interface IVirtualManager {

    /**
     * Returns the configured amount of XP a mob drops.<br>
     * All non-living spawner types will return 0.
     *
     * @param type type
     * @return Amount of XP a mob drops
     */

    IRange xp(SpawnerType type);

    /**
     * Generates the items and XP that would be dropped by a spawner type.<br>
     * The result is scaled to the requested amount of rolls.
     *
     * @param generator generator
     * @param rolls     number of rolls
     * @return Generated items and XP
     */

    IVirtualRolls generate(IGenerator generator, long rolls);

}
