package inheritanceDemo;

/*
 sub derived child
 super base parent
 */

public class Developer extends Employee{
   
	
	String project;
	int YOE;
	
	
	public static void main(String[] args) {
		Developer d1 = new Developer();
		
		d1.name = "Arun";
		d1.project ="Banking";
		d1.YOE= 10;
		d1.workingHrs();
	}
	
}
