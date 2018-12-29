package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.RemoveCommasInHeaderRow;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class RemoveCommasInHeaderRowTests extends TestBase {

	RemoveCommasInHeaderRow headerrow = new RemoveCommasInHeaderRow();
	
	@Test(priority = 102, groups={"TC1827RemoveCommasInHeaderRow"})
	public void TC1827RemoveCommasInHeaderRow()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			headerrow.TC_1827_RemoveCommasInHeaderRow();
			softAssert.assertEquals(headerrow.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1827RemoveCommasInHeaderRow"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}  
}
