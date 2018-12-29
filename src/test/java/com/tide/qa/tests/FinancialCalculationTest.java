package com.tide.qa.tests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialCalculationPage;
import com.tide.qa.pagefactory.LoginPage;

import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class FinancialCalculationTest extends TestBase
{

	FinancialCalculationPage sheets1 = new FinancialCalculationPage();
	LoginPage login = new LoginPage();

	@Test(priority = 1180 , groups={"TC1684_FinancialTestScenario_02"})
	public void TC1684_FinancialTestScenario_02()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(2);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1684_FinancialTestScenario_02"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1181 , groups={"TC1685_FinancialTestScenario_03"})
	public void TC1685_FinancialTestScenario_03()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(3);
			
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1685_FinancialTestScenario_03"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1182 , groups={"TC1686_FinancialTestScenario_04"})
	public void TC1686_FinancialTestScenario_04()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(4);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1686_FinancialTestScenario_04"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
//	@Test(priority = 1014 , groups={"TC1687_FinancialTestScenario_05"})
//	public void TC1687_FinancialTestScenario_05()
//	{
//		SoftAssert softAssert = new SoftAssert();
//		try
//		{
//			sheets1.FinancialTestScenario(5);
//			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
//			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
//			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "60.00");
//			softAssert.assertEquals(sheets1.ActualCoverHolderCommissionPercent, "6.00 %");
//			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
//			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
//		}catch(Exception e)
//		{
//			Report.LogInfo("Exception", "Exception in TC1687_FinancialTestScenario_05"+e.getMessage(), "FAIL");
//			softAssert.fail(e.getMessage());
//		}finally {
//			softAssert.assertAll();
//		}
//	
//	}
//	
	
	@Test(priority = 1183 , groups={"TC1688_FinancialTestScenario_06"})
	public void TC1688_FinancialTestScenario_06()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(6);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommissionPercent, "10.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualBrokeragePercent, "5.00 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1688_FinancialTestScenario_06"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1184 , groups={"TC1689_FinancialTestScenario_07"})
	public void TC1689_FinancialTestScenario_07()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(7);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercentcnvrtDecml, "10.00 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1689_FinancialTestScenario_07"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1185 , groups={"TC1690_FinancialTestScenario_08"})
	public void TC1690_FinancialTestScenario_08()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(8);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1690_FinancialTestScenario_08"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1186 , groups={"TC1691_FinancialTestScenario_09"})
	public void TC1691_FinancialTestScenario_09()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(9);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,100.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1691_FinancialTestScenario_09"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1187 , groups={"TC1692_FinancialTestScenario_10"})
	public void TC1692_FinancialTestScenario_10()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(10);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,100.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1692_FinancialTestScenario_10"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1188 , groups={"TC1693_FinancialTestScenario_11"})
	public void TC1693_FinancialTestScenario_11()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(11);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1693_FinancialTestScenario_11"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1189 , groups={"TC1694_FinancialTestScenario_12"})
	public void TC1694_FinancialTestScenario_12()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(12);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommissionPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1694_FinancialTestScenario_12"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1190 , groups={"TC1695_FinancialTestScenario_13"})
	public void TC1695_FinancialTestScenario_13()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(13);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1695_FinancialTestScenario_13"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1191 , groups={"TC1696_FinancialTestScenario_14"})
	public void TC1696_FinancialTestScenario_14()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(14);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");

			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "800.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "750.00");
			softAssert.assertEquals(sheets1.ActualProducingBrokeragePercent, "10.00 %");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1696_FinancialTestScenario_14"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1192 , groups={"TC1697_FinancialTestScenario_15"})
	public void TC1697_FinancialTestScenario_15()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(15);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "800.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "750.00");
			softAssert.assertEquals(sheets1.ActualProducingBrokerage, "100.00");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1697_FinancialTestScenario_15"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1193 , groups={"TC1698_FinancialTestScenario_16"})
	public void TC1698_FinancialTestScenario_16()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(16);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "800.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "750.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1698_FinancialTestScenario_16"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1194 , groups={"TC1699_FinancialTestScenario_17"})
	public void TC1699_FinancialTestScenario_17()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(17);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1699_FinancialTestScenario_17"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1195 , groups={"TC1700_FinancialTestScenario_18"})
	public void TC1700_FinancialTestScenario_18()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(18);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1700_FinancialTestScenario_18"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1196 , groups={"TC1701_FinancialTestScenario_19"})
	public void TC1701_FinancialTestScenario_19()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(19);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
			softAssert.assertEquals(sheets1.ActualProducingBrokerage, "100.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1701_FinancialTestScenario_19"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1197 , groups={"TC1702_FinancialTestScenario_20"})
	public void TC1702_FinancialTestScenario_20()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(20);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
			softAssert.assertEquals(sheets1.ActualProducingBrokeragePercent, "12.50 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1702_FinancialTestScenario_20"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1198 , groups={"TC1703_FinancialTestScenario_21"})
	public void TC1703_FinancialTestScenario_21()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(21);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1703_FinancialTestScenario_21"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
//	@Test(priority = 1031 , groups={"TC1704_FinancialTestScenario_22"})
//	public void TC1704_FinancialTestScenario_22()
//	{
//		SoftAssert softAssert = new SoftAssert();
//		try
//		{
//			sheets1.FinancialTestScenario(22);
//			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
//			softAssert.assertEquals(sheets1.ActualGrossPremium, "1,000.00");
//			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
//			softAssert.assertEquals(sheets1.ActualCoverHolderCommissionPercent, "10.00 %");
//			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
//			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
//			
//		}catch(Exception e)
//		{
//			Report.LogInfo("Exception", "Exception in TC1704_FinancialTestScenario_22"+e.getMessage(), "FAIL");
//			softAssert.fail(e.getMessage());
//		}finally {
//			softAssert.assertAll();
//		}
//	
//	}
	
	@Test(priority = 1199 , groups={"TC1705_FinancialTestScenario_23"})
	public void TC1705_FinancialTestScenario_23()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(23);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,100.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1705_FinancialTestScenario_23"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1200 , groups={"TC1706_FinancialTestScenario_24"})
	public void TC1706_FinancialTestScenario_24()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(24);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "900.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1706_FinancialTestScenario_24"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1201 , groups={"TC1707_FinancialTestScenario_25"})
	public void TC1707_FinancialTestScenario_25()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(25);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "1,000.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "950.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1707_FinancialTestScenario_25"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1202 , groups={"TC1708_FinancialTestScenario_26"})
	public void TC1708_FinancialTestScenario_26()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(26);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "900.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1708_FinancialTestScenario_26"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1203 , groups={"TC1709_FinancialTestScenario_27"})
	public void TC1709_FinancialTestScenario_27()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(27);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1709_FinancialTestScenario_27"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
//	@Test(priority = 1037 , groups={"TC1710_FinancialTestScenario_28"})
//	public void TC1710_FinancialTestScenario_28()
//	{
//		SoftAssert softAssert = new SoftAssert();
//		try
//		{
//			sheets1.FinancialTestScenario(28);
//			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
//			softAssert.assertEquals(sheets1.ActualGrossPremium, "1,000.00");
//			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
//			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
//			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
//			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "850.00");
//		}catch(Exception e)
//		{
//			Report.LogInfo("Exception", "Exception in TC1710_FinancialTestScenario_28"+e.getMessage(), "FAIL");
//			softAssert.fail(e.getMessage());
//		}finally {
//			softAssert.assertAll();
//		}
//	
//	}
	
	@Test(priority = 1204 , groups={"TC1711_FinancialTestScenario_29"})
	public void TC1711_FinancialTestScenario_29()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(29);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualNetPremium, "1,000.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "1,000.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1711_FinancialTestScenario_29"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1205 , groups={"TC1712_FinancialTestScenario_30"})
	public void TC1712_FinancialTestScenario_30()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(30);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "900.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1712_FinancialTestScenario_30"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1206 , groups={"TC1713_FinancialTestScenario_31"})
	public void TC1713_FinancialTestScenario_31()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(31);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "1,000.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1713_FinancialTestScenario_31"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1207 , groups={"TC1714_FinancialTestScenario_32"})
	public void TC1714_FinancialTestScenario_32()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(32);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "150.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "850.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "750.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1714_FinancialTestScenario_32"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1208 , groups={"TC1715_FinancialTestScenario_33"})
	public void TC1715_FinancialTestScenario_33()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(33);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "150.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "800.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1715_FinancialTestScenario_33"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1209 , groups={"TC1716_FinancialTestScenario_34"})
	public void TC1716_FinancialTestScenario_34()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(34);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualGrossPremiumIncludingTax, "1,000.00");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "150.00");
			softAssert.assertEquals(sheets1.ActualNetPremium, "850.00");
			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "100.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1716_FinancialTestScenario_34"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1210 , groups={"TC1717_FinancialTestScenario_35"})
	public void TC1717_FinancialTestScenario_35()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(35);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommissionPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualBrokeragePercent, "5.00 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1717_FinancialTestScenario_35"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
//	@Test(priority = 1045 , groups={"TC1718_FinancialTestScenario_36"})
//	public void TC1718_FinancialTestScenario_36()
//	{
//		SoftAssert softAssert = new SoftAssert();
//		try
//		{
//			sheets1.FinancialTestScenario(36);
//			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
//			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
//			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
//			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
//			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
//		}catch(Exception e)
//		{
//			Report.LogInfo("Exception", "Exception in TC1718_FinancialTestScenario_36"+e.getMessage(), "FAIL");
//			softAssert.fail(e.getMessage());
//		}finally {
//			softAssert.assertAll();
//		}
//	
//	}
//	
//	@Test(priority = 1046 , groups={"TC1719_FinancialTestScenario_37"})
//	public void TC1719_FinancialTestScenario_37()
//	{
//		SoftAssert softAssert = new SoftAssert();
//		try
//		{
//			sheets1.FinancialTestScenario(37);
//			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
//			
//			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
//			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
//			softAssert.assertEquals(sheets1.ActualCoverHolderCommission, "100.00");
//			softAssert.assertEquals(sheets1.ActualBrokerageAmount, "50.00");
//			softAssert.assertEquals(sheets1.ActualProducingBrokerage, "100.00");
//		}catch(Exception e)
//		{
//			Report.LogInfo("Exception", "Exception in TC1719_FinancialTestScenario_37"+e.getMessage(), "FAIL");
//			softAssert.fail(e.getMessage());
//		}finally {
//			softAssert.assertAll();
//		}
//	
//	}
	

	@Test(priority = 1211 , groups={"TC1720_FinancialTestScenario_38"})
	public void TC1720_FinancialTestScenario_38()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.FinancialTestScenario(38);
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");

			softAssert.assertEquals(sheets1.ActualTaxAmount, "100.00");
			softAssert.assertEquals(sheets1.ActualTaxAmountPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualCoverHolderCommissionPercent, "10.00 %");
			softAssert.assertEquals(sheets1.ActualNetPremium, "675.00");
			softAssert.assertEquals(sheets1.ActualBrokeragePercent, "5.00 %");
			softAssert.assertEquals(sheets1.ActualFinalNetPremium, "625.00");
			softAssert.assertEquals(sheets1.ActualProducingBrokeragePercent, "12.50 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1720_FinancialTestScenario_38"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 1212 , groups={"TC3419_LargeFinancialCalculation"})
	public void TC3419_LargeFinancialCalculation()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets1.LargeFinancialCalculation_TC3419();
			softAssert.assertEquals(sheets1.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets1.ErrorPageValidate, "Invalid financial value translation required");
			softAssert.assertEquals(sheets1.ErrorPageValidate1, "Large Financial Values Identified");
			softAssert.assertTrue(sheets1.BooleanFlag);
			softAssert.assertTrue(sheets1.BooleanFlag1);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1720_FinancialTestScenario_38"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	
	}
	
}
