package com.cjc.dws.webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOnPage 
{
	WebDriver driver;

	@FindBy(css="input[id='Email']")
	WebElement email;
	
	@FindBy(css="input[id='Password']")
	WebElement password;
	
	@FindBy(css="input[class='button-1 login-button']")
	WebElement logInButton;
	
	
	public SignOnPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public UserHomePage signInMethod(String username,String pass)
	{
		email.sendKeys(username);
		password.sendKeys(pass);
		logInButton.click();
		return (new UserHomePage(driver));
		
	}
	
	
	
}
