package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSearchPage 
{
	WebDriver driver;
	
	public DoctorSearchPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}

	// initialization
	@FindBy (name = "searchdata") private WebElement searchDataEdt;
	
	@FindBy (id = "submit") private WebElement searchBtn;
	
	@FindBy (xpath = "//button[.='Add Medical History']") private WebElement addMedicalHistoryBtn;

	// initialization done in constructor on top
	
	// utilization
	public WebElement getSearchDataEdt() 
	{
		return searchDataEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getAddMedicalHistoryBtn() {
		return addMedicalHistoryBtn;
	}

	// Business logics
	public void searchPatient(String nameOrNumber)
	{
		searchDataEdt.sendKeys(nameOrNumber);
		searchBtn.click();
	}
	  
	//Business logic
	public void  clickOnAddMedHistory()
	{
		addMedicalHistoryBtn.click();
	}

}
