package org.tyss.sms.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmsLogOut {
	@FindBy(xpath="//span[@class='hidden-xs']")
	private WebElement profilImage;
	
	
	@FindBy(xpath="//a[.='Sign out']")
	private WebElement signOutBtn;
	
	@FindBy(xpath="//a[.='Profile']")
	private WebElement profileBtn;
	
	
	@FindBy(xpath="//span[@class='label label-warning']")
	private WebElement notificationDropDown;
	
	
	@FindBy(xpath="//li[@id='friend_request']")
	private WebElement friendRequestDropDown;
	
	@FindBy(xpath="//li[@id='unread_msg']")
	private WebElement messageDropDown;
	
	public SmsLogOut(WebDriver driver)
	{
		profilImage.click();
		signOutBtn.click();
	}
	

}
