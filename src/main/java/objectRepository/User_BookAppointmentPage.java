package objectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericUtils.WebDriverUtils;

public class User_BookAppointmentPage extends WebDriverUtils {
	WebDriver driver;

	public User_BookAppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	@FindBy(name = "Doctorspecialization")
	private WebElement docSpecDD;
	@FindBy(id = "doctor")
	private WebElement docNameDD;
	@FindBy(id = "fees")
	private WebElement feesDD;
	@FindBy(name = "appdate")
	private WebElement date;
	@FindBy(id = "timepicker1")
	private WebElement time;
	@FindBy(name = "submit")
	private WebElement submitBtn;

	public WebElement getDocSpecDD() {
		return docSpecDD;
	}

	public WebElement getDocNameDD() {
		return docNameDD;
	}

	public WebElement getFeesDD() {
		return feesDD;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getTime() {
		return time;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void bookAppointment(String docSpec, String docName, String dateFormat, String timeformat) {
		select(getDocSpecDD(), docSpec);
		select(getDocNameDD(), docName);
		getDate().sendKeys(dateFormat);
		getTime().sendKeys(timeformat);
		getSubmitBtn().click();
		try {
			acceptAlert(driver);
			//System.out.println(alert.getText());
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

}
