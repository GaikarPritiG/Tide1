package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class Stage2Tests extends TestBase
{
	
	BordereauProcessPage sheets = new BordereauProcessPage();
	PolicyPage policyPage = new PolicyPage();
	Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	@Test(priority =14, groups={"TC423_Stage2TransactiontypeSupplied"})

	public void TC423_Stage2TransactiontypeSupplied()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{	
			s2.ErroscreenValTransactiontypSupplied_3541();
			softAssert.assertEquals(s2.NewandRenewalEntriesErrorScreen, "New or Renewal entries which already exist");
			softAssert.assertEquals(s2.EndorsementNothaveEntries, "Endorsement(s) which do not have New or Renewal entries to update");
			softAssert.assertEquals(s2.CancellationNotHavingEntries, "Cancellation(s) which do not have entries to update");
			softAssert.assertEquals(s2.Restatementerror, "Reinstatement(s) which do not have Cancellation entries to update");
			softAssert.assertEquals(s2.InvalidIntegerIdentified, "Invalid integer values identified");
			softAssert.assertEquals(s2.LocationSprinklers, "Location Sprinklers (Y/N) reference data translation required");
			softAssert.assertEquals(s2.InsuredCountryErrorScree, "Insured Country reference data translation required");
			softAssert.assertEquals(s2.RN1, "3");
			softAssert.assertEquals(s2.RN2, "6");
			softAssert.assertEquals(s2.RN3, "8");
			softAssert.assertEquals(s2.RN4, "9");
			softAssert.assertEquals(s2.RN5, "11");
			
			softAssert.assertEquals(s2.ActualDPVCOriginal, "New");
			softAssert.assertEquals(s2.ActualDPVCChanged, "Endorsement");
			softAssert.assertEquals(s2.ActualDPVCRuleName, "A New or Renewal record cannot be received against the same risk more than once.");
			
			softAssert.assertEquals(s2.ActualDPVCOriginal1, "Cancellation");
			softAssert.assertEquals(s2.ActualDPVCChanged1, "New");
			softAssert.assertEquals(s2.ActualDPVCRuleName1, "Cancellation(s) must update an existing risk");
			
			
			softAssert.assertEquals(s2.TT2, "Reinstatement");
			
			softAssert.assertEquals(s2.ActualDPVCOriginal2, "Renewal");
			softAssert.assertEquals(s2.ActualDPVCChanged2, "Endorsement");
			softAssert.assertEquals(s2.ActualDPVCRuleName2, "A New or Renewal record cannot be received against the same risk more than once.");
			
			softAssert.assertEquals(s2.ActualDPVCOriginal3, "Endorsement");
			softAssert.assertEquals(s2.ActualDPVCChanged3, "New");
			softAssert.assertEquals(s2.ActualDPVCRuleName3, "Endorsement(s) must update an existing risk");
			/*Report.LogInfo("ErroScreenCheck", sheets.AssertBordereauStatus, "PASS");	
			softAssert.assertEquals(sheets.AssertBordereauStatus, "REVIEW");*/
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC423_Stage2TransactiontypeSupplied"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
		
	}
	
	@Test(priority =15, groups={"TC424_Stage2TransactionTypeNotSupplied"})
	public void TC424_Stage2TransactionTypeNotSupplied()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			s2.ErroscreenValTransactiontypNotSupplied_3542();
			softAssert.assertEquals(s2.InvalidIntegerIdentified, "Invalid integer values identified");
			softAssert.assertEquals(s2.LocationSprinklers, "Location Sprinklers (Y/N) reference data translation required");
			softAssert.assertEquals(s2.InsuredCountryErrorScree, "Insured Country reference data translation required");
			/*softAssert.assertEquals(sheets.AssertBordereauStatus, "REVIEW");*/
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC424_Stage2TransactionTypeNotSupplied"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		}
	
	@Test(priority = 387, groups={"TC425_MissingEntriesTreatedAsCancellation"})
	public void TC425_MissingEntriesTreatedAsCancellation()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername1, AdminPassword1);
			s2.missingEntriesTreatedAsCancellation_3876();
			softAssert.assertEquals(s2.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(s2.AcualYearOfAccount,7);
			softAssert.assertEquals(s2.AcualEndorsement,2);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC425_MissingEntriesTreatedAsCancellation "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 439, groups={"TC426_ValidateMandatoryReferenceField"})
	public void TC426_ValidateMandatoryReferenceField()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.validateMandatoryReferenceField_3914();
			softAssert.assertEquals(s2.InvalidDate,"Invalid date values identified");
			softAssert.assertEquals(s2.InvalidInterger,"Invalid integer values identified");
			softAssert.assertEquals(s2.ReferenceData,"Location Sprinklers (Y/N) reference data translation required");
			/*softAssert.assertEquals(s2.Country,"Insured Country reference data translation required");
			softAssert.assertEquals(s2.Country1,"Risk Country reference data translation required");*/
			softAssert.assertEquals(s2.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(s2.ExpairyDate, "Risk Expiry Date");
			softAssert.assertEquals(s2.Date, "31/12/2018");
			softAssert.assertEquals(s2.RuleName1, "Validate Date values");
			softAssert.assertEquals(s2.Countrycolumn, "Risk Country");
			softAssert.assertEquals(s2.RuleName2, "Validate reference data values");
			softAssert.assertEquals(s2.Sprinkler, "Location Sprinklers (Y/N)");
			softAssert.assertEquals(s2.NO, "No");
			softAssert.assertEquals(s2.RuleName3, "Validate Reference Data values");
			softAssert.assertEquals(s2.Stories, "Location Number Of Buildings");
			softAssert.assertEquals(s2.StoryValue, "10");
			softAssert.assertEquals(s2.RuleName4, "Validate Integer values");			
			softAssert.assertEquals(s2.AssertBordereauStatusReview, "REVIEW");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC426_ValidateMandatoryReferenceField "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 388, groups={"TC427_ValidateIntitialPremiumPositive"})
	public void TC427_ValidateIntitialPremiumPositive()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.validateIntitialPremiumPositive_3915();
			softAssert.assertEquals(s2.NegativGrossP,"First reporting of risk with negative premium");
			softAssert.assertEquals(s2.GrossPremium, "5,000.00");
			softAssert.assertEquals(s2.ChangeValue, "5,000.00");
			softAssert.assertEquals(s2.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(s2.NegativPremium,"First reporting of risk with negative premium");
			softAssert.assertEquals(s2.GrossPremium, "5,000.00");
			softAssert.assertEquals(s2.ChangeValue, "5,000.00");
			softAssert.assertEquals(s2.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC427_ValidateIntitialPremiumPositive "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 312, groups={"TC486_BespokeMultipleDefaultValuesEqual"})
	public void TC486_BespokeMultipleDefaultValuesEqual()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			s2.bespokeMultipleDefaultValuesEqual_3981();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC486_BespokeMultipleDefaultValuesEqual "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 313, groups={"TC3982_BespokeMultipleDefaultValuesNotEqual"})
	public void TC3982_BespokeMultipleDefaultValuesNotEqual()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC3982_BespokeMultipleDefaultValuesNotEqual");
			s2.bespokeMultipleDefaultValuesNotEqual();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3982_BespokeMultipleDefaultValuesNotEqual "+e.getMessage(), "FAIL");
		}
			Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bespoke default - multiple default values based on conditions with not equal to operator Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 397, groups={"TC3636_VerifyNewEntryGenerateOnAddingSubRiskIdentifier"})
	public void TC3636_VerifyNewEntryGenerateOnAddingSubRiskIdentifier()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			s2.VerifyNewEntryGenerateOnAddingSubRiskIdentifier_3636();
			softAssert.assertEquals(s2.ContractStatus, "SIGNED","ContractStatus is not Signed");
			softAssert.assertEquals(s2.NewandRenewalEntriesErrorScreen, "New or Renewal entries which already exist","Expected Error Screen Not Displayed");
			softAssert.assertEquals(s2.DataGridRecordCount, "1 - 2 of 2 items","Current Entries not Generated");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3636_VerifyNewEntryGenerateOnAddingSubRiskIdentifier "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 398, groups={"TC3637_DiscardAndRestoreRecords"})
	public void TC3637_DiscardAndRestoreRecords()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			//login.tideLogin(AdminUsername1, AdminPassword1);
			s2.DiscardAndRestoreRecords_3637();
			softAssert.assertEquals(s2.ErrorCount, "4","Error count is not Correct");
			softAssert.assertEquals(s2.DataGridRecordCount, "1 - 4 of 4 items","Record count is not Correct");
			softAssert.assertEquals(s2.DiscardedRecordCount, "1 - 2 of 2 items","Record count is not Correct");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3637_DiscardAndRestoreRecords "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority = 399, groups={"TC3638_Mandatory_Reference_Error_Screens"})
	public void TC3638_Mandatory_Reference_Error_Screens()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			
			s2.Mandatory_Reference_Error_Screens_TC3638();
			softAssert.assertEquals(s2.ErrorCount, "6","Error count is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP1, "Location Sprinklers (Y/N) Mandatory reference data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP2, "Risk Country Mandatory reference data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP3, "Mandatory string data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP4, "Mandatory decimal data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP5, "Mandatory percentage data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP6, "Mandatory date data field not populated","Error Screen is not Correct");
			
			//Expiry
			softAssert.assertEquals(s2.ActualExpiryOriginal, "-","Original value of Risk Expiry date does not match");
			softAssert.assertEquals(s2.ActualExpiryChanged, "01/10/2018","Changed value of Risk Expiry date does not match");
			softAssert.assertEquals(s2.ActualExpiryRulename, "Validate mandatory date field populated","Rule value of Risk Expiry date does not match");
			
			
			softAssert.assertEquals(s2.ClaimErrorCount,"5","Error count is not Correct For Claim");
			softAssert.assertEquals(s2.MandatoryErrorC1, "Claim Status Mandatory reference data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorC2, "Mandatory string data field not populated","Error Screen is not Correct");
		//	softAssert.assertEquals(s2.MandatoryErrorC3, "Mandatory decimal data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorC4, "Mandatory percentage data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorC5, "Mandatory boolean data field not populated","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorC6, "Mandatory date data field not populated","Error Screen is not Correct");
			
		
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3638_Mandatory_Reference_Error_Screens "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 400, groups={"TC3639_DataClenchingforAlldataTypesWithRuleDataCapture"})
	public void TC3639_DataClenchingforAlldataTypesWithRuleDataCapture()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			s2.Data_Type_Clensing_TC3639();
			softAssert.assertEquals(s2.MandatoryErrorRP1, "Invalid decimal value translation required","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP2, "Invalid percentage values identified","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP3, "Invalid date values identified","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP4, "Invalid integer values identified","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP5, "Cancellation Reason reference data translation required","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorRP6, "Insured State reference data translation required","Error Screen is not Correct");
			
			softAssert.assertEquals(s2.ClaimErrorCount,"3","Error count is not Correct For Claim");
		//	softAssert.assertEquals(s2.MandatoryErrorC1, "Invalid decimal value translation required","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorC2, "Invalid percentage values identified","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorC3, "Invalid boolean values identified","Error Screen is not Correct");
			softAssert.assertEquals(s2.MandatoryErrorC4, "Claim Status reference data translation required","Error Screen is not Correct");
				
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3639_DataClenchingforAlldataTypesWithRuleDataCapture "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 401, groups={"TC3640_Country_stateClenching"})
	public void TC3640_Country_stateClenching()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			s2.Country_State_Clensing_TC3640();
			softAssert.assertEquals(s2.ErrorCount, "4","Error count is not Correct");
			softAssert.assertEquals(s2.ClaimErrorCount, "6","Error count is not Correct");
			
		
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3640_Country_stateClenching "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
		
}
