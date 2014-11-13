/**
 * 
 * @author Matthew
 * scholarship class, members of this class are modified by @Administrator, and compared with @Student
 */
public class Scholarship extends Person {
	private int maxNumAccepts; //maximum number of recipients for this scholarship
	private int currentAccepts;//current number of recipients, cannot be greater than maxNumAccepts
	private int amount;		   //Award amount of scholarship
	
	public Scholarship(String name, String major, float grade, int hours, int amount, int max) {
		this.name = name;   //scholarship name
		this.major = major; //required major for @name
		gpa = grade;		//required gpa for @name	
		creditHours = hours;//required credit hours for @name
		maxNumAccepts = max;
		this.amount = amount;
		currentAccepts = 0;
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
	public void save() {
		
	}
}
