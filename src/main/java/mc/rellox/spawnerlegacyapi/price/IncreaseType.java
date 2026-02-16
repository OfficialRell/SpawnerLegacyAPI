package mc.rellox.spawnerlegacyapi.price;

public enum IncreaseType {

	ADDITION() {
		@Override
		public String format(IPrice price) {
			return price.text().text();
		}
		@Override
		public double price(double value, double increase) {
			return value + increase;
		}
	},
	MULTIPLICATION() {
		@Override
		public String format(IPrice price) {
			return price.value() + "%";
		}
		@Override
		public double price(double value, double increase) {
			return value * increase;
		}
	};
	
	@Override
	public String toString() {
		return name();
	}
	
	public abstract String format(IPrice price);
	
	public abstract double price(double value, double increase);
	
	public static IncreaseType of(String name) {
		try {
			return valueOf(name.toUpperCase());
		} catch (Exception e) {}
		return IncreaseType.ADDITION;
	}

}
