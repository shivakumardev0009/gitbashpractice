package com.PatientModule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hms.genericUtils.BaseClass;
import objectRepository.AdminDashboardPage;
import objectRepository.DoctorAddPatientPage;
import objectRepository.DoctorDashboardPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class TestngGenericPatientAddTest extends BaseClass
{
	@Test 
	public void TestngPatientAddTest() throws Throwable
	{
		String A_USERNAME = fLib.readDataFromPropertyFile("adm_username");
		String A_PASSWORD = fLib.readDataFromPropertyFile("adm_password");
		String D_USERNAME = fLib.readDataFromPropertyFile("doc_username");
		String D_PASSWORD = fLib.readDataFromPropertyFile("doc_password");
		String P_USERNAME = fLib.readDataFromPropertyFile("pat_username");
		String P_PASSWORD = fLib.readDataFromPropertyFile("pat_password");
		HomePage hp = new HomePage(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.logoutFromApp();
		hp.clickOnLink("doctor");
		lp.loginToApp(D_USERNAME, D_PASSWORD);
		
		String pat_name = eLib.readDataFromExcelFile("Patient", 0, 1);
		String pat_number = eLib.readDataFromExcelFile("Patient", 1, 1);
		String email = eLib.readDataFromExcelFile("Patient", 2, 1);
		String pat_email = email+jLib.getRandomNo()+"@gmail.com";
		String pat_gender = eLib.readDataFromExcelFile("Patient", 3, 1);
		String pat_address = eLib.readDataFromExcelFile("Patient", 4, 1);
		String pat_age = eLib.readDataFromExcelFile("Patient", 5, 1);
		String pat_med_history = eLib.readDataFromExcelFile("Patient", 6, 1);

		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.clickOnAddPatientLink();
		
		DoctorAddPatientPage dapp = new DoctorAddPatientPage(driver);
		dapp.addPatient(pat_name, pat_number, pat_email, pat_gender, pat_address, pat_age, pat_med_history);
		
		lp.logoutFromApp();
		
		hp.clickOnLink("admin");
		
		lp.loginToApp(A_USERNAME, A_PASSWORD);		
		
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.managePatients();
		String patient_name = driver.findElement(By.xpath("//table[@id='sample-table-1']/tbody/tr[contains(.,'Abc')]/td[2]")).getText();
		if(pat_name.equalsIgnoreCase(patient_name))
		{
			System.out.println("patient details are displayed ");
		}
		
		System.out.println("--------testcase 5 end to end executed-----------");
	}
}
