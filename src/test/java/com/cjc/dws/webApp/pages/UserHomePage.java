package com.cjc.dws.webApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	WebDriver driver;

	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement userNameDisplayed;
	
	@FindBy(css="div[class=\"listbox\"]>ul>li>a[href=\"/books\"]")
	WebElement bookTabOnLeftBar;
	
	@FindBy(xpath="//*[@id=\"topcartlink\"]/a/span[1]")
	WebElement shoppingCartTab;
	
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean checkUserLoggedIn(String userExpected)
	{
		System.out.println(userNameDisplayed.getText());
		if(userNameDisplayed.getText().equals(userExpected))
			return true;
		else
			return false;
	}
	
	public boolean checkUserRegisteredLoggedIn(String userExpected)
	{
		System.out.println(userNameDisplayed.getText());
		if(userNameDisplayed.getText().equals(userExpected))
			return true;
		else
			return false;
	}
	
	public BooksPage clickOnLeftBarBook()
	{
		bookTabOnLeftBar.click();
		return new BooksPage(driver);
	}
	
	public ShoppingCartPage clickOnShoppingCart()
	{
		shoppingCartTab.click();
		return new ShoppingCartPage(driver);
	}

}
