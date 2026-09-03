package mc.rellox.spawnerlegacyapi.modifier.requirement;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import org.bukkit.entity.Player;

public interface IRequirementContext {

    /**
     * @return Context player
     */

    Player player();

    /**
     * @return Context generator
     */

    IGenerator generator();

}
