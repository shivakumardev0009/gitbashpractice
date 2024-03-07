package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericUtils.WebDriverUtils;

public class AddMedicalHistoryPage extends WebDriverUtils {
	WebDriver driver;
	
	public AddMedicalHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "bp") private WebElement bloodPressureEdt;
	
	@FindBy(name = "bs") private WebElement bloodSugarEdt;
	
	@FindBy(name = "weight") private WebElement weightEdt;
	
	@FindBy(name = "temp") private WebElement temperatureEdt;
	
	@FindBy(name = "pres") private WebElement prescriptioEdt;
	
	@FindBy(name = "submit") private WebElement submitBtn;
	
	@FindBy(css = "[class='close']") private WebElement closeBtn;

	public WebElement getBloodPressureEdt() {
		return bloodPressureEdt;
	}

	public WebElement getBloodSugarEdt() {
		return bloodSugarEdt;
	}

	public WebElement getWeightEdt() {
		return weightEdt;
	}

	public WebElement getTemperatureEdt() {
		return temperatureEdt;
	}

	public WebElement getPrescriptioEdt() {
		return prescriptioEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}
	
	// business logic
	public void addMedicalHistory(String bp, String bs, String wt, String temp, String pres)
	{
		bloodPressureEdt.sendKeys(bp);
		bloodSugarEdt.sendKeys(bs);
		weightEdt.sendKeys(wt);
		temperatureEdt.sendKeys(temp);
		prescriptioEdt.sendKeys(pres);
		submitBtn.submit();
		//acceptAlert(driver);
	}
	

}
