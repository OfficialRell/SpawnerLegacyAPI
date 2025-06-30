package mc.rellox.spawnerlegacyapi.item.tool;

public enum UseType {
	
	RIGHT_CLICK,
	LEFT_CLICK,
	BOTH;
	
	public boolean right() {
		return this == RIGHT_CLICK || this == BOTH;
	}
	
	public boolean left() {
		return this == LEFT_CLICK || this == BOTH;
	}
	
	public boolean match(UseType use) {
		return this == use || this == BOTH;
	}


}
