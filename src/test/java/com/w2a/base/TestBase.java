package com.w2a.base;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtil;

public class TestBase {

	
public static WebDriver driver;	
	

public static Properties Config=new Properties();
public static Properties OR=new Properties();
public static FileInputStream Fis;
public static Logger log=  Logger.getLogger("devpinoyLogger");
public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\Testdata.xlsx");
public static WebDriverWait wait;
public ExtentReports reo=ExtentManager.getInstance();
public static ExtentTest test;

@BeforeSuite
public void setup() throws FileNotFoundException
{
	if(driver==null)
	{
		
		Fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		try {
			Config.load(Fis);
			log.debug("config file loaed ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		try {
			OR.load(Fis);
			log.debug("OR file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	if(Config.getProperty("browser").equals("Firefox"))
			{
		System.setProperty("WebDriver.gecko.driver", "gecko.exe");
		driver=new FirefoxDriver();
		
}
	
	
	else if(Config.getProperty("browser").equals("Chrome"))
	
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		log.debug("chrome browser launched");
    }	
	driver.get(Config.getProperty("testsiteurl"));
	log.debug("Navigated to : " + Config.getProperty("testsiteurl"));
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("Implicit.wait")),TimeUnit.SECONDS);
	wait = new WebDriverWait(driver,5);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

public static void verifyequals(String expected,String actual) throws IOException
{
	
	try {
		
		Assert.assertEquals(actual, expected);
	}
	
	catch( Throwable t)
	{
		TestUtil.CaptureScreenshot();
		
		Reporter.log("<br>"+"verification failure:"+t.getMessage());
		
	}
	
}

//static WebElement dropdown;
//
//public static void selectvalue(String locator,String value)
//{
//	dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
//	//driver.findElement(By.xpath(locator));
//	
//	Select sel = new Select(dropdown);
//	sel.selectByVisibleText(value);
//			
//}
/*public boolean isElementPresent(By by)
{
	
	
	try
	{log.debug("entered try block");
	System.out.println(by);
		driver.findElement(by);
		
		return true;
	}
	catch(NoSuchElementException e)
	{
		return false;
	}
	

} */

@AfterSuite
public void teardown()
{
	//driver.quit();
	log.debug("execution competed");
	
}








}
