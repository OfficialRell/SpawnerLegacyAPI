package mc.rellox.spawnerlegacyapi.text.content.type;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.text.content.variable.IVariables;

public class ContentEmpty implements IContent {
	
	public static final ContentEmpty empty = new ContentEmpty();
	
	private ContentEmpty() {}
	
	@Override
	public String text(IVariables variables) {
		return "";
	}
	
	@Override
	public String toString() {
		return "";
	}

}
