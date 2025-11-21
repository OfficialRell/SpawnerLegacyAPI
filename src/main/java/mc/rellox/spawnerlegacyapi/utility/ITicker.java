package mc.rellox.spawnerlegacyapi.utility;

public interface ITicker {
	
	static ITicker of(int value) {
		return of(value, false);
	}
	
	static ITicker of(int value, boolean offset) {
		return new Ticker(value, offset);
	}
	
	/**
	 * Ticks this ticker
	 */
	
	void tick();
	
	/**
	 * @return Is tick value {@code 0}
	 */
	
	boolean valid();
	
	class Ticker implements ITicker {
		
		private final int value;
		private int ticks = 1;
		
		public Ticker(int value, boolean offset) {
			this.value = value;
			if(offset) ticks = Calculate.random(value);
		}

		@Override
		public void tick() {
			if(--ticks < 0) ticks = value - 1;
		}

		@Override
		public boolean valid() {
			return ticks == 0;
		}
		
	}

}
