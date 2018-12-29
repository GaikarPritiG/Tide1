package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SchedulePage extends PageBase {
	 SchemaPage schema = new SchemaPage();
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	Rules rule = new Rules();
	DatasetReferenceDataPage DR = new DatasetReferenceDataPage();
	
	BProcessingRiskPremiumClaimPage Bprocessing = new BProcessingRiskPremiumClaimPage();
	
	String AdminUsername= "dev.admin@tideapp.co.uk";
	String AdminPassword = "Yb0kMlJ;z8Ho33mO";
	
	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}

	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Broker1 = "Alwen Hough Johnson Ltd - TBC";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	String InceptionDate1 = "01/09/2017";
	String InceptionDate2 = "01/09/2018";
	public static String contractId;
	String QueName = "Risk And Premium format_"+getCurrentDateTimeMS();
	public String Data;
	public String Description;
	public String Dataset;
	public String System;
	public String DatasetWithoutData1;
	
	public static String allSheetsPath = "";
	public static String sheet5185Path = "";
	public static String sheet5188Path = "";
	public static String sheet5085Path = "";
	public static String sheet5190Path = "";
	public static String sheet5303Path = "";
	
	//5085
	public static final String Aust ="@xpath=//*[@id='content']//span/span[1]//span[text()='New South Wales - NSW']";
	public static final String USA ="@xpath=//*[@id='content']//span/span[1]//span[text()='United States']";
	public static final String Data0DD ="@xpath=//*[@id='content']//span/span[2]";
	public static final String ContinueBtn ="@xpath=//button[@ng-click='save()']";
	public static final String CancelBtn ="@xpath=//button[@ng-click='cancel()']";
	//TC5122
		 public static final String DataField ="@xpath=//th[@data-title='Data']";
		 public static final String DescriptionField ="@xpath=//th[@data-title='Description']";
		 public static final String DatasetField ="@xpath=//th[@data-title='Dataset']";
		 public static final String SystemField ="@xpath=//th[@data-title='System']";
		 public static final String SystemFieldasIcon ="@xpath=//*[@data-field='System']//*[@class='k-icon k-i-sort-asc-sm']";
		 public static final String DataValueFilter ="@xpath=//th[@data-title='Data']//a//span";
		 public static final String DescriptionValueFilter ="@xpath=//th[@data-title='Description']//a//span";
		 public static final String DatasetValueFilter ="@xpath=//th[@data-title='Dataset']//a//span";
		 public static final String SystemValueFilter ="@xpath=//th[@data-title='System']//a//span";
		 public static final String SystemColumnData="@xpath=//tr[1]//td[text()='No']";
		 public static final String DescriptionColumnData="@xpath=//tbody[@role='rowgroup']//tr[1]//td[2]";
		 public static final String DatasetColumnData="@xpath=//tbody[@role='rowgroup']//tr[1]//td[3]";
		 public static final String SystemColumnWithYesValue="@xpath=//tr[1]//td[text()='Yes']";
		 public static final String SystemColumnWithNoValue="@xpath=//tr[7]//td[text()='No']";
		 public static final String DescriptionWithoutData ="@xpath=.//tbody[@role='rowgroup']//tr[1]//td[2][text()='-']";
		 public static final String DatasetWithoutData ="@xpath=.//tbody[@role='rowgroup']//tr[1]//td[3][text()='-']";
		 public static final String DataFieldAscIcon ="@xpath=//*[@data-field='Name']//*[@class='k-icon k-i-sort-asc-sm']";
			
//==============================================Sprint 7_otherthanpermission==================================//
	
	public static final String PolicyLink = "@xpath=//a[text()='POLICIES']";
	public static final String locationEditBtn = "@xpath=//*[@ng-click='edit()']";
	public static final String CopyFromSection1 = "@xpath=//*[@ng-click='copyFromSection1()']";
	public static final String EuropeExpandarrow  = "@xpath=//*[text()='Europe (Licensed)']/preceding-sibling::span";
	public static final String SwitzerLandArrow  = "@xpath=//*[text()='Switzerland']/preceding-sibling::span";
	
	public static final String Swedencheckbox  = "@xpath=//*[text()='Sweden']/preceding-sibling::input[@type='checkbox']";
	public static final String Switzerlandcheckbox  = "@xpath=//*[text()='Switzerland']/preceding-sibling::input[@type='checkbox']";
	public static final String SwitzerlandArrow  = "@xpath=//td[2]/label[text()='Switzerland']//preceding::td[1]/span[@class='k-icon k-i-expand']";
	//public static final String SwitzerlandArrow  = "@xpath=//*[@id='grid']//tr[52]/td[1]/span[2]";	
	public static final String SwitzerlandCheckbox  = "@xpath=//td[2]/label[text()='Switzerland']//preceding::input[1][@type='checkbox']";
	public static final String ArgaucheckBox  ="@xpath=//*[text()='Aargau']/preceding-sibling::input[@type='checkbox']";
	//public static final String ArgaucheckBox  = "@xpath=//*[@id='grid']/div[2]/table/tbody/tr[144]/td[3]/input";
	public static final String SwitzerlandState  = "@xpath=//label[text()='Aargau']//preceding-sibling::input[@type='checkbox']";
	public static final String SaveBtn  = "@xpath=//*[@ng-click='save()']";
	public static final String ErrorPage  = "@xpath=//h2[contains(.,'Invalid date values identified')]";
	public static final String ErrorWarringlink  = "@xpath=//*[text()='Errors & Warnings']";
	public static final String SkipAllErrorbtn1 = "@xpath=//*[@ng-click='skipAllErrros()']";
	public static final String errorWarringMsg1= "@xpath=//tr//td[text()='Invalid date values identified - Risk Expiry Date']";
	public static final String errorWarringMsg2= "@xpath=//tr//td[text()='Invalid integer values identified - Location Number Of Buildings']";
	public static final String errorWarringMsg3= "@xpath=//tr//td[text()='Location Sprinklers (Y/N) - reference data translation required']";
	public static final String errorWarringMsg4= "@xpath=//tr//td[text()='Premium Currency - reference data translation required']";
	public static final String errorWarringMsg5= "@xpath=//tr//td[text()='Risk Currency - reference data translation required']";
	public static final String errorWarringMsg6= "@xpath=//tr//td[text()='Insured Country - reference data translation required']";
	public static final String errorWarringMsg7= "@xpath=//tr//td[text()='Risk Country - reference data translation required']";
	public static final String errorWarringMsg8= "@xpath=//tr//td[text()='Construction reference data translation required']";
	public static final String CompleteAssignbtn= "@xpath=//button[@ng-click='nextStep()']";
	
	
	public void Update_DataReferenceData_AdminArea_TC5122() throws Exception
	{
		homePage.adminMenu();
		DR.DatasetReferenceDataLink();
		DR.DatasetReferenceDatapage();
		verifyMustExists(DataField,"Verify Data Column");
		Data =  getTextFrom(DataField);	
		Report.LogInfo("Verify Data Column", Data, "PASS");
		verifyMustExists(DescriptionField,"Verify Description Column");
		Description =  getTextFrom(DescriptionField);	
		Report.LogInfo("Verify Description Column", Description, "PASS");
		verifyMustExists(DatasetField,"Verify Dataset Column");
		Dataset =  getTextFrom(DatasetField);	
		Report.LogInfo("Verify Dataset Column", Dataset, "PASS");
		verifyMustExists(SystemField,"Verify System Column");
		System =  getTextFrom(SystemField);	
		Report.LogInfo("Fees_Paid1 1st value", System, "PASS");
		verifyMustExists(DataValueFilter,"Verify Data Column Filter");
		verifyMustExists(DescriptionValueFilter,"Verify Description Column Filter");
		verifyMustExists(DatasetValueFilter,"Verify Dataset Column Filter");
		verifyMustExists(SystemValueFilter,"Verify System Column Filter");
		selectDataFieldAscOrder();
		selectSystemColumnAscOrder();
		verifyMustExists(SystemColumnData,"Verify System Column displayed data'NO'");
		if(isVisible(SystemColumnData)==true)
		{
			Report.LogInfo("ValueCheck", "System Column displayed data'NO'", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "System Column not displayed data as'NO'", "FAIL");
		}
		verifyMustExists(DescriptionColumnData,"Verify Description column displayed data");
		if(isVisible(DescriptionColumnData)==true)
		{
			Report.LogInfo("ValueCheck", "Description Column displayed data", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "Description Column not displayed data", "FAIL");
		}
		verifyMustExists(DatasetColumnData,"Verify Dataset Column displayed data");
		if(isVisible(DatasetColumnData)==true)
		{
			Report.LogInfo("ValueCheck", "Dataset Column displayed data", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "Dataset Column not displayed data", "FAIL");
		}
		String URL = Configuration.url;
		loginPage.tideReadOnlyLogOut();
		sleep(3000);
		loginPage.tideLogin(AdminUsername, AdminPassword);
		homePage.adminMenu();
		DR.DatasetReferenceDataLink();
		sleep(2000);
		if(isVisible(SystemColumnWithYesValue)==true && isVisible(SystemColumnWithNoValue)==true) 
		{
			Report.LogInfo("ValueCheck", "System Column displayed data With 'Yes' & 'No' values", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "System Column not displayed data With 'Yes' & 'No' values", "FAIL");
		}
		if(isVisible(DescriptionWithoutData)==true)
		{
			Report.LogInfo("ValueCheck", "'-' is displayed when Description not present", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "'-' is not displayed when Description not present", "FAIL");
		}
		if(isVisible(DatasetWithoutData)==true)
		{
			DatasetWithoutData1 =  getTextFrom(DatasetWithoutData);	
			Report.LogInfo("Datase tWithout Data", DatasetWithoutData1, "PASS");
			Report.LogInfo("ValueCheck", "'-' is displayed when Dataset not present", "PASS");
		}
		else{
			Report.LogInfo("ValueCheck", "'-' is not displayed when Dataset not present", "FAIL");
		}		
	}
	
	public String RiskSchemaName;
	public int recordsCountRisk;
	public int recordsCountPremium;
	
	public void riskPremiumBordereauType_5185() throws Exception{
			
		
		RiskSchemaName = "RiskAndPremium_"+getCurrentDateTimeMS();
		schema.AddSchema_Risk(RiskSchemaName);
		BordereauQuePage QuePage = new BordereauQuePage();
		QuePage.sheetProcessingriskAndPrimium(RiskSchemaName,QueName);
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
//		policy.PolicyNumber = "396823LP";
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
		verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannel1(policy.TypeDDValue_RiskAndPremium, "30", "24", "Risk And Premium Bordereaux ");
		BordereauProcess.SubmitBordereaux(subSheet);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5185Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_5185_second.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
	//		policy.contractId = "6883d64d-9f43-49d5-b520-209bcb54cfd4";
		File excelFile = new File(sheet5185Path); 
		
		String Ufname = "S98840720181001.xlsx";	
		int size = 24649;
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
		BordereauProcess.refreshUploadedFile();
		if(isVisible(BordereauProcess.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			click(BordereauProcess.ReviewBtn,"Review Button");
			sleep(3000);
			waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
			verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
			click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(BordereauProcess.ForApprovalButton,10);
			verifyMustExists(BordereauProcess.ForApprovalButton,"For Assignment button");
			click(BordereauProcess.ForApprovalButton,"For Assignment button");
			BordereauProcess.clickOnApproveBordBtn();
			BordereauProcess.refreshUploadedFileApprovedStatus();
			waitForElementToAppear(BordereauProcess.Approvedbtn,10);
			verifyMustExists(BordereauProcess.Approvedbtn,"Approve Button");
				if(isVisible(BordereauProcess.Approvedbtn)==true){
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				BordereauProcess.openDATALink();
				BordereauProcess.navigateToDATARiskTab();
				List <WebElement> totatRecordsRisk = findWebElements(BordereauProcess.TotalRowCountAfterFiltered);
				 recordsCountRisk = totatRecordsRisk.size();
				sleep(2000);
				BordereauProcess.navigateToDATAPremiumTab();
				List <WebElement> totatRecordsRremiunm = findWebElements(BordereauProcess.TotalRowCountAfterFiltered);
				 recordsCountPremium = totatRecordsRremiunm.size();
				sleep(1000);
					if(recordsCountRisk==recordsCountPremium)
					{
						Report.LogInfo("CheckTotalCount", "Risk and Premium total count equal", "PASS");
					}else{
					Report.LogInfo("CheckTotalCount", "Risk and Premium total count not equal", "FAIL");
					}
					
				}else{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
				}	
			}
			else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
			}	
		}
		else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}		
	}	
	
	public String ActualGrossPremium1Row;
	public String ActualGrossPremium2Row;
	public String ActualGrossPremium3Row;
	public String ActualGrossPremium4Row;
	public String ActualGrossPremium5Row;
	public String ActualGrossPremium6Row;
	public String NetPremium1;
	public String NetPremium2;
	public String NetPremium3;
	public String NetPremium4;
	public String NetPremium5;
	public String NetPremium6;
	
	public void coreFinancialRevisedCalculation_5188() throws Exception{
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		 policy.CreateContractwithInceptionDate2018();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.addSection2("2","0","Property D&F (US binder)","GBP - Pound Sterling","10","10","10","Low");
			policy.navigateToSection2Tab();
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection("1E - OVERSEAS LEG");
			Report.LogInfo("StepCheck", "Step 3,4 completed", "PASS"); 
			scrollUp();
			policy.navigationOnBordereauxTab();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5188Path = fpath+"\\src\\test\\resources\\testdata\\CoreFinancial Calculation_TC_5188.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet5188Path);  
			
			String Ufname = "S69273520181001.xlsx";	
			int size = 113582;
			String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
			String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	       
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"CoreFinancial Calculation_TC_5188.xlsx\",\"UniqueFileName\":\"S10419520180507.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10419520180507.xlsx\",\"Filesize\":113582,\"Path\":null,\"size\":113582,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
				BordereauProcess.openDATALink();
				BordereauProcess.navigateToDATARiskTab();
				//Gross Premium 
				String GrossPremium="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium2Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium3Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium4Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium5Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[5]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				String GrossPremium6Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[6]//td[contains(@ng-click,'Gross_Premium')][2][text()='10.00']";
				waitForElementToAppear(GrossPremium,5);
				mouseOverAction(GrossPremium);
				verifyMustExists(GrossPremium,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
				ActualGrossPremium1Row =  getTextFrom(GrossPremium1Row);	
				verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
				ActualGrossPremium2Row =  getTextFrom(GrossPremium2Row);	
				verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
				ActualGrossPremium3Row =  getTextFrom(GrossPremium3Row);	
				verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
				ActualGrossPremium4Row =  getTextFrom(GrossPremium4Row);	
				verifyExists(GrossPremium5Row,"Gross Premium 5 Value");
				ActualGrossPremium5Row =  getTextFrom(GrossPremium5Row);	
				verifyExists(GrossPremium6Row,"Gross Premium 6 Value");
				ActualGrossPremium6Row =  getTextFrom(GrossPremium6Row);	
				//NetPremium
				String NetPremium="@xpath=//*[@data-field='Net_Premium']";
				String NetPreium1Row="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='114.50']";
				String NetPreium2Row="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='114.50']";
				String NetPreium3Row="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='114.50']";
				String NetPreium4Row="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='-10.00']";
				String NetPreium5Row="@xpath=//*[@data-field='Net_Premium']//following::tr[5]//td[contains(@ng-click,'Net_Premium')][text()='-10.00']";
				String NetPreium6Row="@xpath=//*[@data-field='Net_Premium']//following::tr[6]//td[contains(@ng-click,'Net_Premium')][text()='14.50']";
				waitForElementToAppear(NetPremium,5);
				mouseOverAction(NetPremium);
				verifyMustExists(NetPremium,"Net Premium column");
				sleep(2000);
				verifyExists(NetPreium1Row,"Net Premium 1 Value");
				NetPremium1 =  getTextFrom(NetPreium1Row);	
				verifyExists(NetPreium2Row,"Net Premium 2 Value");
				NetPremium2 =  getTextFrom(NetPreium2Row);	
				verifyExists(NetPreium3Row,"Net Premium 3 Value");
				NetPremium3 =  getTextFrom(NetPreium3Row);	
				verifyExists(NetPreium4Row,"Net Premium 4 Value");
				NetPremium4 =  getTextFrom(NetPreium4Row);	
				verifyExists(NetPreium5Row,"Net Premium 5 Value");
				NetPremium5 =  getTextFrom(NetPreium5Row);	
				verifyExists(NetPreium6Row,"Net Premium 6 Value");
				NetPremium6 =  getTextFrom(NetPreium6Row);	
				sleep(2000);
				policy.navigationOnBordereauxTab();
				if(isVisible(BordereauProcess.ReviewBtn)==true){
					Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
					click(BordereauProcess.ReviewBtn,"Review Button");
					sleep(3000);
					waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
					verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
					click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
					if(isVisible(Bprocessing.SectionAssignmentRuleScreen)==true){
						Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");			
						SelectDropDownValue(Bprocessing.BordereauAssignmentSectionDropDwn, Bprocessing.BordereauAssignmentSectionDropDwnOption);
						Bprocessing.SetMapping("Risk Address");
						SelectDropDownValue(Bprocessing.SectionUpperDropDwn, Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.SectionLowerDropDwn, Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.SectionBrentwoodDropDwn, Bprocessing.SectionIdDropDwnOption2);
						SelectDropDownValue(Bprocessing.SectionMainDropDwn, Bprocessing.SectionIdDropDwnOption1);
						SelectDropDownValue(Bprocessing.SectionFrnechDropDwn, Bprocessing.SectionIdDropDwnOption1);
						click(Bprocessing.CompleteAssignmentBtn,"Complete Assignment button");			
						
						SelectDropDownValue(Bprocessing.SectionRiskCodeDwn, Bprocessing.SectionRiskCodeDropoption);
						Bprocessing.SetMapping("Risk Address");
						SelectDropDownValue(Bprocessing.RiskcodeUpperDropDwn,  Bprocessing.SectionIdDropDwnOption1);
						SelectDropDownValue(Bprocessing.RiskcodeLowerDropDwn,  Bprocessing.SectionIdDropDwnOption1);
						SelectDropDownValue(Bprocessing.RiskcodeBrentwoodDropDwn,  Bprocessing.SectionIdDropDwnOption1);
						SelectDropDownValue(Bprocessing.RiskcodeMainDropDwn,  Bprocessing.SectionIdDropDwnOption1);
						SelectDropDownValue(Bprocessing.RiskcodeFrnechDropDwn,  Bprocessing.SectionIdDropDwnOption1);
						click(Bprocessing.CompleteAssignmentBtn,"Complete Assignment button");	
						sleep(3000);
						click(BordereauProcess.ForApprovalButton,"For Approval button");
						BordereauProcess.clickOnApproveBordBtn();
						BordereauProcess.refreshUploadedFileApprovedStatus();
						
						waitForElementToAppear(BordereauProcess.Approvedbtn,10);
						verifyMustExists(BordereauProcess.Approvedbtn,"Approved Button");
						if(isVisible(BordereauProcess.Approvedbtn)==true){
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
							BordereauProcess.openDATALink();
							BordereauProcess.navigateToDATARiskTab();
							//GrossPremium
							waitForElementToAppear(GrossPremium,5);
							mouseOverAction(GrossPremium);
							verifyMustExists(GrossPremium,"Gross Premium Including Tax column");
							sleep(2000);
							verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
							verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
							verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
							verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
							verifyExists(GrossPremium5Row,"Gross Premium 5 Value");
							verifyExists(GrossPremium6Row,"Gross Premium 6 Value");
							//NetPremium
							waitForElementToAppear(NetPremium,5);
							mouseOverAction(NetPremium);
							verifyMustExists(NetPremium,"Net Premium column");
							sleep(2000);
							verifyExists(NetPreium1Row,"Net Premium 1 Value");
							verifyExists(NetPreium2Row,"Net Premium 2 Value");
							verifyExists(NetPreium3Row,"Net Premium 3 Value");
							verifyExists(NetPreium4Row,"Net Premium 4 Value");
							verifyExists(NetPreium5Row,"Net Premium 5 Value");
							verifyExists(NetPreium6Row,"Net Premium 6 Value");
							sleep(2000);
							policy.navigationOnBordereauxTab();
							BordereauProcess.navigateToApprovedTab();
							waitForElementToAppear(BordereauProcess.ApprovedButton,5);
							click(BordereauProcess.ApprovedButton,"Approved button");
							waitForElementToAppear(BordereauProcess.UnApprvBdrBtn,5);
							click(BordereauProcess.UnApprvBdrBtn,"UnApproved button");
							//BordereauProcess.refreshUploadedFileForApprovalStatus();
							policy.navigationOnBordereauxTab();
							click(BordereauProcess.ForApprovalButton,"For Approval button");
							waitForElementToAppear(Bprocessing.RejectBtn,5);
							click(Bprocessing.RejectBtn,"Reject button");
							
							waitForElementToAppear(Bprocessing.RejectYesBtn,5);
							click(Bprocessing.RejectYesBtn,"Yes button");
							sleep(3000);
							if(isVisible(BordereauProcess.ReviewBtn)==true){
								Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
								BordereauProcess.openDATALink();
								BordereauProcess.navigateToDATARiskTab();
								//GrossPremium
								waitForElementToAppear(GrossPremium,5);
								mouseOverAction(GrossPremium);
								verifyMustExists(GrossPremium,"Gross Premium Including Tax column");
								sleep(2000);
								verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
								verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
								verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
								verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
								verifyExists(GrossPremium5Row,"Gross Premium 5 Value");
								verifyExists(GrossPremium6Row,"Gross Premium 6 Value");
								//NetPremium
								waitForElementToAppear(NetPremium,5);
								mouseOverAction(NetPremium);
								verifyMustExists(NetPremium,"Net Premium column");
								sleep(2000);
								verifyExists(NetPreium1Row,"Net Premium 1 Value");
								verifyExists(NetPreium2Row,"Net Premium 2 Value");
								verifyExists(NetPreium3Row,"Net Premium 3 Value");
								verifyExists(NetPreium4Row,"Net Premium 4 Value");
								verifyExists(NetPreium5Row,"Net Premium 5 Value");
								verifyExists(NetPreium6Row,"Net Premium 6 Value");
								}else{
									Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
								}
							}else{
								Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
							}
						}else{
							Report.LogInfo("validateexpectedScreen", "section assignment screen not Displayed", "FAIL");
						}
					}else{
						Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
					}
			}else{
				Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
				}
		}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}	
	}
	public int AcualRiskState;
	public int AcualRiskCountry;
	public int AcualInsuredState;
	public int AcualInsuredCountry;
	
	
	public void locationBreaches_5085() throws Exception{
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.navigateToSectionTab1();	
			policy.navigateLocationTab();
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(locationEditBtn,5);
			click(locationEditBtn,"location Edit option");
			waitForElementToAppear(EuropeExpandarrow,5);
			click(EuropeExpandarrow,"Europe Expand option");
			sleep(3000);
			waitForElementToAppear(Swedencheckbox,5);
			click(Swedencheckbox,"sweden check box");
			
			verifyMustExists(SwitzerLandArrow,"Switzerland outer Arrow" );
			click(SwitzerLandArrow,"switzerland outer Arrow");
			
			verifyMustExists(SwitzerlandArrow,"Switzerland inner Arrow" );
			click(SwitzerlandArrow,"switzerland inner Arrow");
			sleep(1000);
			
			verifyMustExists(SwitzerlandCheckbox,"Switzerland inner checkbox" );
			click(SwitzerlandCheckbox,"switzerland inner checkbox");
			sleep(1000);
			verifyMustExists(ArgaucheckBox,"Argau check box" );
			click(ArgaucheckBox,"Argau check box");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			sleep(2000);
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				waitForElementToAppear(policy.SaveBtn3,5);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(5000);
			}

			scrollUp();
			sleep(2000);
			
	
			policy.navigationOnBordereauxTab();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5085Path = fpath+"\\src\\test\\resources\\testdata\\test locations1_TC_5085.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet5085Path);  
			
			String Ufname = "S39441920180507.xlsx";	
			int size = 18463;
			String BordreauID = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
			String response = uploadFileinContract(ReqUrl,excelFile1,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	       BordereauProcess.refreshUploadedFile();			
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
				click(BordereauProcess.ReviewBtn,"Review Button");
				sleep(3000);
				waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
				verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				BordereauProcess.refreshUploadedFileForApprovalStatus();
				BordereauProcess.clickOnForApprovalBtn();
				//click(BordereauProcess.ForApprovalButton,"ForApproval button");
				BordereauProcess.clickOnApproveBordBtn();
				BordereauProcess.refreshUploadedFileApprovedStatus();
				waitForElementToAppear(BordereauProcess.Approvedbtn,10);
				verifyMustExists(BordereauProcess.Approvedbtn,"Approve Button");
				if(isVisible(BordereauProcess.Approvedbtn)==true){
					Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
					policy.navigateRulesTab();
					policy.navigateBreachesTab();
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
					sleep(2000);
						if(isVisible(policy.RulesRisksStateDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Risks Located State option  displayed", "PASS");
							click(policy.RulesRisksStateDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							AcualRiskState = list.size();
							if(AcualRiskState ==2)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualRiskState,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualRiskState,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Risks Located State option not displayed", "FAIL");
						}
					sleep(2000);;
					refreshPage();
					sleep(2000);
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredStateDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Insured Domiciled State option  displayed", "PASS");
							click(policy.RulesInsuredStateDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							AcualInsuredState = list.size();
							if(AcualInsuredState ==2)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualInsuredState,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualInsuredState,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Insured Domiciled State option not displayed", "FAIL");
						}
						
						
					sleep(2000);
					refreshPage();
					sleep(2000);
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
					sleep(2000);
						if(isVisible(policy.RulesRisksCountryDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Risk Located country option  displayed", "PASS");
							click(policy.RulesRisksCountryDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							AcualRiskCountry = list.size();
							if(AcualRiskCountry ==4)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualRiskCountry,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualRiskCountry,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Risk Located country option not displayed", "FAIL");
						}
					sleep(2000);
					refreshPage();
					sleep(2000);
					waitForElementToAppear(policy.RulesDD,3);
					verifyMustExists(policy.RulesDD,"Rules Drop Down");
					click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredCountryDDValue)==true){
							Report.LogInfo("validateExpectedoption", "Insured Domiciled country option  displayed", "PASS");
							click(policy.RulesInsuredCountryDDValue,"Rule Drop Down value");
							sleep(2000);
							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
							AcualInsuredCountry = list.size();
							if(AcualInsuredCountry ==4)
							{
								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualInsuredCountry,"PASS");
							}else{
								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualInsuredCountry,"FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("validateExpectedoption", "Insured Domiciled country option not displayed", "FAIL");
						}
					sleep(2000);
				}else{
					Report.LogInfo("validateApprovedbutton", "Approved Status Button not Displayed", "FAIL");
				}
			}else{
				Report.LogInfo("validateReviewbutton", "Review Status Button not Displayed", "FAIL");
			}	
		}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}}
			/*}else{
					Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
				}
		}else{
					Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
				}
	}*/
	
	public String ActualErrormessage1;
	public String ActualErrormessage2;
	public String ActualErrormessage3;
	public String ActualErrormessage4;	
	public String ActualErrormessage5;
	public String ActualErrormessage6;
	public String ActualErrormessage7;
	public void BordereauSummaryErrorsAndWarnings_5190() throws Exception{
		
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String subSheet = "Automation Risk Format 1";
		homePage.adminMenu();
		QuePage.bordereauQueLink();
		QuePage.bordereauQuePage();
		QuePage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(QuePage.EditBtn,5);
		verifyMustExists(QuePage.EditBtn,"Edit button");
		click(QuePage.EditBtn,"Edit button");
		QuePage.nextStapeClick();
		QuePage.FormatId = ReturnFormatID();
		
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet5190Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5190.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile = new File(sheet5190Path);  
				
				String Ufname = "S42188420181001.xlsx";	
				int size = 17887;
				String BordreauID = "5cca2e44-2a28-4cdf-ae49-198cb434b638";
		        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
		        String ID = extractIDFromResponseinsideContract(response); 
		        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 2 , "1", 2018);
		        addAsDraft(payload,DraftUrl);
		       
				//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5190.xlsx\",\"UniqueFileName\":\"S80854720180522.xlsx\",\"BordereauFormatId\":\"5cca2e44-2a28-4cdf-ae49-198cb434b638\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S80854720180522.xlsx\",\"Filesize\":17887,\"Path\":null,\"size\":17887,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				BordereauProcess.refreshUploadedFile();
				if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
				{
					Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error", "PASS");
					if(isVisible(ErrorPage)==true){
						verifyMustExists(ErrorPage,"Invalid date values identified error page");
						waitForElementToAppear(SkipAllErrorbtn1,10);
						verifyMustExists(SkipAllErrorbtn1,"Skip All Error");
						click(SkipAllErrorbtn1,"Skip All Error");
						sleep(2000);
						waitForElementToAppear(ErrorWarringlink,5);
						verifyMustExists(ErrorWarringlink,"Error Warring Tab");
						click(ErrorWarringlink,"Error Warring Tab");
						waitForElementToAppear(errorWarringMsg1,5);
						verifyExists(errorWarringMsg1,"Error and Warning message 1");
						verifyExists(errorWarringMsg2,"Error and Warning message 2");
						verifyExists(errorWarringMsg3,"Error and Warning message 3");
						verifyExists(errorWarringMsg4,"Error and Warning message 4");
						verifyExists(errorWarringMsg5,"Error and Warning message 5");
						verifyExists(errorWarringMsg6,"Error and Warning message 6");
						verifyExists(errorWarringMsg7,"Error and Warning message 7");
						
						ActualErrormessage1 = getTextFrom(errorWarringMsg1,"Error Message 1");
						ActualErrormessage2 = getTextFrom(errorWarringMsg2,"Error Message 2");
						ActualErrormessage3 = getTextFrom(errorWarringMsg3,"Error Message 3");
						ActualErrormessage4 = getTextFrom(errorWarringMsg4,"Error Message 4");
						ActualErrormessage5 = getTextFrom(errorWarringMsg5,"Error Message 5");
						ActualErrormessage6 = getTextFrom(errorWarringMsg6,"Error Message 6");
						ActualErrormessage7 = getTextFrom(errorWarringMsg7,"Error Message 7");
						
						sleep(2000);
					}
				}else{
					Report.LogInfo("ReviewErrorStatusValidation", "Review error not Displayed", "FAIL");
				}
			
		}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
		}
	}
	
	
	public void bordereauSummaryErrorsAndWarnings_5303() throws Exception{
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		if(isVisible(BordereauProcess.SignedBtn)== true){
			verifyExists(BordereauProcess.SignedBtn,"Signed Status Button");
			policy.addSection2("2","10","Property D&F (US binder)","GBP","10","10","10","Low");
			Report.LogInfo("StepCheck", "Step 2,3 completed", "PASS");
			policy.navigateToSection2Tab();
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection("1E - OVERSEAS LEG");
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS"); 
			policy.navigateToSectionTab1();
			policy.navigateLocationTab();
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(locationEditBtn,5);
			click(locationEditBtn,"location Edit option");
			sleep(2000);
			waitForElementToAppear(EuropeExpandarrow,5);
			click(EuropeExpandarrow,"Europe Expand option");
			sleep(3000);
			waitForElementToAppear(Swedencheckbox,5);
			click(Swedencheckbox,"sweden check box");
			
			verifyMustExists(SwitzerLandArrow,"Switzerland outer Arrow" );
			click(SwitzerLandArrow,"switzerland outer Arrow");
			
			verifyMustExists(SwitzerlandArrow,"Switzerland inner Arrow" );
			click(SwitzerlandArrow,"switzerland inner Arrow");
			sleep(1000);
			
			verifyMustExists(SwitzerlandCheckbox,"Switzerland inner checkbox" );
			click(SwitzerlandCheckbox,"switzerland inner checkbox");
			sleep(1000);
			verifyMustExists(ArgaucheckBox,"Argau check box" );
			click(ArgaucheckBox,"Argau check box");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			sleep(2000);
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(2000);
				waitForElementToAppear(policy.SaveBtn3,3);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(5000);
			}
			Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
			scrollUp();
			policy.navigateToSectionTab2();
			policy.navigateLocationTab();
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(locationEditBtn,5);
			click(locationEditBtn,"location Edit option");
			sleep(2000);
			verifyMustExists(SwitzerLandArrow,"Switzerland outer Arrow" );
			click(SwitzerLandArrow,"switzerland outer Arrow");
			
			verifyMustExists(SwitzerlandArrow,"Switzerland inner Arrow" );
			click(SwitzerlandArrow,"switzerland inner Arrow");
			sleep(1000);
			
			verifyMustExists(SwitzerlandCheckbox,"Switzerland inner checkbox" );
			click(SwitzerlandCheckbox,"switzerland inner checkbox");
			sleep(1000);
			verifyMustExists(ArgaucheckBox,"Argau check box" );
			click(ArgaucheckBox,"Argau check box");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
			sleep(3000);
			
			/*verifyMustExists(SwitzerlandArrow,"Switzerland arrow" );
			click(SwitzerlandArrow,"switzerland arrow");
			sleep(1000);
			verifyMustExists(ArgaucheckBox,"Switzerland state" );
			click(ArgaucheckBox,"switzerland state");
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");*/
			sleep(2000);
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				waitForElementToAppear(policy.SaveBtn3,5);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(5000);
			}
			scrollUp();
			Report.LogInfo("StepCheck", "Step 13 completed", "PASS");
			waitForElementToAppear(Bprocessing.LocationthreeRefdot,5);
			click(Bprocessing.LocationthreeRefdot,"location Edit dot");
			waitForElementToAppear(CopyFromSection1,5);
			click(CopyFromSection1,"Copy from section 1 option");
			if(isVisible(policy.ConEndrsmntPopUp) == true)
			{
				sleep(1000);
				waitForElementToAppear(policy.SaveBtn3,5);
				verifyExists(policy.SaveBtn3,"Save Button");
				javaScriptclick(policy.SaveBtn3,"Save Button");
				sleep(3000);
			}
			scrollUp();
			sleep(2000);
			policy.navigationOnBordereauxTab();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5303Path = fpath+"\\src\\test\\resources\\testdata\\test locations_TC_5303.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet5303Path);  
			
			String Ufname = "S97288720181001.xlsx";	
			int size = 19524;
			String BordreauID = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	       
	        
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"test locations_TC_5303.xlsx\",\"UniqueFileName\":\"S75180220180507.xlsx\",\"BordereauFormatId\":\"87ff463a-ac88-4a6a-9b80-9e5e892aeb2d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S75180220180507.xlsx\",\"Filesize\":19533,\"Path\":null,\"size\":19533,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}:";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true){
				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
				click(BordereauProcess.ReviewBtn,"Review Button");
				sleep(3000);
				waitForElementToAppear(BordereauProcess.SuRcdAssmnt,10);
				verifyMustExists(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				click(BordereauProcess.SuRcdAssmnt,"Submit recor for Assignment button");
				if(isVisible(Bprocessing.SectionAssignmentRuleScreen)==true){
					Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");			
					SelectDropDownValue(Bprocessing.BordereauAssignmentSectionDropDwn, Bprocessing.SectionAssignmentSection2);
					click(CompleteAssignbtn,"Complete Assignment button");	
					BordereauProcess.clickOnForApprovalBtn();
					BordereauProcess.clickOnApproveBordBtn();
					BordereauProcess.refreshUploadedFileApprovedStatus();
					waitForElementToAppear(BordereauProcess.Approvedbtn,10);
					verifyMustExists(BordereauProcess.Approvedbtn,"Approved Button");
						if(isVisible(BordereauProcess.Approvedbtn)==true){
						Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
						Report.LogInfo("StepCheck", "Step 19 completed", "PASS");
						sleep(20000);
						policy.navigateRulesTab();
						policy.navigateBreachesTab();
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesRisksCountryDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Risks Located Country option  displayed", "PASS");
								click(policy.RulesRisksCountryDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								AcualRiskCountry = list.size();
								if(AcualRiskCountry ==4)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualRiskState,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualRiskState,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Risks Located Country option not displayed", "FAIL");
							}
							sleep(2000);
						refreshPage();
						sleep(2000);
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredCountryDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Insured Domiciled country option  displayed", "PASS");
								click(policy.RulesInsuredCountryDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								 AcualInsuredCountry = list.size();
								if(AcualInsuredCountry ==4)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualInsuredCountry,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualInsuredCountry,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Insured Domiciled country option not displayed", "FAIL");
							}
							sleep(2000);
						refreshPage();
						sleep(2000);
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesRisksStateDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Risk Located State option  displayed", "PASS");
								click(policy.RulesRisksStateDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								 AcualRiskState = list.size();
								if(AcualRiskState ==1)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualRiskState,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualRiskState,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Risk Located State option not displayed", "FAIL");
							}
							sleep(2000);
						refreshPage();
						sleep(2000);
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
						if(isVisible(policy.RulesInsuredStateDDValue)==true){
								Report.LogInfo("validateExpectedoption", "Insured Domiciled State option  displayed", "PASS");
								click(policy.RulesInsuredStateDDValue,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								 AcualInsuredState = list.size();
								if(AcualInsuredState ==1)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualInsuredState,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualInsuredState,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Insured Domiciled State option not displayed", "FAIL");
							}
							sleep(2000);
						}else{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
						}
				}else{
				Report.LogInfo("validateReviewdbutton", "Review Status Button not Displayed", "FAIL");
				}
			}else{
			Report.LogInfo("validateSignedbutton", "Signed Status Button not Displayed", "FAIL");
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//********************Reusable Functions********************************************
	public void selectDataFieldAscOrder()
	{
		verifyMustExists(DataField,"Data field Column");
		click(DataField,"Click on Data field Column");
		sleep(3000);
		verifyMustExists(DataFieldAscIcon,"Row Number Ascending icon");  
		sleep(3000);
	}
	public void selectSystemColumnAscOrder()
	{
		verifyMustExists(SystemField,"System field Column");
		click(SystemField,"Click on System field Column");
		sleep(3000);
		verifyMustExists(SystemFieldasIcon,"Row Number Ascending icon");  
		sleep(3000);
	}
}
