package mc.rellox.spawnerlegacyapi.text.content;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mc.rellox.spawnerlegacyapi.text.Text;

public record Format(String format) {
	
	public static final Format none = new Format("");
	public static final Format bold = new Format(Text.color_char + "l");
	public static final Format italic = new Format(Text.color_char + "o");
	public static final Format underline = new Format(Text.color_char + "n");
	public static final Format strikethrough = new Format(Text.color_char + "m");
	public static final Format obfuscated = new Format(Text.color_char + "k");
	public static final Format reset = new Format(Text.color_char + "r");
	
	public static Format of(Format... fs) {
		return new Format(Stream.of(fs)
				.map(Format::format)
				.collect(Collectors.joining()));
	}
	
	public static Format of(List<Format> list) {
		return new Format(list.stream()
				.map(Format::format)
				.collect(Collectors.joining()));
	}
	
	@Override
	public String toString() {
		return format;
	}

}
