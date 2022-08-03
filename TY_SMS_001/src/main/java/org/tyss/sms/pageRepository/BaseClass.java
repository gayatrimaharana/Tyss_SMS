package org.tyss.sms.pageRepository;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.tyss.sms.genericUtility.IConnect;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsFileUtility;
import org.tyss.sms.genericUtility.SmsJavaUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;

public class BaseClass extends InstanceClass {
/*	@BeforeSuite
	public void suiteSetup() {
		 smsWebDriverUtility=new SmsWebDriverUtility();
		 smsExcelUtility=new SmsExcelUtility();
		 smsFileUtility=new SmsFileUtility();
		 smsJavaUtility=new SmsJavaUtility();
		 
		 smsFileUtility.initializePropertiesFile(IConnect.SMSPROPERTYFILEPATH);
		 browser = smsFileUtility.getDataFromPropertyFile("browser");
		 url = smsFileUtility.getDataFromPropertyFile("url");
		 username = smsFileUtility.getDataFromPropertyFile("username");
		 password = smsFileUtility.getDataFromPropertyFile("password");
		 timeouts = smsFileUtility.getDataFromPropertyFile("timeouts");
		 	 
	}  */
	
	@BeforeClass
	public void classSetup() {
		smsWebDriverUtility=new SmsWebDriverUtility();
		 smsExcelUtility=new SmsExcelUtility();
		 smsFileUtility=new SmsFileUtility();
		 smsJavaUtility=new SmsJavaUtility();
		 
		 smsFileUtility.initializePropertiesFile(IConnect.SMSPROPERTYFILEPATH);
		 browser = smsFileUtility.getDataFromPropertyFile("browser");
		 url = smsFileUtility.getDataFromPropertyFile("url");
		 username = smsFileUtility.getDataFromPropertyFile("username");
		 password = smsFileUtility.getDataFromPropertyFile("password");
		 timeouts = smsFileUtility.getDataFromPropertyFile("timeouts");
	
		
		
		
		
		smsWebDriverUtility.setUpDriver(browser);
		smsWebDriverUtility.maximizeBrowser();
		smsWebDriverUtility.implicitWait(convertStringToLong);
		smsWebDriverUtility.openApplication(url);
		
		homePage =new HomePage(driver);
		
	}
	@BeforeMethod
	public void methodSetup()
	{
		randomNumber=smsJavaUtility.getRandomNumber();
		smsLoginPage.loginAction(username, password);
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		//logout action
	}
	
	@AfterClass
	public void classTearDown()
	{
		smsWebDriverUtility.closeBrowser();
	}

}
