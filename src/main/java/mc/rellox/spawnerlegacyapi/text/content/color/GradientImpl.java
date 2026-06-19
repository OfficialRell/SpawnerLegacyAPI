package mc.rellox.spawnerlegacyapi.text.content.color;

import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.Format;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentList;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentVariable;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;
import org.bukkit.ChatColor;

public record GradientImpl(Colors colors, Format format) implements IGradient {

    @Override
    public String color(String text) {
		// don't color if already colored
        if(text.indexOf(Text.color_char) >= 0) return text;

        var builder = new StringBuilder();
        int l = text.length();
        if(l <= 1) builder.append(colors.color(0)).append(format).append(text);
        else {
            double v = 1.0 / (l - 1);
            for(int i = 0; i < l; i++)
                builder.append(Text.colorFast(merge(v * i, colors.rgb())))
                        .append(format).append(text.charAt(i));
        }
        return builder.toString();
    }

    @Override
    public String color(IContent content, IVariables variables) {
        int length = length(content, variables);
        if(length <= 0) return "";

        StringBuilder builder = new StringBuilder();
        State state = new State(length);
        append(builder, content, variables, state);
        return builder.toString();
    }

    private void append(StringBuilder builder, IContent content, IVariables variables, State state) {
        if(content instanceof ContentList list) {
            for(IContent part : list.list)
                append(builder, part, variables, state);
            return;
        }

        if(content instanceof ContentVariable variableContent) {
            String value = variableContent.text(variables);
            if(value == null || value.isEmpty()) return;

            if(value.indexOf(Text.color_char) >= 0) {
                builder.append(value);
                state.index += length(value);
            } else {
                appendPlain(builder, value, state);
            }
            return;
        }

        String text = content.text(variables);
        if(text == null || text.isEmpty()) return;
        appendPlain(builder, text, state);
    }

    private void appendPlain(StringBuilder builder, String text, State state) {
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if(c == Text.color_char) {
                builder.append(c);
                if(i + 1 < text.length()) builder.append(text.charAt(++i));
                continue;
            }

            builder.append(color(state.index, state.length))
                    .append(format)
                    .append(c);
            state.index++;
        }
    }

    private String color(int index, int length) {
        if(length <= 1) return colors.color(0);
        double at = (double) index / (double) (length - 1);
        return Text.colorFast(merge(at, colors.rgb()));
    }

    private int length(IContent content, IVariables variables) {
        if(content instanceof ContentList list) {
            int sum = 0;
            for(IContent part : list.list) sum += length(part, variables);
            return sum;
        }
        String text = content.text(variables);
        return length(text);
    }

    private int length(String text) {
        return ChatColor.stripColor(text).length();
    }

    private static class State {
        private final int length;
        private int index;

        private State(int length) {
            this.length = length;
        }
    }

    public static int merge(double r, int... os) {
        if(r <= 0.0) return os[0];
        if(r >= 1.0) return os[os.length - 1];
        int l = os.length - 1, m = (int) (r *= l);
        int a = os[m], b = os[m + 1];
        double i = 1 - (r -= m);

        int[] as = {
                a & 0xff, (a >> 8) & 0xff, (a >> 16) & 0xff,
                b & 0xff, (b >> 8) & 0xff, (b >> 16) & 0xff
        };
        int[] cs = {
                (int) (as[0] * i + as[3] * r),
                (int) (as[1] * i + as[4] * r),
                (int) (as[2] * i + as[5] * r)
        };
        return cs[0] | (cs[1] << 8) | (cs[2] << 16);
    }

}
