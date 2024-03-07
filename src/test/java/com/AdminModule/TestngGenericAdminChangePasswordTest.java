package com.AdminModule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hms.genericUtils.BaseClass;
import objectRepository.AddMedicalHistoryPage;
import objectRepository.DoctorDashboardPage;
import objectRepository.DoctorSearchPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class TestngGenericAdminChangePasswordTest extends BaseClass {
	@Test
	public void TestngAdminChangePasswordTest() throws Throwable
	{
		String A_USERNAME = fLib.readDataFromPropertyFile("adm_username");
		String A_PASSWORD = fLib.readDataFromPropertyFile("adm_password");
		String D_USERNAME = fLib.readDataFromPropertyFile("doc_username");
		String D_PASSWORD = fLib.readDataFromPropertyFile("doc_password");
		String D1_USERNAME = fLib.readDataFromPropertyFile("doc1_username");
		String D1_PASSWORD = fLib.readDataFromPropertyFile("doc1_password");
		String P_USERNAME = fLib.readDataFromPropertyFile("pat_username");
		String P_PASSWORD = fLib.readDataFromPropertyFile("pat_password");
		String A_LINK = fLib.readDataFromPropertyFile("adm_link");
		String D_LINK = fLib.readDataFromPropertyFile("doc_link");
		String P_LINK = fLib.readDataFromPropertyFile("pat_link");

		// get the specific data using excel file
		String cur_password = eLib.readDataFromExcelFile("Doctor", 0, 3);
		String new_password = eLib.readDataFromExcelFile("Doctor", 1, 3);
		String con_password = eLib.readDataFromExcelFile("Doctor", 2, 3);
		
		LoginPage lp = new LoginPage(driver);

		lp.changePassword(cur_password, new_password, con_password);
		
		lp.logoutFromApp();
		HomePage hp = new HomePage(driver);
		hp.clickOnLink("doctor");
		lp.loginToApp(D_USERNAME, D_PASSWORD);
		
		String name = eLib.readDataFromExcelFile("Patient", 0, 1);
		String pat_name = name+jLib.getRandomNo();
		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getSearchLink().click();
		DoctorSearchPage dsp = new DoctorSearchPage(driver);
		dsp.getSearchDataEdt();
		dsp.searchPatient(name);
		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[contains(.,'Abc')]/td[7]/a[@href='view-patient.php?viewid=345']")).click();
		dsp.clickOnAddMedHistory();
		
		String blood_pressure = eLib.readDataFromExcelFile("Patient", 9, 1);
		String blood_sugar = eLib.readDataFromExcelFile("Patient", 10, 1);
		String weight = eLib.readDataFromExcelFile("Patient", 11, 1);
		String body_temperature = eLib.readDataFromExcelFile("Patient", 12, 1);
		String prescription = eLib.readDataFromExcelFile("Patient", 13, 1);	
		
		AddMedicalHistoryPage amhp = new AddMedicalHistoryPage(driver);
		amhp.addMedicalHistory(blood_pressure, blood_sugar, weight, body_temperature, prescription);
		System.out.println("--------testcase 1 end to end executed-----------");
	}


}
