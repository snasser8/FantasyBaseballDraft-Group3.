package fantasy;

import java.text.Normalizer;
import java.util.Set;

public class Player {
	private String position;
	private boolean pitcher;
	private boolean drafted;
	private String name;
	private int rank;
	
	private PlayerStats playerstats;
	
	private  static Set<String> validPositionSet = Set.of("P", "C", "1B", "2B", "3B", "SS", "LF", "CF", "RF");
	private String team;
	private String normLast;
	private char firstInitial;
	
	
	//I used a interface that both a batter type and hitter type both implement because we don't know know the type of stats a player will have until runtime 
	Player( PlayerStats playerStats){
		
		if(playerStats.getPosition().equals("P")) {
			this.pitcher=true;
			playerstats =  playerStats;
			
			this.name = normalize(playerStats.getName());
			this.position= playerStats.getPosition();
			
			drafted= false;
			
			this.team = playerStats.getTeam();
			this.rank= playerStats.getRk();
			
			
			
			
		}else {
			this.pitcher=false;
			playerstats= playerStats;
			this.name = playerStats.getName();
			this.position= playerStats.getPosition();
			
			drafted= false;
			
			this.team = playerStats.getTeam();
			this.rank= playerStats.getRk();
		}
		
	}
	
	public static String normalize(String s) {
	    if (s == null) return "";
	    return Normalizer.normalize(s, Normalizer.Form.NFD)
	            .replaceAll("\\p{M}", "")           // accents: é -> e
	            .replace('-', ' ')                  // hyphens become spaces
	            .replaceAll("[^\\p{L}\\p{N} ]", "") // delete everything else: * # . " ' curly quotes, commas, etc.
	            .toLowerCase()
	            .trim()
	            .replaceAll("\\s+", " ");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//this is the stat that we will use for the eval function and it will return what the player object is because batter and picther share a common interface 
	public double getStat(String s) {
		
		
		
		return playerstats.getStat(s);
		
	}
	
	
	
	
	public boolean isDrafted() {
		return drafted;
	}




	public void setDrafted(boolean drafted) {
		this.drafted = drafted;
	}




	public String getTeam() {
		return team;
	}




	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public PlayerStats getPlayerstats() {
		return playerstats;
	}

	public void setPlayerstats(PlayerStats playerstats) {
		this.playerstats = playerstats;
	}

	public static Set<String> getValidPositionSet() {
		return validPositionSet;
	}

	public static void setValidPositionSet(Set<String> validPositionSet) {
		Player.validPositionSet = validPositionSet;
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


	@Override
	public String toString() {
		return "Player [position=" + position + ", pitcher=" + pitcher + ", name=" + name + ", playerstats="
				+ playerstats + "]";
	}
	
	
	


}
