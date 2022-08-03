package org.tyss.sms.pageRepository;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.sms.genericUtility.IConnect;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsJavaUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;

public class SmsAdminAddTeacher {
	@FindBy(xpath = "//input[@id='index_number']" )
	private WebElement indexNumberTextField;
	
	@FindBy(xpath = "//input[@id='full_name']")
	private WebElement fullNameTextField;
	
	@FindBy(xpath = "//input[@id='i_name' and @class='form-control']")
	private WebElement nameWithInitialsTextField;
	
	@FindBy(xpath = "//input[@id='address']")
	private WebElement addressTextField;
	
	@FindBy(xpath ="//select[@name='gender']")
	private WebElement genderDropDown;
	
	@FindBy(xpath ="//input[@id='phone']")
	private WebElement phoneNumberTextField;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id='fileToUpload']")
	private WebElement photoChooseFileBtn;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='modal-content']/div[@class='modal-header bg-primary']/button/following-sibling::h4[contains(text(),'Information')]")
	private WebElement informationAddedpopUp;
	public  SmsAdminAddTeacher(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	
	public void addTeacher(SmsWebDriverUtility smsWebDriverUtility,SmsExcelUtility smsExcelUtility,SmsJavaUtility smsJavaUtility, String sheetName)
	{
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i <smsExcelUtility.getLastCellDataFromExcel(sheetName, 9); i++) {
			arrayList.add(smsExcelUtility.getDataFromExcel(sheetName, 9, i));
		}
	
		String index = arrayList.get(0);
		int randomNumber = smsJavaUtility.getRandomNumber();
		String randomNoIndexNumberTeacher = index+randomNumber;
	
		indexNumberTextField.click();
		indexNumberTextField.sendKeys(randomNoIndexNumberTeacher);
		smsExcelUtility.setDataIntoExcel("Admin_Teacher_AddTeacher", 9, 0, randomNoIndexNumberTeacher);
		fullNameTextField.sendKeys(arrayList.get(1));
		nameWithInitialsTextField.sendKeys(arrayList.get(2));
		addressTextField.sendKeys(arrayList.get(3));
		smsWebDriverUtility.handleSelectDropDown(genderDropDown, arrayList.get(4));
		
	
			phoneNumberTextField.sendKeys(arrayList.get(5));
			String []email = arrayList.get(6).split("@");
			String arrConcatWithRandomNo=email[0]+randomNumber;
			String randomNoEmail_Teacher=arrConcatWithRandomNo.concat("@"+email[1]);
	
			emailTextField.sendKeys(randomNoEmail_Teacher);
			smsExcelUtility.setDataIntoExcel("Admin_Teacher_AddTeacher", 9, 6, randomNoEmail_Teacher);
			photoChooseFileBtn.sendKeys(IConnect.ABSOLUTPATHPROJECT+arrayList.get(7));
			submitBtn.click();
		}
		
		
	}
	
	


