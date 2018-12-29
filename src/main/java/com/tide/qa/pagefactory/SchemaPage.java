package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class SchemaPage extends PageBase {


	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	Rules rule = new Rules();
	String RuleNameInformation;
	String UniqueReferenceVal1;
	String FilteredRuleNameVerification;
	public String SAVE;
	public String ErrorPageValidate;
	public String ErrorPageValidate1;
	public String ErrorPageValidate2;
	public String ErrorPageValidate3;
	public String ErrorPageValidate4;
	public String ErrorPageValidate5;
	public String ErrorPageValidate6;
	public String ErrorPageValidate7;
	public String ErrorPageValidate8;
	public String ErrorPageValidate9;
	public String AddRuleBtn;
	public String SavePublish;
	public String PageValidate;
	public String Reprocess;
	
	public static String COBName;
	public static String SchemaName;

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ssMsddMMyy");
		String datetime = ft.format(dNow);
		return datetime;
	}

	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}

	String RuleName;
	String FilteredRuleNameVerification1;

	public static String contractId;
	public static String sheet4076Path = "";
	public static String sheet3937Path = "";
	public static String sheet3938Path = "";
	public static String sheet3849Path = "";
	public static String sheet3850Path = "";
	public static String sheet3789Path = "";
	public static String sheet3789Path1 = "";
	public static String sheet4044Path = "";
	public static String sheet4080Path = "";
	public static String sheet4080Path1 = "";
	public static String sheet5141Path = "";
	public static String sheet3654Path = "";

	//Schema name
	public static final String RiskSchemaName = "Automation_"+getCurrentDateTimeMS();
	public static final String PremiumSchemaName = "Premium_Test_Schema_"+getCurrentDateTimeMS();
	public static final String ClaimSchemaName = "Automation_Claim_Schema_"+getCurrentDateTimeMS();
	//public static final String PremiumSchemaName="Premium_Automation_431143221117";

	public static final String SchemaLink = "@linkText=Schema";

	//Schema page label
	public static final String SchemaPageLbl = "@xpath=//*[text()='SCHEMA']";
	public static final String RiskLbl = "@xpath=//h3[text()='Risk']";
	public static final String PremiumLbl = "@xpath=//h3[text()='Premium']";
	public static final String ClaimLbl = "@xpath=//h3[text()='Claim']";

	//Add Schema icon
	public static final String AddRiskBtn = "@xpath=//*[@ng-repeat='dataset in SchemaSet'][3]//button";
	public static final String AddPremiumBtn = "@xpath=//*[@ng-repeat='dataset in SchemaSet'][2]//button";
	public static final String AddClaimBtn = "@xpath=//*[@ng-repeat='dataset in SchemaSet'][1]//button";

	//Add Schema page Details
	public static final String SchemaNameTxt = "@xpath=//*[@ng-model='data.SchemaDetails.SchemaName']";
	public static final String ClassOfBusinessDD="@xpath=//*[@ng-model='data.SelectedCOBList']//preceding-sibling::div[1]/input";
	public static final String ClassOfBusinessDDValue = "@xpath=//li[contains(text(),'Property D&F (US binder)')]";
	public static final String ClassOfBusinessDDValue1 = "@xpath=//li[contains(text(),'Cargo')]";
	public static final String SchemaTypeDD="@xpath=//*[@ng-model='data.SchemaDetails.SchemaType']//preceding-sibling::span[1]";
	public static final String SchemaTypeDDValue = "@xpath=//li[contains(text(),'Bordereaux')]";
	public static final String SchemaTypeDDValue1 = "@xpath=//li[contains(text(),'Schedule')]";
	public static final String SaveBtn="@buttonText=Save";
	public static final String SaveChangesBtn="@buttonText=Save Changes";
	public static final String CBddValue="Property D&F (US binder)";
	public static final String SchemaTypeDDTechnology = "@xpath=//li[contains(.,'Technology')]";
	public static final String STddValue="Bordereaux";
	public static final String STddValue1="Schedule";

	//Schema edit page
	public static final String EditkebabIcon = "@xpath=//ui-view[@id='content']//a[@class='dropdown-toggle']";
	public static final String Editlink = "@xpath=//ui-view[@id='content']//a[text()='Edit']";
	public static final String EditClassOfBusinessDD="@xpath=//*[@id='COBLIST']//preceding-sibling::div[1]/input";
	public static final String PropertyDFCancelIcon="@xpath=//dt[text()='Class of Business']/..//li//span[@class='k-icon k-i-close']";
	public static final String EditClassOfBusinessDDValue = "@xpath=//li[contains(text(),'Professional Indemnity (US)')]";
	public static final String BuildingsValue = "@xpath=//*[text()='A - Buildings Value']";
	public static final String BuildingsValue1 = "@xpath=//ul[@aria-hidden='false']//li[text()='A - Buildings Value']";
    
	public static final String BuildingsValuecheckbox1 ="@xpath=//label[contains(.,'A - Buildings Value')]";
	public static final String ContentValueCheckBox ="@xpath=//label[contains(.,'C - Contents Value')]";
	public static final String LocationSprinklersCheckBox ="@xpath=//label[contains(.,'Location Sprinklers (Y/N)')]";
	//public static final String LocationSprinklersCheckBox ="@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]";
	public static final String NoOfBuildingscheckbox ="@xpath=//label[contains(.,'Location Number Of Buildings')]";
	public static final String BuildingYearBuiltcheckbox ="@xpath=//label[contains(.,'Location Year Built')]";
	public static final String ConstructionSchemecheckbox ="@xpath=//label[contains(.,'Location Occupancy Scheme')]";
	public static final String ConstructionCodecheckbox ="@xpath=//label[contains(.,'Location Occupancy Code')]";
	public static final String ConstructionDescriptioncheckbox ="@xpath=//label[contains(.,'Location Occupancy Description')]";
	
	//3660
		public static final String FiscalCodecheckbox ="@xpath=//label[contains(.,'Fiscal Code')]";
		public static final String NAICCodecheckbox ="@xpath=//label[contains(.,'NAIC Code')]";
		public static final String FISCALCODEValue = "@xpath=//*[text()='Fiscal Code']";
		public static final String NAICCODEValue = "@xpath=//*[text()='NAIC Code']";
		public static final String SurplusLinesFilingStatecheckbox ="@xpath=//label[contains(.,'Surplus Lines Filing State')]";
		public static final String SurplusLinesFilingStateValue = "@xpath=//*[text()='Surplus Lines Filing State']";
		public static final String RiskIssuanceDatecheckbox ="@xpath=//label[contains(.,'Risk Issuance Date')]";
		public static final String RiskIssuanceDateValue = "@xpath=//*[text()='Risk Issuance Date']";
		
		
		public static final	String FiscalCodeValue  ="@xpath=//*[@id='grid']//td[text()='Fiscal Code']";
		public static final String PostalCodeValue1 ="@xpath=//*[@id='grid']//td[text()='Risk Postal/Zip Code']";
		public static final String NAICCodeValue ="@xpath=//*[@id='grid']//td[text()='NAIC Code']";
		public static final String SurplusLinesFilingStateValue1 ="@xpath=//*[@id='grid']//td[text()='Surplus Lines Filing State']";
		public static final String NOOption ="@xpath=//ul[@class='k-list k-reset']//li[contains(.,'No')]";
		public static final String British_Indian_Ocean_Territory ="@xpath=//ul[@class='k-list k-reset']//li[contains(.,'British Indian Ocean Territory')]";
		public static final String State_Geneva ="@xpath=//ul[@class='k-list k-reset']//li[contains(.,'Geneva')]";	
	public static final String RightArrowIcon = "@xpath=//*[@ng-click='addToSchemaList()']";
	public static final String SaveAndPublishBtn = "@xpath=//*[@ng-click='savePublish()']";
	public static final String InsuredAddressValue1="@xpath=//td[contains(.,'Insured Address')]";

	public static final String FieldSelectionTab = "@xpath=//a[@ng-click='fieldSelection()']";
	public static final String SettingsTab = "@xpath=//a[text()='Settings']";
	public static final String TotalValueSelectionDD = "@xpath=//*[text()='Total Value Selection']/..//*[@class='k-dropdown-wrap k-state-default']";
	public static final String TotalValueSelectionDDValue = "@xpath=//li[contains(text(),'Total Sum Insured')]";
	public static final String ClassOfBusinessTxt = "@xpath=//*[text()='Class of Business']/../dd";
	public static final String PublishedDescriptionTxt = "@xpath=//*[text()='Published Description']/../dd";
	public static final String PublishDescriptionTxt = "@xpath=//textarea";
	public static final String PublishBtn = "@xpath=//button[@ng-click='publish()']";
	public static final String AddSchemaPageErrorMsg = "@xpath=//*[@ng-if='hasError']";
	public static final String EditPageErrorMsg = "@xpath=//*[@ng-if='hasError']";

	public static final String NoteValue = "@xpath=//*[text()='Notes']";
	public static final String TransactionReference = "@xpath=//*[text()='Transaction Reference']";
	public static final String changedversion = "@xpath=//small";
	//Locators for TC_4076
	public static final String AddRuleInformation= "@xpath=//li[@ng-click='addData(w)']//a[contains(text(),'Information')]";
	public static final String RuleNameText ="@xpath=//*[@ng-model='data.Rules.RuleName']";
	public static final String ErrorMsgTxt ="@xpath=//*[@ng-model='data.Rules.ErrorMessage']";
	public static final String DataSetValueDD = "@xpath=//*[@ng-model='data.Rules.DatasetType']//preceding-sibling::span[1]";
	public static final String DatasetValueDDValue = "@xpath=//li[text()='Risk']";
	public static final String SchemaValueDD = "@xpath=//*[@ng-model='data.Rules.SchemaId']//preceding-sibling::span[1]";
	//public static final String SchemaValueDDValue = "@xpath=//li[contains(.,'Information Schema')]";
	public static final String AppConditionValueDD = "@xpath=//*[@ng-model='data.Rules.IsRuleValid']//preceding-sibling::span[1]";
	public static final String AppConditionValueDDValue = "@xpath=//div[@class='k-list-scroller']//li[text() ='Data is not valid if the rule conditions are met']";
	public static final String AddRuleConditionBtn ="@xpath=//*[@ng-click='addRulesCondition()']";
	public static final String FieldNameValueDD = "@xpath=//*[@ng-model='w.FieldId']//preceding-sibling::span[1]";
	public static final String FieldNameDDValue = "@xpath=//li[text()='Buildings Value']";
	public static final String OperatorValueDD = "@xpath=//*[@ng-model='w.Operator']//preceding-sibling::span[1]";
	public static final String OperatorDDValue = "@xpath=//li[text()='Not Between']";
	public static final String AppliedToValueDD = "@xpath=//*[@ng-model='w.AppliedTo']//preceding-sibling::span[1]";
	public static final String AppliedToDDValue = "@xpath=//li[text()='Value']";
	public static final String EntryValueFromText ="@xpath=//*[@ng-model='w.EntryValueFrom']";
	public static final String EntryValueToText ="@xpath=//*[@ng-model='w.EntryValueTo']";
	public static final String EditRuleBtn ="@xpath=//div[1]//*[@ng-if='w.$edit']/../button[1]";
	public static final String SaveRuleBtn ="@xpath=//*[@ ng-click='save()']";

	// For Filter Schema
	public static final String FilterIconSchema = "@xpath=//*[@data-title='Schema']/a/span";
	public static final String ContentsValueSchema = "@xpath=//*[text()='Contents Value']";
	public static final String RuleBreach = "@xpath=.//*[@id='grid']//tr[1]/td[9]";
	public static final String FilterBtnSchema = "@xpath=//button[contains(.,'Filter')]";
	public static final String FilterIcon = "@xpath=//*[@data-title='Field Name']/a/span";
	public static final String SearchTxt = "@xpath=//input[@placeholder='Search']";
	public static final String FilterBtn = "@xpath=//button[contains(.,'Filter')]";
	public static final String RuleHeaderLink = "@xpath=//a[text()='RULES']";
	public static final String AddRuleDropDown= "@xpath=//button[@ng-click='addData()']//following-sibling::button[1]";
	public static final String AddRuleComplianceData= "@xpath=//li[@ng-click='addData(w)']//a[contains(text(),'Compliance Data')]";
	public static final String ErrorMessgaeText= "@xpath=//input[@ng-model='data.Rules.ErrorMessage']";
	public static final String DataSetDrpDwn= "@xpath=//*[text()='Dataset']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String ProcessingActionDrpDwn= "@xpath=//*[text()='Processing Action']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String CurrencyDrpDwn= "@xpath=//select[@ng-model='data.Rules.Currency']//preceding-sibling::span[1]";
	public static final String ROETolerance= "@xpath=.//*[@ng-model='data.Rules.ROETolerance']";
	public static final String AppConditonDrpDwn= "@xpath=//select[@k-ng-model='data.Rules.IsRuleValid']//preceding-sibling::span[1]";
	public static final String AppSectionDrpDwn= "@xpath=//select[@ng-model='data.SelectedContractSection']//preceding-sibling::div[1]";
	//public static final String FilterIconRuleName= "@xpath=//*[@id='45f80b49-9d49-4615-8c76-9e1fc6d3ce65']/a[1]/span";
	//public static final String FilterIconRuleName= "@xpath=//*[data-title='Rule Name']/a/span";
	//public static final String FilterRuleName = "@xpath=//button[contains(.,'Filter')]";

	public static final String ContentsValue = "@xpath=//*[text()='C - Contents Value']";
	public static final String ContentsValue2 = "@xpath=//div[@class='k-list-scroller']//li[text()='C - Contents Value']";
	public static final String Sprinklers = "@xpath=//*[text()='Location Sprinklers (Y/N)']";
	public static final String Sprinklersvalue = "@xpath=//*[text()='Location Sprinklers (Y/N)']";
	public static final String NumberOfStories = "@xpath=//span[contains(.,'Number of Stories')]";
	public static final String ABuildingsValue = "@xpath=//td[contains(.,'A - Buildings Value')]";
	public static final String PostalCodeValue = "@xpath=//td[contains(.,'Risk Postal/Zip Code')]";
	
	public static final String RiskAddress = "@xpath=//td[contains(.,'Risk Address')]";
	public static final String RiskCureencyValue = "@xpath=//td[contains(.,'Risk Currency')]";
	public static final String NumberOfBuildings = "@xpath=//*[text()='Location Number Of Buildings']";
	public static final String NumberOfBuildingsValue1 = "@xpath=//*[text()='Location Number Of Buildings']";
	public static final String BuildingYearBuilt = "@xpath=//*[text()='Location Year Built']";
	public static final String BuildingYearBuiltValue1 = "@xpath=//*[text()='Location Year Built']";
	public static final String OccupancyScheme = "@xpath=//*[text()='Location Occupancy Scheme']";
	public static final String OccupancyCode = "@xpath=//*[text()='Location Occupancy Code']";
	public static final String OccupancyCodeValue1 = "@xpath=//*[text()='Location Occupancy Code']";
	public static final String OccupancyDescription = "@xpath=//*[text()='Location Occupancy Description']";
	public static final String OccupancyDescriptionValue = "@xpath=//*[text()='Location Occupancy Description']";
	public static final String TotalInsurableValue = "@xpath=//*[text()='Total Insurable Value']";
	public static final String TotalInsurableValue1 = "@xpath=//*[text()='Total Insurable Value']";
	public static final String TotalValueDD = "@xpath=//*[@ng-model='data.TotalValue']//preceding-sibling::span[1]";
	public static final String TotalValueDDValue = "@xpath=//li[contains(.,'Total Insurable Value')]";

	//3937 Error screen
	public static final String MultipleConditionRuleError ="@xpath=//h2[contains(.,'Multiple Condition Rule')]";
	public static final String Data0 ="@xpath=//input[contains(@id,'Data0')]";
	public static final String Data_1 ="@xpath=//input[contains(@id,'Data1')]";
	public static final String Data1 ="@xpath=//*[@id='Data1']//preceding-sibling::span[1]";
	public static final String Data2 ="@xpath=//input[contains(@id,'Data2')]";
	public static final String Data3 ="@xpath=//input[contains(@id,'Data3')]";
	public static final String Data4 ="@xpath=//input[contains(@id,'Data4')]";
	public static final String ContinueBtn ="@xpath=//button[@type='submit']";
	public static final String CancelBtn ="@xpath=//button[@ng-click='cancel()']";
	public static final String Data11 ="@xpath=//*[@id='dataType_Id']/div/div[1]/div[3]/table/tbody/tr[2]/td[5]/div/div/span/span/span[2]/span";
	public static final String Count2 ="@xpath=//*[@id='content']//h2[@class='ng-binding'][text()='2']";
	public static final String ErrorWarningstab ="@xpath=//ul[@ng-if='bordereauxSummary']//li//a[text()='Errors & Warnings']";
	public static final String Records2 ="@xpath=//*[@id='content']//div//td[@class='ng-binding'][text()='2']";
	public static final String ResolveError ="@xpath=//button[@class='btn btn-danger ng-scope'][contains(.,'Resolve Errors')]";
	public static final String Warnings ="@xpath=//button[@class='btn btn-xs btn-danger btn-wide grid-status-btn']";
	public static final String KyeDetails ="@xpath=//ul[@ng-if='bordereauxSummary']//li//a[text()='Key Details']";
	//Rule
	public static final String GrossPremiumValue ="@xpath=//ul//li[text()='Gross Premium']";
	public static final String GreaterThanOrEqualToValue ="@xpath=//li[contains(.,'Greater Than Or Equal To')]";
	public static final String NumberOfStoriesValue ="@xpath=//li[contains(.,'Number of Stories')]";
	public static final String NumberOfBuildingsValue ="@xpath=//li[contains(.,'Location Number Of Buildings')]";
	public static final String LOccuCodeValue ="@xpath=//li[contains(.,'Location Occupancy Scheme')]";
	public static final String InsuredAddressValue ="@xpath=//li[contains(.,'Insured Address')]";
	public static final String BetweenValue ="@xpath=//li[text()=('Between')]";
	public static final String EntryValueFromTxt ="@model=w.EntryValueFrom";
	public static final String EntryValueToTxt ="@model=w.EntryValueTo";
	public static final String OrValue ="@xpath=//li[text()='Or']";
	public static final String RiskInceptionDateValue ="@xpath=//li[contains(.,'Risk Inception Date')]";
	public static final String RiskCountryValue ="@xpath=//li[contains(.,'Risk Country')]";
	public static final String LocationYBValue ="@xpath=//li[contains(.,'Location Year Built')]";
	public static final String NotEqualToValue ="@xpath=//li[contains(.,'Not Equal To')]";
	public static final String TotalInsurableValueRule ="@xpath=//li[contains(.,'Total Insurable Value')]";
	//public static final String GreaterThanValue ="@xpath=//li[contains(.,'Greater Than')]";
	public static final String GreaterThanValue ="@xpath=//li[text()='Greater Than']";
	public static final String LessThanValue ="@xpath=//li[text()='Less Than']";
	public static final String BuildingYearBuiltValue ="@xpath=//li[contains(.,'Location Year Built')]";
	public static final String InsuredName ="@xpath=//li[contains(.,'Insured Name')]";
	public static final String RiskExpiryDate ="@xpath=//li[contains(.,'Risk Expiry Date')]";
	public static final String ContentsValue1 ="@xpath=//ul[@aria-hidden='false']//li[text()='Contents Value']";
	public static final String EntryValueFromDD ="@xpath=//*[@ng-model='w.EntryValueFrom']//preceding-sibling::span[1]";
	public static final String EntryValueFromDD1 ="@xpath=//*[@id='content']/div/div/div/form/div/div[2]/div/div[2]/div/div[1]/div/table/tbody/tr[3]/td[5]/div/div/input";
	public static final String EntryValueToDD ="@xpath=//*[@ng-model='w.EntryValueTo']//preceding-sibling::span[1]";
	public static final String EntryValueFromDD1960Value ="@xpath=//ul/li[contains(.,'1960')]";
	public static final String BuildingYearBuiltDD ="@xpath=//*[@id='Data2']//preceding-sibling::span[1]";
	public static final String RiskCurrencyValue ="@xpath=//li[contains(.,'Risk Currency')]";
	public static final String EntryValueFromDDUSDValue ="@xpath=//ul/li[contains(.,'USD')]";
	public static final String TotalTaxValue ="@xpath=//li[contains(.,'Total Tax %')]";
	public static final String LessThanOrEqualToValue ="@xpath=//li[contains(.,'Less Than Or Equal To')]";
	public static final String RiskPostalCodeValue ="@xpath=//li[contains(.,'Risk Postal/Zip Code')]";
	public static final String ContainsValue ="@xpath=//li[contains(.,'Contains')]";
	public static final String NetPremiumValue ="@xpath=//li[text()='Net Premium To Broker']";
	public static final String ExpairydateValue ="@xpath=//li[text()='Risk Expiry Date']";
	public static final String SprinklersValue ="@xpath=//li[contains(.,'Sprinklers (Y/N)')]";
	public static final String LocationSprinklerValue ="@xpath=//li[contains(.,'Location Sprinklers (Y/N)')]";
	public static final String YearOfAcValue ="@xpath=//li[contains(.,'Year Of Account')]";
	public static final String BuildingValueRule ="@xpath=//li[contains(.,'A - Buildings Value')]";
	public static final String FiscalValueRule ="@xpath=//li[contains(.,'Fiscal Code')]";
	public static final String LocationSprinklersValue ="@xpath=//ul[@aria-hidden='false']//li[text()='Location Sprinklers (Y/N)']";

	//3660
	public static final String SurplusLinesFilingValue ="@xpath=//li[contains(.,'Surplus Lines Filing State')]";
	public static final String RiskReferenceValue ="@xpath=//li[contains(.,'Risk Reference')]";
	public static final String ContentValue ="@xpath=//li[contains(.,'C - Contents Value')]";
	
    //3648
	public static final String ClaimFinnanceCurrencyValue ="@xpath=//li[contains(.,'Claim Financials Currency')]";
	public static final String DateClaimMadeValue ="@xpath=//li[contains(.,'Date Claim Made')]";
	public static final String LossCountryValue ="@xpath=//li[contains(.,'Loss Country')]";
	public static final String EntryValueFromDDGBPValue ="@xpath=//ul/li[contains(.,'GBP')]";
	public static final String LossPostalCodeValue ="@xpath=//li[contains(.,'Loss Postal/Zip Code')]";
	public static final String EntryValueFromDDAlbaniaValue ="@xpath=//li[contains(.,'Albania')]";
	
	public static final String ClaimData0 ="@xpath=//div[@name='Data0']//span[@aria-label='select']";
	public static final String ClaimData1 ="@xpath=//div[@name='Data1']//span[@aria-label='select']";
	public static final String GBPOption ="@xpath=//li[contains(.,'GBP')]";
	public static final String AlbaniyaOption ="@xpath=//li[contains(.,'Albania')]";
	public static final String ClaimData4 ="@xpath=//div[@name='Data3']//span[@aria-label='select']";
	public static final String ClaimData2 ="@xpath=//tr[2]//td[5]//input";
	public static final String ClaimData3 ="@xpath=//tr[3]//td[5]//input";
	public static final String ClaimData5 ="@xpath=//tr[5]//td[5]//input";
	
	//3654
	public static final String LossDescriptionValue ="@xpath=//li[contains(.,'Loss Description')]";
	public static final String EntryValueFromDDUSValue ="@xpath=//li[contains(.,'United States')]";
	public static final String EntryValueFromDDEURValue ="@xpath=//ul/li[contains(.,'EUR')]";
	public static final String ClaimStatusValue ="@xpath=//li[contains(.,'Claim Status')]";
	public static final String EntryValueFromDDOpenValue ="@xpath=//ul/li[contains(.,'Open')]";
	public static final String DenialYNValue ="@xpath=//li[contains(.,'Denial (Y/N)')]";
	public static final String EntryValueFromDDOYESValue ="@xpath=//ul/li[contains(.,'Yes')]";
	public static final String DateOfLossFromValue ="@xpath=//li[contains(.,'Date of Loss (From)')]";
	public static final String ClosedOption ="@xpath=//li[contains(.,'Closed')]";
	public static final String ClosedOption1 ="@xpath=//ul[@aria-hidden='false']//li[text()='Closed']";
	public static final String SrilankaOption ="@xpath=//li[contains(.,'Sri Lanka')]";
	public static final String SrilankaOption2 ="@xpath=//tr[2]//td[3]//following::li[contains(.,'Sri Lanka')][2]";
	public static final String NoValue1 ="@xpath=//ul[@aria-hidden='false']//li[text()='No']";
	
	
	
	
	public static final String EqualToValue ="@xpath=//li[text()='Equal To']";
	public static final String NoValue ="@xpath=//li[text()='No']";
	public static final String OccupancyCodeValue ="@xpath=//li[contains(.,'Occupancy Code')]";
	public static final String IsBlankValue ="@xpath=//li[contains(.,'Is Blank')]";
	public static final String NotBetweenValue ="@xpath=//li[text()='Not Between']";
	public static final String IsnotBlankValue ="@xpath=//li[text()='Is Not Blank']";
	public static final String ClassBusinessSelction= "@xpath=//*[contains(text(),'Class Of Business')]//parent::dl//div[@id='ClassOfBusinessParent']";

	public static final String SingleRuleConditionError ="@xpath=//h2[contains(.,'Single Rule Condition Greater Than')]";
	public static final String EntryValueFromDD300 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'300')]";
	public static final String EntryValueFromDD400 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'400')]";
	public static final String Data0DD ="@xpath=//*[@id='Data0']//preceding-sibling::span[1]";
	public static final String USDValue ="@xpath=//ul[@aria-hidden='false']//li[text()='USD']";
	public static final String Data2DD ="@xpath=//*[@id='Data2']//preceding-sibling::span[1]";
	public static final String Data1DD ="@xpath=//*[@id='Data1']//preceding-sibling::span[1]";
	public static final String Data3DD ="@xpath=//*[@id='Data3']//preceding-sibling::span[1]";
	public static final String YesValue ="@xpath=//ul[@aria-hidden='false']//li[text()='Yes']";
	public static final String AFNValue ="@xpath=//ul[@aria-hidden='false']//li[text()='AFN']";
	public static final String GBPValue ="@xpath=//ul[@aria-hidden='false']//li[text()='GBP']";
	public static final String EURValue ="@xpath=//ul[@aria-hidden='false']//li[text()='EUR']";
	public static final String BuildingValue ="@xpath=//li[contains(.,'Buildings Value')]";

	public static final String SingleRuleConditionLessThanEqualError ="@xpath=//h2[contains(.,'Single Rule Condition Less than Equal to Operator')]";
	// Locators:- TC_4044
	//TC_4044
	public static final String AddRulesDropDwn = "@xpath=//*[@ng-click='addData()']//following-sibling::button[1]";
	public static final String AddRulesOptionInformation = "@xpath=//a[text()='Information']";
	public static final String DataSetDropDwn = "@xpath=//*[@ng-model='data.Rules.DatasetType']//preceding-sibling::span";
	public static final String SelectOptionDataSetDropDwn = "@xpath=//li[text()='Risk']";
	public static final String SchemaDropDwn = "@xpath=//*[@ng-model='data.Rules.SchemaId']//preceding-sibling::span";
	public static final String SchemaDropDwnOption = "@xpath=//li[text()='Automation Schema']";
	public static final String SchemaSearchTextBox = "@xpath=//dt[text()='Schema']//following::input[3]";
	public static final String SelectOptionSchemaDropDwn = "@xpath=//li[text()='Automation Schema']";
	public static final String RulesMenuTab = "@xpath=//*[@ng-if='viewRulesTab']//a";
	public static final String SelectOptionNumberOfStories = "@xpath=//li[contains(.,'Number of Stories')]";
	public static final String EntrySelction1 = "@xpath=//*[@ng-model='w.EntryValueFrom']";
	public static final String EntrySelction2 = "@xpath=//input[@ng-model='w.EntryValueTo']";
	public static final String BetweenSlectionOption = "@xpath=//li[text()='Between']";
	public static final String PopupSaveButton = "@xpath=//*[@class='col-sm-12 p-t-10 ng-scope']//following::button[@ng-click='save()']";
	public static final String BreachesLink = "@xpath=//a[text()='Breaches']";
	public static final String RulseDropDwnSelection = "@xpath=//*[@ng-model='SelectedRuleId']//preceding-sibling::span";
	//public static final String RulseDropDwnSelectionOption = "@xpath=//li[contains(.,'Single Information Rule - 7')]";
	public static final String RulesConditionTab = "@xpath=//dd[contains(.,' Number of Stories between 50 and 99')]";
	public static final String PopupTitle = "@xpath=//h2[contains(.,'Signed Contract Change')]";

	//TC_4080
	public static final String InsurableValue= "@xpath=//li[contains(.,'Total Insurable Value')]";
	public static final String BetweenValue1= "@xpath=//li[text()='Between']";
	public static final String Method1= "@xpath=//*[@ng-model='w.Method']//preceding-sibling::span";
	public static final String AndOption= "@xpath=//li[text()='And']";
	public static final String OrOption= "@xpath=//li[text()='Or']";
	public static final String ValueOption= "@xpath=//li[text()='Value']";
	//public static final String DatasetRiskReference= "@xpath=//*[@ng-bind='dataItem.DisplayFieldName']";
	//public static final String DatasetRiskExpiryDate= "@xpath=//td[contains(.,'Risk Expiry Date')]";
	public static final String DatasetRiskInspectionDate= "@xpath=//*[@ng-bind='dataItem.DisplayFieldName'][contains(.,'Risk Inception Date')]";
	public static final String DatasetGrossPremium= "@xpath=//span[text()='Gross Premium']";
	public static final String DatasetTotalInsurableValue= "@xpath=//span[text()='Total Insurable Value']";
	public static final String RightArrowIcon1= "@xpath=//*[@ng-click='addToSelectionList()']/span";

	public static final String AddRulesConditionButton = "@xpath=//button[@ng-click='addRulesCondition()']";
	public static final String FieldNameDrpDwn = "@xpath= //*[@ng-model='w.FieldId']//preceding-sibling::span[1]";
	public static final String OperatorDrpDwn = "@xpath= //*[@ng-model='w.Operator']//preceding-sibling::span[1]";
	public static final String AppliedToDrpDwn = "@xpath= //*[@ng-model='w.AppliedTo']//preceding-sibling::span[1]";
	public static final String EntrySelectionText1 = "@xpath=//*[@ng-model='w.EntryValueFrom']";	
	
	public static final String TickMarkButton1 = "@xpath=//tr[2][@ng-repeat='w in rulesConditionsList track by $index']//descendant::button[1]";
	public static final String TickMarkButton2 = "@xpath=//tr[3][@ng-repeat='w in rulesConditionsList track by $index']//descendant::button[1]";
	public static final String OperatorDrpDwnSearchText = "@xpath= //div[@class='k-animation-container'][5]//input[@class='k-textbox']";
	public static final String OperatorDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='Equal To']";
	public static final String FieldNameDrpDwnSearchText = "@xpath= //div[@class='k-animation-container'][4]//input[@class='k-textbox']";
	public static final String FieldNameDrpDwnSelectOption1 = "@xpath= //*[@data-role='staticlist']//li[contains(text(),'Risk Inception Date')]";
	public static final String AppliedToDrpDwnSearchText = "@xpath=//div[@class='k-animation-container'][6]//input[@class='k-textbox']";
	public static final String AppliedToDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='Value']";
	public static final String TickMarkButton = "@xpath= //tr[@ng-repeat='w in rulesConditionsList track by $index']//descendant::button[1]";
	//public static final String EntrySelectionText2 = "@xpath=//input[@ng-model='w.EntryValueTo']";
	public static final String EntrySelectionText2 = "@xpath=//*[@id='content']/div/div/div/form/div/div[2]/div/div[2]/div/div[1]/div/table/tbody/tr[2]/td[5]/div/div/div[2]/span/span[1]";
	//public static final String EntrySelectionText2 = "@xpath=//*[@id='content']/div/div/div/form/div/div[2]/div/div[2]/div/div[1]/div/table/tbody/tr[2]/td[5]/div/div/div[2]/span/span[1]/span[2]/span";
	public static final String SaveButtonComplianceRule= "@xpath=//button[@ng-click='save()']";
	public static final String ApplicationConditionDrpDwn ="@xpath=//*[contains(text(),'Application Condition')]//parent::dt[1]//following::span[@class='k-input ng-scope'][1]";
	public static final String ApplicationConditionDrpDwnSelectOption ="@xpath=//*[@data-role='staticlist']//li[text()='Data is valid if the rule conditions are met']";
	public static final String SubmitPassedWarningRecordsForAssignmentBtn ="@xpath=//button[@ng-click='submitBordereau()']";

	//Create Class of business locators
	public static final String SystemReferanceDataOption ="@xpath=//a[contains(.,'Reference Data')]";
	public static final String ClassOfBusinesslabel ="@xpath=//td[contains(.,'Class Of Business')]";
	public static final String AddClassOfBusinessBtn ="@xpath=//button[@ng-click='openAddEditPopup()']";
	public static final String ClassOfBusinessNameTxt ="@model=data.ClassOfBusinessName";
	public static final String ClassOfBusinessShortNameTxt ="@model=data.ClassOfBusinessShortName";
	public static final String LineOfBusinessDD ="@xpath=//*[@ng-model='data.LineOfBusinessId']//preceding-sibling::span[1]";
	public static final String LineOfBusinessValue ="@xpath=//li[text()='Marine']";
	public static final String YearValue1957 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'1957')]";
	public static final String YearValue1958 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'1958')]";
	public static final String YearValue1959 ="@xpath=//ul[@aria-hidden='false']//li[contains(.,'1959')]";

	//3789
	public static final String DataSetFilterIcon ="@xpath=//a[text()='Data']/preceding-sibling::a/span";
	public static final String DataSetFilterSearch ="@xpath=//input[@placeholder='Search']";
	//public static final String COBChkBox ="@xpath=//span[contains(.,'Class of Business')]";
	public static final String COBChkBox ="@xpath=//ul//li[contains(.,'Class Of Business')]";
	public static final String RiskExpiryDateValue="@xpath=//*[@ng-bind='dataItem.DisplayFieldName'][contains(.,'Risk Expiry Date')]";
	public static final String GrossPremium = "@xpath=//span[text()=('Gross Premium')]";
	public static final String RiskCounty = "@xpath=//span[text()=('Risk County')]";
	
	public static final String ClassOfBusinessDDValue2 = "@xpath=//li[contains(text(),'Airline')]";
	//public static final String ContentValueChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Contents Value']/parent::td//following-sibling::td[4]//input";
	public static final String ContentValueChkBox ="@xpath=//*[@id='profile-main']/div/div[3]/div/div/div[2]/table/tbody/tr[100]/td[6]/div/label";
	//public static final String SpinklersChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Sprinklers (Y/N)']/parent::td//following-sibling::td[4]//input";
	public static final String SpinklersChkBox ="@xpath=//*[@id='profile-main']/div/div[3]/div/div/div[2]/table/tbody/tr[101]/td[6]/div/label";
	public static final String NumberOFStoriesChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Number of Stories']/parent::td//following-sibling::td[4]//input";
	public static final String NumberOFBuildingsChkBox ="@xpath=//*[@id='profile-main']/div/div[3]/div/div/div[2]/table/tbody/tr[102]/td[6]/div/label/input";
	// public static final String CancellationDateChkBox ="@xpath=//span[@ng-bind='dataItem.DisplayFieldName'][text()='Cancellation Date']/parent::td//following-sibling::td[4]//input";
	 public static final String CancellationDateChkBox ="@xpath=//*[@id='profile-main']/div/div[3]/div/div/div[2]/table/tbody/tr[16]/td[6]/div/label/input";
	 public static final String SaveAndPublishButton="@xpath=//*[@ng-click='savePublish()']";
	 public static final String ViewQuestinnarie ="@xpath=//*[@ng-click='ViewQuestionnaire()']";
	 //public static final String RemoveSprinkler ="@xpath=//*[text()='Sprinklers']//following-sibling::span//*[@id='tempData129']";
	 public static final String RemoveSprinkler ="@xpath=//*[text()='Sprinklers']//following-sibling::span//*[@id='tempData138']";
	 public static final String SaveandReprocess ="@xpath=//*[@ng-if='saveAndReprocess']";

	public void addRiskSchema_3174() throws InterruptedException
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifySchemaSection(RiskLbl);
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema(RiskSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
		verifySchema(RiskSchemaName);
	}
	public String ExpectedClassofBusiness="Professional Indemnity (US)";
	public String ExpectedPublishedDiscription= "Automation Test";
	public void editRiskSchema_3175() throws InterruptedException
	{
		
		refreshPage();
		if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+RiskSchemaName+"')]")).isDisplayed()== true)
		{
			Report.LogInfo("verifyAddedSchema", "verify added schema successfully", "PASS");
			openInEditMode();
			editSchemaDetails();
			verifyeditedSchema("C - Contents Value", ContentValueCheckBox);
			verifyMustExists(ContentsValue,"Contents Value");
			click(ContentsValue,"Contents Value");
			verifyMustExists(RightArrowIcon,"Right Arrow icon");
			click(RightArrowIcon,"Right Arrow icon");
			sleep(3000);
			navigateToSettingsTab();
			TotalValueSelection(TotalValueSelectionDDValue);
			navigateToFieldSelectionTab();
			SaveAndPublish();
			verifyeditedSchema(RiskSchemaName,ExpectedClassofBusiness,ExpectedPublishedDiscription);	
		}else{
			Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
		}

	}

	public void addPremiumSchema_3176() throws InterruptedException
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifySchemaSection(PremiumLbl);
		verifyAddschemabutton(AddPremiumBtn);
		clickonAddSchemabutton(AddPremiumBtn);
		addSchema(PremiumSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
		verifySchema(PremiumSchemaName);
	}
 
	public void editPremiumSchema_3177() throws InterruptedException
	{
		 ExpectedClassofBusiness="Professional Indemnity (US)";
		 ExpectedPublishedDiscription= "Automation Test";
		if(isVisible(AddSchemaPageErrorMsg)==true)
		{
			Report.LogInfo("verifyerrorMessage", "Error message displayed,Premiun Schema not added successfully", "Fail");
		}else
		{
			if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+PremiumSchemaName+"')]")).isDisplayed()== true)
			{
				Report.LogInfo("verifyAddedSchema", "verify added schema successfully", "PASS");
				openInEditMode();
				if(isVisible(EditPageErrorMsg)==true)
				{
					Report.LogInfo("verifyerrorMessage", "Error message displayed on edit Schema page", "FAIL");	
				}else{
					editSchemaDetails();
					verifyMustExists(NoteValue,"Note value");
					click(NoteValue,"Note value");
					verifyMustExists(RightArrowIcon,"Right Arrow icon");
					click(RightArrowIcon,"Right Arrow icon");
					SaveAndPublish();
					verifyeditedSchema(PremiumSchemaName,ExpectedClassofBusiness,ExpectedPublishedDiscription);
				}
			}else{
				Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
			}

		}

	}

	public void addClaimSchema_3178() throws InterruptedException
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifySchemaSection(ClaimLbl);
		verifyAddschemabutton(AddClaimBtn);
		clickonAddSchemabutton(AddClaimBtn);
		addSchema(ClaimSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
		verifySchema(ClaimSchemaName);
	}

	public void editClaimSchema_3179() throws InterruptedException
	{
		if(isVisible(AddSchemaPageErrorMsg)==true)
		{
			Report.LogInfo("verifyerrorMessage", "Error message displayed,Claim Schema not added successfully", "Fail");
		}else
		{
			if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+ClaimSchemaName+"')]")).isDisplayed()== true)
			{
				Report.LogInfo("verifyAddedSchema", "verify added schema successfully", "PASS");
				openInEditMode();
				if(isVisible(EditPageErrorMsg)==true)
				{
					Report.LogInfo("verifyerrorMessage", "Error message displayed on edit Schema page", "FAIL");	
				}else{
					editSchemaDetails();
					SaveAndPublish();
					verifyeditedSchema(ClaimSchemaName,ExpectedClassofBusiness,ExpectedPublishedDiscription);
				}
			}else{
				Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
			}

		}
	}
	
	
	public void editClaimSchema() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		sleep(2000);
		openInEditMode();
		SavePublish = getTextFrom(SaveAndPublishBtn);
		Report.LogInfo("Save and Publish button", SavePublish, "PASS");
		click(SaveAndPublishBtn,"Save and Publish button");	
		verifyMustExists(PublishDescriptionTxt,"Publish Description textbox");
		sendKeys(PublishDescriptionTxt,"ClaimSchema","Publish Description textbox");	
		verifyMustExists(PublishBtn,"Publish button");
		click(PublishBtn,"Publish button");
		sleep(2000);
		
		
	}
	public void AddSchema_Risk(String RiskSchemaName) throws Exception{
		
		
	    String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		BordereauQuePage QuePage = new BordereauQuePage();
		homePage.adminMenu();
		schemaLink();
		schemapage();
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema1(RiskSchemaName,SchemaTypeDDTechnology,SchemaTypeDDValue);
		sleep(3000);
		scrollUp();
		editSchemaAndPublish("Risk_schema", TotalInsurableChk);
		scrollUp();
	}


	//3937 Multiple Rule Condition - Data is Not valid if the rule conditions are met
		public void multipleRuleConditionDataNotValid_3937() throws Exception
		{
			Rules rule = new Rules();
			PolicyPage policy = new PolicyPage();
			String RiskSchemaName = "Schema Rule 3 Test"+getCurrentDateTimeMS();
			AddSchema_Risk(RiskSchemaName);
			scrollUp();
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Multiple Condition Rule - Method Or .And (Not valid) Error Identified", "Building Year Built  Equal to  1960 And Location Number Of Buildings Between 50 to 99 Or Risk Inception Date Not Equal To  01/02/2018", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
			Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			YearBuiltRule();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			SelectDropDownValue1(policy.MethodDD,policy.AndValue);
			NumberOfBuildings();
			click(policy.CheckBtn,"Check button");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			SelectDropDownValue1(policy.MethodDD,OrValue);
			riskInceptionDate();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			SAVE =  getTextFrom(policy.SaveBtn);	
			Report.LogInfo("Save button", SAVE, "PASS");
			click(policy.SaveBtn,"Save button");

			QuePage.sheetProcessingFirstSheet4(RiskSchemaName);
			//QuePage.sheetProcessingFirstSheet4("Schema Rule 3 Test171017261018");
			policy.CreateContractwithInceptionDate2018();
//			Br.applyFilterPolicy("996920JG");
//			Br.openSelectedPolicy();
			
			BordereauProcessPage BordereauProcess = new BordereauProcessPage();

			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"996920JG"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			String IncDate = "01/01/2018";
			String subSheet = "Automation Risk Format 1 (Lloyd's Property Schema)";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//policy.navigationOnBordereauxTab();
			BordereauProcess.SubmitBordereaux(IncDate);
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3937Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_3937.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection allSheets = new StringSelection(allSheetsPath);
			File excelFile = new File(sheet3937Path);
			policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
			//System.out.println(contractId);
			
			String Ufname = "S68226520181003.xlsx";	
			int size = 17948;
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "1", 2018);
	     //String payload = GeneratePayloadForContract(policy.contractId, "3964cedc-cebe-4f33-be17-aef014f4e821", ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			BordereauProcess.refreshUploadedFile();
			String MultipleConditionRule= "@xpath=//*[@id='dataType_Id']//h2[contains(.,'Multiple Condition Rule - Method Or .And (Not valid) Error Identified Error')]";
			

			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
			{
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
				sleep(2000);
				if(isVisible(MultipleConditionRule)== true){
					ErrorPageValidate =  getTextFrom(MultipleConditionRule);
					
					if(isVisible(Br.SkippAllErroBtn2)== true && isEnable(Br.SkippAllErroBtn2)==true){
						Br.clickOnSkipAllErrorBTN2();
						sleep(2000);
						
						Br.KeyDetailsTAB();
						
					//Key details Error Count	
					String ErrorCountKeyDetails= Br.KeyDetailsErrorCount();
					if(ErrorCountKeyDetails.contentEquals("1"))
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					//Navigate to Processing TAB 
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);
					//Processing tab error Count 
					String ErrorCountProcessingTAB = Br.ProcessingTabErrorCount();
					if(ErrorCountProcessingTAB.contentEquals("1"))
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					Br.openDATALink();
					Br.navigateToDATARiskTab();
					sleep(2000);
					Br.ViewErrorRecordsToggle();
					
					String RiskInceptionDate ="@xpath=//tr[1]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Inception Date')]";
					String LocationNumberOfBuildings ="@xpath=//tr[1]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Number Of Buildings')]";
					String LocationYearBuilt="@xpath=//tr[1]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Year Built')]";
					
					verifyMustExists(RiskInceptionDate,"Risk Inception date value in red color");
					verifyMustExists(LocationNumberOfBuildings,"Location Number Of Buildings value in red color");
					verifyMustExists(LocationYearBuilt,"Location Year Built value in red color");
					
					//Navigate TO Bordereaux Processing Tab 
					Br.Bordereaux_TAB();
					Br.navigateOnProcessingTab();
					Br.ReviewErrorClick_ProcessingTAB();
					Br.ErrorsAndWarningTAB();
					Br.ResolveErrorClick_ErrorsAndWarningTAB();
						
					}
					else{
						Report.LogInfo("Skip all error button", "Expected Skip All Error button not displayed or button is not clickable", "FAIL");
					}
					
					sleep(2000);
					verifyMustExists(Data0,"V4");
					sendKeys(Data0,"1961","L4");
					sleep(2000);
					verifyMustExists(Data_1,"W4");
					sendKeys(Data_1,"49","W4");
					sleep(2000);
					verifyMustExists(Data2,"D4");
					sendKeys(Data2,"01/02/2018","D4");
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");

					sleep(2000);
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);

					Br.openDATALink();
					Br.navigateToDATARiskTab();
					
					String RiskInceptionDate ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Inception Date')]";
					String LocationNumberOfBuildings ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Number Of Buildings')]";
					String LocationYearBuilt="@xpath=//tr[3]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Year Built')]";
					
					verifyMustExists(RiskInceptionDate,"Risk Inception date value in Green color");
					verifyMustExists(LocationNumberOfBuildings,"Location Number Of Buildings value in Green color");
					verifyMustExists(LocationYearBuilt,"Location Year Built value in Green color");
					
					Br.Bordereaux_TAB();
					Br.navigateOnProcessingTab();
					
					
					if(isVisible(BordereauProcess.ReviewBtn)==true)
					{
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
						BordereauProcess.deleteBorderEAUX();
					}
					else
					{
						BordereauProcess.refreshUploadedFile();
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						BordereauProcess.deleteBorderEAUX();
					}				
				}	else
				{
					Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
					goBack();
					BordereauProcess.deleteBorderEAUX();				
				}
			}
			else
			{
				Report.LogInfo("ReviewErrorStatusValidation", "Status not changed to Review Error", "FAIL");
				BordereauProcess.deleteBorderEAUX();				
			}
		}

		//3938 Multiple Rule Condition - Data is valid if the rule conditions are met
		public void multipleRuleConditionDataIsValid_3938() throws Exception
		{
			
		//	String RiskSchemaName =  "Schema Rule 4 Test181109031046";
			
			
			Rules rule = new Rules();
			PolicyPage policy = new PolicyPage();
		    String RiskSchemaName = "Schema Rule 4 Test"+getCurrentDateTimeMS1();
			String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
			String SchemaTypeDDTermLife = "@xpath=//li[contains(.,'Term Life')]";
			BordereauQuePage QuePage = new BordereauQuePage();
		    homePage.adminMenu();
			schemaLink();
			schemapage();
			verifyAddschemabutton(AddRiskBtn);
			clickonAddSchemabutton(AddRiskBtn);
			addSchema1(RiskSchemaName,SchemaTypeDDTermLife,SchemaTypeDDValue);
			sleep(3000);
			editSchemaAndPublish("Schema Rule 4 Test", TotalInsurableChk);
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");		
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Multiple Condition Rule - Method And, Or(Valid) Error Identified", " Location Number Of Buildings Greater Than Value 55 And A - Buildings Value Contains Value 100 Or Location Year Built Not Equal To Value 1960", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
			Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			LocationNoBuildingsValue("55");
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");	
			SelectDropDownValue1(policy.MethodDD,policy.AndValue);
			LocationSprinklersValue();
			click(policy.CheckBtn,"Check button");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			SelectDropDownValue1(policy.MethodDD,OrValue);
			LocationYearBuiltValue1();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			SAVE =  getTextFrom(policy.SaveBtn);	
			Report.LogInfo("Save button", SAVE, "PASS");

			click(policy.SaveBtn,"Save button");
			
			QuePage.sheetProcessingFirstSheet5(RiskSchemaName);
		//	QuePage.sheetProcessingFirstSheet5("Schema Rule 4 Test181035251640");
			
			policy.CreateContractwithInceptionDate2018();
			policy.navigateToReportingChannelsTab();
			policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
			//Br.applyFilterPolicy("644766LZ");
			//Br.openSelectedPolicy();
			
			
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"644766LZ"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			BordereauProcess.SubmitBordereaux(IncDate);
			//policy.navigationOnBordereauxTab();
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3938Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_3938.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection allSheets = new StringSelection(allSheetsPath);
			File excelFile = new File(sheet3938Path);
			policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
			//System.out.println(contractId);
			
			String Ufname = "S19250820181003.xlsx";	
			int size = 18020;
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "4", 2018);
	       // String payload = GeneratePayloadForContract(policy.contractId, "7ea8d52b-97e3-4507-b2f6-8fbfc1da681c", ID, Ufname, size, 1 , "4", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			String MultipleConditionRule= "@xpath=//*[@id='dataType_Id']//h2[contains(.,'Multiple Condition Rule - Method And, Or(Valid) Error Identified')]";

			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewBtn)==true)
			{
				Report.LogInfo("ReviewStatusValidation", "Status changed to Review", "PASS");
				
				sleep(2000);
				Br.KeyDetailsTAB();
				
				//Key details Error Count	
				String WarningCountKeyDetails= Br.KeyDetailsWarningCount();
				if(WarningCountKeyDetails.contentEquals("2"))
				{
					Report.LogInfo("KeyDetailsWarningCountValidation", "Error count matched as Expected.", "PASS");
				}
				else
				{
					Report.LogInfo("KeyDetailsWarningCountValidation", "Error count not matched as Expected", "FAIL");
				}
				
				sleep(2000);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");
				sleep(2000);
				//Processing Tab Warning Count 
				String WarningCountProcessingTAB = Br.ProcessingTabWarningCount();
				if(WarningCountProcessingTAB.contentEquals("2"))
				{
					Report.LogInfo("ProcessingTabWarnngCountValidation", "Warning count matched as Expected.", "PASS");
				}
				else
				{
					Report.LogInfo("ProcessingTabWarnngCountValidation", "Warning count not matched as Expected", "FAIL");
				}
				
				Br.openDATALink();
				Br.navigateToDATARiskTab();
				
				
				String Location_Sprinklers4  ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Sprinklers (Y/N)')]";
				String Location_Sprinklers5  ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Sprinklers (Y/N)')]";
				
				String Location_Number_Of_Buildings4  ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Number Of Buildings')]";
				String Location_Number_Of_Buildings5  ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Number Of Buildings')]";
				
				String Location_Year_Built4  ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Year Built')]";
				String Location_Year_Built5  ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Year Built')]";
				
				verifyMustExists(Location_Sprinklers4,"Location Sprinklers (Y/N) value in red color");
				verifyMustExists(Location_Sprinklers5,"Location Sprinklers (Y/N) value in red color");
				verifyMustExists(Location_Number_Of_Buildings4,"Location Number Of Buildings value in red color");
				verifyMustExists(Location_Number_Of_Buildings5,"Location Number Of Buildings value in red color");
				verifyMustExists(Location_Year_Built4,"Location Year Built value in red color");
				verifyMustExists(Location_Year_Built5,"Location Year Built value in red color");
				
				Br.Bordereaux_TAB();
				Br.navigateOnProcessingTab();
				Br.ReviewClick_ProcessingTAB();
				Br.ErrorsAndWarningTAB();
				Br.ResolveErrorClick_ErrorsAndWarningTAB();
				
				sleep(2000);
				if(isVisible(MultipleConditionRule)== true)
				{
					ErrorPageValidate  =  getTextFrom(MultipleConditionRule);
					Report.LogInfo("Erro Screen dispalyed", PageValidate, "PASS");
					 
					//error 1 resolve
					verifyMustExists(Data0,"W6");
					sendKeys(Data0,"66","W6");
					sleep(2000);
					SelectDropDownValue1(Data1DD,NoValue);
					//SelectDropDownValue(Data11,"No");
					sleep(2000);
					verifyMustExists(Data2,"V6");
					sendKeys(Data2,"1977","V6");
					sleep(1000);
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
					
					sleep(2000);
					if(isVisible(Br.SkippAllErroBtn2)== true && isEnable(Br.SkippAllErroBtn2)==true){
						Br.clickOnSkipAllErrorBTN2();
						sleep(2000);
						
						Br.KeyDetailsTAB();
						
						//Key details Error Count	
						String WarningCountKeyDetails1= Br.KeyDetailsWarningCount();
						if(WarningCountKeyDetails1.contentEquals("1"))
						{
							Report.LogInfo("KeyDetailsWarningCountValidation", "warning count matched as Expected.", "PASS");
						}
						else
						{
							Report.LogInfo("KeyDetailsWarningCountValidation", "warning count not matched as Expected", "FAIL");
						}
						
						sleep(2000);
						verifyMustExists(CancelBtn,"Cancel button");
						click(CancelBtn,"Cancel button");
						sleep(2000);
						//Processing Tab Warning Count 
						String WarningCountProcessingTAB1 = Br.ProcessingTabWarningCount();
						if(WarningCountProcessingTAB1.contentEquals("1"))
						{
							Report.LogInfo("ProcessingTabWarnngCountValidation", "Warning count matched as Expected.", "PASS");
						}
						else
						{
							Report.LogInfo("ProcessingTabWarnngCountValidation", "Warning count not matched as Expected", "FAIL");
						}
						
						
						Br.Bordereaux_TAB();
						Br.navigateOnProcessingTab();
						Br.ReviewClick_ProcessingTAB();
						Br.ErrorsAndWarningTAB();
						Br.ResolveErrorClick_ErrorsAndWarningTAB();
						
						
						verifyMustExists(Data0,"W5");
						sendKeys(Data0,"69","W5");
						sleep(2000);
						SelectDropDownValue1(Data1DD,NoValue);
						sleep(2000);
						verifyMustExists(Data2,"V5");
						sendKeys(Data2,"1979","V5");
						
						verifyMustExists(ContinueBtn,"Continue button");
						click(ContinueBtn,"Continue button");
						sleep(2000);
						verifyMustExists(CancelBtn,"Cancel button");
						click(CancelBtn,"Cancel button");
						sleep(2000);
						
						
						
						
						Br.openDATALink();
						Br.navigateToDATARiskTab();
						
						
						String Location_Sprinklers4_1  ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Sprinklers (Y/N)')]";
						String Location_Sprinklers5_1  ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Sprinklers (Y/N)')]";
						
						String Location_Number_Of_Buildings4_1  ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Number Of Buildings')]";
						String Location_Number_Of_Buildings5_1  ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Number Of Buildings')]";
						
						String Location_Year_Built4_1  ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Year Built')]";
						String Location_Year_Built5_1  ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Year Built')]";
						
						verifyMustExists(Location_Sprinklers4_1,"Location Sprinklers (Y/N) value in green color");
						verifyMustExists(Location_Sprinklers5_1,"Location Sprinklers (Y/N) value in green color");
						verifyMustExists(Location_Number_Of_Buildings4_1,"Location Number Of Buildings value in green color");
						verifyMustExists(Location_Number_Of_Buildings5_1,"Location Number Of Buildings value in green color");
						verifyMustExists(Location_Year_Built4_1,"Location Year Built value in green color");
						verifyMustExists(Location_Year_Built5_1,"Location Year Built value in green color");
						
						
						
						Br.Bordereaux_TAB();
						Br.navigateOnProcessingTab();
						
						
					}
					else{
						Report.LogInfo("Skip all error button", "Expected Skip All Error button not displayed or button is not clickable", "FAIL");
					}
					
					if(isVisible(BordereauProcess.ReviewBtn)==true)
					{
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
						BordereauProcess.deleteBorderEAUX();
					}
					else
					{
						BordereauProcess.refreshUploadedFile();
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						BordereauProcess.deleteBorderEAUX();
					}				
				}
				else
				{
					Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
					goBack();
					BordereauProcess.deleteBorderEAUX();				
				}
				
				
				
				
			}
			else
			{
				Report.LogInfo("ReviewStatusValidation", "Status not changed to Review ", "FAIL");
				BordereauProcess.deleteBorderEAUX();				
			}

		}


		//3849 Multiple Rule Condition - Data is valid if the rule conditions are met
		public void singleRuleConditionDataNotValid_3849() throws Exception
		{
			
			Rules rule = new Rules();
			PolicyPage policy = new PolicyPage();
			//String RiskSchemaName = "Schema Rule Test180639121606";
			String RiskSchemaName = "Schema Rule 5 Test"+getCurrentDateTimeMS1();;
			System.out.println(RiskSchemaName);
			
			String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
			String SchemaTypeDDProperty = "@xpath=//li[contains(.,'Property D&F (US binder)')]";
			BordereauQuePage QuePage = new BordereauQuePage();
			homePage.adminMenu();
			schemaLink();
			schemapage();
			verifyAddschemabutton(AddRiskBtn);
			clickonAddSchemabutton(AddRiskBtn);
			addSchema1(RiskSchemaName,SchemaTypeDDProperty,SchemaTypeDDValue);
			sleep(3000);
			editSchemaAndPublish("Schema rule", TotalInsurableChk);
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	

			
			//Rule 1
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition Not Equal to Operator (Not Valid) Error Identified", "Risk Currency Not Equal To USD", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
			Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//scrollDown();
			riskCurrency();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			SAVE = getTextFrom(policy.SaveBtn);
			Report.LogInfo("Save button", SAVE, "PASS");
			click(policy.SaveBtn,"Save button");

			//Rule 2
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Less than or equal to Operator (Not Valid)Error identified", " Risk Expiry Date  Less Than Or Equal To  Value 02/03/2018", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//netPremiumLessThanOrEqual("100");
			expairydateLessThanOrEqual("02/03/2018");
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 3
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Contains operator(Not valid) Identified error", "Risk Postal Code Contains 879", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			riskPostalCode("879");
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 4
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Not Between operator(Not valid) Identified error", "Risk Inception Date Not Between 01/02/2018 to 10/12/2018", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			riskInceptionDateNotBetween2();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 5
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Is Blank  operator(Not valid) Identified error", " Fiscal Code Is Blank", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			FiscalCodeValueIsBlank();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 6
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Equal to operator(Not valid) Identified error", "Location Sprinklers (Y/N) Equal to Yes", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			sprinklers1();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 7
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			//rule.AddSchemaRule1("Single Rule Condition - Not Between operator(Not valid) Identified error", "Building Value Not Between 300 to 500", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
			rule.AddSchemaRule1("Single Rule Condition - Is Not Blank operator(Not valid) Identified error", "Fiscal Code  Is Not Blank", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//buildingsValue("300.00","500.00");
			FiscalValueIsNotBlank();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");
			
			
			//Rule 8
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Between operator(Not valid) Identified error", "Location Year Built Between Value 1960 AND 1970", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//totalInsuranceValue("8000000");
			LocationYearBuiltBetween("1960","1970");
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 9
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Greater than operator(Not valid) Identified error", "Location Number Of Buildings Greater Than Value 50", RiskSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//totalInsuranceValue("8000000");
			LocationNoBuildingsValue("50");
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");
			

		    QuePage.sheetProcessingFirstSheet1(RiskSchemaName);
		   // QuePage.sheetProcessingFirstSheet1("Schema Rule 5 Test181009262333");
			policy.CreateContractwithInceptionDate2018();
//			Br.applyFilterPolicy("476323YQ");
//			Br.openSelectedPolicy();	
			
			
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"476323YQ"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			String subSheet = "Bordereau Processing (kruthika test schema)";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			BordereauProcess.SubmitBordereaux(IncDate);
			
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3849Path = fpath+"\\src\\test\\resources\\testdata\\Schema rule_3849.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection allSheets = new StringSelection(allSheetsPath);
			File excelFile = new File(sheet3849Path);
			policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
			//System.out.println(contractId);
			
			String Ufname = "S47241520181108.xlsx";	
			int size = 18899;
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	      String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "1", 2018);
	      //  String payload = GeneratePayloadForContract(policy.contractId, "913a32e2-ab8d-4184-9a96-44e9894d04ac", ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Schema rule_3849.xlsx\",\"UniqueFileName\":\"S14615920180512.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S14615920180512.xlsx\",\"Filesize\":18063,\"Path\":null,\"size\":18063,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			String SingleRuleConditionNotEqualToOperator ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition Not Equal to Operator (Not Valid) Error Identified Errors Identified')]";

			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
			{
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
				sleep(2000);
				

				Br.ErrorsAndWarningTAB();
				Br.ResolveErrorClick_ErrorsAndWarningTAB();
				if(isVisible(SingleRuleConditionNotEqualToOperator)== true){
					ErrorPageValidate1 =  getTextFrom(SingleRuleConditionNotEqualToOperator);
					
					
					if(isVisible(Br.SkippAllErroBtn2)== true && isEnable(Br.SkippAllErroBtn2)==true){
						Br.clickOnSkipAllErrorBTN2();
						sleep(2000);
						
						Br.KeyDetailsTAB();
					
						System.out.println("===================================Step 01 Started ============================================");
					//Step 1	
					//Key details Error Count	
					String ErrorCountKeyDetails= Br.KeyDetailsErrorCount();
					String WarningCountKeyDetails= Br.KeyDetailsWarningCount();
					
					
					if(ErrorCountKeyDetails.contentEquals("8"))
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountKeyDetails.contentEquals("11"))
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					System.out.println("===================================Step 02 Started ============================================");
					//Step 2
					//Navigate to Processing TAB 
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);
					//Processing tab error Count 
					String ErrorCountProcessingTAB = Br.ProcessingTabErrorCount();
					String WarningCountProcessingTAB = Br.ProcessingTabWarningCount();
					if(ErrorCountProcessingTAB.contentEquals("8"))
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountProcessingTAB.contentEquals("11"))
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					
					System.out.println("===================================Step 03 Started ============================================");
					//Step 3
					Br.openDATALink();
					Br.navigateToDATARiskTab();
					sleep(2000);
					Br.ViewErrorRecordsToggle();
					
					String RiskInceptionDate1 ="@xpath=//tr[1]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Inception Date')]";
					String RiskInceptionDate2 ="@xpath=//tr[2]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Inception Date')]";
					String RiskInceptionDate3 ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Inception Date')]";
					String RiskInceptionDate4 ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Inception Date')]";
					
					String RiskExpirationDate1 ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Expiry Date')]";
					String RiskExpirationDate2 ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Expiry Date')]";
					
					String RiskPostalZipCode1 ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Postal/Zip Code')]";
					String RiskPostalZipCode2 ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Postal/Zip Code')]";
					
					String RiskCurrency1 ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Currency')]";
					String RiskCurrency2 ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Risk Currency')]";
					
					String FiscalCodeValue1="@xpath=//tr[1]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue2="@xpath=//tr[2]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue3="@xpath=//tr[3]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue4="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue5="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Fiscal Code')]";
					
					String LocationSprinkler1="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Sprinklers (Y/N)')]";
					
					String LocationNumberOfBuildings1="@xpath=//tr[4]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Number Of Buildings')]";
					String LocationNumberOfBuildings2="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Number Of Buildings')]";
					
					String LocationYearBuilt1="@xpath=//tr[5]//td[contains(@ng-click,'bgm-red') and contains(@ng-click,'Location Year Built')]";
					
				
					
					verifyMustExists(RiskInceptionDate1,"Risk Inception date value in red color");
					verifyMustExists(RiskInceptionDate2,"Risk Inception date value in red color");
					verifyMustExists(RiskInceptionDate3,"Risk Inception date value in red color");
					verifyMustExists(RiskInceptionDate4,"Risk Inception date value in red color");
					
					verifyMustExists(RiskExpirationDate1,"Risk Expiration date value in red color");
					verifyMustExists(RiskExpirationDate2,"Risk Expiration date value in red color");
					
					verifyMustExists(RiskPostalZipCode1,"Risk Risk Postal Zip Code value in red color");
					verifyMustExists(RiskPostalZipCode2,"Risk Risk Postal Zip Code value in red color");
					
					verifyMustExists(RiskCurrency1,"Risk Currency value in red color");
					verifyMustExists(RiskCurrency2,"Risk Currency value in red color");
					
					verifyMustExists(FiscalCodeValue1,"Fiscal Code Value1in red color");
					verifyMustExists(FiscalCodeValue2,"Fiscal Code Value1in red color");
					verifyMustExists(FiscalCodeValue3,"Fiscal Code Value1in red color");
					verifyMustExists(FiscalCodeValue4,"Fiscal Code Value1in red color");
					verifyMustExists(FiscalCodeValue5,"Fiscal Code Value1in red color");
					
					verifyMustExists(LocationSprinkler1,"Location Sprinkler value in red color");
					
					verifyMustExists(LocationNumberOfBuildings1,"Location Number Of Buildings value in red color");
					verifyMustExists(LocationNumberOfBuildings2,"Location Number Of Buildings value in red color");
					
					verifyMustExists(LocationYearBuilt1,"Location Year Built value in red color");
					
					
					
					//Navigate TO Bordereaux Processing Tab 
					Br.Bordereaux_TAB();
					Br.navigateOnProcessingTab();
					Br.ReviewErrorClick_ProcessingTAB();
					Br.ErrorsAndWarningTAB();
					Br.ResolveErrorClick_ErrorsAndWarningTAB();
					
					System.out.println("===================================Step 04 Started ============================================");
					
					
				
					
					SelectDropDownValue1(Data0DD,USDValue);
					SelectDropDownValue1(Data1DD,USDValue);
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error2 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Less than or equal to Operator (Not Valid)Error identified Errors Identified')]";
					if(isVisible(Error2)== true){
						ErrorPageValidate2 =  getTextFrom(Error2);
					}
					verifyMustExists(Data0,"E4");
					sendKeys(Data0,"03/04/2018","E4");
					verifyMustExists(Data_1,"E5");
					sendKeys(Data_1,"03/04/2018","E5");
					click(ContinueBtn,"Continue button");
					sleep(2000);
					
					Br.clickOnSkipAllErrorBTN2();
					sleep(2000);
					
					Br.KeyDetailsTAB();
					
					System.out.println("===================================Step 05 Started ============================================");	
					//Step1
					//Key details Error Count	
					String ErrorCountKeyDetails1= Br.KeyDetailsErrorCount();
					String WarningCountKeyDetails1= Br.KeyDetailsWarningCount();
					
					
					if(ErrorCountKeyDetails1.contentEquals("8"))
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountKeyDetails1.contentEquals("7"))
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					//Step2
					//Navigate to Processing TAB 
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);
					//Processing tab error Count 
					String ErrorCountProcessingTAB1 = Br.ProcessingTabErrorCount();
					String WarningCountProcessingTAB1 = Br.ProcessingTabWarningCount();
					if(ErrorCountProcessingTAB1.contentEquals("8"))
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountProcessingTAB1.contentEquals("7"))
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					
					System.out.println("===================================Step 06 Started ============================================");
					//Navigate TO Bordereaux Processing Tab 
					Br.Bordereaux_TAB();
					Br.navigateOnProcessingTab();
					Br.ReviewErrorClick_ProcessingTAB();
					Br.ErrorsAndWarningTAB();
					Br.ResolveErrorClick_ErrorsAndWarningTAB();
					
					String Error3 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Contains operator(Not valid) Identified error Errors Identified')]";
					if(isVisible(Error3)== true){
						ErrorPageValidate3 =  getTextFrom(Error3);
					}
					
					verifyMustExists(Data0,"G5");
					sendKeys(Data0,"SW12 87","G5");
					verifyMustExists(Data_1,"G6");
					sendKeys(Data_1,"SW12 87","G6");
					click(ContinueBtn,"Continue button");
					sleep(2000);
					
					String Error4 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Not Between operator(Not valid) Identified error Errors Identified')]";
					if(isVisible(Error4)== true){
						ErrorPageValidate4 =  getTextFrom(Error4);
					}

					verifyMustExists(Data0,"D2");
					sendKeys(Data0,"01/06/2018","D2");
					verifyMustExists(Data_1,"D3");
					sendKeys(Data_1,"01/06/2018","D3");
					verifyMustExists(Data2,"D4");
					sendKeys(Data2,"01/06/2018","D4");
					verifyMustExists(Data3,"D5");
					sendKeys(Data3,"01/06/2018","D5");	
					click(ContinueBtn,"Continue button");
					sleep(2000);
	     
					String Error5 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Is Blank  operator(Not valid) Identified error Errors Identified')]";
					if(isVisible(Error5)== true){
						ErrorPageValidate5 =  getTextFrom(Error5);
					}
					verifyMustExists(Data0,"Q6");
					sendKeys(Data0,"66","Q6");
					click(ContinueBtn,"Continue button");
					sleep(2000);
					
					
					
					Br.clickOnSkipAllErrorBTN2();
					sleep(2000);
					
					Br.KeyDetailsTAB();
					
					System.out.println("===================================Step 07 Started ============================================");	
					//Step1
					//Key details Error Count	
					String ErrorCountKeyDetails2= Br.KeyDetailsErrorCount();
					String WarningCountKeyDetails2= Br.KeyDetailsWarningCount();
					
					
					if(ErrorCountKeyDetails2.contentEquals("8"))
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountKeyDetails2.contentEquals("0"))
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					//Step2
					//Navigate to Processing TAB 
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);
					//Processing tab error Count 
					String ErrorCountProcessingTAB2 = Br.ProcessingTabErrorCount();
					String WarningCountProcessingTABZero ="@xpath=//div[2]/table/tbody/tr/td[11]";
					String WarningCountProcessingTAB2 = getTextFrom(WarningCountProcessingTABZero);
					
					if(ErrorCountProcessingTAB2.contentEquals("8"))
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountProcessingTAB2.contentEquals("0"))
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					System.out.println("===================================Step 08 Started ============================================");
					//Navigate TO Bordereaux Processing Tab 
					Br.Bordereaux_TAB();
					Br.navigateOnProcessingTab();
					Br.ReviewErrorClick_ProcessingTAB();
					Br.ErrorsAndWarningTAB();
					Br.ResolveErrorClick_ErrorsAndWarningTAB();
					
					String Error6 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Equal to operator(Not valid) Identified error Errors Identified')]";
					if(isVisible(Error6)== true){
						ErrorPageValidate6 =  getTextFrom(Error6);
					}

					SelectDropDownValue1(Data0DD,NoValue);
					click(ContinueBtn,"Continue button");
					sleep(2000);
					
					String Error7 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Is Not Blank operator(Not valid) Identified error Errors Identified')]";
					if(isVisible(Error7)== true){
						ErrorPageValidate7 =  getTextFrom(Error7);
					}
					
					verifyMustExists(Data0,"Q2");
					clearTextBox(Data0);
					verifyMustExists(Data_1,"Q3");
					clearTextBox(Data_1);
					verifyMustExists(Data2,"Q4");
					clearTextBox(Data2);
					verifyMustExists(Data3,"Q5");
					clearTextBox(Data3);
					click(ContinueBtn,"Continue button");
					sleep(2000);
					
					
					Br.clickOnSkipAllErrorBTN2();
					sleep(2000);
					
					Br.KeyDetailsTAB();
					
					System.out.println("===================================Step 09 Started ============================================");	
					//Step1
					//Key details Error Count	
					String ErrorCountKeyDetails3= Br.KeyDetailsErrorCount();
					String WarningCountKeyDetails3= Br.KeyDetailsWarningCount();
					
					
					if(ErrorCountKeyDetails3.contentEquals("3"))
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountKeyDetails3.contentEquals("0"))
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					//Step2
					//Navigate to Processing TAB 
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);
					//Processing tab error Count 
					String ErrorCountProcessingTAB3 = Br.ProcessingTabErrorCount();
					String WarningCountProcessingTAB3 = getTextFrom(WarningCountProcessingTABZero);
					if(ErrorCountProcessingTAB3.contentEquals("3"))
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountProcessingTAB3.contentEquals("0"))
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					

					
					System.out.println("===================================Step 10 Started ============================================");
					//Navigate TO Bordereaux Processing Tab 
					Br.Bordereaux_TAB();
					Br.navigateOnProcessingTab();
					Br.ReviewErrorClick_ProcessingTAB();
					Br.ErrorsAndWarningTAB();
					Br.ResolveErrorClick_ErrorsAndWarningTAB();
					
					String Error8 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Between operator(Not valid) Identified error Errors Identified')]";
					if(isVisible(Error8)== true){
						ErrorPageValidate8 =  getTextFrom(Error8);
					}
					

					verifyMustExists(Data0,"V6");
					sendKeys(Data0,"1971","L3");
					click(ContinueBtn,"Continue button");
					sleep(2000);			
					
					String Error9 ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Single Rule Condition - Greater than operator(Not valid) Identified error Errors Identified')]";
					if(isVisible(Error9)== true){
						ErrorPageValidate9 =  getTextFrom(Error9);
					}
					
					verifyMustExists(Data0,"W5");
					sendKeys(Data0,"15","W5");
					verifyMustExists(Data_1,"W6");
					sendKeys(Data_1,"10","W6");
					click(ContinueBtn,"Continue button");
					sleep(3000);

					
					System.out.println("===================================Step 11 Started ============================================");	
					//Step1
					//Key details Error Count	
					
					
					String ErrorCountKeyDetails4= Br.KeyDetailsErrorCount();
					String WarningCountKeyDetails4= Br.KeyDetailsWarningCount();
					
					
					if(ErrorCountKeyDetails4.contentEquals("0"))
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountKeyDetails4.contentEquals("0"))
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					
					//Step2
					//Navigate to Processing TAB 
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);
					//Processing tab error Count 
					String ErrorCountProcessingTABZero="@xpath=//div[2]/table/tbody/tr/td[10]";
					String ErrorCountProcessingTAB4 = getTextFrom(ErrorCountProcessingTABZero);
					String WarningCountProcessingTAB4 = getTextFrom(WarningCountProcessingTABZero);
					if(ErrorCountProcessingTAB4.contentEquals("0"))
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabErrorCountValidation", "Error count not matched as Expected", "FAIL");
					}
					
					if(WarningCountProcessingTAB4.contentEquals("0"))
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count matched as Expected.", "PASS");
					}
					else
					{
						Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count not matched as Expected", "FAIL");
					}
					

					System.out.println("===================================Step 12 Started ============================================");
					//Step 3
					Br.openDATALink();
					Br.navigateToDATARiskTab();
					sleep(2000);
					
					String RiskInceptionDate1_ ="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Inception Date')]";
					String RiskInceptionDate2_ ="@xpath=//tr[2]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Inception Date')]";
					String RiskInceptionDate3_ ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Inception Date')]";
					String RiskInceptionDate4_ ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Inception Date')]";
					
					String RiskExpirationDate1_ ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Expiry Date')]";
					String RiskExpirationDate2_ ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Expiry Date')]";
					
					String RiskPostalZipCode1_ ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Postal/Zip Code')]";
					String RiskPostalZipCode2_ ="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Postal/Zip Code')]";
					
					String RiskCurrency1_ ="@xpath=//tr[3]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Currency')]";
					String RiskCurrency2_ ="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Risk Currency')]";
					
					String FiscalCodeValue1_="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue2_="@xpath=//tr[2]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue3_="@xpath=//tr[3]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue4_="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Fiscal Code')]";
					String FiscalCodeValue5_="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Fiscal Code')]";
					
					String LocationSprinkler1_="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Sprinklers (Y/N)')]";
					
					String LocationNumberOfBuildings1_="@xpath=//tr[4]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Number Of Buildings')]";
					String LocationNumberOfBuildings2_="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Number Of Buildings')]";
					
					String LocationYearBuilt1_="@xpath=//tr[5]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Location Year Built')]";
					
				
					
					verifyMustExists(RiskInceptionDate1_,"Risk Inception date value in green color");
					verifyMustExists(RiskInceptionDate2_,"Risk Inception date value in green color");
					verifyMustExists(RiskInceptionDate3_,"Risk Inception date value in green color");
					verifyMustExists(RiskInceptionDate4_,"Risk Inception date value in green color");
					
					verifyMustExists(RiskExpirationDate1_,"Risk Expiration date value in green color");
					verifyMustExists(RiskExpirationDate2_,"Risk Expiration date value in green color");
					
					verifyMustExists(RiskPostalZipCode1_,"Risk Risk Postal Zip Code value in green color");
					verifyMustExists(RiskPostalZipCode2_,"Risk Risk Postal Zip Code value in green color");
					
					verifyMustExists(RiskCurrency1_,"Risk Currency value in green color");
					verifyMustExists(RiskCurrency2_,"Risk Currency value in green color");
					
					verifyMustExists(FiscalCodeValue1_,"Fiscal Code value in green color");
					verifyMustExists(FiscalCodeValue2_,"Fiscal Code value in green color");
					verifyMustExists(FiscalCodeValue3_,"Fiscal Code value in green color");
					verifyMustExists(FiscalCodeValue4_,"Fiscal Code value in green color");
					verifyMustExists(FiscalCodeValue5_,"Fiscal Code value in green color");
					
					verifyMustExists(LocationSprinkler1_,"Location Sprinkler value in green color");
					
					verifyMustExists(LocationNumberOfBuildings1_,"Location Number Of Buildings value in green color");
					verifyMustExists(LocationNumberOfBuildings2_,"Location Number Of Buildings value in green color");
					
					verifyMustExists(LocationYearBuilt1_,"Location Year Built value in green color");
					
				
					}
					else{
						Report.LogInfo("Skip all error button", "Expected Skip All Error button not displayed or button is not clickable", "FAIL");
					}
					
					
					
					
					//revert to Upload to Test  discard error scenario's
					System.out.println("================Step13================");
					
					Br.RevertToUpload(QuePage.questionnaireName_3849);
					
					
					System.out.println("================Step14================");
					
					if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
					{
						Br.KeyDetailsTAB();
						Br.ErrorsAndWarningTAB();
						
						String DiscardRecords1 = "@xpath=//table/tbody/tr[1]/td[5]";
						String DiscardRecords5 = "@xpath=//table/tbody/tr[5]/td[5]";
						String DiscardRecords6 = "@xpath=//table/tbody/tr[6]/td[5]";
						String DiscardRecords9 = "@xpath=//table/tbody/tr[9]/td[5]";
						
						String RestoreRecords1 = "@xpath=//table/tbody/tr[1]/td[5]/button[contains(.,'Restore')]";
						String RestoreRecords5 = "@xpath=//table/tbody/tr[5]/td[5]/button[contains(.,'Restore')]";
						String RestoreRecords6 = "@xpath=//table/tbody/tr[6]/td[5]/button[contains(.,'Restore')]";
						String RestoreRecords9 = "@xpath=//table/tbody/tr[9]/td[5]/button[contains(.,'Restore')]";
						
						//discard warning record 1
						verifyMustExists(DiscardRecords1,"Discard warning record 1");
						click(DiscardRecords1);
						sleep(2000);
						
						//restore warning record 1
						verifyMustExists(RestoreRecords1,"Restore warning record 1");
						click(RestoreRecords1);
						sleep(2000);
						
						//discard warning record 1
						verifyMustExists(DiscardRecords1,"Discard warning record 1");
						click(DiscardRecords1);
						sleep(2000);
						
						//discard warning record 5
						verifyMustExists(DiscardRecords5,"Discard warning record 5");
						click(DiscardRecords5);
						sleep(2000);
						
						//discard Error record 6
						verifyMustExists(DiscardRecords6,"Discard Error record 6");
						click(DiscardRecords6);
						sleep(2000);
						
						//Restore  Error record 6
						verifyMustExists(RestoreRecords6,"Restore Error record 6");
						click(RestoreRecords6);
						sleep(2000);
						
						//discard Error record 6
						verifyMustExists(DiscardRecords6,"Discard Error record 6");
						click(DiscardRecords6);
						sleep(2000);
						
						//discard Error record 9
						verifyMustExists(DiscardRecords9,"Discard Error record 9");
						click(DiscardRecords9);
						sleep(2000);
						
						
						
						
						
						Br.KeyDetailsTAB();
						
						
						System.out.println("===================================Step  15 Started ============================================");	
						//Step15 - validate count
						//Key details Error Count	
						String ErrorCountKeyDetails1= Br.KeyDetailsErrorCount();
						String WarningCountKeyDetails1= Br.KeyDetailsWarningCount();
						
						
						if(ErrorCountKeyDetails1.contentEquals("2"))
						{
							Report.LogInfo("KeyDetailsErrorCountValidation", "Error count matched as Expected.", "PASS");
						}
						else
						{
							Report.LogInfo("KeyDetailsErrorCountValidation", "Error count not matched as Expected", "FAIL");
						}
						
						if(WarningCountKeyDetails1.contentEquals("2"))
						{
							Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count matched as Expected.", "PASS");
						}
						else
						{
							Report.LogInfo("KeyDetailsWarningCountValidation", "Warning count not matched as Expected", "FAIL");
						}
						
						//Step2
						//Navigate to Processing TAB 
						verifyMustExists(CancelBtn,"Cancel button");
						click(CancelBtn,"Cancel button");
						sleep(2000);
						//Processing tab error Count 
						String ErrorCountProcessingTAB1 = Br.ProcessingTabErrorCount();
						String WarningCountProcessingTAB1 = Br.ProcessingTabWarningCount();
						if(ErrorCountProcessingTAB1.contentEquals("2"))
						{
							Report.LogInfo("ProcessingTabErrorCountValidation", "Error count matched as Expected.", "PASS");
						}
						else
						{
							Report.LogInfo("ProcessingTabErrorCountValidation", "Error count not matched as Expected", "FAIL");
						}
						
						if(WarningCountProcessingTAB1.contentEquals("2"))
						{
							Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count matched as Expected.", "PASS");
						}
						else
						{
							Report.LogInfo("ProcessingTabWarningCountValidation", "Warning count not matched as Expected", "FAIL");
						}
						
						

						System.out.println("================Step16==============");
						
						//Step 16 Validate  discarded records
						Br.openDATALink();
						Br.navigateToDATARiskTab();
						Br.ViewDiscardedRecordsToggle();
						
						String RiskReference3 ="@xpath=//tr[1]//td[text()='3' and contains(@ng-click,'Risk Reference')]";
						String RiskReference4 ="@xpath=//tr[2]//td[text()='4' and contains(@ng-click,'Risk Reference')]";
						String RiskReference5 ="@xpath=//tr[3]//td[text()='5' and contains(@ng-click,'Risk Reference')]";
						
						Br.mouseMoveOn(RiskReference3);
						Br.verifyMustExists(RiskReference3,"Discarded record with risk reference 3");
						
						Br.mouseMoveOn(RiskReference4);
						Br.verifyMustExists(RiskReference4,"Discarded record with risk reference 4");
						
						Br.mouseMoveOn(RiskReference5);
						Br.verifyMustExists(RiskReference5,"Discarded record with risk reference 5");
						
						System.out.println("================Step 17==================");
						Br.Bordereaux_TAB();
						Br.navigateOnProcessingTab();
						sleep(2000);
						if(isVisible(Br.ReviewError)==true)
						{
							AssertBordereauStatusReviewError =  getTextFrom(BordereauProcess.ReviewError);							
							Report.LogInfo("Validate review  status after discard Error & warning", "Status changed to Review Error .", "PASS");
						}
						else
						{
							Report.LogInfo("Validate review  status after discard Error & warning", "Status not changed to Review Error", "FAIL");
						}
						
					}
					else
					{
						Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
					}
					
				}
				else
				{
					Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
					goBack();
					BordereauProcess.deleteBorderEAUX();				
				}
			}
			else
			{
				Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
				BordereauProcess.deleteBorderEAUX();				
			}
		}

		//3850 Schema Rules - single rule condition - data is valid if the rule conditions are met
		public void singleRuleConditionDataIsValid_3850() throws Exception
		{
			Rules rule = new Rules();
			PolicyPage policy = new PolicyPage();
			String RiskSchemaName = "Schema Rule 6 Test"+getCurrentDateTimeMS1();

			String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
			String SchemaTypeDDProperty = "@xpath=//li[contains(.,'Property D&F (US binder)')]";
			BordereauQuePage QuePage = new BordereauQuePage();
			homePage.adminMenu();
			schemaLink();
			schemapage();
			verifyAddschemabutton(AddRiskBtn);
			clickonAddSchemabutton(AddRiskBtn);
			addSchema1(RiskSchemaName,SchemaTypeDDProperty,SchemaTypeDDValue);
			sleep(3000);
			editSchemaAndPublish("Schema Rule 2 Test", TotalInsurableChk);

			
			
			//Rule 1
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition Between Operator (Valid) Error Identified", "Location Number Of Buildings Between Value 50 AND 99", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
			Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			NumberOfBuildings();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			SAVE =  getTextFrom(policy.SaveBtn);	
			Report.LogInfo("Save button", SAVE, "PASS");
			click(policy.SaveBtn,"Save button");

			//Rule 2
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);	
			rule.AddSchemaRule1("Single Rule Condition - Contains Operator or (Valid)Error identified", "Risk Postal Code contains 9", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			riskPostalCode("9");
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 3
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Equal to operator(Valid) Identified error", "Location Sprinklers (Y/N) Equal to Yes", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			sprinklersYes();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 4
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition -  Not Equal To  operator(Valid) Identified error", "Risk currency not Equal to USD", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//riskCurrency();
			riskCurrency();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 5
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Is Blank Operator (Valid) Identified error", "Insured Address Is Blank", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			insuredAddress();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 6
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Greater Than Or Equal  to operator(Valid) Identified error", "Risk Expairy Date Greater Than Or Equal To 09/09/2018", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//grossPremium();
			riskExparydate();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 7
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Less than operator(Valid) Identified error", "Location Number Of Buildings Less Than Value 98", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//netPremium();
			LNoOfBuilding();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 8
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Not Between operator (Valid) Identified error", "Risk Inception Not Between 01/02/2018 to 10/10/2018", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			riskInceptionDateNotBetween();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			//Rule 9
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");	
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Single Rule Condition - Is Not Blank Operator(Valid) Identified error", "A - Buildings Value Is Not Blank", RiskSchemaName, "Warning", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			//totalInsuranceValue("1000000");
			buildingsValue();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			click(policy.SaveBtn,"Save button");

			QuePage.sheetProcessingFirstSheet2(RiskSchemaName);
			//QuePage.sheetProcessingFirstSheet2("Schema Rule 6 Test181036221523");
			
			policy.CreateContractwithInceptionDate2018();
			policy.navigateToReportingChannelsTab();
			policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
			//Br.applyFilterPolicy("236559SU");
			//Br.openSelectedPolicy();

			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"236559SU"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			BordereauProcess.SubmitBordereaux(IncDate);
			
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3850Path = fpath+"\\src\\test\\resources\\testdata\\Schemarule2_3850.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection allSheets = new StringSelection(allSheetsPath);
			File excelFile = new File(sheet3850Path);
			policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
			//System.out.println(contractId);
			
			String Ufname = "S73805120181003.xlsx";	
			int size = 24498;
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "4", 2018);
	        //String payload = GeneratePayloadForContract(policy.contractId, "95bf156d-92f8-4dd5-b83b-7535e27a2071", ID, Ufname, size, 1 , "4", 2018);
	        addAsDraft(payload,DraftUrl);
			
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Schemarule2_3850.xlsx\",\"UniqueFileName\":\"S15471520180513.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15471520180513.xlsx\",\"Filesize\":24496,\"Path\":null,\"size\":24496,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordereauProcess.refreshUploadedFile();
			if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
			{
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
				String SingleRuleConditionBetweenOperator ="@xpath=//h2[contains(.,'Single Rule Condition Between Operator (Valid) Error Identified Errors Identified')]";
				sleep(2000);
				if(isVisible(SingleRuleConditionBetweenOperator)== true){
					ErrorPageValidate1 =  getTextFrom(SingleRuleConditionBetweenOperator);
					
					verifyMustExists(Data0,"W2");
					sendKeys(Data0,"55","W2");
					sleep(2000);
					verifyMustExists(Data_1,"W6");
					sendKeys(Data_1,"55","W6");	
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error2 ="@xpath=//h2[contains(.,'Single Rule Condition - Contains Operator or (Valid)Error identified Errors Identified')]";
					sleep(2000);
					if(isVisible(Error2)== true){
						ErrorPageValidate2 =  getTextFrom(Error2);
					}
					
					verifyMustExists(Data0,"G2");
					sendKeys(Data0,"SW12 9","G2");
					verifyMustExists(Data_1,"G3");
					sendKeys(Data_1,"SW12 9","G3");	
					verifyMustExists(Data2,"G4");
					sendKeys(Data2,"SW12 9","G4");
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error3 ="@xpath=//h2[contains(.,'Single Rule Condition - Equal to operator(Valid) Identified error Errors Identified')]";
					sleep(2000);
					if(isVisible(Error3)== true){
						ErrorPageValidate3 =  getTextFrom(Error3);
					}
					
					SelectDropDownValue1(Data0DD,YesValue);
					SelectDropDownValue1(Data1DD,YesValue);
					SelectDropDownValue1(Data2DD,YesValue);
					SelectDropDownValue1(Data3DD,YesValue);
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error4 ="@xpath=//h2[contains(.,'Single Rule Condition -  Not Equal To  operator(Valid) Identified error Errors Identified')]";
					sleep(2000);
					if(isVisible(Error4)== true){
						ErrorPageValidate4 =  getTextFrom(Error4);
					}
					
					SelectDropDownValue1(Data0DD,AFNValue);
					SelectDropDownValue1(Data1DD,EURValue);
					SelectDropDownValue1(Data2DD,GBPValue);
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error5 ="@xpath=//h2[contains(.,'Single Rule Condition - Is Blank Operator (Valid) Identified error Errors Identified')]";
					sleep(2000);
					if(isVisible(Error5)== true){
						ErrorPageValidate5 =  getTextFrom(Error5);
					}
					verifyMustExists(Data0,"F3");
					clearTextBox(Data0);
					verifyMustExists(Data_1,"F4");
					clearTextBox(Data_1);	
					verifyMustExists(Data2,"F5");
					clearTextBox(Data2);
					verifyMustExists(Data3,"F6");
					clearTextBox(Data3);
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error6 ="@xpath=//h2[contains(.,'Single Rule Condition - Greater Than Or Equal  to operator(Valid) Identified error Errors Identified')]";
					sleep(2000);
					if(isVisible(Error6)== true){
						ErrorPageValidate6 =  getTextFrom(Error6);
					}
						
					verifyMustExists(Data0,"E3");
					sendKeys(Data0,"03/10/2018","E3");
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error7 ="@xpath=//h2[contains(.,'Single Rule Condition - Less than operator(Valid) Identified error Errors Identified')]";
					sleep(2000);
					if(isVisible(Error7)== true){
						ErrorPageValidate7 =  getTextFrom(Error7);
					}
					
					verifyMustExists(Data0,"W4");
					sendKeys(Data0,"5","W4");
					sleep(2000);
					verifyMustExists(Data_1,"W5");
					sendKeys(Data_1,"5","W5");	
					click(ContinueBtn,"Continue button");
					sleep(2000);

					String Error8 ="@xpath=//h2[contains(.,'Single Rule Condition - Not Between operator (Valid) Identified error Errors Identified')]";
					sleep(2000);
					if(isVisible(Error8)== true){
						ErrorPageValidate8 =  getTextFrom(Error8);
					}
					verifyMustExists(Data0,"D6");
					sendKeys(Data0,"01/01/2017","D6");
					click(ContinueBtn,"Continue button");
					sleep(2000);

//					verifyMustExists(Data0,"Q5");
//					sendKeys(Data0,"55","Q5");
//					verifyMustExists(Data_1,"Q6");
//					sendKeys(Data_1,"55","Q6");	
//					click(ContinueBtn,"Continue button");
//					sleep(2000);

					
					verifyMustExists(CancelBtn,"Cancel button");
					click(CancelBtn,"Cancel button");
					sleep(2000);

					if(isVisible(BordereauProcess.ReviewBtn)==true)
					{
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
						BordereauProcess.deleteBorderEAUX();
					}
					else
					{
						BordereauProcess.refreshUploadedFile();
						verifyExists(BordereauProcess.ReviewBtn,"Review button");
						BordereauProcess.deleteBorderEAUX();
					}				
				}
				else
				{
					Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
					goBack();
					BordereauProcess.deleteBorderEAUX();				
				}
			}
			else
			{
				Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
				BordereauProcess.deleteBorderEAUX();				
			}
		}
	
		
		
		
		//3603  
				public void SingleRuleCondition_3603() throws Exception
				{

					Rules rule = new Rules();
					PolicyPage policy = new PolicyPage();
					String RiskSchemaName = "Schema Rule 7 Test"+getCurrentDateTimeMS1();

					String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
					String SchemaTypeDDProperty = "@xpath=//li[contains(.,'Property D&F (US binder)')]";
					BordereauQuePage QuePage = new BordereauQuePage();
					homePage.adminMenu();
					schemaLink();
					schemapage();
					verifyAddschemabutton(AddRiskBtn);
					clickonAddSchemabutton(AddRiskBtn);
					addSchema1(RiskSchemaName,SchemaTypeDDProperty,SchemaTypeDDValue);
					sleep(3000);
					editSchemaAndPublish("Schema Rule 7 Test", TotalInsurableChk);

					//String RiskSchemaName="Schema Rule 7 Test181027271406";
					
					//Rule 1
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition Equal to  Operator (Valid) Error Identified", "Risk Inception date - Equal To Endorsement effective date", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
					Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					riskInceptionDate1();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					SAVE =  getTextFrom(policy.SaveBtn);	
					Report.LogInfo("Save button", SAVE, "PASS");
					click(policy.SaveBtn,"Save button");

					//Rule 2
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);	
					rule.AddSchemaRule1("Single Rule Condition - Not Equal To Operator(Valid) Error identified", "Location Year built -  Not Equal to Field Location Number of buildings", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					LocationYearBuiltValue2();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");

					//Rule 3
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition - Equal to operator(Valid) Identified error", "Insured Name Equal to Insured Address", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					InsuredName();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");

					//Rule 4
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition -  Risk Expiry date Equal To operator(Valid) Identified error", "Risk Expiry date Equal to Risk Issuance date", RiskSchemaName, "Warning", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					RiskExpiryDate();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");

					//Rule 5
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition - Equal To Operator (Valid) Identified error", "Location Sprinkler value NO", RiskSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					LocationSprinklersValue1();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");

					//String RiskSchemaName="Schema Rule 7 Test181212121450";
					QuePage.addNewQuestionnaireTC3603(RiskSchemaName);
					
					policy.CreateContractwithInceptionDate2018();
					policy.navigateToReportingChannelsTab();
					policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
//					Br.applyFilterPolicy("320555TG");
//					Br.openSelectedPolicy();

					String GetData = Configuration.url+"/api/Contract/GetAllPage";
					String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
					//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"320555TG"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
					String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
					String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
					String IncDate = "01/01/2018";
					BordereauProcess.SubmitBordereaux(IncDate);
					
					//QuePage.BFormatId;
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet3850Path = fpath+"\\src\\test\\resources\\testdata\\Schemarule_3603_1.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//StringSelection allSheets = new StringSelection(allSheetsPath);
					File excelFile = new File(sheet3850Path);
					policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
					//System.out.println(contractId);
					
					String Ufname = "S72770420181212.xlsx";	
					int size = 25750;
			        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
			        String ID = extractIDFromResponseinsideContract(response); 
			        String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "4", 2018);
			       //String payload = GeneratePayloadForContract(policy.contractId, "bfdcfa01-ff70-479c-bb71-68c208eb3497", ID, Ufname, size, 1 , "4", 2018);
			        addAsDraft(payload,DraftUrl);
					
					//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Schemarule2_3850.xlsx\",\"UniqueFileName\":\"S15471520180513.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15471520180513.xlsx\",\"Filesize\":24496,\"Path\":null,\"size\":24496,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
					BordereauProcess.refreshUploadedFile();
					if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
					{
						Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
						if(isVisible(Br.MissingColumns)==true)
						{
							verifyMustExists(Br.ContinueProc, "Contniue processing Button");
							click(Br.ContinueProc,"Continue button");
							String newcolumn = "@xpath=//h2[text()='New Columns Identified']";
							sleep(3000);
							//temporary added due to bug. 3718 - Start
							if(isVisible(newcolumn)==true)
							{
								verifyMustExists(Br.ContinueProc1, "Contniue processing Button");
								click(Br.ContinueProc1,"Continue button");
							}
							//temporary added due to bug. 3718  - END
							
							Br.refreshUploadedFile();
							
							if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
							{
								String SingleRuleConditionEqualToOperator ="@xpath=//h2[contains(.,'Single Rule Condition Equal to  Operator (Valid) Error Identified Errors Identified')]";
								sleep(2000);
								if(isVisible(SingleRuleConditionEqualToOperator)== true){
									ErrorPageValidate1 =  getTextFrom(SingleRuleConditionEqualToOperator);
									
									verifyMustExists(Data0,"D2");
									sendKeys(Data0,"04/01/2018","D2");
									sleep(2000);
									verifyMustExists(Data_1,"W6");
									sendKeys(Data_1,"03/02/2018","W6");	
									click(ContinueBtn,"Continue button");
									sleep(2000);

									
									String Error2 ="@xpath=//h2[contains(.,'Single Rule Condition - Not Equal To Operator(Valid) Error identified Errors Identified')]";
									sleep(2000);
									if(isVisible(Error2)== true){
										ErrorPageValidate2 =  getTextFrom(Error2);
									}
										
									verifyMustExists(Data0,"W2");
									sendKeys(Data0,"1902","W2");
									click(ContinueBtn,"Continue button");
									sleep(2000);
									
									String Error3 ="@xpath=//h2[contains(.,'Single Rule Condition - Equal to operator(Valid) Identified error Errors Identified')]";
									sleep(2000);
									if(isVisible(Error3)== true){
										ErrorPageValidate3 =  getTextFrom(Error3);
									}
									
									verifyMustExists(Data0,"B4");
									sendKeys(Data0,"Random Insured","B4");
									sleep(2000);
									verifyMustExists(Data_1,"B5");
									sendKeys(Data_1,"Random Insured","B5");	
									click(ContinueBtn,"Continue button");
									sleep(2000);
									
									String Error4 ="@xpath=//h2[contains(.,'Single Rule Condition -  Risk Expiry date Equal To operator(Valid) Identified error Errors Identified')]";
									sleep(2000);
									if(isVisible(Error4)== true){
										ErrorPageValidate4 =  getTextFrom(Error4);
									}
									
									verifyMustExists(Data0,"B4");
									sendKeys(Data0,"03/12/2018","E2");
									sleep(2000);
									verifyMustExists(Data_1,"B5");
									sendKeys(Data_1,"03/12/2018","E3");	
									click(ContinueBtn,"Continue button");
									sleep(2000);
									
									verifyMustExists(CancelBtn,"Cancel button");
									click(CancelBtn,"Cancel button");
									sleep(2000);
									
									if(isVisible(BordereauProcess.ReviewBtn)==true)
									{
										verifyExists(BordereauProcess.ReviewBtn,"Review button");
										AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
										
										Br.RevertToUpload(QuePage.questionnaireName_3603);
										
										if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
										{
											if(isVisible(Br.MissingColumns)==true)
											{
												verifyMustExists(Br.ContinueProc, "Contniue processing Button");
												click(Br.ContinueProc);
												String newcolumn1 = "@xpath=//h2[text()='New Columns Identified']";
												sleep(3000);
												//temporary added due to bug. 3718 - Start
												if(isVisible(newcolumn1)==true)
												{
													verifyMustExists(Br.ContinueProc1, "Contniue processing Button");
													click(Br.ContinueProc1);
												}
												//temporary added due to bug. 3718  - END
												
												Br.refreshUploadedFile();
											
												if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
												{
													sleep(2000);
													if(isVisible(Br.SkippAllErroBtn2)== true && isEnable(Br.SkippAllErroBtn2)==true){
														Br.clickOnSkipAllErrorBTN2();
														sleep(2000);
														
														Br.KeyDetailsTAB();
														Br.ErrorsAndWarningTAB();
														

														String DiscardRecords1 = "@xpath=//table/tbody/tr[1]/td[5]";
														String DiscardRecords2 = "@xpath=//table/tbody/tr[2]/td[5]";
														String RestoreRecords1 = "@xpath=//table/tbody/tr[1]/td[5]/button[contains(.,'Restore')]";
														String RestoreRecords2 = "@xpath=//table/tbody/tr[2]/td[5]/button[contains(.,'Restore')]";
														
														
														//discard warning record 1
														verifyMustExists(DiscardRecords1,"Discard warning record 1");
														click(DiscardRecords1,"Discard record 1");
														sleep(2000);
														verifyMustExists(RestoreRecords1, "Record successfully discarded");
														//discard warning record 2
														verifyMustExists(DiscardRecords2,"Discard warning record 2");
														click(DiscardRecords2,"Discard record 2");
														sleep(2000);
														verifyMustExists(RestoreRecords2, "Record successfully discarded");
														
														verifyMustExists(CancelBtn,"Cancel button");
														click(CancelBtn,"Cancel button");
														sleep(2000);
														
														if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewBtn)==true)
														{
															Br.KeyDetailsTAB();
															Br.ErrorsAndWarningTAB();
															

															String DiscardRecords3 = "@xpath=//table/tbody/tr[3]/td[5]";
															String DiscardRecords4 = "@xpath=//table/tbody/tr[4]/td[5]";
															String RestoreRecords3 = "@xpath=//table/tbody/tr[3]/td[5]/button[contains(.,'Restore')]";
															String RestoreRecords4 = "@xpath=//table/tbody/tr[4]/td[5]/button[contains(.,'Restore')]";
															
															
															//discard warning record 4
															verifyMustExists(DiscardRecords3,"Discard warning record 3");
															click(DiscardRecords3,"Discard record 3");
															sleep(2000);
															verifyMustExists(RestoreRecords3, "Record successfully discarded");
															//discard warning record 4
															verifyMustExists(DiscardRecords4,"Discard warning record 4");
															click(DiscardRecords4,"Discard record 4");
															sleep(2000);
															verifyMustExists(RestoreRecords4, "Record successfully discarded");
															
															verifyMustExists(CancelBtn,"Cancel button");
															click(CancelBtn,"Cancel button");
															sleep(2000);
															
															
															
															
															
														}
														else
														{
															Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review .", "FAIL");
														}
														
													}
													else{
														Report.LogInfo("Skip all error button", "Expected Skip All Error button not displayed or button is not clickable", "FAIL");
													}
													
													
												}
												else
												{
													Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
												}
											}
											
										else
										{
											Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
										}
										
									}
									else
									{
										BordereauProcess.refreshUploadedFile();
										verifyExists(BordereauProcess.ReviewBtn,"Review button");
									}	
									
								}
								else
								{
									Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
								}
							
							}	
						}
						else
						{
							Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
							goBack();
							BordereauProcess.deleteBorderEAUX();				
						}
					}
					else
					{
						Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review Error.", "FAIL");
						BordereauProcess.deleteBorderEAUX();				
					}
					}
					
		}
						
		//3648
		public void MultipleRuleCondition_TC3648() throws Exception
		{

			Rules rule = new Rules();
			PolicyPage policy = new PolicyPage();
			String ClaimSchemaName = "Schema Rule 9 Test"+getCurrentDateTimeMS1();

			homePage.adminMenu();
			schemaLink();
			schemapage();
			verifySchemaSection(ClaimLbl);
			verifyAddschemabutton(AddClaimBtn);
			clickonAddSchemabutton(AddClaimBtn);
			addSchema(ClaimSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
			verifySchema(ClaimSchemaName);
			sleep(3000);
			editClaimSchema();
					
			
		//	String ClaimSchemaName="Schema Rule 9 Test181233112200";

					
			//Rule 1
			verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
			click(rule.RuleHeaderLink,"Rules Menu Tab");
			SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
			rule.AddSchemaRule1("Multiple Rule Condition - Equal To, Not Equal To , Is Blank, Contains operator [Valid]", "Claim Finance currency Equal To 'GBP' And Date claim made not equal to '01/01/2018' OR LossPostal/Zip Code Contains '9' OR Loss Conuntry equal To 'Albania' And Insured Address is Blank.", ClaimSchemaName, "Mandatory", "Data is valid if the rule conditions are met");
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
			Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			ClaimFinnanceCurrency();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			SelectDropDownValue1(policy.MethodDD,policy.AndValue);
			DateClaimMade();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			SelectDropDownValue1(policy.MethodDD,OrValue);
			LossPostalCode("9");
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			SelectDropDownValue1(policy.MethodDD,OrValue);
			LossCountry();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
			click(policy.AddRuleConditionBtn,"Add Rule Condition button");
			SelectDropDownValue1(policy.MethodDD,policy.AndValue);
			insuredAddress();
			click(policy.CheckBtn,"Check button");
			sleep(2000);
			verifyMustExists(policy.SaveBtn,"Save button");
			SAVE =  getTextFrom(policy.SaveBtn);	
			Report.LogInfo("Save button", SAVE, "PASS");
			click(policy.SaveBtn,"Save button");
			
			
			//String ClaimSchemaName="Schema Rule 9 Test181232121207";
			QuePage.addBordereauFormatClaim_3648(ClaimSchemaName);
		
			
		policy.CreateClaimContractwithInceptionDate2018();
			
		//	Br.applyFilterPolicy("989962GM");
			//Br.openSelectedPolicy();

			String GetData = Configuration.url+"/api/Contract/GetAllPage";
				String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
				//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"989962GM"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			BordereauProcess.SubmitBordereaux(IncDate);
			
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3850Path = fpath+"\\src\\test\\resources\\testdata\\TC_3648.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3850Path);
			policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
			
			String Ufname = "S77789320180929.xlsx";	
			int size = 16135;
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        Report.LogInfo("BFormatId","<b><i>"+QuePage.BFormatId +"</i></b> - Is Clicked Successfully", "INFO");
	         String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "3", 2018);
	         // String payload = GeneratePayloadForContract(policy.contractId, "a3a10fb2-5920-40bf-a05d-bf0d9a9f53ca", ID, Ufname, size, 1 , "3", 2018);
	        addAsDraft(payload,DraftUrl);
			
			BordereauProcess.refreshUploadedFile();
					
					if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
					{
						String SingleRuleConditionEqualToOperator ="@xpath=//h2[contains(.,'Multiple Rule Condition - Equal To, Not Equal To , Is Blank, Contains operator [Valid] Error')]";
						sleep(2000);
						if(isVisible(SingleRuleConditionEqualToOperator)== true){
							ErrorPageValidate =  getTextFrom(SingleRuleConditionEqualToOperator);
							
						SelectDropDownValue(ClaimData0, GBPOption);
						
							verifyMustExists(ClaimData2,"AB2");
							sendKeys(ClaimData2,"04/01/2018","AB2");
							sleep(1000);
							
							verifyMustExists(ClaimData3,"BG2");
							sendKeys(ClaimData3,"348AMR9","BG2");
							sleep(1000);
							
							SelectDropDownValue(ClaimData4, AlbaniyaOption);
							
							verifyMustExists(ClaimData5,"AY2");
							clearTextBox(ClaimData5);
							
							click(ContinueBtn,"Continue button");
							sleep(1000);
							
							
							verifyMustExists(CancelBtn,"Cancel button");
							click(CancelBtn,"Cancel button");
							sleep(2000);
							
							
							if(isVisible(BordereauProcess.ReviewBtn)==true)
							{
								
								sleep(2000);
								verifyExists(BordereauProcess.ReviewBtn,"Review button");
								AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
								Report.LogInfo("Questionnaire Name","<b><i>"+QuePage.BFormatId +"</i></b> - Is Clicked Successfully", "INFO");
								Br.RevertToUpload(QuePage.questionnaireName_3648);
								//Br.RevertToUpload("SP - First Sheet181212121043");
								Br.refreshUploadedFile();
									
							if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
								{
												sleep(2000);
												SelectDropDownValue(ClaimData0, GBPOption);
												
													verifyMustExists(ClaimData2,"AB2");
													sendKeys(ClaimData2,"04/01/2018","AB2");
													sleep(1000);
													
													verifyMustExists(ClaimData5,"AY2");
													clearTextBox(ClaimData5);
													
													click(ContinueBtn,"Continue button");
													sleep(1000);
													
													verifyMustExists(CancelBtn,"Cancel button");
													click(CancelBtn,"Cancel button");
													sleep(2000);
												
												if(isVisible(BordereauProcess.ReviewBtn)==true)
												{
													Report.LogInfo("PartialResolveValidation", "After partial resolve Status changed to Review .", "PASS");
												}
												else
												{
													Report.LogInfo("ReviewStatusVal", "Status not changed to Review .", "FAIL");
												}
											
										}
										else
										{
											Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review error.", "FAIL");
										}
									}
									
								else
								{
									Report.LogInfo("ReviewStatusVal", "Status not changed to Review.", "FAIL");
								}
								}
								else
								{
									Report.LogInfo("ErrorScreenVal", "Expected Error screen not displayed.", "FAIL");
									
								}	
								}
								else
								{
									Report.LogInfo("ReviewStatusVal", "Status not changed to Review error.", "FAIL");
								}	
							
						}
		
		
				//3654  
				public void SingleRuleCondition_TC3654() throws Exception
				{
/*
					Rules rule = new Rules();
					PolicyPage policy = new PolicyPage();
					String ClaimSchemaName = "Schema Rule 10 Test"+getCurrentDateTimeMS1();
		
					homePage.adminMenu();
					schemaLink();
					schemapage();
					verifySchemaSection(ClaimLbl);
					verifyAddschemabutton(AddClaimBtn);
					clickonAddSchemabutton(AddClaimBtn);
					addSchema(ClaimSchemaName,ClassOfBusinessDDValue,SchemaTypeDDValue,CBddValue,STddValue);
					verifySchema(ClaimSchemaName);
					sleep(3000);
					editClaimSchema();

					//String ClaimSchemaName="Schema Rule 10 Test181248112238";
					
				//Rule 1
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition Not Between  Operator (Invalid) Error Identified", "Risk Inception date - Not Between '01/01/2018' AND '01/04/2018'", ClaimSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
					Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					riskInceptionDateNotBetween12();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					SAVE =  getTextFrom(policy.SaveBtn);	
					Report.LogInfo("Save button", SAVE, "PASS");
					click(policy.SaveBtn,"Save button");

					//Rule 2
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);	
					rule.AddSchemaRule1("Single Rule Condition -  Is Blank Operator(InValid) Error identified", "Loss Description  -  Is Blank", ClaimSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					LossDescription();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");

					//Rule 3
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition - Equal to operator(InValid) Identified error", "Loss Country Equal to United States", ClaimSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					LossCountry1();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");

					//Rule 4
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition -  Not Equal To operator(InValid) Identified error", "Claim Finance Currency Not Equal to 'EUR'", ClaimSchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					ClaimFinnanceCurrency1();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");

					//Rule 5
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition - Contains Operator (InValid) Identified error", "Loss postal Code contains value '2'", ClaimSchemaName, "Warning", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					LossPostalCode("2");
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");
		
					//Rule 6
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition - Equal to operator(InValid) Identified error", "Claim Status Equal to 'Open'", ClaimSchemaName, "Warning", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					ClaimStatus();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");
			
					//Rule 7
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition - Equal to operator(InValid) Identified error", "Denial (Y/N) Equal to YES", ClaimSchemaName, "Warning", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					Denial_YN();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");
					
					//Rule 8
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");	
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("Single Rule Condition - Less Than Or Equal To operator(InValid) Identified error", "Date of loss(From) Less Than Or Equal To '03/01/2018'", ClaimSchemaName, "Warning", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					DateOfLossFrom_LessThanOREqualTo();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					click(policy.SaveBtn,"Save button");
						
					QuePage.addBordereauFormatClaim_3648(ClaimSchemaName);
						
					policy.CreateClaimContractwithInceptionDate2018();
					*/
					Br.applyFilterPolicy("996920JG");
					Br.openSelectedPolicy();

					String GetData = Configuration.url+"/api/Contract/GetAllPage";
					//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
					String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"996920JG"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
					String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
					String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
					String IncDate = "01/01/2018";
					BordereauProcess.SubmitBordereaux(IncDate);
					
					//QuePage.BFormatId;
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet3654Path = fpath+"\\src\\test\\resources\\testdata\\TC_3654.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//StringSelection allSheets = new StringSelection(allSheetsPath);
					File excelFile = new File(sheet3654Path);
					policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
					//System.out.println(contractId);
					
					String Ufname = "S67565420180931.xlsx";	
					int size = 16377;
			        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
			        String ID = extractIDFromResponseinsideContract(response); 
			       // String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "3", 2018);
			       String payload = GeneratePayloadForContract(policy.contractId, "6953b6a5-73f7-4346-9a3b-1a128b10cd9f", ID, Ufname, size, 1 , "3", 2018);
			        addAsDraft(payload,DraftUrl);
					
					BordereauProcess.refreshUploadedFile();
					
					if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
					{
						String SingleRuleConditionEqualToOperator ="@xpath=//h2[contains(.,'Single Rule Condition Not Between  Operator (Invalid) Error Identified Errors Identified')]";
						sleep(2000);
						if(isVisible(SingleRuleConditionEqualToOperator)== true){
							ErrorPageValidate1 =  getTextFrom(SingleRuleConditionEqualToOperator);
							
							
							verifyMustExists(Data0,"T2");
							sendKeys(Data0,"05/03/2018","T2");
							sleep(2000);
							verifyMustExists(Data_1,"T3");
							sendKeys(Data_1,"05/03/2018","T3");	
							click(ContinueBtn,"Continue button");
							sleep(2000);

							String Error2 ="@xpath=//h2[contains(.,'Single Rule Condition -  Is Blank Operator(InValid) Error identified Errors Identified')]";
							sleep(2000);
							if(isVisible(Error2)== true){
								ErrorPageValidate2 =  getTextFrom(Error2);
							}
							verifyMustExists(Data0,"W2");
							sendKeys(Data0,"ABCD","W2");
							click(ContinueBtn,"Continue button");
							sleep(2000);
							
							String Error3 ="@xpath=//h2[contains(.,'Single Rule Condition - Equal to operator(InValid) Identified error Errors Identified')]";
							sleep(2000);
							if(isVisible(Error3)== true){
								ErrorPageValidate3 =  getTextFrom(Error3);
							}
							SelectDropDownValue1(Data0DD,SrilankaOption);
							
							SelectDropDownValue1(Data1DD,SrilankaOption2);
							click(ContinueBtn,"Continue button");
							sleep(2000);
							
							String Error4 ="@xpath=//h2[contains(.,'Single Rule Condition -  Not Equal To operator(InValid) Identified error Errors Identified')]";
							sleep(2000);
							if(isVisible(Error4)== true){
								ErrorPageValidate4 =  getTextFrom(Error4);
							}
							/*SelectDropDownValue1(Data0DD,SrilankaOption);
							SelectDropDownValue1(Data1DD,SrilankaOption);
							click(ContinueBtn,"Continue button");
							sleep(2000);*/
							
							
							SelectDropDownValue1(Data0DD,EURValue);
							SelectDropDownValue1(Data1DD,EURValue);
							SelectDropDownValue1(Data2DD,EURValue);
							SelectDropDownValue1(Data3DD,EURValue);
							click(ContinueBtn,"Continue button");
							sleep(2000);
					
							String Error5 ="@xpath=//h2[contains(.,'Single Rule Condition - Contains Operator (InValid) Identified error Errors Identified')]";
							sleep(2000);
							if(isVisible(Error5)== true){
								ErrorPageValidate5 =  getTextFrom(Error5);
							}
							verifyMustExists(Data0,"BG3");
							sendKeys(Data0,"348AMR","BG3");
							sleep(2000);
							verifyMustExists(Data_1,"BG4");
							sendKeys(Data_1,"348AMR","BG4");	
							click(ContinueBtn,"Continue button");
							sleep(2000);
							
							
							String Error6 ="@xpath=//h2[contains(.,'Single Rule Condition - Equal to operator(InValid) Identified error Errors Identified')]";
							sleep(2000);
							if(isVisible(Error6)== true){
								ErrorPageValidate6 =  getTextFrom(Error6);
							}
							SelectDropDownValue1(Data0DD,ClosedOption1);
							SelectDropDownValue1(Data1DD,ClosedOption1);
							SelectDropDownValue1(Data2DD,ClosedOption1);
							click(ContinueBtn,"Continue button");
							sleep(2000);
							
							String Error7 ="@xpath=//h2[contains(.,'Single Rule Condition - Equal to operator(InValid) Identified error Errors Identified')]";
							sleep(2000);
							if(isVisible(Error7)== true){
								ErrorPageValidate7 =  getTextFrom(Error7);
							}
							SelectDropDownValue1(Data0DD,NoValue1);
							SelectDropDownValue1(Data1DD,NoValue1);
							SelectDropDownValue1(Data2DD,NoValue1);
							click(ContinueBtn,"Continue button");
							sleep(2000);
							
							String Error8 ="@xpath=//h2[contains(.,'Single Rule Condition - Less Than Or Equal To operator(InValid) Identified error Errors Identified')]";
							sleep(2000);
							if(isVisible(Error8)== true){
								ErrorPageValidate8 =  getTextFrom(Error8);
							}
							verifyMustExists(Data0,"Z5");
							sendKeys(Data0,"04/01/2018","Z5");
							sleep(2000);
							verifyMustExists(Data_1,"Z6");
							sendKeys(Data_1,"04/01/2018","Z6");	
							click(ContinueBtn,"Continue button");
							sleep(2000);
							
							
							verifyMustExists(CancelBtn,"Cancel button");
							click(CancelBtn,"Cancel button");
							sleep(2000);
						}
							
							else
							{
								Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review error.", "FAIL");
							}

						if(isVisible(BordereauProcess.ReviewBtn)==true)
						{
							
							sleep(2000);
							verifyExists(BordereauProcess.ReviewBtn,"Review button");
							AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
						}
								
							else
							{
								Report.LogInfo("ReviewStatusVal", "Status not changed to Review.", "FAIL");
							}
						
						
						
							
						}
					
				}
				
public void Hybrid_Top_Rule_TC3660() throws Exception{
					
				/*	String COBName = "Automation class of business_181242101009";	
					String SchemaName = "Schema for Compliance Data_181218101218";	*/
					
						
					Rules rule = new Rules();
					DatasetReferenceDataPage refData = new DatasetReferenceDataPage();
					BordereauProcessPage BordereauProcess = new BordereauProcessPage();
					COBName = "Automation class of business_"+getCurrentDateTimeMS1();
					homePage.adminMenu();
					refData.DatasetReferenceDataLink();
					refData.DatasetReferenceDatapage();
					
					//Filter
					applyDataSetFilter("Class of Business");
					verifyMustExists(ClassOfBusinesslabel,"Class Of Business");
					click(ClassOfBusinesslabel,"Class Of Business");
					createClassOfBusiness1(COBName);
					
					homePage.adminMenu();
					schemaLink();
					schemapage();
					String SchemaName = "Schema for Compliance Data_"+getCurrentDateTimeMS();
					String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
					verifyAddschemabutton(AddRiskBtn);
					clickonAddSchemabutton(AddRiskBtn);
					addSchema1(SchemaName,COBName,SchemaTypeDDValue);
					sleep(3000);
					editSchemaAndPublish("Schema for Hybrid Rule", TotalInsurableChk);
					
					
					//Schema Rule
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");		
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("1.Multiple Condition Rule - Method Equal To, Contains (InValid) Error Identified Error", "NAIC Code Contains  value 'ABD'. AND Surplus Filling State Equal to  value 'New South Wales'", SchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
					Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					BuildingValueBetween();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					SelectDropDownValue1(policy.MethodDD,policy.AndValue);
					SurplusLinesFillingStateValueEqualTo("New South Wales");
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					SAVE =  getTextFrom(policy.SaveBtn);	
					Report.LogInfo("Save button", SAVE, "PASS");
					click(policy.SaveBtn,"Save button");
					
					
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");		
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleSchema);
					rule.AddSchemaRule1("2.Multiple Condition Rule - Method Equal , Greater Than (InValid) Error Identified", "Location sprinkler Equal To 'YES' & content value  greater than '1599'", SchemaName, "Mandatory", "Data is not valid if the rule conditions are met");
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
					Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					sprinklersYes();
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					SelectDropDownValue1(policy.MethodDD,policy.AndValue);
					ContentsValueGreaterThan("1599");
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.SaveBtn,"Save button");
					SAVE =  getTextFrom(policy.SaveBtn);	
					Report.LogInfo("Save button", SAVE, "PASS");
					click(policy.SaveBtn,"Save button");
					
					
					//Compliance Data Rule
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleComplianceData);
					rule.AddComplianceDataRule("3.Risk Reference contains '1'","Mandatory field blank", "Risk", "Mandatory", COBName);
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					RiskReferenceContains("1");
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					DatasetSelection4();
					
					verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
					click(rule.RuleHeaderLink,"Rules Menu Tab");
					SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleComplianceData);
					rule.AddComplianceDataRule("4.Risk inception date should be less than 01/06/2018 & Risk Country Equal To 'British Indian Ocean Territory'","Mandatory field blank", "Risk", "Mandatory", COBName);
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					riskInceptionDateLessThan("01/06/2018");
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
					click(policy.AddRuleConditionBtn,"Add Rule Condition button");
					SelectDropDownValue1(policy.MethodDD,policy.AndValue);
					riskcountryEqual1("British Indian Ocean Territory");
					click(policy.CheckBtn,"Check button");
					sleep(2000);
					DatasetSelection5();
				
					QuePage.sheetProcessingFirstSheet6(SchemaName);
						
					
					
						policy.CreateContractwithInceptionDate2018();
						policy.navigateToReportingChannelsTab();
						policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
						
						
//						Br.applyFilterPolicy("880637EN");
//						Br.openSelectedPolicy();

						String GetData = Configuration.url+"/api/Contract/GetAllPage";
						String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
						//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"880637EN"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
						String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
						String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
						String IncDate = "01/01/2018";
						BordereauProcess.SubmitBordereaux(IncDate);
						
						//QuePage.BFormatId;
						try 
						{
							String fpath = new File(".").getCanonicalPath();
							sheet3850Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_3660.xlsx";
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//StringSelection allSheets = new StringSelection(allSheetsPath);
						File excelFile = new File(sheet3850Path);
						policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
						//System.out.println(contractId);
						
						String Ufname = "S91485620181210.xlsx";	
						int size = 19130;
				        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				      String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "4", 2018);
				      //String payload = GeneratePayloadForContract(policy.contractId, "ea48f5aa-a40c-4f56-914a-113284c27485", ID, Ufname, size, 1 , "4", 2018);
				        addAsDraft(payload,DraftUrl);
						
						BordereauProcess.refreshUploadedFile();
								
								if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
								{
									String MultipleRuleConditionEqualToOperator ="@xpath=//h2[contains(.,'1.Multiple Condition Rule - Method Equal To, Contains (InValid) Error Identified Error')]";
									sleep(2000);
									if(isVisible(MultipleRuleConditionEqualToOperator)== true){
										ErrorPageValidate1 =  getTextFrom(MultipleRuleConditionEqualToOperator);
										sleep(3000);
									    
										
										sleep(2000);
										verifyMustExists(Data0,"AC4");
										clearTextBox(Data0);
										sendKeys(Data0,"AD","AC4");
										sleep(2000);
										
										verifyMustExists(ClaimData1, "Country dropDown");
										SelectDropDownValue(ClaimData1, State_Geneva);
										sleep(2000);
										click(ContinueBtn,"Continue button");
										sleep(1000);
										
										String Error2 ="@xpath=//h2[contains(.,'2.Multiple Condition Rule - Method Equal , Greater Than (InValid) Error Identified Error')]";
										sleep(2000);
										if(isVisible(Error2)== true){
											ErrorPageValidate2 =  getTextFrom(Error2);
										}
										
										//Error2
										SelectDropDownValue(ClaimData0, NOOption);
										verifyMustExists(Data_1,"R6");
										clearTextBox(Data_1);
										sendKeys(Data_1,"1599","R6");
										sleep(2000);
										click(ContinueBtn,"Continue button");
										sleep(1000);
									
										String Error3 ="@xpath=//h2[contains(.,'Compliance Data Rule - 3.Risk Reference contains 1 ')]";
										sleep(2000);
										if(isVisible(Error3)== true){
											ErrorPageValidate3 =  getTextFrom(Error3);
										}
										
										//Error3
										verifyMustExists(Data0,"G2");
										sendKeys(Data0,"4565846666665","G2");
										sleep(2000);
										click(ContinueBtn,"Continue button");
										sleep(1000);
										
										
										String Error4 ="@xpath=//h2[contains(.,'Compliance Data Rule - 4.Risk inception date should be less than 01/06/2018 & Risk Country Equal To British Indian Ocean Territory ')]";
										sleep(2000);
										if(isVisible(Error4)== true){
											ErrorPageValidate4 =  getTextFrom(Error4);
										}
										//Error6
										verifyMustExists(ClaimData0, "State dropDown");
										SelectDropDownValue(ClaimData0, State_Geneva);
										click(ContinueBtn,"Continue button");
										sleep(1000);
										
										
										//Error4
										verifyMustExists(Data0,"G2");
										sendKeys(Data0,"4565846666665","G2");
										sleep(2000);
										click(ContinueBtn,"Continue button");
										sleep(1000);
										
										
										//Error5
										verifyMustExists(Data0,"G2");
										sendKeys(Data0,"ABCD","G2");
										sleep(2000);
										click(ContinueBtn,"Continue button");
										sleep(1000);
										
										
										verifyMustExists(CancelBtn,"Cancel button");
										click(CancelBtn,"Cancel button");
										sleep(2000);
										
										
										
										if(isVisible(BordereauProcess.ReviewBtn)==true)
										{
											AssertBordereauStatusReview = getTextFrom(BordereauProcess.ReviewBtn);
											Report.LogInfo("Review status validation", "Review Status displayed", "PASS");
										}
										else
										{
											Report.LogInfo("Review status validation", "Review Status not displayed", "FAIL");
										}
										
										
										
									}
										else{
											Report.LogInfo("ErrorScreenVal", "Expected Error screen not displayed.", "FAIL");
											
											}
									
								}
								else
								{
									Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review error.", "FAIL");
								
									
								}
					
			}
				//3789 Compliance Data Rules - single rule condition - warning and mandatory
	public void complianceDataRulesSingleRuleCondition_3789() throws Exception
	{
		Rules rule = new Rules();
		DatasetReferenceDataPage refData = new DatasetReferenceDataPage();
		BordereauProcessPage BordereauProcess = new BordereauProcessPage();
		COBName = "Automation class of business_"+getCurrentDateTimeMS1();
		homePage.adminMenu();
		refData.DatasetReferenceDataLink();
		refData.DatasetReferenceDatapage();
		
		//Filter
		applyDataSetFilter("Class of Business");
		verifyMustExists(ClassOfBusinesslabel,"Class Of Business");
		click(ClassOfBusinesslabel,"Class Of Business");
		createClassOfBusiness1(COBName);
		
		homePage.adminMenu();
		schemaLink();
		schemapage();
		String SchemaName = "Schema for Compliance Data_"+getCurrentDateTimeMS();
		String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema1(SchemaName,COBName,SchemaTypeDDValue);
		sleep(3000);
		editSchemaAndPublish("Schema for Compliance Rule", TotalInsurableChk);	
		
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleComplianceData);
		rule.AddComplianceDataRule("Risk inception date should be equal to 01/01/2018","Mandatory field blank", "Risk", "Mandatory", COBName);
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskInceptionDateEqual("01/01/2018");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		DatasetSelection2();
	
		QuePage.sheetProcessingFirstSheet4(SchemaName);
		//QuePage.sheetProcessingFirstSheet4("Schema for Compliance Data_361036251018");
		
		policy.CreateContractwithInceptionDate2018();
//		Br.applyFilterPolicy("447910OC");
//		Br.openSelectedPolicy();
		
		String InceptionDate = "01/01/2018";
		
		BordereauProcess.SubmitBordereaux(InceptionDate);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"447910OC"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();

		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3789Path = fpath+"\\src\\test\\resources\\testdata\\velidate_date_ref_precentage_integer_3789.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet3789Path);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		
		
		
		String Ufname = "S47992420181012.xlsx";	
		int size = 20178;
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "1", 2018);
       // String payload = GeneratePayloadForContract(policy.contractId, "19e8cf1e-df79-4d81-b023-c1dcbe6e9b91", ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		BordereauProcess.refreshUploadedFile();
		
		
		String RiskInceptionDate ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Compliance Data Rule - Risk inception date should be equal to 01/01/2018 ')]";
		String X9 ="@xpath=//td[contains(.,'F5')]";
		String F3 ="@xpath=//td[contains(.,'Q3')]";
		String ContinueProcessing ="@xpath=//button[contains(.,'Continue Processing ')]";
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(ContinueProcessing)== true)
			{
				verifyMustExists(ContinueProcessing,"Continue Processing");
				click(ContinueProcessing,"Continue Processing");
				BordereauProcess.refreshUploadedFile();
				BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError);
			}
			
			if(isVisible(RiskInceptionDate)== true)
			{
				if(isVisible(F3)== true)
				{
					verifyMustExists(Data0,"Q3");
					sendKeys(Data0,"1200","Q3");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				else
				{
					verifyMustExists(Data0,"F5");
					sendKeys(Data0,"70 Lower Street","F5");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				
				if(isVisible(X9)== true)
				{
					verifyMustExists(Data0,"F5");
					sendKeys(Data0,"70 Lower Street","F5");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				else
				{
					verifyMustExists(Data0,"Q3");
					sendKeys(Data0,"1200","Q3");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.Cancelbtn1)==true)
				{
					verifyExists(BordereauProcess.Cancelbtn1,"Cancel button");
					click(BordereauProcess.Cancelbtn1,"Cancel button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
					click(BordereauProcess.ReviewBtn,"Review button");
					sleep(2000);
					verifyMustExists(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					click(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.ForApprovalBtn)==true)
				{
					click(BordereauProcess.ForApprovalBtn,"Approval button");
					sleep(2000);
					verifyMustExists(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					click(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					BordereauProcess.refreshUploadedFileApprovedStatus();
					verifyExists(BordereauProcess.ApprvedBtn,"Apprved button");
					sleep(2000);
				}
			}
			}
		    else
		    {
		     Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
		     goBack();
		     BordereauProcess.deleteBorderEAUX();    
		    }
		    sleep(2000);
			policy.navigationOnBordereauxTab();
			//BordereauProcess.SubmitBordereaux(subSheet);
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3789Path1 = fpath+"\\src\\test\\resources\\testdata\\velidate_date_ref_precentage_integer1_3789.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3789Path1);
			

			String Ufname1 = "S69937520181212.xlsx";	
			int size1 = 19689;
	        String response1 = uploadFileinContract(ReqUrl,excelFile1,policy.contractId,Ufname1);
	        String ID1 = extractIDFromResponseinsideContract(response1); 
	        String payload1 = GeneratePayloadForContract(policy.contractId, QuePage.BFormatId, ID1, Ufname1, size1, 2 , "1", 2018);
	        //String payload1 = GeneratePayloadForContract(policy.contractId, "19e8cf1e-df79-4d81-b023-c1dcbe6e9b91", ID1, Ufname1, size1, 2 , "1", 2018);
	        addAsDraft(payload1,DraftUrl);
	        
			BordereauProcess.refreshUploadedFile();
			if(isVisible(BordereauProcess.ReviewBtn)==true)
			{
				 Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			}
			else
			{
				 Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			}
			
			
			
	}

	public void MultipleRuleConditionMandatory_4080() throws Exception
	{
	String SchemaName1 = "Compliance Rule"+getCurrentDateTimeMS();
		String SchemaTypeDDTechnology = "@xpath=//li[contains(.,'Casualty Treaty (Non-US)')]";
		RuleName= "Risk inception date equal to 04/01/2018 and country equal to India"+getCurrentDateTimeMS();
		FilteredRuleNameVerification1= "@xpath=//tr[1]//td[contains(text(),'"+RuleName+"')]";
		String ErrorMessage = "Mandatory fields are blank";
		String Dataset = "Risk";
		String ProcessingAction = "Mandatory";
		String CLassBusiness = "TestComplianceData";
		String FieldName= "Risk Inception Date";
		String OPERATOR = "Equal To";
		String APPLIEDTO = "Value";
		String Date = "04/01/2018";
		String FieldName2= "Risk Country";
		String EntrySelection2 = "British Indian Ocean Territory";
	
		
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		
		
		SelectDropDownValue1(rule.AddRuleDropDown,rule.AddRuleComplianceData);
		rule.AddComplianceDataRule(RuleName,"Mandatory field blank", "Risk", "Mandatory", "All Classes of Business");
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		riskInceptionDateEqual("02/02/2018");
		click(policy.CheckBtn,"Check button");
		
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		SelectDropDownValue1(policy.MethodDD,policy.AndValue);
		riskcountryEqual(EntrySelection2);
		click(policy.CheckBtn,"Check button");
		
		
		DatasetSelection3(); 
					
		String UniqueReferenceVal1 = "Automation Policy_19"+getCurrentDateTimeMS();
		String Status1 = "Draft";
		String InceptionDate1 = "01/01/2018";
		String subSheet = "Automation Risk Format 1 (Lloyd's Property Schema)";
		policy.CreateContractwithInceptionDate2018();
		
//		Br.applyFilterPolicy("387824ZU");
//		Br.openSelectedPolicy();
		 BordereauProcess.SubmitBordereaux(Date);
	  
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"387824ZU"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		sleep(2000);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//QuePage.BFormatId;
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4080Path = fpath+"\\src\\test\\resources\\testdata\\ComplaincedataRule_4080.xlsx";

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet4080Path);
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S91438420181210.xlsx";	
		int size = 18792;
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        //Here using created questionniare
        String payload = GeneratePayloadForContract(policy.contractId, "5cca2e44-2a28-4cdf-ae49-198cb434b638", ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		Br.refreshUploadedFile();
		String C6 ="@xpath=//td[contains(.,'Q3')]";
		String F3 ="@xpath=//td[contains(.,'F6')]";
		String ContinueProcessing ="@xpath=//button[contains(.,'Continue Processing ')]";
		String ErrorScreen ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Compliance Data Rule - Risk inception date equal to 04/01/2018 and country equal to India')]";
		 
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{

			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			
			if(isVisible(ErrorScreen)== true)
			{
				
				
				verifyMustExists(Data0,"F2");
				sendKeys(Data0,"71 Brentwood Avenue","F2");
				
				click(ContinueBtn,"Continue button");
				sleep(2000);
				
				
				verifyMustExists(Data0,"F6");
				sendKeys(Data0,"456585","F6");
				click(ContinueBtn,"Continue button");
				sleep(2000);

				
				if(isVisible(BordereauProcess.Cancelbtn1)==true)
				{
					verifyExists(BordereauProcess.Cancelbtn1,"Cancel button");
					click(BordereauProcess.Cancelbtn1,"Cancel button");
				}
				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					AssertBordereauStatusReview =  getTextFrom(BordereauProcess.ReviewBtn);
					click(BordereauProcess.ReviewBtn,"Review button");
					sleep(2000);
					verifyMustExists(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					click(SubmitPassedWarningRecordsForAssignmentBtn,"Submit Passed Warning Records For Assignment button");
					sleep(2000);
				}
				if(isVisible(BordereauProcess.ForApprovalBtn)==true)
				{
					click(BordereauProcess.ForApprovalBtn,"Approval button");
					sleep(2000);
					verifyMustExists(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					click(BordereauProcess.ApproveBordBtn,"Approve Bordereau button");
					BordereauProcess.refreshUploadedFileApprovedStatus();
					verifyExists(BordereauProcess.ApprvedBtn,"Apprved button");
					sleep(2000);
				}
			}
			}
		    else
		    {
		     Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
		     goBack();
		     BordereauProcess.deleteBorderEAUX();    
		    }
				
	/*		policy.navigationOnBordereauxTab();
			//BordereauProcess.SubmitBordereaux(subSheet);
			//QuePage.BFormatId;
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4080Path1 = fpath+"\\src\\test\\resources\\testdata\\compliance_feb_4080.xlsx";
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4080Path1);
			//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"compliance_feb_4080.xlsx\",\"UniqueFileName\":\"S64343820180102.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S64343820180102.xlsx\",\"Filesize\":19941,\"Path\":null,\"size\":19941,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"compliance_feb_4080.xlsx\",\"UniqueFileName\":\"S46365820180519.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S46365820180519.xlsx\",\"Filesize\":19129,\"Path\":null,\"size\":19129,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
			BordereauProcess.refreshUploadedFile();*/
		    filterRulename(RuleName);
	}
	public void filterRulename(String RuleName)
	{
		String SearchTextFieldRule1 ="@xpath=//ul//li[contains(.,'"+RuleName+"')][1]";
		verifyMustExists(rule.RuleHeaderLink,"Rules Menu Tab");
		click(rule.RuleHeaderLink,"Rules Menu Tab");
		
		waitForElementToAppear(rule.RuleNameFilterIcon,5);
		verifyMustExists(rule.RuleNameFilterIcon ,"Rule Name Filter");
		click(rule.RuleNameFilterIcon,"Rule Name Filter");
		waitForElementToAppear(rule.SearchTextFieldRule,5);
		verifyMustExists(rule.SearchTextFieldRule,"Search textbox");
		sendKeys(rule.SearchTextFieldRule,RuleName,"Search textbox");
		waitForElementToAppear(SearchTextFieldRule1,5);
		verifyMustExists(SearchTextFieldRule1,"RuleName");
		click(SearchTextFieldRule1,"RuleName");
		verifyMustExists(rule.SearchedRuleFilterButton,"Filter button");
		click(rule.SearchedRuleFilterButton,"Filter button");
		// Edit Rule
		waitForElementToAppear(rule.Edit,5);
		verifyMustExists(rule.Edit ,"Edit rule");
		click(rule.Edit,"Edit Rule");
		//InActive Rule
		waitForElementToAppear(rule.InActive,5);
		verifyMustExists(rule.InActive ,"InActive rule");
		click(rule.InActive,"InActive rule");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}

	public void SingleRuleConditionValidContractTab_4044() throws Exception{

		String Status1 = "Draft";
		String subSheet = "Risk Reference Format";
		String InceptionDate1 = "01/01/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS();
		RuleNameInformation = "Single Information Rule"+getCurrentDateTimeMS();
		//System.out.println("Information Rule "+RuleNameInformation);
		FilteredRuleNameVerification= "@xpath=//tr[1]//td[contains(text(),'"+RuleNameInformation+"')]";

		System.out.println("RuleName"+FilteredRuleNameVerification);
		String ErrorMessgae = "Number of Stories 50 to 99";
		String Dataset = "Risk";
		String Schema = "Automation Schema";
		//String MandatoryWarning = "Warning";
		String ApplicationCondition = "Data is valid if the rule conditions are met";
		String FieldName = "Number of Stories";
		String OPERATOR = "Between";
		String APPLIEDTO = "Value";
		String ENTRY_SELECTIONFirst = "50";
		String ENTRY_SELECTIONSecond = "99";

		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate1,policy.Broker1, policy.Bline1, policy.Underline1);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToSigned();
		sleep(2000);
		waitForElementToAppear(RulesMenuTab,5);
		verifyMustExists(RulesMenuTab,"RulesMenuTab");
		click(RulesMenuTab,"RulesMenuTab");
		//selectInformationRule();
		AddInformationRule(RuleNameInformation,ErrorMessgae,Dataset,ApplicationCondition,Schema);
		AddRuleConditionForInformationRule(FieldName,OPERATOR,APPLIEDTO,ENTRY_SELECTIONFirst,ENTRY_SELECTIONSecond);
		String ActualAddedRuleNameSchema = getTextFrom(FilteredRuleNameVerification);
		if(RuleNameInformation.equalsIgnoreCase(ActualAddedRuleNameSchema)){

			Report.LogInfo("ValidateAddedRuleSchema", "Schema Rule added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateAddedRuleSchema", "Schema Rule not added successfully.", "FAIL");

		}
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		sleep(1000);
		Br.SubmitBordereaux(subSheet);
		fileUpload_4044();
		selectBreaches();
	}

	public void CompleteQuestionnairesAgainstSchema_TC5140() throws Exception
	{
		homePage.adminMenu();
		schemaLink();
		schemapage();
		String SchemaName = "Schema for Complete Questionnaires"+getCurrentDateTimeMS();
		String TotalInsurableChk = "@xpath=//label[contains(.,'Total Insurable Value')]";
		verifyAddschemabutton(AddRiskBtn);
		clickonAddSchemabutton(AddRiskBtn);
		addSchema3(RiskSchemaName,ClassOfBusinessDDValue2,SchemaTypeDDValue);
		sleep(3000);
		scrollUp();
		openInEditMode();
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		sleep(1000);
		//Add building value to schema
		verifyeditedSchema("A - Buildings Value", BuildingsValuecheckbox1);
		verifyMustExists(BuildingsValue,"Buiding value");
		click(BuildingsValue,"Building value");
	    verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		//Add content value to schema
		verifyeditedSchema("C - Contents Value", ContentValueCheckBox);
		verifyMustExists(ContentsValue,"Contents Value");
		click(ContentsValue,"Contents Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Sprinklers (Y/N)", LocationSprinklersCheckBox);
		verifyMustExists(Sprinklers,"Location Sprinklers (Y/N)");
		click(Sprinklers,"Location Sprinklers (Y/N)");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Number of Buildings", NoOfBuildingscheckbox);
		verifyMustExists(NumberOfBuildings,"Number of Buildings");
		click(NumberOfBuildings,"Number of Buildings");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Year Built", BuildingYearBuiltcheckbox);
		verifyMustExists(BuildingYearBuilt,"Building Year Built");
		click(BuildingYearBuilt,"Building Year Built");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Scheme", ConstructionSchemecheckbox);
		verifyMustExists(OccupancyScheme,"Occupancy Scheme");
		click(OccupancyScheme,"Occupancy Scheme");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Code", ConstructionCodecheckbox);
		verifyMustExists(OccupancyCode,"Occupancy Code");
		click(OccupancyCode,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Description", ConstructionDescriptioncheckbox);		
		verifyMustExists(OccupancyDescription,"Occupancy Description");
		click(OccupancyDescription,"Occupancy Description");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Total Insurable Value", TotalInsurableChk);
		verifyMustExists(TotalInsurableValue,"Total Insured Value");
		click(TotalInsurableValue,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		sleep(3000);
		javaScriptclick(CancellationDateChkBox,"Cancellation Date ChkBox");
		sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor)webDriver;
		jse1.executeScript("scroll(0, -250);");
		//scrollDown();
		javaScriptclick(ContentValueChkBox,"Content Value ChkBox");
		sleep(1000);
		javaScriptclick(SpinklersChkBox,"Spinklers ChkBox");
		sleep(1000);
		//javaScriptclick(NumberOFStoriesChkBox,"Number Of Stories ChkBox");
	//	javaScriptclick(NumberOFBuildingsChkBox,"Number Of Stories ChkBox");
		sleep(1000);
		scrollUp();
		verifyMustExists(SettingsTab,"Settings Tab");
		click(SettingsTab,"Settings Tab");	
		verifyMustExists(TotalValueDD,"Total Value dropdown");
		click(TotalValueDD,"Total Value dropdown");	
		verifyMustExists(TotalValueDDValue,"Total Insurable Value option");
		click(TotalValueDDValue,"Total Insurable Value option");	
		verifyMustExists(SaveAndPublishBtn,"Save and Publish button");
		SavePublish = getTextFrom(SaveAndPublishBtn);
		click(SaveAndPublishBtn,"Save and Publish button");	
		sleep(2000);
		verifyMustExists(PublishDescriptionTxt,"Publish Description textbox");
		sendKeys(PublishDescriptionTxt,"Information 2 Schema","Publish Description textbox");	
		verifyMustExists(PublishBtn,"Publish button");
		click(PublishBtn,"Publish button");
		sleep(2000);
		homePage.adminMenu();
		QuePage.bordereauQueLink();
		QuePage.bordereauQuePage();
		QuePage.firstSheetProcess11(RiskSchemaName);
		
	}
	public void ReProcessFileUsingMandatoryFields_TC5141() throws Exception
	{
		String SprinklersDrag = "@xpath=//button[text()='Sprinklers']";
		String SprinklersDrop = "@xpath=//td[contains(.,'Location Sprinklers (Y/N)')]//preceding-sibling::td/div/div";
		
		String  subSheet= QuePage.QuestionnaireName_TC5141;
		//String  subSheet= "SP - All Sheet(s)180321184056";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
	
		BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
		BordereauProcess.openSelectedPolicy();
		
		BordereauProcess.SubmitBordereaux(subSheet);
	
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5141Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC5141.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5141Path);  
	//	contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		contractId = "6883d64d-9f43-49d5-b520-209bcb54cfd4";
		String Ufname = "S70170920180920.xlsx";	
		int size = 18478;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		BordereauProcess.refreshUploadedFile();
		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			verifyMustExists(ViewQuestinnarie,"View Questinnarie button");
			click(ViewQuestinnarie,"View Questinnarie button");
			sleep(2000);
	
			verifyMustExists(QuePage.Step11Btn,"Step 11");
			click(QuePage.Step11Btn,"Step 11");
			sleep(2000);
			
			/*verifyMustExists(RemoveSprinkler,"Remove Sprinkler");
			click(RemoveSprinkler,"RemoveSprinkler");*/
			
			List<WebElement> RemoveIcon = webDriver.findElements(By.xpath(".//*[@id='selection']//tr"));
			for(int i=1; i<=RemoveIcon.size();i++){
				String row = "@xpath=.//*[@id='selection']//tr["+i+"]//i";
				sleep(1000);
				if(isVisible(row) ==true){
					webDriver.findElement(By.xpath(".//*[@id='selection']//tr["+i+"]//i")).click();
					sleep(200);
				}
			}
			
			QuePage.step12();
			verifyMustExists(QuePage.VerifyFirstRow,"Verify Sprinkler is displayed in First Row");
			//verifyMustExists(SaveandReprocess,"Verify Save and Reprocess button");
			if(isEnable(SaveandReprocess)==false)
			{
				Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is disable", "PASS");
				
			}
			else{
				Report.LogInfo("SaveandReprocessValidation", "Save and Reprocess button is not disable", "FAIL");
			}
			sleep(2000);
			verifyMustExists(QuePage.Step11Btn,"Step 11");
			click(QuePage.Step11Btn,"Step 11");
			sleep(1000);
			String ContentsDrag = "@xpath=//button[text()='Contents']";
			String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
			String NoBuildingsDrag = "@xpath=//button[contains(.,'Buildings')]";
			String NoBuildingssDrop = "@xpath=//td[contains(.,'Location Number Of Buildings')]//preceding-sibling::td/div/div";
			String ExpiryDrag = "@xpath=//button[text()='Expiry']";
			String ExpiryDrop = "@xpath=//td[contains(.,'Cancellation Date')]//preceding-sibling::td/div[1]/div";
			dragDropElement(ContentsDrag,ContentsDrop);
			dragDropElement(NoBuildingsDrag,NoBuildingssDrop);
			dragDropElement(SprinklersDrag,SprinklersDrop);
			dragDropElement(ExpiryDrag,ExpiryDrop);
			QuePage.step12();
			sleep(2000);
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
			sleep(10000);
			refreshPage();
			BordereauProcess.deleteBorderEAUX(); 
		}
		else
	    {
	     Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
	    
	    }
	}
	//================================================ Reusable function ==============================================================================================

	public void schemaLink()
	{
		waitForElementToAppear(SchemaLink,5);
		verifyMustExists(SchemaLink,"Schema Link");
		click(SchemaLink,"Schema Link");
	}

	public void schemapage()
	{
		if(isVisible(SchemaPageLbl)==true){
			waitForElementToAppear(SchemaPageLbl,5);
			verifyMustExists(SchemaPageLbl,"Schema page lable");
		}else{
			Report.LogInfo("verifysavepublicButton", "Save public button not dispalyed", "FAIL");
		}
	}

	public void verifySchemaSection(String SchemaSectionlbl)
	{
		waitForElementToAppear(SchemaSectionlbl,5);
		verifyMustExists(SchemaSectionlbl,"Schema section lable");
	}

	public void verifyAddschemabutton(String CreateSchemaIcon)
	{
		if(isVisible(CreateSchemaIcon)==true){
			verifyMustExists(CreateSchemaIcon,"Add Schema button");
		}else{
			Report.LogInfo("verifyAddSchemaButton", "Add schema button not dispalyed", "FAIL");
		}
	}

	public void clickonAddSchemabutton(String CreateSchemaIcon)
	{
		for(int i= 0; i<=5; i++)
		{

			click(CreateSchemaIcon,"Add Schema button");
			sleep(2000);
			if(isVisible(SchemaNameTxt)==true)
			{
				break;
			}
		}
	}

	public void addSchema(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue,String CBdropdownValue, String STdropdownValue)
	{
		if(isVisible(SchemaNameTxt)==true){
			verifyMustExists(SchemaNameTxt,"Schema Name text field");	
			sendKeys(SchemaNameTxt,Name,"Schema Name field.");
			SelectDropDownValue1(ClassOfBusinessDD,ClassOfBusinessDDValue);
			SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
		}else{
			Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
		}
	}

	public void verifySchema(String SchemaName )
	{
		if(isVisible(AddSchemaPageErrorMsg)==true)
		{
			Report.LogInfo("verifyerrorMessage", "Error message displayed,Schema not added successfully", "Fail");
		}else
		{
			if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+SchemaName+"')]")).isDisplayed()== true)
			{
				Report.LogInfo("verifyAddedSchema", "Schema added successfully", "PASS");
			}else{
				Report.LogInfo("verifyAddedSchema", "Schema not added successfully", "FAIL");
			}
		}
	}

	public void openInEditMode()
	{
		if(isVisible(EditkebabIcon)==true){
			waitForElementToAppear(EditkebabIcon,5);
			verifyMustExists(EditkebabIcon,"Edit kebab icon");
			//mouseOverAction(EditkebabIcon);
			click(EditkebabIcon,"Edit kebab icon");
			waitForElementToAppear(Editlink,5);
			verifyMustExists(Editlink,"Edit Link");
			click(Editlink,"Edit Link");
		}else{
			Report.LogInfo("verifyEditedIcon", "Edit icon not displayed", "FAIL");
		}
	}

	public void editSchemaDetails()
	{
		if(isVisible(EditClassOfBusinessDD)==true){
			waitForElementToAppear(EditClassOfBusinessDD,5);
			verifyMustExists(EditClassOfBusinessDD,"Class of Business dropdown");
			verifyMustExists(PropertyDFCancelIcon,"Property D&F (US binder) cancel icon");
			click(PropertyDFCancelIcon,"Property D&F (US binder) cancel icon");
			SelectDropDownValue1(EditClassOfBusinessDD,EditClassOfBusinessDDValue);
		}else{
			Report.LogInfo("verifyeditpage", "edit page not displayed", "FAIL");
		}

	}

	public void navigateToSettingsTab()
	{
		if(isVisible(SettingsTab)==true){
			waitForElementToAppear(SettingsTab,5);
			verifyMustExists(SettingsTab,"Settings Tab");
			click(SettingsTab,"Settings Tab");
		}else{
			Report.LogInfo("verifySettingTab", "Setting Tab not displayed", "FAIL");
		}
	}
	public void navigateToFieldSelectionTab()
	{
		if(isVisible(FieldSelectionTab)==true){
			waitForElementToAppear(FieldSelectionTab,5);
			verifyMustExists(FieldSelectionTab,"Field Selection Tab");
			click(FieldSelectionTab,"Field selection Tab");
		}else{
			Report.LogInfo("verifyFieldSelectionTab", "Field Selection Tab not displayed", "FAIL");
		}
	}	

	public void TotalValueSelection(String DDValue)
	{
		if(isVisible(TotalValueSelectionDD)==true){
			waitForElementToAppear(TotalValueSelectionDD,5);
			verifyMustExists(TotalValueSelectionDD,"Total Value Selection Dropdown");
			click(TotalValueSelectionDD,"Total Value Selection Dropdown");
			javaScriptWait();
			verifyMustExists(DDValue,"dropdown value");	
			click(DDValue,"dropdown value");	
		}else{
			Report.LogInfo("verifyTotalVauedropdown", "Total value drop down not displayed", "FAIL");
		}
	}

	public void SaveAndPublish()
	{
		if(isVisible(SaveAndPublishBtn)==true){
			waitForElementToAppear(SaveAndPublishBtn,5);
			verifyMustExists(SaveAndPublishBtn,"Save And Publish button");
			click(SaveAndPublishBtn,"Save And Publish button");	
			waitForElementToAppear(PublishDescriptionTxt,5);
			verifyMustExists(PublishDescriptionTxt,"publish Description text field");
			sendKeys(PublishDescriptionTxt,"Automation Test","public Description text field");
			verifyMustExists(PublishBtn,"Publish button");
			click(PublishBtn,"Publish button");	
		}else{
			Report.LogInfo("verifysavepublicButton", "Save public button not dispalyed", "FAIL");
		}
	}
	public String ActualClassBussiness;
	public String ActualPublishedDesc;
	public void verifyeditedSchema(String SchemaName,String ExpectedClassBussiness,String ExpectedPDescription )
	{
		if(webDriver.findElement(By.xpath("//ui-view[@id='content']//h3[contains(text(),'"+SchemaName+"')]")).isDisplayed()== true)
		{
			Report.LogInfo("verifyEditedSchema", "Schema edited successfully", "PASS");
		}else{
			Report.LogInfo("verifyEditedSchema", "Schema not edited successfully", "FAIL");
		}
		verifyMustExists(changedversion,"edited version");
		verifyMustExists(ClassOfBusinessTxt,"Class of Business text field");
		 ActualClassBussiness =getTextFrom(ClassOfBusinessTxt);
		if(ExpectedClassBussiness.equals(ActualClassBussiness))
		{
			Report.LogInfo("verifyClassofBusiness", "edited Class Of Business field verify successfully", "PASS");
		}else{
			Report.LogInfo("verifyClassofBusiness", "edited Class Of Business field not verify successfully", "FAIL");
		}

		verifyMustExists(PublishedDescriptionTxt,"published Description text field");
		 ActualPublishedDesc =getTextFrom(PublishedDescriptionTxt);

		if(ExpectedPDescription.equals(ActualPublishedDesc))
		{
			Report.LogInfo("verifypublishedDescription", "edited published Description field verify successfully", "PASS");
		}else{
			Report.LogInfo("verifypublishedDescription", "edited published Description field not verify successfully", "FAIL");
		}	
	}

	public void addSchema2(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue)
	{
		if(isVisible(SchemaNameTxt)==true){
			verifyMustExists(SchemaNameTxt,"Schema Name text field");	
			sendKeys(SchemaNameTxt,Name,"Schema Name field.");
			SelectDropDownValue1(ClassOfBusinessDD,ClassOfBusinessDDValue1);
			SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
		}else{
			Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
		}
	}

	public void verifyeditedSchema(String FilterText, String FilterResult)
	{
		waitForElementToAppear(FilterIcon,5);
		verifyMustExists(FilterIcon,"Filter Icon");
		click(FilterIcon,"Filter Icon");
		verifyMustExists(SearchTxt,"Filter Icon");
		sendKeys(SearchTxt,FilterText,"Filter Icon");
		verifyMustExists(FilterResult,"Filter Button");
		click(FilterResult,"Filter Button");
		verifyMustExists(FilterBtn,"Filter Button");
		click(FilterBtn,"Filter Button");
	}

	public void SearchEditedAddedSchema(String FilterText)
	{
		String Val = "@xpath=//input[@value='"+FilterText+"']";
		waitForElementToAppear(FilterIconSchema,5);
		verifyMustExists(FilterIconSchema,"Filter Icon");
		click(FilterIconSchema,"Filter Icon");
		verifyMustExists(SearchTxt,"Filter Icon");
		sendKeys(SearchTxt,FilterText,"Filter Icon");
		verifyMustExists(Val,"Filter Button");
		click(Val,"Filter Button");
		verifyMustExists(FilterBtn,"Filter Button");
		click(FilterBtn,"Filter Button");
	}

	public void addSchema1(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue)
	{
		if(isVisible(SchemaNameTxt)==true){
			verifyMustExists(SchemaNameTxt,"Schema Name text field");	
			sendKeys(SchemaNameTxt,Name,"Schema Name field.");
			String Val = "@xpath=//li[contains(.,'"+ClassOfBusinessDDValue+"')]";
			SelectDropDownValue1(ClassOfBusinessDD,Val);
			SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
			verifyMustExists(SaveBtn,"Save button");
			click(SaveBtn,"Save button");
		}else{
			Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
		}
	}

	public void editSchemaAndPublish(String PublishName, String InsurableCheck)
	{
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		sleep(2000);
		openInEditMode();
		sleep(1000);
		//Add building value to schema
		verifyeditedSchema("A - Buildings Value", BuildingsValuecheckbox1);
		verifyMustExists(BuildingsValue,"Buiding value");
		click(BuildingsValue,"Building value");
	    verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		//Add content value to schema
		verifyeditedSchema("C - Contents Value", ContentValueCheckBox);
		verifyMustExists(ContentsValue,"Contents Value");
		click(ContentsValue,"Contents Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Sprinklers (Y/N)", LocationSprinklersCheckBox);
		verifyMustExists(Sprinklersvalue,"Location Sprinklers (Y/N)");
		click(Sprinklersvalue,"Location Sprinklers (Y/N)");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Number of Buildings", NoOfBuildingscheckbox);
		verifyMustExists(NumberOfBuildingsValue1,"Number of Buildings");
		click(NumberOfBuildingsValue1,"Number of Buildings");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Year Built", BuildingYearBuiltcheckbox);
		verifyMustExists(BuildingYearBuiltValue1,"Building Year Built");
		click(BuildingYearBuiltValue1,"Building Year Built");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Scheme", ConstructionSchemecheckbox);
		verifyMustExists(OccupancyScheme,"Occupancy Scheme");
		click(OccupancyScheme,"Occupancy Scheme");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Code", ConstructionCodecheckbox);
		verifyMustExists(OccupancyCodeValue1,"Occupancy Code");
		click(OccupancyCodeValue1,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Location Occupancy Description", ConstructionDescriptioncheckbox);		
		verifyMustExists(OccupancyDescriptionValue,"Occupancy Description");
		click(OccupancyDescriptionValue,"Occupancy Description");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("FISCAL CODE", FiscalCodecheckbox);
		verifyMustExists(FISCALCODEValue,"FISCAL CODE Value");
		click(FISCALCODEValue,"FISCAL CODE");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("NAIC CODE", NAICCodecheckbox);
		verifyMustExists(NAICCODEValue,"NAIC CODE Value");
		click(NAICCODEValue,"NAIC CODE Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Surplus Lines Filing State", SurplusLinesFilingStatecheckbox);
		verifyMustExists(SurplusLinesFilingStateValue,"Surplus Lines Filing State Value");
		click(SurplusLinesFilingStateValue,"Surplus Lines Filing State Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		verifyeditedSchema("Risk Issuance Date", RiskIssuanceDatecheckbox);
		verifyMustExists(RiskIssuanceDateValue,"Risk Issuance Date");
		click(RiskIssuanceDateValue,"Risk Issuance Date");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
		
		verifyeditedSchema("Total Insurable Value", InsurableCheck);
		verifyMustExists(TotalInsurableValue1,"Total Insured Value");
		click(TotalInsurableValue1,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		
	
		
		verifyMustExists(SettingsTab,"Settings Tab");
		click(SettingsTab,"Settings Tab");	
		SelectDropDownValue1(TotalValueDD,TotalValueDDValue);
		verifyMustExists(SaveAndPublishBtn,"Save and Publish button");
		SavePublish = getTextFrom(SaveAndPublishBtn);
		Report.LogInfo("Save and Publish button", SavePublish, "PASS");
		click(SaveAndPublishBtn,"Save and Publish button");	
		verifyMustExists(PublishDescriptionTxt,"Publish Description textbox");
		sendKeys(PublishDescriptionTxt,PublishName,"Publish Description textbox");	
		verifyMustExists(PublishBtn,"Publish button");
		click(PublishBtn,"Publish button");
		sleep(2000);
	}

	public void editSchemaAndPublish1(String PublishName)
	{
		scrollUp();
		sleep(2000);
		openInEditMode();
		sleep(1000);
		verifyMustExists(BuildingsValue,"Buiding value");
		click(BuildingsValue,"Building value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(ContentsValue,"Contents Value");
		click(ContentsValue,"Contents Value");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(Sprinklers,"Sprinklers Y/N");
		click(Sprinklers,"Sprinklers Y/N");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(NumberOfStories,"Number of Stories");
		click(NumberOfStories,"Number of Stories");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(BuildingYearBuilt,"Building Year Built");
		click(BuildingYearBuilt,"Building Year Built");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyScheme,"Occupancy Scheme");
		click(OccupancyScheme,"Occupancy Scheme");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyCode,"Occupancy Code");
		click(OccupancyCode,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(OccupancyDescription,"Occupancy Description");
		click(OccupancyDescription,"Occupancy Description");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");
		verifyMustExists(TotalInsurableValue,"Occupancy Code");
		click(TotalInsurableValue,"Occupancy Code");
		verifyMustExists(RightArrowIcon,"Right Arrow icon");
		click(RightArrowIcon,"Right Arrow icon");		
		verifyMustExists(SettingsTab,"Settings Tab");
		click(SettingsTab,"Settings Tab");	
		SelectDropDownValue1(TotalValueDD,TotalValueDDValue);
		verifyMustExists(SaveAndPublishBtn,"Save and Publish button");
		click(SaveAndPublishBtn,"Save and Publish button");	
		verifyMustExists(PublishDescriptionTxt,"Publish Description textbox");
		sendKeys(PublishDescriptionTxt,PublishName,"Publish Description textbox");	
		verifyMustExists(PublishBtn,"Publish button");
		click(PublishBtn,"Publish button");
		sleep(2000);
	}

	//3937
	/*public void grossPremiumRule()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD, GrossPremiumValue);
		SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"100.00","Entry Or Selection textbox");
	}
	*/
	public void YearBuiltRule()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD, BuildingYearBuiltValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"1960","Entry Or Selection textbox");
	}
	//3937
	public void NumberOfBuildings()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfBuildingsValue);
		SelectDropDownValue1(policy.OperatorDD,BetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"50","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"99","Entry Value From textbox");
	}
	
	public void numberOfBuildings()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfBuildingsValue);
		//SelectDropDownValue1(policy.OperatorDD,BetweenValue);
		SelectDropDownValue1(OperatorDrpDwn,BetweenValue1);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"50","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"99","Entry Value From textbox");
	}


	//3937
	public void numberOfStoriesLessThanOrEqual(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfStoriesValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,Value,"Entry Value From textbox");
	}
	//3937
	public void riskInceptionDate()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
		SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"01/02/2018","Entry Value From textbox");		
	}
	
	//3603
		public void riskInceptionDate1()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Field);
			SelectDropDownValue1(policy.FieldDD,policy.EndorsementEffectiveDateVal);
			
			
		}
		
		public void LocationYearBuiltValue2()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,BuildingYearBuiltValue);
			SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Field);
			SelectDropDownValue1(policy.FieldDD,policy.LocationNumberOfBuildingsVal);
		}
		
		public void InsuredName()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,InsuredName);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Field);
			SelectDropDownValue1(policy.FieldDD,policy.FiscalCodeVal);
		}
		public void RiskExpiryDate()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,RiskExpiryDate);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Field);
			SelectDropDownValue1(policy.FieldDD,policy.RiskIssuanceDateVal);
		}
		
		public void LocationSprinklersValue1()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,LocationSprinklersValue);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			SelectDropDownValue1(EntryValueFromDD,NoValue);
		}
		
		
		//3648
		public void ClaimFinnanceCurrency()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,ClaimFinnanceCurrencyValue);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDGBPValue);
		}
		public void DateClaimMade()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,DateClaimMadeValue);
			SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
			sendKeys(EntryValueFromTxt ,"01/01/2018","Entry Value From textbox");
		}
		
		public void LossPostalCode(String value)
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,LossPostalCodeValue);
			SelectDropDownValue1(policy.OperatorDD,ContainsValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
			sendKeys(EntryValueFromTxt,value,"Entry Value From textbox");
		}
		public void LossCountry()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,LossCountryValue);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDAlbaniaValue);
			
		}
		
	//	3654
		public void riskInceptionDateNotBetween12()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
			SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
			sendKeys(EntryValueFromTxt ,"01/01/2018","Entry Value From textbox");
			verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
			sendKeys(EntryValueToTxt,"01/04/2018","Entry Value From textbox");
			
		}
		public void LossDescription()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,LossDescriptionValue);
			SelectDropDownValue1(policy.OperatorDD,IsBlankValue);
		
		}
		
		public void LossCountry1()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,LossCountryValue);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDUSValue);
			
		}
		public void ClaimFinnanceCurrency1()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,ClaimFinnanceCurrencyValue);
			SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDEURValue);
		}
		
		public void ClaimStatus()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,ClaimStatusValue);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDOpenValue);
		}
		public void Denial_YN()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,DenialYNValue);
			SelectDropDownValue1(policy.OperatorDD,EqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDOYESValue);
		}
		public void DateOfLossFrom_LessThanOREqualTo()
		{
			scrollDown();
			PolicyPage policy = new PolicyPage();
			SelectDropDownValue1(policy.FieldNameDD,DateOfLossFromValue);		
			SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
			SelectDropDownValue1(policy.AppliedToDD,policy.Value);
			verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
			sendKeys(EntryValueFromTxt ,"03/01/2018","Entry Value From textbox");
			
			
		}
		
		
	//3849
	public void riskInceptionDateNotBetween1()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"01/02/2017","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"02/03/2017","Entry Value From textbox");
	}

	public void riskInceptionDateNotBetween2()
	{
		/*scrollDown();
		sleep(2000);
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
		sleep(2000);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		sleep(2000);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,date1,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,date2,"Entry Value From textbox");*/
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"01/02/2018","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"10/12/2018","Entry Value From textbox");
	}
	
	public void LocationYearBuiltBetween(String date11, String date21)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,LocationYBValue);
		SelectDropDownValue1(policy.OperatorDD,BetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,date11,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,date21,"Entry Value From textbox");
	}

	//3937
	public void riskInceptionDateNotBetween()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"01/02/2018","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"10/10/2018","Entry Value From textbox");
	}

	//3937
	public void riskInceptionDateNotBetween1(String value, String value1)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,value,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,value1,"Entry Value From textbox");
	}

	//3938
	public void totalInsuranceValue(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,TotalInsurableValueRule);
		SelectDropDownValue1(policy.OperatorDD,GreaterThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,Value,"Entry Or Selection textbox");
	}
	public void LocationNoBuildingsValue(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfBuildingsValue);
		scrollDown();
		SelectDropDownValue1(policy.OperatorDD,GreaterThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,Value,"Entry Or Selection textbox");
	}
	public void BuildingValue(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingValueRule);
		SelectDropDownValue1(policy.OperatorDD,ContainsValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,Value,"Entry Or Selection textbox");
	}

	//3938
	public void contentsValue()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,ContentsValue1);
		SelectDropDownValue1(policy.OperatorDD,LessThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"1000","Entry Or Selection textbox");
	}
	public void LocationSprinklersValue()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,LocationSprinklersValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,NoValue);
	}
	//3938
	/*public void buildingYearBuiltValue()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingYearBuiltValue);
		SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromDD,"Entry Value From dropdown");
		click(EntryValueFromDD,"Entry Value From dropdown");
		verifyMustExists(EntryValueFromDD1960Value,"1960 Value");
		click(EntryValueFromDD1960Value,"1960 Value");
	}*/
	public void LocationYearBuiltValue1()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingYearBuiltValue);
		SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromDD1,"Entry Value From dropdown");
		click(EntryValueFromDD1,"Entry Value From dropdown");
		sendKeys(EntryValueFromDD1,"1960","1960 Value");
		/*verifyMustExists(EntryValueFromDD1960Value,"1960 Value");
		click(EntryValueFromDD1960Value,"1960 Value");*/
	}
	//3849
	public void riskCurrency()
	{
		scrollDown();
		sleep(1000);
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskCurrencyValue);
		SelectDropDownValue1(policy.OperatorDD,NotEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,EntryValueFromDDUSDValue);
	}

	//3849
	public void totalTax()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,TotalTaxValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"10","Entry Value From textbox");
	}

	//3849
	public void riskPostalCode(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskPostalCodeValue);
		SelectDropDownValue1(policy.OperatorDD,ContainsValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,value,"Entry Value From textbox");
	}

	//3849
	public void netPremium()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NetPremiumValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"100","Entry Value From textbox");
	}
	public void LNoOfBuilding()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NumberOfBuildingsValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"98","Entry Value From textbox");
	}

	public void netPremiumLessThanOrEqual(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,NetPremiumValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,value,"Entry Value From textbox");
	}
	
	public void expairydateLessThanOrEqual(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,ExpairydateValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,value,"Entry Value From textbox");
	}

	//3849
	public void sprinklers()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,SprinklersValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,NoValue);
	}

	public void yearOfAccount(String val)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,YearOfAcValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,val,"Entry Value From textbox");
	}

	//3850
	public void sprinklers1()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,LocationSprinklerValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,YesValue);
	}

	/*public void buildingsValue(String value1, String value2)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingsValue1);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,value1,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,value2,"Entry Value From textbox");
	}*/
	public void buildingsValue()
	{
		scrollDown();
		sleep(2000);
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingsValue1);
		SelectDropDownValue1(policy.OperatorDD,IsnotBlankValue);		
		
	}
	public void FiscalValueIsNotBlank()
	{
		scrollDown();
		sleep(2000);
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,FiscalValueRule);
		SelectDropDownValue1(policy.OperatorDD,IsnotBlankValue);		
		
	}



	//3849
	public void occupancyCode()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,OccupancyCodeValue);
		SelectDropDownValue1(policy.OperatorDD,IsBlankValue);			
	}

	//3849
	public void grossPremium()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,GrossPremiumValue);		
		SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"100","Entry Value From textbox");	
	}
	public void riskExparydate()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,ExpairydateValue);		
		SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"09/09/2018","Entry Value From textbox");	
	}
	
	//3850
	public void BuildingValueIsBlank()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingValueRule);
		SelectDropDownValue1(policy.OperatorDD,IsBlankValue);	
		//SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);	
		//SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		//verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		//sendKeys(EntryValueFromTxt,"100","Entry Value From textbox");	
	}
	public void FiscalCodeValueIsBlank()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,FiscalValueRule);
		SelectDropDownValue1(policy.OperatorDD,IsBlankValue);	
		//SelectDropDownValue1(policy.OperatorDD,GreaterThanOrEqualToValue);	
		//SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		//verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		//sendKeys(EntryValueFromTxt,"100","Entry Value From textbox");	
	}

	//3850
	public void insuredAddress()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,InsuredAddressValue);
		SelectDropDownValue1(policy.OperatorDD,IsBlankValue);		
	}

	public void occupancyCodeNotBetween()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,OccupancyCodeValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,"300","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"400","Entry Value From textbox");
	}

	public void occupancyCodeNotBetweenCompliance()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,OccupancyCodeValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);	
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD, EntryValueFromDD300);
		SelectDropDownValue1(EntryValueToDD, EntryValueFromDD400);	
	}

	public void buildingValueNotBetweenCompliance(String value, String Value1)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingValue);
		SelectDropDownValue1(policy.OperatorDD,NotBetweenValue);	
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt ,value,"Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,Value1,"Entry Value From textbox");
	}

	//3660
	public void BuildingValueBetween()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,BuildingValue);
		SelectDropDownValue1(policy.OperatorDD,BetweenValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt,"301","Entry Value From textbox");
		verifyMustExists(EntryValueToTxt,"Entry Value From textbox");
		sendKeys(EntryValueToTxt,"400","Entry Value From textbox");
	}
	
	public void SurplusLinesFillingStateValueContains(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,SurplusLinesFilingValue);
		SelectDropDownValue1(policy.OperatorDD,ContainsValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,Value,"Entry Or Selection textbox");
	}
	public void SurplusLinesFillingStateValueEqualTo(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,SurplusLinesFilingValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		waitForElementToAppear(EntrySelectionText2,5);
		verifyMustExists(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		click(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[text()='"+Value+"']")).click();
		sleep(1000);
	}
	public void RiskReferenceContains(String Value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskReferenceValue);
		SelectDropDownValue1(policy.OperatorDD,ContainsValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,Value,"Entry Or Selection textbox");
	}
	
	public void ContentsValueGreaterThan(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,ContentsValue2);
		SelectDropDownValue1(policy.OperatorDD,GreaterThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,value,"Entry Or Selection textbox");
	}
	
	public void riskInceptionDateLessThan(String Date)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);
		SelectDropDownValue1(policy.OperatorDD,LessThanValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,Date,"Entry Or Selection textbox");
	}
	
	
	public void riskcountryEqual1(String ENTRY_SELECTION1)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskCountryValue);		
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		waitForElementToAppear(EntrySelectionText2,5);
		verifyMustExists(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		click(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[text()='"+ENTRY_SELECTION1+"']")).click();
		sleep(1000);
	}
	
	
	public void DatasetSelection4(){
		
		verifyMustExists(PostalCodeValue1,"Postal Code Value");
		click(PostalCodeValue1,"Postal Code Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}
	
public void DatasetSelection5(){
		
		verifyMustExists(FiscalCodeValue,"Fiscal Code Value");
		click(FiscalCodeValue,"Fiscal Code Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		
		
		verifyMustExists(NAICCodeValue,"NAIC Code Value");
		click(NAICCodeValue,"NAIC Code Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		
		verifyMustExists(SurplusLinesFilingStateValue1,"Surplus Lines Filing State Value");
		click(SurplusLinesFilingStateValue1,"Surplus Lines Filing State Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		
		
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}
	
	
	public void SelectComplianceData()
	{
		waitForElementToAppear(RuleHeaderLink,5);
		verifyMustExists(RuleHeaderLink,"RuleHeaderLink");
		click(RuleHeaderLink,"RuleHeaderLink");
		SelectDropDownValue1(AddRuleDropDown,AddRuleComplianceData);
	}

	public void AddComplianceDataRule(String Rule_Name,String Error_Messgage,String Data_Set, String Processing_Action,String Classic_Bussiness){

		waitForElementToAppear(RuleNameText,5);
		verifyMustExists(RuleNameText,"RuleNameText");
		sendKeys(RuleNameText,Rule_Name,"Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText,5);
		verifyMustExists(ErrorMessgaeText,"ErrorMessgaeText");
		sendKeys(ErrorMessgaeText,Error_Messgage,"Enter ErrorMessgaeText");

		waitForElementToAppear(DataSetDrpDwn,5);
		verifyMustExists(DataSetDrpDwn,"DataSetDrpDwn");
		click(DataSetDrpDwn,"DataSetDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//li[text()='"+Data_Set+"']")).click();
		waitForElementToAppear(ProcessingActionDrpDwn,5);
		verifyMustExists(ProcessingActionDrpDwn,"ProcessingActionDrpDwn");
		click(ProcessingActionDrpDwn,"ProcessingActionDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//li[text()='"+Processing_Action+"']")).click();
		waitForElementToAppear(ClassBusinessSelction,5);
		verifyMustExists(ClassBusinessSelction,"ClassBusinessSelction");
		click(ClassBusinessSelction,"ClassBusinessSelction");
		sleep(1000);
		webDriver.findElement(By.xpath("//li[text()='"+Classic_Bussiness+"']")).click();
	}

	public void AddContractRule(String Rule_Name, String Data_Set, String Currency_Val, String AppCondition_Val){

		waitForElementToAppear(RuleNameText,5);
		verifyMustExists(RuleNameText,"RuleNameText");
		sendKeys(RuleNameText,Rule_Name,"Enter RuleName");

		String dataSetVal = "@xpath=//li[text()='"+Data_Set+"']";
		waitForElementToAppear(DataSetDrpDwn,3);
		SelectDropDownValue1(DataSetDrpDwn,dataSetVal);

		String Currency_Value = "@xpath=//li[text()='"+Currency_Val+"']";
		waitForElementToAppear(CurrencyDrpDwn,3);
		SelectDropDownValue1(CurrencyDrpDwn,Currency_Value);

		waitForElementToAppear(ROETolerance,5);
		verifyMustExists(ROETolerance,"ROE Tolerance");
		sendKeys(ROETolerance,"5","Enter ROE Tolerance");

		String AppCondition_Value = "@xpath=//li[text()='"+AppCondition_Val+"']";
		//String AppCondition_Value = "@xpath=//li[text()='Data is valid if the rule conditions are met']";
		waitForElementToAppear(AppConditonDrpDwn,3);
		SelectDropDownValue1(AppConditonDrpDwn,AppCondition_Value);

		String AppSec_Value = "@xpath=//li[contains(.,'Section2')]";
		String AppSec_Value1 = "@xpath=//li[contains(.,'Section1')]";

		waitForElementToAppear(AppSectionDrpDwn,3);
		SelectDropDownValue1(AppSectionDrpDwn,AppSec_Value);
		SelectDropDownValue1(AppSectionDrpDwn,AppSec_Value1);


	}	

	public void CreatePolicyAndUploadFile() throws Exception{
		String UniqueReferenceVal1 = "Automation Policy_19"+getCurrentDateTimeMS();
		String Status1 = "Draft";
		String InceptionDate1 = "01/01/2017";
		String subSheet = "Risk Reference Format";
		//String InceptionDateExp = "01/01/2018";
		policy.navigationOnPolicyTab();
		policy.navigationOnAddContractPage();
		policy.navigationOnSelectPolicyPopUp();
		policy.navigationOnAddPolicyPopUp();
		policy.addContractBinderDetails();
		policy.addPolicyContractDetails(UniqueReferenceVal1, InceptionDate1,policy.Broker1, policy.Bline1, policy.Underline1);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		policy.changeStatusToSigned();
		sleep(2000);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		Br.SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4080Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_4080.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_4080.xlsx\",\"UniqueFileName\":\"S84333320180008.xlsx\",\"BordereauFormatId\":\"b9dc3d28-c6bf-44cf-abaf-c9076bdb3581\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S84333320180008.xlsx\",\"Filesize\":24684,\"Path\":null,\"size\":24684,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet4080Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		String MultipleRuleConditionError ="@xpath=//*[@id='dataType_Id']//h2[contains(.,'Multiple rule condition Error')]";


		if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(MultipleRuleConditionError)== true)
			{
				verifyMustExists(Data0,"Gross Premium");
				sendKeys(Data0,"01/02/2017","Gross Premium");
				verifyMustExists(Data1,"Number of Stories");
				sendKeys(Data1,"447","Number of Stories");
				verifyMustExists(Data2,"Risk Inception Date");
				sendKeys(Data2,"1992","Risk Inception Date");
				verifyMustExists(ContinueBtn,"Continue button");
				click(ContinueBtn,"Continue button");
				sleep(2000);
				verifyMustExists(CancelBtn,"Cancel button");
				click(CancelBtn,"Cancel button");
				sleep(2000);
				if(isVisible(BordereauProcess.ReviewBtn)==true)
				{
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}
				else
				{
					BordereauProcess.refreshUploadedFile();
					verifyExists(BordereauProcess.ReviewBtn,"Review button");
					BordereauProcess.deleteBorderEAUX();
				}	
			}
		}
		else
		{
			Report.LogInfo("ValidateErrorScreen", "Expected error screen page not displayed.", "FAIL");
			goBack();
			BordereauProcess.deleteBorderEAUX();				
		}
	}

	public void riskcountryEqual(String ENTRY_SELECTION1)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskCountryValue);		
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		waitForElementToAppear(EntrySelectionText2,5);
		verifyMustExists(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		click(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+ENTRY_SELECTION1+"')]")).click();
		sleep(1000);
	}

	public void AddRuleConditionForComplianceRule2(String FieldName1,String OPERATOR1,String ENTRY_SELECTION1 ){


		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");
		waitForElementToAppear(Method1,5);
		verifyMustExists(Method1,"Method1");
		click(Method1,"Method1");
		waitForElementToAppear(AndOption,5);
		verifyMustExists(AndOption,"AndOption");
		click(AndOption,"AndOption");
		waitForElementToAppear(FieldNameDrpDwn,5);
		verifyMustExists(FieldNameDrpDwn,"FieldNameDrpDwn");
		click(FieldNameDrpDwn,"FieldNameDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+FieldName1+"')]")).click();
		waitForElementToAppear(OperatorDrpDwn,5);
		verifyMustExists(OperatorDrpDwn,"OperatorDrpDwn");
		click(OperatorDrpDwn,"OperatorDrpDwn");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+OPERATOR1+"')]")).click();
		waitForElementToAppear(AppliedToDrpDwn,5);
		verifyMustExists(AppliedToDrpDwn,"AppliedToDrpDwn");
		click(AppliedToDrpDwn,"AppliedToDrpDwn");
		waitForElementToAppear(ValueOption,5);
		verifyMustExists(ValueOption,"ValueOption");
		click(ValueOption,"ValueOption");
		//webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+APPLIEDTO1+"')]")).click();
		waitForElementToAppear(EntrySelectionText2,5);
		verifyMustExists(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		click(EntrySelectionText2,"EntrySelectionText");
		sleep(1000);
		webDriver.findElement(By.xpath("//*[@data-role='staticlist']//li[contains(text(),'"+ENTRY_SELECTION1+"')]")).click();
		sleep(1000);
		//sendKeys(EntrySelectionText2,ENTRY_SELECTION1,"EntrySelectionText");
		waitForElementToAppear(TickMarkButton1,5);
		verifyMustExists(TickMarkButton1,"TickMarkButton");
		click(TickMarkButton1,"TickMarkButton");
		/*waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule"); 
		sleep(2000);*/
	}

	public void AddRuleConditionForComplianceRule(String FieldName1,String OPERATOR1,String APPLIEDTO1,String ENTRY_SELECTION1 ){


		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");

		//SelectDropDownValue1(FieldNameDrpDwn,FieldNameDrpDwnSelectOption1);
		waitForElementToAppear(FieldNameDrpDwn,5);
		verifyMustExists(FieldNameDrpDwn,"FieldNameDrpDwn");
		click(FieldNameDrpDwn,"FieldNameDrpDwn");
		waitForElementToAppear(FieldNameDrpDwnSearchText,5);
		verifyMustExists(FieldNameDrpDwnSearchText,"FieldNameDrpDwnSearchText");
		click(FieldNameDrpDwnSearchText,"FieldNameDrpDwnSelectOption");
		scrollDown();
		sleep(2000);
		sendKeys(FieldNameDrpDwnSearchText,FieldName1,"FieldNameDrpDwnSearchText");
		/*sleep(2000);
		scrollDown();*/
		waitForElementToAppear(FieldNameDrpDwnSelectOption1,5);
		sleep(2000);
		verifyMustExists(FieldNameDrpDwnSelectOption1,"FieldNameDrpDwnSelectOption");
		click(FieldNameDrpDwnSelectOption1,"FieldNameDrpDwnSelectOption");
		SelectDropDownValue1(OperatorDrpDwn,OperatorDrpDwnSelectOption);	
		SelectDropDownValue1(AppliedToDrpDwn,AppliedToDrpDwnSelectOption);
		waitForElementToAppear(EntrySelectionText1,5);
		verifyMustExists(EntrySelectionText1,"EntrySelectionText");
		sendKeys(EntrySelectionText1,ENTRY_SELECTION1,"EntrySelectionText");
		waitForElementToAppear(TickMarkButton,5);
		verifyMustExists(TickMarkButton,"TickMarkButton");
		click(TickMarkButton,"TickMarkButton");
	}



	public void AddRuleConditionForComplianceRule1(String ENTRY_SELECTION1 ,String ENTRY_SELECTION2){

		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");
		waitForElementToAppear(Method1,5);
		verifyMustExists(Method1,"Method1");
		click(Method1,"Method1");
		waitForElementToAppear(OrOption,5);
		verifyMustExists(OrOption,"OrOption");
		click(OrOption,"OrOption");
		SelectDropDownValue1(FieldNameDrpDwn,InsurableValue);
		SelectDropDownValue1(OperatorDrpDwn,BetweenValue1);
		SelectDropDownValue1(AppliedToDrpDwn,ValueOption);						
		waitForElementToAppear(EntrySelectionText1,5);
		verifyMustExists(EntrySelectionText1,"EntrySelectionText");
		sendKeys(EntrySelectionText1,ENTRY_SELECTION1,"EntrySelectionText");
		waitForElementToAppear(EntrySelectionText2,5);
		verifyMustExists(EntrySelectionText2,"EntrySelectionText");
		sendKeys(EntrySelectionText2,ENTRY_SELECTION2,"EntrySelectionText");
		waitForElementToAppear(TickMarkButton2,5);
		verifyMustExists(TickMarkButton2,"TickMarkButton");
		click(TickMarkButton2,"TickMarkButton");
		sleep(2000);
	}

	public void DatasetSelection(){
		waitForElementToAppear(DatasetRiskInspectionDate,5);
		verifyMustExists(DatasetRiskInspectionDate,"DatasetRiskInspectionDate");
		click(DatasetRiskInspectionDate,"DatasetRiskInspectionDate");
		waitForElementToAppear(RightArrowIcon1,5);
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(DatasetGrossPremium,5);
		verifyMustExists(DatasetGrossPremium,"DatasetGrossPremium");
		click(DatasetGrossPremium,"DatasetGrossPremium");
		waitForElementToAppear(RightArrowIcon1,5);
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(DatasetTotalInsurableValue,5);
		verifyMustExists(DatasetTotalInsurableValue,"DatasetTotalInsurableValue");
		click(DatasetTotalInsurableValue,"DatasetTotalInsurableValue");
		waitForElementToAppear(RightArrowIcon1,5);
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}

	public void selectInformationRule(){
		SelectDropDownValue1(AddRulesDropDwn,AddRulesOptionInformation);
	}

	public void fileUpload_4044() throws  Exception{
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4044Path = fpath+"\\src\\test\\resources\\testdata\\Information Rule_TC_4044.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Information Rule_TC_4044.xlsx\",\"UniqueFileName\":\"S11350320171127.xlsx\",\"BordereauFormatId\":\"dd7607a8-5fe7-4565-b28b-960cb2f53a8b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S11350320171127.xlsx\",\"Filesize\":18067,\"Path\":null,\"size\":18067,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		File excelFile = new File(sheet4044Path);
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();

		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ValidateReviewStatus", "Review Button displayed", "PASS");
			verifyMustExists(Br.ReviewBtn,"Review Button");
			click(Br.ReviewBtn,"Clicked on Review Button");
			rule.GetApproveStatus();

		}else{
			Report.LogInfo("ValidateReviewStatus", "Review Button not displayed", "FAIL");
			Br.deleteBorderEAUX();
		}	
	}

	public void AddInformationRule(String Rule_Name,String Error_Messgage,String dataset1,String ApplicationCondition1,String Schema1 ){
		waitForElementToAppear(RuleNameText,5);
		verifyMustExists(RuleNameText,"RuleNameText"); 
		sendKeys(RuleNameText,Rule_Name,"Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText,5);
		verifyMustExists(ErrorMessgaeText,"ErrorMessgaeText");
		sendKeys(ErrorMessgaeText,Error_Messgage,"Enter ErrorMessgaeText");

		waitForElementToAppear(DataSetDropDwn,5);
		verifyMustExists(DataSetDropDwn,"DataSetDropDwn");
		click(DataSetDropDwn,"DataSetDropDwn");
		waitForElementToAppear(SelectOptionDataSetDropDwn,5);
		verifyMustExists(SelectOptionDataSetDropDwn,"SelectOptionDataSetDropDwn");
		webDriver.findElement(By.xpath("//li[text()='"+dataset1+"']")).click();
		waitForElementToAppear(ApplicationConditionDrpDwn,5);
		verifyMustExists(ApplicationConditionDrpDwn,"ApplicationConditionDrpDwn");
		click(ApplicationConditionDrpDwn,"ApplicationConditionDrpDwn");
		waitForElementToAppear(ApplicationConditionDrpDwnSelectOption,5);
		verifyMustExists(ApplicationConditionDrpDwnSelectOption,"ApplicationConditionDrpDwnSelectOption");
		webDriver.findElement(By.xpath("//li[text()='"+ApplicationCondition1+"']")).click();

		SelectDropDownValue1(SchemaDropDwn,SchemaDropDwnOption);
	}

	public void AddRuleConditionForInformationRule(String FieldName1,String OPERATOR1,String APPLIEDTO1,String ENTRY_SELECTION1,String ENTRY_SELECTION2 ){
		waitForElementToAppear(AddRulesConditionButton,5);
		verifyMustExists(AddRulesConditionButton,"AddRulesConditionButton");
		click(AddRulesConditionButton,"AddRulesConditionButton");
		SelectDropDownValue1(FieldNameDrpDwn,SelectOptionNumberOfStories);
		sleep(2000);
		SelectDropDownValue1(OperatorDrpDwn,BetweenSlectionOption);

		SelectDropDownValue1(AppliedToDrpDwn,AppliedToDrpDwnSelectOption);
		waitForElementToAppear(EntrySelction1,5);
		verifyMustExists(EntrySelction1,"EntrySelctionFirst");
		sendKeys(EntrySelction1,ENTRY_SELECTION1,"Enter First Entry");
		waitForElementToAppear(EntrySelction2,5);
		verifyMustExists(EntrySelction2,"EntrySelctionSecond");
		sendKeys(EntrySelction2,ENTRY_SELECTION2,"Enter Second Entry");

		waitForElementToAppear(TickMarkButton,5);
		verifyMustExists(TickMarkButton,"TickMarkButton");
		click(TickMarkButton,"TickMarkButton");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule"); 
		sleep(2000);
		if(isVisible(PopupTitle)==true){
			waitForElementToAppear(PopupSaveButton,5);
			verifyMustExists(PopupSaveButton,"PopupSaveButton");
			click(PopupSaveButton,"PopupSaveButton");
		}else{
			sleep(4000);	
		}		
	}

	public void selectBreaches(){
		String RulseDropDwnSelectionOption = "@xpath=//li[contains(.,'"+RuleNameInformation+"')]";
		waitForElementToAppear(RulesMenuTab,5);
		verifyMustExists(RulesMenuTab,"RulesMenuTab");
		click(RulesMenuTab,"RulesMenuTab");
		waitForElementToAppear(BreachesLink,5);
		verifyMustExists(BreachesLink,"BreachesLink");
		click(BreachesLink,"BreachesLink");
		waitForElementToAppear(RulseDropDwnSelection,5);
		verifyMustExists(RulseDropDwnSelection,"RulseDropDwnSelection");
		click(RulseDropDwnSelection,"RulseDropDwnSelection");
		waitForElementToAppear(RulseDropDwnSelectionOption,5);
		verifyMustExists(RulseDropDwnSelectionOption,"RulseDropDwnSelectionOption");
		click(RulseDropDwnSelectionOption,"RulseDropDwnSelectionOption");
		if(isVisible(RulesConditionTab)==true){
			Report.LogInfo("ValidateBreachesStatus", "Breaches get opened", "PASS");
		}else{
			Report.LogInfo("ValidateBreachesStatus", "Breaches not get opened", "FAIL");
		}
	}

	public void createClassOfBusiness(String name) throws InterruptedException
	{
		homePage.adminMenu();
		verifyMustExists(SystemReferanceDataOption,"System Referance Data Option");
		click(SystemReferanceDataOption,"System Referance Data Option");
		verifyMustExists(ClassOfBusinesslabel,"Class Of Business label");
		click(ClassOfBusinesslabel,"Class Of Business label");
		verifyMustExists(AddClassOfBusinessBtn,"Add Class Of Business button");
		click(AddClassOfBusinessBtn,"Add Class Of Business button");
		verifyMustExists(ClassOfBusinessNameTxt,"Class Of Business Name textbox");
		sendKeys(ClassOfBusinessNameTxt,name,"Class Of Business Name textbox");
		verifyMustExists(ClassOfBusinessShortNameTxt,"Class Of Business Short Name textbox");
		sendKeys(ClassOfBusinessShortNameTxt,"aCob","Class Of Business Short Name textbox");
		SelectDropDownValue1(LineOfBusinessDD,LineOfBusinessValue);
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
	}

	public void sprinklersYes()
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,LocationSprinklerValue);
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		SelectDropDownValue1(EntryValueFromDD,YesValue);
	}

	public void contentsValue(String value)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,ContentsValue1);
		SelectDropDownValue1(policy.OperatorDD,LessThanOrEqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,value,"Entry Or Selection textbox");
	}
	
	public void applyDataSetFilter(String FilterString) throws InterruptedException
	{
		int i=0;

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(DataSetFilterIcon, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(DataSetFilterSearch))
			{
				verifyMustExists(DataSetFilterSearch,"Search Filter Textbox");	
				sendKeys(DataSetFilterSearch,FilterString,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(COBChkBox) && i<5);

		click(COBChkBox, "Searched Record Checkbox");
		verifyMustExists(policy.FilterButton,"Filter Button");
		click(policy.FilterButton,"Filter Button");
		sleep(3000);
	
	}
	
	public void createClassOfBusiness1(String name) throws InterruptedException
	{
		verifyMustExists(AddClassOfBusinessBtn,"Add Class Of Business button");
		click(AddClassOfBusinessBtn,"Add Class Of Business button");
		verifyMustExists(ClassOfBusinessNameTxt,"Class Of Business Name textbox");
		sendKeys(ClassOfBusinessNameTxt,name,"Class Of Business Name textbox");
		verifyMustExists(ClassOfBusinessShortNameTxt,"Class Of Business Short Name textbox");
		sendKeys(ClassOfBusinessShortNameTxt,"aCob","Class Of Business Short Name textbox");
		SelectDropDownValue1(LineOfBusinessDD,LineOfBusinessValue);
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
	}
	
	public void riskInceptionDateEqual(String Date)
	{
		scrollDown();
		PolicyPage policy = new PolicyPage();
		SelectDropDownValue1(policy.FieldNameDD,RiskInceptionDateValue);		
		SelectDropDownValue1(policy.OperatorDD,EqualToValue);
		SelectDropDownValue1(policy.AppliedToDD,policy.Value);
		verifyMustExists(EntryValueFromTxt ,"Entry Value From textbox");
		sendKeys(EntryValueFromTxt, Date, "Entry Value From textbox");
	}
	
	
	public void DatasetSelection2(){
		/*verifyMustExists(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		click(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");*/
		verifyMustExists(ABuildingsValue,"A-Buildings Value");
		//click(NumberOfStories,"NumberOfStories");
		click(ABuildingsValue,"A-Buildings Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		verifyMustExists(InsuredAddressValue1,"Insured Address Value");
		click(InsuredAddressValue1,"Insured Address Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}
	public void DatasetSelection3(){
	
		
		verifyMustExists(PostalCodeValue,"Postal Code Value");
		click(PostalCodeValue,"Postal Code Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		
		verifyMustExists(RiskAddress,"Risk Address Value");
		click(RiskAddress,"Risk Address Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}
	
	public void DatasetSelection1(){
		waitForElementToAppear(RiskExpiryDateValue,5);
		verifyMustExists(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		click(RiskExpiryDateValue,"DatasetRiskInspectionDate");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(InsuredAddressValue1,5);
		verifyMustExists(InsuredAddressValue1,"Insured Address Value");
		click(InsuredAddressValue1,"Insured Address Value");
		verifyMustExists(RightArrowIcon1,"RightArrowIcon1");
		click(RightArrowIcon1,"RightArrowIcon1");
		waitForElementToAppear(SaveButtonComplianceRule,5);
		verifyMustExists(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		click(SaveButtonComplianceRule,"SaveButtonComplianceRule");
		sleep(4000);
	}
	
	public void addSchema3(String Name,String ClassOfBusinessDDValue,String SchemaTypeDDValue)
	 {
	  if(isVisible(SchemaNameTxt)==true){
	   verifyMustExists(SchemaNameTxt,"Schema Name text field"); 
	   sendKeys(SchemaNameTxt,Name,"Schema Name field.");
	   SelectDropDownValue1(ClassOfBusinessDD,ClassOfBusinessDDValue2);
	   SelectDropDownValue1(SchemaTypeDD,SchemaTypeDDValue);
	   verifyMustExists(SaveBtn,"Save button");
	   click(SaveBtn,"Save button");
	  }else{
	   Report.LogInfo("verifyAddSchemaPage", "Add schema Page not dispalyed", "FAIL");
	  }
	 }
}



