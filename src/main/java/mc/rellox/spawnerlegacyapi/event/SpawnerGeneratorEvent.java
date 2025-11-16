package mc.rellox.spawnerlegacyapi.event;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public abstract class SpawnerGeneratorEvent extends SpawnerPlayerEvent implements IGeneratorEvent {

	protected final IGenerator generator;
	
	public SpawnerGeneratorEvent(Player player, IGenerator generator) {
		super(player);
		this.generator = generator;
	}

	@Override
	public final IGenerator generator() {
		return generator;
	}

}
