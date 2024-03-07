package com.PatientModule;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.genericUtils.BaseClass;

import objectRepository.AddMedicalHistoryPage;
import objectRepository.AdminDashboardPage;
import objectRepository.Admin_AddDoctorPage;
import objectRepository.Admin_DoctorSpecializationPage;
import objectRepository.DoctorAddPatientPage;
import objectRepository.DoctorDashboardPage;
import objectRepository.DoctorSearchPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Testng3ScriptsTest extends BaseClass{
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
		
		Assert.fail();
		
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
	
	@Test
	void TestngAdminDashboardTest() throws Throwable
	{
		String A_USERNAME = fLib.readDataFromPropertyFile("adm_username");
		String A_PASSWORD = fLib.readDataFromPropertyFile("adm_password");
		String D_USERNAME = fLib.readDataFromPropertyFile("doc_username");
		String D_PASSWORD = fLib.readDataFromPropertyFile("doc_password");
		String P_USERNAME = fLib.readDataFromPropertyFile("pat_username");
		String P_PASSWORD = fLib.readDataFromPropertyFile("pat_password");
		
		// login into application
		HomePage hp = new HomePage(driver);		
		LoginPage lp = new LoginPage(driver);
	
		String expected_result = "PATIENTS | APPOINTMENT HISTORY";
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.getAppointmetnHstryLink().click();
		
		adp.manageUser();
		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[1]/td[last()]")).click();
		try
		{
			wLib.acceptAlert(driver);

		}
		catch (Exception e) {
			
		}
		
		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getDashboardLink().click();
		driver.findElement(By.xpath("//a[contains(.,'Total Doctors')]")).click();
		
		driver.findElement(By.xpath("//table/tbody/tr/td/descendant::a[@href='edit-doctor.php?id=377']")).click();
		String docfees = eLib.readDataFromExcelFile("Doctor", 9, 1);
		driver.findElement(By.name("docfees")).sendKeys(docfees);
		driver.findElement(By.name("submit")).click();

		ddp.getDashboardLink().click();
		ddp.getAppointmentHistoryLink().click();
		String text = driver.findElement(By.xpath("//h1[.='Patients  | Appointment History']")).getText();
		if (text.equalsIgnoreCase(expected_result))
			{
				System.out.println(expected_result+" Page is displayed: Testcase is Pass ");
			}
		else
			{
				System.out.println(expected_result+" Page is not displayed: Testcase is fail ");
			}
		System.out.println("--------testcase 2 end to end executed-----------");
	}
	
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
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.doctorSpecialization();
		
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
//		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.AddDoctor();
		
		Admin_AddDoctorPage aadp = new Admin_AddDoctorPage(driver);
		aadp.doctorRegis(specialization, doc_name, doc_address, doc_fees, doc_number, doc_email, doc_new_password, doc_con_password);
		wLib.acceptAlert(driver);
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
		
//		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[contains(.,'Abc')]/td[7]/a[@href='edit-patient.php?editid=345']")).click();
//		String up_pat_age = eLib.readDataFromExcelFile("Patient", 7, 1);
//		driver.findElement(By.name("patage")).sendKeys(up_pat_age);
//		driver.findElement(By.name("submit")).click();
		System.out.println("--------testcase 3 end to end executed-----------");
	}

}
