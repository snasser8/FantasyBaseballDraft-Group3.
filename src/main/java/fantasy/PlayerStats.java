package fantasy;

public interface PlayerStats {
	
	void setStat(int column , Object j);
	
	String getName();
	String getPosition();
	 String getTeam();
	 double getStat(String statName) throws IllegalArgumentException;
	 
	 //for getting rank 
	 int  getRk();

}
