package mc.rellox.spawnerlegacyapi.text.content;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.text.content.color.IColorer;
import mc.rellox.spawnerlegacyapi.text.content.color.IColorer.Colors;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentColored;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentEmpty;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentKeyed;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentList;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentUnicode;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentVariable;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentWrapped;
import mc.rellox.spawnerlegacyapi.text.content.unicode.IUnicode;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariable;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public interface IContent {
	
	// Parse
	
	static IContent parse(String text) {
		return ContentParser.parse(text);
	}
	
	static List<IContent> parse(List<String> list) {
		return ContentParser.parse(list);
	}
	
	// Statics
	
	static IContent empty() {
		return ContentEmpty.empty;
	}
	
	static IContent empty(int e) {
		String m = " ".repeat(e);
		return wrap(v -> m);
	}
	
	static IContent space() {
		return wrap(v -> " ");
	}
	
	static IContent of(List<IContent> list) {
		return new ContentList(list);
	}
	
	static IContent of(IContent... cs) {
		return new ContentList(cs);
	}
	
	static IContent of(IColorer colorer, IContent content) {
		return new ContentColored(content, colorer);
	}
	
	static IContent of(String text) {
		return wrap(v -> text);
	}
	
	static IContent of(Object object) {
		if(object instanceof IContent content) return content;
		String text = object.toString();
		return wrap(v -> text);
	}
	
	static IContent of(IVariable variable) {
		return new ContentVariable(variable);
	}
	
	static IContent of(IUnicode unicode) {
		return new ContentUnicode(unicode);
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
		return new ContentWrapped(content);
	}
	
	// Methods
	
	/**
	 * @param variables - text variables
	 * @return Final text
	 */
	
	String text(IVariables variables);
	
	/**
	 * @return Final text
	 */
	
	default String text() {
		return text(IVariables.empty);
	}
	
	/**
	 * @param variables - text variables
	 * @return Content with variables
	 */
	
	default IContent modified(IVariables variables) {
		return wrap(v -> text(variables));
	}
	
	/**
	 * @return {@code true} if this content is keyed
	 */
	
	default boolean keyed() {
		return this instanceof ContentKeyed;
	}
	
	/**
	 * @return Raw text that is not parsed or {@code null} if not applicable
	 */
	
	default String key() {
		return this instanceof ContentKeyed keyed ? keyed.key() : null;
	}
	
	/**
	 * @param key - savable text key
	 * @return Keyed content
	 */
	
	default ContentKeyed keyed(String key) {
		return new ContentKeyed(key, this);
	}
	
	/**
	 * Sends this text to the player only if it is not empty.
	 * 
	 * @param player - player
	 */
	
	default void send(Player player) {
		String text = text();
		if(text == null || text.isEmpty()) return;
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
	
	/**
	 * Sends this text to the command sender only if it is not empty.
	 * 
	 * @param sender - sender
	 */
	
	default void send(CommandSender sender) {
		String text = text();
		if(text == null || text.isEmpty()) return;
		sender.sendMessage(text);
	}

}
