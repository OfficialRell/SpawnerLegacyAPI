package mc.rellox.spawnerlegacyapi.registry;

import mc.rellox.spawnerlegacyapi.SLAPI;
import org.bukkit.NamespacedKey;

public interface IKey {

    static IKey of(String key) {
        return new Key(key);
    }

    IKey SPAWNER_TYPE = of("type");
    IKey SPAWNER_OWNER = of("owner");
    IKey SPAWNER_STACK = of("stack");
    IKey SPAWNER_UPGRADES = of("upgrades");
    IKey SPAWNER_LEVELS = of("levels");
    IKey SPAWNER_CHARGES = of("charges");
    IKey SPAWNER_SPAWNABLE = of("spawnable");
    IKey SPAWNER_EMPTY = of("empty");
    IKey SPAWNER_ENABLED = of("enabled");
    IKey SPAWNER_METADATA = of("metadata");
    IKey SPAWNER_TAGS = of("tags");
    IKey SPAWNER_GENERATED = of("generated");

    IKey ITEM_NAME = of("item_name");
    IKey ITEM_LORE = of("item_lore");

    IKey ENTITY_BY_SPAWNER = of("by_spawner");
    IKey ENTITY_XP = of("upgrade_xp");
    IKey ENTITY_DROPS = of("upgrade_drops");
    IKey ENTITY_MODIFIED = of("modified");

    IKey ENTITY_STACK = of("stack_size");

    IKey TOOL_ID = of("tool");

    IKey CROWBAR_USAGE = of("usage");
    IKey CROWBAR_CHANCE = of("chance");

    IKey MODIFIER_KEY = of("modifier_key");

    IKey DEFINED_ITEM = of("defined_item");

    IKey RANDOM = of("random");

    NamespacedKey get();

    class Key implements IKey {

        private final String key;
        private NamespacedKey namespaced_key;

        public Key(String key) {
            this.key = key;
        }

        @Override
        public NamespacedKey get() {
            if(namespaced_key == null)
                namespaced_key = new NamespacedKey(SLAPI.plugin(), key);
            return namespaced_key;
        }
    }

}
