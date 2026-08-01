package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.modifier.IModifierDefinition;
import mc.rellox.spawnerlegacyapi.modifier.IModifierRegistry;
import mc.rellox.spawnerlegacyapi.modifier.instance.IModifierInstance;
import mc.rellox.spawnerlegacyapi.spawner.IGenerator;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface IModifierManager {

    IModifierRegistry registry();

    IModifierDefinition get(String key);

    List<IModifierDefinition> list();

    IModifierInstance load(IGenerator generator, IModifierDefinition definition);

    IModifierInstance load(IGenerator generator, String key);

    List<IModifierInstance> load(IGenerator generator);

    void save(IModifierInstance instance);

    void remove(IGenerator generator, IModifierDefinition definition);

    void remove(IGenerator generator, String key);

    void remove(IModifierInstance instance);

    ItemStack item(IModifierInstance instance);

    IModifierDefinition modifier(ItemStack item);

    IModifierInstance instance(ItemStack item);

}

