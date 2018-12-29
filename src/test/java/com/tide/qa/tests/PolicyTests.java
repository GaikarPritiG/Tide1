package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.PolicyPageContractDataSummary;
import com.tide.qa.utility.Report;
import org.testng.asserts.SoftAssert;

@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class PolicyTests extends TestBase
{
	PolicyPage policyPage = new PolicyPage();
	PolicyPageContractDataSummary polCon = new PolicyPageContractDataSummary();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";

	
	@Test(priority = 6, groups={"TC77_AddContractFolder"})
	public void TC77_AddContractFolder()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{	
			
			policyPage.addPolicy();
			softAssert.assertNotNull(policyPage.PolicyNumber, "Policy number is null");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC77_AddContractFolder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 7, groups={"TC80_ChangeWrittenStatusToSigned"})
	public void TC80_ChangeWrittenStatusToSigned()
	{
		
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			policyPage.changeStatusToSigned();
			softAssert.assertEquals(policyPage.CntractStatusSigned, "SIGNED");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC80_ChangeWrittenStatusToSigned "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
		
	}

	@Test(priority = 21, groups={"TC89_CheckVersionAfterSigned"})
	public void TC89_CheckVersionAfterSigned()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			policyPage.checkVersionAfterSigned();
			softAssert.assertEquals(policyPage.contractVersion, "1","Contract not signed");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC89_CheckVersionAfterSigned "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 22, groups={"TC101_AddFileToContract"})

	public void TC101_AddFileToContract()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.addFileToContract();
			softAssert.assertNotNull(policyPage.addedfile, "File not added successfully");


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC101_AddFileToContract "+e.getMessage(), "FAIL");
			
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =88, groups={"TC91_AddReportingChanel"})
	public void TC91_AddReportingChanel()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.addReportingChannelForContract();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3286_AddReportingChanel "+e.getMessage(), "FAIL");

			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}


	@Test(priority = 23, groups={"TC90_BordereauxEntriesInExpectedTabGeneratedBasedonReportingChannel"})
	public void TC90_BordereauxEntriesInExpectedTabGeneratedBasedonReportingChannel()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.TC3541_BordereauxEntriesInExpectedTabGeneratedBasedonReportingChannel();
			softAssert.assertEquals(policyPage.ScheduleSize, 0,"Scheduleentries not generated");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC90_BordereauxEntriesInExpectedTabGeneratedBasedonReportingChannel "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 89, groups={"TC92_EditReportingChannelOfContract"})
	public void TC92_EditReportingChannelOfContract()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.editReportingChannelOfContract();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC92_EditReportingChannelOfContract "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 90, groups={"TC93_DeleteReportingChannelOfContract"})
	public void TC93_DeleteReportingChannelOfContract()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			policyPage.deleteReportingChannelOfContract();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC93_DeleteReportingChannelOfContract "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 24, groups={"TC94_CreateAnotherContractForSamePolicy"})
	public void TC94_CreateAnotherContractForSamePolicy()
	{
		SoftAssert softAssert = new SoftAssert();
        try
		{
			policyPage.createAnotherContractForSamePolicy();
		//	softAssert.assertEquals(policyPage.ContractStatusText1, "QUOTE");


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3233_CreateAnotherContractForSamePolicy "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}


	@Test(priority = 25, groups={"TC95_SelectionTabHiddenForPolicy"})
	public void TC95_SelectionTabHiddenForPolicy()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.selectionTabHiddenForPolicy();
			softAssert.assertNull(policyPage.perilsExists);
			softAssert.assertNull(policyPage.ModelingExists);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC95_SelectionTabHiddenForPolicy "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 26, groups={"TC96_EditSectionDetails"})
	public void TC96_EditSectionDetails()
	{
		SoftAssert softAssert = new SoftAssert();
        try
		{
			policyPage.editSectionDetails();
			
			softAssert.assertEquals(policyPage.actualCurrencyinSection, "DKK - Danish Krone");


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3393_EditSectionDetails "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 27, groups={"TC97_EditSectionReferenceDetails"})
	public void TC97_EditSectionReferenceDetails()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.editSectionReference();
			softAssert.assertEquals(policyPage.EditedSectionRefText, "Test edit");


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3394_EditSectionReferenceDetails "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	@Test(priority = 28, groups={"TC98_RiskCode_AddEditDelete"})
	public void TC98_RiskCode_AddEditDelete()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.RiskCode_AddEditDelete_TC4351();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC98_RiskCode_AddEditDelete "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}


	@Test(priority = 29, groups={"TC102_EditGeneralContractRules"})
	public void TC102_EditGeneralContractRules()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			policyPage.firstEditGeneralAndLocation();
			softAssert.assertEquals(policyPage.CntractStatusSigned, "SIGNED");
			softAssert.assertEquals(policyPage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(policyPage.GeneralRuleSize, 1);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC102_EditGeneralContractRules "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 30, groups={"TC103_SeEditGeneralContractRules"})
	public void TC103_SeEditGeneralContractRules()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.secondEditGeneralAndLocation();
			softAssert.assertEquals(policyPage.EditSettlementDueDaysText, "100");
        }
		catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC103_SeEditGeneralContractRules "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 302, groups={"TC106_ProcessBordereauWithSupplementaryFiles"})
	public void TC106_ProcessBordereauWithSupplementaryFiles()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.processBordereauWithSupplementaryFiles();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC106_ProcessBordereauWithSupplementaryFiles "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 303, groups={"TC109_NilBordereau"})
	public void TC109_NilBordereau()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.nilBordereau();
			softAssert.assertEquals(policyPage.ActualText1, "NIL BORDEREAU");		


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC109_NilBordereau "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 31, groups={"TC114_ContractClaimAuthorityEdit"})
	public void TC114_ContractClaimAuthorityEdit()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.ContractClaimAuthority_Edit_4034();
			softAssert.assertEquals(policyPage.EditedClaimAuthidity, "Test TPA - Default");
			softAssert.assertEquals(policyPage.EditedClaimAuthidityLimit, "5.00  GBP");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC114_ContractClaimAuthorityEdit "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 304, groups={"TC111_ContractRoleEdit"})

	public void TC111_ContractRoleEdit()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.ContractRoleEdit_TC3527();
			softAssert.assertEquals(policyPage.ActualCompany,policyPage.ExpectedCompany);
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC111_ContractRoleEdit "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority = 305, groups={"TC117_ContractCoverHolder_AddOrEdit"})
	public void TC117_ContractCoverHolder_AddOrEdit()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.ContractCoverHolder_AddOrEdit_TC3801();
			softAssert.assertNotNull(policyPage.ActualCoverholderContact, "Coverholder not edited");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3801_ContractCoverHolder_AddOrEdit"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 306, groups={"TC120_Contract_Link"})

	public void TC120_Contract_Link()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			policyPage.Contract_Link_TC3804();
			
			softAssert.assertEquals(policyPage.ActualLinkText,"CHILD");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC120_Contract_Link"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	
	
	@Test(priority = 32, groups={"TC141_ConDataSumMonthlyReporting"})
	public void TC141_ConDataSumMonthlyReporting()
	{
		
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumMonthlyReporting_4729();
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Jan_V, "1,500.00");
			softAssert.assertEquals(polCon.Jan_T, "1,500.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Jan_V1, "1,000.00");
			softAssert.assertEquals(polCon.Jan_T1, "1,000.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Incure1, "900.00");
			softAssert.assertEquals(polCon.Incure2, "900.00");
			softAssert.assertEquals(polCon.Incure4, "900.00");
			softAssert.assertEquals(polCon.WG1, "66.67%");
			softAssert.assertEquals(polCon.WG2, "60.00%");
			softAssert.assertEquals(polCon.WG3, "60.00%");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP1, "3,000.00");
			softAssert.assertEquals(polCon.GP2, "3,000.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP3, "4,500.00");
			softAssert.assertEquals(polCon.GP4, "4,500.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP5, "150.00%");
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC141_ConDataSumMonthlyReporting"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 33, groups={"TC142_ConDataSumQuaterlyReporting"})
	public void TC142_ConDataSumQuaterlyReporting()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumQuaterlyReporting_4745();
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Jan_V, "200.00");
			softAssert.assertEquals(polCon.Jan_T, "200.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Jan_V1, "400.00");
			softAssert.assertEquals(polCon.Jan_T1, "400.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Incure1, "900.00");
			softAssert.assertEquals(polCon.Incure2, "900.00");
			softAssert.assertEquals(polCon.WG1, "450.00%");
			softAssert.assertEquals(polCon.WG2, "450.00%");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP1, "1,200.00");
			softAssert.assertEquals(polCon.GP2, "1,200.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP3, "1,900.00");
			softAssert.assertEquals(polCon.GP4, "1,900.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Incure3, "1,800.00");
			softAssert.assertEquals(polCon.Incure4, "1,800.00");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC142_ConDataSumQuaterlyReporting"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 34, groups={"TC326_ConDataSumQuaterlyNil"})
	public void TC326_ConDataSumQuaterlyNil()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumQuaterlyNil_4839();
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.WG2, "500.00");
			softAssert.assertEquals(polCon.WG3, "500.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP1, "1,000.00");
			softAssert.assertEquals(polCon.GP2, "1,000.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP3, "1,200.00");
			softAssert.assertEquals(polCon.GP4, "1,200.00");
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC326_ConDataSumQuaterlyNil"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}	
	
	@Test(priority = 35, groups={"TC144_ConDataSumAnnually"})
	public void TC144_ConDataSumAnnually()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			polCon.ConDataSumAnnuallyReporting_4757();
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Jan_V, "200.00");
			softAssert.assertEquals(polCon.Jan_T, "200.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Jan_V1, "400.00");
			softAssert.assertEquals(polCon.Jan_T1, "400.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Incure1, "900.00");
			softAssert.assertEquals(polCon.Incure2, "900.00");
			softAssert.assertEquals(polCon.WG1, "200.00%");
			softAssert.assertEquals(polCon.WG2, "450.00%");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP1, "700.00");
			softAssert.assertEquals(polCon.GP2, "700.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.GP3, "1,400.00");
			softAssert.assertEquals(polCon.GP4, "1,400.00");
			softAssert.assertEquals(polCon.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(polCon.Incure3, "1,800.00");
			softAssert.assertEquals(polCon.Incure4, "1,800.00");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC144_ConDataSumAnnually"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 85, groups={"TC100_SectionMarket_AddEditDelete"})
	public void TC100_SectionMarket_AddEditDelete()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			policyPage.SectionMarket_AddEditDelete_TC5283();
			 softAssert.assertEquals(policyPage.Delete, "DELETE");
			// softAssert.assertEquals(policyPage.SectionPopup, "Signed Contract Change");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC100_SectionMarket_AddEditDelete"+e.getMessage(), "FAIL");
			 softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 1212, groups={"TC2023_AddContractforDraftEndorsement"})
	public void TC2023_AddContractforDraftEndorsement()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{	
			
			policyPage.CreateContract2017ForDraftEndorsement();
			softAssert.assertNotNull(policyPage.PolicyNumber, "Policy number is null");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC2023_AddContractforDraftEndorsement "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority = 108, groups={"TC4179_SortOrderInMarkets"})
	public void TC4179_SortOrderInMarkets()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{	
			
			policyPage.SortOrderInMarkets_TC4179();
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4179_SortOrderInMarkets "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
	

	
	
}