package mc.rellox.spawnerlegacyapi.metadata;

import mc.rellox.spawnerlegacyapi.spawner.display.IGeneratorInside;
import mc.rellox.spawnerlegacyapi.spawner.display.IGeneratorName;

public interface IMetadata {

    /**
     * @return ID of this metadata
     */

    String id();

    /**
     * @return Generator display name or {@code null}
     */

    IGeneratorName name();

    /**
     * @return Generator inside display or {@code null}
     */

    IGeneratorInside inside();

}
