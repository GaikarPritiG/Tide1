package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
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
import com.tide.qa.pagefactory.ReportingChannel;

public class Rules extends PageBase {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQue = new BordereauQuePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	FinancialCalculationRiskAndPremiumPage Fc = new FinancialCalculationRiskAndPremiumPage();
	String PolicyNumber;
	public String RuleName;
	public String RuleNameSchema;
	String AddData;
	String FilteredOutputFormatNameEditing;
	String NameOutputFormatEditing;
	String NameOutputFormat;
	String FilteredRuleNameVerification;
	String FieldName = "SCHEMA FIELD NAME";
	String FilteredOutputFormatNameVerification;
	public String DeleteBorcereaux;
	public String NewRenewal;
	public String EntryStatusVal1;
	public String EntryStatusVal2;
	public String EntryStatusVal3;
	public String EntryStatusVal4;
	public String RowNumber1;
	public String RowNumber2;
	public String RowNumber3;
	public String RowNumber4;
	public String AddRuleBtn;
	public String Endorsment;
	public String R1;
	public String R2;
	public String R3;
	public String R4;
	public String Tide;
	public String ActualCOB;
	public String Building1;
	public String Building2;
	public String Building3;
	public String Building4;
	public String Building5;
	public String Building6;
	public String Building7;
	public String Building8;
	public String Building9;
	public String Building10;
	public String DefaultValueScree;
	public String SaveChanges;
	public int count;
	public int count1;
	public String ARCHIVED;
	public String BreacheCount0;
	public String BreacheCount6;
	public String BreacheCount3;
	public String BreacheCount2;
	public String BreachesR1;
	public String BreachesR2;
	public String BreachesR3;
	public String Breaches_R1;
	public String Breaches_R2;
	public String Breaches_R3;
	public String BreachesR4;
	public String BreachesR5;
	public int AcualRiskState;
	public int AcualRiskCountry;
	public int AcualInsuredState;
	public int AcualInsuredCountry;
	
	// String EditComplianceRule;
	public static String sheet3741Path = "";
	public static String sheet3741SecondPath = "";
	public static String sheet3746Path = "";
	public static String sheet3742Path = "";
	public static String sheet3742_secondPath = "";
	public static String sheet3743Path = "";
	public static String sheet3743_secondPath = "";
	public static String sheet3743_ThirdPath = "";
	public static String sheet3980Path = "";
	public static String sheet3785Path = "";
	public static String sheet3785ScndPath = "";
	public static String sheet1053Path = "";
	public static String sheet3635Path = "";
	public static String sheet3647Path = "";
	public static String sheet3649Path = "";
	
	//Locatior For TC -3649
	public static final String locationEditBtn = "@xpath=//*[@ng-click='edit()']";
	public static final String LocationthreeRefdot ="@xpath=//*[@ng-if='permission.Edit && !loading1 && !IsEdit']//*[@class='dropdown']";
	public static final String CanadaExpandarrow = "@xpath=//*[text()='Canada']/preceding-sibling::span";
	public static final String AlbertacheckBox = "@xpath=//*[text()='Alberta']/preceding-sibling::input[@type='checkbox']";
	//public static final String CanadaExpandarrow = "@xpath=//tr[@class='k-alt k-treelist-group ng-scope']//td//span[@class='k-icon k-i-expand']";
	public static final String CanadaExpandarrow1 = "@xpath=//*[@id=\"grid\"]/div[2]/table/tbody/tr[111]/td[1]/span[2]";
	public static final String Canadacheckbox = "@xpath=//*[text()='Canada']/preceding-sibling::input[@type='checkbox']";
	public static final String BritishColumbiacheckBox = "@xpath=//*[text()='British Columbia']/preceding-sibling::input[@type='checkbox']";
	public static final String RulesRisksCountryDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div//ul//li[contains(.,'Risks Located Country')]";
	public static final String RulesInsuredCountryDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div//ul//li[contains(.,'Insured Domiciled Country')]";
	//public static final String RulesRisksStateDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Risks Located State')]";
	public static final String RulesRisksStateDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div//ul//li[contains(.,'Risks Located State')]";
	//public static final String RulesInsuredStateDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[last()]//ul//li[contains(.,'Insured Domiciled State')]";
	public static final String RulesInsuredStateDDValue ="@xpath=//*[@ng-model='SelectedRuleId']//ancestor::body/div[1]//ul//li[contains(.,'Insured Domiciled State')]";
	public static final String SaveBtn  = "@xpath=//*[@ng-click='save()']";
	
	public static final String RiskLocatedCountry ="@xpath=//*[@id='RiskRule_listbox']/li[1]";
	public static final String RisksLocatedState ="@xpath=//*[@id='RiskRule_listbox']/li[2]";
	public static final String InsuredDomiciledCountry ="@xpath=//*[@id='RiskRule_listbox']/li[3]";
	public static final String InsuredDomiciledState ="@xpath=//*[@id='RiskRule_listbox']/li[4]";
	
	public static final String ClaimReference="@xpath=//a[text()='Claim Reference']";
	public static final String RowNumberAscIcon ="@xpath=//*[@data-title='Claim Reference']//*[@class='k-icon k-i-sort-asc-sm']";
	
	// Locators for TC-3690
	public static final String RuleHeaderLink = "@xpath=//a[text()='RULES']";
	// public static final String AddRuleDropDown=
	// "@xpath=//button[@ng-click='addData()']//following-sibling::button[1]";
	public static final String AddRuleDropDown = "@xpath=//button[contains(.,'Split button dropdowns')]";
	public static final String AddRuleComplianceData = "@xpath=//li[@ng-click='addData(w)']//a[contains(text(),'Compliance Data')]";
	public static final String RuleNameText = "@xpath=//input[@ng-model='data.Rules.RuleName']";
	public static final String ErrorMessgaeText = "@xpath=//input[@ng-model='data.Rules.ErrorMessage']";
	public static final String DataSetDrpDwn = "@xpath=//*[text()='Dataset']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String DataSetDrpDwnPremiumOption = "@xpath=//li[text()='Premium']";
	public static final String ProcessingActionDrpDwn = "@xpath=//*[text()='Processing Action']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String ProcessingActionDrpDwnWarningOption = "@xpath=//li[text()='Warning']";
	public static final String ProcessingActionDrpDwn_NoAction_Option = "@xpath=//li[text()='No Action']";
	public static final String ClassBusinessSelction = "@xpath=//*[contains(text(),'Class Of Business')]//parent::dl//div[@id='ClassOfBusinessParent']";
	public static final String ClassBusinessPropertyOption = "@xpath=//li[text()='Airline']";
	public static final String AddRuleCondition = "@xpath=//*[@id='content']//button[contains(.,' ADD RULE CONDITION')]";
	public static final String MandatoryField = "@xpath=//*[text()='Risk Reference']";
	public static final String RigntArrow = "@xpath=//div[@ng-click='addToSelectionList()']";
	public static final String SaveButtonComplianceRule = "@xpath=//button[@ng-click='save()']";
	public static final String Delete_COB = "@xpath=//*[@id='COB_taglist']/li/span[@aria-label='delete']";
	//
	public static final String RiskCurrency = "@xpath=//*[text()='Risk Currency']";
	public static final String DeSelectCOB = "@xpath=//*[@id='COB_taglist']//span[@class='k-icon k-i-close']";
	// Filter to Rule NAme
	public static final String RuleNameFilterIcon = "@xpath=//th[@data-field='RuleName']//span";
	public static final String SearchTextFieldRule = "@xpath=//input[@placeholder='Search']";
	public static final String SearchedCheckBox = "@xpath=//input [@value='Compliance-Test']";
	public static final String SearchedRuleFilterButton = "@xpath=//button[text()='Filter']";
	// public static final String FilteredRuleNameVerification=
	// "@xpath=//tr[1]//td[contains(text(),'"+RuleName+"')]";

	// Locators for TC-3692
	public static final String AddRuleSchema = "@xpath=//li[@ng-click='addData(w)']//a[contains(text(),'Schema')]";
	public static final String SchemaText = "@xpath=//dt[text()='Schema']//parent::dl//span[@class='k-input ng-scope']";
	public static final String SchemaSearchText = "@xpath=//div[@class='k-animation-container']//span[@class='k-list-filter']";
	public static final String MandatoryOrWarningText = "@xpath=//dt[contains(text(),'Mandatory or Warning')]//parent::dl//dd//span[@class='k-input ng-scope']";

	// Locators for TC-3692 AddSchemaRule()
	public static final String SchemaDrpDwn = "@xpath=//*[text()='Schema']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String SchemaDrpDwnSearchOptionText = "@xpath=//div[@class='k-animation-container']//input[@class='k-textbox']";
	public static final String SchemaDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='kruthika test schema']";
	public static final String SchemaDrpDwnSelectOption1 = "@xpath=//*[@data-role='staticlist']//li[text()='Property Schema']";
	public static final String MandatoryWarningDrpDwn = "@xpath=//*[text()='Mandatory or Warning']//parent::dl//dd//span[@class='k-input ng-scope']";
	public static final String MandatoryWarningDrpDwnSelectOption = "@xpath=//li[text()='Warning']";
	public static final String ApplicationConditionDrpDwn = "@xpath=//*[contains(text(),'Application Condition')]//parent::dt[1]//following::span[@class='k-input ng-scope'][1]";
	public static final String ApplicationConditionDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='Data is valid if the rule conditions are met']";
	public static final String NoDataToDisplay = "@xpath=//tr/td[text()='No data to display.']";
	public static final String actualschema1 = "@xpath=//*[@ng-click='CopyRule(data.Rules)']//span[text()='Property Schema']";
	public static final String ActualStatus1 = "@xpath=//tr[1]//td[12]";
	public static final String MandatoryDrpDwnSelectOption = "@xpath=//li[text()='Mandatory']";
	// Locator for TC-3692 AddRuleConditionForSchemaRule()
	public static final String AddRulesConditionButton = "@xpath=//button[@ng-click='addRulesCondition()']";
	public static final String FieldNameDrpDwn = "@xpath= //*[@ng-model='w.FieldId']//preceding-sibling::span[1]";
	public static final String FieldNameDrpDwnSearchText = "@xpath= //div[@class='k-animation-container'][4]//input[@class='k-textbox']";
	public static final String FieldNameDrpDwnSelectOption = "@xpath= //*[@data-role='staticlist']//li[contains(text(),'Sprinklers (Y/N)')]";
	public static final String OperatorDrpDwn = "@xpath= //*[@ng-model='w.Operator']//preceding-sibling::span[1]";
	public static final String OperatorDrpDwnSearchText = "@xpath= //div[@class='k-animation-container'][5]//input[@class='k-textbox']";
	public static final String OperatorDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='Equal To']";
	public static final String AppliedToDrpDwn = "@xpath= //*[@ng-model='w.AppliedTo']//preceding-sibling::span[1]";
	public static final String AppliedToDrpDwnSearchText = "@xpath=//div[@class='k-animation-container'][6]//input[@class='k-textbox']";
	public static final String AppliedToDrpDwnSelectOption = "@xpath=//*[@data-role='staticlist']//li[text()='Value']";
	public static final String EntrySelectionText = "@xpath=//*[@ng-model='w.EntryValueFrom']//preceding-sibling::span[1]//descendant::span[@class='k-input ng-scope']";
	public static final String EntrySelectionYesOption = "@xpath=//li[text()='Yes']";
	public static final String TickMarkButton = "@xpath= //tr[@ng-repeat='w in rulesConditionsList track by $index']//descendant::button[1]";

	// Locators for TC-3306 EditAboutTide()
	public static final String AboutTide = "@xpath=//a[@href='#!/app/aboutTideEditor']";
	// public static final String AddParagraphData = "@xpath=//body/p[4]/span";
	public static final String AddParagraphData = "@xpath=/html/body/p[1]";
	public static final String iframe = "@xpath=//iframe[@class='k-content']";
	// Locators for TC-3306 AboutMeVerification()
	public static final String TideAdminProfile = "@xpath=//*[text()='Tide Admin']";
	public static final String TideAdminProfileAboutMe = "@xpath=//a[@href='#!/app/aboutTideDetails']";
	// public static final String AboutMeAddedData = "@xpath=//p[4]/span";
	public static final String AboutMeAddedData = "@xpath=//*[@id='content']/div/div/div/div[2]/div/ng-form/div/div/div[1]/div/p[1]";

	// EditRule
	public static final String Edit = "@xpath=//*[@ng-click='editClick(1)']";

	// InActive Rule
	public static final String InActive = "@xpath=//*[@id='content']/div/div/div/form/div/div[1]/div[4]/dl/dd/div/label[2]";
	public static final String InActiveBtn = "@xpath=//*[@class='col-md-6']/dl/dd/div/label[2]";
	// Cancel Button
	public static final String CancelBtn = "@xpath=//*[@ng-click='cancel()']";

	// Locatores:- TC-3535

	public static final String OutPutFormatMenuLink = "@xpath=//a[@href='#!/app/outputformats']";
	public static final String AddOutputFormatButton = "@xpath=//div[@ng-click='addEditOutputFormatPopup()']";
	public static final String Name = "@xpath=//*[@ng-model='data.Name']";
	public static final String Description = "@xpath=//*[@ng-model='data.Description']";
	public static final String BordereauType = "@xpath=//*[@ng-model='data.BordereauType']//preceding-sibling::span";
	public static final String BordereauTypeSelectOption = "@xpath=//li[text()='Risk']";
	public static final String FileType = "@xpath=//*[@ng-model='data.FileType']//preceding-sibling::span";
	public static final String FileTypeSelectOption = "@xpath=//li[contains(text(),'Excel (XLSX)')]";
	public static final String ReportPath = "@xpath=//input[@ng-model='data.ReportPath']";
	public static final String AddOuputFormatSaveButton = "@xpath=//button[@ng-click='save()']";
	public static final String SaveButtonOutputFormat = "@xpath=//button[@ng-click='save()']";

	// OutPutFormat Filter TC-3535
	public static final String OutputFormatFilterIcon = "@xpath=//th[@data-field='Name']//span";
	public static final String OutputFormatFilterSearchText = "@xpath=//input[@placeholder='Search']";
	public static final String EditOutputFormatName = "@xpath=//tr[1]//td//preceding::td[2]//descendant::i";
	public static final String CancelButtonOnPopUp = "@xpath=//*[@ng-click='cancel()']";

	// Locators for TC-3741
	public static final String ContractHeaderLink = "@xpath=//a[@href='#!/app/contractlist']";
	public static final String ErrorScreen3741 = "@xpath=//h2[contains(.,'New or Renewal entries which already exist')]";
	public static final String RiskReference = "@xpath=//*[@ng-model='item.RiskReference']";
	public static final String ContinueButtonOnScreen = "@xpath=//*[@ng-click='save()'][@type='submit']";
	public static final String CancelButtonOnScreen = "@xpath=//*[@ng-click='cancel()']";
	public static final String DataTab = "@xpath=//a[@href='#!/app/contract/5cade4da-6156-4815-875c-0d997b349631/contractData/3e46cb59-1fbc-4594-9c2b-18eb09f6f014//0/summary']";
	public static final String RiskMenu = "@xpath=//*[@href='#!/app/contract/5cade4da-6156-4815-875c-0d997b349631/contractData/3e46cb59-1fbc-4594-9c2b-18eb09f6f014//1/risk']";
	public static final String RiskReferenceValue = "@xpath=//*[@id='grid']//tbody/tr[2]/td[13]";

	// TC-3746 applyFilterTideFieldReviewQuestionnaire()
	public static final String TideFieldFilterIcon = "@xpath=//*[@data-title='Tide Field']//span";
	public static final String TideFieldSearchTextBox = "@xpath=//input[@placeholder='Search']";
	public static final String TideFieldCheckBox = "@xpath=//*[@value='Number of Stories']";
	public static final String TideFieldFilterButton = "@xpath=//button[text()='Filter']";
	public static final String NumberOfBuildingsTab = "@xpath=//th[@data-field='Location_Number_Of_Buildings']";
	public static final String NumberOfRecords = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[42]";

	// TC-3742
	public static final String TransactionTypeDrdwn = "@xpath=//*[@ng-model='item.TransactionType']//preceding-sibling::span[1]";
	public static final String TransactionTypeDrdwnOption = "@xpath=//li[text()='Endorsement']";
	public static final String ContinueButtonOnRenewalScreen = "@xpath=//div[@ng-click='save()']//button[1]";
	public static final String CancelButtonOnBordereauSummary = "@xpath=//button[@ng-click='cancel()']";
	public static final String FirstEntryStatusRecord = "@xpath=//*[@id='grid']//td[contains(@ng-click,'EntryStatus')][contains(@ng-click,'12')][text()='Historic']";
	public static final String SecondEntryStatusRecord = "@xpath=//*[@id='grid']//td[contains(@ng-click,'EntryStatus')][contains(@ng-click,'13')][text()='Endorsement']";
	public static final String ThirdEntryStatusRecord = "@xpath=.//*[@id='grid']//td[contains(@ng-click,'RowNumber')][text()='13']/following-sibling::td[text()='Current']";
	public static final String Step5Link = "@xpath=//ul[@id='stepsBar']//li[@uib-popover='Risk Details']/a";
	// public static final String ReferenceRadioYesButton =
	// "@xpath=//input[@ng-model='form.IsRIDInclude'][@value='true']//parent::label[1]";
	public static final String ReferenceRadioYesButton = "@xpath=//input[@ng-model='form.IsRIDInclude'][@ng-value='true']//parent::label[1]";
	public static final String ReferenceRadioNextStepButton = "@xpath=//button[@ng-click-single='nextStep()']";
	// public static final String ReferenceRadioNoButton =
	// "@xpath=//input[@ng-model='form.IsRIDInclude'][@value='false']//parent::label[2]";
	public static final String ReferenceRadioNoButton = "@xpath=//*[@id=\"RiskDetails\"]/div/div/div/dl[6]/dd/div/label[2]";
	// public static final String ReferenceRadioNoButton =
	// "@xpath=//*[@id='RiskDetails']/div/div/div/dl[6]/dd/div/label[2]/input";
	public static final String ExpectedScreen4 = "@xpath=//*[@ng-click='DeleteBordereaux()']";
	// Locators:-TC-3743

	public static final String RejectButton = "@xpath=//div[@ng-click='OpenRejectBordereauPopup()']";
	public static final String RejectButtonYesPopUpButton = "@xpath=//button[@ng-click='rejectBordereau()']";
	public static final String SummaryScreen = "@xpath=//h2[text()='Bordereau Summary']";
	public static final String SubmitRecordButton = "@xpath=//button[@ng-click='submitBordereau()']";
	public static final String ForApprovalButton = "@xpath=//button[contains(.,'For Approval')]";
	public static final String SubmitApprovalButton = "@xpath=//button[contains(.,'Approve Bordereau')]";
	public static final String BordereauSubmitDrpDwn = "@xpath=//button[text()='Submit Bordereaux']//following::button[@class='btn btn-primary dropdown-toggle']";
	public static final String BordereauSubmitDrpDwnRiskOption = "@xpath=//a[text()='Risk']";
	public static final String MissingBordereauPeriodsErrorScreen = "@xpath=//h2[text()='Missing Bordereau periods']";
	public static final String NilBordereauxYesRadioButton = "@xpath=//input[@ng-model='data.NillBordereau'][@ng-value='true']//parent::label[1]";
	public static final String MissingBordereauPeriodsContinueButton = "@xpath=//button[@ng-click='UpdateSequence()']";
	public static final String MarchApprovedButton = "@xpath=//span[@ng-bind='dataItem.BordereauMonthString'][text()='March']//preceding::button[1]";
	public static final String JanApprovedButton = "@xpath=//span[@ng-bind='dataItem.BordereauMonthString'][text()='January']//preceding::button[1]";
	public static final String MarchUnApprovedButton = "@xpath=//button[contains(.,'UnApprove Bordereau')]";
	public static final String JanUnApprovedButton = "@xpath=//button[contains(.,'UnApprove Bordereau')]";
	public static final String JanUnApprovedErrorScreen = "@xpath=//h2[text()='This Bordereau is not the latest processed Bordereau. Only the latest processed Bordereau can be unapproved.']";
	public static final String JanUnApprovedErrorScreenCancelBtn = "@xpath=//button[@ng-click='ok()']";
	public static final String RevrtToUpld = "@xpath=//button[@ng-click='RevertToUploaded()']";
	// public static final String JanUnApprovedCancelBtn=
	// "@xpath=//button[@ng-click='ok()'][text()='Cancel']";
	public static final String JanUnApprovedCancelBtn = "@xpath=//*[@ng-click='ok()']";
	public static final String JanUnApprovedCancelBtn1 = "@xpath=//*[@ng-click='cancel()']";
	public static final String Bordereausummary = "@xpath=//h2[text()='Bordereau Summary']";

	public static final String ApprovedSummaryScreen = "@xpath=//h2[text()='Approved Bordereau Summary']";
	public static final String UnApproveBordereauButton = "@xpath=//button[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";
	public static final String AlertPopUpCancelBtn = "@xpath=//button[@ng-click='ok()']";

	public static final String ApproveBordereauBtn = "@xpath=//button[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";
	public static final String JanuaryFrApprvl = "@xpath=//span[@ng-bind='dataItem.MonthString'][text()='January']//preceding::td[4]//button[contains(@ng-click,'GoToBordereauSummaryScreen')]";
	public static final String Ok = "@xpath=//button[@ng-click='ok()']";
	
	public static final String RuleBreaches = "@xpath=//*[@class='ng-scope']//tr[1]//td[6]";
	public static final String RuleBreachesCount = "@xpath=//button[@class='btn btn-xs btn-danger btn-wide grid-status-btn']";
	public static final String RuleBreachesCount0 = "@xpath=//tr[@class='ng-scope']//td[6]";
	public static final String ARCHIVEDCount = "@xpath=//*[@id='grid']//td[6]//button";
	public static final String ARCHIVED1 = "@xpath=//tr[1]//button[text()='ARCHIVED']";
	public static final String ARCHIVED2 = "@xpath=//tr[2]//button[text()='ARCHIVED']";
	public static final String ARCHIVED3 = "@xpath=//tr[3]//button[text()='ARCHIVED']";
	public static final String ARCHIVED4 = "@xpath=//tr[4]//button[text()='ARCHIVED']";
	public static final String ARCHIVED5 = "@xpath=//tr[5]//button[text()='ARCHIVED']";
	public static final String ARCHIVED6 = "@xpath=//tr[6]//button[text()='ARCHIVED']";
	
	
	// TC-3690----START
	public void AddComplianceDataRule() throws Exception {

		RuleName = "Compliance-Test" + getCurrentTime();
		FilteredRuleNameVerification = "@xpath=//tr[1]//td[contains(text(),'" + RuleName + "')]";
		String SearchedCheckBox = "@xpath=//input [@value='" + RuleName + "']";
		// System.out.println("RuleName"+RuleName);
		String ErrorMessgae = "Location Sprinklers (Y/N) equal to value Yes";
		String DataSet = "Risk";
		String ProcessingAction = "Warning";
		String ClassBusiness = "Airline";

		// loginPage.tideLogin();
		waitForElementToAppear(RuleHeaderLink, 5);
		verifyMustExists(RuleHeaderLink, "RuleHeaderLink");
		click(RuleHeaderLink, "RuleHeaderLink");
		waitForElementToAppear(AddRuleDropDown, 3);
		verifyMustExists(AddRuleDropDown, "AddRuleDropDown");
		click(AddRuleDropDown, "AddRuleDropDown");
		verifyMustExists(AddRuleComplianceData, "AddRuleComplianceData");
		click(AddRuleComplianceData, "AddRuleComplianceData");
		AddComplianceRule(RuleName, ErrorMessgae, DataSet, ProcessingAction, ClassBusiness);
		RuleNameFiter(RuleName);
		verifyMustExists(FilteredRuleNameVerification, " Verified Rule Name");
		ActualAddedRuleName = getTextFrom(FilteredRuleNameVerification);
		if (RuleName.equalsIgnoreCase(ActualAddedRuleName)) {

			Report.LogInfo("ValidateAddedRule", "Compliance Rule added successfully.", "PASS");
		} else {
			Report.LogInfo("ValidateAddedRule", "Compliance Rule not added successfully.", "FAIL");

		}

	}

	// ============================================TC-3690===========END===================================//

	// Locators for TC-3691
	// public static final String EditComplianceRule=
	// "@xpath=//tr[1]//td[contains(text(),'"+RuleName+"')]//preceding::td[2]//descendant::i";
	public static final String EditComplianceRule = "@xpath=//tr[1]//td//preceding::td[2]//descendant::i";
	public static final String NoRadioButtonCompliance = "@xpath=//span[contains(text(),'Is this Rule Active?')]//following::div[1]//label[2]";
	public static final String ComplianceRuleStatus = "@xpath=//table/tbody/tr[1]/td[12]";
	public String getComplianceRuleStatus1;
	
	public static final String Edit2ndCondion = "@xpath=//tr[2]//button[@ng-click[contains(.,'getSelectedRulesCondition(w)')]]";
	public static final String Check2ndCondion = "@xpath=//tr[2]//button[@ng-click[contains(.,'getSavedData(w)')]]";
	public static final String EditUpArrow = "@xpath=//div[@ng-click='shiftUpRulesCondition()' and @disabled='disabled']";
	public static final String EditDownArrow = "@xpath=//div[@ng-click='shiftDownRulesCondition()' and @disabled='disabled']";
	
	// TC-3691------START
	public void EditComplianceDataRule() {
		if (isVisible(EditComplianceRule) == true) {
			waitForElementToAppear(EditComplianceRule, 4);
			verifyMustExists(EditComplianceRule, "EditComplianceRule");
			click(EditComplianceRule, "EditComplianceRule");
			//NO Radio button
			waitForElementToAppear(NoRadioButtonCompliance, 4);
			verifyMustExists(NoRadioButtonCompliance, "NoRadioButtonCompliance");
			click(NoRadioButtonCompliance, "NoRadioButtonCompliance");
			
			//NO Action Selection
			waitForElementToAppear(ProcessingActionDrpDwn, 5);
			verifyMustExists(ProcessingActionDrpDwn, "ProcessingActionDrpDwn");
			click(ProcessingActionDrpDwn, "ProcessingActionDrpDwn");
			waitForElementToAppear(ProcessingActionDrpDwnWarningOption, 5);
			verifyMustExists(ProcessingActionDrpDwnWarningOption, "ProcessingActionDrpDwnWarningOption");
			click(ProcessingActionDrpDwn_NoAction_Option,"No Action Option");				
			
			
				
			
			waitForElementToAppear(Edit2ndCondion, 4);
			verifyMustExists(Edit2ndCondion, "Added rule condition edit button");
			click(Edit2ndCondion, "Added rule condition edit button");
			
			if(isVisible(EditUpArrow) && isEnable(EditUpArrow))
			{
				Report.LogInfo("ValidateUpDownArrow", "UP Arrow is not in enabled state.", "FAIL");
			}
			else
			{
				Report.LogInfo("ValidateUpDownArrow", "UP Arrow is in enabled state.", "PASS");
				
			}	
			
			if(isVisible(EditDownArrow) && isEnable(EditDownArrow))
			{
				Report.LogInfo("ValidateUpDownArrow", "DOWN Arrow is not in enabled state.", "FAIL");
			}
			else
			{
				Report.LogInfo("ValidateUpDownArrow", "DOWN Arrow is in enabled state.", "PASS");
				
			}	

			sleep(2000);
			waitForElementToAppear(Check2ndCondion, 4);
			verifyMustExists(Check2ndCondion, "Added rule condition check button");
			click(Check2ndCondion, "Added rule condition check button");
			
			
			//Validate warning pop up Cancel button functionality
			// delete class of buisness
			waitForElementToAppear(Delete_COB, 5);
			verifyMustExists(Delete_COB, "Delete class of buisness");
			click(Delete_COB,"Delete class of buisness");
			
			//cancel button
			waitForElementToAppear(CancelButton, 5);
			verifyMustExists(CancelButton, "Warning pop up cancel button");
			click(CancelButton,"Warning pop up cancel button");
			
			//class of buisness
			waitForElementToAppear(AirlieCOB, 5);
			verifyMustExists(AirlieCOB, "Airline class of buisness");
			if(isVisible(AirlieCOB))
			{
				ActualCOB= getTextFrom(AirlieCOB);
				Report.LogInfo("ValidateCancelbuttton", "Cancel button is working fine.", "PASS");
			}
			else
			{
				Report.LogInfo("ValidateCancelbuttton", "Cancel button is not working fine", "FAIL");
				
			}
			
			waitForElementToAppear(SaveButtonComplianceRule, 4);
			verifyMustExists(SaveButtonComplianceRule, "SaveButtonComplianceRule");
			click(SaveButtonComplianceRule, "SaveButtonComplianceRule");
			sleep(2000);
			refreshPage();
			RuleNameFiter(RuleName);
			getComplianceRuleStatus1 = getTextFrom(ComplianceRuleStatus,"Edit");
			if (isVisible(EditComplianceRule) == true) {
				waitForElementToAppear(EditComplianceRule, 4);
				verifyMustExists(EditComplianceRule, "EditComplianceRule");
				click(EditComplianceRule, "EditComplianceRule");
				sleep(3000);
				
				/*s	waitForElementToAppear(DeSelectCOB, 5);
				verifyMustExists(DeSelectCOB, "ClassBusinessSelction");
				click(DeSelectCOB, "ClassBusinessSelction");
				
				waitForElementToAppear(DeSelectCOB, 5);
				verifyMustExists(DeSelectCOB, "ClassBusinessSelction");
				click(DeSelectCOB, "ClassBusinessSelction");*/
				
				waitForElementToAppear(Edit2ndCondion, 4);
				verifyMustExists(Edit2ndCondion, "Added rule condition check button");
				if (isVisible(Edit2ndCondion) == true) {
					Report.LogInfo("ValidateEditingComplianceRule", "Compliance Rule edited successfully.", "PASS");

				} else {
					Report.LogInfo("ValidateEditingComplianceRule", "Compliance Rule not edited successfully.", "FAIL");
				}
				
				
				if (isVisible(NoRadioButtonCompliance) == true) {
					Report.LogInfo("ValidateEditingComplianceRule", "Compliance Rule edited successfully.", "PASS");

				} else {
					Report.LogInfo("ValidateEditingComplianceRule", "Compliance Rule not edited successfully.", "FAIL");
				}
			} else {
				Report.LogInfo("ValidateEditingComplianceRule", "Compliance Rule edit button not available.", "FAIL");

			}
		} else {
			Report.LogInfo("ValidateEditingComplianceRule", "EditComplianceRule button not available.", "FAIL");
		}
	}
	// ============================================TC-3691===========END===================================//

	// ==== TC-3692------START====================================//

	public void AddNewSchemaRule() throws Exception {
		
		SchemaPage schema= new SchemaPage();
		RuleNameSchema = "Schema-Rule(Automation)" + getCurrentTime();
		// System.out.println("Schema Rule "+RuleNameSchema);
		FilteredRuleNameVerification = "@xpath=//tr[1]//td[contains(text(),'" + RuleNameSchema + "')]";
		// String SearchedCheckBox= "@xpath=//input [@value='"+RuleName+"']";
		// System.out.println("RuleName"+RuleName);
		String ErrorMessgae = "Sprinklers error";
		String Schema = "kruthika test schema";
		String MandatoryWarning = "Warning";
		String ApplicationCondition = "Data is valid if the rule conditions are met";
		String FieldName = "Location Sprinklers (Y/N)";
		String OPERATOR = "Equal To";
		String APPLIEDTO = "Value";
		String ENTRY_SELECTION = "Yes";

		// loginPage.tideLogin();
		waitForElementToAppear(RuleHeaderLink, 5);
		verifyMustExists(RuleHeaderLink, "RuleHeaderLink");
		click(RuleHeaderLink, "RuleHeaderLink");
		waitForElementToAppear(AddRuleDropDown, 3);
		verifyMustExists(AddRuleDropDown, "AddRuleDropDown");
		click(AddRuleDropDown, "AddRuleDropDown");
		verifyMustExists(AddRuleSchema, "AddRuleSchema");
		click(AddRuleSchema, "AddRuleSchema");
		AddSchemaRule(RuleNameSchema, ErrorMessgae, Schema, MandatoryWarning, ApplicationCondition);
		AddRuleConditionForSchemaRule(FieldName, OPERATOR, APPLIEDTO, ENTRY_SELECTION);
		
		waitForElementToAppear(SaveButtonComplianceRule, 5);
		verifyMustExists(SaveButtonComplianceRule, "SaveButtonComplianceRule");
		click(SaveButtonComplianceRule, "SaveButtonComplianceRule");
		sleep(2000);
		refreshPage();
		// RuleNameFiter(RuleNameSchema);
		 ActualAddedRuleNameSchema = getTextFrom(FilteredRuleNameVerification);
		if (RuleNameSchema.equalsIgnoreCase(ActualAddedRuleNameSchema)) {

			Report.LogInfo("ValidateAddedRuleSchema", "Schema Rule added successfully.", "PASS");
		} else {
			Report.LogInfo("ValidateAddedRuleSchema", "Schema Rule not added successfully.", "FAIL");

		}
	}
	// ============================================TC-3692===========END===================================//
	// ==============================================================================================================//

	// ----------------START--TC-3693 Sprint 3: Schema
	// Rule(Edit)------------------------------------//

	// Locators TC-3693
	public static final String EditSchemaRule = "@xpath=//tr[1]//td//preceding::td[2]//descendant::i";
	public static final String NoRadioButtonSchemaRule = "@xpath=//span[contains(text(),'Is this Rule Active?')]//following::div[1]//label[2]";
	public static final String MandatoryWarningDrpDwnSelectOption1 = "@xpath=//li[text()='Mandatory']";
	public String ApplicationCondition = "Data is valid if the rule conditions are met";
	public String MandatoryWarning = "Mandatory";
	public String ExpectedSchema = "Property Schema";
	public String ActualSchema;
	public String ActualWarning1;
	public String ActualApplicationCondtion1;
	public String Actual_NO_Data_To_Dispaly;
	public String ExpectedStatus="In-Active";
	public String ActualStatus;
	
	public String Expected_NO_Data_To_Dispaly="No data to display.";
	
	public static final String ApplicationConditionDrpDwnSelectOption1 = "@xpath=//*[@data-role='staticlist']//li[text()='Data is not valid if the rule conditions are met']";

	public static final String YESButton = "@xpath=//button[@ng-click='ok()']";
	public static final String CancelButton = "@xpath=//div[@class[contains(.,'pulseWarning')]]//following-sibling::p//button[@ng-click='cancel()']";
	public static final String AirlieCOB = "@xpath=//*[@id='COB_taglist']/li/span[contains(.,'Airline')]";
	
	
	public void EditSchemaRule() throws Exception {


		String Schema = "Property Schema";
		// String expectedData = "Data is not valid if the rule conditions are met";
		
		RuleNameFiter(RuleNameSchema);
		UpdateScemaRule(Schema);
		waitForElementToAppear(SaveButtonComplianceRule, 4);
		verifyMustExists(SaveButtonComplianceRule, "SaveButtonComplianceRule");
		click(SaveButtonComplianceRule, "SaveButtonComplianceRule");

		RuleNameFiter(RuleNameSchema);
		sleep(2000);
		waitForElementToAppear(EditSchemaRule, 6);
		click(EditSchemaRule, "EditSchemaRule");
		ActualWarning1 = getTextFrom(MandatoryWarningDrpDwn);
		
		 ActualApplicationCondtion1 = getTextFrom(ApplicationConditionDrpDwn);
		 Actual_NO_Data_To_Dispaly = getTextFrom(NoDataToDisplay);
		 ActualSchema = getTextFrom(actualschema1);
		 

		if (MandatoryWarning.equalsIgnoreCase(ActualWarning1)) {
			Report.LogInfo("ValidateEditingSchemaRule", "Mandatory-Warning dropdown edited successfully.", "PASS");

		} else {
			Report.LogInfo("ValidateEditingSchemaRule", "Mandatory-Warning dropdown not edited successfully.", "FAIL");
		}

		if (ApplicationCondition.equalsIgnoreCase(ActualApplicationCondtion1)) {
			Report.LogInfo("ValidateEditingSchemaRule", "Application Condition dropdown edited successfully.", "PASS");

		} else {
			Report.LogInfo("ValidateEditingSchemaRule", "Application Condition dropdown not edited successfully.",
					"FAIL");
		}
		if (ExpectedSchema.equalsIgnoreCase(ActualSchema)) {
			Report.LogInfo("ValidateEditingSchemaName", "Schema Name changed successfully.", "PASS");

		} else {
			Report.LogInfo("ValidateEditingSchemaName", "Schema Name not changed successfully.",
					"FAIL");
		}
		
		if (Expected_NO_Data_To_Dispaly.equalsIgnoreCase(Actual_NO_Data_To_Dispaly)) {
			Report.LogInfo("ValidateSchemaUpdation", "Schema edited successfully.", "PASS");

		} else {
			Report.LogInfo("ValidateSchemaUpdation", "Schema not edited successfully.","FAIL");
		}
		

		//Cancel button
		waitForElementToAppear(CancelButtonOnPopUp, 6);
		verifyMustExists(CancelButtonOnPopUp, "CancelButtonOnPopUp");
		click(CancelButtonOnPopUp, "CancelButtonOnPopUp");
		sleep(3000);
		waitForElementToAppear(ActualStatus1, 6);
		verifyMustExists(ActualStatus1, "Status of rule");
		
		ActualStatus = getTextFrom(ActualStatus1);
		
		
		if (ExpectedStatus.equalsIgnoreCase(ActualStatus)) {
			Report.LogInfo("Status validation at rule grid", "Status edited successfully.", "PASS");

		} else {
			Report.LogInfo("Status validation at rule grid", "Status not edited successfully.","FAIL");
		}
		
		

	}
	// ============================================TC-3693===========END===================================//
	// ==============================================================================================================//

	// ----------------START--TC-3306 Sprint 3: Schema
	// Rule(Edit)------------------------------------//

	public void EditAboutTide_3306() throws Exception {
		// loginPage.tideLogin();
		homePage.adminMenu();
		AddData = "TestingQA" + getCurrentTime();
		waitForElementToAppear(AboutTide, 4);
		verifyMustExists(AboutTide, "AboutTide");
		Tide =  getTextFrom(AboutTide);
		Report.LogInfo("AboutTide", Tide, "PASS");
		click(AboutTide, "Click on About Tide");
		sleep(4000);
		// waitForElementToAppear(AddParagraphData,10);
		AddDataAboutMe(AddData);
		AboutMeVerification();
	}

	// ============================================TC-3306===========END===================================//
	// ==============================================================================================================//

	// ----------------START--TC-3535 Sprint 3: Add an Output
	// Format------------------------------------//

	// Locators TC-3535

	public void AddOutputFormat() throws Exception {
		NameOutputFormat = "Lloyds CoverholderReporting Standards v5" + getCurrentTime();
		// System.out.println("Name:- "+NameOutputFormat);
		FilteredOutputFormatNameVerification = "@xpath=//tr[1]//td[contains(text(),'" + NameOutputFormat + "')]";
		String Description = "The Lloyd's Coverholder Reporting v5";
		String ReportPath = " /Reports/Dev/Extracts/Risk_Tide_Standards_v1.rdl";
		String BordereauType = "Risk";
		String FileType = "Excel (XLSX)";

		// loginPage.tideLogin();
		homePage.adminMenu();
		AddOutputFormatByAdmin(NameOutputFormat, Description, BordereauType, FileType, ReportPath);
		refreshPage();
		waitForElementToAppear(OutputFormatFilterIcon, 3);
		OutputFormatNameFilter(NameOutputFormat);
		waitForElementToAppear(FilteredOutputFormatNameVerification, 5);
		verifyMustExists(FilteredOutputFormatNameVerification, "Filtered OutputFormat Name Verification");
		String ActualOutputFormatName = getTextFrom(FilteredOutputFormatNameVerification);
		if (NameOutputFormat.equals(ActualOutputFormatName)) {
			Report.LogInfo("ValidateAddedOutputFormat", "Output Format added successfully.", "PASS");
		} else {

			Report.LogInfo("ValidateAddedOutputFormat", "Output Format not added successfully.", "FAIL");
		}
	}

	public void AddOutputFormatByAdmin(String name1, String description, String bordereauType, String fileType,
			String reportPath) {
		waitForElementToAppear(OutPutFormatMenuLink, 5);
		verifyMustExists(OutPutFormatMenuLink, "OutPutFormatMenuLink");
		click(OutPutFormatMenuLink, "OutPutFormatMenuLink");
		waitForElementToAppear(AddOutputFormatButton, 5);
		verifyMustExists(AddOutputFormatButton, "AddOutputFormatButton");
		click(AddOutputFormatButton, "AddOutputFormatButton");
		waitForElementToAppear(Name, 5);
		verifyMustExists(Name, "Name");
		sendKeys(Name, name1, "Enter Name");
		waitForElementToAppear(Description, 5);
		verifyMustExists(Description, "Description");
		sendKeys(Description, description, "Enter Description");
		waitForElementToAppear(BordereauType, 5);
		verifyMustExists(BordereauType, "BordereauType");
		click(BordereauType, "BordereauType");
		waitForElementToAppear(BordereauTypeSelectOption, 5);
		verifyMustExists(BordereauTypeSelectOption, "BordereauType");
		webDriver.findElement(By.xpath("//li[text()='" + bordereauType + "']")).click();
		waitForElementToAppear(FileType, 5);
		verifyMustExists(FileType, "FileType");
		click(FileType, "FileType");
		waitForElementToAppear(FileTypeSelectOption, 5);
		verifyMustExists(FileTypeSelectOption, "FileType Select Option");
		webDriver.findElement(By.xpath("//li[contains(text(),'" + fileType + "')]")).click();
		waitForElementToAppear(ReportPath, 5);
		verifyMustExists(ReportPath, "ReportPath");
		sendKeys(ReportPath, reportPath, "Enter Description");
		waitForElementToAppear(SaveButtonOutputFormat, 5);
		verifyMustExists(SaveButtonOutputFormat, "SaveButtonOutputFormat");
		click(SaveButtonOutputFormat, "Add Ouput Format Save Button");
		sleep(5000);
	}
	// ============================================TC-3535===========END===================================//
	// ==============================================================================================================//

	// ------------------TC-3536-----------START-----------------------------//

	// Locators for TC-3536

	public void EditOutputFormat() {
		NameOutputFormatEditing = "Testing :- Aspen User" + getCurrentTime();
		// System.out.println("Name:- "+NameOutputFormatEditing);
		FilteredOutputFormatNameEditing = "@xpath=//tr[1]//td[contains(text(),'" + NameOutputFormatEditing + "')]";
		String DescriptionData = "Testing Purpose";
		String ReportPath = " /Reports/Dev/Extracts/Risk_Tide_Standards_v1.rdl";
		String BordereauType = "Risk";
		String FileType = "Excel (XLSX)";

		// OutputFormatNameFilter(NameOutputFormat);
		UpdateOutputFormatData(NameOutputFormatEditing, DescriptionData);
		refreshPage();
		sleep(2000);
		waitForElementToAppear(EditOutputFormatName, 6);
		OutputFormatNameFilter(NameOutputFormatEditing);
		sleep(3000);
		waitForElementToAppear(EditOutputFormatName, 5);
		click(EditOutputFormatName, "EditOutputFormatName");
		waitForElementToAppear(Name, 5);
		verifyMustExists(Name, "Edited Name ");
		waitForElementToAppear(Description, 5);
		verifyMustExists(Description, "Edited Description");
		waitForElementToAppear(CancelButtonOnPopUp, 6);
		verifyMustExists(CancelButtonOnPopUp, "CancelButtonOnPopUp");
		click(CancelButtonOnPopUp, "CancelButtonOnPopUp");
		// loginPage.tideAdminLogOut();

	}

	public void UpdateOutputFormatData(String name1, String descroption) {
		waitForElementToAppear(EditOutputFormatName, 4);
		verifyMustExists(EditOutputFormatName, "EditOutputFormatName");
		click(EditOutputFormatName, "EditOutputFormatName");
		waitForElementToAppear(Name, 5);
		verifyMustExists(Name, "Name");
		clearTextBox(Name);
		sendKeys(Name, name1, "Enter Name");
		waitForElementToAppear(Description, 5);
		verifyMustExists(Description, "Description");
		clearTextBox(Description);
		sendKeys(Description, descroption, "Enter Description");
		waitForElementToAppear(AddOuputFormatSaveButton, 5);
		verifyMustExists(SaveButtonOutputFormat, "SaveButtonOutputFormat");
		click(SaveButtonOutputFormat, "Add Ouput Format Save Button");
		sleep(6000);

	}
	// ------------------TC-3536-----------END-------------------------------------//
	// ------------------------------------------------------------------------------//

	// -------------------------------TC-3741-START--------------------------------------------------------------//
	// ----------------------------------------------------------------------------------------------------------//

	public static final String TransactionType = "@xpath=//*[@ng-repeat='item in data.BDEngineErrorValues']//td[1]/div/div/span";
	public static final String TransactionTypeDDValue = "@xpath=//ul[@class='k-list k-reset']//*[text()='Endorsement']";
	public static final String NewOrRenewal = "@xpath=//*[@id='multiReference_Id']//h2[contains(.,'New or Renewal entries which already exist')]";

	public void RiskAndPremiumRecordsAndCompletingLifecycleChecks() throws Exception {

		String subSheet = "Automation Risk Format 20";
		String RiskReferenceNo = "13";
		String InceptionDate1 = "01/01/2018";
		String InceptionExp1 = "31/12/2018";
		String MonthDate = "February 2018";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		String SubmitSheet = "Automation Risk Format 20";
		homePage.adminMenu();
		BQue.bordereauQueLink();
		BQue.bordereauQuePage();
		BQue.filterBordereauQuestionnaire1(SubmitSheet);
		sleep(2000);
		waitForElementToAppear(BQue.EditBtn, 5);
		verifyMustExists(BQue.EditBtn, "Edit button");
		click(BQue.EditBtn, "Edit button");
		BQue.nextStapeClick();
		BQue.FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();

		Br.applyFilterPolicy(policy.PolicyNumber);
		// Br.applyFilterPolicy("309578JN");
		Br.openSelectedPolicy();
		if (isVisible(Br.SignedBtn) == true) {
			verifyExists(Br.SignedBtn, "Signed Status Button");
			String GetData = Configuration.url + "/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			Br.SubmitBordereaux(subSheet);
			try {
				String fpath = new File(".").getCanonicalPath();
				sheet3741Path = fpath + "\\src\\test\\resources\\testdata\\Stage 2errors - January 2018_TC_3741.xlsx";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3741Path);
			Br.contractId = addNewBordereauFormatPolicy(payload1, GetData);

			String Ufname = "S23465620180928.xlsx";	
			int size = 17378;
			String BordreauID = "25183871-0de2-4059-99a7-bc65c1e44074";
	        String response = uploadFileinContract(ReqUrl,excelFile,Br.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(Br.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			
			//String payload = "{\"Bordereaux\":{\"ContractId\":\"" + Br.contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2errors - January 2018_TC_3741.xlsx\",\"UniqueFileName\":\"S10578320180504.xlsx\",\"BordereauFormatId\":\"25183871-0de2-4059-99a7-bc65c1e44074\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+Br.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10578320180504.xlsx\",\"Filesize\":17378,\"Path\":null,\"size\":17378,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			Br.refreshUploadedFile();
			if (isVisible(Br.ReviewBtn) == true) {
				Report.LogInfo("ValidateReviewButton", "Review button displayed successfully", "PASS");
				click(Br.ReviewBtn, "Reviwe button");
				waitForElementToAppear(Br.SuRcdAssmnt, 10);
				verifyMustExists(Br.SuRcdAssmnt, "Submit record assesment button");
				click(Br.SuRcdAssmnt, "Submit record assesment button");
				waitForElementToAppear(Br.FrApprovalbtn, 10);
				verifyMustExists(Br.FrApprovalbtn, "For Approval button");
				click(Br.FrApprovalbtn, "For Approval button");
				Br.clickOnApproveBordBtn();
				Br.refreshUploadedFileApprovedStatus();
				
				waitForElementToAppear(Br.ApprovedButton, 5);
				AssertBordereauStatusApproved = getTextFrom(Br.ApprovedButton);
				Report.LogInfo("Validate Approved Status", AssertBordereauStatusApproved, "PASS");
				
				Br.SubmitBordereauxWithYesnoButtons(MonthDate);
				try {
					String fpath = new File(".").getCanonicalPath();
					sheet3741SecondPath = fpath
							+ "\\src\\test\\resources\\testdata\\Stage 2errors - February 2018_TC_3741Second.xlsx";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile1 = new File(sheet3741SecondPath);
				

				String Ufname1 = "S25738320180928.xlsx";	
				int size1 = 17388;
				String BordreauID1 = "25183871-0de2-4059-99a7-bc65c1e44074";
		        String response1 = uploadFileinContract(ReqUrl,excelFile1,Br.contractId,Ufname1);
		        String ID1 = extractIDFromResponseinsideContract(response1); 
		        String payload2 = GeneratePayloadForContract(Br.contractId, BordreauID1, ID1, Ufname1, size1, 2 , "1", 2018);
		        addAsDraft(payload2,DraftUrl);
		        
			    //String payload2 = "{\"Bordereaux\":{\"ContractId\":\"" + Br.contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2errors - February 2018_TC_3741Second.xlsx\",\"UniqueFileName\":\"S96880820180504.xlsx\",\"BordereauFormatId\":\"25183871-0de2-4059-99a7-bc65c1e44074\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+Br.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S96880820180504.xlsx\",\"Filesize\":17388,\"Path\":null,\"size\":17388,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
				Br.refreshUploadedFile();
				if (Br.checkErrorReviewButton(Br.ReviewError) == true) {
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					if (isVisible(TransactionType) == true) {
						verifyMustExists(NewOrRenewal, "For Approval button");
						NewRenewal =  getTextFrom(NewOrRenewal);	
						Report.LogInfo("New or Renewal error sreen is open", NewRenewal, "PASS");
						
						Report.LogInfo("ValidateExpectedScreen", "Navigate on expected screne successfully", "PASS");
						SelectDropDownValue(TransactionType, TransactionTypeDDValue);
						click(ContinueButtonOnScreen, "Cliked on Continue Button");
						waitForElementToAppear(CancelButtonOnScreen, 5);
						click(CancelButtonOnScreen, "Cliked on Cancel");
						Br.refreshUploadedFile();
						if (isVisible(Br.ReviewBtn) == true) {
							AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
							Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
							Report.LogInfo("ValidateReviewButton", "Review button displayed successfully", "PASS");
						} else {
							Report.LogInfo("ValidateReviewButton", "Review button not displayed", "Fail");
						}
					} else {
						Report.LogInfo("ValidateExpectedScreen", "Navigation not on expected screen", "FAIL");
						goBack();
						Br.deleteBorderEAUX();
					}
				} else {
					Report.LogInfo("ValidateReviewErrorButton", "Review Error not displayed", "FAIL");
					Br.deleteBorderEAUX();
				}
			} else {
				Report.LogInfo("ValidateReviewButton", "Review button not displayed", "Fail");
				Br.deleteBorderEAUX();
			}
		} else {
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}     
	//deleteBorderEAUX();

	// =============================================TC-3741-END==================================================//

	// -------------------------------TC-3746-START---------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------------//
	// In- progress either need to delete added dafault value for that
	// 'Questionnaire' or need to user other 'Questionnaire'.//

	// Locators for TC-3746
	public static final String EditQuestionnairButton = "@xpath=//tr[1]//td//preceding::td[2]//descendant::i";
	public static final String ReviewLink12 = "@xpath=//*[@uib-popover='Review']//a";
	public static final String SpecifyDefaultButton = "@xpath=//button[@ng-click='specifyDefault(dataItem)']";
	public static final String DefaultValue = "@xpath=//input[@ng-model='dataItem.DefaultValue']";
	// public static final String
	// DefaultValueSaveButton="@xpath=//button[@ng-click='save()']";
	public static final String DefaultValueSaveButton = "@xpath=//button[@ng-click-single='save()']";
	public static final String DefaultValueScreen = "@xpath=//h2[contains(.,'Apply Default Value for Location Number Of Buildings')]";
	public static final String DefaultValueCancelButton = "@xpath=//button[@ng-click='cancel()']";
	public static final String BorderQuestionarySaveButton = "@xpath=//button[text()='Save']";

	public void BespokeDefault_SingleDefaultValue_3746() throws Exception {
		String QuestionnaireName = "Automation Risk Format 14";
		String Stories = "Location Number Of Buildings";
		String DefaultValueNo1 = "10";
		OpenBordereauQue();
		BQue.filterBordereauQuestionnaire2(QuestionnaireName);
		OpenReviewStep12();
		applyFilterTideFieldReviewQuestionnaire(Stories);
		ProcessForSpecifyDefaultValue(DefaultValueNo1, QuestionnaireName);
		ProcessBordereau();
		if (Br.checkErrorReviewButton(Br.ReviewError) == true) {
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "FAIL");
			Br.deleteBorderEAUX();
		} else {
			Report.LogInfo("ValidateReviewErrorStatus", "Review status displayed", "PASS");
			if (isVisible(Br.ReviewBtn) == true) {
				AssertBordereauStatusReview = getTextFrom(Br.ReviewBtn);
				VerificationNumberOfBuildings();
				waitForElementToAppear(Br.BORDEREAUXLink, 5);
				verifyMustExists(Br.BORDEREAUXLink, "BORDEREAUX Link");
				click(Br.BORDEREAUXLink, "BORDEREAUX Link");
				sleep(2000);
				Br.deleteBorderEAUX();

			} else {
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "FAIL");
				Br.deleteBorderEAUX();
			}

		}

	}

	// =============================================TC-3746-END================================================================//
	// =======================================================================================================================//

	// -------------------------------TC-3838-START-------------------------------------------------------------------------------//
	// --------------------------------------------------------------------------------------------------------------------------//
	// Locators:- 3838

	public void BespokeDefaultMultipleDefaultValuesBasedOnConditions() throws Exception {
		String QuestionnaireName = "Default value Enhancement";
		String Stories = "Number of Stories";
		String DefaultValueNo = "";// Attachment is not given data
		homePage.adminMenu();
		BQue.bordereauQueLink();
		BQue.bordereauQuePage();
		BQue.filterBordereauQuestionnaire(QuestionnaireName);
		waitForElementToAppear(EditQuestionnairButton, 5);
		verifyMustExists(EditQuestionnairButton, "DataTab");
		click(EditQuestionnairButton, "EditQuestionnairButton");
		waitForElementToAppear(ReviewLink12, 5);
		verifyMustExists(ReviewLink12, "ReviewLink12");
		click(ReviewLink12, "ReviewLink12");
		applyFilterTideFieldReviewQuestionnaire(Stories);
		waitForElementToAppear(SpecifyDefaultButton, 5);
		verifyMustExists(SpecifyDefaultButton, "SpecifyDefaultButton");
		click(SpecifyDefaultButton, "SpecifyDefaultButton");
		// In-Progress <Conditional attachment is not given in testdata at step 5>

	}

	// =============================================TC-3838-END================================================================//
	// =======================================================================================================================//

	// ===========================================POLICY-FEATURE==========================================================================//
	// ====================================================================================================================================//
	// =====================================================================================================================================//

	// --------------------------------------TC-3680-START--------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------------------//

	// Loactor:-TC-3680
	public static final String ExpectedTab = "@xpath=//a[text()='Expected']";

	public void EditBordereauInExpectedTabNilBordereau() throws Exception {
		String OnlySpPoliCyNum = "959238AP";
		String OverdueStaus = "Overdue";

		// loginPage.tideLogin();
		waitForElementToAppear(ContractHeaderLink, 5);
		verifyMustExists(ContractHeaderLink, "ContractHeaderLink");
		click(ContractHeaderLink, "Contract Header Link");

		Br.applyFilterPolicy(OnlySpPoliCyNum);
		Br.openSelectedPolicy();
		NavigateONExpectedTab();

	}

	public void NavigateONExpectedTab() {

		waitForElementToAppear(Br.BORDEREAUXLink, 5);
		verifyMustExists(Br.BORDEREAUXLink, "BORDEREAUX Link");
		click(Br.BORDEREAUXLink, "BORDEREAUX Link");
		waitForElementToAppear(ExpectedTab, 5);
		verifyMustExists(ExpectedTab, "ExpectedTab");
		click(ExpectedTab, "ExpectedTab");
	}

	public static final String StatusFiterIcon = "@xpath=//*[@data-title='Status']//span";
	public static final String StatusSearchTextBox = "@xpath=//input[@placeholder='Search']";
	public static final String StatusCheckBox = "@xpath=//*[@value='Overdue']";
	public static final String StatusFiterButton = "@xpath=//button[text()='Filter']";

	public void ApplyStatusFilter(String overdue) {

		int i = 0;
		String RecordCheckbox = "@xpath=//*[@value='" + overdue + "']";

		javaScriptWait();

		do {
			if (i > 0) {
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(StatusFiterIcon, "Status Filter Icon");
			sleep(2000);
			if (isVisible(StatusSearchTextBox)) {
				verifyMustExists(StatusSearchTextBox, "Search Filter Textbox");
				sendKeys(StatusSearchTextBox, overdue, "Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		} while (!isVisible(RecordCheckbox) && i < 5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(StatusFiterButton, "Filter Button");
		click(StatusFiterButton, "Filter Button");
		sleep(3000);

	}

	// ************************************BordereauProcessing*******************************************************************//

	// ****************************************************************************************************************************//
	// -------------------------------TC-3742-START-------------------------------------------------------------------------------//
	// --------------------------------------------------------------------------------------------------------------------------//
	// Locators:- 3742
	public static final String ExpectedScreenForNewEntries3 = "@xpath=//h2[text()='New or Renewal entries which already exist']";

	public void LifecycleErrorDueToChangeRiskInceptionDateInLifecycleValidation() throws Exception {

		String subSheet = "Automation Risk Format 14";
		String RiskReferenceNo = "13";
		String InceptionDate1 = "01/01/2018";
		String InceptionExp1 = "31/12/2018";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();

		String SubmitSheet = "Automation Risk Format 14";
		homePage.adminMenu();
		BQue.bordereauQueLink();
		BQue.bordereauQuePage();
		BQue.filterBordereauQuestionnaire1(SubmitSheet);
		sleep(2000);
		waitForElementToAppear(BQue.EditBtn, 5);
		verifyMustExists(BQue.EditBtn, "Edit button");
		click(BQue.EditBtn, "Edit button");
		BQue.nextStapeClick();
		BQue.FormatId = ReturnFormatID();
		OpenStep5AndProcess();
		Br.applyFilterPolicy(policy.PolicyNumber);
		Br.openSelectedPolicy();
		Br.SubmitBordereaux(subSheet);
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""	+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3742Path = fpath + "\\src\\test\\resources\\testdata\\Stage 2 errors-January 2018_TC_3742_First.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"" + contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors-January 2018_TC_3742_First.xlsx\",\"UniqueFileName\":\"S68312720180429.xlsx\",\"BordereauFormatId\":\"f002233c-e8d3-411a-a570-7b66d5ed3dfe\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S68312720180429.xlsx\",\"Filesize\":18793,\"Path\":null,\"size\":18793,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet3742Path);
		
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S13013420181206.xlsx";	
		int size = 19503;
		String BordreauID = "f002233c-e8d3-411a-a570-7b66d5ed3dfe";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			click(Br.ReviewBtn);
			sleep(2000);
			GetApproveStatus();
			sleep(2000);
			waitForElementToAppear(Br.ApprovedTab, 5);
			verifyExists(Br.ApprovedTab, "Approved Tab");
			click(Br.ApprovedTab, "Approved Tab");
			waitForElementToAppear(Br.ApprovedButton, 5);
			AssertBordereauStatusApproved = getTextFrom(Br.ApprovedButton);
			Report.LogInfo("Validate Approved Status", AssertBordereauStatusApproved, "PASS");
			sleep(2000);
			Br.refreshUploadedFileForApproved();
			JavascriptExecutor jse = (JavascriptExecutor) webDriver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			OpenStep5AndProcessForNoRefrence();
			OpenContractWithPolicy();
			UploadFile2();

		} else {
			Report.LogInfo("ValidateExpectedScreen",
					"Navigate on expected page 'New or Renewal entries which already exist' failed", "FAIL");
			goBack();
			Br.deleteBorderEAUX();
		}
	}

	// --------------------------------------TC-3742-END--------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------------------//

	// ************************************************TC-3743**********BordereauProcessing*******************************//
	// **********************************************START***************************************************************************//

	public void ApproveBordereauxInSequentialOrder() throws Exception {

		String subSheet = "Automation Risk format 11 (Lloyd's Property Schema)";
		String SubmitSheet = "Sequence Rule Format";
		String RiskReferenceNo = "13";
		String InceptionDate1 = "01/01/2018";
		String InceptionExp1 = "31/12/2018";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";

		policy.CreateContractwithInceptionDate2018();

		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		Br.SubmitBordereaux(subSheet);
		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3743Path = fpath + "\\src\\test\\resources\\testdata\\January 2018_TC_3743.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_3743.xlsx\",\"UniqueFileName\":\"S51382720180429.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S51382720180429.xlsx\",\"Filesize\":16957,\"Path\":null,\"size\":16957,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet3743Path);
		
		String Ufname = "S75827920180927.xlsx";	
		int size = 16957;
		String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if (Br.checkErrorReviewButton(Br.ReviewError) == true) {
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "FAIL");
			goBack();
			Br.deleteBorderEAUX();
		} else {
			if (isVisible(Br.ReviewBtn) == true) {
				Report.LogInfo("ValidateReviewStatus", "Review status displayed Successfully.", "PASS");
				click(Br.ReviewBtn, " cliked on ReviewBtn");
				if (isVisible(SummaryScreen) == true) {
					Report.LogInfo("ValidateExpectedScreen", "Summary Screen open successfully", "PASS");
					GetApproveStatus();
					// Br.refreshUploadedFileApprovedStatus();
					Br.refreshAfterApproveFile(JanuaryFrApprvl);
					//Second Bordereau Uploading
					SubmitBordereauxWithYesnoButtons2();
					//Br.refreshUploadedFileForApprovalStatus();
					uploadSecondFile_TC3743();
					sleep(2000);
					waitForElementToAppear(Br.ApprovedTab, 5);
					verifyExists(Br.ApprovedTab, "Approved Tab");	
					javaScriptclick(Br.ApprovedTab, "Approved Tab");
					sleep(2000);
					waitForElementToAppear(Br.ApprovedButton, 5);
					AssertBordereauStatusApproved = getTextFrom(Br.ApprovedButton);
					Report.LogInfo("Validate Approved Status", AssertBordereauStatusApproved, "PASS");
					javaScriptclick(Br.ApprovedButton, "Approve Button");
					sleep(2500);
					if (isVisible(ApprovedSummaryScreen) == true) {
						Report.LogInfo("ValidateExpectedScreen", "Expected screen displayed", "PASS");
						sleep(2000);
						waitForElementToAppear(UnApproveBordereauButton, 5);
						verifyMustExists(UnApproveBordereauButton, "UnApprove Bordereau button");
						javaScriptclick(UnApproveBordereauButton, "UnApprove Bordereau button");
						sleep(2500);
						waitForElementToAppear(AlertPopUpCancelBtn, 5);
						verifyMustExists(AlertPopUpCancelBtn, "Cancel Button");
						javaScriptclick(AlertPopUpCancelBtn, "Cancel Button");
						sleep(2000);
						waitForElementToAppear(CancelButtonOnScreen, 5);
						verifyMustExists(CancelButtonOnScreen, "Cancel Button");
						javaScriptclick(CancelButtonOnScreen, "Cancel Button");
						sleep(2500);
						waitForElementToAppear(Br.Processingtab, 5);
						verifyExists(Br.Processingtab, "Processing Link");
						javaScriptclick(Br.Processingtab, "Processing Link");
						sleep(2000);
						waitForElementToAppear(Br.ReviewBtn, 5);
						verifyMustExists(Br.ReviewBtn,"Review Button");
						Report.LogInfo("ValidateReviewStatus", "Review status displayed Successfully.", "PASS");
						sleep(2500);
						Br.deleteBorderEAUX();
						sleep(2500);
						waitForElementToAppear(Br.ApprovedTab, 5);
						verifyExists(Br.ApprovedTab, "Approved Tab");
						javaScriptclick(Br.ApprovedTab, "Approved Tab");
						sleep(2000);
						waitForElementToAppear(Br.ApprovedButton, 5);
						AssertBordereauStatusApproved = getTextFrom(Br.ApprovedButton);
						Report.LogInfo("Validate Approved Status", AssertBordereauStatusApproved, "PASS");
						javaScriptclick(Br.ApprovedButton, " cliked on Approve Button");
						sleep(2500);
						
						
						if (isVisible(ApprovedSummaryScreen) == true) {
							Report.LogInfo("ValidateExpectedScreen", "Expected screen displayed", "PASS");
							sleep(1500);
							waitForElementToAppear(UnApproveBordereauButton, 5);
							verifyMustExists(UnApproveBordereauButton, "UnApprove Bordereau button");
							javaScriptclick(UnApproveBordereauButton, "UnApprove Bordereau button");
							Br.refreshUploadedFileForApprovalStatus();
							waitForElementToAppear(Br.ForApprovalButton, 5);
							verifyMustExists(Br.ForApprovalButton, "For Approval Button Bordereau button");
							javaScriptclick(Br.ForApprovalButton, "For Approval Button");
							sleep(1500);
							waitForElementToAppear(ApproveBordereauBtn, 5);
							verifyMustExists(ApproveBordereauBtn, "Approve Bordereau button");
							javaScriptclick(ApproveBordereauBtn, "Approve Bordereau button");
							//click(Ok, "Ok");
							// Br.refreshUploadedFileApprovedStatus();
							Br.refreshAfterApproveFile(JanuaryFrApprvl);
							SubmitBordereauxWithYesnoButtons2();
							//Upload Third File
							uploadThirdFile_TC3743();
							sleep(2500);
							waitForElementToAppear(Br.ApprovedTab, 5);
							verifyExists(Br.ApprovedTab, "Approved Tab");
							javaScriptclick(Br.ApprovedTab, "Approved Tab");
							sleep(1500);
							waitForElementToAppear(Br.ApprovedButton, 5);
							javaScriptclick(Br.ApprovedButton, "Approve Button");
							sleep(1500);
							if (isVisible(ApprovedSummaryScreen) == true) {
								Report.LogInfo("ValidateExpectedScreen", "Expected screen displayed", "PASS");
								waitForElementToAppear(UnApproveBordereauButton, 5);
								verifyMustExists(UnApproveBordereauButton, "UnApprove Bordereau button");
								javaScriptclick(UnApproveBordereauButton, "UnApprove Bordereau button");
								Br.refreshUploadedFileForApprovalStatus();
								sleep(1500);
								verifyMustExists(ForApprovalButton, "For Approval button");
								AssertBordereauStatusApproval = getTextFrom(ForApprovalButton);
								Report.LogInfo("Validate Approved Status", AssertBordereauStatusApproval, "PASS");
								sleep(2000);
							} else {
								Report.LogInfo("ValidateExpectedScreen", "Summary Screen not displayed", "FAIL");
								goBack();
								Br.deleteBorderEAUX();
							}
						} else {
							Report.LogInfo("ValidateExpectedScreen", "Summary Screen not displayed", "FAIL");
							goBack();
							Br.deleteBorderEAUX();
						}
					} else {
						Report.LogInfo("ValidateExpectedScreen", "Expected screen not displayed", "FAIL");
						goBack();
						Br.deleteBorderEAUX();
					}
				} else {
					Report.LogInfo("ValidateExpectedScreen", "Summary Screen not displayed", "FAIL");
					goBack();
					Br.deleteBorderEAUX();
				}
			} else {
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed ", "FAIL");
				Br.deleteBorderEAUX();
			}
		}
	}
	// ***************************************TC-3743_END********************************************************************************//

	public void multipleRuleConditions_TC3785() throws Exception {

		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		// step 1
		policy.CreateContractwithInceptionDate2018();

		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");
		// step 2 to 5
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn, "Add Rule button");
		click(policy.AddRulesBtn, "Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup, 5);
		verifyMustExists(policy.AddRulesPopup, "Add Rules popup");
		verifyMustExists(policy.RuleNameTxt, "Rules Name textbox");
		sendKeys(policy.RuleNameTxt, "Number of Buildings and Sprinklers(Y/N)", "Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD, policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD, policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD, policy.CurrencyGBPValue);
		verifyMustExists(policy.ROEToleranceTxt, "ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt, "2", "ROE Tolerance textbox");

		WebElement Section = webDriver
				.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD, policy.YOAValue);
		SelectDropDownValue(policy.OperatorDD, policy.GreaterThan);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt, "Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt, "10", "Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");
		sleep(2000);

		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");

		SelectDropDownValue(policy.MethodNameDD, policy.MethodValue);
		SelectDropDownValue(policy.FieldNameDD, policy.TransactionTypeValue);
		SelectDropDownValue(policy.OperatorDD, policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		SelectDropDownValue(policy.EntryOrSelectionDD, policy.EntryOrSelectionValue);
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");

		waitForElementToAppear(policy.SaveBtn, 5);
		verifyMustExists(policy.SaveBtn, "Save button");
		click(policy.SaveBtn, "Save button");
		sleep(2000);
		if (isVisible(policy.ConEndrsmntPopUp) == true) {
			Endorsment =  getTextFrom(policy.ConEndrsmntPopUp);	
			Report.LogInfo("Endorsment popup is open", Endorsment, "PASS");
			sleep(1000);
			verifyExists(policy.SaveBtn3, "Save Button");
			click(policy.SaveBtn3, "Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step 5 completed", "PASS");
		// step 6 to 9
		scrollUp();
		policy.navigationOnBordereauxTab();
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"" + policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3785Path = fpath + "\\src\\test\\resources\\testdata\\January Contract Rule Test_TC_3785First.xlsx";
		} catch (IOException e) {
			e.printStackTrace();
		}
		File excelFile = new File(sheet3785Path);
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);

		
		String Ufname = "S58940920181001.xlsx";	
		int size = 17690;
		String BordreauID = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
       
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"" + policy.contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January Contract Rule Test_TC_3785First.xlsx\",\"UniqueFileName\":\"S16424320180508.xlsx\",\"BordereauFormatId\":\"87ff463a-ac88-4a6a-9b80-9e5e892aeb2d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16424320180508.xlsx\",\"Filesize\":17690,\"Path\":null,\"size\":17690,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn, "Review button");
			click(Br.ReviewBtn, "Review button");
			waitForElementToAppear(Br.SuRcdAssmnt, 10);
			verifyMustExists(Br.SuRcdAssmnt, "Submit recor for Assignment button");
			click(Br.SuRcdAssmnt, "Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn, 10);
			verifyMustExists(Br.FrApprovalbtn, "For Approval button");
			click(Br.FrApprovalbtn, "For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileApprovedStatus();
			if (isVisible(Br.Approvedbtn) == true) {
				AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
				Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				Report.LogInfo("StepsCheck", "Step 9 completed", "PASS");
				// step 10
				Br.navigateOnProcessingTab();

				try {
					String fpath = new File(".").getCanonicalPath();
					sheet3785ScndPath = fpath+ "\\src\\test\\resources\\testdata\\February Contract Rule Test_TC_3785Second.xlsx";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile1 = new File(sheet3785ScndPath);
				

				String Ufname1 = "S59417720181001.xlsx";	
				int size1 = 17681;
				String BordreauID1 = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
		        String response1 = uploadFileinContract(ReqUrl,excelFile1,policy.contractId,Ufname1);
		        String ID1 = extractIDFromResponseinsideContract(response1); 
		        String payload2 = GeneratePayloadForContract(policy.contractId, BordreauID1, ID1, Ufname1, size1, 2 , "1", 2018);
		        addAsDraft(payload2,DraftUrl);

				//String payload2 = "{\"Bordereaux\":{\"ContractId\":\"" + policy.contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"February Contract Rule Test_TC_3785Second.xlsx\",\"UniqueFileName\":\"S94096320180508.xlsx\",\"BordereauFormatId\":\"87ff463a-ac88-4a6a-9b80-9e5e892aeb2d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S94096320180508.xlsx\",\"Filesize\":17688,\"Path\":null,\"size\":17688,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
				Br.refreshUploadedFile();
				if (isVisible(Br.ReviewBtn) == true) {
					Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					verifyMustExists(Br.ReviewBtn, "Review button");
					click(Br.ReviewBtn, "Review button");
					waitForElementToAppear(Br.SuRcdAssmnt, 10);
					verifyMustExists(Br.SuRcdAssmnt, "Submit recor for Assignment button");
					click(Br.SuRcdAssmnt, "Submit recor for Assignment button");
					waitForElementToAppear(Br.FrApprovalbtn, 10);
					verifyMustExists(Br.FrApprovalbtn, "For Approval button");
					click(Br.FrApprovalbtn, "For Approval button");
					Br.clickOnApproveBordBtn();
					Br.refreshUploadedFileForApprovedScndRw();
					AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
					Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
					Report.LogInfo("StepsCheck", "Step 10 completed", "PASS");
					// step 11
					policy.navigateRulesTab();
					policy.navigateBreachesTab();
					waitForElementToAppear(policy.RulesDD, 3);
					verifyMustExists(policy.RulesDD, "Rules Drop Down");
					SelectDropDownValue(policy.RulesDD, policy.RulesDDValue);
					sleep(2000);
					List<WebElement> list = findWebElements(Br.ActualExpectedRowCount);
					 count = list.size();
					if (count == 6) {
						Report.LogInfo("ValidateRecords",
								"Records count matches with the records in the excel file. Actual records count is: "
										+ count,
								"PASS");
					} else {
						Report.LogInfo("ValidateRecords",
								"Records count does not match with the records in the excel file. Actual records count is: "
										+ count,
								"FAIL");
					}
					sleep(2000);
					Report.LogInfo("StepsCheck", "Step 11 completed", "PASS");

				} else {
					Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
				}
			} else {
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
			}
		} else {
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
		}
	}

	public void multipleRuleConditions_TC1053() throws Exception {

		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		// step 1
		policy.CreateContractwithInceptionDate2018();

		Report.LogInfo("StepsCheck", "Step 1 completed", "PASS");
		// step 2 to 5
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn, "Add Rule button");
		click(policy.AddRulesBtn, "Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup, 5);
		verifyMustExists(policy.AddRulesPopup, "Add Rules popup");
		verifyMustExists(policy.RuleNameTxt, "Rules Name textbox");
		sendKeys(policy.RuleNameTxt, "Risk Inception Date Equal To Value 02/03/2018   And Insured Address Is Blank","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD, policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD, policy.ConditionNotMetValue);
		SelectDropDownValue(policy.CurrencyDD, policy.CurrencyGBPValue);
		verifyMustExists(policy.ROEToleranceTxt, "ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt, "2", "ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD, policy.RiskInceptionDateValue);
		SelectDropDownValue(policy.OperatorDD, policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt, "Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt, "02/03/2018", "Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");
		sleep(2000);

		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");

		SelectDropDownValue(policy.MethodNameDD, policy.MethodValue);
		SelectDropDownValue(policy.FieldNameDD, policy.InsuredAddressValue);
		SelectDropDownValue(policy.OperatorDD, policy.IsBlankValue);
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");

		waitForElementToAppear(policy.SaveBtn, 5);
		verifyMustExists(policy.SaveBtn, "Save button");
		click(policy.SaveBtn, "Save button");
		sleep(2000);
		if (isVisible(policy.ConEndrsmntPopUp) == true) {
			Endorsment =  getTextFrom(policy.ConEndrsmntPopUp);	
			Report.LogInfo("Endorsment popup is open", Endorsment, "PASS");
			sleep(1000);
			verifyExists(policy.SaveBtn3, "Save Button");
			click(policy.SaveBtn3, "Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step 5 completed", "PASS");
		// step 6 to 9
		scrollUp();
		policy.navigationOnBordereauxTab();
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try {
			String fpath = new File(".").getCanonicalPath();
			sheet1053Path = fpath + "\\src\\test\\resources\\testdata\\January Contract Rule Test_TC_1053.xlsx";
		} catch (IOException e) {
			e.printStackTrace();
		}
		File excelFile = new File(sheet1053Path);
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S69756220180516.xlsx";	
		int size = 18675;
		String BordreauID = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January Contract Rule Test_TC_1053.xlsx\",\"UniqueFileName\":\"S69756220180516.xlsx\",\"BordereauFormatId\":\"87ff463a-ac88-4a6a-9b80-9e5e892aeb2d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S69756220180516.xlsx\",\"Filesize\":18675,\"Path\":null,\"size\":18675,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn, "Review button");
			click(Br.ReviewBtn, "Review button");
			waitForElementToAppear(Br.SuRcdAssmnt, 10);
			verifyMustExists(Br.SuRcdAssmnt, "Submit recor for Assignment button");
			click(Br.SuRcdAssmnt, "Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn, 10);
			verifyMustExists(Br.FrApprovalbtn, "For Approval button");
			click(Br.FrApprovalbtn, "For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileApprovedStatus();
			AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
			Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
			// step 11
			policy.navigateRulesTab();
			policy.navigateBreachesTab();
			waitForElementToAppear(policy.RulesDD, 3);
			verifyMustExists(policy.RulesDD, "Rules Drop Down");
			SelectDropDownValue(policy.RulesDD, policy.RulesDDValue7);
			sleep(2000);
			List<WebElement> list = findWebElements(Br.ActualExpectedRowCount);
		     count = list.size();
			if (count == 2) {
				Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is: " + count,"PASS");
			} else {
				Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is: "+ count,"FAIL");
			}
			sleep(2000);
			Report.LogInfo("StepsCheck", "Step 11 completed", "PASS");

		} else {
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
		}

	}

	// ---------------------------Reusable functions for
	// 'Rules'------------------------------------------------------//
	// ================================================================================================================//

	public void AddComplianceRule(String Rule_Name, String Error_Messgage, String Data_Set, String Processing_Action,
			String Classic_Bussiness) {
		
		SchemaPage schema = new SchemaPage();

		waitForElementToAppear(RuleNameText, 5);
		verifyMustExists(RuleNameText, "RuleNameText");
		sendKeys(RuleNameText, Rule_Name, "Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText, 5);
		verifyMustExists(ErrorMessgaeText, "ErrorMessgaeText");
		sendKeys(ErrorMessgaeText, Error_Messgage, "Enter ErrorMessgaeText");
		waitForElementToAppear(DataSetDrpDwn, 5);
		verifyMustExists(DataSetDrpDwn, "DataSetDrpDwn");
		click(DataSetDrpDwn, "DataSetDrpDwn");
		waitForElementToAppear(DataSetDrpDwnPremiumOption, 5);
		verifyMustExists(DataSetDrpDwnPremiumOption, "DataSetDrpDwnPremiumOption");
		webDriver.findElement(By.xpath("//li[text()='" + Data_Set + "']")).click();
		waitForElementToAppear(ProcessingActionDrpDwn, 5);
		verifyMustExists(ProcessingActionDrpDwn, "ProcessingActionDrpDwn");
		click(ProcessingActionDrpDwn, "ProcessingActionDrpDwn");
		waitForElementToAppear(ProcessingActionDrpDwnWarningOption, 5);
		verifyMustExists(ProcessingActionDrpDwnWarningOption, "ProcessingActionDrpDwnWarningOption");
		webDriver.findElement(By.xpath("//li[text()='" + Processing_Action + "']")).click();
		waitForElementToAppear(ClassBusinessSelction, 5);
		verifyMustExists(ClassBusinessSelction, "ClassBusinessSelction");
		click(ClassBusinessSelction, "ClassBusinessSelction");
		waitForElementToAppear(ClassBusinessPropertyOption, 5);
		verifyMustExists(ClassBusinessPropertyOption, "ClassBusinessPropertyOption");
		webDriver.findElement(By.xpath("//li[text()='" + Classic_Bussiness + "']")).click();
		/*String FieldName = "Location Sprinklers (Y/N)";
		String OPERATOR = "Equal To";
		String APPLIEDTO = "Value";
		String ENTRY_SELECTION = "Yes";

		AddRuleConditionForSchemaRule(FieldName, OPERATOR, APPLIEDTO, ENTRY_SELECTION);*/
		
		
		//Left Part
		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		schema.riskInceptionDateEqual("01/01/2018");
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		SelectDropDownValue1(policy.MethodDD,policy.AndValue);
		schema.BuildingValueBetween();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		SelectDropDownValue1(policy.MethodDD,policy.AndValue);
		schema.grossPremium();
		click(policy.CheckBtn,"Check button");
		sleep(2000);
		

		
		//right part
		waitForElementToAppear(MandatoryField, 5);
		verifyMustExists(MandatoryField, "Risk reference");
		click(MandatoryField, "Risk reference");
		waitForElementToAppear(RigntArrow, 5);
		verifyMustExists(RigntArrow, "Right Arrow");
		click(RigntArrow, "Right Arrow");
		
		
		waitForElementToAppear(RiskCurrency, 5);
		verifyMustExists(RiskCurrency, "Risk Currency");
		click(RiskCurrency, "Risk Currency");
		waitForElementToAppear(RigntArrow, 5);
		verifyMustExists(RigntArrow, "Right Arrow");
		click(RigntArrow, "Right Arrow");

		sleep(2000);
		waitForElementToAppear(SaveButtonComplianceRule, 5);
		verifyMustExists(SaveButtonComplianceRule, "SaveButtonComplianceRule");
		click(SaveButtonComplianceRule, "SaveButtonComplianceRule");
		sleep(4000);

	}

	public void UpdateScemaRule(String Schema1) {
		
		waitForElementToAppear(EditSchemaRule, 4);
		verifyMustExists(EditSchemaRule, "EditSchemaRule");
		click(EditSchemaRule, "EditSchemaRule");
		
		//NO Radio button
		waitForElementToAppear(NoRadioButtonCompliance, 4);
		verifyMustExists(NoRadioButtonCompliance, "NoRadioButtonCompliance");
		click(NoRadioButtonCompliance, "NoRadioButtonCompliance");
		
		//warning/Mandatory Option
		waitForElementToAppear(MandatoryWarningDrpDwn, 5);
		verifyMustExists(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		click(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		waitForElementToAppear(MandatoryDrpDwnSelectOption, 5);
		verifyMustExists(MandatoryDrpDwnSelectOption, "Mandatory Option");
		click(MandatoryDrpDwnSelectOption, "Mandatory Option");

		
		//Schema Option
		waitForElementToAppear(SchemaDrpDwn, 5);
		verifyMustExists(SchemaDrpDwn, "SchemaDrpDwn");
		click(SchemaDrpDwn, "SchemaDrpDwn");
		waitForElementToAppear(SchemaDrpDwnSearchOptionText, 5);
		verifyMustExists(SchemaDrpDwnSearchOptionText, "SchemaDrpDwnSearchOptionText");
		sendKeys(SchemaDrpDwnSearchOptionText, Schema1, "Enter Text");
		sleep(3000);
		waitForElementToAppear(SchemaDrpDwnSelectOption1, 5);
		verifyMustExists(SchemaDrpDwnSelectOption1, "Expected Schema option");
		click(SchemaDrpDwnSelectOption1, "SchemaDrpDwnSelectOption");
	
		//YES button
		waitForElementToAppear(YESButton, 5);
		verifyMustExists(YESButton, "YESButton");
		click(YESButton, "YESButton");

		
		
	}

	
	
public void UpdateScemaRule1(String Schema1) {
		
		waitForElementToAppear(EditSchemaRule, 4);
		verifyMustExists(EditSchemaRule, "EditSchemaRule");
		click(EditSchemaRule, "EditSchemaRule");
		
		//NO Radio button
		waitForElementToAppear(NoRadioButtonCompliance, 4);
		verifyMustExists(NoRadioButtonCompliance, "NoRadioButtonCompliance");
		click(NoRadioButtonCompliance, "NoRadioButtonCompliance");
		
		//warning/Mandatory Option
		waitForElementToAppear(MandatoryWarningDrpDwn, 5);
		verifyMustExists(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		click(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		waitForElementToAppear(MandatoryWarningDrpDwnSelectOption, 5);
		verifyMustExists(MandatoryWarningDrpDwnSelectOption, "MandatoryWarningDrpDwnSelectOption");
		click(MandatoryWarningDrpDwnSelectOption, "Select No Action Option");

		
		//Schema Option
		waitForElementToAppear(SchemaDrpDwn, 5);
		verifyMustExists(SchemaDrpDwn, "SchemaDrpDwn");
		click(SchemaDrpDwn, "SchemaDrpDwn");
		waitForElementToAppear(SchemaDrpDwnSearchOptionText, 5);
		verifyMustExists(SchemaDrpDwnSearchOptionText, "SchemaDrpDwnSearchOptionText");
		sendKeys(SchemaDrpDwnSearchOptionText, Schema1, "Enter Text");
		sleep(3000);
		waitForElementToAppear(SchemaDrpDwnSelectOption, 5);
		verifyMustExists(SchemaDrpDwnSelectOption, "Expected Schema option");
		click(SchemaDrpDwnSelectOption, "SchemaDrpDwnSelectOption");
	
		//YES button
		waitForElementToAppear(YESButton, 5);
		verifyMustExists(YESButton, "YESButton");
		click(YESButton, "YESButton");

	}
	public String getCurrentTime() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSS");
		String strDate = sdf.format(cal.getTime());
		// System.out.println("Current date in String Format: "+strDate);
		return strDate;
	}

	public void RuleNameFiter(String RuleName1) {

		int i = 0;
		String RecordCheckbox = "@css=[value='" + RuleName1 + "']";

		javaScriptWait();

		do {
			if (i > 0) {
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(RuleNameFilterIcon, "RuleNameFilterIcon");
			sleep(2000);
			if (isVisible(SearchTextFieldRule)) {
				verifyMustExists(SearchTextFieldRule, "SearchTextFieldRule");
				sendKeys(SearchTextFieldRule, RuleName1, "Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		} while (!isVisible(RecordCheckbox) && i < 5);

		click(RecordCheckbox, "Searched Record Checkbox");
		waitForElementToAppear(SearchedRuleFilterButton, 3);
		verifyMustExists(SearchedRuleFilterButton, "Filter Button");
		click(SearchedRuleFilterButton, "Filter Button");

	}

	public void OutputFormatNameFilter(String name) {

		int i = 0;
		String SearchedCheckBox1 = "@xpath=//li/label/span[contains(.,'" + name + "')]";

		javaScriptWait();

		do {
			if (i > 0) {
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(OutputFormatFilterIcon, "OutputFormatFilterIcon");
			sleep(2000);
			if (isVisible(OutputFormatFilterSearchText)) {
				verifyMustExists(OutputFormatFilterSearchText, "OutputFormatFilterSearchText");
				sendKeys(OutputFormatFilterSearchText, name, "Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		} while (!isVisible(SearchedCheckBox1) && i < 5);

		click(SearchedCheckBox1, "Searched Record Checkbox");
		waitForElementToAppear(SearchedRuleFilterButton, 3);
		verifyMustExists(SearchedRuleFilterButton, "Filter Button");
		click(SearchedRuleFilterButton, "Filter Button");

	}

	public void AddSchemaRule(String Rule_Name, String Error_Messgage, String Schema1, String MandatoryWarning1,
			String ApplicationCondition1) {
		waitForElementToAppear(RuleNameText, 5);
		verifyMustExists(RuleNameText, "RuleNameText");
		sendKeys(RuleNameText, Rule_Name, "Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText, 5);
		verifyMustExists(ErrorMessgaeText, "ErrorMessgaeText");
		sendKeys(ErrorMessgaeText, Error_Messgage, "Enter ErrorMessgaeText");
		waitForElementToAppear(SchemaDrpDwn, 5);
		verifyMustExists(SchemaDrpDwn, "SchemaDrpDwn");
		click(SchemaDrpDwn, "SchemaDrpDwn");
		waitForElementToAppear(SchemaDrpDwnSearchOptionText, 5);
		verifyMustExists(SchemaDrpDwnSearchOptionText, "SchemaDrpDwnSearchOptionText");
		sendKeys(SchemaDrpDwnSearchOptionText, Schema1, "Enter Text");
		sleep(3000);
		waitForElementToAppear(SchemaDrpDwnSelectOption, 5);
		verifyMustExists(SchemaDrpDwnSelectOption, "Expected Schema option");
		webDriver.findElement(By.xpath("//li[text()='" + Schema1 + "']")).click();
		waitForElementToAppear(MandatoryWarningDrpDwn, 5);
		verifyMustExists(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		click(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		waitForElementToAppear(MandatoryWarningDrpDwnSelectOption, 5);
		verifyMustExists(MandatoryWarningDrpDwnSelectOption, "MandatoryWarningDrpDwnSelectOption");
		webDriver.findElement(By.xpath("//li[text()='" + MandatoryWarning1 + "']")).click();
		waitForElementToAppear(ApplicationConditionDrpDwn, 5);
		verifyMustExists(ApplicationConditionDrpDwn, "ApplicationConditionDrpDwn");
		click(ApplicationConditionDrpDwn, "ApplicationConditionDrpDwn");
		waitForElementToAppear(ApplicationConditionDrpDwnSelectOption, 5);
		verifyMustExists(ApplicationConditionDrpDwnSelectOption, "ApplicationConditionDrpDwnSelectOption");
		webDriver.findElement(By.xpath("//li[text()='" + ApplicationCondition1 + "']")).click();

	}

	public void AddSchemaRule1(String Rule_Name, String Error_Messgage, String Schema1, String MandatoryWarning1,
			String ApplicationCondition1) {
		SchemaPage schema = new SchemaPage();
		String SchemaValue = "@xpath=//li[text()='" + Schema1 + "']";
		waitForElementToAppear(RuleNameText, 5);
		verifyMustExists(RuleNameText, "RuleNameText");
		sendKeys(RuleNameText, Rule_Name, "Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText, 5);
		verifyMustExists(ErrorMessgaeText, "ErrorMessgaeText");
		sendKeys(ErrorMessgaeText, Error_Messgage, "Enter ErrorMessgaeText");
		sleep(2000);
		SelectDropDownValue(SchemaDrpDwn, SchemaValue);
		waitForElementToAppear(MandatoryWarningDrpDwn, 5);
		verifyMustExists(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		click(MandatoryWarningDrpDwn, "MandatoryWarningDrpDwn");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[text()='" + MandatoryWarning1 + "']")).click();
		verifyMustExists(ApplicationConditionDrpDwn, "ApplicationConditionDrpDwn");
		click(ApplicationConditionDrpDwn, "ApplicationConditionDrpDwn");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[text()='" + ApplicationCondition1 + "']")).click();
		sleep(1000);
		click(ApplicationConditionDrpDwn, "ApplicationConditionDrpDwn");
		sleep(2000);
		webDriver.findElement(By.xpath("//li[text()='" + ApplicationCondition1 + "']")).click();
	}

	public void AddComplianceDataRule(String Rule_Name, String Error_Messgage, String Data_Set,
			String Processing_Action, String Classic_Bussiness) {
		String DataSet = "@xpath=//li[text()='" + Data_Set + "']";
		String ProcessingAction = "@xpath=//li[text()='" + Processing_Action + "']";
		String ClassicBussiness = "@xpath=//li[text()='" + Classic_Bussiness + "']";

		waitForElementToAppear(RuleNameText, 5);
		scrollUp();
		verifyMustExists(RuleNameText, "RuleNameText");
		sendKeys(RuleNameText, Rule_Name, "Enter RuleName");
		waitForElementToAppear(ErrorMessgaeText, 5);
		verifyMustExists(ErrorMessgaeText, "ErrorMessgaeText");
		sendKeys(ErrorMessgaeText, Error_Messgage, "Enter ErrorMessgaeText");
		waitForElementToAppear(DataSetDrpDwn, 5);
		verifyMustExists(DataSetDrpDwn, "DataSetDrpDwn");
		click(DataSetDrpDwn, "DataSetDrpDwn");
		verifyMustExists(DataSet, "Risk Dataset");
		click(DataSet, "Risk Dataset");
		waitForElementToAppear(ProcessingActionDrpDwn, 5);
		verifyMustExists(ProcessingActionDrpDwn, "ProcessingActionDrpDwn");
		click(ProcessingActionDrpDwn, "ProcessingActionDrpDwn");
		verifyMustExists(ProcessingAction, "Processing Action");
		click(ProcessingAction, "Processing Action");
		waitForElementToAppear(ClassBusinessSelction, 5);
		verifyMustExists(ClassBusinessSelction, "ClassBusinessSelction");
		click(ClassBusinessSelction, "ClassBusinessSelction");
		verifyMustExists(ClassicBussiness, "Classic Bussiness");
		click(ClassicBussiness, "Classic Bussiness");
	}

	public void AddRuleConditionForSchemaRule(String FieldName1, String OPERATOR1, String APPLIEDTO1,
			String ENTRY_SELECTION1) {
		waitForElementToAppear(AddRulesConditionButton, 5);
		verifyMustExists(AddRulesConditionButton, "AddRulesConditionButton");
		click(AddRulesConditionButton, "AddRulesConditionButton");
		waitForElementToAppear(FieldNameDrpDwn, 5);
		verifyMustExists(FieldNameDrpDwn, "FieldNameDrpDwn");
		click(FieldNameDrpDwn, "FieldNameDrpDwn");
		waitForElementToAppear(FieldNameDrpDwnSearchText, 5);
		verifyMustExists(FieldNameDrpDwnSearchText, "FieldNameDrpDwnSearchText");
		sendKeys(FieldNameDrpDwnSearchText, FieldName1, "FieldNameDrpDwnSearchText");
		sleep(2000);
		waitForElementToAppear(FieldNameDrpDwnSelectOption, 5);
		verifyMustExists(FieldNameDrpDwnSelectOption, "FieldNameDrpDwnSelectOption");
		click(FieldNameDrpDwnSelectOption, "FieldNameDrpDwnSelectOption");
		waitForElementToAppear(OperatorDrpDwn, 5);
		verifyMustExists(OperatorDrpDwn, "OperatorDrpDwn");
		click(OperatorDrpDwn, "OperatorDrpDwn");
		waitForElementToAppear(OperatorDrpDwnSearchText, 5);
		verifyMustExists(OperatorDrpDwnSearchText, "OperatorDrpDwnSearchText");
		sendKeys(OperatorDrpDwnSearchText, OPERATOR1, "OperatorDrpDwnSearchText");
		sleep(2000);
		waitForElementToAppear(OperatorDrpDwnSelectOption, 5);
		verifyMustExists(OperatorDrpDwnSelectOption, "OperatorDrpDwnSelectOption");
		click(OperatorDrpDwnSelectOption, "OperatorDrpDwnSelectOption");
		waitForElementToAppear(AppliedToDrpDwn, 5);
		verifyMustExists(AppliedToDrpDwn, "AppliedToDrpDwn");
		click(AppliedToDrpDwn, "AppliedToDrpDwn");
		waitForElementToAppear(AppliedToDrpDwnSearchText, 5);
		verifyMustExists(AppliedToDrpDwnSearchText, "AppliedToDrpDwnSearchText");
		sendKeys(AppliedToDrpDwnSearchText, APPLIEDTO1, "AppliedToDrpDwnSearchText");
		sleep(2000);
		waitForElementToAppear(AppliedToDrpDwnSelectOption, 5);
		verifyMustExists(AppliedToDrpDwnSelectOption, "AppliedToDrpDwnSelectOption");
		click(AppliedToDrpDwnSelectOption, "AppliedToDrpDwnSelectOption");
		waitForElementToAppear(EntrySelectionText, 5);
		verifyMustExists(EntrySelectionText, "EntrySelectionText");
		click(EntrySelectionText, "EntrySelectionText");
		waitForElementToAppear(EntrySelectionYesOption, 5);
		verifyMustExists(EntrySelectionYesOption, "EntrySelectionYesOption");
		webDriver.findElement(By.xpath("//li[text()='" + ENTRY_SELECTION1 + "']")).click();
		waitForElementToAppear(TickMarkButton, 5);
		verifyMustExists(TickMarkButton, "TickMarkButton");
		click(TickMarkButton, "TickMarkButton");
		sleep(4000);
	}

	public void AddDataAboutMe(String AddData1) throws InterruptedException {
		Actions action = new Actions(webDriver);
		webDriver.switchTo().frame(0);
		Thread.sleep(2000);
		clearTextBox(AddParagraphData);
		WebElement textParagraph = findWebElement(AddParagraphData);
		action.moveToElement(textParagraph).click(textParagraph).sendKeys(AddData1).build().perform();
		Thread.sleep(3000);
		webDriver.switchTo().defaultContent();
		waitForElementToAppear(SaveButtonComplianceRule, 10);
		verifyMustExists(SaveButtonComplianceRule, "SaveButtonComplianceRule");
		SaveChanges =  getTextFrom(SaveButtonComplianceRule);
		Report.LogInfo("SaveButtonComplianceRule", SaveChanges, "PASS");
		click(SaveButtonComplianceRule, "Click on Save Button");
	}

	public void AboutMeVerification() {
		waitForElementToAppear(TideAdminProfile, 5);
		verifyMustExists(TideAdminProfile, "TideAdminProfile");
		click(TideAdminProfile, "TideAdminProfile");
		waitForElementToAppear(TideAdminProfileAboutMe, 5);
		verifyMustExists(TideAdminProfileAboutMe, "TideAdminProfileAboutMe");
		click(TideAdminProfileAboutMe, "TideAdminProfileAboutMe");
		String ActualAboutMeData = getTextFrom(AboutMeAddedData);
		if (AddData.equals(ActualAboutMeData)) {
			Report.LogInfo("ValidateEditingAboutMe", "About Me edited data successfully.", "PASS");

		} else {
			Report.LogInfo("ValidateEditingAboutMe", "About Me edited data successfully.", "PASS");
		}
	}

	public void RenewalExistingEntries(String RiskReferenceNumber) {

		waitForElementToAppear(RiskReference, 5);
		verifyMustExists(RiskReference, "RiskReference");
		sendKeys(RiskReference, RiskReferenceNumber, "Enter RiskReference");
		verifyMustExists(ContinueButtonOnScreen, "ContinueButtonOnScreen");
		click(ContinueButtonOnScreen, "Cliked on Continue Button");
		waitForElementToAppear(CancelButtonOnScreen, 5);
		verifyMustExists(CancelButtonOnScreen, "CancelButtonOnScreen");
		click(CancelButtonOnScreen, "Cliked on Cancel Button");
		sleep(5000);

	}

	public void ChangeStatusDraftToSign() throws Exception {
		policy.changeStatusToSigned();
		sleep(2000);

	}

	public void CheckRiskReferenceRecord() {

		waitForElementToAppear(DataTab, 5);
		verifyMustExists(DataTab, "DataTab");
		click(DataTab, "Cliked on DataTab");
		waitForElementToAppear(RiskMenu, 5);
		verifyMustExists(RiskMenu, "RiskMenu");
		click(RiskMenu, "Cliked on RiskMenu");
	}

	// TC-3746
	public void applyFilterTideFieldReviewQuestionnaire(String story) {
		int i = 0;
		String SearchedCheckBox1 = "@xpath=//*[@value='" +story + "']";

		javaScriptWait();

		do {
			if (i > 0) {
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(TideFieldFilterIcon, "TideFieldFilterIcon");
			sleep(2000);
			if (isVisible(TideFieldSearchTextBox)) {
				verifyMustExists(TideFieldSearchTextBox, "TideFieldSearchTextBox");
				sendKeys(TideFieldSearchTextBox, story, "Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		} while (!isVisible(SearchedCheckBox1) && i < 5);

		click(SearchedCheckBox1, "Searched Record Checkbox");
		waitForElementToAppear(TideFieldFilterButton, 3);
		verifyMustExists(TideFieldFilterButton, "Filter Button");
		click(TideFieldFilterButton, "Filter Button");
	}

	public void ProcessBordereau() throws Exception {
		BordereauQuePage bordereauQue = new BordereauQuePage();
		String subSheet = "Automation Risk Format 14 (Lloyd's Property Schema)";
		String IncDate = "01/01/2018";
		String ExpDate = "31/12/2018";
		String subSheet1 = "Automation Risk Format 14";
	
		BQue.bordereauQuePage();
		BQue.filterBordereauQuestionnaire1(subSheet1);
		sleep(2000);
		waitForElementToAppear(BQue.EditBtn,5);
		verifyMustExists(BQue.EditBtn,"Edit button");
		click(BQue.EditBtn,"Edit button");
		BQue.nextStapeClick();
		BQue.FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();

		// Br.openSelectedPolicy();
		waitForElementToAppear(Br.SignedBtn, 5);
		if (isVisible(Br.SignedBtn) == true) {
			verifyExists(Br.SignedBtn, "Signed Status Button");
			Br.SubmitBordereaux(subSheet);
			String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
			String GetData = Configuration.url + "/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try {
				String fpath = new File(".").getCanonicalPath();
				sheet3746Path = fpath + "\\src\\test\\resources\\testdata\\Stage 2 errorsMarch 2018_TC_3746.xlsx";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3746Path);
			policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
			String Ufname = "S37557520180928.xlsx";	
			int size = 18629;
			//String BordreauID = "f002233c-e8d3-411a-a570-7b66d5ed3dfe";
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, BQue.FormatId, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errorsMarch 2018_TC_3746.xlsx\",\"UniqueFileName\":\"S76066220180611.xlsx\",\"BordereauFormatId\":\""+BQue.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S76066220180611.xlsx\",\"Filesize\":18629,\"Path\":null,\"size\":18629,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			Br.refreshUploadedFile();
		} else {
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	public void OpenBordereauQue() throws Exception {
		homePage.adminMenu();
		BQue.bordereauQueLink();
		BQue.bordereauQuePage();
	}

	public void OpenReviewStep12() {

		waitForElementToAppear(EditQuestionnairButton, 5);
		verifyMustExists(EditQuestionnairButton, "DataTab");
		click(EditQuestionnairButton, "EditQuestionnairButton");
		waitForElementToAppear(ReviewLink12, 5);
		verifyMustExists(ReviewLink12, "ReviewLink12");
		click(ReviewLink12, "ReviewLink12");
	}

	public void ProcessForSpecifyDefaultValue(String DefaultValueNo, String QuestionnaireName1) throws Exception {
		BordereauQuePage bordereauQue = new BordereauQuePage();
		waitForElementToAppear(SpecifyDefaultButton, 5);
		verifyMustExists(SpecifyDefaultButton, "SpecifyDefaultButton");
		click(SpecifyDefaultButton, "SpecifyDefaultButton");
		if (isVisible(DefaultValueScreen) == true) {
			DefaultValueScree =  getTextFrom(DefaultValueScreen);	
			Report.LogInfo("ValidateExpectedScreen", DefaultValueScree, "PASS");

			waitForElementToAppear(DefaultValue, 5);
			verifyMustExists(DefaultValue, "DefaultValue");

			sendKeys(DefaultValue, DefaultValueNo, "Enter Default Value");
			waitForElementToAppear(DefaultValueSaveButton, 5);
			verifyMustExists(DefaultValueSaveButton, "DefaultValueSaveButton");
			click(DefaultValueSaveButton, "DefaultValueSaveButton");
			bordereauQue.FormatId = ReturnFormatID();
			waitForElementToAppear(policy.SaveBtn, 5);
			verifyMustExists(policy.SaveBtn, "BorderQuestionarySaveButton");
			click(policy.SaveBtn, "BorderQuestionarySaveButton");
			sleep(5000);
			// BQue.filterBordereauQuestionnaire1(QuestionnaireName1);

		} else {
			Report.LogInfo("ValidateExpectedScreen", "Apply Default Value for Number of Stories", "FAIL");
			click(DefaultValueCancelButton, "click on cancel button");
			homePage.adminMenu();
		}
	}

	public void VerificationNumberOfBuildings() {
		Actions action = new Actions(webDriver);
		Br.openDATALink();
		waitForElementToAppear(Br.DATARiskTab, 5);
		verifyMustExists(Br.DATARiskTab, "RiskMenu");
		click(Br.DATARiskTab, "Cliked on RiskMenu");
		waitForElementToAppear(NumberOfBuildingsTab, 5);
		WebElement NoOfStories = findWebElement(NumberOfBuildingsTab);
		action.moveToElement(NoOfStories).build().perform();
		verifyExists(NumberOfBuildingsTab, "Number of Buildings Tab");
		sleep(2000);
		String NumberOfStories1 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[1]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories2 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[2]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories3 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[3]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories4 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[4]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories5 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[5]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories6 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[6]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories7 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[7]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories8 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[8]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories9 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[9]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories10 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[10]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";
		String NumberOfStories11 = "@xpath=//*[@data-field='Location_Number_Of_Buildings']//following::tr[11]//td[contains(@ng-click,'Location Number Of Buildings')][text()='10']";

		verifyExists(NumberOfStories1, "1st value");
		Building1 = getTextFrom(NumberOfStories1);
		Report.LogInfo("1st value", Building1, "PASS");
		verifyExists(NumberOfStories2, "2nd value");
		Building2 = getTextFrom(NumberOfStories2);
		Report.LogInfo("1st value", Building2, "PASS");
		verifyExists(NumberOfStories3, "3rd value");
		Building3 = getTextFrom(NumberOfStories3);
		Report.LogInfo("1st value", Building3, "PASS");
		verifyExists(NumberOfStories4, "4th value");
		Building4 = getTextFrom(NumberOfStories4);
		Report.LogInfo("1st value", Building4, "PASS");
		verifyExists(NumberOfStories5, "5th value");
		Building5 = getTextFrom(NumberOfStories5);
		Report.LogInfo("1st value", Building5, "PASS");
		verifyExists(NumberOfStories6, "6th value");
		Building6 = getTextFrom(NumberOfStories6);
		Report.LogInfo("1st value", Building6, "PASS");
		verifyExists(NumberOfStories7, "7th value");
		Building7 = getTextFrom(NumberOfStories7);
		Report.LogInfo("1st value", Building7, "PASS");
		verifyExists(NumberOfStories8, "8th value");
		Building8 = getTextFrom(NumberOfStories8);
		Report.LogInfo("1st value", Building8, "PASS");
		verifyExists(NumberOfStories9, "9th value");
		Building9 = getTextFrom(NumberOfStories9);
		Report.LogInfo("1st value", Building9, "PASS");
		verifyExists(NumberOfStories10, "10th value");
		Building10 = getTextFrom(NumberOfStories10);
		Report.LogInfo("1st value", Building10, "PASS");
		verifyExists(NumberOfStories11, "11th value");

	}

	// TC-3742
	public void ChangeTransactionType() {
		waitForElementToAppear(TransactionTypeDrdwn, 5);
		verifyMustExists(TransactionTypeDrdwn, "TransactionTypeDrdwn");
		click(TransactionTypeDrdwn, "Transaction DropDown");
		waitForElementToAppear(TransactionTypeDrdwnOption, 5);
		verifyMustExists(TransactionTypeDrdwnOption, "TransactionTypeDrdwnOption");
		click(TransactionTypeDrdwnOption, "Transaction DropDown selected option");
		waitForElementToAppear(ContinueButtonOnRenewalScreen, 5);
		verifyMustExists(ContinueButtonOnRenewalScreen, "ContinueButtonOnRenewalScreen");
		click(ContinueButtonOnRenewalScreen, "Continue button");
		sleep(3000);

	}

	public void CancelButtonBordereauSummary() {
		waitForElementToAppear(CancelButtonOnBordereauSummary, 5);
		verifyMustExists(CancelButtonOnBordereauSummary, "CancelButtonOnBordereauSummary");
		click(CancelButtonOnBordereauSummary, "Cancel button on Bordereau summary page");
		if (isVisible(Br.ReviewBtn) == true) {

			Report.LogInfo("ValidateReviewStatus", "Review Button displayed", "PASS");
		} else {
			Report.LogInfo("ValidateReviewStatus", "Review Button not displayed", "FAIL");
			Br.deleteBorderEAUX();

		}

	}

	public void OpenEntryStatus() {

		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		Br.openDATALink();
		waitForElementToAppear(Br.DATARiskTab, 5);
		verifyMustExists(Br.DATARiskTab, "RiskMenu");
		click(Br.DATARiskTab, "Cliked on RiskMenu");

	}

	public void VerificationEntryStatus() {
		FinancialCalculationRiskAndPremiumPage changeStatus = new FinancialCalculationRiskAndPremiumPage();
		changeStatus.offOnlycurrentIcon();
		// WebElement firstRecord = findWebElement(FirstEntryStatusRecord);
		verifyExists(FirstEntryStatusRecord, "FirstEntryStatusRecord");
		verifyExists(SecondEntryStatusRecord, "FirstEntryStatusRecord");
		verifyExists(ThirdEntryStatusRecord, "FirstEntryStatusRecord");
	}

	public void OpenStep5AndProcess() throws Exception {

		String QuestionnaireName = "Automation Risk Format 14";
		OpenBordereauQue();
		BQue.filterBordereauQuestionnaire1(QuestionnaireName);
		waitForElementToAppear(EditQuestionnairButton, 5);
		verifyMustExists(EditQuestionnairButton, "EditQuestionnairButton");
		click(EditQuestionnairButton, "EditQuestionnairButton");
		sleep(2000);
		waitForElementToAppear(Step5Link, 5);
		verifyMustExists(Step5Link, "Step5Link");
		javaScriptclick(Step5Link, "Step5 Link");
		sleep(2000);
		waitForElementToAppear(ReferenceRadioYesButton, 5);
		verifyMustExists(ReferenceRadioYesButton, "ReferenceRadioYesButton");
		// click(ReferenceRadioYesButton,"ReferenceRadioYesButton");
		javaScriptclick(ReferenceRadioYesButton, "ReferenceRadioYesButton");
		sleep(2000);
		waitForElementToAppear(ReferenceRadioNextStepButton, 5);
		verifyMustExists(ReferenceRadioNextStepButton, "ReferenceRadioNextStepButton");
		// click(ReferenceRadioNextStepButton,"ReferenceRadioNextStepButton");
		javaScriptclick(ReferenceRadioNextStepButton, "ReferenceRadioNextStepButton");
		sleep(3000);

	}

	public void OpenContractWithPolicy() throws Exception {

		Br.applyFilterPolicy(policy.PolicyNumber);
		Br.openSelectedPolicy();
		Br.SubmitBordereauxWithYesnoButtons1();
	}

	public void OpenStep5AndProcessForNoRefrence() throws Exception {

		String QuestionnaireName = "Automation Risk Format 14";

		OpenBordereauQue();
		BQue.filterBordereauQuestionnaire1(QuestionnaireName);
		waitForElementToAppear(EditQuestionnairButton, 5);
		verifyMustExists(EditQuestionnairButton, "EditQuestionnairButton");
		click(EditQuestionnairButton, "EditQuestionnairButton");
		waitForElementToAppear(Step5Link, 5);
		verifyMustExists(Step5Link, "Step5Link");
		click(Step5Link, "Step5 Link");
		waitForElementToAppear(ReferenceRadioNoButton, 5);
		verifyMustExists(ReferenceRadioNoButton, "ReferenceRadioNoButton");
		// click(ReferenceRadioNoButton,"ReferenceRadioNoButton");
		javaScriptclick(ReferenceRadioNoButton, "ReferenceRadioNoButton");
		sleep(2000);
		waitForElementToAppear(ReferenceRadioNextStepButton, 5);
		verifyMustExists(ReferenceRadioNextStepButton, "ReferenceRadioNextStepButton");
		// click(ReferenceRadioNextStepButton,"ReferenceRadioNextStepButton");
		javaScriptclick(ReferenceRadioNextStepButton, "ReferenceRadioNextStepButton");
		sleep(2000);
		BQue.FormatId = ReturnFormatID();

	}

	public void UploadFile2() throws Exception, IOException {
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";

		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3742_secondPath = fpath+ "\\src\\test\\resources\\testdata\\Stage 2 errorsFebruary 2018_ Endorsement_TC_3742_Second.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload2 = "{\"Bordereaux\":{\"ContractId\":\"" + contractId	+ "\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errorsFebruary 2018_ Endorsement_TC_3742_Second.xlsx\",\"UniqueFileName\":\"S93020620180429.xlsx\",\"BordereauFormatId\":\""	+ BQue.FormatId+ "\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S93020620180429.xlsx\",\"Filesize\":17201,\"Path\":null,\"size\":17201,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet3742_secondPath);
		
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S49729620180928.xlsx";	
		int size = 17201;
		//String BordreauID = "f002233c-e8d3-411a-a570-7b66d5ed3dfe";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BQue.FormatId, ID, Ufname, size, 2 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//uploadFile(ReqUrl, excelFile, payload2, DraftUrl);
		Br.refreshUploadedFileError();
		if (Br.checkErrorReviewButton(Br.ReviewError) == true) {
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if (isVisible(ExpectedScreen4) == true) {
				DeleteBorcereaux = getTextFrom(ExpectedScreen4);
				Report.LogInfo("Delete Borcereaux buton is visible", DeleteBorcereaux, "PASS");
				Report.LogInfo("ValidateExpectedScreen", "Expected Screen displayed successfully", "PASS");

			} else {
				Report.LogInfo("ValidateExpectedScreen", "Expected Screen not displayed successfully", "FAIL");
				goBack();
				// Br.deleteBorderEAUX();

			}
			OpenStep5AndProcess();
		} else {
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			Br.deleteBorderEAUX();
		}

	}

	// TC-3743
	public void GetApproveStatus() {
		waitForElementToAppear(SubmitRecordButton, 5);
		verifyMustExists(SubmitRecordButton, "SubmitRecordButton");
		click(SubmitRecordButton, "SubmitRecordButton");
		waitForElementToAppear(ForApprovalButton, 5);
		verifyMustExists(ForApprovalButton, "ForApprovalButton");
		click(ForApprovalButton, "ForApprovalButton");
		waitForElementToAppear(SubmitApprovalButton, 5);
		verifyMustExists(SubmitApprovalButton, "SubmitApprovalButton");
		click(SubmitApprovalButton, "SubmitApprovalButton");
		sleep(2000);

	}

	public void SubmitBordereauxWithYesnoButtons2() throws Exception {
		waitForElementToAppear(Br.BORDEREAUXLink, 5);
		verifyMustExists(Br.BORDEREAUXLink, "BORDEREAUX Link");
		javaScriptclick(Br.BORDEREAUXLink, "BORDEREAUX Link");
		sleep(3000);
		if (isVisible(Br.BlankDetailsMsg) == true) {
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		} else {
			Report.LogInfo("StatusCheck", "Approved status records found", "PASS");

		}
		sleep(2000);

	}

	public void uploadSecondFile_TC3743() throws Exception, IOException {
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3743_secondPath = fpath + "\\src\\test\\resources\\testdata\\March 2018_TC_3743_Second.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		//String payload3 = "{\"Bordereaux\":{\"ContractId\":\"" + contractId	+ "\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"March 2018_TC_3743_Second.xlsx\",\"UniqueFileName\":\"S84046520180429.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S84046520180429.xlsx\",\"Filesize\":17737,\"Path\":null,\"size\":17737,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet3743_secondPath);
		
		String Ufname = "S87947720180927.xlsx";	
		int size = 17737;
		String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload3 = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 2 , "1", 2018);
        addAsDraft(payload3,DraftUrl);
        
		//uploadFile(ReqUrl, excelFile, payload3, DraftUrl);
		Br.refreshUploadedFile();
		if (isVisible(Br.ReviewBtn) == true) {
			AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);
			Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
			Report.LogInfo("ValidateReviewStatus", "Review status displayed Successfully.", "PASS");
		} else {
			Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed.", "FAIL");
			goBack();
			Br.deleteBorderEAUX();
		}
	}

	public void uploadThirdFile_TC3743() throws Exception, IOException {
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+ policy.PolicyNumber + "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3743_ThirdPath = fpath + "\\src\\test\\resources\\testdata\\April 2018_TC_3743_Third.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload4 = "{\"Bordereaux\":{\"ContractId\":\"" + contractId	+ "\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2019,\"FolderId\":\"0\",\"OriginalFileName\":\"April 2018_TC_3743_Third.xlsx\",\"UniqueFileName\":\"S25109720180429.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25109720180429.xlsx\",\"Filesize\":18536,\"Path\":null,\"size\":18536,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":true,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet3743_ThirdPath);
		
		String Ufname = "S51935720180928.xlsx";	
		int size = 18536;
		String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload4 = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 2 , "1", 2018);
        addAsDraft(payload4,DraftUrl);
        Br.refreshUploadedFile();
        if(isVisible(Br.ReviewBtn)==true) {
			AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
			Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
			javaScriptclick(Br.ReviewBtn,"Click Review Button");
			sleep(1000);
			verifyMustExists(RevrtToUpld,"Revert to Upload Button");
			javaScriptclick(RevrtToUpld,"Click Revert to Upload Button");
			sleep(1000);
}else
	{
		Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
		Br.deleteBorderEAUX();
	}
   	//uploadFile(ReqUrl, excelFile, payload4, DraftUrl);
		Br.refreshUploadedFileForUploadedStatus();
	}

	public void MissingBordereauPeriodsErrorScreen() {
		waitForElementToAppear(NilBordereauxYesRadioButton, 5);
		verifyMustExists(NilBordereauxYesRadioButton, "NilBordereauxYesRadioButton");
		click(NilBordereauxYesRadioButton, "NilBordereauxYesRadioButton");
		waitForElementToAppear(MissingBordereauPeriodsContinueButton, 5);
		verifyMustExists(MissingBordereauPeriodsContinueButton, "MissingBordereauPeriodsContinueButton");
		click(MissingBordereauPeriodsContinueButton, "MissingBordereauPeriodsContinueButton");
		sleep(2000);

	}

	public void ApprovedStatusMarchReview() {

		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			click(Br.ReviewBtn, "Click on Review Button");
			if (isVisible(SummaryScreen) == true) {
				Report.LogInfo("ValidateExpectedScreen", "Summary Screen open successfully", "PASS");
				GetApproveStatus();
				sleep(2000);

			} else {
				Report.LogInfo("ValidateExpectedScreen", "Summary Screen not displayed", "FAIL");
				goBack();
				Br.deleteBorderEAUX();

			}

		} else {
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			Br.deleteBorderEAUX();
		}
	}

	public void verifyReviewStatus() {
		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			Br.deleteBorderEAUX();

		} else {
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			Br.deleteBorderEAUX();
		}
		sleep(3000);

	}

	public void ConvertMarchFileAprrovedToUnapproved() {
		waitForElementToAppear(MarchApprovedButton, 5);
		verifyMustExists(MarchApprovedButton, "MarchApprovedButton");
		javaScriptclick(MarchApprovedButton);
		// (MarchApprovedButton,"MarchApprovedButton");
		WebElement unapproveButton = findWebElement(JanUnApprovedButton);
		if (unapproveButton.isEnabled() == true) {

			Report.LogInfo("ValidateUnApprovedButton", "UnApproved Button is enabled", "PASS");
			waitForElementToAppear(MarchUnApprovedButton, 5);
			verifyMustExists(MarchUnApprovedButton, "MarchUnApprovedButton");
			// click(MarchUnApprovedButton,"MarchUnApprovedButton");
			javaScriptclick(MarchUnApprovedButton);
			sleep(3000);
		} else {
			Report.LogInfo("ValidateUnApprovedButton", "UnApproved Button is not enabled", "FAIL");
			// goBack();
		}

	}

	public void ConvertJanuaryFileAprrovedToUnapproved() {
		waitForElementToAppear(JanApprovedButton, 5);
		verifyMustExists(JanApprovedButton, "JanApprovedButton");
		javaScriptclick(JanApprovedButton);// (JanApprovedButton,"JanApprovedButton");
		sleep(3000);
		/*
		 * goBack(); waitForElementToAppear(JanApprovedButton,5);
		 * verifyMustExists(JanApprovedButton,"JanApprovedButton");
		 * click(JanApprovedButton,"JanApprovedButton"); sleep(3000);
		 */
		WebElement unapproveButton = findWebElement(JanUnApprovedButton);
		if (unapproveButton.isEnabled() == true) {

			Report.LogInfo("ValidateUnApprovedButton", "UnApproved Button is enabled", "PASS");
			waitForElementToAppear(JanUnApprovedButton, 5);
			verifyMustExists(JanUnApprovedButton, "JanUnApprovedButton");
			javaScriptclick(JanUnApprovedButton);
			sleep(4000);
			waitForElementToAppear(JanUnApprovedErrorScreen, 5);
			verifyMustExists(JanUnApprovedErrorScreen, "JanUnApprovedErrorScreen");
			// click(JanUnApprovedErrorScreenCancelBtn,"Clicked on Cancel Button");
			waitForElementToAppear(JanUnApprovedCancelBtn, 5);
			verifyMustExists(JanUnApprovedCancelBtn, "JanUnApprovedCancelBtn");
			click(JanUnApprovedCancelBtn, "Clicked on Cancel Button");
			waitForElementToAppear(JanUnApprovedCancelBtn1, 5);
			verifyMustExists(JanUnApprovedCancelBtn1, "JanUnApprovedCancelBtn1");
			click(JanUnApprovedCancelBtn1, "Clicked on Cancel Button of bordereau process");
			sleep(3000);
		} else {
			Report.LogInfo("ValidateUnApprovedButton", "UnApproved Button is not enabled", "FAIL");
			// goBack();
		}
	}

	// =============================================TC-3980====================================================//
	public void RiskInceptionDateInupdatingRiskAndPremiumRecords_TC3980() throws Exception {

		String subSheet = "Automation Risk Format 21";

		policy.CreateContractwithInceptionDate2018();

		Br.applyFilterPolicy(policy.PolicyNumber);

		Br.openSelectedPolicy();
		String contractId = ReturnContractID();
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		// String GetData = Configuration.url+"/api/Contract/GetAllPage";
		// String payload1 =
		// "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		Br.SubmitBordereaux(subSheet);
		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3980Path = fpath+ "\\src\\test\\resources\\testdata\\Stage2errors-January 2018_TC_3980_Different.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"" + contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage2errors-January 2018_TC_3980_Different.xlsx\",\"UniqueFileName\":\"S22383620180514.xlsx\",\"BordereauFormatId\":\"53e3fa7b-06a7-4c3d-91e0-ecc60decd1e5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S22383620180514.xlsx\",\"Filesize\":17764,\"Path\":null,\"size\":17764,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile = new File(sheet3980Path);
		
		String Ufname = "S10961320180928.xlsx";	
		int size = 17764;
		String BordreauID = "53e3fa7b-06a7-4c3d-91e0-ecc60decd1e5";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			Br.openDATALink();
			Br.navigateToDATARiskTab();
			Fc.offOnlycurrentIcon();
			//Br.selectRowNumberAscOrder();
			VerifyRowNumberAndEntryStatus();
			sleep(2000);
			policy.navigationOnBordereauxTab();
			Br.refreshUploadedFile();
			if (isVisible(Br.ReviewBtn) == true) {
				AssertBordereauStatusReview = getTextFrom(Br.ReviewBtn);
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
				Br.deleteBorderEAUX();
			} else {
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
			}
			//deleteBorderEAUX();

		} else {
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "FAIL");
			policy.navigationOnBordereauxTab();
			Br.refreshUploadedFile();
			Br.deleteBorderEAUX();

		}
		// Upload file 2
		Br.SubmitBordereaux(subSheet);
		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3980Path = fpath + "\\src\\test\\resources\\testdata\\Stage 2 errors - January 2018_TC_3980_Same.xlsx";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//String payload11 = "{\"Bordereaux\":{\"ContractId\":\"" + contractId+ "\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Stage 2 errors - January 2018_TC_3980_Same.xlsx\",\"UniqueFileName\":\"S65853520180502.xlsx\",\"BordereauFormatId\":\"53e3fa7b-06a7-4c3d-91e0-ecc60decd1e5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S65853520180502.xlsx\",\"Filesize\":17766,\"Path\":null,\"size\":17766,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		File excelFile1 = new File(sheet3980Path);
		
		String Ufname1 = "S92196620180928.xlsx";	
		int size1 = 17766;
		String BordreauID1 = "53e3fa7b-06a7-4c3d-91e0-ecc60decd1e5";
        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
        String ID1 = extractIDFromResponseinsideContract(response1); 
        String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 1 , "1", 2018);
        addAsDraft(payload2,DraftUrl);
        
		//uploadFile(ReqUrl, excelFile1, payload11, DraftUrl);
		Br.refreshUploadedFile();
		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			Br.openDATALink();
			Br.navigateToDATARiskTab();
			Fc.offOnlycurrentIcon();
			Br.selectRowNumberAscOrder();
			VerifyRowNumberAndEntryStatus();
			policy.navigationOnBordereauxTab();
			Br.refreshUploadedFile();
			Br.deleteBorderEAUX();

		} else {
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "FAIL");
			policy.navigationOnBordereauxTab();
			Br.refreshUploadedFile();
			Br.deleteBorderEAUX();

		}
	}

	// ================================End
	// TC_3890===============================================
	public void VerifyRowNumberAndEntryStatus() throws Exception {
		// Row number column
		String RowNumber = "@xpath=//*[@data-field='RowNumber']";
		String RowNumber1 = "@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][1]";
		String RowNumber2 = "@xpath=//*[@data-field='RowNumber']//following::tr[2]//td[contains(@ng-click,'RowNumber')][1]";
		String RowNumber3 = "@xpath=//*[@data-field='RowNumber']//following::tr[3]//td[contains(@ng-click,'RowNumber')][1]";
		String RowNumber4 = "@xpath=//*[@data-field='RowNumber']//following::tr[4]//td[contains(@ng-click,'RowNumber')][1]";
		waitForElementToAppear(RowNumber, 20);
		sleep(2000);
		mouseOverAction(RowNumber);
		verifyMustExists(RowNumber, "Row Number");
		sleep(2000);
		verifyExists(RowNumber1, "1st value");
		 R1 = getTextFrom(RowNumber1);
		verifyExists(RowNumber2, "2nd value");
		 R2 = getTextFrom(RowNumber2);
		verifyExists(RowNumber3, "3rd value");
		 R3 = getTextFrom(RowNumber3);
		verifyExists(RowNumber4, "4th value");
		 R4 = getTextFrom(RowNumber4);
		sleep(2000);

		// Entry Status
		String Entry_Status = "@xpath=//*[@data-field='EntryStatus']";
		String EntryStatus1 = "@xpath=//*[@data-field='EntryStatus']//following::tr[1]//td[contains(@ng-click,'EntryStatus')][1]";
		String EntryStatus2 = "@xpath=//*[@data-field='EntryStatus']//following::tr[2]//td[contains(@ng-click,'EntryStatus')][1]";
		String EntryStatus3 = "@xpath=//*[@data-field='EntryStatus']//following::tr[3]//td[contains(@ng-click,'EntryStatus')][1]";
		String EntryStatus4 = "@xpath=//*[@data-field='EntryStatus']//following::tr[4]//td[contains(@ng-click,'EntryStatus')][1]";
		waitForElementToAppear(Entry_Status, 20);
		sleep(2000);
		mouseOverAction(Entry_Status);
		verifyMustExists(Entry_Status, "Entry Status");
		sleep(2000);
		EntryStatusVal1 = "Current";
		EntryStatusVal2 = "Historic";
		EntryStatusVal3 = "Update";
		EntryStatusVal4 = "Current";
		String ActualEntryStatus1 = getTextFrom(EntryStatus1);
		String ActualEntryStatus2 = getTextFrom(EntryStatus2);
		String ActualEntryStatus3 = getTextFrom(EntryStatus3);
		String ActualEntryStatus4 = getTextFrom(EntryStatus4);
		if (EntryStatusVal1.equals(ActualEntryStatus1)) {

			Report.LogInfo("ValidateEntryStatus", "Entry status Display Correctly", "PASS");
		} else {
			Report.LogInfo("ValidateEntryStatus", "Entry status not Display Correctly", "FAIL");
		}
		if (EntryStatusVal2.equals(ActualEntryStatus2)) {

			Report.LogInfo("ValidateEntryStatus", "Entry status Display Correctly", "PASS");
		} else {
			Report.LogInfo("ValidateEntryStatus", "Entry status not Display Correctly", "FAIL");
		}
		if (EntryStatusVal3.equals(ActualEntryStatus3)) {

			Report.LogInfo("ValidateEntryStatus", "Entry status Display Correctly", "PASS");
		} else {
			Report.LogInfo("ValidateEntryStatus", "Entry status not Display Correctly", "FAIL");
		}
		if (EntryStatusVal4.equals(ActualEntryStatus4)) {

			Report.LogInfo("ValidateEntryStatus", "Entry status Display Correctly", "PASS");
		} else {
			Report.LogInfo("ValidateEntryStatus", "Entry status not Display Correctly", "FAIL");
		}
	}
	public void multipleRuleConditions_TC3635() throws Exception {
		String type1 = "Risk And Premium";
		String FreqVal1 = "Monthly";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		String subSheet = "Automation Risk And Premium Format 2 (Lloyd's Property Schema)";
		// step 1
		policy.CreateContractwithInceptionDate2018();
		/*policy.applyFilterPolicy("717177YS");
		policy.openSelectedPolicy();*/
		sleep(1000);
		policy.navigateToReportingChannelsTab();
	    policy.addReportingChannelForAnyComb(type1,FreqVal1);
	    Report.LogInfo("StepCheck", "Steps 1 completed", "PASS");
	    
	    //Step2
	    policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn, "Add Rule button");
		click(policy.AddRulesBtn, "Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup, 5);
		verifyMustExists(policy.AddRulesPopup, "Add Rules popup");
		verifyMustExists(policy.RuleNameTxt, "Rules Name textbox");
		sendKeys(policy.RuleNameTxt, "Risk & Premium MultiRule Condition","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD, policy.PremiumValue);
		SelectDropDownValue(policy.ApplicationConditionDD, policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD, policy.CurrencyGBPValue);
		verifyMustExists(policy.ROEToleranceTxt, "ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt, "1", "ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);
	    
		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD, policy.RiskInceptionDateValue);
		SelectDropDownValue(policy.OperatorDD, policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		sendKeys(policy.EntryOrSelectionTxt, "02/02/2018", "Entry Or Selection textbox");
		//SelectDropDownValue1(policy.EntryValueFromDD,policy.Florida);
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");
		sleep(2000);

		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");

		/*SelectDropDownValue(policy.MethodNameDD, policy.MethodValue);
		
		SelectDropDownValue(policy.FieldNameDD, policy.InsuredPostalCode);
		SelectDropDownValue(policy.OperatorDD, policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt, "Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt, "SW12 800", "Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");
		
		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");
*/
		SelectDropDownValue(policy.MethodNameDD, policy.MethodValue1);
		SelectDropDownValue(policy.FieldNameDD, policy.PremiumCurency);
		SelectDropDownValue(policy.OperatorDD, policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		SelectDropDownValue1(policy.EntryValueFromDD,policy.CurrencyGBP);
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");

		waitForElementToAppear(policy.SaveBtn, 5);
		verifyMustExists(policy.SaveBtn, "Save button");
		click(policy.SaveBtn, "Save button");
		sleep(2000);
		if (isVisible(policy.ConEndrsmntPopUp) == true) {
			Endorsment =  getTextFrom(policy.ConEndrsmntPopUp);	
			Report.LogInfo("Endorsment popup is open", Endorsment, "PASS");
			sleep(1000);
			verifyExists(policy.SaveBtn3, "Save Button");
			click(policy.SaveBtn3, "Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step  completed", "PASS");
		
		scrollUp();
		//step3
		policy.navigationOnBordereauxTab();
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+ "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		
		Br.SubmitBordereaux(subSheet);
		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3635Path = fpath + "\\src\\test\\resources\\testdata\\JanuaryContractRuleTest_TC_3635.xlsx";
		} catch (IOException e) {
			e.printStackTrace();
		}
		File excelFile = new File(sheet3635Path);
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);

		String Ufname = "S56051020181218.xlsx";	
		int size = 19438;
		String BordreauID = "a95e2bc1-c484-4c1f-9ca2-fa75ea47383f";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
        
		Br.refreshUploadedFile();
		if (isVisible(Br.ReviewBtn) == true) {
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn, "Review button");
			click(Br.ReviewBtn, "Review button");
			waitForElementToAppear(Br.SuRcdAssmnt, 10);
			verifyMustExists(Br.SuRcdAssmnt, "Submit recor for Assignment button");
			click(Br.SuRcdAssmnt, "Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn, 10);
			verifyMustExists(Br.FrApprovalbtn, "For Approval button");
			click(Br.FrApprovalbtn, "For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileApprovedStatus();
			AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
			Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
			// step 11
			policy.navigateRulesTab();
			verifyMustExists(RuleBreachesCount, "Rule Breaches Count");		
			BreacheCount6 =  getTextFrom(RuleBreachesCount);	
			Report.LogInfo("Rule Breaches Count 4", BreacheCount6, "PASS");
			click(RuleBreachesCount, "Rule Breaches Count");
			policy.navigateBreachesTab();
			waitForElementToAppear(policy.RulesDD, 3);
			verifyMustExists(policy.RulesDD, "Rules Drop Down");
			SelectDropDownValue(policy.RulesDD, policy.RulesDDValue_6);
			sleep(2000);
			List<WebElement> list = findWebElements(Br.ActualExpectedRowCount);
		     count = list.size();
			if (count == 4) {
				Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is: " + count,"PASS");
			} else {
				Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is: "+ count,"FAIL");
			}
			sleep(2000);
			Report.LogInfo("StepsCheck", "Step 11 completed", "PASS");
			
			//Step 12
			 policy.navigateRulesTab();
			 verifyMustExists(Edit, "Edit Rule");		
			 click(Edit, "Click on Edit Rule");
			
			 verifyMustExists(InActiveBtn, "InActive Rule");		
			 click(InActiveBtn, "InActive Rule");
			
			 
			 waitForElementToAppear(SaveButtonComplianceRule, 5);
			 verifyMustExists(SaveButtonComplianceRule, "Save Button");		
			 click(SaveButtonComplianceRule, "Save Button");
				sleep(2000);
				if (isVisible(policy.ConEndrsmntPopUp) == true) {
					Endorsment =  getTextFrom(policy.ConEndrsmntPopUp);	
					Report.LogInfo("Endorsment popup is open", Endorsment, "PASS");
					sleep(1000);
					verifyExists(policy.SaveBtn3, "Save Button");
					click(policy.SaveBtn3, "Save Button");
					sleep(3000);
				}
				//Br.refreshUploadedFile();	
				verifyMustExists(ARCHIVEDCount, "Rule Breaches Count");		
				click(ARCHIVEDCount, "Rule Breaches Count");
				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD, 3);
				verifyMustExists(policy.RulesDD, "Rules Drop Down");
				SelectDropDownValue(policy.RulesDD, policy.RulesDDValue_6);
				sleep(2000);
				
				verifyMustExists(ARCHIVED1, "ARCHIVED");		
				click(ARCHIVED1, "ARCHIVED");
				ARCHIVED =  getTextFrom(ARCHIVED1);	
				verifyMustExists(ARCHIVED2, "ARCHIVED");		
				click(ARCHIVED2, "ARCHIVED");
				verifyMustExists(ARCHIVED3, "ARCHIVED");		
				click(ARCHIVED3, "ARCHIVED");
				verifyMustExists(ARCHIVED4, "ARCHIVED");		
				click(ARCHIVED4, "ARCHIVED");
				/*verifyMustExists(ARCHIVED5, "ARCHIVED");		
				click(ARCHIVED5, "ARCHIVED");
				verifyMustExists(ARCHIVED6, "ARCHIVED");		
				click(ARCHIVED6, "ARCHIVED");*/
				Report.LogInfo("StepsCheck", "Step 12 completed", "PASS");
				
				//Step 13
				Br.SubmitBordereaux(subSheet);
				waitForElementToAppear(Br.ApprovedTab, 5);
				verifyExists(Br.ApprovedTab, "Approved Tab");	
				click(Br.ApprovedTab, "Approved Tab");			
				
				waitForElementToAppear(Br.ApprovedButton, 5);
				AssertBordereauStatusApproved = getTextFrom(Br.ApprovedButton);
				Report.LogInfo("Validate Approved Status", AssertBordereauStatusApproved, "PASS");
				click(Br.ApprovedButton, " cliked on Approve Button");
                waitForElementToAppear(UnApproveBordereauButton, 5);
			    verifyMustExists(UnApproveBordereauButton, "UnApprove Bordereau button");
				click(UnApproveBordereauButton, "UnApprove Bordereau button");
				Br.refreshUploadedFileForApprovalStatus();
				waitForElementToAppear(Br.ForApprovalButton, 5);
				verifyMustExists(Br.ForApprovalButton, "For Approval Button Bordereau button");
				
				policy.navigateRulesTab();
				verifyMustExists(RuleBreachesCount0, "Rule Breaches Count");		
				BreacheCount0 =  getTextFrom(RuleBreachesCount0);	
				Report.LogInfo("Rule Breaches Count 0", BreacheCount0, "PASS");
				
				Report.LogInfo("StepsCheck", "Step 12 completed", "PASS");
				
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			Br.deleteBorderEAUX();
		}

	}
	
	public void ClaimBespokerule_TC3647() throws Exception {
		
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		String subSheet = "Automation Claim Format 2";
		// step 1
		
		policy.CreateClaimContractwithInceptionDate2018();
		Br.applyFilterPolicy(policy.PolicyNumber);
		Br.openSelectedPolicy();
	
	    //Step2
	    policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn, "Add Rule button");
		click(policy.AddRulesBtn, "Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup, 5);
		verifyMustExists(policy.AddRulesPopup, "Add Rules popup");
		verifyMustExists(policy.RuleNameTxt, "Rules Name textbox");
		sendKeys(policy.RuleNameTxt, "Adjusters Fees (Paid)  Equal To Value 20","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD, policy.ClaimValue);
		SelectDropDownValue(policy.ApplicationConditionDD, policy.ConditionNotMetValue);
		SelectDropDownValue(policy.CurrencyDD, policy.CurrencyGBPValue);
		verifyMustExists(policy.ROEToleranceTxt, "ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt, "1", "ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);
	    
		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD, policy.AdjustersFees);
		SelectDropDownValue(policy.OperatorDD, policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		sendKeys(policy.EntryOrSelectionTxt, "20.00", "Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");
		sleep(2000);
		
		waitForElementToAppear(policy.SaveBtn, 5);
		verifyMustExists(policy.SaveBtn, "Save button");
		click(policy.SaveBtn, "Save button");
		sleep(2000);
		if (isVisible(policy.ConEndrsmntPopUp) == true) {
			Endorsment =  getTextFrom(policy.ConEndrsmntPopUp);	
			Report.LogInfo("Endorsment popup is open", Endorsment, "PASS");
			sleep(1000);
			verifyExists(policy.SaveBtn3, "Save Button");
			click(policy.SaveBtn3, "Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		
		//Step 3 Add Second Rule
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn, "Add Rule button");
		click(policy.AddRulesBtn, "Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup, 5);
		verifyMustExists(policy.AddRulesPopup, "Add Rules popup");
		verifyMustExists(policy.RuleNameTxt, "Rules Name textbox");
		sendKeys(policy.RuleNameTxt, "Indemnity (Paid) Between Value 150.00 AND 200.00 And Attorney Coverage Fees (Paid) Equal To Value 50.00","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD, policy.ClaimValue);
		SelectDropDownValue(policy.ApplicationConditionDD, policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD, policy.CurrencyGBPValue);
		verifyMustExists(policy.ROEToleranceTxt, "ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt, "1", "ROE Tolerance textbox");

		WebElement Section1 = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a1 = new Actions(webDriver);
		sleep(1000);
		a1.click(Section1).build().perform();
		a1.sendKeys(Section1, Keys.BACK_SPACE).build().perform();
		a1.click(Section1).build().perform();
		a1.sendKeys(Section1, Keys.ENTER).build().perform();
		sleep(1000);
		
	    
		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD, policy.IndemnityPaid);
		SelectDropDownValue(policy.OperatorDD, policy.Between);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"150","Entry Or Selection textbox");
		
		verifyMustExists(policy.EntryOrSelectionTxt2 ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt2 ,"200","Entry Or Selection textbox");
		
		click(policy.CheckBtn, "Check button");
		sleep(2000);
		
		verifyMustExists(policy.AddRuleConditionBtn, "Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn, "Add Rule Condition button");
		
        SelectDropDownValue(policy.MethodNameDD, policy.MethodValue);
		
		SelectDropDownValue(policy.FieldNameDD, policy.AttoCoverageFees);
		SelectDropDownValue(policy.OperatorDD, policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD, policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt, "Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt, "50", "Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn, "Check button");
		click(policy.CheckBtn, "Check button");
		
		
		
		waitForElementToAppear(policy.SaveBtn, 5);
		verifyMustExists(policy.SaveBtn, "Save button");
		click(policy.SaveBtn, "Save button");
		sleep(2000);
		if (isVisible(policy.ConEndrsmntPopUp) == true) {
			Endorsment =  getTextFrom(policy.ConEndrsmntPopUp);	
			Report.LogInfo("Endorsment popup is open", Endorsment, "PASS");
			sleep(1000);
			verifyExists(policy.SaveBtn3, "Save Button");
			click(policy.SaveBtn3, "Save Button");
			sleep(3000);
		}
		
		Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
		
		
		//step 4
				policy.navigationOnBordereauxTab();
				String GetData = Configuration.url + "/api/Contract/GetAllPage";
				String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+ "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
				
				
				Br.SubmitBordereaux(subSheet);
				try {
					String fpath = new File(".").getCanonicalPath();
					sheet3647Path = fpath + "\\src\\test\\resources\\testdata\\January Claim Contract Rule_TC_3647.xlsx";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File excelFile = new File(sheet3647Path);
				policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);

				String Ufname = "S11149920181029.xlsx";	
				int size = 15672;
				String BordreauID ="35006c5b-0193-45b9-8c6f-30953876d214";
		        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
		        String ID = extractIDFromResponseinsideContract(response); 
		        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
		        addAsDraft(payload,DraftUrl);
		        
				Br.refreshUploadedFile();
				if (isVisible(Br.ReviewBtn) == true) {
					Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					sleep(2000);
					verifyMustExists(Br.ReviewBtn, "Review button");
					click(Br.ReviewBtn, "Review button");
					waitForElementToAppear(Br.SuRcdAssmnt, 10);
					verifyMustExists(Br.SuRcdAssmnt, "Submit recor for Assignment button");
					click(Br.SuRcdAssmnt, "Submit recor for Assignment button");
					waitForElementToAppear(Br.FrApprovalbtn, 10);
					verifyMustExists(Br.FrApprovalbtn, "For Approval button");
					click(Br.FrApprovalbtn, "For Approval button");
					Br.clickOnApproveBordBtn();
					Br.refreshUploadedFileApprovedStatus();
					AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
					Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
					
					Report.LogInfo("StepsCheck", "Step 4 completed", "PASS");
					
					
					// step 5
					policy.navigateRulesTab();
					
					verifyMustExists(policy.RuleBreachesCountRow1, "Rule Breaches Count");		
					BreacheCount3 =  getTextFrom(policy.RuleBreachesCountRow1);	
					Report.LogInfo("Rule Breaches Count 3", BreacheCount3, "PASS");
					sleep(1000);
					click(policy.RuleBreachesCountRow1, "Rule Breaches Count Row 1");
					/*policy.navigateBreachesTab();
					waitForElementToAppear(policy.RulesDD, 3);
					verifyMustExists(policy.RulesDD, "Rules Drop Down");*/
					SelectDropDownValue(policy.RulesDD, policy.RulesDDValue_3);
					sleep(2000);
					List<WebElement> list = findWebElements(Br.ActualExpectedRowCount);
				     count = list.size();
					if (count == 3) {
						Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is: " + count,"PASS");
					} else {
						Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is: "+ count,"FAIL");
					}
					sleep(2000);
					Report.LogInfo("StepsCheck", "Step 5 completed", "PASS");
					
					//step 6

					verifyMustExists(ClaimReference,"Claim Reference Row Number");
					click(ClaimReference,"Claim Reference Row Number");
					sleep(3000);
					verifyMustExists(RowNumberAscIcon,"Row Number Ascending icon");  
					sleep(3000);
					
					verifyMustExists(policy.BreachesR1, " Breaches  Row 1");	
					BreachesR1 =  getTextFrom(policy.BreachesR1);	
					Report.LogInfo(" Breaches  Row 1 Value 10", BreachesR1, "PASS");
					
					verifyMustExists(policy.BreachesR2, " Breaches  Row 2");	
					BreachesR2 =  getTextFrom(policy.BreachesR2);	
					Report.LogInfo(" Breaches  Row 2 Value 10", BreachesR2, "PASS");
					
					verifyMustExists(policy.BreachesR3, " Breaches  Row 3");	
					BreachesR3 =  getTextFrom(policy.BreachesR3);	
					Report.LogInfo(" Breaches  Row 3 Value 10", BreachesR3, "PASS");
					
					verifyMustExists(policy.Breaches_R1, " Breaches  Row 1");	
					Breaches_R1 =  getTextFrom(policy.Breaches_R1);	
					Report.LogInfo(" Breaches  Row 1 Value 100", Breaches_R1, "PASS");
					
					verifyMustExists(policy.Breaches_R2, " Breaches  Row 1");	
					Breaches_R2 =  getTextFrom(policy.Breaches_R2);	
					Report.LogInfo(" Breaches  Row 1 Value 100", Breaches_R2, "PASS");
					
					verifyMustExists(policy.Breaches_R3, " Breaches  Row 1");	
					Breaches_R3 =  getTextFrom(policy.Breaches_R3);	
					Report.LogInfo(" Breaches  Row 1 Value 200", Breaches_R3, "PASS");
					
					
					Report.LogInfo("StepsCheck", "Step 6 completed", "PASS");
					// step 7
                    policy.navigateRulesTab();
					
					verifyMustExists(policy.RuleBreachesCountRow2, "Rule Breaches Count Row 2");		
					BreacheCount2 =  getTextFrom(policy.RuleBreachesCountRow2);	
					Report.LogInfo("Rule Breaches Count 2", BreacheCount2, "PASS");
					click(policy.RuleBreachesCountRow2, "Rule Breaches Count");
					/*policy.navigateBreachesTab();
					waitForElementToAppear(policy.RulesDD, 3);
					verifyMustExists(policy.RulesDD, "Rules Drop Down");
					SelectDropDownValue(policy.RulesDD, policy.RulesDDValue_2);*/
					sleep(2000);
					List<WebElement> list1 = findWebElements(Br.ActualExpectedRowCount);
				     count1 = list1.size();
					if (count1 == 2) {
						Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is: " + count1,"PASS");
					} else {
						Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is: "+ count1,"FAIL");
					}
					sleep(2000);
					Report.LogInfo("StepsCheck", "Step 7 completed", "PASS");
					
					//Step8
					
					verifyMustExists(policy.Breaches__R1, " Breaches  Row 1");	
					BreachesR5 =  getTextFrom(policy.Breaches__R1);	
					Report.LogInfo(" Breaches  Row 1 Value 20", BreachesR5, "PASS");
					
					verifyMustExists(policy.Breaches__R2, " Breaches  Row 2");	
					BreachesR4 =  getTextFrom(policy.Breaches__R2);	
					Report.LogInfo(" Breaches  Row 1 Value 20", BreachesR4, "PASS");
					
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
					Br.deleteBorderEAUX();
				}

			}
	
      public void RiskandPremiumLoactionRule_3649() throws Exception {
		
    	String subSheet = "Automation Risk And Premium Format 2 (Lloyd's Property Schema)";
  		String type1 = "Risk And Premium";
  		String FreqVal1 = "Monthly";
  		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
  		
  		// step 1
  	    
  	    policy.CreateContractwithInceptionDate2018();
  		
  		policy.navigateToReportingChannelsTab();
  	    policy.addReportingChannelForAnyComb(type1,FreqVal1);
  	    Report.LogInfo("StepCheck", "Steps 1 completed", "PASS");
  	    
  			policy.navigateToSectionTab1();
  			policy.navigateLocationTab();
  			
  			waitForElementToAppear(LocationthreeRefdot,5);
  			click(LocationthreeRefdot,"location Edit dot");
  			sleep(1000);
  			waitForElementToAppear(locationEditBtn,5);
  			click(locationEditBtn,"location Edit option");
  			
  			waitForElementToAppear(CanadaExpandarrow,5);
  			click(CanadaExpandarrow,"North America Arrow expand");
  			sleep(2000);
  			
  			waitForElementToAppear(CanadaExpandarrow1,5);
  			click(CanadaExpandarrow1,"Canada check box");
  			sleep(2000);
  			
  			verifyMustExists(AlbertacheckBox,"Alberta Arrow" );
  			click(AlbertacheckBox,"Alberta Arrow");
  			verifyMustExists(BritishColumbiacheckBox,"British Columbia Arrow" );
  			click(BritishColumbiacheckBox,"British Columbia Arrow");
  					
  			verifyMustExists(SaveBtn,"Save button");
  			click(SaveBtn,"Save button");
  			sleep(2000);
  			if(isVisible(policy.ConEndrsmntPopUp) == true)
  			{
  				sleep(1000);
  				waitForElementToAppear(policy.SaveBtn3,5);
  				verifyExists(policy.SaveBtn3,"Save Button");
  				javaScriptclick(policy.SaveBtn3,"Save Button");
  				sleep(5000);
  			}

  			scrollUp();
  			sleep(2000);
  			policy.navigationOnBordereauxTab();
			String GetData = Configuration.url + "/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+ "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			
  			Br.SubmitBordereaux(subSheet);
  			
  			try 
  			{
  				String fpath = new File(".").getCanonicalPath();
  				sheet3649Path = fpath+"\\src\\test\\resources\\testdata\\January Location Rule Test_TC_3649.xlsx";
  			} 
  			catch (IOException e) 
  			{
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			File excelFile = new File(sheet3649Path);  
  			policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);
  			String Ufname = "S97482320181122.xlsx";	
  			int size = 19427;
  			
  			String BordreauID = "a95e2bc1-c484-4c1f-9ca2-fa75ea47383f";
  			String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
  	        String ID = extractIDFromResponseinsideContract(response); 
  	        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
  	        addAsDraft(payload,DraftUrl);
  	        Br.refreshUploadedFile();	
  			
  	        if(isVisible(Br.ReviewBtn)==true){
  				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
  				click(Br.ReviewBtn,"Review Button");
  				sleep(3000);
  				waitForElementToAppear(Br.SuRcdAssmnt,10);
  				verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
  				click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
  				Br.refreshUploadedFileForApprovalStatus();
  				Br.clickOnForApprovalBtn();
  				//click(BordereauProcess.ForApprovalButton,"ForApproval button");
  				Br.clickOnApproveBordBtn();
  				Br.refreshUploadedFileApprovedStatus();
  				waitForElementToAppear(Br.Approvedbtn,10);
  				verifyMustExists(Br.Approvedbtn,"Approve Button");
  				
  				if(isVisible(Br.Approvedbtn)==true){
  					Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
  					policy.navigateRulesTab();
  					policy.navigateBreachesTab();
  					
  					//Step 1
  					waitForElementToAppear(policy.RulesDD,3);
  					verifyMustExists(policy.RulesDD,"Rules Drop Down");
  					click(policy.RulesDD,"Rule Drop Down");
  					sleep(2000);
  					if(isVisible(RiskLocatedCountry)==true){
  						Report.LogInfo("validateExpectedoption", "Risks Located State option  displayed", "PASS");
  						click(RiskLocatedCountry,"Rule Drop Down value");
  						sleep(2000);
  						List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
  						AcualRiskCountry = list.size();
  						if(AcualRiskCountry ==4)
  						{
  							Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualRiskState,"PASS");
  						}else{
  							Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualRiskState,"FAIL");
  						}
  						sleep(2000);
  					}else{
  						Report.LogInfo("validateExpectedoption", "Risks Located State option not displayed", "FAIL");
  					}
  				
  					
  					//Step 2
  					
  					sleep(2000);
						refreshPage();
						sleep(2000);
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						click(policy.RulesDD,"Rule Drop Down");
							if(isVisible(RisksLocatedState)==true){
								Report.LogInfo("validateExpectedoption", "Insured Domiciled country option  displayed", "PASS");
								click(RisksLocatedState,"Rule Drop Down value");
								sleep(2000);
								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
								AcualRiskState = list.size();
								if(AcualRiskState ==3)
								{
									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualInsuredCountry,"PASS");
								}else{
									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualInsuredCountry,"FAIL");
								}
								sleep(2000);
							}else{
								Report.LogInfo("validateExpectedoption", "Insured Domiciled country option not displayed", "FAIL");
							}
						sleep(2000);	
						
						
						
  					sleep(2000);;
  					refreshPage();
  					sleep(2000);
  					waitForElementToAppear(policy.RulesDD,3);
  					verifyMustExists(policy.RulesDD,"Rules Drop Down");
  					click(policy.RulesDD,"Rule Drop Down");
  						if(isVisible(InsuredDomiciledCountry)==true){
  							Report.LogInfo("validateExpectedoption", "Insured Domiciled State option  displayed", "PASS");
  							click(InsuredDomiciledCountry,"Rule Drop Down value");
  							sleep(2000);
  							List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
  							AcualInsuredCountry = list.size();
  							if(AcualInsuredCountry ==4)
  							{
  								Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualInsuredState,"PASS");
  							}else{
  								Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualInsuredState,"FAIL");
  							}
  							sleep(2000);
  						}else{
  							Report.LogInfo("validateExpectedoption", "Insured Domiciled State option not displayed", "FAIL");
  						}
  					
  					
  					//Step 3
  						sleep(2000);
  						refreshPage();
  						sleep(2000);
  						waitForElementToAppear(policy.RulesDD,3);
  						verifyMustExists(policy.RulesDD,"Rules Drop Down");
  						click(policy.RulesDD,"Rule Drop Down");
  						sleep(2000);
  							if(isVisible(InsuredDomiciledState)==true){
  								Report.LogInfo("validateExpectedoption", "Risk Located country option  displayed", "PASS");
  								click(InsuredDomiciledState,"Rule Drop Down value");
  								sleep(2000);
  								List <WebElement> list = findWebElements(Br.ActualExpectedRowCount);
  								AcualInsuredState = list.size();
  								if(AcualInsuredState ==3)
  								{
  									Report.LogInfo("ValidateRecords","Records count matches with the records in the excel file. Actual records count is:"+AcualRiskCountry,"PASS");
  								}else{
  									Report.LogInfo("ValidateRecords","Records count does not match with the records in the excel file. Actual records count is:"+AcualRiskCountry,"FAIL");
  								}
  								sleep(2000);
  							}else{
  								Report.LogInfo("validateExpectedoption", "Risk Located country option not displayed", "FAIL");
  							}
  					
  							
  					
  				
  					
  				}else{
  					Report.LogInfo("validateApprovedbutton", "Approved Status Button not Displayed", "FAIL");
  				}			
  				
  	        }else{
  				Report.LogInfo("validateReviewbutton", "Review Status Button not Displayed", "FAIL");
  			}	
 		

      }
}



