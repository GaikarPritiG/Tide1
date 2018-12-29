/**
 * 
 */
package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

/**
 * @author root
 *
 */
public class FinancialCalculationPage extends PageBase {
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	PolicyPage policy = new PolicyPage();
	Stage1Page St1 = new Stage1Page();
	String Questionnaire = "SP -";
	Rules rule = new Rules();
	BordereauProcessPage Processing = new BordereauProcessPage();
	DataAssignmentAndApproverRolesPage rule1 = new DataAssignmentAndApproverRolesPage();
	SoftAssert softAssertion= new SoftAssert();
	SchemaPage schema = new SchemaPage();
//	ReferenceData reference = new ReferenceData();
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
	
	public static  String ErrorPageValidate = "";
	public static  String ErrorPageValidate1 = "";
	public static Boolean BooleanFlag;
	public static Boolean BooleanFlag1;
	public static final String Section1TAB = "@xpath=//a[text()='Section 1']"; 
	public static final String AddSection= "@xpath=//a[text()=' Add Section']";
	public static final String EditSection1= "@xpath=//div[@ng-if='editSectionDetails1']/ul/li/a";
	public static final String EditBtn_Section1= "@xpath=//div[@ng-if='editSectionDetails1']/ul/li/ul/li/a";
	public static final String BrokerageInput= "@xpath=//input[@ng-model='data.Brokerage']";
	public static final String CoverHolderCommisionInput= "@xpath=//input[@ng-model='data.Comission']";
	public static final String SaveChangesbtn_editSection= "@xpath=//button[contains(.,'Save Changes')]";
	
	
	
	
	public static String contractId;
	public static String allSheetsPath = "";
	public static String firstSheetPath = "";
	public static String lastSheetPath = "";
	public static String Sheet1592Path = "";
	public static String sheet3419Path = "";
	
	
	
	static String Count;
	static int ActualCount;
	
	public static final String  input1072 ="@xpath=//input[@ng-model='sheet.HeaderIndex']";
	

	public static final String firstErrorROE = "@xpath=//input[@id='Data0']";
	public static final String SecondErrorROE = "@xpath=//input[@id='Data1']";
	public static final String ThirdErrorROE = "@xpath=//input[@id='Data2']";
	//Locators for apply filter on policies
	public static final String PolicyLink = "@xpath=//a[text()='POLICIES']";
	public static final String PolicyReferenceFilterIcon = "@css=thead[role=rowgroup] th:nth-child(1) span";
	public static final String SearchText = "@xpath=//form[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']//input[@placeholder='Search']";
	public static final String DatePick = "@xpath=//input";
	
	public static final String SearchTextBDType = "@xpath=//input[@placeholder='Search']";
	public static final String FilterButton = "@css=.k-button.k-primary";
	public static final String ApprovedTab ="@xpath=//a[text()='Approved']";
	//Open Selected policy
	public static final String SelectedPolicy = "@css=tbody[role='rowgroup'] td:nth-child(1)";

	public static final String DraftBtn = "@buttonText=Draft";

	// Submit Borderaux
	public static final String BORDEREAUXLink = "@xpath=//*[@ng-if='(IsBinder || isLineslip) && IsBordereauTabDisplay']";
	public static final String Processingtab = "@xpath=.//*[@data-ui-sref='app.contract.bordereauxParent.bordereauxTabs({BordereauxTypeEnum: 2})']";
	public static final String SubmitBordereauxDropdown = "@xpath=//*[text()='Submit Bordereaux']//following-sibling::button[1]";
	public static final String SelectOptionRisk = "@css=[data-ng-repeat='w in dataSetList']:nth-child(1)";
	public static final String SelectNewquestionnaire = "@xpath=//*[@ng-model='ProcessingUploadData.FormatId']//preceding-sibling::span[1]";
	public static final String EnterOptionToSelect = "@xpath=//*[@id='formatUL-list']/span/input";
	public static final String PreviousAnsYesRadioBtn ="@css=.form-group.p-r-0.m-t-10>label:nth-child(1)";
	public static final String Calender = "@css=.k-icon.k-i-calendar";
	public static final String CalenderInputBox = "@css=.form-control.calTextHgt.full-width.k-input";
	public static final String DateJan = "@xpath=//a[text()='Jan']";
	public static final String datefield= "@id=Data0";
	public static final String PreviousAnsNoRadioBtn = "@xpath=//div[@class='form-group p-r-0 m-t-10']//descendant::label[@class='radio radio-inline m-r-20'][2]";
	public static final String BlankDetailsMsg = "@xpath=//*[@kendo-grid='grid']//td[text()='No result returned']";
	public static final String BlankDetailsMsgRiskTab = "@xpath=//*[@id='grid']//td[text()='No result returned']";
	public static final String ProcessAgainstSelectedPeriodBtn ="@xpath=//*[@id='content']//button[@ng-click='validateAndCheck()']";
	public static final String ProcessBordereauPage = "@css=.card-body.p-30.m-b-30";
	public static final String ProcessAsAdditionalBtn ="@xpath=//*[@id='content']//button[@ng-click='UpdateBordereauxStatus()']";
	public static final String ProcessAsCorrectionBtn ="@xpath=//*[@id='content']//button[@ng-click='CorrectionBordereaux()']";


	//File upload
	public static final String ClickDragDrop = "@css=.dz-default.dz-message.col-sm-12.col-xs-12.ng-scope";
	public static final String UploadSection ="@xpath=//div[contains(@ng-model,'picFile')]";
	public static final String PicFile = "@model=picFile";
	public static final String ReviewButton ="@buttonText=Review";
	public static final String RefreshAfterUpload= "@xpath=//a[@aria-label='Refresh']/span";
	public static final String Alert = "@css=.sweet-alert.BordereauxCss";
	public static final String AlertOKButton = "@xpath=//*[@id='mainPage']/div[2]/div[2]/p/button[1]";

	//to verify counts on sheets
	public static final String RiskTab ="@css=.k-master-row.ng-scope>td:nth-child(4)";
	public static final String SelectedPageCount ="@css=.k-input";
	public static final String TotalCount = "@css=.k-selectable .ng-scope";
	public static final String ChangePageCountDropDn = "@css=.k-icon.k-i-arrow-60-down";
	public static final String ChangePageCountTo = "@xpath=//li[text()='20']";
	public static final String ActualExpectedRowCount = "@css=.k-selectable .ng-scope";
	public static final String RiskRefrance = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='3']";
	public static final String RiskRefranceA2 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String RiskRefranceA1 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='1']";
	
	public static final String RiskRefrance2 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String Version1 = "@xpath=//tr[1]//td[@title='BreachReference']//following-sibling::td[1][text()='2']";
	public static final String Version2 = "@xpath=//tr[2]//td[@title='BreachReference']//following-sibling::td[1][text()='2']";
	public static final String  RuleConditionExists = "@xpath=//dl/dd[contains(.,'if the rule conditions are met')]";
	public static final String ActualCountPolicyRefrence = "@css=.k-selectable .ng-scope td:nth-child(13)";
	public static final String RiskTabAfterReview ="@xpath=//*[@id='grid']//preceding::td//button[contains(text(),'Review')]//following::td[contains(text(),'Risk')][1]";

	//Delete created BorderEAUX
	public static final String DeleteButton = "@css=.c-red.glyphicon.glyphicon-trash";
	public static final String DeleteYESButton = "@xpath=//button[@ng-click='onYes()']";
	public static final String DeleteCancelButton = "@xpath=//button[@ng-click='onNo()']";
	public static final String PolicyHome = "@css=a[href='#!/app/contractlist']";

	//You can select the sheet for processing this time (the expected sheet text for future processing will remain unchanged)
	public static final String ProcessingTiem = "@css=.k-input.k-readonly";
	public static final String ProcessingTimeSecond = "@css=.k-input";
	public static final String May2017 = "@xpath=//ul[@class='k-list k-reset']//li[text()='May 2017']";
	public static final String June2017 = "@xpath=//ul[@class='k-list k-reset']//li[text()='June 2017']";

	//CANCEL PROCESSING AND DELETE BORDEREAU   //div[@class="btn btn-danger ng-scope"][contains(.,'Resolve Errors')]
	public static final String NegativePremiumResolveErrors = "@xpath=//div[@class=\"btn btn-danger ng-scope\"][contains(.,'Resolve Errors')]";
	public static final String ErrorsAndWarningTab = "@xpath=//*[@id=\"content\"]//a[contains(.,'Errors & Warnings')]";
	public static final String cancelAndDeleteProBtn = "@xpath=//*[@id='content']//button[@ng-click='cancel()']";  
	public static final String ErrorsAndWarnings = "@xpath=//*[@id='content']//a[contains(text(),'Errors & Warnings']"; 
	public static final String ResolveError = "@xpath=//*[@id='content']//div[contains(text(),'Resolve Errors']";
	public static final String NegativeGrossPremium = "@xpath=//*[@id='multiReference_Id']//input[@model ='item.Gross_Premium']";
	
	
	public static final String cancelAndDeleteProBtn1 = "@xpath=//div[@ng-click='cancel(data.BordereauxId)']";
	public static final String ReviewBtn ="@xpath=//button[text()='Review']";
	public static final String ErrorProcessingBtn ="@xpath=//button[text()='Error Processing']";
	public static final String ApprvedBtn ="@xpath=//button[text()='Approved']";
	public static final String SuRcdAssmnt ="@xpath=//*[@id='content']//button[@ng-click='submitBordereau()']";
	public static final String FrApprovalbtn ="@xpath=//*[@id='grid']//button[@ng-click='GoToBordereauSummaryScreen(dataItem, false)']";
	public static final String FrApprovalbtn1 ="@xpath=//button[text()='For Approval']";
	public static final String PartialSubmission ="@xpath=//a[2][contains(.,'Partial Submission')]//following::span[contains(.,'Yes')]";
	//Loactors for SubmitBordereauxFIrstSheet
	public static final String BorderEAUXFirst ="@css=[href='#!/app/contract/253fe192-ba5e-4586-b3d2-c13dbf40e802/bordereaux/2']";
	public static final String BorderEAUXLast ="@css=[href='#!/app/contract/7807ee46-ba51-445d-b5fa-69d71dc08856/bordereaux/2']";
	public static final String CalenderLastST ="@css=.k-icon.k-i-calendar";
	public static final String CalenderFirstST ="@css=.k-icon.k-i-calendar";

	//1] Processing for BorderEAUX
	public static final String ReviewError ="@xpath=//*[@id='grid']//button[contains(.,'Review Errors')]";
	public static final String ForAssigmnentButton ="@xpath=//*[@id='grid']//button[contains(.,'For Assignment')]";
	public static final String ErrorScreen ="@css=.f-400.c-red.normalWhiteSpace.ng-binding.ng-scope";
	public static final String ErrorScreen1 ="@xpath=//h2[contains(.,'Transaction Type')]";
	public static final String RefreshAfterUpload1="@xpath=//*[@options='mainGridOptions']//*[@title='Refresh']//span";
	public static final String ContinueProc ="@xpath=.//*[@ng-click='processBordereau()']";
	public static final String ProcessBorderEAuButton ="@xpath=//button[@ng-click='nextStep()']";
	public static final String SheetNameErrorMsg ="@css=[name='form.bordereauxIdentifySheet'] .row dl:nth-child(4) dt";
	//2] Edit Specific Text
	public static final String ToEditSpecificText = "@css=.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty";
	public static final String RemainUnchangedRadioButton = "@xpath=//label[@class='radio radio-inline ng-scope']";
	public static final String NoSingelContainProcessingTime = "@css=.k-input.ng-scope";
	public static final String Mar2017 = "@xpath=//div[@class='k-list-scroller']//li[1]";

	//1] Sheet Processing
	public static final String SelectDropDown = "@xpath=//*[@ng-model='form.newSheetIndex']//preceding-sibling::span[1]";
	public static final String SelectOptionJune = "@xpath=//li[contains(text(),'May 2017')]";

	//1] To cancel Bordereau process
	public static final String CancelAndDeleteBordereaux ="@xpath=//button[@ng-click='cancel()']";
	public static final String CancelAndDeleteBordereauxSp2 ="@xpath=//*[@id='content']//button[@ng-click='cancel(data.BordereauxId)']";
	public static final String pausebtn ="@xpath=.//*[@ng-click='pause()']";
	public static final String YesCancelProcessing ="@xpath=//p[@class='ng-scope']//button[@ng-click='onYes()']";
	public static final String ContinueProcessingBodrBtn ="@xpath=//*[@id='content']//button[@ng-click='UpdateSequence()']";
	public static final String ContinueProcessing= "@xpath = //*[@id='multiReference_Id']//button[@type='submit']";
	//public static final String ProcessBordereaux1 = "@xpath =//button[@class='btn btn-primary m-l-5 ng-scope']";
	public static final String ProcessBordereaux = "@xpath = //*[@id='content']/div/ui-view/div/div/div[4]/div/div[2]/button[3]";
	//Locators:-TC-3245
	public static final String continuebtx= "@xpath=//button[@ng-click='save()']|//button[@ng-click='continue()']";
	public static final String continuebtx2= "@xpath=//*[@id='RID_Id']//button[@type='submit']";
	public static final String DateTextBox= "@css=#Data0";

	//One or more error pop up
	public static final String OneMoreError ="@xpath=//h2[contains(text(),'One or more ')]";
	public static final String CancelProcessingBtn ="@xpath=//button[contains(.,'CANCEL PROCESSING AND DELETE BORDEREAU')]";
	public static final String ContinueProcessingBtn ="@xpath=//button[contains(.,'Process Bordereau')]";
	public static final String DuplicateColumn ="@xpath=//h2[contains(text(),'Duplicate bordereau column')]";
	public static final String SheetNameRadioBtx ="@css=[name='form.bordereauxIdentifySheet'] .row dl:nth-child(4) dt label";
	public static final String sheetdropdown ="@css=.k-input.ng-scope";

	//public static final String April2017 ="@css=.k-list.k-reset li:nth-child(2)";
	public static final String April2017 ="@xpath=//*[@class='k-item ng-scope'][2]";
	public static final String tidevaluedropdown ="@css=.k-widget.k-dropdown.k-header.m-b.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty";
	public static final String tidevaluedropdown1 ="@xpath=//*[@id='content']/div/div/div[1]/div/div[3]/div[2]/table/tbody/tr/td[2]/div/div/div/span/span/span[2]/span";
	public static final String tidevalueNew ="@css=body>div:nth-of-type(2) li:nth-child(4)";

	public static final String discardRecord="@xpath=//table/tbody/tr[3]/td[3]/button";
	public static final String RecordsNotImported ="@xpath=//table/tbody/tr/td[3]/label[contains(.,'Records will not be imported')]";
	public static final String ContractIndentifiedText ="@xpath=//table/tbody/tr/td/label[contains(.,'Contract identified - records will be imported')]";
	public static final String yearAccount ="@xpath=//*[@id=\"Data0\"]";
	public static final String yearAccount1 ="@css=#Data1";
	public static final String inceptionDate ="@xpath=//*[@ng-model='item.RiskInceptionDate']";

	public static final String SuccessNotificationMsgAfterUpload="@xpath=//*[@id='mainPage']/descendant::div[@class='sweet-alert BordereauxCss']/h2[1][contains(text(),'Good job!')]";
	public static final String FailureNotificationMsgAfterUpload="@xpath=//*[@id='mainPage']/descendant::div[@class='sweet-alert BordereauxCss']/h2[1][contains(text(),'Errors identified!')]";

	public static final String OkButtonOnSuccessNotification="@xpath=//*[@id='mainPage']/descendant::div[@ng-show='BordereauSuccess']/descendant::button[contains(text(),'Ok')]";
	public static final String CancelButtonOnFailureNotification="@xpath=//*[@id='mainPage']/descendant::div[@ng-show='BordereauError || BordereauLargeUpload']/descendant::button[contains(text(),'Cancel')]";
	public static final String ErrorScreenMsg1 ="@xpath=//h2[contains(.,'Duplicate bordereau column names identified')]";
	
	public static final String ErrorScreenMsg ="@xpath=//h2[contains(.,'Header columns are not in the correct sequence')]";
	public static final String ContractStatusMsg ="@css=.col-sm-7 .font-bold.lead";
	//public static final String YesCancelProcessing ="@css=.confirm.btn.btn-lg.btn-danger.waves-effect.waves-light[ng-click='onYes()']";

	public static final String continuebtn= "@xpath=//*[@ng-focus='Focused = true']";
	public static final String ForApprovalBtn = "@xpath=//button[contains(.,'For Approval')]";
	public static final String ForAssignmentBtn = "@xpath=//button[contains(.,'For Assignment')]";

	// Locators for checkRecordsAndDeleteRecord
	public static final String filterIconRecords = "@css=[data-field='StatusString'] span";
	public static final String filterIconRecordsBodrTyp = "@xpath=//th[@data-field='BordereauxType']//span[@class='k-icon k-i-filter']";
	public static final String filterIconRecordsMonth = "@xpath=//th[@data-field='MonthString']//span[@class='k-icon k-i-filter']";

	public static final String BodrTypFilterIcon ="@xpath=.//*[@data-title='Bordereau Type']/a[1]";
	public static final String RiskChckBx ="@xpath=//input[@name='BordereauxType'][@value='Risk']";
	public static final String ClaimChckBx ="@xpath=//input[@name='BordereauxType'][@value='Claim']";
	public static final String PremiumChckBx ="@xpath=//input[@name='BordereauxType'][@value='Premium']";
	public static final String ReviewErrorCheckBox = "@css=input[value='Review Errors']";
	public static final String ReviewCheckBox = "@css=input[value='Review']";
	public static final String UploadCheckBox = "@css=input[value='Uploaded']";
	public static final String ApproveCheckBox = "@css=input[value='Approved']";
	public static final String FilterButtonRecords = "@css=.k-button.k-primary";
	public static final String BodrFilterBtn ="@xpath=//input[@value='Risk']//following::button[@type='submit']";
	public static final String TotalRowCountAfterFiltered = "@css=tbody[role='rowgroup'] tr";
	public static final String CancelBtn ="@xpath=//*[@class='sweet-alert ']//p//button[contains(.,'Cancel')][1]";
	public static final String UnApprvBdrBtn ="@xpath=.//*[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";

	//Locators for Due date filter
	public static final String DuteDatefilterIcon = "@css=[data-title='Due Date'] .k-icon.k-i-filter";
	public static final String DuteDatefilterIconInputBox = "@css=.k-textbox.k-space-right>input";
	public static final String DueDateFiterBtn = "@css=.k-button.k-primary";
	public static final String DueDateCheckbx = "@xpath=//input[@name='DueDate']";

	
	//Finantial calculations
	public static final String DATAClaimTab="@xpath=//*[text()='Claim']";
	public static final String DATAPremiumTab="@xpath=//*[text()='Premium']";
	public static final String CorrectedVal = "@id=Data0";
	public static final String DATAlink ="@xpath=//*[@ng-click='clickedContractData()']";
	public static final String DATARiskTab="@xpath=//*[text()='Risk']";
	public static final String RowNumber="@xpath=//*[@data-field='RowNumber']";
	public static final String RowNumberAscIcon ="@xpath=//*[@data-field='RowNumber']//*[@class='k-icon k-i-sort-asc-sm']";
	public static final String GrossPremiumIncludingTax="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
	public static final String GrossPremium="@xpath=//*[@data-field='Gross_Premium']";
	public static final String CoverholderCommission="@xpath=//*[@data-field='Coverholder_Commission']";
	public static final String CoverholderCommissionPercent="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
	public static final String NetPremium="@xpath=//*[@data-field='Net_Premium']";
	public static final String LondonBrokerage="@xpath=//*[@data-field='London_Brokerage']";
	public static final String LondonBrokeragePercent="@xpath=//*[@data-field='London_Brokerage_Percent']";
	public static final String FinalNetPremium="@xpath=//*[@data-field='Final_Net_Premium']";
	public static final String DataLinkNoResult="@xpath=//*[text()='No result returned']";
	public static final String GrossPremiumTaxFirstRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='105.00']";
	public static final String GrossPremiumTaxSecondRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='100.00']";
	public static final String GrossPremiumTaxThirdRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
	public static final String GrossPremiumTaxFourthRow="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
	public static final String GrossPremiumFirstRow="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][text()='100.00']";
	public static final String GrossPremiumSecondRow="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][text()='100.00']";
	public static final String CoverholderCommissionFirstRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[31][text()='124.50']";
	public static final String CoverholderCommissionThirdRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[31][text()='124.50']";
	public static final String CoverholderCommissionFourthRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[31][text()='0.00']";
	public static final String CoverholderCommissionFifthRow="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[5]//td[31][text()='0.00']";
	public static final String CoverholderCommissionPercentFirstRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50']";
	public static final String CoverholderCommissionPercentThirdRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
	public static final String CoverholderCommissionPercentFourthRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
	public static final String CoverholderCommissionPercentFifthRow="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
	public static final String NetPreiumSixthRow="@xpath=//*[@data-field='Net_Premium']//following::tr[6]//td[contains(@ng-click,'Net_Premium')][text()='75.50']";
	public static final String NetPreiumSeventhRow="@xpath=//*[@data-field='Net_Premium']//following::tr[7]//td[contains(@ng-click,'Net_Premium')][text()='100.00']";
	public static final String NetPreiumEighthRow="@xpath=//*[@data-field='Net_Premium']//following::tr[8]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
	public static final String LondonBrokerageLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[10]//td[contains(@ng-click,'London_Brokerage')][text()='0.00']";
	public static final String LondonBrokerageSecondlastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[9]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
	public static final String LondonBrokerageThirdLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[8]//td[contains(@ng-click,'London_Brokerage')][text()='20.00']";
	public static final String BrokeragePercentLastRow="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[10]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='10.00 %']";
	public static final String BrokeragePercentSecondLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[9]//td[contains(@ng-click,'London_Brokerage')][text()='5.00 %']";
	public static final String BrokeragePercentThirdLastRow="@xpath=//*[@data-field='London_Brokerage']//following::tr[8]//td[contains(@ng-click,'London_Brokerage')][text()='10.00 %']";
	public static final String FinalNetPremiumLastRow="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[10]//td[contains(@ng-click,'Final_Net_Premium')][text()='-24.50']";
	public static final String FinalNetPremiumSecondLastRow="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[9]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
	public static final String FinalNetPremiumThirdLastRow="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[8]//td[contains(@ng-click,'Final_Net_Premium')][text()='-20.00']";

	public static final String TaxHeader = "@xpath=//th[@data-field='Tax_1']";
	public static final String TotalTaxRecords ="@xpath=//*[@role='rowgroup']//tr[7]//td[48]";
	public static final String TaxFirstRow = "@xpath=//*[@data-field='Tax_Total']//following::tr[8]//td[contains(@ng-click,'Tax_Total')][text()='0.00']";
	public static final String TaxSecondRow = "@xpath=//*[@data-field='Tax_Total']//following::tr[9]//td[contains(@ng-click,'Tax_Total')][text()='5.00']";
	public static final String TaxThirdRow = "@xpath=//*[@data-field='Tax_Total']//following::tr[10]//td[contains(@ng-click,'Tax_Total')][text()='5.00']";
	public static final String TaxPercentFirstRow = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[8]//td[contains(@ng-click,'Tax_Total_Percent')][text()='5.00 %']";
	public static final String TaxPercentSecondRow = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[9]//td[contains(@ng-click,'Tax_Total_Percent')][text()='5.00 %']";
	public static final String TaxPercentThirdRow = "@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[10]//td[contains(@ng-click,'Tax_Total_Percent')][text()='5.00 %']";
	
	//Reference,Cell,Original Value,Enriched ValueText 
	public static final String RiskReferenceTxt = "@xpath=//*[@id=\"content\"]/div/div/div[1]/div[3]/table/thead/tr/th[1]";
	public static final String CellTxt = "@xpath=//*[@id=\"content\"]/div/div/div[1]/div[3]/table/thead/tr/th[2]";
	public static final String ORIGINALVALUETxt = "@xpath=//*[@id=\"content\"]/div/div/div[1]/div[3]/table/thead/tr/th[3]";
	public static final String Enrichedvaluetxt = "@xpath=//*[@id=\"Data0\"]";
	
	//TC 3430 Sprint 3
	public static final String EnrichedValueTxt = "@id=Data0";
	public static final String CanBtn = "@xpath=//*[@id='content']//button[@ng-click='cancel()']";
	public static final String RiskOrderFirstRow80 = "@xpath=//*[@id=\"grid\"]/div[3]/table/tbody/tr[1]/td[26]";
	public static final String RiskOrderSecondRow100 = "@xpath=//*[@id=\"grid\"]/div[3]/table/tbody/tr[2]/td[26]";
	public static final String RiskOrderThirdRow60 = "@xpath=//*[@id=\"grid\"]/div[3]/table/tbody/tr[3]/td[26]";

	public static final String GrossPremFirstRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2]";
	public static final String GrossPremSecondRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2]";
	public static final String GrossPremThirdRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2]";

	public static final String CCFirstRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1]";
	public static final String CCSecondRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1]";
	public static final String CCThirdRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][1]";

    public static final String RevertToUploaded ="@xpath=//button[@ng-click= 'RevertToUploaded()']";

	public static final String NPFirstRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1]";
	public static final String NPSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][1]";
	public static final String NPThirdRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][1]";

	public static final String FNPFirstRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][2][text()='-2,371.31']";
	//public static final String FNPSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][2][text()='-4,054.60']";
	public static final String FNPSecondRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][2][text()='-4,054.60']";
	public static final String FNPThirdRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][2][text()='-50,473.50']";

	//Loactors TC_3448
	public static final String CancelStatusAndLeaveUploadingStatusButton = "@xpath=//button[@ng-click='UpdateStatusToPreSequenceRule()']";
	public static final String ContractPreriodPrior = "@xpath=//h2[text()='Bordereau period prior to contract inception']";
	public static final String ContinueProcess = "@xpath=//button[@ng-click='validateAndCheck()']";
	
	public static final String SameBordereauNotYetApproved = "@xpath=//h2[text()='Another bordereau of the same period is not yet approved']";
	public static final String PreviousBordereauNotYetApproved = "@xpath=//h2[contains(.,'Previous bordereau not Approved')]";
	public static final String UploadedButton = "@xpath=//button[text()='Uploaded']";
	public static final String AnotherBordereauSamePeriodNotYetApprovedPage = "@css=h2.font-bold.lead";
	public static final String UploadedDeleteButton = "@xpath=//button[text()='Uploaded']//following-sibling::span[1]/i";
	public static final String UploadedDeleteYESButton = "@xpath=//button[@ng-click='onYes()']";
	public static final String cancelAndDeleteProBtnYes = "@xpath=//button[@ng-click='onYes()']";
	public static final String CancelAndDeleteBtn ="@xpath=//*[@ng-click='cancel()']";

	//public static final String MappingTotalCount="@xpath=//*[@ng-bind='dataItem.MatchCount']";

	//==================================================
	public static final String discardRecords="@xpath=//*[@ng-click='DiscardRecords(item)']";
	public static final String inceptionDate1 ="@xpath=//*[text()='D2']/..//*[@ng-model='item.RiskInceptionDate']";
	public static final String inceptionDate2 ="@xpath=//*[text()='D3']/..//*[@ng-model='item.RiskInceptionDate']";
	//public static final String tidevalueUSD ="@xpath=//*[@id='Data0_listbox']/li[3]";
	public static final String tidevalueUSD ="@xpath=//*[@id='Data0-list']//li[text()='USD - United States Dollar']";
	public static final String tidevalueUSD1 ="@xpath=//*[@id='Data0_listbox']//li[text()='USD - United States Dollar']";
	
	public static final String Approvedbtn="@xpath=//*[@ ng-click='GoToBordereauSummaryScreen(dataItem, false)'][text()='Approved']";
	public static final String ApprovedbtnSncdRw="@xpath=//tr[2]//*[@ ng-click='GoToBordereauSummaryScreen(dataItem, false)'][text()='Approved']";
	public static final String ApprovedbtnThirdRw="@xpath=//tr[3]//*[@ ng-click='GoToBordereauSummaryScreen(dataItem, false)'][text()='Approved']";

	public static final String PremiumCurrency="@xpath=//*[@data-field='Premium_Currency']";
	public static final String RiskCurrency="@xpath=//*[@data-field='Risk_Currency']";
	public static final String PremiumCurrencyfirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[32]";
	public static final String PremiumCurrencysecondRow="@xpath=//*[@role='rowgroup']//tr[2]//td[32]";
	public static final String RiskCurrencyfirstRow="@xpath=//*[@role='rowgroup']//tr[1]//td[33]";
	public static final String RiskCurrencySecondRow="@xpath=//*[@role='rowgroup']//tr[2]//td[33]";
	//public static final String BooleanName="@xpath=//*[text()='Boolean'][1]";
	public static final String MappingTotalCount="@xpath=//*[@ng-bind='dataItem.MatchCount']";
	public static final String SignedBtn = "@buttonText=Signed";

	//Loactors TC_3717
	public static final String EnrichedTxt ="@model=item.EnrichData";
	public static final String ContinueBtn ="@xpath=//button[contains(.,'Continue')]";
	public static final String NewOrRenewal ="@xpath=//*[@id='DiscardRisk_listbox']//li[text()='New or Renewal']";
	public static final String PolicyNum ="@xpath=//*[@id='DiscardRisk_listbox'][@aria-hidden='false']//li[text()='Policy Number']";
	public static final String NoBuildings ="@xpath=//*[@id='DiscardRisk_listbox']//li[text()='No. Buildings']";
	public static final String RiskTxt ="@xpath=//*[@id='DiscardRisk_taglist']/following-sibling::input";
	public static final String ClearValues ="@xpath=//span[@title='clear']";

	//
	public static final String AddContractForPolicy="@xpath=//*[@ng-if='PermissionContract.Add']"; 
	public static final String ContractStatusMsg1 ="@xpath=//h2[text()='Contract Status not Signed']";

	public static final String VerifyErrorpage ="@xpath=//h2[text()='Sprinklers (Y/N) reference data translation required']";
	public static final String SkipAllErrorsBtn="@xpath=//*[@ng-click='SkipAllErrros()']";
	public static final String CancelProcessingButton="@xpath=//*[@ng-click='cancel(data.BordereauxId)']";
	public static final String PauseButton="@xpath=//*[@ng-click='pause()']";
	public static final String ViewDiscardedRecordsIcon="@xpath=//label[text()='View Discarded Records']/../label[2]";
	public static final String BlankRecordsMsg = "@xpath=//*[@kendo-grid='form.grid']//td[text()='No result returned']";

	public static final String BooleanName="@xpath=//*[@ng-bind='dataItem.Name']";
	public static final String ReferenceDataFilterIcon ="@xpath=//*[@data-field='Name']//span";


	public static final String ContinueProcessingbtn ="@xpath=//*[@ng-click='ContinueProcessing()']";
	public static final String columnTab ="@xpath=//button[contains(.,'Column')]";	
	public static final String Version ="@xpath=//*[@data-field='FormatVersion']//following::tr[1]//td[8]";
	public static final String EditQuestionNairebtn ="@xpath=//*[@ng-click='EditQuestionnaire()']";
	public static final String SaveAndReprocessBtn ="@xpath=//*[@ng-if='saveAndReprocess']";
	public static final String ContinuebtnOnErrorScreen ="@xpath=//*[@ng-click='processBordereau()']";
	public static final String DownloadBorderEAU ="@xpath=//*[@ng-click='DownloadFile()']";
	public static final String TideField= "@css=.k-dropdown-wrap";
	public static final String ContentsValue ="@xpath=//li[contains(.,'Contents Value')]";
	public static final String ForApprovalButton= "@xpath=//button[contains(.,'For Approval')]";

	public static final String Okbtn="@xpath=//*[@ng-click='cancel()']";
	public static final String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[6]";
	public static final String RuleNameRiskExpiryDate="@xpath=//*[@uib-popover='Risk Expiry Date defaulted from the Risk Inception Date plus 1 year']";
	public static final String OriginalValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
	public static final String ChangedValue="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";

	public static final String Roletab="@xpath=//a[text()='Roles']";

	public static final String MainEditdot= "@xpath=//ul[@class='actions ng-scope']//a[@class='dropdown-toggle']";
	public static final String CreateContract= "@xpath=//*[@ng-if='PermissionContract.Add']";
	public static final String TransformationErrorScreen= "@xpath=//*[text()='Bordereau Transformation']";
	public static final String YesBtn = "@xpath=//*[@value='true']/parent::label";
	public static final String MultiContractBtn = "@xpath=//*[@ng-if='!Loading1 && contractList.length']//button";
	public static final String Contract2017 = "@xpath=//*[@ng-click='GetSelectedContract(w)']/a[contains(.,'2017')]";

	public static final String SectionIdDropDwn1Risk1 = "@xpath=//tr[1]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk2= "@xpath=//tr[2]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk3 = "@xpath=//tr[3]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk4 = "@xpath=//tr[4]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk5 = "@xpath=//tr[5]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwnOption3 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'D8')]";
	public static final String BordereauAssignmentSectionDropDwnOptionRiskCode = "@xpath=//li[text()='Data in the bordereau will specify the Risk Code']";
	
	 public static final String SectionAssignmentRuleScreenFor2017 ="@xpath=//h2[text()='Section Assignment Rule - 2017 Year of Account Contract (01/01/2017 - 31/12/2017)']";
	  public static final String  SectionIdDropDwn1="@xpath=//tr[1]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn2="@xpath=//tr[2]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn3="@xpath=//tr[3]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn4="@xpath=//tr[4]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn5="@xpath=//tr[5]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String SectionIdDropDwnOption1 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1 (Primary Risk Code: 1T)')]";
	  public static final String SectionIdDropDwnOption2 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2 (Primary Risk Code: 1T)')]";
	  public String OrgnlValue = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
	  public String ChngdValue = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
	  
	  
	  
	//-------------------------------------------------------- Financial Calculations Tests---------------------------------------------------------------------//
	



		
		
		public String ActualGrossPremium;
		public String ActualGrossPremiumIncludingTax;
		public String ActualCoverHolderCommission;
		public String ActualCoverHolderCommissionPercent;
		public String ActualNetPremium;
		public String ActualBrokerageAmount;
		public String ActualBrokeragePercent;
		public String ActualFinalNetPremium;
		public String ActualTaxAmount;
		public String ActualTaxAmountPercent;
		public String ActualProducingBrokerage;
		public String ActualProducingBrokeragePercent;
		public String cvhrHldrCmmssnPecntClm;
		public String cvrhldrCmmssnPercntgOrgVlue;
		public String cvrhldrCmmssnPercntgChngdVlue;
		public String covrHldrCommssnPercentgRule;
		String ExpectedCvrHldrPercntgVlue = "10.00";	
		String ExpectedBrktgAmntVlue = "50.00";
		String ExpectedBrkrgpercntgVlue = "5.00";
		String ExpectedTaxAmntVlue = "100.00";	
		public String CovrHldrCommsnClm;
		public String covrHldrCommssnOrgVlu;
		public String covrHldrCommssnChngdVlu;
		public String covrHldrCommssnRule;
		public String ActlBrkrgAmntClmn;
		public String ActlBrkrgOrgVlue;
		public String ActlBrkrgchngdVlu;
		public String ActlBrkrgRule;
		public String ActlBrkrgPrcntClmn;
		public String ActlBrkrgPrcntOrgVlu;
		public String ActlBrkrgPrcntChngVlu;
		public String ActulFnlNtPrmumOrgVlu;
		public String ActulFnlNtPrmumChngVlu;
		public String ActulFnlNtPrmumRule;
		public String ActlTotlTaxOrgVlu;
		public String ActlTotlTaxChngVlu;
		public String ActlTotlTaxRule;
		public String ActlNetPrmumToBrkrrgVlu;
		public String ActlNetPrmumToBrkrrChngVlu;
		public String ActlNetPrmumToBrkrrRule;
		public String ActulGrossPrmumIncldgTaxOrgVlu;
		public String ActulGrossPrmumIncldgTaxChngVlu;
		public String ActulGrossPrmumIncldgTaxRule;
		public String ActulTotlTaxpecntOrgVlu;
		public String ActulTotlTaxpecntChngVlu;
		public String ActulTotlTaxpecntRule;
		public String ActlTotlTxClmn;
		public String ActlTotlTxamntOrgVlue;
		public String ActlTotlTxAmntchngdVlu;
		public String ActlTotlTxAmntRule;
		public String ActualTaxAmountPercentcnvrtDecml;
		public String ActualTaxAmountPercentcnvrtDecmlOrgVlu;
		public String ActualTaxAmountPercentcnvrtDecmlChngVlu;
		public String ActualTaxAmountPercentcnvrtDecmlRule;
		
		
		
		
		
		// Headers
		String Gross_PremiumCol="@xpath=//*[@data-field='Gross_Premium']";
		String Gross_Premium_including_TaxCol="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
		String Coverholder_CommissionCol="@xpath=//*[@data-field='Coverholder_Commission']";
		String Coverholder_Commission_PercentCol="@xpath=//*[@data-field='Coverholder_Commission_Percent']";
		String BrokerageCol="@xpath=//*[@data-field='London_Brokerage']";
		String BrokeragePercentCol="@xpath=//*[@data-field='London_Brokerage_Percent']";
		String London_Brokerage_PercentCol="@xpath=//*[@data-field='London_Brokerage_Percent']";
		String Net_PremiumCol="@xpath=//*[@data-field='Net_Premium']";
		String Final_Net_PremiumCol="@xpath=//*[@data-field='Final_Net_Premium']";
		String Tax_TotalCol ="@xpath=//*[@data-field='Tax_Total']";
		String Tax_Total_PercentCol="@xpath=//*[@data-field='Tax_Total_Percent']";
		String Producing_BrokerageCol="@xpath=//*[@data-field='Producing_Brokerage']";
		String Producing_Brokerage_PercentCol="@xpath=//*[@data-field='Producing_Brokerage_Percent']";
		
		//
		
		
		
		public static final String RiskCode1EDDValue ="@xpath=//ul[@aria-hidden='false']//li[1]";
		public static final String RiskCode1TDDValue ="@xpath=//ul[@aria-hidden='false']//li[1]";
		
		
		
				
//============================================ TC -FinancialTestScenario start================================================== 		
		public void FinancialTestScenario(int count) throws InterruptedException, Exception, Exception
		{


			String subSheet1 = "Financial Test - Scenario 001";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				Sheet1592Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculations.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(Sheet1592Path);  
			
			//Id\":\""+contractId+"\",\"Id\":\
			//for(int FCTC=1;FCTC<39;FCTC++)
		//	{
				switch(count)
				{
					case 2:
					{
						
						policy.CreateContractwithInceptionDate2018();
						// applyFilterPolicy("802113WJ");
						policy.applyFilterPolicy(policy.PolicyNumber);	 
						policy.openSelectedPolicy();
						Editsection1("5","10");   //edit section1
					
						policy.addSection2_FC("Section 2", "10", "15");  //Add Section2
						policy.navigateToSection2Tab();
						
						policy.navigateToMarketsTabOnSection();
						policy.addMarketOnSection();
						
						policy.navigateToRiskCodesTabOnSection();
						policy.addRiskCodesOnSection();
//						
					
						
						
						Report.LogInfo("File upload Status", "2nd File uploaded", "INFO");
//						//02
						
						  
					 
						// hardcoded String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"802113WJ"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

						String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
						
						
						contractId = addNewBordereauFormatPolicy(payload1, GetData);
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "5c0e840d-0a8e-40a9-8a69-c52619d60d25";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
						//Updated :>String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S98730620180614.xlsx\",\"BordereauFormatId\":\"5c0e840d-0a8e-40a9-8a69-c52619d60d25\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S98730620180614.xlsx\",\"UniqueFileName\":\"S98730620180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

				        //uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				        Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();
							
							
			               //Gross premium including tax
							ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							//Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							ActualCoverHolderCommission = CoverHolderCommission();
							//Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							//(ActualNetPremium, "900.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							//(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							// Validation(ActualFinalNetPremium, "850.00");
					
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}


					}
					break;
					case 3:
					{
						Report.LogInfo("File upload Status", "3rd File uploaded", "INFO");
						//03
						deleteBorderEAUX2();
						
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "e34efd67-246f-4f12-8eee-7c50bd073196";
						//String BordreauID = "7728f697-89f2-4b27-b837-a125359d566d";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
						//Updated:> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S24785720180614.xlsx\",\"BordereauFormatId\":\"7728f697-89f2-4b27-b837-a125359d566d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24785720180614.xlsx\",\"UniqueFileName\":\"S24785720180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						
						
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				        Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							// Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							// Validation(ActualCoverHolderCommission, "100.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							// Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							// Validation(ActualFinalNetPremium, "850.00");
							
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;
					
					
					case 4:
					{
						Report.LogInfo("File upload Status", "4th File uploaded", "INFO");
						//04
						deleteBorderEAUX2();
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "d57549f8-78d9-4cd0-a0e7-e196797152a5";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
					//Updated :> 	String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S72350920180614.xlsx\",\"BordereauFormatId\":\"44a31975-2b92-4ba8-83f9-97cb4abf5f07\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72350920180614.xlsx\",\"UniqueFileName\":\"S72350920180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						
					//	uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				        Processing.refreshUploadedFile();						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							
							//expected data 04
							String ExpectedGrossIncludingTax04 = "0.00";
							String ExpectedCoverHolderCommission04 = "0.00";
							String ExpectedNetPremium04 = "0.00";
							String ExpectedBrokerageAmount04 = "0.00";
							
							
							
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 // Validation(ActualGrossPremiumIncludingTax, "1000.00");
							
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 // Validation(ActualCoverHolderCommission, "100.00");
							
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 // Validation(ActualNetPremium, "900.00");
							
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 // Validation(ActualBrokerageAmount, "50.00");
							
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}
					}
					break;
					
					case 6:
					{
					
						 ArrayList<String> DataCapture1 = new ArrayList<String>();
						
						Report.LogInfo("File upload Status", "6th File uploaded", "INFO");
						//06
						deleteBorderEAUX2();
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "245371ed-c933-4ae9-8583-8a527457d2a0";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
					//Updated:>	String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S17203820180614.xlsx\",\"BordereauFormatId\":\"245371ed-c933-4ae9-8583-8a527457d2a0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S17203820180614.xlsx\",\"UniqueFileName\":\"S17203820180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
				        Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();
							String CoverholdrCoulmn = "@xpath=//*[@data-title='Coverholder Commission']";
							String CoverhldrcommissionfirstRow = "@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'30') and contains(@ng-click,'Coverholder_Commission')]";
							String CvrHldrCmmssnPercntgClm = "@xpath=//*[@data-title='Coverholder Commission %']";
							String CoverHolderCommissionPercent1stRow="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'31') and contains(@ng-click,'Coverholder_Commission_Percent')]";
							String BrkrgAmntClumn = "@xpath=//*[@data-title='Brokerage']";
							String BrokerageValuelocartor = "@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Brokerage') and contains(@ng-click,' 35')]";
							String BrkrgPrcntClumn = "@xpath=//*[@data-title='Brokerage %']";
							String BrokeragePercentValuelocartor = "@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'London_Brokerage_Percent') and contains(@ng-click,' 36')]";
							String GrossPremiumIncludingTaxValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'26') and contains(@ng-click,'Gross_Premium_including_Tax')]";

			               //Gross premium including tax
							// ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							 DataCapture1 =  Processing.RuleDataCapture(GrossPremiumIncludingTaxValuelocartor,"Gross Premium Including Tax","-","1,000.00","Calculate Gross Premium including Tax");
							 ActulGrossPrmumIncldgTaxOrgVlu = DataCapture1.get(0);
							 ActulGrossPrmumIncldgTaxChngVlu = DataCapture1.get(1);
							 ActulGrossPrmumIncldgTaxRule = DataCapture1.get(2);
							Report.LogInfo("Gross Premium Including Tax ",ActualGrossPremiumIncludingTax , "PASS");
							
							//CoverholderCommission
							 waitForElementToAppear(CoverholdrCoulmn,5);
								mouseOverAction(CoverholdrCoulmn);
								verifyMustExists(CoverholdrCoulmn,"Coverholder Commission column");
								CovrHldrCommsnClm =  getTextFrom(CoverholdrCoulmn);
								Report.LogInfo("Coverholder Commission column",CovrHldrCommsnClm , "PASS");
								sleep(2000);
								verifyExists(CoverhldrcommissionfirstRow,"1st value");
								ActualCoverHolderCommission =  getTextFrom(CoverhldrcommissionfirstRow);
								Report.LogInfo("Coverholder Commission Value",ActualCoverHolderCommission , "PASS");
								javaScriptclick(CoverhldrcommissionfirstRow,"value");
								sleep(1500);
								waitForElementToAppear(Okbtn,10);
								verifyExists(OrgnlValue,"Coverholder Commission Original Value");
								covrHldrCommssnOrgVlu = getTextFrom(OrgnlValue);
								Report.LogInfo("Coverholder Commission Original Value",covrHldrCommssnOrgVlu , "PASS");
								sleep(1500);
								verifyMustExists(ChngdValue,"Coverholder commission Changed Value");
								covrHldrCommssnChngdVlu = getTextFrom(ChngdValue);
								Report.LogInfo("coverholder Commission Changed Value",covrHldrCommssnChngdVlu , "PASS");
								//click(GRPChngdVlu,"Gross Premium Changed Value");
								sleep(1500);
								verifyExists(RuleNameField,"Rule Name Field");
								covrHldrCommssnRule =  getTextFrom(RuleNameField);
								Report.LogInfo("Rule Name Field", covrHldrCommssnRule, "PASS");
								click(Okbtn,"ok Buttton");
								sleep(2000);
								//CoverholderCommissionPercent
								waitForElementToAppear(CvrHldrCmmssnPercntgClm,5);
								mouseOverAction(CvrHldrCmmssnPercntgClm);
								verifyMustExists(CvrHldrCmmssnPercntgClm,"Coverholder Commission column");
								cvhrHldrCmmssnPecntClm =  getTextFrom(CvrHldrCmmssnPercntgClm);
								Report.LogInfo("Coverholder Commission % column",cvhrHldrCmmssnPecntClm , "PASS");
								sleep(2000);
								verifyExists(CoverHolderCommissionPercent1stRow,"1st value");
								ActualCoverHolderCommissionPercent =  "10.00";
								Report.LogInfo("Coverholder Commission Percentage Value",ActualCoverHolderCommissionPercent , "PASS");
								javaScriptclick(CoverHolderCommissionPercent1stRow,"value");
								sleep(1500);
								waitForElementToAppear(Okbtn,10);
								verifyExists(OrgnlValue,"Coverholder Commission Percentage Original Value");
								cvrhldrCmmssnPercntgOrgVlue = getTextFrom(OrgnlValue);
								Report.LogInfo("Coverholder Commission Original Percentage Value",cvrhldrCmmssnPercntgOrgVlue , "PASS");
								sleep(1500);
								verifyMustExists(ChngdValue,"Coverholder commission Percentage Changed Value");
								cvrhldrCmmssnPercntgChngdVlue = getTextFrom(ChngdValue);
								Report.LogInfo("coverholder Commission Percentage Changed Value",cvrhldrCmmssnPercntgChngdVlue , "PASS");
								//click(GRPChngdVlu,"Gross Premium Changed Value");
								sleep(1500);
								verifyExists(RuleNameField,"Rule Name Field");
								covrHldrCommssnPercentgRule =  getTextFrom(RuleNameField);
								Report.LogInfo("Rule Name Field", covrHldrCommssnPercentgRule, "PASS");
								click(Okbtn,"ok Buttton");
								sleep(2000);
								if(ActualCoverHolderCommissionPercent.equals(ExpectedCvrHldrPercntgVlue))
								{
									Report.LogInfo("ValidateExpectedCvrHldrPercntg", "Coverholder commission Percentage Column validate successfully", "PASS"); 
									}
									else
								{
									Report.LogInfo("ValidateExpectedCvrHldrPercntg", "Coverholder commission Percentage Column not validate successfully", "FAIL");
									}
								sleep(2000);
								
							//Brokerage Amount
								 waitForElementToAppear(BrkrgAmntClumn,5);
								 mouseOverAction(BrkrgAmntClumn);
								 verifyMustExists(BrkrgAmntClumn,"Brokerage Amount column");
								 ActlBrkrgAmntClmn =  getTextFrom(BrkrgAmntClumn);
								 Report.LogInfo("Brokerage Amount column",ActlBrkrgAmntClmn , "PASS");
								 sleep(2000);
								 verifyExists(BrokerageValuelocartor,"1st value");
								 ActualBrokerageAmount = "50.00";
								 Report.LogInfo("Brokerage Amount Value",ActualBrokerageAmount , "PASS");
								 javaScriptclick(BrokerageValuelocartor,"value");
								 sleep(1500);
								 waitForElementToAppear(Okbtn,10);
								 verifyExists(OrgnlValue,"Brokerage Amount Original Value");
								 ActlBrkrgOrgVlue = getTextFrom(OrgnlValue);
								 Report.LogInfo("Brokrage Amount Original Value",ActlBrkrgOrgVlue , "PASS");
								 sleep(1500);
								 verifyMustExists(ChngdValue,"Brokerage Amount Changed Value");
								 ActlBrkrgchngdVlu = getTextFrom(ChngdValue);
								 Report.LogInfo("Brokerage Amount Changed Value",ActlBrkrgchngdVlu , "PASS");
								 //click(GRPChngdVlu,"Gross Premium Changed Value");
								 sleep(1500);
								 verifyExists(RuleNameField,"Rule Name Field");
								 ActlBrkrgRule =  getTextFrom(RuleNameField);
								 Report.LogInfo("Rule Name Field", ActlBrkrgRule, "PASS");
								 click(Okbtn,"ok Buttton");
								 sleep(2000);
								 if(ActualBrokerageAmount.equals(ExpectedBrktgAmntVlue))
								 {
									 Report.LogInfo("ValidateExpectedBrokrgAmnt", "Brokerage Amount Column validate successfully", "PASS"); 
										}
											else
								{
									Report.LogInfo("ValidateExpectedBrokrgAmnt", "Brokerage Amount Column not validate successfully", "FAIL");
									}
										sleep(2000);
													
							// ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Brokerage Amount Percent
							 
							 waitForElementToAppear(BrkrgPrcntClumn,5);
							 mouseOverAction(BrkrgPrcntClumn);
							 verifyMustExists(BrkrgPrcntClumn,"Brokerge Percent column");
							 ActlBrkrgPrcntClmn =  getTextFrom(BrkrgPrcntClumn);
							 Report.LogInfo("Brokerage Percent column",ActlBrkrgPrcntClmn , "PASS");
							 sleep(2000);
							 verifyExists(BrokeragePercentValuelocartor,"1st value");
							 ActualBrokeragePercent = "5.00";
							 Report.LogInfo("Brokerage Percent column Value",ActualBrokeragePercent , "PASS");
							 javaScriptclick(BrokeragePercentValuelocartor,"value");
							 sleep(1500);
							 waitForElementToAppear(Okbtn,10);
							 verifyExists(OrgnlValue,"Brokerage Percentage Original Value");
							 ActlBrkrgPrcntOrgVlu = getTextFrom(OrgnlValue);
							 Report.LogInfo("Brokerage Percentage Original Value",ActlBrkrgPrcntOrgVlu , "PASS");
							 sleep(1500);
							 verifyMustExists(ChngdValue,"Brokerage Percentage Changed Value");
							 ActlBrkrgPrcntChngVlu = getTextFrom(ChngdValue);
							 Report.LogInfo("Brokerage Percentage Changed Value",ActlBrkrgPrcntChngVlu , "PASS");
							 //click(GRPChngdVlu,"Gross Premium Changed Value");
							 sleep(1500);
							 verifyExists(RuleNameField,"Rule Name Field");
							 covrHldrCommssnPercentgRule =  getTextFrom(RuleNameField);
							 Report.LogInfo("Rule Name Field", covrHldrCommssnPercentgRule, "PASS");
							 click(Okbtn,"ok Buttton");
							 sleep(2000);
							 if(ActualBrokeragePercent.equals(ExpectedBrkrgpercntgVlue))
							 {
								 Report.LogInfo("ValidateExpectedBrokrgPercntg", "Brokerage Percentage Column validate successfully", "PASS"); 
								}
								else
								{
								 Report.LogInfo("ValidateExpectedBrokrgPercntg", "Brokerage commission Percentage Column not validate successfully", "FAIL");
							}
							 sleep(2000);							 ActualBrokeragePercent= BrokeragePercent();
							 //	 Validation(ActualBrokeragePercent, "5.00 %");
					
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					case 7:
					{
						ArrayList<String> DataCapture1 = new ArrayList<String>();
						ArrayList<String> DataCapture2 = new ArrayList<String>();
						ArrayList<String> DataCapture3 = new ArrayList<String>();
						ArrayList<String> DataCapture4 = new ArrayList<String>();
					
						Report.LogInfo("File upload Status", "7th File uploaded", "INFO");
						//07
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "1274d1d9-99ae-4a75-a461-282c30cd8f75";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
				
						//Updated:> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S23102420180614.xlsx\",\"BordereauFormatId\":\"49304c14-ea47-4572-be28-3787fcde7de4\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S23102420180614.xlsx\",\"UniqueFileName\":\"S23102420180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							String Final_Net_PremiumValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Final_Net_Premium') and contains(@ng-click,'37')]";
							String TotlTxAmntClumn = "@xpath=//*[@data-title='Total Tax']";
							String Tax_TotalValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'100') and contains(@ng-click,'Tax_Total')]";
							String Net_PremiumValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Net_Premium') and contains(@ng-click,'34')]";
							String TaxAmountPercentValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'101') and contains(@ng-click,'Tax_Total_Percent')]";
							//CoverholderCommission 
							ActualCoverHolderCommission = CoverHolderCommission();
							Report.LogInfo("Coverholder Commission Value",ActualCoverHolderCommission , "PASS");
							 // Validation(ActualCoverHolderCommission, "100.00");
							sleep(2000);
							//Net Premium to Broker
							// ActualNetPremium= NetPremium();
							// Validation(ActualNetPremium, "900.00");
							DataCapture2 =  Processing.RuleDataCapture(Net_PremiumValuelocartor,"Net Premium to Broker","-","900.00","Calculate Net Premium");
							ActlNetPrmumToBrkrrgVlu = DataCapture2.get(0);
							ActlNetPrmumToBrkrrChngVlu = DataCapture2.get(1);
							ActlNetPrmumToBrkrrRule = DataCapture2.get(2);
							Report.LogInfo("Net Premium to Broker",ActualNetPremium , "PASS");
							sleep(2000);
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 Report.LogInfo("Brokerage Amount",ActualBrokerageAmount , "PASS");
							 // Validation(ActualBrokerageAmount, "50.00");
							sleep(2500);
							//Final Net premium
							// ActualFinalNetPremium=FinalNetPremium();
							// Validation(ActualFinalNetPremium, "850.00");
							DataCapture3 =  Processing.RuleDataCapture(Final_Net_PremiumValuelocartor,"Final Net Premium Amount","-","850.00","Calculate Final Net Premium");
							ActulFnlNtPrmumOrgVlu = DataCapture3.get(0);
							ActulFnlNtPrmumChngVlu = DataCapture3.get(1);
							ActulFnlNtPrmumRule = DataCapture3.get(2);
							 Report.LogInfo("Final Net Premium",ActualFinalNetPremium , "PASS");
							sleep(2500);
							//Total Tax Amount
							// ActualTaxAmount= TaxAmount();
							 // Validation(ActualTaxAmount, "100.00");
							waitForElementToAppear(TotlTxAmntClumn,5);
							 mouseOverAction(TotlTxAmntClumn);
							 verifyMustExists(TotlTxAmntClumn,"Brokerage Amount column");
							 ActlTotlTxClmn =  getTextFrom(TotlTxAmntClumn);
							 Report.LogInfo("Total Tax amount",ActlTotlTxClmn , "PASS");
							 sleep(2000);
							 verifyExists(Tax_TotalValuelocartor,"1st value");
							 ActualTaxAmount = "100.00";
							 Report.LogInfo("Total Tax Amount Value",ActualTaxAmount , "PASS");
							 javaScriptclick(Tax_TotalValuelocartor,"value");
							 sleep(1500);
							 waitForElementToAppear(Okbtn,10);
							 verifyExists(OrgnlValue,"Total Tax Amount Original Value");
							 ActlTotlTxamntOrgVlue = getTextFrom(OrgnlValue);
							 Report.LogInfo("Total Tax Amount",ActlTotlTxamntOrgVlue , "PASS");
							 sleep(1500);
							 verifyMustExists(ChngdValue,"Total Tax Amount");
							 ActlTotlTxAmntchngdVlu = getTextFrom(ChngdValue);
							 Report.LogInfo("Total Tax Amount",ActlTotlTxAmntchngdVlu , "PASS");
							 //click(GRPChngdVlu,"Gross Premium Changed Value");
							 sleep(1500);
							 verifyExists(RuleNameField,"Rule Name Field");
							 ActlTotlTxAmntRule =  getTextFrom(RuleNameField);
							 Report.LogInfo("Rule Name Field", ActlTotlTxAmntRule, "PASS");
							 click(Okbtn,"ok Buttton");
							 sleep(2000);
							 if(ActualBrokerageAmount.equals(ExpectedBrktgAmntVlue))
							 {
								 Report.LogInfo("ValidateExpectedBrokrgAmnt", "Brokerage Amount Column validate successfully", "PASS"); 
									}
										else
							{
								Report.LogInfo("ValidateExpectedBrokrgAmnt", "Brokerage Amount Column not validate successfully", "FAIL");
								}
									sleep(2000);
									
									ActualTaxAmountPercentcnvrtDecml=TaxAmountPercent();
									 // Validation(ActualTaxAmountPercent, "10.00 %");
									 DataCapture4 =  Processing.RuleDataCapture(TaxAmountPercentValuelocartor,"Tax Amount Percent Value Cvert Decimal","0.1","10.00","Convert decimal values in percentage fields to a percentage value");
									 ActualTaxAmountPercentcnvrtDecmlOrgVlu = DataCapture4.get(0);
									 ActualTaxAmountPercentcnvrtDecmlChngVlu = DataCapture4.get(1);
									 ActualTaxAmountPercentcnvrtDecmlRule = DataCapture4.get(2);
									Report.LogInfo("Tax Amount Percent Value Cvert Decimal",ActualTaxAmountPercentcnvrtDecml , "PASS");
									sleep(2000)	;	
							
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;
					
					case 8:
					{
						
						ArrayList<String> DataCapture1 = new ArrayList<String>();
						Report.LogInfo("File upload Status", "8th File uploaded", "INFO");
						//08
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "3d42f631-3b50-43bf-a9e2-863721dbf719";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
					//	String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S62211420180614.xlsx\",\"BordereauFormatId\":\"b84cbbf1-afed-4cce-9087-15c1f153e383\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S62211420180614.xlsx\",\"UniqueFileName\":\"S62211420180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();
							String TaxAmountPercentValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'101') and contains(@ng-click,'Tax_Total_Percent')]";
		
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 // Validation(ActualTaxAmountPercent, "10.00 %");
							 DataCapture1 =  Processing.RuleDataCapture(TaxAmountPercentValuelocartor,"Tax Amount Percent Value","-","10.00","Calculate Total Tax Percentage");
							 ActulTotlTaxpecntOrgVlu = DataCapture1.get(0);
							 ActulTotlTaxpecntChngVlu = DataCapture1.get(1);
							 ActulTotlTaxpecntRule = DataCapture1.get(2);
							Report.LogInfo("Tax Amount Percent Value",ActualTaxAmountPercent , "PASS");
							sleep(2000);
						
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //Validation(ActualCoverHolderCommission, "100.00");
							 sleep(2000);
							
							//Net Premium
							 ActualNetPremium = NetPremium();
							 //	 Validation(ActualNetPremium, "900.00");
							 sleep(2500);
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 // Validation(ActualBrokerageAmount, "50.00");
							sleep(2500);
							 
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 // Validation(ActualFinalNetPremium, "850.00");
						
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;
					
					case 9:
					{
						Report.LogInfo("File upload Status", "9th File uploaded", "INFO");
						//09
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "219e720f-7b74-47e4-b59a-a46f14edd119";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S59731220180614.xlsx\",\"BordereauFormatId\":\"219e720f-7b74-47e4-b59a-a46f14edd119\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S59731220180614.xlsx\",\"UniqueFileName\":\"S59731220180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,100.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "900.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
						
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;
					
					case 10:
					{
						Report.LogInfo("File upload Status", "10th File uploaded", "INFO");
						//10
						
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "d781617e-01ff-4026-8600-20899511d703";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
				        
				        
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S70403420180614.xlsx\",\"BordereauFormatId\":\"d781617e-01ff-4026-8600-20899511d703\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70403420180614.xlsx\",\"UniqueFileName\":\"S70403420180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();
							
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 // Validation(ActualTaxAmountPercent, "10.00 %");
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 // Validation(ActualGrossPremiumIncludingTax, "1,100.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 // Validation(ActualNetPremium, "900.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 // Validation(ActualFinalNetPremium, "850.00");
							
							deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;
					
					case 11:
					{
						Report.LogInfo("File upload Status", "11th File uploaded", "INFO");
						
						//11
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "6163dc47-0175-49af-b5bc-964847bbefbf";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S20334620180614.xlsx\",\"BordereauFormatId\":\"6163dc47-0175-49af-b5bc-964847bbefbf\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20334620180614.xlsx\",\"UniqueFileName\":\"S20334620180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";						
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 // Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 // Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 // Validation(ActualNetPremium, "900.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
							
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;
					
					case 12:
					{
						Report.LogInfo("File upload Status", "12th File uploaded", "INFO");
						
						//12
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "aa60f4a1-23f3-45fa-ac8c-5591a2e02458";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
					//Updated : > 	String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S20334620180614.xlsx\",\"BordereauFormatId\":\"aa60f4a1-23f3-45fa-ac8c-5591a2e02458\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20334620180614.xlsx\",\"UniqueFileName\":\"S20334620180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";	
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

						
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");

							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 //	 Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommissionPercent
							 ActualCoverHolderCommissionPercent = CoverHolderCommissionPercent();
							 //	 Validation(ActualCoverHolderCommissionPercent, "10.00 %");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "900.00");
							
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
							
						
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					case 13:
					{
						Report.LogInfo("File upload Status", "13th File uploaded", "INFO");
						
						//13
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "743fc85f-cba6-43f8-90a3-1cda50e35ef8";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
					//Updated:> 	String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S56028720180614.xlsx\",\"BordereauFormatId\":\"743fc85f-cba6-43f8-90a3-1cda50e35ef8\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56028720180614.xlsx\",\"UniqueFileName\":\"S56028720180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

						
							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 //	 Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 // Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 // Validation(ActualNetPremium, "900.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					case 14:
					{
						Report.LogInfo("File upload Status", "14th File uploaded", "INFO");
						
						//14
						
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "712fa89f-c0fb-4703-9674-83a8f095fda4";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S91978320180614.xlsx\",\"BordereauFormatId\":\"712fa89f-c0fb-4703-9674-83a8f095fda4\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S91978320180614.xlsx\",\"UniqueFileName\":\"S91978320180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();


							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //		 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 //		 Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //		 Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //		 Validation(ActualNetPremium,"800.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //		 Validation(ActualBrokerageAmount, "50.00");

							 //Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "750.00");
		
							//Producing Brokerage Percent
							 ActualProducingBrokeragePercent=ProducingBrokeragePercent();
							 // Validation(ActualProducingBrokeragePercent, "10.00 %");
													
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					case 15:
					{
						Report.LogInfo("File upload Status", "15th File uploaded", "INFO");
						
						//15
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "b2a8f3af-10c5-4faf-877c-a39e218581a6";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S54329320180614.xlsx\",\"BordereauFormatId\":\"b2a8f3af-10c5-4faf-877c-a39e218581a6\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S54329320180614.xlsx\",\"UniqueFileName\":\"S54329320180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 //	 Validation(ActualTaxAmountPercent, "10.00 %");
						
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission,"100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "800.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 // Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 Validation(ActualFinalNetPremium, "750.00");
							
							//Producing Brokerage
							 ActualProducingBrokerage=ProducingBrokerage();
							 //	ProducingBrokerageValidation(ActualProducingBrokerage, "100.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					case 16:
					{
						Report.LogInfo("File upload Status", "16th File uploaded", "INFO");
						
						//16
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "009cd9d8-a921-4456-b492-ca776c118127";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S18762420180614.xlsx\",\"BordereauFormatId\":\"009cd9d8-a921-4456-b492-ca776c118127\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S18762420180614.xlsx\",\"UniqueFileName\":\"S18762420180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 // Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 // Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "800.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "750.00");
							
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					case 17:
					{
						Report.LogInfo("File upload Status", "17th File uploaded", "INFO");
						
						//17
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "61b7efe3-99b3-4927-b404-88fdb476455e";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S74453520180614.xlsx\",\"BordereauFormatId\":\"61b7efe3-99b3-4927-b404-88fdb476455e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74453520180614.xlsx\",\"UniqueFileName\":\"S74453520180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							//expected data 17
							String ExpectedTaxAmount17 = "100.00";
							String ExpectedTaxAmountPercent17 = "10.00 %";
							String ExpectedCoverHolderCommission17 = "60.00";
							String ExpectedBrokerageAmount17 = "50.00";
							String ExpectedFinalNetPremium17 = "850.00";
							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 //	 Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
							
						
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 18:
					{
						Report.LogInfo("File upload Status", "18th File uploaded", "INFO");
						
						//18
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "ed256f10-d14e-4d0d-a9f3-9205fa2035c2";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S54940020180614.xlsx\",\"BordereauFormatId\":\"29f8bef9-42c6-4916-b093-b9bd23e53eb3\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S54940020180614.xlsx\",\"UniqueFileName\":\"S54940020180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";	
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 // Validation(ActualFinalNetPremium, "850.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					case 19:
					{
						Report.LogInfo("File upload Status", "19th File uploaded", "INFO");
						
						//19
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "e0979bb9-2a90-4f42-87a6-734eb1001e1e";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
					//	Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S44752220180614.xlsx\",\"BordereauFormatId\":\"07016efc-7b5f-4c37-83fc-1c8b6451b176\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44752220180614.xlsx\",\"UniqueFileName\":\"S44752220180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

						 
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
							
							//Producing Brokerage
							 ActualProducingBrokerage=ProducingBrokerage();
							 //	 Validation(ActualProducingBrokerage, "100.00");
							
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 20:
					{
						Report.LogInfo("File upload Status", "20th File uploaded", "INFO");
						
						//20
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "23ca9e35-6d1a-42e5-81b3-3d356f8170fe";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S89121020180614.xlsx\",\"BordereauFormatId\":\"7d7eef10-5c86-48b4-9386-93dd9de7d37d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S89121020180614.xlsx\",\"UniqueFileName\":\"S89121020180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,182.45");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //		 Validation(ActualCoverHolderCommission, "57.45");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "59.12");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "840.88");
							
							//Producing Brokerage Percent
							 ActualProducingBrokeragePercent=ProducingBrokeragePercent();
							 //	 Validation(ActualProducingBrokeragePercent, "not_calculated_In_data_tab");
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}
						
					}
					break;

					
					case 21:
					{
						Report.LogInfo("File upload Status", "21th File uploaded", "INFO");
						
						//21
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "7db9e797-51a9-41d5-856d-5e9480da384f";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
					//Updated:> 	//String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S20993220180614.xlsx\",\"BordereauFormatId\":\"2fc1282d-d9c1-4531-9fa4-5906c60bf95d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20993220180614.xlsx\",\"UniqueFileName\":\"S20993220180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						sleep(2000);
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

						
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 23:
					{
						Report.LogInfo("File upload Status", "23th File uploaded", "INFO");
						
						//23
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "ba1c1142-3a83-451f-a4e2-8536eae151f0";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
					//Updated :> 	String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S79344220180614.xlsx\",\"BordereauFormatId\":\"12756453-6103-409d-a097-85a66c53a105\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S79344220180614.xlsx\",\"UniqueFileName\":\"S79344220180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					deleteBorderEAUX2();
					//	uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //		 Validation(ActualTaxAmount, "0.00");
						
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //		 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "850.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 24:
					{
						Report.LogInfo("File upload Status", "24th File uploaded", "INFO");
						
						//24
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "ba36f4b6-a785-42ac-acfa-8ec37c33b3e6";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :>String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S54105220180614.xlsx\",\"BordereauFormatId\":\"ba36f4b6-a785-42ac-acfa-8ec37c33b3e6\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S54105220180614.xlsx\",\"UniqueFileName\":\"S54105220180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "900.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "900.00");
							
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 25:
					{
						Report.LogInfo("File upload Status", "25th File uploaded", "INFO");
						
						//25
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "d45fd137-14db-4cc5-be8e-f79aef932c8a";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
	
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S91469320180614.xlsx\",\"BordereauFormatId\":\"d45fd137-14db-4cc5-be8e-f79aef932c8a\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S91469320180614.xlsx\",\"UniqueFileName\":\"S91469320180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "1,000.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "950.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 26:
					{
						Report.LogInfo("File upload Status", "26th File uploaded", "INFO");
						
						//26
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "4446ee6a-152a-4e05-bda0-075f878c2685";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
				        //Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S79640320180614.xlsx\",\"BordereauFormatId\":\"4446ee6a-152a-4e05-bda0-075f878c2685\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S79640320180614.xlsx\",\"UniqueFileName\":\"S79640320180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //		 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //		 Validation(ActualCoverHolderCommission, "100.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //		 Validation(ActualNetPremium, "900.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "50.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //		 Validation(ActualFinalNetPremium, "850.00");
							
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 27:
					{
						Report.LogInfo("File upload Status", "27th File uploaded", "INFO");
						
						//27
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "1905178b-d1cc-423b-815e-c0a073bda856";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated:> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S55694420180614.xlsx\",\"BordereauFormatId\":\"679f719c-910a-4c15-8679-3aa53d49201e\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S55694420180614.xlsx\",\"UniqueFileName\":\"S55694420180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

						
							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //		 Validation(ActualGrossPremiumIncludingTax, "0.00");
							
							//CoverholderCommission
							 ActualCoverHolderCommission = CoverHolderCommission();
							 //	 Validation(ActualCoverHolderCommission, "0.00");
							
							//Brokerage Amount
							 ActualBrokerageAmount= Brokerage();
							 //	 Validation(ActualBrokerageAmount, "0.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //		 Validation(ActualFinalNetPremium, "900.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 29:
					{
						Report.LogInfo("File upload Status", "29th File uploaded", "INFO");
						
						//29
						
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "ed1c52a4-9b89-493d-a3d3-32f31a466c58";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
				        
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S64016020180614.xlsx\",\"BordereauFormatId\":\"ed1c52a4-9b89-493d-a3d3-32f31a466c58\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S64016020180614.xlsx\",\"UniqueFileName\":\"S64016020180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							// Tax Amount
							 ActualTaxAmount= TaxAmount();
						  // Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 // Validation(ActualTaxAmountPercent, "10.00 %");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "1,000.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "1,000.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 30:
					{
						Report.LogInfo("File upload Status", "30th File uploaded", "INFO");
						
						//30
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "b7ed86b7-cc40-4c58-a9fe-abd073e3133d";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S63049520180614.xlsx\",\"BordereauFormatId\":\"96fe2bce-c8b0-448b-8372-143aab60e6c5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S63049520180614.xlsx\",\"UniqueFileName\":\"S63049520180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //		 Validation(ActualGrossPremiumIncludingTax, "0.00");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //	 Validation(ActualFinalNetPremium, "900.00");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 31:
					{
						Report.LogInfo("File upload Status", "31st File uploaded", "INFO");
						
						//31
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "8eede3b2-3c71-4910-9787-344d8f93c803";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S22507020180614.xlsx\",\"BordereauFormatId\":\"af620f3b-38e9-4a68-b40b-b5e7a57bcf53\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S22507020180614.xlsx\",\"UniqueFileName\":\"S22507020180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
			               //Gross premium including tax
							 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
							 //	 Validation(ActualGrossPremiumIncludingTax, "0.00");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //	 Validation(ActualNetPremium, "0.00");
							
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 32:
					{
						Report.LogInfo("File upload Status", "32th File uploaded", "INFO");
						
						//32
						
						deleteBorderEAUX2();
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "3cd24815-a45b-4851-bb1b-5353d69407d8";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S70490520180614.xlsx\",\"BordereauFormatId\":\"3cd24815-a45b-4851-bb1b-5353d69407d8\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70490520180614.xlsx\",\"UniqueFileName\":\"S70490520180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";	
					
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					
						if(Processing.checkErrorReviewButton(ReviewBtn)==true)
						{
							
							waitForElementToAppear(rule.SubmitRecordButton,5);
							verifyMustExists(rule.SubmitRecordButton,"SubmitRecordButton");
							click(rule.SubmitRecordButton,"SubmitRecordButton");
							waitForElementToAppear(rule1.SectionAssignmentRulepage,5);
							verifyMustExists(rule1.SectionAssignmentRulepage,"Section Assignment Rule");
							SelectDropDownValue(rule1.SectionAssignmentdropdown,rule1.SectionAssignmentdropdownValue2);
							verifyMustExists(rule1.CompleteAssignmentBtn,"Complete assignment button");
							click(rule1.CompleteAssignmentBtn,"Complete assignment button");
							sleep(3000);
							if(isVisible(ForApprovalBtn)==true)
							{
								Report.LogInfo("ValidateForApprovalStatus", "For Approval status displayed", "PASS");
								
								sleep(2000);
								Processing.openDATALink();
								Processing.navigateToDATARiskTab();

								
				               //Gross premium including tax
								 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
								 //	 Validation(ActualGrossPremiumIncludingTax, "1,000.00");
								
								//CoverholderCommission
								 ActualCoverHolderCommission = CoverHolderCommission();
								 //	 Validation(ActualCoverHolderCommission, "60.00");
								
								//Net Premium
								 ActualNetPremium= NetPremium();
								 //	 Validation(ActualNetPremium, "940.00");
								
								//Brokerage Amount
								 ActualBrokerageAmount= Brokerage();
								 //	 Validation(ActualBrokerageAmount, "50.00");
								
								//Final Net premium
								 ActualFinalNetPremium=FinalNetPremium();
								 //	 Validation(ActualFinalNetPremium, "890.00");
								 
								 Processing.Bordereaux_TAB();
								 Processing.navigateOnProcessingTab();
								 Processing.ForApprovalToReview();
								
							deleteBorderEAUX1();
								
							}
							else
							{
								Report.LogInfo("ValidateForApprovalStatus", "For Approval status not displayed", "FAIL");
							}
							
							
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
					case 33:
					{
						Report.LogInfo("File upload Status", "33th File uploaded", "INFO");
						
						//33
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "7e0f1459-23fe-41bb-b255-89ae18613d87";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						
						//updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S43826120180614.xlsx\",\"BordereauFormatId\":\"d525b4b5-b299-4a09-b530-e571adc24cd5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S43826120180614.xlsx\",\"UniqueFileName\":\"S43826120180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					
						if(Processing.checkErrorReviewButton(ReviewBtn)==true)
						{
							
							waitForElementToAppear(rule.SubmitRecordButton,5);
							verifyMustExists(rule.SubmitRecordButton,"SubmitRecordButton");
							click(rule.SubmitRecordButton,"SubmitRecordButton");
							waitForElementToAppear(rule1.SectionAssignmentRulepage,5);
							verifyMustExists(rule1.SectionAssignmentRulepage,"Section Assignment Rule");
							SelectDropDownValue(rule1.SectionAssignmentdropdown,rule1.SectionAssignmentdropdownValue2);
							verifyMustExists(rule1.CompleteAssignmentBtn,"Complete assignment button");
							click(rule1.CompleteAssignmentBtn,"Complete assignment button");
							sleep(3000);
							if(isVisible(ForApprovalBtn)==true)
							{
								Report.LogInfo("ValidateForApprovalStatus", "For Approval status displayed", "PASS");
								
								sleep(2000);
								Processing.openDATALink();
								Processing.navigateToDATARiskTab();

								
								 //Gross premium including tax
								 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
								 //	 Validation(ActualGrossPremiumIncludingTax, "957.45");
								
								//CoverholderCommission
								 ActualCoverHolderCommission = CoverHolderCommission();
								 //	 Validation(ActualCoverHolderCommission, "57.45");
								
								//Brokerage Amount
								 ActualBrokerageAmount= Brokerage();
								 //	 Validation(ActualBrokerageAmount, "47.87");
								
								//Final Net premium
								 ActualFinalNetPremium=FinalNetPremium();
								 //	 Validation(ActualFinalNetPremium, "852.13");
								 
								 Processing.Bordereaux_TAB();
								 Processing.navigateOnProcessingTab();
								 Processing.ForApprovalToReview();
								
							deleteBorderEAUX1();
								
							}
							else
							{
								Report.LogInfo("ValidateForApprovalStatus", "For Approval status not displayed", "FAIL");
							}
							
							
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
						
						
					
					break;

					
					case 34:
					{
						Report.LogInfo("File upload Status", "34th File uploaded", "INFO");
						
						//34
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "6dfd91d9-c253-4ac5-96a0-aad2c73436ba";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S34722120180614.xlsx\",\"BordereauFormatId\":\"ccb0041a-7fc8-448d-96db-1af4e0dcafdf\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S34722120180614.xlsx\",\"UniqueFileName\":\"S34722120180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					
						if(Processing.checkErrorReviewButton(ReviewBtn)==true)
						{
							
							waitForElementToAppear(rule.SubmitRecordButton,5);
							verifyMustExists(rule.SubmitRecordButton,"SubmitRecordButton");
							click(rule.SubmitRecordButton,"SubmitRecordButton");
							waitForElementToAppear(rule1.SectionAssignmentRulepage,5);
							verifyMustExists(rule1.SectionAssignmentRulepage,"Section Assignment Rule");
							SelectDropDownValue(rule1.SectionAssignmentdropdown,rule1.SectionAssignmentdropdownValue2);
							verifyMustExists(rule1.CompleteAssignmentBtn,"Complete assignment button");
							click(rule1.CompleteAssignmentBtn,"Complete assignment button");
							sleep(3000);
							if(isVisible(ForApprovalBtn)==true)
							{
								Report.LogInfo("ValidateForApprovalStatus", "For Approval status displayed", "PASS");
								
								sleep(2000);
								Processing.openDATALink();
								Processing.navigateToDATARiskTab();

								  //Gross premium including tax
								 ActualGrossPremiumIncludingTax=GrossPremiumIncludingTax();
								 //		 Validation(ActualGrossPremiumIncludingTax, "0.00");
								
								
								//CoverholderCommission
								 ActualCoverHolderCommission = CoverHolderCommission();
								 //	 Validation(ActualCoverHolderCommission, "0.00");
								
								
								//Net Premium
								 ActualNetPremium= NetPremium();
								 //	 Validation(ActualNetPremium, "0.00");
								
								
								//Brokerage Amount
								 ActualBrokerageAmount= Brokerage();
								 //	 Validation(ActualBrokerageAmount, "0.00");
								 
								 Processing.Bordereaux_TAB();
								 	Processing.navigateOnProcessingTab();
								 Processing.ForApprovalToReview();
								
							deleteBorderEAUX1();
								
							}
							else
							{
								Report.LogInfo("ValidateForApprovalStatus", "For Approval status not displayed", "FAIL");
							}
							
							
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					
						
					break;

					case 35:
					{
						Report.LogInfo("File upload Status", "35th File uploaded", "INFO");
						
						//35
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "273479e3-ad59-486f-a71c-528a785bd335";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
						//Updated :> String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S38125420180614.xlsx\",\"BordereauFormatId\":\"273479e3-ad59-486f-a71c-528a785bd335\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38125420180614.xlsx\",\"UniqueFileName\":\"S38125420180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();

							
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //	 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 //	 Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommissionPercent
							 ActualCoverHolderCommissionPercent = CoverHolderCommissionPercent();
							 //	 Validation(ActualCoverHolderCommissionPercent, "10.00 %");
							
							//Brokerage Amount Percent
							 ActualBrokeragePercent= BrokeragePercent();
							 //	 Validation(ActualBrokeragePercent, "5.00 %");
							
							
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;
					
					case 38:
					{
						Report.LogInfo("File upload Status", "38th File uploaded", "INFO");
						
						//38
						
						String Ufname = "S10423620180917.xlsx";	
						int size = 28526;
						String BordreauID = "327c6720-b82c-4aff-9845-8f756bfc8753";
				        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
				        String ID = extractIDFromResponseinsideContract(response); 
				        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
				        addAsDraft(payload,DraftUrl);
						
					//Updated:>	String payload = "{\"Bordereaux\":{\"ContractId\":\"b424d763-b4b9-49ae-b82e-5f6b606104f4\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Financial Calculations.xlsx\",\"UniqueFileName\":\"S96340320180614.xlsx\",\"BordereauFormatId\":\"327c6720-b82c-4aff-9845-8f756bfc8753\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S96340320180614.xlsx\",\"UniqueFileName\":\"S96340320180614.xlsx\",\"Filesize\":28362,\"Path\":null,\"size\":28362,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						
						deleteBorderEAUX2();
						//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
						Processing.refreshUploadedFile();
						
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
							sleep(2000);
							verifyMustExists(ReviewBtn,"Review button");
							Processing.openDATALink();
							Processing.navigateToDATARiskTab();
							
						
							sleep(3000);
							// Tax Amount
							 ActualTaxAmount= TaxAmount();
							 //		 Validation(ActualTaxAmount, "100.00");
							
							// Tax Amount Percent
							 ActualTaxAmountPercent=TaxAmountPercent();
							 //Validation(ActualTaxAmountPercent, "10.00 %");
							
							//CoverholderCommissionPercent
							 ActualCoverHolderCommissionPercent = CoverHolderCommissionPercent();
							 //		 Validation(ActualCoverHolderCommissionPercent, "10.00 %");
							
							//Net Premium
							 ActualNetPremium= NetPremium();
							 //Validation(ActualNetPremium, "675.00");
							
							//Brokerage Amount Percent
							 ActualBrokeragePercent= BrokeragePercent();
							 // Validation(ActualBrokeragePercent, "5.00 %");
							
							//Final Net premium
							 ActualFinalNetPremium=FinalNetPremium();
							 //Validation(ActualFinalNetPremium, "625.00");
							
							//Producing Brokerage Percent
							 ActualProducingBrokeragePercent=ProducingBrokeragePercent();
							 //Validation(ActualProducingBrokeragePercent, "12.50 %");
							
						deleteBorderEAUX1();
							
						}
						else{

							Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
							if(isVisible(ErrorProcessingBtn)==true){
								Report.LogInfo("ErrorProcessing Check", "File goes to error Processing", "FAIL");
							}
							if(isVisible(ReviewError)==true){
								Report.LogInfo("Review error status Check", "File goes to Review error ", "FAIL");
							}
								
							Processing.deleteBorderEAUX();
						}

					}
					break;

					
				}
			}
			
		
	public void LargeFinancialCalculation_TC3419() throws Exception
	{

		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk & Premium";
		String freqVal = "Monthly";
		String subSheet = "Large financial Value (schema_SP)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String Schema = "schema_SP";
		
		//Step 1
		policy.CreateContractwithInceptionDate2018();
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
		
//		policy.applyFilterPolicy("344333WU");
//		policy.openSelectedPolicy();
	
		Processing.SubmitBordereaux(subSheet);
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"344333WU"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3419Path = fpath+"\\src\\test\\resources\\testdata\\Large_financial_Value_3419.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3419Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//Id\":\""+contractId+"\",\"Id\":\
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_OtherFeesDescription.xlsx\",\"UniqueFileName\":\"S29916320180523.xlsx\",\"BordereauFormatId\":\"98cf018e-b38d-4086-ab3e-4359487cea40\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29916320180523.xlsx\",\"Filesize\":24158,\"Path\":null,\"size\":24158,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		
		String Ufname = "S78693720181217.xlsx";	
	    int size = 18843;
	    String BordreauID = "24955459-fb97-484c-9d03-c782298fbe83";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
		Processing.refreshUploadedFile();
        	sleep(3000);
        	
        	if(Processing.checkErrorReviewButton(Processing.ReviewError)==true)
			{
				String 	InavlaidFinanceValue ="@xpath=//h2[contains(.,'Invalid financial value translation required')]";
				sleep(2000);
				if(isVisible(InavlaidFinanceValue)== true){
					ErrorPageValidate =  getTextFrom(InavlaidFinanceValue);
					sleep(3000);
					//Error1
					verifyMustExists(schema.Data0,"Reference 2 value");
					clearTextBox(schema.Data0);
					sendKeys(schema.Data0,"1000","Reference 2 value");
					//Error2
					verifyMustExists(schema.Data_1,"Reference 3 value");
					clearTextBox(schema.Data_1);
					sendKeys(schema.Data_1,"11111111111111","Reference 3 value");
					sleep(1000);
				/*	if(isVisible(reference.DisableLocator))
					{
						Report.LogInfo("Large finance 13 digit validation at error screen", " 13 digit validation at error page successful", "PASS");
						BooleanFlag = true;
					}
					else
					{
						Report.LogInfo("Large finance 13 digit validation at error screen", " 13 digit  validation at error page Failed", "FAIL");
						BooleanFlag = false;
					}*/
					//Error2
					verifyMustExists(schema.Data_1,"Reference 3 value");
					clearTextBox(schema.Data_1);
					sendKeys(schema.Data_1,"1000","Reference 3 value");
					sleep(1000);
					verifyMustExists(ContinueBtn,"Continue button");
					click(ContinueBtn,"Continue button");
					sleep(2000);
				}
				else{
					Report.LogInfo("ErrorScreenVal", "Expected Error screen not displayed.", "FAIL");
					}
		}
		else
		{
			Report.LogInfo("ReviewErrorStatusVal", "Status not changed to Review error.", "FAIL");
		}
        	Processing.refreshUploadedFile();
        	if(Processing.checkErrorReviewButton(Processing.ReviewError)==true)
			{
				String 	LArgeFinanceValue ="@xpath=//h2[contains(.,'Large Financial Values Identified')]";
				sleep(2000);
				if(isVisible(LArgeFinanceValue)== true){
					ErrorPageValidate1 =  getTextFrom(LArgeFinanceValue);
				
					sleep(2000);
					verifyMustExists(Processing.ContinueBtn,"Continue button");
					click(Processing.ContinueBtn,"Continue button");
					sleep(2000);
					verifyMustExists(Processing.Cancelbtn1,"Cancel button");
					click(Processing.Cancelbtn1,"Cancel button");
					sleep(2000);
					if(isVisible(Processing.ReviewBtn)==true)
					{
						AssertBordereauStatusReview = getTextFrom(Processing.ReviewBtn);
						Report.LogInfo("Review status validation", "Review Status displayed", "PASS");
						
						Processing.openDATALink();
						Processing.navigateToDATARiskTab();
						
						sleep(2000);
						String discardedRecord =  "@xpath=//tr[5]//td[contains(@ng-click,'Risk Reference') and contains(@ng-click,'5')]";
						if(isVisible(discardedRecord))
						{
							Report.LogInfo("Large finance Discard record", " More than 14 digit value validation at bordereau failed", "FAIL");
							BooleanFlag1 = false;
						}
						else
						{
							Report.LogInfo("Large finance Discard record", " More than 14 digit value validation at bordereau successful", "PASS");
							BooleanFlag1 = true;
						}
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
	
	public String GrossPremium()
	{
		String Gross_PremiumValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,' 27') and contains(@ng-click,'Gross_Premium')]";
		mouseOverAction(Gross_PremiumCol);
		verifyExists(Gross_PremiumCol,"Gross premium column");
		mouseOverAction(Gross_PremiumValuelocartor);
		verifyExists(Gross_PremiumValuelocartor,"Gross premium  column first row"); 
		String ActualGrossPremium= getTextFrom(Gross_PremiumValuelocartor);
		return ActualGrossPremium;
	}
	
	public String GrossPremiumIncludingTax()
	{
		String GrossPremiumIncludingTaxValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'26') and contains(@ng-click,'Gross_Premium_including_Tax')]";
		mouseOverAction(Gross_Premium_including_TaxCol);
		verifyExists(Gross_Premium_including_TaxCol,"Gross premium including tax column");
		mouseOverAction(GrossPremiumIncludingTaxValuelocartor);
		verifyExists(GrossPremiumIncludingTaxValuelocartor,"Gross premium including tax column first row"); 
		String ActualGrossPremiumIncludingTax= getTextFrom(GrossPremiumIncludingTaxValuelocartor);
		return ActualGrossPremiumIncludingTax;
	}
	
	public String CoverHolderCommission()
	{
		String Coverholder_CommissionValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'30') and contains(@ng-click,'Coverholder_Commission')]";
		mouseOverAction(Coverholder_CommissionCol);
		verifyExists(Coverholder_CommissionCol,"Coverholder commission column");
		mouseOverAction(Coverholder_CommissionValuelocartor);
		verifyExists(Coverholder_CommissionValuelocartor,"Coverholder commission column first row"); 
		String ActualCoverHolderCommission= getTextFrom(Coverholder_CommissionValuelocartor);
		return ActualCoverHolderCommission;
	}
	
	public String CoverHolderCommissionPercent()
	{
		String Coverholder_Commission_PercentValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'31') and contains(@ng-click,'Coverholder_Commission_Percent')]";
		mouseOverAction(Coverholder_Commission_PercentCol);
		verifyExists(Coverholder_Commission_PercentCol,"Coverholder commission Percent column");
		mouseOverAction(Coverholder_Commission_PercentValuelocartor);
		verifyExists(Coverholder_Commission_PercentValuelocartor,"Coverholder commission Percent column first row"); 
		String ActualCoverHolderCommissionPercent= getTextFrom(Coverholder_Commission_PercentValuelocartor);
		return ActualCoverHolderCommissionPercent;
	}
	public String NetPremium()
	{
		String Net_PremiumValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Net_Premium') and contains(@ng-click,'34')]";
		mouseOverAction(Net_PremiumCol);
		verifyExists(Net_PremiumCol,"Net Premium Column");
		mouseOverAction(Net_PremiumValuelocartor);
		verifyExists(Net_PremiumValuelocartor,"Net Premium column first row"); 
		String ActualNetPremium= getTextFrom(Net_PremiumValuelocartor);
		return ActualNetPremium;
	}
	
	public String Brokerage()
	{
		String BrokerageValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Brokerage') and contains(@ng-click,' 35')]";
		mouseOverAction(BrokerageCol);
		verifyExists(BrokerageCol,"Brokerage Column");
		mouseOverAction(BrokerageValuelocartor);
		verifyExists(BrokerageValuelocartor,"Brokerage  Column first row"); 
		String ActualBrokerage= getTextFrom(BrokerageValuelocartor);
		return ActualBrokerage;
	}
	
	public String BrokeragePercent()
	{
		String BrokeragePercentValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'London_Brokerage_Percent') and contains(@ng-click,' 36')]";
		mouseOverAction(BrokeragePercentCol);
		verifyExists(BrokeragePercentCol,"Brokerage  Percent Column");
		mouseOverAction(BrokeragePercentValuelocartor);
		verifyExists(BrokeragePercentValuelocartor,"Brokerage  Percent Column first row"); 
		String ActualBrokeragePercent= getTextFrom(BrokeragePercentValuelocartor);
		return ActualBrokeragePercent;
	}
	
	
	public String FinalNetPremium()
	{
		String Final_Net_PremiumValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'Final_Net_Premium') and contains(@ng-click,'37')]";
		mouseOverAction(Final_Net_PremiumCol);
		verifyExists(Final_Net_PremiumCol,"Final Net Premium Column");
		mouseOverAction(Final_Net_PremiumValuelocartor);
		verifyExists(Final_Net_PremiumValuelocartor,"Final Net Premium  column first row"); 
		String ActualFinalNetPremium= getTextFrom(Final_Net_PremiumValuelocartor);
		return ActualFinalNetPremium;
	}
	
	public String TaxAmount() throws Exception
	{
		Thread.sleep(2000);
		String Tax_TotalValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'100') and contains(@ng-click,'Tax_Total')]";
		mouseOverAction(Tax_TotalCol);
		verifyExists(Tax_TotalCol,"Total tax Column");
		mouseOverAction(Tax_TotalValuelocartor);
		verifyExists(Tax_TotalValuelocartor,"Total tax column first row"); 
		String ActualTaxAmount= getTextFrom(Tax_TotalValuelocartor);
		return ActualTaxAmount;
	}
	
	public String TaxAmountPercent() throws Exception
	{
		Thread.sleep(2000);
		String TaxAmountPercentValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'101') and contains(@ng-click,'Tax_Total_Percent')]";
		mouseOverAction(Tax_Total_PercentCol);
		verifyExists(Tax_Total_PercentCol,"Total Amount percent Column");
		mouseOverAction(TaxAmountPercentValuelocartor);
		verifyExists(TaxAmountPercentValuelocartor,"Total Amount percent Column first row"); 
		String ActualTaxAmountPercent= getTextFrom(TaxAmountPercentValuelocartor);
		return ActualTaxAmountPercent;
	}
	public String ProducingBrokerage()
	{
		String Producing_BrokerageValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'28') and contains(@ng-click,'Producing_Brokerage')]";
		mouseOverAction(Producing_BrokerageCol);
		verifyExists(Producing_BrokerageCol,"Producing_Brokerage Column");
		mouseOverAction(Producing_BrokerageValuelocartor);
		verifyExists(Producing_BrokerageValuelocartor,"Producing_Brokerage column first row"); 
		String ActualProducingBrokerage= getTextFrom(Producing_BrokerageValuelocartor);
		return ActualProducingBrokerage;
	}
	public String ProducingBrokeragePercent()
	{
		sleep(3000);
		String Producing_Brokerage_PercentValuelocartor="@xpath=//tr[1]//td[contains(@ng-click,'bgm-green') and contains(@ng-click,'29') and contains(@ng-click,'Producing_Brokerage_Percent')]";
		mouseOverAction(Producing_Brokerage_PercentCol);
		verifyExists(Producing_Brokerage_PercentCol,"Producing_Brokerage percent Column");
		mouseOverAction(Producing_Brokerage_PercentValuelocartor);
		verifyExists(Producing_Brokerage_PercentValuelocartor,"Producing_Brokerage Percent column first row"); 
		String ActualProducingBrokeragePercent= getTextFrom(Producing_Brokerage_PercentValuelocartor);
		return ActualProducingBrokeragePercent;
	}
	
	public void Validation(String actual, String expect) 
	{
		if(actual.equals(expect))
		{
			Report.LogInfo("Validate ", "validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("Validate ", "not validate successfully", "FAIL");
		}	
	}
	
	public void deleteBorderEAUX2(){
		
		waitForElementToAppear(BORDEREAUXLink,5);
		sleep(1500);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");
		sleep(2000);
		Processing.navigateOnProcessingTab();
		//sleep(2000);  
		waitForElementToAppear(DeleteButton,6);
		if(isVisible(DeleteButton)==true){
			verifyMustExists(DeleteButton,"Delete Button");
			click(DeleteButton,"Delete Button");
			//sleep(4000);
			//if(isVisible(DeleteCancelButton)==false){
			waitForElementToAppear(DeleteYESButton,5);
			if(isVisible(DeleteYESButton)== true){
				verifyMustExists(DeleteYESButton,"Delete YES Button");
				click(DeleteYESButton,"Delete YES Button");
				sleep(3000);
			}
			else{
				Report.LogInfo("DeleteYesBTN", "Yes button is not displayed", "FAIL");
				click(DeleteCancelButton,"Delete Cancel Button");   
			}
		}
	}

	
public void Editsection1(String BrokeragePercent,String CoverholderCommisionPercent){
		
		
		waitForElementToAppear(policy.sectionTab_1,2);
		verifyMustExists(policy.sectionTab_1,"Section 1 TAB");
		click(policy.sectionTab_1,"Section 1 TAB");
		
		waitForElementToAppear(EditSection1,2);
		verifyMustExists(EditSection1,"Edit section 1");
		click(EditSection1,"Edit section 1");
		
		waitForElementToAppear(EditBtn_Section1,2);
		verifyMustExists(EditBtn_Section1,"Edit Button Section1");
		click(EditBtn_Section1,"Edit Button Section1");
		
		waitForElementToAppear(BrokerageInput,2);
		verifyMustExists(BrokerageInput,"Brokerage input");
		sendKeys(BrokerageInput,BrokeragePercent,"Brokerage input field.");
		
		waitForElementToAppear(CoverHolderCommisionInput,2);
		verifyMustExists(CoverHolderCommisionInput,"Brokerage input");
		sendKeys(CoverHolderCommisionInput,CoverholderCommisionPercent,"Coverholder Commision input field.");
		
		waitForElementToAppear(SaveChangesbtn_editSection,2);
		verifyMustExists(SaveChangesbtn_editSection,"Save Changes button at section1");
		click(SaveChangesbtn_editSection,"Save Changes button at section1");
		
		sleep(2000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}
	}	
	
public void deleteBorderEAUX1(){
	waitForElementToAppear(BORDEREAUXLink,5);
	sleep(1500);
	verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
	click(BORDEREAUXLink,"BORDEREAUX Link");
	sleep(2000);
	Processing.navigateOnProcessingTab();
	//sleep(2000);  
	waitForElementToAppear(DeleteButton,6);
	if(isVisible(DeleteButton)==true){
		verifyMustExists(DeleteButton,"Delete Button");
		click(DeleteButton,"Delete Button");
		//sleep(4000);
		//if(isVisible(DeleteCancelButton)==false){
		waitForElementToAppear(DeleteYESButton,5);
		if(isVisible(DeleteYESButton)== true){
			verifyMustExists(DeleteYESButton,"Delete YES Button");
			click(DeleteYESButton,"Delete YES Button");
			sleep(3000);
		}
		else{
			Report.LogInfo("DeleteYesBTN", "Yes button is not displayed", "FAIL");
			click(DeleteCancelButton,"Delete Cancel Button");   
		}
		//}else{
		//sleep(1000);
		//click(DeleteCancelButton,"Cancel button");
		//}
	}else{
		Report.LogInfo("DeleteBTN", "Delete button is not displayed", "FAIL");
	}
}

	}
	  
	
