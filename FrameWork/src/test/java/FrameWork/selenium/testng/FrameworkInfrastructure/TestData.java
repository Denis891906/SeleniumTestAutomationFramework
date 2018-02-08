package FrameWork.selenium.testng.FrameworkInfrastructure;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="CheckRozetkaSearch")
	public static Object[][] dataForCheckRozetkaSearch(){
		return new Object[][] {
			{"Samsung Galaxy s8"},
			{"Lenovo Vibe S1"}
		};
	}
	
	

}
