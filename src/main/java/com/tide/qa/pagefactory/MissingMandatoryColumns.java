package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class MissingMandatoryColumns extends PageBase {

	public String Rowno1;
	public String Rowno2;
	public String errorTitleValidate;
	public String Introtext;
	public String Reprocess;
	public String Warningtext;
	public String DefaultValueScree;
	public String ActualDPVCOriginal;
	public String ActualDPVCOriginal1;
	public String ActualDPVCChanged;
	public String ActualDPVCChanged1;
	public String ActualDPVCRuleName;
	public String ActualDPVCRuleName1;
	public String ActualDPVCOriginal2;
	public String ActualDPVCOriginal3;
	public String ActualDPVCOriginal4;
	public String ActualDPVCOriginal5;
	public String ActualDPVCChanged2;
	public String ActualDPVCChanged3;
	public String ActualDPVCChanged4;
	public String ActualDPVCChanged5;
	public String ActualDPVCRuleName2;
	public String ActualDPVCRuleName3;
	public String ActualDPVCRuleName4;
	public String ActualDPVCRuleName5;
	public String ActualDPVCOriginal6;
	public String ActualDPVCOriginal7;
	public String ActualDPVCChanged6;
	public String ActualDPVCChanged7;
	public String ActualDPVCRuleName6;
	public String ActualDPVCRuleName7;
	
	
	
	public static final String Premiumcurrency ="@xpath=//li[contains(text(),'GBP - British Pound')]";
	public static final String ContinueBtn ="@xpath=//button[@class='btn btn-success p-lr-lg']";
	public static final String SaveandReprocess ="@xpath=//*[@ng-if='saveAndReprocess']";
	public static final String EditQuestinnarie = "@xpath=//*[@ng-click='EditQuestionnaire()']";
	public static final String SpecifyDefaultButton = "@xpath=//button[@ng-click='specifyDefault(dataItem)']";
	public static final String DefaultValueScreen = "@xpath=//h2[contains(.,'Apply Default Value for Buildings Value')]";
	public static final String DefaultValueScreen1 = "@xpath=//h2[contains(.,'Apply Default Value for Limit of Indemnity')]";
	public static final String DefaultValue = "@xpath=//input[@ng-model='dataItem.DefaultValue']";
	public static final String DefaultValueSaveButton = "@xpath=//button[@ng-click-single='save()']";
	public static final String DefaultValueCancelButton = "@xpath=//button[@ng-click='cancel()']";
	public static final String TideFieldFilterIcon = "@xpath=//*[@data-title='Tide Field']//span";
	public static final String TideFieldClearButton = "@xpath=//button[text()='Clear']";
	public static final String SaveBtn ="@xpath=//button[contains(text(),'Save')]";
	public static String sheet6168PathScnd = "";
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQ = new BordereauQuePage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	SchemaPage schema = new SchemaPage();
	Rules rule = new Rules();
	public void TC007MissingMandatoryColumns() throws Exception {
		
		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		ArrayList<String> DataCapture4 = new ArrayList<String>();
		ArrayList<String> DataCapture5 = new ArrayList<String>();
		ArrayList<String> DataCapture6 = new ArrayList<String>();
		ArrayList<String> DataCapture7 = new ArrayList<String>();
		ArrayList<String> DataCapture8 = new ArrayList<String>();
		
	//	policy.CreateContractwithInceptionDate2018();
		
		policy.PolicyNumber = "333919EC";
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);		
		BordereauProcess.openSelectedPolicy();

		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Automation Default currency change Rule";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//			BordereauProcess.SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\MissingMandatory.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet6168PathScnd);
		
		policy.contractId ="8931dfa9-32df-45c9-921a-f5bba432c7bd";		
	 //  policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\"af045e74-8255-4451-99fe-34d112f092c7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
		
	//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String Ufname = "S93533420181108.xlsx";	
		int size = 25691;
		String BordreauID = "6980ca1b-e406-4da0-8e66-d830dfa46904";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        BordereauPage.refreshUploadedFile();
        
        if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
    		Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
    		sleep(2000);
    		String Stories = "Buildings Value";
    		String DefaultValueNo1 = "12345";
    		String stories = "Limit of Indemnity";
    		String DefaultValueNo2 = "12345";
    		
    		String Missingtitle= "@xpath=//*[@class='col-sm-6']//h2[contains(.,'One or more mandatory columns not identified')]";
    		String introtext = "@xpath=//*[@id=\"setLi\"]//span[contains(.,'(Buildings Value)')]";
    		String missingmandatorytext = "@xpath=//*[@class='form-group']//li[contains(.,'No Column or Default Supplied (Limit of Indemnity) – This Tide Field is mandatory, but there is no column or default value has been provided in the Questionnaire. It is likely that the Tide Field has become mandatory after the Questionnaire was completed.')]";
			if(isVisible(Missingtitle)== true) {
				errorTitleValidate = getTextFrom(Missingtitle);
				Introtext = getTextFrom(introtext);
				Warningtext = getTextFrom(missingmandatorytext);
				
				verifyMustExists(EditQuestinnarie,"Edit Questinnarie button");
				click(EditQuestinnarie,"Edit Questinnarie button");
				sleep(2000);
				
				verifyMustExists(QuePage.Step13Btn,"Step 13");
				click(QuePage.Step13Btn,"Step 13");
				sleep(2000);
				rule.applyFilterTideFieldReviewQuestionnaire(Stories);
				
				ProcessForSpecifyDefaultValue(DefaultValueNo1, BordreauID);
				
				waitForElementToAppear(TideFieldFilterIcon, 3);
				verifyMustExists(TideFieldFilterIcon, "Clear Button");
				clickAndWait(TideFieldFilterIcon, "TideFieldFilterIcon");
				waitForElementToAppear(TideFieldClearButton, 3);
				verifyMustExists(TideFieldClearButton, "Clear Button");
				click(TideFieldClearButton, "Clear Button");
				
				
				rule.applyFilterTideFieldReviewQuestionnaire(stories);
				ProcessForSpecifyDefaultValue1(DefaultValueNo2, BordreauID);
				
				verifyMustExists(SaveandReprocess,"Verify Save and Reprocess button");
				Reprocess = getTextFrom(SaveandReprocess);
				if(isEnable(SaveandReprocess)==true)
				{
					Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is Enable", "PASS");
					
				}
				else{
					Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is not Enable", "FAIL");
				}
				click(SaveandReprocess,"Click on Save and Reprocess button");
				sleep(5000);
			}
				
			
			BordereauPage.refreshUploadedFile();
        if(isVisible(BordereauProcess.ReviewBtn)==true)
		{
			AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			
			BordereauPage.openDATALink();
			
			BordereauPage.navigateToDATARiskTab();
			sleep(2000);
			// Row number column
			
			String RowNumber = "@xpath=//*[@data-field='RowNumber']";
			String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='2']";
			String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='3']";
			verifyExists(RowNumber1, "1st value");
			verifyExists(RowNumber2, "2nd value");
			Rowno1 = getTextFrom(RowNumber1);
			Rowno2 = getTextFrom(RowNumber2);
			sleep(2000);
		
			// Risk Issuance Date column
				String RiskIssuanceDate  = "@xpath=//*[@data-field='Risk_Issuance_Date']";
				String RiskIssuanceDate1 = "@xpath=//*[@data-field='Risk_Issuance_Date']//following::tr[1]//td[contains(@ng-click,'Risk_Issuance_Date')][text()='01/01/2018']";
				String RiskIssuanceDate2 = "@xpath=//*[@data-field='Risk_Issuance_Date']//following::tr[2]//td[contains(@ng-click,'Risk_Issuance_Date')][text()='01/01/2018']";
				DataCapture1 =	BordereauPage.RuleDataCapture(RiskIssuanceDate1,"Risk Issuance Date","-","01/01/2018","Default value for Risk Issuance Date field is set in Questionnaire as Contract Inception Date.");
				ActualDPVCOriginal = DataCapture1.get(0);
				ActualDPVCChanged = DataCapture1.get(1);
				ActualDPVCRuleName = DataCapture1.get(2);
				DataCapture2 = BordereauPage.RuleDataCapture(RiskIssuanceDate2,"Risk Issuance Date","-","01/01/2018","Default value for Risk Issuance Date field is set in Questionnaire as Contract Inception Date.");
				ActualDPVCOriginal1 = DataCapture2.get(0);
				ActualDPVCChanged1 = DataCapture2.get(1);
				ActualDPVCRuleName1 = DataCapture2.get(2);
			
				// Buildings Value column
				String BuildingsValue  = "@xpath=//*[@data-field='Buildings_Value']";
				String BuildingsValue1 = "@xpath=//*[@data-field='Buildings_Value']//following::tr[1]//td[contains(@ng-click,'Buildings_Value')][text()='12,345.00']";
				String BuildingsValue2 = "@xpath=//*[@data-field='Buildings_Value']//following::tr[2]//td[contains(@ng-click,'Buildings_Value')][text()='12,345.00']";
				DataCapture3 =	BordereauPage.RuleDataCapture(BuildingsValue1,"Buildings Value","-","12,345.00","Default value for Buildings Value field is set in Questionnaire as 12345.");
				ActualDPVCOriginal2 = DataCapture3.get(0);
				ActualDPVCChanged2 = DataCapture3.get(1);
				ActualDPVCRuleName2 = DataCapture3.get(2);
				DataCapture4 = BordereauPage.RuleDataCapture(BuildingsValue2,"Buildings Value","-","12,345.00","Default value for Buildings Value field is set in Questionnaire as 12345.");
				ActualDPVCOriginal3 = DataCapture4.get(0);
				ActualDPVCChanged3 = DataCapture4.get(1);
				ActualDPVCRuleName3 = DataCapture4.get(2);
			
				// Total Insurable Value column
				String TotalInsurableValue  = "@xpath=//*[@data-field='Total_Insurable_Value']";
				String TotalInsurableValue1 = "@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[1]//td[contains(@ng-click,'Total_Insurable_Value')][text()='12,345.00']";
				String TotalInsurableValue2 = "@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[2]//td[contains(@ng-click,'Total_Insurable_Value')][text()='12,345.00']";
				DataCapture5 =	BordereauPage.RuleDataCapture(TotalInsurableValue1,"Total Insurable Value","-","12,345.00","Default value for Total Insurable Value field is set in Questionnaire as 12345.");
				ActualDPVCOriginal4 = DataCapture5.get(0);
				ActualDPVCChanged4 = DataCapture5.get(1);
				ActualDPVCRuleName4 = DataCapture5.get(2);
				DataCapture6 = BordereauPage.RuleDataCapture(TotalInsurableValue2,"Total Insurable Value","-","12,345.00","Default value for Total Insurable Value field is set in Questionnaire as 12345.");
				ActualDPVCOriginal5 = DataCapture6.get(0);
				ActualDPVCChanged5 = DataCapture6.get(1);
				ActualDPVCRuleName5 = DataCapture6.get(2);
			
			

				// Limit of Indemnity column
				String LimitofIndemnity  = "@xpath=//*[@data-field='Limit_of_Indemnity']";
				String LimitofIndemnity1 = "@xpath=//*[@data-field='Limit_of_Indemnity']//following::tr[1]//td[contains(@ng-click,'Total_Insurable_Value')][text()='12,345.00']";
				String LimitofIndemnity2 = "@xpath=//*[@data-field='Limit_of_Indemnity']//following::tr[2]//td[contains(@ng-click,'Total_Insurable_Value')][text()='12,345.00']";
				DataCapture7 =	BordereauPage.RuleDataCapture(LimitofIndemnity1,"Limit of Indemnity","-","12,345.00","Default value for Limit of Indemnity field is set in Questionnaire as 12345.");
				ActualDPVCOriginal6 = DataCapture7.get(0);
				ActualDPVCChanged6 = DataCapture7.get(1);
				ActualDPVCRuleName6 = DataCapture7.get(2);
				DataCapture8 = BordereauPage.RuleDataCapture(LimitofIndemnity2,"Limit of Indemnity","-","12,345.00","Default value for Limit of Indemnity field is set in Questionnaire as 12345.");
				ActualDPVCOriginal7 = DataCapture8.get(0);
				ActualDPVCChanged7 = DataCapture8.get(1);
				ActualDPVCRuleName7 = DataCapture8.get(2);
			
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		} else {
			Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
			
		}
        }
}
        
        public void ProcessForSpecifyDefaultValue(String DefaultValueNo, String QuestionnaireName1) throws Exception {
    		BordereauQuePage bordereauQue = new BordereauQuePage();
    		waitForElementToAppear(SpecifyDefaultButton, 5);
    		verifyMustExists(SpecifyDefaultButton, "SpecifyDefaultButton");
    		click(SpecifyDefaultButton, "SpecifyDefaultButton");
    		if (isVisible(DefaultValueScreen) == true) {
    			DefaultValueScree =  getTextFrom(DefaultValueScreen);	
    			Report.LogInfo("ValidateExpectedScreen", DefaultValueScree, "PASS");

    			waitForElementToAppear(DefaultValue, 5);
    			verifyMustExists(DefaultValue, "DefaultValue");

    			sendKeys(DefaultValue, DefaultValueNo, "Enter Default Value");
    			waitForElementToAppear(DefaultValueSaveButton, 5);
    			verifyMustExists(DefaultValueSaveButton, "DefaultValueSaveButton");
    			click(DefaultValueSaveButton, "DefaultValueSaveButton");
    			/*bordereauQue.FormatId = ReturnFormatID();
    			waitForElementToAppear(SaveBtn, 5);
    			verifyMustExists(SaveBtn, "BorderQuestionarySaveButton");
    			click(SaveBtn, "BorderQuestionarySaveButton");
    			sleep(5000);*/
    			// BQue.filterBordereauQuestionnaire1(QuestionnaireName1);
    			

    		} else {
    			Report.LogInfo("ValidateExpectedScreen", "Apply Default Value for Number of Stories", "FAIL");
    			click(DefaultValueCancelButton, "click on cancel button");
    			homePage.adminMenu();
    		}
    	}

        public void ProcessForSpecifyDefaultValue1(String DefaultValueNo2, String QuestionnaireName1) throws Exception {
    		BordereauQuePage bordereauQue = new BordereauQuePage();
    		waitForElementToAppear(SpecifyDefaultButton, 5);
    		verifyMustExists(SpecifyDefaultButton, "SpecifyDefaultButton");
    		click(SpecifyDefaultButton, "SpecifyDefaultButton");
    		if (isVisible(DefaultValueScreen1) == true) {
    			DefaultValueScree =  getTextFrom(DefaultValueScreen1);	
    			Report.LogInfo("ValidateExpectedScreen", DefaultValueScree, "PASS");

    			waitForElementToAppear(DefaultValue, 5);
    			verifyMustExists(DefaultValue, "DefaultValue");

    			sendKeys(DefaultValue, DefaultValueNo2, "Enter Default Value");
    			waitForElementToAppear(DefaultValueSaveButton, 5);
    			verifyMustExists(DefaultValueSaveButton, "DefaultValueSaveButton");
    			click(DefaultValueSaveButton, "DefaultValueSaveButton");
    			/*bordereauQue.FormatId = ReturnFormatID();
    			waitForElementToAppear(policy.SaveBtn, 5);
    			verifyMustExists(policy.SaveBtn, "BorderQuestionarySaveButton");
    			click(policy.SaveBtn, "BorderQuestionarySaveButton");
    			sleep(5000);*/
    			// BQue.filterBordereauQuestionnaire1(QuestionnaireName1);

    		} else {
    			Report.LogInfo("ValidateExpectedScreen", "Apply Default Value for Number of Stories", "FAIL");
    			click(DefaultValueCancelButton, "click on cancel button");
    			homePage.adminMenu();
    		}
    	}
       
        
        }
	
		
		
	

	

