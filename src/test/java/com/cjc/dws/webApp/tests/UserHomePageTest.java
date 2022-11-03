package com.cjc.dws.webApp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cjc.dws.webApp.base.BaseClass;
import com.cjc.dws.webApp.pages.HomePage;
import com.cjc.dws.webApp.pages.SignOnPage;
import com.cjc.dws.webApp.pages.UserHomePage;



public class UserHomePageTest extends BaseClass{
	WebDriver driver;
	HomePage homePageObj;
	SignOnPage signOnPageObj;
	UserHomePage userHomePageObj;
	
	public UserHomePageTest() {
		super();
	}
	
	@BeforeMethod()
	void init()
	{
		driver=initWebdriver();
		homePageObj=new HomePage(driver);
		signOnPageObj= homePageObj.clickLogIn();
		userHomePageObj=signOnPageObj.signInMethod(prop.getProperty("userName"),prop.getProperty("pass"));
	}
	
	@Test(priority=5)
	void checkDesiredUserLoggedIn()
	{
		Assert.assertEquals(userHomePageObj.checkUserLoggedIn(prop.getProperty("userName")),true );
	}
	
	@AfterMethod
	public void tearDownUserHomePage()
	{
		driver.quit();
	}

}
