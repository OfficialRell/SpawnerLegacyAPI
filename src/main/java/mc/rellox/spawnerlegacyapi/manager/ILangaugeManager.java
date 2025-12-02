package mc.rellox.spawnerlegacyapi.manager;

import java.util.List;

import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface ILangaugeManager {
	
	/**
	 * Caches text contents.
	 * 
	 * @param key - key
	 * @param contents - text content list
	 */
	
	void add(String key, List<IContent> contents);
	
	/**
	 * Caches text contents.
	 * 
	 * @param key - key
	 * @param contents - text content array
	 */
	
	void add(String key, IContent... contents);
	
	/**
	 * @param key - key
	 * @return Single content or {@link IContent#empty} if not found
	 */
	
	IContent get(String key);
	
	/**
	 * @param key - key
	 * @param k - placeholder key
	 * @param o - placeholder value
	 * @return Single content or {@link IContent#empty} if not found
	 */
	
	IContent get(String key, String k, Object o);
	
	/**
	 * @param key - key
	 * @param vs - placeholder key-value pairs
	 * @return Single content or {@link IContent#empty} if not found
	 */
	
	IContent get(String key, Object... vs);
	
	/**
	 * @param key - key
	 * @return List of contents or empty list if not found
	 */
	
	List<IContent> list(String key);
	
	/**
	 * @param key - key
	 * @param k - placeholder key
	 * @param o - placeholder value
	 * @return List of contents or empty list if not found
	 */
	
	List<IContent> list(String key, String k, Object o);
	
	/**
	 * @param key - key
	 * @param vs - placeholder key-value pairs
	 * @return List of contents or empty list if not found
	 */
	
	List<IContent> list(String key, Object... vs);
	
	/**
	 * @param key - key
	 * @param def - default content
	 * @return Single content or default if not found
	 */
	
	IContent or(String key, IContent def);

}
