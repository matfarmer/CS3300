/**
 * 
 * @author Matthew
 * class derived from person to allow an administrator to set up a new scholarship, and edit the fields
 */

public class Administrator extends Person {
	public Administrator(String name, int id, String major, float grade, int hours) {
		this.name = name;   //scholarship name
		idNumber = id;      // 
		this.major = major; //required major for @name
		gpa = grade;		//required gpa for @name	
		creditHours = hours;//requred credit hours for @name
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
