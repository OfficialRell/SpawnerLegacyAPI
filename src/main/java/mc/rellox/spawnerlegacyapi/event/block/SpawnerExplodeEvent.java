package mc.rellox.spawnerlegacyapi.event.block;

import mc.rellox.spawnerlegacyapi.event.IGeneratorEvent;
import mc.rellox.spawnerlegacyapi.event.SpawnerEvent;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;

/**
 * An event that is called when a spawner explodes.
 */

public class SpawnerExplodeEvent extends SpawnerEvent implements IGeneratorEvent {
	
	private final IGenerator generator;
	public final ExplosionType explosion;
	private final boolean[] bs;
	
	public SpawnerExplodeEvent(IGenerator generator, ExplosionType explosion, boolean[] bs) {
		this.generator = generator;
		this.explosion = explosion;
		this.bs = bs;
	}
	
	@Override
	public final IGenerator generator() {
		return generator;
	}
	
	public boolean canBreakOwned() {
		return bs[0];
	}
	
	public void setBreakOwned(boolean b) {
		bs[0] = b;
	}
	
	public boolean canDropOwned() {
		return bs[1];
	}
	
	public void setDropOwned(boolean b) {
		bs[1] = b;
	}
	
	public boolean canBreakNatural() {
		return bs[2];
	}
	
	public void setBreakNatural(boolean b) {
		bs[2] = b;
	}
	
	public boolean canDropNatural() {
		return bs[3];
	}
	
	public void setDropNatural(boolean b) {
		bs[3] = b;
	}
	
	public enum ExplosionType {
		
		TNT, CREEPERS, FIREBALLS, END_CRYSTALS, WITHER;

	}

}
