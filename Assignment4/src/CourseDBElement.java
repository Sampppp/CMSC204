
public class CourseDBElement implements Comparable<CourseDBElement>{

	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor;
	
	//constructor
	public CourseDBElement(String a, int b, int c, String d, String e) {
		id = a;
		crn = b;
		credits = c;
		roomNum = d;
		instructor = e;
	}
	
	//getters
	public String getID() {
		return id;
	}
	public int getCRN() {
		return crn;
	}
	public int getCredits() {
		return credits;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public String getInstructor() {
		return instructor;
	}
	
	
	
	
	@Override
	public int compareTo(CourseDBElement o) {
		if(o.id != id || o.crn != crn || o.credits != credits || o.roomNum != roomNum || o.instructor != instructor)
			return 0;
		return 1;
	}
}
