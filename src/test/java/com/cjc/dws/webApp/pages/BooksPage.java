package com.cjc.dws.webApp.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage {
	WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Books')]")
	WebElement booksPageTitle;
	
	@FindBy(css="input[value='Add to cart']")
	WebElement ComputingAndInternet;
	
	public BooksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public boolean titleDisplayed()
	{
		return(booksPageTitle.getText().equalsIgnoreCase("Books"));
	}
	
	public void clickOnComputingAndInternet()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ComputingAndInternet));
		ComputingAndInternet.click();
	}

}
