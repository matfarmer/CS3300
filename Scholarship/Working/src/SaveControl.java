import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class SaveControl {

	LinkedList<Scholarship> myList;
	LinkedList<String> studentSelect;
	String name, major, temp;
	double gpa, amount;
	int hours, current, max;
	
	public SaveControl() {
		
		myList = new LinkedList<Scholarship>();
		File file = new File("SaveData.txt");
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				name = input.nextLine();
				major = input.nextLine();
				temp = input.nextLine();
				gpa = Double.parseDouble(temp);
				temp = input.nextLine();
				hours = Integer.parseInt(temp);
				temp = input.nextLine();
				amount = Double.parseDouble(temp);
				temp = input.nextLine();
				max = Integer.parseInt(temp);
				temp = input.nextLine();
				current = Integer.parseInt(temp);
				myList.add(new Scholarship(name, major, gpa, hours, amount, max, current));
			}
			input.close();
		} catch (FileNotFoundException e) {}
	}
	
	public void saveScholarship(Scholarship scholarship) {
		
		myList.add(scholarship);
		try {
			PrintWriter output = new PrintWriter("SaveData.txt");
			for(int i = 0; i < myList.size(); i++) {
				output.println(myList.get(i).getName());
				output.println(myList.get(i).getMajor());
				output.println(myList.get(i).getGPA());
				output.println(myList.get(i).getHours());
				output.println(myList.get(i).getAmount());
				output.println(myList.get(i).getMax());
				output.println(myList.get(i).getCurrent());
			}
			output.close();
		} catch (FileNotFoundException e) {}
	}	
	public LinkedList<Scholarship> getList() {
		return myList;
	}
	public void save(LinkedList<Scholarship> myList) {
		try {
			PrintWriter output = new PrintWriter("SaveData.txt");
			for(int i = 0; i < myList.size(); i++) {
				output.println(myList.get(i).getName());
				output.println(myList.get(i).getMajor());
				output.println(myList.get(i).getGPA());
				output.println(myList.get(i).getHours());
				output.println(myList.get(i).getAmount());
				output.println(myList.get(i).getMax());
				output.println(myList.get(i).getCurrent());
			}
			output.close();
		} catch (FileNotFoundException e) {}
	}
	private void saveAward(LinkedList<String> myList) {
		try {
			PrintWriter output = new PrintWriter("Awarded.txt");
			for(int i = 0; i < myList.size(); i++) {
				output.println(myList.get(i));
			}
			output.close();
			
		} catch (FileNotFoundException e) {}
	}
	public void saveAwarded(Student student, Scholarship scholarship) {
		try {
				File file = new File("Awarded.txt");
				Scanner input = new Scanner(file);
				String name;
				LinkedList<String> award = new LinkedList<String>();
				while(input.hasNext()) {
					name = input.nextLine();
					award.add(name);				
				}					
				for(int i = 0; i < award.size(); i++) {
					if(award.get(i).equals(student.getName())) {
						award.add(i + 1, scholarship.getName());
						this.saveAward(award);
						input.close();
						return;
					}
				}
				award.add("Name");
				award.add(student.getName());
				award.add(scholarship.getName());
				award.add("$");
				this.saveAward(award);
				input.close();
		} catch (FileNotFoundException e) {}
	}
	public LinkedList<String> setStudentSelect() {
		File file = new File("Awarded.txt");
		Scanner input;
		LinkedList<String> award = new LinkedList<String>();
		try {
			input = new Scanner(file);
			String name;
			while(input.hasNext()) {
				name = input.nextLine();
				award.add(name);				
			}
			input.close();
		} catch (FileNotFoundException e) {}
		return award;
	}
}
