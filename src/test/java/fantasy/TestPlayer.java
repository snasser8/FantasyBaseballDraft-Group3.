package fantasy;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;


//This tests will be testing to make sure that we are testing for the players position . If we get a position  that is not a pitcher it will display that the 
//isPitcher field will be false 
public class TestPlayer {
	private Player player;
	
	
	@Before
	public void setup() {
		this.player=new Player("P","Placeholder Player");
		
	}
	@Test
	public void validPosition() {
		
		assertEquals(true, player.vaildPosition());
		
	}
	@Test
	public void isPitcher() {
		
		assertEquals(true,player.isPitcher());
	}
	@Test
	public void searchByName() {
		
		assertEquals("Placeholder Player",player.getName());
	}

}
