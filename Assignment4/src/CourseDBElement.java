
public class CourseDBElement implements Comparable<CourseDBElement>{

	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor;
	
	//constructors
	CourseDBElement(String a, int b, int c, String d, String e) {
		id = a;
		crn = b;
		credits = c;
		roomNum = d;
		instructor = e;
	}
	
	CourseDBElement(){
		id = null;
		crn = 0;
		credits = 0;
		roomNum = null;
		instructor = null;
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
	//setters
	public void setID(String a) {
		id = a;
	}
	public void setCRN(int a) {
		crn = a;
	}
	public void setCredits(int a) {
		credits = a;
	}
	public void setRoomNum(String a) {
		roomNum = a;
	}
	public void setInstructor(String a) {
		instructor = a;
	}
	
	
	
	
	@Override
	public int compareTo(CourseDBElement o) {
		if(o.id != id || o.crn != crn || o.credits != credits || o.roomNum != roomNum || o.instructor != instructor)
			return 1;//not the same
		return 0;//the same
	}
}
