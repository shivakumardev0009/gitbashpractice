package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_EditProfilePage {
	
	
	public User_EditProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// declaration
	@FindBy(name = "fname")
	private WebElement nameEdt;
	
	@FindBy(name = "address")
	private WebElement addressEdt;
	
	@FindBy(name = "city")
	private WebElement cityEdt;
	
	@FindBy(name = "gender")
	private WebElement genderDD;
	
	@FindBy(name = "uemail")
	private WebElement emailEdt;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;

	// initialisation done in constructor on top

	// utilization
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getNameEdt() {
		return nameEdt;
	}
	public WebElement getAddressEdt() {
		return addressEdt;
	}
	public WebElement getCityEdt() {
		return cityEdt;
	}
	public WebElement getGenderDD() {
		return genderDD;
	}
	public WebElement getEmailEdt() {
		return emailEdt;
		// Business Logic
	}
}
