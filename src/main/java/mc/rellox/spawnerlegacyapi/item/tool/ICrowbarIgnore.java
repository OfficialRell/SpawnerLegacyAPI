package mc.rellox.spawnerlegacyapi.item.tool;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

import java.util.Set;

public interface ICrowbarIgnore {

    /**
     * @return Set of ignored spawner types
     */

    Set<SpawnerType> types();

    /**
     * @return Set of ignored worlds
     */

    Set<String> worlds();

}
