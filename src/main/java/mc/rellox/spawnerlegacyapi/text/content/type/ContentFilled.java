package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public record ContentFilled(IContent content, IVariables vars) implements IContent {
	
	@Override
	public String text(IVariables variables) {
		return content.text(vars.combine(variables));
	}
	
	@Override
	public final String toString() {
		return text();
	}

}
