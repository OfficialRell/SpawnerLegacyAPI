package mc.rellox.spawnerlegacyapi.text.content;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.text.content.IColorer.Colors;

public interface IContent {
	
	// Statics
	
	static IContent empty() {
		return EmptyContent.empty;
	}
	
	static IContent empty(int e) {
		String m = " ".repeat(e);
		return wrap(v -> m);
	}
	
	static IContent space() {
		return wrap(v -> " ");
	}
	
	static IContent of(List<IContent> list) {
		return wrap(v -> list.stream()
				.map(c -> c.text(v))
				.collect(Collectors.joining()));
	}
	
	static IContent of(IContent... cs) {
		return wrap(v -> Stream.of(cs)
				.map(c -> c.text(v))
				.collect(Collectors.joining()));
	}
	
	static IContent of(IColorer colorer, IContent content) {
		return new ContentText(colorer, content);
	}
	
	static IContent of(String text) {
		return wrap(v -> text);
	}
	
	static IContent of(Object o) {
		if(o instanceof IContent c) return c;
		String text = o.toString();
		return wrap(v -> text);
	}
	
	static IContent of(Variable variable) {
		return new ContentVariable(variable.key);
	}
	
	static IContent of(int rgb, Object o) {
		return of(IColorer.of(rgb), of(o.toString()));
	}
	
	static IContent of(int rgb, String text) {
		return of(IColorer.of(rgb), of(text));
	}
	
	static IContent of(int rgb, Format format, String text) {
		return of(IColorer.of(rgb, format), of(text));
	}
	
	static IContent of(String text, int... rgb) {
		return of(IColorer.of(Colors.of(rgb)), of(text));
	}
	
	static IContent of(String text, Format format, int... rgb) {
		return of(IColorer.of(Colors.of(rgb), format), of(text));
	}
	
	static IContent of(int rgb0, String t0, int rgb1, String t1) {
		return IContent.of(IContent.of(rgb0, t0), IContent.of(rgb1, t1));
	}
	
	static IContent of(int rgb0, String t0, int rgb1, String t1, int rgb2, String t2) {
		return IContent.of(IContent.of(rgb0, t0), IContent.of(rgb1, t1), IContent.of(rgb2, t2));
	}
	
	private static IContent wrap(IContent content) {
		return new WrappedContent(content);
	}
	
	class EmptyContent implements IContent {
		private static final EmptyContent empty = new EmptyContent(); 
		@Override
		public String text(Variables variables) {
			return "";
		}
		@Override
		public String toString() {
			return "";
		}
	}
	
	record WrappedContent(IContent content) implements IContent {
		@Override
		public String text(Variables variables) {
			return content.text(variables);
		}
		@Override
		public String toString() {
			return text();
		}
	}
	
	// Methods
	
	/**
	 * @param variables - text variables
	 * @return Final text
	 */
	
	String text(Variables variables);
	
	/**
	 * @return Final text
	 */
	
	default String text() {
		return text(Variables.empty);
	}
	
	/**
	 * @param variables - text variables
	 * @return Content with variables
	 */
	
	default IContent modified(Variables variables) {
		return wrap(v -> text(variables));
	}
	
	/**
	 * @param key - savable text key
	 * @return Keyed content
	 */
	
	default KeyedContent keyed(String key) {
		return new KeyedContent(key, this);
	}
	
	/**
	 * Sends this text to the player only if it is not empty.
	 * 
	 * @param player - player
	 */
	
	default void send(Player player) {
		String text = text();
		if(text == null || text.isEmpty() == true) return;
		player.sendMessage(text);
	}

	/**
	 * Sends this text the player that has this id and is online.
	 * 
	 * @param id - player's {@link UUID}
	 */
	
	default void send(UUID id) {
		Player player = Bukkit.getPlayer(id);
		if(player != null) send(player);
	}
	
	// Classes
	
	interface Variables {
		
		static final Variables empty = k -> k;
		
		static Variables with(String k, Object o) {
			return v -> v.equals(k) ? convert(o) : v;
		}
		
		static Variables with(Object... vs) {
			if(vs.length == 2) return v -> v.equals(vs[0]) ? convert(vs[1]) : v;
			return v -> {
				int i = 0, m = vs.length;
				do {
					if(v.equals(vs[i]) == true)
						return convert(vs[i + 1]);
				} while((i += 2) < m);
				return v;
			};
		}
		
		String get(String key);
		
		private static String convert(Object o) {
			if(o instanceof IContent c) return c.text();
			if(o instanceof SpawnerType s) return s.formatted().text();
			if(o instanceof IPrice p) return p.text().text();
			return o.toString();
		}
		
	}
	
	record Variable(String key) {
		public static Variable of(String key) {
			return new Variable(key);
		}
	}
	
	record ContentText(IColorer colorer, IContent content) implements IContent {
		@Override
		public String text(Variables variables) {
			return colorer.color(content.text(variables));
		}
		@Override
		public String toString() {
			return text();
		}
	}
	
	record ContentVariable(String key) implements IContent {
		@Override
		public String text(Variables variables) {
			return variables.get(key);
		}
		@Override
		public String toString() {
			return text();
		}
	}

}
