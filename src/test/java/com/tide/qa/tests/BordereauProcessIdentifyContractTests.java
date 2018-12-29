package com.tide.qa.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BordereauProcessIdentifyContractTests extends TestBase {

	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";
	
	@Test(priority =81, groups={"TC627_RecordsinContractdata"})
	public void TC627_RecordsinContractdata()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
		//	login.tideLogin(AdminUsername, AdminPassword);
			sheets.recordsinContract_5308();
			softAssert.assertEquals(sheets.TransformationScreen, "Bordereau Transformation");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets.YOA1, "2018");
			softAssert.assertEquals(sheets.YOA2, "2018");
			softAssert.assertEquals(sheets.YOA3, "2018");
			softAssert.assertEquals(sheets.RF1, "10");
			softAssert.assertEquals(sheets.RF2, "6");
			softAssert.assertEquals(sheets.RF3, "7");
			softAssert.assertEquals(sheets.RF4, "8");
			softAssert.assertEquals(sheets.RF5, "9");
			softAssert.assertEquals(sheets.YO1, "2017");
			softAssert.assertEquals(sheets.YO2, "2017");
			softAssert.assertEquals(sheets.YO3, "2017");
			softAssert.assertEquals(sheets.REF1, "1");
			softAssert.assertEquals(sheets.REF2, "2");
			softAssert.assertEquals(sheets.REF3, "3");
			softAssert.assertEquals(sheets.REF4, "4");
			softAssert.assertEquals(sheets.REF5, "5");
			
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC627_RecordsinContractdata "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
}
