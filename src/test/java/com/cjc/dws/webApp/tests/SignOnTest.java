package com.cjc.dws.webApp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cjc.dws.webApp.base.BaseClass;
import com.cjc.dws.webApp.pages.HomePage;
import com.cjc.dws.webApp.pages.SignOnPage;


public class SignOnTest extends BaseClass
{
	WebDriver driver;
	HomePage homePageObj;
	SignOnPage signOnPageObj;
	public SignOnTest() {
		super();
	}


	@BeforeMethod
	void init()
	{
		
		driver=initWebdriver();
		homePageObj=new HomePage(driver);
		signOnPageObj= homePageObj.clickLogIn();
	}
	
	@Test(priority=4)
	void userLogin()
	{
		
		signOnPageObj.signInMethod(prop.getProperty("userName"),prop.getProperty("pass"));
	}
	
	@AfterMethod
	public void tearDownSignOnPage()
	{
		driver.quit();
	}
	
}
