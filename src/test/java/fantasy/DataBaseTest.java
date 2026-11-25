package fantasy;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataBaseTest {
	private Database data;
	private File fileforBatters;
	private File fileforPitchers;
	private Set<Integer>vaildValues= Set.of(30,35);
	
	//Batters have 30 slots so when I test I will be testing to make sure batters have 31 
	//when all the parsing is done and that pitchers has 35 slots 
	@Before
	public void setUp() {
		this.data= new Database();
		fileforBatters= new File("mlb_al_batter_stats_2023.txt");
		fileforPitchers= new File("mlb_al_pitching_stats_2023.txt");
		
	}
	
	@Test
	public void addtoDB() {
		
		System.out.println("Batters");
		assertEquals(true,this.data.addtoPlayerStatsDBFile(fileforBatters));
		
		System.out.println("Pitchers");
		assertEquals(true,this.data.addtoPlayerStatsDBFile(fileforPitchers));
		
		ArrayList<ArrayList<String>> playerStats =data.getPlayersStats();
		for (ArrayList<String> row : playerStats) {
		    System.out.println(row.size());
		    assertEquals(true,vaildValues.contains(row.size()));
		}
		
		
	}
	
	@After
	public  void populateDB() {
		
		
		 assertEquals(true,data.populateDB());
		
		
	}
	
	
	
	
	public void initializeDB() {
		
		
		this.data.initialize(fileforBatters);
		
		assertEquals(true,data.isInitialized());
		
	}

}
