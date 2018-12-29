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

public class FinancialCalculationRiskAndPremiumPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
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

	public static String contractId;

	public static String sheet4009Path = "";
	public static String sheet4010Path = "";
	public static String sheet4011Path = "";
	public static String sheet4013Path = "";
	public String Rw1;
	public String Rw2;
	public String Rw3;
	public String Rw4;
	public String GP1;
	public String GP2;
	public String GP3;
	public String GP4;
	public String GPT1;
	public String GPT2;
	public String GPT3;
	public String GPT4;
	public String CC1;
	public String CC2;
	public String CC3;
	public String CC4;
	public String NP1;
	public String NP2;
	public String NP3;
	public String NP4;
	public String LB1;
	public String LB2;
	public String LB3;
	public String LB4;
	public String FNP1;
	public String FNP2;
	public String FNP3;
	public String FNP4;
	public String CCP1;
	public String CCP2;
	public String CCP3;
	public String CCP4;


	public static final String onlyCurrentIcon="@xpath=//label[text()='Only Current']/../label[2]";
	public static final String typeOfRiskTransaction="@xpath=//*[@ng-model='BFBasicDetails.RiskTransaction']/..";
	public static final String notSuppliedDD="@xpath=//*[@id='RiskTransaction_listbox']/li[1]";

	public void riskAndPremiumForTransactionType_4009() throws Exception{
		String subSheet="Automation Risk Format 16 (Lloyd's Property Schema)";
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
	    String SubmitSheet="Automation Risk Format 16";
		/*homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubmitSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();*/
		
    	policy.CreateContractwithInceptionDate2018();
	
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		//BordereauPage.applyFilterPolicy("106076DB");
	
		BordereauPage.openSelectedPolicy();
	
		BordereauPage.SubmitBordereaux(subSheet);	
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4009Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4009.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4009Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
	
		String Ufname = "S17059320180928.xlsx";	
		int size = 19649;
		String BordreauID = "82e4d2e4-532d-4f03-802f-0b2d0a7d2f10";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4009.xlsx\",\"UniqueFileName\":\"S26633920180611.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S26633920180611.xlsx\",\"Filesize\":18843,\"Path\":null,\"size\":18843,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			offOnlycurrentIcon();
			//Row number column 
			String RowNumber="@xpath=//*[@data-field='RowNumber']";
			String RowNumber1="@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='2']";
			String RowNumber2="@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='3']";
			String RowNumber3="@xpath=//*[@data-field='RowNumber']//following::tr[3]//td[contains(@ng-click,'RowNumber')][text()='4']";
			String RowNumber4="@xpath=//*[@data-field='RowNumber']//following::tr[4]//td[contains(@ng-click,'RowNumber')][text()='4']";			
			verifyExists(RowNumber1,"1st value");
			verifyExists(RowNumber1,"1st value");
			Rw1 = getTextFrom(RowNumber1);
			Report.LogInfo("RowNumber1 1st value", Rw1, "PASS");
			verifyExists(RowNumber2,"2nd value");
			Rw2 = getTextFrom(RowNumber2);
			Report.LogInfo("RowNumber2 1st value", Rw2, "PASS");
			verifyExists(RowNumber3,"3rd value");
			Rw3 = getTextFrom(RowNumber3);
			Report.LogInfo("RowNumber3 3rd value", Rw3, "PASS");
			verifyExists(RowNumber4,"4th value");
			Rw4 = getTextFrom(RowNumber4);
			Report.LogInfo("RowNumber4 4th value", Rw4, "PASS");
			sleep(2000);
			//GrossPremium Including Tax Column 
			String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
			String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
			String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
			String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
			String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,500.00']";
			waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
			mouseOverAction(GrossPremiumIncludingTaxcolumn);
			verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
			sleep(2000);
			verifyExists(GrossPremiumIncludingTax1,"1st value");
			GP1 = getTextFrom(GrossPremiumIncludingTax1);
			Report.LogInfo("GrossPremiumIncludingTax1 1st value", GP1, "PASS");
			verifyExists(GrossPremiumIncludingTax2,"2nd value");
			GP2 = getTextFrom(GrossPremiumIncludingTax2);
			Report.LogInfo("GrossPremiumIncludingTax2 2nd value", GP2, "PASS");
			verifyExists(GrossPremiumIncludingTax3,"3rd value");
			GP3 = getTextFrom(GrossPremiumIncludingTax3);
			Report.LogInfo("GrossPremiumIncludingTax3 3rd value", GP3, "PASS");
			verifyExists(GrossPremiumIncludingTax4,"4th value");
			GP4 = getTextFrom(GrossPremiumIncludingTax4);
			Report.LogInfo("GrossPremiumIncludingTax4 4th value", GP4, "PASS");
			sleep(2000);
			//GrossPremium column 
			String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
			String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
			String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
			String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
			String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='1,500.00'][2]";
			waitForElementToAppear(GrossPremiumColumn,20);
			mouseOverAction(GrossPremiumColumn);
			verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
			sleep(2000);
			verifyExists(GrossPremium1,"1st value");
			GPT1 = getTextFrom(GrossPremium1);
			Report.LogInfo("GrossPremium1 1st value", GPT1, "PASS");
			verifyExists(GrossPremium2,"2nd value");
			GPT2 = getTextFrom(GrossPremium2);
			Report.LogInfo("GrossPremium2 2nd value", GPT2, "PASS");
			verifyExists(GrossPremium3,"3rd value");
			GPT3 = getTextFrom(GrossPremium3);
			Report.LogInfo("GrossPremium3 3rd value", GPT3, "PASS");
			verifyExists(GrossPremium4,"4th value");
			GPT4 = getTextFrom(GrossPremium4);
			Report.LogInfo("GrossPremium4 4th value", GPT4, "PASS");
			sleep(2000);
			//Coverholder Commission column 
			String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
			String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
			String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
			String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
			String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='1,000.00']";
			waitForElementToAppear(CoverholderCommissioncolumn,20);
			mouseOverAction(CoverholderCommissioncolumn);
			verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
			sleep(2000);
			verifyExists(CoverholderCommission1,"1st value");
			CC1 = getTextFrom(CoverholderCommission1);
			Report.LogInfo("CoverholderCommission1 1st value", CC1, "PASS");
			verifyExists(CoverholderCommission2,"2nd value");
			CC2 = getTextFrom(CoverholderCommission2);
			Report.LogInfo("CoverholderCommission2 2nd value", CC2, "PASS");
			verifyExists(CoverholderCommission3,"3rd value");
			CC3 = getTextFrom(CoverholderCommission3);
			Report.LogInfo("CoverholderCommission3 3rd value", CC3, "PASS");
			verifyExists(CoverholderCommission4,"4th value");
			CC4 = getTextFrom(CoverholderCommission4);
			Report.LogInfo("CoverholderCommission4 4th value", CC4, "PASS");
			sleep(2000);
			//Net Premium column 
			String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
			String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
			String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
			String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
			String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
			waitForElementToAppear(NetPremiumcolumn,20);
			mouseOverAction(NetPremiumcolumn);
			verifyMustExists(NetPremiumcolumn,"Net Premium column");
			sleep(2000);
			verifyExists(NetPremium1,"1st value");
			NP1 = getTextFrom(NetPremium1);
			Report.LogInfo("NetPremium1 1st value", NP1, "PASS");
			verifyExists(NetPremium2,"2nd value");
			NP2 = getTextFrom(NetPremium2);
			Report.LogInfo("NetPremium2 2nd value", NP2, "PASS");
			verifyExists(NetPremium3,"3rd value");
			NP3 = getTextFrom(NetPremium3);
			Report.LogInfo("NetPremium3 3rd value", NP3, "PASS");
			verifyExists(NetPremium4,"4th value");
			NP4 = getTextFrom(NetPremium4);
			Report.LogInfo("NetPremium4 4th value", NP4, "PASS");
			sleep(2000);
			//london brokerage column
			String LondonBrokeragecolumn ="@xpath=//*[@data-field='London_Brokerage']";
			String LondonBrokerage1="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='156.05']";
			String LondonBrokerage2="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='50.00']";
			String LondonBrokerage3="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='25.00']";
			String LondonBrokerage4="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='75.00']";
			waitForElementToAppear(LondonBrokeragecolumn,20);
			mouseOverAction(LondonBrokeragecolumn);
			verifyMustExists(LondonBrokeragecolumn,"London Brokerage column");
			sleep(2000);
			verifyExists(LondonBrokerage1,"1st value");
			LB1 = getTextFrom(LondonBrokerage1);
			Report.LogInfo("LondonBrokerage1 1st value", LB1, "PASS");
			verifyExists(LondonBrokerage2,"2nd value");
			LB2 = getTextFrom(LondonBrokerage2);
			Report.LogInfo("LondonBrokerage2 2nd value", LB2, "PASS");
			verifyExists(LondonBrokerage3,"3rd value");
			LB3 = getTextFrom(LondonBrokerage3);
			Report.LogInfo("LondonBrokerage3 3rd value", LB3, "PASS");
			verifyExists(LondonBrokerage4,"4th value");
			LB4 = getTextFrom(LondonBrokerage4);
			Report.LogInfo("LondonBrokerage4 4th value", LB4, "PASS");
			sleep(2000);
			//Final Net Premium column 
			String FinalNetPremiumcolumn ="@xpath=//*[@data-field='Final_Net_Premium']";
			String FinalNetPremium1="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,843.95']";
			String FinalNetPremium2="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='950.00']";
			String FinalNetPremium3="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='975.00']";
			String FinalNetPremium4="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,925.00']";
			waitForElementToAppear(FinalNetPremiumcolumn,20);
			mouseOverAction(FinalNetPremiumcolumn);
			verifyMustExists(FinalNetPremiumcolumn,"final Net Premium column");
			sleep(2000);
			verifyExists(FinalNetPremium1,"1st value");
			verifyExists(FinalNetPremium2,"2nd value");
			verifyExists(FinalNetPremium3,"3rd value");
			verifyExists(FinalNetPremium4,"4th value");
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
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}
		
	}


	public void transactionTypeNotSupplied_4010() throws Exception {
		String subSheet="Automation Risk Format 21 (Lloyd's Property Schema)";
		String pol="836221AW";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);	
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4010Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4010.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4010Path);  
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);

			String Ufname = "S78745520180928.xlsx";	
			int size = 19187;
			String BordreauID = "53e3fa7b-06a7-4c3d-91e0-ecc60decd1e5";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4010.xlsx\",\"UniqueFileName\":\"S10163220180502.xlsx\",\"BordereauFormatId\":\"53e3fa7b-06a7-4c3d-91e0-ecc60decd1e5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10163220180502.xlsx\",\"Filesize\":19187,\"Path\":null,\"size\":19187,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();
				offOnlycurrentIcon();	
				//GrossPremium Including Tax Column 
				String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
				String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
				String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,500.00']";
				waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
				mouseOverAction(GrossPremiumIncludingTaxcolumn);
				verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremiumIncludingTax1,"1st value");
				GP1 =  getTextFrom(GrossPremiumIncludingTax1);	
				Report.LogInfo("GrossPremiumIncludingTax1 1st value", GP1, "PASS");
				verifyExists(GrossPremiumIncludingTax2,"2nd value");
				GP2 =  getTextFrom(GrossPremiumIncludingTax2);	
				Report.LogInfo("GrossPremiumIncludingTax2 2nd value", GP2, "PASS");
				verifyExists(GrossPremiumIncludingTax3,"3rd value");
				GP3 =  getTextFrom(GrossPremiumIncludingTax3);	
				Report.LogInfo("GrossPremiumIncludingTax3 3rd value", GP3, "PASS");
				verifyExists(GrossPremiumIncludingTax4,"4th value");
				GP4 =  getTextFrom(GrossPremiumIncludingTax4);	
				Report.LogInfo("GrossPremiumIncludingTax4 4th value", GP4, "PASS");
				sleep(2000);
				//GrossPremium column 
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
				String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='1,500.00'][2]";
				waitForElementToAppear(GrossPremiumColumn,20);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				verifyExists(GrossPremium2,"2nd value");
				verifyExists(GrossPremium3,"3rd value");
				verifyExists(GrossPremium4,"4th value");
				sleep(2000);
				//Coverholder Commission column 
				String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
				String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='1,000.00']";
				waitForElementToAppear(CoverholderCommissioncolumn,20);
				mouseOverAction(CoverholderCommissioncolumn);
				verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1,"1st value");
				CC1 =  getTextFrom(CoverholderCommission1);	
				Report.LogInfo("CoverholderCommission1 1st value", CC1, "PASS");
				verifyExists(CoverholderCommission2,"2nd value");
				CC2 =  getTextFrom(CoverholderCommission2);	
				Report.LogInfo("CoverholderCommission2 2nd value", CC2, "PASS");
				verifyExists(CoverholderCommission3,"3rd value");
				CC3 =  getTextFrom(CoverholderCommission3);	
				Report.LogInfo("CoverholderCommission3 3rd value", CC3, "PASS");
				verifyExists(CoverholderCommission4,"4th value");
				CC4 =  getTextFrom(CoverholderCommission4);	
				Report.LogInfo("CoverholderCommission4 4th value", CC4, "PASS");
				sleep(2000);
				//Net Premium column 
				String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
				String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				waitForElementToAppear(NetPremiumcolumn,20);
				mouseOverAction(NetPremiumcolumn);
				verifyMustExists(NetPremiumcolumn,"Net Premium column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				NP1 =  getTextFrom(NetPremium1);	
				Report.LogInfo("NetPremium1 1st value", NP1, "PASS");
				verifyExists(NetPremium2,"2nd value");
				NP2 =  getTextFrom(NetPremium2);	
				Report.LogInfo("NetPremium2 2nd value", NP2, "PASS");
				verifyExists(NetPremium3,"3rd value");
				NP3 =  getTextFrom(NetPremium3);	
				Report.LogInfo("NetPremium3 3rd value", NP3, "PASS");
				verifyExists(NetPremium4,"4th value");
				NP4 =  getTextFrom(NetPremium4);	
				Report.LogInfo("NetPremium4 4th value", NP4, "PASS");
				sleep(2000);
				//london brokerage column	 
				String LondonBrokeragecolumn ="@xpath=//*[@data-field='London_Brokerage']";
				String LondonBrokerage1="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='156.05']";
				String LondonBrokerage2="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='50.00']";
				String LondonBrokerage3="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='25.00']";
				String LondonBrokerage4="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='75.00']";
				waitForElementToAppear(LondonBrokeragecolumn,20);
				mouseOverAction(LondonBrokeragecolumn);
				verifyMustExists(LondonBrokeragecolumn,"London Brokerage column");
				sleep(2000);
				verifyExists(LondonBrokerage1,"1st value");
				LB1 =  getTextFrom(LondonBrokerage1);	
				Report.LogInfo("LondonBrokerage1 1st value", LB1, "PASS");
				verifyExists(LondonBrokerage2,"2nd value");
				LB2 =  getTextFrom(LondonBrokerage2);	
				Report.LogInfo("LondonBrokerage2 2nd value", LB2, "PASS");
				verifyExists(LondonBrokerage3,"3rd value");
				LB3 =  getTextFrom(LondonBrokerage3);	
				Report.LogInfo("LondonBrokerage3 3rd value", LB3, "PASS");
				verifyExists(LondonBrokerage4,"4th value");
				LB4 =  getTextFrom(LondonBrokerage4);	
				Report.LogInfo("LondonBrokerage4 4th value", LB4, "PASS");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				//BordereauPage.refreshUploadedFile();
				if(isVisible(BordereauPage.ReviewBtn)==true) {
					AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);	
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
					BordereauPage.deleteBorderEAUX();
				} else {
					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
				}
				// deleteBorderEAUX();
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");

		}
	}

	public void finalcialCalculationRESTATEMENT_4011() throws Exception {
		String subSheet="Automation Risk Format 22 (Lloyd's Property Schema)";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);	
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4011Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4011.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4011Path);  
			
			String Ufname = "S45183120180928.xlsx";	
			int size = 19150;
			String BordreauID = "c4d9e41a-1314-4d64-a9df-6b59cfebbf27";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			//String payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4011.xlsx\",\"UniqueFileName\":\"S33757620180502.xlsx\",\"BordereauFormatId\":\"c4d9e41a-1314-4d64-a9df-6b59cfebbf27\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S33757620180502.xlsx\",\"Filesize\":19144,\"Path\":null,\"size\":19144,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();
				offOnlycurrentIcon();	
				//GrossPremium Including Tax Column 
				String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
				String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='-500.00']";
				String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
				waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
				mouseOverAction(GrossPremiumIncludingTaxcolumn);
				verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremiumIncludingTax1,"1st value");
				GP1 =  getTextFrom(GrossPremiumIncludingTax1);	
				Report.LogInfo("GrossPremiumIncludingTax1 1st value", GP1, "PASS");
				verifyExists(GrossPremiumIncludingTax2,"2nd value");
				GP2 =  getTextFrom(GrossPremiumIncludingTax2);	
				Report.LogInfo("GrossPremiumIncludingTax2 2nd value", GP2, "PASS");
				verifyExists(GrossPremiumIncludingTax3,"3rd value");
				GP3 =  getTextFrom(GrossPremiumIncludingTax3);	
				Report.LogInfo("GrossPremiumIncludingTax3 3rd value", GP3, "PASS");
				verifyExists(GrossPremiumIncludingTax4,"4th value");
				GP4 =  getTextFrom(GrossPremiumIncludingTax4);	
				Report.LogInfo("GrossPremiumIncludingTax4 4th value", GP4, "PASS");
				sleep(2000);
				//GrossPremium column 
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='-500.00'][2]";
				String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
				waitForElementToAppear(GrossPremiumColumn,20);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				verifyExists(GrossPremium2,"2nd value");
				verifyExists(GrossPremium3,"3rd value");
				verifyExists(GrossPremium4,"4th value");
				sleep(2000);
				//Coverholder Commission column 
				String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
				String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='0.00']";
				String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				waitForElementToAppear(CoverholderCommissioncolumn,20);
				mouseOverAction(CoverholderCommissioncolumn);
				verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1,"1st value");
				CC1 =  getTextFrom(CoverholderCommission1);	
				Report.LogInfo("CoverholderCommission1 1st value", CC1, "PASS");
				verifyExists(CoverholderCommission2,"2nd value");
				CC2 =  getTextFrom(CoverholderCommission2);	
				Report.LogInfo("CoverholderCommission2 2nd value", CC2, "PASS");
				verifyExists(CoverholderCommission3,"3rd value");
				CC3 =  getTextFrom(CoverholderCommission3);	
				Report.LogInfo("CoverholderCommission3 3rd value", CC3, "PASS");
				verifyExists(CoverholderCommission4,"4th value");
				CC4 =  getTextFrom(CoverholderCommission4);	
				Report.LogInfo("CoverholderCommission4 4th value", CC4, "PASS");
				sleep(2000);
				//Net Premium column 
				String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
				String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				waitForElementToAppear(NetPremiumcolumn,20);
				mouseOverAction(NetPremiumcolumn);
				verifyMustExists(NetPremiumcolumn,"Net Premium column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				NP1 =  getTextFrom(NetPremium1);	
				Report.LogInfo("NetPremium1 1st value", NP1, "PASS");
				verifyExists(NetPremium2,"2nd value");
				NP2 =  getTextFrom(NetPremium2);	
				Report.LogInfo("NetPremium2 2nd value", NP2, "PASS");
				verifyExists(NetPremium3,"3rd value");
				NP3 =  getTextFrom(NetPremium3);	
				Report.LogInfo("NetPremium3 3rd value", NP3, "PASS");
				verifyExists(NetPremium4,"4th value");
				NP4 =  getTextFrom(NetPremium4);	
				Report.LogInfo("NetPremium4 4th value", NP4, "PASS");
				sleep(2000);
				//Final Net Premium column 
				String FinalNetPremiumcolumn ="@xpath=//*[@data-field='Final_Net_Premium']";
				String FinalNetPremium1="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,843.95']";
				String FinalNetPremium2="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='950.00']";
				String FinalNetPremium3="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='25.00']";
				String FinalNetPremium4="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='975.00']";
				waitForElementToAppear(FinalNetPremiumcolumn,20);
				mouseOverAction(FinalNetPremiumcolumn);
				verifyMustExists(FinalNetPremiumcolumn,"final Net Premium column");
				sleep(2000);
				verifyExists(FinalNetPremium1,"1st value");
				FNP1 =  getTextFrom(FinalNetPremium1);	
				Report.LogInfo("FinalNetPremium1 1st value", FNP1, "PASS");
				verifyExists(FinalNetPremium2,"2nd value");
				FNP2 =  getTextFrom(FinalNetPremium2);	
				Report.LogInfo("FinalNetPremium2 2nd value", FNP2, "PASS");
				verifyExists(FinalNetPremium3,"3rd value");
				FNP3 =  getTextFrom(FinalNetPremium3);	
				Report.LogInfo("FinalNetPremium3 3rd value", FNP3, "PASS");
				verifyExists(FinalNetPremium4,"4th value");	
				FNP4 =  getTextFrom(FinalNetPremium4);	
				Report.LogInfo("FinalNetPremium4 4th value", FNP4, "PASS");

			}
			else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}

	public void riskAndPremiumForReportingtypeRESTATEMENT_4013() throws Exception {
		String subSheet="Automation Risk Format 22 (Lloyd's Property Schema)";
		String QuestionnaireOnlySpecificText="Automation Risk Format 22";
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireOnlySpecificText+"')][1]";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire(QuestionnaireOnlySpecificText, SelectQuestionnaire);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		sleep(3000);
		BQPage.nextStapeClick();
		BQPage.nextStapeClick();			
		sleep(2000);
		/*verifyMustExists(typeOfRiskTransaction,"type of Risk Transaction drop down");
		click(typeOfRiskTransaction,"type of Risk Transaction drop down");
		javaScriptWait();
		verifyMustExists(notSuppliedDD,"Not supplied drop down value");
		click(notSuppliedDD,"Not supplied drop down value");*/
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		verifyMustExists(BQPage.CancelBtn,"Cancel button");
		click(BQPage.CancelBtn,"Cancel button");
		sleep(3000);
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4013Path = fpath+"\\src\\test\\resources\\testdata\\Stage 2 TC_4013.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4013Path);
			
			String Ufname = "S72631520180928.xlsx";	
			int size = 19143;
			String BordreauID = "c4d9e41a-1314-4d64-a9df-6b59cfebbf27";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			//String payload="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 TC_4013.xlsx\",\"UniqueFileName\":\"S43100020180502.xlsx\",\"BordereauFormatId\":\"c4d9e41a-1314-4d64-a9df-6b59cfebbf27\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S43100020180502.xlsx\",\"Filesize\":19151,\"Path\":null,\"size\":19151,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();
				offOnlycurrentIcon();	
				//GrossPremium Including Tax Column 
				String GrossPremiumIncludingTaxcolumn="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
				String GrossPremiumIncludingTax1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='1,000.00']";
				String GrossPremiumIncludingTax3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='-500.00']";
				String GrossPremiumIncludingTax4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='500.00']";
				waitForElementToAppear(GrossPremiumIncludingTaxcolumn,20);
				mouseOverAction(GrossPremiumIncludingTaxcolumn);
				verifyMustExists(GrossPremiumIncludingTaxcolumn,"Gross Premium Including Tax column");
				sleep(2000);
				verifyExists(GrossPremiumIncludingTax1,"1st value");
				GP1 =  getTextFrom(GrossPremiumIncludingTax1);	
				Report.LogInfo("GrossPremiumIncludingTax1 1st value", GP1, "PASS");
				verifyExists(GrossPremiumIncludingTax2,"2nd value");
				GP2 =  getTextFrom(GrossPremiumIncludingTax2);	
				Report.LogInfo("GrossPremiumIncludingTax2 2nd value", GP2, "PASS");
				verifyExists(GrossPremiumIncludingTax3,"3rd value");
				GP3 =  getTextFrom(GrossPremiumIncludingTax3);	
				Report.LogInfo("GrossPremiumIncludingTax3 3rd value", GP3, "PASS");
				verifyExists(GrossPremiumIncludingTax4,"4th value");
				GP4 =  getTextFrom(GrossPremiumIncludingTax4);	
				Report.LogInfo("GrossPremiumIncludingTax4 4th value", GP4, "PASS");
				sleep(2000);
				//GrossPremium column 
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='1,000.00'][2]";
				String GrossPremium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][text()='-500.00'][2]";
				String GrossPremium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][text()='500.00'][2]";
				waitForElementToAppear(GrossPremiumColumn,20);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				verifyExists(GrossPremium2,"2nd value");
				verifyExists(GrossPremium3,"3rd value");
				verifyExists(GrossPremium4,"4th value");
				sleep(2000);
				//Coverholder Commission column 
				String CoverholderCommissioncolumn ="@xpath=//*[@data-field='Coverholder_Commission']";
				String CoverholderCommission1="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission2="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				String CoverholderCommission3="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][text()='0.00']";
				String CoverholderCommission4="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][text()='500.00']";
				waitForElementToAppear(CoverholderCommissioncolumn,20);
				mouseOverAction(CoverholderCommissioncolumn);
				verifyMustExists(CoverholderCommissioncolumn,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1,"1st value");
				CC1 =  getTextFrom(CoverholderCommission1);	
				Report.LogInfo("CoverholderCommission1 1st value", CC1, "PASS");
				verifyExists(CoverholderCommission2,"2nd value");
				CC2 =  getTextFrom(CoverholderCommission2);	
				Report.LogInfo("CoverholderCommission2 V value", CC2, "PASS");
				verifyExists(CoverholderCommission3,"3rd value");
				CC3 =  getTextFrom(CoverholderCommission3);	
				Report.LogInfo("CoverholderCommission3 3rd value", CC3, "PASS");
				verifyExists(CoverholderCommission4,"4th value");
				CC4 =  getTextFrom(CoverholderCommission4);	
				Report.LogInfo("CoverholderCommission4 4th value", CC4, "PASS");
				sleep(2000);
				//Coverholder Commission % column 
				String CoverholderCommissionpercentcolumn ="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
				String CoverholderCommissionpercent1="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='50.00 %']";
				String CoverholderCommissionpercent2="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='50.00 %']";
				String CoverholderCommissionpercent3="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='100.00 %']";
				String CoverholderCommissionpercent4="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='100.00 %']";
				waitForElementToAppear(CoverholderCommissionpercentcolumn,20);
				mouseOverAction(CoverholderCommissionpercentcolumn);
				verifyMustExists(CoverholderCommissionpercentcolumn,"Coverholder Commission percent column");
				sleep(2000);
				verifyExists(CoverholderCommissionpercent1,"1st value");
				CCP1 =  getTextFrom(CoverholderCommissionpercent1);	
				Report.LogInfo("CoverholderCommissionpercent1 1st value", CCP1, "PASS");
				verifyExists(CoverholderCommissionpercent2,"2nd value");
				CCP2 =  getTextFrom(CoverholderCommissionpercent2);	
				Report.LogInfo("CoverholderCommissionpercent2 2nd value", CCP2, "PASS");
				verifyExists(CoverholderCommissionpercent3,"3rd value");
				CCP3 =  getTextFrom(CoverholderCommissionpercent3);	
				Report.LogInfo("CoverholderCommissionpercent3 3rd value", CCP3, "PASS");
				verifyExists(CoverholderCommissionpercent4,"4th value");
				CCP4 =  getTextFrom(CoverholderCommissionpercent4);	
				Report.LogInfo("CoverholderCommissionpercent4 4th value", CCP4, "PASS");
				sleep(2000);
				//Net Premium column  
				String NetPremiumcolumn ="@xpath=//*[@data-field='Net_Premium']";
				String NetPremium1="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='2,000.00']";
				String NetPremium2="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				String NetPremium3="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPremium4="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='1,000.00']";
				waitForElementToAppear(NetPremiumcolumn,20);
				mouseOverAction(NetPremiumcolumn);
				verifyMustExists(NetPremiumcolumn,"Net Premium column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				verifyExists(NetPremium2,"2nd value");
				verifyExists(NetPremium3,"3rd value");
				verifyExists(NetPremium4,"4th value");
				sleep(2000);
				//london brokerage column
				String LondonBrokeragecolumn ="@xpath=//*[@data-field='London_Brokerage']";
				String LondonBrokerage1="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='156.05']";
				String LondonBrokerage2="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='50.00']";
				String LondonBrokerage3="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='-25.00']";
				String LondonBrokerage4="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='25.00']";
				waitForElementToAppear(LondonBrokeragecolumn,20);
				mouseOverAction(LondonBrokeragecolumn);
				verifyMustExists(LondonBrokeragecolumn,"London Brokerage column");
				sleep(2000);
				verifyExists(LondonBrokerage1,"1st value");
				LB1 =  getTextFrom(LondonBrokerage1);	
				Report.LogInfo("LondonBrokerage1 1st value", LB1, "PASS");
				verifyExists(LondonBrokerage2,"2nd value");
				LB2 =  getTextFrom(LondonBrokerage2);	
				Report.LogInfo("LondonBrokerage2 2nd value", LB2, "PASS");
				verifyExists(LondonBrokerage3,"3rd value");
				LB3 =  getTextFrom(LondonBrokerage3);	
				Report.LogInfo("LondonBrokerage3 3rd value", LB3, "PASS");
				verifyExists(LondonBrokerage4,"4th value");
				LB4 =  getTextFrom(LondonBrokerage4);	
				Report.LogInfo("LondonBrokerage4 4th value", LB4, "PASS");
				sleep(2000);	 
				//Final Net Premium column 
				String FinalNetPremiumcolumn ="@xpath=//*[@data-field='Final_Net_Premium']";
				String FinalNetPremium1="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,843.95']";
				String FinalNetPremium2="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='950.00']";
				String FinalNetPremium3="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='25.00']";
				String FinalNetPremium4="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='975.00']";
				waitForElementToAppear(FinalNetPremiumcolumn,20);
				mouseOverAction(FinalNetPremiumcolumn);
				verifyMustExists(FinalNetPremiumcolumn,"final Net Premium column");
				sleep(2000);
				verifyExists(FinalNetPremium1,"1st value");
				FNP1 =  getTextFrom(FinalNetPremium1);	
				Report.LogInfo("FinalNetPremium1 1st value", FNP1, "PASS");
				verifyExists(FinalNetPremium2,"2nd value");
				FNP2 =  getTextFrom(FinalNetPremium2);	
				Report.LogInfo("FinalNetPremium2 2nd value", FNP2, "PASS");
				verifyExists(FinalNetPremium3,"3rd value");
				FNP3 =  getTextFrom(FinalNetPremium3);	
				Report.LogInfo("FinalNetPremium3 4th value", FNP3, "PASS");
				verifyExists(FinalNetPremium4,"4th value");	
				FNP4 =  getTextFrom(FinalNetPremium4);	
				Report.LogInfo("FinalNetPremium4 4th value", FNP4, "PASS");

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	//=======================================================Reusable function==========================================================================================================//


	public void offOnlycurrentIcon()
	{
		waitForElementToAppear(onlyCurrentIcon,10);
		verifyMustExists(onlyCurrentIcon,"only current Icon");
		click(onlyCurrentIcon,"only current Icon");
		sleep(3000);	
	}	
}
