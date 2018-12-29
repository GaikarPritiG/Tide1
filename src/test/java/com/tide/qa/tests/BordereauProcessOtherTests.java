package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BordereauProcessOtherTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority =335, groups={"TC253_AddInvalidInceptionDateField"})
	public void TC253_AddInvalidInceptionDateField()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.addInvalidInceptionDataFiled_3210();
			softAssert.assertEquals(sheets.ExpectedErrorMsgRiskInceptionDate,sheets.AcualErrorMsg);
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC253_AddInvalidInceptionDateField"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
		}
	
	@Test(priority =336, groups={"TC340_InvalidTransactionTypeError"})
	public void TC340_InvalidTransactionTypeError()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.invalidTransactionTypeError_3216();
			softAssert.assertEquals(sheets.AssertBordereauStatusReviewError, "REVIEW ERRORS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC340_InvalidTransactionTypeError"+e.getMessage(), "FAIL");
		    softAssert.fail(e.getMessage());
	}finally {
		softAssert.assertAll();
	
	}
		}
	
	@Test(priority =337, groups={"TC254_YOAError"})
	public void TC254_YOAError()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.yoaError_3244();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC254_YOAError"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =338, groups={"TC257_RiskContractPeriodIdentified"})
	public void TC257_RiskContractPeriodIdentified()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.contractPeriodIdentification_3245();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC257_RiskContractPeriodIdentified "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =339, groups={"TC256_ContractStatusCheck"})
	public void TC256_ContractStatusCheck()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.contractStatusCheck_3523();
				}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC256_ContractStatusCheck "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	@Test(priority =1177, groups={"TC5675_ZeroPassRecord"})
	public void TC5675_ZeroPassRecord()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.ZeroPassRecord_TC5675();
			softAssert.assertEquals(sheets.SkippAllErroBtnScreen,"SKIP ALL ERRORS");
			softAssert.assertEquals(sheets.AssertBordereauStatusReviewError,"REVIEW ERRORS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5675_ZeroPassRecord "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =394, groups={"TC1056_Other_fees_Description"})
	public void TC1056_Other_fees_Description()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.Other_fees_Description_TC1056();
			softAssert.assertEquals(sheets.Result_1056_01,"Unknown");
			softAssert.assertEquals(sheets.Result_1056_02,"Default2");
			softAssert.assertEquals(sheets.Result_1056_03,"Default3");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1056_Other_fees_Description"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority =395, groups={"TC1068_ROE_DefaultSpecifyNotSupplied"})
	public void TC1068_ROE_DefaultSpecifyNotSupplied()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.ROE_TC1068();
			softAssert.assertEquals(sheets.Result_1068_01,"10.00");
			softAssert.assertEquals(sheets.Result_1068_02,"20.00");
			softAssert.assertEquals(sheets.Result_1068_03,"30.00");
			softAssert.assertEquals(sheets.Result_1068_04,"30.00");
			softAssert.assertEquals(sheets.Result_1068_05,"25.00");
			softAssert.assertEquals(sheets.Result_1068_06,"40.00");
			softAssert.assertEquals(sheets.InvalidDecimaValErrorScreen,"Invalid decimal value translation required");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1068_ROE_DefaultSpecifyNotSupplied "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	
	@Test(priority =396, groups={"TC1386_ROE_DefaultSpecifyForAllRecords"})
	public void TC1386_ROE_DefaultSpecifyForAllRecords
()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.ROE_TC1386();
			softAssert.assertEquals(sheets.Result_1386_01,"0.50");
			softAssert.assertEquals(sheets.Result_1386_02,"0.60");
			softAssert.assertEquals(sheets.Result_1386_03,"0.70");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1386_ROE_DefaultSpecifyForAllRecords"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority =95, groups={"TC3798_CompleteNewQuestionnaire"})
	public void TC3798_CompleteNewQuestionnaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CompleteNewQuestionnaire_TC3798();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3798_CompleteNewQuestionnaire"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority =96, groups={"TC3799_Luna_CreateNewQuestionnaire"})
	public void TC3799_Luna_CreateNewQuestionnaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.Luna_CreateNewQuestionnaire_TC3799();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			softAssert.assertEquals(sheets.AssertBordereauStatusUploaded, "UPLOADED");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3799_Luna_CreateNewQuestionnaire"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =1215, groups={"TC4198_ProcessBordereau_SpecialCharacter"})
	public void TC4198_ProcessBordereau_SpecialCharacter()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.ProcessBordereau_SpecialCharacter_TC4198();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4198_ProcessBordereau_SpecialCharacter"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =1216, groups={"TC4199_Questionnaire_Bordereau_SpecialCharacter"})
	public void TC4199_Questionnaire_Bordereau_SpecialCharacter()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.Questionnaire_Bordereau_SpecialCharacter_TC4199();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4199_Questionnaire_Bordereau_SpecialCharacter"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
}
