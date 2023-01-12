package testNgListenersPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(MyListners.class)
public class TestNGListnersDemo {

	WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	public void firstTest() {
		String expectedMob_title ="MOBILE";
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		String mobiletitle= driver.findElement(By.xpath("//h1[normalize-space()='Mobile']")).getText();
	   Assert.assertEquals(mobiletitle, expectedMob_title);
	}
	@Test
	public void firstTest1() {
		SoftAssert sofassert = new SoftAssert();
		String expectedMob_title ="MOBILE";
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		String mobiletitle= driver.findElement(By.xpath("//h1[normalize-space()='Mobile']")).getText();
		sofassert.assertEquals(mobiletitle, expectedMob_title);
		
		sofassert.assertAll();
	}
//	@Test(dataProvider = "mydata", dataProviderClass = Data.class)
	public void loginTest(String useremail, String password) {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(useremail);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();

		driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
