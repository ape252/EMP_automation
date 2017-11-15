package com.framework.genericsUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class TestngListener implements ITestListener{
	
	@Override
	public void onFinish(ITestContext arg0) {
	
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test case fail "+ result.getName(),true);
		TakeScreenshot.getScreenshot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test case skipped "+result.getName(),true );
		TakeScreenshot.getScreenshot(result.getName());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
	
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		
	}

}
