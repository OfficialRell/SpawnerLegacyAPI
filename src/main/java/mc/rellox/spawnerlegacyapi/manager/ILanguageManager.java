package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.text.content.IContent;

import java.util.List;
import java.util.function.Supplier;

public interface ILanguageManager {

    /**
     * Caches text contents.
     *
     * @param key      key
     * @param contents text content list
     */

    void add(String key, List<IContent> contents);

    /**
     * Caches text contents.
     *
     * @param key      key
     * @param contents text content array
     */

    void add(String key, IContent... contents);

    /**
     * @param key key
     * @return Single content or {@link IContent#empty} if not found
     */

    IContent get(String key);

    /**
     * @param key         key
     * @param placeholder placeholder key
     * @param value       placeholder value
     * @return Single content or {@link IContent#empty} if not found
     */

    IContent get(String key, String placeholder, Object value);

    /**
     * @param key   key
     * @param pairs placeholder key-value pairs
     * @return Single content or {@link IContent#empty} if not found
     */

    IContent get(String key, Object... pairs);

    /**
     * @param key key
     * @return List of contents or empty list if not found
     */

    List<IContent> list(String key);

    /**
     * @param key         key
     * @param placeholder placeholder key
     * @param value       placeholder value
     * @return List of contents or empty list if not found
     */

    List<IContent> list(String key, String placeholder, Object value);

    /**
     * @param key   key
     * @param pairs placeholder key-value pairs
     * @return List of contents or empty list if not found
     */

    List<IContent> list(String key, Object... pairs);

    /**
     * @param key      key
     * @param fallback fallback value
     * @return Single content or fallback value if not found
     */

    IContent or(String key, IContent fallback);

    /**
     * @param key      key
     * @param fallback fallback supplier
     * @return Single content or fallback value from the supplier if not found
     */

    IContent or(String key, Supplier<IContent> fallback);

}
