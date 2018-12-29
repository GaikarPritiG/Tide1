package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BordereauProcessIdentifySheetTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	BordereauQuePage Qpage = new BordereauQuePage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	
	@Test(priority = 314, groups={"TC230_AllSheets"})
	public void TC230_AllSheets()  
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.allSheets_3145();
			softAssert.assertEquals(sheets.TC230Count,20);
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC230_AllSheets "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority = 315, groups={"TC231_FirstSheets"})
	public void TC231_FirstSheets()   
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.FirstSheet_3149();
			softAssert.assertEquals(sheets.TC230Count,5);
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC231_FirstSheets "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	@Test(priority = 316, groups={"TC232_LastSheets"})
	public void TC232_LastSheets()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.LastSheet_3150();
			softAssert.assertEquals(sheets.TC230Count,5);
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC232_LastSheets "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =317, groups={"TC448_MultipleSheet"})
	public void TC448_MultipleSheet()  
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.multiplesheetProcessing_3186();
			softAssert.assertEquals(sheets.AcualErrorMsg,sheets.ExpectedSHNameError1);
		
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC448_MultipleSheet "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	@Test(priority =318, groups={"TC442_OnlySheetsIdentifed"})
	public void TC442_OnlySheetsIdentifed()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.onlySheet_3160();
			softAssert.assertEquals(sheets.TC230Count,5);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC442_OnlySheetsIdentifed "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =319, groups={"TC443_SheetContainsSpecificTextUnchanged"})
	public void TC443_SheetContainsSpecificTextUnchanged()  
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.processingSelectingSheetUnchanged_3165();
			softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg1);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC443_SheetContainsSpecificTextUnchanged "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
		
	@Test(priority =320, groups={"TC444_CancelAndDeleteBorderEAUX"})
	public void TC444_CancelAndDeleteBorderEAUX()  
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			sheets.cancelBordereauProcess_3166();
			softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg1);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC444_CancelAndDeleteBorderEAUX "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =321, groups={"TC445_OnlySheetThatContainsSpecificText"})
	public void TC445_OnlySheetThatContainsSpecificText()  
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
		     sheets.sheetIdentification_3161();
		     softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg);
				
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC445_OnlySheetThatContainsSpecificText "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =322, groups={"TC446_MultipleSheetsIdentifed"})
	public void TC446_MultipleSheetsIdentifed() 
	{
		SoftAssert softAssert = new SoftAssert();
	try
		{			
			sheets.multiplesheet_3192();
			softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg);
				
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC446_MultipleSheetsIdentifed "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	} 

	@Test(priority =323, groups={"TC447_MultipleSheetsCancelProcessing"})
	public void TC447_MultipleSheetsCancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.multiplesheetCancelProcessing_3193();
			softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC447_MultipleSheetsCancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =324, groups={"TC450_VerifySheetEqualsSpecificText"})
	public void TC450_VerifySheetEqualsSpecificText()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
		sheets.verifyOnlySheetThatEqualsSpecificText_3194();
		softAssert.assertEquals(sheets.TC230Count,5);
		
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC450_VerifySheetEqualsSpecificText "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =325, groups={"TC452_VerifyTextAndObserveReviewBtn"})
	public void TC452_VerifyTextAndObserveReviewBtn()   
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.verifySpecificTextAndObserveReviewBtn_3195();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC452_VerifyTextAndObserveReviewBtn "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =326, groups={"TC453_VerifyTextAndObserveDataRecord"})
	public void TC453_VerifyTextAndObserveDataRecord() 
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.verifySpecificTextAndObserveDataRecord_3196();
			softAssert.assertEquals(sheets.TC230Count,5);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC453_VerifyTextAndObserveDataRecord "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =327, groups={"TC454_CancelProcessing"})
	public void TC454_CancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.cancelProcessing_3197();
			softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC454_CancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =328, groups={"TC236_containsSpecificTextMatchRecords"})
	public void TC236_containsSpecificTextMatchRecords() 
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.containsSpecificTextMatchRecords_3198();
			softAssert.assertEquals(sheets.TC230Count,20);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC236_containsSpecificTextMatchRecords "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =329, groups={"TC237_VerifyTextAndObserveDataRecord"})
	public void TC237_VerifyTextAndObserveDataRecord()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.verifyContainsSpecificTextAndObserveDataRecord_3200();
			softAssert.assertEquals(sheets.TC230Count,5);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC237_VerifyTextAndObserveDataRecord "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =330, groups={"TC238_CancelProcessing"})
	public void TC238_CancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.cancelProcessing_3201();
			softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC238_CancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =331, groups={"TC239_EditContainsSpecificText"})
	public void TC239_EditContainsSpecificText()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.editContainsSpecificText_3199();
			softAssert.assertEquals(sheets.TC230Count,20);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC239_EditContainsSpecificText "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =332, groups={"TC233_OnlySpecifiedSheet"})
	public void TC233_OnlySpecifiedSheet()
	{
		SoftAssert softAssert = new SoftAssert();
	try
		{
			sheets.OnlySpecifiedSheet_3202();
			softAssert.assertEquals(sheets.TC230Count,10);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC233_OnlySpecifiedSheet "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =333, groups={"TC234_OnlySpecifiedSheetCanNotBeIdentified"})
	public void TC234_OnlySpecifiedSheetCanNotBeIdentified()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.OnlySpecifiedSheetCanNotBeIdentified_3203();
			softAssert.assertEquals(sheets.ExpValMsg,sheets.AcualErrorMsg);
			softAssert.assertEquals(sheets.TC230Count,10);
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC234_OnlySpecifiedSheetCanNotBeIdentified "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =334, groups={"TC235_OnlySpecifiedSheetCancelProcessing"})
	public void TC235_OnlySpecifiedSheetCancelProcessing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.OnlySpecifiedSheetCancelProcessing_3204();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC235_OnlySpecifiedSheetCancelProcessing "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}	
	
	@Test(priority =393, groups={"TC1076_IgnoreHiddenSheet"})
	public void TC1076_IgnoreHiddenSheet()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			Qpage.IgnoreHiddenSheet_TC1076();
			softAssert.assertNotEquals(Qpage.ExpectedResult_1076, "April 2018");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1076_IgnoreHiddenSheet "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =392, groups={"TC1075_IgnoreHiddenSheet"})
	public void TC1075_IgnoreHiddenSheet()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.IgnoreHiddenSheet_TC1075();
			softAssert.assertNotEquals(sheets.ExpectedResult_1075,"April 2018","Sheet April 2018 found - Sheet does not ignored ");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1075_IgnoreHiddenSheet "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
}
