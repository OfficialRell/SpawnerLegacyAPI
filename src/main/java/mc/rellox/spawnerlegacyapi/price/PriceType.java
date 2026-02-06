package mc.rellox.spawnerlegacyapi.price;

public enum PriceType {
	
	EXPERIENCE(),
	LEVELS(),
	MATERIAL(),
	ECONOMY(),
	FLARE_TOKENS();
	
	public String key() {
		return name().replace('_', '-').toLowerCase();
	}
	
	@Override
	public String toString() {
		return name();
	}
	
	public static PriceType of(String name) {
		try {
			if(name.equalsIgnoreCase("MONEY")) return ECONOMY;
			if(name.equalsIgnoreCase("ITEM")) return MATERIAL;
			return valueOf(name.toUpperCase());
		} catch (Exception e) {}
		return null;
	}

}
