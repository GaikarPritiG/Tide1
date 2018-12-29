package com.tide.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.DefaultCurrencyChangeRulePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

public class DefaultCurrencyChangeRuleTests extends TestBase {
	DefaultCurrencyChangeRulePage defaultccyrule = new DefaultCurrencyChangeRulePage();
	SoftAssert softAssert = new SoftAssert();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	
	
	@Test(priority = 103, groups={"TC3760DefaultCurrencyChangeRule"})
	public void TC3760DefaultCurrencyChangeRule(){
		
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			defaultccyrule.TC3760DefaultCurrencyChangeRule();
			softAssert.assertEquals(defaultccyrule.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(defaultccyrule.ActualDPVCOriginal, "-");
			softAssert.assertEquals(defaultccyrule.ActualDPVCChanged, "USD");
			softAssert.assertEquals(defaultccyrule.ActualDPVCRuleName, "Default Currency used");
			softAssert.assertEquals(defaultccyrule.ActualDPVCOriginal1, "-");
			softAssert.assertEquals(defaultccyrule.ActualDPVCChanged1, "USD");
			softAssert.assertEquals(defaultccyrule.ActualDPVCRuleName1, "Default Currency used");
			softAssert.assertEquals(defaultccyrule.ActualTCOriginal1, "-");
			softAssert.assertEquals(defaultccyrule.ActualTCChanged1, "GBP");
			softAssert.assertEquals(defaultccyrule.ActualTCRuleName1, "Default Currency used");
			softAssert.assertEquals(defaultccyrule.ActualTCOriginal, "-");
			softAssert.assertEquals(defaultccyrule.ActualTCChanged, "GBP");
			softAssert.assertEquals(defaultccyrule.ActualTCRuleName, "Default Currency used");
			
			
						
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3760DefaultCurrencyChangeRule "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 
		
	

	@Test(priority = 104, groups={"TC3760DefaultCurrencyChangeRuleWithErrors"})
	public void TC3760DefaultCurrencyChangeRuleWithErrors(){
		
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			defaultccyrule.TC3760DefaultCurrencyChangeRulewithErorrs();
			softAssert.assertEquals(defaultccyrule.errorTitleValidate, "Premium Currency reference data translation required");
			softAssert.assertEquals(defaultccyrule.errorTitleValidate1, "Risk Currency reference data translation required");
			softAssert.assertEquals(defaultccyrule.errorTitleValidate2, "Tax Currency 1 reference data translation required");
			softAssert.assertEquals(defaultccyrule.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(defaultccyrule.ActualDPVCOriginal, "-");
			softAssert.assertEquals(defaultccyrule.ActualDPVCChanged, "USD");
			softAssert.assertEquals(defaultccyrule.ActualDPVCRuleName, "Default Currency used");
			softAssert.assertEquals(defaultccyrule.ActualDPVCOriginal1, "-");
			softAssert.assertEquals(defaultccyrule.ActualDPVCChanged1, "USD");
			softAssert.assertEquals(defaultccyrule.ActualDPVCRuleName1, "Default Currency used");
			softAssert.assertEquals(defaultccyrule.ActualTCOriginal1, "-");
			softAssert.assertEquals(defaultccyrule.ActualTCChanged1, "GBP");
			softAssert.assertEquals(defaultccyrule.ActualTCRuleName1, "Default Currency used");
			softAssert.assertEquals(defaultccyrule.ActualTCOriginal, "-");
			softAssert.assertEquals(defaultccyrule.ActualTCChanged, "GBP");
			softAssert.assertEquals(defaultccyrule.ActualTCRuleName, "Default Currency used");
			
						
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3760DefaultCurrencyChangeRuleWithErrors "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 
	
	
	}


