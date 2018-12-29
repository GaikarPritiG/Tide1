package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class CreditControlTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	Stage2Page s2 = new Stage2Page();
	LoginPage login = new LoginPage();
	PolicyPage policy = new PolicyPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority =62, groups={"TC784_CreditControl"})
	public void TC784_CreditControl()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			s2.CreditControl_3671();
			softAssert.assertEquals(s2.ActualValue1, "Fully Paid");
			softAssert.assertEquals(s2.ActualValue2, "Unpaid");
			softAssert.assertEquals(s2.ActualValue3, "Partially Paid");
			softAssert.assertEquals(s2.ActualValue4, "Over Paid");
			softAssert.assertEquals(s2.ActualValue5, "1,000.00");
			softAssert.assertEquals(s2.ActualValue6, "1,000.00");
			softAssert.assertEquals(s2.ActualValue7, "1,000.00");
			softAssert.assertEquals(s2.ActualValue8, "1,000.00");		

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC784_CreditControl"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
			
}
}
