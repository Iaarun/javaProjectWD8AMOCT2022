package polymorphismdemo;

public class TestOveriding {
	
	public static void main(String[] args) {
		ScientificCalculator sc = new ScientificCalculator();
		sc.test();
		System.out.println(sc.a);
		
		Calculator cal = new Calculator();
		cal.test();
		System.out.println(cal.a);
	
		
		//downcasting
		Calculator cal1 = new ScientificCalculator();
		cal1.test();
		System.out.println(cal1.a);
		
		//upcasting
	//	ScientificCalculator sc1 = new Calculator();
	
	}

}
