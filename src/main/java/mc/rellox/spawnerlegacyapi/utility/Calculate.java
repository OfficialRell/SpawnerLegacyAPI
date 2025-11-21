package mc.rellox.spawnerlegacyapi.utility;

import java.util.List;
import java.util.Random;

public final class Calculate {
	
	private static final Random R = new Random();
	
	public static double round(double d) {
		int i = (int) (d * 100);
		return (double) (i / 100.0);
	}
	
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public static boolean isInteger(String... l) {
		if(l == null) return false;
		for(String s : l) if(!isInteger(s)) return false;
		return true;
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
