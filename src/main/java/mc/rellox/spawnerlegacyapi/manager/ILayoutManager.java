package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.view.layout.ILayout;
import mc.rellox.spawnerlegacyapi.view.layout.IViewItem;
import mc.rellox.spawnerlegacyapi.view.layout.order.IOrder;

public interface ILayoutManager {
	
	IViewItem item(String key);
	
	ILayout upgrades(SpawnerType type);
	
	ILayout purchase();
	
	ILayout sell();
	
	IOrder order(String key);

}
