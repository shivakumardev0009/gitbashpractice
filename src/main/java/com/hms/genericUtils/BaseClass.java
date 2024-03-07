package com.hms.genericUtils;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public ExcelUtils eLib = new ExcelUtils();
	public FileUtils fLib = new FileUtils();
	public JavaUtils jLib = new JavaUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public DatabaseUtils dLib = new DatabaseUtils();
	public static WebDriver driver;
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException
	{
		dLib.connectToDB();
		System.out.println("--connected to database--");
	}
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome")String BROWSER) throws Throwable 
	{//  inside the launchbrowser()
		//just for cross browser testing String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			System.out.println("----Edge Browser is launched----");
			Thread.sleep(10000);	
			}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("----Firefox Browser is launched----");
			Thread.sleep(10000);
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println("----Chrome Browser is launched----");
			Thread.sleep(10000);
		}
		else
		{
			System.out.println("---invalid browser specified---");
		}
		
		// maximize the window or browser
		wLib.maximizeWindow(driver);
		
		// get the url
		driver.get(URL);
		
		// wait for page load
		wLib.waitForPageLoad(driver, 20);
	}
	@BeforeMethod(alwaysRun = true)
	public void LoginToApp() throws Throwable
	{
		String A_USERNAME = fLib.readDataFromPropertyFile("adm_username");	
		String A_PASSWORD = fLib.readDataFromPropertyFile("adm_password");
		// click on admin link
		HomePage hp = new HomePage(driver);
		hp.clickOnLink("admin");
		// login to applicaion
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(A_USERNAME, A_PASSWORD);
		System.out.println("----login to application ----");
	}
	@AfterMethod(alwaysRun = true)
	public void LogoutFromApp()
	{
		LoginPage lp = new LoginPage(driver);
		lp.logoutFromApp();
		System.out.println("--logged out from application-----");
	}
	@AfterClass(alwaysRun = true)
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("---Browser closed---");
	}
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException
	{
		dLib.disconnectDB();
		System.out.println("--- disconnected from database---");
	}
	
}
