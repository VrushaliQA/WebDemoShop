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
import com.cjc.dws.webApp.pages.ShoppingCartPage;
import com.cjc.dws.webApp.pages.SignOnPage;
import com.cjc.dws.webApp.pages.UserHomePage;
import com.cjc.dws.webApp.utility.Utilities;

public class CompleteOrderTest extends BaseClass {

	WebDriver driver;
	HomePage homePageObj;
	SignOnPage signOnPageObj;
	UserHomePage userHomePageObj;
	BooksPage booksPageObj;
	ShoppingCartPage shoppingCartPageObj;
	
	
	
	
	
	public CompleteOrderTest() {
		super();
	}
	
	@BeforeMethod()
	void initBookPage()
	{
		Utilities.logger=Logger.getLogger( CompleteOrderTest.class.getName());
		driver=initWebdriver();
		homePageObj=new HomePage(driver);
		signOnPageObj= homePageObj.clickLogIn();
		userHomePageObj=signOnPageObj.signInMethod(prop.getProperty("userName"),prop.getProperty("pass"));
		
	}
	
	
	
	
	@Test
	void orderTest()
	{
//		System.out.println("addding the book");
//		logger.fatal("adding the book");
		booksPageObj=userHomePageObj.clickOnLeftBarBook();
		booksPageObj.clickOnComputingAndInternet();
		Utilities.logger.info("Added ComputingAndInternet");
		shoppingCartPageObj=userHomePageObj.clickOnShoppingCart();
		shoppingCartPageObj.acceptTermsOfService();
		shoppingCartPageObj.clickOnCheckout();
	}
	
	
	@AfterMethod
	public void tearDownRegistrationPage()
	{
		//driver.quit();
	}
	

}
