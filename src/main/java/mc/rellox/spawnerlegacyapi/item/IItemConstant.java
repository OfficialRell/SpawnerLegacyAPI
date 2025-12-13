package mc.rellox.spawnerlegacyapi.item;

import java.util.List;

import org.bukkit.Material;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface IItemConstant {
	
	static IItemConstant read(IFile file, String path) {
		Material material = file.getMaterial(path + ".material");
		if(material == null) {
			Text.failure("Invalid material for path: #0", path);
			return null;
		}
		boolean glint = file.getBoolean(path + ".glint");
		IContent name = IContent.parse(file.getString(path + ".name"));
		List<IContent> lore = IContent.parse(file.getStringOrStrings(path + ".lore"));
		int model = file.getInteger(path + ".model");
		return new IItemConstant() {
			@Override
			public Material material() {
				return material;
			}
			@Override
			public boolean glint() {
				return glint;
			}
			@Override
			public IContent name() {
				return name;
			}
			@Override
			public List<IContent> lore() {
				return lore;
			}
			@Override
			public int model() {
				return model;
			}
		};
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
				.flaged();
	}

}
