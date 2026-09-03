package mc.rellox.spawnerlegacyapi.spawner.cache;

import mc.rellox.spawnerlegacyapi.spawner.type.UpgradeType;

public interface IUpgradeValues {

    /**
     * @param type upgrade type
     * @return The final value of the specified upgrade type
     */

    double get(UpgradeType type);

    /**
     * Sets the final value of the specified upgrade type.
     *
     * @param type  upgrade type
     * @param value value to set
     */

    void set(UpgradeType type, double value);

    /**
     * @return The final values of all upgrade types
     */

    double[] values();

    /**
     * @param type upgrade type
     * @return The level of the specified upgrade type
     */

    int level(UpgradeType type);

}
