package mc.rellox.spawnerlegacyapi.configuration.player;

import java.util.Locale;

public enum LimitType {
	
	BREAKING;
	
	public String key() {
		return name().toLowerCase(Locale.ROOT);
	}
}
