package mc.rellox.spawnerlegacyapi.utility;

public interface ILimit {

    static ILimit of(int limit) {
        if(limit == 0) return NONE;
        return limit > 0
                ? new LimitPositive(limit)
                : new LimitNegative(-limit);
    }

    ILimit NONE = new LimitNone();

    /**
     * Limit of 0 will allow any amount.<br>
     * Positive limit will allow up to that amount.<br>
     * Negative limit will allow all but that amount.
     *
     * @return Limit value
     */

    int limit();

    /**
     * @param value value
     * @param total total values
     * @return Has the limit been reached
     */

    boolean allow(int value, int total);

    record LimitNone() implements ILimit {
        @Override
        public int limit() {
            return 0;
        }
        @Override
        public boolean allow(int value, int total) {
            return true;
        }
    }

    record LimitPositive(int limit) implements ILimit {
        @Override
        public boolean allow(int value, int total) {
            return value < limit;
        }
    }

    record LimitNegative(int limit) implements ILimit {
        @Override
        public int limit() {
            return -limit;
        }
        @Override
        public boolean allow(int value, int total) {
            return total - value > limit;
        }
    }
}
