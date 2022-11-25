package classesandObjects;

import java.util.Scanner;

public class ReturtypeDemo {
	
	public static void main(String[] args) {
		int amount = 10000;
		int r = 5;
		int time = 1;
		
		 double si = siCalculator(amount, r, time);
		double totalamount = amount+ si; 
			
		
	}
	
	public static double siCalculator(int pa, int roi, int t) {
	  double si = (pa*roi*t)/100;
	  System.out.println(si);
	  
	  return si;
	  	}
	
	
	public static String sayMyname(String name) {


		return name;
	}
	
	public static int saymyage(int age) {
		
		return age;
	}

}
