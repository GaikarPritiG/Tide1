package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class ProcessEnrichmentPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	SchemaPage SchPage = new SchemaPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	FinancialCalculationRiskAndPremiumPage FCRPpage = new FinancialCalculationRiskAndPremiumPage ();
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
	public static String sheet6168PathScnd = "";
	public static String sheet3879Path = "";
	public static String sheet3880Path = "";
	public static String sheet3881Path = "";
	public static String sheet3882Path = "";
	public static String sheet3882secondPath = "";
	public static String sheet3890Path = "";
	public static String sheet3893Path = "";
	public static String sheet3894Path = "";
	public static String sheet3987Path = "";
	public static String sheet3988Path = "";
	public static String sheet3992Path = "";
	public static String sheet5337Path = "";
	public static String sheet3770Path = "";
	public static String sheet3865Path = "";
	public String YOA;
	public String YOA1;
	public String YOA2;
	public String YOA3;
	public String YOA4;
	public String YOA5;
	public String Brokerage;
	public String Brokerage1;
	public String Brokerage2;
	public String Brokerage3;
	public String Brokerage4;
	public String Brokerage5;
	public String ZeroBrokerage1;
	public String ZeroBrokerage2;
	public String ZeroBrokerage3;
	public String ZeroBrokerage4;
	public String ZeroBrokerage5;
	public String ExpairydDate;
	public String ExpairydDate1;
	public String ExpairydDate2;
	public String ExpairydDate3;
	public String ExpairydDate4;
	public String ExpairydDate5;
	public String RuleExpairydDate;
	public String CCP;
	public String CCP1;
	public String CCP2;
	public String CCP3;
	public String CCP4;
	public String CCP5;
	public String Currency;
	public String Currency1;
	public String Currency2;
	public String Currency3;
	public String Currency4;
	public String Currency5;
	public String ContractCurrency;
	public String PremiumCurrency;
	public String PremiumCurrency1;
	public String PremiumCurrency2;
	public String PremiumCurrency3;
	public String PremiumCurrency4;
	public String PremiumCurrency5;
	public String RiskCurrency;
	public String RiskCurency1;
	public String RiskCurency2;
	public String RiskCurency3;
	public String RiskCurency4;
	public String RiskCurency5;
	public String ErrorPageValidate;
	public String InceptionDate;
	public String InceptionDate1;
	public String InceptionDate2;
	public String InceptionDate3;
	public String InceptionDate4;
	public String InceptionDate5;
	public String TSI;
	public String GRP;
	public String GRP1;
	public String GROrgVlu;
	public String GRChngdVlu;
	public String GrossPremium;
	public String RiskExpiryDate;
	public String RiskIcptnDate;
	public String RiskExpiryDateValue;
	public String RiskInceptionDateValue;
	public String RiskExpiryDateOrignlValue;
	public String RiskIncptnDteOrgValue;
	public String RiskExpiryDateChngdValue;
	public String RiskIncptnChngVlue;
	public String PreCCYRow;
	public String PreCCYValue;
	public String PreCCYOrgVl;
	public String PreCCYChngdVl;
	public String RiskCCYColumn;
	public String RiskCCYvaluerow;
	public String RiskCCyOrgVlu;
	public String RiskCCyChngdVlu;
	public String TSIRule;
	public String GRPRule;
	public String RiskExpiryDateRule;
	public String TSI1;
	public String TSI2;
	public String TSI3;
	public String TSI4;
	public String TSI5;
	public String TSI6;
	public String TIV;
	public String TIV1;
	public String TIV2;
	public String TIV3;
	public String TIV4;
	public String TIV5;
	public String GP;
	public String GP1;
	public String GP2;
	public String GP3;
	public String GP4;
	public String GP5;
	public String GP6;
	public String GrossPremiump;
	public String Data;	
	public String LOIRule;	
    public static final String ContractCurrrency="@xpath=//dt/span[text()='Contract Currency']//following::dd[1]/a[text()='GBP - Pound Sterling']";
	public static final String Verify10PercentCoverholderCommission="@xpath=//dt[contains(.,'Coverholder Commission')]/..//dd";
	public static final String Okbtn="@xpath=//*[@ng-click='cancel()']";
	public static final String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[6]";
	public static final String RuleNameField1="@xpath=//tr[1]//div[@class='ng-binding']";	
	public static final String RuleNameField2="@xpath=//tr[2]//div[@class='ng-binding']";	
	public static final String RuleNameRiskExpiryDate="@xpath=//*[@uib-popover='Risk Expiry Date defaulted from the Risk Inception Date plus 1 year']";
	public static final String OriginalValue="@xpath=//tr[2][@ng-repeat='item in NewBCellEnrich']//td[3]";
	public static final String ChangedValue="@xpath=//tr[1][@ng-repeat='item in NewBCellEnrich']//td[4]";
	public static final String EfectiveDate="@xpath=.//tr[1]//td[contains(@ng-click,'Endorsement Effective Date')]";
	public static final String RuleName="@xpath=//td//div[text()='Use of Risk Inception Date as Endorsement Effective Date']";
	public String actualRuleName;
	public static final String RuleName1="@xpath=//td[3][contains(.,'-')]";
	public static final String RuleName2="@xpath=//td[4][contains(.,'2018')]";
	public static final String RuleName3="@xpath=//td[6][contains(.,'Extract Year of Account from Sheet Name')]";
	public static final String RuleName4="@xpath=//td[4][contains(.,'10.00')]";
	public static final String RuleName5="@xpath=//td[6][contains(.,'Derive the Brokerage Percentage from the relevant Contract')]";
	public static final String RuleName6="@xpath=//td[3][contains(.,'124.5?')]";
	public static final String RuleName7="@xpath=//td[4][contains(.,'124.50')]";
	public static final String RuleName9="@xpath=//td[6][contains(.,'Derive the Coverholder Commission from the relevant Contract')]";
	public static final String RuleName10="@xpath=//td[4][contains(.,'7.00')]";
	public static final String RuleName11="@xpath=//td[6][contains(.,'Default Value Applied')]";
	public static final String RuleName12="@xpath=//td[4][contains(.,'USD')]";
	public static final String RuleName13="@xpath=//td[4][contains(.,'GBP')]";
	public static final String RuleName14="@xpath=//td[6][contains(.,'Derive the Currency from the relevant Contract')]";
	public static final String NegativeToPositiveErrorScreen = "@xpath=//h2[text()='First reporting of risk with negative premium']";
	public static final String NegativeGrosPremClm1= "@xpath=//input[@ng-model='item.Gross_Premium']";
	public static final String ErrScrnContinueBtn = "@xpath=//button[@type='submit']";
	public static final String BordrerauSummaryTab = "@xpath=//h2[@class='borderauSubtitle ng-binding']";
	public static final String OkCanclBtn1="@xpath=//*[@ng-click='cancel()']";
	
	
	
	public void extractYOA_3879() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 1";
		String IncDate = "01/01/2017";
		String ExpDate="01/01/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		contractId = policy.ReturnContractID();
		
	//	policy.PolicyNumber = "501799RH";
	//	BordereauPage.applyFilterPolicy(policy.PolicyNumber);
	//	contractId =	"c820e655-d1e2-4132-9127-4f92232fa40f";
	//	BordereauPage.openSelectedPolicy();
		Report.LogInfo("", contractId, "PASS");
		BordereauPage.SubmitBordereaux(subSheet);	
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3879Path = fpath+"\\src\\test\\resources\\testdata\\YOAFrom_sheet_name_TC_3879.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3879Path);  
		
		
	String	 Ufname = "S44039020181101.xlsx";	
	int	 size = 18630;
	String	 BordreauID = "d2ff9897-6da5-4a76-bb3c-f2ffcca79c21";
    String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	Report.LogInfo("", response, "PASS");
    String ID = extractIDFromResponseinsideContract(response); 
    Report.LogInfo("", ID, "PASS");
    String   payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
    Report.LogInfo("", payload, "PASS");
        addAsDraft(payload,DraftUrl); 
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			//Row number column 
			//YearOfAccount
			String YearOfAccountcolumn="@xpath=//*[@data-field='YearOfAccount']";
			String YearOfAccount1="@xpath=//*[@data-field='YearOfAccount']//following::tr[1]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
			String YearOfAccount2="@xpath=//*[@data-field='YearOfAccount']//following::tr[2]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
			String YearOfAccount3="@xpath=//*[@data-field='YearOfAccount']//following::tr[3]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
			String YearOfAccount4="@xpath=//*[@data-field='YearOfAccount']//following::tr[4]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
			String YearOfAccount5="@xpath=//*[@data-field='YearOfAccount']//following::tr[5]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
			waitForElementToAppear(YearOfAccountcolumn,20);
			mouseOverAction(YearOfAccountcolumn);
			verifyMustExists(YearOfAccountcolumn,"Year Of Account column");
			YOA =  getTextFrom(YearOfAccountcolumn);
			Report.LogInfo("Year Of Account column", YOA, "PASS");
			sleep(2000);
			verifyExists(YearOfAccount1,"1st value");
			YOA1 =  getTextFrom(YearOfAccount1);
			Report.LogInfo("Year Of Account column 1st value", YOA1, "PASS");
			verifyExists(YearOfAccount2,"2nd value");
			YOA2 =  getTextFrom(YearOfAccount2);
			Report.LogInfo("Year Of Account column 2nd value", YOA2, "PASS");
			verifyExists(YearOfAccount3,"3rd value");
			YOA3 =  getTextFrom(YearOfAccount3);
			Report.LogInfo("Year Of Account column 3rd value ", YOA3, "PASS");
			verifyExists(YearOfAccount4,"4th value");
			YOA4 =  getTextFrom(YearOfAccount4);
			Report.LogInfo("Year Of Account column 4th value", YOA4, "PASS");
			verifyExists(YearOfAccount5,"5th value");
			YOA5 =  getTextFrom(YearOfAccount5);
			Report.LogInfo("Year Of Account column 5th value", YOA5, "PASS");
			sleep(2000);
			click(YearOfAccount1,"Year of Account"); 
			sleep(3000);
			waitForElementToAppear(RuleName1,5);
			verifyExists(RuleName1,"Original Value");
			verifyExists(RuleName2,"Changed value");
			verifyExists(RuleName3," rule name");
			verifyExists(Okbtn,"Ok button");
			click(Okbtn,"Ok button");
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}
	}

	public void deriveBrokeragePercentage_3880() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				String London_Brokerage_Percentcolumn="@xpath=//*[@data-field='London_Brokerage_Percent']";
				String London_Brokerage_Percent1="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent2="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent3="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent4="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				String London_Brokerage_Percent5="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
				waitForElementToAppear(London_Brokerage_Percentcolumn,5);
				mouseOverAction(London_Brokerage_Percentcolumn);
				verifyMustExists(London_Brokerage_Percentcolumn,"London_Brokerage_Percent column");
				Brokerage =  getTextFrom(London_Brokerage_Percentcolumn);
				Report.LogInfo("London_Brokerage_Percent column", Brokerage, "PASS");
				sleep(2000);
				verifyExists(London_Brokerage_Percent1,"1st value");
				Brokerage1 =  getTextFrom(London_Brokerage_Percent1);
				Report.LogInfo("London_Brokerage_Percent column 1st value", Brokerage1, "PASS");
				verifyExists(London_Brokerage_Percent2,"2nd value");
				Brokerage2 =  getTextFrom(London_Brokerage_Percent2);
				Report.LogInfo("London_Brokerage_Percent column 2nd value", Brokerage2, "PASS");
				verifyExists(London_Brokerage_Percent3,"3rd value");
				Brokerage3 =  getTextFrom(London_Brokerage_Percent3);
				Report.LogInfo("London_Brokerage_Percent column 3rd value", Brokerage3, "PASS");
				verifyExists(London_Brokerage_Percent4,"4th value");
				Brokerage4 =  getTextFrom(London_Brokerage_Percent4);
				Report.LogInfo("London_Brokerage_Percent column 4th value", Brokerage4, "PASS");
				verifyExists(London_Brokerage_Percent5,"5th value");
				Brokerage5 =  getTextFrom(London_Brokerage_Percent5);
				Report.LogInfo("London_Brokerage_Percent column 5th value", Brokerage5, "PASS");
				sleep(2000);	
				click(London_Brokerage_Percent1,"Brokerage Percentage"); 
				sleep(3000);
				waitForElementToAppear(RuleName1,5);
				verifyExists(RuleName1,"Original Value");
				verifyExists(RuleName4,"Changed value");
				verifyExists(RuleName5," rule name");
				verifyExists(Okbtn,"Ok button");
				click(Okbtn,"Ok button");
				policy.navigateToSectionTab();
				policy.navigateToSectionDotEdit();
				policy.EditBrekaregeSection("0");
				BordereauPage.SubmitBordereaux(subSheet);
		
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet3880Path = fpath+"\\src\\test\\resources\\testdata\\YOAFrom_sheet_name_TC_3880.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile = new File(sheet3880Path);
				String Ufname = "S29264120181028.xlsx";	
				int size = 17680;
				String BordreauID = "d2ff9897-6da5-4a76-bb3c-f2ffcca79c21";
		        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
		        String ID = extractIDFromResponseinsideContract(response); 
		        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
		        addAsDraft(payload,DraftUrl);
				
			
				BordereauPage.refreshUploadedFile();
				if(isVisible(BordereauPage.ReviewBtn)== true){
					AssertBordereauStatusReview=  getTextFrom(BordereauPage.ReviewBtn);
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					BordereauPage.openDATALink();
					BordereauPage.navigateToDATARiskTab();
					// london brokerage % Column = second
					String London_Brokerage_zeroPercentcolumn="@xpath=//*[@data-field='London_Brokerage_Percent']";
					String London_Brokerage_zeroPercent1="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent2="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent3="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent4="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					String London_Brokerage_zeroPercent5="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
					waitForElementToAppear(London_Brokerage_zeroPercentcolumn,5);
					mouseOverAction(London_Brokerage_zeroPercentcolumn);
					verifyMustExists(London_Brokerage_zeroPercentcolumn,"London_Brokerage_Percent column");
					sleep(2000);
					verifyExists(London_Brokerage_zeroPercent1,"1st value");
					ZeroBrokerage1 =  getTextFrom(London_Brokerage_zeroPercent1);
					Report.LogInfo("London_Brokerage_Percent column 1st value", ZeroBrokerage1, "PASS");
					verifyExists(London_Brokerage_zeroPercent2,"2nd value");
					ZeroBrokerage2 =  getTextFrom(London_Brokerage_zeroPercent2);
					Report.LogInfo("London_Brokerage_Percent column 2nd value", ZeroBrokerage2, "PASS");
					verifyExists(London_Brokerage_zeroPercent3,"3rd value");
					ZeroBrokerage3 =  getTextFrom(London_Brokerage_zeroPercent3);
					Report.LogInfo("London_Brokerage_Percent column 3rd value", ZeroBrokerage3, "PASS");
					verifyExists(London_Brokerage_zeroPercent4,"4th value");
					ZeroBrokerage4 =  getTextFrom(London_Brokerage_zeroPercent4);
					Report.LogInfo("London_Brokerage_Percent column 4th value", ZeroBrokerage4, "PASS");
					verifyExists(London_Brokerage_zeroPercent5,"5th value");
					ZeroBrokerage5 =  getTextFrom(London_Brokerage_zeroPercent5);
					Report.LogInfo("London_Brokerage_Percent column 5th value", ZeroBrokerage5, "PASS");
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
					//BordereauPage.deleteBorderEAUX();

				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					BordereauPage.deleteBorderEAUX();
				}

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void removeISOcurrencycode_3881() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
	
			BordereauPage.SubmitBordereaux(subSheet);	
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3881Path = fpath+"\\src\\test\\resources\\testdata\\Symbol_characteor_TC_3881.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3881Path);  
			String Ufname = "S38779120181028.xlsx";	
			int size = 17881;
			String BordreauID = "d2ff9897-6da5-4a76-bb3c-f2ffcca79c21";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
		
			BordereauPage.refreshUploadedFile();
			waitForElementToAppear(BordereauPage.ReviewBtn,20);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				BordereauPage.selectRowNumberAscOrder();
				// Gross_Premium Column 
				String Gross_Premiumcolumn="@xpath=//*[@data-field='Gross_Premium']";
				//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='4,000.00']
				String Gross_Premium1="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='124.50']";
				String Gross_Premium2="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='4.00']";
				String Gross_Premium3="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='8,855.00']";
				String Gross_Premium4="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='124.50']";
				String Gross_Premium5="@xpath=//*[@data-field='Gross_Premium']//following::tr[5]//td[contains(@ng-click,'Gross_Premium')][2][text()='124.50']";
				String Gross_Premium6="@xpath=//*[@data-field='Gross_Premium']//following::tr[6]//td[contains(@ng-click,'Gross_Premium')][2][text()='1,000.00']";
				waitForElementToAppear(Gross_Premiumcolumn,20);
				mouseOverAction(Gross_Premiumcolumn);
				verifyMustExists(Gross_Premiumcolumn,"Gross_Premium column");
				GP =  getTextFrom(Gross_Premiumcolumn);
				Report.LogInfo("Gross_Premium column", GP, "PASS");
				sleep(2000);
				verifyExists(Gross_Premium1,"1st value");
				GP1 =  getTextFrom(Gross_Premium1);
				Report.LogInfo("Gross_Premium column 1st value", GP1, "PASS");
				verifyExists(Gross_Premium2,"2nd value");
				GP2 =  getTextFrom(Gross_Premium2);
				Report.LogInfo("Gross_Premium column 2nd value", GP2, "PASS");
				verifyExists(Gross_Premium3,"3rd value");
				GP3 =  getTextFrom(Gross_Premium3);
				Report.LogInfo("Gross_Premium column 3rd value", GP3, "PASS");
				verifyExists(Gross_Premium4,"4th value");
				GP4 =  getTextFrom(Gross_Premium4);
				Report.LogInfo("Gross_Premium column 4th value", GP4, "PASS");
				verifyExists(Gross_Premium5,"5th value");
				GP5 =  getTextFrom(Gross_Premium5);
				Report.LogInfo("Gross_Premium column 5th value", GP5, "PASS");
				verifyExists(Gross_Premium6,"6th value");
				GP6 =  getTextFrom(Gross_Premium6);
				Report.LogInfo("Gross_Premium column 6th value", GP6, "PASS");
				
				String ValidateData ="@xpath=//td[contains(.,'Remove ISO currency code characters & symbols')]";
				String ValidatePopup ="@xpath=//h2[contains(.,'Gross Premium')]";
				String Ok="@xpath=//div[@ng-click='cancel()']";
				
				waitForElementToAppear(Gross_Premium4,5);
				verifyExists(Gross_Premium4,"1st value");
				click(Gross_Premium4,"1st Gross Premium name");
				sleep(2000);
				if(isVisible(ValidatePopup)==true)
				{
					Report.LogInfo("ValidateCoverholder_commission", "Coverholder commission popup  displayed.", "Pass"); 
					verifyExists(ValidatePopup,"Validate Popup");
					GrossPremiump =  getTextFrom(ValidatePopup);
					Report.LogInfo("Validate Popup", GrossPremiump, "PASS");
					sleep(2000);
					verifyExists(ValidateData,"Validate Message");
					Data =  getTextFrom(ValidateData);
					Report.LogInfo("Validate Popup", Data, "PASS");
					
					verifyExists(RuleName6,"Original Value");
					verifyExists(RuleName7,"Changed value");
					verifyExists(Okbtn,"Ok button");
					click(Okbtn,"Ok button");
					sleep(2000);
					policy.navigationOnBordereauxTab();
					BordereauPage.refreshUploadedFile();
					BordereauPage.deleteBorderEAUX();
				}
				else{
					Report.LogInfo("ValidateCoverholder_commission", "Coverholder commission popup not displayed.", "Fail"); 
					policy.navigationOnBordereauxTab();
					BordereauPage.refreshUploadedFile();
					BordereauPage.deleteBorderEAUX();					
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		/*}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}*/

	}

	public void riskExpiryDate_3882() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubsheetName="Automation Company Admin 1 Process enrichment 1";
	
		policy.applyFilterPolicy(policy.PolicyNumber);
		
		policy.openSelectedPolicy();
		
			BordereauPage.SubmitBordereaux(subSheet);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3882Path = fpath+"\\src\\test\\resources\\testdata\\Default Risk expair date_TC_3882.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3882Path);  
			String Ufname = "S77451920181028.xlsx";	
			int size = 17558;
			String BordreauID = "d2ff9897-6da5-4a76-bb3c-f2ffcca79c21";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//RiskExpiryDate
				
				String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
				String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='01/01/2019']";
				String RiskExpiryDate2="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[2]//td[contains(@ng-click,'RiskExpiryDate')][text()='01/01/2019']";
				String RiskExpiryDate3="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[3]//td[contains(@ng-click,'RiskExpiryDate')][text()='01/01/2019']";
				String RiskExpiryDate4="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][text()='04/01/2020']";
				String RiskExpiryDate5="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[5]//td[contains(@ng-click,'RiskExpiryDate')][text()='01/01/2022']";		
				waitForElementToAppear(RiskExpiryDatecolumn,20);
				mouseOverAction(RiskExpiryDatecolumn);
				verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
				ExpairydDate =  getTextFrom(RiskExpiryDatecolumn);
				Report.LogInfo("RiskExpiryDate column", ExpairydDate, "PASS");
				sleep(2000);
				verifyExists(RiskExpiryDate1,"1st value");
				ExpairydDate1 =  getTextFrom(RiskExpiryDate1);
				Report.LogInfo("RiskExpiryDate column 1st value", ExpairydDate1, "PASS");
				verifyExists(RiskExpiryDate2,"2nd value");
				ExpairydDate2 =  getTextFrom(RiskExpiryDate2);
				Report.LogInfo("RiskExpiryDate column 2nd value ", ExpairydDate2, "PASS");
				verifyExists(RiskExpiryDate3,"3rd value");
				ExpairydDate3 =  getTextFrom(RiskExpiryDate3);
				Report.LogInfo("RiskExpiryDate column 3rd value ", ExpairydDate3, "PASS");
				verifyExists(RiskExpiryDate4,"4th value");
				ExpairydDate4 =  getTextFrom(RiskExpiryDate4);
				Report.LogInfo("RiskExpiryDate column 4th value ", ExpairydDate4, "PASS");
				verifyExists(RiskExpiryDate5,"5th value");
				ExpairydDate5 =  getTextFrom(RiskExpiryDate5);
				Report.LogInfo("RiskExpiryDate column 5th value ", ExpairydDate5, "PASS");

				BordereauPage.verifyBackground(RiskExpiryDate5,"rgba(0, 97, 0, 1)");
				sleep(2000);
				click(RiskExpiryDate5,"RiskExpiryDate5");
				waitForElementToAppear(Okbtn,5);
				verifyExists(RuleNameRiskExpiryDate,"Rule Name Field");
				RuleExpairydDate =  getTextFrom(RuleNameRiskExpiryDate);
				Report.LogInfo("RiskExpiryDate column 5th value ", RuleExpairydDate, "PASS");
				click(Okbtn,"ok Buttton");
				sleep(2000);
			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}
		
	}

	

	public void defaultValueCCPercentage_3884() throws Exception{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			waitForElementToAppear(BordereauPage.ReviewBtn, 10);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				String CoverholderCommissionpercentagecolumn ="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
				String CoverholderCommissionpercentage1="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage2="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage3="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage4="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage5="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";		
				waitForElementToAppear(CoverholderCommissionpercentagecolumn,20);
				mouseOverAction(CoverholderCommissionpercentagecolumn);
				verifyMustExists(CoverholderCommissionpercentagecolumn,"Coverholder Commission percentage column");
				CCP =  getTextFrom(CoverholderCommissionpercentagecolumn);
				Report.LogInfo("Coverholder Commission percentage column", CCP, "PASS");

				sleep(2000);
				verifyExists(CoverholderCommissionpercentage1,"1st value");
				CCP1 =  getTextFrom(CoverholderCommissionpercentage1);
				Report.LogInfo("Coverholder Commission percentage column 1st value", CCP1, "PASS");
				verifyExists(CoverholderCommissionpercentage2,"2nd value");
				CCP2 =  getTextFrom(CoverholderCommissionpercentage2);
				Report.LogInfo("Coverholder Commission percentage column 2nd value", CCP2, "PASS");
				verifyExists(CoverholderCommissionpercentage3,"3rd value");
				CCP3 =  getTextFrom(CoverholderCommissionpercentage3);
				Report.LogInfo("Coverholder Commission percentage column 3rd value", CCP3, "PASS");
				verifyExists(CoverholderCommissionpercentage4,"4th value");
				CCP4 =  getTextFrom(CoverholderCommissionpercentage4);
				Report.LogInfo("Coverholder Commission percentage column 4th value", CCP4, "PASS");
				verifyExists(CoverholderCommissionpercentage5,"5th value");
				CCP5 =  getTextFrom(CoverholderCommissionpercentage5);
				Report.LogInfo("Coverholder Commission percentage column 5th value", CCP5, "PASS");
				sleep(2000);
				click(CoverholderCommissionpercentage1,"Coverholder Comission percentage"); 
				sleep(3000);
				waitForElementToAppear(RuleName1,5);
				verifyExists(RuleName1,"Original Value");
				verifyExists(RuleName4,"Changed value");
				verifyExists(Okbtn,"Ok button");
				click(Okbtn,"Ok button");
			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}


	public void riskExpiryDate_3890() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 2 (Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="Automation Company Admin 1 Process enrichment 2";
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
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn,5);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3890Path = fpath+"\\src\\test\\resources\\testdata\\Default Risk Expairy date_3890.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3890Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);	
			String Ufname = "S69990720180606.xlsx";	
			int size = 18836;
			String BordreauID = "995f332c-fe18-48f4-8f6a-3740a0a0c783";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//RiskExpiryDate
				String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
				String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2018']";
				String RiskExpiryDate2="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[2]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2018']";
				String RiskExpiryDate3="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[3]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2018']";
				String RiskExpiryDate4="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[4]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2018']";
				String RiskExpiryDate5="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[5]//td[contains(@ng-click,'RiskExpiryDate')][text()='31/01/2018']";

				waitForElementToAppear(RiskExpiryDatecolumn,10);
				mouseOverAction(RiskExpiryDatecolumn);
				verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
				ExpairydDate =  getTextFrom(RiskExpiryDatecolumn);
				Report.LogInfo("RiskExpiryDate column", ExpairydDate, "PASS");
				sleep(2000);
				verifyExists(RiskExpiryDate1,"1st value");
				ExpairydDate1 =  getTextFrom(RiskExpiryDate1);
				Report.LogInfo("RiskExpiryDate column 1st value", ExpairydDate1, "PASS");
				verifyExists(RiskExpiryDate2,"2nd value");
				ExpairydDate2 =  getTextFrom(RiskExpiryDate2);
				Report.LogInfo("RiskExpiryDate column 2nd value", ExpairydDate2, "PASS");
				verifyExists(RiskExpiryDate3,"3rd value");
				ExpairydDate3 =  getTextFrom(RiskExpiryDate3);
				Report.LogInfo("RiskExpiryDate column 3rd value", ExpairydDate3, "PASS");
				verifyExists(RiskExpiryDate4,"4th value");
				ExpairydDate4 =  getTextFrom(RiskExpiryDate4);
				Report.LogInfo("RiskExpiryDate column 4th value", ExpairydDate4, "PASS");
				verifyExists(RiskExpiryDate5,"5th value");
				ExpairydDate5 =  getTextFrom(RiskExpiryDate5);
				Report.LogInfo("RiskExpiryDate column 5th value", ExpairydDate5, "PASS");
				BordereauPage.verifyBackground(RiskExpiryDate5,"rgba(0, 97, 0, 1)");
				click(RiskExpiryDate5,"RiskExpiryDate5");
				waitForElementToAppear(Okbtn,5);
				verifyExists(RuleNameField,"Rule Name Field");
				click(Okbtn,"ok Buttton");
				sleep(2000);
				policy.navigationOnBordereauxTab();				
				
			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				//BordereauPage.deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void deriveCoverholderCommission_3891() throws Exception{
		String ExpectedValue="10%";
		//String pol ="692166EX";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			waitForElementToAppear(BordereauPage.ReviewBtn, 5);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Coverholder Commission percentage column 
				String CoverholderCommissionpercentagecolumn ="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
				String CoverholderCommissionpercentage1="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage2="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage3="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage4="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";
				String CoverholderCommissionpercentage5="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='10.00 %']";				String CHPercentagePopup = "@xpath=//h2[contains(.,'Coverholder Commission %')]";
				String ExpectedColor = "rgba(0, 97, 0, 1)";

				waitForElementToAppear(CoverholderCommissionpercentagecolumn,20);
				mouseOverAction(CoverholderCommissionpercentagecolumn);
				verifyMustExists(CoverholderCommissionpercentagecolumn,"Coverholder Commission percentage column");
				CCP =  getTextFrom(CoverholderCommissionpercentagecolumn);
				Report.LogInfo("Coverholder Commission percentage column", CCP, "PASS");
				sleep(2000);
				verifyExists(CoverholderCommissionpercentage1,"1st value");
				CCP1 =  getTextFrom(CoverholderCommissionpercentage1);
				Report.LogInfo("Coverholder Commission percentage column 1st value", CCP1, "PASS");
				verifyExists(CoverholderCommissionpercentage2,"2nd value");
				CCP2 =  getTextFrom(CoverholderCommissionpercentage2);
				Report.LogInfo("Coverholder Commission percentage column 2nd value", CCP2, "PASS");
				verifyExists(CoverholderCommissionpercentage3,"3rd value");
				CCP3 =  getTextFrom(CoverholderCommissionpercentage3);
				Report.LogInfo("Coverholder Commission percentage column 3rd value", CCP3, "PASS");
				verifyExists(CoverholderCommissionpercentage4,"4th value");
				CCP4 =  getTextFrom(CoverholderCommissionpercentage4);
				Report.LogInfo("Coverholder Commission percentage column 4th value", CCP4, "PASS");
				verifyExists(CoverholderCommissionpercentage5,"5th value");
				CCP5 =  getTextFrom(CoverholderCommissionpercentage5);
				Report.LogInfo("Coverholder Commission percentage column 5th value", CCP5, "PASS");

				BordereauPage.verifyBackground(CoverholderCommissionpercentage5,ExpectedColor);
				click(CoverholderCommissionpercentage1,"Coverholder Comission percentage"); 
				sleep(3000);
				waitForElementToAppear(RuleName1,5);
				verifyExists(RuleName1,"Original Value");
				verifyExists(RuleName4,"Changed value");
				verifyExists(RuleName9," rule name");
				verifyExists(Okbtn,"Ok button");
				click(Okbtn,"Ok button");
				sleep(2000);
				policy.navigateToSectionTab();
				waitForElementToAppear(Verify10PercentCoverholderCommission, 5);
				verifyExists(Verify10PercentCoverholderCommission,"Brokerage value");
				String actualBrokerage=getTextFrom(Verify10PercentCoverholderCommission);
				if(actualBrokerage.equals(ExpectedValue)){
					Report.LogInfo("ValidateBrokerageValue", "Expected Brokerage value is displayed successfully", "Pass");
				}else{
					Report.LogInfo("ValidateBrokerageValue", "Expected Brokerage value not displayed", "Fail");
				}

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				//BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}			

	}

	public void brokeragePercentageDefaultValue_3892() throws Exception{
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			waitForElementToAppear(BordereauPage.ReviewBtn, 10);
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//London_Brokerage_Percent column 
				String LondonBrokeragepercentagecolumn ="@xpath=//*[@data-field='London_Brokerage_Percent']";
				String LondonBrokeragepercentage1="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage2="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage3="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage4="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";
				String LondonBrokeragepercentage5="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='7.00 %']";				 waitForElementToAppear(LondonBrokeragepercentagecolumn,20);
				mouseOverAction(LondonBrokeragepercentagecolumn);
				verifyMustExists(LondonBrokeragepercentagecolumn,"London Brokerage percentage column");
				Brokerage =  getTextFrom(LondonBrokeragepercentagecolumn);
				Report.LogInfo("London Brokerage percentage column", Brokerage, "PASS");
				sleep(2000);
				verifyExists(LondonBrokeragepercentage1,"1st value");
				Brokerage1 =  getTextFrom(LondonBrokeragepercentage1);
				Report.LogInfo("London Brokerage percentage column 1st value", Brokerage1, "PASS");
				verifyExists(LondonBrokeragepercentage2,"2nd value");
				Brokerage2 =  getTextFrom(LondonBrokeragepercentage2);
				Report.LogInfo("London Brokerage percentage column 2nd value", Brokerage2, "PASS");
				verifyExists(LondonBrokeragepercentage3,"3rd value");
				Brokerage3 =  getTextFrom(LondonBrokeragepercentage3);
				Report.LogInfo("London Brokerage percentage column 3rd value", Brokerage3, "PASS");
				verifyExists(LondonBrokeragepercentage4,"4th value");
				Brokerage4 =  getTextFrom(LondonBrokeragepercentage4);
				Report.LogInfo("London Brokerage percentage column 4th value", Brokerage4, "PASS");
				verifyExists(LondonBrokeragepercentage5,"5th value");
				Brokerage5 =  getTextFrom(LondonBrokeragepercentage5);
				Report.LogInfo("London Brokerage percentage column 5th value", Brokerage5, "PASS");
				sleep(2000);
				click(LondonBrokeragepercentage1,"Coverholder Comission percentage"); 
				sleep(3000);
				waitForElementToAppear(RuleName1,5);
				verifyExists(RuleName1,"Original Value");
				verifyExists(RuleName10,"Changed value");
				verifyExists(RuleName11," rule name");
				verifyExists(Okbtn,"Ok button");
				click(Okbtn,"Ok button");
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void defaultCurrency_3893() throws Exception{
		String subSheet="Process Enrichment2 Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn)== true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3893Path = fpath+"\\src\\test\\resources\\testdata\\Defult Currency _TC_3893.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3893Path);  

			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String Ufname = "S41033420180606.xlsx";	
			int size = 18797;
			String BordreauID = "995f332c-fe18-48f4-8f6a-3740a0a0c783";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Premium_Currency
				String PremiumCurrencycolumn="@xpath=//*[@data-field='Premium_Currency']";
				String PremiumCurrency1="@xpath=//*[@data-field='Premium_Currency']//following::tr[1]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency2="@xpath=//*[@data-field='Premium_Currency']//following::tr[2]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency3="@xpath=//*[@data-field='Premium_Currency']//following::tr[3]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency4="@xpath=//*[@data-field='Premium_Currency']//following::tr[4]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				String PremiumCurrency5="@xpath=//*[@data-field='Premium_Currency']//following::tr[5]//td[contains(@ng-click,'Premium_Currency')][text()='USD']";
				waitForElementToAppear(PremiumCurrencycolumn,20);
				mouseOverAction(PremiumCurrencycolumn);
				verifyMustExists(PremiumCurrencycolumn,"Premium Currency column");
				Currency =  getTextFrom(PremiumCurrencycolumn);
				Report.LogInfo("Premium Currency column", Currency, "PASS");
				sleep(2000);
				verifyExists(PremiumCurrency1,"1st value");
				Currency1 =  getTextFrom(PremiumCurrency1);
				Report.LogInfo("Premium Currency column 1st value", Currency1, "PASS");
				verifyExists(PremiumCurrency2,"2nd value");
				Currency2 =  getTextFrom(PremiumCurrency2);
				Report.LogInfo("Premium Currency column 2nd value", Currency2, "PASS");
				verifyExists(PremiumCurrency3,"3rd value");
				Currency3 =  getTextFrom(PremiumCurrency3);
				Report.LogInfo("Premium Currency column 3rd value", Currency3, "PASS");
				verifyExists(PremiumCurrency4,"4th value");
				Currency4 =  getTextFrom(PremiumCurrency4);
				Report.LogInfo("Premium Currency column 4th value", Currency4, "PASS");
				verifyExists(PremiumCurrency5,"5th value");
				Currency5 =  getTextFrom(PremiumCurrency5);
				Report.LogInfo("Premium Currency column 5th value", Currency5, "PASS");
				sleep(2000);
				click(PremiumCurrency1,"Coverholder Comission percentage"); 
				sleep(3000);
				waitForElementToAppear(RuleName1,5);
				verifyExists(RuleName1,"Original Value");
				verifyExists(RuleName12,"Changed value");
				verifyExists(RuleName11," rule name");
				verifyExists(Okbtn,"Ok button");
				click(Okbtn,"Ok button");
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

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void deriveCurrency_3894() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		verifyExists(ContractCurrrency,"GBP contract currency");
		if(isVisible(BordereauPage.SignedBtn )&&isVisible(ContractCurrrency) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			verifyExists(ContractCurrrency,"GBP contract currency");
			ContractCurrency =  getTextFrom(ContractCurrrency);
			Report.LogInfo("Premium Currency column", ContractCurrency, "PASS");
			BordereauPage.SubmitBordereaux(subSheet);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3894Path = fpath+"\\src\\test\\resources\\testdata\\Derive the Currency relevant contract_TC_3894.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3894Path);  
			String Ufname = "S27963420181029.xlsx";	
			int size = 18822;
			String BordreauID = "9d36b96c-0d02-4005-946d-fbf5b51e24dc";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauPage.refreshUploadedFile();

			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Premium_Currency
				String RiskCurrencycolumn="@xpath=//*[@data-field='Premium_Currency']";
				String RiskCurrency1="@xpath=//*[@data-field='Premium_Currency']//following::tr[1]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency2="@xpath=//*[@data-field='Premium_Currency']//following::tr[2]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency3="@xpath=//*[@data-field='Premium_Currency']//following::tr[3]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency4="@xpath=//*[@data-field='Premium_Currency']//following::tr[4]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				String RiskCurrency5="@xpath=//*[@data-field='Premium_Currency']//following::tr[5]//td[contains(@ng-click,'Premium_Currency')][text()='GBP']";
				waitForElementToAppear(RiskCurrencycolumn,20);
				mouseOverAction(RiskCurrencycolumn);
				verifyMustExists(RiskCurrencycolumn,"Risk Currency column");
				PremiumCurrency =  getTextFrom(RiskCurrencycolumn);
				Report.LogInfo("Premium Currency column", PremiumCurrency, "PASS");
				sleep(2000);
				verifyExists(RiskCurrency1,"1st value");
				PremiumCurrency1 =  getTextFrom(RiskCurrency1);
				Report.LogInfo("Premium Currency column 1st value", PremiumCurrency1, "PASS");
				verifyExists(RiskCurrency2,"2nd value");
				PremiumCurrency2 =  getTextFrom(RiskCurrency2);
				Report.LogInfo("Premium Currency column 2nd value", PremiumCurrency2, "PASS");
				verifyExists(RiskCurrency3,"3rd value");
				PremiumCurrency3 =  getTextFrom(RiskCurrency3);
				Report.LogInfo("Premium Currency column 3rd value", PremiumCurrency3, "PASS");
				verifyExists(RiskCurrency4,"4th value");
				PremiumCurrency4 =  getTextFrom(RiskCurrency4);
				Report.LogInfo("Premium Currency column 4th value", PremiumCurrency4, "PASS");
				verifyExists(RiskCurrency5,"5th value");
				PremiumCurrency5 =  getTextFrom(RiskCurrency5);
				Report.LogInfo("Premium Currency column 5th value", PremiumCurrency5, "PASS");
				sleep(2000);
				//Risk_Currency
				String PremiumCurrencycolumn="@xpath=//*[@data-field='Risk_Currency']";
				String PremiumCurrency1="@xpath=//*[@data-field='Risk_Currency']//following::tr[1]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency2="@xpath=//*[@data-field='Risk_Currency']//following::tr[2]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency3="@xpath=//*[@data-field='Risk_Currency']//following::tr[3]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency4="@xpath=//*[@data-field='Risk_Currency']//following::tr[4]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				String PremiumCurrency5="@xpath=//*[@data-field='Risk_Currency']//following::tr[5]//td[contains(@ng-click,'Risk_Currency')][text()='GBP']";
				waitForElementToAppear(PremiumCurrencycolumn,20);
				mouseOverAction(PremiumCurrencycolumn);
				verifyMustExists(PremiumCurrencycolumn,"Risk Currency column");
				RiskCurrency =  getTextFrom(PremiumCurrencycolumn);
				Report.LogInfo("Risk Currency column", RiskCurrency, "PASS");
				sleep(2000);
				verifyExists(PremiumCurrency1,"1st value");
				RiskCurency1 =  getTextFrom(PremiumCurrency1);
				Report.LogInfo("Risk Currency column", RiskCurency1, "PASS");
				verifyExists(PremiumCurrency2,"2nd value");
				RiskCurency2 =  getTextFrom(PremiumCurrency2);
				Report.LogInfo("Risk Currency column", RiskCurency2, "PASS");
				verifyExists(PremiumCurrency3,"3rd value");
				RiskCurency3 =  getTextFrom(PremiumCurrency3);
				Report.LogInfo("Risk Currency column", RiskCurency3, "PASS");
				verifyExists(PremiumCurrency4,"4th value");
				RiskCurency4 =  getTextFrom(PremiumCurrency4);
				Report.LogInfo("Risk Currency column", RiskCurency4, "PASS");
				verifyExists(PremiumCurrency5,"5th value");
				RiskCurency5 =  getTextFrom(PremiumCurrency5);
				Report.LogInfo("Risk Currency column", RiskCurency5, "PASS");
				sleep(2000);
				click(PremiumCurrency1,"Coverholder Comission percentage"); 
				sleep(3000);
				waitForElementToAppear(RuleName1,5);
				verifyExists(RuleName1,"Original Value");
				verifyExists(RuleName13,"Changed value");
				verifyExists(RuleName14," rule name");
				verifyExists(Okbtn,"Ok button");
				click(Okbtn,"Ok button");
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

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void TotalInsurableValue_3987() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 1";
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		BordereauPage.SubmitBordereaux(subSheet);	
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3987Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3987.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3987Path); 
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S57958220181029.xlsx";	
		int size = 23984;
		String BordreauID = "d2ff9897-6da5-4a76-bb3c-f2ffcca79c21";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		BordereauPage.refreshUploadedFile();
		if(isVisible(BordereauPage.ReviewBtn)== true){
			AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			BordereauPage.openDATALink();
			BordereauPage.navigateToDATARiskTab();
			//Total_Sum_Insured
			String TotalSumInsuredcolumn="@xpath=//*[@data-field='Total_Sum_Insured']";
			String TotalSumInsured1="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[1]//td[contains(@ng-click,'Total_Sum_Insured')][text()='4,000.00']";
			String TotalSumInsured2="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[2]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
			String TotalSumInsured3="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[3]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured4="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[4]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured5="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[5]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured6="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[6]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured7="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[7]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured8="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[8]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			String TotalSumInsured9="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[9]//td[contains(@ng-click,'Total_Sum_Insured')][text()='900,001.00']";
			waitForElementToAppear(TotalSumInsuredcolumn,5);
			mouseOverAction(TotalSumInsuredcolumn);
			verifyMustExists(TotalSumInsuredcolumn,"Total Sum Insured column");
			TSI =  getTextFrom(TotalSumInsuredcolumn);
			Report.LogInfo("Total Sum Insured column", TSI, "PASS");
			sleep(2000);
			verifyExists(TotalSumInsured1,"1st value");
			TSI1 =  getTextFrom(TotalSumInsured1);
			Report.LogInfo("Total Sum Insured column 1st value", TSI1, "PASS");
			click(TotalSumInsured1,"1st value");
			waitForElementToAppear(Okbtn,10);
			verifyExists(RuleNameField,"Rule Name Field");
			TSIRule =  getTextFrom(RuleNameField);
			Report.LogInfo("Rule Name Field", TSIRule, "PASS");
			click(Okbtn,"ok Buttton");
			waitForElementToAppear(TotalSumInsured2,10);
			verifyExists(TotalSumInsured2,"2nd value");
			TSI2 =  getTextFrom(TotalSumInsured2);
			Report.LogInfo("Total Sum Insured column 2nd value", TSI2, "PASS");
			verifyExists(TotalSumInsured3,"3rd value");
			TSI3 =  getTextFrom(TotalSumInsured3);
			Report.LogInfo("Total Sum Insured column 3rd value", TSI3, "PASS");
			verifyExists(TotalSumInsured4,"4th value");
			TSI4 =  getTextFrom(TotalSumInsured4);
			Report.LogInfo("Total Sum Insured column 4th value", TSI4, "PASS");
			verifyExists(TotalSumInsured5,"5th value");
			TSI5 =  getTextFrom(TotalSumInsured5);
			Report.LogInfo("Total Sum Insured column 5th value", TSI5, "PASS");
			verifyExists(TotalSumInsured6,"6th value");
			TSI6 =  getTextFrom(TotalSumInsured6);
			Report.LogInfo("Total Sum Insured column 6th value", TSI6, "PASS");
			verifyExists(TotalSumInsured7,"7th value");
			verifyExists(TotalSumInsured8,"8th value");
			verifyExists(TotalSumInsured9,"9th value");
			sleep(2000);
			//Total_Insurable_Value
			String TotalInsurableValuecolumn="@xpath=//*[@data-field='Total_Insurable_Value']";
			String TotalInsurableValue1="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[1]//td[contains(@ng-click,'Total_Insurable_Value')][text()='4,000.00']";
			String TotalInsurableValue2="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[2]//td[contains(@ng-click,'Total_Insurable_Value')][text()='2,000.00']";
			String TotalInsurableValue3="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[3]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue4="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[4]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue5="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[5]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue6="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[6]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue7="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[7]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue8="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[8]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			String TotalInsurableValue9="@xpath=//*[@data-field='Total_Insurable_Value']//following::tr[9]//td[contains(@ng-click,'Total_Insurable_Value')][text()='900,001.00']";
			waitForElementToAppear(TotalInsurableValuecolumn,5);
			mouseOverAction(TotalInsurableValuecolumn);
			verifyMustExists(TotalInsurableValuecolumn,"Total Insurable Value column");
			TIV =  getTextFrom(TotalInsurableValuecolumn);
			Report.LogInfo("Total Insurable Value column", TIV, "PASS");
			sleep(2000);
			verifyExists(TotalInsurableValue1,"1st value");
			TIV1=  getTextFrom(TotalInsurableValue1);
			Report.LogInfo("Total Insurable Value column 1st value", TIV1, "PASS");
			verifyExists(TotalInsurableValue2,"2nd value");
			TIV2 =  getTextFrom(TotalInsurableValue2);
			Report.LogInfo("Total Insurable Value column 2nd value", TIV2, "PASS");
			verifyExists(TotalInsurableValue3,"3rd value");
			TIV3 =  getTextFrom(TotalInsurableValue3);
			Report.LogInfo("Total Insurable Value column 3rd value", TIV3, "PASS");
			verifyExists(TotalInsurableValue4,"4th value");
			TIV4 =  getTextFrom(TotalInsurableValue4);
			Report.LogInfo("Total Insurable Value column 4th value", TIV4, "PASS");
			verifyExists(TotalInsurableValue5,"5th value");
			TIV5 =  getTextFrom(TotalInsurableValue5);
			Report.LogInfo("Total Insurable Value column 5th value", TIV5, "PASS");
			verifyExists(TotalInsurableValue6,"6th value");
			verifyExists(TotalInsurableValue7,"7th value");
			verifyExists(TotalInsurableValue8,"8th value");
			verifyExists(TotalInsurableValue9,"9th value");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();

		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			BordereauPage.deleteBorderEAUX();
		}
	}

	public void limitOfIndemnity_3988() throws Exception{
		String subSheet="LOI Format (Limit of Idiminity)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn ) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3988Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_TC_3988.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3988Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String Ufname = "S38180420180908.xlsx";	
			int size = 113758;
			String BordreauID = "30950c3f-0e9e-4a67-8d0c-c873b9d73362";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				//Total_Sum_Insured
				String TotalSumInsuredcolumn="@xpath=//*[@data-field='Total_Sum_Insured']";
				String TotalSumInsured1="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[1]//td[contains(@ng-click,'Total_Sum_Insured')][text()='4,000.00']";
				String TotalSumInsured2="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[2]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured3="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[3]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured4="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[4]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured5="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[5]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured6="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[6]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured7="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[7]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured8="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[8]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured9="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[9]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				String TotalSumInsured10="@xpath=//*[@data-field='Total_Sum_Insured']//following::tr[10]//td[contains(@ng-click,'Total_Sum_Insured')][text()='2,000.00']";
				waitForElementToAppear(TotalSumInsuredcolumn,20);
				mouseOverAction(TotalSumInsuredcolumn);
				verifyMustExists(TotalSumInsuredcolumn,"Total Sum Insured column");
				sleep(2000);
				verifyExists(TotalSumInsured1,"1st value");
				TSI1 =  getTextFrom(TotalSumInsured1);
				Report.LogInfo("Total Insurable Value column", TSI1, "PASS");
				waitForElementToAppear(TotalSumInsured2,10);
				verifyExists(TotalSumInsured2,"2nd value");
				TSI2 =  getTextFrom(TotalSumInsured2);
				Report.LogInfo("Total Insurable Value column", TSI2, "PASS");
				verifyExists(TotalSumInsured3,"3rd value");
				TSI3 =  getTextFrom(TotalSumInsured3);
				Report.LogInfo("Total Insurable Value column", TSI3, "PASS");
				verifyExists(TotalSumInsured4,"4th value");
				TSI4 =  getTextFrom(TotalSumInsured4);
				Report.LogInfo("Total Insurable Value column", TSI4, "PASS");
				verifyExists(TotalSumInsured5,"5th value");
				TSI5 =  getTextFrom(TotalSumInsured5);
				Report.LogInfo("Total Insurable Value column", TSI5, "PASS");
				verifyExists(TotalSumInsured6,"6th value");
				TSI6 =  getTextFrom(TotalSumInsured6);
				Report.LogInfo("Total Insurable Value column", TSI6, "PASS");
				verifyExists(TotalSumInsured7,"7th value");
				verifyExists(TotalSumInsured8,"8th value");
				verifyExists(TotalSumInsured9,"9th value");
				verifyExists(TotalSumInsured10,"10th value");
				sleep(2000);
				click(TotalSumInsured1,"1st value");
				waitForElementToAppear(Okbtn,10);
				verifyExists(RuleNameField,"Rule Name Field");
				LOIRule =  getTextFrom(RuleNameField);
				Report.LogInfo("Rule Name Field", TSIRule, "PASS");
				click(Okbtn,"ok Buttton");			
				String LimitOfIndemnitycolumn="@xpath=//*[@data-field='Limit_Of_Indemnity']";
				String LimitOfIndemnity1="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[1]//td[text()='4,000.00'][1]";
				String LimitOfIndemnity2="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[2]//td[text()='2,000.00'][1]";
				String LimitOfIndemnity3="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[3]//td[text()='2,000.00'][1]";
				String LimitOfIndemnity4="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[4]//td[text()='2,000.00'][1]";
				String LimitOfIndemnity5="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[5]//td[text()='2,000.00'][1]";
				String LimitOfIndemnity6="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[6]//td[text()='2,000.00'][1]";
				String LimitOfIndemnity7="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[7]//td[text()='2,000.00'][1]";
				String LimitOfIndemnity8="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[8]//td[text()='2,000.00'][1]";
				String LimitOfIndemnity9="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[9]//td[text()='2,000.00'][1]";
			    String LimitOfIndemnity10="@xpath=//*[@data-field='Limit_Of_Indemnity']//following::tr[10]//td[text()='2,000.00'][1]";
				waitForElementToAppear(LimitOfIndemnitycolumn,20);
				mouseOverAction(LimitOfIndemnitycolumn);
				verifyMustExists(LimitOfIndemnitycolumn,"Limit Of Indemnity column");
				sleep(2000);
				verifyExists(LimitOfIndemnity1,"1st value");
				verifyExists(LimitOfIndemnity2,"2nd value");
				verifyExists(LimitOfIndemnity3,"3rd value");
				verifyExists(LimitOfIndemnity4,"4th value");
				verifyExists(LimitOfIndemnity5,"5th value");
				verifyExists(LimitOfIndemnity6,"6th value");
				verifyExists(LimitOfIndemnity7,"7th value");
				verifyExists(LimitOfIndemnity8,"8th value");
				verifyExists(LimitOfIndemnity9,"9th value");
				verifyExists(LimitOfIndemnity10,"10th value");
				sleep(2000);
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void RemovenonDateCharacters() throws Exception{
		String subSheet="Automation Company Admin 1 Process enrichment 1 (Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn ) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			contractId = ReturnContractID();
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3992Path = fpath+"\\src\\test\\resources\\testdata\\Default Risk expair date_TC_3992.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3992Path);  
			
			//contractId = addNewBordereauFormatPolicy(payload1, GetData);
			String Ufname = "S71954620181020.xlsx";	
			int size = 18728;
			String BordreauID = "d2ff9897-6da5-4a76-bb3c-f2ffcca79c21";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauPage.refreshUploadedFile();
			
		
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Default Risk expair date_TC_3992.xlsx\",\"UniqueFileName\":\"S19511720171128.xlsx\",\"BordereauFormatId\":\"bc2ca3dd-d933-4930-8989-a65bf0499b82\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S19511720171128.xlsx\",\"Filesize\":19285,\"Path\":null,\"size\":19285,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			
			
	        String Mandatorydatedatafield= "@xpath=//*[@id='content']//h2[contains(.,'Mandatory date data field not populated')]";
			
			if(BordereauPage.checkErrorReviewButton(BordereauPage.ReviewError)==true)
			{
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
				sleep(2000);
				
				if(isVisible(Mandatorydatedatafield)== true){
					ErrorPageValidate =  getTextFrom(Mandatorydatedatafield);
					sleep(2000);
					verifyMustExists(SchPage.Data0,"D6");
					sendKeys(SchPage.Data0,"01/01/2018","D6");
					verifyMustExists(SchPage.Data_1,"D5");
					sendKeys(SchPage.Data_1,"01/01/2018","D5");
					verifyMustExists(BordereauPage.ContinueBtn,"Continue button");
					click(BordereauPage.ContinueBtn,"Continue button");
					BordereauPage.refreshUploadedFile();
				}	else
				{
					Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
					goBack();
					BordereauPage.deleteBorderEAUX();				
				}
				
			}else{
				BordereauPage.refreshUploadedFile();
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
					BordereauPage.deleteBorderEAUX();
				}
				
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				BordereauPage.selectRowNumberAscOrder();
			
				String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";
				String RiskInceptionDate1="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2018']";
				String RiskInceptionDate2="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[2]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2018']";
				String RiskInceptionDate3="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[3]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2018']";
				String RiskInceptionDate4="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[4]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2018']";
				String RiskInceptionDate5="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[5]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2018']";
				waitForElementToAppear(RiskInceptionDatecolumn,20);
				mouseOverAction(RiskInceptionDatecolumn);
				verifyMustExists(RiskInceptionDatecolumn,"Risk Inception Date column");
				InceptionDate =  getTextFrom(RiskInceptionDatecolumn);
				Report.LogInfo("Risk Inception Date column", InceptionDate, "PASS");
				sleep(2000);
				verifyExists(RiskInceptionDate1,"1st value");
				InceptionDate1 =  getTextFrom(RiskInceptionDate1);
				Report.LogInfo("Risk Inception Date column 1st value", InceptionDate1, "PASS");
				verifyExists(RiskInceptionDate2,"2nd value");
				InceptionDate2 =  getTextFrom(RiskInceptionDate2);
				Report.LogInfo("Risk Inception Date column 2nd value", InceptionDate2, "PASS");
				verifyExists(RiskInceptionDate3,"3rd value");
				InceptionDate3 =  getTextFrom(RiskInceptionDate3);
				Report.LogInfo("Risk Inception Date column 3rd value", InceptionDate3, "PASS");
				verifyExists(RiskInceptionDate4,"4th field");
				InceptionDate4 =  getTextFrom(RiskInceptionDate4);
				Report.LogInfo("Risk Inception Date column 4th field", InceptionDate4, "PASS");
				sleep(1000);
				verifyExists(RiskInceptionDate5,"5th field");
				InceptionDate5 =  getTextFrom(RiskInceptionDate5);
				Report.LogInfo("Risk Inception Date column 5th field", InceptionDate5, "PASS");
				javaScriptclick(RiskInceptionDate5,"5st field ");
				waitForElementToAppear(Okbtn,10);
				//verifyExists(RuleNameField,"Rule Name Field");
				verifyExists(OriginalValue,"Original Value Field");
				sleep(1000);
				verifyExists(ChangedValue,"Changed Value Field");
				sleep(1000);
				verifyExists(RuleNameField1,"Rule Name Field");
				sleep(1000);
				verifyExists(RuleNameField2,"Rule Name Field");
				sleep(1000);
				javaScriptclick(Okbtn,"ok Buttton");
				sleep(3000);
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

			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}
	public void RiskInceptionDateasEndormentEfDate_5337() throws Exception{
		policy.CreateContractwithInceptionDate2018();
	
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		BordereauPage.openSelectedPolicy();
		String subSheet="Process Enrichment Format (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		waitForElementToAppear(BordereauPage.SignedBtn, 10);
		if(isVisible(BordereauPage.SignedBtn ) == true){
			verifyExists(BordereauPage.SignedBtn,"Signed Status Button");
			BordereauPage.SubmitBordereaux(subSheet);
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet5337Path = fpath+"\\src\\test\\resources\\testdata\\Renewal_jan_TC_5337.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
		//	policy.contractId = "6883d64d-9f43-49d5-b520-209bcb54cfd4";
			File excelFile = new File(sheet5337Path);  
			
			String Ufname = "S65530920181117.xlsx"; 	
			int size = 18378;
			String BordreauID = "59783d0e-52d9-4335-b3fb-f6cf25dcfc7b"; //"9303af0c-5c78-4764-96a8-5c437985f71a";
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	       
	        
            //String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Renewal_jan_TC_5337.xlsx\",\"UniqueFileName\":\"S20168320180606.xlsx\",\"BordereauFormatId\":\"9303af0c-5c78-4764-96a8-5c437985f71a\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20168320180606.xlsx\",\"Filesize\":18378,\"Path\":null,\"size\":18378,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);	
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				BordereauPage.openDATALink();
				BordereauPage.navigateToDATARiskTab();	
				mouseOver(EfectiveDate);
				verifyExists(EfectiveDate,"Efective date");
				/*click(EfectiveDate,"Effective date");
				waitForElementToAppear(Okbtn,5);
				sleep(1500);
				verifyExists(RuleName,"Rule Name Field");
				actualRuleName = getTextFrom(RuleName,"Rule name");
				
				click(Okbtn,"ok Buttton");*/
				waitForElementToAppear(BordereauPage.BORDEREAUXLink,5);
				sleep(1500);
				verifyMustExists(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
				click(BordereauPage.BORDEREAUXLink,"BORDEREAUX Link");
				BordereauPage.deleteBorderEAUX();
				
			} else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}
	
	public void RiskInceptionDateasEndormentEfDate_1900()  throws Exception {
	
	//	policy.CreateContractwithInceptionDate2018();
		
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
				
				String Ufname = "S26826320181111.xlsx";	
				int size = 22330;
				String BordreauID = "34ba1e41-d8d7-4ae6-9870-d57e19a93aff";
		        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
		        String ID = extractIDFromResponseinsideContract(response); 
		        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
		        addAsDraft(payload,DraftUrl);
				
				
				//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Renewal_jan_TC_5337.xlsx\",\"UniqueFileName\":\"S41904720180520.xlsx\",\"BordereauFormatId\":\"87ff463a-ac88-4a6a-9b80-9e5e892aeb2d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S41904720180520.xlsx\",\"Filesize\":18027,\"Path\":null,\"size\":18027,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//	String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Renewal_jan_TC_5337.xlsx\",\"UniqueFileName\":\"S20168320180606.xlsx\",\"BordereauFormatId\":\"9303af0c-5c78-4764-96a8-5c437985f71a\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20168320180606.xlsx\",\"Filesize\":18378,\"Path\":null,\"size\":18378,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan2018_effectivedatenotsupplied.xlsx\",\"UniqueFileName\":\"S15118420180620.xlsx\",\"BordereauFormatId\":\"06e9f32d-e377-4391-8049-c9c26a031634\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15118420180620.xlsx\",\"UniqueFileName\":\"S15118420180620.xlsx\",\"Filesize\":22309,\"Path\":null,\"size\":22309,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				BordereauPage.refreshUploadedFile();
				sleep(2000);
				if(isVisible(BordereauPage.ReviewBtn)== true){
					AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
					Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
					sleep(2000);
					BordereauPage.openDATALink();
					BordereauPage.navigateToDATARiskTab();
					sleep(2000);
					mouseOver(EfectiveDate);
					verifyExists(EfectiveDate,"Efective date");
					click(EfectiveDate,"Effective date");
					waitForElementToAppear(Okbtn,5);
					sleep(1500);
					verifyExists(RuleName,"Rule Name Field");
					actualRuleName = getTextFrom(RuleName,"Rule name");
					click(Okbtn,"ok Buttton");
					
					
					policy.navigationOnBordereauxTab();
					BordereauPage.deleteBorderEAUX();
					
				} else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					policy.navigationOnBordereauxTab();
					BordereauPage.deleteBorderEAUX();
				} 
		
}	


	public void NegativeToPositiveScenario()  throws Exception {
	
	policy.CreateContractwithInceptionDate2018();

	String GetData = Configuration.url + "/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""
			+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	try {
		String fpath = new File(".").getCanonicalPath();
		sheet3770Path = fpath + "\\src\\test\\resources\\testdata\\Positive to Negative and Negative to Positive Scenarios.xlsx";
	} catch (IOException e) {
		e.printStackTrace();
	}
	File excelFile = new File(sheet3770Path); 
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);

	String Ufname = "S20972420181102.xlsx"; // unique Reference    
	int size = 10455;//File Size
	String BordreauID = "e99c6088-4fa1-40ee-84d5-c9aec44943a3";//Format ID
	String response = uploadFileinContract(ReqUrl, excelFile, policy.contractId, Ufname);
	String ID = extractIDFromResponseinsideContract(response);
	String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1, "1", 2018);
	addAsDraft(payload, DraftUrl);
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl
		BordereauPage.refreshUploadedFile();
		
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(1500);				
				BordereauPage.navigateToDATATab();
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				String GrossPremiumRow = "@xpath=//*[@data-title='Gross Premium']";
				String GrossPrmiumAmount = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[27]";
				String GRPOriginalVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
				String GRPChngdVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
							
				waitForElementToAppear(GrossPremiumRow,5);
				mouseOverAction(GrossPremiumRow);
				verifyMustExists(GrossPremiumRow,"Gross Premium column");
				GRP =  getTextFrom(GrossPremiumRow);
				Report.LogInfo("Gross Premium column",GRP , "PASS");
				sleep(2000);
				verifyExists(GrossPrmiumAmount,"1st value");
				GRP1 =  getTextFrom(GrossPrmiumAmount);
				Report.LogInfo("Gross Premium column",GRP1 , "PASS");
				click(GrossPrmiumAmount,"value");
				sleep(1500);
				waitForElementToAppear(Okbtn,10);
				verifyExists(GRPOriginalVlu,"Gross Premium Originak Value");
				GROrgVlu = getTextFrom(GRPOriginalVlu);
				Report.LogInfo("Gross Premium Original Value",GROrgVlu , "PASS");
				sleep(1500);
				verifyMustExists(GRPChngdVlu,"Gross Premium Changed Value");
				GRChngdVlu = getTextFrom(GRPChngdVlu);
				Report.LogInfo("Gross Premium Changed Value",GRChngdVlu , "PASS");
				//click(GRPChngdVlu,"Gross Premium Changed Value");
				sleep(1500);
				verifyExists(RuleNameField,"Rule Name Field");
				GRPRule =  getTextFrom(RuleNameField);
				Report.LogInfo("Rule Name Field", GRPRule, "PASS");
				click(Okbtn,"ok Buttton");
				policy.navigationOnBordereauxTab();
				//BordereauPage.deleteBorderEAUX();

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}	
			}

	public void RiskExpiryDatedefaultedfroRiskInceptionDateplus1year()  throws Exception {
	
	policy.CreateContractwithInceptionDate2018();

	String GetData = Configuration.url + "/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""
			+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	try {
		String fpath = new File(".").getCanonicalPath();
		sheet3770Path = fpath + "\\src\\test\\resources\\testdata\\TC inception date plus 1 year.xlsx";
	} catch (IOException e) {
		e.printStackTrace();
	}
	File excelFile = new File(sheet3770Path); 
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);

	String Ufname = "S69975320181105.xlsx"; // unique Reference    
	int size = 9938;//File Size
	String BordreauID = "8d5f47b7-748e-4a39-949d-0c08a7b199a6";//Format ID
	String response = uploadFileinContract(ReqUrl, excelFile, policy.contractId, Ufname);
	String ID = extractIDFromResponseinsideContract(response);
	String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1, "1", 2018);
	addAsDraft(payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(1500);			
				BordereauPage.navigateToDATATab();
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				String RiskExpiryDateRow = "@xpath=//*[@data-title='Risk Expiry Date']";
				String RiskExpiryChangdDate = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[16]";
				String RExpiryOriginalVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
				String RExpiryChngdVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
							
				waitForElementToAppear(RiskExpiryDateRow,5);
				mouseOverAction(RiskExpiryDateRow);
				verifyMustExists(RiskExpiryDateRow,"Risk Expiry Date column");
				RiskExpiryDate =  getTextFrom(RiskExpiryDateRow);
				Report.LogInfo("Risk Expiry Date column",RiskExpiryDate , "PASS");
				sleep(2000);
				verifyExists(RiskExpiryChangdDate,"1st value");
				RiskExpiryDateValue =  getTextFrom(RiskExpiryChangdDate);
				Report.LogInfo("Risk Expiry Date Value",RiskExpiryDateValue , "PASS");
				click(RiskExpiryChangdDate,"value");
				sleep(1500);
				waitForElementToAppear(Okbtn,10);
				verifyExists(RExpiryOriginalVlu,"Gross Premium Originak Value");
				RiskExpiryDateOrignlValue = getTextFrom(RExpiryOriginalVlu);
				Report.LogInfo("Risk Expiry Date Original Value",RiskExpiryDateOrignlValue , "PASS");
				sleep(1500);
				verifyMustExists(RExpiryChngdVlu,"Gross Premium Changed Value");
				RiskExpiryDateChngdValue = getTextFrom(RExpiryChngdVlu);
				Report.LogInfo("Risk Expiry Date Changed Value ",RiskExpiryDateChngdValue , "PASS");
				sleep(1500);
				verifyExists(RuleNameField,"Rule Name Field");
				RiskExpiryDateRule =  getTextFrom(RuleNameField);
				Report.LogInfo("Rule Name Field", RiskExpiryDateRule, "PASS");
				click(Okbtn,"ok Buttton");				
				policy.navigationOnBordereauxTab();
				//BordereauPage.deleteBorderEAUX();

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}	
			}
	public void RiskExpiryDateDefaultedtoFinalDayofBordereauReportingPeriod()  throws Exception {
	
	policy.CreateContractwithInceptionDate2018();

	String GetData = Configuration.url + "/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""
			+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	try {
		String fpath = new File(".").getCanonicalPath();
		sheet3770Path = fpath + "\\src\\test\\resources\\testdata\\Tc Risk Expiry Date defaulted to the final day of the Bordereau reporting period.xlsx";
	} catch (IOException e) {
		e.printStackTrace();
	}
	File excelFile = new File(sheet3770Path); 
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);

	String Ufname = "S69975320181105.xlsx"; // unique Reference    
	int size = 9938;//File Size
	String BordreauID = "8d5f47b7-748e-4a39-949d-0c08a7b199a6";//Format ID
	String response = uploadFileinContract(ReqUrl, excelFile, policy.contractId, Ufname);
	String ID = extractIDFromResponseinsideContract(response);
	String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1, "1", 2018);
	addAsDraft(payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(1500);			
				BordereauPage.navigateToDATATab();
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				String RiskExpiryDateRow = "@xpath=//*[@data-title='Risk Expiry Date']";
				String RiskExpiryChangdDate = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[16]";
				String RExpiryOriginalVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
				String RExpiryChngdVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
							
				waitForElementToAppear(RiskExpiryDateRow,5);
				mouseOverAction(RiskExpiryDateRow);
				verifyMustExists(RiskExpiryDateRow,"Risk Expiry Date column");
				RiskExpiryDate =  getTextFrom(RiskExpiryDateRow);
				Report.LogInfo("Risk Expiry Date column",RiskExpiryDate , "PASS");
				sleep(2000);
				verifyExists(RiskExpiryChangdDate,"1st value");
				RiskExpiryDateValue =  getTextFrom(RiskExpiryChangdDate);
				Report.LogInfo("Risk Expiry Date Value",RiskExpiryDateValue , "PASS");
				click(RiskExpiryChangdDate,"value");
				sleep(1500);
				waitForElementToAppear(Okbtn,10);
				verifyExists(RExpiryOriginalVlu,"Gross Premium Originak Value");
				RiskExpiryDateOrignlValue = getTextFrom(RExpiryOriginalVlu);
				Report.LogInfo("Risk Expiry Original Value",RiskExpiryDateOrignlValue , "PASS");
				sleep(1500);
				verifyMustExists(RExpiryChngdVlu,"Gross Premium Changed Value");
				RiskExpiryDateChngdValue = getTextFrom(RExpiryChngdVlu);
				Report.LogInfo("Risk Expiry Changed Value",RiskExpiryDateChngdValue , "PASS");
				sleep(1500);
				verifyExists(RuleNameField,"Rule Name Field");
				RiskExpiryDateRule =  getTextFrom(RuleNameField);
				Report.LogInfo("Rule Name Field", RiskExpiryDateRule, "PASS");
				click(Okbtn,"ok Buttton");				
				policy.navigationOnBordereauxTab();
				//BordereauPage.deleteBorderEAUX();

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}	
			}


	public void ExtractCurrencyfromSheetName()  throws Exception {
	
	policy.CreateContractwithInceptionDate2018();

	String GetData = Configuration.url + "/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""
			+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	try {
		String fpath = new File(".").getCanonicalPath();
		sheet3770Path = fpath + "\\src\\test\\resources\\testdata\\TC 3776 AsertCCYFromSheetName.xlsx";
	} catch (IOException e) {
		e.printStackTrace();
	}
	File excelFile = new File(sheet3770Path); 
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);

	String Ufname = "S74564720181105.xlsx"; // unique Reference    
	int size = 9879;//File Size
	String BordreauID = "c02cf1ac-5031-4a88-84da-e030c20e3597";//Format ID
	String response = uploadFileinContract(ReqUrl, excelFile, policy.contractId, Ufname);
	String ID = extractIDFromResponseinsideContract(response);
	String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1, "1", 2018);
	addAsDraft(payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
		
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(1500);			
				BordereauPage.navigateToDATATab();
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				String PremiumCCYRow = "@xpath=//*[@data-title='Premium Currency']";
				String PremiumCCYValue = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[35]";
				String PrmeiumOrgnlCCY = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
				String PremiumChngdCCY = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
				String RiskCCYRow = "@xpath=//*[@data-title='Risk Currency']";
				String RiskCCYValue = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[35]";
				String RiskOrgnlCCY = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
				String RiskChngdCCY = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
							
				waitForElementToAppear(PremiumCCYRow,5);
				mouseOverAction(PremiumCCYRow);
				verifyMustExists(PremiumCCYRow,"Premium CCY Row column");
				PreCCYRow =  getTextFrom(PremiumCCYRow);
				Report.LogInfo("Premium Currency Column",PreCCYRow , "PASS");
				sleep(2000);
				verifyExists(PremiumCCYValue,"1st value");
				PreCCYValue =  getTextFrom(PremiumCCYValue);
				Report.LogInfo("Premium Currency Value",PreCCYValue , "PASS");
				click(PremiumCCYValue,"value");
				sleep(1500);
				waitForElementToAppear(Okbtn,10);
				verifyExists(PrmeiumOrgnlCCY,"Premium Currency Original Value");
				PreCCYOrgVl = getTextFrom(PrmeiumOrgnlCCY);
				Report.LogInfo("Premium Currency Original Value",PreCCYOrgVl , "PASS");
				sleep(1500);
				verifyMustExists(PremiumChngdCCY,"Premium Currency Changed Value");
				PreCCYChngdVl = getTextFrom(PremiumChngdCCY);
				Report.LogInfo("Premium Currency Changed Value",PreCCYChngdVl , "PASS");
				sleep(1500);
				verifyExists(RuleNameField,"Rule Name Field");
				RiskExpiryDateRule =  getTextFrom(RuleNameField);
				Report.LogInfo("Rule Name Field", RiskExpiryDateRule, "PASS");
				click(Okbtn,"ok Buttton");	
				//Risk CCY
				sleep(2000);
				waitForElementToAppear(RiskCCYRow,5);
				mouseOverAction(RiskCCYRow);
				verifyMustExists(RiskCCYRow,"Risk CCY Column");
				RiskCCYColumn =  getTextFrom(RiskCCYRow);
				Report.LogInfo("Risk CCY Column",RiskCCYColumn , "PASS");
				sleep(2000);
				verifyExists(RiskCCYValue,"1st value");
				RiskCCYvaluerow = getTextFrom(RiskCCYValue);
				Report.LogInfo("Risk CCY Value",RiskCCYvaluerow , "PASS");
				click(RiskCCYValue,"value");
				sleep(1500);
				waitForElementToAppear(Okbtn,10);
				verifyExists(RiskOrgnlCCY,"Risk CCY Original Value");
				RiskCCyOrgVlu = getTextFrom(RiskOrgnlCCY);
				Report.LogInfo("Risk CCY Original Value",RiskCCyOrgVlu , "PASS");
				sleep(1500);
				verifyMustExists(RiskChngdCCY,"Risk CCY Changed Value");
				RiskCCyChngdVlu = getTextFrom(RiskChngdCCY);
				Report.LogInfo("Risk CCY Changed Value",RiskCCyChngdVlu , "PASS");
				sleep(1500);
				verifyExists(RuleNameField,"Rule Name Field");
				RiskExpiryDateRule =  getTextFrom(RuleNameField);
				Report.LogInfo("Rule Name Field", RiskExpiryDateRule, "PASS");
				click(Okbtn,"ok Buttton");				
				policy.navigationOnBordereauxTab();
				
				

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				BordereauPage.deleteBorderEAUX();
			}	
			}


public void RiskInceptionDateDefaultedtoFirstDayofBordereauReportingPeriod()  throws Exception {
	
	policy.CreateContractwithInceptionDate2018();
	ArrayList<String> DataCaptureIception = new ArrayList<String>();

	String GetData = Configuration.url + "/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""
			+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	try {
		String fpath = new File(".").getCanonicalPath();
		sheet3865Path = fpath + "\\src\\test\\resources\\testdata\\3865 TC First day of contract for inception date by default.xlsx";
	} catch (IOException e) {
		e.printStackTrace();
	}
	File excelFile = new File(sheet3865Path); 
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);

	String Ufname = "S60148520181117.xlsx"; // unique Reference    
	int size = 9879;//File Size
	String BordreauID = "4cc79a09-9ec3-47fa-a1b3-a3a7a3a88f87";//Format ID
	String response = uploadFileinContract(ReqUrl, excelFile, policy.contractId, Ufname);
	String ID = extractIDFromResponseinsideContract(response);
	String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1, "1", 2018);
	addAsDraft(payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(1500);			
				BordereauPage.navigateToDATATab();
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				String RiskIncepDateRow = "@xpath=//*[@data-title='Risk Inception Date']";
				String RiskInceptionChangdDate = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[15]";	//"//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')]";
				String RInceptionOriginalVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
				String RInceptionChngdVlu = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
							
				DataCaptureIception =  BordereauPage.RuleDataCapture(RiskInceptionChangdDate,"Risk Inception date","-","01/01/2018","Risk Inception Date defaulted to the first day of the Bordereau reporting period");
				RiskIncptnDteOrgValue = DataCaptureIception.get(0);
				RiskIncptnChngVlue = DataCaptureIception.get(1);
				RiskExpiryDateRule = DataCaptureIception.get(2);		
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();

			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();
			}	
}

public void VerifydefaultIsSpecifiedastheReviewStepofTheRiskQuestionnaireTC4158() throws InterruptedException, ClientProtocolException, AWTException, IOException{
	homePage.adminMenu();
	BQPage.bordereauQueLink();
	BQPage.bordereauQuePage();
	BQPage.addQuestionaireforDV();
}

public void ApplyDefaultWhenThereIsNoSuppliedValueForThisFieldTC4160() throws Exception {
/*	policy.PolicyNumber = "961853JL";
	BordereauPage.applyFilterPolicy(policy.PolicyNumber);		
	BordereauPage.openSelectedPolicy();*/
	policy.CreateContractwithInceptionDate2018();
	
	String GetData = Configuration.url + "/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""
			+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	try {
		String fpath = new File(".").getCanonicalPath();
		sheet3865Path = fpath + "\\src\\test\\resources\\testdata\\Default_Specified_TC4160.xlsx";
	} catch (IOException e) {
		e.printStackTrace();
	}
	File excelFile = new File(sheet3865Path); 
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);

	String Ufname = "S19438420181110.xlsx"; 
	int size = 19617;//File Size
	String BordreauID = "eb3e8312-dca3-4149-b46b-69c9b0ceb14d";//Format ID
	String response = uploadFileinContract(ReqUrl, excelFile, policy.contractId, Ufname);
	String ID = extractIDFromResponseinsideContract(response);
	String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1, "1", 2018);
	addAsDraft(payload, DraftUrl);
		BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauPage.ReviewBtn)== true){
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(1500);			
				BordereauPage.navigateToDATATab();
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				String BuildingValue = "@xpath=//*[@data-field='A_Buildings_Value']//following::tr[1]//td[contains(@ng-click,'A_Buildings_Value')]";
				BordereauPage.RuleDataCapture(BuildingValue,"Building valu","-","10","Default value for A - Buildings Value field is set in Questionnaire as 10.");

			}
			
			else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();
			}	
	
}
public void ApplyDefaultForallrecordsRegardlessoftheSuppliedvalueTC4161() throws Exception {
	
	
	String ContentValue = "@xpath=//*[@data-field='C_Contents_Value']//following::tr[1]//td[contains(@ng-click,'C_Contents_Value')]";
	
	BordereauPage.RuleDataCapture(ContentValue,"ContentValue valu","1000","20.00","Default value for C - Contents Value field is set in Questionnaire as 20.");

}

public void ApplyDefaultforMultiRuleConditionTC4162() throws InterruptedException {
                 
	String Sprinkler = "@xpath=//*[@data-field='Location_Sprinklers_YN']//following::tr[4]//td[contains(@ng-click,'Location_Sprinklers_YN')]";
                  BordereauPage.RuleDataCapture(Sprinkler,"Sprinklers","-","Yes","Default value for Location Sprinklers (Y/N) field is set in Questionnaire as Yes. , or Yes if Bordereau column Insured Name Equal To Insured 1");
                  policy.navigationOnBordereauxTab();
                  BordereauPage.deleteBorderEAUX();
}
}








	
	
	
	
	
	