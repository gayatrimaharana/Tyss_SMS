package org.tyss.sms.pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;

public class SmsAdminAllTeacher {
	@FindBy(xpath = "//select[@class='form-control input-sm']")
	private WebElement selectEntriesDropDown;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td[2]/a")
	private WebElement actualTeacherNameField;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td[2]/following-sibling::td/a[.='Edit']")  
	private WebElement editBtn;
	@FindBy(xpath = "//h4[.='Edit Teacher']")
	private WebElement editTeacherPopup;
	
	@FindBy(xpath = "//input[@id='full_name1']")
	private WebElement fullNameTextField;
	
	@FindBy(xpath = "//input[@id='i_name1']")
	private WebElement nameWithInitialsTextField;
	
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement addressTextField;
	
	
	@FindBy(xpath = "//select[@name='gender']")
	private WebElement genderDropDown;
	
	@FindBy(xpath = "//input[@id='phone1']")
	private WebElement phoneNumberTextField;
	
	@FindBy(xpath = "//input[@id='email1']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id='fileToUpload1']']")
	private WebElement fileUploadBtn;
	
	@FindBy(xpath = "//button[@id='btnSubmit1']")
	private WebElement updateBtn;
	
	@FindBy(xpath = "//h4[contains(text(),'Information')]")
	private WebElement informationPopUp;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td[2]/following-sibling::td/a[.='Delete']")  
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td[2]/following-sibling::td/a[.='Add Salary']")  
	private WebElement addSalaryBtn;
	
	@FindBy(xpath = "//div[@class='panel-heading bg-aqua-active']")
	private WebElement addPaymentPopUp;
	
	@FindBy(xpath = "//button[.='+Add Payment ']")  
	private WebElement addPaymentBtn;
	
	@FindBy(xpath = "//input[@id='amount']")
	private WebElement enterAmountTextField;

	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td[2]/following-sibling::td/a[.='View Payments']")  
	private WebElement viewPaymentsBtn;
	
	@FindBy(xpath = "//h3[contains(text(),' History')]")
	private WebElement salaryHistoryTable;
	
	@FindBy(xpath = "//a[.='Previous']")  
	private WebElement previousBtn;
	
	@FindBy(xpath = "//a[.='Next']")  
	private WebElement nextBtn;
	
	
	public SmsAdminAllTeacher(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Business logic
	public void  SearchAllTeacher(String teacherName)
	{
		searchTextField.sendKeys(teacherName);
		
	}
	public  WebElement actualName()
	{
		return actualTeacherNameField;
	}
	
	public void editTeacher()
	{
		editBtn.click();
		
		updateBtn.click();
		
	}
	public void clickAddPayment()
	{
		addSalaryBtn.click();
	}
	public void addPayment(String amount)
	{
		
		
		
		enterAmountTextField.clear();
		enterAmountTextField.sendKeys(amount);
	}
	public void viewPayments()
	{
		viewPaymentsBtn.click();
	}
	

}
