package mc.rellox.spawnerlegacyapi.event.block;

import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.event.IPriceEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerGeneratorEvent;
import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

public class SpawnerInteractEvent extends SpawnerGeneratorEvent implements IPriceEvent {
	
	public final InteractAction action;
	
	private IPrice price;
	
	public SpawnerInteractEvent(Player player, IGenerator generator, InteractAction action, IPrice price) {
		super(player, generator);
		this.action = action;
		
		this.price = price;
	}

	@Override
	public IPrice price() {
		return price;
	}

	@Override
	public void price(IPrice price) {
		this.price = price;
	}
	
	public static enum InteractAction {
		
		/**
		 * When a player breaks a spawner.
		 */
		BREAK,
		/**
		 * When a player changes the type of a spawner.
		 */
		CHANGE,
		/**
		 * When a player stacks to a spawner.
		 */
		STACK;
		
	}

}
