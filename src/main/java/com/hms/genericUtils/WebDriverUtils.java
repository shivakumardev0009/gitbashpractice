package com.hms.genericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils 
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	public void refresfPage(WebDriver driver)
	{
		driver.navigate().refresh();
	}

	public void previousPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public void nextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public WebDriverWait webDriverWaitObj(WebDriver driver, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	
	public void waitForElementToBeVisible(WebDriver driver,int sec, WebElement element) 
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver,int sec, WebElement element) 
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForAlertToBePresent(WebDriver driver,int sec) 
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForFrameToBeVisible(WebDriver driver,int sec, int id) 
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}
	
	public void waitForFrameToBeVisible(WebDriver driver,int sec, WebElement element ) 
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public void waitForFrameToBeVisible(WebDriver driver,int sec, String value) 
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(value));
	}
	
	public Select selectObj(WebElement element)
	{
		Select sel = new Select(element);
		return sel;
	}
	
	public void select(WebElement element , int index)
	{
		selectObj(element).selectByIndex(index);
	}

	public void select(WebElement element , String value)
	{
		selectObj(element).selectByValue(value);
	}

	public void select(String text , WebElement element)
	{
		selectObj(element).selectByVisibleText(text);
	}

	public void deSelect(WebElement element , int index)
	{
		selectObj(element).selectByIndex(index);
	}

	public void deSelect(WebElement element , String value)
	{
		selectObj(element).selectByValue(value);
	}

	public void deSelect(String text , WebElement element)
	{
		selectObj(element).selectByVisibleText(text);
	}

	public List<WebElement> getAllOptions(WebElement element)
	{
		List<WebElement> AllOptions = selectObj(element).getOptions();
		return AllOptions;
	}
	
	public List<WebElement> getAllSelectedOptions(WebElement element)
	{
		List<WebElement> SelectedOptions = selectObj(element).getAllSelectedOptions();
		return SelectedOptions;
	}
	
	public WebElement getFirstSelectedOption(WebElement element)
	{
		WebElement FirstSelectedOption = selectObj(element).getFirstSelectedOption();
		return FirstSelectedOption;
	}
	
	public Actions actionObj(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		actionObj(driver).moveToElement(element).perform();
		// actionObj(driver).click(element).perform();
	}
	
	public void dargAndDrop(WebDriver driver, WebElement src, WebElement dst) 
	{
		actionObj(driver).dragAndDrop(src, dst).perform();
	}
	
	public void doubleClickAction(WebDriver driver)
	{
		actionObj(driver).doubleClick().perform();
	}

	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		actionObj(driver).doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		actionObj(driver).contextClick().perform();
	}

	public void rightClick(WebDriver driver, WebElement element)
	{
		actionObj(driver).contextClick(element).perform();
	}

	public void enterKey(WebDriver driver)
	{
		actionObj(driver).sendKeys(Keys.ENTER).perform();
	}

	public Robot robotObj() throws Throwable 
	{
		Robot robot = new Robot();
		return robot;
	}
	
	public void enterKeyPress() throws Throwable
	{
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}

	public void enterKeyRelease() throws Throwable
	{
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//step1:use  window handles to get all window id's
		Set<String> windows = driver.getWindowHandles();
		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();
		//step3: check whether next window
		while(it.hasNext())
		{
			//step4: capture the window id
			String winId = it.next();
			//step5: switch the current window to capture the title
			String currentWindowTitle = driver.switchTo().window(winId).getTitle();
			//step6: check whether current window is expected
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	public static String getScreenShot(WebDriver driver, String ScreenShotName) throws Throwable
	{
		JavaUtils jLib = new JavaUtils();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./FailedScripts/"+ScreenShotName+jLib.getSystemDateInFormat()+".jpeg";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("windows.scrollBy(0,"+y+")", element);
		//js.executeScript("arguments[0].scrollIntoView()", element);
	}
}
