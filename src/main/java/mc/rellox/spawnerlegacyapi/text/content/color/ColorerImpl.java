package mc.rellox.spawnerlegacyapi.text.content.color;

import mc.rellox.spawnerlegacyapi.text.content.Format;

public class ColorerImpl implements IColorer {
	
	private final String color;
	private final Format format;
	
	public ColorerImpl(String color, Format format) {
		this.color = color;
		this.format = format;
	}
	
	@Override
	public String color(String text) {
		return color + format + text;
	}

	@Override
	public Format format() {
		return format;
	}
	
}
