package mc.rellox.spawnerlegacyapi.manager;

import java.util.function.Function;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.configuration.settings.IBooleanValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.IDoubleArrayValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.IDoubleValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.IEnumSet;
import mc.rellox.spawnerlegacyapi.configuration.settings.IIntValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.IPermissions;
import mc.rellox.spawnerlegacyapi.configuration.settings.IPlayerOptions;
import mc.rellox.spawnerlegacyapi.configuration.settings.IPriceValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.IPricesArrayValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.IPricesValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.ISimpleSet;
import mc.rellox.spawnerlegacyapi.configuration.settings.ITypePermissions;
import mc.rellox.spawnerlegacyapi.configuration.settings.IValue;
import mc.rellox.spawnerlegacyapi.configuration.settings.IValueBuilder;
import mc.rellox.spawnerlegacyapi.configuration.settings.IValueHeld;
import mc.rellox.spawnerlegacyapi.price.Group;

public interface IValueManager {
	
	<T> IValue<T> of(IValueBuilder<T, ?> builder, String path, String suffix);
	
	<T extends Enum<T>, U> IValue<T> of(IFile file, String path, String suffix, Class<T> type);
	
	<T, U> IValue<T> of(IValueBuilder<T, ?> builder, String path);
	
	<T extends Enum<T>, U> IValue<T> of(IFile file, String path, Class<T> type);
	
	<J> IValueHeld<J> of(IFile file, String path, Function<String, J> parser);
	
	<J> IValueHeld<J> of(IFile file, String path, String suffix, Function<String, J> parser);
	
	IIntValue ofInt(IFile file, String path, String suffix);
	
	IIntValue ofInt(IFile file, String path, String suffix, int min, int max);
	
	IIntValue ofInt(IFile file, String path);
	
	IIntValue ofInt(IFile file, String path, int min, int max);
	
	IDoubleValue ofDouble(IFile file, String path, String suffix);
	
	IDoubleValue ofDouble(IFile file, String path, String suffix, double min, double max);
	
	IDoubleValue ofDouble(IFile file, String path);
	
	IDoubleValue ofDouble(IFile file, String path, double min, double max);
	
	IDoubleArrayValue ofDoubleArray(IFile file, String path, String suffix);
	
	IDoubleArrayValue ofDoubleArray(IFile file, String path, String suffix, double min, double max);
	
	IDoubleArrayValue ofDoubleArray(IFile file, String path);
	
	IDoubleArrayValue ofDoubleArray(IFile file, String path, double min, double max);
	
	IBooleanValue ofBoolean(IFile file, String path, String suffix);
	
	IBooleanValue ofBoolean(IFile file, String path);
	
	<T extends Enum<T>> IEnumSet<T> ofEnum(IFile file, String path, Class<T> type);
	
	IPriceValue ofPrice(IFile file, String path, String suffix, Group group);
	
	IPriceValue ofPrice(IFile file, String path, Group group);
	
	IPricesValue ofPrices(IFile file, String path, String suffix, Group group);
	
	IPricesValue ofPrices(IFile file, String path, Group group);
	
	IPricesArrayValue ofPricesArray(IFile file, String path, String suffix, Group group);
	
	IPricesArrayValue ofPricesArray(IFile file, String path, Group group);
	
	IPlayerOptions ofOptions(IFile file, String path);
	
	IPermissions ofPerms(IFile file, String path, String permission);
	
	IPermissions ofPermsAddition(IFile file, String path, String permission);
	
	ITypePermissions ofTypePerms(IFile file, String path, String permission);
	
	<T> ISimpleSet<T> ofSet(IFile file, String path, Function<String, T> parser);
	
	ISimpleSet<String> ofSet(IFile file, String path);

}
