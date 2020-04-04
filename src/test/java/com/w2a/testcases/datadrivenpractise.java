package com.w2a.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadrivenpractise {

// declaring the webdriver instance
	WebDriver driver;
	
	@BeforeMethod
// create a method for starting up the browser
	public void setbrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://total-qa.com/selenium/practise-website/");
		 driver.manage().window().maximize();	
	}
	
	
	@DataProvider
	public Iterator<Object[]> getdata()// creating a method to read data from the excel
	{
		ArrayList<Object[]>testdata=Readexcel.getdatafromexcel();		
		return testdata.iterator();
	}
	

	@Test(dataProvider="getdata")
	public void practisewebsite(String Username,String Password) throws InterruptedException// the arguements must be same as that of titles provided in excel

	{
	
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(Username);	
		driver.findElement(By.xpath("//input[@name='pword']")).sendKeys(Password);		
		Thread.sleep(3000);
	}

	

	@AfterMethod
	public void closeapp()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
