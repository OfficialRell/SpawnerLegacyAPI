package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.function.Function;
import java.util.stream.Stream;

import org.bukkit.configuration.ConfigurationSection;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public interface IHeldValue<T> {

	static <T> IHeldValue<T> of(IFile file, String path, Function<String, T> parser) {
		Object object = file.get(path);
		if(object == null)
			throw new NullPointerException("Value for path '" + path + "' cannot be null");

		try {
			if(object instanceof ConfigurationSection cs) {
				String initial = cs.getString("initial");
				if(initial == null || initial.isEmpty() == true)
					throw new NullPointerException("Initial value for path '" + path + "' cannot be null");
				T value = parser.apply(initial);
				Object[] values = Stream.of(HolderType.values())
						.map(type -> cs.getString(type.key()))
						.map(parser)
						.toArray();
				return new HeldFilled<T>(value, values);
			}
			String initial = file.getString(path);
			if(initial == null || initial.isEmpty() == true)
				throw new NullPointerException("Initial value for path '" + path + "' cannot be null");
			T value = parser.apply(initial);
			return new HeldSingle<T>(value);
		} catch (Exception e) {
			RF.debug(e);
		}
		return t -> null;
	}

	T get(HolderType type);

	record HeldSingle<T>(T value) implements IHeldValue<T> {

		@Override
		public T get(HolderType type) {
			return value;
		}

	}

	record HeldFilled<T>(T initial, Object[] values) implements IHeldValue<T> {

		@SuppressWarnings("unchecked")
		@Override
		public T get(HolderType type) {
			Object value = values[type.ordinal()];
			return value == null ? initial : (T) value;
		}

	}

}
