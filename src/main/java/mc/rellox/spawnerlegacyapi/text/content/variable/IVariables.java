package mc.rellox.spawnerlegacyapi.text.content.variable;

import mc.rellox.spawnerlegacyapi.price.IPrice;
import mc.rellox.spawnerlegacyapi.spawner.type.SpawnerType;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

public interface IVariables {
	
	static final IVariables empty = () -> null;
	
	static IVariables with(String k, Object o) {
		var objects = new Object[] {k, o};
		return () -> objects;
	}
	
	static IVariables with(Object... vs) {
		if(vs == null || vs.length == 0) return empty;
		if(vs.length % 2 != 0)
			throw new IllegalArgumentException("Variables length must be even.");
		return () -> vs;
	}
	
	Object[] variables();
	
	default String get(IVariable variable) {
		if(variable == null) return null;
		return get(variable.key());
	}
	
	default String get(String key) {
		Object[] vars = variables();
		if(vars == null) return null;
		int m = vars.length, i = 0;
		if(m == 2) return key.equals(vars[0]) ? convert(vars[1]) : null;
		do {
			if(key.equals(vars[i])) return convert(vars[i + 1]);
		} while((i += 2) < m);
		return null;
	}
	
	default IVariables combine(IVariables other) {
		if(other == null || other.variables() == null) return this;
		if(this.variables() == null) return other;
		Object[] a = this.variables(), b = other.variables();
		Object[] combined = new Object[a.length + b.length];
		System.arraycopy(a, 0, combined, 0, a.length);
		System.arraycopy(b, 0, combined, a.length, b.length);
		return () -> combined;
	}
	
	private static String convert(Object object) {
		return switch(object) {
			case String string -> string;
			case IContent content -> content.text();
			case SpawnerType type -> type.formatted().text();
			case IPrice price -> price.text().text();
			case Enum<?> enum_ -> enum_.name();
			default -> object.toString();
		};
	}

}
