package mc.rellox.spawnerlegacyapi.item;

import mc.rellox.spawnerlegacyapi.configuration.IMemory;
import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import org.bukkit.Material;

import java.util.List;

public interface IItemConstant {

    static IItemConstant of(Material material, boolean glint, IContent name, List<IContent> lore, int model) {
        return new ItemConstant(material, glint, name, lore, model);
    }

    static IItemConstant read(IMemory memory) {
        Material material = memory.getMaterial("material");
        if(material == null) {
            Text.failure("Invalid material for path: " + memory.path());
            return null;
        }
        boolean glint = memory.getBoolean("glint");
        IContent name = IContent.parse(memory.getString("name"));
        List<IContent> lore = IContent.parse(memory.getStringOrStrings("lore"));
        int model = memory.getInteger("model");
        return of(material, glint, name, lore, model);
    }

    /**
     * @return Item material
     */

    Material material();

    /**
     * @return Does this item has an enchantment glint
     */

    boolean glint();

    /**
     * @return Item name
     */

    IContent name();

    /**
     * @return Item lore
     */

    List<IContent> lore();

    /**
     * @return Item custom model data
     */

    int model();

    /**
     * @return New item builder
     */

    default ItemBuilder builder() {
        return ItemBuilder.of(material())
                .shining(glint())
                .named(name())
                .describe(lore())
                .modelled(model())
                .flagged();
    }

    record ItemConstant(
            Material material,
            boolean glint,
            IContent name,
            List<IContent> lore,
            int model
    ) implements IItemConstant {}

}
