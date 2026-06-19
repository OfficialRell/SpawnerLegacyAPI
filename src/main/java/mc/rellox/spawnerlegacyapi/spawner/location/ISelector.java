package mc.rellox.spawnerlegacyapi.spawner.location;

import mc.rellox.spawnerlegacyapi.utility.Calculate;
import org.bukkit.block.Block;

import java.util.List;
import java.util.function.Supplier;

public interface ISelector extends Supplier<Block> {
	
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
				var block = list.getFirst();
				return () -> block;
			}
		};
		
		/**
		 * @param list list of blocks
		 * @return New block location selector
		 */
		
		public abstract ISelector get(List<Block> list);
	}

}
