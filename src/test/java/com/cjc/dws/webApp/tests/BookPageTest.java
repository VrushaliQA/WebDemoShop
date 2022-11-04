package com.cjc.dws.webApp.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cjc.dws.webApp.base.BaseClass;
import com.cjc.dws.webApp.pages.BooksPage;
import com.cjc.dws.webApp.pages.HomePage;
import com.cjc.dws.webApp.pages.SignOnPage;
import com.cjc.dws.webApp.pages.UserHomePage;


public class BookPageTest extends BaseClass {

	WebDriver driver;
	HomePage homePageObj;
	SignOnPage signOnPageObj;
	UserHomePage userHomePageObj;
	BooksPage booksPageObj;
	
	public Logger logger=Logger.getLogger( BookPageTest.class.getName());
	
	
	public BookPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod()
	void initBookPage()
	{
		driver=initWebdriver();
		homePageObj=new HomePage(driver);
		signOnPageObj= homePageObj.clickLogIn();
		userHomePageObj=signOnPageObj.signInMethod(prop.getProperty("userName"),prop.getProperty("pass"));
		booksPageObj=userHomePageObj.clickOnLeftBarBook();
	}
	
	
	@Test
	void booksLogoDisplayed()
	{
		Assert.assertEquals(booksPageObj.titleDisplayed(), true);
		
	}
	
	@Test
	void addTheBook()
	{
//		System.out.println("addding the book");
//		logger.fatal("adding the book");
		booksPageObj.clickOnComputingAndInternet();
		logger.info("Added ComputingAndInternet");
		
	}
	
	
	@AfterMethod
	public void tearDownRegistrationPage()
	{
		//driver.quit();
	}
	

}
