package mc.rellox.spawnerlegacyapi.configuration.settings;

public interface IValueChanger {
	
	default double change(double initial) {
		return type().change(initial, value());
	}
	
	double value();
	
	ChangerType type();

}
