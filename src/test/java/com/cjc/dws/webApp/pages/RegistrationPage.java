package com.cjc.dws.webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
	WebDriver driver;

	@FindBy(css="input[id='FirstName']")
	WebElement firstName;

	@FindBy(css="input[id='LastName']")
	WebElement lastName;
	
	
	@FindBy(css="input[id='Email']")
	WebElement email;
	

	@FindBy(css="input[id='Password']")
	WebElement password;
	
	@FindBy(css="input[id='ConfirmPassword']")
	WebElement confirmPassword;
	
	@FindBy(css="input[id='register-button']")
	WebElement registerButton;
	
	@FindBy(css="input[id='gender-male']")
	WebElement maleGender;
	
	@FindBy(css="input[id='gender-female']")
	WebElement femaleGender;
	
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public UserHomePage registerUser(String[] data)
	{
		int j=0;
		if(data[j].equalsIgnoreCase("male"))
		{
			maleGender.click();
			j++;
		}
		else if(data[j].equalsIgnoreCase("female"))
		{
			femaleGender.click();
			j++;
		}
		
		
		
		firstName.sendKeys(data[j]);
		j++;
		
		lastName.sendKeys(data[j]);
		j++;
		
		email.sendKeys(data[j]);
		j++;
		
		password.sendKeys(data[j]);
		j++;
		
		confirmPassword.sendKeys(data[j]);
		
		registerButton.click();
		return new UserHomePage(driver);
	}

}
