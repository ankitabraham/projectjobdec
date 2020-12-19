package com.orangee.uitest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class loginpage 
{
    WebDriver driver;
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginbutton = By.id("btnLogin");
	By errormessage = By.id("spanMessage");
	
	
	public loginpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String invalidlogin(String user,String pass)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginbutton).click();
		String messagee = driver.findElement(errormessage).getText();
		return messagee;
	}
	
	
}
