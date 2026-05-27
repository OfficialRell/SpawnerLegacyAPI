package mc.rellox.spawnerlegacyapi.spawner.type;

public enum StackingType {
	
	INFINITE,
	FINITE;
	
	public static StackingType of(String name, StackingType fallback) {
		try {
			return valueOf(name.toUpperCase());
		} catch(Exception ignored) {}
		return fallback;
	}

}
