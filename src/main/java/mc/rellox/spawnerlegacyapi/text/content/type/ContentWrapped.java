package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public record ContentWrapped(IContent content) implements IContent {
	
	@Override
	public String text(IVariables variables) {
		return content.text(variables);
	}

}
