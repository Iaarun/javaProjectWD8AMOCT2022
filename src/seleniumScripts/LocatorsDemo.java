package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsDemo {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		LocatorsDemo ld = new LocatorsDemo();
		ld.launchBrowsers("chrome");
		ld.linkedtextDemo();
	}
	
	public void linkedtextDemo() throws InterruptedException {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement returnlink= driver.findElement(By.linkText("Return to index"));
		returnlink.click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		returnlink= driver.findElement(By.partialLinkText("Return to"));
		returnlink.click();
	}
	
	public void classNamelocator() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
	System.out.println(driver.findElement(By.className("img-fluid")).isDisplayed());
	}
	
	public void nameId() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void launchBrowsers(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();

	}
}
