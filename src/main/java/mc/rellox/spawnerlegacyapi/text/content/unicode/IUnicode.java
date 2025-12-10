package mc.rellox.spawnerlegacyapi.text.content.unicode;

import mc.rellox.spawnerlegacyapi.text.Text;

public interface IUnicode {
	
	static IUnicode of(String code) {
		var chars = Text.unicode(code);
		return new UnicodeImpl(code, chars);
	}
	
	/**
	 * @return The unicode code representation (e.g. "u+2605")
	 */
	
	String code();
	
	/**
	 * @return The actual characters represented by the unicode code
	 */
	
	String chars();

}
