/**
 * 
 * @author Matthew
 * scholarship class, members of this class are modified by @Administrator, and compared with @Student
 */
public class Scholarship extends Person {
	private int maxNumAccepts; //maximum number of recipients for this scholarship
	private int currentAccepts;//current number of recipients, cannot be greater than maxNumAccepts 
	
	public Scholarship(String name, int id, String major, float grade, int hours, int max, int current) {
		this.name = name;   //scholarship name
		idNumber = id;      // 
		this.major = major; //required major for @name
		gpa = grade;		//required gpa for @name	
		creditHours = hours;//requred credit hours for @name
		maxNumAccepts = max;
		currentAccepts = current;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return idNumber;
	}
	public String getMajor() {
		return major;
	}
	public float getGPA() {
		return gpa;
	}
	public int getHours() {
		return creditHours;
	}

}
