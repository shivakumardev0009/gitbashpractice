package com.hms.genericUtils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SampleBaseclass {
	@BeforeSuite
	public void sync_BS()
	{
		System.out.println("BS--- Connect to the database--");
	}
	@BeforeTest
	public void sync_BT()
	{
		System.out.println("BT--- Parallel execution starts--");
	}
	@BeforeClass
	public void sync_BC()
	{
		System.out.println("BC--- Launching the browser--");
	}
	@BeforeMethod
	public void sync_BM()
	{
		System.out.println("BM--- Login to application--");
	}
	@AfterMethod
	public void sync_AM()
	{
		System.out.println("AM--- Logout from the application--");
	}
	@AfterClass
	public void sync_AC()
	{
		System.out.println("AC--- Close the browser--");
	}
	@AfterTest
	public void sync_AT()
	{
		System.out.println("AT--- Parallel execution ends--");
	}
	@AfterSuite
	public void sync_AS()
	{
		System.out.println("AS--- Disconnect from the Database--");
	}

}
