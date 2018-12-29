package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BordereauProcessedMissingFutureTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	PolicyPage policy = new PolicyPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";
			
	@Test(priority =348, groups={"TC273_SamePeriodNotYetApproved"})
	public void TC273_SamePeriodNotYetApproved()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.AnotherBordereauSamePeriodNotYetApproved();
			softAssert.assertEquals(sheets.ErrorScreenVerification, "Another bordereau of the same period is not yet approved");
			softAssert.assertNotNull(sheets.verifyButtonText);
			softAssert.assertEquals(sheets.AssertBordereauStatusUploaded, "UPLOADED");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC273_SamePeriodNotYetApproved "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =349, groups={"TC274_PreviousBordereauNotYetApproved"})

	public void TC274_PreviousBordereauNotYetApproved()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.PreviousBordereauNotYetApproved();
			softAssert.assertEquals(sheets.ErrorScreenVerification, "Previous bordereau not Approved");
			softAssert.assertNotNull(sheets.verifyButtonText);
			softAssert.assertEquals(sheets.AssertBordereauStatusUploaded, "UPLOADED");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC274_PreviousBordereauNotYetApproved "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =350, groups={"TC275_BordereauPeriodPrior"})
	public void TC275_BordereauPeriodPrior()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			sheets.BordereauPeriodPriorToContractInception();
			softAssert.assertEquals(sheets.ErrorScreenText, "Bordereau period prior to contract inception");
			softAssert.assertNotNull(sheets.PauseBtnText);
			softAssert.assertEquals(sheets.AssertBordereauStatusReviewError, "REVIEW ERRORS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC275_BordereauPeriodPrior "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}	

	@Test(priority = 351, groups={"TC277_MissingFutureNilCancelProcessing"})
	public void TC277_MissingFutureNilCancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.missingFutureSequentiallyNilBordereaux_3452();
			softAssert.assertEquals(sheets.ErrorScreenText, "Missing Bordereau periods");
			softAssert.assertNotNull(sheets.PauseBtnText);
			softAssert.assertEquals(sheets.AssertBordereauStatusReviewError, "REVIEW ERRORS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC277_MissingFutureNilCancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
		
	@Test(priority = 352, groups={"TC276_MissingFutureSequentiallyNilBordereaux"})

	public void TC276_MissingFutureSequentiallyNilBordereaux()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			
			sheets.missingFutureSequentiallyNilBordereaux_3451();
			softAssert.assertEquals(sheets.ErrorScreenText, "Missing Bordereau periods");
			softAssert.assertNotNull(sheets.PauseBtnText);
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC276_MissingFutureSequentiallyNilBordereaux "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}	
			
	@Test(priority = 353, groups={"TC278_AlreadyApprovedCancelProcessing"})
	public void TC278_AlreadyApprovedCancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.AlreadyApprovedCancelProcessing_3453();
			softAssert.assertEquals(sheets.ErrorScreenText, "Approved bordereau already processed against the period selected");
			softAssert.assertNotNull(sheets.PauseBtnText);
			softAssert.assertEquals(sheets.AssertBordereauStatusReviewError, "REVIEW ERRORS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC278_AlreadyApprovedCancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
		
	@Test(priority = 354, groups={"TC279_AlreadyApprovedIncorrectPeriod"})
	public void TC279_AlreadyApprovedIncorrectPeriod()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			sheets.AlreadyApprovedIncorrectPeriod_3455();
			softAssert.assertEquals(sheets.ErrorScreenText, "Approved bordereau already processed against the period selected");
			softAssert.assertNotNull(sheets.ProcessAgainstSelectedPeriodBtnTet);
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC279_AlreadyApprovedIncorrectPeriod "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
		
	@Test(priority = 355, groups={"TC280_AlreadyApprovedAdditionalBordereaux"})
	public void TC280_AlreadyApprovedAdditionalBordereaux()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			sheets.AlreadyApprovedAdditionalBordereaux_3456();
			softAssert.assertEquals(sheets.ErrorScreenText, "Approved bordereau already processed against the period selected");
			softAssert.assertNotNull(sheets.ProcessAsAdditionalBtntext);
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC280_AlreadyApprovedAdditionalBordereaux "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 356, groups={"TC281_AlreadyApprovedCorrectionBordereau"})
	public void TC281_AlreadyApprovedCorrectionBordereau()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CorrectionBordereau_3458();
			softAssert.assertEquals(sheets.ErrorScreenText, "Approved bordereau already processed against the period selected");
			softAssert.assertNotNull(sheets.ProcessAsCorrectionBtntext);
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC281_AlreadyApprovedCorrectionBordereau "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
			
				
	@Test(priority = 357, groups={"TC284_ErrorRemainingCancelProcessing"})
	public void TC284_ErrorRemainingCancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			sheets.ErrorRemainingCancelProcessing_3471();
			softAssert.assertEquals(sheets.ErrorScreenText, "Another bordereau of the same period has errors remaining");
			softAssert.assertNotNull(sheets.PauseBtnText);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC284_ErrorRemainingCancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 358, groups={"TC285_ErrorRemainingCancelProcessing"})
	public void TC285_ErrorRemainingCancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			sheets.ErrorRemainingCancelProcessing_3472();
			softAssert.assertEquals(sheets.ErrorScreenText,"Previous bordereau has errors remaining");
			softAssert.assertNotNull(sheets.PauseBtnText);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC285_ErrorRemainingCancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
		
		
	
	@Test(priority = 359, groups={"TC286_ErrorRemainingContinueProcessing"})
	public void TC286_ErrorRemainingContinueProcessing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.ErrorRemainingContinueProcessing_3475();
			softAssert.assertEquals(sheets.SkippAllErroBtnScreen, "SKIP ALL ERRORS");
			softAssert.assertEquals(sheets.SubProcessRcdsBtn, "SUBMIT PASSED RECORDS FOR ASSIGNMENT");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC286_ErrorRemainingContinueProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
		
	}
	

	@Test(priority = 360, groups={"TC287_SameBordroErrorRemaining"})
	public void TC287_SameBordroErrorRemaining()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.SamebordorErrorRemainingContinueProcessing_3477();
			softAssert.assertEquals(sheets.SkippAllErroBtnScreen, "SKIP ALL ERRORS");
			softAssert.assertEquals(sheets.SubProcessRcdsBtn, "SUBMIT PASSED RECORDS FOR ASSIGNMENT");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC287_SameBordroErrorRemaining "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}	
}