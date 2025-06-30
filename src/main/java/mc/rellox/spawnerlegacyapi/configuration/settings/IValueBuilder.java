package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.function.Function;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public interface IValueBuilder<T, U> {

	static <T, U> IValueBuilder<T, U> of(IFile file, ValueType<U> type, Function<U, T> parser) {
		return new GenericBuilder<>(file, type, parser);
	}

	static <T extends Enum<T>> IValueBuilder<T, String> of(IFile file, Class<T> ec) {
		return new GenericBuilder<>(file, ValueType.STRING, u -> RF.enumerate(ec, u));
	}

	static <J> IValueBuilder<IHeldValue<J>, Object> of(IFile file, Function<String, J> parser) {
		return new HolderBuilder<>(file, parser);
	}
	
	IFile file();

	T build(String path);
	
	default boolean exists(String path) {
		return file().exists(path) == true;
	}

	record GenericBuilder<T, U>(IFile file, ValueType<U> type, Function<U, T> parser) implements IValueBuilder<T, U> {

		@Override
		public T build(String path) {
			U value = type.get(file, path);
			return value == null ? null : parser.apply(value);
		}

	}

	record HolderBuilder<J>(IFile file, Function<String, J> parser) implements IValueBuilder<IHeldValue<J>, Object> {

		@Override
		public IHeldValue<J> build(String path) {
			if(exists(path) == false) return null;
			return IHeldValue.of(file, path, parser);
		}

	}

}
