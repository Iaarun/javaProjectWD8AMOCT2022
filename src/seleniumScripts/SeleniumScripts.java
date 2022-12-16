package seleniumScripts;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Selenium4.6.0
 */
public class SeleniumScripts {
	WebDriver driver;

	public static void main(String[] args) {
		SeleniumScripts ss = new SeleniumScripts();
		ss.launchBrowsers("firefox");
		ss.basicfunction();
		ss.closeBrowser();
	}

	public void basicfunction() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");
		String url = driver.getCurrentUrl();
		System.out.println(url);

		String title = driver.getTitle();
		System.out.println(title);

		String tabId = driver.getWindowHandle();
		System.out.println(tabId);
		
		Set<String> alltabs= driver.getWindowHandles();
		
		alltabs.forEach(x->{System.out.println(x);});
		
//		for(String x: alltabs) {
//			System.out.println(x);
//		}
		
		System.out.println(driver.getPageSource());
	}

	public void launchapp() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");
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

	}

}
