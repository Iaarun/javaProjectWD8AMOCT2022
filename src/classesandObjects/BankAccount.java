package classesandObjects;

import java.util.Scanner;

public class BankAccount {
	 static int availableAmount = 2000;
	 
	 public static void main(String[] args) {
	//	amount();
		withdraw(amount());
		
	}
	public static int amount() {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		return amount;
	}
	
	public static void withdraw(int amount) {
		 System.out.println(availableAmount - amount);
		
	}

}
