package org.tyss.sms.genericUtility;

import java.io.File;
import java.util.Random;

public class SmsJavaUtility {
	public int getRandomNumber()
	{
	return	new Random().nextInt(1000);
	}
	public int getRandomNumberLimit(int limit)
	{
		return new Random().nextInt(limit);
	}
	
	
	public long convertStringToLong(String data)
	{
		return Long.parseLong(data);
	}
	
	
	public void printStatement(String value)
	{
		System.out.println(value);
	}
	public String[] splitString(String value, String stratergy)
	{
	return	value.split(stratergy);
	}
	

}
