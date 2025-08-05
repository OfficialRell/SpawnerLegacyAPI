package mc.rellox.spawnerlegacyapi.spawner.type;

import java.util.stream.Stream;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import mc.rellox.spawnerlegacyapi.utility.region.IEntityMulitbox;
import mc.rellox.spawnerlegacyapi.utility.region.type.EntityBox;

public enum SpawnerType {
	
	EMPTY(EntityType.AREA_EFFECT_CLOUD, "EMPTY", null, true, EntityBox.empty),

	ALLAY(_e("ALLAY"), "Allay", _m("ALLAY_SPAWN_EGG"), EntityBox.single),
	ARMADILLO(_e("ARMADILLO"), "Armadillo", _m("ARMADILLO_SPAWN_EGG"), EntityBox.single),
	ARMOR_STAND(EntityType.ARMOR_STAND, "Armor Stand", Material.ARMOR_STAND, true, EntityBox.doubled),
	AXOLOTL(_e("AXOLOTL"), "Axolotl", _m("AXOLOTL_SPAWN_EGG"), EntityBox.single),
	BAT(EntityType.BAT, "Bat", Material.BAT_SPAWN_EGG, EntityBox.single),
	BEE(_e("BEE"), "Bee", _m("BEE_SPAWN_EGG"), EntityBox.single),
	BLAZE(EntityType.BLAZE, "Blaze", Material.BLAZE_SPAWN_EGG, EntityBox.doubled),
	BOAT(_e("OAK_BOAT", "BOAT"), "Boat", Material.OAK_BOAT, true, EntityBox.box(2, 1, 2)),
	BOGGED(_e("BOGGED"), "Bogged", _m("BOGGED_SPAWN_EGG"), EntityBox.doubled),
	BREEZE(_e("BREEZE"), "Breeze", _m("BREEZE_SPAWN_EGG"), EntityBox.doubled),
	CAMEL(_e("CAMEL"), "Camel", _m("CAMEL_SPAWN_EGG"), EntityBox.box(2, 3, 2)),
	CAT(_e("CAT"), "Cat", _m("CAT_SPAWN_EGG"), EntityBox.single),
	CAVE_SPIDER(EntityType.CAVE_SPIDER, "Cave Spider", Material.CAVE_SPIDER_SPAWN_EGG, EntityBox.single),
	CHEST_BOAT(_e("CHEST_BOAT"), "Boat with Chest", null, true, EntityBox.box(2, 1, 2)),
	CHICKEN(EntityType.CHICKEN, "Chicken", Material.CHICKEN_SPAWN_EGG, EntityBox.single),
	COD(EntityType.COD, "Cod", Material.COD_SPAWN_EGG, EntityBox.single),
	COW(EntityType.COW, "Cow", Material.COW_SPAWN_EGG, EntityBox.doubled),
	CREAKING(_e("CREAKING"), "Creaking", _m("CREAKING_SPAWN_EGG"), EntityBox.box(1, 3, 1)),
	CREEPER(EntityType.CREEPER, "Creeper", Material.CREEPER_SPAWN_EGG, EntityBox.doubled),
	DOLPHIN(EntityType.DOLPHIN, "Dolphin", Material.DOLPHIN_SPAWN_EGG, EntityBox.single),
	DONKEY(EntityType.DONKEY, "Donkey", Material.DONKEY_SPAWN_EGG, EntityBox.doubled),
	DROWNED(EntityType.DROWNED, "Drowned", Material.DROWNED_SPAWN_EGG, EntityBox.doubled),
	ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN, "Elder Guardian", Material.ELDER_GUARDIAN_SPAWN_EGG, EntityBox.box(2, 2, 2)),
	ENDERMAN(EntityType.ENDERMAN, "Enderman", Material.ENDERMAN_SPAWN_EGG, EntityBox.box(1, 3, 1)),
	ENDERMITE(EntityType.ENDERMITE, "Endermite", Material.ENDERMITE_SPAWN_EGG, EntityBox.single),
	ENDER_DRAGON(EntityType.ENDER_DRAGON, "Ender Dragon", null, true, EntityBox.box(16, 8, 16)),
	EVOKER(EntityType.EVOKER, "Evoker", Material.EVOKER_SPAWN_EGG, EntityBox.doubled),
	EXPERIENCE_BOTTLE(_e("THROWN_EXP_BOTTLE", "EXPERIENCE_BOTTLE"), "Experience Bottle", Material.EXPERIENCE_BOTTLE, true, EntityBox.single),
	EXPERIENCE_ORB(EntityType.EXPERIENCE_ORB, "Experience Orb", null, true, EntityBox.single),
	FOX(_e("FOX"), "Fox", _m("FOX_SPAWN_EGG"), EntityBox.single),
	FROG(_e("FROG"), "Frog", _m("FROG_SPAWN_EGG"), EntityBox.single),
	GHAST(EntityType.GHAST, "Ghast", Material.GHAST_SPAWN_EGG, EntityBox.box(4, 4, 4)),
	GIANT(EntityType.GIANT, "Giant", null, true, EntityBox.box(4, 12, 4)),
	GLOW_SQUID(_e("GLOW_SQUID"), "Glow Squid", _m("GLOW_SQUID_SPAWN_EGG"), EntityBox.single),
	GOAT(_e("GOAT"), "Goat", _m("GOAT_SPAWN_EGG"), EntityBox.doubled),
	GUARDIAN(EntityType.GUARDIAN, "Guardian", Material.GUARDIAN_SPAWN_EGG, EntityBox.single),
	HAPPY_GHAST(_e("HAPPY_GHAST"), "Happy Ghast", _m("HAPPY_GHAST_SPAWN_EGG"), EntityBox.box(4, 4, 4)),
	HOGLIN(_e("HOGLIN"), "Hoglin", _m("HOGLIN_SPAWN_EGG"), EntityBox.box(2, 2, 2)),
	HORSE(EntityType.HORSE, "Horse", Material.HORSE_SPAWN_EGG, EntityBox.doubled),
	HUSK(EntityType.HUSK, "Husk", Material.HUSK_SPAWN_EGG, EntityBox.doubled),
	ILLUSIONER(EntityType.ILLUSIONER, "Illusioner", null, EntityBox.doubled),
	IRON_GOLEM(EntityType.IRON_GOLEM, "Iron Golem", _m("IRON_GOLEM_SPAWN_EGG"), EntityBox.box(2, 3, 2)),
	LLAMA(EntityType.LLAMA, "Llama", Material.LLAMA_SPAWN_EGG, EntityBox.doubled),
	MAGMA_CUBE(EntityType.MAGMA_CUBE, "Magma Cube", Material.MAGMA_CUBE_SPAWN_EGG, SLAPI.get().spawners().magmaBox()),
	MINECART(EntityType.MINECART, "Minecart", Material.MINECART, true, EntityBox.single),
	MINECART_CHEST(_e("MINECART_CHEST", "CHEST_MINECART"), "Minecart with Chest", Material.CHEST_MINECART, true, EntityBox.single),
	MINECART_COMMAND(_e("MINECART_COMMAND", "COMMAND_BLOCK_MINECART"), "Minecart with Command Block", Material.COMMAND_BLOCK_MINECART, true, EntityBox.single),
	MINECART_FURNACE(_e("MINECART_FURNACE", "FURNACE_MINECART"), "Minecart with Furnace", Material.FURNACE_MINECART, true, EntityBox.single),
	MINECART_HOPPER(_e("MINECART_HOPPER", "HOPPER_MINECART"), "Minecart with Hopper", Material.HOPPER_MINECART, true, EntityBox.single),
	MINECART_SPAWNER(_e("MINECART_MOB_SPAWNER", "SPAWNER_MINECART"), "Minecart with Spawner", null, true, EntityBox.single),
	MINECART_TNT(_e("MINECART_TNT", "TNT_MINECART"), "Minecart with TNT", Material.TNT_MINECART, true, EntityBox.single),
	MULE(EntityType.MULE, "Mule", Material.MULE_SPAWN_EGG, EntityBox.doubled),
	MUSHROOM_COW(_e("MUSHROOM_COW", "MOOSHROOM"), "Mushroom Cow", Material.MOOSHROOM_SPAWN_EGG, EntityBox.doubled),
	OCELOT(EntityType.OCELOT, "Ocelot", Material.OCELOT_SPAWN_EGG, EntityBox.single),
	PANDA(_e("PANDA"), "Panda", _m("PANDA_SPAWN_EGG"), EntityBox.box(2, 2, 2)),
	PARROT(EntityType.PARROT, "Parrot", Material.PARROT_SPAWN_EGG, EntityBox.single),
	PHANTOM(EntityType.PHANTOM, "Phantom", Material.PHANTOM_SPAWN_EGG, EntityBox.single),
	PIG(EntityType.PIG, "Pig", Material.PIG_SPAWN_EGG, EntityBox.single),
	PIGLIN(_e("PIGLIN"), "Piglin", _m("PIGLIN_SPAWN_EGG"), EntityBox.doubled),
	PIGLIN_BRUTE(_e("PIGLIN_BRUTE"), "Piglin Brute", _m("PIGLIN_BRUTE_SPAWN_EGG"), EntityBox.doubled),
	PIG_ZOMBIE(_e("PIG_ZOMBIE"), "Pig Zombie", _m("ZOMBIE_PIGMAN_SPAWN_EGG"), EntityBox.doubled),
	PILLAGER(_e("PILLAGER"), "Pillager", _m("PILLAGER_SPAWN_EGG"), EntityBox.doubled),
	POLAR_BEAR(EntityType.POLAR_BEAR, "Polar Bear", Material.POLAR_BEAR_SPAWN_EGG, EntityBox.box(2, 2, 2)),
	PUFFERFISH(EntityType.PUFFERFISH, "Pufferfish", Material.PUFFERFISH_SPAWN_EGG, EntityBox.single),
	RABBIT(EntityType.RABBIT, "Rabbit", Material.RABBIT_SPAWN_EGG, EntityBox.single),
	RAVAGER(_e("RAVAGER"), "Ravager", _m("RAVAGER_SPAWN_EGG"), EntityBox.box(2, 3, 2)),
	SALMON(EntityType.SALMON, "Salmon", Material.SALMON_SPAWN_EGG, EntityBox.single),
	SHEEP(EntityType.SHEEP, "Sheep", Material.SHEEP_SPAWN_EGG, EntityBox.doubled),
	SHULKER(EntityType.SHULKER, "Shulker", Material.SHULKER_SPAWN_EGG, EntityBox.single),
	SILVERFISH(EntityType.SILVERFISH, "Silverfish", Material.SILVERFISH_SPAWN_EGG, EntityBox.single),
	SKELETON(EntityType.SKELETON, "Skeleton", Material.SKELETON_SPAWN_EGG, EntityBox.doubled),
	SKELETON_HORSE(EntityType.SKELETON_HORSE, "Skeleton Horse", Material.SKELETON_HORSE_SPAWN_EGG, EntityBox.doubled),
	SLIME(EntityType.SLIME, "Slime", Material.SLIME_SPAWN_EGG, SLAPI.get().spawners().slimeBox()),
	SNIFFER(_e("SNIFFER"), "Sniffer", _m("SNIFFER_SPAWN_EGG"), EntityBox.box(2, 2, 2)),
	SNOWMAN(_e("SNOWMAN", "SNOW_GOLEM"), "Snowman", _m("SNOW_GOLEM_SPAWN_EGG"), EntityBox.doubled),
	SPIDER(EntityType.SPIDER, "Spider", Material.SPIDER_SPAWN_EGG, EntityBox.box(2, 1, 2)),
	SQUID(EntityType.SQUID, "Squid", Material.SQUID_SPAWN_EGG, EntityBox.single),
	STRAY(EntityType.STRAY, "Stray", Material.STRAY_SPAWN_EGG, EntityBox.doubled),
	STRIDER(_e("STRIDER"), "Strider", _m("STRIDER_SPAWN_EGG"), EntityBox.doubled),
	TADPOLE(_e("TADPOLE"), "Tadpole", _m("TADPOLE_SPAWN_EGG"), EntityBox.single),
	TRADER_LLAMA(_e("TRADER_LLAMA"), "Trader Llama", _m("TRADER_LLAMA_SPAWN_EGG"), EntityBox.doubled),
	TROPICAL_FISH(EntityType.TROPICAL_FISH, "Tropical Fish", Material.TROPICAL_FISH_SPAWN_EGG, EntityBox.single),
	TURTLE(EntityType.TURTLE, "Turtle", Material.TURTLE_SPAWN_EGG, EntityBox.box(2, 1, 2)),
	VEX(EntityType.VEX, "Vex", Material.VEX_SPAWN_EGG, EntityBox.single),
	VILLAGER(EntityType.VILLAGER, "Villager", Material.VILLAGER_SPAWN_EGG, EntityBox.doubled),
	VINDICATOR(EntityType.VINDICATOR, "Vindicator", Material.VINDICATOR_SPAWN_EGG, EntityBox.doubled),
	WANDERING_TRADER(_e("WANDERING_TRADER"), "Wandering Trader", _m("WANDERING_TRADER_SPAWN_EGG"), EntityBox.doubled),
	WARDEN(_e("WARDEN"), "Warden", _m("WARDEN_SPAWN_EGG"), EntityBox.box(1, 3, 1)),
	WITCH(EntityType.WITCH, "Witch", Material.WITCH_SPAWN_EGG, EntityBox.doubled),
	WITHER(EntityType.WITHER, "Wither", null, EntityBox.box(1, 4, 1)),
	WITHER_SKELETON(EntityType.WITHER_SKELETON, "Wither Skeleton", Material.WITHER_SKELETON_SPAWN_EGG, EntityBox.box(1, 3, 1)),
	WOLF(EntityType.WOLF, "Wolf", Material.WOLF_SPAWN_EGG, EntityBox.single),
	ZOGLIN(_e("ZOGLIN"), "Zoglin", _m("ZOGLIN_SPAWN_EGG"), EntityBox.box(2, 2, 2)),
	ZOMBIE(EntityType.ZOMBIE, "Zombie", Material.ZOMBIE_SPAWN_EGG, EntityBox.doubled),
	ZOMBIE_HORSE(EntityType.ZOMBIE_HORSE, "Zombie Horse", Material.ZOMBIE_HORSE_SPAWN_EGG, EntityBox.doubled),
	ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER, "Zombie Villager", Material.ZOMBIE_VILLAGER_SPAWN_EGG, EntityBox.doubled),
	ZOMBIFIED_PIGLIN(_e("ZOMBIFIED_PIGLIN"), "Zombified Piglin", _m("ZOMBIFIED_PIGLIN_SPAWN_EGG"), EntityBox.doubled),
	
	ITEM(_e("DROPPED_ITEM", "ITEM"), "Item", null, true, EntityBox.single);

	private final EntityType type;
	private final String name;
	private final boolean unique;
	private final Material material;
	private final EntityBox box;

	SpawnerType(EntityType type, String name, Material material, boolean unique, EntityBox box) {
		this.type = type;
		this.name = name;
		this.material = material;
		this.box = box;
		this.unique = unique;
	}
	
	SpawnerType(EntityType type, String name, Material material, EntityBox box) {
		this(type, name, material, false, box);
	}
	
	/**
	 * @return {@code true} if this type has an existing entity type
	 */
	
	public boolean exists() {
		return type != null;
	}
	
	/**
	 * @return {@code true} if not an {@link #EMPTY} type
	 */
	
	public boolean regular() {
		return this != EMPTY && exists() == true;
	}

	/**
	 * @param name - name
	 * @return {@code true} if equals the input name
	 */
	
	public boolean equals(String name) {
		return name.equalsIgnoreCase(name);
	}

	/**
	 * @param type - entity type
	 * @return {@code true} if equals the entity type
	 */
	
	public boolean equals(EntityType type) {
		return this.type == null ? false : this.type.equals(type);
	}
	
	/**
	 * @return Entity required spawning space
	 */
	
	public EntityBox box() {
		return box instanceof IEntityMulitbox multi ? multi.box() : box;
	}
	
	/**
	 * Checks if this type is unique, such as {@link #ARMOR_STAND}, {@link #BOAT}
	 * or other none-mob type entities.
	 * 
	 * @return {@code true} if unique
	 */
	
	public boolean unique() {
		return unique;
	}

	/**
	 * @return The entity type, this can be {@code null} if the entity type does not exist
	 */
	
	public EntityType entity() {
		return type;
	}

	/**
	 * @return Raw default type name
	 */
	
	public IContent text() {
		return IContent.of(name);
	}

	/**
	 * @return Formatted name that is defined in the langauge file
	 */
	
	public IContent formatted() {
		return SLAPI.language().or("Entities.name." + name(), text());
	}
	
	/**
	 * @return The changing material or {@code null} if none
	 */
	
	public Material material() {
		return SLAPI.spawners().material(this, material);
	}
	
	/**
	 * @return {@code true} if this type is disabled
	 */
	
	public boolean disabled() {
		return SLAPI.spawners().disabled(this);
	}
	
	public static SpawnerType of(String name) {
		try {
			SpawnerType type = valueOf(name.toUpperCase());
			return type.exists() == true ? type : null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static SpawnerType of(EntityType type) {
		return stream()
				.filter(SpawnerType::regular)
				.filter(s -> s.equals(type))
				.findFirst()
				.orElse(null);
	}
	
	public static SpawnerType of(Entity entity) {
		return entity == null ? null :
			stream()
			.filter(SpawnerType::regular)
			.filter(s -> s.type == entity.getType())
			.findFirst()
			.orElse(null);
	}
	
	public static SpawnerType of(Material m) {
		return stream()
				.filter(type -> type.material() == m)
				.findFirst()
				.orElse(null);
	}
	
	public static Stream<SpawnerType> stream() {
		return Stream.of(values())
				.filter(SpawnerType::exists);
	}
	
	private static EntityType _e(String... ns) {
		return ns.length == 1 ? RF.enumerate(EntityType.class, ns[0])
				: RF.enumerate(EntityType.class, ns);
	}
	
	private static Material _m(String name) {
		return RF.enumerate(Material.class, name);
	}

}
