package fantasy;

import java.util.Set;

public class Player {
	private String position;
	private boolean pitcher;
	private String name;
	private  static Set<String> validPositionSet = Set.of("P", "C", "1B", "2B", "3B", "SS", "LF", "CF", "RF");
	Player(String position,String name ){
		this.name = name;
		this.position = position;
		if(this.position.equals("P")) {
			this.pitcher=true;
		}else {
			this.pitcher=false;
		}
		
		
	}
	
	public String getPosition() {
		return position;
	}
	public  boolean vaildPosition() {
		
		return validPositionSet.contains(position);
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public boolean isPitcher() {
		return pitcher;
	}
	public void setPitcher(boolean pitcher) {
		this.pitcher = pitcher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	


}
