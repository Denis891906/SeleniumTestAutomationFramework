package FrameWork.pages.rozetka;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RozetkaHome {
	public RozetkaHome(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	private WebDriver driver;
	
	@FindBy(xpath="//*[@class='rz-header-search-inner']//input[@name='text']") 
	private WebElement searchField;
	
	@FindBy(xpath="//button[text()='Найти']")
	private WebElement searchBtn;
	
	public RozetkaHome open() {
		System.out.println("Line in the begining of 'open'");
		driver.get("https://rozetka.com.ua/");
		System.out.println("Line in the end of 'open'");
		return this;
	}

	public RozetkaHome search(String searchRequest) {
		/*WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));*/
		
		
		System.out.println("Line in the begining of the 'search'");
		searchField.click();
		searchField.sendKeys(searchRequest);
		searchBtn.click();
		System.out.println("Line in the end of the 'search'");
		return new RozetkaHome(driver);
	}

	public void checkGoodIsPresentInSearchResult() {
		System.out.println("Line in the begining of the 'checkResult'");
		Assert.assertTrue(isGoodPresentInSearchResult(driver));		
	} 
	
	public static boolean isGoodPresentInSearchResult(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);		
		List<WebElement> array=driver.findElements(By.xpath("//*[@class='g-i-tile g-i-tile-catalog' or @data-location='SearchResults']"));
		System.out.println("The size is " + array.size());
		return array.size() > 0;
	}



	
}
