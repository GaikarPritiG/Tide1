package com.tide.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.CSVProcessing;
import com.tide.qa.pagefactory.CoverageExpert;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class CoverageExpertTest  extends TestBase {
	
	
	LoginPage login = new LoginPage();
	CoverageExpert coverage = new CoverageExpert();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	String AdminUsername = "priti@systenics.net";
	String AdminPassword = "test1234@";
	

	@Test(priority =658, groups={"TC1900_BordereauProcessingaddCoverage"})
	public void TC1900_BordereauProcessingaddCoverage()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			coverage.BordereauProcessingaddCoverage_TC1900();
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(coverage.EWaterflag, "Yes");
			softAssert.assertEquals(coverage.EWaterCurrency, "USD");
			softAssert.assertEquals(coverage.EWaterTSI, "1,000.00");
			softAssert.assertEquals(coverage.EWaterLimit, "2.50");
			softAssert.assertEquals(coverage.EWaterType, "Excess");
			softAssert.assertEquals(coverage.EWaterAmount, "5.00");
			softAssert.assertEquals(coverage.EWaterPercent, "5.50 %");
			softAssert.assertEquals(coverage.EWaterBasis, "Each and every interest");
			softAssert.assertEquals(coverage.EWaterPremium, "100.00");
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1900_BordereauProcessingaddCoverage "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 659, groups={"TC1903_BordereauProcessaddEditCoverage"})
	public void TC1903_BordereauProcessaddEditCoverage()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			coverage.BordereauProcessaddEditCoverage_TC1903();
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(coverage.EarthIFlag1, "Yes");
			softAssert.assertEquals(coverage.EarthCurrency1, "USD");
			softAssert.assertEquals(coverage.EarthTSI1, "1,000.00");
			softAssert.assertEquals(coverage.EarthLimit1, "2.50");
			softAssert.assertEquals(coverage.EarthType1, "Excess");
			softAssert.assertEquals(coverage.EarthAmount1, "5.00");
			softAssert.assertEquals(coverage.EarthPercent1, "5.50 %");
			softAssert.assertEquals(coverage.EarthBasis1, "Each and every interest");
			softAssert.assertEquals(coverage.EarthPremium1, "100.00");
			
			softAssert.assertEquals(coverage.TerrorismIFlag1, "Yes");
			softAssert.assertEquals(coverage.TerrorismCurrency1, "USD");
			softAssert.assertEquals(coverage.TerrorismTSI1, "1,000.00");
			softAssert.assertEquals(coverage.TerrorismLimit1, "2.50");
			softAssert.assertEquals(coverage.TerrorismType1, "Excess");
			softAssert.assertEquals(coverage.TerrorismAmount1, "5.00");
			softAssert.assertEquals(coverage.TerrorismPercent1, "5.50 %");
			softAssert.assertEquals(coverage.TerrorismBasis1, "Each and every interest");
			softAssert.assertEquals(coverage.TerrorismPremium1, "100.00");
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1903_BordereauProcessaddEditCoverage "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 660, groups={"TC1905_BordereauProcessDeleteCoverage"})
	public void TC1905_BordereauProcessDeleteCoverage()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			coverage.BordereauProcessDeleteCoverage_TC1905();
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1905_BordereauProcessDeleteCoverage "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 661, groups={"TC3810_ClaimBordereauProcessAddExpert"})
	public void TC3810_ClaimBordereauProcessAddExpert()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			coverage.ClaimBordereauProcessAddExperte_TC3810();
			//softAssert.assertEquals(coverage.CName1, "Escape of Water Company Name - 1");
			softAssert.assertEquals(coverage.ActualCName1, "Company 1");
			softAssert.assertEquals(coverage.ActualCName2, "Company 2");
			//.assertEquals(coverage.ActualCref, "Escape of Water Company Reference - 1");
			softAssert.assertEquals(coverage.ActualCref1, "Company Reference 1");
			//softAssert.assertEquals(coverage.ActualCAdd, "Escape of Water Company Address - 1");
			softAssert.assertEquals(coverage.ActualCAdd1, "88 Frnech Road");
		   // softAssert.assertEquals(coverage.ActualCState, "Escape of Water Company State - 1");
			softAssert.assertEquals(coverage.ActualCState1, "Australia");
			//softAssert.assertEquals(coverage.ActualCPostalCode, "Escape of Water Company Postal Code - 1");
			softAssert.assertEquals(coverage.ActualCPostalCode1, "SW12 879");
			//softAssert.assertEquals(coverage.ActualCCountry, "Escape of Water Company Country - 1");
			softAssert.assertEquals(coverage.ActualCCountry1, "United Kingdom");
			
			//softAssert.assertEquals(coverage.CName2, "Escape of Water Company Name - 2");
			softAssert.assertEquals(coverage.ActualCName_1, "Company 1");
			softAssert.assertEquals(coverage.ActualCName_2, "Company 2");
			//softAssert.assertEquals(coverage.ActualCref2, "Escape of Water Company Reference - 2");
			softAssert.assertEquals(coverage.ActualCref_1, "Company Reference 1");
			//softAssert.assertEquals(coverage.ActualCAdd2, "Escape of Water Company Address - 2");
			softAssert.assertEquals(coverage.ActualCAdd_1, "88 Frnech Road");
			//softAssert.assertEquals(coverage.ActualCState2, "Escape of Water Company State - 2");
			softAssert.assertEquals(coverage.ActualCState_1, "Australia");
			//softAssert.assertEquals(coverage.ActualCPostalCode2, "Escape of Water Company Postal Code - 2");
			softAssert.assertEquals(coverage.ActualCPostalCode_1, "SW12 879");
			//softAssert.assertEquals(coverage.ActualCCountry2, "Escape of Water Company Country - 2");
			softAssert.assertEquals(coverage.ActualCCountry_1, "United Kingdom");
			
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3810_ClaimBordereauProcessAddExpert "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 662, groups={"TC1911_ClaimBordereauProcessEditExpert"})
	public void TC1911_ClaimBordereauProcessEditExpert()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			coverage.ClaimBordereauProcessEditExpert_TC1911();
			softAssert.assertEquals(coverage.ActualCName1, "Company 1");
			softAssert.assertEquals(coverage.ActualCName2, "Company 2");
			softAssert.assertEquals(coverage.ActualCref1, "Company Reference 1");
			softAssert.assertEquals(coverage.ActualCAdd1, "88 Frnech Road");
			softAssert.assertEquals(coverage.ActualCState1, "Australia");
			softAssert.assertEquals(coverage.ActualCPostalCode1, "SW12 879");
			softAssert.assertEquals(coverage.ActualCCountry1, "United Kingdom");
			
			
			softAssert.assertEquals(coverage.ActualCName_1, "Company 1");
			softAssert.assertEquals(coverage.ActualCName_2, "Company 2");
			softAssert.assertEquals(coverage.ActualCref_1, "Company Reference 1");
			softAssert.assertEquals(coverage.ActualCAdd_1, "88 Frnech Road");
			softAssert.assertEquals(coverage.ActualCState_1, "Australia");
			softAssert.assertEquals(coverage.ActualCPostalCode_1, "SW12 879");
			softAssert.assertEquals(coverage.ActualCCountry_1, "United Kingdom");
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1911_ClaimBordereauProcessEditExpert"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 663, groups={"TC1912_ClaimBordereauProcessDeleteExpert"})
	public void TC1912_ClaimBordereauProcessDeleteExpert()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			coverage.ClaimBordereauProcessDeleteExpert_TC1912();
			softAssert.assertEquals(coverage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1912_ClaimBordereauProcessDeleteExpert "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

}
