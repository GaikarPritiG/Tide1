package com.tide.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialMultiFieldSelection;
import com.tide.qa.utility.Report;

public class FinancialMultiFieldSelectionTests extends TestBase {

	FinancialMultiFieldSelection  financialmultselect = new FinancialMultiFieldSelection();
	
	@Test(priority = 105, groups={"TC4106FinancialMultiFieldSelectionTests"})
	public void TC4106FinancialMultiFieldSelectionTests()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			financialmultselect.TC_4106_FinancialMultiFieldSelection();
			softAssert.assertEquals(financialmultselect.AssertBordereauStatusReview,"REVIEW");
			
			softAssert.assertEquals(financialmultselect.RN1, "7");
			softAssert.assertEquals(financialmultselect.RN2, "8");
			softAssert.assertEquals(financialmultselect.RN3, "9");
			softAssert.assertEquals(financialmultselect.RN4, "10");
			
			softAssert.assertEquals(financialmultselect.GP1, "44,510.30");
			softAssert.assertEquals(financialmultselect.GP2, "23,875.30");
			softAssert.assertEquals(financialmultselect.GP3, "23,875.00");
			softAssert.assertEquals(financialmultselect.GP4, "23,900.00");
			
			softAssert.assertEquals(financialmultselect.CM1, "27,489.70");
			softAssert.assertEquals(financialmultselect.CM2, "12,124.70");
			softAssert.assertEquals(financialmultselect.CM3, "12,125.00");
			softAssert.assertEquals(financialmultselect.CM4, "12,100.00");
			
			softAssert.assertEquals(financialmultselect.NP1, "44,510.30");
			softAssert.assertEquals(financialmultselect.NP2, "23,875.30");
			softAssert.assertEquals(financialmultselect.NP3, "23,875.00");
			softAssert.assertEquals(financialmultselect.NP4, "23,900.00");
			
			softAssert.assertEquals(financialmultselect.Bk1, "25,200.00");
			softAssert.assertEquals(financialmultselect.Bk2, "12,600.00");
			softAssert.assertEquals(financialmultselect.Bk3, "12,600.00");
			softAssert.assertEquals(financialmultselect.Bk4, "12,600.00");
			
			softAssert.assertEquals(financialmultselect.TIV1, "111,000.00");
			softAssert.assertEquals(financialmultselect.TIV2, "111,000.00");
			softAssert.assertEquals(financialmultselect.TIV3, "111,000.00");
			softAssert.assertEquals(financialmultselect.TIV4, "111,000.00");
			
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4106FinancialMultiFieldSelectionTests"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}  
}
