package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialCalculationRiskAndPremiumPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class FinancialCalculationRiskAndPremiumTests extends TestBase {
	
	FinancialCalculationRiskAndPremiumPage RPpage= new FinancialCalculationRiskAndPremiumPage();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";

	@Test(priority =639, groups={"TC616_FCRiskAndPremium_Transactiontype"})
	public void TC616_FCRiskAndPremium_Transactiontype()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			RPpage.riskAndPremiumForTransactionType_4009();
			softAssert.assertEquals(RPpage.Rw1,"2");
			softAssert.assertEquals(RPpage.Rw2,"3");
			softAssert.assertEquals(RPpage.Rw3,"4");
			softAssert.assertEquals(RPpage.Rw4,"4");
			
			softAssert.assertEquals(RPpage.GP1,"1,000.00");
			softAssert.assertEquals(RPpage.GP2,"1,000.00");
			softAssert.assertEquals(RPpage.GP3,"500.00");
			softAssert.assertEquals(RPpage.GP4,"1,500.00");
			
			softAssert.assertEquals(RPpage.GPT1,"1,000.00");
			softAssert.assertEquals(RPpage.GPT2,"1,000.00");
			softAssert.assertEquals(RPpage.GPT3,"500.00");
			softAssert.assertEquals(RPpage.GPT4,"1,500.00");
			
			softAssert.assertEquals(RPpage.CC1,"500.00");
			softAssert.assertEquals(RPpage.CC2,"500.00");
			softAssert.assertEquals(RPpage.CC3,"500.00");
			softAssert.assertEquals(RPpage.CC4,"1,000.00");
			
			softAssert.assertEquals(RPpage.NP1,"2,000.00");
			softAssert.assertEquals(RPpage.NP2,"1,000.00");
			softAssert.assertEquals(RPpage.NP3,"1,000.00");
			softAssert.assertEquals(RPpage.NP4,"2,000.00");
			
			softAssert.assertEquals(RPpage.LB1,"156.05");
			softAssert.assertEquals(RPpage.LB2,"50.00");
			softAssert.assertEquals(RPpage.LB3,"25.00");
			softAssert.assertEquals(RPpage.LB4,"75.00");
			softAssert.assertEquals(RPpage.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC616_FCRiskAndPremium_Transactiontype"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =640, groups={"TC617_TransactionTypeNotSupplied"})
	public void TC617_TransactionTypeNotSupplied()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			RPpage.transactionTypeNotSupplied_4010();
			softAssert.assertEquals(RPpage.GP1,"1,000.00");
			softAssert.assertEquals(RPpage.GP2,"1,000.00");
			softAssert.assertEquals(RPpage.GP3,"500.00");
			softAssert.assertEquals(RPpage.GP4,"1,500.00");
			
			softAssert.assertEquals(RPpage.CC1,"500.00");
			softAssert.assertEquals(RPpage.CC2,"500.00");
			softAssert.assertEquals(RPpage.CC3,"500.00");
			softAssert.assertEquals(RPpage.CC4,"1,000.00");
			
			softAssert.assertEquals(RPpage.NP1,"2,000.00");
			softAssert.assertEquals(RPpage.NP2,"1,000.00");
			softAssert.assertEquals(RPpage.NP3,"1,000.00");
			softAssert.assertEquals(RPpage.NP4,"2,000.00");
			
			softAssert.assertEquals(RPpage.LB1,"156.05");
			softAssert.assertEquals(RPpage.LB2,"50.00");
			softAssert.assertEquals(RPpage.LB3,"25.00");
			softAssert.assertEquals(RPpage.LB4,"75.00");
			softAssert.assertEquals(RPpage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC617_TransactionTypeNotSupplied"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =641, groups={"TC618_ReportingtypeRESTATEMENT"})
	public void TC618_ReportingtypeRESTATEMENT()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			RPpage.finalcialCalculationRESTATEMENT_4011();
			softAssert.assertEquals(RPpage.GP1,"1,000.00");
			softAssert.assertEquals(RPpage.GP2,"1,000.00");
			softAssert.assertEquals(RPpage.GP3,"-500.00");
			softAssert.assertEquals(RPpage.GP4,"500.00");
			
			softAssert.assertEquals(RPpage.CC1,"500.00");
			softAssert.assertEquals(RPpage.CC2,"500.00");
			softAssert.assertEquals(RPpage.CC3,"0.00");
			softAssert.assertEquals(RPpage.CC4,"500.00");
			
			softAssert.assertEquals(RPpage.NP1,"2,000.00");
			softAssert.assertEquals(RPpage.NP2,"1,000.00");
			softAssert.assertEquals(RPpage.NP3,"0.00");
			softAssert.assertEquals(RPpage.NP4,"1,000.00");
			
			softAssert.assertEquals(RPpage.FNP1,"1,843.95");
			softAssert.assertEquals(RPpage.FNP2,"950.00");
			softAssert.assertEquals(RPpage.FNP3,"25.00");
			softAssert.assertEquals(RPpage.FNP4,"975.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC618_ReportingtypeRESTATEMENT"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =642, groups={"TC619_ReportingtypeRESTATEMENT"})
	public void TC619_ReportingtypeRESTATEMENT()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			RPpage.riskAndPremiumForReportingtypeRESTATEMENT_4013();
			softAssert.assertEquals(RPpage.GP1,"1,000.00");
			softAssert.assertEquals(RPpage.GP2,"1,000.00");
			softAssert.assertEquals(RPpage.GP3,"-500.00");
			softAssert.assertEquals(RPpage.GP4,"500.00");
			
			softAssert.assertEquals(RPpage.CC1,"500.00");
			
			softAssert.assertEquals(RPpage.CC2,"500.00");
			softAssert.assertEquals(RPpage.CC3,"0.00");
			softAssert.assertEquals(RPpage.CC4,"500.00");
			
			softAssert.assertEquals(RPpage.CCP1,"50.00 %");
			softAssert.assertEquals(RPpage.CCP2,"50.00 %");
			softAssert.assertEquals(RPpage.CCP3,"100.00 %");
			softAssert.assertEquals(RPpage.CCP4,"100.00 %");
			
			softAssert.assertEquals(RPpage.LB1,"156.05");
			softAssert.assertEquals(RPpage.LB2,"50.00");
			softAssert.assertEquals(RPpage.LB3,"-25.00");
			softAssert.assertEquals(RPpage.LB4,"25.00");
			
			softAssert.assertEquals(RPpage.FNP1,"1,843.95");
			softAssert.assertEquals(RPpage.FNP2,"950.00");
			softAssert.assertEquals(RPpage.FNP3,"25.00");
			softAssert.assertEquals(RPpage.FNP4,"975.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC619_ReportingtypeRESTATEMENT"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}

	}
}
