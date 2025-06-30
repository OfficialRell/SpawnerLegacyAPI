package mc.rellox.spawnerlegacyapi.configuration.settings;

public enum PlayerOption {
	
	BREAK, STACK, CHANGE, OPEN, UPGRADE;
	
	public String suffix() {
		return "can-" + name().toLowerCase();
	}

}
