package mc.rellox.spawnerlegacyapi.text.content.type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public class ContentList implements IContent {
		
	public final List<IContent> list;
	
	public ContentList(List<IContent> list, boolean copy) {
		this.list = copy ? new ArrayList<>(list) : list;
	}
	
	public ContentList(List<IContent> list) {
		this(list, false);
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
