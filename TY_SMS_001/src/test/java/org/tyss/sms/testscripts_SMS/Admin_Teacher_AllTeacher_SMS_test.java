package org.tyss.sms.testscripts_SMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.sms.genericUtility.IConnect;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsFileUtility;
import org.tyss.sms.genericUtility.SmsJavaUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;
import org.tyss.sms.pageRepository.HomePage;
import org.tyss.sms.pageRepository.SmsAdminAddTeacher;
import org.tyss.sms.pageRepository.SmsAdminAllTeacher;
import org.tyss.sms.pageRepository.SmsLoginPage;

public class Admin_Teacher_AllTeacher_SMS_test {

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
		homePage.getTeacherTab();
		homePage.getAllTeacherTab();
		SmsAdminAllTeacher smsAdminAllTeacher=new SmsAdminAllTeacher(driver);
		String expectedTeacherName = smsExcelUtility.getDataFromExcel("Admin_Teacher_AddTeacher", 9, 2);
		smsAdminAllTeacher.SearchAllTeacher(expectedTeacherName);
		String actualTeacherName = smsAdminAllTeacher.actualName().getText();
		if(actualTeacherName.equals(expectedTeacherName))
		{
			System.out.println("Teacher Name is same as searched teacher name ===> TC is passed");
		}
		
		else
		{
			System.out.println("Teacher Name is not same as searched teacher name ===> TC is Failed");
		}
	
	//	smsAdminAllTeacher.editTeacher();
		String amount = smsExcelUtility.getDataFromExcel("Admin_Teacher_AddTeacher", 10, 8);
		smsAdminAllTeacher.clickAddPayment();
		WebElement addPaymentPopup = driver.findElement(By.xpath("//div[@class='panel-heading bg-aqua-active']"));
		smsWebDriverUtility.waitTillElementVisible(addPaymentPopup);
		smsAdminAllTeacher.addPayment(amount);
		
		smsAdminAllTeacher.viewPayments();


	}

}
