package com.tide.qa.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.SchedulePage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class ScheduleTests extends TestBase{

	PolicyPage policyPage = new PolicyPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	SchedulePage Schedule= new SchedulePage();
	SoftAssert softAssert = new SoftAssert();
	LoginPage login = new LoginPage();
	String AdminUsername = "dev.admin@tideapp.co.uk";
	String AdminPassword = "Yb0kMlJ;z8Ho33mO";
	
	String AdminUsername1 = "broker01.ca@tideapp.co.uk";
	String AdminPassword1 = "HuCSbq7589wNU4M";
	
	@Test(priority = 652, groups={"TC804_Update_DataReferenceData_AdminArea"})
	public void TC804_Update_DataReferenceData_AdminArea()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Schedule.Update_DataReferenceData_AdminArea_TC5122();
			softAssert.assertEquals(Schedule.Data,"Data");
			softAssert.assertEquals(Schedule.Description,"Description");
			softAssert.assertEquals(Schedule.Dataset,"Dataset");
			softAssert.assertEquals(Schedule.System,"System");
			softAssert.assertEquals(Schedule.DatasetWithoutData1,"-");
			login.tideAdminLogOut();
			login.tideLogin(AdminUsername1, AdminPassword1);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC804_Update_DataReferenceData_AdminArea "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	} 
	
	@Test(priority =76, groups={"TC795_RiskPremiumBordereauType"})
	public void TC795_RiskPremiumBordereauType()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Schedule.riskPremiumBordereauType_5185();
			softAssert.assertNotNull(Schedule.RiskSchemaName);
			softAssert.assertEquals(Schedule.recordsCountRisk, Schedule.recordsCountPremium);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC795_RiskPremiumBordereauType "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =77, groups={"TC798_CoreFinancialRevisedCalculationse"})
	public void TC798_CoreFinancialRevisedCalculationse()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Schedule.coreFinancialRevisedCalculation_5188();
			softAssert.assertEquals(Schedule.ActualGrossPremium1Row,"10.00");
			softAssert.assertEquals(Schedule.ActualGrossPremium2Row,"10.00");
			softAssert.assertEquals(Schedule.ActualGrossPremium3Row,"10.00");
			softAssert.assertEquals(Schedule.ActualGrossPremium4Row,"10.00");
			softAssert.assertEquals(Schedule.ActualGrossPremium5Row,"10.00");
			softAssert.assertEquals(Schedule.ActualGrossPremium6Row,"10.00");
			softAssert.assertEquals(Schedule.NetPremium1,"114.50");
			softAssert.assertEquals(Schedule.NetPremium2,"114.50");
			softAssert.assertEquals(Schedule.NetPremium3,"114.50");
			softAssert.assertEquals(Schedule.NetPremium4,"-10.00");
			softAssert.assertEquals(Schedule.NetPremium5,"-10.00");
			softAssert.assertEquals(Schedule.NetPremium6,"14.50");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC798_CoreFinancialRevisedCalculationse "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}	
	@Test(priority =78, groups={"TC802_LocationBreaches"})
	public void TC802_LocationBreaches()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Schedule.locationBreaches_5085();
			softAssert.assertEquals(Schedule.AcualRiskState,2);
			softAssert.assertEquals(Schedule.AcualInsuredState,2);
			softAssert.assertEquals(Schedule.AcualRiskCountry,4);
			softAssert.assertEquals(Schedule.AcualInsuredCountry,4);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC802_LocationBreaches "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =79, groups={"TC800_BordereauSummaryErrorsandWarnings"})

	public void TC800_BordereauSummaryErrorsandWarnings()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Schedule.BordereauSummaryErrorsAndWarnings_5190();
			softAssert.assertEquals(Schedule.ActualErrormessage1,"Invalid date values identified - Risk Expiry Date");
			softAssert.assertEquals(Schedule.ActualErrormessage2,"Invalid integer values identified - Location Number Of Buildings");
			softAssert.assertEquals(Schedule.ActualErrormessage3,"Location Sprinklers (Y/N) - reference data translation required");
			softAssert.assertEquals(Schedule.ActualErrormessage4,"Premium Currency - reference data translation required");
			softAssert.assertEquals(Schedule.ActualErrormessage5,"Risk Currency - reference data translation required");
			softAssert.assertEquals(Schedule.ActualErrormessage6,"Insured Country - reference data translation required");
			softAssert.assertEquals(Schedule.ActualErrormessage7,"Risk Country - reference data translation required");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC800_BordereauSummaryErrorsandWarnings "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =80, groups={"TC803_copyfromsection1tosection2"})
	public void TC803_copyfromsection1tosection2()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Schedule.bordereauSummaryErrorsAndWarnings_5303();		
			softAssert.assertEquals(Schedule.AcualRiskCountry,4);
			softAssert.assertEquals(Schedule.AcualInsuredCountry,4);
			softAssert.assertEquals(Schedule.AcualRiskState,1);
			softAssert.assertEquals(Schedule.AcualInsuredState,1);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC803_copyfromsection1tosection2 "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	@Test(priority = 111, groups={"TC4218_AddOpenMarketFolderType"})
	public void TC4218_AddOpenMarketFolderType()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{	
			
			policyPage.addOpnMrktTypePolicy();
			softAssert.assertNotNull(policyPage.PolicyNumber, "Policy number is null");
			softAssert.assertEquals(policyPage.CntractStatusSigned, "SIGNED");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4218_AddOpenMarketFolderType "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 112, groups={"TC4230_AddScheduleInOpenMarketTypeContract"})
	public void TC4230_AddScheduleInOpenMarketTypeContract()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{	
			QuePage.addScheduleToOpnMrktContrct();
			softAssert.assertNotNull(policyPage.PolicyNumber, "Policy number is null");
			softAssert.assertNotNull(QuePage.ActualScheduleQuestnrName, "Questionnaire Name is null");
			softAssert.assertEquals(QuePage.ScheduleTabInOpnMrktcontrct, "SCHEDULE");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4230_AddScheduleInOpenMarketTypeContract "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 113, groups={"TC4226_VerifyScheduleQuestionnaireInQuestionnaireList"})
	public void TC4226_VerifyScheduleQuestionnaireInQuestionnaireList()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{	
			QuePage.FilterScheduleQuestneFrmQuestionnaireList();
			softAssert.assertNotNull(policyPage.PolicyNumber, "Policy number is null");
			softAssert.assertEquals(QuePage.ScheduleTabInOpnMrktcontrct, "SCHEDULE");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4226_VerifyScheduleQuestionnaireInQuestionnaireList "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
}
