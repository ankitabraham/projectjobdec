package com.orangee.uitest.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{

public static WebDriver driver;
	
	public  void init_initial() {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe\\");
	     driver = new ChromeDriver();
	     
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	
	
}
