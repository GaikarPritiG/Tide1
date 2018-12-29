package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.Page;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class DefaultCurrencyChangeRulePage extends PageBase{

	public String Rowno1;
	public String Rowno2;
	public String actualRuleName;
	public String errorTitleValidate;
	public String errorTitleValidate1;
	public String errorTitleValidate2;
	public static String sheet6168PathScnd = "";
	public String ActualDPVCOriginal;
	public String ActualDPVCChanged; 
	public String ActualDPVCRuleName;
	public String ActualDPVCOriginal1;
	public String ActualDPVCChanged1; 
	public String ActualDPVCRuleName1;
	public String ActualTCOriginal;
	public String ActualTCOriginal1;
	public String ActualTCChanged;
	public String ActualTCChanged1;
	public String ActualTCRuleName;
	public String ActualTCRuleName1;
	public String TC1;
	public String TC2;
	
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQ = new BordereauQuePage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	SchemaPage schema = new SchemaPage();
	public static final String ContinueBtn ="@xpath=//button[@class='btn btn-success p-lr-lg']";
	public static final String Data0DD ="@xpath=//*[@id='Data0']//preceding-sibling::span[1]";
	public static final String Premiumcurrency ="@xpath=//li[contains(text(),'GBP - Pound Sterling')]";
	public static final String Riskcurrency ="@xpath=//li[contains(text(),'USD - US Dollar')]";
	public static final String Taxcurrency1 ="@xpath=//li[contains(text(),'CAD - Canadian Dollar')]";
	public static final String taxcurrency1 = "@xpath=//li[contains(text(),'CAD - Canadian Dollar')]";
	
	
	public void TC3760DefaultCurrencyChangeRule() throws Exception {
		
		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		ArrayList<String> DataCapture4 = new ArrayList<String>();
	
			
			/*policy.CreateContractwithInceptionDate2018();
			
			policy.navigateToReportingChannelsTab();*/
			
		
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
				sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Defaultcurrencychangerule_TC3760.xlsx";
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
			String Ufname = "S58037920181107.xlsx";	
			int size = 18817;
			String BordreauID = "7587fab0-8e35-465d-a6a7-3bd4297e9475";
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        BordereauPage.refreshUploadedFile();
	        
	        
	        
	        if (isVisible(BordereauPage.ReviewBtn) == true) {
				AssertBordereauStatusReview =  getTextFrom(BordereauPage.ReviewBtn);
				Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
				BordereauPage.openDATALink();
			
				BordereauPage.navigateToDATARiskTab();
				sleep(2000);
				// Row number column
				
				String RowNumber = "@xpath=//*[@data-field='RowNumber']";
				String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
				String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='4']";
				verifyExists(RowNumber1, "1st value");
				verifyExists(RowNumber2, "1st value");
				Rowno1 = getTextFrom(RowNumber1);
				Rowno2 = getTextFrom(RowNumber2);
				sleep(2000);
				

				// Daily Production Value Currency Column
				String DailyProductionValueCurrency = "@xpath=//*[@data-field='Daily_Production_Value_Currency']";
				String DailyProductionValueCurrency1 = "@xpath=//*[@data-field='Daily_Production_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Daily_Production_Value_Currency')][text()='USD']";
				String DailyProductionValueCurrency2 = "@xpath=//*[@data-field='Daily_Production_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Daily_Production_Value_Currency')][text()='USD']";
				DataCapture1 =	BordereauPage.RuleDataCapture(DailyProductionValueCurrency1,"Daily Production Value Currency","-","USD","Default Currency used");
				ActualDPVCOriginal = DataCapture1.get(0);
				ActualDPVCChanged = DataCapture1.get(1);
				ActualDPVCRuleName = DataCapture1.get(2);
				DataCapture2 = BordereauPage.RuleDataCapture(DailyProductionValueCurrency2,"Daily Production Value Currency","-","USD","Default Currency used");
				ActualDPVCOriginal1 = DataCapture2.get(0);
				ActualDPVCChanged1 = DataCapture2.get(1);
				ActualDPVCRuleName1 = DataCapture2.get(2);
				
	        
				// Deductible/Excess Currency Column
				String DeductibleExcessCurrency = "@xpath=//*[@data-field='DeductibleExcess_Currency']";
				String DeductibleExcessCurrency1 = "@xpath=//*[@data-field='DeductibleExcess_Currency']//following::tr[1]//td[contains(@ng-click,'DeductibleExcess_Currency')][text()='USD']";
				String DeductibleExcessCurrency2 = "@xpath=//*[@data-field='DeductibleExcess_Currency']//following::tr[2]//td[contains(@ng-click,'DeductibleExcess_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(DeductibleExcessCurrency1,"Daily Production Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(DeductibleExcessCurrency2,"Daily Production Value Currency","-","USD","Default Currency used");
					
				
				// Fixed Sum Payment Currency Column
				String FixedSumPaymentCurrency = "@xpath=//*[@data-field='Fixed_Sum_Payment_Currency']";
				String FixedSumPaymentCurrency1 = "@xpath=//*[@data-field='Fixed_Sum_Payment_Currency']//following::tr[1]//td[contains(@ng-click,'Fixed_Sum_Payment_Currency')][text()='USD']";
				String FixedSumPaymentCurrency2 = "@xpath=//*[@data-field='Fixed_Sum_Payment_Currency']//following::tr[2]//td[contains(@ng-click,'Fixed_Sum_Payment_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(FixedSumPaymentCurrency1,"Fixed Sum Payment Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(FixedSumPaymentCurrency2,"Fixed Sum Payment Currency","-","USD","Default Currency used");
					
				
				// Goods Value Currency Column
				String GoodsValueCurrency = "@xpath=//*[@data-field='Goods_Value_Currency']";
				String GoodsValueCurrency1 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Goods_Value_Currency')][text()='USD']";
				String GoodsValueCurrency2 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Goods_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(GoodsValueCurrency1,"Goods Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(GoodsValueCurrency2,"Goods Value Currency","-","USD","Default Currency used");
					
				
				// Individual Livestock Value Currency Column
				String IndividualLivestockValueCurrency = "@xpath=//*[@data-field='Individual_Livestock_Value_Currency']";
				String IndividualLivestockValueCurrency1 = "@xpath=//*[@data-field='Individual_Livestock_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Individual_Livestock_Value_Currency')][text()='USD']";
				String IndividualLivestockValueCurrency2 = "@xpath=//*[@data-field='Individual_Livestock_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Individual_Livestock_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(IndividualLivestockValueCurrency1,"Individual Livestock Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(IndividualLivestockValueCurrency2,"Individual Livestock Value Currency","-","USD","Default Currency used");
					
				// Insured Revenue Or Turnover Currency Column
				String InsuredRevenueOrTurnoverCurrency = "@xpath=//*[@data-field='Insured_Revenue_Or_Turnover_Currency']";
				String InsuredRevenueOrTurnoverCurrency1 = "@xpath=//*[@data-field='Insured_Revenue_Or_Turnover_Currency']//following::tr[1]//td[contains(@ng-click,'Insured_Revenue_Or_Turnover_Currency')][text()='USD']";
				String InsuredRevenueOrTurnoverCurrency2 = "@xpath=//*[@data-field='Insured_Revenue_Or_Turnover_Currency']//following::tr[2]//td[contains(@ng-click,'Insured_Revenue_Or_Turnover_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(InsuredRevenueOrTurnoverCurrency1,"Insured Revenue Or Turnover Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(InsuredRevenueOrTurnoverCurrency2,"Insured Revenue Or Turnover Currency","-","USD","Default Currency used");
				
				// Insured US Turnover Currency Column
				String InsuredUSTurnoverCurrency = "@xpath=//*[@data-field='Insured_US_Turnover_Currency']";
				String InsuredUSTurnoverCurrency1 = "@xpath=//*[@data-field='Insured_US_Turnover_Currency']//following::tr[1]//td[contains(@ng-click,'Insured_US_Turnover_Currency')][text()='USD']";
				String InsuredUSTurnoverCurrency2 = "@xpath=//*[@data-field='Insured_US_Turnover_Currency']//following::tr[2]//td[contains(@ng-click,'Insured_US_Turnover_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(InsuredUSTurnoverCurrency1,"Insured US Turnover Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(InsuredUSTurnoverCurrency2,"Insured US Turnover Currency","-","USD","Default Currency used");
				
				// Livestock Value Per Head Currency Column
				String LivestockValuePerHeadCurrency = "@xpath=//*[@data-field='Goods_Value_Currency']";
				String LivestockValuePerHeadCurrency1 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Livestock_Value_Per_Head_Currency')][text()='USD']";
				String LivestockValuePerHeadCurrency2 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Livestock_Value_Per_Head_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(LivestockValuePerHeadCurrency1,"Livestock Value Per Head Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(LivestockValuePerHeadCurrency2,"Livestock Value Per Head Currency","-","USD","Default Currency used");
				
				// Location Limit Currency Column
				String LocationLimitCurrency = "@xpath=//*[@data-field='Location_Limit_Currency']";
				String LocationLimitCurrency1 = "@xpath=//*[@data-field='Location_Limit_Currency']//following::tr[1]//td[contains(@ng-click,'Location_Limit_Currency')][text()='USD']";
				String LocationLimitCurrency2 = "@xpath=//*[@data-field='Location_Limit_Currency']//following::tr[2]//td[contains(@ng-click,'Location_Limit_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(LocationLimitCurrency1,"Location Limit Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(LocationLimitCurrency2,"Location Limit Currency","-","USD","Default Currency used");
				
				
				// Maximum Benefit Any One Event Currency Column
				String MaximumBenefitAnyOneEventCurrency = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Event_Currency']";
				String MaximumBenefitAnyOneEventCurrency1 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Event_Currency']//following::tr[1]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Event_Currency')][text()='USD']";
				String MaximumBenefitAnyOneEventCurrency2 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Event_Currency']//following::tr[2]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Event_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOneEventCurrency1,"Maximum Benefit Any One Event Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOneEventCurrency2,"Maximum Benefit Any One Event Currency","-","USD","Default Currency used");
				
				
				// Maximum Benefit Period Currency Column
				String MaximumBenefitPeriodCurrency = "@xpath=//*[@data-field='Maximum_Benefit_Period_Currency']";
				String MaximumBenefitPeriodCurrency1 = "@xpath=//*[@data-field='Maximum_Benefit_Period_Currency']//following::tr[1]//td[contains(@ng-click,'Maximum_Benefit_Period_Currency')][text()='USD']";
				String MaximumBenefitPeriodCurrency2 = "@xpath=//*[@data-field='Maximum_Benefit_Period_Currency']//following::tr[2]//td[contains(@ng-click,'Maximum_Benefit_Period_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(MaximumBenefitPeriodCurrency1,"Maximum Benefit Period Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(MaximumBenefitPeriodCurrency2,"Maximum Benefit Period Currency","-","USD","Default Currency used");
				
				
				// Maximum Benefit Any One Person Currency Column
				String MaximumBenefitAnyOnePersonCurrency = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Person_Currency']";
				String MaximumBenefitAnyOnePersonCurrency1 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Person_Currency']//following::tr[1]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Person_Currency')][text()='USD']";
				String MaximumBenefitAnyOnePersonCurrency2 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Person_Currency']//following::tr[2]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Person_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOnePersonCurrency1,"Maximum Benefit Any One Person Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOnePersonCurrency2,"Maximum Benefit Any One Person Currency","-","USD","Default Currency used");
				

				// Prize Value Currency Column
				String PrizeValueCurrency = "@xpath=//*[@data-field='Prize_Value_Currency']";
				String PrizeValueCurrency1 = "@xpath=//*[@data-field='Prize_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Prize_Value_Currency')][text()='USD']";
				String PrizeValueCurrency2 = "@xpath=//*[@data-field='Prize_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Prize_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(PrizeValueCurrency1,"Prize Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(PrizeValueCurrency2,"Prize Value Currency","-","USD","Default Currency used");
				

				// Product Annual Sales Currency Column
				String ProductAnnualSalesCurrency = "@xpath=//*[@data-field='Product_Annual_Sales_Currency']";
				String ProductAnnualSalesCurrency1 = "@xpath=//*[@data-field='Product_Annual_Sales_Currency']//following::tr[1]//td[contains(@ng-click,'Product_Annual_Sales_Currency')][text()='USD']";
				String ProductAnnualSalesCurrency2 = "@xpath=//*[@data-field='Product_Annual_Sales_Currency']//following::tr[2]//td[contains(@ng-click,'Product_Annual_Sales_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(ProductAnnualSalesCurrency1,"Product Annual Sales Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(ProductAnnualSalesCurrency2,"Product Annual Sales Currency","-","USD","Default Currency used");
				

				// Product Estimated Annual Sales Currency Column
				String ProductEstimatedAnnualSalesCurrency = "@xpath=//*[@data-field='Product_Estimated_Annual_Sales_Currency']";
				String ProductEstimatedAnnualSalesCurrency1 = "@xpath=//*[@data-field='Product_Estimated_Annual_Sales_Currency']//following::tr[1]//td[contains(@ng-click,'Product_Estimated_Annual_Sales_Currency')][text()='USD']";
				String ProductEstimatedAnnualSalesCurrency2 = "@xpath=//*[@data-field='Product_Estimated_Annual_Sales_Currency']//following::tr[2]//td[contains(@ng-click,'Product_Estimated_Annual_Sales_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(ProductEstimatedAnnualSalesCurrency1,"Product Estimated Annual Sales Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(ProductEstimatedAnnualSalesCurrency2,"Product Estimated Annual Sales Currency","-","USD","Default Currency used");
				

				// Wage Roll Annual Salary Currency Column
				String WageRollAnnualSalaryCurrency = "@xpath=//*[@data-field='Wage_Roll_Annual_Salary_Currency']";
				String WageRollAnnualSalaryCurrency1 = "@xpath=//*[@data-field='Wage_Roll_Annual_Salary_Currency']//following::tr[1]//td[contains(@ng-click,'Wage_Roll_Annual_Salary_Currency')][text()='USD']";
				String WageRollAnnualSalaryCurrency2 = "@xpath=//*[@data-field='Wage_Roll_Annual_Salary_Currency']//following::tr[2]//td[contains(@ng-click,'Wage_Roll_Annual_Salary_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(WageRollAnnualSalaryCurrency1,"Wage Roll Annual Salary Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(WageRollAnnualSalaryCurrency2,"Wage Roll Annual Salary Currency","-","USD","Default Currency used");
				

				// Vessel Value Currency Column
				String VesselValueCurrency = "@xpath=//*[@data-field='Vessel_Value_Currency']";
				String VesselValueCurrency1 = "@xpath=//*[@data-field='Vessel_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Vessel_Value_Currency')][text()='USD']";
				String VesselValueCurrency2 = "@xpath=//*[@data-field='Vessel_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Vessel_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(VesselValueCurrency1,"Vessel Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(VesselValueCurrency2,"Vessel Value Currency","-","USD","Default Currency used");
				
				
				// Vessel Purchase Price Currency Column
				String VesselPurchasePriceCurrency = "@xpath=//*[@data-field='Vessel_Purchase_Price_Currency']";
				String VesselPurchasePriceCurrency1 = "@xpath=//*[@data-field='Vessel_Purchase_Price_Currency']//following::tr[1]//td[contains(@ng-click,'Vessel_Purchase_Price_Currency')][text()='USD']";
				String VesselPurchasePriceCurrency2 = "@xpath=//*[@data-field='Vessel_Purchase_Price_Currency']//following::tr[2]//td[contains(@ng-click,'Vessel_Purchase_Price_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(VesselPurchasePriceCurrency1,"Vessel Purchase Price Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(VesselPurchasePriceCurrency2,"Vessel Purchase Price Currency","-","USD","Default Currency used");
				
				// Tax Currency 1 Column
				String TaxCurrency_1 = "@xpath=//*[@data-field='Tax_Currency_1']";
				String TaxCurrency_11 = "@xpath=//*[@data-field='Tax_Currency_1']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_1')][text()='CAD']";
				String TaxCurrency_12 = "@xpath=//*[@data-field='Tax_Currency_1']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_1')][text()='CAD']";
				
				waitForElementToAppear(TaxCurrency_1, 20);
				mouseOverAction(TaxCurrency_1);
				verifyMustExists(TaxCurrency_1, "Tax Currency 1 Column");
				sleep(2000);
				verifyExists(TaxCurrency_11, "1st value");
				verifyExists(TaxCurrency_12, "2nd value");
				TC1 = getTextFrom(TaxCurrency_11);
				TC2 = getTextFrom(TaxCurrency_12);
				sleep(2000);
				
				
				// Tax Currency 2 Column
				String TaxCurrency_2 = "@xpath=//*[@data-field='Tax_Currency_2']";
				String TaxCurrency_21 = "@xpath=//*[@data-field='Tax_Currency_2']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_2')][text()='GBP']";
				String TaxCurrency_22 = "@xpath=//*[@data-field='Tax_Currency_2']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_2')][text()='GBP']";
				DataCapture3  =	BordereauPage.RuleDataCapture(TaxCurrency_21,"Tax Currency 2","-","GBP","Default Currency used");
				ActualTCOriginal = DataCapture3.get(0);
				ActualTCChanged = DataCapture3.get(1);
				ActualTCRuleName = DataCapture3.get(2);
				DataCapture4 = BordereauPage.RuleDataCapture(TaxCurrency_22,"Tax Currency 2","-","GBP","Default Currency used");
				ActualTCOriginal1 = DataCapture4.get(0);
				ActualTCChanged1 = DataCapture4.get(1);
				ActualTCRuleName1 = DataCapture4.get(2);
				
				
				// Tax Currency 3 Column
				String TaxCurrency_3 = "@xpath=//*[@data-field='Tax_Currency_3']";
				String TaxCurrency_31 = "@xpath=//*[@data-field='Tax_Currency_3']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_3')][text()='GBP']";
				String TaxCurrency_32 = "@xpath=//*[@data-field='Tax_Currency_3']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_3')][text()='GBP']";
				BordereauPage.RuleDataCapture(TaxCurrency_31,"Tax Currency 3","-","GBP","Default Currency used");
				BordereauPage.RuleDataCapture(TaxCurrency_32,"Tax Currency 3","-","GBP","Default Currency used");
				
				// Tax Currency 4 Column
				String TaxCurrency_4 = "@xpath=//*[@data-field='Tax_Currency_4']";
				String TaxCurrency_41 = "@xpath=//*[@data-field='Tax_Currency_4']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_4')][text()='GBP']";
				String TaxCurrency_42 = "@xpath=//*[@data-field='Tax_Currency_4']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_4')][text()='GBP']";
				BordereauPage.RuleDataCapture(TaxCurrency_41,"Tax Currency 4","-","GBP","Default Currency used");
				BordereauPage.RuleDataCapture(TaxCurrency_42,"Tax Currency 4","-","GBP","Default Currency used");
				
				
				// Tax Currency 5 Column
				String TaxCurrency_5 = "@xpath=//*[@data-field='Tax_Currency_5']";
				String TaxCurrency_51 = "@xpath=//*[@data-field='Tax_Currency_5']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_5')][text()='GBP']";
				String TaxCurrency_52 = "@xpath=//*[@data-field='Tax_Currency_5']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_5')][text()='GBP']";
				BordereauPage.RuleDataCapture(TaxCurrency_51,"Tax Currency 5","-","GBP","Default Currency used");
				BordereauPage.RuleDataCapture(TaxCurrency_52,"Tax Currency 5s","-","GBP","Default Currency used");
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();
			} else {
				Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();
	        
		}
	
	}
	

	
	public void TC3760DefaultCurrencyChangeRulewithErorrs() throws Exception {
		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		ArrayList<String> DataCapture4 = new ArrayList<String>();
		
		
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
			sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Defaultcurrencychangerule_TC3760_Errors.xlsx";
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
		String Ufname = "S48325020181107.xlsx";	
		int size = 18847;
		String BordreauID = "7587fab0-8e35-465d-a6a7-3bd4297e9475";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        BordereauPage.refreshUploadedFile();
        

    	if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
    		Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
    		sleep(2000);
		
    		String PremiumCurrency= "@xpath=//*[@class='card']//h2[contains(.,'Premium Currency reference data translation required')]";
			if(isVisible(PremiumCurrency)== true) {
				errorTitleValidate = getTextFrom(PremiumCurrency);
				sleep(2000);
				BordereauPage.refreshPage();
				SelectDropDownValue1(schema.Data0DD,Premiumcurrency);
				sleep(2000);
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");
		
		    	}
    	
			String RiskCurrency= "@xpath=//*[@class='card']//h2[contains(.,'Risk Currency reference data translation required')]";
			if(isVisible(RiskCurrency)== true) {
				errorTitleValidate1 = getTextFrom(RiskCurrency);
				sleep(2000);
				BordereauPage.refreshPage();
				SelectDropDownValue1(schema.Data0DD,Riskcurrency);
				sleep(2000);
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");
		
		    	}
    	
			String Taxcurrency1= "@xpath=//*[@class='card']//h2[contains(.,'Tax Currency 1 reference data translation required')]";
		
			if(isVisible(Taxcurrency1)== true) {
				errorTitleValidate2 = getTextFrom(Taxcurrency1);
				sleep(2000);
				BordereauPage.refreshPage();
				SelectDropDownValue1(schema.Data0DD,taxcurrency1);
				sleep(2000);
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
				String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
				String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][text()='4']";
				verifyExists(RowNumber1, "1st value");
				verifyExists(RowNumber2, "1st value");
				Rowno1 = getTextFrom(RowNumber1);
				Rowno2 = getTextFrom(RowNumber2);
				sleep(2000);
				

				// Daily Production Value Currency Column
				String DailyProductionValueCurrency = "@xpath=//*[@data-field='Daily_Production_Value_Currency']";
				String DailyProductionValueCurrency1 = "@xpath=//*[@data-field='Daily_Production_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Daily_Production_Value_Currency')][text()='USD']";
				String DailyProductionValueCurrency2 = "@xpath=//*[@data-field='Daily_Production_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Daily_Production_Value_Currency')][text()='USD']";
				DataCapture1 = BordereauPage.RuleDataCapture(DailyProductionValueCurrency1,"Daily Production Value Currency","-","USD","Default Currency used");
				ActualDPVCOriginal = DataCapture1.get(0);
				ActualDPVCChanged = DataCapture1.get(1);
				ActualDPVCRuleName = DataCapture1.get(2);
				
				
				DataCapture2	= BordereauPage.RuleDataCapture(DailyProductionValueCurrency2,"Daily Production Value Currency","-","USD","Default Currency used");
				ActualDPVCOriginal1 = DataCapture2.get(0);
				ActualDPVCChanged1 = DataCapture2.get(1);
				ActualDPVCRuleName1 = DataCapture2.get(2);
				
				// Deductible/Excess Currency Column
				String DeductibleExcessCurrency = "@xpath=//*[@data-field='DeductibleExcess_Currency']";
				String DeductibleExcessCurrency1 = "@xpath=//*[@data-field='DeductibleExcess_Currency']//following::tr[1]//td[contains(@ng-click,'DeductibleExcess_Currency')][text()='USD']";
				String DeductibleExcessCurrency2 = "@xpath=//*[@data-field='DeductibleExcess_Currency']//following::tr[2]//td[contains(@ng-click,'DeductibleExcess_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(DeductibleExcessCurrency1,"Daily Production Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(DeductibleExcessCurrency2,"Daily Production Value Currency","-","USD","Default Currency used");
					
				
				// Fixed Sum Payment Currency Column
				String FixedSumPaymentCurrency = "@xpath=//*[@data-field='Fixed_Sum_Payment_Currency']";
				String FixedSumPaymentCurrency1 = "@xpath=//*[@data-field='Fixed_Sum_Payment_Currency']//following::tr[1]//td[contains(@ng-click,'Fixed_Sum_Payment_Currency')][text()='USD']";
				String FixedSumPaymentCurrency2 = "@xpath=//*[@data-field='Fixed_Sum_Payment_Currency']//following::tr[2]//td[contains(@ng-click,'Fixed_Sum_Payment_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(FixedSumPaymentCurrency1,"Fixed Sum Payment Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(FixedSumPaymentCurrency2,"Fixed Sum Payment Currency","-","USD","Default Currency used");
					
				
				// Goods Value Currency Column
				String GoodsValueCurrency = "@xpath=//*[@data-field='Goods_Value_Currency']";
				String GoodsValueCurrency1 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Goods_Value_Currency')][text()='USD']";
				String GoodsValueCurrency2 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Goods_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(GoodsValueCurrency1,"Goods Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(GoodsValueCurrency2,"Goods Value Currency","-","USD","Default Currency used");
					
				
				// Individual Livestock Value Currency Column
				String IndividualLivestockValueCurrency = "@xpath=//*[@data-field='Individual_Livestock_Value_Currency']";
				String IndividualLivestockValueCurrency1 = "@xpath=//*[@data-field='Individual_Livestock_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Individual_Livestock_Value_Currency')][text()='USD']";
				String IndividualLivestockValueCurrency2 = "@xpath=//*[@data-field='Individual_Livestock_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Individual_Livestock_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(IndividualLivestockValueCurrency1,"Individual Livestock Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(IndividualLivestockValueCurrency2,"Individual Livestock Value Currency","-","USD","Default Currency used");
					
				// Insured Revenue Or Turnover Currency Column
				String InsuredRevenueOrTurnoverCurrency = "@xpath=//*[@data-field='Insured_Revenue_Or_Turnover_Currency']";
				String InsuredRevenueOrTurnoverCurrency1 = "@xpath=//*[@data-field='Insured_Revenue_Or_Turnover_Currency']//following::tr[1]//td[contains(@ng-click,'Insured_Revenue_Or_Turnover_Currency')][text()='USD']";
				String InsuredRevenueOrTurnoverCurrency2 = "@xpath=//*[@data-field='Insured_Revenue_Or_Turnover_Currency']//following::tr[2]//td[contains(@ng-click,'Insured_Revenue_Or_Turnover_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(InsuredRevenueOrTurnoverCurrency1,"Insured Revenue Or Turnover Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(InsuredRevenueOrTurnoverCurrency2,"Insured Revenue Or Turnover Currency","-","USD","Default Currency used");
				
				// Insured US Turnover Currency Column
				String InsuredUSTurnoverCurrency = "@xpath=//*[@data-field='Insured_US_Turnover_Currency']";
				String InsuredUSTurnoverCurrency1 = "@xpath=//*[@data-field='Insured_US_Turnover_Currency']//following::tr[1]//td[contains(@ng-click,'Insured_US_Turnover_Currency')][text()='USD']";
				String InsuredUSTurnoverCurrency2 = "@xpath=//*[@data-field='Insured_US_Turnover_Currency']//following::tr[2]//td[contains(@ng-click,'Insured_US_Turnover_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(InsuredUSTurnoverCurrency1,"Insured US Turnover Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(InsuredUSTurnoverCurrency2,"Insured US Turnover Currency","-","USD","Default Currency used");
				
				// Livestock Value Per Head Currency Column
				String LivestockValuePerHeadCurrency = "@xpath=//*[@data-field='Goods_Value_Currency']";
				String LivestockValuePerHeadCurrency1 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Livestock_Value_Per_Head_Currency')][text()='USD']";
				String LivestockValuePerHeadCurrency2 = "@xpath=//*[@data-field='Goods_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Livestock_Value_Per_Head_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(LivestockValuePerHeadCurrency1,"Livestock Value Per Head Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(LivestockValuePerHeadCurrency2,"Livestock Value Per Head Currency","-","USD","Default Currency used");
				
				// Location Limit Currency Column
				String LocationLimitCurrency = "@xpath=//*[@data-field='Location_Limit_Currency']";
				String LocationLimitCurrency1 = "@xpath=//*[@data-field='Location_Limit_Currency']//following::tr[1]//td[contains(@ng-click,'Location_Limit_Currency')][text()='USD']";
				String LocationLimitCurrency2 = "@xpath=//*[@data-field='Location_Limit_Currency']//following::tr[2]//td[contains(@ng-click,'Location_Limit_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(LocationLimitCurrency1,"Location Limit Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(LocationLimitCurrency2,"Location Limit Currency","-","USD","Default Currency used");
				
				
				// Maximum Benefit Any One Event Currency Column
				String MaximumBenefitAnyOneEventCurrency = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Event_Currency']";
				String MaximumBenefitAnyOneEventCurrency1 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Event_Currency']//following::tr[1]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Event_Currency')][text()='USD']";
				String MaximumBenefitAnyOneEventCurrency2 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Event_Currency']//following::tr[2]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Event_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOneEventCurrency1,"Maximum Benefit Any One Event Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOneEventCurrency2,"Maximum Benefit Any One Event Currency","-","USD","Default Currency used");
				
				
				// Maximum Benefit Period Currency Column
				String MaximumBenefitPeriodCurrency = "@xpath=//*[@data-field='Maximum_Benefit_Period_Currency']";
				String MaximumBenefitPeriodCurrency1 = "@xpath=//*[@data-field='Maximum_Benefit_Period_Currency']//following::tr[1]//td[contains(@ng-click,'Maximum_Benefit_Period_Currency')][text()='USD']";
				String MaximumBenefitPeriodCurrency2 = "@xpath=//*[@data-field='Maximum_Benefit_Period_Currency']//following::tr[2]//td[contains(@ng-click,'Maximum_Benefit_Period_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(MaximumBenefitPeriodCurrency1,"Maximum Benefit Period Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(MaximumBenefitPeriodCurrency2,"Maximum Benefit Period Currency","-","USD","Default Currency used");
				
				
				// Maximum Benefit Any One Person Currency Column
				String MaximumBenefitAnyOnePersonCurrency = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Person_Currency']";
				String MaximumBenefitAnyOnePersonCurrency1 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Person_Currency']//following::tr[1]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Person_Currency')][text()='USD']";
				String MaximumBenefitAnyOnePersonCurrency2 = "@xpath=//*[@data-field='Maximum_Benefit_Any_One_Person_Currency']//following::tr[2]//td[contains(@ng-click,'Maximum_Benefit_Any_One_Person_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOnePersonCurrency1,"Maximum Benefit Any One Person Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(MaximumBenefitAnyOnePersonCurrency2,"Maximum Benefit Any One Person Currency","-","USD","Default Currency used");
				

				// Prize Value Currency Column
				String PrizeValueCurrency = "@xpath=//*[@data-field='Prize_Value_Currency']";
				String PrizeValueCurrency1 = "@xpath=//*[@data-field='Prize_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Prize_Value_Currency')][text()='USD']";
				String PrizeValueCurrency2 = "@xpath=//*[@data-field='Prize_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Prize_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(PrizeValueCurrency1,"Prize Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(PrizeValueCurrency2,"Prize Value Currency","-","USD","Default Currency used");
				

				// Product Annual Sales Currency Column
				String ProductAnnualSalesCurrency = "@xpath=//*[@data-field='Product_Annual_Sales_Currency']";
				String ProductAnnualSalesCurrency1 = "@xpath=//*[@data-field='Product_Annual_Sales_Currency']//following::tr[1]//td[contains(@ng-click,'Product_Annual_Sales_Currency')][text()='USD']";
				String ProductAnnualSalesCurrency2 = "@xpath=//*[@data-field='Product_Annual_Sales_Currency']//following::tr[2]//td[contains(@ng-click,'Product_Annual_Sales_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(ProductAnnualSalesCurrency1,"Product Annual Sales Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(ProductAnnualSalesCurrency2,"Product Annual Sales Currency","-","USD","Default Currency used");
				

				// Product Estimated Annual Sales Currency Column
				String ProductEstimatedAnnualSalesCurrency = "@xpath=//*[@data-field='Product_Estimated_Annual_Sales_Currency']";
				String ProductEstimatedAnnualSalesCurrency1 = "@xpath=//*[@data-field='Product_Estimated_Annual_Sales_Currency']//following::tr[1]//td[contains(@ng-click,'Product_Estimated_Annual_Sales_Currency')][text()='USD']";
				String ProductEstimatedAnnualSalesCurrency2 = "@xpath=//*[@data-field='Product_Estimated_Annual_Sales_Currency']//following::tr[2]//td[contains(@ng-click,'Product_Estimated_Annual_Sales_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(ProductEstimatedAnnualSalesCurrency1,"Product Estimated Annual Sales Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(ProductEstimatedAnnualSalesCurrency2,"Product Estimated Annual Sales Currency","-","USD","Default Currency used");
				

				// Wage Roll Annual Salary Currency Column
				String WageRollAnnualSalaryCurrency = "@xpath=//*[@data-field='Wage_Roll_Annual_Salary_Currency']";
				String WageRollAnnualSalaryCurrency1 = "@xpath=//*[@data-field='Wage_Roll_Annual_Salary_Currency']//following::tr[1]//td[contains(@ng-click,'Wage_Roll_Annual_Salary_Currency')][text()='USD']";
				String WageRollAnnualSalaryCurrency2 = "@xpath=//*[@data-field='Wage_Roll_Annual_Salary_Currency']//following::tr[2]//td[contains(@ng-click,'Wage_Roll_Annual_Salary_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(WageRollAnnualSalaryCurrency1,"Wage Roll Annual Salary Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(WageRollAnnualSalaryCurrency2,"Wage Roll Annual Salary Currency","-","USD","Default Currency used");
				

				// Vessel Value Currency Column
				String VesselValueCurrency = "@xpath=//*[@data-field='Vessel_Value_Currency']";
				String VesselValueCurrency1 = "@xpath=//*[@data-field='Vessel_Value_Currency']//following::tr[1]//td[contains(@ng-click,'Vessel_Value_Currency')][text()='USD']";
				String VesselValueCurrency2 = "@xpath=//*[@data-field='Vessel_Value_Currency']//following::tr[2]//td[contains(@ng-click,'Vessel_Value_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(VesselValueCurrency1,"Vessel Value Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(VesselValueCurrency2,"Vessel Value Currency","-","USD","Default Currency used");
				
				
				// Vessel Purchase Price Currency Column
				String VesselPurchasePriceCurrency = "@xpath=//*[@data-field='Vessel_Purchase_Price_Currency']";
				String VesselPurchasePriceCurrency1 = "@xpath=//*[@data-field='Vessel_Purchase_Price_Currency']//following::tr[1]//td[contains(@ng-click,'Vessel_Purchase_Price_Currency')][text()='USD']";
				String VesselPurchasePriceCurrency2 = "@xpath=//*[@data-field='Vessel_Purchase_Price_Currency']//following::tr[2]//td[contains(@ng-click,'Vessel_Purchase_Price_Currency')][text()='USD']";
				BordereauPage.RuleDataCapture(VesselPurchasePriceCurrency1,"Vessel Purchase Price Currency","-","USD","Default Currency used");
				BordereauPage.RuleDataCapture(VesselPurchasePriceCurrency2,"Vessel Purchase Price Currency","-","USD","Default Currency used");
				
				// Tax Currency 1 Column
				String TaxCurrency_1 = "@xpath=//*[@data-field='Tax_Currency_1']";
				String TaxCurrency_11 = "@xpath=//*[@data-field='Tax_Currency_1']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_1')][text()='CAD']";
		     	String TaxCurrency_12 = "@xpath=//*[@data-field='Tax_Currency_1']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_1')][text()='CAD']";
				BordereauPage.RuleDataCapture(TaxCurrency_11,"Tax Currency 1","CADD","CAD","Validate reference data values");
			//	BordereauPage.RuleDataCapture(TaxCurrency_12,"Tax Currency 1","","CAD","Default Currency used");
				
				// Tax Currency 2 Column
				String TaxCurrency_2 = "@xpath=//*[@data-field='Tax_Currency_2']";
				String TaxCurrency_21 = "@xpath=//*[@data-field='Tax_Currency_2']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_2')][text()='GBP']";
				String TaxCurrency_22 = "@xpath=//*[@data-field='Tax_Currency_2']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_2')][text()='GBP']";
				DataCapture3 =	BordereauPage.RuleDataCapture(TaxCurrency_21,"Tax Currency 2","-","GBP","Default Currency used");
				ActualTCOriginal = DataCapture3.get(0);
				ActualTCChanged = DataCapture3.get(1);
				ActualTCRuleName = DataCapture3.get(2);
				DataCapture4 = 	BordereauPage.RuleDataCapture(TaxCurrency_22,"Tax Currency 2","-","GBP","Default Currency used");
				ActualTCOriginal1 = DataCapture4.get(0);
				ActualTCChanged1 = DataCapture4.get(1);
				ActualTCRuleName1 = DataCapture4.get(2);
				
				// Tax Currency 3 Column
				String TaxCurrency_3 = "@xpath=//*[@data-field='Tax_Currency_3']";
				String TaxCurrency_31 = "@xpath=//*[@data-field='Tax_Currency_3']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_3')][text()='GBP']";
				String TaxCurrency_32 = "@xpath=//*[@data-field='Tax_Currency_3']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_3')][text()='GBP']";
				BordereauPage.RuleDataCapture(TaxCurrency_31,"Tax Currency 3","-","GBP","Default Currency used");
				BordereauPage.RuleDataCapture(TaxCurrency_32,"Tax Currency 3","-","GBP","Default Currency used");
				
				// Tax Currency 4 Column
				String TaxCurrency_4 = "@xpath=//*[@data-field='Tax_Currency_4']";
				String TaxCurrency_41 = "@xpath=//*[@data-field='Tax_Currency_4']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_4')][text()='GBP']";
				String TaxCurrency_42 = "@xpath=//*[@data-field='Tax_Currency_4']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_4')][text()='GBP']";
				BordereauPage.RuleDataCapture(TaxCurrency_41,"Tax Currency 4","-","GBP","Default Currency used");
				BordereauPage.RuleDataCapture(TaxCurrency_42,"Tax Currency 4","-","GBP","Default Currency used");
				
				
				// Tax Currency 5 Column
				String TaxCurrency_5 = "@xpath=//*[@data-field='Tax_Currency_5']";
				String TaxCurrency_51 = "@xpath=//*[@data-field='Tax_Currency_5']//following::tr[1]//td[contains(@ng-click,'Tax_Currency_5')][text()='GBP']";
				String TaxCurrency_52 = "@xpath=//*[@data-field='Tax_Currency_5']//following::tr[2]//td[contains(@ng-click,'Tax_Currency_5')][text()='GBP']";
				BordereauPage.RuleDataCapture(TaxCurrency_51,"Tax Currency 5","-","GBP","Default Currency used");
				BordereauPage.RuleDataCapture(TaxCurrency_52,"Tax Currency 5s","-","GBP","Default Currency used");
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();
			} else {
				Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();
				
	}
	
	} else {
		Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
		policy.navigationOnBordereauxTab();
		BordereauPage.deleteBorderEAUX();
		
		
}
    	
    	
	}
}

