package mc.rellox.spawnerlegacyapi.spawner.cache;

import java.util.UUID;

import org.bukkit.block.CreatureSpawner;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ICacheType<T> {

	// constants

	ICacheType<SpawnerType> TYPE = SLAPI.cache().of(0);
	ICacheType<UUID> OWNER = SLAPI.cache().of(1);
	ICacheType<Integer> STACK = SLAPI.cache().of(2);
	ICacheType<double[]> UPGRADES = SLAPI.cache().of(3);
	ICacheType<int[]> LEVELS = SLAPI.cache().of(4);
	ICacheType<Integer> CHARGES = SLAPI.cache().of(5);
	ICacheType<Integer> SPAWNABLE = SLAPI.cache().of(6);
	ICacheType<Boolean> EMPTY = SLAPI.cache().of(7);
	ICacheType<Boolean> ENABLED = SLAPI.cache().of(8);
	ICacheType<String> METADATA = SLAPI.cache().of(9);
	ICacheType<Integer> TAGS = SLAPI.cache().of(10);
	ICacheType<Boolean> GENERATED = SLAPI.cache().of(11);

	// class methods

	/**
	 * Reads the value from the spawner.
	 * 
	 * @param spawner spawner
	 * 
	 * @return Newly read value
	 */

	T read(CreatureSpawner spawner);

	/**
	 * Writes the value to the spawner.
	 *
	 * @param spawner spawner
	 * @param value new value
	 */

	void write(CreatureSpawner spawner, T value);

	/**
	 * @return Type index
	 */

	int index();

}
