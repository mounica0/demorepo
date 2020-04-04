package com.w2a.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 
{

	

	 public static void main(String[] args) throws InterruptedException
	 { 
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		    
		    WebDriver driver = new ChromeDriver();
		    driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
		
		    //Once you got the select object initialised then you can access all the methods of select class. 
		    //Identify the select HTML element:
		    Thread.sleep(5000);
		    driver.manage().window().maximize();
		
		    
		    System.out.println("hello sushi");
		    System.out.println("hello sushi");
//		    WebElement mySelectElement = driver.findElement(By.name("multipleselect[]"));
//		    Select dropdown= new Select(mySelectElement);
//		    //To deselect an option
//		    //the deselect method will throw UnsupportedOperationException if the SELECT does not support multiple selections
//		    dropdown.selectByValue("msagile");
//		    dropdown.selectByValue("msmanual");
//		    Thread.sleep(2000);
//		    dropdown.deselectAll();
		    
		    WebElement downdown= driver.findElement(By.name("dropdown"));
		    Select dropdown=new Select(downdown);
		    dropdown.selectByIndex(3);
		    
		    
		    
		    }
 }
	
	
	
	

