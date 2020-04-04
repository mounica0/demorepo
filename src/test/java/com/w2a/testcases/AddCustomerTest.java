package com.w2a.testcases;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Reporter;
import org.testng.SkipException;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {


@Test (dataProviderClass=TestUtil.class,dataProvider="dp")

public void AddCustomerTest(Hashtable <String,String> data) throws InterruptedException
{
	
	if(!data.get("Runmode").equalsIgnoreCase("Y"))
	{
		throw new SkipException(" Skipping the test case as the runmode is no");
	}
	
	driver.findElement(By.xpath(OR.getProperty("bml"))).click();
	driver.findElement(By.cssSelector("button[ng-class='btnClass1']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys(data.get("Firstname"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys(data.get("Lastname"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys(data.get("postcode"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Alert a = wait.until(ExpectedConditions.alertIsPresent());
	a.accept();
	Reporter.log("Customer added successfully");

}








		
	
	


}
