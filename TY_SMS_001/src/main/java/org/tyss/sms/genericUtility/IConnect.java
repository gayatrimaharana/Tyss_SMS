package org.tyss.sms.genericUtility;

public interface IConnect {
	String ABSOLUTPATHPROJECT=System.getProperty("user.dir");
	public String SMSPROPERTYFILEPATH=ABSOLUTPATHPROJECT+"./src/test/resources/commonDataSMS.properties";
	public String SMSEXCELFILEPATH=ABSOLUTPATHPROJECT+"./src/test/resources/SMS_ExcelFile_Project.xlsx";
	public String SMSABSOLUTEPATH=ABSOLUTPATHPROJECT+"./src/test/resources/image_Inputs";

}
