package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.configuration.IMemory;

import java.util.List;

@Deprecated(since = "4.1.0", forRemoval = true)
public interface ValueType<U> {

    ValueType<String> STRING = IMemory::getString;
    ValueType<List<String>> STRINGS = IMemory::getStrings;

    U get(IFile file, String path);

}
