package mc.rellox.spawnerlegacyapi.spawner.display;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface IGeneratorDisplay extends ISave {

    IGeneratorName name();

    IGeneratorInside inside();

    @Override
    default void save(IFile file, String path) {
        name().save(file, path + ".name");
        inside().save(file, path + ".inside");
    }
}
