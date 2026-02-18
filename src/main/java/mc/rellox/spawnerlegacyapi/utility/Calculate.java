package mc.rellox.spawnerlegacyapi.utility;

import java.util.List;
import java.util.Random;

import mc.rellox.spawnerlegacyapi.SLAPI;

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
	
	private static final long[] time_maximum = {Integer.MAX_VALUE, 11, 30, 23, 59, 59};
	private static final long[] time_units = {31536000, 2592000, 86400, 3600, 60, 1};
	private static final String[] time_keys = {
			"Time.values.year", "Time.values.month", "Time.values.day",
			"Time.values.hour", "Time.values.minute", "Time.values.second"
	};
	
	/**
	 * Parses time: &lt;years&gt;:&lt;months&gt;:&lt;days&gt;:&lt;hours&gt;:&lt;minutes&gt;:&lt;seconds&gt;
	 * into seconds.<br>
	 * Can pass less values (e.g. &lt;minutes&gt;:&lt;seconds&gt).
	 * 
	 * @param time - time value
	 * @return parsed time in seconds
	 */
	
	public static long time(String time) {
		String[] parts = time.split(":");
        int size = parts.length;
        if(size > 6 || size == 0) return -1;
        
        long seconds = 0;
        for(int i = 0; i < size; i++) {
            try {
                int value = Integer.parseInt(parts[i]);
                if(value > time_maximum[6 - size + i]) return -1;
                seconds += value * time_units[6 - size + i];
            } catch(Exception e) {
                return -1;
            }
        }
        
        return seconds;
	}
	
	/**
	 * Converts seconds into a human-readable format.
	 * 
	 * @param cooldown - time in seconds
	 * @return Human-readable time
	 */

	public static String time(long cooldown) {
		if(cooldown <= 0)
			return SLAPI.language().get(time_keys[5] + ".single", "value", 0).text();
		
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < time_units.length; i++) {
			long value = cooldown / time_units[i];
			if(value > 0) {
				String key = time_keys[i] + (value == 1 ? ".single" : ".multiple");
				String part = SLAPI.language().get(key, "value", value).text();
				builder.append(part).append(" ");
				cooldown %= time_units[i];
			}
		}

		return builder.toString().trim();
	}
	
	/**
	 * This method helps runnables to always start a task at the same interval.
	 * 
	 * @return Ticks until the next second
	 */
	
	public static long sync() {
		long ticks = (System.currentTimeMillis() / 50) % 20;
		return ticks == 0 ? 0 : 20 - ticks;
	}

}
