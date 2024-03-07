package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage 
{
	WebDriver driver;
	
	public DoctorDashboardPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}

	// initialization
	@FindBy (xpath = "Update Profile") private WebElement updateProfileLink;
	
	@FindBy (xpath = "//a[contains(.,'View Appointment History')]") private WebElement viewAppointmenttHistoryLink;
	
	@FindBy (xpath = "//span[.=' Dashboard ']") private WebElement dashboardLink;
	
	@FindBy (xpath = "//span[.=' Appointment History ']") private WebElement appointmentHistoryLink;
	
	@FindBy (xpath = "//span[.=' Patients ']") private WebElement patientsLink;
	
	@FindBy (xpath = "//span[.=' Search ']") private WebElement searchLink;
	
	@FindBy (xpath = "//span[.=' Add Patient']") private WebElement addPatientLink;
	
	@FindBy (xpath = "//span[.=' Manage Patient ']") private WebElement managePatientLink;

	// initialization done in constructor on top
	
	// utilization
	public WebElement getUpdateProfileLink() {
		return updateProfileLink;
	}

	public WebElement getViewAppointmenttHistoryLink() {
		return viewAppointmenttHistoryLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}

	public WebElement getPatientsLink() {
		return patientsLink;
	}

	public WebElement getSearchLink() {
		return searchLink;
	}

	public WebElement getAddPatientLink() {
		return addPatientLink;
	}

	public WebElement getManagePatientLink() {
		return managePatientLink;
	}
	
	// Business logic 
	public void clickOnAddPatientLink()
	{
		patientsLink.click();
		addPatientLink.click();
	}
	public void clickOnManagePatientLink()
	{
		patientsLink.click();
		managePatientLink.click();
	}
	
	
	


}
