package mc.rellox.spawnerlegacyapi.spawner.type;

public enum StackingType {
	
	INFINITE,
	FINITE;
	
	public static StackingType of(String name, StackingType def) {
		try {
			return valueOf(name.toUpperCase());
		} catch (Exception e) {}
		return def;
	}

}
