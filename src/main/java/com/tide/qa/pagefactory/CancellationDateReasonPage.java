package com.tide.qa.pagefactory;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class CancellationDateReasonPage extends PageBase {
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	String Questionnaire = "SP -";	

	PeriodofCoverEnhancementPage enhncement= new PeriodofCoverEnhancementPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("HHmmssyyMMdd");
		String datetime = ft.format(dNow);
		return datetime;
	}


	public static String contractId;
	public static String sheet3767Path = "";
	public static String sheet3767SecondPath = "";	
	
	//=============================Locators===========================================//
	
	public static final String CancellationDate="@xpath=//*[@data-field='Cancellation_Date']";
	public static final String CancellationReason="@xpath=//*[@data-field='Cancellation_Reason']";
	public static final String CancellationDateRow="@xpath=//td[contains(@ng-click,'Cancellation_Date')][text()='02/11/2018']";
	public static final String CancellationReasonRow="@xpath=//td[contains(@ng-click,'Cancellation_Reason')][text()='Unknown']";
	public static final String RuleName1="@xpath=//td[3][contains(.,'-')]";
	public static final String RuleName2="@xpath=//td[4][contains(.,'02/11/2018')]";
	public static final String RuleName3="@xpath=//td[6][contains(.,'Populate Cancellation Date with Endorsement Effective Date if blank')]";
	public static final String Okbtn="@xpath=//div[@ng-click='cancel()']";
	
	public static final String RuleName4="@xpath=//td[3][contains(.,'-')]";
	public static final String RuleName5="@xpath=//td[4][contains(.,'Unknown')]";
	public static final String RuleName6="@xpath=//td[6][contains(.,'Populate Cancellation Reason with Unknown if blank')]";
	

	public String ExpectedCancellationDateRow="02/11/2018";
	public String ActualCancellationReasonRow;
	public String ActualCancellationDateRow;
	public String ExpectedCancellationReasonRow="Unknown";
	public void cancellationDate_3767() throws Exception{
		
		String  subSheet="SP - First Sheet (Automation Schema)";
		String DateMonth = "February 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
				try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3767Path = fpath+"\\src\\test\\resources\\testdata\\Cancelation_jan_TC3767.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3767Path);

			contractId =BordereauPage.addNewBordereauFormatPolicy(payload1, GetData);
			
			String Ufname = "S99065020180908.xlsx";	
			int size = 16955;
			String BordreauID = "bd66df73-be6b-4196-8bd9-dc1bf63e5542";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)==true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(3000);
				click(BordereauPage.ReviewBtn,"Review button");
				waitForElementToAppear(BordereauPage.SuRcdAssmnt,10);
				verifyMustExists(BordereauPage.SuRcdAssmnt,"Submit recor for Assignment button");
				click(BordereauPage.SuRcdAssmnt,"Submit recor for Assignment button");
				waitForElementToAppear(BordereauPage.FrApprovalbtn,10);
				verifyMustExists(BordereauPage.FrApprovalbtn,"For Approval button");
				click(BordereauPage.FrApprovalbtn,"For Approval button");
				BordereauPage.clickOnApproveBordBtn();
				sleep(3000);
				BordereauPage.refreshUploadedFileForApproved();
				if(isVisible(BordereauPage.Approvedbtn)==true)
				{
					BordereauPage.SubmitBordereauxWithYesnoButtons(DateMonth);
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet3767SecondPath = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March 2017_TC3767_Second.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					File excelFile1 = new File(sheet3767SecondPath);
					String Ufname2 = "S97792920180908.xlsx";	
					int size2 = 10096;
			        String response2 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname2);
			        String ID2 = extractIDFromResponseinsideContract(response2); 
			        String payload2 = GeneratePayloadForContract(contractId, BordreauID, ID2, Ufname2, size2, 2 , "1", 2018);
			        addAsDraft(payload2,DraftUrl);
					BordereauPage.refreshUploadedFile();
					if(isVisible(BordereauPage.ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						sleep(3000);
						verifyMustExists(BordereauPage.ReviewBtn,"Review button");
						BordereauPage.openDATALink();
						BordereauPage.navigateToDATARiskTab();
						mouseOverAction(CancellationDate);
						verifyMustExists(CancellationDate,"Cancellation Date column");
						mouseOverAction(CancellationDateRow);
						verifyMustExists(CancellationDateRow,"Cancellation Date row"); 
						 ActualCancellationDateRow = getTextFrom(CancellationDateRow);
						sleep(2000);
						if(ActualCancellationDateRow.equals(ExpectedCancellationDateRow))
						{
							Report.LogInfo("ValidateCancellationDateRow", "Cancellation Date Row validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateCancellationDateRow", "Cancellation Date Row not validate successfully", "Fail");
						}
						
						mouseOverAction(CancellationReason);
						verifyMustExists(CancellationReason,"Cancellation Reason column");
						mouseOverAction(CancellationReasonRow);
						verifyMustExists(CancellationReasonRow,"CancellationReason row"); 
						 ActualCancellationReasonRow = getTextFrom(CancellationReasonRow);
						sleep(2000);
						if(ActualCancellationReasonRow.equals(ExpectedCancellationReasonRow))
						{
							Report.LogInfo("ValidateCancellationReasonRow", "Cancellation Reason Row validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateCancellationReasonRow", "Cancellation Reason Row not validate successfully", "Fail");
						}	
						
						click(CancellationDateRow,"Cancellation Date- first row"); 
						sleep(3000);
						waitForElementToAppear(RuleName1,5);
						verifyExists(RuleName1,"Original Value");
						verifyExists(RuleName2,"Changed value");
						verifyExists(RuleName3," rule name");
						verifyExists(Okbtn,"Ok button");
						click(Okbtn,"Ok button");
						
						click(CancellationReasonRow,"Cancellation Reason Row"); 
						sleep(3000);
						waitForElementToAppear(RuleName4,5);
						verifyExists(RuleName4,"Original Value");
						verifyExists(RuleName5,"Changed value");
						verifyExists(RuleName6," rule name");
						verifyExists(Okbtn,"Ok button");
						click(Okbtn,"Ok button");

					}else{
						Report.LogInfo("ReviewStatusValidation", "Review Button not Displayed", "FAIL");
						BordereauPage.deleteBorderEAUX();
					}

				}else{
					Report.LogInfo("ApprovedbuttonValidation", "Approved Button not Displayed", "FAIL");
				}
			}else{
				Report.LogInfo("ReviewStatusValidation", "Review Button not Displayed", "FAIL");
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");

		}
	}

}
