package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.unicode.IUnicode;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public record ContentUnicode(IUnicode unicode) implements IContent {

	@Override
	public String text(IVariables vars) {
		return unicode.chars();
	}

}
