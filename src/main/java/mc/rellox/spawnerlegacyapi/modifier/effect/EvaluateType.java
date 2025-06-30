package mc.rellox.spawnerlegacyapi.modifier.effect;

public enum EvaluateType {
	
	ADD {
		@Override
		public double calculate(double value, double change) {
			return value + change;
		}
	},
	SUBTRACT {
		@Override
		public double calculate(double value, double change) {
			return value - change;
		}
	},
	MULTIPLY {
		@Override
		public double calculate(double value, double change) {
			return value * change;
		}
	},
	DEVIDE {
		@Override
		public double calculate(double value, double change) {
			return value / change;
		}
	},
	ADD_PERCENT {
		@Override
		public double calculate(double value, double change) {
			return value * (1 + change * 0.01);
		}
	},
	SUBTRACT_PERCENT {
		@Override
		public double calculate(double value, double change) {
			return value * (1 - change * 0.01);
		}
	};
	
	public abstract double calculate(double value, double change);
	

}
