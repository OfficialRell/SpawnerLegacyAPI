package mc.rellox.spawnerlegacyapi.event.block;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.IGeneratorSnapshot;
import org.bukkit.entity.Player;

/**
 * An event that is called a player stacks a spawner.
 */

public class SpawnerStackEvent extends SpawnerInteractEvent {

    private final IGeneratorSnapshot snapshot;
    public final boolean direct;

    public SpawnerStackEvent(Player player, IGenerator generator, IPrice price,
                             IGeneratorSnapshot virtual, boolean direct) {
        super(player, generator, InteractAction.STACK, price);
        this.snapshot = virtual;
        this.direct = direct;
    }

    /**
     * @return Generator snapshot that is being stacked
     */

    public IGeneratorSnapshot snapshot() {
        return snapshot;
    }

}
