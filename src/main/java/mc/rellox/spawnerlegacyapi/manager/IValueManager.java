package mc.rellox.spawnerlegacyapi.manager;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.configuration.settings.*;
import mc.rellox.spawnerlegacyapi.configuration.filter.IFilter;
import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;
import mc.rellox.spawnerlegacyapi.price.Group;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import org.bukkit.World;

import java.util.function.Function;

public interface IValueManager {

    /**
     * @param id filter name
     * @return Filter by the id or {@code null}
     */

    IFilter filter(String id);

    /**
     * Creates a simple filter context.
     *
     * @param world world
     * @param type spawner type
     * @return Newly created filter context
     */

    IFilterContext context(World world, SpawnerType type);

    /**
     * Registers a new filter.
     *
     * @param filter filter
     *
     * @throws IllegalArgumentException if a filter with the same name already exists
     */

    void submit(IFilter filter);

    <T> IValue<T> of(IValueBuilder<T, ?> builder, String path, String suffix);

    <T extends Enum<T>> IValue<T> of(IFile file, String path, String suffix, Class<T> type);

    <T> IValue<T> of(IValueBuilder<T, ?> builder, String path);

    <T extends Enum<T>> IValue<T> of(IFile file, String path, Class<T> type);

    <T> ITypedValue<T> ofTyped(IValueBuilder<T, ?> builder, String path, String suffix);

    <T extends Enum<T>> ITypedValue<T> ofTyped(IFile file, String path, String suffix, Class<T> type);

    <T> ITypedValue<T> ofTyped(IValueBuilder<T, ?> builder, String path);

    <T extends Enum<T>> ITypedValue<T> ofTyped(IFile file, String path, Class<T> type);

    <J> IValueHeld<J> of(IFile file, String path, Function<String, J> parser);

    <J> IValueHeld<J> of(IFile file, String path, String suffix, Function<String, J> parser);

    IIntValue ofInt(IFile file, String path, String suffix);

    IIntValue ofInt(IFile file, String path, String suffix, int min, int max);

    IIntValue ofInt(IFile file, String path);

    IIntValue ofInt(IFile file, String path, int min, int max);

    IIntTypedValue ofIntTyped(IFile file, String path, String suffix);

    IIntTypedValue ofIntTyped(IFile file, String path, String suffix, int min, int max);

    IIntTypedValue ofIntTyped(IFile file, String path);

    IIntTypedValue ofIntTyped(IFile file, String path, int min, int max);

    IDoubleValue ofDouble(IFile file, String path, String suffix);

    IDoubleValue ofDouble(IFile file, String path, String suffix, double min, double max);

    IDoubleValue ofDouble(IFile file, String path);

    IDoubleValue ofDouble(IFile file, String path, double min, double max);

    IDoubleTypedValue ofDoubleTyped(IFile file, String path, String suffix);

    IDoubleTypedValue ofDoubleTyped(IFile file, String path, String suffix, double min, double max);

    IDoubleTypedValue ofDoubleTyped(IFile file, String path);

    IDoubleTypedValue ofDoubleTyped(IFile file, String path, double min, double max);

    IDoubleArrayValue ofDoubleArray(IFile file, String path, String suffix);

    IDoubleArrayValue ofDoubleArray(IFile file, String path, String suffix, double min, double max);

    IDoubleArrayValue ofDoubleArray(IFile file, String path);

    IDoubleArrayValue ofDoubleArray(IFile file, String path, double min, double max);

    IBooleanValue ofBoolean(IFile file, String path, String suffix);

    IBooleanValue ofBoolean(IFile file, String path);

    IBooleanTypedValue ofBooleanTyped(IFile file, String path, String suffix);

    IBooleanTypedValue ofBooleanTyped(IFile file, String path);

    <T extends Enum<T>> IEnumSet<T> ofEnum(IFile file, String path, Class<T> type);

    IPriceValue ofPrice(IFile file, String path, String suffix, Group group);

    IPriceValue ofPrice(IFile file, String path, Group group);

    IPriceTypedValue ofPriceTyped(IFile file, String path, String suffix, Group group);

    IPriceTypedValue ofPriceTyped(IFile file, String path, Group group);

    IPricesValue ofPrices(IFile file, String path, String suffix, Group group);

    IPricesValue ofPrices(IFile file, String path, Group group);

    IPricesTypedValue ofPricesTyped(IFile file, String path, String suffix, Group group);

    IPricesTypedValue ofPricesTyped(IFile file, String path, Group group);

    IPricesArrayValue ofPricesArray(IFile file, String path, String suffix, Group group);

    IPricesArrayValue ofPricesArray(IFile file, String path, Group group);

    IPlayerOptions ofOptions(IFile file, String path);

    IValuePermissions ofValuePermissions(IFile file, String path, String permission);

    IValuePermissions ofAdditionPermissions(IFile file, String path, String permission);

    IPermissions ofPermissions(IFile file, String path, String permission);

    IPermissionsTyped ofPermissionsTyped(IFile file, String path, String permission);

    <T> ISimpleSet<T> ofSet(IFile file, String path, Function<String, T> parser);

    ISimpleSet<String> ofSet(IFile file, String path);

}
