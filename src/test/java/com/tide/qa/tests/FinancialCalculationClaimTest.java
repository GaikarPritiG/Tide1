package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialCalculationClaimPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class FinancialCalculationClaimTest extends TestBase{

	FinancialCalculationClaimPage sheets = new FinancialCalculationClaimPage();
	//Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";
	
	@Test(priority =629, groups={"TC509_Calculate_Fees_Reserve"})
	public void TC509_Calculate_Fees_Reserve()
	{
		SoftAssert softAssert = new SoftAssert();;
		try
		{
			sheets.CalculateFeesReserve_4094();
			softAssert.assertEquals(sheets.ActualFRow1, "40.00");
			softAssert.assertEquals(sheets.ActualSRow2, "40.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC509_Calculate_Fees_Reserve"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =630, groups={"TC510_CalculateFeesPaid"})
	public void TC510_CalculateFeesPaid()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CalculateFeesPaid_4095();
			softAssert.assertEquals(sheets.FP1, "40.00");
			softAssert.assertEquals(sheets.FP2, "40.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC510_CalculateFeesPaid"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =631, groups={"TC511_CalculateFees_TotalIncurred"})
	public void TC511_CalculateFees_TotalIncurred()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CalculateFees_TotalIncurred_4093();
			softAssert.assertEquals(sheets.FTI1, "80.00");
			softAssert.assertEquals(sheets.FTI2, "80.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC511_CalculateFees_TotalIncurred"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =632, groups={"TC512_Indemnity_TotalIncurred"})
	public void TC512_Indemnity_TotalIncurred()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.Indemnity_TotalIncurred_4092();
			softAssert.assertEquals(sheets.ITI1, "1,100.00");
			softAssert.assertEquals(sheets.ITI2, "1,100.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC512_Indemnity_TotalIncurred"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =633, groups={"TC513_CalculateTotal_Reserve"})
	public void TC513_CalculateTotal_Reserve()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CalculateTotal_Reserve_4089();
			softAssert.assertEquals(sheets.TR1, "1,040.00");
			softAssert.assertEquals(sheets.TR2, "1,040.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC513_CalculateTotal_Reserve"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =634, groups={"TC514_Total_Paid"})
	public void TC514_Total_Paid()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CalculateTotal_Paid_4090();
			softAssert.assertEquals(sheets.TP1, "140.00");
			softAssert.assertEquals(sheets.TP2, "140.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC514_Total_Paid"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =635, groups={"TC515_Total_Incurred"})
	public void TC515_Total_Incurred()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CalculateTotal_Incurred_4091();
			softAssert.assertEquals(sheets.TI1, "1,180.00");
			softAssert.assertEquals(sheets.TI2, "1,180.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC515_Total_Incurred"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =636, groups={"TC516_ChangeValuePositiveToNegative"})
	public void TC516_ChangeValuePositiveToNegative()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.positiveToNegative_4096();
			softAssert.assertEquals(sheets.ACFP1,"10.00");
			softAssert.assertEquals(sheets.ACFP2,"-10.00");
			softAssert.assertEquals(sheets.ACFR1,"10.00");
			softAssert.assertEquals(sheets.ACFR2,"-10.00");
			softAssert.assertEquals(sheets.DFP1,"10.00");
			softAssert.assertEquals(sheets.DFP2,"-10.00");
			softAssert.assertEquals(sheets.DFR1,"10.00");
			softAssert.assertEquals(sheets.DFR2,"-10.00");
			softAssert.assertEquals(sheets.EP1,"10.00");
			softAssert.assertEquals(sheets.EP2,"-10.00");
			softAssert.assertEquals(sheets.ER1,"10.00");
			softAssert.assertEquals(sheets.ER2,"-10.00");
			softAssert.assertEquals(sheets.FR1,"40.00");
			softAssert.assertEquals(sheets.FR2,"-40.00");
			softAssert.assertEquals(sheets.IP1,"100.00");
			softAssert.assertEquals(sheets.IP2,"-100.00");
			softAssert.assertEquals(sheets.IR1,"1,000.00");
			softAssert.assertEquals(sheets.IR2,"-1,000.00");
			softAssert.assertEquals(sheets.FI1,"80.00");
			softAssert.assertEquals(sheets.FI2,"-80.00");
			softAssert.assertEquals(sheets.IT1,"1,100.00");
			softAssert.assertEquals(sheets.IT2,"-1,100.00");
			softAssert.assertEquals(sheets.TIV1,"1,180.00");
			softAssert.assertEquals(sheets.TIV2,"-1,180.00");
			softAssert.assertEquals(sheets.TPV1,"140.00");
			softAssert.assertEquals(sheets.TPV2,"-140.00");
			softAssert.assertEquals(sheets.TRV1,"1,040.00");
			softAssert.assertEquals(sheets.TRV2,"-1,040.00");
			softAssert.assertEquals(sheets.AP1,"10.00");
			softAssert.assertEquals(sheets.AP2,"-10.00");
			softAssert.assertEquals(sheets.AFR1,"10.00");
			softAssert.assertEquals(sheets.AFR2,"-10.00");		
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC516_ChangeValuePositiveToNegative"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =637, groups={"TC517_ClaimsFinancials"})
	public void TC517_ClaimsFinancials()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.claimsFinancials_4103();
			softAssert.assertEquals(sheets.AssertBordereauStatusApproved, "APPROVED");
			softAssert.assertEquals(sheets.FP1,"-40.00");	
			softAssert.assertEquals(sheets.FP2,"-40.00");	
			softAssert.assertEquals(sheets.FP3,"-80.00");	
			softAssert.assertEquals(sheets.FP4,"-40.00");	
			softAssert.assertEquals(sheets.FP5,"-40.00");	
			softAssert.assertEquals(sheets.FP6,"-80.00");
			
			softAssert.assertEquals(sheets.FR1,"-40.00");	
			softAssert.assertEquals(sheets.FR2,"-40.00");	
			softAssert.assertEquals(sheets.FR3,"-80.00");	
			softAssert.assertEquals(sheets.FR4,"-40.00");	
			softAssert.assertEquals(sheets.FR5,"-40.00");	
			softAssert.assertEquals(sheets.FR6,"-80.00");
			
			softAssert.assertEquals(sheets.FTR1,"-80.00");	
			softAssert.assertEquals(sheets.FTR2,"-80.00");	
			softAssert.assertEquals(sheets.FTR3,"-160.00");	
			softAssert.assertEquals(sheets.FTR4,"-80.00");	
			softAssert.assertEquals(sheets.FTR5,"-80.00");	
			softAssert.assertEquals(sheets.FTR6,"-160.00");

			softAssert.assertEquals(sheets.TR1,"-1,040.00");	
			softAssert.assertEquals(sheets.TR2,"-1,040.00");	
			softAssert.assertEquals(sheets.TR3,"-2,080.00");	
			softAssert.assertEquals(sheets.TR4,"-1,040.00");	
			softAssert.assertEquals(sheets.TR5,"-1,040.00");	
			softAssert.assertEquals(sheets.TR6,"-2,080.00");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC517_ClaimsFinancials"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =638, groups={"TC518_ClaimsFinancials"})
	public void TC518_ClaimsFinancials()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.claimsFinancials_4104();
			softAssert.assertEquals(sheets.AssertBordereauStatusApproved, "APPROVED");
			softAssert.assertEquals(sheets.FP1,"40.00");	
			softAssert.assertEquals(sheets.FP2,"0.00");	
			softAssert.assertEquals(sheets.FP3,"40.00");	
			softAssert.assertEquals(sheets.FP4,"40.00");	
			softAssert.assertEquals(sheets.FP5,"0.00");	
			softAssert.assertEquals(sheets.FP6,"40.00");
			
			softAssert.assertEquals(sheets.FR1,"40.00");	
			softAssert.assertEquals(sheets.FR2,"80.00");	
			softAssert.assertEquals(sheets.FR3,"120.00");	
			softAssert.assertEquals(sheets.FR4,"40.00");	
			softAssert.assertEquals(sheets.FR5,"80.00");	
			softAssert.assertEquals(sheets.FR6,"120.00");
			
			softAssert.assertEquals(sheets.TP1,"140.00");	
			softAssert.assertEquals(sheets.TP2,"0.00");	
			softAssert.assertEquals(sheets.TP3,"140.00");	
			softAssert.assertEquals(sheets.TP4,"140.00");	
			softAssert.assertEquals(sheets.TP5,"0.00");	
			softAssert.assertEquals(sheets.TP6,"140.00");
			
			softAssert.assertEquals(sheets.TR1,"1,040.00");	
			softAssert.assertEquals(sheets.TR2,"2,080.00");	
			softAssert.assertEquals(sheets.TR3,"3,120.00");	
			softAssert.assertEquals(sheets.TR4,"1,040.00");	
			softAssert.assertEquals(sheets.TR5,"2,080.00");	
			softAssert.assertEquals(sheets.TR6,"3,120.00");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC518_ClaimsFinancials"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
}
