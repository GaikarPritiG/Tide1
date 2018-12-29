package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class FormatFilterTest extends TestBase
{
	BordereauQuePage sheets = new BordereauQuePage();
	//Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	String AdminUsername = "dave.brit@brit.com";
	String AdminPassword = "Test123@";
	
	@Test(priority =622, groups={"TC506_FilterRecrdToRetainRcrd"})
	public void TC506_FilterRecrdToRetainRcrd()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.FilterRecrdToRetainRcrd_3684();
			softAssert.assertEquals(sheets.NoBuildingValue,"10");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC506_FilterRecrdToRetainRcrd"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =623, groups={"TC507_FilterRecrdToDiscardRcrd"})
	public void TC507_FilterRecrdToDiscardRcrd()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.FilterRecrdToDiscardRcrd_3695();
			//softAssert.assertEquals(sheets.RecordOne1,"11");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC507_FilterRecrdToDiscardRcrd"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}	
}
