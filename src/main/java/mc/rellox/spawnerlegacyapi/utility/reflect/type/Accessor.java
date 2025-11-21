package mc.rellox.spawnerlegacyapi.utility.reflect.type;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public interface Accessor<R> {

	static Accessor<?> empty = new Accessor<>() {
		@Override
		public Object get() {return null;}
		@Override
		public Object objected(Object object) {return null;}
		@Override
		public void set(Object r) {}
		@Override
		public String name() {return "null";}
		@Override
		public Class<?> type() {return null;}
	};
	
	@SuppressWarnings("unchecked")
	static <R> Accessor<R> empty() {
		return (Accessor<R>) empty;
	}
	
	R get();
	
	R objected(Object object);

	void set(R r);
	
	String name();
	
	Class<?> type();
	
	default boolean warning() {
		return false;
	}
	
	default R get(R def) {
		R r = get();
		return r == null ? def : r;
	}
	
	@SuppressWarnings("unchecked")
	default void force(Object o) {
		set((R) o);
	}
	
	default Accessor<?> next(String next) {
		return next(next, null);
	}
	
	default <O> Accessor<O> next(String next, Class<O> returns) {
		R r = get();
		return r == null ? empty()
				: of(r.getClass(), r, next, returns, warning());
	}
	
	@SuppressWarnings("unchecked")
	default <O> Accessor<O> as(Class<O> c) {
		return (Accessor<O>) this;
	}
	
	static <R> Accessor<R> of(Class<?> clazz, Object object, String name, Class<R> returns, boolean warn) {
		if(clazz == null) return empty();
		try {
			Field field = field(clazz, name, warn);
			if(field == null) return empty();
			field.setAccessible(true);
			return of(field, object, returns, warn);
		} catch (Exception e) {
			RF.debug(e, warn);
		}
		return empty();
	}
	
	static <R> List<Accessor<R>> of(Class<?> clazz, Object object, Class<R> returns, int limit, boolean warn) {
		if(clazz == null) return List.of();
		try {
			Set<Field> set = fields(clazz);
			if(set.isEmpty()) {
				RF.debug(new NoSuchFieldException("No fields with return type of "
						+ returns.getName()), warn);
				return List.of();
			}
			return set.stream()
					.filter(field -> returns.isAssignableFrom(field.getType()))
					.limit(limit)
					.peek(field -> field.setAccessible(true))
					.map(field -> of(field, object, returns, warn))
					.toList();
		} catch (Exception e) {
			RF.debug(e, warn);
		}
		return List.of();
	}
	
	private static <R> Accessor<R> of(Field field, Object object, Class<R> returns, boolean warn) {
		return new Accessor<>() {
			@Override
			public R get() {
				return objected(object);
			}
			@SuppressWarnings("unchecked")
			@Override
			public R objected(Object object) {
				try {
					return (R) field.get(object);
				} catch (Exception e) {
					RF.debug(e, warn);
				}
				return null;
			}
			@Override
			public void set(R r) {
				try {
					field.set(object, r);
				} catch (Exception e) {
					RF.debug(e, warn);
				}
			}
			@Override
			public String name() {
				return field.getName();
			}
			@Override
			public Class<?> type() {
				return returns == null
						? field.getType()
						: returns;
			}
		};
	}

	private static Field field(Class<?> clazz, String name, boolean warn) {
		Field f = field0(clazz, name);
		if(f != null) return f;
		RF.debug(new NoSuchFieldException("No such field with name: " + name), warn);
		return null;
	}
	
	private static Field field0(Class<?> clazz, String name) {
		if(clazz.equals(Object.class)
				|| clazz.getName().equals("java.lang.Object"))
			return null;
		try {
			return clazz.getDeclaredField(name);
		} catch (Exception e) {}
		try {
			return clazz.getField(name);
		} catch (Exception e) {}
		return field0(clazz.getSuperclass(), name);
	}
	
	private static Set<Field> fields(Class<?> c) {
		Set<Field> set = new HashSet<>();
		fields0(set, c);
		return set;
	}
	
	private static void fields0(Set<Field> set, Class<?> c) {
		if(c.equals(Object.class)
				|| c.getName().equals("java.lang.Object"))
			return;
		Stream.of(c.getFields()).forEach(set::add);
		Stream.of(c.getDeclaredFields()).forEach(set::add);
		fields0(set, c.getSuperclass());
	}

}
