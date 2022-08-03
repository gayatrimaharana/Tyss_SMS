package org.tyss.sms.genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmsWebDriverUtility {
	private WebDriver driver;
	private Actions act;
	private WebDriverWait wait;
	public WebDriver setUpDriver(String browser)
	{
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			System.out.println("The browser is not working");
			break;
		}
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to wait the page by using implicit wait
	 * @param longTimeout
	 */
	public void implicitWait(Long longTimeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	
	public void initializeExplicitWait(long timeouts,long pollingTime) {
		  wait=new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		  wait.pollingEvery(Duration.ofMillis(pollingTime));
		  wait.ignoring(Exception.class);
	  }
	
	/**
	   *This method is used to wait until element is visible 
	   * @param element
	   */
	  public void waitTillElementVisible(WebElement element) {
		  wait.until(ExpectedConditions.visibilityOf(element));
	  }
	  
	
	/**
	 * This method is used to navigate to the application
	 * @param url
	 */
	public void openApplication(String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to initialize the action class
	 */
	public void initializeActions()
	{
	 act = new Actions(driver);
	}
	/**
	 * This method is used to handle mouse hover on element
	 * @param element
	 */
	public void mouseHoverOnElement(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * This method is used to handle <select> tag dropdown by using visible text
	 * @param dropDownElement
	 * @param visibleText
	 */
	public void handleSelectDropDown(WebElement dropDownElement,String visibleText)
	{
		Select select = new Select(dropDownElement);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * This method is used to handle <select> tag dropdown by using value attribute
	 * of the <option> tag
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropDownByValue(String value,WebElement dropDownElement)
	{
		Select select = new Select(dropDownElement);
		select.selectByValue(value);
	}
	/**
	 * This method is used to handle <select> tag dropdown by using index attribute
	 * @param value
	 * @param dropDownElement
	 */
	public void handleSelectDropDown(WebElement dropDownElement,int indexNumber)
	{
		Select select = new Select(dropDownElement);
		select.selectByIndex(indexNumber);
	}
	/**
	 * This method is used to click on the OK button of the Alert popup.
	 */
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to click on the CANCEL button of the Alert popup
	 */
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to capture the alert message
	 * @return
	 */
	public String getTextAlert()
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to switch from parent window to child window 
	 */
	public void switchToWindow()
	{
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh)
		{
		 driver.switchTo().window(wh);
		}
	}
	/**
	 * This method is used to close the particular browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	/**
	 * This method is used to close the particular tab
	 */
	public void closeTab()
	{
		driver.close();
	}


}
