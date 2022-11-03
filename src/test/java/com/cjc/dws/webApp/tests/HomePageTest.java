package com.cjc.dws.webApp.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cjc.dws.webApp.base.BaseClass;
import com.cjc.dws.webApp.pages.HomePage;
import com.cjc.dws.webApp.pages.SignOnPage;



public class HomePageTest extends BaseClass {

	WebDriver driver;
	HomePage homePageObj;
	SignOnPage signOnPageObj;
	HomePageTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	void init()
	{
		
		driver=initWebdriver();
		homePageObj=new HomePage(driver);
	}
	
	@Test(priority=1)
	void checkLogo()
	{
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(homePageObj.checkLogo(), true);
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	void clickOnLogin()
	{
		//System.out.println("into the test");
		homePageObj.clickLogIn();
		//System.out.println("quiting  the test");
	}
	
	@AfterMethod
	public void tearDownHomePage()
	{
		driver.quit();
	}
	
}
