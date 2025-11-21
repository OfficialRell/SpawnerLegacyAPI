package mc.rellox.spawnerlegacyapi.spawner.requirement;

public class ErrorCounter {
	
	public final int total;
	
	public boolean found;
	private int light0, light1, ground0, environment0;
	// light = blocks that hide light
	// lighed = blocks that need light
	private final ErrorSubmit submit;
	
	public ErrorCounter(int total) {
		this.total = light0 = ground0 = environment0 = total;
		this.submit = new ErrorSubmit();
	}
	
	public ErrorSubmit submit() {
		submit.light = submit.ground
				= submit.environment
				= submit.lighted = true;
		return submit;
	}
	
	public int light() {
		return light0;
	}
	
	public int lighted() {
		return light1;
	}
	
	public int ground() {
		return ground0;
	}
	
	public int environment() {
		return environment0;
	}
	
	public boolean valid() {
		return found;
	}

	@Override
	public String toString() {
		return "ErrorCounter[total:" + total
				+ ", light:" + light()
				+ ", lighted:" + light1
				+ ", ground: " + ground()
				+ ", environment: " + environment()
				+ ", found: " + found
				+ "]";
	}
	
	public class ErrorSubmit {
		
		private boolean light, lighted, ground, environment;
		
		public void submit() {
			if(!light) light0--;
			if(!lighted) light1++;
			if(!ground) ground0--;
			if(!environment) environment0--;
		}
		
		public boolean valid() {
			return light && lighted && ground && environment;
		}
		
		public void light() {
			light = false;
		}
		
		public void lighted() {
			lighted = false;
		}
		
		public void ground() {
			ground = false;
		}
		
		public void environment() {
			environment = false;
		}
		
	}
	
}
