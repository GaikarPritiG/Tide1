package com.tide.qa.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BreachManagmentPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BreachmanagmentTest  extends TestBase {
	LoginPage login = new LoginPage();

	BreachManagmentPage BrchMngnt = new BreachManagmentPage();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	String AdminUsername = "priti@systenics.net";
	String AdminPassword = "test1234@";

	@Test(priority =69, groups={"TC136_NoChangeToExistngBreach"})
	public void TC136_NoChangeToExistngBreach()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			BrchMngnt.NoChangeToExistngBreach_5127();
			 softAssert.assertEquals(BrchMngnt.AddRuleBtn, "ADD RULE CONDITION");
			 softAssert.assertEquals(BrchMngnt.AssertBordereauStatusApproved, "APPROVED");
			 softAssert.assertEquals(BrchMngnt.RF3, "3");
			 softAssert.assertEquals(BrchMngnt.Edit, "EDIT");
			 softAssert.assertEquals(BrchMngnt.RF3, "3");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC136_NoChangeToExistngBreach "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =70, groups={"TC137_UpdateToExistngBreach"})
	public void TC137_UpdateToExistngBreach()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(Admin1Username, Admin1Password);
			BrchMngnt.UpdateToExistngBreach_5128();
			 softAssert.assertEquals(BrchMngnt.AddRuleBtn, "ADD RULE CONDITION");
			 softAssert.assertEquals(BrchMngnt.AssertBordereauStatusApproved, "APPROVED");
			 softAssert.assertEquals(BrchMngnt.RF3, "3");
			 softAssert.assertEquals(BrchMngnt.RF2, "2");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC137_UpdateToExistngBreach "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	
	@Test(priority =71, groups={"TC138_AchiveOfPreviousBreach"})
	public void TC138_AchiveOfPreviousBreach()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(Admin1Username, Admin1Password);
			BrchMngnt.AchiveOfPreviousBreach_5129();
			 softAssert.assertEquals(BrchMngnt.AddRuleBtn, "ADD RULE CONDITION");
			 softAssert.assertEquals(BrchMngnt.AssertBordereauStatusApproved, "APPROVED");
			 softAssert.assertEquals(BrchMngnt.RF3, "3");
			 softAssert.assertEquals(BrchMngnt.BC1, "1 - 3 of 3 items");
			 softAssert.assertEquals(BrchMngnt.RF3, "3");
			 softAssert.assertEquals(BrchMngnt.RF2, "2");
			 softAssert.assertEquals(BrchMngnt.RF1, "1");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC138_AchiveOfPreviousBreach "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
}
