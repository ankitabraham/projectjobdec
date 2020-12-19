package com.orangee.uitest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage1
{
 WebDriver driver;
	
	@FindBy(id = "txtUsername") 
	WebElement username;
	
	@FindBy(id = "txtPassword") 
	WebElement password;
	
	@FindBy(id = "btnLogin") 
	WebElement loginn;
	
	@FindBy(id = "spanMessage") 
	WebElement messaged;
	
	
	public loginpage1(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String logingcred(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		loginn.click();
	
		return "sucess";
	}
	
}
