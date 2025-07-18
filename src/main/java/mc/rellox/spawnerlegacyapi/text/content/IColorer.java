package mc.rellox.spawnerlegacyapi.text.content;

import mc.rellox.spawnerlegacyapi.text.Text;

public interface IColorer {
	
	static IColorer of(int rgb) {
		return new ColorerRegular(rgb, Format.none);
	}
	
	static IColorer of(int rgb, Format format) {
		return new ColorerRegular(rgb, format);
	}
	
	static IColorer of(Colors colors) {
		return new Gradient(colors);
	}
	
	static IColorer of(Colors colors, Format format) {
		return new GradientFormatted(colors, format);
	}
	
	static IColorer reset() {
		return text -> Text.color_char + "r" + text;
	}
	
	String color(String text);
	
	class ColorerRegular implements IColorer {
		
		private final String color;
		private final Format format;
		
		public ColorerRegular(int rgb, Format format) {
			this.color = Text.color(rgb);
			this.format = format;
		}
		
		@Override
		public String color(String text) {
			return color + format + text;
		}
		
	}
	
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
			int color = Gradient.merge(at, rgb);
			return Text.colorFast(color) + text;
		}
	}
	
	class Gradient implements IColorer {
		
		protected final Colors colors;
		
		public Gradient(Colors colors) {
			this.colors = colors;
		}
		
		@Override
		public String color(String text) {
			var sb = new StringBuilder();
			int l = text.length();
			if(l <= 1) sb.append(colors.color(0))
				.append(text);
			else {
				double v = 1.0 / (l - 1);
				for(int i = 0; i < l; i++)
					sb.append(Text.color(merge(v * i, colors.rgb())))
					.append(text.charAt(i));
			}
			return sb.toString();
		}
		
		protected static int merge(double r, int... os) {
			if(r <= 0.0) return os[0];
			if(r >= 1.0) return os[os.length - 1];
			int l = os.length - 1, m = (int) (r *= l);
			int a = os[m], b = os[m + 1];
			double i = 1 - (r -= m);

			int[] as = {a & 0xff, (a >> 8) & 0xff, (a >> 16) & 0xff,
				b & 0xff, (b >> 8) & 0xff, (b >> 16) & 0xff};
			int[] cs = {(int) (as[0] * i + as[3] * r),
						(int) (as[1] * i + as[4] * r),
						(int) (as[2] * i + as[5] * r)};
			return cs[0] | (cs[1] << 8) | (cs[2] << 16);
		}
		
	}
	
	class GradientFormatted extends Gradient {
		
		private final Format format;

		public GradientFormatted(Colors colors, Format format) {
			super(colors);
			this.format = format;
		}
		
		@Override
		public String color(String text) {
			var sb = new StringBuilder();
			int l = text.length();
			if(l <= 1) sb.append(Text.color(colors.color(0)))
				.append(format.toString())
				.append(text);
			else {
				double v = 1.0 / (l - 1);
				for(int i = 0; i < l; i++)
					sb.append(Text.color(merge(v * i, colors.rgb())))
					.append(format.toString()).append(text.charAt(i));
			}
			return sb.toString();
		}
		
	}

}
