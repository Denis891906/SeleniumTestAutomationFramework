package FrameWork.selenium.testng.Tests;

import org.testng.annotations.Test;

import FrameWork.pages.rozetka.RozetkaHome;
import FrameWork.selenium.testng.FrameworkInfrastructure.BaseSeleniumTest;
import FrameWork.selenium.testng.FrameworkInfrastructure.TestData;

public class CheckRozetkaSearch extends BaseSeleniumTest {

	@Test(dataProvider="CheckRozetkaSearch", dataProviderClass = TestData.class)
	public void CheckRozetkaSearch(String searchRequest) {
		RozetkaHome rozetka = new RozetkaHome(getDriver()).open().search(searchRequest);
		rozetka.checkGoodIsPresentInSearchResult();;	
	}
}

