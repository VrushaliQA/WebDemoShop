package com.cjc.dws.webApp.tests;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cjc.dws.weApp.commons.DataProviderForRegistration;
import com.cjc.dws.webApp.base.BaseClass;
import com.cjc.dws.webApp.pages.HomePage;
import com.cjc.dws.webApp.pages.RegistrationPage;
import com.cjc.dws.webApp.pages.UserHomePage;



public class RegistrationPageTest extends BaseClass {
	WebDriver driver;
	HomePage homePageObj;
	RegistrationPage registrationPageObj;
	UserHomePage userHomePageObj;
	
	
	public RegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	void init()
	{
		driver=initWebdriver();
		homePageObj=new HomePage(driver);
		registrationPageObj=homePageObj.clickOnRegistration();
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class,priority=2)
	public void gettingRegister(Row row)
	{
		
			
			String data[]=new String[row.getLastCellNum()];
			int i=0;
			Iterator<Cell> cellItr=row.cellIterator();
			while(cellItr.hasNext())
			{
				Cell cell=cellItr.next();
				switch(cell.getCellType())
				{
				case NUMERIC:
					 Integer val=(int) cell.getNumericCellValue();
						data[i]= val.toString();
						i++;
						break;
					 case STRING:
						 data[i]=cell.getStringCellValue();
						 i++;
						 break;
					 default:
						break;
				}
			}
			userHomePageObj=registrationPageObj.registerUser(data);
			Assert.assertEquals(userHomePageObj.checkUserRegisteredLoggedIn("vrushalid@gmail.com"),true );
					
			
	}
	
	@AfterMethod
	public void tearDownRegistrationPage()
	{
		driver.quit();
	}
	
}
		
		
	
	


