package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.CancellationDateReasonPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PeriodofCoverEnhancementPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class PeriodOfCoverEnhancementTests extends TestBase {

	PeriodofCoverEnhancementPage Enhancement = new PeriodofCoverEnhancementPage();
	CancellationDateReasonPage date =new CancellationDateReasonPage();
	LoginPage login = new LoginPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";

	@Test(priority =371, groups={"TC494_SeparateRiskInception"})
	public void TC494_SeparateRiskInception()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Enhancement.separateRiskInception_3765();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC494_SeparateRiskInception"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
		
	
}
}
