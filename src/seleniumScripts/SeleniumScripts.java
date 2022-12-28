package seleniumScripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.xml.ws.Response;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * Selenium4.6.0
 */
public class SeleniumScripts {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		SeleniumScripts ss = new SeleniumScripts();
		ss.launchBrowsers("chrome");
		ss.fileUpload();
	//	ss.closeBrowser();
	}

	public void fileUpload() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement fileupload = driver.findElement(By.xpath("//input[@name='my-file']"));
		fileupload.sendKeys("C:\\Users\\HP\\Downloads\\Unconfirmed 801381.crdownload");
	}

	public void capturescreenshot() throws IOException {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
		driver.findElement(By.xpath("//button[@id='my-dropdown-1']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(file, new File("D:\\javaprog\\JavaProjectWD8AMOCT\\screenshot\\dd.psning"));
		WebElement menu = driver.findElement(By.xpath("//ul[@class='dropdown-menu show']"));
		file = menu.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("D:\\javaprog\\JavaProjectWD8AMOCT\\screenshot\\menu.gif"));
		System.out.println("Screenshot captured");

	}

	public void handlescroll() {
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

		WebElement alertbtn = driver.findElement(By.xpath("//input[@value='Confirmation Alert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// random scroll
		// js.executeScript("window.scrollBy(0,500)");

		// scroll to bring element into view
		// js.executeScript("arguments[0].scrollIntoView();", alertbtn);

		// scroll till bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void handleDropDown() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		WebElement createbutton = driver.findElement(By.xpath("//a[contains(@id,'u_0_0_')]"));
		createbutton.click();

		WebElement month = driver.findElement(By.id("month"));
		Select select = new Select(month);

		System.out.println("Default value: " + select.getFirstSelectedOption().getText());
		System.out.println("=================");
		List<WebElement> options = select.getOptions();
		options.forEach(x -> {
			System.out.println(x.getText());
		});

		select.selectByIndex(10);
		Thread.sleep(1000);
		select.selectByVisibleText("Feb");
		Thread.sleep(1000);
		select.selectByValue("6");
		System.out.println(select.isMultiple());

	}

	public void slider() {
		driver.get("https://jqueryui.com/slider/");
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(
				By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default ui-state-hover']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(500, 0).release().build().perform();
	}

	public void deagrandDrop() {
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions actions = new Actions(driver);
		// actions.clickAndHold(drag).moveToElement(drop).release().build().perform();
		actions.dragAndDrop(drag, drop).perform();

	}

	public void handleframes() {
		driver.navigate().to("https://jqueryui.com/droppable/");
		System.out.println(driver.findElement(By.xpath("//a[@href='/']")).isDisplayed());
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		System.out.println(driver.findElement(By.xpath("//div[@id='draggable']")).isDisplayed());

		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//a[@href='/']")).isDisplayed());

	}

	public void promptalert() {
		driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");
		driver.findElement(By.xpath("//input[@value='Say my name!']")).click();
		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());
		alert.sendKeys("Arun");
		alert.accept();
		System.out.println(alert.getText());
		alert.dismiss();
	}

	public void clickOnbutton() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement submitBtn = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));

		submitBtn.click();
	}

	public void displayedenabledselected() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement readonly = driver.findElement(By.name("my-readonly"));
		System.out.println(readonly.isDisplayed());

		WebElement disabled = driver.findElement(By.name("my-disabled"));
		System.out.println(disabled.isEnabled());
	}

	public void handleMultipleCheckbox() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

		List<WebElement> checkboxes = driver.findElements(By.name("my-check"));

		checkboxes.forEach(x -> {
			if (!x.isSelected()) {
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
