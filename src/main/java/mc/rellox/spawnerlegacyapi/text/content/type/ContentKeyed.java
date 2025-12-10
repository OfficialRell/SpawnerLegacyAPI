package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public record ContentKeyed(String key, IContent content) implements IContent {

	@Override
	public String text(IVariables variables) {
		return content.text(variables);
	}
	
	@Override
	public final String toString() {
		return text();
	}

}
