package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class InvalidFinancialValueTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";

	@Test(priority =361, groups={"TC1284_FinancialFieldEnterCharacter"})
	public void TC1284_FinancialFieldEnterCharacter()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.EnterCharacterFinantialfields_3373();
			softAssert.assertEquals(sheets.InvalidFinancialErrorScreentext, "Invalid financial value translation required");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1284_FinancialFieldEnterCharacter "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =362, groups={"TC1289_Calculation_GPIncludingTax"})
	public void TC1289_Calculation_GPIncludingTax()

	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_GrossPremiumIncludingTax();
			softAssert.assertEquals(sheets.Row1Text, "100.00");
			softAssert.assertEquals(sheets.Row2Text, "100.00");
			softAssert.assertEquals(sheets.Row3Text, "0.00");
			softAssert.assertEquals(sheets.Row4Text, "0.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1289_Calculation_GPIncludingTax"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	} 

	@Test(priority =363, groups={"TC1290_Calculation_GrossPremium"})
	public void TC1290_Calculation_GrossPremium()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_GrossPremium();
			softAssert.assertEquals(sheets.Row1Text, "100.00");
			softAssert.assertEquals(sheets.Row2Text, "100.00");
			softAssert.assertEquals(sheets.Row3Text, "0.00");
			softAssert.assertEquals(sheets.Row4Text, "0.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1290_Calculation_GrossPremium"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =364, groups={"TC1291_Calculation_CoverholderCommission"})
	public void TC1291_Calculation_CoverholderCommission()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_CoverholderCommission();
			softAssert.assertEquals(sheets.Row1Text, "124.50");
			softAssert.assertEquals(sheets.Row2Text, "124.50");
			softAssert.assertEquals(sheets.Row3Text, "0.00");
			softAssert.assertEquals(sheets.Row4Text, "0.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1291_Calculation_CoverholderCommission"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =365, groups={"TC1299_Calculation_CC_Percent"})
	public void TC1299_Calculation_CC_Percent()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_CoverholderCommission_Percent();
			softAssert.assertEquals(sheets.Row1Text, "124.50 %");
			softAssert.assertEquals(sheets.Row2Text, "124.50 %");
			softAssert.assertEquals(sheets.Row3Text, "0.00 %");
			softAssert.assertEquals(sheets.Row4Text, "0.00 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1299_Calculation_CC_Percent"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =366, groups={"TC1293_Calculation_NetPremium"})
	public void TC1293_Calculation_NetPremium()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_NetPremium();
			softAssert.assertEquals(sheets.Row1Text, "-24.50");
			softAssert.assertEquals(sheets.Row2Text, "-24.50");
			softAssert.assertEquals(sheets.Row3Text, "-124.50");
			softAssert.assertEquals(sheets.Row4Text, "0.00");
			softAssert.assertEquals(sheets.Row5Text, "1,537.00");
			softAssert.assertEquals(sheets.Row6Text, "75.50");
			softAssert.assertEquals(sheets.Row7Text, "100.00");
			softAssert.assertEquals(sheets.Row8Text, "0.00");
			softAssert.assertEquals(sheets.Row9Text, "-24.50");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1293_Calculation_NetPremium"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =367, groups={"TC1294_CorefinancialCalculation_Brokerage"})
	public void TC1294_CorefinancialCalculation_Brokerage()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_Brokerage();
			softAssert.assertEquals(sheets.Row1Text, "5.00");
			softAssert.assertEquals(sheets.Row2Text, "5.00");
			softAssert.assertEquals(sheets.Row3Text, "5.00");
			softAssert.assertEquals(sheets.Row4Text, "5.00");
			softAssert.assertEquals(sheets.Row5Text, "76.85");
			softAssert.assertEquals(sheets.Row6Text, "5.00");
			softAssert.assertEquals(sheets.Row7Text, "5.00");
			softAssert.assertEquals(sheets.Row8Text, "20.00");
			softAssert.assertEquals(sheets.Row9Text, "5.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1294_CorefinancialCalculation_Brokerage"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	} 

	@Test(priority =368, groups={"TC1295_Calculation_BrokeragePercent"})
	public void TC1295_Calculation_BrokeragePercent()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_BrokeragePercent();
			softAssert.assertEquals(sheets.Row1Text, "5.00 %");
			softAssert.assertEquals(sheets.Row2Text, "5.00 %");
			softAssert.assertEquals(sheets.Row3Text, "0.00 %");
			softAssert.assertEquals(sheets.Row4Text, "0.00 %");
			softAssert.assertEquals(sheets.Row5Text, "5.00 %");
			softAssert.assertEquals(sheets.Row6Text, "5.00 %");
			softAssert.assertEquals(sheets.Row7Text, "5.00 %");
			softAssert.assertEquals(sheets.Row8Text, "0.00 %");
			softAssert.assertEquals(sheets.Row9Text, "5.00 %");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC1295_Calculation_BrokeragePercent"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =369, groups={"TC1296_Calculation_FinalNetPremium"})
	public void TC1296_Calculation_FinalNetPremium()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.financialCalculation_FinalNetPremium();
			softAssert.assertEquals(sheets.Row1Text, "-29.50");
			softAssert.assertEquals(sheets.Row2Text, "-29.50");
			softAssert.assertEquals(sheets.Row3Text, "-129.50");
			softAssert.assertEquals(sheets.Row4Text, "-5.00");
			softAssert.assertEquals(sheets.Row5Text, "1,460.15");
			softAssert.assertEquals(sheets.Row6Text, "70.50");
			softAssert.assertEquals(sheets.Row7Text, "95.00");
			softAssert.assertEquals(sheets.Row8Text, "-20.00");
			softAssert.assertEquals(sheets.Row9Text, "-29.50");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC1296_Calculation_FinalNetPremium"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =611, groups={"TC1287_ProcessBorderoWithDefaulstRisk"})
	public void TC1287_ProcessBorderoWithDefaulstRisk()
	{		
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername2, AdminPassword2);
			sheets.ProcessBorderoWithDefaulstRisk_3429();
			softAssert.assertNotEquals(sheets.ActualFirstRow, "1,326.02");
			softAssert.assertNotEquals(sheets.ActualSecondRow, "1,813.90");
			softAssert.assertNotEquals(sheets.ActualFirstRowGross, "622.50");
			softAssert.assertNotEquals(sheets.ActualSecondRowGross, "2,134.00");
			softAssert.assertNotEquals(sheets.ActualFirstRowCC, "62.25");
			softAssert.assertNotEquals(sheets.ActualSecondRowCC, "213.40");		
			softAssert.assertNotEquals(sheets.ActualFirstRowNP, "1,404.05");
			softAssert.assertNotEquals(sheets.ActualSecondRowNP, "1,920.60");		
			softAssert.assertNotEquals(sheets.ActualFirstRowLB, "78.03");
			softAssert.assertNotEquals(sheets.ActualSecondRowLB, "106.70");					
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1287_ProcessBorderoWithDefaulstRisk "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =612, groups={"TC1288_ProcessBorderoWithRisk"})
	public void TC1288_ProcessBorderoWithRisk()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.ProcessBorderoWithRisk_3430();
			softAssert.assertEquals(sheets.ActualFirstRO,"80.00 %");
			softAssert.assertEquals(sheets.ActualSecondRO,"100.00 %");
		//	softAssert.assertEquals(sheets.ActualThirdRO,"60.00 %");
			softAssert.assertEquals(sheets.ActualFirstGP,"996.00");
			softAssert.assertEquals(sheets.ActualSecondGP,"4,268.00");
			softAssert.assertEquals(sheets.ActualThirdGP,"53,130.00");
			softAssert.assertEquals(sheets.ActualFirstCC,"99.60");
			softAssert.assertEquals(sheets.ActualSecondCC,"426.80");
			softAssert.assertEquals(sheets.ActualThirdCC,"5,313.00");		
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1288_ProcessBorderoWithRisk "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =613, groups={"TC498_UseLeftCharactersRiskReference"})
	public void TC498_UseLeftCharactersRiskReference()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.useLeftCharactersRiskReference();
			softAssert.assertEquals(sheets.RiskReferenceColumnText, "Risk Reference");
			softAssert.assertEquals(sheets.RF1, "10");
			softAssert.assertEquals(sheets.RF2, "11");
			softAssert.assertEquals(sheets.RF3, "22");
			softAssert.assertEquals(sheets.RF4, "33");
			softAssert.assertEquals(sheets.RF5, "44");
			softAssert.assertEquals(sheets.RF6, "55");
			softAssert.assertEquals(sheets.RF7, "66");
			softAssert.assertEquals(sheets.RF8, "77");
			softAssert.assertEquals(sheets.RF9, "88");
			softAssert.assertEquals(sheets.RF10, "99");	
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC498_UseLeftCharactersRiskReference "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =614, groups={"TC499_DeleteRowsBasedSingleColumn"})

	public void TC499_DeleteRowsBasedSingleColumn()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.deleteRowsBasedSingleColumn();
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC499_DeleteRowsBasedSingleColumn "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =615, groups={"TC500_DeleteRowsBasedMultipleColumn"})
	public void TC500_DeleteRowsBasedMultipleColumn()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.deleteRowsBasedMultipleColumn();
			softAssert.assertEquals(sheets.RF1, "11");
			softAssert.assertEquals(sheets.RF2, "22");
			softAssert.assertEquals(sheets.RF3, "33");
			softAssert.assertEquals(sheets.RF4, "36");
			softAssert.assertEquals(sheets.RF5, "44");
			softAssert.assertEquals(sheets.RF6, "55");
			softAssert.assertEquals(sheets.RF7, "66");
			softAssert.assertEquals(sheets.RF8, "77");
			softAssert.assertEquals(sheets.RF9, "88");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC500_DeleteRowsBasedMultipleColumn "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =616, groups={"TC501_RiskBordereauxonCCLookup"})
	public void TC501_RiskBordereauxonCCLookup()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.riskBordereauxonContractCurrencyLookup();
			softAssert.assertEquals(sheets.PremiumCurColumn, "Premium Currency");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC501_RiskBordereauxonCCLookup "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority =617, groups={"TC502_AdvancedOption"})
	public void TC502_AdvancedOption()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.advancedOption();
			softAssert.assertEquals(sheets.GP1, "100.00");
			softAssert.assertEquals(sheets.GP2, "100.00");
			softAssert.assertEquals(sheets.GP3, "100.00");
			softAssert.assertEquals(sheets.GP4, "100.00");
			softAssert.assertEquals(sheets.GP5, "100.00");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC502_AdvancedOption "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =618, groups={"TC1300_Calculate_tax_fieldsBySelecting_yes_OnlyOne_option"})
	public void TC1300_Calculate_tax_fieldsBySelecting_yes_OnlyOne_option()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
	 		sheets.TC4476_CalculateTaxBySelecting_Yes_OnlyOne_option();
	 		softAssert.assertEquals(sheets.TTax1,"5.00 %");
	 		softAssert.assertEquals(sheets.TTax2,"5.00 %");
	 		softAssert.assertEquals(sheets.TTax10,"5.00 %");
	 		softAssert.assertEquals(sheets.TTax11,"5.00 %");
	 		softAssert.assertEquals(sheets.TFR1,"10.00");
	 		softAssert.assertEquals(sheets.TFR2,"10.50");
	 		softAssert.assertEquals(sheets.TFR10,"14.50");
	 		softAssert.assertEquals(sheets.TFR11,"15.00");
	 		softAssert.assertEquals(sheets.TM1,"5.00");
	 		softAssert.assertEquals(sheets.TM2,"5.50");
	 		softAssert.assertEquals(sheets.TM9,"9.00");
	 		softAssert.assertEquals(sheets.TM10,"9.50");
	 		softAssert.assertEquals(sheets.TM11,"10.00");
	 		softAssert.assertEquals(sheets.TP1,"100.00");
	 		softAssert.assertEquals(sheets.TP2,"100.00");
	 		softAssert.assertEquals(sheets.TP9,"104.00");
	 		softAssert.assertEquals(sheets.TP10,"104.50");
	 		softAssert.assertEquals(sheets.TP11,"105.00");	
	 		softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1300_Calculate_tax_fieldsBySelecting_yes_OnlyOne_option "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	@Test(priority =619, groups={"TC1301_CalculateTaxWithOutadditonalTax"})

	public void TC1301_CalculateTaxWithOutadditonalTax()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.TC4477_CalculateTaxWithOutadditonalTax();
			softAssert.assertEquals(sheets.TTax1,"5.00 %");
	 		softAssert.assertEquals(sheets.TTax2,"5.00 %");
	 		softAssert.assertEquals(sheets.TTax10,"5.00 %");
	 		softAssert.assertEquals(sheets.TTax11,"5.00 %");
	 		softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1301_CalculateTaxWithOutadditonalTax "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =620, groups={"TC1302_CalculateTaxWithadditonalTax"})
	public void TC1302_CalculateTaxWithadditonalTax()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.CalculateTaxWithadditonalTax_TC4478();
			softAssert.assertEquals(sheets.TTax1,"11.00");
	 		softAssert.assertEquals(sheets.TTax2,"11.00");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1302_CalculateTaxWithadditonalTax "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
}
