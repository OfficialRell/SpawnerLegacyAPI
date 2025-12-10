package mc.rellox.spawnerlegacyapi.text.content.color;

import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.Format;

public record GradientImpl(Colors colors, Format format) implements IGradient {

	@Override
	public String color(String text) {
		var builder = new StringBuilder();
		int l = text.length();
		if(l <= 1) builder.append(colors.color(0)).append(format).append(text);
		else {
			double v = 1.0 / (l - 1);
			for(int i = 0; i < l; i++)
				builder.append(Text.color(merge(v * i, colors.rgb())))
				.append(format).append(text.charAt(i));
		}
		return builder.toString();
	}
	
	public static int merge(double r, int... os) {
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
