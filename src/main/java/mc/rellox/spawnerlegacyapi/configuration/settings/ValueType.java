package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.List;

import mc.rellox.spawnerlegacyapi.configuration.IFile;

public interface ValueType<U> {
	
	public static final ValueType<String> STRING = (file, path) -> file.getString(path);
	public static final ValueType<List<String>> STRINGS = (file, path) -> file.getStrings(path);
	
	U get(IFile file, String path);

}
