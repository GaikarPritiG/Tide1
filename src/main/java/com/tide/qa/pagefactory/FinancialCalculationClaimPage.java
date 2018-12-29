package com.tide.qa.pagefactory;

import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.http.client.ClientProtocolException;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class FinancialCalculationClaimPage extends PageBase {

	//Class objects
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	FinancialCalculationRiskAndPremiumPage FCpage= new FinancialCalculationRiskAndPremiumPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String contractId;
	public static String sheet4094Path = "";
	public static String sheet4096Path = "";
	public static String sheet4103Path = "";
	public static String sheet4104Path = "";
	public static String sheet4104SecondPath = "";
	public String ActualFRow1;
	public String ActualSRow2;
	public String FP1;
	public String FP2;
	public String FP3;
	public String FP4;
	public String FP5;
	public String FP6;
	public String FTI1;
	public String FTI2;
	public String ITI1;
	public String ITI2;
	public String TR1;
	public String TR2;
	public String TR3;
	public String TR4;
	public String TR5;
	public String TR6;
	public String TP1;
	public String TP2;
	public String TP3;
	public String TP4;
	public String TP5;
	public String TP6;
	public String TI1;
	public String TI2;
	public String ACFP1;
	public String ACFP2;
	public String ACFR1;
	public String ACFR2;
	public String DFP1;
	public String DFP2;
	public String DFR1;
	public String DFR2;
	public String EP1;
	public String EP2;
	public String ER1;
	public String ER2;
	public String FR1;
	public String FR2;
	public String FR3;
	public String FR4;
	public String FR5;
	public String FR6;
	public String IP1;
	public String IP2;
	public String IR1;
	public String IR2;
	public String FI1;
	public String FI2;
	public String IT1;
	public String IT2;
	public String TIV1;
	public String TIV2;
	public String TPV1;
	public String TPV2;
	public String TRV1;
	public String TRV2;
	public String AP1;
	public String AP2;
	public String AFR1;
	public String AFR2;
	public String FTR1;
	public String FTR2;
	public String FTR3;
	public String FTR4;
	public String FTR5;
	public String FTR6;
	
	public static final String SignedBtn = "@buttonText=Signed";
	public static final String EnrichedValue1Txt = "@xpath=//*[@id='Data0']";
	public static final String EnrichedValue2Txt = "@xpath=//*[@id='Data1']";
	public static final String PauseBtn = "@xpath=//*[contains(text(),'Pause')]";
	public static final String CancelBtn = "@xpath=//*[@ng-click='cancel()']";
	public static final String RiskInceptionDate="@xpath=//*[@data-field='RiskInceptionDate']";
	public static final String RiskExpiryDate="@xpath=//*[@data-field='RiskExpiryDate']";
	public static final String RiskInceptionDateFirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[14]";
	public static final String RiskInceptionDateSeconRow="@xpath=//*[@role='rowgroup']//tr[2]//td[14]";
	public static final String RiskExpiryDateFirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[15]";
	public static final String RiskExpiryDateSecondRow="@xpath=//*[@role='rowgroup']//tr[2]//td[15]";

	/*public static final String NetPremiumColumn ="@xpath=//*[@data-field='Net_Premium']";
	public static final String NetPremiumrow1="@xpath=//*[@role='rowgroup']//tr[1]//td[30]";
	public static final String NetPremiumrow2="@xpath=//*[@role='rowgroup']//tr[2]//td[30]";
	public static final String NetPremiumrow3="@xpath=//*[@role='rowgroup']//tr[3]//td[30]";
	*/
	//Calculate Fees Reserved
	public static final String Fees_ReserveColumn ="@xpath=//*[@data-field='Fees_Reserve']";
	public static final String Fees_Reserverow1 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";
	public static final String Fees_Reserverow2 ="@xpath=//*[@role='rowgroup']//tr[2]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";

	//Calculate Fees Paid
	public static final String Fees_PaidColumn ="@xpath=//*[@data-field='Fees_Paid']";
	public static final String Fees_Paidrow1 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";
	public static final String Fees_Paidrow2 ="@xpath=//*[@role='rowgroup']//tr[2]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";

	//Calculate Fees Total(Fees TotalIncured) -4093
	public static final String Fees_TotalIncuredColumn ="@xpath=//*[@data-field='Fees_TotalIncurred']";
	public static final String Fees_TotalIncurredrow1 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='80.00']";
	public static final String Fees_TotalIncurredrow2 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='80.00']";

	//Calculate Indemnity (Indemnity TotalIncurred) -4092
	public static final String Indemnity_TotalIncurredColumn ="@xpath=//*[@data-field='Indemnity_TotalIncurred']";
	public static final String Indemnity_TotalIncurredrow1 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='1,100.00']";
	public static final String Indemnity_TotalIncurredrow2 ="@xpath=//*[@role='rowgroup']//tr[2]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='1,100.00']";

	//Calculate Indemnity (Total Reserve) -4089
	public static final String Total_ReserveColumn ="@xpath=//*[@data-field='Total_Reserve']";
	public static final String Total_Reserverow1 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Total_Reserve')][text()='1,040.00']";
	public static final String Total_Reserverow2 ="@xpath=//*[@role='rowgroup']//tr[2]//td[contains(@ng-click,'Total_Reserve')][text()='1,040.00']";

	//Calculate Indemnity (TotalPaid) -4090
	public static final String TotalPaidColumn ="@xpath=//*[@data-field='Total_Paid']";
	public static final String TotalPaidrow1 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Total_Paid')][text()='140.00']";
	public static final String TotalPaidrow2 ="@xpath=//*[@role='rowgroup']//tr[2]//td[contains(@ng-click,'Total_Paid')][text()='140.00']";

	//Calculate Indemnity (Total Incurred) -4091
	public static final String TotalIncurredColumn ="@xpath=//*[@data-field='Total_Incurred']";
	public static final String TotalIncurredrow1 ="@xpath=//*[@role='rowgroup']//tr[1]//td[contains(@ng-click,'Total_Incurred')][text()='1,180.00']";
	public static final String TotalIncurredrow2 ="@xpath=//*[@role='rowgroup']//tr[2]//td[contains(@ng-click,'Total_Incurred')][text()='1,180.00']";

	public void CalculateFeesReserve_4094() throws Exception
	{
		String  subSheet="Automation Claim Format 2 (Lloyd's Claim Property schema)";	
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String ExpectedFirstRow ="40.00";
		String ExpectedSecondRow ="40.00";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateClaimContractwithInceptionDate2018();
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		BordereauPage.SubmitBordereaux(subSheet);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4094Path = fpath+"\\src\\test\\resources\\testdata\\Claims Financial Calculatoins January (1).xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4094Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S77959620180928.xlsx";	
		int size = 14677;
		String BordreauID = "35006c5b-0193-45b9-8c6f-30953876d214";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Claims Financial Calculatoins January (1).xlsx\",\"UniqueFileName\":\"S75481220180429.xlsx\",\"BordereauFormatId\":\"35006c5b-0193-45b9-8c6f-30953876d214\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S75481220180429.xlsx\",\"Filesize\":14677,\"Path\":null,\"size\":14677,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauPage.refreshUploadedFile();

		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATAClaimTab();
			mouseOverAction(Fees_ReserveColumn);
			verifyExists(Fees_ReserveColumn,"Fees(Reserve) column");
			mouseOverAction(Fees_Reserverow1);
			verifyExists(Fees_Reserverow1,"Fees(Reserve) column first row"); 
			String ActualFirstRow1 = getTextFrom(Fees_Reserverow1);
			ActualFRow1 = getTextFrom(Fees_Reserverow1);
			Report.LogInfo("Fees(Reserve) column first row", ActualFRow1, "PASS");
			sleep(2000);
			if(ActualFirstRow1.equals(ExpectedFirstRow))
			{
				Report.LogInfo("ValidateFirstRow", "First Row validate successfully", "PASS");	
			}
			else
			{
				Report.LogInfo("ValidateFirstRow", "First Row not validate successfully", "Fail");
			}

			verifyExists(Fees_Reserverow2,"Fees(Reserve) Second row"); 
			String ActualFirstRow2 = getTextFrom(Fees_Reserverow2);
			ActualSRow2 = getTextFrom(Fees_Reserverow2);
			Report.LogInfo("Fees(Reserve) Second row", ActualSRow2, "PASS");
			sleep(2000);
			if(ActualFirstRow2.equals(ExpectedSecondRow))
			{
				Report.LogInfo("ValidateSeondRow", "Second Row validate successfully", "PASS");	
			}
			else
			{
				Report.LogInfo("ValidateSecondRow", "second Row not validate successfully", "Fail");
			}

		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			//	BordereauPage.deleteBorderEAUX();
		}			

	}

	public void CalculateFeesPaid_4095() throws Exception
	{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
		verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		BordereauPage.navigateOnProcessingTab();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATAClaimTab();

			String ExpectedPaidFirstRow ="40.00";
			String ExpectedPaidSecondRow ="40.00";
			mouseOverAction(Fees_PaidColumn);
			verifyMustExists(Fees_PaidColumn,"Fees(Paid) column");
			verifyExists(Fees_Paidrow1,"Fees paid first row");
			FP1 = getTextFrom(Fees_Paidrow1);
			Report.LogInfo("Fees paid first row", FP1, "PASS");
			verifyExists(Fees_Paidrow2,"Fees paid Second row");
			FP2 = getTextFrom(Fees_Paidrow2);
			Report.LogInfo("Fees paid Second row", FP2, "PASS");
		
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			//	BordereauPage.deleteBorderEAUX();
		}			
	}
	public void CalculateFees_TotalIncurred_4093() throws Exception
	{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
		verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		BordereauPage.navigateOnProcessingTab();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATAClaimTab();

			String ExpectedPaidFirstRow ="80.00";
			String ExpectedPaidSecondRow ="80.00";
			mouseOverAction(Fees_TotalIncuredColumn);
			verifyMustExists(Fees_TotalIncuredColumn,"Total Incurred column");
			verifyExists(Fees_TotalIncurredrow1,"Fees Total Incurredrow1 first row");
			FTI1 = getTextFrom(Fees_TotalIncurredrow1);
			Report.LogInfo("Fees Total Incurredrow1 first row", FTI1, "PASS");
			verifyExists(Fees_TotalIncurredrow2,"Fees Total Incurredrow1 Second row");
			FTI2 = getTextFrom(Fees_TotalIncurredrow2);
			Report.LogInfo("Fees Total Incurredrow1 Second row", FTI2, "PASS");

		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			//	BordereauPage.deleteBorderEAUX();
		}	
	}
	public void Indemnity_TotalIncurred_4092() throws Exception
	{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
		verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		BordereauPage.navigateOnProcessingTab();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATAClaimTab();

			String ExpectedPaidFirstRow ="1,100.00";
			String ExpectedPaidSecondRow ="1,100.00";
			mouseOverAction(Indemnity_TotalIncurredColumn);
			verifyMustExists(Indemnity_TotalIncurredColumn,"Indemnity - Total Incurred column");
			
			verifyExists(Indemnity_TotalIncurredrow1,"Fees Total Incurredrow1 first row");
			ITI1 = getTextFrom(Indemnity_TotalIncurredrow1);
			Report.LogInfo("Fees Total Incurredrow1 first row", ITI1, "PASS");
			verifyExists(Indemnity_TotalIncurredrow2,"Fees Total Incurredrow1 Second row");
			ITI2 = getTextFrom(Indemnity_TotalIncurredrow2);
			Report.LogInfo("Fees Total Incurredrow1 Second row", ITI2, "PASS");
			
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			//	BordereauPage.deleteBorderEAUX();
		}

	}
	public void  CalculateTotal_Reserve_4089() throws Exception
	{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
		verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		BordereauPage.navigateOnProcessingTab();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATAClaimTab();

			String ExpectedPaidFirstRow ="1,040.00";
			String ExpectedPaidSecondRow ="1,040.00";
			mouseOverAction(Total_ReserveColumn);
			verifyMustExists(Total_ReserveColumn," Total Reserve column");
			verifyExists(Total_Reserverow1,"Total reserve first row");
			TR1 = getTextFrom(Total_Reserverow1);
			Report.LogInfo("Total reserve first row", TR1, "PASS");
			verifyExists(Total_Reserverow2,"Total reserve Second row");
			TR2 = getTextFrom(Total_Reserverow2);
			Report.LogInfo("Total reserve Second row", TR2, "PASS");
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			//	BordereauPage.deleteBorderEAUX();
		}

	}
	public void  CalculateTotal_Paid_4090() throws Exception
	{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
		verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		BordereauPage.navigateOnProcessingTab();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATAClaimTab();

			String ExpectedPaidFirstRow ="140.00";
			String ExpectedPaidSecondRow ="140.00";
			mouseOverAction(TotalPaidColumn);
			verifyMustExists(TotalPaidColumn," Total Paid column");
			verifyExists(TotalPaidrow1,"Total Paid first row");
			TP1 = getTextFrom(TotalPaidrow1);
			Report.LogInfo("Total Paid first row", TP1, "PASS");
			verifyExists(TotalPaidrow2,"Total Paid Second row");
			TP2 = getTextFrom(TotalPaidrow2);
			Report.LogInfo("Total Paid Second row", TP2, "PASS");
			
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			//	BordereauPage.deleteBorderEAUX();
		}

	}
	public void  CalculateTotal_Incurred_4091() throws Exception
	{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
		verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
		BordereauPage.navigateOnProcessingTab();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATAClaimTab();

			String ExpectedPaidFirstRow ="1,180.00";
			String ExpectedPaidSecondRow ="1,180.00";
			mouseOverAction(TotalIncurredColumn);
			verifyMustExists(TotalIncurredColumn," Total Incurred column");
			verifyExists(TotalIncurredrow1,"Total Incurred column first row");
			TI1 = getTextFrom(TotalIncurredrow1);
			Report.LogInfo("Total Incurred column first row", TI1, "PASS");
			verifyExists(TotalIncurredrow2,"Total Incurred column second row");
			TI2 = getTextFrom(TotalIncurredrow2);
			Report.LogInfo("Total Incurred column second row", TI2, "PASS");
			
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status Not displayed.", "Fail");
			BordereauPage.deleteBorderEAUX();
		}

	}


	public void positiveToNegative_4096() throws Exception
	{
		String subSheet="Automation Claim Format 3 (Lloyd's Claim Property schema)";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);	
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4096Path = fpath+"\\src\\test\\resources\\testdata\\Claims Financial Calculatoins January_TC4096.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4096Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			String Ufname = "S63076720180928.xlsx";	
			int size = 14671;
			String BordreauID = "cf44b1bf-a3b7-4688-83ef-933e88963644";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			// payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Claims Financial Calculatoins January_TC4096.xlsx\",\"UniqueFileName\":\"S75976920180429.xlsx\",\"BordereauFormatId\":\"cf44b1bf-a3b7-4688-83ef-933e88963644\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S75976920180429.xlsx\",\"Filesize\":14671,\"Path\":null,\"size\":14671,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATAClaimTab();
				//AttorneyCoverageFees_Paid
				String AttorneyCoverageFees_Paidcolumn ="@xpath=//*[@data-field='AttorneyCoverageFees_Paid']";
				String AttorneyCoverageFees_Paid1="@xpath=//*[@data-field='AttorneyCoverageFees_Paid']//following::tr[1]//td[contains(@ng-click,'AttorneyCoverageFees_Paid')][text()='10.00']";
				String AttorneyCoverageFees_Paid2="@xpath=//*[@data-field='AttorneyCoverageFees_Paid']//following::tr[2]//td[contains(@ng-click,'AttorneyCoverageFees_Paid')][text()='-10.00']";			
				waitForElementToAppear(AttorneyCoverageFees_Paidcolumn,20);
				mouseOverAction(AttorneyCoverageFees_Paidcolumn);
				verifyMustExists(AttorneyCoverageFees_Paidcolumn,"AttorneyCoverageFees_Paid Column");
				sleep(2000);
				verifyExists(AttorneyCoverageFees_Paid1,"1st value");
				ACFP1 =  getTextFrom(AttorneyCoverageFees_Paid1);	
				Report.LogInfo("AttorneyCoverageFees_Paid1 1st value", ACFP1, "PASS");	
				verifyExists(AttorneyCoverageFees_Paid2,"2nd value");
				ACFP2 =  getTextFrom(AttorneyCoverageFees_Paid2);	
				Report.LogInfo("AttorneyCoverageFees_Paid2 2nd value", ACFP2, "PASS");	
				sleep(2000);
				//AttorneyCoverageFees_Reserve
				String AttorneyCoverageFees_Reservecolumn ="@xpath=//*[@data-field='AttorneyCoverageFees_Reserve']";
				String AttorneyCoverageFees_Reserve1="@xpath=//*[@data-field='AttorneyCoverageFees_Reserve']//following::tr[1]//td[contains(@ng-click,'AttorneyCoverageFees_Reserve')][text()='10.00']";
				String AttorneyCoverageFees_Reserve2="@xpath=//*[@data-field='AttorneyCoverageFees_Reserve']//following::tr[2]//td[contains(@ng-click,'AttorneyCoverageFees_Reserve')][text()='-10.00']";
				waitForElementToAppear(AttorneyCoverageFees_Reservecolumn,20);
				mouseOverAction(AttorneyCoverageFees_Reservecolumn);
				verifyMustExists(AttorneyCoverageFees_Reservecolumn,"AttorneyCoverageFees_Reserve Column");
				sleep(2000);
				verifyExists(AttorneyCoverageFees_Reserve1,"1st value");
				ACFR1 =  getTextFrom(AttorneyCoverageFees_Reserve1);	
				Report.LogInfo("AttorneyCoverageFees_Reserve1 1st value", ACFR1, "PASS");
				verifyExists(AttorneyCoverageFees_Reserve2,"2nd value");
				ACFR2 =  getTextFrom(AttorneyCoverageFees_Reserve2);	
				Report.LogInfo("AttorneyCoverageFees_Reserve2 2nd value", ACFR2, "PASS");
				sleep(2000);
				//DefenceFees_Paid
				String DefenceFees_Paidcolumn ="@xpath=//*[@data-field='DefenceFees_Paid']";
				String DefenceFees_Paid1="@xpath=//*[@data-field='DefenceFees_Paid']//following::tr[1]//td[contains(@ng-click,'DefenceFees_Paid')][text()='10.00']";
				String DefenceFees_Paid2="@xpath=//*[@data-field='DefenceFees_Paid']//following::tr[2]//td[contains(@ng-click,'DefenceFees_Paid')][text()='-10.00']";
				waitForElementToAppear(DefenceFees_Paidcolumn,20);
				mouseOverAction(DefenceFees_Paidcolumn);
				verifyMustExists(DefenceFees_Paidcolumn,"DefenceFees_Paid Column");
				sleep(2000);
				verifyExists(DefenceFees_Paid1,"1st value");
				DFP1 =  getTextFrom(DefenceFees_Paid1);	
				Report.LogInfo("DefenceFees_Paid1 1st value", DFP1, "PASS");
				verifyExists(DefenceFees_Paid2,"2nd value");
				DFP2 =  getTextFrom(DefenceFees_Paid2);	
				Report.LogInfo("DefenceFees_Paid1 2nd value", DFP2, "PASS");
				sleep(2000);
				//DefenceFees_Reserve
				String DefenceFees_Reservecolumn ="@xpath=//*[@data-field='DefenceFees_Reserve']";
				String DefenceFees_Reserve1="@xpath=//*[@data-field='DefenceFees_Reserve']//following::tr[1]//td[contains(@ng-click,'DefenceFees_Reserve')][text()='10.00']";
				String DefenceFees_Reserve2="@xpath=//*[@data-field='DefenceFees_Reserve']//following::tr[2]//td[contains(@ng-click,'DefenceFees_Reserve')][text()='-10.00']";
				waitForElementToAppear(DefenceFees_Reservecolumn,20);
				mouseOverAction(DefenceFees_Reservecolumn);
				verifyMustExists(DefenceFees_Reservecolumn,"DefenceFees_Reserve Column");
				sleep(2000);
				verifyExists(DefenceFees_Reserve1,"1st value");
				DFR1 =  getTextFrom(DefenceFees_Reserve1);	
				Report.LogInfo("DefenceFees_Reserve1 1st value", DFR1, "PASS");
				verifyExists(DefenceFees_Reserve2,"2nd value");
				DFR2 =  getTextFrom(DefenceFees_Reserve2);	
				Report.LogInfo("DefenceFees_Reserve2 2nd value", DFR2, "PASS");
				sleep(2000);
				//Expenses_Paid
				String Expenses_Paidcolumn ="@xpath=//*[@data-field='Expenses_Paid']";
				String Expenses_Paid1="@xpath=//*[@data-field='Expenses_Paid']//following::tr[1]//td[contains(@ng-click,'Expenses_Paid')][text()='10.00']";
				String Expenses_Paid2="@xpath=//*[@data-field='Expenses_Paid']//following::tr[2]//td[contains(@ng-click,'Expenses_Paid')][text()='-10.00']";
				waitForElementToAppear(Expenses_Paidcolumn,20);
				mouseOverAction(Expenses_Paidcolumn);
				verifyMustExists(Expenses_Paidcolumn,"Expenses_Paid Column");
				sleep(2000);
				verifyExists(Expenses_Paid1,"1st value");
				EP1 =  getTextFrom(Expenses_Paid1);	
				Report.LogInfo("Expenses_Paid2 1st value", EP1, "PASS");
				verifyExists(Expenses_Paid2,"2nd value");
				EP2 =  getTextFrom(Expenses_Paid2);	
				Report.LogInfo("Expenses_Paid2 2nd value", EP2, "PASS");
				sleep(2000);
				//Expenses_Reserve
				String Expenses_Reservecolumn ="@xpath=//*[@data-field='Expenses_Reserve']";
				String Expenses_Reserve1="@xpath=//*[@data-field='Expenses_Reserve']//following::tr[1]//td[contains(@ng-click,'Expenses_Reserve')][text()='10.00']";
				String Expenses_Reserve2="@xpath=//*[@data-field='Expenses_Reserve']//following::tr[2]//td[contains(@ng-click,'Expenses_Reserve')][text()='-10.00']";
				waitForElementToAppear(Expenses_Reservecolumn,20);
				mouseOverAction(Expenses_Reservecolumn);
				verifyMustExists(Expenses_Reservecolumn,"Expenses_Reserve Column");
				sleep(2000);
				verifyExists(Expenses_Reserve1,"1st value");
				ER1 =  getTextFrom(Expenses_Reserve1);	
				Report.LogInfo("Expenses_Reserve1 1st value", ER1, "PASS");
				verifyExists(Expenses_Reserve2,"2nd value");
				ER2 =  getTextFrom(Expenses_Reserve2);	
				Report.LogInfo("Expenses_Reserve1 2nd value", ER2, "PASS");
				sleep(2000);
				//Fees_Paid
				String Fees_Paidcolumn ="@xpath=//*[@data-field='Fees_Paid']";
				String Fees_Paid1="@xpath=//*[@data-field='Fees_Paid']//following::tr[1]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";
				String Fees_Paid2="@xpath=//*[@data-field='Fees_Paid']//following::tr[2]//td[contains(@ng-click,'Fees_Paid')][text()='-40.00']";
				waitForElementToAppear(Fees_Paidcolumn,5);
				mouseOverAction(Fees_Paidcolumn);
				verifyMustExists(Fees_Paidcolumn,"Fees_Paid Column");
				sleep(2000);
				verifyExists(Fees_Paid1,"1st value");
				verifyExists(Fees_Paid2,"2nd value");
				sleep(2000);
				//Fees_Reserve
				String Fees_Reservecolumn ="@xpath=//*[@data-field='Fees_Reserve']";
				String Fees_Reserve1="@xpath=//*[@data-field='Fees_Reserve']//following::tr[1]//td[contains(@ng-click,'Fees_Reserve')][text()='40.00']";
				String Fees_Reserve2="@xpath=//*[@data-field='Fees_Reserve']//following::tr[2]//td[contains(@ng-click,'Fees_Reserve')][text()='-40.00']";
				waitForElementToAppear(Fees_Reservecolumn,5);
				mouseOverAction(Fees_Reservecolumn);
				verifyMustExists(Fees_Reservecolumn,"Fees_Reserve Column");
				sleep(2000);
				verifyExists(Fees_Reserve1,"1st value");
				FR1 =  getTextFrom(Fees_Reserve1);	
				Report.LogInfo("Expenses_Reserve1 1st value", FR1, "PASS");
				verifyExists(Fees_Reserve2,"2nd value");
				FR2 =  getTextFrom(Fees_Reserve2);	
				Report.LogInfo("Expenses_Reserve1 1st value", FR2, "PASS");
				sleep(2000);
				//Indemnity_Paid
				String Indemnity_Paidcolumn ="@xpath=//*[@data-field='Indemnity_Paid']";
				String Indemnity_Paid1="@xpath=//*[@data-field='Indemnity_Paid']//following::tr[1]//td[contains(@ng-click,'Indemnity_Paid')][text()='100.00']";
				String Indemnity_Paid2="@xpath=//*[@data-field='Indemnity_Paid']//following::tr[2]//td[contains(@ng-click,'Indemnity_Paid')][text()='-100.00']";
				waitForElementToAppear(Indemnity_Paidcolumn,5);
				mouseOverAction(Indemnity_Paidcolumn);
				verifyMustExists(Indemnity_Paidcolumn,"Indemnity_Paid Column");
				sleep(2000);
				verifyExists(Indemnity_Paid1,"1st value");
				IP1 =  getTextFrom(Indemnity_Paid1);	
				Report.LogInfo("Indemnity_Paid1 1st value", IP1, "PASS");
				verifyExists(Indemnity_Paid2,"2nd value");
				IP2 =  getTextFrom(Indemnity_Paid2);	
				Report.LogInfo("Indemnity_Paid2 2nd value", IP2, "PASS");
				sleep(2000);
				//Indemnity_Reserve
				String Indemnity_Reservecolumn ="@xpath=//*[@data-field='Indemnity_Reserve']";
				String Indemnity_Reserve1="@xpath=//*[@data-field='Indemnity_Reserve']//following::tr[1]//td[contains(@ng-click,'Indemnity_Reserve')][text()='1,000.00']";
				String Indemnity_Reserve2="@xpath=//*[@data-field='Indemnity_Reserve']//following::tr[2]//td[contains(@ng-click,'Indemnity_Reserve')][text()='-1,000.00']";
				waitForElementToAppear(Indemnity_Reservecolumn,5);
				mouseOverAction(Indemnity_Reservecolumn);
				verifyMustExists(Indemnity_Reservecolumn,"Indemnity_Reserve Column");
				sleep(2000);
				verifyExists(Indemnity_Reserve1,"1st value");
				IR1 =  getTextFrom(Indemnity_Reserve1);	
				Report.LogInfo("Indemnity_Reserve1 1st value", IR1, "PASS");
				verifyExists(Indemnity_Reserve2,"2nd value");
				IR2 =  getTextFrom(Indemnity_Reserve2);	
				Report.LogInfo("Indemnity_Reserve2 2nd value", IR2, "PASS");
				sleep(2000);
				//Fees_TotalIncurred
				String Fees_TotalIncurredcolumn ="@xpath=//*[@data-field='Fees_TotalIncurred']";
				String Fees_TotalIncurred1="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[1]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='80.00']";
				String Fees_TotalIncurred2="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[2]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='-80.00']";
				waitForElementToAppear(Fees_TotalIncurredcolumn,5);
				mouseOverAction(Fees_TotalIncurredcolumn);
				verifyMustExists(Fees_TotalIncurredcolumn,"Fees_TotalIncurred Column");
				sleep(2000);
				verifyExists(Fees_TotalIncurred1,"1st value");
				FI1 =  getTextFrom(Fees_TotalIncurred1);	
				Report.LogInfo("Fees_TotalIncurred1 1st value", FI1, "PASS");
				verifyExists(Fees_TotalIncurred2,"2nd value");
				FI2 =  getTextFrom(Fees_TotalIncurred2);	
				Report.LogInfo("Fees_TotalIncurred2 2nd value", FI2, "PASS");
				sleep(2000);
				//Indemnity_TotalIncurred
				String Indemnity_TotalIncurredcolumn ="@xpath=//*[@data-field='Indemnity_TotalIncurred']";
				String Indemnity_TotalIncurred1="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[1]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='1,100.00']";
				String Indemnity_TotalIncurred2="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[2]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='-1,100.00']";			 waitForElementToAppear(Indemnity_TotalIncurredcolumn,20);
				mouseOverAction(Indemnity_TotalIncurredcolumn);
				verifyMustExists(Indemnity_TotalIncurredcolumn,"Indemnity_TotalIncurred Column");
				sleep(2000);
				verifyExists(Indemnity_TotalIncurred1,"1st value");
				IT1 =  getTextFrom(Indemnity_TotalIncurred1);	
				Report.LogInfo("Indemnity_TotalIncurred1 1st value", IT1, "PASS");
				verifyExists(Indemnity_TotalIncurred2,"2nd value");
				IT2 =  getTextFrom(Indemnity_TotalIncurred2);	
				Report.LogInfo("Indemnity_TotalIncurred2 2nd value", IT2, "PASS");
				sleep(2000);
				//Total_Incurred
				String Total_Incurredcolumn ="@xpath=//*[@data-field='Total_Incurred']";
				String Total_Incurred1="@xpath=//*[@data-field='Total_Incurred']//following::tr[1]//td[contains(@ng-click,'Total_Incurred')][text()='1,180.00']";
				String Total_Incurred2="@xpath=//*[@data-field='Total_Incurred']//following::tr[2]//td[contains(@ng-click,'Total_Incurred')][text()='-1,180.00']";
				waitForElementToAppear(Total_Incurredcolumn,5);
				mouseOverAction(Total_Incurredcolumn);
				verifyMustExists(Total_Incurredcolumn,"Total_Incurred Column");
				sleep(2000);
				verifyExists(Total_Incurred1,"1st value");
				TIV1 =  getTextFrom(Total_Incurred1);	
				Report.LogInfo("Total_Incurred1 1st value", TIV1, "PASS");
				verifyExists(Total_Incurred2,"2nd value");
				TIV2 =  getTextFrom(Total_Incurred2);	
				Report.LogInfo("Total_Incurred2 1st value", TIV2, "PASS");
				sleep(2000);
				//Total_Paid
				String Total_Paidcolumn ="@xpath=//*[@data-field='Total_Paid']";
				String Total_Paid1="@xpath=//*[@data-field='Total_Paid']//following::tr[1]//td[contains(@ng-click,'Total_Paid')][text()='140.00']";
				String Total_Paid2="@xpath=//*[@data-field='Total_Paid']//following::tr[2]//td[contains(@ng-click,'Total_Paid')][text()='-140.00']";
				waitForElementToAppear(Total_Paidcolumn,5);
				mouseOverAction(Total_Paidcolumn);
				verifyMustExists(Total_Paidcolumn,"Total_Paid Column");
				sleep(2000);
				verifyExists(Total_Paid1,"1st value");
				TPV1 =  getTextFrom(Total_Paid1);	
				Report.LogInfo("Total_Paid1 1st value", TPV1, "PASS");
				verifyExists(Total_Paid2,"2nd value");
				TPV2 =  getTextFrom(Total_Paid2);	
				Report.LogInfo("Total_Paid2 2nd value", TPV2, "PASS");
				sleep(2000);
				//Total_Reserve
				String Total_Reservecolumn ="@xpath=//*[@data-field='Total_Reserve']";
				String Total_Reserve1="@xpath=//*[@data-field='Total_Reserve']//following::tr[1]//td[contains(@ng-click,'Total_Reserve')][text()='1,040.00']";
				String Total_Reserve2="@xpath=//*[@data-field='Total_Reserve']//following::tr[2]//td[contains(@ng-click,'Total_Reserve')][text()='-1,040.00']";
				waitForElementToAppear(Total_Reservecolumn,5);
				mouseOverAction(Total_Reservecolumn);
				verifyMustExists(Total_Reservecolumn,"Total_Reserve Column");
				sleep(2000);
				verifyExists(Total_Reserve1,"1st value");
				TRV1 =  getTextFrom(Total_Reserve1);	
				Report.LogInfo("Total_Reserve1 1st value", TRV1, "PASS");
				verifyExists(Total_Reserve2,"2nd value");
				TRV2 =  getTextFrom(Total_Reserve2);	
				Report.LogInfo("Total_Reserve2 2nd value", TRV2, "PASS");
				sleep(2000);
				//AdjustersFees_Paid
				String AdjustersFees_Paidcolumn ="@xpath=//*[@data-field='AdjustersFees_Paid']";
				String AdjustersFees_Paid1="@xpath=//*[@data-field='AdjustersFees_Paid']//following::tr[1]//td[contains(@ng-click,'AdjustersFees_Paid')][text()='10.00']";
				String AdjustersFees_Paid2="@xpath=//*[@data-field='AdjustersFees_Paid']//following::tr[2]//td[contains(@ng-click,'AdjustersFees_Paid')][text()='-10.00']";
				waitForElementToAppear(AdjustersFees_Paidcolumn,5);
				mouseOverAction(AdjustersFees_Paidcolumn);
				verifyMustExists(AdjustersFees_Paidcolumn,"AdjustersFees_Paid Column");
				sleep(2000);
				verifyExists(AdjustersFees_Paid1,"1st value");
				AP1 =  getTextFrom(AdjustersFees_Paid1);	
				Report.LogInfo("AdjustersFees_Paid1 1st value", AP1, "PASS");
				verifyExists(AdjustersFees_Paid2,"2nd value");
				AP2 =  getTextFrom(AdjustersFees_Paid2);	
				Report.LogInfo("AdjustersFees_Paid2 2nd value", AP2, "PASS");
				sleep(2000);
				//AdjustersFees_Reserve
				String AdjustersFees_Reservecolumn ="@xpath=//*[@data-field='AdjustersFees_Reserve']";
				String AdjustersFees_Reserve1="@xpath=//*[@data-field='AdjustersFees_Reserve']//following::tr[1]//td[contains(@ng-click,'AdjustersFees_Reserve')][text()='10.00']";
				String AdjustersFees_Reserve2="@xpath=//*[@data-field='AdjustersFees_Reserve']//following::tr[2]//td[contains(@ng-click,'AdjustersFees_Reserve')][text()='-10.00']";
				waitForElementToAppear(AdjustersFees_Reservecolumn,5);
				mouseOverAction(AdjustersFees_Reservecolumn);
				verifyMustExists(AdjustersFees_Reservecolumn,"AdjustersFees_Reserve Column");
				sleep(2000);
				verifyExists(AdjustersFees_Reserve1,"1st value");
				AFR1 =  getTextFrom(AdjustersFees_Reserve1);	
				Report.LogInfo("AdjustersFees_Reserve1 1st value", AFR1, "PASS");
				verifyExists(AdjustersFees_Reserve2,"2nd value");
				AFR2 =  getTextFrom(AdjustersFees_Reserve2);	
				Report.LogInfo("AdjustersFees_Reserve2 2nd value", AFR2, "PASS");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				BordereauPage.refreshUploadedFile();
				if(isVisible(BordereauPage.ReviewBtn)==true) {
					AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);	
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
					BordereauPage. deleteBorderEAUX(); 
		}else
			{
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
			}
				//deleteBorderEAUX();

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}
		else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}	
	}


	public void claimsFinancials_4103() throws Exception
	{
		String  subSheet="Automation Claim Format 3 (Lloyd's Claim Property schema)";
		String DateMonth = "February 2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		sleep(3000);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4094Path = fpath+"\\src\\test\\resources\\testdata\\Claims Financial Calculatoins January (1).xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4094Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			String Ufname = "S23044120180928.xlsx";	
			int size = 14677;
			String BordreauID = "cf44b1bf-a3b7-4688-83ef-933e88963644";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
	        addAsDraft(payload,DraftUrl);
			
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Claims Financial Calculatoins January (1).xlsx\",\"UniqueFileName\":\"S56626220180429.xlsx\",\"BordereauFormatId\":\"cf44b1bf-a3b7-4688-83ef-933e88963644\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56626220180429.xlsx\",\"Filesize\":14677,\"Path\":null,\"size\":14677,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
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
				BordereauPage.refreshUploadedFileForApproved();
				if(isVisible(BordereauPage.Approvedbtn)==true)
				{
					AssertBordereauStatusApproved =  getTextFrom(BordereauPage.Approvedbtn);	
					Report.LogInfo("APPROVED Status", AssertBordereauStatusApproved, "PASS");
					BordereauPage.SubmitBordereauxWithYesnoButtons(DateMonth);
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4103Path = fpath+"\\src\\test\\resources\\testdata\\Claims Financial Calculations February_TC_4103.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile1 = new File(sheet4103Path);  
					
					String Ufname1 = "S61440820180928.xlsx";	
					int size1 = 11436;
					String BordreauID1 = "cf44b1bf-a3b7-4688-83ef-933e88963644";
			        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
			        String ID1 = extractIDFromResponseinsideContract(response1); 
			        String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 2 , "3", 2018);
			        addAsDraft(payload2,DraftUrl);
			        
					//String payload2="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Claims Financial Calculations February_TC_4103.xlsx\",\"UniqueFileName\":\"S49145820180523.xlsx\",\"BordereauFormatId\":\"cf44b1bf-a3b7-4688-83ef-933e88963644\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S49145820180523.xlsx\",\"Filesize\":11436,\"Path\":null,\"size\":11436,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
					BordereauPage.refreshUploadedFile();
					if(isVisible(BordereauPage.ReviewBtn)== true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						BordereauPage.openDATALink();
						BordereauPage.navigateToDATAClaimTab();
						FCpage.offOnlycurrentIcon();
						//Fees_Paid
						String Fees_Paidcolumn ="@xpath=//*[@data-field='Fees_Paid']";
						String Fees_Paid1="@xpath=//*[@data-field='Fees_Paid']//following::tr[1]//td[contains(@ng-click,'Fees_Paid')][text()='-40.00']";
						String Fees_Paid2="@xpath=//*[@data-field='Fees_Paid']//following::tr[2]//td[contains(@ng-click,'Fees_Paid')][text()='-40.00']";
						String Fees_Paid3="@xpath=//*[@data-field='Fees_Paid']//following::tr[3]//td[contains(@ng-click,'Fees_Paid')][text()='-80.00']";
						String Fees_Paid4="@xpath=//*[@data-field='Fees_Paid']//following::tr[4]//td[contains(@ng-click,'Fees_Paid')][text()='-40.00']";
						String Fees_Paid5="@xpath=//*[@data-field='Fees_Paid']//following::tr[5]//td[contains(@ng-click,'Fees_Paid')][text()='-40.00']";
						String Fees_Paid6="@xpath=//*[@data-field='Fees_Paid']//following::tr[6]//td[contains(@ng-click,'Fees_Paid')][text()='-80.00']";
						waitForElementToAppear(Fees_Paidcolumn,5);
						mouseOverAction(Fees_Paidcolumn);
						verifyMustExists(Fees_Paidcolumn,"Fees_Paid Column");
						sleep(2000);
						verifyExists(Fees_Paid1,"1st value");
						FP1 =  getTextFrom(Fees_Paid1);	
						Report.LogInfo("Fees_Paid1 1st value", FP1, "PASS");
						verifyExists(Fees_Paid2,"2nd value");
						FP2 =  getTextFrom(Fees_Paid2);	
						Report.LogInfo("Fees_Paid2 2nd value", FP2, "PASS");
						verifyExists(Fees_Paid3,"3rd value");
						FP3 =  getTextFrom(Fees_Paid3);	
						Report.LogInfo("Fees_Paid3 3rd value", FP3, "PASS");
						verifyExists(Fees_Paid4,"4th value");
						FP4 =  getTextFrom(Fees_Paid4);	
						Report.LogInfo("Fees_Paid4 4th value", FP4, "PASS");
						verifyExists(Fees_Paid5,"5th value");
						FP5 =  getTextFrom(Fees_Paid5);	
						Report.LogInfo("Fees_Paid5 5th value", FP5, "PASS");
						verifyExists(Fees_Paid6,"6st value");
						FP6 =  getTextFrom(Fees_Paid6);	
						Report.LogInfo("Fees_Paid6 6st value", FP6, "PASS");
						sleep(2000);
						//Fees_Reserve
						String Fees_Reservecolumn ="@xpath=//*[@data-field='Fees_Reserve']";
						String Fees_Reserve1="@xpath=//*[@data-field='Fees_Reserve']//following::tr[1]//td[contains(@ng-click,'Fees_Reserve')][text()='-40.00']";
						String Fees_Reserve2="@xpath=//*[@data-field='Fees_Reserve']//following::tr[2]//td[contains(@ng-click,'Fees_Reserve')][text()='-40.00']";
						String Fees_Reserve3="@xpath=//*[@data-field='Fees_Reserve']//following::tr[3]//td[contains(@ng-click,'Fees_Reserve')][text()='-80.00']";
						String Fees_Reserve4="@xpath=//*[@data-field='Fees_Reserve']//following::tr[4]//td[contains(@ng-click,'Fees_Reserve')][text()='-40.00']";
						String Fees_Reserve5="@xpath=//*[@data-field='Fees_Reserve']//following::tr[5]//td[contains(@ng-click,'Fees_Reserve')][text()='-40.00']";
						String Fees_Reserve6="@xpath=//*[@data-field='Fees_Reserve']//following::tr[6]//td[contains(@ng-click,'Fees_Reserve')][text()='-80.00']";
						waitForElementToAppear(Fees_Reservecolumn,5);
						mouseOverAction(Fees_Reservecolumn);
						verifyMustExists(Fees_Reservecolumn,"Fees_Reserve Column");
						sleep(2000);
						verifyExists(Fees_Reserve1,"1st value");
						FR1 =  getTextFrom(Fees_Reserve1);	
						Report.LogInfo("Fees_Reserve1 1st value", FR1, "PASS");
						verifyExists(Fees_Reserve2,"2nd value");
						FR2 =  getTextFrom(Fees_Reserve2);	
						Report.LogInfo("Fees_Reserve2 2nd value", FR2, "PASS");
						verifyExists(Fees_Reserve3,"3rd value");
						FR3 =  getTextFrom(Fees_Reserve3);	
						Report.LogInfo("Fees_Reserve3 13rdst value", FR3, "PASS");
						verifyExists(Fees_Reserve4,"4th value");
						FR4 =  getTextFrom(Fees_Reserve4);	
						Report.LogInfo("Fees_Reserve4 4th value", FR4, "PASS");
						verifyExists(Fees_Reserve5,"5th value");
						FR5 =  getTextFrom(Fees_Reserve5);	
						Report.LogInfo("Fees_Reserve5 5th value", FR5, "PASS");
						verifyExists(Fees_Reserve6,"6st value");
						FR6 =  getTextFrom(Fees_Reserve6);	
						Report.LogInfo("Fees_Reserve6 6st value", FR6, "PASS");
						sleep(2000);
						//Fees_TotalIncurred
						String Fees_TotalIncurredcolumn ="@xpath=//*[@data-field='Fees_TotalIncurred']";
						String Fees_TotalIncurred1="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[1]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='-80.00']";
						String Fees_TotalIncurred2="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[2]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='-80.00']";
						String Fees_TotalIncurred3="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[3]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='-160.00']";
						String Fees_TotalIncurred4="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[4]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='-80.00']";
						String Fees_TotalIncurred5="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[5]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='-80.00']";
						String Fees_TotalIncurred6="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[6]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='-160.00']";
						waitForElementToAppear(Fees_TotalIncurredcolumn,20);
						mouseOverAction(Fees_TotalIncurredcolumn);
						verifyMustExists(Fees_TotalIncurredcolumn,"Fees_TotalIncurred Column");
						sleep(2000);
						verifyExists(Fees_TotalIncurred1,"1st value");
						FTR1 =  getTextFrom(Fees_TotalIncurred1);	
						Report.LogInfo("Fees_TotalIncurred1 1st value", FTR1, "PASS");
						verifyExists(Fees_TotalIncurred2,"2nd value");
						FTR2 =  getTextFrom(Fees_TotalIncurred2);	
						Report.LogInfo("Fees_TotalIncurred2 2nd value", FTR2, "PASS");
						verifyExists(Fees_TotalIncurred3,"3rd value");
						FTR3 =  getTextFrom(Fees_TotalIncurred3);	
						Report.LogInfo("Fees_TotalIncurred3 3rd value", FTR3, "PASS");
						verifyExists(Fees_TotalIncurred4,"4th value");
						FTR4 =  getTextFrom(Fees_TotalIncurred4);	
						Report.LogInfo("Fees_TotalIncurred4 4th value", FTR4, "PASS");
						verifyExists(Fees_TotalIncurred5,"5th value");
						FTR5 =  getTextFrom(Fees_TotalIncurred5);	
						Report.LogInfo("Fees_TotalIncurred5 5th value", FTR5, "PASS");
						verifyExists(Fees_TotalIncurred6,"6st value");
						FTR6 =  getTextFrom(Fees_TotalIncurred6);	
						Report.LogInfo("Fees_TotalIncurred6 6st value", FTR6, "PASS");
						sleep(2000);
						//Indemnity_TotalIncurred
						String Indemnity_TotalIncurredcolumn ="@xpath=//*[@data-field='Indemnity_TotalIncurred']";
						String Indemnity_TotalIncurred1="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[1]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='-1,100.00']";
						String Indemnity_TotalIncurred2="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[2]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='-1,100.00']";
						String Indemnity_TotalIncurred3="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[3]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='-2,200.00']";
						String Indemnity_TotalIncurred4="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[4]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='-1,100.00']";
						String Indemnity_TotalIncurred5="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[5]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='-1,100.00']";
						String Indemnity_TotalIncurred6="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[6]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='-2,200.00']";
						waitForElementToAppear(Indemnity_TotalIncurredcolumn,5);
						mouseOverAction(Indemnity_TotalIncurredcolumn);
						verifyMustExists(Indemnity_TotalIncurredcolumn,"Indemnity_TotalIncurred Column");
						sleep(2000);
						verifyExists(Indemnity_TotalIncurred1,"1st value");
						verifyExists(Indemnity_TotalIncurred2,"2nd value");
						verifyExists(Indemnity_TotalIncurred3,"3rd value");
						verifyExists(Indemnity_TotalIncurred4,"4th value");
						verifyExists(Indemnity_TotalIncurred5,"5th value");
						verifyExists(Indemnity_TotalIncurred6,"6st value");
						sleep(2000);
						//Total_Incurred
						String Total_Incurredcolumn ="@xpath=//*[@data-field='Total_Incurred']";
						String Total_Incurred1="@xpath=//*[@data-field='Total_Incurred']//following::tr[1]//td[contains(@ng-click,'Total_Incurred')][text()='-1,180.00']";
						String Total_Incurred2="@xpath=//*[@data-field='Total_Incurred']//following::tr[2]//td[contains(@ng-click,'Total_Incurred')][text()='-1,180.00']";
						String Total_Incurred3="@xpath=//*[@data-field='Total_Incurred']//following::tr[3]//td[contains(@ng-click,'Total_Incurred')][text()='-2,360.00']";
						String Total_Incurred4="@xpath=//*[@data-field='Total_Incurred']//following::tr[4]//td[contains(@ng-click,'Total_Incurred')][text()='-1,180.00']";
						String Total_Incurred5="@xpath=//*[@data-field='Total_Incurred']//following::tr[5]//td[contains(@ng-click,'Total_Incurred')][text()='-1,180.00']";
						String Total_Incurred6="@xpath=//*[@data-field='Total_Incurred']//following::tr[6]//td[contains(@ng-click,'Total_Incurred')][text()='-2,360.00']";
						waitForElementToAppear(Total_Incurredcolumn,5);
						mouseOverAction(Total_Incurredcolumn);
						verifyMustExists(Total_Incurredcolumn,"Total_Incurred Column");
						sleep(2000);
						verifyExists(Total_Incurred1,"1st value");
						verifyExists(Total_Incurred2,"2nd value");
						verifyExists(Total_Incurred3,"3rd value");
						verifyExists(Total_Incurred4,"4th value");
						verifyExists(Total_Incurred5,"5th value");
						verifyExists(Total_Incurred6,"6st value");
						sleep(2000);
						//Total_Paid
						String Total_Paidcolumn ="@xpath=//*[@data-field='Total_Paid']";
						String Total_Paid1="@xpath=//*[@data-field='Total_Paid']//following::tr[1]//td[contains(@ng-click,'Total_Paid')][text()='-140.00']";
						String Total_Paid2="@xpath=//*[@data-field='Total_Paid']//following::tr[2]//td[contains(@ng-click,'Total_Paid')][text()='-140.00']";
						String Total_Paid3="@xpath=//*[@data-field='Total_Paid']//following::tr[3]//td[contains(@ng-click,'Total_Paid')][text()='-280.00']";
						String Total_Paid4="@xpath=//*[@data-field='Total_Paid']//following::tr[4]//td[contains(@ng-click,'Total_Paid')][text()='-140.00']";
						String Total_Paid5="@xpath=//*[@data-field='Total_Paid']//following::tr[5]//td[contains(@ng-click,'Total_Paid')][text()='-140.00']";
						String Total_Paid6="@xpath=//*[@data-field='Total_Paid']//following::tr[6]//td[contains(@ng-click,'Total_Paid')][text()='-280.00']";
						waitForElementToAppear(Total_Paidcolumn,5);
						mouseOverAction(Total_Paidcolumn);
						verifyMustExists(Total_Paidcolumn,"Total_Paid Column");
						sleep(2000);
						verifyExists(Total_Paid1,"1st value");
						verifyExists(Total_Paid2,"2nd value");
						verifyExists(Total_Paid3,"3rd value");
						verifyExists(Total_Paid4,"4th value");
						verifyExists(Total_Paid5,"5th value");
						verifyExists(Total_Paid6,"6st value");
						sleep(2000);
						//Total_Reserve
						String Total_Reservecolumn ="@xpath=//*[@data-field='Total_Reserve']";
						String Total_Reserve1="@xpath=//*[@data-field='Total_Reserve']//following::tr[1]//td[contains(@ng-click,'Total_Reserve')][text()='-1,040.00']";
						String Total_Reserve2="@xpath=//*[@data-field='Total_Reserve']//following::tr[2]//td[contains(@ng-click,'Total_Reserve')][text()='-1,040.00']";
						String Total_Reserve3="@xpath=//*[@data-field='Total_Reserve']//following::tr[3]//td[contains(@ng-click,'Total_Reserve')][text()='-2,080.00']";
						String Total_Reserve4="@xpath=//*[@data-field='Total_Reserve']//following::tr[4]//td[contains(@ng-click,'Total_Reserve')][text()='-1,040.00']";
						String Total_Reserve5="@xpath=//*[@data-field='Total_Reserve']//following::tr[5]//td[contains(@ng-click,'Total_Reserve')][text()='-1,040.00']";
						String Total_Reserve6="@xpath=//*[@data-field='Total_Reserve']//following::tr[6]//td[contains(@ng-click,'Total_Reserve')][text()='-2,080.00']";
						waitForElementToAppear(Total_Reservecolumn,5);
						mouseOverAction(Total_Reservecolumn);
						verifyMustExists(Total_Reservecolumn,"Total_Reserve Column");
						sleep(2000);
						verifyExists(Total_Reserve1,"1st value");
						TR1 =  getTextFrom(Total_Reserve1);	
						Report.LogInfo("Total_Reserve1 1st value", TR1, "PASS");
						verifyExists(Total_Reserve2,"2nd value");
						TR2 =  getTextFrom(Total_Reserve2);	
						Report.LogInfo("Total_Reserve2 2nd value", TR2, "PASS");
						verifyExists(Total_Reserve3,"3rd value");
						TR3 =  getTextFrom(Total_Reserve3);	
						Report.LogInfo("Total_Reserve3 3rd value", TR3, "PASS");
						verifyExists(Total_Reserve4,"4th value");
						TR4 =  getTextFrom(Total_Reserve4);	
						Report.LogInfo("Total_Reserve4 4th value", TR4, "PASS");
						verifyExists(Total_Reserve5,"5th value");
						TR5 =  getTextFrom(Total_Reserve5);	
						Report.LogInfo("Total_Reserve5 5th value", TR5, "PASS");
						verifyExists(Total_Reserve6,"6st value");
						TR6 =  getTextFrom(Total_Reserve6);	
						Report.LogInfo("Total_Reserve6 6st value", TR6, "PASS");
						sleep(2000);
						policy.navigationOnBordereauxTab();
						BordereauPage.refreshUploadedFile();
						if(isVisible(BordereauPage.ReviewBtn)==true) {
							AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);	
							Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
							BordereauPage.deleteBorderEAUX(); 
						} else {
							Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
						}
						// deleteBorderEAUX();
					}else{
						Report.LogInfo("ApprovedbuttonValidation", "Approved Button not Displayed", "FAIL");
					}
				}

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void claimsFinancials_4104() throws Exception
	{
		String subSheet="Automation Claim Format 4 (Lloyd's Claim Property schema)";
		String DateMonth = "February 2018";
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		
		policy.CreateClaimContractwithInceptionDate2018();
		
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		BordereauPage.SubmitBordereaux(subSheet);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4104Path = fpath+"\\src\\test\\resources\\testdata\\Claims Financial Calculatoins January_TC_4104.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4104Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S64009620180928.xlsx";	
		int size = 14672;
		String BordreauID = "c3c22194-dbbd-46fc-bd2f-cb2cbe68415d";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Claims Financial Calculatoins January_TC_4104.xlsx\",\"UniqueFileName\":\"S54092420180430.xlsx\",\"BordereauFormatId\":\"c3c22194-dbbd-46fc-bd2f-cb2cbe68415d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S54092420180430.xlsx\",\"Filesize\":14672,\"Path\":null,\"size\":14672,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
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
			BordereauPage.refreshUploadedFileForApproved();
			if(isVisible(BordereauPage.Approvedbtn)==true)
			{
				AssertBordereauStatusApproved =  getTextFrom(BordereauPage.Approvedbtn);	
				Report.LogInfo("APPROVED Status", AssertBordereauStatusApproved, "PASS");
				BordereauPage.SubmitBordereauxWithYesnoButtons(DateMonth);
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4104SecondPath = fpath+"\\src\\test\\resources\\testdata\\Claims Financial Calculations February_TC_4104_second.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				File excelFile1 = new File(sheet4104SecondPath);  
				
				
				String Ufname1 = "S88948420180928.xlsx";	
				int size1 = 11448;
				String BordreauID1 = "c3c22194-dbbd-46fc-bd2f-cb2cbe68415d";
		        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
		        String ID1 = extractIDFromResponseinsideContract(response1); 
		        String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 2 , "3", 2018);
		        addAsDraft(payload2,DraftUrl);
		        
				//String payload2="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Claims Financial Calculations February_TC_4104_second.xlsx\",\"UniqueFileName\":\"S92077520180430.xlsx\",\"BordereauFormatId\":\"c3c22194-dbbd-46fc-bd2f-cb2cbe68415d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S92077520180430.xlsx\",\"Filesize\":11448,\"Path\":null,\"size\":11448,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
				BordereauPage.refreshUploadedFile();
				if(isVisible(BordereauPage.ReviewBtn)== true){
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					BordereauPage.openDATALink();
					BordereauPage.navigateToDATAClaimTab();
					FCpage.offOnlycurrentIcon();
					//Fees_Paid
					String Fees_Paidcolumn ="@xpath=//*[@data-field='Fees_Paid']";
					String Fees_Paid1="@xpath=//*[@data-field='Fees_Paid']//following::tr[1]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";
					String Fees_Paid2="@xpath=//*[@data-field='Fees_Paid']//following::tr[2]//td[contains(@ng-click,'Fees_Paid')][text()='0.00']";
					String Fees_Paid3="@xpath=//*[@data-field='Fees_Paid']//following::tr[3]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";
					String Fees_Paid4="@xpath=//*[@data-field='Fees_Paid']//following::tr[4]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";
					String Fees_Paid5="@xpath=//*[@data-field='Fees_Paid']//following::tr[5]//td[contains(@ng-click,'Fees_Paid')][text()='0.00']";
					String Fees_Paid6="@xpath=//*[@data-field='Fees_Paid']//following::tr[6]//td[contains(@ng-click,'Fees_Paid')][text()='40.00']";
					waitForElementToAppear(Fees_Paidcolumn,5);
					mouseOverAction(Fees_Paidcolumn);
					verifyMustExists(Fees_Paidcolumn,"Fees_Paid Column");
					sleep(2000);
					verifyExists(Fees_Paid1,"1st value");
					FP1 =  getTextFrom(Fees_Paid1);	
					Report.LogInfo("Fees_Paid1 1st value", FP1, "PASS");
					verifyExists(Fees_Paid2,"2nd value");
					FP2 =  getTextFrom(Fees_Paid2);	
					Report.LogInfo("Fees_Paid2 2nd value", FP2, "PASS");
					verifyExists(Fees_Paid3,"3rd value");
					FP3 =  getTextFrom(Fees_Paid3);	
					Report.LogInfo("Fees_Paid3 3rd value", FP3, "PASS");
					verifyExists(Fees_Paid4,"4th value");
					FP4 =  getTextFrom(Fees_Paid4);	
					Report.LogInfo("Fees_Paid4 4th value", FP4, "PASS");
					verifyExists(Fees_Paid5,"5th value");
					FP5 =  getTextFrom(Fees_Paid5);	
					Report.LogInfo("Fees_Paid5 5th value", FP5, "PASS");
					verifyExists(Fees_Paid6,"6st value");
					FP6 =  getTextFrom(Fees_Paid6);	
					Report.LogInfo("Fees_Paid1 6st value", FP6, "PASS");
					sleep(2000);
					//Fees_Reserve
					String Fees_Reservecolumn ="@xpath=//*[@data-field='Fees_Reserve']";
					String Fees_Reserve1="@xpath=//*[@data-field='Fees_Reserve']//following::tr[1]//td[contains(@ng-click,'Fees_Reserve')][text()='40.00']";
					String Fees_Reserve2="@xpath=//*[@data-field='Fees_Reserve']//following::tr[2]//td[contains(@ng-click,'Fees_Reserve')][text()='80.00']";
					String Fees_Reserve3="@xpath=//*[@data-field='Fees_Reserve']//following::tr[3]//td[contains(@ng-click,'Fees_Reserve')][text()='120.00']";
					String Fees_Reserve4="@xpath=//*[@data-field='Fees_Reserve']//following::tr[4]//td[contains(@ng-click,'Fees_Reserve')][text()='40.00']";
					String Fees_Reserve5="@xpath=//*[@data-field='Fees_Reserve']//following::tr[5]//td[contains(@ng-click,'Fees_Reserve')][text()='80.00']";
					String Fees_Reserve6="@xpath=//*[@data-field='Fees_Reserve']//following::tr[6]//td[contains(@ng-click,'Fees_Reserve')][text()='120.00']";
					waitForElementToAppear(Fees_Reservecolumn,5);
					mouseOverAction(Fees_Reservecolumn);
					verifyMustExists(Fees_Reservecolumn,"Fees_Reserve Column");
					sleep(2000);
					verifyExists(Fees_Reserve1,"1st value");
					FR1 =  getTextFrom(Fees_Reserve1);	
					Report.LogInfo("Fees_Reserve1 1st value", FR1, "PASS");
					verifyExists(Fees_Reserve2,"2nd value");
					FR2 =  getTextFrom(Fees_Reserve2);	
					Report.LogInfo("Fees_Reserve2 2nd value", FR2, "PASS");
					verifyExists(Fees_Reserve3,"3rd value");
					FR3 =  getTextFrom(Fees_Reserve3);	
					Report.LogInfo("Fees_Reserve3 3rd value", FR3, "PASS");
					verifyExists(Fees_Reserve4,"4th value");
					FR4 =  getTextFrom(Fees_Reserve4);	
					Report.LogInfo("Fees_Reserve4 4th value", FR4, "PASS");
					verifyExists(Fees_Reserve5,"5th value");
					FR5 =  getTextFrom(Fees_Reserve5);	
					Report.LogInfo("Fees_Reserve5 5th value", FR5, "PASS");
					verifyExists(Fees_Reserve6,"6st value");
					FR6 =  getTextFrom(Fees_Reserve6);	
					Report.LogInfo("Fees_Reserve6 6st value", FR6, "PASS");
					sleep(2000);
					//Fees_TotalIncurred
					String Fees_TotalIncurredcolumn ="@xpath=//*[@data-field='Fees_TotalIncurred']";
					String Fees_TotalIncurred1="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[1]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='80.00']";
					String Fees_TotalIncurred2="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[2]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='80.00']";
					String Fees_TotalIncurred3="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[3]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='160.00']";
					String Fees_TotalIncurred4="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[4]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='80.00']";
					String Fees_TotalIncurred5="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[5]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='80.00']";
					String Fees_TotalIncurred6="@xpath=//*[@data-field='Fees_TotalIncurred']//following::tr[6]//td[contains(@ng-click,'Fees_TotalIncurred')][text()='160.00']";
					waitForElementToAppear(Fees_TotalIncurredcolumn,5);
					mouseOverAction(Fees_TotalIncurredcolumn);
					verifyMustExists(Fees_TotalIncurredcolumn,"Fees_TotalIncurred Column");
					sleep(2000);
					verifyExists(Fees_TotalIncurred1,"1st value");
					verifyExists(Fees_TotalIncurred2,"2nd value");
					verifyExists(Fees_TotalIncurred3,"3rd value");
					verifyExists(Fees_TotalIncurred4,"4th value");
					verifyExists(Fees_TotalIncurred5,"5th value");
					verifyExists(Fees_TotalIncurred6,"6st value");
					sleep(2000);
					//Indemnity_TotalIncurred
					String Indemnity_TotalIncurredcolumn ="@xpath=//*[@data-field='Indemnity_TotalIncurred']";
					String Indemnity_TotalIncurred1="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[1]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='1,100.00']";
					String Indemnity_TotalIncurred2="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[2]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='2,000.00']";
					String Indemnity_TotalIncurred3="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[3]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='3,100.00']";
					String Indemnity_TotalIncurred4="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[4]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='1,100.00']";
					String Indemnity_TotalIncurred5="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[5]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='2,000.00']";
					String Indemnity_TotalIncurred6="@xpath=//*[@data-field='Indemnity_TotalIncurred']//following::tr[6]//td[contains(@ng-click,'Indemnity_TotalIncurred')][text()='3,100.00']";
					waitForElementToAppear(Indemnity_TotalIncurredcolumn,5);
					mouseOverAction(Indemnity_TotalIncurredcolumn);
					verifyMustExists(Indemnity_TotalIncurredcolumn,"Indemnity_TotalIncurred Column");
					sleep(2000);
					verifyExists(Indemnity_TotalIncurred1,"1st value");
					verifyExists(Indemnity_TotalIncurred2,"2nd value");
					verifyExists(Indemnity_TotalIncurred3,"3rd value");
					verifyExists(Indemnity_TotalIncurred4,"4th value");
					verifyExists(Indemnity_TotalIncurred5,"5th value");
					verifyExists(Indemnity_TotalIncurred6,"6st value");
					sleep(2000);
					//Total_Incurred
					String Total_Incurredcolumn ="@xpath=//*[@data-field='Total_Incurred']";
					String Total_Incurred1="@xpath=//*[@data-field='Total_Incurred']//following::tr[1]//td[contains(@ng-click,'Total_Incurred')][text()='1,180.00']";
					String Total_Incurred2="@xpath=//*[@data-field='Total_Incurred']//following::tr[2]//td[contains(@ng-click,'Total_Incurred')][text()='2,080.00']";
					String Total_Incurred3="@xpath=//*[@data-field='Total_Incurred']//following::tr[3]//td[contains(@ng-click,'Total_Incurred')][text()='3,260.00']";
					String Total_Incurred4="@xpath=//*[@data-field='Total_Incurred']//following::tr[4]//td[contains(@ng-click,'Total_Incurred')][text()='1,180.00']";
					String Total_Incurred5="@xpath=//*[@data-field='Total_Incurred']//following::tr[5]//td[contains(@ng-click,'Total_Incurred')][text()='2,080.00']";
					String Total_Incurred6="@xpath=//*[@data-field='Total_Incurred']//following::tr[6]//td[contains(@ng-click,'Total_Incurred')][text()='3,260.00']";
					waitForElementToAppear(Total_Incurredcolumn,5);
					mouseOverAction(Total_Incurredcolumn);
					verifyMustExists(Total_Incurredcolumn,"Total_Incurred Column");
					sleep(2000);
					verifyExists(Total_Incurred1,"1st value");
					verifyExists(Total_Incurred2,"2nd value");
					verifyExists(Total_Incurred3,"3rd value");
					verifyExists(Total_Incurred4,"4th value");
					verifyExists(Total_Incurred5,"5th value");
					verifyExists(Total_Incurred6,"6st value");
					sleep(2000);
					//Total_Paid
					String Total_Paidcolumn ="@xpath=//*[@data-field='Total_Paid']";
					String Total_Paid1="@xpath=//*[@data-field='Total_Paid']//following::tr[1]//td[contains(@ng-click,'Total_Paid')][text()='140.00']";
					String Total_Paid2="@xpath=//*[@data-field='Total_Paid']//following::tr[2]//td[contains(@ng-click,'Total_Paid')][text()='0.00']";
					String Total_Paid3="@xpath=//*[@data-field='Total_Paid']//following::tr[3]//td[contains(@ng-click,'Total_Paid')][text()='140.00']";
					String Total_Paid4="@xpath=//*[@data-field='Total_Paid']//following::tr[4]//td[contains(@ng-click,'Total_Paid')][text()='140.00']";
					String Total_Paid5="@xpath=//*[@data-field='Total_Paid']//following::tr[5]//td[contains(@ng-click,'Total_Paid')][text()='0.00']";
					String Total_Paid6="@xpath=//*[@data-field='Total_Paid']//following::tr[6]//td[contains(@ng-click,'Total_Paid')][text()='140.00']";
					waitForElementToAppear(Total_Paidcolumn,5);
					mouseOverAction(Total_Paidcolumn);
					verifyMustExists(Total_Paidcolumn,"Total_Paid Column");
					sleep(2000);
					verifyExists(Total_Paid1,"1st value");
					TP1 =  getTextFrom(Total_Paid1);	
					Report.LogInfo("Total_Paid1 1st value", TP1, "PASS");
					verifyExists(Total_Paid2,"2nd value");
					TP2 =  getTextFrom(Total_Paid2);	
					Report.LogInfo("Total_Paid2 2nd value", TP2, "PASS");
					verifyExists(Total_Paid3,"3rd value");
					TP3 =  getTextFrom(Total_Paid3);	
					Report.LogInfo("Total_Paid3 3rd value", TP3, "PASS");
					verifyExists(Total_Paid4,"4th value");
					TP4 =  getTextFrom(Total_Paid4);	
					Report.LogInfo("Total_Paid4 4th value", TP4, "PASS");
					verifyExists(Total_Paid5,"5th value");
					TP5 =  getTextFrom(Total_Paid5);	
					Report.LogInfo("Total_Paid5 5th value", TP5, "PASS");
					verifyExists(Total_Paid6,"6st value");
					TP6 =  getTextFrom(Total_Paid6);	
					Report.LogInfo("Total_Paid6 6st value", TP6, "PASS");
					sleep(2000);
					//Total_Reserve
					String Total_Reservecolumn ="@xpath=//*[@data-field='Total_Reserve']";
					String Total_Reserve1="@xpath=//*[@data-field='Total_Reserve']//following::tr[1]//td[contains(@ng-click,'Total_Reserve')][text()='1,040.00']";
					String Total_Reserve2="@xpath=//*[@data-field='Total_Reserve']//following::tr[2]//td[contains(@ng-click,'Total_Reserve')][text()='2,080.00']";
					String Total_Reserve3="@xpath=//*[@data-field='Total_Reserve']//following::tr[3]//td[contains(@ng-click,'Total_Reserve')][text()='3,120.00']";
					String Total_Reserve4="@xpath=//*[@data-field='Total_Reserve']//following::tr[4]//td[contains(@ng-click,'Total_Reserve')][text()='1,040.00']";
					String Total_Reserve5="@xpath=//*[@data-field='Total_Reserve']//following::tr[5]//td[contains(@ng-click,'Total_Reserve')][text()='2,080.00']";
					String Total_Reserve6="@xpath=//*[@data-field='Total_Reserve']//following::tr[6]//td[contains(@ng-click,'Total_Reserve')][text()='3,120.00']";
					waitForElementToAppear(Total_Reservecolumn,5);
					mouseOverAction(Total_Reservecolumn);
					verifyMustExists(Total_Reservecolumn,"Total_Reserve Column");
					sleep(2000);
					verifyExists(Total_Reserve1,"1st value");
					TR1 =  getTextFrom(Total_Reserve1);	
					Report.LogInfo("Total_Reserve1 1st value", TR1, "PASS");
					verifyExists(Total_Reserve2,"2nd value");
					TR2 =  getTextFrom(Total_Reserve2);	
					Report.LogInfo("Total_Reserve2 2nd value", TR2, "PASS");
					verifyExists(Total_Reserve3,"3rd value");
					TR3 =  getTextFrom(Total_Reserve3);	
					Report.LogInfo("Total_Reserve3 3rd value", TR3, "PASS");
					verifyExists(Total_Reserve4,"4th value");
					TR4 =  getTextFrom(Total_Reserve4);	
					Report.LogInfo("Total_Reserve4 4th value", TR4, "PASS");
					verifyExists(Total_Reserve5,"5th value");
					TR5 =  getTextFrom(Total_Reserve5);	
					Report.LogInfo("Total_Reserve5 5th value", TR5, "PASS");
					verifyExists(Total_Reserve6,"6st value");
					TR6 =  getTextFrom(Total_Reserve6);	
					Report.LogInfo("Total_Reserve6 6st value", TR6, "PASS");
					sleep(2000);
					policy.navigationOnBordereauxTab();
					BordereauPage.refreshUploadedFile();
					if(isVisible(BordereauPage.ReviewBtn)==true) {
						AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);	
						Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
						BordereauPage.deleteBorderEAUX(); 
			}else
				{
					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
				}
					//deleteBorderEAUX();

				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					BordereauPage.deleteBorderEAUX();
				}

			}else{
				Report.LogInfo("ApprovedbuttonValidation", "Approved Button not Displayed", "FAIL");
			}

		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}

	}
}
