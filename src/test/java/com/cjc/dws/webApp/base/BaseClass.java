package com.cjc.dws.webApp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cjc.dws.webApp.utility.TimeOutsProvider;



public class BaseClass {

	
	
	 public Properties prop;
		FileInputStream ip;
		 WebDriver driver;
		public BaseClass()
		{
			prop=new Properties();
			try {
				ip=new FileInputStream("G:\\CJCSelenium\\MavenTasks\\02_11_2022_Project\\src\\test\\resources\\configuration\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public WebDriver initWebdriver()
		{
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				 System.setProperty("webdriver.chrome.driver","G:\\CJCSelenium\\MavenTasks\\02_11_2022_Project\\src\\test\\resources\\chromeExe\\chromedriver.exe");
				 driver=new ChromeDriver();
				 driver.manage().deleteAllCookies();
				 driver.manage().window().maximize();
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.PAGETIMEOUT));
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.IMPLICITETIMEOUT));
				 driver.get(prop.getProperty("url"));
				
				 
			}
			 return driver;
		}


}
