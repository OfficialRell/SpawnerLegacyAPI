package mc.rellox.spawnerlegacyapi.text.content;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mc.rellox.spawnerlegacyapi.text.content.color.IColorer;
import mc.rellox.spawnerlegacyapi.text.content.color.IColorer.Colors;
import mc.rellox.spawnerlegacyapi.text.content.unicode.IUnicode;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariable;

public final class ContentParser {
	
	protected static final Pattern PATTERN_COLOR, PATTERN_TOKEN;
	static {
		// Matches <#RRGGBB(-#RRGGBB)*> or <!format>
		PATTERN_COLOR = Pattern.compile("<((#[a-f\\d]{6}(-#[a-f\\d]{6})*)|(![a-z]+))>",
				Pattern.CASE_INSENSITIVE);
		// Matches %variable[:i|r|.d]% or u+XXXX
		PATTERN_TOKEN = Pattern.compile( "(%([a-z_]+)((:[ir])?|(:\\.\\d))?%)|(u\\+[\\da-f]{4})",
				Pattern.CASE_INSENSITIVE);
	}
	
	public static IContent parse(String text) {
		return text == null || text.isEmpty()
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
		if(text == null || text.isEmpty()) return IContent.empty();
		
		List<Text> list = text();
		List<IContent> result = new ArrayList<>();
		
		ContentBuilder builder = new ContentBuilder();
		
		for(Text t : list) {
			if(t.type == Type.text) {
				IContent input = fill(t.text);
				result.add(builder.build(input));
			} else if(t.type == Type.color) builder.color(t.text);
			else if(t.type == Type.gradient) builder.gradient(t.text);
			else builder.format(t.text);
		}
		return result.isEmpty() ? IContent.empty()
				: result.size() == 1 ? result.get(0) : IContent.of(result);
	}
	
	private List<Text> text() {
		List<Text> list = new ArrayList<>();
		Matcher matcher = PATTERN_COLOR.matcher(text);
		
		int start, end = 0;
		while(matcher.find()) {
			// check if the input starts with a raw text
			start = matcher.start();
			if(start > end) list.add(new Text(text.substring(end, start), Type.text));
			end = matcher.end();
			// split all other types
			String group = matcher.group(), inner = group.substring(1, group.length() - 1);
			if(inner.indexOf('-') >= 0) list.add(new Text(inner, Type.gradient));
			else if(inner.indexOf('!') == 0) list.add(new Text(inner, Type.format));
			else if(inner.indexOf('#') == 0) list.add(new Text(inner, Type.color));
			else list.add(new Text(group, Type.text));
		}
		// add leftover text
		if(end < text.length()) list.add(new Text(text.substring(end), Type.text)); 
		return list;
	}
	
	private IContent fill(String input) {
	    if(input == null || input.isEmpty()) return IContent.empty();

	    List<IContent> list = new ArrayList<>();
	    Matcher matcher = PATTERN_TOKEN.matcher(input);

	    int pos = 0;
	    while(matcher.find()) {
	        int start = matcher.start();
	        if(start > pos)
	            list.add(IContent.of(input.substring(pos, start)));

	        if(matcher.group(1) != null) {
	            // Variable
	            String whole = matcher.group(1);
	            String inner = whole.substring(1, whole.length() - 1);
	            list.add(IContent.of(IVariable.of(inner)));
	        } else {
	            // Unicode
	            String token = matcher.group(6);
	            list.add(IContent.of(IUnicode.of(token)));
	        }

	        pos = matcher.end();
	    }

	    if(pos < input.length())
	        list.add(IContent.of(input.substring(pos)));

	    return list.size() == 1 ? list.get(0) : IContent.of(list);
	}
	
	private class ContentBuilder {
		
		private int[] colors;
		private final List<Format> formats = new ArrayList<>();
		
		private void color(String s) {
			try {
				colors = new int[] {Integer.parseInt(s.substring(1), 16)};
			} catch (Exception e) {}
		}
		
		private void gradient(String s) {
			try {
				colors = Stream.of(s.split("-"))
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
			if(f != null) formats.add(f);
		}
		
		private IContent build(IContent input) {
			IColorer color;
			if(colors != null) {
				if(colors.length == 1) {
					if(formats.isEmpty()) color = IColorer.of(colors[0]);
					else color = IColorer.of(colors[0], Format.of(formats));
				} else {
					if(formats.isEmpty()) color = IColorer.of(Colors.of(colors));
					else color = IColorer.of(Colors.of(colors), Format.of(formats));
				}
			} else if(!formats.isEmpty()) color = IColorer.of(Colors.white, Format.of(formats));
			else color = null;
			
			colors = null;
			formats.clear();
			return color == null ? input : IContent.of(color, input);
		}
	}
	
	private record Text(String text, Type type) {}
	
	private enum Type {
		text, color, gradient, format;
	}

}
