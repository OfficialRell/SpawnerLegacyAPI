package mc.rellox.spawnerlegacyapi.utility;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public interface IRange {
	
	static IRange nulled = new RangeConstant(0);
	static IRange singular = new RangeConstant(1);
	
	static IRange of(int value) {
		return value == 1 ? singular : new RangeConstant(value);
	}
	
	static IRange of(int minimum, int maximum) {
		return new RangeRandom(minimum, maximum);
	}
	
	static IRange of(String s) {
		try {
			if(s.matches("\\d+") == true) {
				int i = Integer.parseInt(s);
				return of(i);
			}
			if(s.matches("\\d+-\\d+") == true) {
				String[] ss = s.split("-");
				int a = Integer.parseInt(ss[0]);
				int b = Integer.parseInt(ss[1]);
				return of(a, b);
			}
			throw new IllegalArgumentException("int range value cannot be parsed (" + s + ")");
		} catch (Exception e) {
			RF.debug(e);
		}
		return nulled;
	}
	
	/**
	 * @return Minimum value
	 */
	
	int minimum();
	
	/**
	 * @return Maximum value
	 */
	
	int maximum();
	
	/**
	 * @return Random value between minimum and maximum (both inclusive)
	 */
	
	int roll();
	
	/**
	 * @return {@code true} if minimum or maximum is {@code 0}
	 */
	
	default boolean nulled() {
		return minimum() == 0 || maximum() == 0;
	}
	
	/**
	 * @return This range key
	 */
	
	default String key() {
		int a = minimum(), b = maximum();
		return a == b ? a + "" : a + "-" + b;
	}
	
	static record RangeConstant(int minimum, int maximum, int roll) implements IRange {
		public RangeConstant(int value) {
			this(value, value, value);
		}
	}
	
	static record RangeRandom(int minimum, int maximum) implements IRange {
		@Override
		public int roll() {
			return Calculate.between(minimum, maximum);
		}
	}

}
