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

public class Dataproviderpractice 
{
	WebDriver driver;

@BeforeMethod 
public void setup()
	{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
 driver=new ChromeDriver();
	driver.get("https://total-qa.com/selenium/practise-website/");
	driver.manage().window().maximize();
	}

@DataProvider

public Iterator<Object[]> getdata()
{
	ArrayList<Object[]> al=Excelreader.readdatafromexcel();
	
	return al.iterator();
}

@Test(dataProvider="getdata")

public void login(String Username,String Password) throws InterruptedException
{
	driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(Username);	
	driver.findElement(By.xpath("//input[@name='pword']")).sendKeys(Password);	
	Thread.sleep(4000);
	
}




}
