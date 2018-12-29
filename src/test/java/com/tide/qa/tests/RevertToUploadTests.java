package com.tide.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.RevertToUploadPage;
import com.tide.qa.utility.Report;

public class RevertToUploadTests extends TestBase {
	
	RevertToUploadPage rtu = new RevertToUploadPage();
	
	
	@Test(priority = 107, groups={"TC4216RevertToUploadTests"})
	public void TC4216RevertToUploadTests()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			rtu.TC_4216_RevertToUpload();
			softAssert.assertEquals(rtu.errorTitleValidate1, "Location Sprinklers (Y/N) reference data translation required");	
			softAssert.assertEquals(rtu.AssertBordereauStatusUploaded, "UPLOADED");
			softAssert.assertEquals(rtu.submmitbordereautitle, "Submit Bordereau");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4216RevertToUploadTests"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}  

}
