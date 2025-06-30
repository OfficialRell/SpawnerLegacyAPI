package mc.rellox.spawnerlegacyapi.spawner.type;

import java.util.stream.Stream;

import org.bukkit.Color;

import mc.rellox.spawnerlegacyapi.view.layout.SlotField;

public enum UpgradeType {
	
	RANGE("range", "blocks", Color.AQUA, SlotField.upgrade_range),
	DELAY("delay", "ticks", Color.YELLOW, SlotField.upgrade_delay),
	AMOUNT("amount", "entities", Color.PURPLE, SlotField.upgrade_amount),
	NEARBY("nearby", "entities", Color.RED, SlotField.upgrade_nearby),
	
	XP("xp", "percent", Color.LIME, SlotField.upgrade_xp),
	DROPS("drops", "percent", Color.BLUE, SlotField.upgrade_drops);
	
	public final String id, values;
	public final Color color;
	public final SlotField field;
	
	private UpgradeType(String id, String values, Color color, SlotField field) {
		this.id = id;
		this.values = values;
		this.color = color;
		this.field = field;
	}
	
	public static UpgradeType of(String id) {
		return Stream.of(values())
				.filter(u -> u.id.equalsIgnoreCase(id))
				.findFirst()
				.orElse(null);
	}
	
	public static UpgradeType of(int i) {
		return values()[i];
	}

}
