package mc.rellox.spawnerlegacyapi.item;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;

public record ItemLoop(ItemBuilder... items) {
	
	public ItemLoop {
		if(items == null || items.length <= 0)
			throw new NullPointerException("item array must have at least 1 element");
	}
	
	public ItemBuilder of(int i) {
		return items[i % items.length];
	}

}
