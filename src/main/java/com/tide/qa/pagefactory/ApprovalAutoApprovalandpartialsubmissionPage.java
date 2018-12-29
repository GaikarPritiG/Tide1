package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class ApprovalAutoApprovalandpartialsubmissionPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQPage = new BordereauQuePage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	Stage2Page Stage2 = new Stage2Page();
	String Questionnaire = "SP -";	
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

	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String FilteredOutputFormatNameEditing;
	String NameOutputFormatEditing ;
	String NameOutputFormat;
	String FilteredRuleNameVerification;
	String FieldName = "SCHEMA FIELD NAME";
	String FilteredOutputFormatNameVerification;

	public static String sheet4756Path = "";
	public static String sheet4755Path = "";
	public static String sheet4754Path = "";
	public static String sheet4721Path = "";
	public static String sheet4721PathScnd = "";
	public static String sheet4721PathThird = "";
	public static String sheet4720Path = "";
	public static String contractId;
	
	public String NewandRenewalEntriesErrorScreen;
	//==================================Locators===============================//
	public static final String OutPutFormatMenuLink = "@xpath=//a[@href='#!/app/outputformats']";
	public static final String Errorbtn = "@xpath=//*[@id='grid']//*[contains(@ng-click,'Risk')]//button";
	public static final String ResolvErrorbtn = "@xpath=//*[@id='content']//*[@ng-click='resolveRemainingErrros()']";
	public static final String DiscardErrorbtn = "@xpath=//*[@id='content']//*[@ng-click='discardRemainingErrros()']";
	public static final String ViewDiscardbtn = "@xpath=.//*[@id='profile-main']//label[@for='IsDiscard']";
	public static final String IdentifysheetDD = "@xpath=//*[@ng-model='dataSummary.SheetType']//preceding-sibling::span[1]";
	
	//-------------------------------------------------------- BordereauProcessIdentifySheetTests ---------------------------------------------------------------------//

	public void LetTideSelctQue_4756() throws Exception{
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk";
		String freqVal = "Monthly";
		String subSheet = "Automation-Risk format 9 (Lloyd's Property Schema LOI)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Step 1
		policy.CreateContractwithInceptionDate2018();
		policy.applyFilterPolicy(policy.PolicyNumber);
		policy.openSelectedPolicy();
		
		//Step 2
		BordereauProcess.SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3 
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4756Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC4756.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4756Path);
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S50401520180908.xlsx";	
		int size = 18752;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForluna(contractId, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		BordereauProcess.refreshAfterUploadedFileForReviewSatusAndUploadStatus();
		if(isVisible(BordereauProcess.UploadedButton)==true){
			Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
			verifyExists(BordereauProcess.UploadedButton,"Upload button");
			AssertBordereauStatusUploaded =  getTextFrom(BordereauProcess.UploadedButton);
			Report.LogInfo("UPLOADED status displayed", AssertBordereauStatusUploaded, "PASS");
			click(BordereauProcess.UploadedButton,"Upload button");

			//step 4
			verifyMustExists(IdentifysheetDD,"Applied Bordereau Dropdown");
			click(IdentifysheetDD,"Applied Bordereau Dropdown");
			sleep(2000);
			webDriver.findElement(By.xpath("//li[contains(text(),'First Sheet')]")).click();
			
			clickOnContinue();
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS");

			//step 5 
			clickOnContinue();
			Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
			sleep(3000);
			/*String Quename = "Automation Risk Format 1";
			String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+Quename+"')][1]";
			BQPage.filterBordereauQuestionnaire(Quename, SelectQuestionnaire);
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");*/

			//Step 7
			clickOnContinue();
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
			sleep(3000);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true) {
				AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);	
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
				BordereauProcess.deleteBorderEAUX(); 
	}else if(isVisible(BordereauProcess.ReviewError)==true) {
		AssertBordereauStatusReviewError =  getTextFrom(BordereauProcess.ReviewError);	
			Report.LogInfo("ReviewErrorStatus", "AssertBordereauStatusReviewError", "PASS");	
			BordereauProcess.deleteBorderEAUX();
		} else {
			Report.LogInfo("ErroScreenCheck", "No valid  status  displayed", "FAIL");	

		}
		}else{
			Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
			//deleteBorderEAUX();
		}
	}
	public void uploadLunaFile(){
	if(isVisible(BordereauProcess.UploadedButton)==true){
		Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
		verifyExists(BordereauProcess.UploadedButton,"Upload button");
		AssertBordereauStatusUploaded =  getTextFrom(BordereauProcess.UploadedButton);
		Report.LogInfo("UPLOADED status displayed", AssertBordereauStatusUploaded, "PASS");
		click(BordereauProcess.UploadedButton,"Upload button");

		//step 4
		verifyMustExists(IdentifysheetDD,"Applied Bordereau Dropdown");
		click(IdentifysheetDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'First Sheet')]")).click();
		
		clickOnContinue();
		Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
		
		//step 5 
		clickOnContinue();
		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
		sleep(3000);
	}
	else{
		Report.LogInfo("Validate Uploaded Status", "Uploaded status not displayed", "FAIL");
		}
	}	
	public void PatialSubResolvError_4755() throws Exception{

		String MonthDate = "April 2017";
		String val1 = "1";
		String val2 = "5";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.CreateContractwithInceptionDate2018();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4755Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC4755.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4755Path);	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S43952320181008.xlsx";	
		int size = 20057;
		String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload =  "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC4755.xlsx\",\"UniqueFileName\":\"S68260020180426.xlsx\",\"BordereauFormatId\":\"49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S68260020180426.xlsx\",\"Filesize\":20057,\"Path\":null,\"size\":20057,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();

		//Step 3
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			verifyMustExists(Stage2.NewandRenewalEntriesLocator,"New and renewal entries exists screen");
			NewandRenewalEntriesErrorScreen = getTextFrom(Stage2.NewandRenewalEntriesLocator);
			Report.LogInfo("DrpVal", NewandRenewalEntriesErrorScreen, "PASS");
			SelectDropDownValue(Stage2.RenewalDrp,Stage2.Endorsment1);
			waitForElementToAppear(Stage2.RiskRefFirst,3);
			verifyMustExists(Stage2.RiskRefFirst,"Risk Referance");
			sendKeys(Stage2.RiskRefFirst,val1,"Risk Referance");

			SelectDropDownValue(Stage2.NewDrp,Stage2.Endorsment2);

			waitForElementToAppear(Stage2.RiskRefSecond,3);
			verifyMustExists(Stage2.RiskRefSecond,"Risk Referance");
			sendKeys(Stage2.RiskRefSecond,val2,"Risk Referance");

			verifyMustExists(Stage2.ContinueBtn,"Continue button");
			click(Stage2.ContinueBtn,"Continue button");
			sleep(2000);
			
			Report.LogInfo("StepCheck", "Step 3 completed", "PASS");
			
			
			//Step 4
			waitForElementToAppear(BordereauProcess.SkippAllErroBtn,5);
			verifyExists(BordereauProcess.SkippAllErroBtn,"Skip all error button");
			click(BordereauProcess.SkippAllErroBtn,"Skip all error button");
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
			//Step 5
			waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
			verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
			//Step 6
			verifyMustExists(BordereauProcess.PartialSubmission,"Partialsubmission set to yes");
			verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
			click(BordereauProcess.FrApprovalbtn1,"For Approval button");
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");
			//Step 7
			BordereauProcess.clickOnApproveBordBtn();
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
			//Add Approved refresh
			BordereauProcess.refreshUploadedFileApprovedStatus();
			//Step 8			
			verifyMustExists(Errorbtn,"Error button");
			click(Errorbtn,"Error button");
			Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
			//Step 9 
			verifyMustExists(ResolvErrorbtn,"Resolve Error button");
			click(ResolvErrorbtn,"ResolveError button");
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");

			//Step 10
			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
				if(isVisible(Stage2.RenewalDrp)==true){
					
					//Stage2.EndorsmentFirstContinue(val1,val2);
					Stage2.EndorsmentContinueSecond_3541();
					Stage2.ChangeStasCanToNew();
					Stage2.ReinstatementToCancl11();
					Stage2.EnrichedValChange();
					Stage2.TideValChange();
					Stage2.TideValChangeToUnitedKingdm();
					//Stage2.TideValUKToRMS();
					Report.LogInfo("StepCheck", "Step 10 completed", "PASS");
					//waitForElementToAppear(SbmtRcdAssmntBtn,3);
					//Step 11
					/*if(isVisible(BordereauProcess.ErrorsAndWarningTab)==true){
						verifyMustExists(BordereauProcess.ErrorsAndWarningTab," errors and warning  button");
						click(BordereauProcess.ErrorsAndWarningTab," error and warning button");
						sleep(2000);
						
							verifyMustExists(BordereauProcess.NegativePremiumResolveErrors," errors and warning  button");
							click(BordereauProcess.NegativePremiumResolveErrors," error and warning button");
							verifyMustExists(Stage2.GrossPremTxt,"gross Premium text");
							
								Stage2.ChangGrossPremTxtVal();
						Report.LogInfo("StepCheck", "Step 11 completed", "PASS");
						sleep(2000);*/
						verifyMustExists(BordereauProcess.CancelAndDeleteBordereaux," errors and warning  button");
						click(BordereauProcess.CancelAndDeleteBordereaux," error and warning button");
						//Step 12
						BordereauProcess.navigateToDATATab();
						if(isVisible(BordereauProcess.DATARiskTab)==true){
							BordereauProcess.navigateToDATARiskTab();
							BordereauProcess.VerificationRcddCounts(5);
							
							Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
						}else{
							Report.LogInfo("RiskTab", "Risk tab not gets opned", "FAIL");

						}
					}
				}else{
					Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
					goBack();
					BordereauProcess.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateUploadedStatus", "Review error status not displayed", "FAIL");
				//deleteBorderEAUX();
			}
		
		}
		
	


	public void PatialSubDisscardError_4754() throws Exception{
		String MonthDate = "April 2017";
		String val1 = "1";
		String val2 = "5";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.CreateContractwithInceptionDate2018();
		/*policy.PolicyNumber = "889012XP";
		policy.applyFilterPolicy(policy.PolicyNumber);
		policy.openSelectedPolicy();*/
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4754Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC4755.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4754Path);	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S72650620181008.xlsx";	
		int size = 20057;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		                  
		//String payload =  "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC4755.xlsx\",\"UniqueFileName\":\"S68260020180426.xlsx\",\"BordereauFormatId\":\"49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S68260020180426.xlsx\",\"Filesize\":20057,\"Path\":null,\"size\":20057,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();

		//Step 3
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
		//	verifyMustExists(Stage2.NewandRenewalEntriesLocator,"New and renewal entries exists screen");
		//	NewandRenewalEntriesErrorScreen = getTextFrom(Stage2.NewandRenewalEntriesLocator);
		//	Report.LogInfo("DrpVal", NewandRenewalEntriesErrorScreen, "PASS");
		//	SelectDropDownValue(Stage2.RenewalDrp,Stage2.Endorsment1);
		//	waitForElementToAppear(Stage2.RiskRefFirst,3);
		//	verifyMustExists(Stage2.RiskRefFirst,"Risk Referance");
		//	sendKeys(Stage2.RiskRefFirst,val1,"Risk Referance");

		//	SelectDropDownValue(Stage2.NewDrp,Stage2.Endorsment2);

	//		waitForElementToAppear(Stage2.RiskRefSecond,3);
	//		verifyMustExists(Stage2.RiskRefSecond,"Risk Referance");
	//		sendKeys(Stage2.RiskRefSecond,val2,"Risk Referance");

	//		verifyMustExists(Stage2.ContinueBtn,"Continue button");
	//		click(Stage2.ContinueBtn,"Continue button");
	//		sleep(2000);
			
	//		Report.LogInfo("StepCheck", "Step 3 completed", "PASS");
			
			//Step 4
			waitForElementToAppear(BordereauProcess.SkippAllErroBtn2,5);
			verifyExists(BordereauProcess.SkippAllErroBtn2,"Skip all error button");
			click(BordereauProcess.SkippAllErroBtn2,"Skip all error button");
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
			//Step 5
			waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
			verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
			//Step 6
			waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
			verifyMustExists(BordereauProcess.PartialSubmission,"Partialsubmission set to yes");
			verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
			click(BordereauProcess.FrApprovalbtn1,"For Approval button");
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");
			//Step 7
			BordereauProcess.clickOnApproveBordBtn();
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
			//Add Approved refresh
			BordereauProcess.refreshUploadedFileApprovedStatus();
			//Step 8			
			verifyMustExists(Errorbtn,"Error button");
			click(Errorbtn,"Error button");
			Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
			//Step 9 
			verifyMustExists(DiscardErrorbtn,"Discard Error button");
			click(DiscardErrorbtn,"Discard Error button");
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
			BordereauProcess.navigateToDATATab();
			if(isVisible(BordereauProcess.DATARiskTab)==true){
				BordereauProcess.navigateToDATARiskTab();
				waitForElementToAppear(ViewDiscardbtn,5);
				verifyMustExists(ViewDiscardbtn,"View Discard Error button");
				click(ViewDiscardbtn,"View discard Error button");
				if (isVisible(BordereauProcess.discardedRowCount)==true)
				{
					Report.LogInfo("StatusCheck", " status records found", "PASS");
				}else{
					Report.LogInfo("StatusCheck", "No status records found", "FAIL");
				}
				Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
			}else{
				Report.LogInfo("RiskTab", "Risk tab not gets opned", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateUploadedStatus", "Review error status not displayed", "FAIL");
			//deleteBorderEAUX();
		}
	}

	public void AutoApprvl_4721() throws Exception{

		String val1 = "1";
		String val2 = "5";
		String subSheet = "Automation Company Adin 1 Risk Format 1";
		String subSheet2 = "Company Admin 1 risk format 20";
		String subSheet3 = "Automation Company Admin 1 Claim Format 11";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		signedStatus();
		contractId = ReturnContractID();
		BordereauProcess.SubmitBordereaux(subSheet);

		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
		//Step 3 
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4721Path = fpath+"\\src\\test\\resources\\testdata\\January 2017Aprroved_TC4721.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4721Path);
		String Ufname = "S22879520180606.xlsx";	
	    int size = 17028;
	    String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
       addAsDraft(payload,DraftUrl);
	
		
		BordereauProcess.refreshUploadedFile();
		//Step 6
		if(isVisible(BordereauProcess.ReviewBtn)== true){
			AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			verifyExists(BordereauProcess.ReviewBtn,"Review button");
			click(BordereauProcess.ReviewBtn,"Review button");
			Report.LogInfo("StepCheck", "Step 6 completed", "PASS");
			//Step 7
			waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
			verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
			
			waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
			verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
			click(BordereauProcess.FrApprovalbtn1,"For Approval button");
		
			BordereauProcess.clickOnApproveBordBtn();			
			BordereauProcess.refreshUploadedFileApprovedStatus();
			
			BordereauProcess.VerifyApproved();
			
			
			Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
			BordereauProcess.SubmitBordereaux(subSheet);			
			//Step 8 
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4721PathScnd = fpath+"\\src\\test\\resources\\testdata\\January 2017Approved_TC4721Scnd.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4721PathScnd);
			//String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017Approved_TC4721Scnd.xlsx\",\"UniqueFileName\":\"S65648520180606.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S65648520180606.xlsx\",\"Filesize\":16955,\"Path\":null,\"size\":16955,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			
	         String Ufname1 = "S65648520180606.xlsx";	
	 	     int size1 = 16955;
	 	     String BordreauID1 = "93a517f5-4051-4698-90db-0f5d9a808b20";
	         String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
	         String ID1 = extractIDFromResponseinsideContract(response1); 
	         String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 1 , "2", 2018);
	        addAsDraft(payload2,DraftUrl);
		
			BordereauProcess.refreshUploadedFile();		
			Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
			
			//Step 9
			if(isVisible(BordereauProcess.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				verifyExists(BordereauProcess.ReviewBtn,"Review button");
				click(BordereauProcess.ReviewBtn,"Review button");
				Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
				//Step 7
				waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
				verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
				click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
				
				waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
				verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
				click(BordereauProcess.FrApprovalbtn1,"For Approval button");
			
				BordereauProcess.clickOnApproveBordBtn();			
				BordereauProcess.refreshUploadedFileForApprovedScndRw();
				BordereauProcess.VerifyApproved();
				Report.LogInfo("StepCheck", "Step 10 completed", "PASS");
				//---------------------------------------------------------------
				BordereauProcess.SubmitBordereaux(subSheet3);
				//Step 8 
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4721PathThird = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Approved_TC4721Third.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile3 = new File(sheet4721PathThird);
				
				String Ufname3 = "S10970820181129.xlsx";	
			    int size3 = 15308;
			    String BordreauID3 = "bf75e0f5-1723-4af0-8c4b-6aa0d92ddd51";
		        String response3 = uploadFileinContract(ReqUrl,excelFile3,contractId,Ufname3);
		        String ID3 = extractIDFromResponseinsideContract(response3); 
		        String payload3 = GeneratePayloadForContract(contractId, BordreauID3, ID3, Ufname3, size3, 1 , "3", 2018);
		        addAsDraft(payload3,DraftUrl);
		       
				
				BordereauProcess.refreshUploadedFile();		
				Report.LogInfo("StepCheck", "Step 11 completed", "PASS");
				
				verifyExists(BordereauProcess.ReviewError,"Review Error button");
				click(BordereauProcess.ReviewError,"Review Error button");
				
				verifyExists(BordereauProcess.ContinueProc,"Continue  button");
				click(BordereauProcess.ContinueProc,"Continue button");
				
				BordereauProcess.refreshUploadedFile();	
				//Step 9
				if(isVisible(BordereauProcess.ReviewBtn)== true){
					AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					click(BordereauProcess.ReviewBtn,"Review button");
					Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
					//Step 13
					waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
					verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
					click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
					
					waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
					verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
					click(BordereauProcess.FrApprovalbtn1,"For Approval button");
				
					BordereauProcess.clickOnApproveBordBtn();			
					BordereauProcess.refreshUploadedFileForApprovedScndRw();
					BordereauProcess.VerifyApproved();
					Report.LogInfo("StepCheck", "Step 13 completed", "PASS");					
					
				}
				else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
					BordereauProcess.deleteBorderEAUX();
					sleep(3000);
				}
				
			}
			else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
				BordereauProcess.deleteBorderEAUX();
				sleep(3000);
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
			BordereauProcess.deleteBorderEAUX();
			sleep(3000);
		}		
	}

	public void ApprvlMultplConSameCon_4720() throws Exception{
		BProcessingRiskPremiumClaimPage BPProcessng = new BProcessingRiskPremiumClaimPage();
		String UniqueReferenceVal2 = "Automation Policy2"+getCurrentDateTimeMS1();
		
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String IncDate1 = "01/01/2018";
		String ExpDate2="01/01/2019";
		String Type = "Risk";
		String freqVal = "Monthly";
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String Status1 = "Draft";
		String Status2 = "Quote";
		String Broker2 = "AON - DUA team - london";
		String Bline2 = "Property (D&F)";
		String Underline2 = "Abhi, Standard";
		//Step 1
		policy.addPolicy2(IncDate,ExpDate);
		
		
		policy.changeStatusToSigned2(Type,freqVal);
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");
		
		BPProcessng.openPolicyCreateContract();
		policy.addPolicyContractDetails2(UniqueReferenceVal2, IncDate1, ExpDate2, Broker2, Bline2, Underline2);
		
		policy.changeStatusToSigned2(Type,freqVal);
		
		contractId = ReturnContractID();
		BordereauProcess.SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
		//Step 3 
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4720Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March_TC4720.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4720Path);
		
		
		String Ufname = "S95065720181129.xlsx";	
	    int size = 18349;
	    String BordreauID = "c3bdfd79-9d91-478f-87cc-cba93ae3f385";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
       addAsDraft(payload,DraftUrl);
       
		/*String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March_TC4720.xlsx\",\"UniqueFileName\":\"S21988320180119.xlsx\",\"BordereauFormatId\":\"e1f3d92f-bd74-4e8a-b3c2-2eb5f4d3bb9c\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21988320180119.xlsx\",\"Filesize\":19276,\"Path\":null,\"size\":19276,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);*/
		BordereauProcess.refreshUploadedFile();
		
		verifyExists(BordereauProcess.ReviewError,"Review Error button");
		click(BordereauProcess.ReviewError,"Review Error button");
		
		verifyExists(BordereauProcess.ContinueProc,"Continue  button");
		click(BordereauProcess.ContinueProc,"Continue button");
		
		BordereauProcess.refreshUploadedFile();	
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)== true)
		{
			String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
			String YesBtn = "@xpath=.//*[@value='true']";
			if(isVisible(ErrorScreen)== true){							
				if(isVisible(BordereauProcess.ContinueProcessingBodrBtn)== true){
					javaScriptclick(YesBtn,"Yes button");
					verifyMustExists(BordereauProcess.ContinueProcessingBodrBtn,"Continue Processing button");
					javaScriptclick(BordereauProcess.ContinueProcessingBodrBtn,"Continue Processing button");
					sleep(3000);
					BordereauProcess.refreshUploadedFile();
					if(isVisible(BordereauProcess.ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						click(BordereauProcess.ReviewBtn,"Review button");
						Report.LogInfo("StepCheck", "Step 12 completed", "PASS");
						//Step 13
						waitForElementToAppear(BordereauProcess.SubProcessRcdBtn,5);
						verifyExists(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
						click(BordereauProcess.SubProcessRcdBtn,"Submit process record button");
						
						waitForElementToAppear(BordereauProcess.FrApprovalbtn1,5);
						verifyMustExists(BordereauProcess.FrApprovalbtn1,"For Approval button");
						click(BordereauProcess.FrApprovalbtn1,"For Approval button");
					
						BordereauProcess.clickOnApproveBordBtn();			
						BordereauProcess.refreshUploadedFileApprovedStatus();
					}else{
						Report.LogInfo("Status", "Review button not display", "FAIL");

					}
					}else{
						goBack();
					}				
			}else{
				goBack();
			}
		}else{
			goBack();
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------//	
	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public void clickOnContinue(){
		waitForElementToAppear(BordereauProcess.continuebtx,5);
		verifyExists(BordereauProcess.continuebtx,"Continue button");
		click(BordereauProcess.continuebtx,"Continue button");
	}

	public void signedStatus() throws InterruptedException{
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk";
		String TypePre = "Premium";
		String TypeClaim = "Claim";
		String freqVal = "Monthly";
		//Step 2
		policy.addPolicy2(IncDate,ExpDate);
		contractId = ReturnContractID();
		policy.addSection();
		policy.navigateToMarketsTabOnSection();
		policy.addMarketOnSection();
		policy.navigateToRiskCodesTabOnSection();
		policy.addRiskCodesOnSection();
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb(Type,freqVal);
		policy.addReportingChannelForAnyComb(TypePre,freqVal);
		policy.addReportingChannelForAnyComb(TypeClaim,freqVal);
		policy.addCoverholder();
		Report.LogInfo("StepCheck", "Step 3 completed", "PASS");
		//Step 4
		policy.navigateToContractDetailsTab();		
		policy.DraftToSignedStatus();
		verifyExists(policy.SaveBtn,"Save Button");
		click(policy.SaveBtn,"Save Button");
		sleep(3000);
		verifyExists(policy.SignedBtn,"Signed Status Button");
		Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
	}
}