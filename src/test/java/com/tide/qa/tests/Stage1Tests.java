package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BProcessingRiskPremiumClaimPage;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Stage1Page;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class Stage1Tests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	BProcessingRiskPremiumClaimPage sheets1 = new BProcessingRiskPremiumClaimPage();
	Stage1Page s1= new Stage1Page();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";
	
	@Test(priority = 66, groups={"TC341_AddNewPolicyInstance"})
	public void TC341_AddNewPolicyInstance()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			s1.addNewPolicyInstance();
			softAssert.assertEquals(s1.YearAccount, "Year of Account");
			softAssert.assertEquals(s1.NEXTStep, "NEXT STEP");
			softAssert.assertEquals(s1.AssertBordereauStatusReviewError, "REVIEW ERRORS");
			softAssert.assertEquals(s1.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC341_AddNewPolicyInstance "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 67, groups={"TC342_AddExistingPolicies"})

	public void TC342_AddExistingPolicies()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
		//	login.tideLogin(AdminUsername, AdminPassword);
			s1.addExistingPolicies();
			softAssert.assertEquals(s1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(s1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(s1.YearAccount, "Year of Account");
			softAssert.assertEquals(s1.NEXTStep, "NEXT STEP");
			softAssert.assertEquals(s1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(s1.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC342_AddExistingPolicies "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	

	@Test(priority = 494, groups={"TC3692_Process_Blank_Column_File"})
	public void TC3692_Process_Blank_Column_File()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			sheets1.BlankColumnBordereauProcessingForRisk_3692();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3692_Process_Blank_Column_File "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	
	
	
	
	
}
