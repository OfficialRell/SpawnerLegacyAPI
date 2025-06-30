package mc.rellox.spawnerlegacyapi.text.content;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mc.rellox.spawnerlegacyapi.text.content.IColorer.Colors;
import mc.rellox.spawnerlegacyapi.text.content.IContent.Variable;

public final class ContentParser {
	
	protected static final Pattern colors, variables;
	static {
		colors = Pattern.compile("<(?:(?:#[a-f\\d]{6}(?:-#[a-f\\d]{6})*)|(?:![a-z]+))>",
				Pattern.CASE_INSENSITIVE);
		variables = Pattern.compile("%[a-z_]+%", Pattern.CASE_INSENSITIVE);
	}
	
	public static IContent parse(String text) {
		return text == null || text.isEmpty() == true
				? IContent.empty() : new ContentParser(text).parse();
	}
	
	public static List<IContent> parse(List<String> list) {
		return list == null || list.isEmpty()
				? List.of() : list.stream()
				.map(ContentParser::parse)
				.collect(Collectors.toList());
	}
	
	public static IContent parseAndKey(String text) {
		return parse(text).keyed(text);
	}
	
	public static List<IContent> parseAndKey(List<String> list) {
		return list == null || list.isEmpty()
				? List.of() : list.stream()
				.map(ContentParser::parseAndKey)
				.collect(Collectors.toList());
	}
	
	private final String text;
	
	private ContentParser(String text) {
		this.text = text;
	}
	
	public IContent parse() {
		if(text == null || text.isEmpty() == true) return IContent.empty();
		List<Text> list = text();
		List<IContent> result = new ArrayList<>();
		ContentBuilder builder = new ContentBuilder();
		for(Text t : list) {
			if(t.type == Type.text) {
				IContent input = variabled(t.text);
				result.add(builder.build(input));
				builder.reset();
			} else if(t.type == Type.color) builder.color(t.text);
			else if(t.type == Type.gradient) builder.gradient(t.text);
			else builder.format(t.text);
		}
		return result.isEmpty() == true ? IContent.empty()
				: result.size() == 1 ? result.get(0) : IContent.of(result);
	}
	
	private List<Text> text() {
		List<Text> list = new ArrayList<>();
		Matcher m = colors.matcher(text);
		int e = 0, s;
		while(m.find() == true) {
			s = m.start();
			if(s > e) list.add(new Text(text.substring(e, s), Type.text));
			e = m.end();
			String t = m.group(), g = t.substring(1, t.length() - 1);
			if(g.indexOf('-') >= 0) list.add(new Text(g, Type.gradient));
			else if(g.indexOf('!') == 0) list.add(new Text(g, Type.format));
			else if(g.indexOf('#') == 0) list.add(new Text(g, Type.color));
			else list.add(new Text(t, Type.text));
		}
		if(e < text.length()) list.add(new Text(text.substring(e), Type.text)); 
		return list;
	}
	
	private IContent variabled(String t) {
		if(t.isEmpty() == true) return IContent.empty();
		List<IContent> list = new ArrayList<>();
		Matcher m = variables.matcher(t);
		int e = 0, s;
		while(m.find() == true) {
			s = m.start();
			if(s > e) list.add(IContent.of(t.substring(e, s)));
			e = m.end();
			String g = m.group();
			list.add(IContent.of(Variable.of(g.substring(1, g.length() - 1))));
		}
		if(e < t.length()) list.add(IContent.of(t.substring(e))); 
		return list.size() == 1 ? list.get(0) : IContent.of(list);
	}
	
	private class ContentBuilder {
		private int[] is;
		private final List<Format> fs = new ArrayList<>();
		private void reset() {
			is = null;
			fs.clear();
		}
		private void color(String s) {
			try {
				is = new int[] {Integer.parseInt(s.substring(1), 16)};
			} catch (Exception e) {}
		}
		private void gradient(String s) {
			try {
				is = Stream.of(s.split("-"))
						.mapToInt(t -> Integer.parseInt(t.substring(1), 16))
						.toArray();
			} catch (Exception e) {}
		}
		private void format(String s) {
			Format f = switch(s.substring(1)) {
			case "bold", "b" -> Format.bold;
			case "italic", "i" -> Format.italic;
			case "obfuscated", "o" -> Format.obfuscated;
			case "strikethrough", "s" -> Format.strikethrough;
			case "underline", "u" -> Format.underline;
			default -> null;
			};
			if(f != null) fs.add(f);
		}
		private IContent build(IContent input) {
			IColorer color;
			if(is != null) {
				if(is.length == 1) {
					if(fs.isEmpty() == true) color = IColorer.of(is[0]);
					else color = IColorer.of(is[0], Format.of(fs));
				} else {
					if(fs.isEmpty() == true) color = IColorer.of(Colors.of(is));
					else color = IColorer.of(Colors.of(is), Format.of(fs));
				}
			} else if(fs.isEmpty() == false) color = IColorer.of(Colors.white, Format.of(fs));
			else color = null;
			return color == null ? input : IContent.of(color, input);
		}
	}
	
	private record Text(String text, Type type) {}
	
	private enum Type {
		text, color, gradient, format;
	}

}
