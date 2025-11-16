package mc.rellox.spawnerlegacyapi.event;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public class SpawnerTypeChangeEvent extends SpawnerGeneratorEvent implements ISpawnerTypeChangeEvent {
	
	protected final ChangeCauseType cause;
	
	protected final SpawnerType from;
	protected SpawnerType to;

	public SpawnerTypeChangeEvent(Player player, IGenerator generator, ChangeCauseType cause,
			SpawnerType from, SpawnerType to) {
		super(player, generator);
		this.cause = cause;
		this.from = from;
		this.to = to;
	}
	
	@Override
	public ChangeCauseType cause() {
		return cause;
	}

	@Override
	public SpawnerType from() {
		return from;
	}

	@Override
	public SpawnerType to() {
		return to;
	}

	@Override
	public void to(SpawnerType to) {
		this.to = to;
	}

}
