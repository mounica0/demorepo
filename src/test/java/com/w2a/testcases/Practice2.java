package com.w2a.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.Key;

public class Practice2 
{

	

	 public static void main(String[] args) throws InterruptedException
	 { 
			boolean  flag ;
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			
		    WebDriver driver = new ChromeDriver();
		   // driver.get("http://demo.guru99.com/test/");
//		driver.findElement(By.xpath("//input[@name='bdaytime']")).click();
//		driver.findElement(By.xpath("//input[@name='bdaytime']")).sendKeys("09301990");
//		driver.findElement(By.xpath("//input[@name='bdaytime']")).sendKeys(Keys.TAB);
//		driver.findElement(By.xpath("//input[@name='bdaytime']")).sendKeys("0103PM") ;  
//		    
//		
		   // driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		    
		    
		  //  class="fl icon-calendar_icon-new icon-return-calendar icon"
		    		
		    		
		   // driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']")).click();
		    
		   // class="k-link k-nav-fast"
//		    	WebElement month= driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']"));
//		    	String vonval= month.getText();
//		    	
//		    	if(vonval.equalsIgnoreCase("March 2020"))
//		    	{
//		    		
//		    	}
//		    
		  //  rb-calendar_return_cal
		    	//id=rb-calendar_return_cal
		    			
		    		//	class="monthTitle"
	 
		    			driver.get("https://www.redbus.in/");
			    driver.manage().window().maximize();
			    driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-return-calendar icon']")).click();
			   
			  //*[@id="rb-calendar_return_cal"]/table/tbody/tr[1]/td[2]
			  //*[@id="rb-calendar_return_cal"]/table/tbody/tr[1]/td[2]
			    WebElement month=driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[1]/td[2]"));
			    String monthval= month.getText();
			    System.out.println(monthval);
			    while(flag=true)
	 { String monthval1 = null;
			    if(monthval.equalsIgnoreCase("Apr 2022"))
			    {  	flag = false;
			    	List<WebElement> dates = driver.findElements(By.xpath("//div[@id='rb-calendar_return_cal']/table//td"));
			    	System.out.println("entering loop");
			    	for(int i= 0; i< dates.size();i++)
			    	{
			    		String date=dates.get(i).getText();
			    		
			    		if(date.equalsIgnoreCase("6"))
						{
	                      dates.get(i).click();
					
						break;
						}
			    	
			         }
			    	
			      }
			    
			    else
		    	{
		    		driver.findElement(By.xpath("//*[@id='rb-calendar_return_cal']/table/tbody/tr[1]/td[3]")).click();
		    		 WebElement month1=driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[1]/td[2]"));
			    monthval1= month1.getText();
		    	}
			   monthval=monthval1;
		}
	
	 } 
}

	
	
	
	

