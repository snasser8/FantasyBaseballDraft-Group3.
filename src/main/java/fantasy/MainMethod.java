package fantasy;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MainMethod {

	public static void main(String[] args) {
		
		
		Database data = new Database();
		File batterFile = new File("mlb_al_batter_stats_2023.txt");
		File pitcherFile = new File("mlb_al_pitching_stats_2023.txt");
		data.addtoPlayerStatsDBFile(batterFile);
		data.addtoPlayerStatsDBFile(pitcherFile);
		data.populateDB();
		
		
		
		
		
		HashMap<String ,ArrayList<Player>> player = data.getDatabase();
		
		Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter a command: ");
		//String stat =  scanner.nextLine();
		//String[]line = stat.split(" ");
		
		//line[1].trim().toUpperCase();
	
		Overall("",data,"RK");
	
		
	}
	public static void Overall(String playerPosition,Database data , String evalType ) {
		HashMap<String ,ArrayList<Player>> player = data.getDatabase();
		evalType.toUpperCase();
		
		boolean rank = (evalType=="RK")?true:false;
		
		
		
		if(!data.hasBatterStat(evalType)) {
			
		return;
		}
		
		
		if (playerPosition.trim().equals("")) {
		    ArrayList<Player> all = new ArrayList<>();
		    for (ArrayList<Player> list : player.values()) {
		        all.addAll(list);
		    }
		    
		   if(!rank) {
		    all.sort(Comparator.comparingDouble((Player p) -> p.getStat(evalType)).reversed());
		    
		   }else {
			   all.sort(Comparator.comparingDouble((Player p) -> p.getStat(evalType)));
			   
		   }
		    
		   
		    
		    int top50=0;
		    for(Player p : all) {
		    	if(p.isPitcher()||p.isDrafted()) {
		    		
		    		continue;
		    	}
		    	if(top50==50) {
		    		break;
		    	}
	        	 
	        	System.out.printf("%-10s %10s  %10s %10.2f\n",p.getName(),p.getTeam(),p.getPosition(),p.getStat(evalType));
	        	
	        	
	        	top50++;
	         }
		    
		    return;
		    
		}
		
	         ArrayList<Player> PositionArray= player.get(playerPosition);
	         
	         if(PositionArray==null) {
	        	System.out.println("Not a valid position");
	        	 return;
	         }
	         
	         
	         if(!rank) {
	         PositionArray.sort(Comparator.comparingDouble((Player p) -> p.getStat(evalType)).reversed());
	         }else {
	        	 PositionArray.sort(Comparator.comparingDouble((Player p) -> p.getStat(evalType)));
	        	 
	         }

	         
	         //overall with position in mine and we need to know the evaluation type 
	         //right now we will use unnormalized name but I will fix this latter 
	         
	         int top50=0;
	         for(Player p : PositionArray) {
	        	 
	        	 if(top50==50) {
	        		 
	        		 break;
	        	 }
	        	 
	        	System.out.printf("%-10s    %s     %s    %f\n",p.getName(),p.getTeam(),p.getPosition(),p.getStat(evalType));
	        	
	        	
	        	top50++;
	         }
		
	}
	
}
	







