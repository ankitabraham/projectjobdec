package ankit.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import com.orangee.uitest.ankit.excel_reader;
import com.orangee.uitest.pageobject.loginpage;
import com.orangee.uitest.screenshot.CaptureScreenshot;
import com.orangee.uitest.testBase.TestBase;
@Listeners(com.orangee.uitest.listners.Listners.class)
public class TC01_invalid_login extends TestBase
{

	
 	static excel_reader excel;
 	static String filepath=System.getProperty("user.dir")+"\\Resources\\Data\\";
 	static String excelname = "test.xlsx";
 	static String sheetname = "Sheet1";
 	static int rownum = 1;
 	static String message = "invalid login";
 	CaptureScreenshot screen;
 	static ArrayList<String> values = new ArrayList<String>();
     loginpage login;
		// TODO Auto-generated method stub
 	
 
	       
			@BeforeClass
	        	public  void setUp()throws Exception {
	    		

	    		/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe\\");
	    	     driver = new ChromeDriver();
	    	     
	    	     driver.manage().window().maximize();
	    	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	     driver.get("https://opensource-demo.orangehrmlive.com/");
	    	    // String log4jConfPath = System.getProperty("user.dir")+"\\Resources\\ConfigFiles\\log4j.properties\\";
	    	    // PropertyConfigurator.configure(log4jConfPath);
			 	 //PropertyConfigurator.configure(log4jConfPath);
				//public static final Logger log = Logger.getLogger(TC01_InvalidLogin.class.getName());*/
               init_initial();
	    	   
	    	  //  TC01_InvalidLogin_Test();
	        
	    	
	        

	}
			@Test
	    	 void TC01_InvalidLogin_Test() throws Exception {
	    		
	    		excel = new excel_reader();
	    		screen = new CaptureScreenshot();
	    		login = new loginpage(driver);
	    		
	    		values = excel.getCellData(filepath, excelname, sheetname, rownum);
	    		
	    		 
	    		String username = values.get(0);
	    		String password = values.get(1);
	    		
	    		//driver.findElement(By.id("txtUsername")).sendKeys(username);
	    	//	driver.findElement(By.id("txtPassword")).sendKeys(password);
	    		
	    		//driver.findElement(By.id("btnLogin")).click();
	    		
	    		String actualMessage = login.invalidlogin(username, password);
	    		screen.getScreenShot(driver, "TC01_INVALID_LOGIN");
	    		//String actualMessage = driver.findElement(By.id("spanMessage")).getText();
	    		String expectedMessage = "Invalid credentials";
	    		
	    	
	    	if((actualMessage).equals(expectedMessage)) { // asserting actual = expected
	    			
	    			System.out.println("Test Case Passed");
	    		}
	    	else
	    		System.out.println("testcase 1 failed/french");
	    		
	    		//excel.updateCellData(filepath, excelname, sheetname, rownum, actualMessage );

          }
	    	
			
			@AfterClass
			void closee()
			{
				driver.close();
			}
	    	
}