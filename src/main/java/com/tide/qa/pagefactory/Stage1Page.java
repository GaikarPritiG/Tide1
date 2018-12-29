package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;









import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class Stage1Page extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	PolicyPage policy = new PolicyPage();
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

	public static String sheet3369Path = "";
	public static String sheet3702Path = "";
	public static String sheet3702SecondPath = "";
	
	public static String Policy1 = "";
	public static String Policy2 = "";
	public static String contractId1 = "";
	public static String contractId2 = "";
	public static String FolderId1 = "";
	public static String FolderId2 = "";
	public String YearAccount;
	public String NEXTStep;

	public static final String SubmitBordereauxDownBtn ="@xpath=//*[contains(@ng-show,'viewRiskOption')]//button[2]";
	public static final String SelectContractTxt ="@xpath=//*[@id='bordereauxprocesspolicy_taglist']/following::input[1]";
	public static final String SelectPolicy1 ="@xpath=//*[@id='bordereauxprocesspolicy_listbox']//li[1]";
	public static final String UploadedDateFilter ="@xpath=//a[contains(.,'Uploaded Date')]";
	public static final String FolderReferenceFilter ="@xpath=//a[text()='Folder Reference']/preceding-sibling::a/span";
	public static final String CoverholderFilter ="@xpath=//a[text()='Coverholder']/preceding-sibling::a/span";
	public static final String SearchTxt ="@xpath=//input[@placeholder='Search']";
	
	public static final String YOA ="@xpath=//td[contains(.,'Year of Account')]";
	public static final String NextStep ="@xpath=//button[contains(@ng-click,'nextStep()')]";
	public static final String RightIcon ="@xpath=//div[@ng-click='addToSelectionList()']";
	public static final String DD2016 ="@xpath=//tr[1]//select[@ng-model='data.FolderId']//preceding-sibling::span[1]";
	public static final String DD2017 ="@xpath=//tr[2]//select[@ng-model='data.FolderId']//preceding-sibling::span[1]";
	public static final String SubmitMapping ="@xpath=//button[contains(@ng-click,'submitMapping()')]";
	public static final String ProcessingTab ="@xpath=//*[@id='content']//a[@data-ui-sref='app.bordereauxParent.bordereauxTabs({BordereauxTypeEnum: 2})']";
	
	//======================================atul QA1 maintenance====================================//
	public static final String YesRadioBtn ="@xpath=//*[@ng-model='data.NillBordereau'][@ng-value='true']/..";
	public static final String ContinueProcessingBtn  ="@xpath=//*[@ng-click='UpdateSequence()']";
	public static final String PauseBtn  ="@xpath=//*[@ng-click='pause()']";
	
	
	//3369 Add new  Policy instance
	public void addNewPolicyInstance() throws Exception
	{		
		//System.out.println(FolderId);
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		SchemaPage schema = new SchemaPage();
		HomePage homePage = new HomePage();
		String subSheet="Automation Risk Format 10";
		homePage.adminMenu();
	    BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
		String InceptionDate = "01/01/2016";
		String InceptionDate1 = "31/12/2016";
		String InceptionDate2 = "01/01/2017";
		String InceptionDate3 = "31/12/2017";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal1, InceptionDate,InceptionDate1, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		Policy1 = policy.PolicyNumber;
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//policy.changeStatusToQuote();
		//policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		contractId1 = ReturnContractID();
		String Uname = Configuration.url+"/api/Contract/GetContractListByContractId/"+contractId1+"";
		FolderId1 = GetFolderIDPolicy(Uname);

		//Another policy
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails1(UniqueReferenceVal2, InceptionDate2,InceptionDate3, policy.Broker1, policy.Bline1, policy.Underline1);
		waitForElementToAppear(policy.DraftBtn,5);
		verifyExists(policy.DraftBtn,"Draft Status Button");
		Policy2 = policy.PolicyNumber;
	
		//policy.changeStatusToQuote();
		//policy.changeStatusToWritten();
		policy.changeStatusToSigned_1();
		contractId2 = ReturnContractID();
		String Uname2 = Configuration.url+"/api/Contract/GetContractListByContractId/"+contractId2+"";
		FolderId2 = GetFolderIDPolicy(Uname2);
	
		reportingChannel.NavigateBordereauHeaderLink();
		navigateOnProcessingTab();

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3369Path = fpath+"\\src\\test\\resources\\testdata\\YOAFrom_sheet_NAME_TC_3369.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet3369Path); 
		

	/*	String Ufname = "S73281120180909.xlsx";	
		int size = 17667;
		String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId1,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId1,contractId2 , BordreauID, ID, Ufname, size, 1 , "1", 2017 , FolderId1 , FolderId2);
        addAsDraft(payload,DraftUrl);
			*/
		//String payload ="{\"Bordereaux\":{\"ContractId\":null,\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_NAME_TC_3369.xlsx\",\"UniqueFileName\":\"S73420920180511.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":true,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73420920180511.xlsx\",\"Filesize\":17667,\"Path\":null,\"size\":17667,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[{\"FolderId\":\""+FolderId2+"\"},{\"FolderId\":\""+FolderId1+"\"}]}";
		String payload ="{\"Bordereaux\":{\"ContractId\":null,\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_NAME_TC_3369.xlsx\",\"UniqueFileName\":\"S73281120180909.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\"24fb688d-3cdb-4014-a991-68020fe87e7d\"},{\"ContractId\":\"48254bd1-a132-44fc-86b5-faff99d625e0\"}],\"UploadFileVM\":{\"Id\":\"21174d33-e030-4c35-b1ce-ca4bfed85672\",\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73281120180909.xlsx\",\"UniqueFileName\":\"S16359620181009.xlsx\",\"Filesize\":17667,\"Path\":null,\"size\":17667,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"IsValidFileSize\":true,\"FileExtension\":1,\"IsValidFileType\":true,\"IsValidFileNameSizeLimit\":true,\"IsScanPerform\":true,\"Scanner\":{\"ScanStatus\":1,\"ScanProcessStatus\":0,\"ScanLogMessage\":\"No Threat Detected\"}},\"IsUploadOnly\":false,\"BordereauFolder\":[{\"FolderId\":\""+FolderId2+"\"},{\"FolderId\":\""+FolderId1+"\"}]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		sleep(2000);
		javaScriptclick(UploadedDateFilter,"Uploaded Date Filter");
		sleep(3000);
		javaScriptclick(UploadedDateFilter,"Uploaded Date Filter");
		sleep(2000);
		//applyCoverHolderFilter("21st Century Insurance & Reinsurance Brokers Ltd. - 111988DYV ");
		applyFolderReferenceFilter("Multi-Folder:  " + Policy1+", "+Policy2);
		//applyFolderReferenceFilter("Multi-Folder:  " + Policy2+", "+Policy1);
		policy.openSelectedPolicy();
		sleep(2000);
		//reportingChannel.refreshBordereauxUploadedFile();
		sleep(2000);

		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			sleep(2000);
		//BordereauProcess.deleteBorderEAUX();	
		verifyExists(reportingChannel.OpenBordereauxAfterUpload,"Review Error");
		BordereauProcess.refreshUploadedFile();
		click(reportingChannel.OpenBordereauxAfterUpload,"Review Error");
		waitForElementToAppear(YOA,5);
		verifyExists(YOA,"Year Of Account");
		YearAccount =  getTextFrom(YOA);	
		Report.LogInfo("Year Of Account", YearAccount, "PASS");
		click(YOA,"Year Of Account");
		verifyExists(RightIcon,"Right Arrow");
		click(RightIcon,"Right Arrow");
		verifyExists(NextStep,"Next Step");
		NEXTStep =  getTextFrom(NextStep);	
		Report.LogInfo("Next Step", YearAccount, "PASS");
		click(NextStep,"Next Step");
		
		String DD2016Value ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Policy1+"')]";
		String DD2017Value ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Policy2+"')]";
		sleep(3000);
		SelectDropDownValue(DD2016,DD2016Value);
		SelectDropDownValue(DD2017,DD2017Value);
		verifyExists(SubmitMapping,"Submit Mapping");
		click(SubmitMapping,"Submit Mapping");
		sleep(4000);
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}
		applyFolderReferenceFilter(""+Policy1+"");
		BordereauProcess.refreshUploadedFile1();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			//AssertBordereauStatusReviewError =  getTextFrom(BordereauProcess.ReviewError);	
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(ContinueProcessingBtn)== true)
			{
				
				click(YesRadioBtn,"Yes radio button");
				sleep(2000);
				verifyExists(ContinueProcessingBtn," Continue Processing bordereau button");
				click(ContinueProcessingBtn," Continue Processing bordereau  button");
				sleep(3000);
				applyFolderReferenceFilter(""+Policy1+"");
				BordereauProcess.refreshUploadedFile1();
				if(isVisible(BordereauProcess.ReviewBtn) == true)
				{
					AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);	
					Report.LogInfo("ReviewStatusValidation", "Status changed to Review", "PASS");
				}
				else
				{
					Report.LogInfo("ReviewStatusValidation", "Review not displayed.", "FAIL");
					//BordereauProcess.deleteBorderEAUX();				
				}	
			}
			else
			{
				Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ReviewErrorStatusValidation", "Review Error not displayed", "Fail");
		}
		
	}

	//3702 Add existing policies
	public void addExistingPolicies() throws Exception
	{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		HomePage homePage = new HomePage();
		//BordereauProcess.SubmitBordereauxWithYesnoButtons("MonthDate");
		reportingChannel.NavigateBordereauHeaderLink();
		navigateOnProcessingTab();
		refreshPage();
		sleep(2000);
		applyFolderReferenceFilter(""+Policy1+"");
		if(isVisible(BordereauProcess.ReviewBtn) == true)
		{
			AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);	
			click(BordereauProcess.ReviewBtn,"Reviwe button");
			waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
			verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
			click(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
			sleep(3000);
			applyFolderReferenceFilter(""+Policy1+"");
			waitForElementToAppear(BordereauProcess.FrApprovalbtn,5);
			verifyMustExists(BordereauProcess.FrApprovalbtn,"For Approval button");
			click(BordereauProcess.FrApprovalbtn,"For Approval button");
			BordereauProcess.clickOnApproveBordBtn();
			sleep(3000);
			applyFolderReferenceFilter(""+Policy2+"");
			if(isVisible(BordereauProcess.ReviewBtn) == true)
			{
				AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);	
				click(BordereauProcess.ReviewBtn,"Reviwe button");
				waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
				verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
				click(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
				sleep(3000);
				applyFolderReferenceFilter(""+Policy2+"");
				waitForElementToAppear(BordereauProcess.FrApprovalbtn,5);
				verifyMustExists(BordereauProcess.FrApprovalbtn,"For Approval button");
				click(BordereauProcess.FrApprovalbtn,"For Approval button");
				BordereauProcess.clickOnApproveBordBtn();
				sleep(3000);
				//refreshPage();
				//BordereauProcess.SubmitBordereauxWithYesnoButtons("MonthDate");
				reportingChannel.NavigateBordereauHeaderLink();
				navigateOnProcessingTab();
				String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
				String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
				//String Uname = "https://tideprod-tideqa1.azurewebsites.net/api/Contract/GetContractListByContractId/"+contractId1+"";

				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3702Path = fpath+"\\src\\test\\resources\\testdata\\YOAFrom_sheet_name_TC_3702.xlsx";
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile = new File(sheet3702Path);  
				//string payload ="{\"Bordereaux\":{\"ContractId\":null,\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_name_TC_3702.xlsx\",\"UniqueFileName\":\"S15530920180105.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15530920180105.xlsx\",\"Filesize\":18482,\"Path\":null,\"size\":18482,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[{\"FolderId\":\""+FolderId2+"\"},{\"FolderId\":\""+FolderId1+"\"}]}";
				String payload ="{\"Bordereaux\":{\"ContractId\":null,\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_name_TC_3702.xlsx\",\"UniqueFileName\":\"S76722320180506.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S76722320180506.xlsx\",\"Filesize\":17679,\"Path\":null,\"size\":17679,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[{\"FolderId\":\""+FolderId2+"\"},{\"FolderId\":\""+FolderId1+"\"}]}";
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				sleep(30000);
				
				applyFolderReferenceFilter(""+Policy1+"");
				BordereauProcess.refreshUploadedFile1();
				if(isVisible(BordereauProcess.ReviewBtn) == true)
				{
					click(BordereauProcess.ReviewBtn,"Reviwe button");
					waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
					verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
					click(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
					sleep(3000);
					applyFolderReferenceFilter(""+Policy1+"");
					waitForElementToAppear(BordereauProcess.FrApprovalbtn,5);
					verifyMustExists(BordereauProcess.FrApprovalbtn,"For Approval button");
					click(BordereauProcess.FrApprovalbtn,"For Approval button");
					BordereauProcess.clickOnApproveBordBtn();
					sleep(2000);
					applyFolderReferenceFilter(""+Policy2+"");
					if(isVisible(BordereauProcess.ReviewBtn) == true)
					{
						click(BordereauProcess.ReviewBtn,"Reviwe button");
						waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
						verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
						click(BordereauProcess.SuRcdAssmnt,"Submit record assesment button");
						sleep(3000);
						applyFolderReferenceFilter(""+Policy2+"");
						waitForElementToAppear(BordereauProcess.FrApprovalbtn,5);
						verifyMustExists(BordereauProcess.FrApprovalbtn,"For Approval button");
						click(BordereauProcess.FrApprovalbtn,"For Approval button");
						BordereauProcess.clickOnApproveBordBtn();
						sleep(3000);
						//BordereauProcess.SubmitBordereauxWithYesnoButtons("MonthDate");
						reportingChannel.NavigateBordereauHeaderLink();
						navigateOnProcessingTab();
						try 
						{
							String fpath = new File(".").getCanonicalPath();
							sheet3702SecondPath = fpath+"\\src\\test\\resources\\testdata\\YOAFrom_sheet_name_TC_3702Second.xlsx";
						} 
						catch (IOException e) 
						{
							e.printStackTrace();
						}
						File excelFile1 = new File(sheet3702SecondPath);  
						//String payload1 ="{\"Bordereaux\":{\"ContractId\":null,\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_name_TC_3702Second.xlsx\",\"UniqueFileName\":\"S49628520180105.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":true,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S49628520180105.xlsx\",\"Filesize\":18482,\"Path\":null,\"size\":18482,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[{\"FolderId\":\""+FolderId2+"\"},{\"FolderId\":\""+FolderId1+"\"}]}";
						String payload1 ="{\"Bordereaux\":{\"ContractId\":null,\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"YOAFrom_sheet_name_TC_3702Second.xlsx\",\"UniqueFileName\":\"S90637520180506.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":true,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S90637520180506.xlsx\",\"Filesize\":17678,\"Path\":null,\"size\":17678,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[{\"FolderId\":\""+FolderId2+"\"},{\"FolderId\":\""+FolderId1+"\"}]}";
						uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
						sleep(2000);
						sleep(20000);
						javaScriptclick(UploadedDateFilter,"Uploaded Date Filter");
						sleep(3000);
						javaScriptclick(UploadedDateFilter,"Uploaded Date Filter");
						sleep(2000);
						applyFolderReferenceFilter("Blanks");
						sleep(2000);
						reportingChannel.refreshBordereauxUploadedFile();
						sleep(2000);
						verifyExists(reportingChannel.OpenBordereauxAfterUpload,"Review Error");
						click(reportingChannel.OpenBordereauxAfterUpload,"Review Error");
						waitForElementToAppear(YOA,5);
						verifyExists(YOA,"Year Of Account");
						YearAccount =  getTextFrom(YOA);	
						Report.LogInfo("Year Of Account", YearAccount, "PASS");
						click(YOA,"Year Of Account");
						verifyExists(RightIcon,"Right Arrow");
						click(RightIcon,"Right Arrow");
						verifyExists(NextStep,"Next Step");
						NEXTStep =  getTextFrom(NextStep);	
						Report.LogInfo("Next Step", YearAccount, "PASS");
						click(NextStep,"Next Step");
						sleep(2000);
						String DD2016Value ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Policy1+"')]";
						String DD2017Value ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'"+Policy2+"')]";
						SelectDropDownValue(DD2016,DD2016Value);
						SelectDropDownValue(DD2017,DD2017Value);
						verifyExists(SubmitMapping,"Submit Mapping");
						click(SubmitMapping,"Submit Mapping");
						sleep(3000);
						applyFolderReferenceFilter(""+Policy1+"");
						BordereauProcess.refreshUploadedFile1();
						if(isVisible(BordereauProcess.ReviewBtn) == true)
						{
							AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);	
							Report.LogInfo("ReviewStatusValidation", "Review button displayed.", "PASS");
						}else
						{
							Report.LogInfo("ReviewStatusValidation", "Review not displayed.", "FAIL");
							BordereauProcess.deleteBorderEAUX();				
						}
						refreshPage();
						sleep(3000);
						applyFolderReferenceFilter(""+Policy2+"");
						BordereauProcess.refreshUploadedFile1();
						if(isVisible(BordereauProcess.ReviewBtn) == true)
						{
							AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);	
							Report.LogInfo("ReviewStatusValidation", "Review button displayed.", "PASS");
						}else
						{
							Report.LogInfo("ReviewStatusValidation", "Review not displayed.", "FAIL");
							BordereauProcess.deleteBorderEAUX();				
						}
				
						
					}else{
						Report.LogInfo("ReviewStatusValidation", "Review not displayed.", "FAIL");
						BordereauProcess.deleteBorderEAUX();
					}	
				}else{
					Report.LogInfo("ReviewStatusValidation", "Review not displayed.", "FAIL");
					BordereauProcess.deleteBorderEAUX();				
				}				
			}else
			{
				Report.LogInfo("ReviewStatusValidation", "Review not displayed.", "FAIL");
				BordereauProcess.deleteBorderEAUX();				
			}	
		}else
		{
			Report.LogInfo("ReviewStatusValidation", "Review not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();				
		}	
	}
	
	
//================================ reusable function ==================================================================//
	
	
	
	public void applyFolderReferenceFilter(String FilterString) throws InterruptedException
	{
		String StatusChkBox ="@xpath=//span[contains(.,'"+FilterString+"')]";
		//String StatusChkBox ="@xpath=//span[contains(.,'"+FilterString+""+Folder1+"')]";
		int i=0;

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(FolderReferenceFilter, "Policy Reference Filter Icon");
			sleep(3000);
			if(isVisible(SearchTxt))
			{
				verifyMustExists(SearchTxt,"Search Filter Textbox");	
				sendKeys(SearchTxt,FilterString,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(StatusChkBox) && i<5);

		click(StatusChkBox, "Searched Record Checkbox");
		verifyMustExists(policy.FilterButton,"Filter Button");
		click(policy.FilterButton,"Filter Button");
		sleep(3000);
	}
	
	public void applyCoverHolderFilter(String FilterString) throws InterruptedException
	{
		String StatusChkBox ="@xpath=//span[contains(.,'"+FilterString+"')]";
		//String StatusChkBox ="@xpath=//span[contains(.,'"+FilterString+""+Folder1+"')]";
		int i=0;

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(CoverholderFilter, "Coverholder Filter Icon");
			sleep(3000);
			if(isVisible(SearchTxt))
			{
				verifyMustExists(SearchTxt,"Search Filter Textbox");	
				sendKeys(SearchTxt,FilterString,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(StatusChkBox) && i<5);

		click(StatusChkBox, "Searched Record Checkbox");
		verifyMustExists(policy.FilterButton,"Filter Button");
		click(policy.FilterButton,"Filter Button");
		sleep(3000);
	}
	
	public void navigateOnProcessingTab(){		
		waitForElementToAppear(ProcessingTab,5);
		verifyExists(ProcessingTab,"Processing Link");
		click(ProcessingTab,"Processing Link");
		sleep(2000); 
	}
	

}