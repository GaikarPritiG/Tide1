package com.tide.qa.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.FinancialCalculationRiskAndPremiumPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.ProcessEnrichmentPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class ProcessEnrichmentTests  extends TestBase {
	
	ProcessEnrichmentPage PEpage= new ProcessEnrichmentPage();
	SoftAssert softAssert = new SoftAssert();
	LoginPage login = new LoginPage();
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	
		
	@Test(priority =374, groups={"TC630_extractYOA"})
	public void TC630_extractYOA()
 	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.extractYOA_3879();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.YOA, "Year Of Account");
			softAssert.assertEquals(PEpage.YOA1, "2018");
			softAssert.assertEquals(PEpage.YOA2, "2018");
			softAssert.assertEquals(PEpage.YOA3, "2018");
			softAssert.assertEquals(PEpage.YOA4, "2018");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC630_extractYOA"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	 	
	@Test(priority =375, groups={"TC631_DeriveBrokeragePercentage"})

	public void TC631_DeriveBrokeragePercentage()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.deriveBrokeragePercentage_3880();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.Brokerage, "Brokerage %");
			softAssert.assertEquals(PEpage.Brokerage1, "10.00 %");
			softAssert.assertEquals(PEpage.Brokerage2, "10.00 %");
			softAssert.assertEquals(PEpage.Brokerage3, "10.00 %");
			softAssert.assertEquals(PEpage.Brokerage4, "10.00 %");
			softAssert.assertEquals(PEpage.Brokerage5, "10.00 %");
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.ZeroBrokerage1, "0.00 %");
			softAssert.assertEquals(PEpage.ZeroBrokerage2, "0.00 %");
			softAssert.assertEquals(PEpage.ZeroBrokerage3, "0.00 %");
			softAssert.assertEquals(PEpage.ZeroBrokerage4, "0.00 %");
			softAssert.assertEquals(PEpage.ZeroBrokerage5, "0.00 %");
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC631_DeriveBrokeragePercentage"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =376, groups={"TC632_RemoveISOcurrencycode"})
	public void TC632_RemoveISOcurrencycode()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.removeISOcurrencycode_3881();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.GP, "Gross Premium");
			softAssert.assertEquals(PEpage.GP1, "124.50");
			softAssert.assertEquals(PEpage.GP2, "4.00");
			softAssert.assertEquals(PEpage.GP3, "8,855.00");
			softAssert.assertEquals(PEpage.GP4, "124.50");
			softAssert.assertEquals(PEpage.GP5, "124.50");
			softAssert.assertEquals(PEpage.GP6, "1,000.00");
			softAssert.assertEquals(PEpage.GrossPremiump,"Gross Premium");
			softAssert.assertEquals(PEpage.Data,"Remove ISO currency code characters & symbols");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC632_RemoveISOcurrencycode"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =377, groups={"TC633_RiskExpiryDatedefaulted"})
	public void TC633_RiskExpiryDatedefaulted()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.riskExpiryDate_3882();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.ExpairydDate, "Risk Expiry Date");
			softAssert.assertEquals(PEpage.ExpairydDate1, "01/01/2019");
			softAssert.assertEquals(PEpage.ExpairydDate2, "01/01/2019");
			softAssert.assertEquals(PEpage.ExpairydDate3, "01/01/2019");
			softAssert.assertEquals(PEpage.ExpairydDate4, "04/01/2020");
			softAssert.assertEquals(PEpage.ExpairydDate5, "01/01/2022");
			softAssert.assertEquals(PEpage.RuleExpairydDate, "Risk Expiry Date defaulted from the Risk Inception Date plus 1 year");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC633_RiskExpiryDatedefaulted"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =378, groups={"TC634_Defaultvalue_CCommissionPercentage"})
	public void TC634_Defaultvalue_CCommissionPercentage()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.defaultValueCCPercentage_3884();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.CCP, "Coverholder Commission %");
			softAssert.assertEquals(PEpage.CCP1, "10.00 %");
			softAssert.assertEquals(PEpage.CCP2, "10.00 %");
			softAssert.assertEquals(PEpage.CCP3, "10.00 %");
			softAssert.assertEquals(PEpage.CCP4, "10.00 %");
			softAssert.assertEquals(PEpage.CCP5, "10.00 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC634_Defaultvalue_CCommissionPercentage"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =379, groups={"TC635_RiskExpiryDateDefaultedToReportingPeriod"})
	public void TC635_RiskExpiryDateDefaultedToReportingPeriod()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			//login.tideLogin(AdminUsername1, AdminPassword1);
			PEpage.riskExpiryDate_3890();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.ExpairydDate, "Risk Expiry Date");
			softAssert.assertEquals(PEpage.ExpairydDate1, "31/01/2018");
			softAssert.assertEquals(PEpage.ExpairydDate2, "31/01/2018");
			softAssert.assertEquals(PEpage.ExpairydDate3, "31/01/2018");
			softAssert.assertEquals(PEpage.ExpairydDate4, "31/01/2018");
			softAssert.assertEquals(PEpage.ExpairydDate5, "31/01/2018");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC635_RiskExpiryDateDefaultedToReportingPeriod"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =380, groups={"TC636_DeriveCoverholderCommission"})
	public void TC636_DeriveCoverholderCommission()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.deriveCoverholderCommission_3891();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.CCP, "Coverholder Commission %");
			softAssert.assertEquals(PEpage.CCP1, "10.00 %");
			softAssert.assertEquals(PEpage.CCP2, "10.00 %");
			softAssert.assertEquals(PEpage.CCP3, "10.00 %");
			softAssert.assertEquals(PEpage.CCP4, "10.00 %");
			softAssert.assertEquals(PEpage.CCP5, "10.00 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC636_DeriveCoverholderCommission"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =381, groups={"TC637_BrokeragePercentageDefaultValue"})
	public void TC637_BrokeragePercentageDefaultValue()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.brokeragePercentageDefaultValue_3892();		
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.Brokerage1, "7.00 %");
			softAssert.assertEquals(PEpage.Brokerage2, "7.00 %");
			softAssert.assertEquals(PEpage.Brokerage3, "7.00 %");
			softAssert.assertEquals(PEpage.Brokerage4, "7.00 %");
			softAssert.assertEquals(PEpage.Brokerage5, "7.00 %");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC637_BrokeragePercentageDefaultValue"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
		
	@Test(priority =382, groups={"TC638_DefaultCurrencyused"})
	public void TC638_DefaultCurrencyused()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.defaultCurrency_3893();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.Currency,"Premium Currency");
			softAssert.assertEquals(PEpage.Currency1,"USD");
			softAssert.assertEquals(PEpage.Currency2,"USD");
			softAssert.assertEquals(PEpage.Currency3,"USD");
			softAssert.assertEquals(PEpage.Currency4,"USD");
			softAssert.assertEquals(PEpage.Currency5,"USD");
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC638_DefaultCurrencyused"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =383, groups={"TC639_DeriveCurrency"})
	public void TC639_DeriveCurrency()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.deriveCurrency_3894();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.ContractCurrency, "GBP - Pound Sterling");
			softAssert.assertEquals(PEpage.PremiumCurrency, "Premium Currency");
			softAssert.assertEquals(PEpage.PremiumCurrency1, "GBP");
			softAssert.assertEquals(PEpage.PremiumCurrency2, "GBP");
			softAssert.assertEquals(PEpage.PremiumCurrency3, "GBP");
			softAssert.assertEquals(PEpage.PremiumCurrency4, "GBP");
			softAssert.assertEquals(PEpage.PremiumCurrency5, "GBP");
			
			softAssert.assertEquals(PEpage.RiskCurrency, "Risk Currency");
			softAssert.assertEquals(PEpage.RiskCurency1, "GBP");
			softAssert.assertEquals(PEpage.RiskCurency2, "GBP");
			softAssert.assertEquals(PEpage.RiskCurency3, "GBP");
			softAssert.assertEquals(PEpage.RiskCurency4, "GBP");
			softAssert.assertEquals(PEpage.RiskCurency5, "GBP");
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC639_DeriveCurrency"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =384, groups={"TC640_TotalInsurableValue"})
	public void TC640_TotalInsurableValue()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.TotalInsurableValue_3987();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.TSI,"Total Sum Insured");
			softAssert.assertEquals(PEpage.TSIRule,"If Total Sums Insured is not supplied then use value from Total Insurable Value");
			softAssert.assertEquals(PEpage.TSI1,"4,000.00");
			softAssert.assertEquals(PEpage.TSI2,"2,000.00");
			softAssert.assertEquals(PEpage.TSI3,"900,001.00");
			softAssert.assertEquals(PEpage.TSI4,"900,001.00");
			softAssert.assertEquals(PEpage.TSI5,"900,001.00");
			softAssert.assertEquals(PEpage.TSI6,"900,001.00");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC640_TotalInsurableValue"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =385, groups={"TC641_LimitofIndemnity"})

	public void TC641_LimitofIndemnity()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.limitOfIndemnity_3988();
			softAssert.assertEquals(PEpage.LOIRule,"If Total Sums Insured is not supplied then use value from Limit of Indemnity");
			softAssert.assertEquals(PEpage.TSI1,"4,000.00");
			softAssert.assertEquals(PEpage.TSI2,"2,000.00");
			softAssert.assertEquals(PEpage.TSI3,"2,000.00");
			softAssert.assertEquals(PEpage.TSI4,"2,000.00");
			softAssert.assertEquals(PEpage.TSI5,"2,000.00");
			softAssert.assertEquals(PEpage.TSI6,"2,000.00");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC641_LimitofIndemnity"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =386, groups={"TC642_RemovenonDateCharacters"})
	public void TC642_RemovenonDateCharacters()
    {
        SoftAssert softAssert = new SoftAssert();
        try
        {
            PEpage.RemovenonDateCharacters();
            softAssert.assertEquals(PEpage.ErrorPageValidate, "Mandatory date data field not populated");
            softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
            softAssert.assertEquals(PEpage.InceptionDate, "Risk Inception Date");
            softAssert.assertEquals(PEpage.InceptionDate1, "01/01/2018");
            softAssert.assertEquals(PEpage.InceptionDate2, "01/01/2018");
            softAssert.assertEquals(PEpage.InceptionDate3, "01/01/2018");
            softAssert.assertEquals(PEpage.InceptionDate4, "01/01/2018");
            softAssert.assertEquals(PEpage.InceptionDate5, "01/01/2018");
            softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
           
        }catch(Exception e)
        {
            Report.LogInfo("Exception", "Exception in TC642_RemovenonDateCharacters"+e.getMessage(), "FAIL");
            softAssert.fail(e.getMessage());
        }finally {
            softAssert.assertAll();
       
        }
    }
	@Test(priority =75, groups={"TC643_RiskInceptionDateasEndormentEfDate"})
	public void TC643_RiskInceptionDateasEndormentEfDate()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.RiskInceptionDateasEndormentEfDate_5337();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			//softAssert.assertEquals(PEpage.actualRuleName, "Use of Risk Inception Date as Endorsement Effective Date");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC643_RiskInceptionDateasEndormentEfDate"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =101, groups={"TC643_RiskInceptionDateasEndormentEfDateNotsupplied"})
	public void TC643_RiskInceptionDateasEndormentEfDateNotsupplied()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.RiskInceptionDateasEndormentEfDate_1900();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(PEpage.actualRuleName, "Use of Risk Inception Date as Endorsement Effective Date");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC643_RiskInceptionDateasEndormentEfDateNotsupplied"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =405, groups={"TC3770_ChangeValuesFromNegativeToPositiveOrPositiveToNegative"})
	public void TC3770_ChangeValuesFromNegativeToPositiveOrPositiveToNegative()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.NegativeToPositiveScenario();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC3770_ChangeValuesFromNegativeToPositiveOrPositiveToNegative"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	
	@Test(priority =501, groups={"TC3773_RiskExpiryDate_defaulted_fromtheRiskInceptionDate_plus1year"})
	public void TC3773_RiskExpiryDate_defaulted_fromtheRiskInceptionDate_plus1year()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.RiskExpiryDatedefaultedfroRiskInceptionDateplus1year();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC3773_RiskExpiryDate_defaulted_fromtheRiskInceptionDate_plus1year"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	

	@Test(priority =502, groups={"TC3775_Risk_ExpiryDateDefaultedtoFinalDayofBordereauReportingPeriod"})
	public void TC3775_Risk_ExpiryDateDefaultedtoFinalDayofBordereauReportingPeriod()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.RiskExpiryDateDefaultedtoFinalDayofBordereauReportingPeriod();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC3775_Risk_ExpiryDateDefaultedtoFinalDayofBordereauReportingPeriod"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	@Test(priority =105, groups={"TC3865_RiskInceptionDateDefaultedtoFirstDayofBordereauReportingPeriod"})
	public void TC3865_RiskInceptionDateDefaultedtoFirstDayofBordereauReportingPeriod()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.RiskInceptionDateDefaultedtoFirstDayofBordereauReportingPeriod();
			softAssert.assertEquals(PEpage.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC3865_RiskInceptionDateDefaultedtoFirstDayofBordereauReportingPeriod"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =410, groups={"TC4158_VerifydefaultIsSpecifiedastheReviewStepofTheRiskQuestionnaire"})
	public void TC4158_VerifydefaultIsSpecifiedastheReviewStepofTheRiskQuestionnaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.VerifydefaultIsSpecifiedastheReviewStepofTheRiskQuestionnaireTC4158();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC4158_VerifydefaultIsSpecifiedastheReviewStepofTheRiskQuestionnaire"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =411, groups={"TC4160_ApplyDefaultWhenThereIsNoSuppliedValueForThisField"})
	public void TC4160_ApplyDefaultWhenThereIsNoSuppliedValueForThisField()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.ApplyDefaultWhenThereIsNoSuppliedValueForThisFieldTC4160();
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC4160_ApplyDefaultWhenThereIsNoSuppliedValueForThisField"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	
	@Test(priority =412, groups={"TC4161_ApplyDefaultForallrecordsRegardlessoftheSuppliedvalue"})
	public void TC4161_ApplyDefaultForallrecordsRegardlessoftheSuppliedvalue()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.ApplyDefaultForallrecordsRegardlessoftheSuppliedvalueTC4161();
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC4161_ApplyDefaultForallrecordsRegardlessoftheSuppliedvalue"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =413, groups={"TC4162_ApplyDefaultforMultiRuleCondition"})
	public void TC4162_ApplyDefaultforMultiRuleCondition()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			PEpage.ApplyDefaultforMultiRuleConditionTC4162();
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "TC4162_ApplyDefaultforMultiRuleCondition"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
		
	
	
	
	
	
	
	
}

