package org.tyss.sms.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsFileUtility;
import org.tyss.sms.genericUtility.SmsJavaUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;

public class InstanceClass {
	
	public SmsFileUtility smsFileUtility;
	public SmsJavaUtility smsJavaUtility;
	public WebDriver driver;
	public WebDriverWait wait;
	public SmsExcelUtility smsExcelUtility;
	public SmsWebDriverUtility smsWebDriverUtility;
	
	protected String url;
	protected String username;
	protected String password;
	protected String timeouts;
	protected String browser;
	protected long convertStringToLong;
	public SmsLoginPage smsLoginPage;
	public HomePage homePage;
	public int randomNumber;

}
