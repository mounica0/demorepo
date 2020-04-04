package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;


import com.w2a.base.TestBase;

public class TestUtil extends TestBase
{
	
   public static String Screenshotpath;
   public static String ScreenshotName;
	
	public static void CaptureScreenshot() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println(scrFile);
		Date d = new Date();
		ScreenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println(ScreenshotName);
		//FileUtils.copyFile(scrFile,new File(System.getProperty("C:\\Users\\Admin\\datakeywrdframeworkimplement\\Datadrivenframework\\target\\"+ScreenshotName)));
		System.out.println(("C:\\Users\\Admin\\datakeywrdframeworkimplement\\Datadrivenframework\\target\\")+ScreenshotName);
		System.out.println((System.getProperty("user.dir")+"\\target\\")+ScreenshotName);
		FileUtils.copyFile(scrFile,new File(System.getProperty("user.dir") + "\\test-output\\html\\" + ScreenshotName));
	
	//System.out.println(System.getProperty(("user.dir")+"\\test-output"+ScreenshotName));
	
	
	}
	
	@DataProvider(name="dp")

	public Object[][] getdata(Method m)
	{
		String sheetName=m.getName();
	int rowcount= excel.getRowCount(sheetName);
	int colcount=excel.getColumnCount(sheetName);

	Object [][] data = new Object[rowcount-1][1];
	
Hashtable<String,String> table = null;


	for(int i=2;i<=rowcount;i++)
		
	{

		table = new Hashtable<String,String>();
		for(int j=0;j<colcount;j++)
		{
			table.put(excel.getCellData(sheetName, j, 1), excel.getCellData(sheetName, j, i));
			
			data[i-2][0] = table;
		}
		
		
	}





	return data;
	
		
	}	

	public static boolean isTestRunnable(String testname, ExcelReader excel)
	{
		
		String sheetname="Test_Suite";
		int rows=excel.getRowCount(sheetname);
		for(int rownum=2;rownum<=rows;rownum++)
		{
			
			String testcase = excel.getCellData(sheetname, "TC_id", rownum);
			if(testcase.equalsIgnoreCase(testname))
			{
				String runmode = excel.getCellData(sheetname, "Runmode", rownum);
				if(runmode.equalsIgnoreCase("Y"))
				{
					return true;
				}
			   return false;
			}
			
		}
		return false;
		
	}
	
}




