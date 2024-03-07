package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// declaration
	@FindBy(className = "dropdown-toggle")
	private WebElement userProfile;
	
	@FindBy(partialLinkText = "Log Out")
	private WebElement logOutBtn;
	
	@FindBy(partialLinkText = "Change Password") private WebElement changePassword;
	
	@FindAll({@FindBy(className = "[class='title']"),@FindBy(linkText = " Dashboard ")})
	private WebElement dashBoardLink;
	
	@FindBy(xpath = "//span[@class='title' and text()=' Doctors ']")
	private WebElement doctorsLink;
	
	@FindBy(xpath = "//span[.=' Users ']/following-sibling::i")
	private WebElement usersLink;
	
	@FindBy(xpath = "//span[.=' Patients ']/following-sibling::i")
	private WebElement patientsLink;
	
	@FindBy(xpath = "//span[.=' Appointment History ' and @class]")
	private WebElement AppointmetnHstryLink;
	
	@FindBy(xpath = "//span[contains(.,'Queries ')]")
	private WebElement contactQueryLink;
	
	@FindBy(xpath = "//span[contains(.,' Doctor Se')]")
	private WebElement docSessionLog;
	
	@FindBy(xpath = "//span[contains(.,'User Se')]")
	private WebElement userSessionLog;
	
	@FindBy(xpath = "//span[contains(.,' Patient Se')]")
	private WebElement patientSearch;
	
	@FindBy(xpath="//span[.=' Doctor Specialization ']")
	private WebElement docSpecliazation;
	
	@FindBy(xpath = "//span[.=' Add Doctor']")
	private WebElement addDoctor;
	
	@FindBy(xpath = "//span[.=' Manage Doctors ']")
	private WebElement manageDoctors;
	
	@FindBy(xpath="//span[.=' Manage Users ']")
	private WebElement manageUsers;
	
	@FindBy(xpath = "//span[.=' Unread Query ']")
	private WebElement unReadQuery;
	
	@FindBy(xpath = "//span[.=' Read Query ']")
	private WebElement readQuery;
	
	@FindBy(xpath = "//span[.='B/w dates reports ']")
	private WebElement reportLinkBWdates;
	
	@FindBy(xpath="//span[.=' Manage Patients ']")
	private WebElement managePatients;
	
	@FindBy(xpath = "//span[.=' Reports ']")
	private WebElement reports;
	
	// initialisation done in constructor on top

	// utilisation
	public WebElement getReports() {
		return reports;
	}
	public WebElement getManagePatients() {
		return managePatients;
	}
	public WebElement getUserProfile() {
		return userProfile;
	}
	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	public WebElement getChangePassword() {
		return changePassword;
	}
	public WebElement getDashBoardLink() {
		return dashBoardLink;
	}
	public WebElement getDoctorsLink() {
		return doctorsLink;
	}
	public WebElement getUsersLink() {
		return usersLink;
	}
	public WebElement getPatientsLink() {
		return patientsLink;
	}
	public WebElement getAppointmetnHstryLink() {
		return AppointmetnHstryLink;
	}
	public WebElement getContactQueryLink() {
		return contactQueryLink;
	}
	public WebElement getDocSessionLog() {
		return docSessionLog;
	}
	public WebElement getUserSessionLog() {
		return userSessionLog;
	}
	public WebElement getPatientSearch() {
		return patientSearch;
	}
	public WebElement getDocSpecliazation() {
		return docSpecliazation;
	}
	public WebElement getAddDoctor() {
		return addDoctor;
	}
	public WebElement getManageDoctors() {
		return manageDoctors;
	}
	public WebElement getManageUsers() {
		return manageUsers;
	}
	public WebElement getUnReadQuery() {
		return unReadQuery;
	}
	public WebElement getReadQuery() {
		return readQuery;
	}
	public WebElement getReportLinkBWdates() {
		return reportLinkBWdates;
	}
	
	// business logics
	public void signOut() {
		getUserProfile().click();
		getLogOutBtn().click();
	}
	public void changePwdLink() {
		getUserProfile().click();
		getChangePassword().click();
	}
	public void doctorSpecialization() {
		getDoctorsLink().click();
		getDocSpecliazation().click();
	}
	public void AddDoctor() {
		doctorsLink.click();
		addDoctor.click();
	}
	public void manageDoctor() {
		getDoctorsLink().click();
		getManageDoctors().click();
	}
	public void manageUser() {
		getUsersLink().click();
		getManageUsers().click();
	}
	public void managePatients() {
		getPatientsLink().click();
		getManagePatients().click();
	}
	public void queries(String readORunReadQuery) {
		
		getContactQueryLink().click();
		if (readORunReadQuery.toLowerCase().contains("unread")) {
			getUnReadQuery().click();
		} else {
			getReadQuery().click();
		}
	}
	public void reports() {
		getReports().click();
		getReportLinkBWdates().click();
	}
	
}
