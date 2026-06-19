package mc.rellox.spawnerlegacyapi.item;

import mc.rellox.spawnerlegacyapi.utility.Utility;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import mc.rellox.spawnerlegacyapi.version.Version;
import mc.rellox.spawnerlegacyapi.version.Version.VersionType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.stream.IntStream;

public final class ItemUtility {

    public static boolean nulled(ItemStack item) {
        return item == null || item.getType() == Material.AIR;
    }

    public static boolean has(Player player, ItemStack item, int a) {
        if(Utility.op(player)) return true;
        if(item == null || item.getType().isAir()) return false;

        PlayerInventory v = player.getInventory();
        int t = IntStream.range(0, 36).map(i -> {
            ItemStack slot = v.getItem(i);
            if(!item.isSimilar(slot)) return 0;
            return slot.getAmount();
        }).sum();
        return t >= a;
    }

    public static void add(Player player, ItemStack item) {
        int f = 0, a = item.getAmount();
        PlayerInventory inventory = player.getInventory();
        ItemStack slot;
        for(int i = 0; f < a && i < 36; i++) {
            if((slot = inventory.getItem(i)) == null) f += 64;
            else if(slot.isSimilar(item)) f += 64 - slot.getAmount();
        }
        if(f >= a) inventory.addItem(item);
        else {
            ItemStack give = item.clone();
            give.setAmount(f);
            ItemStack sink = item.clone();
            sink.setAmount(a - f);
            inventory.addItem(give);
            Item drop = player.getWorld().dropItem(player.getLocation(), sink);
            drop.setVelocity(new Vector());
        }
    }

    public static void remove(Player player, ItemStack item, int amount) {
        if(Utility.op(player)) return;
        ItemStack clone = item.clone();
        clone.setAmount(amount);
        player.getInventory().removeItem(clone);
    }

    public static void glint(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        glint(meta);
        item.setItemMeta(meta);
    }

    @SuppressWarnings("deprecation")
    public static void glint(ItemMeta meta) {
        if(Version.version.atleast(VersionType.v_20_4)) {
            RF.order(meta, "setEnchantmentGlintOverride", Boolean.class)
                    .invoke(true);
        } else {
            meta.addEnchant(
                    Enchantment.getByKey(NamespacedKey.minecraft("power")),
                    0,
                    true);
        }
    }

}
