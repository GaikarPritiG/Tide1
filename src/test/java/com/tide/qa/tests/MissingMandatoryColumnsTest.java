package com.tide.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.MissingMandatoryColumns;
import com.tide.qa.utility.Report;

public class MissingMandatoryColumnsTest extends TestBase {
	
	MissingMandatoryColumns missingcolumn = new MissingMandatoryColumns();
	
	@Test(priority = 105, groups={"TC007MissingMandatoryColumns"})
	public void TC007MissingMandatoryColumns(){
		
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			
			// Map Gross space with TIV field with Default value
			// Supply mandatory error raise for Building value or Line of Business field and Apply default value 12345
	 
			missingcolumn.TC007MissingMandatoryColumns();
			
			softAssert.assertEquals(missingcolumn.errorTitleValidate, "One or more mandatory columns not identified");
			softAssert.assertEquals(missingcolumn.Introtext, "(Buildings Value)");
			softAssert.assertEquals(missingcolumn.Warningtext, "No Column or Default Supplied (Limit of Indemnity) – This Tide Field is mandatory, but there is no column or default value has been provided in the Questionnaire. It is likely that the Tide Field has become mandatory after the Questionnaire was completed.");
			softAssert.assertEquals(missingcolumn.AssertBordereauStatusReview, "REVIEW");		
			softAssert.assertEquals(missingcolumn.Rowno1, "2");
			softAssert.assertEquals(missingcolumn.Rowno2, "3");
			
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged, "01/01/2018");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName, "Default value for Risk Issuance Date field is set in Questionnaire as Contract Inception Date.");
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal1, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged1, "01/01/2018");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName1, "Default value for Risk Issuance Date field is set in Questionnaire as Contract Inception Date.");
			
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal2, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged2, "12,345.00");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName2, "Default value for Buildings Value field is set in Questionnaire as 12345.");
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal3, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged3, "12,345.00");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName3, "Default value for Buildings Value field is set in Questionnaire as 12345.");
			
			
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal4, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged4, "12,345.00");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName4, "Default value for Total Insurable Value field is set in Questionnaire as 12345.");
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal5, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged5, "12,345.00");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName5, "Default value for Total Insurable Value field is set in Questionnaire as 12345.");
			
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal6, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged6, "12,345.00");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName6, "Default value for Limit of Indemnity field is set in Questionnaire as 12345.");
			softAssert.assertEquals(missingcolumn.ActualDPVCOriginal7, "-");
			softAssert.assertEquals(missingcolumn.ActualDPVCChanged7, "12,345.00");
			softAssert.assertEquals(missingcolumn.ActualDPVCRuleName7, "Default value for Limit of Indemnity field is set in Questionnaire as 12345.");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC007MissingMandatoryColumns "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 
		
	

}
