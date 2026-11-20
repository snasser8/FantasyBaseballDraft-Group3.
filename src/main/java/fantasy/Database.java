package fantasy;

public class Database {
	
	private  boolean initialized;
	
	public Database() {
		
		this.initialized=false;
		
	}
	public boolean initialize() {
		
		this.initialized =true;
		return true;
	}
	public boolean isInitialized() {
		return initialized;
	}
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	

}
