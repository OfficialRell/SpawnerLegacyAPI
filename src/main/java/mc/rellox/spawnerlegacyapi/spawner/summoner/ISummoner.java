package mc.rellox.spawnerlegacyapi.spawner.summoner;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import org.bukkit.Location;

import java.util.List;

public interface ISummoner {

    /**
     * @return Spawner type
     */

    SpawnerType type();

    /**
     * Summons entities in the world and returns the summon result.
     *
     * @param locations list of locations
     * @param count     entity count
     * @return Summon result
     */

    ISummonResult summon(List<Location> locations, int count);

}
