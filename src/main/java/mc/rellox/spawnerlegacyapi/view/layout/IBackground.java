package mc.rellox.spawnerlegacyapi.view.layout;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IBackground extends ISave {
	
	static IBackground empty = new IBackground() {
		@Override
		public void save(IFile file, String path) {}
		@Override
		public ItemBuilder[] items() {return null;}
	};
	
	
	/**
	 * @return List of background items or {@code null} if not specified
	 */
	
	ItemBuilder[] items();
	
}
