package com.tide.qa.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class RenewalYNFromTransactionTypeTests extends TestBase {

	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority =370, groups={"TC497_PasswordProtectedFiles"})
	public void TC497_PasswordProtectedFiles()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
		sheets.PasswordProtectedFiles_3773();
	//	softAssert.assertEquals(sheets.Expectedresp,sheets.ErrorRes);
		
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC497_PasswordProtectedFiles"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	}	
}
