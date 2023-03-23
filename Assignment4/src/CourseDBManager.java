/*
 * Class: CMSC204 
 * Instructor: David Kuijt
 * Description: Database with hashing
 * Due: 03/25/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class CourseDBManager implements CourseDBManagerInterface {
	
	private CourseDBStructure cdbs;
	
	CourseDBManager() {
		cdbs = new CourseDBStructure();
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		cdbs.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return cdbs.get(crn);
		} catch (IOException e) {
			return null;
		}	
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
			
		Scanner in = new Scanner(input);
		while(in.hasNextLine()) {
			String[] temp = in.nextLine().split("\\s");
			String tempInstructor = "";
			for(int i = 4; i < temp.length; i ++)
				tempInstructor += temp[i] + " ";
			add(temp[0], Integer.valueOf(temp[1]), Integer.valueOf(temp[2]), temp[3], tempInstructor.substring(0, tempInstructor.length() - 1));			
		}
		in.close();
	
	}

	@Override
	public ArrayList<String> showAll() {
		return cdbs.showAll();
	}

}
