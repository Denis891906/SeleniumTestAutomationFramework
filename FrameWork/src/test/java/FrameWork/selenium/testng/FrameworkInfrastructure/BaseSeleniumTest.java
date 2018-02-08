package FrameWork.selenium.testng.FrameworkInfrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

// The best practices https://seleniumcamp.com/talk/start-writing-good-functional-tests-in-java-with-webdriver/

public class BaseSeleniumTest {

	private WebDriver driver;
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\FrameWork\\drivers\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeSuite
	public void  beforeTest() {
		System.out.println("Hello from BeforeTest");
		initDriver();
		
	}
	
	@AfterSuite
	public void afterTest() {
		getDriver().quit();
		System.out.println("Line from AfterTest");
	}
	
}
