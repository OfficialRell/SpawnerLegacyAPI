package mc.rellox.spawnerlegacyapi.modifier.effect;

public enum EvaluateType {
	
	ADD {
		@Override
		public double calculate(double value, double change) {
			return +change;
		}
	},
	SUBTRACT {
		@Override
		public double calculate(double value, double change) {
			return -change;
		}
	},
	MULTIPLY {
		@Override
		public double calculate(double value, double change) {
			return value * (change - 1);
		}
	},
	DEVIDE {
		@Override
		public double calculate(double value, double change) {
			return value / change - value;
		}
	},
	ADD_PERCENT {
		@Override
		public double calculate(double value, double change) {
			return value * (change * 0.01);
		}
	},
	SUBTRACT_PERCENT {
		@Override
		public double calculate(double value, double change) {
			return -value * (change * 0.01);
		}
	};
	
	/**
	 * Returns the calculated change value.<br>
	 * This value is not added to the base value.
	 * 
	 * @param value - base value
	 * @param change - change value
	 * @return The calculated change value
	 */
	
	public abstract double calculate(double value, double change);
	

}
