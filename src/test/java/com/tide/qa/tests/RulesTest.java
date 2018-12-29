package com.tide.qa.tests;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class RulesTest  extends TestBase {
	LoginPage login = new LoginPage();
	Rules rule = new Rules();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	String AdminUsername = "priti@systenics.net";
	String AdminPassword = "test1234@";

	@Test(priority =624, groups={"TC480_ApproveBordereauxInSequentialOrder"})
	public void TC480_ApproveBordereauxInSequentialOrder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rule.ApproveBordereauxInSequentialOrder();
			softAssert.assertEquals(rule.AssertBordereauStatusReview,"REVIEW");
			softAssert.assertEquals(rule.AssertBordereauStatusApproved,"APPROVED");
			softAssert.assertEquals(rule.AssertBordereauStatusApproved,"APPROVED");
			softAssert.assertEquals(rule.AssertBordereauStatusApproval,"FOR APPROVAL");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC480_ApproveBordereauxInSequentialOrder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =625, groups={"TC503_LCErrorDueToChangeRIDateInLifecycle"})
	public void TC503_LCErrorDueToChangeRIDateInLifecycle()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rule.LifecycleErrorDueToChangeRiskInceptionDateInLifecycleValidation();
			softAssert.assertEquals(rule.AssertBordereauStatusApproved,"APPROVED");
			softAssert.assertEquals(rule.DeleteBorcereaux,"CANCEL PROCESSING AND DELETE BORDEREAU");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC503_LCErrorDueToChangeRIDateInLifecycle "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =626, groups={"TC504_CompletingLifecycleChecks"})
	public void TC504_CompletingLifecycleChecks()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{		
			rule.RiskAndPremiumRecordsAndCompletingLifecycleChecks();
			softAssert.assertEquals(rule.AssertBordereauStatusApproved,"APPROVED");
			softAssert.assertEquals(rule.NewRenewal,"New or Renewal entries which already exist");
			softAssert.assertEquals(rule.AssertBordereauStatusReview,"REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC504_CompletingLifecycleChecks "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =627, groups={"TC505_RiskInceptionDateInupdatingRiskAndPremiumRecords"})
	public void TC505_RiskInceptionDateInupdatingRiskAndPremiumRecords()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rule.RiskInceptionDateInupdatingRiskAndPremiumRecords_TC3980();
			softAssert.assertEquals(rule.EntryStatusVal1,"Current");
			softAssert.assertEquals(rule.EntryStatusVal2,"Historic");
			softAssert.assertEquals(rule.EntryStatusVal3,"Update");
			softAssert.assertEquals(rule.EntryStatusVal4,"Current");
			softAssert.assertEquals(rule.R1,"2");
			softAssert.assertEquals(rule.R2,"3");
			softAssert.assertEquals(rule.R3,"4");
			softAssert.assertEquals(rule.R4,"4");
			softAssert.assertEquals(rule.AssertBordereauStatusReview,"REVIEW");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC505_RiskInceptionDateInupdatingRiskAndPremiumRecords "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =628, groups={"TC484_BespokeDefault_SingleDefaultValue"})
	public void TC484_BespokeDefault_SingleDefaultValue()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rule.BespokeDefault_SingleDefaultValue_3746();
			softAssert.assertEquals(rule.DefaultValueScree,"Apply Default Value for Location Number Of Buildings");
			softAssert.assertEquals(rule.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(rule.Building1,"10");
			softAssert.assertEquals(rule.Building2,"10");
			softAssert.assertEquals(rule.Building3,"10");
			softAssert.assertEquals(rule.Building4,"10");
			softAssert.assertEquals(rule.Building5,"10");
			softAssert.assertEquals(rule.Building6,"10");
			softAssert.assertEquals(rule.Building7,"10");
			softAssert.assertEquals(rule.Building8,"10");
			softAssert.assertEquals(rule.Building9,"10");
			softAssert.assertEquals(rule.Building10,"10");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC484_BespokeDefault_SingleDefaultValue "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =38, groups={"TC674_AddComplianceDataRule"})
	public void TC674_AddComplianceDataRule()
	{
		SoftAssert softAssert = new SoftAssert();	
		try
		{
			
			rule.AddComplianceDataRule();
			softAssert.assertNotNull(rule.ActualAddedRuleName);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC674_AddComplianceDataRule "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =39, groups={"TC675_EditComplianceDataRule"})

	public void TC675_EditComplianceDataRule()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rule.EditComplianceDataRule();
			softAssert.assertEquals(rule.ActualCOB,"Airline");     // validating edit class of business warning pop up Cancel button functionality.
			
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC675_EditComplianceDataRule "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =40, groups={"TC676_AddNewSchemaRule"})
	public void TC676_AddNewSchemaRule()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rule.AddNewSchemaRule();
			softAssert.assertNotNull(rule.ActualAddedRuleNameSchema);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC676_AddNewSchemaRule "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =41, groups={"TC677_EditSchemaRule"},dependsOnMethods={"TC676_AddNewSchemaRule"})
	public void TC677_EditSchemaRule()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rule.EditSchemaRule();
			softAssert.assertEquals(rule.MandatoryWarning,rule.ActualWarning1);
			softAssert.assertEquals(rule.ApplicationCondition,rule.ActualApplicationCondtion1);  
			softAssert.assertEquals(rule.ActualSchema,rule.ExpectedSchema);     // validating schema edit
			softAssert.assertEquals(rule.Actual_NO_Data_To_Dispaly,rule.Expected_NO_Data_To_Dispaly);  // validating schema edit effect on rule condition
			softAssert.assertEquals(rule.ActualStatus,rule.ExpectedStatus);     // validating status edit
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC677_EditSchemaRule "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =42, groups={"TC783_EditAboutTide"})
	public void TC783_EditAboutTide()
	{
		SoftAssert softAssert = new SoftAssert();
	
		try
		{
			rule.EditAboutTide_3306();
			softAssert.assertEquals(rule.Tide, "About Tide");
			softAssert.assertEquals(rule.SaveChanges, "SAVE CHANGES");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC783_EditAboutTide "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}finally {
		softAssert.assertAll();
	
	}
}
	@Test(priority =68, groups={"TC1052_MultipleRuleConditions"})
	 public void TC1052_MultipleRuleConditions()
	 {
		SoftAssert softAssert = new SoftAssert();
	  try
	  {
	   //login.tideLogin(Admin1Username, Admin1Password);
	   rule.multipleRuleConditions_TC3785();
	   softAssert.assertEquals(rule.AddRuleBtn, "ADD RULE CONDITION");
	   softAssert.assertEquals(rule.Endorsment, "Contract Endorsement");
	   softAssert.assertEquals(rule.AssertBordereauStatusApproved, "APPROVED");
	   softAssert.assertEquals(rule.AssertBordereauStatusApproved, "APPROVED");
	   softAssert.assertEquals(rule.count,6);
	  }catch(Exception e)
	  {
	   Report.LogInfo("Exception", "Exception in TC1052_MultipleRuleConditions "+e.getMessage(), "FAIL");
	   softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}

	 }
	
	@Test(priority = 1179, groups={"TC1053_MultipleRuleConditionsNotValid"})
	 public void TC1053_MultipleRuleConditionsNotValid()
	 {
		SoftAssert softAssert = new SoftAssert();
	  try
	  {
	   //login.tideLogin(Admin1Username, Admin1Password);
	   rule.multipleRuleConditions_TC1053();
	   softAssert.assertEquals(rule.AddRuleBtn, "ADD RULE CONDITION");
	   softAssert.assertEquals(rule.Endorsment, "Contract Endorsement");
	   softAssert.assertEquals(rule.AssertBordereauStatusApproved, "APPROVED");
	   softAssert.assertEquals(rule.count,2);
	  }catch(Exception e)
	  {
	   Report.LogInfo("Exception", "Exception in TC1053_MultipleRuleConditionsNotValid "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}

	 }

	@Test(priority = 653, groups={"TC3635_RiskPremiumMulticonditioncontractruleValid"})
	 public void TC3635_RiskPremiumMulticonditioncontractruleValid()
	 {
		SoftAssert softAssert = new SoftAssert();
	  try
	  {
	   rule.multipleRuleConditions_TC3635();
	   softAssert.assertEquals(rule.AddRuleBtn, "ADD RULE CONDITION");
	   softAssert.assertEquals(rule.Endorsment, "Contract Endorsement");
	   softAssert.assertEquals(rule.AssertBordereauStatusApproved, "APPROVED");
	   softAssert.assertEquals(rule.BreacheCount6, "4");
	   softAssert.assertEquals(rule.count,4);
	   softAssert.assertEquals(rule.ARCHIVED,"ARCHIVED");
	   softAssert.assertEquals(rule.AssertBordereauStatusApproved, "APPROVED");
	   softAssert.assertEquals(rule.BreacheCount0, "0");
	  }catch(Exception e)
	  {
	   Report.LogInfo("Exception", "Exception in TC3635_RiskPremiumMulticonditioncontractruleValid "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
 
	 }
	
	@Test(priority = 654, groups={"TC3647_ClaimBespokerule"})
	 public void TC3647_ClaimBespokerule()
	 {
		SoftAssert softAssert = new SoftAssert();
	  try
	  {
	   rule.ClaimBespokerule_TC3647();
	   softAssert.assertEquals(rule.AddRuleBtn, "ADD RULE CONDITION");
	   softAssert.assertEquals(rule.Endorsment, "Contract Endorsement");
	   softAssert.assertEquals(rule.AssertBordereauStatusApproved, "APPROVED");
	   softAssert.assertEquals(rule.BreacheCount3, "3");
	   softAssert.assertEquals(rule.BreacheCount2, "2");
	   softAssert.assertEquals(rule.count,3);
	   softAssert.assertEquals(rule.count1,2);
	   softAssert.assertEquals(rule.BreachesR1, "10.00");
	   softAssert.assertEquals(rule.BreachesR2, "10.00");
	   softAssert.assertEquals(rule.BreachesR3, "10.00");
	   softAssert.assertEquals(rule.Breaches_R1, "100.00");
	   softAssert.assertEquals(rule.Breaches_R2, "100.00");
	   softAssert.assertEquals(rule.Breaches_R3, "200.00");
	   softAssert.assertEquals(rule.BreachesR5, "20.00");
	   softAssert.assertEquals(rule.BreachesR4, "20.00");
	   
	   
	   
	  }catch(Exception e)
	  {
	   Report.LogInfo("Exception", "Exception in TC3647_Claim-Bespokerule(Valid&NotValid) "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}

	 }
	
	@Test(priority = 655, groups={"TC3649_RiskandPremiumLoactionRule"})
	 public void TC3649_RiskandPremiumLoactionRule()
	 {
		SoftAssert softAssert = new SoftAssert();
	  try
	  {
	   //login.tideLogin(Admin1Username, Admin1Password);
	    rule.RiskandPremiumLoactionRule_3649();
	    softAssert.assertEquals(rule.AcualRiskCountry,4);
		softAssert.assertEquals(rule.AcualRiskState,3);
		softAssert.assertEquals(rule.AcualInsuredCountry,4);
		softAssert.assertEquals(rule.AcualInsuredState,3);
	  }catch(Exception e)
	  {
	   Report.LogInfo("Exception", "Exception in TC3649_RiskandPremiumLoactionRule "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}

	 }
	
}
