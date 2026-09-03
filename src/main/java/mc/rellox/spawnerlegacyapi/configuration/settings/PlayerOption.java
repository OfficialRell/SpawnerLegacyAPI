package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.Locale;

public enum PlayerOption {
	
	BREAK, STACK, CHANGE, OPEN, UPGRADE;
	
	public String suffix() {
		return "can-" + name().toLowerCase(Locale.ROOT);
	}

}
