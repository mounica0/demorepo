package com.w2a.testcases;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class BankManagerLoginTest extends TestBase 
{
	@Test
	public void LoginManagerTest()
	{
		
		if(!TestUtil.isTestRunnable("LoginManagerTest", excel))
		{
			throw new SkipException("skiiping hte test"+"LoginManagerTest"+"as Runmode is NO");
		}
	
		driver.findElement(By.xpath(OR.getProperty("bml"))).click();
		//System.out.println(OR.getProperty("addCustBtn_CSS"));
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Protractor practice website - Banking App","Login successful");
		//Assert.assertEquals(title, "Protra3ctor practice website - Banking App", "baboye");
		//Assert.assert(driver.findElement(By.cssSelector("button[ng-click='addCust()']")).isDisplayed(),"Login not successful");
		//isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS")));
		// By.cssSelector("button[ng-class='btnClass1']")
		//OR.getProperty("bml")	
		//Assert.fail();
		Reporter.log("task completed");
		
	}
	
	
	
	
	
	
	

}
