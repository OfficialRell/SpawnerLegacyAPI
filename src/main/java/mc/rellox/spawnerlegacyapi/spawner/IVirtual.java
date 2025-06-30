package mc.rellox.spawnerlegacyapi.spawner;

import java.util.stream.Stream;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.spawner.IGeneratorTags.Tag;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;

public interface IVirtual {
	
	public static Builder builder(SpawnerType type) {
		return new Builder(type);
	}
	
	/**
	 * @param other - virtual spawner to compare with
	 * @return {@code true} if virtual spawners are exactly equal, otherwise {@code false}
	 */
	
	boolean exact(IVirtual other);
	
	/**
	 * @return Spawner type of this virtual spawner
	 */
	
	SpawnerType type();
	
	/**
	 * @return Upgrade levels of this virtual spawner
	 */
	
	int[] levels();
	
	/**
	 * @return Spawner charges of this virtual spawner
	 */
	
	int charges();
	
	/**
	 * @return Spawnable entity limit of this virtual spawner
	 */
	
	int spawnable();
	
	/**
	 * @return {@code true} if this virtual spawner is empty, otherwise {@code false}
	 */
	
	boolean empty();
	
	/**
	 * @return Spawner meta data or {@code null}
	 */
	
	String meta();
	
	/**
	 * @return Generator tags
	 */
	
	int tags();
	
	/**
	 * @param player - player who placed
	 */
	
	void player(Player player);
	
	/**
	 * @return Player who played
	 */
	
	Player player();
	
	/**
	 * @return The placed spawner item or {@code null}
	 */
	
	ItemStack spawner();
	
	/**
	 * @param a - amount
	 * @return Virtual spawner item stack
	 */
	
	ItemStack toItem(int a);
	
	/**
	 * @return Virtual spawner item stack
	 */
	
	default ItemStack toItem() {
		return toItem(1);
	}
	
	/**
	 * Places a natural spawner with this virtual spawner values at the specified block. 
	 * 
	 * @param block - block
	 */
	
	default void place(Block block) {
		place(null, block);
	}
	
	/**
	 * Places a natural (if owner is {@code null}) or owned spawner
	 * with this virtual spawner values at the specified block. 
	 * 
	 * @param owner - owner
	 * @param block - block
	 */
	
	default void place(Player owner, Block block) {
		SLAPI.get().spawners().place(block, owner, this);
	}
	
	class Builder {
		
		SpawnerType type;
		int[] levels;
		int charges;
		int spawnable;
		boolean empty;
		String meta;
		int tags;
		
		private Builder(SpawnerType type) {
			this.type = type;
		}
		
		public Builder levels(int[] levels) {
			this.levels = levels;
			return this;
		}
		
		public Builder charges(int charges) {
			this.charges = charges;
			return this;
		}
		
		public Builder spawnable(int spawnable) {
			this.spawnable = spawnable;
			return this;
		}
		
		public Builder empty(boolean empty) {
			this.empty = empty;
			return this;
		}
		
		public Builder meta(String meta) {
			this.meta = meta;
			return this;
		}
		
		public Builder tags(int tags) {
			this.tags = tags;
			return this;
		}
		
		public Builder tags(Tag... tags) {
			this.tags = Stream.of(tags)
					.mapToInt(Tag::index)
					.reduce(0, this::or);
			return this;
		}
		
		public IVirtual build() {
			return SLAPI.get().spawners().of(type, levels, charges, spawnable, empty, meta, tags);
		}
		
		private int or(int a, int b) {
			return a | b;
		}
		
	}

}
