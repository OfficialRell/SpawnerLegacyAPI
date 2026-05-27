package mc.rellox.spawnerlegacyapi.spawner.warning;

public enum WarningType {
	
	/**
	 * Warning when spawner is out of charges.
	 */
	CHARGES,
	/**
	 * Warning when environment requirement is not met.
	 */
	ENVIRONMENT,
	/**
	 * Warning when ground requirement is not met.
	 */
	GROUND,
	/**
	 * Warning when required light level is not met.
	 */
	LIGHT,
	/**
	 * Warning when required redstone power is not met.
	 */
	POWER,
	/**
	 * Warning for other unidentifiable reasons.
	 */
	UNKNOWN

}
