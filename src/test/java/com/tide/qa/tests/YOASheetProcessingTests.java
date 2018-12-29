package com.tide.qa.tests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)

public class YOASheetProcessingTests extends TestBase {
	
	
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";

	@Test(priority =621, groups={"TC492_YOASheetProcessing_January"})
	public void TC492_YOASheetProcessing_January()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.yoaSheetProcessing_3754();
			softAssert.assertEquals(sheets.CurrencyScreen,"Premium Currency reference data translation required");
			softAssert.assertEquals(sheets.CurrencyScreen1,"Risk Currency reference data translation required");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC492_YOASheetProcessing_January"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
}
