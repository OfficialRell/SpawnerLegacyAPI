package mc.rellox.spawnerlegacyapi.spawner.display;

import mc.rellox.spawnerlegacyapi.spawner.ISpawner;
import mc.rellox.spawnerlegacyapi.metadata.item.IBuildableItem;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IGeneratorInside extends ISave {

    /**
     * Changes the displayed entity inside the spawner.
     *
     * @param spawner spawner
     */

    void set(ISpawner spawner);

    interface IGeneratorInsideItem extends IGeneratorInside {

        /**
         * @return Displayed item
         */

        IBuildableItem item();

    }

    interface IGeneratorInsideType extends IGeneratorInside {

        /**
         * @return Displayed type
         */

        SpawnerType type();

    }

}
