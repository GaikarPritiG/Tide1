package com.tide.qa.pagefactory;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.utility.Report;

public class SimplifiedUploadPage {
	
	@Test(priority =15, groups={"TC424_Stage2TransactionTypeNotSupplied"})
	public void TC424_Stage2TransactionTypeNotSupplied()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			/*softAssert.assertEquals(s2.InvalidIntegerIdentified, "Invalid integer values identified");
			softAssert.assertEquals(s2.LocationSprinklers, "Location Sprinklers (Y/N) reference data translation required");
			softAssert.assertEquals(s2.InsuredCountryErrorScree, "Insured Country reference data translation required");
			softAssert.assertEquals(sheets.AssertBordereauStatus, "REVIEW");*/
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC424_Stage2TransactionTypeNotSupplied"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		}

}
