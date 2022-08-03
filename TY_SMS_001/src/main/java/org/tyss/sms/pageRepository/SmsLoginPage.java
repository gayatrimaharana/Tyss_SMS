package org.tyss.sms.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmsLoginPage {
	@FindBy(xpath="//input[@id='email']")
	private WebElement userTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;
	
	@FindBy(id="btnSubmit")
	private WebElement submitBtn;
	
	public SmsLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//business library/setter method
	public void loginAction(String username, String password)
	{
		userTextField.sendKeys(username);
		passwordTextBox.sendKeys(password);
		submitBtn.click();
	}
	

}
