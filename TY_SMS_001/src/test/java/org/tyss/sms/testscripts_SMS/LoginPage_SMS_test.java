package org.tyss.sms.testscripts_SMS;

import org.openqa.selenium.WebDriver;
import org.tyss.sms.genericUtility.IConnect;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsFileUtility;
import org.tyss.sms.genericUtility.SmsJavaUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;
import org.tyss.sms.pageRepository.HomePage;
import org.tyss.sms.pageRepository.SmsLoginPage;

public class LoginPage_SMS_test {

	public static void main(String[] args) {
		SmsWebDriverUtility smsWebDriverUtility=new SmsWebDriverUtility();
		SmsExcelUtility smsExcelUtility=new SmsExcelUtility();
		SmsFileUtility smsFileUtility=new SmsFileUtility();
		SmsJavaUtility smsJavaUtility=new SmsJavaUtility();
		
		smsFileUtility.initializePropertiesFile(IConnect.SMSPROPERTYFILEPATH);
		smsExcelUtility.initializeExcelFile(IConnect.SMSEXCELFILEPATH);
		String browser = smsFileUtility.getDataFromPropertyFile("browser");
		String url = smsFileUtility.getDataFromPropertyFile("url");
		String username = smsFileUtility.getDataFromPropertyFile("username");
		String password = smsFileUtility.getDataFromPropertyFile("password");
		String timeouts = smsFileUtility.getDataFromPropertyFile("timeouts");
		
		
		WebDriver driver=smsWebDriverUtility.setUpDriver(browser);
		smsWebDriverUtility.maximizeBrowser();
		
		Long longTimeOut = smsJavaUtility.convertStringToLong(timeouts);
		
		smsWebDriverUtility.implicitWait(longTimeOut);
		
		SmsLoginPage smsLoginPage=new SmsLoginPage(driver);
		
		smsWebDriverUtility.openApplication(url);
		
		smsLoginPage.loginAction(username, password);
		HomePage homePage=new HomePage(driver);
		homePage.getSignOutBtn();
		

	}

}
