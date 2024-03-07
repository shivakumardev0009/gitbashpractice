package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver ;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//declaration 
	@FindBy (name = "username") private WebElement usernameEdt;
	
	@FindBy (name = "password") private WebElement passwordEdt;
	
	@FindBy (name = "submit") private WebElement loginBtn;
	
	@FindBy (id = "Invalid username or password") private WebElement unOrPwdErrorMsg;
	
	@FindBy (id = "username-error") private WebElement unErrorMsg;
	
	@FindBy (id = "password-error") private WebElement pwdErrorMsg;
	
	@FindBy (partialLinkText = "Forgot Password ?") private WebElement forgotPwdLink;
	
	@FindBy (partialLinkText = "Create an account") private WebElement createAccLink;
	
    @FindBy (className = "dropdown-toggle") private WebElement profileLookUpLink;
	
	@FindBy (xpath = "//a[contains(.,'Change Password')]") private WebElement changePasswordLink;
	
	@FindBy (xpath = "//a[contains(.,'Log Out')]") private WebElement logOutLink;
	
	@FindBy (name = "cpass") private WebElement currentPasswordEdt;
	
	@FindBy (name = "npass") private WebElement newPasswordEdt;
	
	@FindBy (name = "cfpass") private WebElement confirmPasswordEdt;
	
	@FindBy (name = "submit") private WebElement submitBtn;

	//initialization done in constructor on top
	
	//utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getUnOrPwdErrorMsg() {
		return unOrPwdErrorMsg;
	}

	public WebElement getUnErrorMsg() {
		return unErrorMsg;
	}

	public WebElement getPwdErrorMsg() {
		return pwdErrorMsg;
	}

	public WebElement getForgotPwdLink() {
		return forgotPwdLink;
	}

	public WebElement getCreateAccLink() {
		return createAccLink;
	}
	
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

	// business logic 
	public void loginToApp(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	public void getErrorMsg() 
	{
		System.out.println(unErrorMsg.getText());
		System.out.println(pwdErrorMsg.getText());
		System.out.println(unOrPwdErrorMsg.getText());
	}
	
	public void createAnAccount()
	{
		createAccLink.click();
	}
	
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
	public void logoutFromApp()
	{
		profileLookUpLink.click();
		logOutLink.click();
	}


}
