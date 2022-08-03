package org.tyss.sms.pageRepository;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.tyss.sms.genericUtility.IConnect;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsJavaUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;

public class SmsAdminMyProfile {
	@FindBy(xpath = "//a[@id='btnEdit']")
	private WebElement editUpdateBtn;
	
	@FindBy(xpath = "//input[@id='full_name1']")
	private WebElement fullNameTextField;
	
	@FindBy(xpath = "//input[@id='i_name1']")
	private WebElement nameWithInitialsTextField;
	
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement addressTextField;
	
	
	
	
	@FindBy(id="gender2")
	private WebElement selectGenderDropDown;
	
	@FindBy(xpath = "//input[@id='email1']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id='phone1']")
	private WebElement phoneNumberTextField;
	
	@FindBy(id="user_name1")
	private WebElement userNameTextField; 
	
	@FindBy(xpath = "//input[@id='password1']")
	private WebElement passwordTextField; 
	
	@FindBy(id="btnUpdate")
	private WebElement updateBtn;
	
	@FindBy(xpath = "//input[@id='fileToUpload']")
	private WebElement chooseFileBtn;
	
	public SmsAdminMyProfile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//business logic
	private Sheet sheet;
	public void getGenderDataAndSelectGenderFromExcel(SmsWebDriverUtility smsWebDriverUtility,SmsExcelUtility smsExcelUtility,String data)
	{
	smsWebDriverUtility.mouseHoverOnElement(selectGenderDropDown);
	int count=sheet.getRow(1).getLastCellNum();
	for (int i = 0; i < count; i++) 
	{
		String gender1 = smsExcelUtility.getDataFromExcel("Admin_MyProfile", i, 3);
		String gender2 = smsExcelUtility.getDataFromExcel("Admin_MyProfile", i, 3);
		if(!(gender1.toString().equalsIgnoreCase("male"))) 
		{
			smsWebDriverUtility.handleSelectDropDown(selectGenderDropDown, gender1);
		}
		else
		{
			smsWebDriverUtility.handleSelectDropDown(selectGenderDropDown, gender2);
		}
		
	}
		
	}
	
	public void adminMyProfileUpdate(SmsWebDriverUtility smsWebDriverUtility,SmsExcelUtility smsExcelUtility,String sheetName)
	{
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i < smsExcelUtility.getLastCellDataFromExcel(sheetName, 10); i++) {
			arrayList.add(smsExcelUtility.getDataFromExcel(sheetName, 10, i));
		}
		
		
		
		editUpdateBtn.click();
		fullNameTextField.clear();
		fullNameTextField.sendKeys(arrayList.get(0));
		nameWithInitialsTextField.clear();
		nameWithInitialsTextField.sendKeys(arrayList.get(1));
		addressTextField.clear();
		addressTextField.sendKeys(arrayList.get(2));
		smsWebDriverUtility.handleSelectDropDown(selectGenderDropDown, arrayList.get(3));
		phoneNumberTextField.clear();
		phoneNumberTextField.sendKeys(arrayList.get(5));
		chooseFileBtn.sendKeys(IConnect.ABSOLUTPATHPROJECT+arrayList.get(6));
		updateBtn.click();
		
	}
}
