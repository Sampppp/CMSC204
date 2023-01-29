package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTest {
	private Gradebook test1, test2;
	
	@BeforeEach
	void setUp() throws Exception {
		test1 = new Gradebook(5);
		test1.addScore(0);
		test1.addScore(1);
		
		test2 = new Gradebook(5);
		test2.addScore(0);
		test2.addScore(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
		test2 = null;
	}

	@Test
	void testGradebook() {
	}

	@Test
	void testAddScore() {
		assertTrue(test1.toString().equals("0.0 1.0 "));		
		assertEquals(2, test1.getScoresSize());
		
		assertTrue(test2.toString().equals("0.0 1.0 "));		
		assertEquals(2, test2.getScoresSize());
	}

	@Test
	void testSum() {
		assertEquals(1.0, test1.sum(), .001);
		
		assertEquals(1.0, test2.sum(), .001);
	}

	@Test
	void testMinimum() {
		assertEquals(0.0, test1.minimum(), .001);
		
		assertEquals(0.0, test2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(1.0, test1.finalScore(), .001);
		
		assertEquals(1.0, test2.finalScore(), .001);
	}

}
