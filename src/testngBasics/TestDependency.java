package testngBasics;

import org.testng.annotations.Test;

public class TestDependency {
	
	@Test(dependsOnMethods = "testException")
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}

	@Test
	public void testException() {
		int a=10, b=0;
		System.out.println(a/b);
		System.out.println("expected exception");
		
	}

}
