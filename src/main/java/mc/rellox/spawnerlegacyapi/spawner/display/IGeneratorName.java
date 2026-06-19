package mc.rellox.spawnerlegacyapi.spawner.display;

import mc.rellox.spawnerlegacyapi.spawner.meta.IDisplay;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IGeneratorName extends IDisplay, ISave {

    /**
     * @return Spawner display name
     */

    IContent name();

    @Override
    default IContent display() {
        return name();
    }

}
