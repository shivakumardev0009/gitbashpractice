package com.AdminModule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hms.genericUtils.BaseClass;
import objectRepository.AdminDashboardPage;
import objectRepository.DoctorDashboardPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class TestngGenericAdminDashboardTest extends BaseClass {
	@Test
	public void TestngAdminDashboardTest() throws Throwable
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
		
		wLib.acceptAlert(driver);
		
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
}
