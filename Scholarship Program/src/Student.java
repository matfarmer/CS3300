/**
 * 
 * @author Matthew
 * class derived from person, allows for a student to modify fields to be compared with scholarship class
 * for acceptance of scholarship
 */

public class Student extends Person {
		public Student(String name, int id, String major, float grade, int hours) {
			this.name = name;   //student's name
			idNumber = id;		//student ID number (needed and used for search)
			this.major = major; //student's major
			gpa = grade;		//student's current gpa
			creditHours = hours;//students current credit hours 
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
