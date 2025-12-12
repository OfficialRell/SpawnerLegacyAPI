package mc.rellox.spawnerlegacyapi.text.content.color;

import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.Format;

public interface IColorer {
	
	static IColorer of(int rgb) {
		return of(rgb, Format.none);
	}
	
	static IColorer of(int rgb, Format format) {
		return new ColorerImpl(Text.colorFast(rgb), format);
	}
	
	static IColorer of(String hex) {
		return of(hex, Format.none);
	}
	
	static IColorer of(String hex, Format format) {
		return new ColorerImpl(Text.color(hex), format);
	}
	
	static IGradient of(Colors colors) {
		return IGradient.of(colors);
	}
	
	static IGradient of(Colors colors, Format format) {
		return IGradient.of(colors, format);
	}
	
	static IColorer reset() {
		return new ColorerImpl("", Format.reset);
	}
	
	/**
	 * @param text - input text
	 * @return colored text
	 */
	
	String color(String text);
	
	/**
	 * @return format of the colorer
	 */
	
	Format format();
	
	record Colors(int... rgb) {
		
		public static final int red = 0xff0000,
				red_50 = 0x800000,
				pink = 0xff80bf,
				green = 0x00ff00,
				green_50 = 0x008000,
				blue = 0x0000ff,
				blue_50 = 0x000080,
				yellow = 0xffff00,
				purple = 0xff00ff,
				purple_50 = 0x800080,
				orange = 0xff8000,
				aqua = 0x00ffff,
				aqua_50 = 0x008080,
				mint = 0x00ff80,
				mint_50 = 0x008040,
				lime = 0x80ff00,
				gray_75 = 0xc4c4c4,
				gray_50 = 0x808080,
				gray_25 = 0x404040,
				white = 0xffffff;
		
		public static Colors of(int... rgb) {
			return new Colors(rgb);
		}
		
		public String color(int i) {
			return Text.color(rgb[i]);
		}
		
		public String color(String text, double at) {
			int color = GradientImpl.merge(at, rgb);
			return Text.colorFast(color) + text;
		}
	}

}
