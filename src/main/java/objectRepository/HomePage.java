package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver ;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	//declaration 
	@FindBy (xpath = "//div[@class='text list_1_of_2' and contains(.,'Patients')]/descendant::a") 
	private WebElement patientLink;
	
	@FindBy (xpath = "//div[@class='text list_1_of_2' and contains(.,'Doctors Login')]/descendant::a") 
	private WebElement doctorLink;
	
	@FindBy (xpath = "//div[@class='text list_1_of_2' and contains(.,'Admin Login')]/descendant::a") 
	private WebElement adminLink;
	
	@FindBy (linkText = "Home") 
	private WebElement homeLink;
	
	@FindBy (linkText = "contact") 
	private WebElement contactLink; 
	
	@FindBy (linkText = "Hospital Management system") 
	private WebElement logoLink;
	
	//initialization done in constructor on top
	
	//utilization
	public WebElement getPatientLink() {
		return patientLink;
	}

	public WebElement getDoctorLink() {
		return doctorLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getLogoLink() {
		return logoLink;
	}
	
	// business logic
	/**
	 * clicking on the link which we are pass the argument
	 * @author Dev
	 * @param logintext
	 */
	public void clickOnLink(String logintext)
	{
		if(logintext.equalsIgnoreCase("patient"))
		{
			patientLink.click();
		}
		else if (logintext.equalsIgnoreCase("doctor"))
		{
			doctorLink.click();
		}
		else if (logintext.equalsIgnoreCase("admin"))
		{
			adminLink.click();
		}
		else if (logintext.equalsIgnoreCase("home"))
		{
			homeLink.click();
		}
		else if (logintext.equalsIgnoreCase("contact"))
		{
			contactLink.click();
		}
		else if (logintext.equalsIgnoreCase("logo"))
		{
			System.out.println(doctorLink.getText());
		}
		else
		{
			System.out.println("invalid input");
		}
				
	}
	

	

}
