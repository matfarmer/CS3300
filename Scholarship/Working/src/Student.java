import javax.swing.JOptionPane;

/**
 * 
 * @author Matthew
 * class derived from person, allows for a student to modify fields to be compared with scholarship class
 * for acceptance of scholarship
 */

public class Student extends Person {
		public Student(String name, String major, double grade, int hours) {
			this.name = name;   //student's name
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
		public double getGPA() {
			return gpa;
		}
		public int getHours() {
			return creditHours;
		}
		public boolean awardScholarship(Scholarship scholarship) {
			if(this.major.equals(scholarship.major) && this.gpa >= scholarship.gpa && this.creditHours >= scholarship.creditHours) {
				if(scholarship.getCurrent() < scholarship.getMax()) {
					JOptionPane.showMessageDialog(null, "You have been accepted!");
					return true;
				}
				else {
					JOptionPane.showMessageDialog(null, "We are sorry to inform you that this scholarship is"
							+ "full");
					return false;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You do not meet the requirements.");
				return false;
			}
		}
}
		

/*public void eligibilty()
		{
			SaveScholarship read = new SaveScholarship();
			read.readAmount();//used to gain the value for counter.
			int eligible[] =new int[read.counter];
			System.out.println(read.counter);
			
			System.out.println(name+" "+ major+" "+gpa+" "+creditHours);
			
			for(int i=0; i<read.counter;i++)
				eligible[i]=-1;
			

			read.readData();
			
			
			int n =0;
			
			for(int t=0; t<read.counter; t++)
			{ 
				//System.out.println("Something" + read.gpa[t]+" "+read.hours[t]+" "+read.major[t]);
				if(Float.parseFloat(read.gpa[t]) <= gpa && Integer.parseInt(read.hours[t]) <= creditHours  && read.major[t].equals(major))
				{
					eligible[n]=t; //gives us the values in the array of what scholarship the student is eligible for
					n++;
					System.out.println("Something else");
				}
			}
			
			System.out.println("These are the scholarhsip that you are qualified for");
			int w=0;
			while(eligible[w]!=-1 && w < read.counter)
			{
				System.out.println(read.name[eligible[w]]);
				w++;
			}
		}

}*/
