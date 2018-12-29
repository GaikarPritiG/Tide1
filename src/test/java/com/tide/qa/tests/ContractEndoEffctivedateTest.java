package com.tide.qa.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BreachManagmentPage;
import com.tide.qa.pagefactory.ContractEndoEffectiveDatePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class ContractEndoEffctivedateTest  extends TestBase {
	LoginPage login = new LoginPage();

	ContractEndoEffectiveDatePage ConEFD = new ContractEndoEffectiveDatePage();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	
	@Test(priority =72, groups={"TC131_CreateConEffectvdate"})
	public void TC131_CreateConEffectvdate()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(Admin1Username, Admin1Password);
			ConEFD.CreateConEffectvdate_5150();
			 softAssert.assertEquals(ConEFD.AddRuleBtn, "ADD RULE CONDITION");
			 softAssert.assertEquals(ConEFD.AssertBordereauStatusApproved, "APPROVED");
			 softAssert.assertEquals(ConEFD.Edit, "EDIT");
			 softAssert.assertEquals(ConEFD.Save, "SAVE CHANGES");
			 softAssert.assertEquals(ConEFD.RecordCount, "1 - 4 of 4 items");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC131_CreateConEffectvdate "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =73, groups={"TC132_CreateConEffectvdatePastNtIncptnDate"})
	public void TC132_CreateConEffectvdatePastNtIncptnDate()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(Admin1Username, Admin1Password);
			ConEFD.CreateConEffectvdatePastNtIncptnDate_5151();
			softAssert.assertEquals(ConEFD.AddRuleBtn, "ADD RULE CONDITION");
			 softAssert.assertEquals(ConEFD.AssertBordereauStatusApproved, "APPROVED");
			 softAssert.assertEquals(ConEFD.Edit, "EDIT");
			 softAssert.assertEquals(ConEFD.Save, "SAVE CHANGES");
			 softAssert.assertEquals(ConEFD.RecordCount, "1 - 3 of 3 items");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC132_CreateConEffectvdatePastNtIncptnDate "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority =74, groups={"TC134_CreateConEffectvdateEqualsIncptnDate"})
	public void TC134_CreateConEffectvdateEqualsIncptnDate()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(Admin1Username, Admin1Password);
			ConEFD.CreateConEffectvdateEqualsIncptnDate_5152();
			 softAssert.assertEquals(ConEFD.AddRuleBtn, "ADD RULE CONDITION");
			 softAssert.assertEquals(ConEFD.AssertBordereauStatusApproved, "APPROVED");
			 softAssert.assertEquals(ConEFD.Edit, "EDIT");
			 softAssert.assertEquals(ConEFD.Save, "SAVE CHANGES");
			 softAssert.assertEquals(ConEFD.RecordCount, "1 - 3 of 3 items");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC134_CreateConEffectvdateEqualsIncptnDate "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

}
