package mc.rellox.spawnerlegacyapi.configuration.settings;

public enum HolderType {

	/**
	 * Applies to spawners that the player owns.
	 */
	OWNED,
	/**
	 * Applies to naturally generated spawners.
	 */
	NATURAL,
	/**
	 * Applies to spawners that the player is trusted with.
	 */
	TRUSTED,
	/**
	 * Applies to other player owned spawners.
	 */
	OTHER;

	/**
	 * @return Key of this holder type
	 */
	public String key() {
		return name().toLowerCase();
	}

}
