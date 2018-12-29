package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;




public class FinancialMultiFieldSelection extends PageBase {


	public static String sheet6168PathScnd = "";
    public String RN1;
    public String RN2;
    public String RN3;
    public String RN4;
    public String GP1;
    public String GP2;
    public String GP3;
    public String GP4;
    public String NP1;
    public String NP2;
    public String NP3;
    public String NP4;
    public String TIV1;
    public String TIV2;
    public String TIV3;
    public String TIV4;
    public String CM1;
    public String CM2;
    public String CM3;
    public String CM4;
    public String Bk1;
    public String Bk2;
    public String Bk3;
    public String Bk4;
    
    public String ActualDPVCOriginal;
    public String ActualDPVCChanged;
    public String ActualDPVCRuleName;
    public String ActualDPVCOriginal1;
    public String ActualDPVCChanged1;
    public String ActualDPVCRuleName1;
    public String ActualDPVCOriginal2;
    public String ActualDPVCChanged2;
    public String ActualDPVCRuleName2;
    public String ActualDPVCOriginal3;
    public String ActualDPVCChanged3;
    public String ActualDPVCRuleName3;
    
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	SchemaPage schema = new SchemaPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQ = new BordereauQuePage();

	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	
	
	public void TC_4106_FinancialMultiFieldSelection() throws Exception{
		
		
		
		//policy.CreateContractwithInceptionDate2018();
		
		/*policy.PolicyNumber = "798195PE";
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();*/
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Automation Endorsement Effective date is not supplied";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//			BordereauProcess.SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Jan2018_effectivedatenotsupplied.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet6168PathScnd);
	//	policy.contractId="72b537f1-e8cd-4512-9052-9f4279360e34";
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\"af045e74-8255-4451-99fe-34d112f092c7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
		
	//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String Ufname = "S11253920181111.xlsx";	
		int size = 22320;
		String BordreauID = "34ba1e41-d8d7-4ae6-9870-d57e19a93aff";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
        
		BordereauPage.refreshUploadedFile();
		
		if (isVisible(BordereauPage.ReviewBtn) == true) {
			AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			BordereauPage.openDATALink();
		//	BordereauPage.navigateToDATARiskTab();
			BordereauPage.navigateToDATARiskTab();
			sleep(2000);
			// Row number column
			String RowNumber = "@xpath=//*[@data-field='RowNumber']";
			String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='7']";
			String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='8']";
			String RowNumber3 = "@xpath=//*[@data-field='RowNumber']//following::tr[3]//td[contains(@ng-click,'RowNumber')][text()='9']";
			String RowNumber4 = "@xpath=//*[@data-field='RowNumber']//following::tr[4]//td[contains(@ng-click,'RowNumber')][text()='10']";
			verifyExists(RowNumber1, "1st value");
			verifyExists(RowNumber2, "2st value");
			verifyExists(RowNumber3, "3st value");
			verifyExists(RowNumber4, "4st value");
			RN1 = getTextFrom(RowNumber1);
			RN2 = getTextFrom(RowNumber2);
			RN3 = getTextFrom(RowNumber3);
			RN4 = getTextFrom(RowNumber4);
			sleep(2000);
			
			// Gross Premium Column
						String GrossPremium = "@xpath=//*[@data-field='Gross_Premium']";
						String grosspremium1 = "@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='44,510.30']";
						String grosspremium2 = "@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='23,875.30']";
						String grosspremium3 = "@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='23,875.00']";
						String grosspremium4 = "@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='23,900.00']";
						waitForElementToAppear(GrossPremium, 20);
						mouseOverAction(GrossPremium);
						verifyMustExists(GrossPremium, "Gross Premium Column");
						sleep(2000);
						verifyExists(grosspremium1, "1st value");
						verifyExists(grosspremium2, "2nd value");
						verifyExists(grosspremium3, "3st value");
						verifyExists(grosspremium4, "4nd value");
						
						GP1 = getTextFrom(grosspremium1);
						GP2 = getTextFrom(grosspremium2);
						GP3 = getTextFrom(grosspremium3);
						GP4 = getTextFrom(grosspremium4);
						
						// Coverholder Commission Column
						String Coverholdercommissionvalue = "@xpath=//*[@data-field='Coverholder_Commission']";
						String Coverholdercommissionvalue1 = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='27,489.70']";
						String Coverholdercommissionvalue2 = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='12,124.70']";
						String Coverholdercommissionvalue3 = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='12,125.00']";
						String Coverholdercommissionvalue4 = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='12,100.00']";
						waitForElementToAppear(Coverholdercommissionvalue, 20);
						mouseOverAction(Coverholdercommissionvalue);
						verifyMustExists(Coverholdercommissionvalue, "Coverholder Commission Column");
						sleep(2000);
						verifyExists(Coverholdercommissionvalue1, "1st value");
						verifyExists(Coverholdercommissionvalue2, "2nd value");
						verifyExists(Coverholdercommissionvalue3, "3st value");
						verifyExists(Coverholdercommissionvalue4, "4nd value");
						
						CM1 = getTextFrom(Coverholdercommissionvalue1);
						CM2 = getTextFrom(Coverholdercommissionvalue2);
						CM3 = getTextFrom(Coverholdercommissionvalue3);
						CM4 = getTextFrom(Coverholdercommissionvalue4);
						
						
						// Net Premium Column
						String NetPremium = "@xpath=//*[@data-field='Net_Premium']";
						String netpremium1 = "@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='44,510.30']";
						String netpremium2 = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='23,875.30']";
						String netpremium3 = "@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='23,875.00']";
						String netpremium4 = "@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='23,900.00']";
						waitForElementToAppear(NetPremium, 20);
						mouseOverAction(NetPremium);
						verifyMustExists(NetPremium, "Net Premium Column");
						sleep(2000);
						verifyExists(netpremium1, "1st value");
						verifyExists(netpremium2, "2nd value");
						verifyExists(netpremium3, "3st value");
						verifyExists(netpremium4, "4nd value");
						
						NP1 = getTextFrom(netpremium1);
						NP2 = getTextFrom(netpremium2);
						NP3 = getTextFrom(netpremium3);
						NP4 = getTextFrom(netpremium4);
					
						// Brokerage Column
						String Brokerage = "@xpath=//*[@data-field='London_Brokerage']";
						String Brokerage1 = "@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='25,200.00']";
						String Brokerage2 = "@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='12,600.00']";
						String Brokerage3 = "@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='12,600.00']";
						String Brokerage4 = "@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='12,600.00']";
						waitForElementToAppear(Brokerage, 20);
						mouseOverAction(Brokerage);
						verifyMustExists(Brokerage, "Brokerage Column");
						sleep(2000);
						verifyExists(Brokerage1, "1st value");
						verifyExists(Brokerage2, "2nd value");
						verifyExists(Brokerage3, "3st value");
						verifyExists(Brokerage4, "4nd value");
						
						Bk1 = getTextFrom(Brokerage1);
						Bk2 = getTextFrom(Brokerage2);
						Bk3 = getTextFrom(Brokerage3);
						Bk4 = getTextFrom(Brokerage4);
						
						
						// Total Insurable value Column
						String ToalInsurablevalue = "@xpath=//*[@data-field='Total_Insurable_Value']";
						String totalinsurablevalue1 = "@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[1]//td[contains(@ng-click,'Total_Insurable_Value')][text()='111,000.00']";
						String totalinsurablevalue2 = "@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[2]//td[contains(@ng-click,'Total_Insurable_Value')][text()='111,000.00']";
						String totalinsurablevalue3 = "@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[3]//td[contains(@ng-click,'Total_Insurable_Value')][text()='111,000.00']";
						String totalinsurablevalue4 = "@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[4]//td[contains(@ng-click,'Total_Insurable_Value')][text()='111,000.00']";
						waitForElementToAppear(ToalInsurablevalue, 20);
						mouseOverAction(ToalInsurablevalue);
						verifyMustExists(ToalInsurablevalue, "Total Insurable value Column");
						sleep(2000);
						verifyExists(totalinsurablevalue1, "1st value");
						verifyExists(totalinsurablevalue2, "2nd value");
						verifyExists(totalinsurablevalue3, "3st value");
						verifyExists(totalinsurablevalue4, "4nd value");
						
						TIV1 = getTextFrom(totalinsurablevalue1);
						TIV2 = getTextFrom(totalinsurablevalue2);
						TIV3 = getTextFrom(totalinsurablevalue3);
						TIV4 = getTextFrom(totalinsurablevalue4);
						
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		} else {
			Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		}
		}
		
		
	}
		
	


