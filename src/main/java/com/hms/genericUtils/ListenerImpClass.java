package com.hms.genericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"------> Test Script Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"------> PASSED");
		Reporter.log(methodName+"------> Test Script Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		try {
			String screenShot = WebDriverUtils.getScreenShot(BaseClass.driver, methodName);
			test.log(Status.FAIL, methodName+"------> TestScript Failed");
			test.log(Status.FAIL,result.getThrowable());
			Reporter.log(methodName+"------> FAILED");
			test.addScreenCaptureFromPath(screenShot);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"------> Test Script Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(methodName+"------> SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		// configure the page
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Hospital Management Systems");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("HMS");
		
		//Attatch report
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		 
		 // set system information
		 report.setSystemInfo("Base Platform", "Windows 10");
		 report.setSystemInfo("Base Browser", "Chrome");
		 report.setSystemInfo("Base url", IpathConstants.DBURL);
		 report.setSystemInfo("Reporter Name", "Dev");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
