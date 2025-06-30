package mc.rellox.spawnerlegacyapi.configuration;

public enum LimitType {
	
	BREAKING;
	
	public String key() {
		return name().toLowerCase();
	}
}
