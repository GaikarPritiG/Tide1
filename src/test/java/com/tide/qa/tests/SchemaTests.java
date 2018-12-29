package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.SchemaPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class SchemaTests extends TestBase{

	SchemaPage schema= new SchemaPage();
	LoginPage login = new LoginPage();
	SoftAssert softAssert = new SoftAssert();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority = 46, groups={"TC684_AddRiskSchema"})
	public void TC684_AddRiskSchema()
	{
		try
		{
			
			schema.addRiskSchema_3174();
			softAssert.assertNotNull(schema.RiskSchemaName);
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC684_AddRiskSchema"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 47, groups={"TC685_EditRiskSchema"})
	public void TC685_EditRiskSchema()
	{
		
		try
		{
			schema.editRiskSchema_3175();
			softAssert.assertEquals(schema.ActualClassBussiness, schema.ExpectedClassofBusiness);
			softAssert.assertEquals(schema.ExpectedPublishedDiscription, schema.ActualPublishedDesc);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC685_EditRiskSchema"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 48, groups={"TC686_AddPremiumSchema"})
	public void TC686_AddPremiumSchema()
	{
		try
		{
			schema.addPremiumSchema_3176();
			softAssert.assertNotNull(schema.PremiumSchemaName);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC686_AddPremiumSchema"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}
	
	
	@Test(priority = 49, groups={"TC687_EditpremiumSchema"})
	public void TC687_EditpremiumSchema()
	{
		
		try
		{
			schema.editPremiumSchema_3177();
			softAssert.assertEquals(schema.ActualClassBussiness, schema.ExpectedClassofBusiness);
			softAssert.assertEquals(schema.ExpectedPublishedDiscription, schema.ActualPublishedDesc);
		
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC687_EditpremiumSchema"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 50, groups={"TC688_AddClaimSchema"})
	public void TC688_AddClaimSchema()
	{
		try
		{
			schema.addClaimSchema_3178();
			softAssert.assertNotNull(schema.ClaimSchemaName);
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC688_AddClaimSchema"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}

	}
	
	@Test(priority = 51, groups={"TC689_EditClaimSchema"})

	public void TC689_EditClaimSchema()
	{
		try
		{
			schema.editClaimSchema_3179();
			softAssert.assertEquals(schema.ActualClassBussiness, schema.ExpectedClassofBusiness);
			softAssert.assertEquals(schema.ExpectedPublishedDiscription, schema.ActualPublishedDesc);
		
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC689_EditClaimSchema"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 52, groups={"TC941_MultipleRuleConditionDataNotValid"})
	public void TC941_MultipleRuleConditionDataNotValid()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			schema.multipleRuleConditionDataNotValid_3937();
			softAssert.assertEquals(schema.SavePublish, "SAVE AND PUBLISH");
			softAssert.assertEquals(schema.AddRuleBtn, "ADD RULE CONDITION");
			softAssert.assertEquals(schema.SAVE, "SAVE");
			softAssert.assertEquals(schema.ErrorPageValidate, "Multiple Condition Rule - Method Or .And (Not valid) Error Identified Error");
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC941_MultipleRuleConditionDataNotValid"+e.getMessage(), "FAIL");
			 softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 53, groups={"TC942_MultipleRuleConditionDataIsValid"})
	public void TC942_MultipleRuleConditionDataIsValid()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			schema.multipleRuleConditionDataIsValid_3938();
			softAssert.assertEquals(schema.SavePublish, "SAVE AND PUBLISH");
			softAssert.assertEquals(schema.AddRuleBtn, "ADD RULE CONDITION");
			softAssert.assertEquals(schema.SAVE, "SAVE");
			softAssert.assertEquals(schema.ErrorPageValidate, "Multiple Condition Rule - Method And, Or(Valid) Error Identified Error");
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC942_MultipleRuleConditionDataIsValid"+e.getMessage(), "FAIL");
			 softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 54, groups={"TC943_SingleRuleConditionDataNotValid"})
	public void TC943_SingleRuleConditionDataNotValid()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.singleRuleConditionDataNotValid_3849();
			softAssert.assertEquals(schema.SavePublish, "SAVE AND PUBLISH");
			softAssert.assertEquals(schema.AddRuleBtn, "ADD RULE CONDITION");
			softAssert.assertEquals(schema.SAVE, "SAVE");
			softAssert.assertEquals(schema.ErrorPageValidate1, "Single Rule Condition Not Equal to Operator (Not Valid) Error Identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate2, "Single Rule Condition - Less than or equal to Operator (Not Valid)Error identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate3, "Single Rule Condition - Contains operator(Not valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate4, "Single Rule Condition - Not Between operator(Not valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate5, "Single Rule Condition - Is Blank operator(Not valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate6, "Single Rule Condition - Equal to operator(Not valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate7, "Single Rule Condition - Is Not Blank operator(Not valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate8, "Single Rule Condition - Between operator(Not valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate9, "Single Rule Condition - Greater than operator(Not valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.AssertBordereauStatusReviewError, "REVIEW ERRORS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC943_SingleRuleConditionDataNotValid"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
			
		}
	}
	
	@Test(priority = 55, groups={"TC944_SingleRuleConditionDataIsValid"})
	public void TC944_SingleRuleConditionDataIsValid()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			schema.singleRuleConditionDataIsValid_3850();
			softAssert.assertEquals(schema.SavePublish, "SAVE AND PUBLISH");
			softAssert.assertEquals(schema.AddRuleBtn, "ADD RULE CONDITION");
			softAssert.assertEquals(schema.SAVE, "SAVE");
			softAssert.assertEquals(schema.ErrorPageValidate1, "Single Rule Condition Between Operator (Valid) Error Identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate2, "Single Rule Condition - Contains Operator or (Valid)Error identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate3, "Single Rule Condition - Equal to operator(Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate4, "Single Rule Condition - Not Equal To operator(Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate5, "Single Rule Condition - Is Blank Operator (Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate6, "Single Rule Condition - Greater Than Or Equal to operator(Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate7, "Single Rule Condition - Less than operator(Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate8, "Single Rule Condition - Not Between operator (Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC944_SingleRuleConditionDataIsValid"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 56, groups={"TC1050_ComplianceDataRulesSingleRule"})
	public void TC1050_ComplianceDataRulesSingleRule()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			schema.complianceDataRulesSingleRuleCondition_3789();
			
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1050_ComplianceDataRulesSingleRule"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 57, groups={"TC1051_MultipleRuleConditionMandatory"})
	public void TC1051_MultipleRuleConditionMandatory()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.MultipleRuleConditionMandatory_4080();
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1051_MultipleRuleConditionMandatory"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority = 91, groups={"TC3603_SingleRuleCondition"})
	public void TC3603_SingleRuleCondition()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			
			schema.SingleRuleCondition_3603();
			softAssert.assertEquals(schema.ErrorPageValidate1, "Single Rule Condition Equal to Operator (Valid) Error Identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate2, "Single Rule Condition - Not Equal To Operator(Valid) Error identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate3, "Single Rule Condition - Equal to operator(Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate4, "Single Rule Condition - Risk Expiry date Equal To operator(Valid) Identified error Errors Identified");
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception TC3603_SingleRuleCondition"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority = 92, groups={"TC3648_MultipleRuleCondition"})
	public void TC3648_MultipleRuleCondition()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			
			schema.MultipleRuleCondition_TC3648();
			softAssert.assertEquals(schema.ErrorPageValidate, "Multiple Rule Condition - Equal To, Not Equal To , Is Blank, Contains operator [Valid] Error");
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception TC3648_MultipleRuleCondition"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 93, groups={"TC3654_SingleRuleCondition"})
	public void TC3654_SingleRuleCondition()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			
			schema.SingleRuleCondition_TC3654(); 
			
			softAssert.assertEquals(schema.ErrorPageValidate1, "Single Rule Condition Not Between Operator (Invalid) Error Identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate2, "Single Rule Condition - Is Blank Operator(InValid) Error identified Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate3, "Single Rule Condition - Equal to operator(InValid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate4, "Single Rule Condition - Not Equal To operator(InValid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate5, "Single Rule Condition - Contains Operator (InValid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate6, "Single Rule Condition - Equal to operator(InValid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate7, "Single Rule Condition - Equal to operator(InValid) Identified error Errors Identified");
			softAssert.assertEquals(schema.ErrorPageValidate8, "Single Rule Condition - Less Than Or Equal To operator(InValid) Identified error Errors Identified");
			
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception TC3654_SingleRuleCondition"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority = 94, groups={"TC3660_Hybrid_Top_Rule"})
	public void TC3660_Hybrid_Top_Rule()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			
			schema.Hybrid_Top_Rule_TC3660();
			softAssert.assertEquals(schema.ErrorPageValidate1, "1.Multiple Condition Rule - Method Equal To, Contains (InValid) Error Identified Error Error");
			softAssert.assertEquals(schema.ErrorPageValidate2, "2.Multiple Condition Rule - Method Equal , Greater Than (InValid) Error Identified Error");
			softAssert.assertEquals(schema.ErrorPageValidate3, "Compliance Data Rule - 3.Risk Reference contains 1");
			softAssert.assertEquals(schema.ErrorPageValidate4, "Compliance Data Rule - 4.Risk inception date should be less than 01/06/2018 & Risk Country Equal To British Indian Ocean Territory");
			softAssert.assertEquals(schema.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception TC3660_Hybrid_Top_Rule"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 86, groups={"TC682_CompleteQuestionnairesAgainstSchema"})
	public void TC682_CompleteQuestionnairesAgainstSchema()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			schema.CompleteQuestionnairesAgainstSchema_TC5140();
			softAssert.assertEquals(schema.SavePublish, "SAVE AND PUBLISH");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC682_CompleteQuestionnairesAgainstSchemaWhileNotSupplyingMandatoryFields"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 87, groups={"TC838_ReProcessFileUsingMandatoryFields"})
	public void TC838_ReProcessFileUsingMandatoryFields()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			
			//login.tideLogin(AdminUsername, AdminPassword);
			schema.ReProcessFileUsingMandatoryFields_TC5141();
			softAssert.assertEquals(schema.Reprocess, "SAVE AND REPROCESS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC838_ReProcessFileUsingMandatoryFields"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
}
