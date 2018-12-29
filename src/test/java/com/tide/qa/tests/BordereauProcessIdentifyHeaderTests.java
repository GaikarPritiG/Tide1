            package com.tide.qa.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BordereauProcessIdentifyHeaderTests extends TestBase
{
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword = "Pa55word123";
	String AdminUsername2 = "broker01.ca@tideapp.co.uk";
	String AdminPassword2 = "HuCSbq7589wNU4M";
	
	
	
	@Test(priority =307, groups={"TC209_VerifyNormalAndExpectedHeader"})
	public void TC209_VerifyNormalAndExpectedHeader()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.verifyNormalAndExpectedHeader_3207();
			softAssert.assertEquals(sheets.count3207, 10);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC209_VerifyNormalAndExpectedHeader "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
		
	
	
	
	@Test(priority =308, groups={"TC210_IdentifyDuplicateColumn"})

	public void TC210_IdentifyDuplicateColumn()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.identifyDuplicateColumn_3213();
			softAssert.assertEquals(sheets.DublicatecolumnErrorMessage, "Duplicate header columns identified");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC210_IdentifyDuplicateColumn "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	
	
	@Test(priority =309, groups={"TC213_RemoveHeaderRowFromOneSheet"})
	public void TC213_RemoveHeaderRowFromOneSheet()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.removeHeaderRow();
			softAssert.assertEquals(sheets.ActualErrorMsg, sheets.ExpectedErrorMsg);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC213_RemoveHeaderRowFromOneSheet"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =310, groups={"TC217_RemoveHeaderFromAllSheets"})
	public void TC217_RemoveHeaderFromAllSheets()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.removeHeaderFromAllSheets();
			softAssert.assertEquals(sheets.ActualErrorMsg, sheets.ExpectedErrorMsg4);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC217_RemoveHeaderFromAllSheets "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =311, groups={"TC214_SpecifyWrongHeaderForOneSheet"})
	public void TC214_SpecifyWrongHeaderForOneSheet()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.wrongHeaderRowNumberOneSheet();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC214_SpecifyWrongHeaderForOneSheet"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority =312, groups={"TC215_SpecifyWrongHeaderForAllSheet"})
	public void TC215_SpecifyWrongHeaderForAllSheet()
	{
		SoftAssert softAssert = new SoftAssert();  
		try
		{
			sheets.wrongHeaderRowNumberAllSheet();
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC215_SpecifyWrongHeaderForAllSheet"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority =313, groups={"TC218_DuplicateColumnPresentInAllSheet"})
	public void TC218_DuplicateColumnPresentInAllSheet() throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
		/*	login.tideReadOnlyLogOut();
			login.tideLogin(AdminUsername2, AdminPassword2);*/
			sheets.duplicateColumnAllSheet();
			softAssert.assertEquals(sheets.ActualErrorMsg, sheets.ExpectedErrorMsg2);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC218_DuplicateColumnPresentInAllSheet"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	

	@Test(priority =644, groups={"TC203_Newcolumnsidentified"})
	public void TC203_Newcolumnsidentified()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.newcolumnsidentified_4470();	
			softAssert.assertEquals(sheets.NewColumnscreen,"New Columns Identified");
			softAssert.assertEquals(sheets.AssertBordereauStatusApproved,"APPROVED");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC203_Newcolumnsidentified"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =645, groups={"TC204_editQuestionnaire_usecolumns"})

	public void TC204_editQuestionnaire_usecolumns()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.newColumnsIdentified_4472();
			softAssert.assertEquals(sheets.version1,"1");
			softAssert.assertEquals(sheets.NewColumnscreen,"New Columns Identified");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(sheets.version2,"2");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC204_editQuestionnaire_usecolumns"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =646, groups={"TC205_expectedCloumnsMissing"})

	public void TC205_expectedCloumnsMissing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.expectedColumnsMissing_4473();
			softAssert.assertEquals(sheets.MissingColumnsscreen,"One or more header columns not identified");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC205_expectedCloumnsMissing"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =647, groups={"TC206_oneExpectedCloumnsMissing"})
	public void TC206_oneExpectedCloumnsMissing()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.oneExpectedColumnsMissing_4474();
			softAssert.assertEquals(sheets.MissingColumnsscreen,"One or more header columns not identified");
			softAssert.assertEquals(sheets.EditQuestionnair,"EDIT QUESTIONNAIRE");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC206_oneExpectedCloumnsMissing"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =648, groups={"TC207_DownloadBordereaufile"})
	public void TC207_DownloadBordereaufile()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.downloadBordereaufile_4481();
			softAssert.assertEquals(sheets.NewColumnscreen,"New Columns Identified");
			softAssert.assertEquals(sheets.DownloadBorderButton,"DOWNLOAD BORDEREAU");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC207_DownloadBordereaufile"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =391, groups={"TC1072_HeaderWidestRow"})
	public void TC1072_HeaderWidestRow()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			sheets.HeaderWidestRow_TC1072();
			softAssert.assertEquals(sheets.Result_1072_01,"2");
			softAssert.assertEquals(sheets.Result_1072_02,"3");			
			softAssert.assertEquals(sheets.Result_1072_03,"4");
			softAssert.assertEquals(sheets.Result_1072_04,"17");
			softAssert.assertEquals(sheets.AssertBordereauStatusReview,"REVIEW");
			softAssert.assertEquals(sheets.errorPage_1072_03, "Header row(s) not identified");
			softAssert.assertEquals(sheets.errorPage_1072_04, "Header row(s) not identified");
		
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1072_HeaderWidestRow"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
}

