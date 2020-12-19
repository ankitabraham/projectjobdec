package com.orangee.uitest.screenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class CaptureScreenshot
{

String dest = "";
	
	public String getScreenShot(WebDriver driver,String scenario_name){
			
			try {
			
				TakesScreenshot ts=(TakesScreenshot)driver; // taking screenshot 
				
				File source = ts.getScreenshotAs(OutputType.FILE); // keeping it at temp file
				
				
				SimpleDateFormat s=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
				
				
				String date = s.format(new Date()); // system date and time
				
				
				dest = System.getProperty("user.dir")+"\\ScreenShots\\/"+date+"-"+scenario_name+".png";
				
				
				File destination = new File(dest);
				
				
				FileHandler.copy(source, destination); // this will copy the screenshot in the folder location
				
				
				Reporter.log("Screen Shot Taken",true);
				
			    	
			}  
			
			catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
			return dest;
			
		}

	
	
	
	
	
}
