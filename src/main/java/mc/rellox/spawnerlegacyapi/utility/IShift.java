package mc.rellox.spawnerlegacyapi.utility;

public interface IShift {

    static IShift of(String value) {
        if(value == null || value.length() <= 1) return null;

        ShiftType type = ShiftType.of(value.charAt(0));
        if(type == null) type = ShiftType.SET;

        var ii = Calculate.toDouble(value.substring(1));
        if(ii.invalid()) return null;

        return new Shift(type, ii.get());
    }

    /**
     * @param base base value
     * @return Shifted value
     */

    default double shift(double base) {
        return type().shift(base, value());
    }

    /**
     * @return Shift type
     */

    ShiftType type();

    /**
     * @return Shifting value
     */

    double value();

    record Shift(ShiftType type, double value) implements IShift {}

}
