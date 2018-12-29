package com.tide.qa.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.RateOfExchangePage;
import com.tide.qa.pagefactory.SchemaPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class RateOfExchangeTests extends TestBase{

	RateOfExchangePage exchange = new RateOfExchangePage();
	SchemaPage schema= new SchemaPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority = 43, groups={"TC935_EditRateofExchange"})
	public void TC935_EditRateofExchange()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			exchange.editRateOfExchange_3376();
			softAssert.assertNotNull(exchange.Actualvalue);
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC935_EditRateofExchange"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 44, groups={"TC936_UploadinvalidRateofExchangeFile"},dependsOnMethods={"TC935_EditRateofExchange"})

	public void TC936_UploadinvalidRateofExchangeFile()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			exchange.uploadInvalidFile_3377();
			softAssert.assertNotNull(exchange.ExpectedError);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3377_UploadinvalidRateofExchangeFile"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 45, groups={"TC937_UploadvalidRateofExchangeFile"},dependsOnMethods={"TC935_EditRateofExchange"})
	public void TC937_UploadvalidRateofExchangeFile()
	{	
		SoftAssert softAssert = new SoftAssert();
		try
		{	
			
			exchange.uploadvalidFile_3378();
			softAssert.assertNotNull(exchange.TideExchangRateValue);
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3378_UploadvalidRateofExchangeFile"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}

	}
}
