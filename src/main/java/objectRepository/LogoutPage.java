package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
WebDriver driver;
	
	public LogoutPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}

	// initialization
	@FindBy (className = "dropdown-toggle") private WebElement profileLookUpLink;
	
	@FindBy (xpath = "//a[contains(.,'Change Password')]") private WebElement changePasswordLink;
	
	@FindBy (xpath = "//a[contains(.,'Log Out')]") private WebElement logOutLink;
	
	@FindBy (name = "cpass") private WebElement currentPasswordEdt;
	
	@FindBy (name = "npass") private WebElement newPasswordEdt;
	
	@FindBy (name = "cfpass") private WebElement confirmPasswordEdt;
	
	@FindBy (name = "submit") private WebElement submitBtn;
	
	// initialization done in constructor on top
	
	// utilization
	public WebElement getProfileLookUpLink() {
		return profileLookUpLink;
	}

	public WebElement getChangePasswordLink() {
		return changePasswordLink;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public WebElement getCurrentPasswordEdt() {
		return currentPasswordEdt;
	}

	public WebElement getNewPasswordEdt() {
		return newPasswordEdt;
	}

	public WebElement getConfirmPasswordEdt() {
		return confirmPasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	// Business Logics
	public void changePassword(String curPassword, String newPassword, String conPassword)
	{
		profileLookUpLink.click();
		changePasswordLink.click();
		currentPasswordEdt.sendKeys(curPassword);
		newPasswordEdt.sendKeys(newPassword);
		confirmPasswordEdt.sendKeys(conPassword);
		if(newPassword.equals(conPassword))
		{
			submitBtn.click();
		}
		
	}
	public void logoutApp()
	{
		profileLookUpLink.click();
		logOutLink.click();
	}

}
