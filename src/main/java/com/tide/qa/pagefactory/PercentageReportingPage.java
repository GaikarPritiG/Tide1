package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class PercentageReportingPage  extends PageBase{

	public String Rowno1;
	public String Rowno2;
	public String CCP1;
	public String CCP2;
	public String TTP;
	public String ActualDPVCOriginal1;
	public String ActualDPVCOriginal2;
	public String ActualDPVCChanged1;
	public String ActualDPVCChanged2;
	public String ActualDPVCRuleName1;
	public String ActualDPVCRuleName2;
	public String ActualDPVCOriginal3;
	public String ActualDPVCChanged3;
	public String ActualDPVCRuleName3;
	public static String sheet6168PathScnd = "";
	public String errorTitleValidate;
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQ = new BordereauQuePage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	SchemaPage schema = new SchemaPage();
	public static final String ContinueBtn ="@xpath=//button[@class='btn btn-success p-lr-lg']";

	public static final String EnrichedValTxt = "@xpath=//*[@id='Data0']";
	
	public void TC4136PercentageReporting() throws Exception {
		
		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		
		policy.CreateContractwithInceptionDate2018();
		/*policy.PolicyNumber = "798195PE";
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();*/
		
		
		
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
			sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Percentage_Reporting.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet6168PathScnd);
	//	policy.contractId = "72b537f1-e8cd-4512-9052-9f4279360e34";		
	   policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\"af045e74-8255-4451-99fe-34d112f092c7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
		
	//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String Ufname = "S28326720181111.xlsx";	
		int size = 21061;
		String BordreauID = "1ef0fbee-ee61-4f11-9f76-ad4f4b0419c2";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        BordereauPage.refreshUploadedFile();
        

    	if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
    		Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
    		sleep(2000);
		
    		String ErrorTittle= "@xpath=//*[@class='card']//h2[contains(.,'Invalid percentage values identified')]";
			if(isVisible(ErrorTittle)== true) {
				errorTitleValidate = getTextFrom(ErrorTittle);
				sleep(2000);
				verifyMustExists(EnrichedValTxt,"Enriched value textbox");
				sendKeys(EnrichedValTxt,"50","Enriched Val Txt");
				
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
				
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				
				// Row number column
				String RowNumber = "@xpath=//*[@data-field='RowNumber']";
				String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='5']";
				String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='6']";
				verifyExists(RowNumber1, "1st value");
				verifyExists(RowNumber2, "1st value");
				Rowno1 = getTextFrom(RowNumber1);
				Rowno2 = getTextFrom(RowNumber2);
				sleep(2000);
				

				// Coverholder Commission % column
				String CoverholderCommissionPercentage = "@xpath=//*[@data-field='Coverholder_Commission_Percent']";
				String CoverholderCommissionPercentage1 = "@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.50 %']";
				String CoverholderCommissionPercentage2 = "@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='50.00 %']";
				waitForElementToAppear(CoverholderCommissionPercentage, 20);
				mouseOverAction(CoverholderCommissionPercentage);
				verifyMustExists(CoverholderCommissionPercentage, "Coverholder Commission % column");
				sleep(2000);
				verifyExists(CoverholderCommissionPercentage1, "1st value");
				verifyExists(CoverholderCommissionPercentage2, "2nd value");
				CCP1 = getTextFrom(CoverholderCommissionPercentage1);
				CCP2 = getTextFrom(CoverholderCommissionPercentage2);
				sleep(2000);
				
				
				
				// Brokerage % column
				String BrokeragPercentage = "@xpath=//*[@data-field='London_Brokerage_Percent']";
				String BrokeragPercentage1 = "@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='50.00 %']";
				String BrokeragPercentage2 = "@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='50.00 %']";
				DataCapture1 =	BordereauPage.RuleDataCapture(BrokeragPercentage1,"Brokerage %","0.5","50.00","Convert decimal values in percentage fields to a percentage value");
				ActualDPVCOriginal1 = DataCapture1.get(0);
				ActualDPVCChanged1 = DataCapture1.get(1);
				ActualDPVCRuleName1 = DataCapture1.get(2);
				DataCapture2 =	BordereauPage.RuleDataCapture(BrokeragPercentage2,"Brokerage %","500","50.00","Validate Percentage values");
				ActualDPVCOriginal2 = DataCapture2.get(0);
				ActualDPVCChanged2 = DataCapture2.get(1);
				ActualDPVCRuleName2 = DataCapture2.get(2);
				
				// Total Tax % column
				String TotalTaxPercentage = "@xpath=//*[@data-field='Tax_Total_Percent']";
				String TotalTaxPercentage1 = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[1]//td[contains(@ng-click,'Tax_Total_Percent')][text()='50.00 %']";
				String TotalTaxPercentage2 = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[2]//td[contains(@ng-click,'Tax_Total_Percent')][text()='50.00 %']";
				DataCapture3 =	BordereauPage.RuleDataCapture(TotalTaxPercentage1,"Total Tax %","0.5","50.00","Convert decimal values in percentage fields to a percentage value");
				ActualDPVCOriginal3 = DataCapture3.get(0);
				ActualDPVCChanged3 = DataCapture3.get(1);
				ActualDPVCRuleName3 = DataCapture3.get(2);
				verifyExists(TotalTaxPercentage2, "2nd value");
				TTP = getTextFrom(TotalTaxPercentage2);
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
