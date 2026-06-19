package mc.rellox.spawnerlegacyapi.spawner.summoner;

import mc.rellox.spawnerlegacyapi.metadata.entity.IMetadataExecution;
import org.bukkit.entity.Entity;

import java.util.List;

public interface ISummonResult {

    /**
     * @return List of all spawned entities
     */

    List<Entity> entities();

    /**
     * @return If no entities were spawned
     */

    default boolean empty() {
        return entities().isEmpty();
    }

    /**
     * @return Metadata execution result or {@code null}
     */

    IMetadataExecution metadata();

}
