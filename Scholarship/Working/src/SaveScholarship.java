import java.util.Scanner;
import java.io.*;

public class SaveScholarship
{
	Scholarship save = new Scholarship();
	
	protected String name[];
	protected String major[];
	protected String  gpa[];
	protected String hours [];
	protected String amount [];
	protected String max [];
	protected String current [];
	protected int placeHolder=0;
	protected int counter=0;
	
	public SaveScholarship()
	{
		readAmount();
		/*name= new String[placeHolder+1];
		major = new String[placeHolder+1];
		  gpa = new String [placeHolder+1];
		hours = new String[placeHolder+1];
		 amount = new String[placeHolder+1];
		max = new String[placeHolder+1];
		current = new String[placeHolder+1];
		
		// placeHolder=0;
		
		for( int g=0; g<placeHolder+1; g++)
		{
			name[g]="&"; 
			major[g]="&";
			gpa[g]="&";
			hours[g]="&";
			amount[g]="&";
			max[g]="&";
			current[g]="&";
			
			placeHolder=0;
			
		}*/
	}
	
	
	public void readAmount()
	{
		
		File scholarshipFile = new File("ScholarshipData.txt");
		
		Scanner readFile=null;
		
		try {
			readFile=new Scanner(scholarshipFile);
		} catch (FileNotFoundException e) {
			System.out.println("File not Found.");
		}
		
		String counters=readFile.nextLine();
		counter=Integer.parseInt(counters);
		placeHolder=counter;
		readFile.close();
		
		//readAmount();
		name= new String[placeHolder+1];
		major = new String[placeHolder+1];
		  gpa = new String [placeHolder+1];
		hours = new String[placeHolder+1];
		 amount = new String[placeHolder+1];
		max = new String[placeHolder+1];
		current = new String[placeHolder+1];
		
		// placeHolder=0;
		
		for( int g=0; g<placeHolder+1; g++)
		{
			//System.out.println(g+" time");
			name[placeHolder]="&"; 
			major[placeHolder]="&";
			gpa[placeHolder]="&";
			hours[placeHolder]="&";
			amount[placeHolder]="&";
			max[placeHolder]="&";
			current[placeHolder]="&";
			
			placeHolder=0;
		}
	}
	
	public void saveData()
	{
		//FileWriter saveFile=null; int p = 0;
		//try {
			//saveFile = new FileWriter("ScholarshipData.txt",true);
			//p++;
		//} catch (IOException e) {
			PrintWriter write=null;
			try {
				 write =new PrintWriter("ScholarshipData.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//}
		
		//PrintWriter write =null;
		//if(p>0)
		//write =new PrintWriter(saveFile);
		
		
		int i=0;
		write.println(counter);
		
		while (name != null && i<placeHolder)
		{
			write.print(name[i]+",");
			i++;
		}
		write.println(".");
		write.println("???");
		i=0;
		
		while (major != null && i<placeHolder)
		{
			write.print(major[i]+",");
			i++;
		}
		write.println(".");
		write.println("???");
		i=0;
		
		while (gpa != null && i<placeHolder)
		{
			write.print(gpa[i]+",");
			i++;
		}
		write.println("-");
		write.println("???");
		i=0;
		
		while (hours != null && i<placeHolder)
		{
			write.print(hours[i]+",");
			i++;
		}
		write.println(".");
		write.println("???");
		i=0;
		
		while (amount != null && i<placeHolder)
		{
			write.print(amount[i]+",");
			i++;
		}
		write.println("-");
		write.println("???");
		i=0;
		
		while (max != null && i<placeHolder)
		{
			write.print(max[i]+",");
			i++;
		}
		write.println(".");
		write.println("???");
		i=0;
		
		while (current != null && i<placeHolder)
		{
			write.print(current[i]+",");
			i++;
		}
		write.println(".");
		write.println("???");
		
		write.close();

	}

	
	
	public void readData()
	{
		int w=0;
		int i=0, k=0;
		char charHold=' ';
		String listHold="";
		String variableHold="";
		
		File scholarshipFile = new File("ScholarshipData.txt");
		
		Scanner readFile=null;
		
		try {
			readFile=new Scanner(scholarshipFile);
		} catch (FileNotFoundException e) {
			System.out.println("File not Found.");
		}
		
		
		while(readFile.hasNext())
		{
		listHold="";i=0; k=0;
		String counters=readFile.nextLine();
		//counter=Integer.parseInt(counters);
		//placeHolder=counter;
			listHold =readFile.nextLine();
			while(listHold.charAt(0) != '?')
			{	
				//System.out.println(listHold);
				while(charHold !='.')
				{
					charHold=listHold.charAt(k);
					k++;
			
					if(charHold==',')
					{	
						name[i]=variableHold;
						variableHold="";
						i++;//k=0;
						
					}
					else
					{
							
						if(i<counter)	
						variableHold+=charHold;
							
					}
					
					
				}listHold =readFile.nextLine();
			}
				
						
						listHold="";i=0; k=0;variableHold="";charHold=' ';
						listHold =readFile.nextLine();
					
						
					while(listHold.charAt(0) != '?')
					{
						while(charHold !='.')
						{
							charHold=listHold.charAt(k);
							k++;
					
							if(charHold==',')
							{
								major[i]=variableHold;
								variableHold="";
								i++;
							}
							
							else
							{
									
								if(i<counter)	
								variableHold+= charHold;
									
							}
							
							
						}listHold =readFile.nextLine();
					}
						
						listHold="";i=0; k=0;variableHold="";charHold=' ';
						listHold =readFile.nextLine();
						
					while(listHold.charAt(0) != '?')
					{	
						while(charHold !='-')
						{
							charHold=listHold.charAt(k);
							k++;
					
							if(charHold==',')
							{
								gpa[i]=variableHold;
								variableHold="";
								i++;
							}
							
							else
							{
									
								if(i<counter)	
								variableHold+= charHold;
									
							}
							
						
						}listHold =readFile.nextLine();
					}
						
						listHold="";i=0; k=0;variableHold="";charHold=' ';
						listHold =readFile.nextLine();
		
						
					while(listHold.charAt(0) != '?')
					{
						while(charHold !='.')
						{
							charHold=listHold.charAt(k);
							k++;
					
							if(charHold==',')
							{
								hours[i]=variableHold;
								variableHold="";
								i++;
							}
							
							else
							{
									
								if(i<counter)	
								variableHold+= charHold;
									
							}
							
						
						}listHold =readFile.nextLine();
					}
		
		
						listHold="";i=0; k=0;variableHold="";charHold=' ';
						listHold =readFile.nextLine();
						
						
						while(listHold.charAt(0) != '?')
					{
						while(charHold !='-')
						{
							charHold=listHold.charAt(k);
							k++;
					
							if(charHold==',')
							{
								amount[i]=variableHold;
								variableHold="";
								i++;
							}
							
							else
							{
									
								if(i<counter)	
								variableHold+= charHold;
									
							}
							
							
						}listHold =readFile.nextLine();
					}
		
						listHold="";i=0; k=0;variableHold="";charHold=' ';
						listHold =readFile.nextLine();
						
					while(listHold.charAt(0) != '?')
					{	
						while(charHold !='.')
						{
							charHold=listHold.charAt(k);
							k++;
					
							if(charHold==',')
							{
								max[i]=variableHold;
								variableHold="";
								i++;
							}
						
							else
							{
									
								if(i<counter)	
								variableHold+= charHold;
									
							}
							
							
						}listHold =readFile.nextLine();
					}
					
						listHold="";i=0; k=0;variableHold="";charHold=' ';
						
						
						listHold =readFile.nextLine();
						while(listHold.charAt(0) != '?')
					{
						while(charHold !='.')
						{
							charHold=listHold.charAt(k);
							k++;
					
							if(charHold==',')
							{
								current[i]=variableHold;
								variableHold="";
								i++;
							}
							
							else
							{
									
								if(i<counter)	
								variableHold+= charHold;
									
							}
							
							
						}listHold =readFile.nextLine();
					
					}		
				
			}
		
		
	}
	
	public void addScholarship(String z, String y, double x, int w, double v, int u, int t) 
	{
		readAmount();
		readData();
		
	
		for(int r=0; r<counter; r++)
		{
			if(name[r].charAt(0) != '.' )
				placeHolder++;
			
				
			//System.out.println(placeHolder+"cd"+name[r]);
		}
		
		
		
		name[placeHolder]=z;
		major[placeHolder]=y;
		
		double a=x;
		String c= Double.toString(a);
		gpa[placeHolder]=c; //System.out.println(name[placeHolder]+" "+save.getName());
		
		int d=w;
		c=Integer.toString(d);
		hours[placeHolder]=c;
		
		 a=v;
		 c= Double.toString(a);
		amount[placeHolder]=c;
		
		d=t;
		c=Integer.toString(d);
		current[placeHolder]=c;
		
		d=u;
		c=Integer.toString(d);
		max[placeHolder]=c;
		
		placeHolder++;
	
		counter=placeHolder;
	}
	
	public void addScholarships(Object[][] data) {
		placeHolder = 0;
		String gpa, hours, amount, max, current, name, major;
		
		for(int i = 0; i < data.length; i++) {
			name = (String)data[i][0];
	    	major = (String)data[i][1];
	    	gpa = (String)data[i][2];
	    	hours = (String)data[i][3];
	    	amount = (String)data[i][4];
	    	max = (String)data[i][5];
	    	current = (String)data[i][6];
	    	addScholarship(name, major, 
    				Double.parseDouble(gpa),
    				Integer.parseInt(hours),
    				Double.parseDouble(amount),
    				Integer.parseInt(max),
    				Integer.parseInt(current));
		}
		
	}
	
}
