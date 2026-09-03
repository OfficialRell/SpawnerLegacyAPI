package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.spawner.GeneratorRemoval;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.IGeneratorSnapshot;
import mc.rellox.spawnerlegacyapi.spawner.info.IInfo;
import mc.rellox.spawnerlegacyapi.spawner.world.IGeneratorWorld;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.List;
import java.util.Optional;

public interface IGeneratorManager {

    /**
     * @param world world
     * @return Information about generator in a world
     */

    IInfo info(World world);

    /**
     * @param world world
     * @return Generator world or {@code null} if disabled
     */

    IGeneratorWorld get(World world);

    /**
     * Creates a new generator at the block with generator snapshot data.<br>
     * Returns {@code null} if generators in that world are disabled.
     *
     * @param block    block
     * @param snapshot generator snapshot
     * @return Newly created generator
     */

    IGenerator put(Block block, IGeneratorSnapshot snapshot);

    /**
     * Gets existing generator at the block or creates a new one if absent.<br>
     * Returns {@code null} if generators in that world are disabled.
     *
     * @param block  block
     * @param create create if absent
     * @return New or existing generator
     */

    IGenerator get(Block block, boolean create);

    /**
     * Gets existing generator at the block.<br>
     * Does not create a new one.
     *
     * @param block block
     * @return Existing generator or {@code null} if absent
     */

    IGenerator raw(Block block);

    /**
     * Returns a list of all active generators in a world or in all worlds if {@code null} is given.
     *
     * @param world world
     * @return List of all generators in a world
     */

    List<IGenerator> list(World world);

    /**
     * Returns a list of all active generators in all worlds.
     *
     * @return List of all generators in all worlds
     */

    default List<IGenerator> list() {
        return list(null);
    }

    /**
     * @param block block
     * @return Optional generator at the block or empty if absent or inactive
     */

    Optional<IGenerator> nullable(Block block);

    /**
     * Updates generator at the block.
     *
     * @param block block
     */

    void update(Block block);

    /**
     * Updates all generators in all worlds.
     */

    void update();

    /**
     * Removes the generator only from the cache.
     *
     * @param block block
     */

    default void remove(Block block) {
        remove(block, GeneratorRemoval.CACHE);
    }

    /**
     * Removes the generator.
     *
     * @param block   block
     * @param removal removal type
     */

    void remove(Block block, GeneratorRemoval removal);

    /**
     * Removes the generator.
     * <p>
     * Deprecated, use {@link #remove(Block, GeneratorRemoval)} instead.
     *
     * @param block block
     * @param fully if {@code true}, removes spawner block
     */

    @Deprecated(since = "3.0.0", forRemoval = true)
    default void remove(Block block, boolean fully) {
        remove(block, fully ? GeneratorRemoval.ALL : GeneratorRemoval.CACHE);
    }

}
