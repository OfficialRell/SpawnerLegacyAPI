package mc.rellox.spawnerlegacyapi.spawner.meta.item;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.utility.ISave;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

@Deprecated(since = "2.0.0", forRemoval = true)
public interface IMetaItem extends ISave {

    Material material();

    IContent name();

    List<IContent> lore();

    Map<Enchantment, Integer> enchantments();

    int model();

    String id();

    ItemStack item();

    ItemStack item(int amount);

}
