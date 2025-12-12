package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariable;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public record ContentVariable(IVariable variable) implements IContent {
	
	@Override
	public String text(IVariables variables) {
		var string = variables.get(variable);
		if(string == null || string.isEmpty() || variable.key().equals(string))
			return variable.key();
		return variable.map(string);
	}
	
	@Override
	public String toString() {
		return text();
	}

}
