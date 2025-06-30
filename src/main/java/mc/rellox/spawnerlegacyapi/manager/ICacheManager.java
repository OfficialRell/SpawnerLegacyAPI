package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;
import java.util.function.Consumer;

import org.bukkit.block.CreatureSpawner;

import mc.rellox.spawnerlegacyapi.spawner.cache.ICacheType;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface ICacheManager {
	
	<T> ICacheType<T> of(int index);
	
	List<ICacheType<?>> all();
	
	void loop(Consumer<ICacheType<?>> action);
	
	int size();
	
	SpawnerType type(CreatureSpawner spawner);
	
}
