package seleniumScripts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		ss.handleMultipleCheckbox();
		// ss.closeBrowser();
	}

	public void handleMultipleCheckbox() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

		List<WebElement> checkboxes = driver.findElements(By.name("my-check"));
		
		checkboxes.forEach(x->{
			if(!x.isSelected()) {
				x.click();
			}
		});
	}

	public void sendDataCheckboxRadiobutton() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement userinput = driver.findElement(By.id("my-text-id"));
		userinput.sendKeys("Selenium Practice");

		WebElement checkbox2 = driver.findElement(By.id("my-check-2"));
		checkbox2.click();

		WebElement checkbox1 = driver.findElement(By.id("my-check-1"));
		checkbox1.click();

	}

	public void navigationcommands() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();

	}

	public void basicfunction() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");
		String url = driver.getCurrentUrl();
		System.out.println(url);

		String title = driver.getTitle();
		System.out.println(title);

		String tabId = driver.getWindowHandle();
		System.out.println(tabId);

		Set<String> alltabs = driver.getWindowHandles();

		alltabs.forEach(x -> {
			System.out.println(x);
		});

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
