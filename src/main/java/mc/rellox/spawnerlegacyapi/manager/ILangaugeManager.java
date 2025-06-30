package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;

import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface ILangaugeManager {
	
	IContent get(String key);
	
	IContent get(String key, String k, Object o);
	
	IContent get(String key, Object... vs);
	
	List<IContent> list(String key);
	
	List<IContent> list(String key, String k, Object o);
	
	List<IContent> list(String key, Object... vs);
	
	IContent or(String key, IContent text);

}
