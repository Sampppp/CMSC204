

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class StudentCourseDBManagerTest {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC999",12345,9,"SC132","Big Guy");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC999",12345,9,"SC132","Big Guy");
		dataMgr.add("CMSC420",42000,4,"SC420","Mary Whanna");
		dataMgr.add("CMSC222",22222,2,"SC222","Twototoo");
		dataMgr.add("1",1,1,"1","1");
		dataMgr.add("2",2,2,"2","2");
		dataMgr.add("3",3,3,"3","3");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(2),"Course:CMSC999 CRN:12345 Credits:9 Instructor:Big Guy Room:SC132");
		assertEquals(list.get(5),"Course:CMSC420 CRN:42000 Credits:4 Instructor:Mary Whanna Room:SC420");
		assertEquals(list.get(3),"Course:CMSC222 CRN:22222 Credits:2 Instructor:Twototoo Room:SC222");
		assertEquals(list.get(0),"Course:1 CRN:1 Credits:1 Instructor:1 Room:1");
		assertEquals(list.get(1),"Course:2 CRN:2 Credits:2 Instructor:2 Room:2");
		assertEquals(list.get(4),"Course:3 CRN:3 Credits:3 Instructor:3 Room:3");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test69.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC233 12345 4 SC444 Joe Mammah");
			inFile.print("CMSC244 54321 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC233",dataMgr.get(12345).getID());
			assertEquals("CMSC244",dataMgr.get(54321).getID());
			assertEquals("SC450",dataMgr.get(54321).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
