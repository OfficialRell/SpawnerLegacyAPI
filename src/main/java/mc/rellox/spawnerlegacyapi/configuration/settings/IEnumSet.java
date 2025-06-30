package mc.rellox.spawnerlegacyapi.configuration.settings;

public interface IEnumSet<T extends Enum<T>> extends ILoad {
	
	boolean has(T t);

}
