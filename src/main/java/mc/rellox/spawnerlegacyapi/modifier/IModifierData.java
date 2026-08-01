package mc.rellox.spawnerlegacyapi.modifier;

import java.util.Map;
import java.util.Set;

public interface IModifierData {

    <T> T get(String key);

    void put(String key, Object value);

    boolean has(String key);

    Set<String> keys();

    Map<String, Object> map();

}

