package mc.rellox.spawnerlegacyapi.configuration.player;

public enum LimitType {
	
	BREAKING;
	
	public String key() {
		return name().toLowerCase();
	}
}
