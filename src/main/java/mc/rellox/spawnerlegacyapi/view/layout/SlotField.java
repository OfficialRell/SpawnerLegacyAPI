package mc.rellox.spawnerlegacyapi.view.layout;

public enum SlotField {

	upgrade_stats("stats"),
	upgrade_range("range"),
	upgrade_delay("delay"),
	upgrade_amount("amount"),
	upgrade_nearby("nearby"),
	upgrade_xp("xp"),
	upgrade_drops("drops"),
	upgrade_charges("charges"),
	upgrade_types("types"),

	spawners_current("current"),
	spawners_page("page"),
	spawners_previous("previous"),
	spawners_next("next"),
	
	crafting_craft("craft"),
	crafting_page("page"),
	crafting_previous("previous"),
	crafting_next("next"),
	
	shop_page("page"),
	shop_previous("previous"),
	shop_next("next"),
	
	shop_sell("sell");
	
	private final String defines;
	
	private SlotField(String defines) {
		this.defines = defines;
	}
	
	public String defines() {
		return defines;
	}
	
	public static SlotField[] upgrade() {
		return new SlotField[] {
				upgrade_stats, upgrade_range, upgrade_delay,
				upgrade_amount, upgrade_nearby, upgrade_xp,
				upgrade_drops, upgrade_charges, upgrade_types
		};
	}
	
	public static SlotField[] purchase() {
		return new SlotField[] {
				shop_page, shop_previous, shop_next
		};
	}
	
	public static SlotField[] selling() {
		return new SlotField[] {
				shop_sell
		};
	}
	
	public static SlotField[] spawners() {
		return new SlotField[] {
				spawners_current,
				spawners_page,
				spawners_previous,
				spawners_next
		};
	}
	
	public static SlotField[] crafting() {
		return new SlotField[] {
				crafting_craft,
				crafting_page,
				crafting_previous,
				crafting_next
		};
	}

}
