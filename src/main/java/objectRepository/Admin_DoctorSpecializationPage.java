package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_DoctorSpecializationPage {

	public Admin_DoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// declaration
	@FindBy(name = "doctorspecilization")
	private WebElement docsplzation;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	// initialisation done in constructor on top
	
	// utilisation
	private WebElement getDocsplzation() {
		return docsplzation;
	}
	private WebElement getSubmitBtn() {
		return submitBtn;
	}

	// Business Logic
	public void addDoctorSpecialization(String doctorDept) {
		getDocsplzation().sendKeys(doctorDept);
		getSubmitBtn().click();
	}
	
	
}
