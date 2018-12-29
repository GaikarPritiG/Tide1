package com.tide.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.PercentageReportingPage;
import com.tide.qa.utility.Report;

public class PercentageReportingTests extends TestBase {
	
	
	PercentageReportingPage percentagereporting = new PercentageReportingPage();
	
	@Test(priority = 106, groups={"TC4136PercentageReportingWithErrors"})
	public void TC4136PercentageReportingWithErrors(){
		
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			percentagereporting.TC4136PercentageReporting();
			softAssert.assertEquals(percentagereporting.errorTitleValidate, "Invalid percentage values identified");
			softAssert.assertEquals(percentagereporting.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(percentagereporting.Rowno1, "5");
			softAssert.assertEquals(percentagereporting.Rowno2, "6");
			
			softAssert.assertEquals(percentagereporting.CCP1, "0.50 %");
			softAssert.assertEquals(percentagereporting.CCP2, "50.00 %");
			
			softAssert.assertEquals(percentagereporting.ActualDPVCOriginal1, "0.5");
			softAssert.assertEquals(percentagereporting.ActualDPVCChanged1, "50.00");
			softAssert.assertEquals(percentagereporting.ActualDPVCRuleName1, "Convert decimal values in percentage fields to a percentage value");
			
			softAssert.assertEquals(percentagereporting.ActualDPVCOriginal2, "500");
			softAssert.assertEquals(percentagereporting.ActualDPVCChanged2, "50.00");
			softAssert.assertEquals(percentagereporting.ActualDPVCRuleName2, "Validate Percentage values");
			
			softAssert.assertEquals(percentagereporting.ActualDPVCOriginal3, "0.5");
			softAssert.assertEquals(percentagereporting.ActualDPVCChanged3, "50.00");
			softAssert.assertEquals(percentagereporting.ActualDPVCRuleName3, "Convert decimal values in percentage fields to a percentage value");
			
			softAssert.assertEquals(percentagereporting.TTP, "50.00 %");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4136PercentageReportingWithErrors "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 

}
