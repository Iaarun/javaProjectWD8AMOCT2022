package seleniumScripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import filehandling.PropertiesFileHandle;

/**
 * Selenium4.6.0
 */
public class SeleniumScripts {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		PropertiesFileHandle pfh = new PropertiesFileHandle();
		Properties p1= pfh.readConfig();
		SeleniumScripts ss = new SeleniumScripts();
		ss.launchBrowsers((String) p1.get("browser"));
		ss.handleTable();
		ss.closeBrowser();
	}
	public void test(String name, int age) {
		System.out.println("My name is "+name+ "and age is ");
	}

	public void handleTable() {
		driver.get("https://www.moneycontrol.com/markets/indian-indices/");
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='indicesTable']/thead/tr[1]/th"));
		int colNo = columns.size();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='indicesTable']/tbody/tr"));
		int rownum = rows.size();
		
		//get the header names
		for(int i=1; i<=colNo; i++) {
		String names=	driver.findElement(By.xpath("//table[@id='indicesTable']/thead/tr[1]/th["+i+"]")).getText();
		System.out.print(names+" ");
		}

		System.out.println("=====");
		//get columndata
		
		for(int i=1; i<=rownum; i++) {
			String names=	driver.findElement(By.xpath("//table[@id='indicesTable']/tbody/tr["+i+"]/td[1]")).getText();
			String ltp=	driver.findElement(By.xpath("//table[@id='indicesTable']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(names+" | "+ltp);
			}
		
		System.out.println("=====");
		System.out.println("complete table Data");
		System.out.println("=====");
		
		for(int i=1; i<=rownum; i++) {
			for(int j=1; j<=colNo; j++) {
				String data =	driver.findElement(By.xpath("//table[@id='indicesTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
			    System.out.print(data+"  ");
			}
			System.out.println();
		}
	}

	public void handleCalender() {
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		WebElement inputbox = driver.findElement(By.id("datepicker"));
		inputbox.click();

		String calTitle = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		System.out.println(calTitle);
		String month = calTitle.split(" ")[0].trim();
		String year = calTitle.split(" ")[1].trim();

		String nyear = String.valueOf(Integer.parseInt(year) + 1);

		while (!(month.equals("March") && year.equals(nyear))) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			calTitle = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
			month = calTitle.split(" ")[0].trim();
			year = calTitle.split(" ")[1].trim();
		}

		driver.findElement(By.xpath("//a[normalize-space()='30']")).click();

	}

	public void login() {
		// WebDriver driver = new ChromeDriver();

		driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.id("login"));
		login.sendKeys("testuser");

		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("testuser");

		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();

		WebElement errormessage = driver.findElement(By.id("textmsg"));

		System.out.println(errormessage.getText());

	}

	public void multipletabs() {
		LinkedHashSet<String> lset = new LinkedHashSet<>();
		driver.get("https://www.naukri.com/");
		String firsttab = driver.getWindowHandle();
		lset.add(firsttab);
		WebElement servicestab = driver.findElement(By.xpath("//div[normalize-space()='Services']"));
		WebElement companiesTab = driver.findElement(By.xpath("//div[normalize-space()='Companies']"));

		Actions action = new Actions(driver);

		action.keyDown(Keys.CONTROL).click(servicestab).keyUp(Keys.CONTROL).build().perform();
		lset.addAll(driver.getWindowHandles());
		action.keyDown(Keys.CONTROL).click(companiesTab).keyUp(Keys.CONTROL).build().perform();
		lset.addAll(driver.getWindowHandles());
		// Set<String> allids = driver.getWindowHandles();

		Iterator<String> it = lset.iterator();
		String fid = it.next();
		System.out.println(fid + "\n" + driver.getTitle());

		String sid = it.next();
		driver.switchTo().window(sid);
		System.out.println(sid + "\n" + driver.getTitle());

		String tid = it.next();
		driver.switchTo().window(tid);
		System.out.println(tid + "\n" + driver.getTitle());
	}

	public void handliMultipleWindow() {
		driver.get("https://www.naukri.com/");
		String firsttab = driver.getWindowHandle();
		System.out.println(driver.getCurrentUrl());
		WebElement services = driver.findElement(By.xpath("//div[normalize-space()='Services']"));

		services.click();

		Set<String> alltabs = driver.getWindowHandles();

		for (String id : alltabs) {
			if (!id.equals(firsttab)) {
				driver.switchTo().window(id);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}

		driver.switchTo().window(firsttab);
		System.out.println(driver.getCurrentUrl());

	}

	public void autosuggestion() {
		driver.get("https://jqueryui.com/autocomplete/");
		driver.switchTo().frame(0);
		WebElement Tags = driver.findElement(By.id("tags"));
		Tags.sendKeys("P");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));

		list.forEach(x -> {
			if (x.getText().equals("Perl")) {
				x.click();
			}
		});

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
