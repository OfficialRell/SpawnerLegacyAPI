package mc.rellox.spawnerlegacyapi.text.content.color;

import mc.rellox.spawnerlegacyapi.text.content.Format;

public interface IGradient extends IColorer {
	
	static IGradient of(Colors colors) {
		return new GradientImpl(colors, Format.none);
	}
	
	static IGradient of(Colors colors, Format format) {
		return new GradientImpl(colors, format);
	}
	
	/**
	 * @return The colors used in this gradient
	 */
	
	Colors colors();

}
