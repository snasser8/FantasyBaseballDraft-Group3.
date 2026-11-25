package fantasy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Database {
	
	private  boolean initialized;
	private HashMap<String, ArrayList<Player>>database= new HashMap<>();
	private HashMap<Integer,String>batterStatsPosition;
	private HashMap<Integer,String>pitcherStatsPosition;
	private ArrayList<String>playersCSV= new ArrayList<>();
	private ArrayList<Player> pitchers = new ArrayList<>();       // 1 = P (Pitcher)
	private ArrayList<Player> catchers = new ArrayList<>();       // 2 = C (Catcher)
	private ArrayList<Player> firstBasemen = new ArrayList<>();   // 3 = 1B (First Base)
	private ArrayList<Player> secondBasemen = new ArrayList<>();  // 4 = 2B (Second Base)
	private ArrayList<Player> thirdBasemen = new ArrayList<>();   // 5 = 3B (Third Base)
	private ArrayList<Player> shortstops = new ArrayList<>();     // 6 = SS (Shortstop)
	private ArrayList<Player> leftFielders = new ArrayList<>();   // 7 = LF (Left Field)
	private ArrayList<Player> centerFielders = new ArrayList<>(); // 8 = CF (Center Field)
	private ArrayList<Player> rightFielders = new ArrayList<>();  // 9 = RF (Right Field)
	private ArrayList<Player>Batters= new ArrayList<>();
	private String Battervaluation;
	private String Pitchervaluation;
	private static final Set<String> BATTER_STATS = Set.of(
		    "RK","AGE","G","PA","AB","R","H","2B","3B","HR","RBI","SB","CS","BB","SO",
		    "BA","AVG","OBP","SLG","OPS","OPS+","TB","GDP","HBP","SH","SF","IBB");

		private static final Set<String> PITCHER_STATS = Set.of(
		    "RK","AGE","W","L","W-L%","ERA","G","GS","GF","CG","SHO","SV","IP","H","R","ER",
		    "HR","BB","IBB","SO","HBP","BK","WP","BF","ERA+","FIP","WHIP","H9","HR9","BB9","SO9","SO/W");
	//Later will need a  array for every team you would need to remove the player 
	
	
	
	//basically this is a 2d array of where each index corresponds to a list of the player stats 
	//Ex .
	
	//index 0 -      [Rk= , name= ] etc ;
		
		
		
		
		

	public Database() {
		
		this.initialized=false;
		Battervaluation="BA";
		Pitchervaluation= "IP";
		    database.put("P", pitchers);
		    database.put("C", catchers);
		    database.put("1B", firstBasemen);
		    database.put("2B", secondBasemen);
		    database.put("3B", thirdBasemen);
		    database.put("SS", shortstops);
		    database.put("LF", leftFielders);
		    database.put("CF", centerFielders);
		    database.put("RF", rightFielders);
	}
	
	
	
	
	
	
	
	
	public static Set<String> getBatterStats() {
		return BATTER_STATS;
	}
	public boolean hasBatterStat(String stat) {
		
		return BATTER_STATS.contains(stat);
	}
public boolean hasPitcherStat(String stat) {
		
		return PITCHER_STATS.contains(stat);
	}

	public static Set<String> getPitcherStats() {
		return PITCHER_STATS;
	}

	public void setDatabase(HashMap<String, ArrayList<Player>> database) {
		this.database = database;
	}





	public void setBatterStatsPosition(HashMap<Integer, String> batterStatsPosition) {
		this.batterStatsPosition = batterStatsPosition;
	}





	public void setPitcherStatsPosition(HashMap<Integer, String> pitcherStatsPosition) {
		this.pitcherStatsPosition = pitcherStatsPosition;
	}





	public void setPitchers(ArrayList<Player> pitchers) {
		this.pitchers = pitchers;
	}





	public void setCatchers(ArrayList<Player> catchers) {
		this.catchers = catchers;
	}





	public void setFirstBasemen(ArrayList<Player> firstBasemen) {
		this.firstBasemen = firstBasemen;
	}





	public void setSecondBasemen(ArrayList<Player> secondBasemen) {
		this.secondBasemen = secondBasemen;
	}





	public void setThirdBasemen(ArrayList<Player> thirdBasemen) {
		this.thirdBasemen = thirdBasemen;
	}





	public void setShortstops(ArrayList<Player> shortstops) {
		this.shortstops = shortstops;
	}





	public void setLeftFielders(ArrayList<Player> leftFielders) {
		this.leftFielders = leftFielders;
	}





	public void setCenterFielders(ArrayList<Player> centerFielders) {
		this.centerFielders = centerFielders;
	}





	public void setRightFielders(ArrayList<Player> rightFielders) {
		this.rightFielders = rightFielders;
	}





	public void setPlayersStats(ArrayList<ArrayList<String>> playersStats) {
		this.playersStats = playersStats;
	}

	private ArrayList<ArrayList<String>> playersStats= new  ArrayList<>();
	
	
	public String getBattervaluation() {
		return Battervaluation;
	}





	public ArrayList<Player> getBatters() {
		return Batters;
	}





	public void setBatters(ArrayList<Player> batters) {
		Batters = batters;
	}





	public void setBattervaluation(String battervaluation) {
		Battervaluation = battervaluation;
	}





	public String getPitchervaluation() {
		return Pitchervaluation;
	}





	public void setPitchervaluation(String pitchervaluation) {
		Pitchervaluation = pitchervaluation;
	}





	
	public  void overall() {
		
		
		
		
	}
	public HashMap<String, ArrayList<Player>> getDatabase() {
		return database;
	}





	public HashMap<Integer, String> getBatterStatsPosition() {
		return batterStatsPosition;
	}





	public HashMap<Integer, String> getPitcherStatsPosition() {
		return pitcherStatsPosition;
	}





	public ArrayList<String> getPlayersCSV() {
		return playersCSV;
	}





	public ArrayList<Player> getPitchers() {
		return pitchers;
	}





	public ArrayList<Player> getCatchers() {
		return catchers;
	}





	public ArrayList<Player> getFirstBasemen() {
		return firstBasemen;
	}





	public ArrayList<Player> getSecondBasemen() {
		return secondBasemen;
	}





	public ArrayList<Player> getThirdBasemen() {
		return thirdBasemen;
	}





	public ArrayList<Player> getShortstops() {
		return shortstops;
	}





	public ArrayList<Player> getLeftFielders() {
		return leftFielders;
	}





	public ArrayList<Player> getCenterFielders() {
		return centerFielders;
	}





	public ArrayList<Player> getRightFielders() {
		return rightFielders;
	}





	public void overall(String s) {
		
		
		
	}
	
	
	
	public static boolean isInteger(String s) {
	    if (s == null || s.isBlank()) return false;
	    try {
	        Integer.parseInt(s.trim());
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public static boolean isFiniteDouble(String s) {
	    if (s == null || s.isBlank()) return false;
	    try {
	        double val = Double.parseDouble(s.trim());
	        return Double.isFinite(val);
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	
	public void printAllLists() {
		System.out.println("Pitchers (P): " + pitchers.toString());
		System.out.println("Catchers (C): " + catchers.toString());
		System.out.println("First Basemen (1B): " + firstBasemen.toString());
		System.out.println("Second Basemen (2B): " + secondBasemen.toString());
		System.out.println("Third Basemen (3B): " + thirdBasemen.toString());
		System.out.println("Shortstops (SS): " + shortstops.toString());
		System.out.println("Left Fielders (LF): " + leftFielders.toString());
		System.out.println("Center Fielders (CF): " + centerFielders.toString());
		System.out.println("Right Fielders (RF): " + rightFielders.toString());
		
		
		
	}
	
	public void printAllListSizes() {
	    System.out.println("Pitchers (P): " + pitchers.size());
	    System.out.println("Catchers (C): " + catchers.size());
	    System.out.println("First Basemen (1B): " + firstBasemen.size());
	    System.out.println("Second Basemen (2B): " + secondBasemen.size());
	    System.out.println("Third Basemen (3B): " + thirdBasemen.size());
	    System.out.println("Shortstops (SS): " + shortstops.size());
	    System.out.println("Left Fielders (LF): " + leftFielders.size());
	    System.out.println("Center Fielders (CF): " + centerFielders.size());
	    System.out.println("Right Fielders (RF): " + rightFielders.size());
	    System.out.println("Batters (all): " + Batters.size());
	}
	
	
	
	public boolean populateDB() {
		ArrayList<ArrayList<String>> stats=	getPlayersStats();
		
		 System.out.println("rows from getPlayersStats: " + stats.size());
		
		if(stats==null||stats.isEmpty()) {
			
			return false;
		}
		
		for (ArrayList<String> row : stats) {
			
			
			PlayerStats player;
			ColumnSchema[] schema ;
			
			
			
			
			int columnNum=0;
			
			
			
			
			if(row.size()==35) {
			PitcherColumn[] pitcher= PitcherColumn.values();
			     schema = pitcher;
				player= new PitcherStats();
				
			}else if(row.size()==30) {
				
			
				
				player= new BatterStats();
				
				BatterColumn[]batter = BatterColumn.values();
				schema = batter;
				
				
			}else {
				System.out.println("Unexpected List Size");
				break;
			
			}
		    for (String val : row) {
		    	
		    	
		    DataType type =	schema[columnNum].getType();
		    Object currentVal;
		    switch (type) {
		    case STRING:
		      currentVal=   parseValue(val ,type);
		      
		      if(currentVal==null) {
		    	  break;
		      }
		        
		        String value= (String)currentVal ;
		        player.setStat(columnNum, value);
		        break;
		    case INT:
              currentVal=   parseValue(val ,type);
              if(currentVal==null) {
		    	  break;
		      }
		        
		        
		        int  valueInt= (int)currentVal ;
		        player.setStat(columnNum, valueInt);
		        break;
		    case DOUBLE:
		    	 currentVal=   parseValue(val ,type);
		    	 if(currentVal==null) {
			    	  break;
			      }
			        
			        
			        double  valueDouble= (double)currentVal ;
			        player.setStat(columnNum, valueDouble);
		        
		        break;
		};
		    
		 
		    
		    	columnNum++;
		    		
		    	}
		    
		    Player playerObject= new Player(player);
		    
      if (row.size() == 30 && playerObject.getPosition().equals("P")) continue;
		addPlayerByPosition(playerObject.getPosition(), playerObject);
		    
		    	
		    	
		    }
		
		/// printAllLists();
		
		return true;
		}
	
	
	
	/*
	public void addPlayerByPosition(String position, Player player) {
	    switch (position) {
	        case "P"  -> pitchers.add(player);
	        case "C"  -> catchers.add(player);
	        case "1B" -> firstBasemen.add(player);
	        case "2B" -> secondBasemen.add(player);
	        case "3B" -> thirdBasemen.add(player);
	        case "SS" -> shortstops.add(player);
	        case "LF" -> leftFielders.add(player);
	        case "CF" -> centerFielders.add(player);
	        case "RF" -> rightFielders.add(player);
	        default   -> System.out.println("Invalid position: " + position);
	    }
	}
	*/
	
	public void addPlayerByPosition(String position, Player player) {
	    switch (position) {
	        case "P"  -> pitchers.add(player);
	        case "C"  -> {
	            catchers.add(player);
	            Batters.add(player);
	        }
	        case "1B" -> {
	            firstBasemen.add(player);
	            Batters.add(player);
	        }
	        case "2B" -> {
	            secondBasemen.add(player);
	            Batters.add(player);
	        }
	        case "3B" -> {
	            thirdBasemen.add(player);
	            Batters.add(player);
	        }
	        case "SS" -> {
	            shortstops.add(player);
	            Batters.add(player);
	        }
	        case "LF" -> {
	            leftFielders.add(player);
	            Batters.add(player);
	        }
	        case "CF" -> {
	            centerFielders.add(player);
	            Batters.add(player);
	        }
	        case "RF" -> {
	            rightFielders.add(player);
	            Batters.add(player);
	        }
	        case "D"  -> { /* Ignored per assignment spec */ }
	        default   -> System.out.println("Invalid position: " + position);
	    }
	}
	
	
	
	
	
	
	
	
		 
	public static Object parseValue(String rawValue, DataType type) {
	    // Handle empty/missing cells safely before parsing numbers
	
		    // Handle empty/missing cells safely before parsing numbers
		    if (rawValue == null || rawValue.trim().isEmpty()) {
		        return null; 
		    }

		    String cleaned = rawValue.trim();

		    switch (type) {
		        case STRING:
		            return cleaned;

		        case INT:
		           
		        	
		        	if(cleaned.equalsIgnoreCase("NA")) {
		        		
		        		return 0;
		        	}
		            return Integer.parseInt(cleaned);

		        case DOUBLE:
		            
                   if(cleaned.equalsIgnoreCase("NA")) {
		        		
		        		return 0.0;
		        	}
		        	
		        	
		            return Double.parseDouble(cleaned);

		        default:
		            return null;
		    }
		}
		
	
	
	
	
	public ArrayList<ArrayList<String>> getPlayersStats() {
		return playersStats;
	}

	public int getSizeOfCV(ArrayList<String>list) {
		
		
		
		return list.size();
		
	}
	
	
	
	public boolean addtoPlayerStatsDBFile(File file) {
		
           int count =0;
		try(Scanner scanner = new Scanner(file)){
			while(scanner.hasNextLine()) {
				
				String data = scanner.nextLine();
				if(count>0) {
				//System.out.println(data);
					playersCSV.add(data);
				
				}
				
				count++;
			}
			
			
		}catch(FileNotFoundException e) {
			
			
			e.printStackTrace();
			System.out.println("You have a file not found exception");
			return false;
			
			
		}
		/*
		 for(String player: playersCSV) {
			
           System.out.println(player);
			
			
		}
		 
		 
		 */
		
		PlayerCSVtoString();
		return true;
		
		
	}
	
	
	public void setPlayersCSV(ArrayList<String> playersCSV) {
		this.playersCSV = playersCSV;
	}
	





	public boolean initialize(File file) {
		
		
		
		
		this.initialized =true;
		return true;
	}
	private void PlayerCSVtoString() {
		int row=0;
		for(String player: playersCSV) {
			//Every row will have a player and we you run into , you just add to the player
			ArrayList<String>Player= new ArrayList<>();
			char currentChar;
			//Acts as a buffer for every player to add to there array of attributes
			
			//every time we find a , we take the string in the buffer and add it 
			//to are attribute array for the player then clear the buffer for the next index 
			//in the array of attributes for each player
			StringBuilder currentIndex= new StringBuilder();  
			for(int x=0; x<player.length();x++) {
	        	
	        	currentChar= player.charAt(x);
	        	
	        	//the last char is not in the list yet so we have to add the last char 
	        	//to the buffer then add the string to the list of player attributes
	        	if(x==player.length()-1) {
	        		currentIndex.append(currentChar);
	        		Player.add(currentIndex.toString());
	        		currentIndex.setLength(0);
	        		break;
	        	}
	        	
	        	if(currentChar!=',') {
	        		currentIndex.append(currentChar);
	        	}else {
	        		if(currentIndex.toString().trim().isEmpty()) {
	        			
	        			Player.add("NA");
	        			
	        			currentIndex.setLength(0);
	        		}else {
	        		Player.add(currentIndex.toString());
	        		currentIndex.setLength(0);
	        		}
	        	}
	        	 
	          }
			playersStats.add(Player);
			currentIndex.setLength(0);	
				row++;
			}
		
	 
		
		playersCSV.clear();
				
	}
	public int getAttributeSize(ArrayList<String>player) {
		
		return player.size();
	}
	public boolean isInitialized() {
		return initialized;
	}
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	

}
