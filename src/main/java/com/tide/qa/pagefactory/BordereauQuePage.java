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

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jprotractor.NgBy;
import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;


public class BordereauQuePage extends PageBase
{
	//Read Excel data
	String path;
	String BordereauFilePath;
	static String FormatId;
	public static String BFormatId;
	public String versionNumber;
	public static String EditName;
	public static String EditName1;
	LoginPage login = new LoginPage();
	
	public static String allSheetsPath = "";
	public static String allSheetsPath1 = "";
	public static String firstSheetPath = "";
	public static String lastSheetPath = "";
	public static String specificTextSheetPath = "";
	public static String equalSpecificTextSheetPath = "";
	public static String anySheetContainsSpecificTextPath = "";
	public static String onlySpecificTextPath = "";
	public static String addPremiumQuestionairePath = "";
	public static String addClaimQuestionairePath = "";
	public static String sheet3684Path = "";
	public static String sheet3695Path = "";
	public static String allsheetPath = "";
	public static String sheet4303Path = "";
	String QuestionnaireName_TC5141 ="";
	public String NoBuildingValue;
	public String RecordOne1;
	public String NotePopupText;
	public String verisoncount1;
	public String verisoncount2;
	public String Note;
	public String OK;
	public String StabdardRefCoulmn;
	public static String ExpectedResult_1076="";
	public static String questionnaireName_3648;
	public static String questionnaireName_3849;
	public static String questionnaireName_3603;
	public static String firstSheetpath2="";
	public static String RowCanNotChangeText_Actual="";
	public static String RowCanNotChangeText_Expected="To note: If you incorrectly selected the header row(s) in this step to identify the header fields to complete this questionnaire, then you need to cancel this questionnaire and start a new questionnaire. The above question only relates to the expected position of the header row during future processing.";
		
	public static String ScheduleTabInOpnMrktcontrct;
	public static String ActualScheduleQuestnrName;
	public static String EditScheduleQuestnrName;
	public static final String RiskOrderNo ="@xpath=//dt[contains(.,'Is a Ceded % or Contract Order supplied in the Bordereau')]//following::dd/div/label[2]";
	
	GlobalVariables g = new GlobalVariables();
	{ 
		try {
			String path = new File(".").getCanonicalPath();
			g = new GlobalVariables();
			g.setRelativePath(path);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		path = "./src/test/resources/TestData.xls";
		BordereauFilePath = "./src/main/resources/January 2017.xlsx";
	} 
	ReadExcelFile rd = new ReadExcelFile();

	/*	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssddMMMs");
		String datetime = ft.format(dNow);
		return datetime;
	}
	 */
	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public String BPOQuestionaire = "BPOQuestionaire"+getCurrentDateTimeMS();
	
	public String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();
	String QuestionnaireName1 = "SP - All Sheet1(s)"+getCurrentDateTimeMS();
	public String QuestionnaireName1stSheet = "SP - First Sheet"+getCurrentDateTimeMS();
	String QuestionnaireNameLastSheet = "SP - Last Sheet"+getCurrentDateTimeMS();
	String QuestionnaireSpecificTextSheet = "SP - The only sheet that contains specific text"+getCurrentDateTimeMS();
	String QuestionnaireEqualSpecificTextSheet = "SP - The only sheet that equals specific text"+getCurrentDateTimeMS();
	String QuestionnaireAnySheetContainsSpecificText = "SP - Any sheets that contains specific text"+getCurrentDateTimeMS();
	String QuestionnaireOnlySpecificText = "SP - Only specified Sheet(s)"+getCurrentDateTimeMS();
	public String PremiumBordereauText = "Premium Bordereau Questionnaire"+getCurrentDateTimeMS();
	public String ClaimBordereauText = "Automation Format-1 "+getCurrentDateTimeMS();
	String ClaimBordereauText1 = "Automation Format-2 "+getCurrentDateTimeMS();
	String RiskAndPremiumText = "Automation Risk and Premium Format"+getCurrentDateTimeMS();
	String RiskAndPremiumText1 = "Automation Risk and Premium Format1"+getCurrentDateTimeMS();
	String CSVRiskAndPremium = "CSV Risk and Premium Questionnaire"+getCurrentDateTimeMS();
	String Coverage = "Coverage Risk and Premium Questionnaire"+getCurrentDateTimeMS();
	String Expert = "Expert Questionnaire"+getCurrentDateTimeMS();
	public String ScheduleQuestionnaireName="Schedule Automation Format(s)"+getCurrentDateTimeMS();
	
	String AllSheetOption = "All Sheet";
	String FirstSheetOption = "First Sheet";
	String LastSheetOption = "Last Sheet";
	String SpecificTextSheetOption = "The only sheet that contains specific text";
	String EqualSpecificTextSheetOption = "The only sheet that contains specific text";
	String AnySheetContainsSpecificTextOption = "Any sheets that contains specific text";
	String OnlySpecificTextOption = "Only specified sheet(s)";
	String AllSheetsOption = "All Sheet(s)";
	public String Cancel;
	public String Edit;
	public String ViewQB;
	public String Savechanges;
	//Class objects
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	PolicyPage policy = new PolicyPage();
	DatasetReferenceDataPage DataRef = new DatasetReferenceDataPage();

		//Element Locators
	//Select Bordereau Questionnaire Link from Admin Dropdown
	public static final String bordereauQueLink ="@xpath=//a[contains(.,'Questionnaires')]";

	//Bordereau Questionnaire Page Locators
	public static String contractId;
	public static final String bordereauQuePage ="@xpath=//*[@class='card-header']//div[contains(.,'Questionnaire')]";
	public static final String addQueBtn ="@xpath=//*[@class='btn btn-primary ng-scope']";
	public static final String UploadSection ="@xpath=//div[contains(@ng-model,'picFile')]";
	public static final String typeOfBordereauDD ="@xpath=//*[contains(@ng-class,'step2data.DataSetType')]//span[@class='k-icon k-i-arrow-60-down']";
	public static final String riskOption ="@xpath=//li[text()='Risk']";
	public static final String businessClassDD ="@xpath=//*[@ng-hide='StepsMenuVM.IsSaved']//span[@class='k-icon k-i-arrow-60-down']";
	public static final String businessClassDDLuna ="@xpath=//span[text()='-- Select --']";
	
	//Schedule 
		public static final String ScheduleTab="@xpath=//a[@data-ui-sref='app.contract.scheduleDetails']";
		public static final String AddScheduleBtn="@xpath=//button[@ng-click='addData()']";
		public static final String ScheduleQuestnrTxtVerify = "@xpath=//div[contains(text(),'Schedule Questionnaire')]";
		public static final String ScheduleTypOfBusinessDD="@xpath=//*[contains(@name,'form.scheduleType')]//span[@class='k-icon k-i-arrow-60-down']";
		public static final String ScheduleTypOfBusinessDDValue="@xpath=//li[contains(text(),'ScheduleTestSchema')]";
		public static final String ScheduleQuesnrNameTxt = "@xpath=//input[@ng-model='questionnaireData.QuestionnaireName']";
		public static final String ScheduleSheetDD="@xpath=//*[@class='k-input ng-scope']";
		public static final String SelectScheduleSheetDDValue="@xpath=//li[text()='Sheet1']";
		public static final String SelectRowInSchedule="@xpath=//input[@ng-model='data.HeaderIndex']";
		public static final String selectValidFieldQuestnDD="@xpath=//div[@class='k-multiselect-wrap k-floatwrap']";
		public static final String FieldQustnDDValue="@xpath=//li[@data-offset-index='0']";
		public static final String LocationFloorTideFild="@xpath=//label[@class='k-label']/span[text()='Location Floor Number']";
		public static final String LocationFlrSpecifyDefltClck="@xpath=//button[@ng-click='specifyDefault(dataItem)']";
		public static final String ApplyDefltfrLoctnFlrScrn="@xpath=//h2[text()='Apply Default Value for Location Floor Number']";
		public static final String TextClmDfltLoctValue="@xpath=//input[@ng-class='{isErrorBorder:dataItem.isError}']";
		public static final String SaveDefultVlueBtn="@xpath=//button[@ng-click-single='save()']";
		public static final String ClearBtnofFltr="@xpath=//button[@type='reset']";
		public static final String NextScheduleQunrBtn="@xpath=//button[@ng-click='nextStep()']";
		public static final String SchedukeQuestnName="@xpath=//div[@class='m-t-5 f-13 f-w-400']/span[@class='m-r-30 ng-binding']";
	
	
	
	
	public static final String automationSchemaOption ="@xpath=//li[text()='Automation Schema']";
	public static final String LloydSchemaOption ="@xpath=//li[text()='Lloyd Property Schema']";
	public static final String questionnaireNameTxt ="@model=step2data.FormatName";
	public static final String questionnaireNameTxtLuna ="@model=data.BordereauFormat.FormatName";
	public static final String nextStepBtn ="@xpath=//button[contains(.,'Next Step')]";
	public static final String suppliedBordereauSheetDD ="@xpath=//*[@ng-model='data.SheetIndex']//preceding-sibling::span[1]";
	public static final String suppliedBordereauSheetMarchOption ="@xpath=//li[text()='March 2017']";
	public static final String suppliedBordereauSheet2017Option ="@xpath=//li[text()='2017']";
	public static final String appliedToIdentifyDD ="@xpath=//*[@ng-model='data.SheetType']//preceding-sibling::span[1]";
	public static final String RiskOrderField ="@xpath= //*[@id='content']/div/ui-view/div/form/div/div/div/dl[7]/dd/div/div/input";
	public static final String Spinner ="@xpath=//*[@id='loading-bar-spinner']/div[@class='spinner']";
	public static final String FirstSheetVal ="@xpath=//ul/li[text()='First Sheet']";
	public static final String SaveAsDraftQueBtn = "@xpath=//button[contains(.,'SAVE AS DRAFT')]";

	public static final String appliedRuleAllSheetsOption ="@xpath=//li[contains(text(),'All Sheet')]";
	public static final String sheetsContainTxt ="@model=data.SheetText";
	public static final String specifiedSheetProcessedDD ="@xpath=//*[@ng-model='form.multiSheetText']//preceding-sibling::div[1]";
	public static final String specifiedSheetMarchOption ="@xpath=//preceding::dt[contains(text(),'Please specify the sheet')][1]//following::li[contains(text(),'March 2017')][2]";
	public static final String specifiedSheetProcessedDD1 ="@xpath=//*[@ng-model='form.multiSheetText']//preceding-sibling::div//input";
	public static final String specifiedSheetMayOption ="@xpath=//preceding::dt[contains(text(),'Please specify the sheet')][1]//following::li[contains(text(),'May 2017')][2]";
	public static final String rateOfExchangeClaimsFormat ="@xpath=//input[@ng-model='BFBasicDetailsClaim.RateOfExchange']";
	public static final String headerRowCountTxt ="@model=data.HeaderIndex";
	public static final String FinancialFigDrp ="@xpath=//*[@ng-model='BFBasicDetailsClaim.FinancialCurrency']//preceding-sibling::span[1]";
	//public static final String OriginalCurrencyval ="@xpath=//div[@class='k-animation-container']//li[text()='Original Currency - [J]']";
	public static final String OtherfeesDescriptionDD ="@xpath=//*[@ng-model='BFCoreFinancialVM.OtherFeeDescription.MappingOptions']//preceding-sibling::span[1]";
	public static final String OtherfeesdescriptionNotSuppliedOption ="@xpath=//*[@class='k-list k-reset']//li[contains(.,'Please select the description column')]";
	public static final String OtherfeesdescriptionOFDOption ="@xpath= //*[@class='k-animation-container']//li[contains(.,'Other Fees Description')]";
	public static final String OriginalCurrencyval ="@xpath=//div[@class='k-animation-container']//li[text()='Original Currency']";
	public static final String Dropdown3 ="@xpath=//dt[contains(.,'In which currency are the financial figures in the bordereau provided?')]//following::dd[1]//span[@class='k-select']";
	public static final String DDvalue3 ="@xpath=//li[text()='Original Currency']";
	public static final String Dropdown4 ="@xpath=//*[@id=\"content\"]//input[@class='k-input k-readonly']";
	public static final String DDValue4 ="@xpath=//li[1][@role='option'][contains(.,'Claim Ref')]";
	
	public static final String TaskTile ="@xpath=//td[3][contains(.,'New Questionnaire Request')]";
	public static final String TaskType ="@xpath=//td[4][contains(.,'Questionnaire Request')]";
	public static final String TaskStatus ="@xpath=//td[5][contains(.,'New')]";
	public static final String TaskTile2 ="@xpath=//td[3][contains(.,'New Questionnaire Adjustment Request')]";
	public static final String TaskType2 ="@xpath=//td[4][contains(.,'Questionnaire Adjustment Request')]";
	public static final String AdjustmentTaskStatus ="@xpath=//tr[2]//td[5][contains(.,'Complete')]";
	
	//3648
	public static final String DefaultCurrencyDD ="@xpath=//div[@ng-class[contains(.,'DefaultCurrency')]]//span[@aria-label='select']";
	public static final String DevaultCurrencyGBPValue ="@xpath=//ul/li[contains(.,'GBP')]";
	public static final String ROEDD ="@xpath=//*[@ng-model='BFBasicDetailsClaim.RateOfExchange']//preceding-sibling::span[1]";
	public static final String ClaimFinanceCurrencyDD ="@xpath=//*[@ng-model='BFBasicDetailsClaim.FinancialCurrency']//preceding-sibling::span[1]";
	
	public static final String ROEPaidThisMonthOption ="@xpath=//*[@id='RateOfExchange_listbox']//li[contains(.,'Paid This Month Fees')]";
	public static final String OriginalCurrencyValue ="@xpath=//ul/li[contains(.,'Original Currency')]";
	public static final String OriginalCurrencyval1 ="@xpath=//ul[@id='RateOfExchange_listbox']//li[text()='Original Currency']";
	public static final String FeesDD ="@xpath=//dl[@uib-popover-template[contains(.,'feesDescription')]]//span[@aria-label='select']";
	public static final String IndemnityDD ="@xpath=//dl[@uib-popover-template[contains(.,'indemnityDescription')]]//span[@aria-label='select']";
	public static final String TotalResrveDD ="@xpath=//dl[@uib-popover-template[contains(.,'totalResrveDescription')]]//span[@aria-label='select']";
	public static final String TotalPaidDD ="@xpath=//dl[@uib-popover-template[contains(.,'totalPaidDescription')]]//span[@aria-label='select']";
	public static final String TotalIncurredDD ="@xpath=//dl[@uib-popover-template[contains(.,'totalIncurredDescription')]]//span[@aria-label='select']";
	public static final String PaidThisMonthval ="@xpath=//div[@class='k-animation-container']//li[text()='Paid This Month Fees']";
	
	public static final String Fees_TotalIncurred_NotSupplied ="@xpath=//ul[@id='Fees_TotalIncurred_listbox']//li[text()='Not Supplied']";
	public static final String Indemnity_TotalIncurred_NotSupplied ="@xpath=//ul[@id='Indemnity_TotalIncurred_listbox']//li[text()='Not Supplied']";
	public static final String Total_Reserve_NotSupplied ="@xpath=//ul[@id='Total_Reserve_listbox']//li[text()='Not Supplied']";
	public static final String Total_Paid_NotSupplied ="@xpath=//ul[@id='Total_Paid_listbox']//li[text()='Not Supplied']";
	public static final String Total_Incurred_NotSupplied ="@xpath=//ul[@id='Total_Incurred_listbox']//li[text()='Not Supplied']";
	public static final String Dropdown5 ="@xpath=//*[@id='content']//dl[8]//span[2]";
	public static final String DDvalue5 ="@xpath=//ul/li[2][text()='Original Currency']";
	
	public static final String SettlementCurrencyval ="@xpath=//div[@class='k-animation-container']//li[text()='Settlement Currency']";
	public static final String OriginalCurrencyDD ="@xpath=//*[@class='fg-line errorBorder']//span[@class='k-icon k-i-arrow-60-down']";
	public static final String OriginalCurrencyDD1 ="@xpath=//*[@id='content']/div/ui-view/div/form/div/div/div/dl[8]/dd/div/div/div/span/span/span[2]/span";
	public static final String multipleLocationsRadioBtn ="@xpath=//*[@name='multilocationGrp'][@value='false']";
	public static final String YOAeachRiskSpecifiedDD ="@xpath=//*[@ng-model='BFBasicDetails.YearOfAccount']//preceding-sibling::span[1]";
	public static final String YOA_DD ="@xpath=//div[@ng-class='{errorBorder:(!isFirstLoad ) && !BFBasicDetails.YearOfAccount }']/div/span/span/span[@aria-label='select']";
	public static final String YOA_Value ="@xpath=//*[@ng-model='BFBasicDetails.YearOfAccount']//preceding-sibling::span[1]";
	public static final String PolicydDD ="@xpath=//*[@id='content']//dl[10]//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String yearofAccountOption ="@xpath=//*[@id='YearOfAccount_listbox']//li[contains(.,'Year of Account')]";
	//public static final String yearofAccountOption1 ="@xpath=//*[@id='YearOfAccount_listbox']//li[contains(.,'Year of Account 2017')]";
	public static final String yearofAccountOption1 ="@xpath=//*[@id='YearOfAccount_listbox']//li[contains(.,'Year of Account 2017')]";
	public static final String Ascertainfromsheetname ="@xpath=//*[@id='YearOfAccount_listbox']//li[contains(.,'Ascertain from sheet name')]";
	//public static final String PolicyOption ="@xpath=//*[@id='DiscardRisk_taglist']//li[contains(.,'Policy Number')]//span";
	public static final String PolicyOption ="@xpath=//*[@id='4c4a9118-73d3-41e3-9aa4-cfd3e9707dae']";
	public static final String contractOrderRadioBtn ="@xpath=//label//input[@ng-model='BFBasicDetails.IsCeded'][@value='false']";
	public static final String riskAddressSection ="@xpath=//*[@id='grid']//td[contains(text(),'Address')]";
	public static final String arrowRightBtn ="@css=.zmdi.zmdi-arrow-right";
	public static final String totalInsurableValueDD ="@xpath=//*[@ng-model='BFCoreFinancialVM.TotalInsurableValue.MappingOptionsColumns']//preceding-sibling::div[1]";
	public static final String TIVOption ="@xpath=//*[@id='TIVSelect_listbox']//li[1]";
	public static final String coverholderCommissionDD ="@xpath=//*[@ng-model='BFDeductionsOptions.Commission']//preceding-sibling::span[1]";
	public static final String commissionAmountOption ="@xpath=//following-sibling::li[text()='Commission Percentage']//preceding-sibling::li[text()='Amount']";
	public static final String brokerageDD ="@xpath=//*[@ng-model='BFDeductionsOptions.LondonBrokerage']//preceding-sibling::span[1]";
	public static final String brokerageAmountOption ="@xpath=//following-sibling::li[text()='Percentage']//preceding-sibling::li[text()='Amount']";
	public static final String OtherFeesTxt ="@xpath=//*[@ng-model='BFCoreFinancialVM.OtherFeeDescription.Value']";
	public static final String OtherFeesNoOption ="@xpath=//*[@name='Other_FeesGrp'][@ng-value='false']";
	public static final String taxDD ="@xpath=//*[@ng-model='BFDeductionsOptions.Tax']//preceding-sibling::span[1]";
	public static final String taxAmountOption ="@xpath=//following-sibling::li[text()='Amount and Tax Percentage']//preceding-sibling::li[text()='Tax Percentage']";
	public static final String producingBrokerageRadioBtn ="@xpath=//*[@name='ProducingBrokerageBoolGrp'][@value='false']";
	public static final String taxRadioBtn ="@xpath=//*[@name='TaxTypeGrp'][@value='false']";
	public static final String taxTypeTxt ="@model=BFCoreFinancialVM.TaxType.Value";
	public static final String premiumsChk ="@name=chk1";
	public static final String limitsAndOthersChk ="@name=chk3";
	public static final String limitsAndOthersChkLuna ="@name=chk2";
	
	public static final String limitAndOtherChk4 = "@name=chk4";
	public static final String mappingYBBtn ="@xpath=//button[text()='YB']";
	public static final String tableRow1 ="@xpath=//*[@id='selection']//table/tbody/tr[1]/td[1]";
	public static final String SaveBtn ="@buttonText=Save";
	public static final String RiskSpecifiedDD ="@xpath=//*[@ng-model='BFBasicDetails.PremiumAllocation']//preceding-sibling::span[1]";
	public static final String RiskOption ="@xpath=//*[@class='k-list k-reset']//li[contains(.,'Risk')]";
	public static final String SaveAndProcessBtn ="@xpath=//button[text()='SAVE & PROCESS BORDEREAU']";
	
	public static final String TideFieldFilter ="@xpath=//th[@data-field='DisplayFieldName']//span";
	// BPO
	public static final String IdentifysheetDD = "@xpath=//*[@ng-model='dataSummary.SheetType']//preceding-sibling::span[1]";
	public static final String Inputheader = "@xpath=//div/input[@ng-model='data.HeaderRowNumber']";
	public static final String Reprocess = "@xpath=//button[text()=' ReProcess']";
	public static final String RaiseQuestionaireRequest = "@xpath=//div[@class='pull-right']//div[contains(.,'RAISE BPO QUESTIONNAIRE REQUEST')]";
	public static final String NavigatetoTaskTab = "@xpath=//a[text()='TASKS']";
	public static final String ACKNOWLEDGEbtn = "@xpath=//button[contains(.,'ACKNOWLEDGE')]";
	public static final String Searchtext = "@xpath=//input[@placeholder='Search']";
	public static final String RelatedEntityFilter = "@xpath=//th[@data-field='RelatedEntity']/a/span";
	public static final String taskiconLink = "@xpath=.//*[contains(@class, 'glyphicon glyphicon-time')]";
	
	//---------------------------Step_4
	public static final String RiskinBordereauDD ="@xpath=//*[@class='form-group col-md-7 m-l-20 p-r-0']";
	public static final String RiskinBordereauDDoption ="@xpath=//li[contains(.,'Policy Number 1')]";
	
	public static final String RiskcandeleteDD ="@xpath=//*[@id='content']/div/ui-view/div/form/div/div/div/dl[10]/dd/div/div/div/div/div";
	public static final String RiskcandeleteOption ="@xpath=//*[@id='DiscardRisk_listbox']//li[contains(.,'Policy Number 1')]";
   
	//-------------------------Step_5
	
	public static final String StartriskperiodDD ="@xpath=//*[@id='RiskDetails']/div/div/div/dl[1]/dd/div/div/div/span";
	public static final String StartriskperiodDDoption ="@xpath=//*[@id='RiskInceptionDate_listbox']//li[contains(.,'Start Date 1/1/2017 120000 AM')]";
	
	public static final String RiskEffectiveDateDD ="@xpath=//div[@ng-class[contains(.,'RiskEffectiveDate')]]//span[@aria-label='select']";
	public static final String RiskEffectiveDateValue ="@xpath=//*[@id='RiskEffectiveDate_listbox']//li[contains(.,'Endorsement Effective date')]";
	public static final String StartDateDD ="@xpath=//dt[contains(.,'Which column specifies the start of the risk period?')]//following::dd[1]//span[@class='k-select']";
	public static final String StartDateDV ="@xpath=//li[text()='Default to Start of Bordereau Period']";
	
	public static final String ExpiryDateDD ="@xpath=//dt[contains(.,'Which column specifies the end of the risk period?')]//following::dd[1]//span[@class='k-select']";
	public static final String ExpiryDateDV ="@xpath=//li[text()='Default to End of Bordereau Period']";
	
	public static final String CountryNotSelectDD ="@xpath=//dt[contains(.,'Which column specifies the Country of the Risk Address')]//following::dd[1]//span[@class='k-select']";
	public static final String CountryNotSelectDV ="@xpath=//dt[contains(.,'Which column specifies the Country of the Risk Address')]//following::li[1][text()='Not Supplied']";
	
	public static final String DefaultCountryDD ="@xpath=//dt[contains(.,'Please select a Country that will be applied to all Risks.')]//following::dd[1]//span[@class='k-select']";
	public static final String DefaultCountryDV ="@xpath=//li[text()='Albania']";
	
	public static final String RiskAndPremiumCDD ="@xpath=//dt[contains(.,'What is the source of the currency value?')]//following::dd[1]//span[@class='k-select']";
	public static final String RiskAndPremiumCDV ="@xpath=//li[text()='Default Value']";
	
	public static final String RiskAndPremiumCDD2 ="@xpath=//dt[contains(.,'Please enter the default value')]//following::dd[1]//span[@class='k-select']";
	public static final String RiskAndPremiumCDV2 ="@xpath=//li[text()='GBP - Pound Sterling']";
	
	
	public static final String EndriskperiodDD ="@xpath=//*[@id='RiskDetails']/div/div/div/dl[2]/dd/div/div/div/span";
	public static final String EndriskperiodOption ="@xpath=//*[@id='RiskExpiryDate_listbox']//li[contains(.,'Expiry 12/31/2017 120000 AM')]";
	
	public static final String InsuredNameDD ="@xpath=//*[@id='RiskDetails']/div/div/div/dl[5]/dd/div/div/div/div";
	public static final String InsuredNameOption ="@xpath=//*[@id='InsuredName_listbox']//li[contains(.,'Insured Name Random Insured1')]";
	
	//-------------------------Step_6
	public static final String NewRenewalDD ="@xpath=//div[@ng-class[contains(.,'data.NewRenwalIndicator')]]/div/span/span/span[@aria-label='select']";
	public static final String NewRenewalValue ="@xpath=//ul[@id='NewRenwalIndicator_listbox']/li[contains(.,'New or Renewal')]";
	
	public static final String PremiumTransactionTypeDD ="@xpath=//div[@ng-class[contains(.,'data.PremiumTransaction')]]/div/span/span/span[@aria-label='select']";
	public static final String PremiumTransactionTypeValue ="@xpath=//ul[@id='PremiumTransaction_listbox']//li[contains(.,'Transaction Type')]";
	
	public static final String TransactionTypeDD ="@xpath=//div[@ng-class[contains(.,'data.RiskTransaction')]]/div/span/span/span[@aria-label='select']";
	public static final String TransactionTypeValue ="@xpath=//ul[@id='RiskTransaction_listbox']//li[contains(.,'Transaction Type')]";
	
	//--------------------------Step 8 Finance 
		public static final String CurrencyDD ="@xpath=//div[@ng-class[contains(.,'RiskCurrency.MappingType')]]/div/span/span/span[@aria-label='select']";
		public static final String ContractLookupValue ="@xpath=//ul[@class='k-list k-reset']/li[contains(.,'Contract Lookup')]";


	//Edit Questionnaire
	public static final String QuestionnaireNameFilter ="@xpath=//*[@data-title='Questionnaire Name']/a/span";
	public static final String SearchTxt ="@xpath=//input[@placeholder='Search']";
	public static final String SelectQuestionnaire2 ="@xpath=//*[@value='Automation Risk Format 14']";
	public static final String FilterBtn = "@xpath=//button[text()='Filter']";
	public static final String EditBtn ="@xpath=//*[@id='grid']//button[@ng-click='commandEdit(1)']";
	public static final String VerifyVersion ="@xpath=//*[@id='content']//td[contains(.,'SP - Only specified Sheet')]//following-sibling::td[1]";
	public static final String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'SP - All Sheet(s)')]//following-sibling::td[1]";
	public static final String VerifyVersion2 ="@xpath=//*[@id='content']//td[contains(.,'SP - All Sheet1(s)')]//following-sibling::td[1]";
	public static final String VerifyRandPVersion1 = "@xpath=//*[@id='content']//td[contains(.,'Automation Risk and Premium Format')]//following-sibling::td[1]";
	public static final String VerifyRandPVersion2 = "@xpath=//*[@id='content']//td[contains(.,'Automation Risk and Premium Format')]//following-sibling::td[1]";
	public static final String RemoveMarch2017 ="@xpath=//*[@class='k-reset']/li[1]/span/span";
	public static final String CancelBtn ="@xpath=//*[@ng-click='cancel()']";
	public static final String ActivateQueBtn = "@xpath=//*[@id='grid']//button[@ng-click='ActiveDeactive(dataItem,true)']";
	public static final String DeactivateQueBtn = "@xpath=//*[@id='grid']//button[@ng-click='ActiveDeactive(dataItem,false)']";
	public static final String DraftstatusQues = "@xpath=//div[@class='text-danger']";
	public static final String ActiveStatusBtn = "@xpath=//div[@class='text-success']";
	//Steps locators
	public static final String Steps ="@xpath=//*[@id='stepsBar']//li[contains(@class,'active')]";

	//Sprint 3 Premium Bordereau 
	public static final String premiumOption ="@xpath=//li[text()='Premium']";
	public static final String premiumSchemaOption ="@xpath=//li[contains(.,'Premium Property schema')]";
	public static final String LloydsPropertySchema ="@xpath=//li[contains(.,'Lloyd's Property Schema')]";
	public static final String Restatement2 ="@name=chk4";
	//Step 6 Premium
	public static final String grossPremiumplusTax ="@xpath=//input[@ng-model='BFCoreFinancialOptions.GrossPremiumincludingTax'][@value='false']";
	//edit
	public static final String DoesThisUniqueRadio ="@xpath=//input[@ng-model='form.uniqueRefAdjust'][@value='true']";
	public static final String StaticCharactersTxt ="@model=BFBasicDetails.StaticCharacters";
	public static final String MultipleRisksReportedRadio ="@xpath=//input[@ng-model='form.multilocation'][@value='false']";
	public static final String AscertainRiskValue ="@xpath=//*[@id='YearOfAccount_listbox'][@aria-hidden='false']//li[contains(.,'Ascertain from the Risk Inception Date')]";

	//Sprint 3 Claim Bordereau 
	public static final String ClaimOption ="@xpath=//li[text()='Claim']";
	//public static final String ClaimSchemaOption ="@xpath=//li[contains(.,'Automation Schema-Claim')]";
	public static final String ClaimSchemaOption ="@xpath=//li[contains(.,'Automation Claim schema FC')]";
	public static final String RateOfExchangeTxt ="@model=BFBasicDetailsClaim.RateOfExchange";
	
	//Risk and Premium Bordereau
	public static final String RiskAndPremiumOption = "@xpath=//li[text()='Risk And Premium']";
	public static final String RiskAndPremiumSchemaOption = "@xpath=//li[text()='Property Schema']";
	public static final String suppliedBordereauSheetBorddataOption ="@xpath=//li[text()='bord data']";

	public static final String RateOfExchangeDD ="@xpath=//*[@ng-model='BFBasicDetailsClaim.RateOfExchange']//preceding-sibling::span[1]";
	
	
	//Step 6 claim
	public static final String LossCounty ="@xpath=//*[@id='grid']//td[contains(text(),'Loss County')]";
	public static final String LossAddress ="@xpath=//*[@id='grid']//td[contains(text(),'Loss Address')]";
	//Step 7 claim
	public static final String RiskAddress ="@xpath=//*[@id='grid']//td[contains(text(),'Risk Address')]";
	//Step 8 claim
	public static final String InsuredAddress ="@xpath=//*[@id='grid']//td[contains(text(),'Insured Address')]";
	
	//Step 4 claim
		public static String  CoreDetails="@xpath=//*[@id='stepsBar']/li[4]/a";
	//Step 3 
	public static String  SheetAndHeader ="@xpath=//*[@id='stepsBar']/li[3]/a";
	public static String  RowCanNotChangeText ="@xpath=//*[text()=' To note: If you incorrectly selected the header row(s) in this step to identify the header fields to complete this questionnaire, then you need to cancel this questionnaire and start a new questionnaire. The above question only relates to the expected position of the header row during future processing.']";
	public static final String RiskOrder = "@xpath=//span[text()='Risk Order %']";
	public static final String RiskInceptionDate = "@xpath=//span[text()='Risk Inception Date']";
	public static final String RiskExpiry = "@xpath=//span[text()='Risk Expiry Date']";
	public static final String RiskCountry = "@xpath=//span[text()='Risk Country']";
	public static final String RiskCurrency = "@xpath=//span[text()='Risk Currency']";
	public static final String PremiumCurrency = "@xpath=//span[text()='Premium Currency']";
			public static final String RateOfExchangeOption ="@xpath=//*[@id='RateOfExchange-list']//li[contains(.,'Rate of exchage')]";
		public static final String RiskInceptionOption ="@xpath=//*[@id='RateOfExchange_listbox']//li[contains(.,'Risk Inception')]";
	
		public static final String RiskOrderDV = "@xpath=//td[text()='Risk Order %']//following::td//a[text()='Core Details']//following::td/button[text()='DEFAULT SPECIFIED']";
		public static final String RiskInceptionDateDV = "@xpath=//td[text()='Risk Inception Date']//following::td//a[text()='Risk Details']//following::td/button[text()='DEFAULT SPECIFIED']";
		public static final String RiskExpiryDV = "@xpath=//td[text()='Risk Expiry Date']//following::td//a[text()='Risk Details']//following::td/button[text()='DEFAULT SPECIFIED']";
		public static final String RiskCountryDV = "@xpath=//td[text()='Risk Country']//following::td//a[text()='Location Details']//following::td/button[text()='DEFAULT SPECIFIED']";
		public static final String RiskCurrencyDV = "@xpath=//td[text()='Risk Currency']//following::td//a[text()='Financials']//following::td/button[text()='DEFAULT SPECIFIED']";
		public static final String PremiumCurrencyDV = "@xpath=//td[text()='Premium Currency']//following::td//a[text()='Financials']//following::td/button[text()='DEFAULT SPECIFIED']";
		//Step 8 Risk & claim
		public static String  Deduction="@xpath=//*[@id='stepsBar']/li[8]/a";
		
	//Step 9 claim
	public static final String paragraph1 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[1]";
	public static final String paragraph2 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[2]";
	
	//Step 10 claim
	public static final String paragraph3 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[1]";
	public static final String paragraph4 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[2]";
	
	//Step 11 claim
	//public static final String paragraph5 ="@xpath=//*[@id='TotalIncurredClaim']/div/div/div[1]/p[1]";
	public static final String paragraph5 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[1]";
	public static final String paragraph6 ="@xpath=//*[@id='ReservePaidClaim']/div/div/div[1]/p[2]";
	
	//Step 13
	public static final String ReviewStep13 = "@xpath=//*[@id='stepsBar']/li[13]/a";
	
	String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireOnlySpecificText+"')][1]";

	//Edit Questionnaire
	public static final String FilterGrp ="@xpath=//*[@name='FilterGrp'][@value='false']";
	public static final String SpecifyFilter ="@xpath=//*[@id='content']//button[@ng-click='SpecifyFilter()']";

	public static final String AdditionalBookingBtn ="@xpath=//button[@ng-click='addFilterCondition()']";

	public static final String AppConDrpValRetain ="@xpath=//ul/li[text()='Rows should be retained if the conditions are met']";
	public static final String AppConDrp ="@xpath=//div[@class='fg-line']//select[@ng-model='data.IsFilterValid']//preceding-sibling::span";
	public static final String AppConDrpValDelete ="@xpath=//ul/li[text()='Rows should be deleted if the conditions are met']";
	//public static final String SaveChangesBtn ="@xpath=//button[@ng-click='save()']";
	public static final String SaveChangesBtn ="@xpath=//button[@ng-click-single='save()']";
	public static final String NumBuildings1 ="@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[1]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
	public static final String NumBuildings2 ="@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[2]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";

	public static final String RecordOne ="@xpath=//*[@id='grid']//tbody//tr";
	public static final String GotoHome ="@xpath=//*[@ng-click='back()']";

	public static final String VerifyVersionNumber = "@xpath =//*[@id='content']//td[contains(.,'SP- FirstSheet')]//following-sibling::td[1]";
	public static final String EditBtnVersionNo ="@xpath =//*[@id='grid']//div[@ng-click='commandEdit(8)']";
	public static final String NoteBtn ="@xpath=//*[@ng-click='OpenNotesPopup()']";
	public static final String NotePopup ="@xpath=//div[text()='Bordereau Questionnaire Notes']";
	public static final String AddNoteBtn ="@xpath=//*[@ng-click='addNote()']";
	public static final String AddNotePopup ="@xpath=//h2[text()='Add Note']";
	public static final String AddNoteTxt ="@xpath=//*[@ng-model='data.Note']";
	//public static final String SaveNoteBtn ="@xpath=//*[@ng-click='Save()']";
	public static final String SaveNoteBtn ="@xpath=//*[@ng-click-single='save()']";
	public static final String VersionCount="@xpath=//div[@class='m-b-20']//span[4]";
	public static final String NoteVersionCount="@xpath=//*[@class='k-grid-content k-auto-scrollable']//tr[1]//td[2]";
	public static final String SecondNoteVersionCount="@xpath=//*[@class='k-grid-content k-auto-scrollable']//tr[2]//td[2]";
	public static final String CancelNoteBtn ="@xpath=//*//button[@ng-click='cancel()']";

	public static final String Step11Btn ="@xpath=//li[@uib-popover='Remaining Fields']//*[@id='editLink']";
	public static final String FirstsheetVersion ="@xpath=//*[@id='content']//tr[1]//td[contains(.,'SP - First Sheet')]//following-sibling::td[1]";
	public static final String SecondVersionCount="@xpath=//*[@class='k-grid-content k-auto-scrollable']//tr[3]//td[2]";
	public static final String step11link ="@xpath=//*[@uib-popover='Remaining Fields']/a";
	public static final String Step12Btn ="@xpath=//li[@uib-popover='Review']//*[@id='editLink']";
	public static final String Step13Btn ="@xpath=//li[@uib-popover='Review']//*[@id='editLink']";

	public static final String riskAndPremiumOption ="@xpath=//li[text()='Risk And Premium']";
	public static final String suppliedBordereauSheetBordDataOption ="@xpath=//li[text()='bord data']";
	public static final String ShowadvanceOption ="@xpath=//label[@class='ts-helper']";
	public static final String StandaredRefereanceColumn ="@xpath=.//*[@data-title='Standard Reference']";
	public static final String EditInsuredName ="@xpath=//*[@ng-click='editClick(10)']";
	public static final String BorderueFieldNameFilter ="@xpath=//*[@data-title='Bordereau Field']/a/span";
	public static final String VerifyStandaredRefValue ="@xpath=//*[@id='StandardReference']";
	public static final String EditRiskIssuranceDate ="@xpath=//*[@ng-click='editClick(230)']";
	public static final String MandatoryYes ="@xpath=//*[@ng-model='fieldData.IsMandatory'][@value='true']/..";
	public static final String EditBuildingYearBuilt ="@xpath=//*[@ng-click='editClick(642)']";
	public static final String EditNumberofStories ="@xpath=//*[@ng-click='editClick(17)']";

	public static final String VerifyFirstRow ="@xpath=//tr[1]//*[@id='TideField']";
	public static final String VerifySecondRow ="@xpath=//tr[2]//*[@id='TideField']";
	public static final String VerifyThirdRow ="@xpath=//tr[3]//*[@id='TideField']";
	public static final String VerifyFourthRow ="@xpath=//tr[4]//*[@id='TideField']";
	public static final String ViewQueBtn ="@xpath=//*[@ng-click='OpenBordereauQuestionnairePopup()']";
	public static final String ViewQuetionnariePopup ="@xpath=//div[@class='pmbb-header']//div[Contains(text(),'View Bordereau Questionnaire')]";
	public static final String NoteTab ="@xpath=//*[@ng-click='OpenNotes()']";
	public static final String OkBtn ="@xpath=//*[@ng-click='ok()']";
	public static final String BSummaryPage ="@xpath=//h2[text()='Bordereau Summary']";
	
	//TC_Settlement financial
		public static final String SettlementFirstQYes ="@xpath=//*[@id='content']//input[@ng-model='SettlementFinancials.IsCoverholderSettlementCurrency'][@ng-value='true']";
		public static final String SettlementsecondQYes ="@xpath=//*[@id='content']//input[@ng-model='SettlementFinancials.IsBrokerSettlementCurrency'][@ng-value='true']";
		//public static final String SettlementFirstQYes ="@xpath=//input[@ng-model='SettlementFinancials.IsCoverholderSettlementCurrency'][@value='true']";
		//public static final String SettlementFirstQYes1  ="@xpath=//*[@id='content']/div/ui-view/div/form/div[2]/div/div/div[1]/dl/dd/div/label[1]/input";
		public static final String SettlementFirstQNo ="@xpath=//*[@name='CurrencyGrp'][@value='false']";
		public static final String SettlementSecondQYes ="@xpath=//*[@name='CurrencyGrp'][@value='true']";
		public static final String SettlementSecondQNo ="@xpath=//*[@name='CurrencyGrp'][@value='false']";
		public static final String TideValDrp11 = "@xpath=//div[@ng-class='{errorBorder: (!isFirstLoad && !SettlementFinancials.CoverholderSettlementCurrency)}']//span[@aria-label='select']";
		//public static final String TideValDrp111 = "@xpath=//*[@id=\"cafaee2c-58c1-4a77-96cb-42008e385163\"]/div/div";
		public static final String TideValDrp111 = "@xpath=//div[@class='k-animation-container']//li[@class='k-item ng-scope'][contains(.,'CCY')]";
		public static final String TideValDrp12 = "@xpath=//div[@ng-class='{errorBorder: (!isFirstLoad  && !SettlementFinancials.CoverholderSettlementCurrencyRoE)}']//span/span/span/span";
	    public static final String TideValDrp112 = "@xpath=//div[@class='k-animation-container']//li[@class='k-item ng-scope'][contains(.,'Rate of Exchange')]";
		public static final String TideValDrp13 = "@xpath=//div[@ng-class='{errorBorder: (!isFirstLoad  && !SettlementFinancials.NetPremium100Settlement)}']/div/span/span/span/span";
		public static final String TideValDrp113 = "@xpath=/html/body/div[10]/div/div[3]/ul/li[24]/div/div";

		public static final String Coverholdderstlmntccyroe ="@xpath=//div[@class='fg-line errorBorder']//preceding-sibling::span[1]//span[2]";
				
		public static final String rateofexchangeOption ="@xpath=//*[@id=\"content\"]/div/ui-view/div/form/div/div/div/div[2]/div[2]/dl/dd/div/div/div/span/span/span[1]";
		
	    //TC 1900
			public static final String AddcoverageBtn ="@xpath=//*[@ng-click='openAddEditPopup()']";
			public static final String Addingcoverage ="@xpath=//*[@ng-model='SingleData.Coverage_Name_Id']//preceding-sibling::span[1]";
			public static final String AddingcoverageOption ="@xpath=//ul//li[contains(.,'Escape of Water')]";
			public static final String CoverageIncludedFlag ="@xpath=//*[@ng-model='SingleData.Coverage_Included_Flag']//preceding-sibling::span[1]";
			public static final String CoverageIncludedFlagOption ="@xpath=//div[5]//ul//li[contains(.,'Coverage Included Flag')]";
			public static final String CurrencyCoverage ="@xpath=//*[@ng-model='SingleData.Coverage_Currency']//preceding-sibling::span[1]";
			public static final String CurrencyCoverageOption ="@xpath=//div[6]//ul//li[contains(.,'Coverage Currency')]";
			public static final String TotalSunInsured ="@xpath=//*[@ng-model='SingleData.Coverage_Total_Sums_Insured']//preceding-sibling::span[1]";
			public static final String TotalSunInsuredOption ="@xpath=//div[7]//ul//li[contains(.,'Coverage Total Sums Insured')]";
			public static final String CoverageLimit ="@xpath=//*[@ng-model='SingleData.Coverage_Limit']//preceding-sibling::span[1]";
			public static final String CoverageLimitOption ="@xpath=//div[8]//ul//li[contains(.,'Coverage Limit')]";
			public static final String DXB ="@xpath=//*[@ng-model='SingleData.Coverage_Deductible_Or_Excess_Type']//preceding-sibling::span[1]";
			public static final String DXBOption ="@xpath=//div[@class='k-animation-container']//li[@class='k-item ng-scope'][contains(.,'Coverage Deductible or Excess Type')]";
			public static final String DXA ="@xpath=//*[@ng-model='SingleData.Coverage_Deductible_Or_Excess_Amount']//preceding-sibling::span[1]";
			public static final String DXAOption ="@xpath=//div[10]//ul//li[contains(.,'Coverage Deductible or Excess Amount')]";
			public static final String DXP ="@xpath=//*[@ng-model='SingleData.Coverage_Deductible_Or_Excess_Percentage']//preceding-sibling::span[1]";
			public static final String DXPOption ="@xpath=//div[11]//ul//li[contains(.,'Coverage Deductible or Excess Percentage')]";
			public static final String DXPA ="@xpath=//*[@ng-model='SingleData.Coverage_Deductible_Or_Excess_Basis']//preceding-sibling::span[1]";
			public static final String DXPAOption ="@xpath=//div[12]//ul//li[contains(.,'Coverage Deductible or Excess Basis')]";
			public static final String GP ="@xpath=//*[@ng-model='SingleData.Coverage_Premium']//preceding-sibling::span[1]";
			public static final String GPOption ="@xpath=//div[13]//ul//li[contains(.,'Coverage Premium')]";	
			public static final String CoverageSave ="@xpath=//button[contains(.,'Save')]";
			
			public static final String CoveragetTabHeader1 ="@xpath=//tr[1]//td[2][text()='Escape of Water']";
			public static final String CoveragetTabHeader2 ="@xpath=//tr[1]//td[3][text()='Coverage Included Flag']";
			public static final String CoveragetTabHeader3 ="@xpath=//tr[1]//td[4][text()='Coverage Currency']";
			public static final String CoveragetTabHeader4 ="@xpath=//tr[1]//td[5][text()='Coverage Total Sums Insured']";
			public static final String CoveragetTabHeader5 ="@xpath=//tr[1]//td[6][text()='Coverage Limit']";
			public static final String CoveragetTabHeader6 ="@xpath=//tr[1]//td[7][text()='Coverage Deductible or Excess Basis']";
			public static final String CoveragetTabHeader7 ="@xpath=//tr[1]//td[8][text()='Coverage Deductible or Excess Amount']";
			public static final String CoveragetTabHeader8 ="@xpath=//tr[1]//td[9][text()='Coverage Deductible or Excess Percentage']";
			public static final String CoveragetTabHeader9 ="@xpath=//tr[1]//td[10][text()='Coverage Deductible or Excess Basis']";
			public static final String CoveragetTabHeader10 ="@xpath=//tr[1]//td[11][text()='Coverage Premium']";
			
			
			public static final String CoveragetTabHeader_1 ="@xpath=//tr[1]//td[2][text()='Terrorism']";
			
			//3810
			public static final String ExpertTabHeader1 ="@xpath=//tr[1]//td[2][text()='Escape of Water']";
			public static final String ExpertTabHeader2 ="@xpath=//tr[1]//td[3][text()='Expert Company Name']";
			public static final String ExpertTabHeader3 ="@xpath=//tr[1]//td[4][text()='Expert Company Reference']";
			public static final String ExpertTabHeader4 ="@xpath=//tr[1]//td[5][text()='Expert Company Address']";
			public static final String ExpertTabHeader5 ="@xpath=//tr[1]//td[6][text()='Expert Company State']";
			public static final String ExpertTabHeader6 ="@xpath=//tr[1]//td[7][text()='Expert Company Postal Code']";
			public static final String ExpertTabHeader7  ="@xpath=//tr[1]//td[8][text()='Expert Company Country']";
			
			public static final String ExpertTabHeader_1 ="@xpath=//tr[2]//td[2][text()='Escape of Water']";
			public static final String ExpertTabHeader_2 ="@xpath=//tr[2]//td[3][text()='Expert Company Name']";
			public static final String ExpertTabHeader_3 ="@xpath=//tr[2]//td[4][text()='Expert Company Reference']";
			public static final String ExpertTabHeader_4 ="@xpath=//tr[2]//td[5][text()='Expert Company Address']";
			public static final String ExpertTabHeader_5 ="@xpath=//tr[2]//td[6][text()='Expert Company State']";
			public static final String ExpertTabHeader_6 ="@xpath=//tr[2]//td[7][text()='Expert Company Postal Code']";
			public static final String ExpertTabHeader_7  ="@xpath=//tr[2]//td[8][text()='Expert Company Country']";
			
			public static final String ExpertTabHeader ="@xpath=//tr[1]//td[2][text()='Flood']";
			//1903
			public static final String EditCoverageBtn ="@xpath=//*[@ng-click='openAddEditPopup(dataItem)']";	
			public static final String AddingcoverageOption1 ="@xpath=//ul//li[contains(.,'Terrorism')]";		
			public static final String coveragSaveChanges ="@xpath=//button[@ng-click='save()']";
			
			
			//1905
			public static final String DeleteCoverageBtn ="@xpath=//*[@ng-click='delete()']";
			public static final String YesDeleteItBtn ="@xpath=//*[@ng-click='deleteBfCoverage()']";
			public static final String DeleteSentence ="@xpath=//*[@class='modal-dialog modal-md']//h2[contains(.,'Are you sure you want to delete Escape of Water Coverage?')]";
			public static final String NoResult ="@xpath=//*[@id='grid']//td[contains(.,'No result returned')]";
			public static final String AddingcoverageOption2 ="@xpath=//ul//li[contains(.,'Earthquake')]";
			public static final String CoverCancelBtn ="@xpath=//*[@class='btn btn-default cancel btn-space']";
			
			//1911 	
			public static final String suppliedBordereauSheetborddataOption ="@xpath=//li[text()='bord data']";
			public static final String AddingtypeofExpertcoverage ="@xpath=//*[@ng-model='SingleData.Expert_Role_Id']//preceding-sibling::span[1]";
			
			public static final String ExpertCopmpanyName ="@xpath=//*[@ng-model='SingleData.Expert_Company_Name']//preceding-sibling::span[1]";
			/*public static final String ExpertCopmpanyNameOption ="@xpath=//div[4]//ul//li[contains(.,'Expert Company Name')]";*/
			//public static final String ExpertCopmpanyName ="@xpath=//*[@ng-model='SingleData.Expert_Company_Name']//preceding-sibling::span//span[2]//span";
			public static final String ExpertCopmpanyNameOption ="@xpath=//div[@class='k-animation-container']//ul//li[contains(.,'Expert Company Name')]";
			//public static final String ExpertCopmpanyNameOption ="@xpath=//div[@class='k-animation-container']//ul//li[contains(.,'Expert Company Name')]";
			
			public static final String ExpertCopmpanyReference ="@xpath=//*[@ng-model='SingleData.Expert_Company_Reference']//preceding-sibling::span[1]";
			public static final String ExpertCopmpanyReferenceOption ="@xpath=//div[@class='k-animation-container']//ul//li[contains(.,'Expert Company Referenc')]";
			
			public static final String ExpertCopmpanyAddress ="@xpath=//*[@ng-model='SingleData.Expert_Company_Address']//preceding-sibling::span[1]";
			public static final String ExpertCopmpanyAddressOption ="@xpath=//div[@class='k-animation-container']//ul//li[contains(.,'Expert Company Address')]";
			
			public static final String ExpertCopmpanyState ="@xpath=//*[@ng-model='SingleData.Expert_Company_State']//preceding-sibling::span[1]";
			public static final String ExpertCopmpanyStateOption ="@xpath=//div[@class='k-animation-container']//ul//li[contains(.,'Expert Company State')]";
			
			public static final String ExpertCopmpanyPostalCode ="@xpath=//*[@ng-model='SingleData.Expert_Company_Postal_Code']//preceding-sibling::span[1]";
			public static final String ExpertCopmpanyPostalCodeOption ="@xpath=//div[@class='k-animation-container']//ul//li[contains(.,'Expert Company Postal Code')]";
			
			public static final String ExpertCopmpanyCountry ="@xpath=//*[@ng-model='SingleData.Expert_Company_Country']//preceding-sibling::span[1]";
			public static final String ExpertCopmpanyCountryOption ="@xpath=//div[@class='k-animation-container']//ul//li[contains(.,'Expert Company Country')]";
			
			public static final String searchtxt ="@xpath=//div[@class='k-list-container k-popup k-group k-reset k-state-border-up']//span//input";
			public static final String AddingcoverageOption3 ="@xpath=//ul//li[contains(.,'Flood')]";	
			
			
	public void addNewQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaire();
	}

	public void addNewQuestionnaireTC4058() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaireTC4058();
	}

	public void addNewQuestionnaire1ForTC4059() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaireTC4059();
	}

	public void sheetProcessingFirstSheet1(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess(SchemaName1);
	}

	public void sheetProcessingFirstSheet() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess();
	}

	public void sheetProcessingFirstSheet2(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess1(SchemaName1);
	}

	public void addNewQuestionnaireTC3603(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess_TC3603(SchemaName1);
	}
	
	public void addNewQuestionnaireTC4199(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess_TC4199(SchemaName1);
	}
	public void sheetProcessingFirstSheet5(String SchemaName1,String QueName) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess5(SchemaName1,QueName);
	}

	public void sheetProcessingLastSheet() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		lastSheetProcess();
	}
	public void sheetProcessingFirstSheet3(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess3(SchemaName1);
	}
	public void sheetProcessingFirstSheet4(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess4(SchemaName1);
	}
	public void sheetProcessingFirstSheet5(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess5(SchemaName1);
	}

	public void sheetProcessingFirstSheet6(String SchemaName1) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		firstSheetProcess6(SchemaName1);
	}
	
	public void sheetProcessingSpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		specificTextSheetProcess();
	}

	public void sheetProcessingEqualSpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		equalSpecificTextSheetProcess();
	}

	public void sheetProcessingAnySheetContainsSpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		//sleep(2000);
		bordereauQuePage();
		//sleep(2000);
		anySheetContainsSpecificTextProcess();
	}

	public void sheetProcessingOnlySpecificText() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		onlySpecificTextProcess();
	}

	public void editBordereauFormat(String que, String year) throws InterruptedException, AWTException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		editTextProcess(que, year);
	}


	public void addNewCSVQuestionnaire3749() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addCSVRiskandPremiumQuestionnaire();
	}
	
	public void addcoverageQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addCoverageQuestionnaire();
	}
	
	public void addExpertQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addexpertquestionnaire();
	}
	
	
	public void editaddcoverageQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String coverageVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
	 
	    sleep(2000);
	   if(getTextFrom(coverageVersion1).equals("1") == true)
	{
		Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
	}		
	  waitForElementToAppear(EditBtn, 3);
	  verifyMustExists(EditBtn,"Edit button");
	  click(EditBtn,"Edit button");
	  sleep(3000);
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
      nextStapeClick();
      
      verifyMustExists(EditCoverageBtn,"Edit Coverage button");
	  click(EditCoverageBtn,"Edit Coverage button");
      
	  verifyMustExists(Addingcoverage," ADD NEW COVERAGE button");
	  SelectDropDownValue(Addingcoverage, AddingcoverageOption1);
	  sleep(1000);
	  
	  verifyMustExists(coveragSaveChanges,"COVERAGE Save Changes button");
	  click(coveragSaveChanges, "COVERAGE Save Changes button");
	  
	 
	  verifyMustExists(AddcoverageBtn," ADD NEW COVERAGE button");
	  click(AddcoverageBtn," ADD NEW COVERAGE button");
	  
	  
	  SelectDropDownValue(Addingcoverage, AddingcoverageOption2);
	  sleep(1000);
	  
	  CoverageFields();
	  
	  sleep(1000);
	  verifyMustExists(CoveragetTabHeader_1,"Coverage Header_1");
	  verifyMustExists(CoveragetTabHeader2,"Coverage Header 2");
	  verifyMustExists(CoveragetTabHeader3,"Coverage Header 3");
      verifyMustExists(CoveragetTabHeader4,"Coverage Header 4");
	  verifyMustExists(CoveragetTabHeader5,"Coverage Header 5");
	  verifyMustExists(CoveragetTabHeader6,"Coverage Header 6");
	  verifyMustExists(CoveragetTabHeader7,"Coverage Header 7");
	  verifyMustExists(CoveragetTabHeader8,"Coverage Header 8");
	  verifyMustExists(CoveragetTabHeader9,"Coverage Header 9");
	  verifyMustExists(CoveragetTabHeader10,"Coverage Header 10");
	  sleep(1000);
	  nextStapeClick();
	  sleep(1000);
	  BFormatId= ReturnFormatID();
	  sleep(1000);
	  verifyMustExists(CancelBtn,"Cancel button");
	  click(CancelBtn,"Cancel button");
	  sleep(3000);
}
	

	public void editaddexpertQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String coverageVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
	 
	    sleep(2000);
	   if(getTextFrom(coverageVersion1).equals("1") == true)
	{
		Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
	}		
	  waitForElementToAppear(EditBtn, 3);
	  verifyMustExists(EditBtn,"Edit button");
	  click(EditBtn,"Edit button");
	  sleep(3000);
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  
      
      verifyMustExists(EditCoverageBtn,"Edit Coverage button");
	  click(EditCoverageBtn,"Edit Coverage button");
 		
	  SelectDropDownValue(AddingtypeofExpertcoverage, AddingcoverageOption3);
	  sleep(1000);
	  
	  ExpertFields(); // 12 Step Coverage
	  sleep(1000);
	  
	  verifyMustExists(ExpertTabHeader,"Expert Header 1");
	  verifyMustExists(ExpertTabHeader2,"Expert Header 2");
	  verifyMustExists(ExpertTabHeader3,"Expert Header 3");
	  verifyMustExists(ExpertTabHeader4,"Expert Header 4");
	  verifyMustExists(ExpertTabHeader5,"Expert Header 5");
	  verifyMustExists(ExpertTabHeader6,"Expert Header 6");
	  verifyMustExists(ExpertTabHeader7,"Expert Header 7");
	  
	  verifyMustExists(ExpertTabHeader_1,"Expert Header_1");
	  verifyMustExists(ExpertTabHeader_2,"Expert Header_2");
	  verifyMustExists(ExpertTabHeader_3,"Expert Header_3");
	  verifyMustExists(ExpertTabHeader_4,"Expert Header_4");
	  verifyMustExists(ExpertTabHeader_5,"Expert Header_5");
	  verifyMustExists(ExpertTabHeader_6,"Expert Header_6");
	  verifyMustExists(ExpertTabHeader_7,"Expert Header_7");
	  sleep(1000);
	 
	  nextStapeClick();
	  BFormatId = ReturnFormatID();
	  sleep(1000);
	  verifyMustExists(CancelBtn,"Cancel button");
	  click(CancelBtn,"Cancel button");
	  sleep(3000);
}
	

	public void deletecoverageQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String coverageVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
	 
	    sleep(2000);
	   if(getTextFrom(coverageVersion1).equals("2") == true)
	{
		Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
	}		
	  waitForElementToAppear(EditBtn, 3);
	  verifyMustExists(EditBtn,"Edit button");
	  click(EditBtn,"Edit button");
	  sleep(3000);
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
      nextStapeClick();
      
      verifyMustExists(EditCoverageBtn,"Edit Coverage button");
	  click(EditCoverageBtn,"Edit Coverage button"); 
	  verifyMustExists(DeleteCoverageBtn,"Delete Coverage button");
	  click(DeleteCoverageBtn,"Delete Coverage button");  
	  verifyMustExists(YesDeleteItBtn,"Yes Delete It button");
	  click(YesDeleteItBtn,"Yes Delete It button");
	  sleep(1000);
	  
	  verifyMustExists(EditCoverageBtn,"Edit Coverage button");
	  click(EditCoverageBtn,"Edit Coverage button");
	  verifyMustExists(DeleteCoverageBtn,"Delete Coverage button");
	  click(DeleteCoverageBtn,"Delete Coverage button"); 
	  verifyMustExists(YesDeleteItBtn,"Yes Delete It button");
	  click(YesDeleteItBtn,"Yes Delete It button");
	  sleep(1000);
	  
	  
	  verifyMustExists(NoResult,"No result Returned");
	  sleep(2000);
	
	  
	  nextStapeClick();
	  sleep(1000);
	  BFormatId= ReturnFormatID();
	  sleep(1000);
	  verifyMustExists(CancelBtn,"Cancel button");
	  click(CancelBtn,"Cancel button");
	  sleep(3000);
}
	
	public void deleteExpertQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String coverageVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
	 
	    sleep(2000);
	   if(getTextFrom(coverageVersion1).equals("2") == true)
	{
		Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
	}		
	  waitForElementToAppear(EditBtn, 3);
	  verifyMustExists(EditBtn,"Edit button");
	  click(EditBtn,"Edit button");
	  sleep(3000);
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  nextStapeClick();
	  
      
      verifyMustExists(EditCoverageBtn,"Edit Coverage button");
	  click(EditCoverageBtn,"Edit Coverage button"); 
	  verifyMustExists(DeleteCoverageBtn,"Delete Coverage button");
	  click(DeleteCoverageBtn,"Delete Coverage button");  
	  verifyMustExists(YesDeleteItBtn,"Yes Delete It button");
	  click(YesDeleteItBtn,"Yes Delete It button");
	  sleep(1000);
	  
	  verifyMustExists(EditCoverageBtn,"Edit Coverage button");
	  click(EditCoverageBtn,"Edit Coverage button");
	  verifyMustExists(DeleteCoverageBtn,"Delete Coverage button");
	  click(DeleteCoverageBtn,"Delete Coverage button"); 
	  verifyMustExists(YesDeleteItBtn,"Yes Delete It button");
	  click(YesDeleteItBtn,"Yes Delete It button");
	  sleep(1000);
	  
	  
	  verifyMustExists(NoResult,"No result Returned");
	  sleep(1000);
	  nextStapeClick();	 
	  sleep(2000);
	  FormatId = ReturnFormatID();
	  sleep(1000);
	  verifyMustExists(CancelBtn,"Cancel button");
	  click(CancelBtn,"Cancel button");
	  sleep(3000);
}
	public void editcoverage() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";
	 String coverageVersion2 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		editaddcoverageQuestionnaire();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(coverageVersion2,5);
		if(getTextFrom(coverageVersion2).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "FAIL");
		}
	
	}
	
	public void editExpert() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";
	 String coverageVersion2 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		editaddexpertQuestionnaire();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(coverageVersion2,5);
		if(getTextFrom(coverageVersion2).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "FAIL");
		}
	
	}
	

	public void deleteExpert() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";
	 String coverageVersion2 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		deleteExpertQuestionnaire();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(coverageVersion2,5);
		if(getTextFrom(coverageVersion2).equals("3") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 3", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "FAIL");
		}
	
	}
	
	public String BPOQuestionnaireRequestProcessRaiseRequest_TC1895() throws Exception
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		ApprovalAutoApprovalandpartialsubmissionPage Autop = new ApprovalAutoApprovalandpartialsubmissionPage();	
		String QuestionaireName = null;
	    String	subSheet = "";
	    String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
	    String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
      
	    policy.applyFilterPolicy(policy.PolicyNumber);
		policy.openSelectedPolicy();
		BordereauProcess.SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3 
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\BPO_File.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
	//	contractId = "6883d64d-9f43-49d5-b520-209bcb54cfd4";
		String Ufname = "S25794920181030.xlsx";	
		int size = 19570;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForluna(contractId, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		BordereauProcess.refreshAfterUploadedFileForReviewSatusAndUploadStatus();
		if(isVisible(BordereauProcess.UploadedButton)==true){
			Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
			verifyExists(BordereauProcess.UploadedButton,"Upload button");
			AssertBordereauStatusUploaded =  getTextFrom(BordereauProcess.UploadedButton);
			Report.LogInfo("UPLOADED status displayed", AssertBordereauStatusUploaded, "PASS");
			click(BordereauProcess.UploadedButton,"Upload button");

			//step 4
			verifyMustExists(IdentifysheetDD,"Applied Bordereau Dropdown");
			click(IdentifysheetDD,"Applied Bordereau Dropdown");
			sleep(2000);
			webDriver.findElement(By.xpath("//li[contains(text(),'First Sheet')]")).click();
			
			Autop.clickOnContinue();
			Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
           sleep(5000);
			//step 5 
			sendKeys(Inputheader,"1-2","Change header row");
			sleep(2000);
			click(Reprocess,"Click on reprocess");
			sleep(2000);
			Autop.clickOnContinue();
			sleep(10000);
			verifyExists(RaiseQuestionaireRequest,"Raise Questionaire Request");
			
			click(RaiseQuestionaireRequest,"Raise Questionaire Request");
			sleep(3000);
			findWebElement(premiumsChk).sendKeys(Keys.SPACE);
			findWebElement(limitsAndOthersChkLuna).sendKeys(Keys.SPACE);
			sleep(3000);
	        QuestionaireName = NewQuesCompleteRequest(BPOQuestionaire);
			verifyMustExists(BordereauProcess.UploadedButton,"Validate Warning");
			
			click(BordereauProcess.UploadedButton,"Upload button");
			String ValidateWarning = "@xpath=//h2[contains(.,'There is an outstanding Questionnaire Request related to this Bordereau. This must be completed before you can proceed. See the relevant Task against this Bordereau. You can either wait for the request to be completed, or select to complete the Task now, so you can proceed to complete, or select, a Questionnaire on a self-service basis.')]";
			verifyMustExists(ValidateWarning,"Validate Warning");
			String pauseButon = "@xpath=//button[text()='Pause']";
			click(pauseButon,"Pause button");
			return QuestionaireName;	
		}	
		return QuestionaireName;
	}
	public void BPOQuestionnaireRequestProcessTaskComplete_TC1896(String QuestionaireNam4) throws Exception
	{
		
		refreshPage();
		Report.LogInfo("", QuestionaireNam4, "PASS");
		verifyMustExists(NavigatetoTaskTab,"Navigate to task tab");
		click(NavigatetoTaskTab,"Navigate to task tab");
		String EditTask ="@xpath=//tr[1]/td[1]//button[text()]";
		String NewStatus ="@xpath=//td[1][text()='New']";
		String AckStatus ="@xpath=//td[1][text()='Acknowledged']";
		String MandatoryfieldNotSupplied ="@xpath=//button[contains(.,'MANDATORY FIELDS NOT SUPPLIED')]";
		String AddNotes ="@xpath=//h2[contains(.,'Add Notes')]";
		String RecordComplete ="@xpath=//button[contains(.,'RECORD COMPLETE')]";
		String NavigatetoQuestionaire ="@xpath=//div[@class='fg-line']//a[@ng-click='redirectToQuestionnaire()']";
		String NextStep ="@xpath=//button[text()='Next Step ']";
		String SaveAndProcess ="@xpath=//button[text()='SAVE & PROCESS BORDEREAU']";
		
		verifyMustExists(EditTask,"Navigate to task tab");
		click(EditTask,"Navigate to task tab");
		
		verifyMustExists(ACKNOWLEDGEbtn,"Click on Acknowledge");
		click(ACKNOWLEDGEbtn,"Click on Acknowledge");
		
		verifyMustExists(RelatedEntityFilter,"Filter related entity");
		click(RelatedEntityFilter,"Filter related entity");
		
		
		
		verifyMustExists(Searchtext,"Search text");
		sendKeys(Searchtext,policy.PolicyNumber,"text entered");
		String PN = policy.PolicyNumber;
		
	String searchtext = "@xpath=//label//span[contains(.,'"+PN+"')]";
	

		
	verifyMustExists(searchtext,"Filter related entity");
	click(searchtext,"Filter related entity");
	String filter = "@xpath=//button[@type='submit']";
	verifyMustExists(filter,"Filter  ");
	click(filter,"Filter");
	
	verifyMustExists(EditTask,"Navigate to task tab");
	click(EditTask,"Navigate to task tab");
	
	verifyMustExists(NewStatus,"Verify New Status");
	verifyMustExists(AckStatus,"Verify Acknowledge Status");
	verifyMustExists(MandatoryfieldNotSupplied,"Mandatory button");
	verifyMustExists(RecordComplete,"Record Complete");
	verifyMustExists(NavigatetoQuestionaire,"Navigate to Questionaire");
	click(NavigatetoQuestionaire,"Navigate to Questionaire");
	
	for(int i=0;i<=9;i++) {
		
	if(i==6) {
		step8();
	}else if(i==2){
		refreshPage();
		verifyMustExists(NextStep,"Navigate to Questionaire");
		click(NextStep,"Navigate to Questionaire");
		} else {
	verifyMustExists(NextStep,"Navigate to Questionaire");
	click(NextStep,"Navigate to Questionaire");
	}
	}
	
	verifyMustExists(SaveAndProcess,"Navigate to Questionaire");
	click(SaveAndProcess,"Navigate to Questionaire");
	
	verifyMustExists(NavigatetoTaskTab,"Navigate to task tab");
	click(NavigatetoTaskTab,"Navigate to task tab");
	verifyMustExists(RelatedEntityFilter,"Filter related entity");
	click(RelatedEntityFilter,"Filter related entity");
	verifyMustExists(Searchtext,"Search text");
	sendKeys(Searchtext,policy.PolicyNumber,"text entered");
	verifyMustExists(searchtext,"Filter related entity");
    click(searchtext,"Filter related entity");
    verifyMustExists(filter,"Filter  ");
    click(filter,"Filter");
    verifyMustExists(EditTask,"Navigate to task tab");
    click(EditTask,"Navigate to task tab");
    verifyMustExists(RecordComplete,"Record Complete");
    click(RecordComplete,"Record Complete");
  String Addnotes ="@xpath=//input[@ng-model='notes']";
    
    verifyMustExists(Addnotes,"Search text");
	sendKeys(Addnotes,policy.PolicyNumber,"text entered");
	
String ClickSave = "@xpath=//button[@ng-click='save()']";	
	 verifyMustExists(ClickSave,"Record Complete");
	    click(ClickSave,"Record Complete");

	}
	public void BPOQuestionnaireRequestProcessAdjustmentRequest() throws Exception
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		String subSheet = "";
	//	 policy.PolicyNumber = "";
		    policy.applyFilterPolicy(policy.PolicyNumber);
			policy.openSelectedPolicy();
			
		//  BordereauProcess.SubmitBordereaux(subSheet);
			waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
			sleep(1500);
			verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
			click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
			sleep(2000);
			BordereauProcess.navigateOnProcessingTab();
			
		  verifyMustExists(taskiconLink,"Task Icon Link");
		  click(taskiconLink,"Task Icon Link");
		  String StatusComplete = "@xpath=//td[5][text()='Complete']";
		  verifyMustExists(StatusComplete,"Status Complete");
		    
		  String AddQuesAdjustmentTask = "@xpath=//button[@ng-click='openAdjustmentPopup()']";
		  verifyMustExists(AddQuesAdjustmentTask,"Task Icon Link");
		  click(AddQuesAdjustmentTask,"Task Icon Link");
		  
		  String AddAdjustment = "@xpath=//button[contains(.,'Adjustment')]";
		  verifyMustExists(AddAdjustment,"Task Icon Link");
		  click(AddAdjustment,"Task Icon Link");
		  String AddAdjustmentDD = "@xpath=//span[text()='-- Select --']";
		  String AddAdjustmentDV = "@xpath=//li[text()='Other']";
		  	 
		  SelectDropDownValue(AddAdjustmentDD,AddAdjustmentDV);
		  
		  String OtherDescription = "@xpath=//input[@type='text']";
			   
		  verifyMustExists(OtherDescription,"Search text");
		  sendKeys(OtherDescription,policy.PolicyNumber,"text entered");
		  
		  String SaveBtn = "@xpath=//button[contains(.,'Save')]";
		  verifyMustExists(SaveBtn,"Save button");
		  click(SaveBtn,"Save button");
		
		  
		  String CreateAdjustmentTask = "@xpath=//button[contains(.,'CREATE ADJUSTMENT TASK')]";
		  verifyMustExists(CreateAdjustmentTask,"Create Adjustment");
		  click(CreateAdjustmentTask,"Create Adjustment");
		  String okbutton ="@xpath=//button[contains(.,'OK')]";
			verifyMustExists(okbutton,"OK button");
			click(okbutton,"Click on OK button");  
			
	       	verifyMustExists(taskiconLink,"Task Icon in red");
			click(taskiconLink,"Click on task Icon");
			verifyMustExists(TaskTile2,"Task Title");
			verifyMustExists(TaskType2,"Task Type");
			verifyMustExists(TaskStatus,"Task Status");
			verifyMustExists(okbutton,"OK button");
			click(okbutton,"Click on OK button");
			
	}
	public void BPOQuestionnaireRequestProcessAdjustmentRequestComplete(String questionaireNae)  throws Exception
	{
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		// policy.PolicyNumber = "";
		    policy.applyFilterPolicy(policy.PolicyNumber);
			policy.openSelectedPolicy();
			
		//  BordereauProcess.SubmitBordereaux(subSheet);
			waitForElementToAppear(BordereauProcess.BORDEREAUXLink,5);
			sleep(1500);
			verifyMustExists(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
			click(BordereauProcess.BORDEREAUXLink,"BORDEREAUX Link");
			sleep(2000);
			BordereauProcess.navigateOnProcessingTab();
			
		  verifyMustExists(taskiconLink,"Task Icon Link");
		  click(taskiconLink,"Task Icon Link");
		  
		  verifyMustExists(AdjustmentTaskStatus,"Task Status");
		  String okbutton ="@xpath=//button[contains(.,'OK')]";
			verifyMustExists(okbutton,"OK button");
			click(okbutton,"Click on OK button");
			
			 String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+questionaireNae+"')][1]";

				homePage.adminMenu();
				bordereauQueLink();
				bordereauQuePage();
				filterBordereauQuestionnaire(questionaireNae, SelectQuestionnaire);
			    String DeactivateQues = "@xpath=//button[text()='Deactivate']";	
				verifyMustExists(DeactivateQues,"Deactivate");
				click(DeactivateQues,"Deactivate");
			
				
	}
	public void BPOQuestionnaireAdjustmentrequestComplete() throws Exception
	{
		verifyMustExists(NavigatetoTaskTab,"Navigate to task tab");
		click(NavigatetoTaskTab,"Navigate to task tab");
		String EditTask ="@xpath=//tr[1]/td[1]//button[text()]";
		String NewStatus ="@xpath=//td[1][text()='New']";
		String AckStatus ="@xpath=//td[1][text()='Acknowledged']";
		String MandatoryfieldNotSupplied ="@xpath=//button[contains(.,'MANDATORY FIELDS NOT SUPPLIED')]";
		String AddNotes ="@xpath=//h2[contains(.,'Add Notes')]";
		String RecordComplete ="@xpath=//button[contains(.,'RECORD COMPLETE')]";
		String NavigatetoQuestionaire ="@xpath=//div[@class='fg-line']/label[2]/a[@ng-click='redirectToQuestionnaire()']";
		String NextStep ="@xpath=//button[contains(.,'Next Step')]";
		String SaveAndProcess ="@xpath=//button[text()='SAVE AND REPROCESS']";
		
		verifyMustExists(EditTask,"Navigate to task tab");
		click(EditTask,"Navigate to task tab");
		
		verifyMustExists(ACKNOWLEDGEbtn,"Click on Acknowledge");
		click(ACKNOWLEDGEbtn,"Click on Acknowledge");
		
		verifyMustExists(RelatedEntityFilter,"Filter related entity");
		click(RelatedEntityFilter,"Filter related entity");
		
//		policy.PolicyNumber = "418952OE";
		
		verifyMustExists(Searchtext,"Search text");
		sendKeys(Searchtext,policy.PolicyNumber,"text entered");
		
		String PN = policy.PolicyNumber;
		
		String searchtext = "@xpath=//label//span[contains(.,'"+PN+"')]";
		
		
	verifyMustExists(searchtext,"Filter related entity");
	click(searchtext,"Filter related entity");
	String filter = "@xpath=//button[@type='submit']";
	verifyMustExists(filter,"Filter  ");
	click(filter,"Filter");
	
	verifyMustExists(EditTask,"Navigate to task tab");
	click(EditTask,"Navigate to task tab");
	
	verifyMustExists(NewStatus,"Verify New Status");
	verifyMustExists(AckStatus,"Verify Acknowledge Status");
	verifyMustExists(MandatoryfieldNotSupplied,"Mandatory button");
	verifyMustExists(RecordComplete,"Record Complete");
	verifyMustExists(NavigatetoQuestionaire,"Navigate to Questionaire");
	click(NavigatetoQuestionaire,"Navigate to Questionaire");
	
	for(int i=0;i<11;i++) {
		
	sleep(2000);
	verifyMustExists(NextStep,"Next Step");
	click(NextStep,"Next Step");
	}
	
	verifyMustExists(SaveAndProcess,"Navigate to Questionaire");
	click(SaveAndProcess,"Navigate to Questionaire");
	
	verifyMustExists(NavigatetoTaskTab,"Navigate to task tab");
	click(NavigatetoTaskTab,"Navigate to task tab");
	verifyMustExists(RelatedEntityFilter,"Filter related entity");
	click(RelatedEntityFilter,"Filter related entity");
	verifyMustExists(Searchtext,"Search text");
	sendKeys(Searchtext,policy.PolicyNumber,"text entered");
	verifyMustExists(searchtext,"Filter related entity");
    click(searchtext,"Filter related entity");
    verifyMustExists(filter,"Filter  ");
    click(filter,"Filter");
    verifyMustExists(EditTask,"Navigate to task tab");
    click(EditTask,"Navigate to task tab");
    verifyMustExists(RecordComplete,"Record Complete");
    click(RecordComplete,"Record Complete");
  String Addnotes ="@xpath=//input[@ng-model='notes']";
    
    verifyMustExists(Addnotes,"Search text");
	sendKeys(Addnotes,policy.PolicyNumber,"text entered");
	
     String ClickSave = "@xpath=//button[@ng-click='save()']";	
	 verifyMustExists(ClickSave,"Record Complete");
	    click(ClickSave,"Record Complete");	
	}
	
	
	
	
	public void deletecoverage() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
	 String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";
	 String coverageVersion2 ="@xpath=//*[@id='content']//td[contains(.,'"+EditName+"')]//following-sibling::td[1]";
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		deletecoverageQuestionnaire();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(coverageVersion2,5);
		if(getTextFrom(coverageVersion2).equals("3") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 3", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "FAIL");
		}
	
	}
	//3460	Edit Bordereaux Questionaire 
	public void editBordereauFormat() throws InterruptedException, AWTException
	{
	    String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		editTextProcess();
		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		versionNumber = getTextFrom(VerifyVersion1);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	//3723	Add a Premium Questionaire 
	public void addPremiumQuestionaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addPremiumQuestionaireFile();
	}

	//3733	Edit a Questionaire 
	public void editPremiumQuestionaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+PremiumBordereauText+"')]//following-sibling::td[1]";
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+PremiumBordereauText+"')][1]";

		filterBordereauQuestionnaire(PremiumBordereauText, SelectQuestionnaire);
		sleep(5000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}	
		//sleep(2000);
		
		waitForElementToAppear(EditBtn, 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		
		/*
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");*/
		sleep(3000);
		nextStapeClick();
		nextStapeClick();
		javaScriptclick(DoesThisUniqueRadio,"Does This Unique reference Yes button");
		verifyMustExists(StaticCharactersTxt,"Static Characters textbox");
		sendKeys(StaticCharactersTxt,"2","Static Characters textbox");
		javaScriptclick(MultipleRisksReportedRadio,"Does This Unique reference Yes button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		verifyMustExists(AscertainRiskValue,"Ascertain from the Risk Inception Date");
		click(AscertainRiskValue,"Ascertain from the Risk Inception Date");
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
		filterBordereauQuestionnaire(PremiumBordereauText,SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		versionNumber =getTextFrom(VerifyVersion1);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}
//3532	Add a bordereau Format(Claim)
	public void addBordereauFormatClaim() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		sleep(60000);
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addClaimQuestionaireFile();
	}

	public void addBordereauFormatClaim1() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addClaimQuestionaireFile1();
	}
	
	//3648	Add a bordereau Format(Claim)
		public void addBordereauFormatClaim_3648(String SchemaName) throws InterruptedException, AWTException, ClientProtocolException, IOException
		{
			homePage.adminMenu();
			bordereauQueLink();
			bordereauQuePage();
			addClaimQuestionaireFil_3648(SchemaName);
		}

	

	//3533	Edit Bordereau Format(Claim)
	public void editClaimQuestionaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'"+ClaimBordereauText+"')]//following-sibling::td[1]";
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+ClaimBordereauText+"')][1]";

		filterBordereauQuestionnaire(ClaimBordereauText, SelectQuestionnaire);
		sleep(5000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}	
		//sleep(5000);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		sleep(3000);
		nextStapeClick();
		/*verifyMustExists(RateOfExchangeTxt,"Rate Of Exchange textbox");
		sendKeys(RateOfExchangeTxt,"3","Rate Of Exchange textbox");*/
		
		verifyMustExists(OriginalCurrencyDD1,"Bordereau associated Dropdown");
		click(OriginalCurrencyDD1,"Bordereau associated Dropdown");
		click(SettlementCurrencyval,"Select Automation Schema Option");
		nextStapeClick();
		nextStapeClick();
		verifyMustExists(LossAddress,"Loss Address");
		click(LossAddress,"Loss Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
		sleep(3000);
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
		filterBordereauQuestionnaire(ClaimBordereauText, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		versionNumber =getTextFrom(VerifyVersion1);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	//4058	Bordereau Questionaire- Tide Admin
	public void BordereauQuestionaireTideAdmin_4058() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		addNewQuestionnaireTC4058();
		editBordereauFormatDubForTc4058_1();
		deactivateQuestionnaire();
	}

	//4059	Bordereau Questionaire- Company Admin
	public void BordereauQuestionaireCompanyAdmin_4059() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		addNewQuestionnaire1ForTC4059();
		//editBordereauFormatDubForTc4058();
		deactivateQuestionnaire();
	}

	//4060	Bordereau Questionaire- Standard user
	public void BordereauQuestionaireStandardUser_4060() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		addNewQuestionnaire1ForTC4059();
	//	editBordereauFormatDubForTc4058_1();
		deactivateQuestionnaire();
	}

	//4061	Bordereau Questionaire- Standard user
	public String adminTabVisible;
	public void BordereauQuestionaireReadOnly_4061() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		sleep(2000);
		if(isVisible(homePage.adminDropdown)==false){
			Report.LogInfo("ReadOnly", "Admin tab not available for this user", "PASS");
			adminTabVisible = "PASS";
			
		}else{
			Report.LogInfo("ReadOnly", "Admin tab is available for this user", "FAIL");
			adminTabVisible = "FAIL";

		}
	}

	public void AddBordereauQuestionaireNotes_4197() throws Exception
	{
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireName1stSheet+"')][1]";
		//TC3135
		sheetProcessingFirstSheet();
		refreshPage();
		filterBordereauQuestionnaire(QuestionnaireName1stSheet, SelectQuestionnaire);
		sleep(2000);
		verifyMustExists(FirstsheetVersion,"First sheet Version");
		//String  VersionNumber = getTextFrom(FirstsheetVersion);
		versionNumber = getTextFrom(FirstsheetVersion);
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);

		verifyMustExists(NoteBtn,"Note button");
		String NoteCount =getTextFrom(NoteBtn);
		String NoteCount0 ="NOTES - 0";
		if(NoteCount.equals(NoteCount0)){
			Report.LogInfo("VerifyNoteCount", "Note Count is Zero", "PASS");
			click(NoteBtn,"Notevbutton");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Note Count is not Zero", "Fail");
			click(NoteBtn,"Note button");
		}
		sleep(2000);
		verifyMustExists(NotePopup,"Note Popup");
		NotePopupText = getTextFrom(NotePopup);
		Report.LogInfo("Note Popup", NotePopupText, "PASS");
		verifyMustExists(AddNoteBtn,"Add Note button");
		click(AddNoteBtn,"Add Note button");
		sleep(2000);
		verifyMustExists(AddNotePopup,"Note Popup");
		verifyMustExists(AddNoteTxt,"Note Textbox");
		sendKeys(AddNoteTxt,"Test");
		sleep(2000);
		verifyMustExists(SaveNoteBtn,"Save Note button");
		click(SaveNoteBtn,"Save Note button");
		verifyMustExists(VersionCount," Version Count is 1");
		verifyMustExists(NoteVersionCount,"Version Count is 1");
		verisoncount1 = getTextFrom(NoteVersionCount);
		Report.LogInfo(" Version Count is 1", verisoncount1, "PASS");
		String NoteCnt= getTextFrom(NoteVersionCount);
		if(versionNumber.equals(NoteCnt))
		{
			Report.LogInfo("VerifyNoteCount", "Note Count is matched", "PASS");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Note Count is not matched", "Fail");
		}
		verifyMustExists(AddNoteBtn,"Add Note button");
		click(AddNoteBtn,"Add Note button");
		sleep(2000);
		verifyMustExists(AddNotePopup,"Add Note Popup");
		verifyMustExists(AddNoteTxt,"Add Note Text");
		sendKeys(AddNoteTxt,"Test 1");
		sleep(2000);
		verifyMustExists(SaveNoteBtn,"Save Note button");
		click(SaveNoteBtn,"Save Note button");
		verifyMustExists(VersionCount,"Version Count");
		verifyMustExists(SecondNoteVersionCount,"Second Note Version Count");
		verisoncount2 = getTextFrom(SecondNoteVersionCount);
		Report.LogInfo(" Version Count is 1", verisoncount2, "PASS");
		String VersionCnt = getTextFrom(VersionCount);
		String SecondVersionCnt = getTextFrom(SecondNoteVersionCount);
		if(VersionCnt.equals(SecondVersionCnt))
		{
			Report.LogInfo("VerifyNoteCount", "Second Note Count is matched", "PASS");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Second Note Count is not matched", "Fail");
		}
		sleep(2000);
		verifyMustExists(CancelNoteBtn,"Add Note button");
		click(CancelNoteBtn,"Add Note button");
		verifyMustExists(NoteBtn,"Note button Count is changed");
		sleep(2000);
		refreshPage();
		verifyMustExists(Step11Btn,"Step11 button");
		click(Step11Btn,"Step11 button");
		sleep(2000);
		/*List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}
		sleep(2000);
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'Buildings Value')]//preceding-sibling::td/div/div";
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		sleep(2000);*/
		step12();
		step13_Risk();
		refreshPage();
		filterBordereauQuestionnaire(QuestionnaireName1stSheet, SelectQuestionnaire);
		waitForElementToAppear(FirstsheetVersion,5);
		if(getTextFrom(FirstsheetVersion).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		verifyMustExists(NoteBtn,"Note button");
		click(NoteBtn,"Notevbutton");			
		sleep(2000);
		verifyMustExists(NotePopup,"Note Popup");
		verifyMustExists(AddNoteBtn,"Add Note button");
		click(AddNoteBtn,"Add Note button");
		sleep(2000);
		verifyMustExists(AddNotePopup,"Note Popup");
		verifyMustExists(AddNoteTxt,"Note Text");
		sendKeys(AddNoteTxt,"Test2");
		sleep(2000);
		verifyMustExists(SaveNoteBtn,"Save Note button");
		click(SaveNoteBtn,"Save Note button");
		verifyMustExists(VersionCount,"Version Count");
		verifyMustExists(SecondVersionCount,"Save Note Version Count");
		String SecondVersionNote = getTextFrom(VersionCount);
		String SecondVersionNoteCnt= getTextFrom(SecondVersionCount);
		if(SecondVersionNote.equals(SecondVersionNoteCnt))
		{
			Report.LogInfo("VerifyNoteCount", "Note Count is matched", "PASS");
		}
		else{
			Report.LogInfo("VerifyNoteCount", "Note Count is not matched", "Fail");
		}
		sleep(2000);
		verifyMustExists(CancelNoteBtn,"Cancel Note button");
		click(CancelNoteBtn,"Cancel Note button");
		verifyMustExists(NoteBtn,"Note button Count is changed");
		refreshPage();
		
		verifyMustExists(CancelBtn,"Cancel  button");
		click(CancelBtn,"Cancel  button");
		refreshPage();
		
		
		/*verifyMustExists(Step12Btn,"Step12 Link");
		click(Step12Btn,"Step12 Link");
		sleep(2000);
		step13_Risk();
		sleep(3000);*/
		bordereauQuePage();
	}

	public void firstSheetProcess(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S67095720180505.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18056,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S67095720180505.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\Schema rule_3849.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S75248720181108.xlsx";
		int size = 18899;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		sleep(3000);
		 if(isVisible(loginPage.Username)==true) {
			 login.tideLogin("admin@tide.com","Test123@");
			 openurl(URL);	 
		 }
		 sleep(2000);
		
		

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		questionnaireName_3849 = QuestionnaireName;
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step_6_Risk();
		//step11();
		step6();
		step7_2();
		step8();
		step9();
		step10();
		//nextStapeClick();
		//step11();
		String BuildingsPopover = "@xpath=//div[@popover='Buildings']";
		String ContentsPopover = "@xpath=//div[@popover='Contents']";
		String SprinklersPopover = "@xpath=//div[@popover='Sprinklers']";
		String OccupancySchemePopover = "@xpath=//div[@popover='Occupancy Scheme']";
		String OccupancyCodePopover = "@xpath=//div[@popover='Occupancy Code']";
		String OccupancyDescriptionPopover = "@xpath=//div[@popover='Occupancy Description']";
		String YB = "@xpath=//div[contains(@popover,'YB')]//i";
		String TIV = "@xpath=//div[contains(@popover,'TIV')]//i";
		String GrossSpace = "@xpath=//div[contains(@popover,'Gross Space')]//i";
		String ConstructionScheme = "@xpath=//div[contains(@popover,'Construction Scheme')]//i";
		String ConstructionDescription = "@xpath=//div[contains(@popover,'Construction Description')]//i";
		String ConstructionCode = "@xpath=//div[contains(@popover,'Construction Code')]//i";
		String PostalCode = "@xpath=//div[contains(@popover,'Postal Code')]//i";
		String Country = "@xpath=//div[contains(@popover,'Country')]//i";
		String Buildings = "@xpath=//div[contains(@popover,'Buildings')]//i";
		String Address1 = "@xpath=//tr[6]//div[contains(@popover,'Address 1')]//i";
		String Address2 = "@xpath=//tr[7]//div[contains(@popover,'Address 1')]//i";
		String Address3 = "@xpath=//tr[11]//div[contains(@popover,'Address 1')]//i";
		String Address4 = "@xpath=//tr[17]//div[contains(@popover,'Address 1')]//i";
		String Contents1 = "@xpath=//tr[9]//div[contains(@popover,'Contents')]//i";
		String Contents2 = "@xpath=//tr[10]//div[contains(@popover,'Contents')]//i";
		String Contents3 = "@xpath=//tr[21]//div[contains(@popover,'Contents')]//i";

		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String NobuildingsDrag = "@xpath=//button[contains(.,'No. Buildings')]";
		String NobuildingsDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String LocationYearBuiltDrag = "@xpath=//button[contains(.,'YB')]";
		String LoactionYearBuiltDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";
		String FiscalDrag = "@xpath=//button[text()='Fiscal Code']";
		String FiscalDrop = "@xpath=//td[contains(.,'Fiscal Code')]//preceding-sibling::td/div/div";

		verifyMustExists(NobuildingsDrag, "No. building");
		verifyMustExists(NobuildingsDrop, "No. building");
		verifyMustExists(LocationYearBuiltDrag, "YB");
		verifyMustExists(LoactionYearBuiltDrop, "YB");
		verifyMustExists(SprinklersDrag, "Sprinkler");
		verifyMustExists(SprinklersDrop, "Sprinkler");
		verifyMustExists(FiscalDrag, "Fiscal Code");
		verifyMustExists(FiscalDrop, "Fiscal Code");
		
		
		dragDropElement(NobuildingsDrag,NobuildingsDrop);
		dragDropElement(LocationYearBuiltDrag,LoactionYearBuiltDrop);
		//dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		/*dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);*/
		dragDropElement(SprinklersDrag,SprinklersDrop);
		dragDropElement(FiscalDrag,FiscalDrop);


		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}

	/***********************************************************************************/
	public void bordereauQueLink()
	{
		//sleep(2000);
		verifyMustExists(bordereauQueLink,"Bordereau Questionnaire Link");
		click(bordereauQueLink,"Bordereau Questionnaire Link");
	}

	public void bordereauQuePage()
	{
		//sleep(2000);
		waitForElementToAppear(bordereauQuePage,2);
		verifyExists(bordereauQuePage,"Bordereau Questionnaire Page Title");	
	}

	public void addQuestionnaire() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{		
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_3126.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(allSheetsPath);
		String Filename = "S82243620180826.xlsx";
		int size = 24605;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
		 if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("admin@tide.com","Test123@");
			 openurl(URL);	 
		 }
		 sleep(2000);
		
		 
		step2(QuestionnaireName);
		
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
	//	===== header row cannot be chenged informing text - scenario added====
		waitForElementToAppear(SheetAndHeader,2);
		verifyMustExists(SheetAndHeader,"Step 3 click");
		click(SheetAndHeader,"Step 3 click");
		
		waitForElementToAppear(RowCanNotChangeText,2);
		verifyMustExists(RowCanNotChangeText,"Step 3, Row can not change text");
		RowCanNotChangeText_Actual= getTextFrom(RowCanNotChangeText);
		
		nextStapeClick();
		step4();
		step5();
		step11();
		step6();
		step7();
		step8();
		step9();
		step10();
		//step11();
		step12();
		step13_Risk();
		
		
	}
	
	public void addQuestionaireforDV() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{		
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_3126.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(allSheetsPath);
		String Filename = "S82243620180826.xlsx";
		int size = 24605;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
		 if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("admin@tide.com","Test123@");
			 openurl(URL);	 
		 }
		 sleep(2000);
		
		 
		step2(QuestionnaireName);
		
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
	//	===== header row cannot be chenged informing text - scenario added====
		waitForElementToAppear(SheetAndHeader,2);
		verifyMustExists(SheetAndHeader,"Step 3 click");
		click(SheetAndHeader,"Step 3 click");
		
		waitForElementToAppear(RowCanNotChangeText,2);
		verifyMustExists(RowCanNotChangeText,"Step 3, Row can not change text");
		RowCanNotChangeText_Actual= getTextFrom(RowCanNotChangeText);
		
		nextStapeClick();
		step4();
		step5_DV();
		step11();
		step6_DV();
		step7_DV();
		step8();
		step9();
		step10();
		//step11();
		step12();
		step13_DV();
		
		
	}
	//Headrer row Selecton Questionnaire
	public void addQuestionnaireHR() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{	
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38639920180430.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18146,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S38639920180430.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
	
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_1.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(firstSheetPath);
		
		String Filename = "S22566520181102.xlsx";
		int size = 18146;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1-2", "Header Row Count Textbox.");
		nextStapeClick();
		
		step4();
		step5();
		step11();
		step6();
		step7();
		step8();
		step9();
		step10();
		step12();
		step13_Risk();
		
		// Edited Questionnaire
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";

		filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		Edit = getTextFrom(EditBtn);
		Report.LogInfo("Edit button", Edit, "PASS");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
				
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1-3", "Header Row Count Textbox.");
		nextStapeClick();
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		Cancel = getTextFrom(CancelBtn);
		Report.LogInfo("Cancel button", Cancel, "PASS");
		click(CancelBtn,"Cancel button");
		
		addQuestionnaireHR_1();
		
	}
	public void addQuestionnaireHR_1() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		bordereauQuePage();
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
	    //String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S42827220180430.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S42827220180430.xlsx\"}}";
	    String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		File excelFile = new File(allSheetsPath);
		

		String Filename = "S66167320181102.xlsx";
		int size = 25257;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId= addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
	
		step2(QuestionnaireName);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1-2", "Header Row Count Textbox.");
		nextStapeClick();
		step_4();
		step_5();
		
	}

	public void addQuestionnaireTC4058() throws AWTException, ClientProtocolException, IOException
	{
		//String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24286620171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S24286620171010.xlsx\"}}";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S40807020180501.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S40807020180501.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(allSheetsPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		//refreshPage();
		openurl(URL);
		//UploadFile(allSheets,);
		step2(QuestionnaireName1);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
		step13_Risk();
	}

	public void addQuestionnaireTC4059() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S40807020180501.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S40807020180501.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
	
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(allSheetsPath);
		
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireName);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick1();

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		webDriver.manage().deleteAllCookies();
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath1 = fpath+"\\src\\test\\resources\\testdata\\January_2017.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile1 = new File(allSheetsPath1);
		uploadFileQue(requestURL, excelFile1, payload, URLname);
		String formatId1 = addNewBordereauFormat(payload, URLname);
		String URL1 = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId1+"&isEdit=0&CreateAndProcess=0";
		openurl(URL1);
		 if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("companyadmin.brookes@aspen.co.uk","Test123@");
			 openurl(URL);	 
		 }

		//UploadFile(allSheets,);
		step2(QuestionnaireName);
		step3(AllSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
		step13_Risk();
	}

	public void firstSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20096120180429.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S20096120180429.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S81761520180929.xlsx";
		int size = 17710;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step11();
		step6();
		step7();
		step8();
		step9();
		step10();
		//step11();
		step12();
		step13_Risk();
		
	}

	public void firstSheetProcess1(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S92757420180522.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24367,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S92757420180522.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\Schemarule2_3850.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S11200820180922.xlsx";
		int size = 24498;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		 sleep(3000);
		if (isVisible(loginPage.Username) == true) {
			loginPage.tideLogin("admin@tide.com", "Test123@");
			openurl(URL);
		}
		sleep(2000);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskAndPremiumOption,"Select Risk And Premium Option");
		click(riskAndPremiumOption,"Select Risk And Premium Option");
		sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		//step11();
		step_6_RP();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		nextStapeClick();
		nextStapeClick();
		
		
		sleep(1000);

		
		
		
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";

		String NoBuildingsDrag = "@xpath=//button[contains(.,'No. Buildings')]";
		String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);
		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}

	public void firstSheetProcess_TC3603(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S92757420180522.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24367,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S92757420180522.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\Schemarule_3603.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S77717120181212.xlsx";
		int size = 25766;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		 sleep(3000);
		if (isVisible(loginPage.Username) == true) {
			loginPage.tideLogin("admin@tide.com", "Test123@");
			openurl(URL);
		}
		sleep(2000);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskAndPremiumOption,"Select Risk And Premium Option");
		click(riskAndPremiumOption,"Select Risk And Premium Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		questionnaireName_3603=QuestionnaireName;
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5_TC3603();
		//step11();
		step_6_RP();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		nextStapeClick();
		nextStapeClick();
		
		
		sleep(1000);

		
		
		
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";
		
		String FISCALCODEDrag = "@xpath=//button[contains(.,'Fiscal Code')]";
		String FISCALCODEDrop = "@xpath=//td[contains(.,'Fiscal Code')]//preceding-sibling::td/div/div";
		
		String NoBuildingsDrag = "@xpath=//button[contains(.,'No. Buildings')]";
		String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
	
	/*	String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		*/
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";
		
		String RiskIssuanceDateDrag = "@xpath=//button[text()='Issuance Date']";
		String RiskIssuanceDateDrop = "@xpath=//td[contains(.,'Risk Issuance Date')]//preceding-sibling::td/div/div";
		
		
		
		verifyMustExists(YBDrag, "YB drag");
		verifyMustExists(YBDrop, "YB drop");
		verifyMustExists(ContentsDrag, "Contents Drag");
		verifyMustExists(ContentsDrop, "Contents Drop");
		verifyMustExists(AddressDrag, "Address Drag");
		verifyMustExists(AddressDrop, "Address Drop");
		verifyMustExists(CountryDrag, "Country Drag");
		verifyMustExists(CountryDrop, "Country Drop");
		
		verifyMustExists(NoBuildingsDrag, "No. Buildings drag");
		verifyMustExists(NoBuildingssDrop, "No. Buildings drop");
		verifyMustExists(PostalCodeDrag, "Postal Code Drag");
		verifyMustExists(PostalCodeDrop, "Postal Code Drop");
		verifyMustExists(BuildingsValueDrag, "Buildings Value Drag");
		verifyMustExists(BuildingsValueDrop, "Buildings Value Drop");
		verifyMustExists(RiskIssuanceDateDrag, "Risk Issuance Date Drag");
		verifyMustExists(RiskIssuanceDateDrop, "Risk Issuance Date Drop");
		
		verifyMustExists(FISCALCODEDrag, "FISCALCODED");
		verifyMustExists(FISCALCODEDrop, "FISCALCODED");
		
		


		
	
		
		
		
		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
		/*dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);*/
		dragDropElement(SprinklersDrag,SprinklersDrop);
		dragDropElement(RiskIssuanceDateDrag,RiskIssuanceDateDrop);
		dragDropElement(FISCALCODEDrag,FISCALCODEDrop);
		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}
	
	
	public void firstSheetProcess_TC4199(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - First sheet"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\SpecialCharacter_4198.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S25564420181213.xlsx";
		int size = 19830;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		 sleep(3000);
		if (isVisible(loginPage.Username) == true) {
			loginPage.tideLogin("admin@tide.com", "Test123@");
			openurl(URL);
		}
		sleep(2000);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskAndPremiumOption,"Select Risk And Premium Option");
		click(riskAndPremiumOption,"Select Risk And Premium Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		questionnaireName_3603=QuestionnaireName;
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		//step11();
		step_6_RP();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		nextStapeClick();
		nextStapeClick();
		sleep(1000);
		
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}


		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}

	public void lastSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12440520171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S12440520171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			lastSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_Last_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(lastSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireNameLastSheet);
		step3(LastSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void specificTextSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48296320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S48296320171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			specificTextSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Specific_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(specificTextSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireSpecificTextSheet);
		step3(SpecificTextSheetOption);
		waitForElementToAppear(sheetsContainTxt,2);
		verifyMustExists(sheetsContainTxt,"Questionnaire Name Textbox");
		sendKeys(sheetsContainTxt,"March");
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Questionnaire Name Textbox");
		sendKeys(headerRowCountTxt,"1");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void firstSheetProcess3(String SchemaName) throws AWTException, ClientProtocolException, IOException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S82113320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S82113320171010.xlsx\"}}";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S37427020171126.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":25257,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S37427020171126.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7_1();
		step8();
		step9();
		step10();

		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Building Year Built')]//preceding-sibling::td/div/div";

		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Sprinklers')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);


		step11();
		BFormatId= ReturnFormatID();
		step12();
	}

	public void firstSheetProcess4(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25064520180504.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":17948,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S25064520180504.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2018_3937.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S79854020181003.xlsx";
		int size = 17948;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		 sleep(3000);
		if (isVisible(loginPage.Username) == true) {
			loginPage.tideLogin("nilesk1@otak.co.uk", "systenics1234@");
			openurl(URL);
		}
		sleep(2000);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		//step11();
		step_6_Risk();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		//step11();
		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";

		String NoBuildingsDrag = "@xpath=//button[contains(.,'No. Buildings')]";
		String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
		/*dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);*/
		dragDropElement(SprinklersDrag,SprinklersDrop);
		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}

	public void firstSheetProcess5(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25064520180504.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":17948,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S25064520180504.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2018_3937.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S79854020181003.xlsx";
		int size = 17948;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		 sleep(3000);
		if (isVisible(loginPage.Username) == true) {
			loginPage.tideLogin("nilesk1@otak.co.uk", "systenics1234@");
			openurl(URL);
		}
		sleep(2000);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskAndPremiumOption,"Select Risk and Premium Option");
		click(riskAndPremiumOption,"Select Risk and Premium Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step_6_RP();
		//step11();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		nextStapeClick();
		nextStapeClick();
		//step11();
		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";

		String NoBuildingsDrag = "@xpath=//button[contains(.,'No. Buildings')]";
		String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
		/*dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);*/
		dragDropElement(SprinklersDrag,SprinklersDrop);
		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}
	
	public void LunaQuestionnaire(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "Luna_Create_New_Questionnaire"+getCurrentDateTimeMS();

		
		sleep(2000);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step_6_RP();
		//step11();
		step6();
		step7_2();
		step8();
		step9();
		step10();
		nextStapeClick();
		nextStapeClick();
		//step11();
		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";

		String NoBuildingsDrag = "@xpath=//button[contains(.,'No. Buildings')]";
		String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		/*dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);*/
		step12();
		BFormatId= ReturnFormatID();
		ReviewStep_Luna();
	}
	
	
	public void firstSheetProcess6(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25064520180504.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":17948,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S25064520180504.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2018_3660.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S91485620181210.xlsx";
		int size = 19130;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		 sleep(3000);
		if (isVisible(loginPage.Username) == true) {
			loginPage.tideLogin("nilesk1@otak.co.uk", "systenics1234@");
			openurl(URL);
		}
		sleep(2000);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskAndPremiumOption,"Select Risk and Premium Option");
		click(riskAndPremiumOption,"Select Risk and Premium Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step_6_RP();
		//step11();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		nextStapeClick();
		nextStapeClick();
		//step11();
		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";
		
		String FISCALCODEDrag = "@xpath=//button[contains(.,'Fiscal Code')]";
		String FISCALCODEDrop = "@xpath=//td[contains(.,'Fiscal Code')]//preceding-sibling::td/div/div";
		
		String NAICCODEDrag = "@xpath=//button[contains(.,'NAIC Code')]";
		String NAICCODEDrop = "@xpath=//td[contains(.,'NAIC Code')]//preceding-sibling::td/div/div";
		
		String SurplusLinesFilingStateDrag = "@xpath=//button[contains(.,'Surplus Lines Filing State')]";
		String SurplusLinesFilingStateDrop = "@xpath=//td[contains(.,'Surplus Lines Filing State')]//preceding-sibling::td/div/div";
		
		

		String NoBuildingsDrag = "@xpath=//button[contains(.,'No. Buildings')]";
		String NoBuildingsDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		
		verifyMustExists(NoBuildingsDrag, "No. building");
		verifyMustExists(NoBuildingsDrop, "No. building");
		verifyMustExists(YBDrag, "YB");
		verifyMustExists(YBDrop, "YB");
		verifyMustExists(BuildingsValueDrag, "Buildings");
		verifyMustExists(BuildingsValueDrop, "BUildings");
		verifyMustExists(SprinklersDrag, "Sprinkler");
		verifyMustExists(SprinklersDrop, "Sprinkler");
		verifyMustExists(FISCALCODEDrag, "FISCALCODED");
		verifyMustExists(FISCALCODEDrop, "FISCALCODED");
		verifyMustExists(NAICCODEDrag, "NAICCODED");
		verifyMustExists(NAICCODEDrop, "NAICCODED");
		verifyMustExists(SurplusLinesFilingStateDrag, "SurplusLinesFilingState");
		verifyMustExists(SurplusLinesFilingStateDrop, "SurplusLinesFilingState");
		verifyMustExists(CountryDrag, "Country");
		verifyMustExists(CountryDrop, "Country");
		verifyMustExists(AddressDrag, "Address");
		verifyMustExists(AddressDrop, "Address");
		verifyMustExists(PostalCodeDrag, "PostalCode");
		verifyMustExists(PostalCodeDrop, "PostalCode");
		verifyMustExists(ContentsDrag, "Contents");
		verifyMustExists(ContentsDrop, "Contents");
		
		
		
		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingsDrop);
		/*dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);*/
		dragDropElement(SprinklersDrag,SprinklersDrop);
		dragDropElement(FISCALCODEDrag,FISCALCODEDrop);
		dragDropElement(NAICCODEDrag,NAICCODEDrop);
		dragDropElement(SurplusLinesFilingStateDrag,SurplusLinesFilingStateDrop);
		
		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}
	

	
	public void equalSpecificTextSheetProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S27595720171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S27595720171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			equalSpecificTextSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Specific_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(equalSpecificTextSheetPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireEqualSpecificTextSheet);
		step3(EqualSpecificTextSheetOption);
		waitForElementToAppear(sheetsContainTxt,2);
		verifyMustExists(sheetsContainTxt,"Sheets Contain Textbox");
		sendKeys(sheetsContainTxt,"March 2017","Sheets Contain Textbox.");
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void anySheetContainsSpecificTextProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16069320171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S16069320171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			anySheetContainsSpecificTextPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Equal_Any_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(anySheetContainsSpecificTextPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireAnySheetContainsSpecificText);
		step3(AnySheetContainsSpecificTextOption);
		waitForElementToAppear(sheetsContainTxt,2);
		verifyMustExists(sheetsContainTxt,"Sheets Contain Textbox");
		sendKeys(sheetsContainTxt,"2017","Sheets Contain Textbox.");

		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void onlySpecificTextProcess() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72986420171010.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24625,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S72986420171010.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			onlySpecificTextPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_Only_Specific_Text.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(onlySpecificTextPath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		step2(QuestionnaireOnlySpecificText);
		step3(OnlySpecificTextOption);
		waitForElementToAppear(specifiedSheetProcessedDD,2);
		verifyMustExists(specifiedSheetProcessedDD,"Please specify the sheet(s) to be processed Dropdown");
		click(specifiedSheetProcessedDD,"Please specify the sheet(s) to be processed Dropdown");
		//sleep(2000);
		click(specifiedSheetMarchOption,"Select March 2017 Option");
		//sleep(3000);
		click(specifiedSheetProcessedDD1,"Please specify the sheet(s) to be processed Dropdown");
		waitForElementToAppear(specifiedSheetMayOption,2);
		click(specifiedSheetMayOption,"Select May 2017 Option");
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1","Header Row Count Textbox.");
		nextStapeClick();
		step4RiskAndP();
		step5();
		step6();
		step7();
		step8();
		step9();
		step10();
		step11();
		step12();
	}

	public void addPremiumQuestionaireFile() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addPremiumQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\January 2017_PremiumQuestionaire_3732.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(addPremiumQuestionairePath);
		String Filename = "S11999520180425.xlsx";
		int size = 23081;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	    String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 openurl(URL);
		sleep(3000);
		if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("admin@tide.com","Test123@");
			 openurl(URL);	 
		 }

		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(premiumOption,"Select Premium Option");
		click(premiumOption,"Select Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		sleep(2000);
		click(premiumSchemaOption,"Select Automation Schema Option");
		sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,PremiumBordereauText,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3(AllSheetsOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		step5();
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);//step 10
		findWebElement(Restatement2).sendKeys(Keys.SPACE);
		nextStapeClick();
		step6_1();
		step8();
		nextStapeClick();
		nextStapeClick();
		nextStapeClick();
		
		//step11();		
		step14();
	}

	public void addClaimQuestionaireFile() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addClaimQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Jan_All sheets_BordereauFormatClaim_3532.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(addClaimQuestionairePath);
		String Filename = "S20884020180917.xlsx";
		int size = 22224;
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);	
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		
		 openurl(URL);
			sleep(3000);
			if(isVisible(loginPage.Username)==true) {
					loginPage.tideLogin("admin@tide.com","Test123@");
				 openurl(URL);	 
			 }

		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		sleep(2000);
		verifyMustExists(ClaimOption,"Select Premium Option");
		click(ClaimOption,"Select Premium Option");
		sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		sleep(2000);
		click(ClaimSchemaOption,"Select Automation Schema Option");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,ClaimBordereauText,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3(AllSheetsOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
		nextStapeClick();
		sleep(1000);
		step4Claim();		
		nextStapeClick();
		step6Claim();
		step7Claim();
		step8Claim();
		step9Claim();
		step10Claim();
		step11Claim();
		FormatId = ReturnFormatID();
		step12();
		step13();
		step14();
	}

	
	public void addClaimQuestionaireFil_3648(String SchemaName) throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String QuestionnaireName = "SP - First Sheet"+getCurrentDateTimeMS();
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addClaimQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\TC_3648.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(addClaimQuestionairePath);
		String Filename = "S34903920181212.xlsx";
		int size = 16144;
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);	
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		
		 openurl(URL);
			sleep(3000);
			if(isVisible(loginPage.Username)==true) {
					loginPage.tideLogin("admin@tide.com","Test123@");
				 openurl(URL);	 
			 }
		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(ClaimOption,"Select claim Option");
		click(ClaimOption,"Select Claim Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		questionnaireName_3648 = QuestionnaireName;
		step3(FirstSheetOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
		nextStapeClick();
		sleep(1000);
		step4Claim_3648();		
		//step4Claim_3648();
		nextStapeClick();
		//step6Claim();
		nextStapeClick();
		step7Claim();
		step8Claim();
		step9Claim();
		step10Claim();
		step11Claim();
		//step12();
		step12_Claim();
		step13_Claim();
		sleep(3000);
		BFormatId = ReturnFormatID();
			step14();
	}

	
	
	
	
	public void addClaimQuestionaireFile1() throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S28072720171113.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":22224,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S28072720171113.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addClaimQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Jan_All sheets_BordereauFormatClaim_3532.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(addClaimQuestionairePath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(ClaimOption,"Select Premium Option");
		click(ClaimOption,"Select Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		click(ClaimSchemaOption,"Select Automation Schema Option");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,ClaimBordereauText1,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3(AllSheetsOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
		nextStapeClick();
		step4Claim();		
		nextStapeClick();
		step6Claim();
		step7Claim();
		step8Claim();
		nextStapeClick();
		nextStapeClick();
		nextStapeClick();
		nextStapeClick();
		FormatId = ReturnFormatID();
		step12();
	}

	//3684	Edit Bordereaux Questionaire 
	public void FilterRecrdToRetainRcrd_3684() throws Exception
	{
		BordereauProcessPage BR = new BordereauProcessPage();
		String FormtFiltr = "Automation Risk Format 16";
		String IncDate = "01/01/2018";
		String IncExpDate = "31/12/2018";
		String subSheet = "Automation Risk Format 16 (Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(FormtFiltr);
		sleep(2000);
		waitForElementToAppear(EditBtn,5);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		nextStapeClick();
		nextStapeClick();			
		sleep(2000);
		//verifyMustExists(FilterGrp,"FilterGrp button");
		javaScriptclick(FilterGrp,"FilterGrp button");
		verifyMustExists(SpecifyFilter,"FilterGrp button");
		click(SpecifyFilter,"FilterGrp button");

		if(isVisible(AppConDrp)==true){
			verifyMustExists(AppConDrp,"Application Condition Drop down");
			click(AppConDrp,"Application Condition Drop down");
			sleep(1000);
			waitForElementToAppear(AppConDrpValRetain,5);
			verifyMustExists(AppConDrpValRetain,"Application Condition Drop down value");
			click(AppConDrpValRetain,"Application Condition Drop down value");
			sleep(1000);
			waitForElementToAppear(SaveChangesBtn,5);
			verifyMustExists(SaveChangesBtn,"Application Condition Drop down value");
			click(SaveChangesBtn,"Application Condition Drop down value");
		}
		sleep(2000);
		nextStapeClick();
		FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();
		String GetData = Configuration.url+"api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		BR.applyFilterPolicy(policy.PolicyNumber);
		BR.openSelectedPolicy();
		BR.SubmitBordereauxWithYesnoButtons(FormtFiltr);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3684Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_3684.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3684Path);	
		BR.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S82399420180827.xlsx";	
		int size = 22817;
		String BordreauID = "82e4d2e4-532d-4f03-802f-0b2d0a7d2f10";
        String response = uploadFileinContract(ReqUrl,excelFile,BR.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(BR.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+BR.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_3684.xlsx\",\"UniqueFileName\":\"S15778820180431.xlsx\",\"BordereauFormatId\":\"82e4d2e4-532d-4f03-802f-0b2d0a7d2f10\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+BR.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15778820180431.xlsx\",\"Filesize\":22817,\"Path\":null,\"size\":22817,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		BR.refreshUploadedFile();
		if(isVisible(BR.ReviewBtn) == true){
			BR.openDATALink();
			BR.navigateToDATARiskTab();
			if(isVisible(NumBuildings1)==true){
				NoBuildingValue = getTextFrom(NumBuildings1);
				Report.LogInfo("No Building Value matched", NoBuildingValue, "PASS");
				Report.LogInfo("RecordCheck", "Record Match.", "PASS");
			}else{
				Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
			}
			if(isVisible(NumBuildings2)==true){
				NoBuildingValue = getTextFrom(NumBuildings2);
				Report.LogInfo("No Building Value matched", NoBuildingValue, "PASS");
				Report.LogInfo("RecordCheck", "Record Match.", "PASS");
			}else{
				Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
			}
			BR.SubmitBordereauxWithYesnoButtons(FormtFiltr);
			if (isVisible(BR.ReviewBtn) == true) {
				AssertBordereauStatusReview = getTextFrom(BR.ReviewBtn);
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
				BR.deleteBorderEAUX();
			} else {
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
			}
			// deleteBorderEAUX();
		}else{
			Report.LogInfo("StatusCheck", "Review status not display.", "FAIL");
			BR.deleteBorderEAUX();
		}
	}

	//3695	Edit Bordereaux Questionaire 
	public void FilterRecrdToDiscardRcrd_3695() throws Exception
	{
		BordereauProcessPage BR = new BordereauProcessPage();
		String FormtFiltr = "Automation Risk Format 16";
		//String IncDate = "01/01/2017";
		//String IncExpDate = "31/12/2017";
		String subSheet = "Automation Risk Format 16 (Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(FormtFiltr);
		sleep(2000);
		waitForElementToAppear(EditBtn,5);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		nextStapeClick();
		nextStapeClick();			
		sleep(2000);
		javaScriptclick(FilterGrp,"FilterGrp button");
		verifyMustExists(SpecifyFilter,"FilterGrp button");
		click(SpecifyFilter,"FilterGrp button");

		if(isVisible(AppConDrp)==true){
			verifyMustExists(AppConDrp,"Application Condition Drop down");
			click(AppConDrp,"Application Condition Drop down");
			sleep(1000);
			waitForElementToAppear(AppConDrpValDelete,5);
			verifyMustExists(AppConDrpValDelete,"Application Condition Drop down value");
			click(AppConDrpValDelete,"Application Condition Drop down value");
			sleep(1000);
			waitForElementToAppear(SaveChangesBtn,5);
			verifyMustExists(SaveChangesBtn,"Application Condition Drop down value");
			click(SaveChangesBtn,"Application Condition Drop down value");
		}

		nextStapeClick();
		FormatId = ReturnFormatID();
		//System.out.println(FormatId);

		BR.applyFilterPolicy(policy.PolicyNumber);
		BR.openSelectedPolicy();
		BR.SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3695Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_3695.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3695Path);
		
		String Ufname = "S98203120180927.xlsx";	
		int size = 22806;
		String BordreauID = "82e4d2e4-532d-4f03-802f-0b2d0a7d2f10";
        String response = uploadFileinContract(ReqUrl,excelFile,BR.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(BR.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);

		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+BR.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_3695.xlsx\",\"UniqueFileName\":\"S67573120180431.xlsx\",\"BordereauFormatId\":\"82e4d2e4-532d-4f03-802f-0b2d0a7d2f10\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+BR.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S67573120180431.xlsx\",\"Filesize\":22806,\"Path\":null,\"size\":22806,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);

		BR.refreshUploadedFile();
		if(isVisible(BR.ReviewBtn) == true){
			BR.openDATALink();
			BR.navigateToDATARiskTab();
			if(isVisible(RecordOne)==true){
				RecordOne1 =  getTextFrom(RecordOne);	
				Report.LogInfo("RecordCheck", RecordOne1, "PASS");	
				Report.LogInfo("RecordCheck", "Record Match.", "PASS");
			}else{
				Report.LogInfo("RecordCheck", "Record not Match.", "FAIL");
			}
			BR.SubmitBordereauxWithYesnoButtons(FormtFiltr);	
			if(isVisible(BR.ReviewBtn)==true) {
				AssertBordereauStatusReview =  getTextFrom(BR.ReviewBtn);	
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
		        BR.deleteBorderEAUX(); 
	}else
		{
			Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
		}
			//deleteBorderEAUX();
		}else{
			Report.LogInfo("StatusCheck", "Review status not display.", "FAIL");
			BR.deleteBorderEAUX();
		}
	}

	public void StandardReferencesInQuestionnaire_TC4199() throws Exception
	{
		String QueNameFiltr ="Automation Risk Format 10";
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		//step1
		filterBordereauQuestionnaire1(QueNameFiltr);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(2000);
		verifyMustExists(Step13Btn,"Step13 Link");
		click(Step13Btn,"Step13 Link");
		sleep(2000);
		verifyMustExists(ShowadvanceOption,"Show advanced Option button");
		click(ShowadvanceOption,"Show advanced Option button");
		sleep(2000);
		scrollUp();
		filterBordereauField("Insured Name");
		verifyMustExists(VerifyStandaredRefValue,"Verify Standard Reference Value is CR0035 this");
		//step2
		homePage.adminMenu();
		waitForElementToAppear(DataRef.DatasetLink,5);
		verifyMustExists(DataRef.DatasetLink,"Dataset link");
		click(DataRef.DatasetLink,"Data set link");
		sleep(3000);
		DataRef.SelectRiskAndPremium();
		RemoveRiskAndPremiumData();
		//step3
		homePage.adminMenu();
		bordereauQueLink();
		sleep(1000);
		bordereauQuePage();
		filterBordereauQuestionnaire1(QueNameFiltr);
		verifyMustExists(EditBtn,"Edit button");
		Edit = getTextFrom(EditBtn);
		Report.LogInfo("Edit button",Edit, "PASS");
		click(EditBtn,"Edit button");
		sleep(2000);
		verifyMustExists(Step13Btn,"Step13 Link");
		click(Step13Btn,"Step13 Link");
		sleep(2000);
		verifyMustExists(ShowadvanceOption,"Show advanced Option button");
		click(ShowadvanceOption,"Show advanced Option button");
		sleep(2000);
		scrollUp();
		filterBordereauField("Insured Name");
		verifyMustExists(VerifyStandaredRefValue,"Verify Standard Reference Value is blank");
		step13_Risk();
		//step4
		homePage.adminMenu();
		waitForElementToAppear(DataRef.DatasetLink,5);
		verifyMustExists(DataRef.DatasetLink,"Dataset link");
		click(DataRef.DatasetLink,"Data set link");
		sleep(3000);
		DataRef.SelectRiskAndPremium();
		sleep(2000);
		EditRiskAndPremium();	//Add Value in DataSet
		//step5
		homePage.adminMenu();
		bordereauQueLink();
		sleep(1000);
		bordereauQuePage();
		filterBordereauQuestionnaire1(QueNameFiltr);
		verifyMustExists(EditBtn,"Edit button");
		Edit = getTextFrom(EditBtn);
		Report.LogInfo("Edit button",Edit, "PASS");
		click(EditBtn,"Edit button");
		sleep(2000);
		verifyMustExists(Step13Btn,"Step13 Link");
		click(Step13Btn,"Step13 Link");
		sleep(2000);
		verifyMustExists(ShowadvanceOption,"Show advanced Option button");
		click(ShowadvanceOption,"Show advanced Option button");
		sleep(2000);
		scrollUp();
		filterBordereauField("Insured Name");
		verifyMustExists(VerifyStandaredRefValue,"Verify Standard Reference Value is CR0035 this");
		step13_Risk();
	}

	public void ViewUsedQuestionnaire_TC4303() throws Exception
	{
		BordereauProcessPage BR = new BordereauProcessPage();
		String subSheet = "Automation Risk Format 10";
		String ReqUrl = Configuration.url+"api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(EditBtn,5);
		verifyMustExists(EditBtn,"Edit button");
		Edit = getTextFrom(EditBtn);	
		Report.LogInfo("Edit button", Edit, "PASS");
		click(EditBtn,"Edit button");
		nextStapeClick();
		FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();
		BR.applyFilterPolicy(policy.PolicyNumber);
		BR.openSelectedPolicy();
		BR.SubmitBordereaux(subSheet);
		String GetData = Configuration.url+"api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
	
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4303Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC4303.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4303Path);	
		BR.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S83735720181001.xlsx";	
		int size = 24402;
		String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
        String response = uploadFileinContract(ReqUrl,excelFile,BR.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(BR.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//System.out.println(contractId);
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+BR.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC4303.xlsx\",\"UniqueFileName\":\"S14443420180506.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+BR.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14443420180506.xlsx\",\"Filesize\":24401,\"Path\":null,\"size\":24401,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BR.refreshUploadedFile();
		if(isVisible(BR.ReviewBtn) == true){
			AssertBordereauStatusReview =  getTextFrom(BR.ReviewBtn);	
			Report.LogInfo("StatusCheck", "Review status is display.", "PASS");
			click(BR.ReviewBtn,"Click on Review Button");
			sleep(2000);
			verifyMustExists(ViewQueBtn,"View Questioneries");
			ViewQB =  getTextFrom(ViewQueBtn);	
			Report.LogInfo("View Questioneries", ViewQB, "PASS");
			click(ViewQueBtn,"View Questioneries");
			sleep(2000);
			//verifyMustExists(ViewQuetionnariePopup,"View Questioneries Popup");
			verifyMustExists(NoteTab,"Note Tab");
			Note =  getTextFrom(NoteTab);	
			Report.LogInfo("Note Tab", Note, "PASS");
			click(NoteTab,"Note Tab");
			sleep(1000);
			verifyMustExists(OkBtn,"Ok Button");
			OK =  getTextFrom(OkBtn);	
			Report.LogInfo("Ok Button", OK, "PASS");
			click(OkBtn,"Ok Button");
			sleep(1000);
			verifyMustExists(BSummaryPage,"Bordearue Summary Page");
		}else{
			Report.LogInfo("StatusCheck", "Review status not display.", "FAIL");
			BR.deleteBorderEAUX();
		}
	}


//====================================== Reusable function ===============================//

	public void step1() throws AWTException
	{
		waitForElementToAppear(addQueBtn,5);
		verifyMustExists(addQueBtn,"Add New Questionnaire Button");
		click(addQueBtn,"Add New Questionnaire Button");
		sleep(3000);
	}

	public void step2(String queName)
	{
		EditName = queName;
		System.out.println(EditName);
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		sleep(2000);
		click(automationSchemaOption,"Select Automation Schema Option");
		sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,queName,"Questionnaire Name Textbox.");
		nextStapeClick();

	}
	
	public String NewQuesCompleteRequest(String queName)
	{
		EditName = queName;
	
		verifyMustExists(businessClassDDLuna,"Bordereau associated Dropdown");
		click(businessClassDDLuna,"Bordereau associated Dropdown");
		sleep(2000);
		click(automationSchemaOption,"Select Automation Schema Option");
		sleep(2000);
		verifyMustExists(questionnaireNameTxtLuna,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxtLuna,queName,"Questionnaire Name Textbox.");
		String submitbutton ="@xpath=//button[contains(.,'Submit')]";
		verifyMustExists(submitbutton,"Submit button");
		click(submitbutton,"Click on submit button");
		
		String okbutton ="@xpath=//button[contains(.,'OK')]";
		verifyMustExists(okbutton,"OK button");
		click(okbutton,"Click on OK button");
		String TaskIcon = "@xpath=//i[@class='c-red glyphicon glyphicon-time']";
		verifyMustExists(TaskIcon,"Task Icon in red");
		click(TaskIcon,"Click on task Icon");
		verifyMustExists(TaskTile,"Task Title");
		verifyMustExists(TaskType,"Task Type");
		verifyMustExists(TaskStatus,"Task Status");
		verifyMustExists(okbutton,"OK button");
		click(okbutton,"Click on OK button");
		
		return EditName;
		}

	public void step3(String sheetName)
	{
		sleep(2000);
		verifyMustExists(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		sleep(2000);
		click(suppliedBordereauSheetMarchOption,"Select March Option");
		sleep(2000);
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+sheetName+"')]")).click();
	}
	public void step_3(String sheetName)
	{
		//sleep(2000);
		verifyMustExists(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		//sleep(2000);
		click(suppliedBordereauSheetborddataOption,"Select bord data Option");
		sleep(2000);
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+sheetName+"')]")).click();
	}

	public void step4()
	{
		//webDriver.navigate().refresh();
		if(isVisible(RiskSpecifiedDD) == true)
		{
			verifyMustExists(RiskSpecifiedDD,"Risk Specified Dropdown");
			click(RiskSpecifiedDD,"Risk Specified Dropdown");
			//sleep(1000);
			click(RiskOption,"Risk Option");
			sleep(1000);
		}
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		sleep(2000);
		click(yearofAccountOption,"Select Year of Account ");
		//sleep(1000);
		javaScriptclick(contractOrderRadioBtn,"Select Contract Order supplied in the Bordereau? Radio Button");
		
		verifyMustExists(RiskOrderNo,"Risk order No");
		click(RiskOrderNo,"Risk order No");
	
		/*verifyMustExists(PolicydDD,"YOA associated with each Risk specified? Dropdown");
		click(PolicydDD,"YOA associated with each Risk specified? Dropdown");
		click(PolicyOption,"Select Year of Account ");*/
		nextStapeClick();
	}
	
	public void step4RiskAndP()
	{
		//webDriver.navigate().refresh();
		if(isVisible(RiskSpecifiedDD) == true)
		{
			verifyMustExists(RiskSpecifiedDD,"Risk Specified Dropdown");
			click(RiskSpecifiedDD,"Risk Specified Dropdown");
			//sleep(1000);
			click(RiskOption,"Risk Option");
			//sleep(1000);
		}
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
	//	click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		//sleep(2000);
	//	click(yearofAccountOption,"Select Year of Account ");
		//sleep(1000);
		javaScriptclick(contractOrderRadioBtn,"Select Contract Order supplied in the Bordereau? Radio Button");
		
		
		/*verifyMustExists(PolicydDD,"YOA associated with each Risk specified? Dropdown");
		click(PolicydDD,"YOA associated with each Risk specified? Dropdown");
		click(PolicyOption,"Select Year of Account ");*/
		nextStapeClick();
	}
	public void step_4()
	{
	
		SelectDropDownValue(RiskinBordereauDD, RiskinBordereauDDoption);
		if(isVisible(RiskSpecifiedDD) == true)
		{
			verifyMustExists(RiskSpecifiedDD,"Risk Specified Dropdown");
			click(RiskSpecifiedDD,"Risk Specified Dropdown");
			//sleep(1000);
			click(RiskOption,"Risk Option");
			//sleep(1000);
		}
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		//sleep(2000);
		click(yearofAccountOption1,"Select Year of Account ");
		
		
		nextStapeClick();
	}

	public void step4Claim()
	{
		
		verifyMustExists(OriginalCurrencyDD,"Bordereau associated Dropdown");
		click(OriginalCurrencyDD,"Bordereau associated Dropdown");
		click(OriginalCurrencyval,"Select Automation Schema Option");
		//SelectDropDownValue(Dropdown3,DDvalue3);
		//SelectDropDownValue(Dropdown4,DDValue4);		
		nextStapeClick();
	}
	
	public void step4Claim_3648()
	{
		
		refreshPage();
		sleep(3000);
		
		verifyMustExists(OriginalCurrencyDD,"Bordereau associated Dropdown");
		click(OriginalCurrencyDD,"Bordereau associated Dropdown");
		click(OriginalCurrencyval,"Select Automation Schema Option");
		
		SelectDropDownValue(ROEDD, ROEPaidThisMonthOption);

	//	SelectDropDownValue(Dropdown3,DDvalue3);
		
		
			
		nextStapeClick();
	}
	
	public void step5()
	{
		nextStapeClick();
	}
	
	public void step5_DV()
	{
		SelectDropDownValue(StartDateDD, StartDateDV);
		sleep(3000);
		SelectDropDownValue(ExpiryDateDD, ExpiryDateDV);
		
		nextStapeClick();
	}
	
	public void step5_TC3603()
	{
		refreshPage();
		sleep(3000);
		verifyMustExists(RiskEffectiveDateDD, "Risk Effective date drop down");
		click(RiskEffectiveDateDD,"Risk Effective date drop down ");
		verifyMustExists(RiskEffectiveDateValue, "Risk Effective date drop value");
		click(RiskEffectiveDateValue,"Risk Effective date drop down value");
		nextStapeClick();
	}
	
	public void step_5()
	{
		verifyMustExists(StartriskperiodDD,"Risk in Borderea Dropdown");
		click(StartriskperiodDD,"Risk in Borderea Dropdown");
		click(StartriskperiodDDoption,"Risk in Borderea Option");
		
		verifyMustExists(EndriskperiodDD,"Risk in Borderea Dropdown");
		click(EndriskperiodDD,"Risk in Borderea Dropdown");
		click(EndriskperiodOption,"Risk in Borderea Option");
		
		verifyMustExists(InsuredNameDD,"Risk in Borderea Dropdown");
		click(InsuredNameDD,"Risk in Borderea Dropdown");
		click(InsuredNameOption,"Risk in Borderea Option");
		sleep(1000);
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		
	}

	String RenExistriskVal = "@xpath=.//li[text()='Not supplied']";
	String RenExistriskDD = "@xpath=//input[@ng-model='BFRiskDetails.NewRenwalIndicator']//preceding::span[2]";

	public void step5_1()
	{
		sleep(1000);
		//SelectDropDownValue(RenExistriskDD, RenExistriskVal);
		sleep(1000);
		nextStapeClick();
	}

	public void step6()
	{
		waitForElementToAppear(riskAddressSection, 8);
		verifyMustExists(riskAddressSection,"Available Risk Address");
		click(riskAddressSection,"Available Risk Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}
	
	public void step6_DV()
	{
		refreshPage();
		SelectDropDownValue(CountryNotSelectDD, CountryNotSelectDV);
		sleep(2000);
		SelectDropDownValue(DefaultCountryDD, DefaultCountryDV);
		
		waitForElementToAppear(riskAddressSection, 8);
		verifyMustExists(riskAddressSection,"Available Risk Address");
		click(riskAddressSection,"Available Risk Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}

	public void step6_1()
	{
		javaScriptclick(grossPremiumplusTax,"Gross Premium plus Tax?");
		nextStapeClick();
	}

	public void step6Claim()
	{
		waitForElementToAppear(LossCounty, 8);
		verifyMustExists(LossCounty,"Loss country");
		click(LossCounty,"Loss County");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}
	public void step7_DV()
	{
		
		SelectDropDownValue(RiskAndPremiumCDD, RiskAndPremiumCDV);
		sleep(2000);
		SelectDropDownValue(RiskAndPremiumCDD2, RiskAndPremiumCDV2);
		
		sleep(5000);
		nextStapeClick();
	}
	
	public void step7()
	{
		
		sleep(5000);
		nextStapeClick();
	}

	public void step7_1()
	{
		
		/*sleep(2000);
		waitForElementToAppear(totalInsurableValueDD, 8);
		verifyMustExists(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		click(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		//waitForElementToAppear(TIVOption,2);
		//click(TIVOption,"Select TIV option");
*/		nextStapeClick();
	}

	public void step7Claim()
	{
		waitForElementToAppear(RiskAddress, 8);
		verifyMustExists(RiskAddress,"Loss Address");
		click(RiskAddress,"Loss Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}
	public void step7_2()
	{
		sleep(2000);
		//SelectDropDownValue(CurrencyDD, ContractLookupValue);
		
		waitForElementToAppear(totalInsurableValueDD, 8);
		verifyMustExists(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		click(totalInsurableValueDD,"Total Insurable Value? Dropdown");
		//waitForElementToAppear(TIVOption,2);
		//click(TIVOption,"Select TIV option");
		nextStapeClick();
	}

	public void step8LastSheet()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		//sleep(2000);
		waitForElementToAppear(coverholderCommissionDD, 8);
		verifyMustExists(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		click(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		//sleep(2000);
		click(commissionAmountOption,"Select Amount option");
		verifyMustExists(brokerageDD,"Brokerage amount, percentage, or both? Dropdown");
		click(brokerageDD,"Brokerage amount, percentage, or both?  Dropdown");
		//sleep(2000);
		click(brokerageAmountOption,"Select Amount option");
		javaScriptclick(producingBrokerageRadioBtn,"Select Producing Brokerage Radio Button");
		javaScriptclick(taxRadioBtn,"Select taxRadioBtn Radio Button");
		verifyMustExists(taxDD,"Tax charged to the insured, either as an amount, percentage, or both? Dropdown");
		click(taxDD,"Tax charged to the insured, either as an amount, percentage, or both? Dropdown");
		//sleep(2000);
		click(taxAmountOption,"Select Amount option");
		nextStapeClick();
	}

	public void step8Claim()
	{
		waitForElementToAppear(InsuredAddress, 8);
		verifyMustExists(InsuredAddress,"Insured Address");
		click(InsuredAddress,"Insured Address");
		verifyMustExists(arrowRightBtn,"Right Arrow");
		click(arrowRightBtn,"Right Arrow");
		nextStapeClick();
	}
	public void step9Claim()
	{
		nextStapeClick();
	}
	public void step10Claim()
	{
		verifyMustExists(paragraph3,"Insured Address");
		verifyMustExists(paragraph4,"Insured Address");
		nextStapeClick();
	}
	public void step11Claim()
	{
		verifyMustExists(paragraph5,"Insured Address");
		verifyMustExists(paragraph6,"Insured Address");
		nextStapeClick();
	}

	public void step8()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		//sleep(2000);
		waitForElementToAppear(coverholderCommissionDD, 8);
		verifyMustExists(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		click(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		waitForElementToAppear(commissionAmountOption,2);
		click(commissionAmountOption,"Select Amount option");
		verifyMustExists(brokerageDD,"Brokerage amount, percentage, or both? Dropdown");
		click(brokerageDD,"Brokerage amount, percentage, or both?  Dropdown");
		waitForElementToAppear(brokerageAmountOption,2);
		click(brokerageAmountOption,"Select Amount option");
		javaScriptclick(OtherFeesNoOption,"Click on other fees no option.");
		/*if(isVisible(OtherFeesTxt)==true){
			Report.LogInfo("TextBoxCheck", "Other Fees No option is not selected", "FAIL");
			javaScriptclick(OtherFeesNoOption,"Click on other fees no option.");
		}else{
			Report.LogInfo("TextBoxCheck", "Other Fees No option is selected", "PASS");
		}	*/	
		nextStapeClick();
	}

	public void step9()
	{
		//findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		//findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
	}
	public void step10()
	{
		//findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		//findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
	}

	public void step11()
	{
		refreshPage();
		sleep(4000);
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
		sleep(5000);
	}

	public void step_6_RP()
	{
		
		SelectDropDownValue(NewRenewalDD, NewRenewalValue);
		SelectDropDownValue(PremiumTransactionTypeDD, PremiumTransactionTypeValue);
		SelectDropDownValue(TransactionTypeDD, TransactionTypeValue);
		
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
		//sleep(5000);
	}
	public void step_6_Risk()
	{
		
		SelectDropDownValue(NewRenewalDD, NewRenewalValue);
		SelectDropDownValue(TransactionTypeDD, TransactionTypeValue);
		
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
		//sleep(5000);
	}
	
	
	
	
	public void step12()
	{
		//findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		//findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
	}
	
	public void step12_Claim()
	{
		SelectDropDownValue(FeesDD, Fees_TotalIncurred_NotSupplied);
		SelectDropDownValue(IndemnityDD, Indemnity_TotalIncurred_NotSupplied);
		SelectDropDownValue(TotalResrveDD, Total_Reserve_NotSupplied);
		SelectDropDownValue(TotalPaidDD, Total_Paid_NotSupplied);
		SelectDropDownValue(TotalIncurredDD, Total_Incurred_NotSupplied);
		nextStapeClick();
	}
	
	public void step13_Claim()
	{
		sleep(1000);

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}
		String DenialYNDrag = "@xpath=//button[contains(.,'Denial')]";
		String DenialYNDrop = "@xpath=//td[contains(.,'Denial (Y/N)')]//preceding-sibling::td/div/div";
		dragDropElement(DenialYNDrag,DenialYNDrop);
		nextStapeClick();
	}
	
	
	public void step13()
	{
		nextStapeClick();
	}
	
	
	
	

	/*public void step12()
	{
		waitForElementToAppear(SaveBtn, 10);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save Button");
		//sleep(15000);
	}*/

	public void nextStapeClick()
	{	

		waitForElementToAppear(nextStepBtn,5);
		verifyMustExists(nextStepBtn,"Next Step Button");
		javaScriptclick(nextStepBtn,"Next Step Button");
		sleep(3000);
		waitForElementToAppear(Steps,20);
	}

	public void nextStapeClick1() throws InterruptedException
	{	
		verifyMustExists(nextStepBtn,"Next Step Button");
		//javaScriptclick(nextStepBtn,"Next Step Button");
		click(nextStepBtn,"Next button");
		Thread.sleep(5000);
		if(isVisible(Spinner)==true){
			Thread.sleep(2000);
			webDriver.findElement(By.xpath("//*[@ng-click='cancel()']")).click();
			//click(CancelBtn,"Cancel button");
			Thread.sleep(2000);
			click(GotoHome,"Go to home");			
		}
	}

	public void editTextProcess(String Questionnaire, String Year) throws AWTException
	{		
		//Filter
		waitForElementToAppear(QuestionnaireNameFilter,5);
		javaScriptclick(QuestionnaireNameFilter, "Questionnaire Filter");
		sleep(2000);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,Questionnaire,"Search textbox");
		sleep(2000);
		webDriver.findElement(By.xpath("//ul//li[contains(.,'"+Questionnaire+"')][1]")).click();
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		//sleep(5000);
		nextStapeClick();
		//step3(TheOnlySheetSpecificTextOption);
		waitForElementToAppear(sheetsContainTxt,3);
		verifyMustExists(sheetsContainTxt,"Questionnaire Name Textbox");
		sendKeys(sheetsContainTxt, Year, "Year");
		nextStapeClick();
	}

	public void filterBordereauQuestionnaire(String QueSearch, String SelectQuestionnaire)
	{
		int i=0;
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(QuestionnaireNameFilter,5);
			javaScriptclick(QuestionnaireNameFilter, "Questionnaire Filter");
			sleep(2000);
			if(isVisible(SearchTxt))
			{
				verifyMustExists(SearchTxt,"Search Filter Textbox");	
				Report.LogInfo("Edit Adde Questionnaire Name", QueSearch, "PASS");
				sendKeys(SearchTxt,QueSearch,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(SelectQuestionnaire) && i<5);
		sleep(1500);
		javaScriptclick(SelectQuestionnaire, "Searched Record Checkbox");
		Report.LogInfo("Questionnaire Selected","Questionnaire Selected", "PASS");
		verifyMustExists(FilterBtn,"Filter Button");	
		javaScriptclick(FilterBtn,"Filter Button");
	}

	public void editTextProcess() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToAppear(EditBtn, 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		waitForElementToAppear(appliedToIdentifyDD, 3);
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+FirstSheetOption+"')]")).click();

		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
	}

	public void filterBordereauQuestionnaire(String QueSearch)
	{
		waitForElementToPresent(By.xpath(QuestionnaireNameFilter), 3);
		verifyMustExists(QuestionnaireNameFilter,"Questionnaire Name Filter");
		click(QuestionnaireNameFilter,"Questionnaire Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 3);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,QueSearch,"Search textbox");
		waitForElementToPresent(By.xpath(SelectQuestionnaire), 3);
		verifyMustExists(SelectQuestionnaire,"Questionnaire");
		click(SelectQuestionnaire,"Questionnaire");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}

	  public void filterBordereauQuestionnaire1(String QueSearch)
	    {
	        String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QueSearch+"')][1]";
	 
	        waitForElementToPresent(By.xpath(QuestionnaireNameFilter), 5);
	        verifyMustExists(QuestionnaireNameFilter,"Questionnaire Name Filter");
	        sleep(2000);
	        javaScriptclick(QuestionnaireNameFilter,"Questionnaire Name Filter");
	        waitForElementToPresent(By.xpath(SearchTxt), 3);
	        verifyMustExists(SearchTxt,"Search textbox");
	        sendKeys(SearchTxt,QueSearch,"Search textbox");
	        waitForElementToPresent(By.xpath(SelectQuestionnaire), 3);
	        verifyMustExists(SelectQuestionnaire,"Questionnaire");
	        click(SelectQuestionnaire,"Questionnaire");
	        verifyMustExists(FilterBtn,"Filter button");
	        click(FilterBtn,"Filter button");
	    }

	public void filterBordereauQuestionnaire2(String QueSearch)
	{
		waitForElementToPresent(By.xpath(QuestionnaireNameFilter), 3);
		verifyMustExists(QuestionnaireNameFilter,"Questionnaire Name Filter");
		javaScriptclick(QuestionnaireNameFilter,"Questionnaire Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 5);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,QueSearch,"Search textbox");
		waitForElementToPresent(By.xpath(SelectQuestionnaire2), 4);
		verifyMustExists(SelectQuestionnaire2,"Questionnaire");
		click(SelectQuestionnaire2,"Questionnaire");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}

	public void editTextProcess1() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		waitForElementToAppear(appliedToIdentifyDD,2);
		click(appliedToIdentifyDD,"All sheet drop");
		sleep(1000);
		verifyMustExists(FirstSheetVal,"First sheet val");
		click(FirstSheetVal,"First sheet val");
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
	}

	public void editTextProcess_1() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		
		
		
	}

	public void editTextProcess2() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyVersion2).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}		
		waitForElementToPresent(By.xpath(EditBtn), 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		waitForElementToAppear(appliedToIdentifyDD,2);
		click(appliedToIdentifyDD,"All sheet drop");
		sleep(1000);
		verifyMustExists(FirstSheetVal,"First sheet val");
		click(FirstSheetVal,"First sheet val");
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
	}

	//3460	Edit Bordereaux Questionaire 
	public void editBordereauFormatDubForTc4058() throws InterruptedException, AWTException
	{
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireName+"')][1]";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(QuestionnaireName, SelectQuestionnaire);
		editTextProcess1();
		filterBordereauQuestionnaire(QuestionnaireName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion1,5);
		if(getTextFrom(VerifyVersion1).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	public void editBordereauFormatDubForTc4058_1() throws InterruptedException, AWTException
	{
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QuestionnaireName1+"')][1]";

		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire(QuestionnaireName1, SelectQuestionnaire);
		editTextProcess2();
		filterBordereauQuestionnaire(QuestionnaireName1, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyVersion2,5);
		if(getTextFrom(VerifyVersion2).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}

	public void deactivateQuestionnaire()
	{
		//filterBordereauQuestionnaire(QuestionnaireName1, SelectQuestionnaire);
		String DectiveBtnQue = "@xpath=.//*[@ng-click='ActiveDeactive(dataItem,false)']";
		//String ActiveBtnQue = "@xpath=..//*[@ng-click='ActiveDeactive(dataItem,true)']";
		if(isVisible(DectiveBtnQue)==true){
			Report.LogInfo("Deactivate", "Bordereau Questionnaire is Deactivate", "PASS");
		}else{
			Report.LogInfo("Deactivate", "Bordereau Questionnaire is not Deactivate", "FAIL");

		}
	}

	public void firstSheetProcess5(String SchemaName,String QuestionnaireName) throws AWTException, ClientProtocolException, IOException
	{

		//String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S18423320180611.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":17710,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S18423320180611.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2017_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		
		String Filename = "S47193020180929.xlsx";
		int size = 17710;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step11();
		step6();
		step7_1();
		step8();
		step9();
		step10();
		//step11();
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";

		String NoBuildingsDrag = "@xpath=//button[contains(.,'Buildings')]";
		String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);
		step12();
		BFormatId= ReturnFormatID();
		step13_Risk();
	}

	public void step8_1()
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		//sleep(2000);
		waitForElementToAppear(coverholderCommissionDD, 8);
		verifyMustExists(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		click(coverholderCommissionDD,"Coverholder Commission amount, percentage, or both Dropdown");
		waitForElementToAppear(commissionAmountOption,2);
		javaScriptclick(producingBrokerageRadioBtn,"Select Producing Brokerage Radio Button");
		click(commissionAmountOption,"Select Amount option");
		verifyMustExists(brokerageDD,"Brokerage amount, percentage, or both? Dropdown");
		click(brokerageDD,"Brokerage amount, percentage, or both?  Dropdown");
		waitForElementToAppear(brokerageAmountOption,2);
		click(brokerageAmountOption,"Select Amount option");		
		nextStapeClick();
	}

	public void gotostep11()
	{
		waitForElementToAppear(step11link,5);
		verifyMustExists(step11link,"Step 11 link");
		javaScriptclick(step11link,"Step 11 link");
		sleep(2000);
		waitForElementToAppear(nextStepBtn,5);
	}

	public void sheetProcessingriskAndPrimium(String SchemaName1,String QueName) throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		allSheetProcess(SchemaName1,QueName);
	}

	public void allSheetProcess(String SchemaName,String QuestionnaireName) throws AWTException, ClientProtocolException, IOException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S66789520180501.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":17660,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S66789520180501.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allsheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017 - Aprroved_TC_5185_first.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(allsheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S39047520181004.xlsx";
		int size = 17660;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
		
		
		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(riskAndPremiumOption,"Select Risk and Premium Option");
		click(riskAndPremiumOption,"Select Risk and Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3one(FirstSheetOption);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4RiskAndP();
		step5_1();
		step11();// Step 6
		step6();
		step7_1();
		step8();
		step9();
		step10();
		nextStapeClick();//12
		nextStapeClick();//13
		
	//step11();//14

		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}
		sleep(1000);
		step12one();//14
		BFormatId= ReturnFormatID();
		step13_Risk();//15
	}

	public void step3one(String sheetName)
	{
		verifyMustExists(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetBordDataOption,"Select bord data Option");
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+sheetName+"')]")).click();
	}

	public void step11one()
	{
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(limitsAndOthersChk).sendKeys(Keys.SPACE);
		nextStapeClick();
	}

	public void step12one()
	{
		nextStapeClick();
		sleep(2000);
	}
	public void step13_Risk()
	{
		waitForElementToAppear(SaveBtn, 10);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save Button");
		sleep(3000);;
	}
	public void step13_DV()
	{ 
		FilterDefaultFields(RiskOrder, "Filter Risk Order %", RiskOrderDV);
		
		FilterDefaultFields(RiskInceptionDate, "Filter Risk Inception Date", RiskInceptionDateDV);
		
		FilterDefaultFields(RiskExpiry, "Filter Risk Expiry", RiskExpiryDV);
		
		FilterDefaultFields(RiskCountry, "Filter Risk Country", RiskCountryDV);
		
		FilterDefaultFields(RiskCurrency, "Filter Risk Currency", RiskCurrencyDV);
		
		FilterDefaultFields(PremiumCurrency, "Filter Premium Currency", PremiumCurrencyDV);
		
		
		String cancel = "@xpath=//button[text()='cancel']";
		waitForElementToAppear(cancel, 10);
		verifyMustExists(cancel,"Save Button");
		click(cancel,"Save Button");
	}
	public void FilterDefaultFields(String Locator, String Discription, String DVLocator) {
		waitForElementToAppear(TideFieldFilter, 10);
		verifyMustExists(TideFieldFilter,"Tide Fikter");
		click(TideFieldFilter,"Tide Fikter");
		
		verifyMustExists(Locator,Discription);
		click(Locator,Discription);
		
		verifyMustExists(FilterBtn,"Tide Fikter");
		click(FilterBtn,"Tide Fikter");
		sleep(2000);
		verifyMustExists(DVLocator,"Verify it is green");
		refreshPage();
		
		
	}
	
	public void ReviewStep_Luna()
	{
		waitForElementToAppear(SaveAndProcessBtn, 10);
		verifyMustExists(SaveAndProcessBtn,"Save And Process Button");
		click(SaveAndProcessBtn,"Save And Process Button");
		sleep(3000);;
	}
	
	public void step13RiskAndPremium()
	{
		nextStapeClick();
		sleep(2000);
	}
	
	public void step14()
	{
		waitForElementToAppear(SaveBtn, 10);
		verifyMustExists(SaveBtn,"Save Button");
		click(SaveBtn,"Save Button");
		sleep(3000);
	}

		public void EditRiskAndPremium()
		{
		verifyMustExists(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		click(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		sleep(1000);
		verifyMustExists(DataRef.EditLink,"Edit Risk & Premium Field");
		click(DataRef.EditLink,"Edit Risk & Premium Field");
		sleep(2000);
		scrollUp();
		DataRef.applyFieldNameFilter("Insured Name");
		verifyMustExists(EditInsuredName,"Verify Edit Insured Name Field");
		click(EditInsuredName,"Edit Insured Name Field");
		sleep(1000);
		waitForElementToAppear(DataRef.SourceDataStandardReference,5);
		verifyMustExists(DataRef.SourceDataStandardReference,"Source Data Standard Reference");
		sendKeys(DataRef.SourceDataStandardReference, DataRef.SourceDataStndrdRefValue, "Enter Source Data Standard Reference Value as CR0035");

		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(1000);
		if(isVisible(DataRef.SaveChangesPopupBtn) == true) {
		verifyMustExists(DataRef.SaveChangesPopupBtn,"Verify Save Changes Button Pop Up");
		javaScriptclick(DataRef.SaveChangesPopupBtn,"Click Save Changes Pop up button");
		Report.LogInfo("ValidateSaveChangesPopupBtn", "Verify Save changes Pop button is clicked Successfully Second time ", "PASS");
}else {
	Report.LogInfo("ValidateSaveChangesPopupBtn", "Verify Save changes Pop button is Not clicked Successfully Second tine ", "FAIL");
}
		//waitForElementToAppear(DataRef.WarningMessage,5);
		//verifyMustExists(DataRef.WarningMessage,"WarningMessage");
		// waitForElementToAppear(ValueIfNullDropDwn,5);*/
		//verifyMustExists(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		//click(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		sleep(2000);
	}
	public void RemoveRiskAndPremiumData()
	{ 
		verifyMustExists(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		click(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		sleep(1000);
		verifyMustExists(DataRef.EditLink,"Edit Risk & Premium Field");
		click(DataRef.EditLink,"Edit Risk & Premium Field");
		sleep(2000);
		scrollUp();
		DataRef.applyFieldNameFilter("Insured Name");
		verifyMustExists(EditInsuredName,"Verify Edit Insured Name Field");
		click(EditInsuredName,"Edit Insured Name Field");
		sleep(1000);
		waitForElementToAppear(DataRef.SourceDataStandardReference,5);
		verifyMustExists(DataRef.SourceDataStandardReference,"Clear Standard Reference Value");
		clearTextBox(DataRef.SourceDataStandardReference);
		sleep(1000);
		//sendKeys(DataRef.SourceDataStandardReference, BoredereauName, "Enter Source Data Standard Reference");
		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(1000);
		//waitForElementToAppear(DataRef.SaveChangesPopupBtn, 5);
		if(isVisible(DataRef.SaveChangesPopupBtn) == true)
				{
				verifyMustExists(DataRef.SaveChangesPopupBtn,"Verify Save Changes Button Pop Up");
				javaScriptclick(DataRef.SaveChangesPopupBtn,"Click Save Changes Pop up button");
				Report.LogInfo("ValidateSaveChangesPopupBtn", "Verify Save changes Pop button is clicked Successfully ", "PASS");
		}else {
			Report.LogInfo("ValidateSaveChangesPopupBtn", "Verify Save changes Pop button is Not clicked Successfully ", "FAIL");
		}
		
		//waitForElementToAppear(DataRef.WarningMessage,5);
		//verifyMustExists(DataRef.WarningMessage,"WarningMessage");
		// waitForElementToAppear(ValueIfNullDropDwn,5);*/
		/*verifyMustExists(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		Savechanges = getTextFrom(DataRef.AddFieldsPopupSaveChangesButton);
		Report.LogInfo("AddFieldsPopupSaveChangesButton", Savechanges, "PASS");
		click(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");*/
		sleep(2000);
	}
	public void filterBordereauField(String BordereauSearch)
	{
		String SelectFieldName = "@xpath=//input[@value='"+BordereauSearch+"']";

		waitForElementToPresent(By.xpath(BorderueFieldNameFilter), 3);
		verifyMustExists(BorderueFieldNameFilter,"Borderue Field Name Filter");
		click(BorderueFieldNameFilter,"Borderue Field Name Filter");
		waitForElementToPresent(By.xpath(SearchTxt), 3);
		verifyMustExists(SearchTxt,"Search textbox");
		sendKeys(SearchTxt,BordereauSearch,"Search textbox");
		waitForElementToPresent(By.xpath(SelectFieldName), 3);
		verifyMustExists(SelectFieldName,"Questionnaire");
		click(SelectFieldName,"Questionnaire");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
	}
	public void ChangeRiskAndPremium()
	{ 
		verifyMustExists(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		click(DataRef.EditKebabThreeDotsLink,"Edit Risk & Premium Field");
		sleep(1000);
		verifyMustExists(DataRef.EditLink,"Edit Risk & Premium Field");
		click(DataRef.EditLink,"Edit Risk & Premium Field");
		sleep(2000);
		scrollUp();
		DataRef.applyFieldNameFilter("Risk Issuance Date");
		verifyMustExists(EditRiskIssuranceDate,"Verify Edit Risk Issurance Date Field");
		click(EditRiskIssuranceDate,"Edit Risk Issurance Date Field");
		sleep(1000);
		waitForElementToAppear(MandatoryYes,5);
		verifyMustExists(MandatoryYes,"Mandatory Yes");
		click(MandatoryYes,"Mandatory Yes");
		sleep(1000);			
		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(4000);
		DataRef.applyFieldNameFilter("Building Year Built");
		verifyMustExists(EditBuildingYearBuilt,"Verify Edit Building Year Built Field");
		click(EditBuildingYearBuilt,"Edit Building Year Built Field");
		sleep(1000);
		waitForElementToAppear(MandatoryYes,5);
		verifyMustExists(MandatoryYes,"Mandatory Yes");
		click(MandatoryYes,"Mandatory Yes");
		sleep(1000);			
		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(2000);
		DataRef.applyFieldNameFilter("Number of Stories");
		verifyMustExists(EditNumberofStories,"Verify Edit Number of Stories");
		click(EditNumberofStories,"Edit Risk Number of Stories Field");
		sleep(1000);
		waitForElementToAppear(MandatoryYes,5);
		verifyMustExists(MandatoryYes,"Mandatory Yes");
		click(MandatoryYes,"Mandatory Yes");
		sleep(1000);			
		verifyMustExists(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		click(DataRef.AddFieldsPopupSaveButton,"AddFieldsPopupSaveButton");
		sleep(2000);
		//waitForElementToAppear(DataRef.WarningMessage,5);
		//verifyMustExists(DataRef.WarningMessage,"WarningMessage");
		// waitForElementToAppear(ValueIfNullDropDwn,5);*/
		verifyMustExists(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		click(DataRef.AddFieldsPopupSaveChangesButton,"AddFieldsPopupSaveChangesButton");
		sleep(2000);
	}
	
	public void firstSheetProcess11(String SchemaName) throws AWTException, ClientProtocolException, IOException
	{
		String QuestionnaireName = "SP - All Sheet(s)"+getCurrentDateTimeMS();

		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70986620180507.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":17851,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S70986620180507.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January_2018_First_Sheet.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetPath);
		//uploadFileQue(requestURL, excelFile, payload, URLname);
		String Filename = "S32856220181006.xlsx";
		int size = 17851;		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);

		String QuestioneriesValue ="@xpath=//li[contains(.,'"+SchemaName+"')]";
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		//sleep(2000);
		verifyMustExists(riskOption,"Select Risk Option");
		click(riskOption,"Select Risk Option");
		//sleep(2000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		//sleep(2000);
		verifyMustExists(QuestioneriesValue,"Questioneries Value");
		click(QuestioneriesValue,"Questioneries Value");
		//sleep(2000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,QuestionnaireName,"Questionnaire Name Textbox.");
		nextStapeClick();
		//System.out.println(QuestionnaireName1stSheet);
		step3(FirstSheetOption);
		//sleep(2000);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");
		nextStapeClick();
		step4();
		step5();
		step11();
		step6();
		step7_1();
		step8();
		step9();
		step10();	
		sleep(1000);



		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}
		String ContentsDrag = "@xpath=//button[text()='Contents']";
		String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";
	
		String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String OccupancyCodeDrag = "@xpath=//button[text()='Occupancy Code']";
		String OccupancyCodeDrop = "@xpath=//td[contains(.,'Location Occupancy Code')]//preceding-sibling::td/div/div";
		String OccupancyDescriptionDrag = "@xpath=//button[text()='Occupancy Description']";
		String OccupancyDescriptionDrop = "@xpath=//td[contains(.,'Location Occupancy Description')]//preceding-sibling::td/div/div";
		String OccupancySchemeDrag = "@xpath=//button[text()='Occupancy Scheme']";
		String OccupancySchemeDrop = "@xpath=//td[contains(.,'Location Occupancy Scheme')]//preceding-sibling::td/div/div";
		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";
		String NoBuildingsDrag = "@xpath=//button[contains(.,'Buildings')]";
		String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
		String ExpiryDrag = "@xpath=//button[text()='Expiry']";
		String ExpiryDrop = "@xpath=//td[contains(.,'Cancellation Date')]//preceding-sibling::td/div[1]/div";
	
		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);
		dragDropElement(OccupancyCodeDrag,OccupancyCodeDrop);
		dragDropElement(OccupancyDescriptionDrag,OccupancyDescriptionDrop);
		dragDropElement(OccupancySchemeDrag,OccupancySchemeDrop);
		sleep(1000);

		step12();
		verifyExists(VerifyFirstRow,"Verify First Row");
		String FirstRow = getTextFrom(VerifyFirstRow);
		String SecondRow = getTextFrom(VerifySecondRow);
		String ThirdRow = getTextFrom(VerifyThirdRow);
	//	String FourthRow = getTextFrom(VerifyFourthRow);
		if(FirstRow.equalsIgnoreCase("C - Contents Value")){
			Report.LogInfo("FirstRowValidation", "Contents Value is Display is Red", "PASS");
		}
		else{
			Report.LogInfo("SaveandReprocessValidation", "Contents Valuee is not Display is Red", "FAIL");
		}			
		verifyExists(VerifySecondRow,"Verify Second Row");
		if(SecondRow.equalsIgnoreCase("Cancellation Date")){
			Report.LogInfo("FirstRowValidation", "Cancellation Date is Display is Red", "PASS");
		}
		else{
			Report.LogInfo("SaveandReprocessValidation", "Cancellation Date is not Display is Red", "FAIL");
		}
		
		verifyExists(VerifyFourthRow,"Verify Fourth Row");
		if(ThirdRow.equalsIgnoreCase("Location Sprinklers (Y/N)")){
			Report.LogInfo("FirstRowValidation", "Location Sprinklers (Y/N) is Display is Red", "PASS");
		}
		else{
			Report.LogInfo("SaveandReprocessValidation", "Location Sprinklers (Y/N) is not Display is Red", "FAIL");
		}
		verifyMustExists(Step11Btn,"Step 11");
		click(Step11Btn,"Step 11");
		
		/*List<WebElement> RemoveIcon1 = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
		for(int i=1; i<=RemoveIcon1.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(1000);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(200);
			}
		}*/
		
		dragDropElement(ContentsDrag,ContentsDrop);
		dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
		dragDropElement(SprinklersDrag,SprinklersDrop);
		dragDropElement(ExpiryDrag,ExpiryDrop);
		step12();
		sleep(2000);
		BFormatId= ReturnFormatID();
		//System.out.println(BFormatId);
		step13_Risk();
		QuestionnaireName_TC5141 = QuestionnaireName;
	}

	public void HeaderrowselectionQuestionnaire_TC5524() throws Exception
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addQuestionnaireHR();
	}
	public String addsettlementQue() throws Exception{
		
		String questionnairename = "Financial Settlement calculation"+getCurrentDateTimeMS();
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21985720180607.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18728,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S21985720180607.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		//sleep(4000);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addPremiumQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Settlmentfincial_TC_6168.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(addPremiumQuestionairePath);
		uploadFileQue(requestURL, excelFile, payload, URLname);
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "http")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		
		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(premiumOption,"Select Premium Option");
		click(premiumOption,"Select Premium Option");
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		click(premiumSchemaOption,"Select Automation Schema Option");
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt, questionnairename,"Questionnaire Name Textbox.");
		nextStapeClick();
		step3(AllSheetsOption);
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"2", "Header Row Count Textbox.");
		nextStapeClick();
		//nextStapeClick();
		step4();
		step5();
		step6_1();
		step8();
		premium_settlement_step9();
		//premium_settlement_step9_Yes_1();
		//premium_settlement_step9_Yes_2();
		nextStapeClick();
		/*findWebElement(BQPage.premiumsChk).sendKeys(Keys.SPACE);
		findWebElement(BQPage.Restatement2).sendKeys(Keys.SPACE);
		
		BQPage.nextStapeClick();*/
		step11();
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}
		step12();
		step13_Risk();
		return formatId;
		
	}
	 public void premium_settlement_step9() {
			
			nextStapeClick();
			
			//waitForElementToAppear(SettlementFirstQYes,10);
			//verifyMustExists(SettlementFirstQYes,"For Approval button");
			//javaScriptclick(SettlementFirstQYes,"For Approval button");
			
		//	SelectDropDownValue1(TideValDrp11,TideValDrp111);
		//	SelectDropDownValue1(TideValDrp12,TideValDrp112);
		//	SelectDropDownValue1(TideValDrp13,TideValDrp113);
				
		
		}
	 public String addsettlementQue1() throws Exception{
			
			String questionnairename = "Financial Settlement calculation"+getCurrentDateTimeMS();
			String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
			//                {"UploadFileVM":{"BordereauxId":null,"BordereauFormatId":null,"FileName":"S29546920180429.xlsx","Filesize":0,"Path":null,"size":169230,"ActiveSheetIndex":0,"HeaderIndex":0,"MultiHeaders":null,"SheetNames":null,"IsPasswordProtected":false},"BordereauFormat":{"UniqueFileName":"S29546920180429.xlsx"}}
			
			//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29546920180429.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":169230,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S29546920180429.xlsx\"}}";
			//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12772920180520.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":170841,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S12772920180520.xlsx\"}}";
			//String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S40328120180522.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18721,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S40328120180522.xlsx\"}}";
			String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21985720180607.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18728,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S21985720180607.xlsx\"}}";
			//String payload = "{"UploadFileVM":{"BordereauxId":null,"BordereauFormatId":null,"FileName":"S90541020180522.xlsx","Filesize":0,"Path":null,"size":18721,"ActiveSheetIndex":0,"HeaderIndex":0,"MultiHeaders":null,"SheetNames":null,"IsPasswordProtected":false},"BordereauFormat":{"UniqueFileName":"S90541020180522.xlsx"}}";
			String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
			//sleep(2000);
			step1();
			//sleep(4000);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				addPremiumQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Settlmentfincial_TC_6168.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(addPremiumQuestionairePath);
			uploadFileQue(requestURL, excelFile, payload, URLname);
			String formatId = addNewBordereauFormat(payload, URLname);
			String URL = Configuration.url.replace("https", "http")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
			openurl(URL);
			
			verifyMustExists(typeOfBordereauDD,"Bordereau Type");
			click(typeOfBordereauDD,"Bordereau Type Dropdown");
			verifyMustExists(premiumOption,"Select Premium Option");
			click(premiumOption,"Select Premium Option");
			verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
			click(businessClassDD,"Bordereau associated Dropdown");
			click(premiumSchemaOption,"Select Automation Schema Option");
			verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
			sendKeys(questionnaireNameTxt, questionnairename,"Questionnaire Name Textbox.");
			nextStapeClick();
			step3(AllSheetsOption);
			waitForElementToAppear(headerRowCountTxt,2);
			verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
			sendKeys(headerRowCountTxt,"2", "Header Row Count Textbox.");
			nextStapeClick();
			//nextStapeClick();
			step4();
			step5();
			step6_1();
			step8();
			//premium_settlement_step9();
			premium_settlement_step9_Yes_1();
			//premium_settlement_step9_Yes_2();
			nextStapeClick();
			/*findWebElement(BQPage.premiumsChk).sendKeys(Keys.SPACE);
			findWebElement(BQPage.Restatement2).sendKeys(Keys.SPACE);
			
			BQPage.nextStapeClick();*/
			step11();
			List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

			for(int i=1; i<=RemoveIcon.size();i++){
				String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
				sleep(100);
				if(isVisible(row) ==true){
					webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
					sleep(1000);
				}
			}
			step12();
			step13_Risk();
			return formatId;
			
		}
		
	 public String addsettlementQue2() throws Exception{
         
         String questionnairename = "Financial Settlement calculation"+getCurrentDateTimeMS();
         String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
         //                {"UploadFileVM":{"BordereauxId":null,"BordereauFormatId":null,"FileName":"S29546920180429.xlsx","Filesize":0,"Path":null,"size":169230,"ActiveSheetIndex":0,"HeaderIndex":0,"MultiHeaders":null,"SheetNames":null,"IsPasswordProtected":false},"BordereauFormat":{"UniqueFileName":"S29546920180429.xlsx"}}
         
         //String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29546920180429.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":169230,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S29546920180429.xlsx\"}}";
         //String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12772920180520.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":170841,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S12772920180520.xlsx\"}}";
         //String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S40328120180522.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18721,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S40328120180522.xlsx\"}}";
         String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21985720180607.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":18728,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S21985720180607.xlsx\"}}";
         //String payload = "{"UploadFileVM":{"BordereauxId":null,"BordereauFormatId":null,"FileName":"S90541020180522.xlsx","Filesize":0,"Path":null,"size":18721,"ActiveSheetIndex":0,"HeaderIndex":0,"MultiHeaders":null,"SheetNames":null,"IsPasswordProtected":false},"BordereauFormat":{"UniqueFileName":"S90541020180522.xlsx"}}";
         String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
         //sleep(2000);
         step1();
         //sleep(4000);
         try 
         {
                 String fpath = new File(".").getCanonicalPath();
                 addPremiumQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Settlmentfincial_TC_6168.xlsx";
         } 
         catch (IOException e) 
         {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         }
         File excelFile = new File(addPremiumQuestionairePath);
         uploadFileQue(requestURL, excelFile, payload, URLname);
         String formatId = addNewBordereauFormat(payload, URLname);
         String URL = Configuration.url.replace("https", "http")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
         openurl(URL);
         
         verifyMustExists(typeOfBordereauDD,"Bordereau Type");
         click(typeOfBordereauDD,"Bordereau Type Dropdown");
         verifyMustExists(premiumOption,"Select Premium Option");
         click(premiumOption,"Select Premium Option");
         verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
         click(businessClassDD,"Bordereau associated Dropdown");
         click(premiumSchemaOption,"Select Automation Schema Option");
         verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
         sendKeys(questionnaireNameTxt, questionnairename,"Questionnaire Name Textbox.");
         nextStapeClick();
         step3(AllSheetsOption);
         waitForElementToAppear(headerRowCountTxt,2);
         verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
         sendKeys(headerRowCountTxt,"2", "Header Row Count Textbox.");
         nextStapeClick();
         //nextStapeClick();
         step4();
         step5();
         step6_1();
         step8();
         //premium_settlement_step9();
         //premium_settlement_step9_Yes_1();
         premium_settlement_step9_Yes_2();
         nextStapeClick();
         nextStapeClick();
         step11();
         List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

         for(int i=1; i<=RemoveIcon.size();i++){
                 String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
                 sleep(100);
                 if(isVisible(row) ==true){
                         webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
                         sleep(1000);
                 }
         }
         step12();
         step13_Risk();
         return formatId;
         
 }
public void premium_settlement_step9_Yes_1() {
 		
    	
 		waitForElementToAppear(SettlementFirstQYes,5);
 		Report.LogInfo("StepCheck", SettlementFirstQYes, "PASS");
 		verifyOptionalExists(SettlementFirstQYes,"For Approval button");
 		javaScriptclick(SettlementFirstQYes,"For Approval button");
 		
 		/*SelectDropDownValue1(TideValDrp11,TideValDrp111);
 		click(TideValDrp111,"Select CCy");
 		SelectDropDownValue1(TideValDrp12,TideValDrp112);
 		SelectDropDownValue1(TideValDrp13,TideValDrp113);*/
 		nextStapeClick();
 	
 	}
     public void premium_settlement_step9_Yes_2() {
    	 
    	 waitForElementToAppear(SettlementFirstQYes,5);
  		Report.LogInfo("StepCheck", SettlementFirstQYes, "PASS");
  		verifyOptionalExists(SettlementFirstQYes,"For Approval button");
  		javaScriptclick(SettlementFirstQYes,"For Approval button");
  		
  		waitForElementToAppear(SettlementsecondQYes,5);
  		Report.LogInfo("StepCheck", SettlementsecondQYes, "PASS");
  		verifyOptionalExists(SettlementsecondQYes,"For Approval button");
  		javaScriptclick(SettlementsecondQYes,"For Approval button");
  		nextStapeClick();
     }
     
	
	public void Step8_TC1056_1() throws Exception  //select NOt supplied option
	{
		

		waitForElementToAppear(Deduction, 8);
		verifyMustExists(Deduction,"Deduction step number 8");
		click(Deduction,"Deduction step number 8");
		Thread.sleep(2000);
		
		waitForElementToAppear(OtherfeesDescriptionDD, 8);
		verifyMustExists(OtherfeesDescriptionDD,"Other fees description drop down");
		click(OtherfeesDescriptionDD,"Other fees description drop down");
		verifyMustExists(OtherfeesdescriptionNotSuppliedOption,"Not supplied Option");
		waitForElementToAppear(OtherfeesdescriptionNotSuppliedOption,2);
		click(OtherfeesdescriptionNotSuppliedOption,"Select Not supplied option");
		
	}
	public void Step8_TC1056_2() throws Exception // Select Other fees description
	{
		

		waitForElementToAppear(Deduction, 8);
		verifyMustExists(Deduction,"Deduction step number 8");
		click(Deduction,"Deduction step number 8");
		Thread.sleep(2000);
		
		waitForElementToAppear(OtherfeesDescriptionDD, 8);
		verifyMustExists(OtherfeesDescriptionDD,"Other fees description drop down");
		click(OtherfeesDescriptionDD,"Other fees description drop down");
		waitForElementToAppear(OtherfeesdescriptionOFDOption,2);
		verifyMustExists(OtherfeesdescriptionOFDOption, "Other fees description option");
		click(OtherfeesdescriptionOFDOption,"Select Other fees description option");
		
	}
	
	public void step3_TC1076()
	{
		waitForElementToAppear(suppliedBordereauSheetDD, 2);
		verifyMustExists(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		
		String Sheetlocator = "@xpath=//*[@class='k-animation-container']/div/div[3]";
		ExpectedResult_1076= getTextFrom(Sheetlocator);
		
		if(ExpectedResult_1076.contains("April 2018"))
		{
			Report.LogInfo("Result", "Sheet April 2018 Found", "Fail");	
		}
		else
		{
			Report.LogInfo("Result", "Sheet April 2018 Not Found", "Pass");	
		}
	}
	
	
	public void Step4_TC1068_ROE1() throws Exception //SELECT rate of exchange option
	{
		

		waitForElementToAppear(CoreDetails, 8);
		verifyMustExists(CoreDetails,"Core Details Step 4");
		click(CoreDetails,"Core Details Step 4");
		Thread.sleep(2000);
		
		waitForElementToAppear(RateOfExchangeDD, 8);
		verifyMustExists(RateOfExchangeDD,"Rate of Exchange drop down");
		click(RateOfExchangeDD,"Rate of Exchange drop down");
		
		waitForElementToAppear(RateOfExchangeOption,2);	
		verifyMustExists(RateOfExchangeOption, "Rate of Exchange option");
		click(RateOfExchangeOption,"Select Rate of Exchange drop down");
		
	}
	public void Step4_TC1068_ROE2() throws Exception   //SELECT Risk inception option.
	{
		

		waitForElementToAppear(CoreDetails, 8);
		verifyMustExists(CoreDetails,"Core Details Step 4");
		click(CoreDetails,"Core Details Step 4");
		Thread.sleep(2000);
		
		waitForElementToAppear(RateOfExchangeDD, 8);
		verifyMustExists(RateOfExchangeDD,"Rate of Exchange drop down");
		click(RateOfExchangeDD,"Rate of Exchange drop down");
		
		waitForElementToAppear(RiskInceptionOption,2);
		verifyMustExists(RiskInceptionOption, "Risk inception option");
		click(RiskInceptionOption,"Select Risk Inception option");
	}
	public void IgnoreHiddenSheet_TC1076() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		  
	//	String payload = "{\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S12503320180528.xlsx\",\"Filesize\":0,\"Path\":null,\"size\":24315,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"BordereauFormat\":{\"UniqueFileName\":\"S12503320180528.xlsx\"}}";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		
		
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\HiddenSheet_April.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(allSheetsPath);
		String Filename = "S56091420180919.xlsx";
		int size = 24315;
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
	
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		openurl(URL);
		sleep(2000);
		//UploadFile(allSheets,);
		//verifyExists(bordereauQuePage,"Bordereau Questionnaire Page Title");	
		step2(QuestionnaireName);
		step3_TC1076();
	}
	public void addNewRiskandPremiumQuestionnaire() throws InterruptedException, AWTException, ClientProtocolException, IOException
	{
		//loginPage.tideLogin();
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		addRiskandPremiumQuestionnairedetails();
	}
	
	 public void addNewRiskandPremiumForSaveAsDraftStatusQuestionnaire() throws InterruptedException, Exception
		{
			//loginPage.tideLogin();
			homePage.adminMenu();
			bordereauQueLink();
			bordereauQuePage();
			addRiskandPremiumQuestionnaireDetailsForDraftStatus();
			sleep(1500);
			OpenQuestionnaireForFilter(EditName1);	
			VerifyDraftStatusandActiveButton();
		}
	
	
	
	
	
	public void addRiskandPremiumQuestionnairedetails() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{		
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		Report.LogInfo("", requestURL , "WARNING");
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetpath2 = fpath+"\\src\\test\\resources\\testdata\\January 2018_Blank Column process in Questionnaire.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetpath2);
		String Filename = "S51725920181031.xlsx";
		int size = 18243;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
		 if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("kruthika@systenics.net","apple@4169");
			 openurl(URL);	 
		 }
		 sleep(2000);
		 verifyMustExists(typeOfBordereauDD,"Bordereau Type");
			click(typeOfBordereauDD,"Bordereau Type Dropdown");
			sleep(2000);
			verifyMustExists(RiskAndPremiumOption,"Select Risk and Premium Option");
			click(RiskAndPremiumOption,"Select Risk and Premium Option");
			sleep(2000);
			verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
			click(businessClassDD,"Bordereau associated Dropdown");
			sleep(1000);
			//sendKeys()
			verifyMustExists(RiskAndPremiumSchemaOption,"Select Automation Schema Option");
			click(RiskAndPremiumSchemaOption,"Select Automation Schema Option");
			sleep(2000);
			verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
			sendKeys(questionnaireNameTxt,RiskAndPremiumText,"Questionnaire Name Textbox.");
			EditName = RiskAndPremiumText;
			nextStapeClick();
			
			step3RiskAndPremium(FirstSheetOption);
			waitForElementToAppear(headerRowCountTxt,2);
			verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
			sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
			nextStapeClick();
			sleep(1000);
					
		step4();
		step5();
		step6RiskAndPremium(); //6th Step
		step6();//7th Step
		step7(); //8th Step
		
		step8(); //9th Step
		step9(); //10th Step
		step10(); //11th Step
		step12(); //12th Step
		step13RiskAndPremium();
		nextStapeClick(); // 14th Step
		step14(); // 15th Step
		
	}
	public void step3RiskAndPremium(String sheetName)
	{
		sleep(2000);
		verifyMustExists(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		click(suppliedBordereauSheetDD,"Supplied Bordereau Dropdown");
		sleep(2000);
		click(suppliedBordereauSheetBorddataOption,"Select bord data Option");//suppliedBordereauSheetBorddataOption
		sleep(2000);
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+sheetName+"')]")).click();
	}
	public void step6RiskAndPremium()
	{    
		refreshPage();
		sleep(1000);
		findWebElement(premiumsChk).sendKeys(Keys.SPACE);
		sleep(1000);
		findWebElement(limitAndOtherChk4).sendKeys(Keys.SPACE); //limitAndOtherChk4
		nextStapeClick();
		//sleep(5000);
	}

	public void editRiskAndPremiumBordereauFormat()  throws InterruptedException, Exception
	{
	   // String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+EditName+"')][1]";
	    OpenQuestionnaireForFilter(EditName);
		/*homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();*/
		//filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		editTextProcessforRiskAndPremiumQuestionnaire();
		OpenQuestionnaireForFilter(EditName);
		//filterBordereauQuestionnaire(EditName, SelectQuestionnaire);
		sleep(3000);
		waitForElementToAppear(VerifyRandPVersion2,5);
		versionNumber = getTextFrom(VerifyRandPVersion2);
		if(getTextFrom(VerifyRandPVersion2).equals("2") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 2", "PASS");
		}
		else
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "FAIL");
		}
	}
	
	public void editTextProcessforRiskAndPremiumQuestionnaire() throws AWTException
	{
		sleep(2000);
		if(getTextFrom(VerifyRandPVersion1).equals("1") == true)
		{
			Report.LogInfo("VersionIs", "Bordereau Questionnaire Version is 1", "PASS");
		}	
		VerifyActiveStatusandDeActiveButton();
		waitForElementToAppear(EditBtn, 3);
		verifyMustExists(EditBtn,"Edit button");
		click(EditBtn,"Edit button");
		sleep(3000);
		nextStapeClick();
		waitForElementToAppear(appliedToIdentifyDD, 3);
		verifyMustExists(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		click(appliedToIdentifyDD,"Applied Bordereau Dropdown");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+AllSheetOption+"')]")).click();
		nextStapeClick();
		verifyMustExists(CancelBtn,"Cancel button");
		click(CancelBtn,"Cancel button");
		sleep(3000);
	}
	
	public void addRiskandPremiumQuestionnaireDetailsForDraftStatus() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{	
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetpath2 = fpath+"\\src\\test\\resources\\testdata\\January 2017 for SaveAsDraft.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetpath2);
		String Filename =  "S37342120181129.xlsx"; //"S26857520181031.xlsx";
		int size = 25368;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
		 if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("kruthika@systenics.net","apple@4169");
			 openurl(URL);	 
		 }
		 sleep(2000);
		 verifyMustExists(typeOfBordereauDD,"Bordereau Type");
			click(typeOfBordereauDD,"Bordereau Type Dropdown");
			sleep(2000);
			verifyMustExists(RiskAndPremiumOption,"Select Risk and Premium Option");
			click(RiskAndPremiumOption,"Select Risk and Premium Option");
			sleep(2000);
			verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
			click(businessClassDD,"Bordereau associated Dropdown");
			sleep(1000);
			//sendKeys()
			verifyMustExists(RiskAndPremiumSchemaOption,"Select Automation Schema Option");
			click(RiskAndPremiumSchemaOption,"Select Automation Schema Option");
			sleep(2000);
			verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
			sendKeys(questionnaireNameTxt,RiskAndPremiumText1,"Questionnaire Name Textbox.");
			EditName1 = RiskAndPremiumText1;
			Report.LogInfo("Questionnaire Name Added", "Questionnaire Name Added Successfully", "PASS");
			nextStapeClick();
			
			step3RiskAndPremium(FirstSheetOption);
			waitForElementToAppear(headerRowCountTxt,2);
			verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
			sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
			nextStapeClick();
			RiskandPremiumstep4SaveAsDraft();		
		
	}
	
	
	public void RiskandPremiumstep4SaveAsDraft()
	{
		//webDriver.navigate().refresh();
		if(isVisible(RiskSpecifiedDD) == true)
		{
			verifyMustExists(RiskSpecifiedDD,"Risk Specified Dropdown");
			click(RiskSpecifiedDD,"Risk Specified Dropdown");
			sleep(1000);
			click(RiskOption,"Risk Option");
			sleep(1000);
		}
		javaScriptclick(multipleLocationsRadioBtn,"Select multiple locations reported for each Risk? Radio Button");
		verifyMustExists(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		sleep(2000);
		click(yearofAccountOption,"Select Year of Account ");
		sleep(1000);
		javaScriptclick(contractOrderRadioBtn,"Select Contract Order supplied in the Bordereau? Radio Button");
		sleep(1000);
		waitForElementToAppear(SaveAsDraftQueBtn,5);
		verifyMustExists(SaveAsDraftQueBtn,"Save As Draft");
		javaScriptclick(SaveAsDraftQueBtn,"Save As Draft");
		sleep(3000);
	}
	
	public void VerifyActiveStatusandDeActiveButton() throws AWTException
	{
		sleep(2000);
		if(isVisible(ActiveStatusBtn) == true)
		{
			verifyMustExists(ActiveStatusBtn,"Active Status Button");
			Report.LogInfo("Active Status Button", "Draft Status Button is Enable", "PASS");
		}else{
			Report.LogInfo("Active Status Button", "Draft Status Button is Disable", "Fail");
		sleep(2000);		
		if(isVisible(DeactivateQueBtn) == true)
		{
			verifyMustExists(DeactivateQueBtn,"Activate Button");
			Report.LogInfo("Activate Button", "Activate Button is Enable", "PASS");
		}else{
			Report.LogInfo("Activate Button", "Activate Button is Disable", "Fail");
			
		sleep(1000);
		}
		}
	}
	
	public void VerifyDraftStatusandActiveButton() throws AWTException
	{
		sleep(2000);
		if(isVisible(DraftstatusQues) == true)
		{
			verifyMustExists(DraftstatusQues,"Draft Status Button");
			Report.LogInfo("Draft Status Button", "Draft Status Button is Enable", "PASS");
		}else{
			Report.LogInfo("Draft Status Button", "Draft Status Button is Disable", "Fail");
		sleep(2000);		
		if(isVisible(ActivateQueBtn) == true)
		{
			verifyMustExists(ActivateQueBtn,"Activate Button");
			Report.LogInfo("Activate Button", "Activate Button is Disable", "PASS");
		}else{
			Report.LogInfo("Activate Button", "Activate Button is Enable", "Fail");
			
		sleep(1000);
		}
		}
	}
	

	public void addCSVRiskandPremiumQuestionnaire() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{		
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		Report.LogInfo("", requestURL , "WARNING");
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetpath2 = fpath+"\\src\\test\\resources\\testdata\\January-Risk-PB-2018CSV.csv";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetpath2);
		String Filename = "S29641720181102.csv";
		int size = 1059;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
		 if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("priti@systenics.net","test1234@");
			 openurl(URL);	 
		 }
		 sleep(2000);
		 verifyMustExists(typeOfBordereauDD,"Bordereau Type");
			click(typeOfBordereauDD,"Bordereau Type Dropdown");
			sleep(2000);
			verifyMustExists(RiskAndPremiumOption,"Select Risk and Premium Option");
			click(RiskAndPremiumOption,"Select Risk and Premium Option");
			sleep(2000);
			verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
			click(businessClassDD,"Bordereau associated Dropdown");
			sleep(1000);
			//sendKeys()
			verifyMustExists(automationSchemaOption,"Select Automation Schema  Option");
			click(automationSchemaOption,"Select Automation Schema  Option");
			sleep(2000);
			verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
			sendKeys(questionnaireNameTxt,CSVRiskAndPremium,"Questionnaire Name Textbox.");
			EditName = CSVRiskAndPremium;
			nextStapeClick();
			
			//step3RiskAndPremium(FirstSheetOption);
			waitForElementToAppear(headerRowCountTxt,2);
			verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
			sendKeys(headerRowCountTxt,"4", "Header Row Count Textbox.");		
			nextStapeClick();
			sleep(1000);
					
		step4();
		step5();
		step6RiskAndPremium(); //6th Step
		step6();//7th Step
		step7(); //8th Step
		
		step8(); //9th Step
		step9(); //10th Step
		step10(); //11th Step
		step12(); //12th Step
		step13RiskAndPremium();
		/*List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}

		String YBDrag = "@xpath=//button[contains(.,'YB')]";
		String YBDrop = "@xpath=//td[contains(.,'Location Year Built')]//preceding-sibling::td/div/div";
	
		String AddressDrag = "@xpath=//button[contains(.,'Address 1')]";
		String AddressDrop = "@xpath=//td[contains(.,'Insured Address')]//preceding-sibling::td/div/div";
		String CountryDrag = "@xpath=//button[contains(.,'Country')]";
		String CountryDrop = "@xpath=//td[contains(.,'Insured Country')]//preceding-sibling::td/div/div";
     	String PostalCodeDrag = "@xpath=//button[contains(.,'Postal Code')]";
		String PostalCodeDrop = "@xpath=//td[contains(.,'Insured Postal/Zip Code')]//preceding-sibling::td/div/div";
		String BuildingsValueDrag = "@xpath=//button[text()='Buildings']";
		String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";

		dragDropElement(YBDrag,YBDrop);
		dragDropElement(BuildingsValueDrag,BuildingsValueDrop);
		dragDropElement(AddressDrag,AddressDrop);
		dragDropElement(CountryDrag,CountryDrop);
		dragDropElement(PostalCodeDrag,PostalCodeDrop);	
		dragDropElement(SprinklersDrag,SprinklersDrop);*/
		nextStapeClick(); // 14th Step
		
		BFormatId= ReturnFormatID();
		step14(); // 15th Step
		
	}
	
	public void addCoverageQuestionnaire() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{		
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		Report.LogInfo("", requestURL , "WARNING");
		//sleep(2000);
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetpath2 = fpath+"\\src\\test\\resources\\testdata\\Coverage.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(firstSheetpath2);
		String Filename = "S34404120181106.xlsx";
		int size = 25810;
		
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		String ID = extractIDFromResponse(response);
	
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);
		
		String formatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", formatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		 Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
		 if(isVisible(loginPage.Username)==true) {
				loginPage.tideLogin("priti@systenics.net","test1234@");
			 openurl(URL);	 
		 }
		 sleep(2000);
		 verifyMustExists(typeOfBordereauDD,"Bordereau Type");
			click(typeOfBordereauDD,"Bordereau Type Dropdown");
			sleep(2000);
			verifyMustExists(RiskAndPremiumOption,"Select Risk and Premium Option");
			click(RiskAndPremiumOption,"Select Risk and Premium Option");
			sleep(2000);
			verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
			click(businessClassDD,"Bordereau associated Dropdown");
			sleep(1000);
			//sendKeys()
			verifyMustExists(LloydSchemaOption,"Select Lloyd Property  Schema  Option");
			click(LloydSchemaOption,"Select Lloyd Property  Schema  Option");
			sleep(2000);
			verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
			sendKeys(questionnaireNameTxt,Coverage,"Questionnaire Name Textbox.");
			EditName = Coverage;
			nextStapeClick();
			
			step3(FirstSheetOption);
			waitForElementToAppear(headerRowCountTxt,2);
			verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
			sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
			nextStapeClick();
			sleep(1000);
					
		step4();
		step5();
		step6RiskAndPremium(); //6th Step
		step6();//7th Step
		step7(); //8th Step
		
		step8(); //9th Step
		step9(); //10th Step		
    	step10(); //11th Step
    	
    	verifyMustExists(AddcoverageBtn," ADD NEW COVERAGE button");
		click(AddcoverageBtn," ADD NEW COVERAGE button");
		sleep(1000);
		verifyMustExists(Addingcoverage," ADD NEW COVERAGE field button");
		click(Addingcoverage," ADD NEW COVERAGE button");
		sleep(1000);
		click(AddingcoverageOption," ADD NEW COVERAGE button");
		
		
		//SelectDropDownValue(Addingcoverage, AddingcoverageOption);
		sleep(1000);
		CoverageFields(); // 12 Step Coverage
    	
		//Verify Add existence field
		verifyMustExists(AddcoverageBtn," ADD NEW COVERAGE button");
		click(AddcoverageBtn," ADD NEW COVERAGE button");
		
		verifyMustExists(Addingcoverage," ADD NEW COVERAGE field button");
		click(Addingcoverage," ADD NEW COVERAGE field button");
		
		if(isVisible(AddingcoverageOption)==true)
		{
			Report.LogInfo("ValidateResult", "Escape of Water field display ", "Fail");
					   
		}else{
			Report.LogInfo("ValidateResult", "Escape of Water field Not display ", "PASS");
			  verifyMustExists(CoverCancelBtn,"Cancel button");
			  click(CoverCancelBtn,"Cancel button");
		}
		sleep(1000);
		verifyMustExists(CoveragetTabHeader1,"Coverage Header 1");
		verifyMustExists(CoveragetTabHeader2,"Coverage Header 2");
		verifyMustExists(CoveragetTabHeader3,"Coverage Header 3");
		verifyMustExists(CoveragetTabHeader4,"Coverage Header 4");
		verifyMustExists(CoveragetTabHeader5,"Coverage Header 5");
		verifyMustExists(CoveragetTabHeader6,"Coverage Header 6");
		verifyMustExists(CoveragetTabHeader7,"Coverage Header 7");
		verifyMustExists(CoveragetTabHeader8,"Coverage Header 8");
		verifyMustExists(CoveragetTabHeader9,"Coverage Header 9");
		verifyMustExists(CoveragetTabHeader10,"Coverage Header 10");
		sleep(1000);
		nextStapeClick();
		step13RiskAndPremium();
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}
		
		nextStapeClick(); // 14th Step
		
		BFormatId= ReturnFormatID();
		step14(); // 15th Step
		
	}
	
	public void CoverageFields() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
	
		/*
		SelectDropDownValue(CoverageIncludedFlag, CoverageIncludedFlagOption);
		sleep(1000);				
		SelectDropDownValue(CurrencyCoverage, CurrencyCoverageOption);
		sleep(1000);				
		SelectDropDownValue(TotalSunInsured, TotalSunInsuredOption);
		sleep(1000);
		SelectDropDownValue(CoverageLimit, CoverageLimitOption);
		sleep(1000);
		SelectDropDownValue(DXB, DXBOption);
		sleep(1000);
		SelectDropDownValue(DXA, DXAOption);
		sleep(1000);
		SelectDropDownValue(DXP, DXPOption);
		sleep(1000);
		SelectDropDownValue(DXPA, DXPAOption);
		sleep(1000);
		SelectDropDownValue(GP, GPOption);
		sleep(1000);*/
		
		
		verifyMustExists(CoverageSave,"Coverage Save");
		click(CoverageSave,"Coverage Save button");
		sleep(1000);
		
		
	}
	public void ExpertFields() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		
		
		verifyMustExists(ExpertCopmpanyName,"Coverage Save");
		//click(ExpertCopmpanyName,"Coverage Save button");
		//click(ExpertCopmpanyNameOption,"Coverage Save button");
		sleep(1000);
		
		verifyMustExists(ExpertCopmpanyReference,"Coverage Save");
		//click(ExpertCopmpanyReference,"Coverage Save button");
		//click(ExpertCopmpanyReferenceOption,"Coverage Save button");
		sleep(1000);
		
		
		verifyMustExists(ExpertCopmpanyAddress,"Coverage Save");
		//click(ExpertCopmpanyAddress,"Coverage Save button");
		//click(ExpertCopmpanyAddressOption,"Coverage Save button");
		sleep(1000);
		
		verifyMustExists(ExpertCopmpanyState,"Coverage Save");
		//click(ExpertCopmpanyState,"Coverage Save button");
		//click(ExpertCopmpanyStateOption,"Coverage Save button");
		sleep(1000);
		
		verifyMustExists(ExpertCopmpanyPostalCode,"Coverage Save");
		//click(ExpertCopmpanyPostalCode,"Coverage Save button");
		//click(ExpertCopmpanyPostalCodeOption,"Coverage Save button");
		sleep(1000);
		
		verifyMustExists(ExpertCopmpanyCountry,"Coverage Save");
		//click(ExpertCopmpanyCountry,"Coverage Save button");
		//click(ExpertCopmpanyCountryOption,"Coverage Save button");
		sleep(1000);
		
		
		verifyMustExists(CoverageSave,"Coverage Save");
		click(CoverageSave,"Coverage Save button");
		sleep(1000);
	
	}
	
	public void addexpertquestionnaire() throws AWTException, ClientProtocolException, IOException, InterruptedException
	{
		String requestURL = Configuration.url+"api/FileStorage/UploadFile/4";
		String URLname = Configuration.url+"api/BordereauFormat/AddNewBordereauFormat";
		step1();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			addClaimQuestionairePath = fpath+"\\src\\test\\resources\\testdata\\Claims Expert.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(addClaimQuestionairePath);
		String Filename = "S53972320181112.xlsx";
		int size = 12762;
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		String ID = extractIDFromResponse(response);
		String payload = GeneratePayloadForQuestionaire(ID,Filename, size);	
		String formatId = addNewBordereauFormat(payload, URLname);
		String URL = Configuration.url.replace("https", "https")+"/#!/app/bordereaux/bordereauType?Redirect=app.bordereauxlist&FormatId="+formatId+"&isEdit=0&CreateAndProcess=0";
		
		 openurl(URL);
			sleep(3000);
			if(isVisible(loginPage.Username)==true) {
					loginPage.tideLogin("admin@tide.com","Test123@");
				 openurl(URL);	 
			 }

		verifyMustExists(typeOfBordereauDD,"Bordereau Type");
		click(typeOfBordereauDD,"Bordereau Type Dropdown");
		verifyMustExists(ClaimOption,"Select Premium Option");
		click(ClaimOption,"Select Premium Option");
		sleep(1000);
		verifyMustExists(businessClassDD,"Bordereau associated Dropdown");
		click(businessClassDD,"Bordereau associated Dropdown");
		sleep(1000);
		click(ClaimSchemaOption,"Select Automation Schema Option");
		sleep(1000);
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		sendKeys(questionnaireNameTxt,Expert,"Questionnaire Name Textbox.");
		EditName = Expert;
		nextStapeClick();
		step_3(FirstSheetOption);
		
		
		waitForElementToAppear(headerRowCountTxt,2);
		verifyMustExists(headerRowCountTxt,"Header Row Count Textbox");
		sendKeys(headerRowCountTxt,"1", "Header Row Count Textbox.");		
		nextStapeClick();
		sleep(1000);
		step4Claim();		
		nextStapeClick();
		step6Claim();
		nextStapeClick();// step7
		nextStapeClick();// step8
		//step7Claim();
		//step8Claim();
		
		//Add Expert1 
		verifyMustExists(AddcoverageBtn," ADD NEW COVERAGE button");
		click(AddcoverageBtn," ADD NEW COVERAGE button");
		
		SelectDropDownValue(AddingtypeofExpertcoverage, AddingcoverageOption);
		sleep(1000);
		
		ExpertFields(); // 12 Step Coverage
		//Verf Added Fields
		verifyMustExists(ExpertTabHeader1,"Expert Header 1");
		verifyMustExists(ExpertTabHeader2,"Expert Header 2");
		verifyMustExists(ExpertTabHeader3,"Expert Header 3");
		verifyMustExists(ExpertTabHeader4,"Expert Header 4");
		verifyMustExists(ExpertTabHeader5,"Expert Header 5");
		verifyMustExists(ExpertTabHeader6,"Expert Header 6");
		verifyMustExists(ExpertTabHeader7,"Expert Header 7");
		
		
		//Add Expert2
		verifyMustExists(AddcoverageBtn," ADD NEW COVERAGE button");
		click(AddcoverageBtn," ADD NEW COVERAGE button");
		
		
		SelectDropDownValue(AddingtypeofExpertcoverage, AddingcoverageOption);
		sleep(1000);
		
		ExpertFields(); // 12 Step Coverage
		//Verf Added Fields
		verifyMustExists(ExpertTabHeader_1,"Expert Header_1");
		verifyMustExists(ExpertTabHeader_2,"Expert Header_2");
		verifyMustExists(ExpertTabHeader_3,"Expert Header_3");
		verifyMustExists(ExpertTabHeader_4,"Expert Header_4");
		verifyMustExists(ExpertTabHeader_5,"Expert Header_5");
		verifyMustExists(ExpertTabHeader_6,"Expert Header_6");
		verifyMustExists(ExpertTabHeader_7,"Expert Header_7");
		
		step9Claim();
		step10Claim();
		step11Claim();
		FormatId = ReturnFormatID();
		step12();
		List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));

		for(int i=1; i<=RemoveIcon.size();i++){
			String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
			sleep(100);
			if(isVisible(row) ==true){
				webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
				sleep(1000);
			}
		}
		
		step13();
		step14();
	}


public void OpenQuestionnaireForFilter(String QuestionnaireName ) throws Exception
	{
		homePage.adminMenu();
		bordereauQueLink();
		bordereauQuePage();
		filterBordereauQuestionnaire1(QuestionnaireName);
		Thread.sleep(3000);
	}


	// TODO Auto-generated method stub
public void addScheduleToOpnMrktContrct()throws InterruptedException, AWTException, ClientProtocolException, IOException
{	
	
	String requestURL = Configuration.url+"api/FileStorage/UploadFile/2";
	String URLname = Configuration.url+"api/Schedule/AddAsDraft";
	//policyPage.applyFilterPolicy("592480WI");
	//BordPage.applyFilterPolicy("159029HF");
	//policyPage.openSelectedPolicy();

	policy.addOpnMrktTypePolicy();
	
	contractId = ReturnContractID();
	
	String GetData = Configuration.url+"/api/Contract/GetAllPage";
	String payload_1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

	
	navigateToScheduleTab();
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\4230ScheduleQuestionnaireFormatest.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(allSheetsPath);
		String Filename = "S77645120181221.xlsx";
		int size = 10616;
	
		String response = uploadFileQueNew(requestURL, excelFile, Filename);
		sleep(2000);
		 Report.LogInfo("formatId", response , "WARNING");
		String ID = extractIDFromResponse(response);
		
		  Report.LogInfo("formatId", ID , "WARNING");
		String payload = GeneratePayloadForSchedule(contractId,ID,Filename, size);
		 Report.LogInfo("formatId", payload , "WARNING");
		String ScheduleformatId = addNewBordereauFormat(payload, URLname);
		  Report.LogInfo("formatId", ScheduleformatId , "WARNING");
		String URL = Configuration.url.replace("https", "https")+"/#!/app/schedule/type/"+contractId+"/"+ScheduleformatId+"";
		  Report.LogInfo("formatId", URL , "WARNING");
		Report.LogInfo("Response", URL , "WARNING");
			 sleep(3000);
			 openurl(URL);
				 sleep(2000);
		 ScheduleQuestnrStep2();
		 ScheduleStep3();
		ScheduleStep4();
		ScheduleStep5();
		ScheduleStep6();
		ScheduleStep7();
		ScheduleStep8();
		waitForElementToAppear(ScheduleTab, 5);
		verifyMustExists(ScheduleTab,"Verify Schedule tab in contract");
		ScheduleTabInOpnMrktcontrct =  getTextFrom(ScheduleTab);
		
		}

public void navigateToScheduleTab() 
{
	if(isVisible(ScheduleTab)==true){
		waitForElementToAppear(ScheduleTab,5);
		verifyMustExists(ScheduleTab,"Schedule Tab");
		javaScriptclick(ScheduleTab,"Schedule Tab");
	}else{
		Report.LogInfo("ElementCheck", "Expected element not found", "FAIL");
	}
}

public void ScheduleQuestnrStep2()
{
	
	//System.out.println(EditName);
	verifyMustExists(ScheduleTypOfBusinessDD,"Schedule Business Type Dropdown");
	javaScriptclick(ScheduleTypOfBusinessDD,"Schedule Business Type Dropdown");
	sleep(2000);
	verifyMustExists(ScheduleTypOfBusinessDDValue,"Verify Business Type Value");
	javaScriptclick(ScheduleTypOfBusinessDDValue,"Click Type of Business Value");
	sleep(1000);
	verifyMustExists(ScheduleQuesnrNameTxt,"Schedule Questionnaire Name Textbox");
	sendKeys(ScheduleQuesnrNameTxt,ScheduleQuestionnaireName,"Schedule Questionnaire Name Textbox.");
	waitForElementToAppear(NextScheduleQunrBtn, 5);
	sleep(1000);
	//verifyMustExists(NextScheduleQunrBtn, "Verify Next tep button in Schedule Questionnaire");
	click(NextScheduleQunrBtn,"Click Next step button");
	EditScheduleQuestnrName=getTextFrom(ScheduleQuestionnaireName);
	System.out.println(EditScheduleQuestnrName);
		//nextStapeClick();

}
public void ScheduleStep3()
{
	sleep(2000);
	verifyExists(SchedukeQuestnName,"Signed Status Button");
	ActualScheduleQuestnrName =  getTextFrom(SchedukeQuestnName);
	sleep(1000);
	verifyMustExists(ScheduleSheetDD,"Verify Select Sheet Dropdown Value");
	javaScriptclick(ScheduleSheetDD,"Click Select sheet Dropdown");
	sleep(1000);
	verifyMustExists(SelectScheduleSheetDDValue,"Verify sheet value from Drop Down");
	javaScriptclick(SelectScheduleSheetDDValue,"Select March Option");
	sleep(2000);
	verifyMustExists(SelectRowInSchedule,"Verify Header Row Count Text");
	clearTextBox(SelectRowInSchedule);
	sleep(1000);
	sendKeys(SelectRowInSchedule,"1", "Header Row Count Textbox.");
	waitForElementToAppear(NextScheduleQunrBtn, 5);
	verifyMustExists(NextScheduleQunrBtn, "Verify Next tep button in Schedule Questionnaire");
	javaScriptclick(NextScheduleQunrBtn,"Click Next step button");
	//nextStapeClick();
	
	}
public void ScheduleStep4()
{
	//webDriver.navigate().refresh();
		/*sleep(1000);
		verifyMustExists(selectValidFieldQuestnDD,"Verify Field if blank mean that it is not a valid risk, and the row can be deleted");
		javaScriptclick(selectValidFieldQuestnDD,"Click Dropdown");
		sleep(1000);
		clearTextBox(FieldQustnDDValue);
		sleep(1000);
		javaScriptclick(FieldQustnDDValue,"Click Field Risk Reference Option");*/
		waitForElementToAppear(NextScheduleQunrBtn, 5);
		verifyMustExists(NextScheduleQunrBtn, "Verify Next tep button in Schedule Questionnaire");
		javaScriptclick(NextScheduleQunrBtn,"Click Next step button");
		//nextStapeClick();
}
public void ScheduleStep5()
{ 
	sleep(1000);
	//FilterDefaultFields(LocationFloorTideFild, "Filter Location Floor Number", LocationFlrSpecifyDefltClck);
	waitForElementToAppear(TideFieldFilter, 10);
	verifyMustExists(TideFieldFilter,"Tide Filter");
	click(TideFieldFilter,"Tide Fiter");
	sleep(1000);
	verifyMustExists(LocationFloorTideFild,"Filter Location Floor");
	click(LocationFloorTideFild,"Filter Location Floor");
	sleep(1000);
	verifyMustExists(FilterBtn,"Tide Filter");
	click(FilterBtn,"Tide Filter");
	sleep(2000);
	verifyMustExists(LocationFlrSpecifyDefltClck,"Verify Default value option");
	javaScriptclick(LocationFlrSpecifyDefltClck,"Click Location Floor Default Option");
	sleep(1000);
	verifyMustExists(ApplyDefltfrLoctnFlrScrn,"Verify Apply Default Value for Location Floor Number Text on Screen");
	verifyMustExists(TextClmDfltLoctValue,"Verify Text Box of location Floor");
	sendKeys(TextClmDfltLoctValue,"Test1","Location Floor  Textbox.");
	sleep(1000);
	verifyMustExists(SaveDefultVlueBtn,"Verify Save Button of Default Value");
	javaScriptclick(SaveDefultVlueBtn,"Click Save Button of Default Value");
	waitForElementToAppear(TideFieldFilter, 5);
	click(TideFieldFilter,"Tide Filter");
	sleep(1000);
	verifyMustExists(ClearBtnofFltr,"Verify Clear Button");
	javaScriptclick(ClearBtnofFltr,"Click Clear Button");
	sleep(1000);
	waitForElementToAppear(NextScheduleQunrBtn, 5);
	verifyMustExists(NextScheduleQunrBtn, "Verify Next tep button in Schedule Questionnaire");
	javaScriptclick(NextScheduleQunrBtn,"Click Next step button");
	//nextStapeClick();
	}
public void ScheduleStep6()
{
	sleep(1000);
	
	nextStapeClick();
}

public void ScheduleStep7()
{
	waitForElementToAppear(NextScheduleQunrBtn, 5);
	verifyMustExists(NextScheduleQunrBtn, "Verify Next tep button in Schedule Questionnaire");
	javaScriptclick(NextScheduleQunrBtn,"Click Next step button");	
}

public void ScheduleStep8()
{
	waitForElementToAppear(SaveBtn, 10);
	verifyMustExists(SaveBtn,"Save Button");
	click(SaveBtn,"Save Button");
	sleep(3000);;
}
public void FilterScheduleQuestneFrmQuestionnaireList() throws InterruptedException, AWTException

{
	sleep(1000);
	homePage.adminMenu();
	bordereauQueLink();
	bordereauQuePage();
	filterBordereauQuestionnaire(EditScheduleQuestnrName, SelectQuestionnaire);
	VerifyDraftStatusandActiveButton();
	
	
}
}		