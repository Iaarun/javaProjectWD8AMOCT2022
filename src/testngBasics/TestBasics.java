package testngBasics;

import org.testng.annotations.Test;

public class TestBasics {
	
	@Test(priority = 4)
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(priority = 2)
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(priority = -1)
	public void test3() {
		System.out.println("Test3");
	}
	@Test(priority = 1)
	public void test4() {
		System.out.println("Test4");
	}
	@Test(priority = 0, invocationCount = 2)
	public void test5() {
		System.out.println("Test5");
	}
	
	@Test(enabled = false)
	public void test6() {
		System.out.println("Test6");
	}
	@Test(expectedExceptions = ArithmeticException.class)
	public void testException() {
		int a=10, b=0;
		
		System.out.println(a/b);
	}
	
	

}
