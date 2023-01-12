package testngBasics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestDependency {
	
	@Test(dependsOnMethods = "testException", alwaysRun = true)
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
