package mc.rellox.spawnerlegacyapi.registry;

import org.bukkit.NamespacedKey;

public enum KeyType {
	
	SPAWNER_TYPE("type"),
	SPAWNER_OWNER("owner"),
	SPAWNER_STACK("stack"),
	SPAWNER_UPGRADES("upgrades"),
	SPAWNER_LEVELS("levels"),
	SPAWNER_CHARGES("charges"),
	SPAWNER_SPAWNABLE("spawnable"),
	SPAWNER_EMPTY("empty"),
	SPAWNER_ENABLED("enabled"),
	SPAWNER_METADATA("metadata"),
	SPAWNER_TAGS("tags"),
	SPAWNER_GENERATED("generated"),

	ITEM_NAME("item_name"),
	ITEM_LORE("item_lore"),
	
	ENTITY_BY_SPAWNER("by_spawner"),
	ENTITY_XP("upgrade_xp"),
	ENTITY_DROPS("upgrade_drops"),
	
	ENTITY_STACK("stack_size"),

	TOOL_ID("tool"),
	
	CROWBAR_USAGE("usage"),
	CROWBAR_CHANCE("chance"),
	
	RANDOM("random");
	
	public final String key;
	
	private KeyType(String key) {
		this.key = key;
	}
	
	public NamespacedKey key() {
		return Keys.of(this);
	}

}
