package mc.rellox.spawnerlegacyapi.spawner.requirement;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Waterlogged;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IMaterial {
	
	IMaterial empty = block -> true;
	IMaterial air = block -> {
		Material type = block.getType();
		return type.getHardness() <= 0 || type.isAir();
	};
	IMaterial solid = block -> block.getType().isSolid();
	IMaterial water = block -> {
		var type = block.getType();
		if(type == Material.WATER) return true;
		if(type.getHardness() > 0) return false;
		if(block.getBlockData() instanceof Waterlogged) return true;
		if(block.getBlockData() instanceof Waterlogged) return true;
		return type == Material.SEAGRASS || type == Material.TALL_SEAGRASS
				|| type == Material.KELP_PLANT;
	};
	IMaterial slab = block -> block.getType().name().endsWith("_SLAB");
	IMaterial stairs = block -> block.getType().name().endsWith("_STAIRS");
	IMaterial fence = block -> block.getType().name().endsWith("_FENCE")
			|| block.getType().name().endsWith("_FENCE_GATE")
			|| block.getType().name().endsWith("_WALL");
	
	static IMaterial is(final Material material) {
		return block -> block.getType() == material;
	}
	
	static IMaterial is(Collection<Material> is) {
		if(is.size() == 1) return is(is.toArray(Material[]::new)[0]);
		final Set<Material> set = new HashSet<>(is);
		return block -> set.contains(block.getType());
	}
	
	static IMaterial not(final Material material) {
		return block -> block.getType() != material;
	}
	
	static IMaterial not(Collection<Material> not) {
		if(not.size() == 1) return not(not.toArray(Material[]::new)[0]);
		final Set<Material> set = new HashSet<>(not);
		return block -> !set.contains(block.getType());
	}
	
	static IMaterial any(List<IMaterial> list) {
		if(list.size() == 1) return list.getFirst();
		return block -> list.stream().anyMatch(i -> i.is(block));
	}
	
	static IMaterial all(List<IMaterial> list) {
		if(list.size() == 1) return list.getFirst();
		return block -> list.stream().allMatch(i -> i.is(block));
	}
	
	/**
	 * @param block block to check
	 * @return {@code true} if this block matches
	 */
	
	boolean is(Block block);
	
	/**
	 * @return The negated material predicate
	 */
	
	default IMaterial negate() {
		return block -> !is(block);
	}

}
