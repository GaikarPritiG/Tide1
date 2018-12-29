package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.CancellationDateReasonPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class CancellationDateReasonTests extends TestBase {

	CancellationDateReasonPage date = new CancellationDateReasonPage();
	LoginPage login = new LoginPage();
	
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";

	@Test(priority =372, groups={"TC495_CancellationDate"})
	public void TC495_CancellationDate()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			date.cancellationDate_3767();
			softAssert.assertEquals(date.ActualCancellationDateRow, date.ExpectedCancellationDateRow, "Cancellation Date not matching");
			softAssert.assertEquals(date.ActualCancellationReasonRow, date.ExpectedCancellationReasonRow,"Cancellation Reason not matching");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC495_CancellationDate"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
		
	}

}
