package mc.rellox.spawnerlegacyapi.modifier.effect;

public enum EvaluateType {

    SET,
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    ADD_PERCENT,
    SUBTRACT_PERCENT;

    /**
     * Returns only the calculated change value.<br>
     * This method does not modify the base value.
     *
     * @param base   base value
     * @param change change value
     * @return The calculated change value
     */

    public double partial(double base, double change) {
        return switch(this) {
            case SET -> change - base;
            case ADD -> +change;
            case SUBTRACT -> -change;
            case MULTIPLY -> base * (change - 1);
            case DIVIDE -> base / change - base;
            case ADD_PERCENT -> base * (change * 0.01);
            case SUBTRACT_PERCENT -> -base * (change * 0.01);
        };
    }

    /**
     * Returns the new value after applying the change to the base value.
     *
     * @param base   base value
     * @param change change value
     * @return The new value after applying the change
     */

    public double full(double base, double change) {
        return switch(this) {
            case SET -> change;
            case ADD -> base + change;
            case SUBTRACT -> base - change;
            case MULTIPLY -> base * change;
            case DIVIDE -> base / change;
            case ADD_PERCENT -> base + (base * (change * 0.01));
            case SUBTRACT_PERCENT -> base - (base * (change * 0.01));
        };
    }

}
