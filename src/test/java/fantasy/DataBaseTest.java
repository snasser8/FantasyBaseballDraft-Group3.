package fantasy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DataBaseTest {
	private Database data;
	@Before
	public void setUp() {
		this.data= new Database();
		
	}
	@Test 
	public void initializeDB() {
		
		this.data.initialize();
		
		assertEquals(true,data.isInitialized());
		
	}

}
