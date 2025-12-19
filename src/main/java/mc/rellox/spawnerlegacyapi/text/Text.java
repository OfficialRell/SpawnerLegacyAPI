package mc.rellox.spawnerlegacyapi.text;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.color.IColorer.Colors;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import mc.rellox.spawnerlegacyapi.version.Version;

public final class Text {
	
	public static final String infinity = "" + '\u221e';
	public static final String multiple = "" + '\u00d7';
	public static final char color_char = ChatColor.COLOR_CHAR;
	
	private static final String color_aqua = color(Colors.aqua);
	private static final String color_dark_red = color(Colors.red_50);
	private static final String color_yellow = color(Colors.yellow);
	private static final String color_orange = color(Colors.orange);
	private static final String color_dark_green = color(Colors.green_50);
	private static final String color_green = color(Colors.green);
	
	public static final ItemFlag[] item_flags;
	
	static {
		var ignore = List.of("HIDE_CUSTOM_NAME", "HIDE_ITEM_NAME", "HIDE_LORE");
		item_flags = Stream.of(ItemFlag.values())
				.filter(flag -> !ignore.contains(flag.name()))
				.toArray(ItemFlag[]::new);
	}
	
	public static void success(String success, Object... os) {
		String w = color_dark_green + "(!) " + color_green + success;
		if(os != null) for(int i = 0; i < os.length; i++) w = w.replace("#" + i, color_aqua + os[i].toString() + color_green);
		Bukkit.getConsoleSender().sendMessage(w);
	}
	
	public static void failure(String warning, Object... os) {
		String w = color_dark_red + "(!) " + color_orange + warning;
		if(os != null) for(int i = 0; i < os.length; i++) w = w.replace("#" + i, color_yellow + os[i].toString() + color_orange);
		Bukkit.getConsoleSender().sendMessage(w);
	}
	
	public static void warning(String warning, Object... os) {
		String w = color_orange + "(!) " + color_yellow + warning;
		if(os != null) for(int i = 0; i < os.length; i++) w = w.replace("#" + i, color_aqua + os[i].toString() + color_yellow);
		Bukkit.getConsoleSender().sendMessage(w);
	}
	
	public static List<String> toText(List<IContent> list) {
		return list.stream()
				.map(IContent::text)
				.collect(Collectors.toList());
	}
	
	// 1-I 5-V 10-X 50-L 100-C 500-D 1000-M
	public static String roman(int i) {
		if(i <= 0 || i > 5000) return "" + i;
		StringBuilder sb = new StringBuilder();
		if(i >= 1000) do sb.append("M"); while((i -= 1000) >= 1000);
		if(i >= 900) i -= r(sb, "CM", 900);
		if(i >= 500) i -= r(sb, "D", 500);
		if(i >= 400) i -= r(sb, "CD", 400);
		if(i >= 100) do sb.append("C"); while((i -= 100) >= 100);
		if(i >= 90) i -= r(sb, "XC", 90);
		if(i >= 50) i -= r(sb, "L", 50);
		if(i >= 40) i -= r(sb, "XL", 40);
		if(i >= 10) do sb.append("X"); while((i -= 10) >= 10);
		if(i >= 9) i -= r(sb, "IX", 9);
		if(i >= 5) i -= r(sb, "V", 5);
		if(i >= 4) i -= r(sb, "IV", 4);
		if(i >= 1) do sb.append("I"); while(--i >= 1);
		return sb.toString();
	}
	
	private static int r(StringBuilder sb, String s, int i) {
		sb.append(s);
		return i;
	}
	
	public static String display(ItemStack item) {
		try {
			Class<?> clazz = RF.craft("inventory.CraftItemStack");
			Object nms_item = RF.order(clazz, "asNMSCopy", ItemStack.class).invoke(item);
			
			String[] names = switch (Version.version) {
				case v_18_1 -> new String[] {"v", "a"};
				case v_18_2 -> new String[] {"w", "a"};
				case v_19_1, v_19_2, v_19_3, v_20_4 -> new String[] {"x", "getString"};
				case v_21_1 -> new String[] {"w", "getString"};
				default -> new String[] {"y", "getString"};
			};
			
			String a = names[0];
			String b = names[1];
			
			Object component = RF.direct(nms_item, a);
			String name = RF.direct(component, b, String.class);
			
			if(name == null)
				Bukkit.getLogger().warning("Null name got returned when trying to fetch item name");
			
			return ChatColor.stripColor(name);
		} catch(Exception e) {
			Bukkit.getLogger().warning("Cannot get item display name");
			return "null";
		}
	}
	
	public static boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	public static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static boolean isKey(String s) {
		for(char c : s.toCharArray())
			if(!isLetter(c) && !isNumber(c) && c != '_' && c != '.')
				return false;
		return true;
	}

	public static String color(String hex) {
		if(hex.charAt(0) == '#') hex = hex.substring(1);
		StringBuilder s = new StringBuilder();
		s.append(color_char).append("x");
		for(char c : hex.toCharArray()) s.append(color_char).append(c);
		return s.toString();
	}
	
	public static String color(int rgb) {
		return color(String.format("%06x", rgb));
	}
	
	private static final char[] HEX = "0123456789abcdef".toCharArray();

	public static String colorFast(int rgb) {
	    int v = rgb & 0xFFFFFF;
	    char[] out = new char[14];
	    out[0] = color_char;
	    out[1] = 'x';

	    int shift = 20;
	    int pos = 2;
	    for (int i = 0; i < 6; i++) {
	        int nibble = (v >> shift) & 0xF;
	        out[pos++] = color_char;
	        out[pos++] = HEX[nibble];
	        shift -= 4;
	    }
	    return new String(out);
	}
	
	public static String format(double value, int p) {
		return String.format("%." + p + "f", value);
	}
	
	public static int fromHex(String hex) {
		if(hex.charAt(0) == '#') hex = hex.substring(1);
		try {
			return Integer.parseInt(hex, 16);
		} catch (Exception e) {}
		return 0;
	}
	
	public static String path(String s) {
		if(s == null) return null;
		if(s.isEmpty()) return "";
		return s.toLowerCase().replace('_', '-');
	}
	
	public static String normalize(String s) {
		if(s == null) return null;
		if(s.isEmpty()) return "";
		
		return Stream.of(s.split("[\\s_-]"))
				.filter(t -> !t.isEmpty())
				.map(Text::upper)
				.collect(Collectors.joining(" "));
	}
	
	private static String upper(String s) {
		if(s == null || s.isEmpty()) return "";
		return Character.toUpperCase(s.charAt(0))
				+ s.substring(1).toLowerCase();
	}
	
	public static String unicode(String code) {
		try {
			var number = code.substring(2); // skip "u+"
			var value = Integer.parseInt(number, 16);
			return String.valueOf(Character.toChars(value));
		} catch (Exception e) {
			RF.debug(e);
		}
		return code;
	}
	
	public static List<String> clean(List<String> list) {
		boolean n = false;
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().isEmpty()) {
				if(n) it.remove();
				n = true;
			} else n = false;
		}
		if(!list.isEmpty()) {
			int last = list.size() - 1;
			if(list.get(last).isEmpty())
				list.remove(last);
		}
		return list;
	}
	
	public static String or(Object object, String nulled) {
		return object == null ? nulled : object.toString();
	}
	
	public static <T> String or(T object, String nulled, Function<T, String> mapper) {
		return object == null ? nulled : mapper.apply(object);
	}
	
	public static List<String> fromLegacy(List<String> list) {
		return list.stream()
				.map(Text::fromLegacy)
				.collect(Collectors.toList());
	}
	
	public static String fromLegacy(String s) {
		StringBuilder sb = new StringBuilder();
		boolean l = false, h = false, i = false;
		String x = "";
		for(char c : s.toCharArray()) {
			if(c == '<') i = true;
			else if(c == '&') l = true;
			else if(c == '#') h = true;
			else {
				if(l) {
					String o = switch (c) {
					case 'a' -> "<#00ff00>"; case 'b' -> "<#00ffff>";
					case 'c' -> "<#ff0000>"; case 'd' -> "<#ff00ff>";
					case 'e' -> "<#ffff00>"; case 'f' -> "<#ffffff>";
					case '1' -> "<#000080>"; case '2' -> "<#008000>";
					case '3' -> "<#008080>"; case '4' -> "<#800000>";
					case '5' -> "<#800080>"; case '6' -> "<#ff8000>";
					case '7' -> "<#c4c4c4>"; case '8' -> "<#595959>";
					case '9' -> "<#0000ff>"; case '0' -> "<#000000>";
					case 'k' -> "<!obfuscated>"; case 'l' -> "<!bold>";
					case 'm' -> "<!strikethrough>"; case 'n' -> "<!underline>";
					case 'o' -> "<!italic>"; default -> "";
					};
					sb.append(o);
					l = false;
				} else if(h) {
					x += "" + c;
					if(x.length() >= 6) {
						sb.append("<#").append(x).append('>');
						x = "";
						h = false;
					}
				} else sb.append(c);
			}
			if(i && l || h) return s;
			i = false;
		}
		return sb.toString();
	}
	
	public static void send(Player player, IContent content) {
		if(content == null) return;
		String text = content.text();
		if(!text.isEmpty()) player.sendMessage(text);
	}
	
	public static void send(Player player, List<IContent> list) {
		if(list.isEmpty()) return;
		if(list.size() == 1) {
			String text = list.get(0).text();
			if(!text.isEmpty()) player.sendMessage(text);
		} else list.stream()
			.map(IContent::text)
			.forEach(player::sendMessage);
	}
	
	public static void debug(Block block, String text) {
		debug(block.getLocation(), text);
	}
	
	public static void debug(Location loc, String text) {
		loc.getWorld().getNearbyEntities(loc, 1.5, 1.5, 1.5, Player.class::isInstance)
		.forEach(e -> e.sendMessage(text));
	}
	
}
