
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager which is implemented from the
 * CourseDBManagerInterface
 * 
 */
public class StudentCourseDBStructureTest {
	CourseDBStructure cds, testStructure;

	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(21);
		testStructure = new CourseDBStructure("Student Testing", 69);
	}

	@After
	public void tearDown() throws Exception {
		cds = testStructure = null;
	}

	/**
	 * Test the tableSize for CourseDBStructures constructed with both constructors
	 */
	@Test
	public void testGetTableSize() {
		assertEquals(19, cds.getTableSize());
		assertEquals(69, testStructure.getTableSize());
	}

	@Test
	public void testHashTable() {

		//Create a course 
		CourseDBElement cde1 = new CourseDBElement("CMSC123", 42069, 3, "SC420", "Somebody In Particular");
		cds.add(cde1);  //add to data structure
		cds.add(cde1);  // add it again. add method  should  ignore it
		cds.add(cde1);  // add it again. add method  should  ignore it
		cds.add(cde1);  // add it again. add method  should  ignore it
		cds.add(cde1);  // add it again. add method  should  ignore it
		cds.add(cde1);  // add it again. add method  should  ignore it
		
		ArrayList<String> courseList = cds.showAll();
		assertTrue(courseList.size()==1);  
		
		//Create another course
		CourseDBElement cde2 = new CourseDBElement("CMSC200", 2341, 1, "SC111", "Nobody In Particular");
		//Create another course
		CourseDBElement cde3 = new CourseDBElement("CMSC300", 1234, 2, "SC112", "Nobody In Particular");
		//Create another course
		CourseDBElement cde4 = new CourseDBElement("CMSC400", 3456, 3, "SC113", "Nobody In Particular");
		//Create another course
		CourseDBElement cde5 = new CourseDBElement("CMSC500", 6789, 4, "SC114", "Nobody In Particular");
	 
 		try {
			assertEquals(42069, cds.get(cde1.getCRN()).getCRN());  
			cds.get(cde2.getCRN()).getCRN(); // should throw exception
		} catch (IOException e) {

			assertTrue("threw Exception successfuly for the course not found", true);
		}
		
 		cds.add(cde2);
 		cds.add(cde3);
 		cds.add(cde4);
 		cds.add(cde5);

 		courseList = cds.showAll(); 
		assertTrue(courseList.size()==5);  
		
		try {
			assertEquals(2341, cds.get(cde2.getCRN()).getCRN());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		CourseDBElement cde1Update = new CourseDBElement("CMSC123-updated", 42069, 4, "SC700", "updated");
		cds.add(cde1Update);  //Same CRN updated information
 		courseList = cds.showAll();  		
		assertTrue(courseList.size()==5);  
		
		try {
			assertEquals(42069, cds.get(cde1Update.getCRN()).getCRN());
			assertEquals("CMSC123-updated", cds.get(cde1Update.getCRN()).getID());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		
		testStructure.add(cde1); 
		courseList = testStructure.showAll(); 
		assertTrue(courseList.size()==1); 
	}
}
