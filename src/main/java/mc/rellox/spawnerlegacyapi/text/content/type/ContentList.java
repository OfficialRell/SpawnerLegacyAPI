package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record ContentList(List<IContent> list) implements IContent {

    public ContentList(List<IContent> list, boolean copy) {
        this(copy ? new ArrayList<>(list) : list);
    }

    public ContentList(IContent... array) {
        this(List.of(array), true);
    }

    @Override
    public String text(IVariables variables) {
        return list.stream()
                .map(content -> content.text(variables))
                .collect(Collectors.joining());
    }

}
