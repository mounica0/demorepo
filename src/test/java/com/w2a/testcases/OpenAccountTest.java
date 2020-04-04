package com.w2a.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase {


	@Test (dataProviderClass=TestUtil.class,dataProvider="dp")
//@Test
public void OpenAccountTest(Hashtable <String,String> data) throws InterruptedException, IOException
{
	if(!TestUtil.isTestRunnable("OpenAccountTest", excel))
	{
		throw new SkipException("skiiping hte test"+"OpenAccounttest"+"as Runmode is NO");
	}
		
		// normal method
	//verifyequals("abc","xyz");
	driver.findElement(By.xpath(OR.getProperty("bml"))).click();
	driver.findElement(By.xpath(OR.getProperty("oa"))).click();
	WebElement cname=driver.findElement(By.xpath(OR.getProperty("cname")));
	cname.click();
	Select sel = new Select(cname);
	sel.selectByVisibleText(data.get("Customer"));
	//sel.selectByIndex(1);
	Thread.sleep(2000);
	WebElement curname=driver.findElement(By.xpath(OR.getProperty("cur")));
	curname.click();
	Select sel1 = new Select(curname);
	sel1.selectByVisibleText(data.get("Currency"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(OR.getProperty("process"))).click();
	Alert a = wait.until(ExpectedConditions.alertIsPresent());
	Thread.sleep(2000);
	a.accept();
	Reporter.log("Account created successfully");
	//Assert.fail("Intentional fail");
	
// Better method
	
		//selectvalue("cname,String Customer);
		
		
}




}
