package mc.rellox.spawnerlegacyapi.configuration.settings;

public enum HolderType {
	
	OWNED, NATURAL, TRUSTED, OTHER;
	
	public String key() {
		return name().toLowerCase();
	}

}
