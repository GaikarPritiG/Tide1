package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

//*[@name='CurrencyGrp'][@value='true']

public class SettlementFinancialsPage extends PageBase {
	public static String sheet6168PathScnd = "";
	
	public String RN1;
	public String RN2;
	public String RN11;
	public String RN12;
	public String CSC11;
	public String CSC12;
	public String CSCRoe11;
	public String CSCRoe12;
	public String NPCSC11;
	public String NPCSC12;
	public String RN21;
	public String RN22;
	public String CSC21;
	public String CSC22;
	public String CSCRoe21;
	public String CSCRoe22;
	public String NPCSC21;
	public String NPCSC22;
	public String BSC21;
	public String BSC22;
	public String BSCRoe21;
	public String BSCRoe22;
	public String BBSC21;
	public String BBSC22;
	public String FNPBSC21;
	public String FNPBSC22;
	public String RN31;
	public String RN32;
	public String CSCRoe31;
	public String CSCRoe32;
	public String NPCSC31;
	public String NPCSC32;
	public String BSC32;
	public String BSCRoe31;
	public String BSCRoe32;
	public String BBSC32;
	public String FNPBSC32;
	
	public String errorTitleValidate;
	public String errorTitleValidate1;
	public String errorTitleValidate2;
	public String ActualDPVCOriginal;
	public String ActualDPVCChanged; 
	public String ActualDPVCRuleName;
	public String ActualDPVCOriginal2;
	public String ActualDPVCChanged2; 
	public String ActualDPVCRuleName2;
	public String ActualDPVCOriginal3;
	public String ActualDPVCChanged3; 
	public String ActualDPVCRuleName3;
	public String ActualDPVCOriginal4;
	public String ActualDPVCChanged4; 
	public String ActualDPVCRuleName4;
	public String ActualDPVCOriginal5;
	public String ActualDPVCChanged5; 
	public String ActualDPVCRuleName5;
	public String ActualDPVCOriginal6;
	public String ActualDPVCChanged6; 
	public String ActualDPVCRuleName6;
	public String ActualDPVCOriginal1;
	public String ActualDPVCChanged1; 
	public String ActualDPVCRuleName1;
	public String ActualDPVCOriginal7;
	public String ActualDPVCChanged7; 
	public String ActualDPVCRuleName7;
	
	public String ActualDPVCOriginal8;
	public String ActualDPVCChanged8; 
	public String ActualDPVCRuleName8;
	public String ActualDPVCOriginal9;
	public String ActualDPVCChanged9; 
	public String ActualDPVCRuleName9;
	public String ActualDPVCOriginal10;
	public String ActualDPVCChanged10; 
	public String ActualDPVCRuleName10;
	public String ActualDPVCOriginal11;
	public String ActualDPVCChanged11; 
	public String ActualDPVCRuleName11;
	public String ActualDPVCOriginal12;
	public String ActualDPVCChanged12; 
	public String ActualDPVCRuleName12;
	public String ActualDPVCOriginal13;
	public String ActualDPVCChanged13; 
	public String ActualDPVCRuleName13;
    public String CSC;
	
	
	public static final String Data0 ="@xpath=//input[contains(@id,'Data0')]";
	public static final String Data1 ="@xpath=//input[contains(@id,'Data0')]";
	public static final String ContinueBtn ="@xpath=//button[@class='btn btn-success p-lr-lg']";
	public static final String Brokersettlmntccy ="@xpath=//li[contains(text(),'GBP - Pound Sterling')]";
	public static final String Coverholdersettlmntccy ="@xpath=//li[contains(text(),'GBP - Pound Sterling')]";
	public static final String Coverholdersettlmntccy1 ="@xpath=//li[contains(text(),'GBP - Pound Sterling')]";
	
	
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	SchemaPage schema = new SchemaPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQ = new BordereauQuePage();

	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	

	public void TC_1367_SettlementFinancial() throws Exception {

		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		ArrayList<String> DataCapture4 = new ArrayList<String>();
		ArrayList<String> DataCapture5 = new ArrayList<String>();
		ArrayList<String> DataCapture6 = new ArrayList<String>();
		ArrayList<String> DataCapture7 = new ArrayList<String>();
		ArrayList<String> DataCapture8 = new ArrayList<String>();
		ArrayList<String> DataCapture9 = new ArrayList<String>();
		ArrayList<String> DataCapture10 = new ArrayList<String>();
		ArrayList<String> DataCapture11 = new ArrayList<String>();
		ArrayList<String> DataCapture12 = new ArrayList<String>();
		ArrayList<String> DataCapture13 = new ArrayList<String>();
		ArrayList<String> DataCapture14 = new ArrayList<String>();
		
		/*homePage.adminMenu();
		BQ.bordereauQueLink();
		BQ.bordereauQuePage();
		QuePage.BFormatId = BQ.addsettlementQue();*/
		
		
		policy.CreateContractwithInceptionDate2018();
		
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForpremium();
	
		/*policy.PolicyNumber = "798195PE";
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		*/
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//			BordereauProcess.SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Settlmentfincial_TC_6168.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet6168PathScnd);
		
	//	policy.contractId ="72b537f1-e8cd-4512-9052-9f4279360e34";
		
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\"af045e74-8255-4451-99fe-34d112f092c7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
		
	//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String Ufname = "S71334120181110.xlsx";	
		int size = 18718;
		String BordreauID = "06a997ec-266e-41f5-8099-4257f21d3083";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "2", 2018);
        addAsDraft(payload,DraftUrl);
        
        
		BordereauPage.refreshUploadedFile();
		
		if (isVisible(BordereauPage.ReviewBtn) == true) {
			AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			BordereauPage.openDATALink();
		//	BordereauPage.navigateToDATARiskTab();
			BordereauPage.navigateToDATAPremiumTab();
			sleep(2000);
			// Row number column
			String RowNumber = "@xpath=//*[@data-field='RowNumber']";
			String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
			String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='4']";
			verifyExists(RowNumber1, "1st value");
			verifyExists(RowNumber2, "1st value");
			RN1 = getTextFrom(RowNumber1);
			RN2 = getTextFrom(RowNumber2);
			sleep(2000);
			
			// Coverholder Settlement Currency Column
			String coverholdersettlementcurrency = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']";
			String coverholdersettlementcurrency1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='USD']";
			String coverholdersettlementcurrency2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='USD']";
			DataCapture1 =	BordereauPage.RuleDataCapture(coverholdersettlementcurrency1,"Coverholder Settlement Currency","-","USD","Derive Coverholder Settlement Currency from Premium Currency");
			ActualDPVCOriginal = DataCapture1.get(0);
			ActualDPVCChanged = DataCapture1.get(1);
			ActualDPVCRuleName = DataCapture1.get(2);
			DataCapture2 = BordereauPage.RuleDataCapture(coverholdersettlementcurrency2,"Coverholder Settlement Currency","-","USD","Derive Coverholder Settlement Currency from Premium Currency");
			ActualDPVCOriginal1 = DataCapture2.get(0);
			ActualDPVCChanged1 = DataCapture2.get(1);
			ActualDPVCRuleName1 = DataCapture2.get(2);
			
			
			// Coverholder Settlement Currency RoE column
			String CoverholderSettlementCurrencyRoE = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']";
			String CoverholderSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
			String CoverholderSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
		
			DataCapture3 =	BordereauPage.RuleDataCapture(CoverholderSettlementCurrencyRoE1,"Coverholder Settlement Currency RoE","-","1.00","Set Coverholder Settlement RoE as 1");
			ActualDPVCOriginal2 = DataCapture3.get(0);
			ActualDPVCChanged2 = DataCapture3.get(1);
			ActualDPVCRuleName2 = DataCapture3.get(2);
			DataCapture4 = BordereauPage.RuleDataCapture(CoverholderSettlementCurrencyRoE2,"Coverholder Settlement Currency RoE","-","1.00","Set Coverholder Settlement RoE as 1");
			ActualDPVCOriginal3 = DataCapture4.get(0);
			ActualDPVCChanged3 = DataCapture4.get(1);
			ActualDPVCRuleName3 = DataCapture4.get(2);
			
			// Net Premium (Coverholder Settlement Currency) column
			String NetPremium_CoverholderSettlementCurrency = "@xpath=//*[@data-field='Net_Premium_100_Settlement']";
			String NetPremium_CoverholderSettlementCurrency1 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='11,875.30']";
			String NetPremium_CoverholderSettlementCurrency2 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='8,635.00']";
			DataCapture5 =	BordereauPage.RuleDataCapture(NetPremium_CoverholderSettlementCurrency1,"Net Premium (Coverholder Settlement Currency)","-","11,875.30","Use Net Premium (Premium Currency) as Net Premium (Coverholder Settlement Currency)");
			ActualDPVCOriginal4 = DataCapture5.get(0);
			ActualDPVCChanged4 = DataCapture5.get(1);
			ActualDPVCRuleName4 = DataCapture5.get(2);
			DataCapture6 = BordereauPage.RuleDataCapture(NetPremium_CoverholderSettlementCurrency2,"Net Premium (Coverholder Settlement Currency)","-","8,635.00","Use Net Premium (Premium Currency) as Net Premium (Coverholder Settlement Currency)");
			ActualDPVCOriginal5 = DataCapture6.get(0);
			ActualDPVCChanged5 = DataCapture6.get(1);
			ActualDPVCRuleName5 = DataCapture6.get(2);
			
			
			// Broker Settlement Currency column
			String BrokerSettlementCurrency = "@xpath=//*[@data-field='Broker_Settlement_Currency']";
			String BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='USD']";
			String BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='USD']";
			
			DataCapture7 =	BordereauPage.RuleDataCapture(BrokerSettlementCurrency1,"Broker Settlement Currency","-","USD","Derive Broker Settlement Currency from Coverholder Settlement Currency");
			ActualDPVCOriginal6 = DataCapture7.get(0);
			ActualDPVCChanged6 = DataCapture7.get(1);
			ActualDPVCRuleName6 = DataCapture7.get(2);
			DataCapture8 = BordereauPage.RuleDataCapture(BrokerSettlementCurrency2,"Broker Settlement Currency","-","USD","Derive Broker Settlement Currency from Coverholder Settlement Currency");
			ActualDPVCOriginal7 = DataCapture8.get(0);
			ActualDPVCChanged7 = DataCapture8.get(1);
			ActualDPVCRuleName7 = DataCapture8.get(2);
			
			// Broker Settlement Currency RoE column
			String BrokerSettlementCurrencyRoE = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']";
			String BrokerSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
			String BrokerSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
			
			DataCapture9 =	BordereauPage.RuleDataCapture(BrokerSettlementCurrencyRoE1,"Broker Settlement Currency RoE","-","1.00","Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			ActualDPVCOriginal8 = DataCapture9.get(0);
			ActualDPVCChanged8 = DataCapture9.get(1);
			ActualDPVCRuleName8 = DataCapture9.get(2);
			DataCapture10 = BordereauPage.RuleDataCapture(BrokerSettlementCurrencyRoE2,"Broker Settlement Currency RoE","-","1.00","Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			ActualDPVCOriginal9 = DataCapture10.get(0);
			ActualDPVCChanged9 = DataCapture10.get(1);
			ActualDPVCRuleName9 = DataCapture10.get(2);
			
			// Brokerage (Broker Settlement Currency) column
			String Brokerage_BrokerSettlementCurrency = "@xpath=//*[@data-field='Brokerage_100_Settlement']";
			String Brokerage_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='600.00']";
			String Brokerage_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='600.00']";
			DataCapture11 =	BordereauPage.RuleDataCapture(Brokerage_BrokerSettlementCurrency1,"Brokerage (Broker Settlement Currency)","-","600.00","Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			ActualDPVCOriginal10 = DataCapture11.get(0);
			ActualDPVCChanged10 = DataCapture11.get(1);
			ActualDPVCRuleName10 = DataCapture11.get(2);
			DataCapture12 = BordereauPage.RuleDataCapture(Brokerage_BrokerSettlementCurrency2,"Brokerage (Broker Settlement Currency)","-","600.00","Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			ActualDPVCOriginal11 = DataCapture12.get(0);
			ActualDPVCChanged11 = DataCapture12.get(1);
			ActualDPVCRuleName11 = DataCapture12.get(2);
			
			
			// Final Net Premium (Broker Settlement Currency) column
			String FinalNetPremium_BrokerSettlementCurrency = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']";
			String FinalNetPremium_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='11,275.30']";
			String FinalNetPremium_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='8,035.00']";
			
			DataCapture13 =	BordereauPage.RuleDataCapture(FinalNetPremium_BrokerSettlementCurrency1,"Final Net Premium (Broker Settlement Currency)","-","11,275.30","Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
			ActualDPVCOriginal12 = DataCapture13.get(0);
			ActualDPVCChanged12 = DataCapture13.get(1);
			ActualDPVCRuleName12 = DataCapture13.get(2);
			DataCapture14 = BordereauPage.RuleDataCapture(FinalNetPremium_BrokerSettlementCurrency2,"Final Net Premium (Broker Settlement Currency)","-","8,035.00","Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
			ActualDPVCOriginal13 = DataCapture14.get(0);
			ActualDPVCChanged13 = DataCapture14.get(1);
			ActualDPVCRuleName13 = DataCapture14.get(2);
			
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		} else {
			Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		}
		
		
	}
	
public void SettlementFinancial_1368() throws Exception {

	
	ArrayList<String> DataCapture7 = new ArrayList<String>();
	ArrayList<String> DataCapture8 = new ArrayList<String>();
	ArrayList<String> DataCapture9 = new ArrayList<String>();
	ArrayList<String> DataCapture10 = new ArrayList<String>();
	ArrayList<String> DataCapture11 = new ArrayList<String>();
	ArrayList<String> DataCapture12 = new ArrayList<String>();
	ArrayList<String> DataCapture13 = new ArrayList<String>();
	ArrayList<String> DataCapture14 = new ArrayList<String>();
	
	
	/*	
		homePage.adminMenu();
		BQ.bordereauQueLink();
		BQ.bordereauQuePage();
		QuePage.BFormatId = BQ.addsettlementQue1();
		*/
	
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//			BordereauProcess.SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Settlmentfincial_TC_6168.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet6168PathScnd);
		
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\"af045e74-8255-4451-99fe-34d112f092c7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
		
	//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		
		String Ufname = "S76582020180923.xlsx";	
		int size = 18324;
		String BordreauID = "4bc03da4-50b6-42a1-8940-a0e9b91e715d";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "2", 2018);
        addAsDraft(payload,DraftUrl);
		
		BordereauPage.refreshUploadedFile();
		
		if (isVisible(BordereauPage.ReviewBtn) == true) {
			AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			BordereauPage.openDATALink();
		//	BordereauPage.navigateToDATARiskTab();
			BordereauPage.navigateToDATAPremiumTab();
			sleep(2000);
			// Row number column
			String RowNumber = "@xpath=//*[@data-field='RowNumber']";
			String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
			String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='4']";
			verifyExists(RowNumber1, "1st value");
			verifyExists(RowNumber2, "1st value");
			RN11 = getTextFrom(RowNumber1);
			RN12 = getTextFrom(RowNumber2);
			sleep(2000);
			// Coverholder Settlement Currency Column
			String coverholdersettlementcurrency = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']";
			String coverholdersettlementcurrency1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='USD']";
			String coverholdersettlementcurrency2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='USD']";
			
			waitForElementToAppear(coverholdersettlementcurrency, 20);
			mouseOverAction(coverholdersettlementcurrency);
			verifyMustExists(coverholdersettlementcurrency, "Coverholder Settlement Currency Column");
			sleep(2000);
			verifyExists(coverholdersettlementcurrency1, "1st value");
			verifyExists(coverholdersettlementcurrency2, "2nd value");
			CSC11 = getTextFrom(coverholdersettlementcurrency1);
			CSC12 = getTextFrom(coverholdersettlementcurrency2);
			sleep(2000);
			// Coverholder Settlement Currency RoE column
			String CoverholderSettlementCurrencyRoE = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']";
			String CoverholderSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
			String CoverholderSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
			
			waitForElementToAppear(CoverholderSettlementCurrencyRoE, 20);
			mouseOverAction(CoverholderSettlementCurrencyRoE);
			verifyMustExists(CoverholderSettlementCurrencyRoE, "Coverholder Settlement Currency RoE column");
			sleep(2000);
			verifyExists(CoverholderSettlementCurrencyRoE1, "1st value");
			verifyExists(CoverholderSettlementCurrencyRoE2, "2nd value");
			CSCRoe11 = getTextFrom(CoverholderSettlementCurrencyRoE1);
			CSCRoe12 = getTextFrom(CoverholderSettlementCurrencyRoE2);
			sleep(2000);
			// Net Premium (Coverholder Settlement Currency) column
			String NetPremium_CoverholderSettlementCurrency = "@xpath=//*[@data-field='Net_Premium_100_Settlement']";
			String NetPremium_CoverholderSettlementCurrency1 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='11,875.30']";
			String NetPremium_CoverholderSettlementCurrency2 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='8,635.00']";
			
			waitForElementToAppear(NetPremium_CoverholderSettlementCurrency, 20);
			mouseOverAction(NetPremium_CoverholderSettlementCurrency);
			verifyMustExists(NetPremium_CoverholderSettlementCurrency, "Net Premium (Coverholder Settlement Currency) column");
			sleep(2000);
			verifyExists(NetPremium_CoverholderSettlementCurrency1, "1st value");
			verifyExists(NetPremium_CoverholderSettlementCurrency2, "2nd value");
			NPCSC11 = getTextFrom(NetPremium_CoverholderSettlementCurrency1);
			NPCSC12 = getTextFrom(NetPremium_CoverholderSettlementCurrency2);
			sleep(2000);
			// Broker Settlement Currency column
			String BrokerSettlementCurrency = "@xpath=//*[@data-field='Broker_Settlement_Currency']";
			String BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='USD']";
			String BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='USD']";
			DataCapture7 =	BordereauPage.RuleDataCapture(BrokerSettlementCurrency1,"Broker Settlement Currency","-","USD","Derive Broker Settlement Currency from Coverholder Settlement Currency");
			ActualDPVCOriginal6 = DataCapture7.get(0);
			ActualDPVCChanged6 = DataCapture7.get(1);
			ActualDPVCRuleName6 = DataCapture7.get(2);
			DataCapture8 = BordereauPage.RuleDataCapture(BrokerSettlementCurrency2,"Broker Settlement Currency","-","USD","Derive Broker Settlement Currency from Coverholder Settlement Currency");
			ActualDPVCOriginal7 = DataCapture8.get(0);
			ActualDPVCChanged7 = DataCapture8.get(1);
			ActualDPVCRuleName7 = DataCapture8.get(2);
			
			// Broker Settlement Currency RoE column
			String BrokerSettlementCurrencyRoE = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']";
			String BrokerSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
			String BrokerSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
			DataCapture9 =	BordereauPage.RuleDataCapture(BrokerSettlementCurrencyRoE1,"Broker Settlement Currency RoE","-","1.00","Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			ActualDPVCOriginal8 = DataCapture9.get(0);
			ActualDPVCChanged8 = DataCapture9.get(1);
			ActualDPVCRuleName8 = DataCapture9.get(2);
			DataCapture10 = BordereauPage.RuleDataCapture(BrokerSettlementCurrencyRoE2,"Broker Settlement Currency RoE","-","1.00","Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			ActualDPVCOriginal9 = DataCapture10.get(0);
			ActualDPVCChanged9 = DataCapture10.get(1);
			ActualDPVCRuleName9 = DataCapture10.get(2);
			
			// Brokerage (Broker Settlement Currency) column
			String Brokerage_BrokerSettlementCurrency = "@xpath=//*[@data-field='Brokerage_100_Settlement']";
			String Brokerage_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='600.00']";
			String Brokerage_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='600.00']";
			DataCapture11 =	BordereauPage.RuleDataCapture(Brokerage_BrokerSettlementCurrency1,"Brokerage (Broker Settlement Currency)","-","600.00","Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			ActualDPVCOriginal10 = DataCapture11.get(0);
			ActualDPVCChanged10 = DataCapture11.get(1);
			ActualDPVCRuleName10 = DataCapture11.get(2);
			DataCapture12 = BordereauPage.RuleDataCapture(Brokerage_BrokerSettlementCurrency2,"Brokerage (Broker Settlement Currency)","-","600.00","Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			ActualDPVCOriginal11 = DataCapture12.get(0);
			ActualDPVCChanged11 = DataCapture12.get(1);
			ActualDPVCRuleName11 = DataCapture12.get(2);
			
			
			
			// Final Net Premium (Broker Settlement Currency) column
			String FinalNetPremium_BrokerSettlementCurrency = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']";
			String FinalNetPremium_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='11,275.30']";
			String FinalNetPremium_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='8,035.00']";

			DataCapture13 =	BordereauPage.RuleDataCapture(FinalNetPremium_BrokerSettlementCurrency1,"Final Net Premium (Broker Settlement Currency)","-","11,275.30","Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
			ActualDPVCOriginal12 = DataCapture13.get(0);
			ActualDPVCChanged12 = DataCapture13.get(1);
			ActualDPVCRuleName12 = DataCapture13.get(2);
			DataCapture14 = BordereauPage.RuleDataCapture(FinalNetPremium_BrokerSettlementCurrency2,"Final Net Premium (Broker Settlement Currency)","-","8,035.00","Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
			ActualDPVCOriginal13 = DataCapture14.get(0);
			ActualDPVCChanged13 = DataCapture14.get(1);
			ActualDPVCRuleName13 = DataCapture14.get(2);
			
			
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		} else {
			Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		}
		
}

public void SettlementFinancial_1369() throws Exception {
	

	
	/*homePage.adminMenu();
	BQ.bordereauQueLink();
	BQ.bordereauQuePage();
	QuePage.BFormatId = BQ.addsettlementQue2();*/
	
		
	String GetData = Configuration.url+"/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

	String subSheet = "Bordereau Processing (kruthika test schema)";
	String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	//			BordereauProcess.SubmitBordereaux(subSheet);
	
	try 
	{
		String fpath = new File(".").getCanonicalPath();
		sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Settlmentfincial_TC_6168.xlsx";
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//StringSelection allSheets = new StringSelection(allSheetsPath);
	File excelFile = new File(sheet6168PathScnd);
	
    policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
	//System.out.println(contractId);

	Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
	
	//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
	//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
	String Ufname = "S18774620180923.xlsx";	
	int size = 18324;
	String BordreauID = "a9d6979d-1c60-4faf-ad07-9d09da3f5760";
    String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
    String ID = extractIDFromResponseinsideContract(response); 
    String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "2", 2018);
    addAsDraft(payload,DraftUrl);
	
	BordereauPage.refreshUploadedFile();
	
	if (isVisible(BordereauPage.ReviewBtn) == true) {
		AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
		Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
		BordereauPage.openDATALink();
	//	BordereauPage.navigateToDATARiskTab();
		BordereauPage.navigateToDATAPremiumTab();
		sleep(2000);
		// Row number column
		String RowNumber = "@xpath=//*[@data-field='RowNumber']";
		String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
		String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='4']";
		verifyExists(RowNumber1, "1st value");
		verifyExists(RowNumber2, "1st value");
		RN21 = getTextFrom(RowNumber1);
		RN22 = getTextFrom(RowNumber2);
		sleep(2000);
		// Coverholder Settlement Currency Column
		String coverholdersettlementcurrency = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']";
		String coverholdersettlementcurrency1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='USD']";
		String coverholdersettlementcurrency2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='USD']";
	
		mouseOverAction(coverholdersettlementcurrency);
		verifyMustExists(coverholdersettlementcurrency, "Coverholder Settlement Currency Column");
		sleep(2000);
		verifyExists(coverholdersettlementcurrency1, "1st value");
		verifyExists(coverholdersettlementcurrency2, "2nd value");
		CSC21 = getTextFrom(coverholdersettlementcurrency1);
		CSC22 = getTextFrom(coverholdersettlementcurrency2);
		sleep(2000);
		// Coverholder Settlement Currency RoE column
		String CoverholderSettlementCurrencyRoE = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']";
		String CoverholderSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
		String CoverholderSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
		
		waitForElementToAppear(CoverholderSettlementCurrencyRoE, 20);
		mouseOverAction(CoverholderSettlementCurrencyRoE);
		verifyMustExists(CoverholderSettlementCurrencyRoE, "Coverholder Settlement Currency RoE column");
		sleep(2000);
		verifyExists(CoverholderSettlementCurrencyRoE1, "1st value");
		verifyExists(CoverholderSettlementCurrencyRoE2, "2nd value");
		CSCRoe21 = getTextFrom(CoverholderSettlementCurrencyRoE1);
		CSCRoe22 = getTextFrom(CoverholderSettlementCurrencyRoE2);
		sleep(2000);
		// Net Premium (Coverholder Settlement Currency) column
		String NetPremium_CoverholderSettlementCurrency = "@xpath=//*[@data-field='Net_Premium_100_Settlement']";
		String NetPremium_CoverholderSettlementCurrency1 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='11,875.30']";
		String NetPremium_CoverholderSettlementCurrency2 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='8,635.00']";
		
		
		waitForElementToAppear(NetPremium_CoverholderSettlementCurrency, 20);
		mouseOverAction(NetPremium_CoverholderSettlementCurrency);
		verifyMustExists(NetPremium_CoverholderSettlementCurrency,
				"Net Premium (Coverholder Settlement Currency) column");
		sleep(2000);
		verifyExists(NetPremium_CoverholderSettlementCurrency1, "1st value");
		verifyExists(NetPremium_CoverholderSettlementCurrency2, "2nd value");
		NPCSC21 = getTextFrom(NetPremium_CoverholderSettlementCurrency1);
		NPCSC22 = getTextFrom(NetPremium_CoverholderSettlementCurrency2);
		sleep(2000);
		// Broker Settlement Currency column
		String BrokerSettlementCurrency = "@xpath=//*[@data-field='Broker_Settlement_Currency']";
		String BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='USD']";
		String BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='USD']";
		
		
		waitForElementToAppear(BrokerSettlementCurrency, 20);
		mouseOverAction(BrokerSettlementCurrency);
		verifyMustExists(BrokerSettlementCurrency, "Broker Settlement Currency column");
		sleep(2000);
		verifyExists(BrokerSettlementCurrency1, "1st value");
		verifyExists(BrokerSettlementCurrency2, "2nd value");
		BSC21 = getTextFrom(BrokerSettlementCurrency1);
		BSC22 = getTextFrom(BrokerSettlementCurrency2);
		sleep(2000);
		// Broker Settlement Currency RoE column
		String BrokerSettlementCurrencyRoE = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']";
		String BrokerSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
		String BrokerSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
		
		
		waitForElementToAppear(BrokerSettlementCurrencyRoE, 20);
		mouseOverAction(BrokerSettlementCurrencyRoE);
		verifyMustExists(BrokerSettlementCurrencyRoE, "Broker Settlement Currency RoE column");
		sleep(2000);
		verifyExists(BrokerSettlementCurrencyRoE1, "1st value");
		verifyExists(BrokerSettlementCurrencyRoE2, "2nd value");
		BSCRoe21 = getTextFrom(BrokerSettlementCurrencyRoE1);
		BSCRoe22 = getTextFrom(BrokerSettlementCurrencyRoE2);
		sleep(2000);
		// Brokerage (Broker Settlement Currency) column
		String Brokerage_BrokerSettlementCurrency = "@xpath=//*[@data-field='Brokerage_100_Settlement']";
		String Brokerage_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='1,050.00']";
		String Brokerage_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='512.00']";
		
		waitForElementToAppear(Brokerage_BrokerSettlementCurrency, 20);
		mouseOverAction(Brokerage_BrokerSettlementCurrency);
		verifyMustExists(Brokerage_BrokerSettlementCurrency, "Brokerage (Broker Settlement Currency) column");
		sleep(2000);
		verifyExists(Brokerage_BrokerSettlementCurrency1, "1st value");
		verifyExists(Brokerage_BrokerSettlementCurrency2, "2nd value");
		BBSC21 = getTextFrom(Brokerage_BrokerSettlementCurrency1);
		BBSC22 = getTextFrom(Brokerage_BrokerSettlementCurrency2);
		sleep(2000);
		// Final Net Premium (Broker Settlement Currency) column
		String FinalNetPremium_BrokerSettlementCurrency = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']";
		String FinalNetPremium_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='250.00']";
		String FinalNetPremium_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='712.00']";
		
		
		waitForElementToAppear(FinalNetPremium_BrokerSettlementCurrency, 20);
		mouseOverAction(FinalNetPremium_BrokerSettlementCurrency);
		verifyMustExists(FinalNetPremium_BrokerSettlementCurrency,
				"Final Net Premium (Broker Settlement Currency) column");
		sleep(2000);
		verifyExists(FinalNetPremium_BrokerSettlementCurrency1, "1st value");
		verifyExists(FinalNetPremium_BrokerSettlementCurrency2, "2nd value");
		FNPBSC21 = getTextFrom(FinalNetPremium_BrokerSettlementCurrency1);
		FNPBSC22 = getTextFrom(FinalNetPremium_BrokerSettlementCurrency2);
		sleep(2000);
		policy.navigationOnBordereauxTab();
		BordereauPage.deleteBorderEAUX();
	} else {
		Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
		policy.navigationOnBordereauxTab();
		BordereauPage.deleteBorderEAUX();
	} 																																																		
	
	
}

public void SettlementFinancial_3725() throws Exception {
	
	ArrayList<String> DataCapture1 = new ArrayList<String>();
	ArrayList<String> DataCapture2 = new ArrayList<String>();
	ArrayList<String> DataCapture7 = new ArrayList<String>();
	ArrayList<String> DataCapture11 = new ArrayList<String>();
	ArrayList<String> DataCapture13 = new ArrayList<String>();
	
	
  /*  policy.CreateContractwithInceptionDate2018();
	
	policy.navigateToReportingChannelsTab();
	policy.addReportingChannelForpremium();*/
	/*policy.PolicyNumber = "996940CD";
	BordereauProcess.applyFilterPolicy(policy.PolicyNumber);		
	BordereauProcess.openSelectedPolicy();
*/
	/*policy.PolicyNumber = "798195PE";
	BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
	BordereauProcess.openSelectedPolicy();
	*/
	
	String GetData = Configuration.url+"/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

	String subSheet = "Bordereau Processing (kruthika test schema)";
	String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	

	try 
	{
		String fpath = new File(".").getCanonicalPath();
		sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Settlmentfincial_TC_6168_Erros.xlsx";
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//StringSelection allSheets = new StringSelection(allSheetsPath);
	File excelFile = new File(sheet6168PathScnd);
	//policy.contractId ="e0dbf057-73a8-46fb-b144-96443bc30a88";
//	policy.contractId ="72b537f1-e8cd-4512-9052-9f4279360e34";
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
	//System.out.println(contractId);

	Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
	//policy.contractId = "9f171182-6961-4315-86c5-fe128cf6cd36";
	String Ufname = "S53797920181111.xlsx";	
	int size = 18965;
	String BordreauID = "342fb5e1-bb73-413a-a506-2c1ccc88fa7c";
    String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
    String ID = extractIDFromResponseinsideContract(response); 
    String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "2", 2018);
    addAsDraft(payload,DraftUrl);
	
	BordereauPage.refreshUploadedFile();
	
	String InvalidFinancial= "@xpath=//*[@class='card']//h2[contains(.,'Invalid financial value translation required')]";
	
	if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
		Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
		sleep(2000);
		if(isVisible(InvalidFinancial)== true) {
			errorTitleValidate = getTextFrom(InvalidFinancial);
			Report.LogInfo("Check", errorTitleValidate, "PASS");
			sleep(2000);
			verifyMustExists(Data0,"V4");
			sendKeys(Data0,"1050","L4");
			sleep(2000);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			
			verifyMustExists(Data1,"V4");
			sendKeys(Data1,"250","L4");
			sleep(2000);
			verifyMustExists(ContinueBtn,"Continue button");
			click(ContinueBtn,"Continue button");
			sleep(2000);
			
			BordereauPage.refreshUploadedFile();
			
			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
				
			}
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
				String BrokerSettlmentCcy= "@xpath=//*[@class='card']//h2[contains(.,'Broker Settlement Currency reference data translation required')]";
				String CoverholderSettlmentCcy= "@xpath=//*[@class='card']//h2[contains(.,'Coverholder Settlement Currency reference data translation required')]";
				if(isVisible(BrokerSettlmentCcy)== true) {
					errorTitleValidate1 = getTextFrom(BrokerSettlmentCcy);
					sleep(2000);
					SelectDropDownValue1(schema.Data0DD,Brokersettlmntccy);
					sleep(2000);
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
									
				
			}
				
				refreshPage();
				if(isVisible(CoverholderSettlmentCcy)==true) {
					
					
					errorTitleValidate2 = getTextFrom(CoverholderSettlmentCcy);
					sleep(2000);
					SelectDropDownValue1(schema.Data0DD,Coverholdersettlmntccy);
					sleep(2000);
					/*SelectDropDownValue1(schema.Data1DD,Coverholdersettlmntccy1);
					sleep(2000);*/
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
					sleep(2000);
					verifyMustExists(schema.CancelBtn,"Cancel button");
					click(schema.CancelBtn,"Cancel button");
					sleep(2000);
					
				}
				
				
				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
					Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					BordereauPage.openDATALink();
				//	BordereauPage.navigateToDATARiskTab();
					BordereauPage.navigateToDATAPremiumTab();
					sleep(2000);
					// Row number column
					String RowNumber = "@xpath=//*[@data-field='RowNumber']";
					String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
					String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='4']";
					verifyExists(RowNumber1, "1st value");
					verifyExists(RowNumber2, "1st value");
					RN31 = getTextFrom(RowNumber1);
					RN32 = getTextFrom(RowNumber2);
					sleep(2000);
					// Coverholder Settlement Currency Column
					String coverholdersettlementcurrency = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']";
					String coverholdersettlementcurrency1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='GBP']";
					String coverholdersettlementcurrency2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency')][text()='GBP']";
					
					DataCapture1 =	BordereauPage.RuleDataCapture(coverholdersettlementcurrency1,"Coverholder Settlement Currency","Test@1050","GBP","Validate reference data values");
					ActualDPVCOriginal = DataCapture1.get(0);
					ActualDPVCChanged = DataCapture1.get(1);
					ActualDPVCRuleName = DataCapture1.get(2);
					
					verifyExists(coverholdersettlementcurrency2, "2nd value");
					CSC = getTextFrom(coverholdersettlementcurrency2);
					sleep(2000);
					/*DataCapture2 = BordereauPage.RuleDataCapture(coverholdersettlementcurrency2,"Coverholder Settlement Currency","512","GBP","Validate reference data values");
					ActualDPVCOriginal1 = DataCapture2.get(0);
					ActualDPVCChanged1 = DataCapture2.get(1);
					ActualDPVCRuleName1 = DataCapture2.get(2);*/
					
					// Coverholder Settlement Currency RoE column
					String CoverholderSettlementCurrencyRoE = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']";
					String CoverholderSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
					String CoverholderSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')][text()='1.00']";
					
					
					waitForElementToAppear(CoverholderSettlementCurrencyRoE, 20);
					mouseOverAction(CoverholderSettlementCurrencyRoE);
					verifyMustExists(CoverholderSettlementCurrencyRoE, "Coverholder Settlement Currency RoE column");
					sleep(2000);
					verifyExists(CoverholderSettlementCurrencyRoE1, "1st value");
					verifyExists(CoverholderSettlementCurrencyRoE2, "2nd value");
					CSCRoe31 = getTextFrom(CoverholderSettlementCurrencyRoE1);
					CSCRoe32 = getTextFrom(CoverholderSettlementCurrencyRoE2);
					sleep(2000);
					// Net Premium (Coverholder Settlement Currency) column
					String NetPremium_CoverholderSettlementCurrency = "@xpath=//*[@data-field='Net_Premium_100_Settlement']";
					String NetPremium_CoverholderSettlementCurrency1 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='100.00']";
					String NetPremium_CoverholderSettlementCurrency2 = "@xpath=//*[@data-field='Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Net_Premium_100_Settlement')][text()='100.00']";
					
					
					waitForElementToAppear(NetPremium_CoverholderSettlementCurrency, 20);
					mouseOverAction(NetPremium_CoverholderSettlementCurrency);
					verifyMustExists(NetPremium_CoverholderSettlementCurrency, "Net Premium (Coverholder Settlement Currency) column");
					sleep(2000);
					verifyExists(NetPremium_CoverholderSettlementCurrency1, "1st value");
					verifyExists(NetPremium_CoverholderSettlementCurrency2, "2nd value");
					NPCSC31 = getTextFrom(NetPremium_CoverholderSettlementCurrency1);
					NPCSC32 = getTextFrom(NetPremium_CoverholderSettlementCurrency2);
					sleep(2000);
					// Broker Settlement Currency column
					String BrokerSettlementCurrency = "@xpath=//*[@data-field='Broker_Settlement_Currency']";
					String BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='GBP']";
					String BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Broker_Settlement_Currency']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency')][text()='USD']";
					
					DataCapture7 =	BordereauPage.RuleDataCapture(BrokerSettlementCurrency1,"Broker Settlement Currency","Random Insured1","GBP","Validate reference data values");
					ActualDPVCOriginal6 = DataCapture7.get(0);
					ActualDPVCChanged6 = DataCapture7.get(1);
					ActualDPVCRuleName6 = DataCapture7.get(2);
					
					waitForElementToAppear(BrokerSettlementCurrency, 20);
					mouseOverAction(BrokerSettlementCurrency);
					verifyMustExists(BrokerSettlementCurrency, "Broker Settlement Currency column");
					sleep(2000);
					
					verifyExists(BrokerSettlementCurrency2, "2nd value");
				
					BSC32 = getTextFrom(BrokerSettlementCurrency2);
					sleep(2000);
					// Broker Settlement Currency RoE column
					String BrokerSettlementCurrencyRoE = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']";
					String BrokerSettlementCurrencyRoE1 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[1]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
					String BrokerSettlementCurrencyRoE2 = "@xpath=//*[@data-field='Broker_Settlement_Currency_RoE']//following::tr[2]//td[contains(@ng-click,'Broker_Settlement_Currency_RoE')][text()='1.00']";
					
					
					waitForElementToAppear(BrokerSettlementCurrencyRoE, 20);
					mouseOverAction(BrokerSettlementCurrencyRoE);
					verifyMustExists(BrokerSettlementCurrencyRoE, "Broker Settlement Currency RoE column");
					sleep(2000);
					verifyExists(BrokerSettlementCurrencyRoE1, "1st value");
					verifyExists(BrokerSettlementCurrencyRoE2, "2nd value");
					BSCRoe31 = getTextFrom(BrokerSettlementCurrencyRoE1);
					BSCRoe32 = getTextFrom(BrokerSettlementCurrencyRoE2);
					sleep(2000);
					// Brokerage (Broker Settlement Currency) column
					String Brokerage_BrokerSettlementCurrency = "@xpath=//*[@data-field='Brokerage_100_Settlement']";
					String Brokerage_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='1,050.00']";
					String Brokerage_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Brokerage_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Brokerage_100_Settlement')][text()='0.00']";
					
					DataCapture11 =	BordereauPage.RuleDataCapture(Brokerage_BrokerSettlementCurrency1,"Brokerage (Broker Settlement Currency)","es@1050","1,050.00","Validate Financial values");
					ActualDPVCOriginal10 = DataCapture11.get(0);
					ActualDPVCChanged10 = DataCapture11.get(1);
					ActualDPVCRuleName10 = DataCapture11.get(2);
					
					DataCapture2 =	BordereauPage.RuleDataCapture(Brokerage_BrokerSettlementCurrency2,"Brokerage (Broker Settlement Currency)","GBP","0.00","Remove ISO currency code characters & symbols");
					ActualDPVCOriginal11 = DataCapture2.get(0);
					ActualDPVCChanged11 = DataCapture2.get(1);
					ActualDPVCRuleName11 = DataCapture2.get(2);
					
					/*waitForElementToAppear(Brokerage_BrokerSettlementCurrency, 20);
					mouseOverAction(Brokerage_BrokerSettlementCurrency);
					verifyMustExists(Brokerage_BrokerSettlementCurrency, "Brokerage (Broker Settlement Currency) column");
					sleep(2000);
					
					verifyExists(Brokerage_BrokerSettlementCurrency2, "2nd value");*/
					
					/*BBSC32 = getTextFrom(Brokerage_BrokerSettlementCurrency2);
					sleep(2000);*/
					// Final Net Premium (Broker Settlement Currency) column
					String FinalNetPremium_BrokerSettlementCurrency = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']";
					String FinalNetPremium_BrokerSettlementCurrency1 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='250.00']";
					String FinalNetPremium_BrokerSettlementCurrency2 = "@xpath=//*[@data-field='Final_Net_Premium_100_Settlement']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium_100_Settlement')][text()='712.00']";
					
					DataCapture13 =	BordereauPage.RuleDataCapture(FinalNetPremium_BrokerSettlementCurrency1,"Final Net Premium (Broker Settlement Currency)","es@250","250.00","Validate Financial values");
					ActualDPVCOriginal12 = DataCapture13.get(0);
					ActualDPVCChanged12 = DataCapture13.get(1);
					ActualDPVCRuleName12 = DataCapture13.get(2);
					
					waitForElementToAppear(FinalNetPremium_BrokerSettlementCurrency, 20);
					mouseOverAction(FinalNetPremium_BrokerSettlementCurrency);
					verifyMustExists(FinalNetPremium_BrokerSettlementCurrency, "Final Net Premium (Broker Settlement Currency) column");
					sleep(2000);
					
					verifyExists(FinalNetPremium_BrokerSettlementCurrency2, "2nd value");
					
					FNPBSC32 = getTextFrom(FinalNetPremium_BrokerSettlementCurrency2);
					sleep(2000);
					policy.navigationOnBordereauxTab();
					BordereauPage.deleteBorderEAUX();
				} else {
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
					policy.navigationOnBordereauxTab();
					BordereauPage.deleteBorderEAUX();
				}
					
				}
			
		}
		
	}
	
	
	



}

