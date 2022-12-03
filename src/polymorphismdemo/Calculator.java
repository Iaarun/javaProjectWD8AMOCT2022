package polymorphismdemo;

public class Calculator {
    int a=10;
	public static void add(int b, int a) {
		System.out.println("addintion of two number");
	}

//	public int add(int a, int b) {
//		return a+b;
//	}
	public static void add(int a, int b, int c) {
		System.out.println("addintion of three number");
	}

	public void add(int a, double b) {
		System.out.println("Addition of int and decimal number");
	}

	public void add(double a, int b) {
		System.out.println("Addition of int and decimal number");
	}
	
	public  void test() {
		System.out.println("Test function in Calculator class");
	}

	public static void main(String[] args) {

	}

	public static void main(int[] args) {

	}

}
