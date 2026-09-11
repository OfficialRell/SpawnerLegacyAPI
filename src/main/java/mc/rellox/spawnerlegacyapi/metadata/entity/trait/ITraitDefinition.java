package mc.rellox.spawnerlegacyapi.metadata.entity.trait;

import java.util.Map;

public interface ITraitDefinition {

    /**
     * @return Trait identifier
     */

    String id();

    /**
     * @return Map of all read values
     */

    Map<String, Object> values();

    /**
     * @param id value identifier
     * @return {@code true} if the trait has the specified value by the identifier
     */

    boolean has(String id);

    /**
     * @param id  value identifier
     * @param <T> value type
     * @return Value by the specified identifier or {@code null}
     */

    <T> T value(String id);

}
