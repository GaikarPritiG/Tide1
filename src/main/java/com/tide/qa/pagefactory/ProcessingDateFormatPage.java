package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class ProcessingDateFormatPage extends PageBase{
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

	public static String sheet3984Path = "";
	public static String sheet3984PathScnd = "";


	public static final String onlyCurrentIcon="@xpath=//label[text()='Only Current']/../label[2]";
	public static final String EnrchValDate="@xpath=//*[@ng-model='item.EnrichData']";
	public static final String ContinueBtn="@xpath=//*[@id='content']//button[@ng-click='save()']";
	public static final String CancelBtn="@xpath=//*[@id='content']//button[@ng-click='cancel()']";
	public static final String Okbtn="@xpath=//div[@ng-click='cancel()']";
	
	public void usToUkdate_3984() throws Exception{
		String subSheet="SP - First Sheet (Automation Schema)";
		String IncDate ="01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		
		contractId = ReturnContractID();
		BordereauPage.SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			Report.LogInfo("ValidateReviewStatus", "1", "PASS"); 
			
			sheet3984Path = fpath+"\\src\\test\\resources\\testdata\\us_to_uk_formatTC_3984.xlsx";
			Report.LogInfo("ValidateReviewStatus", "2", "PASS"); 
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3984Path);  
		String Ufname = "S54566620181028.xlsx";	
		int size = 19212;
		String BordreauID = "57cd9da3-e1f8-4ff5-aa35-47ac276e4188";
		Report.LogInfo("ValidateReviewStatus", "3", "PASS"); 
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        Report.LogInfo("ValidateReviewStatus", "4", "PASS"); 
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			BordereauPage.selectRowNumberAscOrder();
			String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";
           String RiskInceptionDate1= "@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='14/01/2018']";
			String RiskInceptionDate2="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[2]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='14/01/2018']";
			String RiskInceptionDate3="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[3]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='14/01/2018']";
			String RiskInceptionDate4="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[4]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='01/01/2018']";
			String RiskInceptionDate5="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[5]//td[contains(@ng-click,'RiskInceptionDate')][1][text()='01/01/2018']";
			waitForElementToAppear(RiskInceptionDatecolumn,5);
			mouseOverAction(RiskInceptionDatecolumn);
			verifyMustExists(RiskInceptionDatecolumn,"RiskInceptionDate column");
			sleep(2000);
		//	verifyExists(RiskInceptionDate1,"1st value");
			verifyExists(RiskInceptionDate2,"2nd value");
			verifyExists(RiskInceptionDate3,"3rd value");
			verifyExists(RiskInceptionDate4,"4th value");
			verifyExists(RiskInceptionDate5,"5th value");
			sleep(2000);
			//RiskExpiryDate
			String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
			sleep(2000);
			String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='31/01/2018']";
			String RiskExpiryDate2="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[2]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='31/01/2018']";
			String RiskExpiryDate3="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[3]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='14/01/2018']";
			String RiskExpiryDate4="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='14/01/2018']";
			String RiskExpiryDate5="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[5]//td[contains(@ng-click,'RiskExpiryDate')][1][text()='14/01/2018']";
			waitForElementToAppear(RiskExpiryDatecolumn,5);
			mouseOverAction(RiskExpiryDatecolumn);
			verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
			sleep(2000);
			verifyExists(RiskExpiryDate1,"1st value");
			verifyExists(RiskExpiryDate2,"2nd value");
			verifyExists(RiskExpiryDate3,"3rd value");
			verifyExists(RiskExpiryDate4,"4th value");
			verifyExists(RiskExpiryDate5,"5th value");

			sleep(2000);
			BordereauPage.RuleDataCapture(RiskExpiryDate5,"Risk Expiry","1.14.2018","14/01/2018","Convert date values to UK date format");
			policy.navigationOnBordereauxTab();
			BordereauPage.refreshUploadedFile();
			BordereauPage.deleteBorderEAUX();
			
		
			
			
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}
	}

}
