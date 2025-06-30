package mc.rellox.spawnerlegacyapi.spawner.location;

import java.util.List;
import java.util.function.Supplier;

import org.bukkit.block.Block;

import mc.rellox.spawnerlegacyapi.utility.Calculate;

public interface ISelector extends Supplier<Block> {
	
//	static ISelector of(SpawnerType type, List<Block> list) {
//		return Settings.settings.spawning_type.get(type).get(list);
//	}
	
	enum Selection {
		SINGLE {
			@Override
			public ISelector get(List<Block> list) {
				Block block = Calculate.random(list);
				return () -> block;
			}
		}, SPREAD {
			@Override
			public ISelector get(List<Block> list) {
				return () -> Calculate.random(list);
			}
		}, ABOVE {
			@Override
			public ISelector get(List<Block> list) {
				return () -> list.get(0);
			}
		};
		
		
		/**
		 * @param list - list of blocks
		 * @return New block location selector
		 */
		
		public abstract ISelector get(List<Block> list);
	}

}
