package com.tide.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.CSVProcessing;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.Report;

public class CSVProcessingTest  extends TestBase {
	
	LoginPage login = new LoginPage();
	CSVProcessing CSV = new CSVProcessing();
	String Admin1Username = "admin@tide.com";
	String Admin1Password ="Systenics123@";
	String AdminUsername = "priti@systenics.net";
	String AdminPassword = "test1234@";
	
	
	
	
	@Test(priority =656, groups={"TC3749_CreateCSVQuestionnaire"})
	public void TC3749_CreateCSVQuestionnaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			CSV.CreateCSVQuestionnaire_TC3749();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3749_CreateCSVQuestionnaire "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	

	@Test(priority =657, groups={"TC3750_AssertfromsheetnamemustnotbepresentforYOACCY"})
	public void TC3750_AssertfromsheetnamemustnotbepresentforYOACCY()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			CSV.AssertfromsheetnamemustnotbepresentforYOACCY_TC3750();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TTC3750_AssertfromsheetnamemustnotbepresentforYOACCY "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =498, groups={"TC3752_CSVFileProcessusingcsvxlsxQuestionnaireformat"})
	public void TC3752_CSVFileProcessusingcsvxlsxQuestionnaireformat()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			CSV.CSVFileProcessusingcsvxlsxQuestionnaireformat_TC3752();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3752_CSVFileProcessusingcsv&xlsxQuestionnaireformat "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =500, groups={"TC3764_XMLFileProcessingwithcontractdoesnotexist"})
	public void TC3764_XMLFileProcessingwithcontractdoesnotexist()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			CSV.XMLFileProcessingwithcontractdoesnotexist_TC3764();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3764_XMLFileProcessingwithcontractdoesnotexist "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}


}
