package testngBasics;

import org.testng.annotations.Test;

public class TestGroups {
	
	@Test(groups = { "regression", "sanity"})
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(groups = "regression")
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(groups =  "sanity")
	public void test3() {
		System.out.println("Test3");
	}
	@Test(groups = "regression")
	public void test4() {
		System.out.println("Test4");
	}
	@Test(groups = "regression")
	public void test5() {
		System.out.println("Test5");
	}
	
	@Test(groups =  "sanity")
	public void test6() {
		System.out.println("Test6");
	}
	@Test(expectedExceptions = ArithmeticException.class)
	public void testException() {
		int a=10, b=0;
		System.out.println(a/b);
		System.out.println("expected exception");
		
	}

}
