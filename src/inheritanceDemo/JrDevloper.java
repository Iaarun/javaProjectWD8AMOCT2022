package inheritanceDemo;

public class JrDevloper extends Employee {
	
	@Override
	public void workingHrs() {
		System.out.println("I am o notice period");
	}
	public static void main(String[] args) {
		JrDevloper jd = new JrDevloper();
		
		jd.name= "Amit";
	//	jd.YOE = 1;
	//	jd.project= "Insurance";
		jd.workingHrs();
	}

	
}
