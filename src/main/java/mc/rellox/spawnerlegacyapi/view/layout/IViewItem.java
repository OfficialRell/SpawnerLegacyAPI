package mc.rellox.spawnerlegacyapi.view.layout;

import org.bukkit.Material;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IViewItem extends ISave {
	
	/**
	 * @return Item material
	 */
	
	Material material();
	
	/**
	 * @return Is the item glowing
	 */
	
	boolean glint();
	
	/**
	 * @return Item model
	 */
	
	int model();
	
	/**
	 * @return Item id
	 */
	
	String id();
	
	/**
	 * @return Item builder
	 */
	
	default ItemBuilder item() {
		return ItemBuilder.of(material())
				.shining(glint())
				.modelled(model())
				.flaged();
	}
	
	@Override
	default void save(IFile file, String path) {
		path += "." + id();
		file.set(path + ".material", material().name());
		file.set(path + ".glint", glint());
		file.set(path + ".model", model());
	}

}
