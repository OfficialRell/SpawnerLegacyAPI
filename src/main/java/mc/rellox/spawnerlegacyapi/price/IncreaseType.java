package mc.rellox.spawnerlegacyapi.price;

public enum IncreaseType {

	ADDITION() {
		@Override
		public String format(IPrice c) {
			return c.text().text();
		}
		@Override
		public double price(double c, double i) {
			return c + i;
		}
	},
	MULTIPLICATION() {
		@Override
		public String format(IPrice c) {
			return c.value() + "%";
		}
		@Override
		public double price(double c, double i) {
			return c * i;
		}
	};
	
	@Override
	public String toString() {
		return name();
	}
	
	public abstract String format(IPrice c);
	
	public abstract double price(double c, double i);
	
	public static IncreaseType of(String name) {
		try {
			return valueOf(name.toUpperCase());
		} catch (Exception e) {}
		return IncreaseType.ADDITION;
	}

}
