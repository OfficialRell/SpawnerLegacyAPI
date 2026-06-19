package mc.rellox.spawnerlegacyapi.utility;

public interface IChance {

    static IChance of(int chance) {
        if(chance <= 0) return NEVER;
        if(chance >= 100) return ALWAYS;
        return new Chance(chance);
    }

    IChance ALWAYS = new ChanceAlways();
    IChance NEVER = new ChanceNever();

    /**
     * @return Chance value [1-100]
     */

    int chance();

    /**
     * @return Whether the chance roll was successful
     */

    boolean roll();

    record ChanceAlways() implements IChance {
        @Override
        public int chance() {
            return 100;
        }
        @Override
        public boolean roll() {
            return true;
        }
    }

    record ChanceNever() implements IChance {
        @Override
        public int chance() {
            return 0;
        }
        @Override
        public boolean roll() {
            return false;
        }
    }

    record Chance(int chance) implements IChance {
        @Override
        public boolean roll() {
            return Calculate.chance(chance);
        }
    }

}
