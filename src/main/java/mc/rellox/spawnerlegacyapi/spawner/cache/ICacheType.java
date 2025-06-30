package mc.rellox.spawnerlegacyapi.spawner.cache;

import java.util.UUID;

import org.bukkit.block.CreatureSpawner;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ICacheType<T> {

	// constants

	static ICacheType<SpawnerType> TYPE = SLAPI.get().cache().of(0);
	static ICacheType<UUID> OWNER = SLAPI.get().cache().of(1);
	static ICacheType<Integer> STACK = SLAPI.get().cache().of(2);
	static ICacheType<double[]> UPGRADES = SLAPI.get().cache().of(3);
	static ICacheType<int[]> LEVELS = SLAPI.get().cache().of(4);
	static ICacheType<Integer> CHARGES = SLAPI.get().cache().of(5);
	static ICacheType<Integer> SPAWNABLE = SLAPI.get().cache().of(6);
	static ICacheType<Boolean> EMPTY = SLAPI.get().cache().of(7);
	static ICacheType<Boolean> ENABLED = SLAPI.get().cache().of(8);
	static ICacheType<String> METADATA = SLAPI.get().cache().of(9);
	static ICacheType<Integer> TAGS = SLAPI.get().cache().of(10);
	static ICacheType<Boolean> GENERATED = SLAPI.get().cache().of(11);

	// class methods

	/**
	 * Reads the value from the spawner.
	 * 
	 * @param spawner - spawner
	 * 
	 * @return Newly read value
	 */

	T read(CreatureSpawner spawner);

	/**
	 * Writes the value to the spawner.
	 * 
	 * @param generator - generator
	 * @param spawner - spawner
	 * @param value - new value
	 */

	void write(CreatureSpawner spawner, T value);

	/**
	 * @return Type index
	 */

	int index();

}
