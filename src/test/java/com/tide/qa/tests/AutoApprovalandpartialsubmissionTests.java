package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.ApprovalAutoApprovalandpartialsubmissionPage;
//import com.tide.qa.pagefactory.ContractMetadataPage;
import com.tide.qa.pagefactory.DashBoardPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class AutoApprovalandpartialsubmissionTests extends TestBase {
	
	ApprovalAutoApprovalandpartialsubmissionPage Apprvl = new ApprovalAutoApprovalandpartialsubmissionPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	SoftAssert softAssert = new SoftAssert();
	PolicyPage policy = new PolicyPage();
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	
	@Test(priority = 63, groups={"TC387_LetTideSelctQue"})
	public void TC387_LetTideSelctQue()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Apprvl.LetTideSelctQue_4756();
			softAssert.assertEquals(Apprvl.AssertBordereauStatusUploaded, "UPLOADED");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC387_LetTideSelctQue"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 64, groups={"TC386_PatialSubResolvError"})
	public void TC386_PatialSubResolvError()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Apprvl.PatialSubResolvError_4755();
			softAssert.assertEquals(Apprvl.NewandRenewalEntriesErrorScreen, "New or Renewal entries which already exist");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4755_PatialSubResolvError"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority = 65, groups={"TC385_PatialSubDisscardError"})
	public void TC385_PatialSubDisscardError()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Apprvl.PatialSubDisscardError_4754();
			//softAssert.assertEquals(Apprvl.NewandRenewalEntriesErrorScreen, "New or Renewal entries which already exist");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC385_PatialSubDisscardError"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority = 389, groups={"TC4721_AutoApprvl"})
	public void TC4721_AutoApprvl()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername1, AdminPassword1);
			Apprvl.AutoApprvl_4721();
			softAssert.assertEquals(Apprvl.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(Apprvl.AssertBordereauStatusApproved, "APPROVED");
			softAssert.assertEquals(Apprvl.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(Apprvl.AssertBordereauStatusApproved, "APPROVED");
			softAssert.assertEquals(Apprvl.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(Apprvl.AssertBordereauStatusApproved, "APPROVED");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4721_AutoApprvl"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 390, groups={"TC4720_ApprvlMultplConSameCon"})
	public void TC4720_ApprvlMultplConSameCon()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername1, AdminPassword1);
			Apprvl.ApprvlMultplConSameCon_4720();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4720_ApprvlMultplConSameCon"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

}
