package com.cjc.dws.webApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy(css="input[id='termsofservice']")
	WebElement termsOfService;
	
	@FindBy(css="button[type='submit']")
	WebElement checkOutTab;
	
	WebDriver driver;
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void acceptTermsOfService()
	{
		termsOfService.click();
	}
	
	public void clickOnCheckout()
	{
		checkOutTab.click();
	}
	

}
