package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.List;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.configuration.IFileValues;

public interface ValueType<U> {
	
	ValueType<String> STRING = IFileValues::getString;
	ValueType<List<String>> STRINGS = IFileValues::getStrings;
	
	U get(IFile file, String path);

}
