package com.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.genericUtils.ExcelUtils;
import com.hms.genericUtils.FileUtils;
import com.hms.genericUtils.JavaUtils;
import com.hms.genericUtils.WebDriverUtils;

import objectRepository.Admin_AddDoctorPage;
import objectRepository.DoctorAddPatientPage;
import objectRepository.DoctorDashboardPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class AdminAddDoctor1Test {
	
	@Test(dataProvider = "getDataDP")
	public void AddPatient(String pname, String pno, String email, String gender, String address, String age, String medhistory) throws Throwable
	{
		ExcelUtils eLib = new ExcelUtils();
		FileUtils fLib = new FileUtils();
		JavaUtils jLib = new JavaUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		String URL = fLib.readDataFromPropertyFile("url");
		String D_USERNAME = fLib.readDataFromPropertyFile("doc_username");
		String D_PASSWORD = fLib.readDataFromPropertyFile("doc_password");
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 20);
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		hp.clickOnLink("doctor");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(D_USERNAME, D_PASSWORD);
		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.clickOnAddPatientLink();
		DoctorAddPatientPage dapp = new DoctorAddPatientPage(driver);
		String pat_email = email+jLib.getRandomNo()+"@ gmail.com";
		dapp.addPatient(pname, pno, pat_email, gender, address, age, medhistory);
	}
	@DataProvider 
	public Object[][] getDataDP() throws Throwable
	{
		ExcelUtils eLib = new ExcelUtils();
		Object[][] value = eLib.genricExcelDP("PatientReg");
		return value;
	}
}
