package mc.rellox.spawnerlegacyapi.utility;

import java.util.List;
import java.util.Random;

public final class Calculate {
	
	private static final Random R = new Random();
	
	public static double round(double d) {
		int i = (int) (d * 100);
		return (double) (i / 100.0);
	}
	
	public static IInteger toInteger(String s) {
		return toInteger(s, 10);
	}
	
	public static IInteger toHex(String s) {
		return toInteger(s, 16);
	}
	
	public static IInteger toInteger(String s, int radix) {
		try {
			int i = Integer.parseInt(s, radix);
			return new IInteger() {
				@Override
				public boolean invalid() {return false;}
				@Override
				public String input() {return s;}
				@Override
				public int get() {return i;}
			};
		} catch (Exception e) {
			return new IInteger() {
				@Override
				public int get() {throw new NumberFormatException(s + " is not an integer");}
				@Override
				public boolean invalid() {return true;}
				@Override
				public String input() {return s;}
			};
		}
	}

	public static interface INumber {
		
		String input();
		
		boolean invalid();
		
		default boolean valid() {
			return !invalid();
		}
		
	}

	public static interface IInteger extends INumber {
		
		int get();
		
		default int get(int d) {
			return invalid() ? d : get();
		}
		
	}
	
	public static IDouble toDouble(String s) {
		try {
			double i = Double.parseDouble(s);
			return new IDouble() {
				@Override
				public boolean invalid() {return false;}
				@Override
				public String input() {return s;}
				@Override
				public double get() {return i;}
			};
		} catch (Exception e) {
			return new IDouble() {
				@Override
				public double get() {throw new NumberFormatException(s + " is not a double");}
				@Override
				public boolean invalid() {return true;}
				@Override
				public String input() {return s;}
			};
		}
	}

	public static interface IDouble extends INumber {
		
		double get();
		
		default double get(double d) {
			return invalid() ? d : get();
		}
		
	}
	
	public static boolean chance(double chance) {
		return R.nextDouble() * 100 < chance;
	}

	public static int random(int r) {
		return R.nextInt(r);
	}

	public static int random() {
		return R.nextInt();
	}
	
	public static int between(int a, int b) {
		return random(b - a + 1) + a;
	}

	public static <E> E random(List<E> list) {
		int size = list.size();
		return size > 0 ? list.get(R.nextInt(size)) : null;
	}

}
