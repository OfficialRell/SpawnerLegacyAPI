package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.configuration.IMemory;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface IValueBuilder<T, U> {

    BiFunction<IFile, String, String> STRING = IMemory::getString;
    BiFunction<IFile, String, List<String>> STRINGS = IMemory::getStrings;
    BiFunction<IFile, String, IMemory> MEMORY = IMemory::child;
    BiFunction<IFile, String, Set<IMemory>> MEMORIES = IMemory::children;

    static <T, U> IValueBuilder<T, U> of(IFile file, BiFunction<IFile, String, U> type, Function<U, T> parser) {
        return new GenericBuilder<>(file, type, parser);
    }

    static <T> IValueBuilder<T, String> ofString(IFile file, Function<String, T> parser) {
        return new GenericBuilder<>(file, STRING, parser);
    }

    static <T> IValueBuilder<T, IMemory> ofMemory(IFile file, Function<IMemory, T> parser) {
        return new GenericBuilder<>(file, MEMORY, parser);
    }

    static <T extends Enum<T>> IValueBuilder<T, String> of(IFile file, Class<T> ec) {
        return new GenericBuilder<>(file, STRING, u -> RF.enumerate(ec, u));
    }

    static <J> IValueBuilder<IHeldValue<J>, Object> of(IFile file, Function<String, J> parser) {
        return new HolderBuilder<>(file, parser);
    }

    @Deprecated(since = "4.1.0", forRemoval = true)
    static <T, U> IValueBuilder<T, U> of(IFile file, ValueType<U> type, Function<U, T> parser) {
        return new GenericBuilder<>(file, type::get, parser);
    }

    IFile file();

    T build(String path);

    default boolean exists(String path) {
        return file().exists(path);
    }

    record GenericBuilder<T, U>(IFile file, BiFunction<IFile, String, U> type, Function<U, T> parser)
            implements IValueBuilder<T, U> {

        @Override
        public T build(String path) {
            U value = type.apply(file, path);
            return value == null ? null : parser.apply(value);
        }

    }

    record HolderBuilder<J>(IFile file, Function<String, J> parser)
            implements IValueBuilder<IHeldValue<J>, Object> {

        @Override
        public IHeldValue<J> build(String path) {
            return exists(path)
                    ? IHeldValue.of(file, path, parser)
                    : null;
        }

    }

}
