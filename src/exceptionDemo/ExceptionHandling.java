package exceptionDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 try{
  code
 }catch(Exception){
 
 }
 */
public class ExceptionHandling {
	
	public static void main(String[] args) throws FileNotFoundException, InvalidAgeException {
		test2();
		//validateAge(17);
	}
	
	public static void test3() throws FileNotFoundException {
		File f = new File("D:\\sampletestcase\\Gurur99Bank_TestCase.xlsx");
		FileInputStream fis = new FileInputStream(f);
	
	}
	
	public static void test2() {
		
		System.out.println("Programm Starts");
		int a[] = {15,15,64,13};
		
		try {
			for(int i=0; i<a.length; i++) {
				System.out.println(a[i]/0);
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}catch (Exception e) {
            e.printStackTrace();
		}finally {
			System.out.println("Finally Block");
		}
		
		
		System.out.println("Programm Ends");
	}
	
	public static void test() {
		System.out.println("Programm Starts");
		
		double a=10.0;
		int b=0;
		double res = a/b;
		try {
			System.out.println(a/b);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Programm Ends");
	}
	
	public static void validateAge(int age) throws InvalidAgeException {
		if(age <18) {
			throw new InvalidAgeException("Invalid Age exception");
		}else {
			System.out.println("Valid Age");
		}
	}
	

}
