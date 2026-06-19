package mc.rellox.spawnerlegacyapi.spawner;

import java.util.stream.Stream;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.spawner.IGeneratorTags.Tag;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.spawner.type.UpgradeType;

@Deprecated(since = "2.0.0", forRemoval = true)
public interface IVirtual {

	@Deprecated(since = "2.0.0", forRemoval = true)
	static Builder builder(SpawnerType type) {
		return new Builder(type);
	}

	boolean exact(IGeneratorSnapshot other);

	SpawnerType type();

	int[] levels();

	int charges();

	int spawnable();

	boolean empty();

	String meta();

	int tags();

	void player(Player player);

	Player player();

	ItemStack spawner();

	ItemStack toItem(int amount);

	default ItemStack toItem() {
		return toItem(1);
	}

	void place(Block block);

	void place(Player owner, Block block);

	@Deprecated(since = "2.0.0", forRemoval = true)
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
			if(levels != null && levels.length != UpgradeType.values().length)
				throw new IllegalArgumentException("Levels array must have a length of " + UpgradeType.values().length);
			this.levels = levels;
			return this;
		}
		
		public Builder level(UpgradeType upgrade, int level) {
			if(levels == null) levels = new int[UpgradeType.values().length];
			levels[upgrade.ordinal()] = Math.max(1, level);
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
		
		public IGeneratorSnapshot build() {
			return SLAPI.spawners().of(type, levels, charges, spawnable, empty, meta, tags);
		}
		
		private int or(int a, int b) {
			return a | b;
		}
		
	}

}
