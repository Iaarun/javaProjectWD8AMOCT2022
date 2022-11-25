package classesandObjects;

import java.util.Scanner;

public class Calculator {
	
 static	int num =10;
	
	public static void main(String[] args) {
	//	addition();
		
		
		sayMyName("Suraj");
	}
	
	//non parameterised
	public static void addition() {
		int a=10, b = 20;
		int res =a+b;
		System.out.println(res);
	}
	
	//parameterised function
	public static void add(int a, int b) {
		int result = a+b;
		System.out.println(result);
	}
	
	public static void sayMyName(String name) {
		System.out.println("Hello"+name);
	}
	
	
	
//	public static void test(String[] args) {
//		System.out.println(num);
//	}
	
 // accessmodifier static/nonstatic returntype identifier(){ }
	
	

}
