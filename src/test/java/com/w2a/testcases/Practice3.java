package com.w2a.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.Key;

public class Practice3 
{

	

	 public static void main(String[] args) throws InterruptedException
	 { 
			boolean  flag ;
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			
		    WebDriver driver = new ChromeDriver();
		   driver.get("http://carwale.com");
driver.manage().window().maximize();

JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,3000)");
	 } 
}

	
	
	
	

