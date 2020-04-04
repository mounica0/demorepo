package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class Customlistener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test=reo.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		reo.endTest(test);
		reo.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"failed");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.ScreenshotName));
	
		Reporter.log("Capturing Screenshot");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.ScreenshotName+">Screenshot</a>");
		reo.endTest(test);
		reo.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		reo.endTest(test);
		reo.flush();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
