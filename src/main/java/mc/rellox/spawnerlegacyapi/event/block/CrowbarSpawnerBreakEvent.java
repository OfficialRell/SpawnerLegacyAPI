package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.item.tool.ICrowbar;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * This event is called onyl for Bukkit
 * to allow other plugins to manipulate.
 */

public class CrowbarSpawnerBreakEvent extends BlockBreakEvent implements IGeneratorEvent {

	private final IGenerator generator;
	private final ICrowbar crowbar;

	public CrowbarSpawnerBreakEvent(IGenerator generator, ICrowbar crowbar, Player player) {
		super(generator.block(), player);
		this.generator = generator;
		this.crowbar = crowbar;
	}

	@Override
	public IGenerator generator() {
		return generator;
	}
	
	public ICrowbar crowbar() {
		return crowbar;
	}

}
