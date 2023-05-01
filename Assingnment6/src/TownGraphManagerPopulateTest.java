import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManagerPopulateTest {
	private TownGraphManager graph;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  File a = new File("src/3689889.txt");
		  System.out.println(a.canRead());
		  graph.populateTownGraph(a); 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetRoad() {
		assertEquals("I-94", graph.getRoad("Chicago", "Detroit"));
	}
}
