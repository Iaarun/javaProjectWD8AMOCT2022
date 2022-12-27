package seleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * 
 * Launching browser before selenium version  4.6.0
  webdriver.chrome.driver
  webdriver.gecko.driver
  webdriver.ie.driver
 *
 */
public class LaunchBrowser {
	
	public static void main(String[] args) {
		LaunchBrowser lb = new LaunchBrowser();
		lb.launchChromeBrowser();
	}

	public void launchChromeBrowser() {
	String path=	System.getProperty("user.dir");
	System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"\\browserdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.close();
	}
	
	public void launchfirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\Automationtools\\seljars\\ff31\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
	}
}
