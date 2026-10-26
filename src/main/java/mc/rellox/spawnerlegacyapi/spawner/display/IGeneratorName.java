package mc.rellox.spawnerlegacyapi.spawner.display;

import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IGeneratorName extends ISave {

    /**
     * @return Spawner display name
     */

    IContent name();

}
