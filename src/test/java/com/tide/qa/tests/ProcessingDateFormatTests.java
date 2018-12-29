package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.ProcessingDateFormatPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class ProcessingDateFormatTests extends TestBase {
	
	ProcessingDateFormatPage Dateformat= new ProcessingDateFormatPage();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";

	@Test(priority =373, groups={"TC605_USDateFormatsToUKDateFormat"})
	public void TC605_USDateFormatsToUKDateFormat()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Dateformat.usToUkdate_3984();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC605_USDateFormatsToUKDateFormat"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	}

}
