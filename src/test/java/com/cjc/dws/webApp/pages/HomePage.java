package com.cjc.dws.webApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	WebDriver driver;
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[1]/a/img")
	WebElement logo;
	
	@FindBy(css="a[class='ico-login']")
	WebElement logInLink;


	@FindBy(css="a[class='ico-register']")
	WebElement registerLink;
	
	public HomePage(WebDriver driver) {
       PageFactory.initElements(driver, this);
       this.driver=driver;
	}
	
	public boolean checkLogo()
	{
		return logo.isDisplayed();
	}
	
	public SignOnPage clickLogIn()
	{
		logInLink.click();
		
		return (new SignOnPage(driver));
	}
	
	public RegistrationPage clickOnRegistration()
	{
		registerLink.click();
		return (new RegistrationPage(driver));
	}
	
	

}
