package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webtablepractice
{

WebDriver driver;
	
	@BeforeMethod
// create a method for starting up the browser
	public void setbrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
		 driver.manage().window().maximize();	
	}
	
	@Test
	
	public void table()
	{
		int rowcnt = driver.findElements(By.xpath(" //*[@id=\"myTable\"]/tr")).size();
		int colcnt = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tr[1]/*")).size();
System.out.println(rowcnt);
System.out.println(colcnt);	
WebElement ele =driver.findElement(By.xpath("//*[@id=\"myTable\"]/tr[1]/td[4]"));
ele.click();

	for(int i= 1;i< rowcnt ; i++)
		{
		for(int j=1;j<colcnt;j++)
		{
			//*[@id="myTable"]/tr[1]
			
			String elementval=driver.findElement(By.xpath("//*[@id=\"myTable\"]/tr[" + i + "]/td[" + j + "]")).getText();
		System.out.println(elementval);
		}
		
		
		}
			
	
	
	
	}
	
}
