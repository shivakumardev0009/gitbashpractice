package com.AdminModule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hms.genericUtils.BaseClass;
import objectRepository.AdminDashboardPage;
import objectRepository.Admin_AddDoctorPage;
import objectRepository.Admin_DoctorSpecializationPage;
import objectRepository.DoctorAddPatientPage;
import objectRepository.DoctorDashboardPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class TestngGenericAdminPatientEditTest extends BaseClass
{
	@Test 
	public void TestngAdminPatientEditTest() throws Throwable
	{
		
		String A_USERNAME = fLib.readDataFromPropertyFile("adm_username");
		String A_PASSWORD = fLib.readDataFromPropertyFile("adm_password");
		String D_USERNAME = fLib.readDataFromPropertyFile("doc_username");
		String D_PASSWORD = fLib.readDataFromPropertyFile("doc_password");
		String P_USERNAME = fLib.readDataFromPropertyFile("pat_username");
		String P_PASSWORD = fLib.readDataFromPropertyFile("pat_password");
		String specialization = eLib.readDataFromExcelFile("Doctor",0, 1);

		Admin_DoctorSpecializationPage adsp = new Admin_DoctorSpecializationPage(driver);
		adsp.addDoctorSpecialization(specialization);
		
		String doc_name = eLib.readDataFromExcelFile("Doctor",1, 1);
		String doc_address = eLib.readDataFromExcelFile("Doctor",2, 1);
		String doc_fees = eLib.readDataFromExcelFile("Doctor",3, 1);
		String doc_number = eLib.readDataFromExcelFile("Doctor",4, 1);
		String email = eLib.readDataFromExcelFile("Doctor",5, 1);
		String doc_new_password = eLib.readDataFromExcelFile("Doctor",6, 1);
		String doc_con_password = eLib.readDataFromExcelFile("Doctor",7, 1);

		String doc_email = email+jLib.getRandomNo()+"@gmail.com";
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.AddDoctor();
		
		Admin_AddDoctorPage aadp = new Admin_AddDoctorPage(driver);
		aadp.doctorRegis(specialization, doc_name, doc_address, doc_fees, doc_number, doc_email, doc_new_password, doc_con_password);
	
		LoginPage lp = new LoginPage(driver);
		lp.logoutFromApp();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnLink("doctor");

		lp.loginToApp(D_USERNAME, D_PASSWORD);
		
		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.clickOnAddPatientLink();
		
		String pat_name = eLib.readDataFromExcelFile("Patient", 0, 1);
		String pat_number = eLib.readDataFromExcelFile("Patient", 1, 1);
		String pat_email = eLib.readDataFromExcelFile("Patient", 2, 1);
		String pat_gender = eLib.readDataFromExcelFile("Patient", 3, 1);
		String pat_address = eLib.readDataFromExcelFile("Patient", 4, 1);
		String pat_age = eLib.readDataFromExcelFile("Patient", 5, 1);
		String pat_med_history = eLib.readDataFromExcelFile("Patient", 6, 1);

		DoctorAddPatientPage dapp = new DoctorAddPatientPage(driver);
		dapp.addPatient(pat_name, pat_number, pat_email, pat_gender, pat_address, pat_age, pat_med_history);
		
		ddp.clickOnManagePatientLink();
		
		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[contains(.,'Abc')]/td[7]/a[@href='edit-patient.php?editid=345']")).click();
		String up_pat_age = eLib.readDataFromExcelFile("Patient", 7, 1);
		driver.findElement(By.name("patage")).sendKeys(up_pat_age);
		driver.findElement(By.name("submit")).click();
		System.out.println("--------testcase 3 end to end executed-----------");
	}
}
