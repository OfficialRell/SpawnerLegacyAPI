package mc.rellox.spawnerlegacyapi.text.content;

import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.color.IColorer;
import mc.rellox.spawnerlegacyapi.text.content.color.IColorer.Colors;
import mc.rellox.spawnerlegacyapi.text.content.unicode.IUnicode;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ContentParser {

    private static final Pattern PATTERN_COLOR, PATTERN_TOKEN;

    static {
        // Matches <#RRGGBB(-#RRGGBB)*>, <!format> or <name>
        PATTERN_COLOR = Pattern.compile(
                "<(?:(?<color>#[a-f\\d]{6}(?:-#[a-f\\d]{6})*)"
                        + "|(?<format>![a-z]+)"
                        + "|(?<name>[a-z_-]+))>",
                Pattern.CASE_INSENSITIVE
        );
        // Matches %variable[:i|r|.d]% or u+XXXX
        PATTERN_TOKEN = Pattern.compile(
                "(?<variable>%[a-z_]+(?::[ir]|:\\.\\d)?%)"
                        + "|(?<unicode>u\\+[\\da-f]{4})",
                Pattern.CASE_INSENSITIVE
        );
    }

    private static final Map<String, Integer> COLORS = Map.ofEntries(
            Map.entry("black", 0x000000),
            Map.entry("white", 0xffffff),
            Map.entry("red", 0xff0000),
            Map.entry("green", 0x00ff00),
            Map.entry("blue", 0x0000ff),
            Map.entry("yellow", 0xffff00),
            Map.entry("purple", 0xff00ff),
            Map.entry("orange", 0xff8000),
            Map.entry("magenta", 0xff0080),
            Map.entry("aqua", 0x00ffff),
            Map.entry("lilac", 0x8000ff),
            Map.entry("lime", 0x80ff00),
            Map.entry("mint", 0x00ff80),
            Map.entry("sky", 0x0080ff)
    );

    private static final Map<String, Format> FORMATS = Map.ofEntries(
            Map.entry("bold", Format.bold),
            Map.entry("b", Format.bold),
            Map.entry("italic", Format.italic),
            Map.entry("i", Format.italic),
            Map.entry("obfuscated", Format.obfuscated),
            Map.entry("o", Format.obfuscated),
            Map.entry("strikethrough", Format.strikethrough),
            Map.entry("s", Format.strikethrough),
            Map.entry("underline", Format.underline),
            Map.entry("u", Format.underline)
    );

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

        List<IContent> result = new ArrayList<>();
        Matcher matcher = PATTERN_COLOR.matcher(text);
        ContentBuilder builder = new ContentBuilder();

        int end = 0;

        while(matcher.find()) {
            int start = matcher.start();

            if(start > end) {
                String raw = text.substring(end, start);

                if(!raw.isEmpty())
                    result.add(builder.build(fill(raw)));
            }

            String color = matcher.group("color");
            String format = matcher.group("format");
            String name = matcher.group("name");

            if(color != null) {
                if(color.indexOf('-') >= 0) builder.gradient(color);
                else builder.color(color);
            } else if(format != null) {
                builder.format(format);
            } else if(name != null) {
                int rgb = color(name);
                if(rgb >= 0) builder.color(rgb);
                else result.add(builder.build(fill(matcher.group())));
            }

            end = matcher.end();
        }

        if(end < text.length())
            result.add(builder.build(fill(text.substring(end))));

        return IContent.of(result);
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

            String variable = matcher.group("variable");

            if(variable != null) {
                String inner = variable.substring(1, variable.length() - 1);
                list.add(IContent.of(IVariable.of(inner)));
            } else {
                String unicode = matcher.group("unicode");
                list.add(IContent.of(IUnicode.of(unicode)));
            }

            pos = matcher.end();
        }

        if(pos < input.length())
            list.add(IContent.of(input.substring(pos)));

        return IContent.of(list);
    }

    private static int color(String input) {
        if(input == null || input.isEmpty()) return -1;
        input = input.toLowerCase(Locale.ROOT).replace('-', '_');

        String name = input.substring(input.indexOf('_') + 1);
        int color = COLORS.getOrDefault(name, -1);
        if(color < 0) return -1;

        if(input.startsWith("light_")) return Text.lighten(color, 0.5);
        if(input.startsWith("dark_")) return Text.darken(color, 0.5);
        return color;
    }

    private static class ContentBuilder {

        private int[] colors;
        private final List<Format> formats = new ArrayList<>();

        private void color(String s) {
            colors = new int[] {
                    Integer.parseInt(s.substring(1), 16)
            };
        }

        private void color(int color) {
            colors = new int[] {
                    color
            };
        }

        private void gradient(String s) {
            colors = Stream.of(s.split("-"))
                    .mapToInt(t -> Integer.parseInt(t.substring(1), 16))
                    .toArray();
        }

        private void format(String s) {
            Format format = FORMATS.get(s.substring(1));
            if(format != null) formats.add(format);
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
            } else if(!formats.isEmpty()) {
                color = IColorer.of(Colors.white, Format.of(formats));
            } else {
                color = null;
            }

            colors = null;
            formats.clear();
            return color == null ? input : IContent.of(color, input);
        }
    }

}
