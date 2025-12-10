package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.color.IColorer;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public record ContentColored(IContent content, IColorer colorer) implements IContent {

	@Override
	public String text(IVariables variables) {
		return colorer.color(content.text(variables));
	}
	
	@Override
	public final String toString() {
		return text();
	}

}
