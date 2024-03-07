package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_DashboardPage {
	
	public User_DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dropdown-toggle")
	private WebElement userProfile;
	
	@FindBy(xpath = "//a[contains(.,'My Profile')]")
	private WebElement myProfileLink;
	
	@FindBy(xpath="//a[contains(.,'Change Password')]")
	private WebElement changePwd;
	
	@FindBy(xpath ="//a[contains(.,'Log Out')]")
	private WebElement logOut;
	
	public WebElement getUserProfile() {
		return userProfile;
	}
	public WebElement getMyProfileLink() {
		return myProfileLink;
	}
	public WebElement getChangePwd() {
		return changePwd;
	}
	public WebElement getLogOut() {
		return logOut;
	}
	
	//Business logics
	public void signOut() {
		getUserProfile().click();
		getLogOut().click();
	}
}
