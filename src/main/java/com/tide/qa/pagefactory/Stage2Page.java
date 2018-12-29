package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class Stage2Page extends PageBase{
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	PolicyPage policy = new PolicyPage();
	ReportingChannel RC = new ReportingChannel();
	//PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
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
	
	DatasetReferenceDataPage DataRef = new DatasetReferenceDataPage();
	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();

	public static String contractId;

	public static String allSheetsPath = "";
	public static String sheet3541Path = "";
	public static String sheet3542Path = "";
	public static String sheet3542ScndPath = "";	
	public static String sheet3671Path = "";
	public static String sheet3671PathSecnd = "";
	public static String sheet3671Paththird = "";
	public static String sheet3876Path = "";
	public static String sheet3876Path1 = "";
	public static String sheet3914Path = "";
	public static String sheet3915Path = "";
	public static String sheet3981Path = "";
	public static String sheet3982Path = "";
	public static String sheet3915Path2 = "";
	public static String sheet5094Path = "";
	public static String NewandRenewalEntriesErrorScreen = null;
	public static String DataGridRecordCount = null;
	public static String DiscardedRecordCount = null;
	
	public static String EndorsementNothaveEntries = null;
	public static String CancellationNotHavingEntries = null;
	public static String Restatementerror = null;
	public static String InvalidIntegerIdentified = null;
	public static String LocationSprinklers = null;
	public static String InsuredCountryErrorScree = null;
	public int AcualYearOfAccount;
	public int AcualEndorsement;
	public String InvalidDate;
	public String InvalidInterger;
	public String ReferenceData;
	public String Country;
	public String Country1;
	public String NegativGrossP;
	public String NegativPremium;
	public String GrossPremium;
	public String ChangeValue;
	public String ExpairyDate;
	public String Date;
	public String Countrycolumn;
	public String Sprinkler;
	public String NO;
	public String Stories;
	public String StoryValue;
	public String RuleName1;
	public String RuleName2;
	public String RuleName3;
	public String RuleName4;
	public  String ContractStatus;
	public String ErrorCount;
	public String ClaimErrorCount;
	
	public String MandatoryErrorRP1;
	public String MandatoryErrorRP2;
	public String MandatoryErrorRP3;
	public String MandatoryErrorRP4;
	public String MandatoryErrorRP5;
	public String MandatoryErrorRP6;
	
	public String MandatoryErrorC1;
	public String MandatoryErrorC2;
	public String MandatoryErrorC3;
	public String MandatoryErrorC4;
	public String MandatoryErrorC5;
	public String MandatoryErrorC6;
	
	public String RN1;
	public String RN2;
	public String RN3;
	public String RN4;
	public String RN5;
	public String TT2;
	public String ActualDPVCOriginal;
	public String ActualDPVCOriginal1;
	public String ActualDPVCOriginal2;
	public String ActualDPVCOriginal3;
	public String ActualDPVCChanged;
	public String ActualDPVCChanged1;
	public String ActualDPVCChanged2;
	public String ActualDPVCChanged3;
	public String ActualDPVCRuleName;
	public String ActualDPVCRuleName1;
	public String ActualDPVCRuleName2;
	public String ActualDPVCRuleName3;
	
	
	//TC 3473 //h2[contains(.,'Endorsement(s) which do not have New or Renewal entries to update')]
	public static final String NewandRenewalEntriesLocator= "@xpath=//h2[contains(.,'New or Renewal entries which already exist')]";
	public static final String EndorsementNothaveEntriesLocator= "@xpath=//h2[contains(.,'Endorsement(s) which do not have New or Renewal entries to update')]";
	public static final String CancellationNotHavingEntriesLocator= "@xpath=//h2[contains(.,'Cancellation(s) which do not have entries to update')]";
	public static final String RestatementerrorLocator= "@xpath=//h2[contains(.,'Reinstatement(s) which do not have Cancellation entries to update')]";
	public static final String InvalidIntegerIdentifiedLocator= "@xpath=//h2[contains(.,'Invalid integer values identified')]";
	public static final String LocationSprinklersLocator= "@xpath=//h2[contains(.,'Location Sprinklers (Y/N) reference data translation required')]";
	public static final String InsuredCountryErrorScreenLocator= "@xpath=//h2[contains(.,'Insured Country reference data translation required')]";
	public static final String RecordCountOfCurrentEntries = "@xpath=//span[contains(.,'1 - 2 of 2 items')]";
	public static final String RecordCountOfCurrentEntries2 = "@xpath=//span[contains(.,'1 - 4 of 4 items')]";
	public static final String LossCountryErrorScreenLocator= "@xpath=//h2[contains(.,'Loss Country reference data translation required')]";
	
	public static final String CountryClensingMappingCount = "@xpath=//td[contains(.,'1 Values')]";
	
	public static final String UMRWrdVerify = "@xpath=//*[text()='UMR ']";
	public static final String UMRMultiValue = "@xpath=//*[@ng-if='errorPageHeaderData.UniqueReference.length <= 50']";
	public static final String ErrorCountOnBordereauxGrid = "@xpath=//td[contains(.,'No')]//following::td/button[@class='btn btn-xs btn-danger btn-wide grid-status-btn']";
	public static final String LocationSprinklersMandatory = "@xpath=//h2[text()='Location Sprinklers (Y/N) Mandatory reference data field not populated']";
	public static final String ClaimStatusMandatoryRef = "@xpath=//h2[text()='Claim Status Mandatory reference data field not populated']";
	public static final String BooleanFieldMandatory = "@xpath=//h2[text()='Mandatory boolean data field not populated']";
	public static final String ReferenceDataTypeClaims = "@xpath=//h2[text()='Claim Status reference data translation required']";
	public static final String SelectInsuredStateDD = "@xpath=//span[text()='--Select--']";

	public static final String SelectLocationSprinklersDD = "@xpath=//span[text()='-- Select --']";
	public static final String SelectLocationSprinklersDV = "@xpath=//li[text()='No']";
	public static final String SelectRiskCountryDV = "@xpath=//li[text()='United States of America']";
	public static final String SelectClaimStatusDV = "@xpath=//li[text()='Open']";
	public static final String CancellationReasonDDV = "@xpath=//li[text()='Alternative product purchased']";
	public static final String SelectInsuredStateDDV = "@xpath=//li[text()='Alabama - US-AL']";
	public static final String SelectInsuredStateDV = "@xpath=//li[text()='United States']";
	public static final String VerifyRiskRefExists = "@xpath=//td[1][text()='6']";
	public static final String VerifyRiskRefExists2 = "@xpath=//td[1][text()='8']";
	public static final String VerifyRiskRefExists3 = "@xpath=//td[1][text()='7']";
	public static final String VerifyRiskRefExists4 = "@xpath=//td[1][text()='2']";
	public static final String VerifyRiskRefExists5 = "@xpath=//td[1][text()='2']";

	public static final String RiskCountryMandatory = "@xpath=//h2[text()='Risk Country Mandatory reference data field not populated']";
	public static final String InsuredStateDataType = "@xpath=//h2[text()='Insured State reference data translation required']";

	public static final String InsuredNameMandatory = "@xpath=//h2[text()='Mandatory string data field not populated']";
	public static final String InputTextInsuredName = "@xpath=//span//input[@type='text']";
	
	//span//input[@ng-model='item.EnrichData']";
	public static final String InputTextPercentage1 = "@xpath=//span//input[@ng-model='item.EnrichData']";
	
	public static final String InputTextPercentage = "@xpath=//span/input[@ng-model='item.EnrichData']";

	public static final String DecimalMandatory = "@xpath=//h2[text()='Mandatory decimal data field not populated']";
	public static final String PercentageMandatory = "@xpath=//h2[text()='Mandatory percentage data field not populated']";
	public static final String DateMandatory = "@xpath=//h2[text()='Mandatory date data field not populated']";
	
	public static final String DecimalDataType = "@xpath=//h2[text()='Invalid decimal value translation required']";
	public static final String PercentageDatatype = "@xpath=//h2[text()='Invalid percentage values identified']";
	public static final String DateDataType = "@xpath=//h2[text()='Invalid date values identified']";
	public static final String IntegerDataType = "@xpath=//h2[text()='Invalid integer values identified']";
	public static final String ReferenceDataType = "@xpath=//h2[text()='Cancellation Reason reference data translation required']";
	public static final String BooleanDataType = "@xpath=//h2[text()='Invalid boolean values identified']";

	public static final String SubRiskIdentifier = "@xpath=//tr[1]//*[@ng-model='item.SubRiskIdentifier']";
	public static final String RenewalDrp = "@xpath=//tr[1]//*[@ng-model='item.TransactionType']//preceding-sibling::span[1]";
	public static final String NewDrp = "@xpath=//tr[2]//*[@ng-model='item.TransactionType']//preceding-sibling::span[1]";
	//public static final String Endorsment1 = "@xpath=//html/body/div[1]/div/div[2]/ul/li[4][text()='Endorsement']";
	public static final String Endorsment1 = "@xpath=//*[@class='k-animation-container'][1]//li[4][text()='Endorsement']";//"@xpath=//ul[@aria-hidden='false']//li[text()='Endorsement']";
	
	public static final String EndrsmntDrp = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][1]//span[@class='k-select']//preceding-sibling::span[1][text()='Endorsement']";
	//public static final String NewVal = "@xpath=//html/body/div[5]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVal = "@xpath=//html/body/div[5]/div/div[2]/ul/li[2][text()='New']";//"@xpath=//ul[@aria-hidden='false']//li[text()='New']";
	public static final String EndrsmntDrp2 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][2]//span[@class='k-select']//preceding-sibling::span[1][text()='Endorsement']";

	//public static final String NewVal2 = "@xpath=//html/body/div[7]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVal2 = "@xpath=//html/body/div[7]/div/div[2]/ul/li[2][text()='New']";//"@xpath=//ul[@aria-hidden='false']//li[text()='New']";

	public static final String EndrsmntDrp3 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][3]//span[@class='k-select']//preceding-sibling::span[1][text()='Endorsement']";
	//public static final String NewVall3 = "@xpath=//html/body/div[5]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVall3 = "@xpath=//ul[@aria-hidden='false']//li[text()='New']";
	
	//public static final String Endorsment2 = "@xpath=//*[@class='k-animation-container'][2]//li[4][text()='Endorsement']";
	public static final String Endorsment2 = "@xpath=//*[@class='k-animation-container'][2]//li[4][text()='Endorsement']";//"@xpath=//ul[@aria-hidden='false']//li[text()='Endorsement']";

	public static final String RiskRefFirst = "@xpath=//*[@id='multiReference_Id']//tr[1]//input[@ng-model='item.RiskReference']";
	public static final String RiskRefSecond = "@xpath=//*[@id='multiReference_Id']//tr[2]//input[@ng-model='item.RiskReference']";
	public static final String ContinueBtn = "@xpath=//*[@id='multiReference_Id']//button[@type='submit']";
	public static final String ContinueBtnSave = "@xpath=//*[@id='content']//button[@ng-click='save()']";
	public static final String ContinueBtn1 = "@xpath=//button[contains(.,'Continue')]";
	
	public static final String IntegerInput = "@xpath=//td[4]//input[@type='number']";
	
	public static final String CancellatiotoNew = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][1]//span[@class='k-select']//preceding-sibling::span[1][text()='Cancellation']";
	//public static final String NewVal3 = "@xpath=//html/body/div[9]/div/div[2]/ul/li[2][text()='New']";
	public static final String NewVal3 =  "@xpath=//html/body/div[9]/div/div[2]/ul/li[2][text()='New']"; //"@xpath=//ul[@aria-hidden='false']//li[text()='New']";

	public static final String ReinstatmentDrp = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][1]//span[@class='k-select']//preceding-sibling::span[1][text()='Reinstatement']";
	//public static final String Cancellation1 = "@xpath=//html/body/div[11]/div/div[2]/ul/li[5][text()='Cancellation']";
	public static final String Cancellation1 = "@xpath=//html/body/div[11]/div/div[2]/ul/li[5][text()='Cancellation']"; //"@xpath=//ul[@aria-hidden='false']//li[text()='Cancellation']";

	public static final String ReinstatmentDrp2 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][2]//span[@class='k-select']//preceding-sibling::span[1][text()='Reinstatement']";
	//public static final String Cancellation2 = "@xpath=//html/body/div[13]/div/div[2]/ul/li[5][text()='Cancellation']";
	public static final String Cancellation2 = "@xpath=//ul[@aria-hidden='false']//li[text()='Cancellation']";

	public static final String ReinstatmentDrp3 = "@xpath=//*[@id='multiReference_Id']//tr[@ng-if='data.BDEngineErrorValues.length'][3]//span[@class='k-select']//preceding-sibling::span[1][text()='Reinstatement']";
	//public static final String Cancellation3 = "@xpath=//div[35]//li[@class='k-item ng-scope'][text()='Cancellation']";
	public static final String Cancellation3 = "@xpath=//ul[@aria-hidden='false']//li[text()='Cancellation']";

	
	public static final String EnrichedValTxt = "@xpath=//*[@id='Data0']";

	public static final String TideValDrp = "@xpath=//*[@id='content']//div[@ng-if='data.BEnrichmentVMList.length']//td[2]/div/div";
	public static final String TideValDrp1 = "@xpath=//*[@id='content']//tr[1]//td[4]";

	public static final String TideDrpVal = "@xpath=//*[@id='Data0_listbox']//li[text()='No']";
	public static final String TideDrpValUK = "@xpath=//*[@id='Data0_listbox']//li[text()='United Kingdom']";
	public static final String TideDrpValRMS = "@xpath=//*[@id='Data{{$index}}_listbox']/li[text()='RMS: 0 - Unknown']";

	public static final String SbmtRcdAssmntBtn = "@xpath=//*[@id='content']//button[@ng-click='submitBordereau()']";
	public static final String ForApprvl = "@xpath=//button[text()='For Approval']";
	public static final String ForApprvlScndRw = "@xpath=//button[text()='For Approval']";
	public static final String ApprvdBtn = "@xpath=//button[@ng-click = 'approveUnApproveBordereau(bordereauxData.Id)']";

	public static final String CreditCntrlCTab = "@xpath=.//*[@id='profile-main']//li[5]/a[text()='Credit Control']";
	public static final String FolderDrp = "@xpath=//*[@id='content']//div[@class='fg-line']//span[2]";


	//TC 3542
	public static final String GrossPremTxt = "@xpath=//*[@id='multiReference_Id']//input[@ng-model='item.Gross_Premium']";

	//TC 3876
	public static final String OnlyCurrentBtn = "@xpath=//label[contains(@for,'ts3')]";
	public static final String PaginationItem = "@xpath=//span[contains(.,'16 items')]";
	//TC 3915
	public static final String GrossPremiumValue = "@xpath=//*[@id='grid']//following::td[contains(@ng-click,'Gross Premium')][text()='5,000.00']";
	
	//public static final String Twelth ="@xpath=//*[@uib-popover='Review']//a";
	public static final String Twelth ="@xpath=//*[@uib-popover='Review']";
	//public static final String DefaultSpecified ="@xpath=//td[text()='Number of Stories']//following::td[2]//div[contains(.,'DEFAULT SPECIFIED')]";
	public static final String DefaultSpecified ="@xpath=//*[@id='grid']/div[2]/table/tbody/tr[43]/td[5]//button[contains(.,'DEFAULT SPECIFIED')]";
	public static final String Edit1 ="@xpath=//tr[1]//button[@ng-if='!w.$edit'][1]";
	public static final String Edit2 ="@xpath=//tr[2]//button[@ng-if='!w.$edit'][1]";

	public static final String ChangedValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
	public static final String OKBtn="@xpath=//div[@ng-click='cancel()']";
	public static final String DatasetLink = "@xpath=//a[text()='Datasets']";
	
	//-------------------------------------------------------- BordereauProcessIdentifySheetTests ---------------------------------------------------------------------//
	
	public void ErroscreenValTransactiontypSupplied_3541() throws Exception{
		
		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		ArrayList<String> DataCapture4 = new ArrayList<String>();
	
		String MonthDate = "April 2017";
		String val1 = "1";
		String val2 = "5";
		String ReqUrl = Configuration.url+"/api//FileStorage//UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
	//	policy.PolicyNumber = "452002SA";	
		
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);		
		BordereauProcess.openSelectedPolicy();
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3541Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC4755.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3541Path);	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S59609120180917.xlsx";	
		int size = 20057;
		String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(NewandRenewalEntriesLocator)==true){
				sleep(1000);
				verifyMustExists(UMRWrdVerify,"Verify UMR in Error Screen");
				Report.LogInfo("UMR is verified on Error Screen","Unique Market Reference","PASS");
				sleep(1000);
				verifyMustExists(UMRMultiValue,"Verify Multi Contract UMR");
				Report.LogInfo("UMR value is verified on Error Screen","Unique Market Reference value","PASS");
				sleep(1000);
				EndorsmentFirstContinue(val1,val2);
				EndorsmentContinueSecond_3541();
				ChangeStasCanToNew();
				ReinstatementToCancl();
				EnrichedValChange();
				TideValChange();
				TideValChangeToUnitedKingdm();
					sleep(1000);
					if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
						verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
						click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
						sleep(1000);
					} else {
						Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
					}
					
					if(isVisible(BordereauProcess.ReviewBtn)==true) {
						BordereauProcess.AssertBordereauStatus =  getTextFrom(BordereauProcess.ReviewBtn);	
						Report.LogInfo("ErroScreenCheck", BordereauProcess.AssertBordereauStatus, "PASS");	
						BordereauPage.openDATALink();
						BordereauPage.navigateToDATARiskTab();
						sleep(2000);
						
						
						// Row number column
						String RowNumber = "@xpath=//*[@data-field='RowNumber']";
						String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
						String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='6']";
						String RowNumber3 = "@xpath=//*[@data-field='RowNumber']//following::tr[3]//td[contains(@ng-click,'RowNumber')][text()='8']";
						String RowNumber4 = "@xpath=//*[@data-field='RowNumber']//following::tr[4]//td[contains(@ng-click,'RowNumber')][text()='9']";
						String RowNumber5 = "@xpath=//*[@data-field='RowNumber']//following::tr[5]//td[contains(@ng-click,'RowNumber')][text()='11']";
						click(RowNumber);
						sleep(2000);
						verifyMustExists(RowNumber1, "1st value");
						verifyMustExists(RowNumber2, "2nd value");
						verifyMustExists(RowNumber3, "3rd value");
						verifyMustExists(RowNumber4, "4th value");
						verifyMustExists(RowNumber5, "5th value");
						RN1 = getTextFrom(RowNumber1);
						RN2 = getTextFrom(RowNumber2);
						RN3 = getTextFrom(RowNumber3);
						RN4 = getTextFrom(RowNumber4);
						RN5 = getTextFrom(RowNumber5);
						
						sleep(2000);
						
						// Transaction Type Column
						String TransactionType = "@xpath=//*[@data-field='Transaction_Type']";
						String TransactionType1 = "@xpath=//*[@data-field='Transaction_Type']//following::tr[1]//td[contains(@ng-click,'Transaction_Type')][text()='Endorsement']";
						String TransactionType2 = "@xpath=//*[@data-field='Transaction_Type']//following::tr[2]//td[contains(@ng-click,'Transaction_Type')][text()='New']";
						String TransactionType3 = "@xpath=//*[@data-field='Transaction_Type']//following::tr[3]//td[contains(@ng-click,'Transaction_Type')][text()='Reinstatement']";
						String TransactionType4 = "@xpath=//*[@data-field='Transaction_Type']//following::tr[4]//td[contains(@ng-click,'Transaction_Type')][text()='Endorsement']";
						String TransactionType5 = "@xpath=//*[@data-field='Transaction_Type']//following::tr[5]//td[contains(@ng-click,'Transaction_Type')][text()='New']";
						DataCapture1 =	BordereauPage.RuleDataCapture(TransactionType1,"Transaction Type","New","Endorsement","A New or Renewal record cannot be received against the same risk more than once.");
						ActualDPVCOriginal = DataCapture1.get(0);
						ActualDPVCChanged = DataCapture1.get(1);
						ActualDPVCRuleName = DataCapture1.get(2);
						

						DataCapture2 = BordereauPage.RuleDataCapture(TransactionType2,"Transaction Type","Cancellation","New","Cancellation(s) must update an existing risk");
						ActualDPVCOriginal1 = DataCapture2.get(0);
						ActualDPVCChanged1 = DataCapture2.get(1);
						ActualDPVCRuleName1 = DataCapture2.get(2);
						
						verifyExists(TransactionType3, "3rd value");
						TT2 = getTextFrom(TransactionType3);
						
						
						DataCapture3 = BordereauPage.RuleDataCapture(TransactionType4,"Transaction Type","Renewal","Endorsement","A New or Renewal record cannot be received against the same risk more than once.");
						ActualDPVCOriginal2 = DataCapture3.get(0);
						ActualDPVCChanged2 = DataCapture3.get(1);
						ActualDPVCRuleName2 = DataCapture3.get(2);
						
						DataCapture4 = BordereauPage.RuleDataCapture(TransactionType5,"Transaction Type","Endorsement","New","Endorsement(s) must update an existing risk");
						ActualDPVCOriginal3 = DataCapture4.get(0);
						ActualDPVCChanged3 = DataCapture4.get(1);
						ActualDPVCRuleName3 = DataCapture4.get(2);
						
						policy.navigationOnBordereauxTab();		
				        BordereauProcess.deleteBorderEAUX(); 
			}else
				{
					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
				}
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}
		
		Report.LogInfo("ErroScreenCheck", BordereauProcess.AssertBordereauStatus, "PASS");	
	}

	public void ErroscreenValTransactiontypNotSupplied_3542() throws Exception{
		String MonthDate = "April 2017";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";		
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);		
		BordereauProcess.openSelectedPolicy();
		BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);
		BordereauProcess.DeleteError();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3542Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC4755.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3542Path);
		String Ufname = "S68394120181014.xlsx";	
		int size = 20057;
		String BordreauID = "76cdb33a-3ce5-4eb3-b5b5-d7a6e6f8d68c";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			
			EnrichedValChange();
			TideValChange();
			TideValChangeToUnitedKingdm();
				//TideValUKToRMS();	
				if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
					verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					sleep(1000);
				}				
				if(isVisible(BordereauProcess.ReviewBtn)==true) {
					BordereauProcess.AssertBordereauStatus =  getTextFrom(BordereauProcess.ReviewBtn);	
			BordereauProcess.deleteBorderEAUX(); 
		}else
			{
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
			}			
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();
		
		}
				
	}

	//3876 Add existing policies
	public void missingEntriesTreatedAsCancellation_3876() throws Exception
	{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		//String subSheet="Automation Risk Format 6";
		String subSheet="Automation Company 1 Risk Format 1 (Lloyd's Property Schema)";
		
		policy.CreateContractwithInceptionDate2018();	
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//policy.contractId = ReturnContractID();
		BordereauProcess.SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3876Path1 = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3876.xlsx";
		} 
		catch (IOException e) 
		{                 
			e.printStackTrace();
		}
		File excelFile = new File(sheet3876Path1);  
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
	
		String Ufname = "S76263520181020.xlsx";	
		int size = 19305;
		String BordreauID = "0ca8af8f-b8c6-4846-9937-46a2a0c685e4";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		
		reportingChannel.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(BordereauProcess.ReviewBtn,"Review button");
			click(BordereauProcess.ReviewBtn,"Review button");
			BordereauProcess.clickOnSubProcessRcdBtn();
			//BordereauProcess.clickOnSubAssesmntBtn();
			sleep(3000);
			waitForElementToAppear(policy.FrApprovalbtn,10);
			verifyMustExists(policy.FrApprovalbtn,"For Approval button");
			click(policy.FrApprovalbtn,"For Approval button");
			BordereauProcess.clickOnApproveBordBtn();		
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
		}

		BordereauProcess.openDATALink();
		BordereauProcess.navigateToDATARiskTab();
		List<WebElement> YearOfAccount =  webDriver.findElements(By.xpath("//*[@data-field='YearOfAccount']//following::td[contains(@ng-click,'YearOfAccount')][text()='2018']"));
		sleep(2000);
		AcualYearOfAccount = YearOfAccount.size();
		if(AcualYearOfAccount == 7)
		{
			Report.LogInfo("YearOfAccount", "Year Of Account is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("YearOfAccount", "Year Of Account is Displayed wrong", "FAIL");
		}
		sleep(2000);
		policy.navigationOnBordereauxTab();
		sleep(1000);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3876Path = fpath+"\\src\\test\\resources\\testdata\\cancelation_2_3876.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile1 = new File(sheet3876Path);  
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);

		String Ufname1 = "S65848520180613.xlsx";	
		int size1 = 18857;
		String  response1 = uploadFileinContract(ReqUrl,excelFile1,policy.contractId,Ufname1);
		String ID1 = extractIDFromResponseinsideContract(response1); 
		String payload2 = GeneratePayloadForContract(policy.contractId, BordreauID, ID1, Ufname1, size1, 2, "1", 2018);
        addAsDraft(payload2,DraftUrl);
        
       
		reportingChannel.refreshUploadedFile();
		BordereauProcess.openDATALink();
		BordereauProcess.navigateToDATARiskTab();
		//Locators
		List<WebElement> Endorsement = webDriver.findElements(By.xpath("//*[@data-field='Transaction_Type']//following::td[contains(@ng-click,'Transaction_Type')][text()='Endorsement']"));
		sleep(2000);
		AcualEndorsement = Endorsement.size();
		if(AcualEndorsement == 2)
		{
			Report.LogInfo("Endorsement", "Endorsement count is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("Endorsement", "Endorsement count is Displayed wrong", "FAIL");
		}
		sleep(1000);
		List<WebElement> Cancellation = webDriver.findElements(By.xpath("//*[@data-field='Transaction_Type']//following::td[contains(@ng-click,'Transaction Type')][text()='Cancellation']"));
		sleep(2000);
		if(Cancellation.size() == 5)
		{
			Report.LogInfo("Cancellation", "Cancellation count is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("Cancellation", "Cancellation count is Displayed wrong", "FAIL");
		}
		sleep(1000);
		verifyMustExists(OnlyCurrentBtn,"Only Current button");
		click(OnlyCurrentBtn,"Only Current button");
		sleep(3000);
		if(isVisible(PaginationItem) == true)
		{
			Report.LogInfo("PaginationCount", "Pagination count is Displayed 16 properly", "PASS");
		}
		else
		{
			Report.LogInfo("PaginationCount", "Pagination count is Displayed wrong", "FAIL");
		}
	}

	//3914 Validate mandatory reference field, boolean field, date Field, Integer Field, String field and percentage field
	public static final String CancelButtonOnScreen = "@xpath=//*[@ng-click='cancel()']";
	public static final String Okbtn="@xpath=//*[@ng-click='cancel()']";
	public static final String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich'][1]//td[6]";
	//public static final String TideValDrp = "@xpath=//*[@id='content']//div[@ng-if='data.BEnrichmentVMList.length']//td[2]/div/div";
	public static final String TideDrpValUK2 = "@xpath=//*[@class='k-animation-container'][last()]//*[@id='Data0_listbox']//li[text()='United Kingdom']";
		



	public void validateMandatoryReferenceField_3914() throws Exception
		{
			ReportingChannel reportingChannel = new ReportingChannel();
			BordereauProcessPage BordereauPage = new BordereauProcessPage();

			String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
			String InceptionDate = "01/01/2017";
			String InceptionDate1 = "31/12/2017";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String subSheet ="Stage 2(Transaction type not Applied)";
			String SubmitSheet="Automation Company Admin 1 Risk Format 23";
			homePage.adminMenu();
			BQPage.bordereauQueLink();
			BQPage.bordereauQuePage();
			BQPage.filterBordereauQuestionnaire1(SubmitSheet);
			sleep(2000);
			waitForElementToAppear(BQPage.EditBtn,5);
			verifyMustExists(BQPage.EditBtn,"Edit button");
			click(BQPage.EditBtn,"Edit button");
			BQPage.nextStapeClick();
			BQPage.FormatId = ReturnFormatID();
			
			policy.CreateContractwithInceptionDate2018();
			
			BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
			BordereauProcess.openSelectedPolicy();
			waitForElementToAppear(BordereauPage.SignedBtn,5);
			if(isVisible(BordereauPage.SignedBtn)== true){
				verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
				BordereauPage.SubmitBordereaux(subSheet);
				String GetData = Configuration.url+"/api/Contract/GetAllPage";
				String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3914Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3914.xlsx";
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile = new File(sheet3914Path);  
				policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
				//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_3914.xlsx\",\"UniqueFileName\":\"S27408620180101.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S27408620180101.xlsx\",\"Filesize\":20609,\"Path\":null,\"size\":20609,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				
				String Ufname = "S71713120180604.xlsx";	
				int size = 19759;
				String BordreauID = "c16a8c81-ee54-4e2c-8454-d8071c7788ae";
		        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
		        String ID = extractIDFromResponseinsideContract(response); 
		        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
		        addAsDraft(payload,DraftUrl);
				reportingChannel.refreshUploadedFile();
				String Invalidatefield= "@xpath=//h2[contains(.,'Invalid date values identified')]";
				String InvaliIntegerfield= "@xpath=//h2[contains(.,'Invalid integer values identified')]";
				
				
				if(BordereauPage.checkErrorReviewButton(BordereauPage.ReviewError)==true){
				{
					Report.LogInfo("ReviewError", "Riview Error status displayed successfully.", "PASS");
					
					
				/*	EnrichedValChange1("11");
					EnrichedValChange1("11");*/
					verifyMustExists(Invalidatefield,"Invalid date values identified page displayed");
					InvalidDate =  getTextFrom(Invalidatefield);
					Report.LogInfo("Invalid date values identified page displayed", InvalidDate, "PASS");				
					EnrichedValChange1("31/12/2018");
					
					verifyMustExists(InvaliIntegerfield,"Invalid Integer values identified page displayed");
					InvalidInterger =  getTextFrom(InvaliIntegerfield);
					Report.LogInfo("Invalid Integer values identified page displayed", InvalidInterger, "PASS");					
					EnrichedValChange1("10");
					
					TideValChange1();
					
					TideValChangeToUnitedKingdm1(TideDrpValUK);
					
					TideValChangeToUnitedKingdm1(TideDrpValUK2);
					
					waitForElementToAppear(CancelButtonOnScreen,5);
					click(CancelButtonOnScreen,"Cliked on Cancel");
					BordereauPage.refreshUploadedFile();
					if(isVisible(BordereauPage.ReviewBtn)==true){
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						JavascriptExecutor jse = (JavascriptExecutor)webDriver;
						jse.executeScript("scroll(0, -250);");
						BordereauPage.openDATALink();
						BordereauPage.navigateToDATARiskTab();
						
						String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
						String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/12/2018']";
						waitForElementToAppear(RiskExpiryDatecolumn,10);
						mouseOverAction(RiskExpiryDatecolumn);
						verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
						ExpairyDate =  getTextFrom(RiskExpiryDatecolumn);
						Report.LogInfo("RiskExpiryDate column", ExpairyDate, "PASS");
						sleep(2000);
						verifyExists(RiskExpiryDate1,"1st value");
						Date =  getTextFrom(RiskExpiryDate1);
						Report.LogInfo("RiskExpiryDate 1st value", Date, "PASS");
						BordereauPage.verifyBackground(RiskExpiryDate1,"rgba(0, 97, 0, 1)");
						click(RiskExpiryDate1,"RiskExpiryDate1");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						RuleName1 =  getTextFrom(RuleNameField);
						Report.LogInfo("Rule Name Field", RuleName1, "PASS");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
						String RiskCountrycolumn="@xpath=//*[@data-field='Risk_Country']";
						String RiskCountry5="@xpath=//*[@data-field='Risk_Country']//following::tr[5]//td[contains(@ng-click,'Risk_Country')][text()='United Kingdom']";
						waitForElementToAppear(RiskCountrycolumn,10);
						mouseOverAction(RiskCountrycolumn);
						verifyMustExists(RiskCountrycolumn,"Risk Country column");
						Countrycolumn =  getTextFrom(RiskCountrycolumn);
						Report.LogInfo("Risk Country column", Countrycolumn, "PASS");
						sleep(2000);
						verifyExists(RiskCountry5,"5th value");
						BordereauPage.verifyBackground(RiskCountry5,"rgba(0, 97, 0, 1)");
						click(RiskCountry5,"RiskCountry5");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						RuleName2 =  getTextFrom(RuleNameField);
						Report.LogInfo("Rule Name Field", RuleName2, "PASS");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
						String Sprinklerscolumn="@xpath=//*[@data-title='Location Sprinklers (Y/N)']";
						String SprinklersNo="@xpath=//*[@data-title='Location Sprinklers (Y/N)']//following::tr[3]//td[contains(@ng-click,'Sprinklers')][text()='No']";
						waitForElementToAppear(Sprinklerscolumn,10);
						mouseOverAction(Sprinklerscolumn);
						verifyMustExists(Sprinklerscolumn,"Sprintklers column");
						Sprinkler =  getTextFrom(Sprinklerscolumn);
						Report.LogInfo("Sprintklers column", Sprinkler, "PASS");
						sleep(2000);
						verifyExists(SprinklersNo,"No value");
						NO =  getTextFrom(SprinklersNo);
						Report.LogInfo("No value", NO, "PASS");
						BordereauPage.verifyBackground(SprinklersNo,"rgba(0, 97, 0, 1)");
						click(SprinklersNo,"Sprinklers No value");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						RuleName3 =  getTextFrom(RuleNameField);
						Report.LogInfo("Rule Name Field", RuleName3, "PASS");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
						String NumberOfStoriescolumn="@xpath=//*[@data-title='Location Number Of Buildings']";
						String NumberOfStroies10value="@xpath=//*[@data-title='Location Number Of Buildings']//following::tr[4]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
						waitForElementToAppear(NumberOfStoriescolumn,10);
						mouseOverAction(NumberOfStoriescolumn);
						verifyMustExists(NumberOfStoriescolumn,"Number of Stories column");
						Stories =  getTextFrom(NumberOfStoriescolumn);
						Report.LogInfo("Number of Stories column", Stories, "PASS");
						sleep(2000);
						verifyExists(NumberOfStroies10value,"4th value");
						StoryValue =  getTextFrom(NumberOfStroies10value);
						Report.LogInfo("4th value", StoryValue, "PASS");
						BordereauPage.verifyBackground(NumberOfStroies10value,"rgba(0, 97, 0, 1)");
						click(NumberOfStroies10value,"Number of Stories 10 value");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						RuleName4 =  getTextFrom(RuleNameField);
						Report.LogInfo("Rule Name Field", RuleName4, "PASS");
						click(Okbtn,"ok Buttton");
						sleep(2000);
						
					/*	String Taxpercent1column="@xpath=//*[@data-field='Tax_Percent_1']";
						String Taxpercent11value="@xpath=//*[@data-field='Tax_Percent_1']//following::tr[6]//td[contains(@ng-click,'Tax_Percent_1')][text()='11.00 %']";
						waitForElementToAppear(Taxpercent1column,10);
						mouseOverAction(Taxpercent1column);
						verifyMustExists(Taxpercent1column,"Tax percent 1 column");
						sleep(2000);
						verifyExists(Taxpercent11value,"11 % value");
						BordereauPage.verifyBackground(Taxpercent11value,"rgba(0, 97, 0, 1)");
						click(Taxpercent11value,"Number of Stories 10 value");
						waitForElementToAppear(Okbtn,5);
						verifyExists(RuleNameField,"Rule Name Field");
						click(Okbtn,"ok Buttton");
						sleep(2000);*/
						policy.navigationOnBordereauxTab();
						if(isVisible(BordereauPage.ReviewBtn)==true) {
							AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);	
							Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
							BordereauPage.deleteBorderEAUX(); 
				}else
					{
						Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
					}
						//BordereauPage.deleteBorderEAUX();
						}else{
						Report.LogInfo("ValidateReviewButton", "Review button not displayed", "Fail");
							}	
						}				
					}else{
						Report.LogInfo("ReviewError", "Riview Error not displayed.", "FAIL");
						goBack();
					}
			}else{
				Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
				}	
		}
	
	
	public void VerifyNewEntryGenerateOnAddingSubRiskIdentifier_3636() throws Exception{
		
		ReportingChannel reportingChannel = new ReportingChannel();
		String subSheet1="Automation Company Adin 1 Risk Format 30";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
	policy.CreateContractwithInceptionDate2018();
		
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			ContractStatus = 	getTextFrom(BordereauProcess.SignedBtn);
			BordereauProcess.SubmitBordereaux(subSheet1);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Location Breaches (2) (2).xlsx";
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			File excelFile = new File(sheet3915Path); 
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			String Ufname = "S40921120181111.xlsx";	
			int size = 18119;
			String BordreauID = "4bbb1461-2ce6-4f03-875a-44a1763f2667";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	    	reportingChannel.refreshUploadedFile();
	        if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
			{
				sleep(5000);
				if(isVisible(RenewalDrp)==true){
					waitForElementToAppear(NewandRenewalEntriesLocator,3);
					verifyMustExists(NewandRenewalEntriesLocator,"New or Renewal entries which already exist");
					NewandRenewalEntriesErrorScreen = getTextFrom(NewandRenewalEntriesLocator);
						
					waitForElementToAppear(SubRiskIdentifier,3);
					verifyMustExists(SubRiskIdentifier,"Sub Risk Identifier");
					sendKeys(SubRiskIdentifier,"2","SubRisk Reference Changed");
					sleep(1000);
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
					sleep(2000);
					if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
						verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
						click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
						sleep(1000);
						
						if(isVisible(BordereauProcess.RiskDataGrid)==true){
							verifyMustExists(BordereauProcess.RiskDataGrid," Navigate to Risk Data Grid");
							click(BordereauProcess.RiskDataGrid," Navigate to Risk Data Grid");
							
							waitForElementToAppear(RecordCountOfCurrentEntries,3);
							verifyMustExists(RecordCountOfCurrentEntries,"Record Count of Current Entries");
							if(isVisible(RecordCountOfCurrentEntries)==true){
								DataGridRecordCount = getTextFrom(RecordCountOfCurrentEntries);
								Report.LogInfo("BordereauXtatusCheck", "Record Count is displayed Correctly", "PASS");	
								policy.navigationOnBordereauxTab();
								BordereauProcess.deleteBorderEAUX(); 
								
							} else {
								Report.LogInfo("BordereauXtatusCheck", "Record Count is not displayed Correctly", "FAIL");	
								policy.navigationOnBordereauxTab();
								BordereauProcess.deleteBorderEAUX(); 
								
							}
						
					} else {
						Report.LogInfo("BordereauXtatusCheck", "Bordereaux Summary screen Not Displayed", "FAIL");	
						BordereauProcess.deleteBorderEAUX(); 
					}
				}else {
					Report.LogInfo("BordereauXtatusCheck", "Expected Error Screen not Displayed", "FAIL");	
					BordereauProcess.deleteBorderEAUX(); 
				}
			}else {
				Report.LogInfo("BordereauXtatusCheck", "Review Error not Displayed", "FAIL");	
			}
		}
		else {
			Report.LogInfo("SignedStatusCheck", "Contract not Signed", "FAIL");
		}
		}
	}
	public void Country_State_Clensing_TC3640() throws Exception{
		
		policy.PolicyNumber = "181029NR";
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);		
		BordereauProcess.openSelectedPolicy();
		contractId = "a6232f62-1ff0-4fb5-ae9b-a9d10c6bf103";
		ReportingChannel reportingChannel = new ReportingChannel();
		String subSheet1="Automation Company Adin 1 Risk Format 31";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		BordereauProcess.SubmitBordereaux(subSheet1);
		try
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Country_State_Clensing.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3915Path); 
		String Ufname = "S98585020181112.xlsx";	
		int size = 24839;
		String BordreauID = "1cafd1db-bed8-4bf0-a5a0-12d8580a4894";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
    	reportingChannel.refreshUploadedFile();
    	waitForElementToAppear(ErrorCountOnBordereauxGrid,3);
		verifyMustExists(ErrorCountOnBordereauxGrid,"Error Count on Bordereaux Grid");
		ErrorCount = getTextFrom(ErrorCountOnBordereauxGrid);
		 if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
				
			    waitForElementToAppear(InsuredCountryErrorScreenLocator,3);
				verifyMustExists(InsuredCountryErrorScreenLocator,"Mandatory Decimal Field Insured Name screen exists");			
				 SelectDropDownValue(SelectInsuredStateDD,SelectRiskCountryDV);
				 
				 waitForElementToAppear(CountryClensingMappingCount,3);
					verifyMustExists(CountryClensingMappingCount,"Mapping count is verified");			
					
				waitForElementToAppear(BordereauProcess.continuebtx,3);
				verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
				click(BordereauProcess.continuebtx,"Continue Button");	
				
				 waitForElementToAppear(InsuredStateDataType,3);
					verifyMustExists(InsuredStateDataType,"Insured State Error Screen");			
					 SelectDropDownValue(SelectInsuredStateDD,SelectInsuredStateDDV);
					 waitForElementToAppear(CountryClensingMappingCount,3);
						verifyMustExists(CountryClensingMappingCount,"Mapping count is verified");		
					 
					 waitForElementToAppear(BordereauProcess.continuebtx,3);
						verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
						click(BordereauProcess.continuebtx,"Continue Button");	
				
				 waitForElementToAppear(CountryClensingMappingCount,3);
					verifyMustExists(CountryClensingMappingCount,"Mapping count is verified");			
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");	
					
					 waitForElementToAppear(CountryClensingMappingCount,3);
						verifyMustExists(CountryClensingMappingCount,"Mapping count is verified");		
							
							waitForElementToAppear(BordereauProcess.continuebtx,3);
							verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
							click(BordereauProcess.continuebtx,"Continue Button");	
							
							if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
								verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
								click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
								sleep(1000);
								BordereauProcess.deleteBorderEAUX(); 
							}
							else {
								Report.LogInfo("Check", "Summary Screen Not Displayed", "FAIL");
							}

		 }
		 BordereauProcess.SubmitBordereaux(subSheet1);	 
		 try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Country_State_Claims.xlsx";
				Report.LogInfo("", sheet3915Path, "PASS");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			 excelFile = new File(sheet3915Path); 
			 Ufname = "S20285620180929.xlsx";	
			 size = 12995;
			 BordreauID = "6a0ddf19-51da-4955-888b-45c8144ed5f8";
				Report.LogInfo("", "1", "PASS");
	         response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	         Report.LogInfo("", response, "PASS");
	         ID = extractIDFromResponseinsideContract(response); 
	         Report.LogInfo("", ID, "PASS");
	         payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
	         Report.LogInfo("", payload, "PASS");
	        addAsDraft(payload,DraftUrl);
	        Report.LogInfo("", "1", "PASS");
	    	reportingChannel.refreshUploadedFile();
	    	waitForElementToAppear(ErrorCountOnBordereauxGrid,3);
			verifyMustExists(ErrorCountOnBordereauxGrid,"Error Count on Bordereaux Grid");
			ClaimErrorCount = getTextFrom(ErrorCountOnBordereauxGrid);
			 if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
				
				 waitForElementToAppear(LossCountryErrorScreenLocator,3);
					verifyMustExists(LossCountryErrorScreenLocator,"Mandatory Decimal Field Insured Name screen exists");			
					 SelectDropDownValue(SelectInsuredStateDD,SelectRiskCountryDV);
					 
					 waitForElementToAppear(CountryClensingMappingCount,3);
						verifyMustExists(CountryClensingMappingCount,"Mapping count is verified");			
						
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");	
					
					 waitForElementToAppear(InsuredCountryErrorScreenLocator,3);
						verifyMustExists(InsuredCountryErrorScreenLocator,"Mandatory Decimal Field Insured Name screen exists");	
					
					 waitForElementToAppear(CountryClensingMappingCount,3);
						verifyMustExists(CountryClensingMappingCount,"Mapping count is verified");			
						
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");	
					
					 waitForElementToAppear(InsuredStateDataType,3);
						verifyMustExists(InsuredStateDataType,"Insured State Error Screen");			
						 SelectDropDownValue(SelectInsuredStateDD,SelectInsuredStateDDV);
						 
						 waitForElementToAppear(BordereauProcess.continuebtx,3);
							verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
							click(BordereauProcess.continuebtx,"Continue Button");	
							
							waitForElementToAppear(BordereauProcess.continuebtx,3);
							verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
							click(BordereauProcess.continuebtx,"Continue Button");	
							
							waitForElementToAppear(BordereauProcess.continuebtx,3);
							verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
							click(BordereauProcess.continuebtx,"Continue Button");	
						
					

							if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
								verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
								click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
								sleep(1000);
								BordereauProcess.deleteBorderEAUX(); 
							}
							else {
								Report.LogInfo("Check", "Summary Screen Not Displayed", "FAIL");
								BordereauProcess.deleteBorderEAUX(); 
								}
				 
			 }
			 else {
				 
			 }
		
	}
	public void Data_Type_Clensing_TC3639() throws Exception{
		
    	ReportingChannel reportingChannel = new ReportingChannel();
		String subSheet1="Automation Company Adin 1 Risk Format 31";
		String subSheet2="Automation Company Admin 1 Claims Format ";
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauProcess.SubmitBordereaux(subSheet1);
		try
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Data_Error_Screens.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3915Path); 
		String Ufname = "S84687120181111.xlsx";	
		int size = 25915;
		String BordreauID = "1cafd1db-bed8-4bf0-a5a0-12d8580a4894";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
    	reportingChannel.refreshUploadedFile();
    	waitForElementToAppear(ErrorCountOnBordereauxGrid,3);
		verifyMustExists(ErrorCountOnBordereauxGrid,"Error Count on Bordereaux Grid");
		ErrorCount=getTextFrom(ErrorCountOnBordereauxGrid);
		 if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
			
			    waitForElementToAppear(DecimalDataType,3);
				verifyMustExists(DecimalDataType,"Mandatory Decimal Field Insured Name screen exists");		
				MandatoryErrorRP1 = getTextFrom(DecimalDataType);
				verifyMustExists(InputTextInsuredName,"Tide decimal value");
				sendKeys(InputTextInsuredName,"1","Decimal value entered");	
				waitForElementToAppear(BordereauProcess.continuebtx,3);
				verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
				click(BordereauProcess.continuebtx,"Continue Button");	
				
				waitForElementToAppear(PercentageDatatype,3);
				verifyMustExists(PercentageDatatype,"Mandatory Percentage Field Insured Name screen exists");
				MandatoryErrorRP2 = getTextFrom(PercentageDatatype);
				verifyMustExists(InputTextPercentage1,"Tide value dropdown");
				sendKeys(InputTextPercentage1,"1","Percentage value entered");	
				waitForElementToAppear(BordereauProcess.continuebtx,3);
				verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
				click(BordereauProcess.continuebtx,"Continue Button");
				
				waitForElementToAppear(DateDataType,3);
				verifyMustExists(DateDataType,"Invalid date values identified");
				MandatoryErrorRP3 = getTextFrom(DateDataType);
				verifyMustExists(InputTextInsuredName,"Tide value dropdown");
				sendKeys(InputTextInsuredName,"01/10/2018","date value entered");	
				waitForElementToAppear(BordereauProcess.continuebtx,3);
				verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
				click(BordereauProcess.continuebtx,"Continue Button");
				
				waitForElementToAppear(IntegerDataType,3);
				verifyMustExists(IntegerDataType,"Mandatory String Field Insured Name screen exists");
				MandatoryErrorRP4 = getTextFrom(IntegerDataType);
				verifyMustExists(InputTextPercentage1,"Tide value dropdown");
				sendKeys(InputTextPercentage1,"9","Insured Name");	
				waitForElementToAppear(BordereauProcess.continuebtx,3);
				verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
				click(BordereauProcess.continuebtx,"Continue Button");
				
			 waitForElementToAppear(ReferenceDataType,3);
			 verifyMustExists(ReferenceDataType,"Mandatory Location Sprinklers screen exists");
			 MandatoryErrorRP5 = getTextFrom(ReferenceDataType);
			 SelectDropDownValue(SelectLocationSprinklersDD,CancellationReasonDDV);
			 waitForElementToAppear(BordereauProcess.continuebtx,3);
	     	 verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			 click(BordereauProcess.continuebtx,"Continue Button");
		      		
			 waitForElementToAppear(InsuredStateDataType,3);
			 verifyMustExists(InsuredStateDataType,"Mandatory Risk Country screen exists");
			 MandatoryErrorRP6 = getTextFrom(InsuredStateDataType);
			 SelectDropDownValue(SelectInsuredStateDD,SelectInsuredStateDDV);
						
			waitForElementToAppear(BordereauProcess.continuebtx,3);
			verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			click(BordereauProcess.continuebtx,"Continue Button");
								
			if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
				verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				sleep(1000);
				verifyMustExists(BordereauProcess.RiskAndPremiumDataGrid," Navigate to Risk and Premium Data Grid");
				click(BordereauProcess.RiskAndPremiumDataGrid," Navigate to Risk and Premium Data Grid");
				
			
				String CancellationDate="@xpath=//*[@data-field='Cancellation_Date']//following::tr[1]//td[contains(@ng-click,'Cancellation_Date')]";
				String Cancellation_Reason="@xpath=//*[@data-field='Cancellation_Reason']//following::tr[1]//td[contains(@ng-click,'Cancellation_Reason')]";
				String London_Brokerage="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')]";
				String Insured_Country="@xpath=//*[@data-field='Insured_State']//following::tr[7]//td[contains(@ng-click,'Insured_State')]";
				String Broker_Settlement_Currency_RoE="@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')]";
				String A_Buildings_Value="@xpath=//*[@data-field='A_Buildings_Value']//following::tr[3]//td[contains(@ng-click,'A_Buildings_Value')]";
	
				 BordereauProcess.RuleDataCapture(CancellationDate,"CancellationDate","1/1/20fdsd18","01/10/2018","Validate Date values");
				 BordereauProcess.RuleDataCapture(London_Brokerage,"London_Brokerage","10000","1.00","Validate Percentage values");
				 BordereauProcess.RuleDataCapture(Cancellation_Reason,"Cancillation Reason","dfghfdhd","Alternative product purchased","Validate Reference Data values");
				 BordereauProcess.RuleDataCapture(Insured_Country,"Insured_State","retetryryyyr","Alabama","Validate reference data values");
				 BordereauProcess.RuleDataCapture(Broker_Settlement_Currency_RoE,"Broker_Settlement_Currency_RoE","dsfgdsg","1.00","Validate Decimal values");
				 BordereauProcess.RuleDataCapture(A_Buildings_Value,"A_Buildings_Value","sasf","9","Validate Integer values");
				 waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
					sleep(1500);
					verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
					click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
				 BordereauProcess.deleteBorderEAUX(); 				
			}	else {
				Report.LogInfo("Check", "Summary screen not displayed", "FAIL");
				 waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
					sleep(1500);
					verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
					click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
					BordereauProcess.deleteBorderEAUX(); 
			}
		
		 }
		 else {
			 Report.LogInfo("BordereauxStatus", "Review error status not Displayed", "FAIL");
		 }
		 
		 BordereauProcess.SubmitBordereaux(subSheet2);
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Data_Type_Clensing_Claims.xlsx";
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			 excelFile = new File(sheet3915Path); 
			 Ufname = "S33632620181112.xlsx";	
			 size = 13180;
			 BordreauID = "5ae92072-5532-4dee-9002-b9d0b199009c";
	         response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	         ID = extractIDFromResponseinsideContract(response); 
	         payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
	        addAsDraft(payload,DraftUrl);
	    	reportingChannel.refreshUploadedFile();
	    	waitForElementToAppear(ErrorCountOnBordereauxGrid,3);
			verifyMustExists(ErrorCountOnBordereauxGrid,"Error Count on Bordereaux Grid");
			ErrorCount=getTextFrom(ErrorCountOnBordereauxGrid);
			ClaimErrorCount = getTextFrom(ErrorCountOnBordereauxGrid);
			 if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
					
					waitForElementToAppear(PercentageDatatype,3);
					verifyMustExists(PercentageDatatype,"Mandatory Percentage Field Insured Name screen exists");
					MandatoryErrorC2 = getTextFrom(PercentageDatatype);
					verifyMustExists(InputTextPercentage1,"Tide value dropdown");
					sendKeys(InputTextPercentage1,"1","Percentage value entered");	
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");
					
					waitForElementToAppear(BooleanDataType,3);
					verifyMustExists(BooleanDataType,"Mandatory Percentage Field Insured Name screen exists");
					MandatoryErrorC3 = getTextFrom(BooleanDataType);
					verifyMustExists(SelectLocationSprinklersDD,"Tide value dropdown");
					 SelectDropDownValue(SelectLocationSprinklersDD,SelectLocationSprinklersDV);
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");
					
					waitForElementToAppear(ReferenceDataTypeClaims,3);
					 verifyMustExists(ReferenceDataTypeClaims,"Mandatory Location Sprinklers screen exists");
					 MandatoryErrorC4 = getTextFrom(ReferenceDataTypeClaims);
					 SelectDropDownValue(SelectLocationSprinklersDD,SelectClaimStatusDV);
					 waitForElementToAppear(BordereauProcess.continuebtx,3);
			     	 verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					 click(BordereauProcess.continuebtx,"Continue Button");
						if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
							verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
							click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
							sleep(1000);
							verifyMustExists(BordereauProcess.ClaimsDataGrid," Navigate to Risk and Premium Data Grid");
							click(BordereauProcess.ClaimsDataGrid," Navigate to Risk and Premium Data Grid");
							
						
							String Risk_Order_Percent="@xpath=//*[@data-field='Risk_Order_Percent']//following::tr[3]//td[contains(@ng-click,'Risk_Order_Percent')]";
							String IsDenial="@xpath=//*[@data-field='IsDenial']//following::tr[1]//td[contains(@ng-click,'IsDenial')]";
							String ClaimStatus="@xpath=//*[@data-field='ClaimStatus']//following::tr[5]//td[contains(@ng-click,'ClaimStatus')]";
						//	String Rate_of_Exchange="@xpath=//*[@data-field='Rate_of_Exchange']//following::tr[4]//td[contains(@ng-click,'Rate_of_Exchange')]";
							
							 BordereauProcess.RuleDataCapture(Risk_Order_Percent,"Risk_Order_Percent","sfdsfdsf","1.00","Validate Percentage values");
							 BordereauProcess.RuleDataCapture(IsDenial,"IsDenial","Yesdsfsdg","No","Validate Boolean values");
							 BordereauProcess.RuleDataCapture(ClaimStatus,"ClaimStatus","dgdfgfdg","Open","Validate Reference Data values");
					//		 BordereauProcess.RuleDataCapture(Rate_of_Exchange,"Rate_of_Exchange","edfeew","1.00","Validate Decimal values");
							 waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
								sleep(1500);
								verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
								click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
							 BordereauProcess.deleteBorderEAUX(); 	
									
						}	else {
							Report.LogInfo("Check", "Summary screen not displayed", "FAIL");
							BordereauProcess.deleteBorderEAUX(); 
						}
					 
			 }
			 
			 else {
				 Report.LogInfo("BordereauxStatus", "Review error status not Displayed", "FAIL");
					
			 }
		
		 
	}
	
	public String ActualExpiryOriginal;
	public String ActualExpiryChanged;
	public String ActualExpiryRulename;
	public void Mandatory_Reference_Error_Screens_TC3638() throws Exception{
		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		ArrayList<String> DataCapture4 = new ArrayList<String>();
		ArrayList<String> DataCapture5 = new ArrayList<String>();
		ArrayList<String> DataCapture6 = new ArrayList<String>();
		ReportingChannel reportingChannel = new ReportingChannel();
		String subSheet1="Automation Company Adin 1 Risk Format 31";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String DueDays1 = "30";
		 
		String NumberExpected1 ="18";
		String ChannelTypeOption1 = "Bordereaux";
		String TypeOption1 = "Risk And Premium";
		String TypeOption2 = "Claim";
		String Frequency1 = "Monthly";
		String ChannelIdentifier1 ="Risk And Premium Bordereaux";
		String ChannelIdentifier2 ="Claim Bordereaux";
		policy.navigateToReportingChannelsTab();
	RC.addReportingChannel(ChannelTypeOption1,TypeOption1,Frequency1,DueDays1,ChannelIdentifier1,NumberExpected1);
	RC.addReportingChannel(ChannelTypeOption1,TypeOption2,Frequency1,DueDays1,ChannelIdentifier2,NumberExpected1);
		BordereauProcess.SubmitBordereaux(subSheet1);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Mandatory_Ref_Screens.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3915Path); 
		String Ufname = "S23906620181111.xlsx";	
		int size = 25870;
		String BordreauID = "caa8a311-27d1-4eaa-aceb-fe46c08ef969";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
    	reportingChannel.refreshUploadedFile();
    	waitForElementToAppear(ErrorCountOnBordereauxGrid,3);
		verifyMustExists(ErrorCountOnBordereauxGrid,"Error Count on Bordereaux Grid");
		ErrorCount = getTextFrom(ErrorCountOnBordereauxGrid);
		 if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
			
			 waitForElementToAppear(LocationSprinklersMandatory,3);
			 verifyMustExists(LocationSprinklersMandatory,"Mandatory Location Sprinklers screen exists");
			 MandatoryErrorRP1 = getTextFrom(LocationSprinklersMandatory);
			 SelectDropDownValue(SelectLocationSprinklersDD,SelectLocationSprinklersDV);
			 waitForElementToAppear(VerifyRiskRefExists,3);
			 verifyMustExists(VerifyRiskRefExists,"Verify Risk Ref Exists");
			 waitForElementToAppear(BordereauProcess.continuebtx,3);
	     	 verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			 click(BordereauProcess.continuebtx,"Continue Button");
		      		
			 waitForElementToAppear(RiskCountryMandatory,3);
			 verifyMustExists(RiskCountryMandatory,"Mandatory Risk Country screen exists");
			 MandatoryErrorRP2 = getTextFrom(RiskCountryMandatory);
			 SelectDropDownValue(SelectLocationSprinklersDD,SelectRiskCountryDV);
			waitForElementToAppear(VerifyRiskRefExists2,3);
			verifyMustExists(VerifyRiskRefExists2,"Verify Risk Ref Exists");				
			waitForElementToAppear(BordereauProcess.continuebtx,3);
			verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			click(BordereauProcess.continuebtx,"Continue Button");
								
			waitForElementToAppear(InsuredNameMandatory,3);
			verifyMustExists(InsuredNameMandatory,"Mandatory String Field Insured Name screen exists");
			MandatoryErrorRP3 = getTextFrom(InsuredNameMandatory);
			verifyMustExists(InputTextInsuredName,"Tide value dropdown");
			sendKeys(InputTextInsuredName,"Insured Name 9","Insured Name");	
			waitForElementToAppear(BordereauProcess.continuebtx,3);
			verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			click(BordereauProcess.continuebtx,"Continue Button");
										
							
			waitForElementToAppear(DecimalMandatory,3);
			verifyMustExists(DecimalMandatory,"Mandatory Decimal Field Insured Name screen exists");			
			MandatoryErrorRP4 = getTextFrom(DecimalMandatory);
			verifyMustExists(InputTextInsuredName,"Tide value dropdown");
			sendKeys(InputTextInsuredName,"1","Decimal value entered");	
			waitForElementToAppear(BordereauProcess.continuebtx,3);
			verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			click(BordereauProcess.continuebtx,"Continue Button");				
											 
			waitForElementToAppear(PercentageMandatory,3);
			verifyMustExists(PercentageMandatory,"Mandatory Percentage Field Insured Name screen exists");
			MandatoryErrorRP5 = getTextFrom(PercentageMandatory);
			verifyMustExists(InputTextPercentage,"Tide value dropdown");
			sendKeys(InputTextPercentage,"1","Percentage value entered");	
			waitForElementToAppear(BordereauProcess.continuebtx,3);
			verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			click(BordereauProcess.continuebtx,"Continue Button");
												
			waitForElementToAppear(DateMandatory,3);
			verifyMustExists(DateMandatory,"Mandatory Date Field Insured Name screen exists");
			MandatoryErrorRP6 = getTextFrom(DateMandatory);
			verifyMustExists(InputTextInsuredName,"Tide value dropdown");
			sendKeys(InputTextInsuredName,"01/10/2018","date value entered");	
			waitForElementToAppear(BordereauProcess.continuebtx,3);
			verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
			click(BordereauProcess.continuebtx,"Continue Button");
			if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
				verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				sleep(1000);
				verifyMustExists(BordereauProcess.RiskAndPremiumDataGrid," Navigate to Risk and Premium Data Grid");
				click(BordereauProcess.RiskAndPremiumDataGrid," Navigate to Risk and Premium Data Grid");
				
			
				String RiskExpiryDate="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')]";
				String RiskCountry="@xpath=//*[@data-field='Risk_Country']//following::tr[8]//td[contains(@ng-click,'Risk_Country')]";
				String InsuredName="@xpath=//*[@data-field='Insured_Name']//following::tr[7]//td[contains(@ng-click,'Insured_Name')]";
				String CoverholderCommision_Per="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')]";
				String LocationSprinklers="@xpath=//*[@data-field='Location_Sprinklers_YN']//following::tr[6]//td[contains(@ng-click,'Location_Sprinklers_YN')]";
				String VesselLength="@xpath=//*[@data-field='Vessel_Length']//following::tr[2]//td[contains(@ng-click,'Vessel_Length')]";
	
				DataCapture1 =  BordereauProcess.RuleDataCapture(RiskExpiryDate,"Risk Expiry date","-","01/10/2018","Validate mandatory date field populated");
				ActualExpiryOriginal = DataCapture1.get(0);
				ActualExpiryChanged = DataCapture1.get(1);
				ActualExpiryRulename = DataCapture1.get(2);
				DataCapture2 =	BordereauProcess.RuleDataCapture(InsuredName,"Insured Name","-","Insured Name 9","Validate mandatory string field populated");
				DataCapture3 =	BordereauProcess.RuleDataCapture(RiskCountry,"Risk Country","-","United States of America","Validate mandatory System Reference field populated");
				DataCapture4 =	BordereauProcess.RuleDataCapture(CoverholderCommision_Per,"Commision Percentage","-","1.00","Validate mandatory percentage field populated");
				DataCapture5 =	BordereauProcess.RuleDataCapture(LocationSprinklers,"Location Sprinklers","-","No","Validate mandatory reference field populated");
				DataCapture6 =	BordereauProcess.RuleDataCapture(VesselLength,"Location Sprinklers","-","1.00","Validate mandatory decimal field populated");
				
				 waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
					sleep(1500);
					verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
					click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
				 BordereauProcess.deleteBorderEAUX(); 				
			}	else {
				Report.LogInfo("Check", "Summary screen not displayed", "FAIL");
				 waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
					sleep(1500);
					verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
					click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
				BordereauProcess.deleteBorderEAUX(); 
			}
			
		 } else {
			 Report.LogInfo("Check", "Review status displayed", "FAIL");
		 }
		 
		 try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Claims Financial Calculations February_TC_4104_second (4).xlsx";
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		     excelFile = new File(sheet3915Path); 
			 Ufname = "S96718220181111.xlsx";	
			 size = 13134;
			 BordreauID = "eeb6cb5c-a523-4308-a8c7-71eed23d7599";
	         response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	         ID = extractIDFromResponseinsideContract(response); 
	         payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
	        addAsDraft(payload,DraftUrl);
	    	reportingChannel.refreshUploadedFile();
	    	waitForElementToAppear(ErrorCountOnBordereauxGrid,3);
			verifyMustExists(ErrorCountOnBordereauxGrid,"Error Count on Bordereaux Grid");
			ClaimErrorCount = getTextFrom(ErrorCountOnBordereauxGrid);
			 if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
				 waitForElementToAppear(ClaimStatusMandatoryRef,3);
				 verifyMustExists(ClaimStatusMandatoryRef,"Mandatory Location Sprinklers screen exists");
				 MandatoryErrorC1 = getTextFrom(ClaimStatusMandatoryRef);
				 SelectDropDownValue(SelectLocationSprinklersDD,SelectClaimStatusDV);
				 waitForElementToAppear(BordereauProcess.continuebtx,3);
		     	 verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
				 click(BordereauProcess.continuebtx,"Continue Button");
			
				 
				 waitForElementToAppear(InsuredNameMandatory,3);
					verifyMustExists(InsuredNameMandatory,"Mandatory String Field Insured Name screen exists");
					 MandatoryErrorC2 = getTextFrom(InsuredNameMandatory);
					verifyMustExists(InputTextInsuredName,"Tide value dropdown");
					sendKeys(InputTextInsuredName,"Insured Name 9","Insured Name");	
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");
					
					/*waitForElementToAppear(DecimalMandatory,3);
					verifyMustExists(DecimalMandatory,"Mandatory Decimal Field Insured Name screen exists");
					 MandatoryErrorC3 = getTextFrom(DecimalMandatory);
					verifyMustExists(InputTextInsuredName,"Tide value dropdown");
					sendKeys(InputTextInsuredName,"1","Decimal value entered");	
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");	*/


					waitForElementToAppear(PercentageMandatory,3);
					verifyMustExists(PercentageMandatory,"Mandatory Percentage Field Insured Name screen exists");
					 MandatoryErrorC4 = getTextFrom(PercentageMandatory);
					verifyMustExists(InputTextPercentage1,"Tide value dropdown");
					sendKeys(InputTextPercentage1,"1","Percentage value entered");	
					waitForElementToAppear(BordereauProcess.continuebtx,3);
					verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					click(BordereauProcess.continuebtx,"Continue Button");
					
					waitForElementToAppear(BooleanFieldMandatory,3);
					 verifyMustExists(BooleanFieldMandatory,"Mandatory boolean data field not populated");
					 MandatoryErrorC5 = getTextFrom(BooleanFieldMandatory);
					 refreshPage();
					 SelectDropDownValue(SelectLocationSprinklersDD,SelectLocationSprinklersDV);
					 waitForElementToAppear(BordereauProcess.continuebtx,3);
			     	 verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
					 click(BordereauProcess.continuebtx,"Continue Button");
					 
					 waitForElementToAppear(DateMandatory,3);
						verifyMustExists(DateMandatory,"Mandatory date data field not populated");
						 MandatoryErrorC6 = getTextFrom(DateMandatory);
						verifyMustExists(InputTextInsuredName,"Tide value dropdown");
						sendKeys(InputTextInsuredName,"01/10/2018","date value entered");	
						waitForElementToAppear(BordereauProcess.continuebtx,3);
						verifyMustExists(BordereauProcess.continuebtx,"Continue Button");
						click(BordereauProcess.continuebtx,"Continue Button");
						
						if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
							verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
							click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
							sleep(1000);
							verifyMustExists(BordereauProcess.ClaimsDataGrid," Navigate to Risk and Premium Data Grid");
							click(BordereauProcess.ClaimsDataGrid," Navigate to Risk and Premium Data Grid");
							
						
							String RiskOrderPercentage="@xpath=//*[@data-field='Risk_Order_Percent']//following::tr[3]//td[contains(@ng-click,'Risk_Order_Percent')]";
							String DenialYN="@xpath=//*[@data-field='IsDenial']//following::tr[1]//td[contains(@ng-click,'IsDenial')]";
							String InsuredName="@xpath=//*[@data-field='Insured_Name']//following::tr[6]//td[contains(@ng-click,'Insured_Name')]";
							String ClaimStatus="@xpath=//*[@data-field='ClaimStatus']//following::tr[5]//td[contains(@ng-click,'ClaimStatus')]";
							String DateOfLoss_From="@xpath=//*[@data-field='DateOfLoss_From']//following::tr[2]//td[contains(@ng-click,'DateOfLoss_From')]";
							String Rate_of_Exchange="@xpath=//*[@data-field='Rate_of_Exchange']//following::tr[4]//td[contains(@ng-click,'Rate_of_Exchange')]";
				
							 BordereauProcess.RuleDataCapture(RiskOrderPercentage,"Risk Order %","-","1.00","Validate mandatory percentage field populated");
							 BordereauProcess.RuleDataCapture(InsuredName,"Insured Name","-","Insured Name 9","Validate mandatory string field populated");
							 BordereauProcess.RuleDataCapture(DenialYN,"DenialY/N","-","No","Validate mandatory boolean field populated");
							 BordereauProcess.RuleDataCapture(ClaimStatus,"ClaimStatus","-","Open","Validate mandatory reference field populated");
							 BordereauProcess.RuleDataCapture(DateOfLoss_From,"DateOfLoss_From","-","01/10/2018","Validate mandatory date field populated");
						//	 BordereauProcess.RuleDataCapture(Rate_of_Exchange,"Rate_of_Exchange","-","1.00","Validate mandatory decimal field populated");
							 waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
								sleep(1500);
								verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
								click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
							 BordereauProcess.deleteBorderEAUX(); 				
						}	else {
							Report.LogInfo("Check", "Summary screen not displayed", "FAIL");
							waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
							sleep(1500);
							verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
							click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
						BordereauProcess.deleteBorderEAUX(); 
						}
						
					 } else {
						 Report.LogInfo("Check", "Review status displayed", "FAIL");
					 }
			 }
		 
	
	public void DiscardAndRestoreRecords_3637() throws Exception{
		ReportingChannel reportingChannel = new ReportingChannel();
		String subSheet1="Automation Company Adin 1 Risk Format 30";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		
		
		BordereauProcess.SubmitBordereaux(subSheet1);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\DiscardAndRestoreRecords.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet3915Path); 
		String Ufname = "S26904120181111.xlsx";	
		int size = 18700;
		String BordreauID = "4bbb1461-2ce6-4f03-875a-44a1763f2667";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
    	reportingChannel.refreshUploadedFile();
    	waitForElementToAppear(ErrorCountOnBordereauxGrid,3);
		verifyMustExists(ErrorCountOnBordereauxGrid,"Error Count on Bordereaux Grid");
		ErrorCount = getTextFrom(ErrorCountOnBordereauxGrid);
    	 if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
			{
    		 Report.LogInfo("BordereauXtatusCheck", "Review Error  Displayed", "PASS");	
    		 
    		 waitForElementToAppear(BordereauProcess.SkipAllErrorsBtn3,3);
    			verifyMustExists(BordereauProcess.SkipAllErrorsBtn3,"Skip All Errors");
    			click(BordereauProcess.SkipAllErrorsBtn3,"Skip All Erroros");
    				
    			 waitForElementToAppear(BordereauProcess.ErrorsAndWarningTAB,3);
    			verifyMustExists(BordereauProcess.ErrorsAndWarningTAB,"Error And Warning Tab");
    			click(BordereauProcess.ErrorsAndWarningTAB,"Error And Warning Tab");
    			  waitForElementToAppear(BordereauProcess.DiscardRecords1,3);
      			verifyMustExists(BordereauProcess.DiscardRecords1,"Discard Record");
      			click(BordereauProcess.DiscardRecords1,"Discard Record");
      		
      			 waitForElementToAppear(BordereauProcess.DiscardRecords2,3);
     			verifyMustExists(BordereauProcess.DiscardRecords2,"Discard Record");
     			click(BordereauProcess.DiscardRecords2,"Discard Record");
     			
     			 waitForElementToAppear(BordereauProcess.RestoredRecords1,3);
      			verifyMustExists(BordereauProcess.RestoredRecords1,"Restore Records");
      			
      			 waitForElementToAppear(BordereauProcess.DiscardedRecords2,3);
      			verifyMustExists(BordereauProcess.DiscardedRecords2,"Discard Record");
      			
      		  waitForElementToAppear(BordereauProcess.ResolceError3,3);
    			verifyMustExists(BordereauProcess.ResolceError3,"Resolve Remaining Errors");
    			click(BordereauProcess.ResolceError3,"Resolve Remaining Errors");
    		
    			 waitForElementToAppear(ContinueBtn1,3);
     			verifyMustExists(ContinueBtn1,"Click on continue Button");
     			click(ContinueBtn1,"Click on continue Button");
     			
     			
     			 waitForElementToAppear(IntegerInput,3);
     			verifyMustExists(IntegerInput,"Error And Warning Tab");
     			sendKeys(IntegerInput,"1960","Input Building Value");
				
     			 waitForElementToAppear(ContinueBtn1,3);
      			verifyMustExists(ContinueBtn1,"Click on continue Button");
      			click(ContinueBtn1,"Click on continue Button");
      			
    			
      			if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
					verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					sleep(1000);
					
					if(isVisible(BordereauProcess.RiskDataGrid)==true){
						verifyMustExists(BordereauProcess.RiskDataGrid," Navigate to Risk Data Grid");
						click(BordereauProcess.RiskDataGrid," Navigate to Risk Data Grid");
						
						waitForElementToAppear(RecordCountOfCurrentEntries2,3);
						verifyMustExists(RecordCountOfCurrentEntries2,"Record Count of Current Entries");
						if(isVisible(RecordCountOfCurrentEntries2)==true){
							DataGridRecordCount = getTextFrom(RecordCountOfCurrentEntries2);
							Report.LogInfo("BordereauXtatusCheck", "Record Count is displayed Correctly", "PASS");
							BordereauProcess.OnViewDiscardedRecordsIcon();
							waitForElementToAppear(RecordCountOfCurrentEntries,3);
							verifyMustExists(RecordCountOfCurrentEntries,"Record Count of Discarded Entries");
							DiscardedRecordCount = getTextFrom(RecordCountOfCurrentEntries);
							policy.navigationOnBordereauxTab();
							BordereauProcess.deleteBorderEAUX(); 
							
						}
						else {
							Report.LogInfo("BordereauXtatusCheck", "Wrong record Count Displayed", "FAIL");	
							policy.navigationOnBordereauxTab();
							BordereauProcess.deleteBorderEAUX(); 
					
						}
					} else{
						Report.LogInfo("BordereauXtatusCheck", "Wrong screen Displayed", "FAIL");	
						policy.navigationOnBordereauxTab();
						BordereauProcess.deleteBorderEAUX(); 
				
	      		
					}
      			} else {
      				Report.LogInfo("BordereauXtatusCheck", "Bordereaux Summary screen Not Displayed", "FAIL");	
					BordereauProcess.deleteBorderEAUX(); 
			
      			}
      			
			}
    	 else {
    		 Report.LogInfo("BordereauXtatusCheck", "Review Error not Displayed", "FAIL");	
    		 BordereauProcess.deleteBorderEAUX(); 
    	 }
	}

	public void validateIntitialPremiumPositive_3915() throws Exception
	{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String subSheet1="Automation Company Adin 1 Risk Format 1";
		String subSheet2="Automation Company Admin 1 Risk Format 2 (Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet1);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		
		policy.CreateContractwithInceptionDate2018();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			BordereauProcess.SubmitBordereaux(subSheet1);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3915Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3915.xlsx";
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			File excelFile = new File(sheet3915Path); 
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String Ufname = "S24540620181020.xlsx";	
			int size = 18841;
			String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
		
			reportingChannel.refreshUploadedFile();
			String NegativePremium= "@xpath=//h2[contains(.,'First reporting of risk with negative premium')]";
			
			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
			{
				sleep(5000);
				if(isVisible(GrossPremTxt)==true){
					verifyMustExists(NegativePremium,"First reporting of risk with negative premium page");
					NegativGrossP =  getTextFrom(NegativePremium);
					Report.LogInfo("First reporting of risk with negative premium page displayed", NegativGrossP, "PASS");
					
					verifyMustExists(GrossPremTxt,"Tide value dropdown");
					sendKeys(GrossPremTxt,"5000","Gross Prem Txt");	
					waitForElementToAppear(ContinueBtn,3);
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
					sleep(2000);
					scrollUp();
					waitForElementToAppear(SbmtRcdAssmntBtn,5);
					if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
					verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
					sleep(1000);
					}else{
					Report.LogInfo("ErroScreenCheck", "Cancel button not displayed.", "FAIL");
					}
					
				}else{
					Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
				}
			}				
			else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
			
			}	
			sleep(2000);
			BordereauProcess.openDATALink();
			BordereauProcess.navigateToDATARiskTab();
			if(isVisible(GrossPremiumValue) == true)
			{
				verifyMustExists(GrossPremiumValue,"Gross Premium Value");
				GrossPremium =  getTextFrom(GrossPremiumValue);
				Report.LogInfo("Gross Premium Value", GrossPremium, "PASS");
				Report.LogInfo("GrossPremium", "Gross Premium is Displayed properly", "PASS");
			}
			else
			{
				Report.LogInfo("GrossPremium", "Gross Premium is Displayed wrong", "FAIL");
			}
			click(GrossPremiumValue,"Select Gross Premium Value");
			if(isVisible(ChangedValue))
			{
				
				Report.LogInfo("ChangedValueData", "Data is displayed", "PASS");
				verifyMustExists(ChangedValue,"Changed Value");	
				ChangeValue =  getTextFrom(ChangedValue);
			}
			else{
				Report.LogInfo("ChangedValueData", "Data is not displayed", "FAIL");
			}
			verifyMustExists(OKBtn,"Edit button");
			click(OKBtn,"Edit button");
			
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
		policy.navigationOnBordereauxTab();
		if(isVisible(BordereauProcess.ReviewBtn)==true) {
			AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);	
			Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
			BordereauProcess.deleteBorderEAUX(); 
}else
	{
		Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
	}
		//BordereauProcess.deleteBorderEAUX();
		
		//Upload file2
		BordereauProcess.SubmitBordereaux(subSheet2);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3915Path2 = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_3915_Second.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile1 = new File(sheet3915Path2);  
	
		 String Ufname1 = "S92678120181020.xlsx";	
		 int size1 = 19767;
		 String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
         String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
         String ID1 = extractIDFromResponseinsideContract(response1); 
         String payload2 = GeneratePayloadForContract(contractId, BordreauID, ID1, Ufname1, size1, 1 , "1", 2018);
        addAsDraft(payload2,DraftUrl);
	
		
		reportingChannel.refreshUploadedFile();
		String NegativePremium= "@xpath=//h2[contains(.,'First reporting of risk with negative premium')]";
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			sleep(5000);
			if(isVisible(GrossPremTxt)==true){
				verifyMustExists(NegativePremium,"First reporting of risk with negative premium page");
				NegativPremium =  getTextFrom(NegativePremium);
				Report.LogInfo("First reporting of risk with negative premium page displayed", NegativPremium, "PASS");
				
				verifyMustExists(GrossPremTxt,"Tide value dropdown");
				sendKeys(GrossPremTxt,"5000","Gross Prem Txt");	
				waitForElementToAppear(ContinueBtn,3);
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");
				sleep(2000);
				scrollUp();
				waitForElementToAppear(SbmtRcdAssmntBtn,5);
				if(isVisible(BordereauProcess.cancelAndDeleteProBtn)==true){
				verifyMustExists(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				click(BordereauProcess.cancelAndDeleteProBtn," Cancel button");
				sleep(1000);
				}else{
				Report.LogInfo("ErroScreenCheck", "Cancel button not displayed.", "FAIL");
				}
				
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
			}
		}				
		else{
			Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
			goBack();
		
			}	
		sleep(2000);
		BordereauProcess.openDATALink();
		BordereauProcess.navigateToDATARiskTab();
		if(isVisible(GrossPremiumValue) == true)
		{
			verifyMustExists(GrossPremiumValue,"Gross Premium Value");
			GrossPremium =  getTextFrom(GrossPremiumValue);
			Report.LogInfo("Gross Premium Value", GrossPremium, "PASS");
			Report.LogInfo("GrossPremium", "Gross Premium is Displayed properly", "PASS");
		}
		else
		{
			Report.LogInfo("GrossPremium", "Gross Premium is Displayed wrong", "FAIL");
		}
		click(GrossPremiumValue,"Select Gross Premium Value");
		if(isVisible(ChangedValue))
			{
				Report.LogInfo("ChangedValueData", "Data is displayed", "PASS");
				verifyMustExists(ChangedValue,"Changed Value");
				ChangeValue =  getTextFrom(ChangedValue);
			}
			else{
				Report.LogInfo("ChangedValueData", "Data is not displayed", "FAIL");
			}		
		verifyMustExists(OKBtn,"Edit button");
		click(OKBtn,"Edit button");
}


	//3981 Bespoke default - multiple default values based on conditions with equal to operator
	public void bespokeMultipleDefaultValuesEqual_3981() throws Exception{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String SelectQuestionnaire ="@xpath=//ul//li//*[@value='Automation Company Admin 1 Risk Format 5']";
		String SubsheetName ="Automation Company Admin 1 Risk Format 5Default value enhancement 1";
		String subSheet ="Automation Company Admin 1 Risk Format 5";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire(SubsheetName, SelectQuestionnaire);
		if(isVisible(BQPage.EditBtn)==true){
			waitForElementToAppear(BQPage.EditBtn,5);
			verifyMustExists(BQPage.EditBtn,"Edit button");
			click(BQPage.EditBtn,"Edit button");
			sleep(2000);
			verifyMustExists(Twelth,"Review 12th step");
			click(Twelth,"Review 12th step");
			verifyMustExists(DefaultSpecified,"Default Specified Button");
			click(DefaultSpecified,"Default Specified Button");
			verifyMustExists(Edit1,"Edit icon");
			click(Edit1,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(Edit2,"Edit icon");
			click(Edit2,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(policy.SaveBtn2,"Save button");
			click(policy.SaveBtn2,"Save button");
			verifyMustExists(policy.SaveBtn,"Save button");
			BQPage.FormatId = ReturnFormatID();
			System.out.println(BQPage.FormatId);
			click(policy.SaveBtn,"Save button");
			sleep(2000);
			BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
			BordereauProcess.openSelectedPolicy();
			if(isVisible(BordereauProcess.SignedBtn)== true){
				verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
				BordereauProcess.SubmitBordereaux(subSheet);	
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3981Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March 2017_TC_3981.xlsx";
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile = new File(sheet3981Path);  
				String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March 2017_TC_3981.xlsx\",\"UniqueFileName\":\"S13562020180116.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S13562020180116.xlsx\",\"Filesize\":18959,\"Path\":null,\"size\":18959,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				reportingChannel.refreshUploadedFile();
				if(isVisible(BordereauProcess.ReviewBtn)== true){
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					BordereauProcess.openDATALink();
					BordereauProcess.navigateToDATARiskTab();
					String NumberOfStoriescolumn="@xpath=//*[@data-field='NumberOfStories']";
					String NumberOfStoriesValue1="@xpath=//*[@data-field='NumberOfStories']//following::tr[1]//td[contains(@ng-click,'NumberOfStories')][text()='5']";
					String NumberOfStoriesValue2="@xpath=//*[@data-field='NumberOfStories']//following::tr[2]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					String NumberOfStoriesValue3="@xpath=//*[@data-field='NumberOfStories']//following::tr[3]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					String NumberOfStoriesValue4="@xpath=//*[@data-field='NumberOfStories']//following::tr[4]//td[contains(@ng-click,'NumberOfStories')][text()='15']";
					String NumberOfStoriesValue5="@xpath=//*[@data-field='NumberOfStories']//following::tr[5]//td[contains(@ng-click,'NumberOfStories')][text()='10']";		
					String NumberOfStoriesValue6="@xpath=//*[@data-field='NumberOfStories']//following::tr[6]//td[contains(@ng-click,'NumberOfStories')][text()='12']";		
					waitForElementToAppear(NumberOfStoriescolumn,8);
					mouseOverAction(NumberOfStoriescolumn);
					verifyMustExists(NumberOfStoriescolumn,"NumberOfStories column");
					sleep(2000);
					verifyExists(NumberOfStoriesValue1,"1st value");
					verifyExists(NumberOfStoriesValue2,"2nd value");
					verifyExists(NumberOfStoriesValue3,"3rd value");
					verifyExists(NumberOfStoriesValue4,"4th value");
					verifyExists(NumberOfStoriesValue5,"5th value");
					verifyExists(NumberOfStoriesValue6,"6th value");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					BordereauProcess.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("ButtonCheck", "Edit button not display", "FAIL");
		}
	}


	//3982 Bespoke default - multiple default values based on conditions with not equal to operator
	public void bespokeMultipleDefaultValuesNotEqual() throws Exception{
		ReportingChannel reportingChannel = new ReportingChannel();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String SelectQuestionnaire ="@xpath=//ul//li//*[@value='Default Value Enhancement 1']";
		String SubsheetName ="Default value enhancement 1";
		String subSheet ="Default value enhancement 1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire(SubsheetName, SelectQuestionnaire);
		if(isVisible(BQPage.EditBtn)==true){
			waitForElementToAppear(BQPage.EditBtn,5);
			verifyMustExists(BQPage.EditBtn,"Edit button");
			click(BQPage.EditBtn,"Edit button");
			sleep(3000);
			verifyMustExists(Twelth,"Review 12th step");
			click(Twelth,"Review 12th step");
			verifyMustExists(DefaultSpecified,"Default Specified Button");
			click(DefaultSpecified,"Default Specified Button");
			verifyMustExists(Edit1,"Edit icon");
			click(Edit1,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.NotEqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(Edit2,"Edit icon");
			click(Edit2,"Edit icon");
			SelectDropDownValue(policy.OperatorDD,policy.NotEqualToValue);
			verifyMustExists(policy.CheckBtn,"Check icon");
			click(policy.CheckBtn,"Check icon");
			verifyMustExists(policy.SaveBtn2,"Save button");
			click(policy.SaveBtn2,"Save button");
			verifyMustExists(policy.SaveBtn,"Save button");
			BQPage.FormatId = ReturnFormatID();
			System.out.println(BQPage.FormatId);
			click(policy.SaveBtn,"Save button");
			sleep(2000);
			BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
			BordereauProcess.openSelectedPolicy();
			if(isVisible(BordereauProcess.SignedBtn)== true){
				verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
				BordereauProcess.SubmitBordereaux(subSheet);
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3982Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 errors - March 2017_TC_3982.xlsx";
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				File excelFile = new File(sheet3982Path);  
			//	String payload ="{\"Bordereaux\":{\"ContractId\":\"27126cba-98af-4d8b-9a00-a1463eebdb1d\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March 2017_TC_3982.xlsx\",\"UniqueFileName\":\"S26722320171122.xlsx\",\"BordereauFormatId\":\"9bd03061-a9e4-44d0-b3ba-57c71c5688be\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S26722320171122.xlsx\",\"Filesize\":20053,\"Path\":null,\"size\":20053,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - March 2017_TC_3982.xlsx\",\"UniqueFileName\":\"S14001120180116.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14001120180116.xlsx\",\"Filesize\":18605,\"Path\":null,\"size\":18605,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				reportingChannel.refreshUploadedFile();
				if(isVisible(BordereauProcess.ReviewBtn)== true){
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					BordereauProcess.openDATALink();
					BordereauProcess.navigateToDATARiskTab();
					String NumberOfStoriescolumn="@xpath=//*[@data-field='NumberOfStories']";
					String NumberOfStoriesValue1="@xpath=//*[@data-field='NumberOfStories']//following::tr[1]//td[contains(@ng-click,'NumberOfStories')][text()='10']";
					String NumberOfStoriesValue2="@xpath=//*[@data-field='NumberOfStories']//following::tr[2]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					String NumberOfStoriesValue3="@xpath=//*[@data-field='NumberOfStories']//following::tr[3]//td[contains(@ng-click,'NumberOfStories')][text()='15']";
					String NumberOfStoriesValue4="@xpath=//*[@data-field='NumberOfStories']//following::tr[4]//td[contains(@ng-click,'NumberOfStories')][text()='20']";
					waitForElementToAppear(NumberOfStoriescolumn,8);
					mouseOverAction(NumberOfStoriescolumn);
					verifyMustExists(NumberOfStoriescolumn,"NumberOfStories column");
					sleep(2000);
					verifyExists(NumberOfStoriesValue1,"1st value");
					verifyExists(NumberOfStoriesValue2,"2nd value");
					verifyExists(NumberOfStoriesValue3,"3rd value");
					verifyExists(NumberOfStoriesValue4,"4th value");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					BordereauProcess.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
			}
		}else
		{
			Report.LogInfo("ButtonCheck", "Edit button not display", "FAIL");
		}
	}
	
	
	public void ValidateMandatoryReferenceField_TC5094() throws Exception
	{
		homePage.adminMenu(); 
		waitForElementToAppear(DatasetLink,5);
		verifyMustExists(DatasetLink,"Dataset link");
		click(DatasetLink,"Data set link");
		sleep(3000);
		DataRef.SelectRiskAndPremium();
		sleep(2000);
		BQPage.ChangeRiskAndPremium();
		String IncDate = "01/01/2018";
		String IncExpDate = "31/12/2018";
		String subSheet = "Rule testing(General and Location)";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";
			
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
		policy.addPolicy2(IncDate,IncExpDate);
		verifyExists(BordereauProcess.DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToSigned();
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		BordereauProcess.SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5094Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_5094.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5094Path);	
		BordereauProcess.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+BordereauProcess.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculation_5094.xlsx\",\"UniqueFileName\":\"S39143520180223.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+BordereauProcess.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S39143520180223.xlsx\",\"Filesize\":107657,\"Path\":null,\"size\":107657,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);

			if(isVisible(BordereauProcess.EnrichedValueTxt)==true){
				verifyMustExists(BordereauProcess.EnrichedValueTxt,"Enriched Value textbox");
				sendKeys(BordereauProcess.EnrichedValueTxt, "31/01/2017", "Enriched Value textbox");
				verifyMustExists(BordereauProcess.continuebtx,"Continue button");
				click(BordereauProcess.continuebtx, "Continue button");
				sleep(2000);
				verifyMustExists(BordereauProcess.EnrichedValueTxt,"Enriched Value textbox");
				sendKeys(BordereauProcess.EnrichedValueTxt, "10", "Enriched Value textbox");
				sleep(2000);
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
				goBack();
				BordereauProcess.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}		
		
	}
	//----------------------------------------------------Credit control Test case----------------

	public void CreditControl_3671() throws Exception{
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
			sheet3671Path = fpath+"\\src\\test\\resources\\testdata\\January 2016 Single Risk_TC_3671.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3671Path);	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S77668020181124.xlsx";
		int size = 15876;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String BordreauID = "e4ac8a79-65a1-43ca-8d71-8fc2dc53dccd";
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			click(BordereauProcess.ReviewBtn,"Review button");
			sleep(1000);
			SubmitRecordAssesmentBtn();
			sleep(1000);
			ForApprovalBtn();
			sleep(1000);
			ApprdBtn();
			sleep(1000);
			policy.navigateToReportingChannelsTab();
			sleep(1000);
			policy.addReportingChannelForpremium();
			sleep(1000);
			BordereauProcess.SubmitBordereauxWithYesnoButtons(MonthDate);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3671PathSecnd = fpath+"\\src\\test\\resources\\testdata\\January 2016 Single Premium_TC_3671_Second.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3671PathSecnd);	
			
			String Ufname1 = "S90283720181008.xlsx";
			int size1 = 15797;
	        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
	        String BordreauID1 = "184c00fd-520b-4931-92f5-74fa1c376f83";
	        String ID1 = extractIDFromResponseinsideContract(response1); 
	        String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 1 , "2", 2018);
	        addAsDraft(payload2,DraftUrl);
			
			//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2016 Single Premium_TC_3671_Second.xlsx\",\"UniqueFileName\":\"S99553320180428.xlsx\",\"BordereauFormatId\":\"184c00fd-520b-4931-92f5-74fa1c376f83\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44805120171114.xlsx\",\"Filesize\":15797,\"Path\":null,\"size\":15797,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			
			//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				click(BordereauProcess.ReviewBtn,"Review button");
				sleep(1000);
				SubmitRecordAssesmentBtn();
				sleep(1000);
				ForApprovalBtnSncdRow();
				sleep(1000);
				ApprdBtn();
				sleep(5000);
				BordereauProcess.openDATALink();
				sleep(5000);
				NavigationCreditContrlTab();
				sleep(5000); 
				SelectDrpValOfFolder();		

			}else{
				Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
				BordereauProcess.deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			BordereauProcess.deleteBorderEAUX();
		}		
	}


	//--------------------------------------------------------------------------------------------------------------------------------------------//	
	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public void EndorsmentFirstContinue(String val1, String val2){
		verifyMustExists(NewandRenewalEntriesLocator,"New and renewal entries exists screen");
		NewandRenewalEntriesErrorScreen = getTextFrom(NewandRenewalEntriesLocator);
		Report.LogInfo("DrpVal", NewandRenewalEntriesErrorScreen, "PASS");
		SelectDropDownValue(RenewalDrp,Endorsment1);
		Report.LogInfo("EndorsementValueFirst","FirstEndorsementVlueSelectd", "PASS");
		waitForElementToAppear(RiskRefFirst,3);
		verifyMustExists(RiskRefFirst,"Risk Referance");
		sendKeys(RiskRefFirst,val1,"Risk Referance");
		Report.LogInfo("FirstRiskRefChangd","FirstRiskRefrnceVlueChngd", "PASS");
		
		SelectDropDownValue(NewDrp,Endorsment2);
		Report.LogInfo("EndorsementValueSecond","SecondEndorsementVlueSelectd", "PASS");
		waitForElementToAppear(RiskRefSecond,3);
		verifyMustExists(RiskRefSecond,"Risk Referance");
		sendKeys(RiskRefSecond,val2,"Risk Referance");
		Report.LogInfo("SecndRiskRefChangd","SecndRiskRefrnceVlueChngd", "PASS");

		verifyMustExists(ContinueBtn,"Continue button");
		click(ContinueBtn,"Continue button");
		sleep(2000);
	}
	
	public void EndorsmentContinueSecond(){
		//waitForElementToAppear(EndrsmntDrp,3);
		if(isVisible(EndrsmntDrp)==true){
			SelectDropDownValue(EndrsmntDrp,NewVal);

			sleep(1500);	
			SelectDropDownValue(EndrsmntDrp2,NewVal2);
			sleep(1500);
			SelectDropDownValue(EndrsmntDrp3,NewVal2);
			
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	public void EndorsmentContinueSecond_3541(){
		verifyMustExists(EndorsementNothaveEntriesLocator,"New and renewal entries exists screen");
		EndorsementNothaveEntries = getTextFrom(EndorsementNothaveEntriesLocator);
		Report.LogInfo("DrpVal", EndorsementNothaveEntries, "PASS");
		if(isVisible(EndrsmntDrp)==true){
			SelectDropDownValue(EndrsmntDrp,NewVal);
			Report.LogInfo("EndosementFirstvlue","EndosementFirstvlueEntry", "PASS");
			sleep(1500);	
			SelectDropDownValue(EndrsmntDrp2,NewVal2);
			Report.LogInfo("Endosementsecndvlue","EndosementsecndvlueEntry", "PASS");
			sleep(1500);
		//	SelectDropDownValue(EndrsmntDrp3,NewVal2);
			
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	
	public void ChangeStasCanToNew() {
		
		verifyMustExists(CancellationNotHavingEntriesLocator,"New and renewal entries exists screen");
		CancellationNotHavingEntries = getTextFrom(CancellationNotHavingEntriesLocator);
		Report.LogInfo("DrpVal", CancellationNotHavingEntries, "PASS");
		if(isVisible(CancellatiotoNew)==true){
			SelectDropDownValue(CancellatiotoNew,NewVal3);
			Report.LogInfo("CancellatioToNew","Cancelation value chnged to new", "PASS");

			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ReinstatementToCancl(){
		
		verifyMustExists(RestatementerrorLocator,"New and renewal entries exists screen");
		Restatementerror = getTextFrom(RestatementerrorLocator);
		Report.LogInfo("DrpVal", Restatementerror, "PASS");
		if(isVisible(ReinstatmentDrp)==true){
			SelectDropDownValue(ReinstatmentDrp,Cancellation1);

			sleep(1000);
			//SelectDropDownValue(ReinstatmentDrp2,Cancellation2);

			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	
	public void ReinstatementToCancl1(){
		
		if(isVisible(ReinstatmentDrp)==true){
			SelectDropDownValue(ReinstatmentDrp,Cancellation1);
			
			sleep(1000);
			SelectDropDownValue(ReinstatmentDrp2,Cancellation2);
			sleep(1000);
			//if(isVisible(ReinstatmentDrp3)==true){
		//	SelectDropDownValue(ReinstatmentDrp3,Cancellation3);
		//	}
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ReinstatementToCancl11() {

		if (isVisible(ReinstatmentDrp) == true) {
			SelectDropDownValue(ReinstatmentDrp, Cancellation1);

			sleep(1000);
			// if(isVisible(ReinstatmentDrp3)==true){
			// SelectDropDownValue(ReinstatmentDrp3,Cancellation3);
			// }
			waitForElementToAppear(ContinueBtn, 3);
			verifyMustExists(ContinueBtn, "Continue button");
			click(ContinueBtn, "Continue button");
			sleep(2000);
		} else {
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void EnrichedValChange(){
		verifyMustExists(InvalidIntegerIdentifiedLocator,"New and renewal entries exists screen");
		InvalidIntegerIdentified = getTextFrom(InvalidIntegerIdentifiedLocator);
		Report.LogInfo("DrpVal", InvalidIntegerIdentified, "PASS");
		if(isVisible(EnrichedValTxt)==true){
			verifyMustExists(EnrichedValTxt,"Enriched value textbox");
			sendKeys(EnrichedValTxt,"10","Enriched Val Txt");
			Report.LogInfo("InvalidIntegrValue","Invalid Integr Vlaue Changed", "PASS");
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void TideValChange(){
		refreshPage();
		verifyMustExists(LocationSprinklersLocator,"Location Sprinklers not located");
		LocationSprinklers = getTextFrom(LocationSprinklersLocator);
		Report.LogInfo("DrpVal", LocationSprinklers, "PASS");
		
		if(isVisible(TideValDrp)==true){
			verifyMustExists(TideValDrp,"Tide value dropdown");
			click(TideValDrp,"Tide value dropdown");
			Report.LogInfo("TideValueDrpDown","Tide Value Drop Down Clicked", "PASS");
			sleep(2000);
			waitForElementToAppear(TideDrpVal,3);
			if(isVisible(TideDrpVal)==true){
				verifyMustExists(TideDrpVal,"Tide Drp Val");
				click(TideDrpVal,"Tide Drp Val");	
				Report.LogInfo("TideDrpDownValue","Tide Drop Down Value Clicked", "PASS");
				sleep(1000);
				waitForElementToAppear(ContinueBtnSave,3);
				verifyMustExists(ContinueBtnSave,"Continue button");
				click(ContinueBtnSave,"Continue button");
				sleep(2000);
			}else{
				Report.LogInfo("DrpVal", "Expected dropdown value not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void TideValChangeToUnitedKingdm(){
		verifyMustExists(InsuredCountryErrorScreenLocator,"New and renewal entries exists screen");
		InsuredCountryErrorScree = getTextFrom(InsuredCountryErrorScreenLocator);
		
		if(isVisible(TideValDrp)==true){
			SelectDropDownValue1(TideValDrp,TideDrpValUK);
			Report.LogInfo("UK1Selected","United Kingdom 1 Selected", "PASS");
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);			

			if(isVisible(TideValDrp)==true){
				sleep(2000);
				SelectDropDownValue1(TideValDrp,TideDrpValUK);
				Report.LogInfo("UK2Selected","United Kingdom 2 Selected", "PASS");
				waitForElementToAppear(ContinueBtnSave,3);
				verifyMustExists(ContinueBtnSave,"Continue button");
				click(ContinueBtnSave,"Continue button");
				sleep(2000);
							}else{
				Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void TideValUKToRMS(){
		//waitForElementToAppear(TideValDrp,3);
		if(isVisible(TideValDrp1)==true){
			verifyMustExists(TideValDrp1,"Tide value dropdown");
			click(TideValDrp1,"Tide value dropdown");
			sleep(1000);
			waitForElementToAppear(TideDrpValRMS,3);
			if(isVisible(TideDrpValRMS)==true){
				verifyMustExists(TideDrpValRMS,"Tide Drp Val");
				click(TideDrpValRMS,"Tide Drp Val");		
				waitForElementToAppear(ContinueBtnSave,3);
				verifyMustExists(ContinueBtnSave,"Continue button");
				click(ContinueBtnSave,"Continue button");
				sleep(2000);
			}else{
				Report.LogInfo("DrpVal", "Expected dropdown value not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}


	public void ChangGrossPremTxtVal(){
		//waitForElementToAppear(TideValDrp,3);
		if(isVisible(GrossPremTxt)==true){
			verifyMustExists(GrossPremTxt,"Tide value dropdown");
			sendKeys(GrossPremTxt,"6576","Gross Prem Txt");	
			waitForElementToAppear(ContinueBtn,3);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void SubmitRecordAssesmentBtn(){
		if(isVisible(SbmtRcdAssmntBtn)==true){
			verifyMustExists(SbmtRcdAssmntBtn," submit records for assignment button");
			click(SbmtRcdAssmntBtn," submit records for assignment button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ForApprovalBtn(){
		if(isVisible(ForApprvl)==true){
			verifyMustExists(ForApprvl," For Approval button");
			click(ForApprvl," For Approval button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ForApprovalBtnSncdRow(){
		if(isVisible(ForApprvlScndRw)==true){
			verifyMustExists(ForApprvlScndRw," For Approval button");
			click(ForApprvlScndRw," For Approval button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void ApprdBtn(){
		if(isVisible(ApprvdBtn)==true){
			verifyMustExists(ApprvdBtn," For Approval button");
			click(ApprvdBtn," For Approval button");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}

	public void NavigationCreditContrlTab(){
		if(isVisible(CreditCntrlCTab)==true){
			verifyMustExists(CreditCntrlCTab," Credit control tab");
			click(CreditCntrlCTab," Credit control tab");
			sleep(1000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	public  String ActualValue1;
	public  String ActualValue2;
	public  String ActualValue3;
	public  String ActualValue4;
	public  String ActualValue5;
	public  String ActualValue6;
	public  String ActualValue7;
	public  String ActualValue8;

	public void SelectDrpValOfFolder(){

		String paymntStFirstRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Fully Paid']";
		String paymntStScndRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Unpaid']";
		String paymntStthirdRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Partially Paid']";
		String paymntStFourthRw = "@xpath=.//*[@data-field='Payment_Status']//following::td[text()='Over  Paid']";
		
		 ActualValue1 = getTextFrom(paymntStFirstRw,"Validate 1 row");
		 ActualValue2 = getTextFrom(paymntStScndRw,"Validate 2 row");
		 ActualValue3 = getTextFrom(paymntStthirdRw,"Validate 3 row");
		 ActualValue4 = getTextFrom(paymntStFourthRw,"Validate 4 row");
		 


		if(isVisible(paymntStFirstRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(paymntStScndRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(paymntStthirdRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(paymntStFourthRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		String GRPFirstRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[1]//td[5][text()='1,000.00']";
		String GRPScndRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[2]//td[5][text()='1,000.00']";
		String GRPthirdRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[3]//td[5][text()='1,000.00']";
		String GRPFourthRw = "@xpath=.//*[@data-field='Gross_Premium_Written']//following::tr[4]//td[5][text()='1,000.00']";
		
		ActualValue5 = getTextFrom(GRPFirstRw,"Validate 1 Row");
		ActualValue6 = getTextFrom(GRPScndRw,"Validate 2 Row");
		ActualValue7 = getTextFrom(GRPthirdRw,"Validate 3 Row");
		ActualValue8 = getTextFrom(GRPFourthRw,"Validate 4 Row");
		
		if(isVisible(GRPFirstRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPScndRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPthirdRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

		if(isVisible(GRPFourthRw)==true){
			Report.LogInfo("RecordCheck", "Record Match.", "PASS");
		}else{
			Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
		}

	}
	
	public void EnrichedValChange1(String value){
		//waitForElementToAppear(EnrichedValTxt,3);
		if(isVisible(EnrichedValTxt)==true){		
			verifyMustExists(EnrichedValTxt,"Enriched value textbox");
			sendKeys(EnrichedValTxt,value,"Enriched Val Txt");
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	
	String ReferenceDatafield= "@xpath=//h2[contains(.,'Location Sprinklers (Y/N) reference data translation required')]";
	public void TideValChange1(){
		if(isVisible(TideValDrp)==true){
			verifyMustExists(ReferenceDatafield,"Invalid Integer values identified page displayed");
			ReferenceData =  getTextFrom(ReferenceDatafield);
			Report.LogInfo("Invalid Integer values identified page displayed", ReferenceData, "PASS");
			SelectDropDownValue1(TideValDrp,TideDrpVal);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}


	public void TideValChangeToUnitedKingdm1(String value ){
		if(isVisible(TideValDrp)==true){
			SelectDropDownValue1(TideValDrp,value);
			waitForElementToAppear(ContinueBtnSave,3);
			verifyMustExists(ContinueBtnSave,"Continue button");
			click(ContinueBtnSave,"Continue button");
			sleep(2000);			
		}else{
			Report.LogInfo("ErroScreenCheck", "Expected error screen not displayed.", "FAIL");
		}
	}
	


}