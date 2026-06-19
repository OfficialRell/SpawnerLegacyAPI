package mc.rellox.spawnerlegacyapi.utility;

public enum ShiftType {

    SET {
        @Override
        public double shift(double base, double value) {
            return value;
        }
    },
    ADD {
        @Override
        public double shift(double base, double value) {
            return base + value;
        }
    },
    SUBTRACT {
        @Override
        public double shift(double base, double value) {
            return base - value;
        }
    },
    MULTIPLY {
        @Override
        public double shift(double base, double value) {
            return base * value;
        }
    },
    DIVIDE {
        @Override
        public double shift(double base, double value) {
            return base / value;
        }
    };

    public abstract double shift(double base, double value);

    public static ShiftType of(char c) {
        return switch(c) {
            case '+' -> ADD;
            case '-' -> SUBTRACT;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default -> null;
        };
    }

}
