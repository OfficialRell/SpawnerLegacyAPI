package mc.rellox.spawnerlegacyapi.configuration.settings;


public enum ChangerType {

	NONE {
		@Override
		public double change(double value, double other) {
			return value;
		}
		@Override
		public char operator() {
			return '?';
		}
	},
	ADD {
		@Override
		public double change(double value, double other) {
			return value + other;
		}
		@Override
		public char operator() {
			return '+';
		}
	},
	SUBTRACT {
		@Override
		public double change(double value, double other) {
			return value - other;
		}
		@Override
		public char operator() {
			return '-';
		}
	},
	MULTIPLY {
		@Override
		public double change(double value, double other) {
			return value * other;
		}
		@Override
		public char operator() {
			return '*';
		}
	},
	DIVIDE {
		@Override
		public double change(double value, double other) {
			return value / other;
		}
		@Override
		public char operator() {
			return '/';
		}
	};
	
	public abstract char operator();

	public abstract double change(double value, double other);

	public static ChangerType of(char c) {
		return switch (c) {
		case '+' -> ADD;
		case '-' -> SUBTRACT;
		case '*' -> MULTIPLY;
		case '/' -> DIVIDE;
		default -> NONE;
		};
	}

}
