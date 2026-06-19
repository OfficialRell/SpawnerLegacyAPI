package mc.rellox.spawnerlegacyapi.text.content.color;

import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.Format;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentList;
import mc.rellox.spawnerlegacyapi.text.content.type.ContentVariable;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public record ColorerImpl(String color, Format format) implements IColorer {

    @Override
    public String color(String text) {
		// don't color if already colored
        if(text.indexOf(Text.color_char) >= 0) return text;

        return color + format + text;
    }

    @Override
    public String color(IContent content, IVariables variables) {
        if(content instanceof ContentList list) {
            StringBuilder builder = new StringBuilder();
            for(IContent part : list.list) {
                append(builder, part, variables);
            }
            return builder.toString();
        }
        String text = content.text(variables);
        return color(text);
    }

    private void append(StringBuilder builder, IContent content, IVariables variables) {
        if(content instanceof ContentVariable variable) {
            String value = variable.text(variables);
            if(value.indexOf(Text.color_char) >= 0) {
                builder.append(value);
                builder.append(color).append(format);
            } else {
                builder.append(color).append(format).append(value);
            }
            return;
        }

        if(content instanceof ContentList list) {
            for(IContent part : list.list) append(builder, part, variables);
            return;
        }

        String text = content.text(variables);
        if(text.isEmpty()) return;
        builder.append(color).append(format).append(text);
    }

}
