package mc.rellox.spawnerlegacyapi.configuration.filter;

import mc.rellox.spawnerlegacyapi.metadata.IMetadata;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.spawner.type.UpgradeType;
import org.bukkit.World;
import org.bukkit.block.Block;

public interface IFilterContext {

    /**
     * @return World the spawner is in
     */

    World world();

    /**
     * @return Spawner type
     */

    SpawnerType type();

    /**
     * @return Spawner location
     */

    Block block();

    /**
     * @return {@code true} if the spawner is natural, {@code false} if it is player-owned
     */

    boolean natural();

    /**
     * @return {@code true} if the spawner is player-owned, {@code false} if it is natural
     */

    default boolean owned() {
        return !natural();
    }

    /**
     * @return Spawner upgrade level for the given upgrade type
     */

    int level(UpgradeType type);

    /**
     * @return Total spawner upgrade level
     */

    int level();

    /**
     * @return Spawner stack size
     */

    int stack();

    /**
     * @return Spawner tags
     */

    int tags();

    /**
     * @return Spawner metadata
     */

    IMetadata metadata();

}
