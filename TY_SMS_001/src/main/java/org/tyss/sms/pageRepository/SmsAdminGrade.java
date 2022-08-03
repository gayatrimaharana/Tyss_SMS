package org.tyss.sms.pageRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.tyss.sms.genericUtility.SmsExcelUtility;
import org.tyss.sms.genericUtility.SmsJavaUtility;
import org.tyss.sms.genericUtility.SmsWebDriverUtility;

public class SmsAdminGrade {
	@FindBy (xpath = "//input[@id='name']")
	private WebElement enterGradeName;
	
	
	@FindBy (xpath = "//input[@id='admission_fee']")
	private WebElement enterAdmissionFee;
	

	@FindBy (id="hall_charge")
	private WebElement enterHallCharge;
	
	@FindBy (xpath = "//button[@id='btnSubmit']")
	private WebElement addGradeNextBtn;
	
	@FindBy (xpath = "")
	private WebElement successfulAddedInformationPopUp; //Write xpath here
	
	@FindBy(xpath = "//select[@class='form-control input-sm']")
	private WebElement selectEntriesDropDown;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//td[@class='sorting_1']/following-sibling::td/a[.='Edit']")
	private WebElement editBtn;
	
	@FindBy(xpath = "//input[@id='name1']")
	private WebElement editGradeTextBox;
	
	@FindBy(xpath = "//input[@id='admission_fee1']")
	private WebElement editGradeAdmissionFee;
	
	@FindBy(id="hall_charge1")
	private WebElement editGradeHallCharge;
	
	@FindBy(xpath = "//button[@class='btn btn-info']")
	private WebElement editGradeUpdateBtn;
	
	@FindBy(xpath = "")  //need to write xpath
	private WebElement gradeInformationUpdatedPopUp ;
	
	@FindBy(xpath = "//td[@class='sorting_1']/following-sibling::td/a[.='View eMark']")
	private WebElement viewEmarkBtn;
	
	@FindBy(xpath = "//h3[.='Add eMarks Range & Grade']")
	private WebElement addEMarksRangeAndGradePopUp;
	
	@FindBy(xpath = "//input[@id='mark_range_text_1']")
	private WebElement rangeTextField;
	
	@FindBy(xpath = "//input[@id='mark_grade_text_1']")
	private WebElement gradeTextField;
	
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-plus']")
	private WebElement plusBtn;
	
	@FindBy(xpath ="//a[@class='btn btn-danger btn-xs pull-right']" )
	private WebElement removeGradeBtn;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submitButtonAddEMarksRangeAndGradePopUp;
	
	@FindBy(xpath = "//td[@class='sorting_1']/following-sibling::td/a[.='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//div[@class='modal-header bg-primary']/h4[.='Delete'and@id='frm_title']")
	private WebElement deletePopUp;
	
	@FindBy(id="btnYes")
	private WebElement deletePopUp_accept;
	
	@FindBy(id="frm_cancel")
	private WebElement deletePopUp_dismiss;
	
	@FindBy(xpath = "//a[.='Previous']")
	private WebElement previousBtn;
	
	@FindBy(xpath = "//a[.='Next']")
	private WebElement nextBtn;
	
	
	public SmsAdminGrade(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	//business logic
	public void addGrade(SmsWebDriverUtility smsWebDriverUtility,SmsExcelUtility smsExcelUtility,SmsJavaUtility smsJavaUtility, String sheetName)
	{
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i <smsExcelUtility.getLastCellDataFromExcel(sheetName, 10); i++) {
			arrayList.add(smsExcelUtility.getDataFromExcel(sheetName, 10, i));
		}
		
		String grade = arrayList.get(0);
		int randomNumber = smsJavaUtility.getRandomNumber();
		String randomNoGrade = grade+randomNumber;
		enterGradeName.sendKeys(randomNoGrade);
		enterAdmissionFee.sendKeys(arrayList.get(1));
		enterHallCharge.sendKeys(arrayList.get(2));
		addGradeNextBtn.click();
	}
	public void showGradeDropDown(SmsWebDriverUtility smsWebDriverUtility)
	{
		smsWebDriverUtility.handleSelectDropDown(selectEntriesDropDown, 1);
		Select select=new Select(selectEntriesDropDown);
		List<WebElement> allOption = select.getOptions();
		for(WebElement option:allOption)
		{
			allOption.iterator().next();
		}
	}
	

}
