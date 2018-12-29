package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class BordereauProcessPage extends PageBase{
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	PolicyPage policy = new PolicyPage();
	Stage1Page St1 = new Stage1Page();
	
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
	//String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
	//String UniqueReferenceVal3 = "Automation Policy1"+getCurrentDateTimeMS();
	String CompanyReferenceval = "Automation Policy1"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Broker1 = "Alwen Hough Johnson Ltd - TBC";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	String InceptionDate1 = "01/09/2017";
	String InceptionDate2 = "01/09/2018";
	public static String contractId;
	String QueName = "Test Automation_"+getCurrentDateTimeMS();
	public static String allSheetsPath = "";
	public static String firstSheetPath = "";
	public static String lastSheetPath = "";
	public static String sheet3160Path = "";
	public static String sheet3161Path = "";
	public static String sheet3165Path = "";
	public static String sheet3166Path = "";
	public static String sheet3186Path = "";
	public static String sheet3192Path = "";
	public static String sheet3193Path = "";
	public static String sheet3194Path = "";
	public static String sheet3195Path = "";
	public static String sheet3196Path = "";
	public static String sheet3197Path = "";
	public static String sheet3198Path = "";
	public static String sheet3199Path = "";
	public static String sheet3200Path = "";
	public static String sheet3201Path = "";
	public static String sheet3202Path = "";
	public static String sheet3203Path = "";
	public static String sheet3204Path = "";
	public static String sheet3207Path = "";
	public static String sheet3209Path = "";
	public static String sheet3211Path = "";
	public static String sheet3212Path = "";
	public static String sheet3213Path = "";
	public static String sheet3214Path = "";
	public static String sheet3210Path = "";
	public static String sheet3216Path = "";
	public static String sheet3244Path = "";
	public static String sheet3245Path = "";
	public static String sheet3451Path = "";
	public static String sheet3452Path = "";
	public static String sheet3452ScndPath = "";
	public static String sheet3453Path = "";
	public static String sheet3455Path = "";
	public static String sheet3456Path = "";
	public static String sheet3480Path = "";
	public static String sheet3479Path = "";
	public static String sheet3458Path = "";
	public static String sheet3463Path = "";
	public static String sheet3469Path = "";
	public static String sheet3471Path = "";
	public static String sheet3471ScndPath = "";
	public static String sheet3474Path = "";
	public static String sheet3472Path = "";
	public static String sheet3476Path = "";
	public static String sheet3475Path = "";
	public static String sheet34752Path = "";
	public static String sheet3477Path = "";
	public static String sheet34772Path = "";
	public static String sheet3373Path = "";
	public static String sheet3429Path = "";
	public static String sheet3430Path = "";
	public static String sheet3424Path = "";
	public static String sheet3425Path = "";
	public static String sheet3340Path = "";
	public static String sheet3361Path = "";
	public static String sheet3344Path = "";
	public static String sheet3349Path = "";
	public static String sheet3345Path = "";
	public static String sheet3346Path = "";
	public static String sheet3347Path = "";
	public static String sheet3348Path = "";
	public static String sheet3352Path = "";
	public static String sheet3359Path = "";
	public static String sheet3360Path = "";
	public static String sheet3441Path = "";
	public static String sheet3448Path = "";
	public static String sheet3449Path = "";
	public static String sheet3450Path = "";
	public static String sheet3500Path = "";
	public static String sheet3523Path = "";
	public static String sheet3759Path = "";
	public static String sheet3759PathFirst = "";
	public static String sheet3760Path = "";
	public static String sheet3773Path = "";
	public static String sheet3754Path = "";
	public static String sheet3755Path = "";	
	public static String sheet3714Path = "";
	public static String sheet3717Path = "";
	public static String sheet3719Path = "";
	public static String sheet3727Path = "";
	public static String sheet3728Path = "";
	public static String sheet4470Path = "";
	public static String sheet4470SecondPath = "";
	public static String sheet4472Path = "";
	public static String sheet4473Path = "";
	public static String sheet4474Path = "";
	public static String sheet4474SecondPath = "";
	public static String sheet4481Path = "";
	public static String sheet4476Path = "";
	public static String sheet4477Path = "";
	public static String sheet4478Path ="";
	public static String sheet4475Path = "";
	public static String sheet5308Path = "";
	public static String SheetPath5282 ="";
	public static String Sheet5675Path ="";
	public static String Sheet1075Path="";
	public static String Sheet1072Path="";
	public static String Result_1072_01="";
	public static String Result_1072_02="";
	public static String Result_1072_03="";
	public static String Result_1072_04="";
	public static String ExpectedResult_1075 ="";
	public static String errorPage_1072_03 = "";
	public static String errorPage_1072_04 = "";
	public static String Result_1056_01 = "";
	public static String Result_1056_02 = "";
	public static String Result_1056_03 = "";
	public static String Sheet1068Path = "";
	public static String Result_1068_01 = "";
	public static String Result_1068_02 = "";
	public static String Result_1068_03 = "";
	public static String Result_1068_04 = "";
	public static String Result_1068_05 = "";
	public static String Result_1068_06 = "";
	public static String Result_1386_01 = "";
	public static String Result_1386_02 = "";
	public static String Result_1386_03 = "";
	public static String Sheet1386Path = "";
	public static String sheet3799Path = "";
	public static String sheet4198Path = "";
	public static String sheet4199Path = "";
	
	public static String InvalidDecimaValErrorScreen="";
	public String FinalNetPrmimOrgValue;
	public String FinalNetPrmimChngVlue;
	public String FinalNetPrmimRule;
	public String FinalNetPrmimSecondOrgValue;
	public String FinalNetPrmimSecondChngVlue;
	public String FinalNetPrmimSecondRule;
	public String GrossPremiumFirstRowOrgValue;
	public String GrossPremiumFirstRowChngVlue;
	public String GrossPremiumFirstRowRule;
	public String GrossPremimumSecondRowOrgValue;
	public String GrossPremimumSecondRowChngValue;
	public String GrossPremimumSecondRowRule;
	public String ComissioncvCFirstRowOrgVlue;
	public String ComissioncvCFirstRowChngVlue;
	public String ComissioncvCFirstRowRule;
	public String ComissioncvCSecndRowOrgVlue;
	public String ComissioncvCSecndRowChngVlue;
	public String ComissioncvCSecndRowRule;
	public String NetPremiumFirstRowOrgVlue;
	public String NetPremiumFirstRowChngVlue;
	public String NetPremiumFirstRowRule;
	public String NetPremiumSecondRowOrgVlue;
	public String NetPremiumSecondRowChngVlue;
	public String NetPremiumSecondRowRule;
	public String LBrokerageFirstRowOrgVlue;
	public String LBrokerageFirstRowChngVlue;
	public String LBrokerageFirstRowRule;
	public String LBrokerageSecondRowOrgVlue;
	public String LBrokerageSecondRowChngVlue;
	public String LBrokerageSecondRowRule;
	public String RiskOrderThirdRow60OrgValue;
	public String RiskOrderThirdRow60ChngValue;
	public String RiskOrderThirdRow60Rule;
	
	
	
	
	public static final String SUploadScreen = "@xpath=/html/head/title[text()='Tide | Simplified Bordereau Upload']";
	
	public static final String ThankYouScreen = "@xpath=//h2[text()='Thank you for your submission!']";
	public static final String DaysOverdue = "@xpath=//tr[1]//td[12]";
	public static final String UploadedBy= "@xpath=//tr[1]//td[15]";
	public static final String DueDate= "@xpath=//tr[1]//td[11]";
	
	

	public static final String firstErrorROE = "@xpath=//input[@id='Data0']";
	public static final String SecondErrorROE = "@xpath=//input[@id='Data1']";
	public static final String ThirdErrorROE = "@xpath=//input[@id='Data2']";
	
	
	static String Count;
	public String	ActualOriginalValue;
	 public String	ActualChangedValue;
	 public String	ActualRuleNameValue;
	static int ActualCount;
	public String AssertBordereauStatus= null;
	//public String AssertBordereauStatusReview;
	public String AssertBordereauStatusrReviewError = null;
	public String SkippAllErroBtnScreen = null;
	public String SubProcessRcdsBtn = null;
	public String ContinueProcesingBtn = null;
	public String ActualFirstRow;
	public String ActualSecondRow;
	public String ActualFirstRowGross;
	public String ActualSecondRowGross;
	public String ActualFirstCC;
	public String ActualSecondCC;
	public String ActualThirdCC;
	public String ActualFirstRowNP;
	public String ActualSecondRowNP;
	public String ActualFirstRowLB;
	public String ActualSecondRowLB;
	public String EnrichedValueText;
	public String ActualFirstRO;
	public String ActualSecondRO;
	public String ActualThirdRO60;
	public String ActualFirstGP;
	public String ActualSecondGP;
	public String ActualThirdGP;
	public String ActualFirstRowCC;
	public String ActualSecondRowCC;
	public String ActualThirdRowCC;
	public String RiskReferenceColumnText;
	public String RF1;
	public String RF2;
	public String RF3;
	public String RF4;
	public String RF5;
	public String RF6;
	public String RF7;
	public String RF8;
	public String RF9;
	public String RF10;
	public String PremiumCurColumn;
	public String GP1;
	public String GP2;
	public String GP3;
	public String GP4;
	public String GP5;
	public String TTax1;
	public String TTax2;
	public String TTax10;
	public String TTax11;
	public String TFR1;
	public String TFR2;
	public String TFR10;
	public String TFR11;
	public String TM1;
	public String TM2;
	public String TM9;
	public String TM10;
	public String TM11;
	public String TP1;
	public String TP2;
	public String TP9;
	public String TP10;
	public String TP11;
	public String CurrencyScreen;
	public String CurrencyScreen1;
	public String NewColumnscreen;
	public String MissingColumnsscreen;
	public String EditQuestionnair;
	public String DownloadBorderButton;
	public String version1;
	public String version2;
	public String TransformationScreen;
	public String CompleteAssig;
	public String SectionAssig1;
	public String SectionAssig2;
	public String RiskAssign1;
	public String RiskAssign2;
	public String YOA1;
	public String YOA2;
	public String YOA3;
	public String YO1;
	public String YO2;
	public String YO3;
	public String REF1;
	public String REF2;
	public String REF3;
	public String REF4;
	public String REF5;
	
	public static String SettlementROEValue1="@xpath=//tr[1]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')]";
	public static String SettlementROEValue2="@xpath=//tr[2]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')]";
	public static String SettlementROEValue3="@xpath=//tr[3]//td[contains(@ng-click,'Coverholder_Settlement_Currency_RoE')]";
	
	//Default Specify locators
	public static final String ReviewLink12 = "@xpath=//*[@uib-popover='Review']//a";
	public static final String SpecifyDefaultButton = "@xpath=//button[@ng-click='specifyDefault(dataItem)']";
	public static final String DefaultValue = "@xpath=//input[@ng-model='dataItem.DefaultValue']";
	public static final String EntryValue = "@xpath=//input[@ng-model='w.Value']";
	public static final String ConditionalDefaultValue = "@xpath=//input[@ng-model='w.DefaultValue']";
	//OtherFeesDescription default specify filter
	public static final String TideFieldFilterIcon = "@xpath=//*[@data-title='Tide Field']//span";
	public static final String TideFieldSearchTextBox = "@xpath=//input[@placeholder='Search']";
	public static final String TideFieldCheckBox = "@xpath=//*[@value='Number of Stories']";
	public static final String TideFieldFilterButton = "@xpath=//button[text()='Filter']";
	public static final String NumberOfBuildingsTab = "@xpath=//th[@data-field='Location_Number_Of_Buildings']";
	public static final String NumberOfRecords = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr/td[42]";
	public static final String AddConditionalDefault = "@xpath=//button[text()=' ADD CONDITIONAL DEFAULT']";
	public static final String ColumnNameSelect = "@xpath=//td[1]//span[@class='k-input ng-scope']";
	public static final String OperatorNameSelect = "@xpath=//td[2]//span[@class='k-input ng-scope']";
	public static final String OperatorInput ="@xpath=//div[@class='k-list-container k-popup k-group k-reset']//input";
	public static final String ColumnInput ="@xpath=//div[@class='k-list-container k-popup k-group k-reset k-state-border-up']//input";
	public static final String SelectColumnInput ="@xpath=//div[@class='k-animation-container']/div/div/ul/li";
	public static final String SelectOperatorInput ="@xpath=//div[@class='k-animation-container']/div/div/ul/li";
	
	// public static final String
	// DefaultValueSaveButton="@xpath=//button[@ng-click='save()']";
	public static  String DefaultValueSaveButton = "@xpath=//button[@ng-click-single='save()']";
	public static String DefaultValueScreen = "@xpath=//h2[contains(.,'Apply Default Value for Location Number Of Buildings')]";
	public static  String DefaultValueCancelButton = "@xpath=//button[@ng-click='cancel()']";
	public static  String BorderQuestionarySaveButton = "@xpath=//button[text()='Save']";
	
	
	public static final String  input1072 ="@xpath=//input[@ng-model='sheet.HeaderIndex']";
	public static final String MissingColumns = "@xpath=//*[@id='content']//h2[contains(.,'One or more header columns not identified')]";
	//Locators for apply filter on policies
	public static final String PolicyLink = "@xpath=//a[text()='POLICIES']";
	public static final String PolicyReferenceFilterIcon = "@css=thead[role=rowgroup] th:nth-child(1) span";
	
	public static final String PolicyReferenceFilterIcon_Simplified = "@css=thead[role=rowgroup] th:nth-child(3) span";
	public static final String SearchText = "@xpath=//form[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']//input[@placeholder='Search']";
	public static final String DatePick = "@xpath=//input";
	
	public static final String SearchTextBDType = "@xpath=//input[@placeholder='Search']";
	public static final String FilterButton = "@css=.k-button.k-primary";
	public static final String ApprovedTab ="@xpath=//a[text()='Approved']";
	//Open Selected policy
	public static final String SelectedPolicy = "@css=tbody[role='rowgroup'] td:nth-child(1)";

	public static final String DraftBtn = "@buttonText=Draft";

	//Step 4 claim
		public static String  CoreDetails="@xpath=//*[@id='stepsBar']/li[4]/a";
	// Step 13 risk Review
		public static final String ReviewStep13 = "@xpath=//*[@id='stepsBar']/li[13]/a";
	// Submit Borderaux
	//public static final String BORDEREAUXLink = "@xpath=.//*[@ng-if='IsBinder && IsBordereauTabDisplay']";
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
	public static final String BlankDetailsMsg = "@xpath=//*[@kendo-grid='form.grid']//td[text()='No result returned']";
	
	public static final String BlankDetailsMsgRiskTab = "@xpath=//*[@id='grid']//td[text()='No result returned']";
	public static final String ProcessAgainstSelectedPeriodBtn ="@xpath=//button[contains(.,'process against selected period')]";
	public static final String ProcessBordereauPage = "@css=.card-body.p-30.m-b-30";
	public static final String ProcessAsAdditionalBtn ="@xpath=//*[@id='content']//button[@ng-click='UpdateBordereauxStatus()']";
	public static final String ProcessAsCorrectionBtn ="@xpath=//*[@id='content']//button[@ng-click='CorrectionBordereaux()']";
	public static final String InvalidFinancialErrorScreen ="@xpath=//h2[contains(.,'Invalid financial value translation required')]";
	public static final String discardedRowCount = "@xpath=//span[contains(.,'of 3 items')]";


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
	public static final String RiskRefrance = "@xpath=//div[@class='k-grid-content k-auto-scrollable'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='3']";
	//public static final String RiskRefranceA2 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String RiskRefranceA2 = "@xpath=//div[@class='k-grid-content k-auto-scrollable'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	
	public static final String RiskRefranceA1 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='1']";
	
	public static final String RiskRefrance2 = "@xpath=//td[@title='RiskReference_Mapped'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String Version1 = "@xpath=//div[@class='k-grid-content k-auto-scrollable']//following-sibling::td[1][text()='2']";
	public static final String Version2 = "@xpath=//div[@class='k-grid-content k-auto-scrollable']//following-sibling::td[1][text()='2']";
	public static final String  RuleConditionExists = "@xpath=//dl/dd[contains(.,'if the rule conditions are met')]";
	public static final String ActualCountPolicyRefrence = "@css=.k-selectable .ng-scope td:nth-child(13)";
	public static final String RiskTabAfterReview ="@xpath=//*[@id='grid']//preceding::td//button[contains(text(),'Review')]//following::td[contains(text(),'Risk')][1]";

	//To Verify Counts on Summary screen
	public static final String KeyDetailsErrorCount	 ="@css=.k-master-row.ng-scope>td:nth-child(4)";
	
	//Delete created BorderEAUX
	public static final String DeleteButton = "@css=.c-red.glyphicon.glyphicon-trash";
	public static final String DeleteYESButton = "@xpath=//button[@ng-click='onYes()']";
	public static final String DeleteCancelButton = "@xpath=//button[@ng-click='onNo()']";
	public static final String PolicyHome = "@css=a[href='#!/app/contractlist']";
	
	//Reject Bordereau
	public static final String Deletebtn_RejectBordereau= "@xpath=//button[@ng-click='rejectBordereau()']";
	public static final String Cancelbtn_RejectBordereau= "@xpath=//div[@class='sweet-alert ']/p/button[@ng-click='cancel()']";

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
	
	public static final String RiskDataGrid = "@xpath=//td[text()='Risk']";
	public static final String RiskAndPremiumDataGrid = "@xpath=//td[text()='Risk And Premium']";
	public static final String ClaimsDataGrid = "@xpath=//td[text()='Claim']";
	
	public static final String cancelAndDeleteProBtn1 = "@xpath=//div[@ng-click='cancel(data.BordereauxId)']";
	public static final String ReviewBtn ="@xpath=//button[text()='Review']";
	public static final String ApprvedBtn ="@xpath=//button[text()='Approved']";
	public static final String SuRcdAssmnt ="@xpath=//*[@id='content']//button[@ng-click='submitBordereau()']";
	public static final String FrApprovalbtn ="@xpath=//*[@id='grid']//button[@ng-click='GoToBordereauSummaryScreen(dataItem, false)']";
	public static final String FrApprovalbtn1 ="@xpath=//button[text()='For Approval']";
	public static final String PartialSubmission ="@xpath=//a[2][contains(.,'Partial Submission')]//following::td[contains(.,'Yes')]";
	public static final String Rejectbtn ="@xpath=//button[contains(.,'Reject')]";
	
	//luna processing locatiors
	public static final String BordereauSummary ="@xpath=//h2[text()='Bordereau Summary']";
	public static final String CreateNewQuestionnaire ="@xpath=//div[@ng-click='AddNewBordereauFormat(false)']";
	public static final String Step2 ="@xpath=//*[@id='stepsBar']//span[text()='Bordereau Type']";
	
	//Loactors for SubmitBordereauxFIrstSheet
	public static final String BorderEAUXFirst ="@css=[href='#!/app/contract/253fe192-ba5e-4586-b3d2-c13dbf40e802/bordereaux/2']";
	public static final String BorderEAUXLast ="@css=[href='#!/app/contract/7807ee46-ba51-445d-b5fa-69d71dc08856/bordereaux/2']";
	public static final String CalenderLastST ="@css=.k-icon.k-i-calendar";
	public static final String CalenderFirstST ="@css=.k-icon.k-i-calendar";
	
	public static final String DataTabLink ="@xpath=//tr/td[4][contains(.,'Risk')]";
	
	public static final String ReviewError ="@xpath=//*[@id='grid']//button[contains(.,'Review Errors')]";
	public static final String ForAssigmnentButton ="@xpath=//*[@id='grid']//button[contains(.,'For Assignment')]";
	public static final String ErrorScreen ="@css=.f-400.c-red.normalWhiteSpace.ng-binding.ng-scope";
	public static final String ErrorScreen1 ="@xpath=//h2[contains(.,'Transaction Type')]";
	public static final String ErrorScreen5 ="@xpath=//h2[contains(.,'Another bordereau of the same period is not yet approved')]";
	public static final String ErrorScreen3 ="@xpath=//h2[contains(.,'Previous bordereau not Approved')]";
	
	public static final String ErrorScreen8 ="@xpath=//h2[contains(.,'Bordereau period prior to contract inception')]";
	public static final String RefreshAfterUpload1="@xpath=//*[@options='mainGridOptions']//*[@title='Refresh']//span";
	public static final String ContinueProc ="@xpath=.//*[@ng-click='processBordereau()']";
	public static final String ContinueProc1 ="@xpath=//button[@ng-click='ContinueProcessing()']";
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
	public static final String pausebtn ="@xpath=//*[@ng-click='Pause()']";
	public static final String pausebtn1 ="@xpath=//button[@ng-click='cancel()']";
	public static final String ErrorScreenNillBor2 ="@xpath=//h2[@class='font-bold lead borderauSubtitle ng-scope']";
	public static final String NillBorYesBtn ="@xpath=//input[@value='true']";
	public static final String ContinueProcBtn = "@xpath=//button[contains(.,'Continue Processing bordereau')]";
	public static final String YesCancelProcessing ="@xpath=//p[@class='ng-scope']//button[@ng-click='onYes()']";
	public static final String ContinueProcessingBodrBtn ="@xpath=//*[@id='content']//button[@ng-click='UpdateSequence()']";
	public static final String ContinueProcessing= "@xpath = //*[@id='multiReference_Id']//button[@type='submit']";
	//Locators:-TC-3245
	
	public static final String Errorscreen2= "@xpath=//h2[contains(.,'Cannot Identify Contract in Tide based on Risk Inception Date')]";
	public static final String Errorscreen= "@xpath=//h2[contains(.,'Cannot identify Contract in Tide based on Year of Account')]";
	
	public static final String continuebtx= "@xpath=//button[@ng-click='save()']|//button[@ng-click='continue()']";
	public static final String continuebtx2= "@xpath=//*[@id='RID_Id']//button[@type='submit']";
	public static final String DateTextBox0= "@css=#Data0";
	public static final String DateTextBox1= "@css=#Data1";
	public static final String DateTextBox2= "@css=#Data2";

	//One or more error pop up
	public static final String Pausebtn1 ="@xpath=//button[contains(.,'Pause')]";
	public static final String OneMoreError ="@xpath=//h2[contains(text(),'One or more ')]";
	public static final String CancelProcessingBtn ="@xpath=//button[contains(.,'CANCEL PROCESSING AND DELETE BORDEREAU')]";
	public static final String ContinueProcessingBtn ="@xpath=//button[contains(.,'Process Bordereau')]";
	public static final String DuplicateColumn ="@xpath=//h2[contains(text(),'Duplicate header columns identified')]";
	public static final String SheetNameRadioBtx ="@css=[name='form.bordereauxIdentifySheet'] .row dl:nth-child(4) dt label";
	public static final String sheetdropdown ="@css=.k-input.ng-scope";

	//public static final String April2017 ="@css=.k-list.k-reset li:nth-child(2)";
	public static final String April2017 ="@xpath=//*[@class='k-item ng-scope'][2]";
	public static final String tidevaluedropdown ="@css=.k-widget.k-dropdown.k-header.m-b.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty";
	public static final String PremiumCurrencyRef ="@xpath=//*[@id='content']//h2[contains(.,'Premium Currency reference data translation required')]";
	public static final String RiskCurrencyRef ="@xpath=//*[@id='content']//h2[contains(.,'Risk Currency reference data translation required')]";
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
	public static final String ErrorScreenMsg1 ="@xpath=//h2[contains(.,'Duplicate header columns identified')]";
	
	public static final String ErrorScreenMsg ="@xpath=//h2[contains(.,'Header columns')]";
	public static final String ErrorScreenMsg2 ="@xpath=//h2[contains(.,'Header row')]";
	
	
	
	public static final String ErrorScreenMsg3 ="@xpath=//h2[contains(.,'Header row(s) not identified')]";
	
	
	public static final String ContractStatusMsg ="@css=.col-sm-7 .font-bold.lead";
	//public static final String YesCancelProcessing ="@css=.confirm.btn.btn-lg.btn-danger.waves-effect.waves-light[ng-click='onYes()']";

	public static final String continuebtn= "@xpath=//*[@ng-focus='Focused = true']";
	public static final String ForApprovalBtn = "@xpath=//button[contains(.,'For Approval')]";
	public static final String ForAssignmentBtn = "@xpath=//button[contains(.,'For Assignment')]";

	// Locators for checkRecordsAndDeleteRecord
	public static final String filterIconRecords = "@css=[data-field='StatusString'] span";
	public static final String filterIconRecords_Month = "@css=[data-field='MonthString'] span";
	public static final String filterIconRecords_DueDate = "@css=[data-field='DueDate'] span";
	public static final String filterIconRecords_DaysOverdue = "@css=[data-field='DaysOverdueCal'] span";
	public static final String filterIconRecords_UploadedBy = "@css=[data-field='UploadedByString'] span";
	public static final String filterIconRecords_ProcessedBy = "@css=[data-field='ProcessedByString'] span";
	public static final String filterIconRecords_ApprovedByString = "@css=[data-field='ApprovedByString'] span";
	
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
	public static final String FilterButtonRecords1 = "@xpath=//div[4]//button[text()='Filter']";
	public static final String FilterButtonRecords2 = "@xpath=//div[5]//button[text()='Filter']";
	public static final String BodrFilterBtn ="@xpath=//input[@value='Risk']//following::button[@type='submit']";
	public static final String TotalRowCountAfterFiltered = "@css=tbody[role='rowgroup'] tr";
	public static final String CancelBtn ="@xpath=//*[@class='sweet-alert ']//p//button[contains(.,'Cancel')][1]";
	public static final String UnApprvBdrBtn ="@xpath=.//*[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";

	//Locators for Due date filter
	public static final String DuteDatefilterIcon = "@css=[data-title='Due Date'] .k-icon.k-i-filter";
	public static final String DuteDatefilterIconInputBox = "@css=.k-textbox.k-space-right>input";
	public static final String DueDateFiterBtn = "@css=.k-button.k-primary";
	public static final String DueDateCheckbx = "@xpath=//input[@name='DueDate']";

	//Skip All Error button click
	public static final String SkippAllErroBtn2 = "@xpath=//button[@ng-click='skipAllErrros()']";
	public static final String SkippAllErroBtn = "@xpath=//*[@id='multiReference_Id']//button[@ng-click='skipAllErrros()']";
	public static final String SubProcessRcdBtn = "@xpath=//*[@id='content']//button[@ng-click='submitBordereau()']";
	public static final String SubAssesmntBtn = "@xpath=//*[@id='grid']//button[@ng-click='GoToSRAssignment(dataItem, false)']";
	public static final String ApproveBordBtn = "@xpath=//*[@id='content']//button[@ng-click='approveUnApproveBordereau(bordereauxData.Id)']";
	public static final String SkippAllErroBtn1 = "@xpath=//button[@ng-click='SkipAllErrros()']";
	public static final String Cancelbtn1 ="@xpath=//*[@ng-click='cancel()']";
	
	//Finantial calculations
	public static final String DATAClaimTab="@xpath=//*[text()='Claim']";
	public static final String DATAPremiumTab="@xpath=//*[text()='Premium']";
	public static final String CorrectedVal = "@id=Data0";
	public static final String CorrectedVal1 = "@id=Data1";
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
	public static final String RiskReferenceTxt = "@xpath=//*[@id='content']/div/div/div[1]/div[3]/div[1]/table/thead/tr/th[1]";
	public static final String CellTxt = "@xpath=//*[@id='content']/div/div/div[1]/div[3]/div[1]/table/thead/tr/th[2]";
	public static final String ORIGINALVALUETxt = "@xpath=//*[@id='content']/div/div/div[1]/div[3]/div[1]/table/thead/tr/th[3]";
	public static final String Enrichedvaluetxt = "@xpath=//*[@id='content']/div/div/div[1]/div[3]/div[1]/table/thead/tr/th[4]";
	
	//TC 3430 Sprint 3
	public static final String EnrichedValueTxt = "@id=Data0";
	public static final String CanBtn = "@xpath=//*[@id='content']//button[@ng-click='cancel()']";
	public static final String RiskOrderFirstRow80 = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr[1]/td[25]";
	public static final String RiskOrderSecondRow100 = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr[2]/td[25]";
	public static final String RiskOrderThirdRow60 = "@xpath=//*[@id='grid']/div[3]/table/tbody/tr[3]/td[25]";
	public String OrgnlValueRule = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[3]";
	public String ChngdValueRule = "@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[4]";
	  
	public String RiskOrdeThrdRow60PrctOrgVlue;
	public String RiskOrdeThrdRow60PrctChngVlue;
	public String RiskOrdeThrdRow60PrctRule;
	
	
	public static final String GrossPremFirstRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2]";
	public static final String GrossPremSecondRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2]";
	public static final String GrossPremThirdRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2]";

	public static final String CCFirstRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1]";
	public static final String CCSecondRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1]";
	public static final String CCThirdRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][1]";

    public static final String RevertToUploaded ="@xpath=//button[@ng-click= 'RevertToUploaded()']";
    public static final String CancelAndDeleteBord ="@xpath=//button[contains(.,' CANCEL PROCESSING AND DELETE BORDEREAU ')]";
	public static final String NPFirstRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1]";
	public static final String NPSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][1]";
	public static final String NPThirdRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][1]";

	public static final String FNPFirstRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][2][text()='-2,371.31']";
	//public static final String FNPSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][2][text()='-4,054.60']";
	public static final String FNPSecondRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][2][text()='-4,054.60']";
	public static final String FNPThirdRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][2][text()='-50,473.50']";

	//Loactors TC_3448

	public static final String CancelStatusAndLeaveUploadingStatusButton = "@xpath=//button[@ng-click='BordereauxRevert()']";
	public static final String pauseButton = "@xpath=//button[@ng-click='pause()']";
	
	
	
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
	public static final String tidevalueEUR ="@xpath=//*[@id='Data0-list']//li[text()='EUR - Euro']";
	public static final String tidevalueUSD1 ="@xpath=//*[@id='Data0_listbox']//li[text()='USD - United States Dollar']";
	public static final String RiskRefrance3 = "@xpath=//div[@class='k-grid-content k-auto-scrollable'][1]//a[@ng-click='openRiskReference(dataItem)'][text()='3']";
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

	public static final String VerifyErrorpage ="@xpath=//h2[text()='Location Sprinklers (Y/N) reference data translation required']";
	public static final String SkipAllErrorsBtn="@xpath=//*[@ng-click='skipAllErrros()']";
	public static final String SkipAllErrorsBtn3="@xpath=//*[@ng-click='SkipAllErrros()']";
	public static final String SkipAllErrorsBtn2="@xpath=//*[@ng-click='SkipAllErrros()']";
	public static final String CancelProcessingButton="@xpath=//*[@ng-click='cancel(data.BordereauxId)']";
	public static final String PauseButton="@xpath=//*[@ng-click='pause()']";
	public static final String ViewDiscardedRecordsIcon="@xpath=//label[text()='View Discarded Records']/../label[2]";
	public static final String BlankRecordsMsg = "@xpath=//*[@kendo-grid='form.grid']//td[text()='No result returned']";

	public static final String CancelAndDeleteButton="@xpath=//button[contains(.,'Cancel Processing And Delete Bordereau')]";
	public static final String CancelAndDeleteButtonC="@xpath=//button[contains(.,'Yes, cancel processing!')]";
	
	public static final String BooleanName="@xpath=//*[@ng-bind='dataItem.Name']";
	public static final String ReferenceDataFilterIcon ="@xpath=//a[text()='Data']//preceding-sibling::a";
	public static final String DatasetFilter ="@xpath=//a[contains(.,'Dataset')]//preceding-sibling::a";

	public static final String NewColumnIdentifided ="@xpath=//*[@id='content']/div/ui-view/div/div/div[2]/div";
	public static final String Pausebtn ="@xpath=//button[contains(.,'Pause')]";
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
	public static final String InvalidDecimalValue = "@xpath=//*[text()='Invalid decimal value translation required']";
	public static final String YesBtn = "@xpath=//*[@value='true']/parent::label";
	public static final String MultiContractBtn = "@xpath=//*[@ng-if='!Loading1 && contractList.length']//button";
	public static final String Contract2017 = "@xpath=//*[@ng-click='GetSelectedContract(w)']/a[contains(.,'2017')]";
	public static final String UMRWrdVerify = "@xpath=//*[text()='UMR ']";
	public static final String UMRMultiValue = "@xpath=//*[@ng-if='errorPageHeaderData.UniqueReference.length <= 50']";
	
	public static final String SelectDropDownforContract = "@xpath=//span[@class='caret']";
	public static final String  SelectContract = "@xpath=//a[contains(.,'(01/01/2018)')]";

	public static final String SectionIdDropDwn1Risk1 = "@xpath=//tr[1]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk2= "@xpath=//tr[2]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk3 = "@xpath=//tr[3]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk4 = "@xpath=//tr[4]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwn1Risk5 = "@xpath=//tr[5]//select[@ng-model='data.SectionRiskCodeId']//preceding-sibling::span";
	public static final String SectionIdDropDwnOption3 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'D8')]";
	public static final String BordereauAssignmentSectionDropDwnOptionRiskCode = "@xpath=//li[text()='Data in the bordereau will specify the Risk Code']";
	
	 public static final String SectionAssignmentRuleScreenFor2017 ="@xpath=//h2[text()='Section Assignment Rule - 2017 Year of Account Contract (01/01/2017 - 31/12/2017)']";
	 public static final String SectionAssignmentRuleScreenFor2018 ="@xpath=//h2[text()='Section Assignment Rule - 2018 Year of Account Contract (01/01/2018 - 31/12/2018)']";
	 public static final String RiskCodeRuleScreen2017 ="@xpath=//h2[text()='Risk Code Assignment Rule - 2017 Year of Account Contract (01/01/2017 - 31/12/2017)']";		
	 public static final String RiskCodeRuleScreen2018 ="@xpath=//h2[text()='Risk Code Assignment Rule - 2018 Year of Account Contract (01/01/2018 - 31/12/2018)']";		 
	 public static final String  SectionIdDropDwn1="@xpath=//tr[1]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn2="@xpath=//tr[2]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn3="@xpath=//tr[3]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn4="@xpath=//tr[4]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String  SectionIdDropDwn5="@xpath=//tr[5]//select[@ng-model='data.SectionId']//preceding-sibling::span";
	  public static final String SectionIdDropDwnOption1 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 1 (Primary Risk Code: 1T)')]";
	  public static final String SectionIdDropDwnOption2 = "@xpath=//ul[@aria-hidden='false']//li[contains(.,'Section 2 (Primary Risk Code: 1T)')]";
	  public static final String ErrorScreenRiskInception ="@xpath=//h2[contains(.,'nvalid Risk Inception Date values identified')]";
	  
	  public static final String Error_Count = "@xpath=//div[@class='count']//following-sibling::small[contains(.,'Error')]//following-sibling::h2";
	  public static final String Warning_Count = "@xpath=//div[@class='count']//following-sibling::small[contains(.,'Warning')]//following-sibling::h2";
	  public static final String PassedRecords_Count = "@xpath=//div[@class='count']//following-sibling::small[contains(.,'Passed')]//following-sibling::h2";
	  public static final String TotalRecords_Count = "@xpath=//div[@class='count']//following-sibling::small[contains(.,'Total Records')]//following-sibling::h2";
	  public static final String NewRenewalRecords_Count = "@xpath=//div[@class='count']//following-sibling::small[contains(.,'New / Renewals')]//following-sibling::h2";
	  public static final String EndorsementsRecords_Count = "@xpath=//div[@class='count']//following-sibling::small[contains(.,'Endorsements')]//following-sibling::h2";
	  public static final String CancellationRecords_Count ="@xpath=//div[@class='count']//following-sibling::small[contains(.,'Cancellations')]//following-sibling::h2";
	  
	  
	  public static final String ViewErrorRecordsToggle ="@xpath=//span[@class='m-l-10 ng-scope']//following-sibling::label[contains(.,'View Error Records')]//following-sibling::label[@class='ts-helper']";
	  public static final String ViewDiscardedRecordsToggle ="@xpath=//span[@class='m-l-10 ng-scope']//following-sibling::label[contains(.,'View Discarded Records')]//following-sibling::label[@class='ts-helper']";
	  public static final String RevertToUpload ="@xpath=//button[@ng-click='RevertToUploaded()']";
	  public static final String SelectQDrpDown ="@xpath=//div[@class='form-group staticHeight']/div/div/span/span/span[2]";
	  public static final String ProcessBordereauBtn ="@xpath=//button[@id='processBordereau']";
	  public static final String NewQProcessBtn ="@xpath=//button[text()=' ANSWER NEW QUESTIONNAIRE AND PROCESS BORDEREAU ']";
	  public static final String UploadedBtn ="@xpath=//button[text()='Uploaded']";
	  //Summary screen 4 Tab
	  public static final String KeyDetailsTAB ="@xpath=//a[text()='Key Details']";
	  public static final String ErrorsAndWarningTAB ="@xpath=//a[text()='Errors & Warnings']";
	  public static final String BordereauStatisticsTAB ="@xpath=//a[text()='Bordereau Statistics']";
	  public static final String NotesTAB ="@xpath=//a[text()='Notes']";
	  public static final String DiscardRecords1 ="@xpath=//tr[1]//td[5]/button[contains(.,'Discard Records')]";
	  public static final String DiscardRecords2 ="@xpath=//tr[2]//td[5]/button[contains(.,'Discard Records')]";
		
	  public static final String RestoredRecords1 ="@xpath=//tr[1]//td[5]/button[contains(.,'Restore')]";
	  public static final String DiscardedRecords2 ="@xpath=//tr[2]//td[4]/label[contains(.,'Discarded')]";
	
	  public static final String ResolceError3 ="@xpath=//tr[3]//td[4]/button[contains(.,' Resolve Errors')]";
	  public static final String RDCOriginalValue ="@xpath=//td[3][contains(.,'-')]";
	  public static final String ChangedValueFromRDC ="@xpath=//td[3][contains(.,'-')]";
	  public static final String RuleNameFromRDC ="@xpath=//td[3][contains(.,'-')]";
	  public static final String Okbtn1="@xpath=//*[@ng-click='cancel()']";
			
	//Simplified Upload
	  public static final String SelectContract_Simplified="@xpath=//div/label[contains(.,'Select the type of bordereau you are submitting')]//preceding::div//span[@aria-label='select']";
	
	 
		
	  public static final String ResolveError_ErrorsAndWarningTAB ="@xpath=//button[@class='btn btn-danger ng-scope'][contains(.,'Resolve Errors')]";
	
	  public static final String ErrorCountProcessingTAB ="@xpath=//tr/td[10]/button";
	  public static final String WarningCountProcessingTAB ="@xpath=//tr/td[11]/button";
	 
	public void allSheets_3145() throws Exception{
		String subSheet = "SP - All Sheet(s) (Automation Schema)";
	    String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			allSheetsPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_AllSheet_3145.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(allSheetsPath);
		
		
		String Ufname = "S74718420180501.xlsx";	
		int size = 23409;
		String BordreauID = "6edc1e3e-a195-4b0d-9419-1f061d9c057c";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(20);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			deleteBorderEAUX();
			
		}
	}

	public void ForApprovalToReview()
	{
		waitForElementToAppear(FrApprovalbtn1,5);
		verifyMustExists(FrApprovalbtn1,"For Approval button");
		click(FrApprovalbtn1,"For Approval button");
		
		waitForElementToAppear(Rejectbtn,5);
		verifyMustExists(Rejectbtn,"Reject button");
		click(Rejectbtn,"Reject button");
		
		waitForElementToAppear(Deletebtn_RejectBordereau,5);
		if(isVisible(Deletebtn_RejectBordereau)== true){
			verifyMustExists(Deletebtn_RejectBordereau,"Delete YES Button");
			click(Deletebtn_RejectBordereau,"Delete YES Button");
			sleep(3000);
		}
		else{
			Report.LogInfo("DeleteYesBTN", "Yes button is not displayed", "FAIL");
			click(Cancelbtn_RejectBordereau,"Delete Cancel Button");   
		}
		
		
		 
	}
	
	public void FirstSheet_3149() throws Exception{
		String subSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			firstSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_FirstSheet_3149.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		File excelFile = new File(firstSheetPath);
	
		String Ufname = "S10252720180501.xlsx";	
		int size = 24654;
		String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void LastSheet_3150() throws Exception{
		String subSheet = "SP - Last Sheet (Automation Schema)";
	    String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			lastSheetPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_LastSheet_3150.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(lastSheetPath);
		String Ufname = "S58607320180501.xlsx";	
		int size = 24415;
		String BordreauID = "3044d8e2-5d69-4988-92d9-781fc570ea50";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed.", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void onlySheet_3160() throws Exception{
		
		String subSheet = "Automation-SP - The only sheet that contains specific text";
		
		
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		if(isVisible(BQPage.sheetsContainTxt)==true){
			waitForElementToAppear(BQPage.sheetsContainTxt,2);
			verifyMustExists(BQPage.sheetsContainTxt,"Questionnaire Name Textbox");
		}
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
	    String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
	    String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3160Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3160.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3160Path);
		
	
		String Ufname = "S22605220180909.xlsx";	
		int size = 23399;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void sheetIdentification_3161() throws Exception{
	
		String subSheet = "SP - The only sheet that contains specific text (Automation Schema)";
		String EditingText = "May 2017";
		String ValMsg = "This format expects to find a single sheet containing 'June'. This Bordereau contains no sheets that contain this text.";
		String ExpectedSHNameError = "This format expects to find a single sheet containing ‘June’. This sheet contains no sheets that contain this text.";
		ExpValMsg = ValMsg;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3165Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_SheetSpecificTextUnchanged_3165.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3165Path);
		
	
		String Ufname = "S30941720180501.xlsx";	
		int size = 23416;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
        
		
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
			if(isVisible(ErrorScreen)== true){
				
				bordereauxProcessing(ValMsg, ExpectedSHNameError);
				EditSpecificText(EditingText);
				refreshUploadedFile();
				
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ReviewStatusCheck", "Review status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}
public String ExpValMsg;
	public void processingSelectingSheetUnchanged_3165() throws Exception{
	
		String subSheet = "Automation-SP - The only sheet that contains specific text";
		 ExpValMsg = "This format expects to find a single sheet containing 'June'. This Bordereau contains no sheets that contain this text.";
		String SheetYear = "May 2017";
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
        String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

	
		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3165Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_SheetSpecificTextUnchanged_3165.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3165Path);
		
		
		String Ufname = "S30941720180501.xlsx";	
		int size = 23416;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				bordereauxProcessRemainUnchanged(ExpValMsg, SheetYear);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ReviewStatusCheck", "Review status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void cancelBordereauProcess_3166() throws Exception{
	
		String subSheet ="Automation-SP - The only sheet that contains specific text";
		ExpValMsg = "This format expects to find a single sheet containing 'June'. This Bordereau contains no sheets that contain this text.";

		
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		if(isVisible(BQPage.sheetsContainTxt)==true){
			waitForElementToAppear(BQPage.sheetsContainTxt,2);
			verifyMustExists(BQPage.sheetsContainTxt,"Questionnaire Name Textbox");
		
		}
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3166Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_SheetSpecificTextUnchanged_3165.xlsx";
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		File excelFile = new File(sheet3166Path);
		
		
		String Ufname = "S30941720180501.xlsx";	
		int size = 23416;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
  		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				cancelAndDeleteBoredereauByCatchingValidation(ExpValMsg);
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}
	public String ExpectedSHNameError1;
	
	public void multiplesheetProcessing_3186() throws Exception{
		
		
		String subSheet = "Automation-SP - The only sheet that contains specific text";
		String EditingTextMultiSheet ="June";
		                       
		 ExpectedSHNameError1 = "This format expects to find a single sheet containing 'May'. This Bordereau contains two or more sheets that contain this text.";
		String ExpectedSHNameError = " This format expects to find a single sheet containing 'June'. This sheet contains no sheets that contain this text.";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		if(isVisible(BQPage.sheetsContainTxt)==true){
			waitForElementToAppear(BQPage.sheetsContainTxt,2);
			verifyMustExists(BQPage.sheetsContainTxt,"Questionnaire Name Textbox");
			sendKeys(BQPage.sheetsContainTxt,"May");
		}
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		Report.LogInfo("ValidateReviewErrorStatus", BQPage.FormatId, "PASS");
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3186Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_MultipleSheets_3186.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        File excelFile = new File(sheet3186Path);
		String Ufname = "S47442920180501.xlsx";	
		int size = 24329;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				bordereauxProcessing(ExpectedSHNameError1, ExpectedSHNameError);	
				EditSpecificText(EditingTextMultiSheet);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ReviewStatusCheck", "Review status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}

	}

	public void multiplesheet_3192() throws Exception{
		
		String subSheet = "Automation-SP - The only sheet that contains specific text";
		String errorMsg="This format expects to find a single sheet containing 'May 2017'. This Bordereau contains two or more sheets that contain this text.";
		ExpValMsg = errorMsg;
		String BordFilter = "Automation-SP - The only sheet that contains specific text";
		String EditYear = "May";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		if(isVisible(BQPage.sheetsContainTxt)==true){
			waitForElementToAppear(BQPage.sheetsContainTxt,2);
			verifyMustExists(BQPage.sheetsContainTxt,"Questionnaire Name Textbox");
		}
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3192Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_3192.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		File excelFile = new File(sheet3192Path);
		
		
		String Ufname = "S13573020180501.xlsx";	
		int size = 24308;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(errorMsg);
				selectSheetRadioAndVerifyErrorMessage(errorMsg);
				monthselection();
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ButtonCheck", "Review button not displayed.", "FAIL");
				}
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}		
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");		
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void multiplesheetCancelProcessing_3193() throws Exception{
		String BordereauxValue ="SP - The only sheet that contains specific text (Automation Schema)";
		String errorMsg="This format expects to find a single sheet containing 'May 2017'. This Bordereau contains two or more sheets that contain this text.";
		ExpValMsg = errorMsg;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(BordereauxValue);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3193Path = fpath+"\\src\\test\\resources\\testdata\\January_2017_3192.xlsx";
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3193Path);			
		String Ufname = "S13573020180501.xlsx";	
		int size = 24308;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
        
		refreshUploadedFile();

		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(errorMsg);
				verifyMustExists(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
				click(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
				sleep(4000);	
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}		
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");	
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}

	}

	/*------- TC-ID:- 3194 ----------------- */
	public void verifyOnlySheetThatEqualsSpecificText_3194() throws Exception{
		
		String subSheet = "Automation-SP - The only sheet that equals specific text";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		
		if(isVisible(BQPage.sheetsContainTxt)==true){
			waitForElementToAppear(BQPage.sheetsContainTxt,2);
			verifyMustExists(BQPage.sheetsContainTxt,"Questionnaire Name Textbox");
			sendKeys(BQPage.sheetsContainTxt,"April 2017");
		}
		BQPage.nextStapeClick();
	
		BQPage.FormatId = ReturnFormatID();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3194Path = fpath+"\\src\\test\\resources\\testdata\\OnlySheetWithequalText_3194.xlsx";
		} 
		catch (IOException e) 
		{
						e.printStackTrace();
		}
		
		File excelFile = new File(sheet3194Path);
		String Ufname = "S45664720180627.xlsx";	
		int size = 24857;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
	
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			VerificationCounts(5);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");				
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	/*------- TC-ID:- 3195 ----------------- */
	public void verifySpecificTextAndObserveReviewBtn_3195() throws Exception{
		
		String subSheet = "SP - The only sheet that equals specific text (Automation Schema)";
		String year = "April 2016";
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3195Path = fpath+"\\src\\test\\resources\\testdata\\onlysheetWithequalText2_3196.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3195Path);
		
		
		String Ufname = "S36506320180909.xlsx";	
		int size = 24586;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				
				EditSpecificText(year);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					Report.LogInfo("CheckReviewStatus", "Review Status button displayed.", "PASS");
				}else{
					Report.LogInfo("CheckReviewStatus", "Review Status button not displayed.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3196 ----------------- */
	public void verifySpecificTextAndObserveDataRecord_3196() throws Exception{
		
		String subSheet = "Automation-SP - The only sheet that equals specific text";
		
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		if(isVisible(BQPage.sheetsContainTxt)==true){
			waitForElementToAppear(BQPage.sheetsContainTxt,2);
			verifyMustExists(BQPage.sheetsContainTxt,"Questionnaire Name Textbox");
		}
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		
		
	
		String YearSel = "March 2017";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3196Path = fpath+"\\src\\test\\resources\\testdata\\onlysheetWithequalText2_3195.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3196Path);
		//UploadFile(allSheets);

		File excelFile = new File(sheet3196Path);
		
		
		String Ufname = "S34704720180909.xlsx";	
		int size = 25186;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				selectSheetForProcessingRadioAndDate(YearSel);
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					VerificationCounts(5);
					Report.LogInfo("CheckReviewStatus", "Review Status button displayed successfully.", "PASS");								
				}else{
					Report.LogInfo("CheckReviewStatus", "Review Status button not displayed.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3197 ----------------- */
	public void cancelProcessing_3197() throws Exception{
		
		String subSheet = "SP - The only sheet that equals specific text (Automation Schema)";
		String expectedErrorMsg = "This format expects to find a single sheet which is named 'April 2016'. This Bordereau contains no sheets with this name.";
		ExpValMsg= expectedErrorMsg;
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3197Path = fpath+"\\src\\test\\resources\\testdata\\onlysheetWithequalText2_3195.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3197Path);
		
		
		String Ufname = "S54928620180627.xlsx";	
		int size = 25188;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
      
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(expectedErrorMsg);
				verifyandClickCancelAndDeleteProButton();
				sleep(2000);
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}		
	}

	/*------- TC-ID:- 3198 ----------------- */
	public void containsSpecificTextMatchRecords_3198() throws Exception{
		
		String subSheet = "Automation--SP - Any sheets that contains specific text";
		String BordFilter = "Automation--SP - Any sheets that contains specific text";
		String EditYear = "2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//Precondition so used TC 3610
		BQPage.editBordereauFormat(BordFilter, EditYear);
		BQPage.FormatId = ReturnFormatID();
		sleep(4000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3198Path = fpath+"\\src\\test\\resources\\testdata\\Anysheetwithspecifictext2_3198.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File excelFile = new File(sheet3198Path);
		
	
		String Ufname = "S18096620180910.xlsx";	
		int size = 24495;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			VerificationCounts(20);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	/*------- TC-ID:- 3199----------------- */
	public void editContainsSpecificText_3199() throws Exception{
		
		String subSheet = "SP - Any sheets that contains specific text (Automation Schema)";
		String year = "2016";
		String BordFilter = "Automation--SP - Any sheets that contains specific text";
		String EditYear = "2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		//loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3199Path = fpath+"\\src\\test\\resources\\testdata\\Anysheetwithspecifictext2_3199.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3199Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3199Path);
		String Ufname = "S17640320180502.xlsx";	
		int size = 23414;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				EditSpecificText(year);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					Report.LogInfo("CheckReviewStatus", "Review Status displayed successfully after editing year.", "PASS");
					VerificationCounts(20);
				}else{
					Report.LogInfo("CheckReviewStatus", "Review Status not displayed after editing year.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
				//Precondition so used TC 3609
				BQPage.editBordereauFormat(BordFilter, EditYear);
				BQPage.FormatId = ReturnFormatID();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();	
				//Precondition so used TC 3609
				BQPage.editBordereauFormat(BordFilter, EditYear);
				BQPage.FormatId = ReturnFormatID();
			}
		}else{
			Report.LogInfo("ReviewErrorStatus", "There are no review errors after initial upload.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
			//Precondition so used TC 3609
			BQPage.editBordereauFormat(BordFilter, EditYear);
			BQPage.FormatId = ReturnFormatID();
		}	
	}

	/*------- TC-ID:- 3200----------------- */
	public void verifyContainsSpecificTextAndObserveDataRecord_3200() throws Exception{
		
		String subSheet = "SP - Any sheets that contains specific text (Automation Schema)";
		String YearSel = "March 2016";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		///loginPage.tideLogin();
		applyFilterPolicy(policy.PolicyNumber);
		
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3200Path = fpath+"\\src\\test\\resources\\testdata\\Anysheetwithspecifictext2_3200.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3200Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3200Path);
		
		String Ufname = "S47565220180502.xlsx";	
		int size = 24048;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
       
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				selectSheetForProcessingRadioAndDate(YearSel);
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true)
				{
					VerificationCounts(5);
					Report.LogInfo("CheckReviewBTN", "Review button display successfully.", "PASS");								
				}else{
					Report.LogInfo("CheckReviewBTN", "Review button not display successfully.", "FAIL");
				}
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3201 ----------------- */
	public void cancelProcessing_3201() throws Exception{
		
		String subSheet = "SP - Any sheets that contains specific text (Automation Schema)";
		String expectedErrorMsg = "This format expects to find a one or many sheets containing '2017'. This Bordereau contains no sheets that contain this text.";
		ExpValMsg = expectedErrorMsg;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3201Path =  fpath+"\\src\\test\\resources\\testdata\\Anysheetwithspecifictext2_3199.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(sheet3201Path);
		//UploadFile(allSheets);
		File excelFile = new File(sheet3201Path);	
		
		String Ufname = "S17640320180502.xlsx";	
		int size = 23414;
		String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
	
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(expectedErrorMsg);
				verifyandClickCancelAndDeleteProButton();
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	/*------- TC-ID:- 3202 ----------------- */
	public void OnlySpecifiedSheet_3202() throws Exception{
		
		String subSheet = "Automation--SP - Only Specified Sheet(s)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
	//	policy.PolicyNumber = "720168BA";

	//	contractId = "d1c25db5-cf28-46ea-8061-70dbae709539";
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3202Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3202.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3202Path);
		
		String Ufname = "S18660120180627.xlsx";	
		int size = 23500;
		String BordreauID = "c5198a16-e108-4e94-af44-98caed175060";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("CheckReviewBTN", "Review button display successfully.", "PASS");								
			VerificationCounts(10);
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}else{
			Report.LogInfo("CheckReviewBTN", "Review button not display successfully.", "FAIL");								
			deleteBorderEAUX();
		}
	}

	/*------- TC-ID:- 3203 ----------------- */
	public void OnlySpecifiedSheetCanNotBeIdentified_3203() throws Exception{
		
		
		String subSheet = "SP - Only Specified Sheet(s) (Automation Schema)";
		String ExpectedErrorMsg = "This format expects to find sheets which are named 'March 2017,April 2017'. This Bordereau contains no sheets with this name.";
		ExpValMsg = ExpectedErrorMsg;
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3203Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3203.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3203Path);		
		
		String Ufname = "S11099520180502.xlsx";	
		int size = 24305;
		String BordreauID = "c5198a16-e108-4e94-af44-98caed175060";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
        
		
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyErrormessage(ExpectedErrorMsg);
				monthSelection();
				verifyandClickProcessBorderEAuButton();
				refreshUploadedFile();
				if(isVisible(ReviewError)== true){
					//VerificationCounts(5);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("CheckReviewBTN", "Review button not display successfully.", "FAIL");								
					deleteBorderEAUX();
				}
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		}else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	/*------- TC-ID:- 3204 ----------------- */
	public void OnlySpecifiedSheetCancelProcessing_3204() throws Exception{
		String OnlySpPoliCyNum = "640522OY";
		String subSheet = "SP - Only Specified Sheet(s) (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3204Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3203.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3204Path);			
		String Ufname = "S11099520180502.xlsx";	
		int size = 24305;
		String BordreauID = "c5198a16-e108-4e94-af44-98caed175060";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
       
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			if(isVisible(ErrorScreen)== true){
				verifyandClickCancelAndDeleteProButton();
				sleep(2000);
				//VerifyNotificationPopupAfterUpload();
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();			
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	//==================================================BordereauProcessIdentifyHeaderTests=======================================================

	/*------- TC-ID:- 3207 ----------------- */
	public void verifyNormalAndExpectedHeader_3207() throws Exception{
		policy.CreateContractwithInceptionDate2018();
		String subSheet = "Bordereau Processing (kruthika test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	
	
		SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3207Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_3207.xlsx";
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		File excelFile = new File(sheet3207Path);	
	    contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S56648520180431.xlsx";	
		int size = 18422;
		String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewError) == true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed instead of Review only.", "FAIL");
			deleteBorderEAUX();
		}else if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			verificationCountsAfterReviewButton(10);
		deleteBorderEAUX();
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status displayed not displayed and bordereaux processing.", "FAIL");
		}
	}

	/*------- TC-ID:- 3213 ----------------- */
	public String DublicatecolumnErrorMessage;
	public void identifyDuplicateColumn_3213() throws Exception
	{
		String NewColumnFieldDDOption ="Bordereau Processing (kruthika test schema)";
    String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
        
		applyFilterPolicy(policy.PolicyNumber);
		
		openSelectedPolicy();
		SubmitBordereaux(NewColumnFieldDDOption);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3213Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_Duplicate_Column.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3213Path);	
		String Ufname = "S19597920180431.xlsx";	
		int size = 18478;
		String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			if(isVisible(DuplicateColumn)==true){
				verifyExists(DuplicateColumn,"Error Screen");
				DublicatecolumnErrorMessage = getTextFrom(DuplicateColumn,"Duplicate header columns identified");

				verifyMustExists(Pausebtn1,"Cancel Processing Button");
				click(Pausebtn1,"Cancel Processing Button");
				sleep(3000);
			}else{
				Report.LogInfo("ErroScreenCheck", "Expected error not displayed.", "FAIL");
				goBack();
				
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateStatus", "Review error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		
	}

	/*------- TC-ID:- 3214 ----------------- */
	public void changeColumnPosition_3214() throws Exception
	{
		
		String NewColumnFieldDDOption ="Bordereau Processing (kruthika test schema)";
		
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_Change_Column_Possition.xlsx\",\"UniqueFileName\":\"S25941320180431.xlsx\",\"BordereauFormatId\":\"49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S25941320180431.xlsx\",\"Filesize\":18918,\"Path\":null,\"size\":18918,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		
		openSelectedPolicy();
		SubmitBordereaux(NewColumnFieldDDOption);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3214Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_Change_Column_Possition.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3214Path);		
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		checkReviewButton(ReviewBtn);
		verificationCountsAfterReviewButton(10);
		deleteBorderEAUX();
		//VerifyNotificationPopupAfterUpload();
	}
	public String ExpectedErrorMsg="Header row(s) not identified";
	public String ExpectedErrorMsg4 ="Header row(s) not identified";
	
	public void removeHeaderRow() throws Exception
	{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();		
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3344Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3344.xlsx";
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		File excelFile = new File(sheet3344Path);  
		
	
		
		String Ufname = "S58719120180431.xlsx";	
		int size = 23336;
		String BordreauID = "6edc1e3e-a195-4b0d-9419-1f061d9c057c";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			
			verifyNoHeaderErrorScreen2(ExpectedErrorMsg4);
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		
	}
	
	public void removeHeaderFromAllSheets() throws Exception
	{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3349Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3349.xlsx";
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		File excelFile = new File(sheet3349Path);  
		
	
		
		String Ufname = "S68880020180431.xlsx";	
		int size = 22850;
		String BordreauID = "6edc1e3e-a195-4b0d-9419-1f061d9c057c";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyNoHeaderErrorScreen1(ExpectedErrorMsg4);

		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	public void wrongHeaderRowNumberOneSheet() throws Exception
	{

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
        String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3345Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3345.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3345Path);  
		
	

		String Ufname = "S53691120180431.xlsx";	
		int size = 17608;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
	refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			deleteBorderEAUX();
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
			deleteBorderEAUX();
			sleep(3000);
		}
		sleep(3000);
	}

	public void wrongHeaderRowNumberAllSheet() throws Exception
	{
	
		applyFilterPolicy(policy.PolicyNumber);
	    openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3346Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3346.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3346Path);  
		

		String Ufname = "S30855320180431.xlsx";	
		int size = 19658;
		String BordreauID = "6edc1e3e-a195-4b0d-9419-1f061d9c057c";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			deleteBorderEAUX();

		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
			deleteBorderEAUX();	
		}
		sleep(3000);
	}

	public void changeColumnPosition() throws Exception
	{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		
	
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3347Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3347.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3347Path);  
		
		
		String Ufname = "S75929620180501.xlsx";	
		int size = 22863;
		String BordreauID = "6edc1e3e-a195-4b0d-9419-1f061d9c057c";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifySequenceRuleErrorScreen(ExpectedErrorMsg);
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}
	public String ExpectedErrorMsg2="Duplicate header columns identified";
	
	public void duplicateColumnAllSheet() throws Exception
	{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3352Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3352.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3352Path); 
		
		
		
		String Ufname = "S40568320180926.xlsx";	
		int size = 23620;
		String BordreauID = "6edc1e3e-a195-4b0d-9419-1f061d9c057c";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
        
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen1(ExpectedErrorMsg2);
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}

	

	public void allHeaderMissing() throws Exception
	{
		String ExpectedErrorMsg="One or more (but not all) of the expected fields by this bordereau questionnaire were not found in this bordereau.";
		applyFilterPolicy("380703UT");
		openSelectedPolicy();
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");
		String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3360.xlsx\",\"UniqueFileName\":\"S79574620171010.xlsx\",\"BordereauFormatId\":\"7b7d342f-a02c-4c18-8336-11b2606b2499\",\"FolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S79574620171010.xlsx\",\"Filesize\":24172,\"Path\":null,\"size\":24172,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3360Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3360.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3360Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet3360Path);  
		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			verifyErrorScreen(ExpectedErrorMsg);	
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}




	//==========================================================BordereauProcessOtherTests======================================================================

	public void addInvalidInceptionDataFiled_3210() throws Exception
	{
		policy.CreateContractwithInceptionDate2018();
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		ExpectedErrorMsg = "Invalid Risk Inception Date values identified";
		applyFilterPolicy(policy.PolicyNumber);

		openSelectedPolicy();
		SubmitBordereaux("SP - First Sheet (Automation Schema)");

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3210Path = fpath+"\\src\\test\\resources\\testdata\\DatraClensingJanuary_3210.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File excelFile = new File(sheet3210Path); 
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		
		String Ufname = "S89198120180519.xlsx";	
		int size = 16968;
		String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);
			verifyErrorScreen11();
			if(isVisible(datefield)==true){
				sleep(2000);
				verifyMustExists(datefield,"Date Field");
				verifyvalidDateAndBackground();
				refreshUploadedFile();
				sleep(2000);
						if(isVisible(ReviewBtn)== true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
							deleteBorderEAUX();
						}
				}
			}

		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			
		}
		
	}

	public void invalidTransactionTypeError_3216() throws Exception
	{	
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux("SP - First Sheet (Automation Schema)");

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3216Path = fpath+"\\src\\test\\resources\\testdata\\TransactionType_3216.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			File excelFile = new File(sheet3216Path);  
			String Ufname = "S84525020180519.xlsx";	
			int size = 16955;
			String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				
				if(isVisible(ErrorScreen1)== true){
					verifyMustExists(tidevaluedropdown,"Tide Value drop down");
					verifyBackground(tidevaluedropdown,"rgba(156, 0, 6, 1)");
					sleep(2000);
					verifyMustExists(pausebtn1,"Pause button");
					click(pausebtn1,"Pause button");
					sleep(2000);
					if(isVisible(ReviewError)== true){
						AssertBordereauStatusReviewError = getTextFrom(ReviewError);
						Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
						deleteBorderEAUX();
					}
					//VerifyNotificationPopupAfterUpload();
				}else{
					Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
					goBack();
					deleteBorderEAUX();				
				}
			}
			else
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");			
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void yoaError_3244() throws Exception
	{	
       String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3244Path = fpath+"\\src\\test\\resources\\testdata\\YOAError_3244.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			File excelFile = new File(sheet3244Path);  
			
			String Ufname = "S59184720180519.xlsx";	
			int size = 16853;
			String BordreauID = "49a5b6e6-8cfe-43d4-bd3f-377160a0c0b4";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			
			refreshUploadedFile();
			processBordereauAccounterror();
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}

	}

	public void contractPeriodIdentification_3245() throws Exception
	{
		String subSheet = "SP - First Sheet (Automation Schema)";
		String RequireDate = "02/01/2018";
		String ExpectedColor = "rgba(0, 97, 0, 1)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux(subSheet);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3245Path = fpath+"\\src\\test\\resources\\testdata\\ContractPeriodOutside_3245.xlsx";
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
			File excelFile = new File(sheet3245Path); 
			String Ufname = "S21548420180520.xlsx";	
			int size = 17576;
			String BordreauID = "27766dd9-9600-4ef0-850a-a523fc9a8684";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				
				if(isVisible(Errorscreen)==true){
					verifyMustExists(continuebtx,"Continue Button");
					click(continuebtx,"Continue Button");
					sleep(2000);
					verifyMustExists(Errorscreen2,"Continue Button");
					passDate(RequireDate);
					verifyBackground(DateTextBox0,ExpectedColor);
					verifyBackground(DateTextBox1,ExpectedColor);
					verifyBackground(DateTextBox2,ExpectedColor);
					sleep(2000);
					click(continuebtx2,"Continue Button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						sleep(3000);
						
						//VerifyNotificationPopupAfterUpload();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ErroScreen", "Expected error not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				
				//VerifyNotificationPopupAfterUpload();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}
	public void missingFutureSequentiallyNilBordereaux_3452() throws Exception
	{
		String MonthDate = "April 2017";
		String DueDate = "30/05/2017";
		String Valuedate = "30/05/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

	policy.CreateContractwithInceptionDate2018();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3452Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_TC_3613.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3452Path); 
       contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S66718220180604.xlsx";	
		int size = 112254;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        refreshUploadedFile();

        if(isVisible(ReviewBtn)==true){
			click(ReviewBtn,"Reviwe button");
			waitForElementToAppear(SuRcdAssmnt,10);
			verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
			click(SuRcdAssmnt,"Submit record assesment button");
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			clickOnApproveBordBtn();

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3452ScndPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_CancelProcessing_3452.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet3452ScndPath);
			String Ufname2 = "S24499820180604.xlsx";	
			int size2 = 26031;
	        String response2 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname2);
	        String ID1 = extractIDFromResponseinsideContract(response2); 
	        String payload2 = GeneratePayloadForContract(contractId, BordreauID, ID1, Ufname2, size2, 4 , "1", 2018);
	        addAsDraft(payload2,DraftUrl);
			
			
			
			
			refreshUploadedFile();
			sleep(2000);
			AssertBordereauStatusReviewError = getTextFrom(ReviewError);
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
				if(isVisible(ErrorScreen)== true){
					ErrorScreenText = getTextFrom(ErrorScreen);
				SelectPauseButton();
				} else {
					Report.LogInfo("ValidateReviewErrorStatus", "Error screen not displayed not displayed.", "FAIL");
				}
				deleteBorderEAUX();
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				goBack();
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
		}
	}

	public void missingFutureSequentiallyNilBordereaux_3451() throws Exception
	{
	
		String MonthDate = "April 2017";
		String DueDate = "30/05/2017";
		String Valuedate = "30/05/2017";
		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String NoRadioBtn = "2";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3451Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_CancelProcessing_3452.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3451Path);  

			String Ufname = "S24499820180604.xlsx";	
			int size = 22626;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 4 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				sleep(1000);
                        String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
						String YesBtn = "@xpath=.//*[@value='true']";
							ErrorScreenText = getTextFrom(ErrorScreen);
						
						javaScriptclick(YesBtn,"Yes button");
						verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing button");
						PauseBtnText = getTextFrom(ContinueProcessingBodrBtn);
						javaScriptclick(ContinueProcessingBodrBtn,"Continue Processing button");
						sleep(3000);
						refreshUploadedFile();
						if(isVisible(ReviewBtn)==true){
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
							//ApplyDueDateFilter(DueDate, Valuedate);
							deleteBorderEAUX();
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							ApplyDueDateFilter(DueDate, Valuedate);
							deleteBorderEAUX();
						}
						Report.LogInfo("StepCheck", "Steps 4,5 completed", "PASS");
				
			}else{
				
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	//============================================ Bordereau processed Already approved ====================================== 	

	public void AlreadyApprovedCancelProcessing_3453() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "January 2017";
		String DueDate = "Blanks";
		String Valuedate = "null";
		String NoRadioBtn = "1";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3453Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_CancelProcessing_3452.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3453Path);  
			String Ufname = "S24499820180604.xlsx";	
			int size = 26031;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
				ErrorScreenText = getTextFrom(ErrorScreen);
				SelectPauseButton(); 
				AssertBordereauStatusReviewError = getTextFrom(ReviewError);
				deleteBorderEAUX();
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}}else{
				Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
				policy.changeStatusToSigned();
			}
	}
public String ProcessAgainstSelectedPeriodBtnTet;
	public void AlreadyApprovedIncorrectPeriod_3455() throws Exception
	{
		String MonthDate = "January 2017";
		String DueDate = "02/03/2017";
		String Valuedate = "02/03/2017";
		String IncorrectPerDate = "February 2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3455Path =fpath+"\\src\\test\\resources\\testdata\\January 2017_CancelProcessing_3452.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3455Path);  
			String Ufname = "S24499820180604.xlsx";	
			int size = 26031;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				if(isVisible(ProcessBordereauPage)==true){
					String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
					ErrorScreenText = getTextFrom(ErrorScreen);
					CalDateSelection(IncorrectPerDate);
					verifyMustExists(ProcessBordereauPage,"Process Against Selected Period Button");
					click(ProcessBordereauPage,"Process Against Selected Period Button");
					verifyMustExists(ProcessAgainstSelectedPeriodBtn,"Process Against Selected Period Button");
					ProcessAgainstSelectedPeriodBtnTet = getTextFrom(ProcessAgainstSelectedPeriodBtn);
					click(ProcessAgainstSelectedPeriodBtn,"Process Against Selected Period Button");		
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
				}			
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}
public String ProcessAsAdditionalBtntext;
	public void AlreadyApprovedAdditionalBordereaux_3456() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "January 2017";
		String DueDate = "02/03/2017";
		String Valuedate = "02/03/2017";
	    String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3456Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_CancelProcessing_3452.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3456Path);  
		
			String Ufname = "S24499820180604.xlsx";	
			int size = 26031;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				if(isVisible(ProcessAsAdditionalBtn)==true){
					String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
					ErrorScreenText = getTextFrom(ErrorScreen);
					waitForElementToAppear(ProcessAsAdditionalBtn,5);
					verifyMustExists(ProcessAsAdditionalBtn,"Process Against Selected Period Button");
					ProcessAsAdditionalBtntext = getTextFrom(ProcessAsAdditionalBtn);
					click(ProcessAsAdditionalBtn,"Process Against Selected Period Button");
					
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}
public String ProcessAsCorrectionBtntext;
	public void CorrectionBordereau_3458() throws Exception
	{
		String OnlySpPoliCyNum = "356394GI";
		String MonthDate = "January 2017";
		String DueDate = "02/03/2017";
		String Valuedate = "02/03/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			DeleteError();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3458Path =  fpath+"\\src\\test\\resources\\testdata\\January 2017_CancelProcessing_3452.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			File excelFile = new File(sheet3455Path);  
			String Ufname = "S24499820180604.xlsx";	
			int size = 26031;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
				ErrorScreenText = getTextFrom(ErrorScreen);
				if(isVisible(ProcessAsCorrectionBtn)==true){
					
					waitForElementToAppear(ProcessAsCorrectionBtn,5);
					verifyMustExists(ProcessAsCorrectionBtn,"Process Against Selected Period Button");
					ProcessAsCorrectionBtntext = getTextFrom(ProcessAsCorrectionBtn);
					click(ProcessAsCorrectionBtn,"Process Against Selected Period Button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "PASS");
						ApplyDueDateFilter(DueDate, Valuedate);
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ErrorScrenCheck", "Expected error screen not displayed.", "FAIL");
					goBack();
					ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void MissingBordereauPeriod_3463() throws Exception
	{
		BProcessingRiskPremiumClaimPage BPProcessng = new BProcessingRiskPremiumClaimPage();

		String IncDate = "01/01/2017";
		String InceptionDate = "01/01/2018";
		String InceptionDateExp = "31/12/2018";
		String InceptionDateExp1 = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String MonthDate = "January 2018";
		String NoRadioBtn = "2";
		String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
		String subSheet = "SP - First Sheet (Automation Schema)";
		//String payload = "{\"Bordereaux\":{\"ContractId\":\"4937eb53-88f5-4e75-8b4a-c80b5845d353\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"PolicyId\":\"0\",\"OriginalFileName\":\"January 2017_TC_3463.xlsx\",\"UniqueFileName\":\"S56695420171010.xlsx\",\"BordereauFormatId\":\"f3d9edd1-9335-4e0c-bc14-b7dcc6f3771f\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56695420171010.xlsx\",\"Filesize\":24610,\"Path\":null,\"size\":24610,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate, InceptionDateExp1);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	
		policy.changeStatusToSigned();	
		BPProcessng.openPolicyCreateContract();	
		policy.addPolicyContractDetails1(UniqueReferenceVal2, InceptionDate, InceptionDateExp, policy.Broker2, policy.Bline2, policy.Underline2);
		verifyExists(DraftBtn,"Draft Status Button");
		policy.changeStatusToSigned();
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3463Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3463.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3463Path);

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S44388720180604.xlsx";	
		int size = 23675;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods for the 2017 Year of Account Contract (01/01/2017 - 31/12/2017)']";
			ErrorScreenText = getTextFrom(ErrorScreen);
			
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);
			//VerifyNotificationPopupAfterUpload();
			SelectPauseButton();
			AssertBordereauStatusReviewError = getTextFrom(ReviewError);
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
	}

	public void MissingBordereauPeriodContinueNillBordereau_3469() throws Exception
	{
		String OnlySpPoliCyNum = "412478QC";
		String MonthDate = "January 2018";
		String YesRadioBtn = "1";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String fpath = new File(".").getCanonicalPath();
		sheet3469Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3469.xlsx";
		File excelFile = new File(sheet3463Path);
		
		String Ufname = "S41253820171027.xlsx";	
		int size = 24610;
		String BordreauID = "c691dc97-46d0-4b0f-8dd2-cc143c764386";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
	
		refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods for the 2017 Year of Account Contract (01/01/2017 - 31/12/2017)']";
				ErrorScreenText = getTextFrom(ErrorScreen);
				
				SelectYesNoAndContinueProcessing(YesRadioBtn);
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					AssertBordereauStatusReview = getTextFrom(ReviewBtn);
					Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
					//ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
					//ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		
	}

	public void ErrorRemainingCancelProcessing_3471() throws Exception
	{
		String MonthDate = "February 2017";
		String DueDate = "30/03/2017";
		String Valuedate = "30/03/2017";
		String NoRadioBtn = "2";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
      policy.CreateContractwithInceptionDate2018();
		
        String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		SubmitBordereauxWithYesnoButtons(MonthDate);
		DeleteError();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3471Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3471.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3471Path); 

		contractId = addNewBordereauFormatPolicy(payload1, GetData);	
		String Ufname = "S47841820180604.xlsx";	
		int size = 22576;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewError)==true){
			click(ReviewError,"Review button");
			waitForElementToAppear(VerifyErrorpage,10);
			verifyMustExists(VerifyErrorpage,"Verify Error page");
			waitForElementToAppear(SkipAllErrorsBtn2,10);
			verifyMustExists(SkipAllErrorsBtn2,"Skip All Error");
			click(SkipAllErrorsBtn2,"Skip All Error");
			sleep(1000);
			waitForElementToAppear(SuRcdAssmnt,10);
			verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
			click(SuRcdAssmnt,"Submit record assesment button");
			waitForElementToAppear(FrApprovalbtn,10);
			verifyMustExists(FrApprovalbtn,"For Approval button");
			click(FrApprovalbtn,"For Approval button");
			clickOnApproveBordBtn();
			refreshUploadedFileApprovedStatus();
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3471ScndPath = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3471.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			File excelFile1 = new File(sheet3471ScndPath);
	        String response2 = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID2 = extractIDFromResponseinsideContract(response2); 
	        String payload2 = GeneratePayloadForContract(contractId, BordreauID, ID2, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload2,DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				String ErrorScreen = "@xpath=.//h2[text()='Another bordereau of the same period has errors remaining']";
				ErrorScreenText = getTextFrom(ErrorScreen);
				SelectCancelAndDelete();
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
		}
	}


	public void ErrorRemainingCancelProcessing_3472() throws Exception
	{
		String OnlySpPoliCyNum = "434779QW";
		String MonthDate = "January 2017";
		String DueDate = "Blanks";
		String Valuedate = "null";
		String NoRadioBtn = "2";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons(MonthDate);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3472Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3471.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File excelFile = new File(sheet3472Path);  
			
			String Ufname = "S47841820180604.xlsx";	
			int size = 22576;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 2 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)== true)
			{
				String ErrorScreen = "@xpath=.//h2[text()='Previous bordereau has errors remaining']";
				ErrorScreenText = getTextFrom(ErrorScreen);
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				SelectCancelAndDelete();
			
				
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				ApplyDueDateFilter(DueDate, Valuedate);
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}

	public void DatePresentationCannotIdentified_4475() throws Exception
	{

		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//TC 3532
		BQPage.addBordereauFormatClaim1();
		String SubSheet = BQPage.ClaimBordereauText;
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn, 5);
		verifyMustExists(BQPage.EditBtn, "Edit button");
		click(BQPage.EditBtn, "Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		//applyFilterPolicy("142006MC");
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.navigationOnBordereauxTab();
		SubmitBordereaux(SubSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4475Path = fpath+"\\src\\test\\resources\\testdata\\Jan-All sheets_TC4475.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet4475Path);  
		//contractId = addNewBordereauFormatPolicy(payload1, GetData);

		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan-All sheets_TC4475.xlsx\",\"UniqueFileName\":\"S41399620180120.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S41399620180120.xlsx\",\"Filesize\":14102,\"Path\":null,\"size\":14102,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(ReviewBtn,"Review button");
			openDATALink();
			navigateToDATAClaimTab();
			//Verify Inception date format
			String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";
			String RiskInceptionDate1="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2017']";
			waitForElementToAppear(RiskInceptionDatecolumn,20);
			mouseOverAction(RiskInceptionDatecolumn);
			verifyMustExists(RiskInceptionDatecolumn,"Risk Inception Date column");
			sleep(2000);
			verifyExists(RiskInceptionDate1,"Inception Date is displayed in MM-DD-YYYY format");
		}
		else{

			Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
			deleteBorderEAUX();
		}
	}

	public void ErrorRemainingContinueProcessing_3475() throws Exception
	{			
		String NewColumnFieldDDOption = "Automation Risk format 11(Lloyd's Property Schema)";
	
		String MonthDate = "January 2018";
		String DateMonth = "February 2018";
		String YesRadioBtn = "1";
		String DueDate = "30/11/2018";
		String Valuedate = "30/11/2018";
		String InceptionDate="01/01/2018";
		String InceptionDateExp="31/12/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String QueName = "Automation Risk format 11";
		policy.CreateContractwithInceptionDate2018();
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		SubmitBordereaux(NewColumnFieldDDOption);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3475Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_3475.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File excelFile = new File(sheet3475Path);

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S39891820180927.xlsx";
		int size = 24234;		
		String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response);        
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
     
        addAsDraft(payload,DraftUrl);
       
        
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3475.xlsx\",\"UniqueFileName\":\"S56688420180431.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S56688420180431.xlsx\",\"Filesize\":24236,\"Path\":null,\"size\":24236,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_Second_TC3475.xlsx\",\"UniqueFileName\":\"S66272320180431.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S66272320180431.xlsx\",\"Filesize\":22400,\"Path\":null,\"size\":22400,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(SkippAllErroBtn)== true && isEnable(SkippAllErroBtn)==true){
				clickOnSkipAllErrorBTN();
				clickOnSubProcessRcdBtn();
				//clickOnSubAssesmntBtn();
				sleep(5000);
				waitForElementToAppear(FrApprovalbtn,10);
				verifyMustExists(FrApprovalbtn,"For Approval button");
				click(FrApprovalbtn,"For Approval button");
				clickOnApproveBordBtn();
				refreshUploadedFileApprovedStatus();
				SubmitBordereauxWithYesnoButtons(DateMonth);

				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet34752Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_Second_TC3475.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
				//UploadFile(IdentificationSheet);
				File excelFile1 = new File(sheet34752Path); 
				String Ufname2 = "S41572620180927.xlsx";	
				int size2 = 22398;
				String BordreauID1= "0402b2e4-591d-4179-b539-fbed0dbefca2";
				 String response2 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname2);
				 String ID2 = extractIDFromResponseinsideContract(response2); 
				 String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID2, Ufname2, size2, 2 , "1", 2018);
				 addAsDraft(payload2,DraftUrl);
				//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
				refreshUploadedFile();
				if(checkErrorReviewButton(ReviewError)== true)
				{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(2000);
					if(isVisible(CancelAndDeleteBordereauxSp2)==true){
						SelectYesNoAndContinueProcessing(YesRadioBtn);
						refreshUploadedFile();
						if(isVisible(ReviewBtn)==true){
							Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
							openDATALink();
							navigateToDATARiskTab();
							//OnViewDiscardedRecordsIcon();
							verifyExists(RowNumber,"Row Number column");
							sleep(2000);
							List<WebElement> RowCount = webDriver.findElements(By.xpath("//*[@data-field='RowNumber']//following::tr"));

							if((RowCount.size())== 8){
								Report.LogInfo("ValidationReviewStatus", "Record count is 8", "Pass");	
								sleep(1000);
							}
							else{
								Report.LogInfo("ValidationReviewStatus", "Record count is not 8", "FAIL");
							}
							verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
							click(BORDEREAUXLink,"BORDEREAUX Link");
							sleep(3000);
							navigateOnProcessingTab();
							if(isVisible(ReviewBtn)==true) {
								AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
								Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
						        deleteBorderEAUX(); 
					}else
						{
							Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "PASS");	
						}
							//deleteBorderEAUX();
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							ApplyDueDateFilter(DueDate, Valuedate);

							deleteBorderEAUX();
						}
					}else{
						Report.LogInfo("ErrorScreenCheck", "Expected error screen not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
					ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed or button is not clickable.", "FAIL");
			}
		}
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	public void SamebordorErrorRemainingContinueProcessing_3477() throws Exception
	{
		String NewColumnFieldDDOption = "Automation Risk format 11 (Lloyd's Property Schema)";
		String UniqueReferenceVal3 = "Automation Policy"+policy.PolicyNumber;	
		String QueName = "Automation Risk format 11";
		String MonthDate = "January 2018";
		String DateMonth = "February 2018";
		String YesRadioBtn = "1";
		String DueDate = "30/10/2018";
		String Valuedate = "null";
		String InceptionDate="01/01/2018";
		String InceptionDateExp="31/12/2018";
		String QueName1 = "Automation Risk format 11";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		policy.CreateContractwithInceptionDate2018();	
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		SubmitBordereaux(NewColumnFieldDDOption);
		//CalDateSelection(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3477Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_3477.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//brit
		File excelFile = new File(sheet3477Path); 

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S38214120180431.xlsx";	
		int size = 24126;
		String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3477.xlsx\",\"UniqueFileName\":\"S38214120180431.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S38214120180431.xlsx\",\"Filesize\":24126,\"Path\":null,\"size\":24126,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";		
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(SkippAllErroBtn)== true && isEnable(SkippAllErroBtn)==true){
				clickOnSkipAllErrorBTN();
				clickOnSubProcessRcdBtn();
				//clickOnSubAssesmntBtn();
				sleep(5000);
				waitForElementToAppear(FrApprovalbtn,10);
				verifyMustExists(FrApprovalbtn,"For Approval button");
				click(FrApprovalbtn,"For Approval button");
				clickOnApproveBordBtn();
				refreshUploadedFileApprovedStatus();
				SubmitBordereauxWithYesnoButtons(DateMonth);

				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet34772Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_Second_TC3477.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
				//UploadFile(IdentificationSheet);
				File excelFile1 = new File(sheet34772Path);  
				
				String Ufname1 = "S18720320180431.xlsx";	
				int size1 = 22354;
		        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
		        String ID1 = extractIDFromResponseinsideContract(response1); 
		        String payload2 = GeneratePayloadForContract(contractId, BordreauID, ID1, Ufname1, size1, 1 , "1", 2018);
		        addAsDraft(payload2,DraftUrl);
		        
		        
				//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_Second_TC3477.xlsx\",\"UniqueFileName\":\"S18720320180431.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S18720320180431.xlsx\",\"Filesize\":22354,\"Path\":null,\"size\":22354,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
				refreshUploadedFile();
				if(checkErrorReviewButton(ReviewError)== true)
				{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(2000);
					SelectYesNoAndContinueProcessing(YesRadioBtn);
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
						//ApplyDueDateFilter(DueDate, Valuedate);
						openDATALink();
						navigateToDATARiskTab();
						//	OnViewDiscardedRecordsIcon();
						waitForElementToAppear(BlankRecordsMsg,5);
						if (isVisible(BlankRecordsMsg)==true)
						{
							Report.LogInfo("DataValidation", "No records found", "Fail");
						}
						else{
							Report.LogInfo("DataValidation", "Data displayed successfully.", "PASS");
						}
						verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
						click(BORDEREAUXLink,"BORDEREAUX Link");
						sleep(3000);
						navigateOnProcessingTab();
						if(isVisible(ReviewBtn)==true) {
							AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
							Report.LogInfo("ValidationReviewStatus", AssertBordereauStatusReview, "PASS");	
					        deleteBorderEAUX(); 
				}else
					{
						Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "PASS");	
					}
						//deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
						//ApplyDueDateFilter(DueDate, Valuedate);
						//deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
					//ApplyDueDateFilter(DueDate, Valuedate);
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed or button is not clickable", "FAIL");
			}
		}
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}		
	}

	public void contractStatusCheck_3523() throws Exception
	{
		String ExpectedContractStatus="Contract Status not Signed";
		
		String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String IncepDate2 = "01/01/2017";
		String ExpDate="31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.CreateContractwithInceptionDate2018();
		String OpenPolicy = "@xpath=//*[@id='FolderListGrid']//tr//td[contains(.,'"+policy.PolicyNumber+"')]";

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		sleep(2000);
		verifyExists(policy.PolicyEditDot,"Edit Policy");
		click(policy.PolicyEditDot,"Edit Policy");

		verifyExists(AddContractForPolicy,"Edit Policy");
		click(AddContractForPolicy,"Edit Policy");

		verifyExists(policy.Policytitle,"Verify Policy Title");	
		policy.addPolicyContractDetails1(UniqueReferenceVal2, IncepDate2, ExpDate,policy.Broker2, policy.Bline2, policy.Underline2);
		verifyExists(DraftBtn,"Draft Status Button");
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		
		SubmitBordereaux("SP - All Sheet(s) (Automation Schema)");

		//String payload = "{\"Bordereaux\":{\"ContractId\":\"cd9cf514-81ee-4727-ac3c-60392e0bbe94\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"PolicyId\":\"0\",\"OriginalFileName\":\"ContractStatusCheck_TC_3523.xlsx\",\"UniqueFileName\":\"S98008620171014.xlsx\",\"BordereauFormatId\":\"360bbefa-2ed6-47cb-bbf5-9791c078764a\",\"IsPolicyRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S98008620171014.xlsx\",\"Filesize\":19610,\"Path\":null,\"size\":19610,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauPolicy\":[]}";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";


		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3523Path = fpath+"\\src\\test\\resources\\testdata\\ContractStatusCheck_TC_3523.xlsx";
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		File excelFile = new File(sheet3523Path);  

		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S45523720180912.xlsx";	
		int size = 19913;
		String BordreauID = "57cd9da3-e1f8-4ff5-aa35-47ac276e4188";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);

			if(isVisible(CancelAndDeleteBtn)==true)
			{
				Report.LogInfo("ValidateErrorScreen", "expected Error screen displayed ", "PASS");
				verifyOptionalExists(ContractStatusMsg1,"Contract Status not Signed Message");
				String ActualContractStatus=getTextFrom(ContractStatusMsg1);
				if(ActualContractStatus.equals(ExpectedContractStatus))
				{
					Report.LogInfo("ValidateContractStatusMsg", "Contract status message validate successfully", "PASS");	
				}
				else
				{
					Report.LogInfo("ValidateContractStatusMsg", "Contract status message not validate successfully", "FAIL");
				}
				verifyMustExists(CancelAndDeleteBtn,"Cancel Processing And Delete Bordereau");
				click(CancelAndDeleteBtn," Click on Cancel Processing And Delete Bordereau");	
				sleep(3000);
				if(isVisible(DeleteYESButton)==true){
					verifyMustExists(DeleteYESButton," Yes and Cancel Processing ");
					click(DeleteYESButton," Click on Yes and Cancel Processing");
				}else{
					Report.LogInfo("ValidateErrorScreen", "expected Error screen not displayed ", "FAIL");
					deleteBorderEAUX();
				}
			}
			else{
				Report.LogInfo("ValidateErrorScreen", "expected Error screen not displayed ", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}
		else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
		sleep(3000);
	}
	public void ZeroPassRecord_TC5675() throws Exception
	{
		String IncDate = "01/01/2018";
		String ExpDate = "01/01/2019";
		String subSheet = "Automation Risk Format 1 (Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String QueName = "Automation Risk Format 1";
		policy.CreateContractwithInceptionDate2018();
		
	    applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
    	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			Sheet5675Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_5675.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(Sheet5675Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_5675.xlsx\",\"UniqueFileName\":\"S86147420180430.xlsx\",\"BordereauFormatId\":\"5cca2e44-2a28-4cdf-ae49-198cb434b638\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S86147420180430.xlsx\",\"Filesize\":24518,\"Path\":null,\"size\":24518,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		String Ufname = "S77421820181102.xlsx";	
		int size = 24518;
		String BordreauID = "5cca2e44-2a28-4cdf-ae49-198cb434b638";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(SkippAllErroBtn1)== true && isEnable(SkippAllErroBtn1)==true){
				 clickOnSkipAllErrorBTN1();
			
				waitForElementToAppear(Cancelbtn1,10);
				verifyMustExists(Cancelbtn1,"Cancel button");
				click(Cancelbtn1,"Cancel button");
				refreshUploadedFile();
				waitForElementToAppear(ReviewError,10);
				if(isVisible(ReviewError)==true){
					AssertBordereauStatusReviewError = getTextFrom(ReviewError);
					Report.LogInfo("Review Error Status Button Displayed", AssertBordereauStatusReviewError, "PASS");
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error Status Button Displayed", "PASS");
					deleteBorderEAUX();
				}
				else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error Status Button not Displayed", "FAIL");
				}	
				//3477
			/*
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					Sheet5675Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_5675.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				}
				else{
					Report.LogInfo("ErrorScreen", "Expected error screen not displayed or button is not clickable", "FAIL");
				}
			}
			else
			{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
				//VerifyNotificationPopupAfterUpload();
			}
	}
	//=====================================================================================================================================	
		public void TideFieldFilter_ReviewStep(String TideFieldName) {
			int i = 0;
			String SearchedCheckBox1 = "@xpath=//*[@value='" + TideFieldName + "']";

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
					sendKeys(TideFieldSearchTextBox, TideFieldName, "Search Filter Textbox.");
					sleep(2000);
				}
				i++;
			} while (!isVisible(SearchedCheckBox1) && i < 5);

			click(SearchedCheckBox1, "Searched Record Checkbox");
			waitForElementToAppear(TideFieldFilterButton, 3);
			verifyMustExists(TideFieldFilterButton, "Filter Button");
			click(TideFieldFilterButton, "Filter Button");
		}
		
		
		
		
		
		
		public void DefaultAndConditionalDefaultSpecify(String ReviewStepTideFieldName ,String Operator, String CoulmnName,String DefaultvalueInput,String entry, String ConditionalDefaultvalueInput) throws Exception {
			String subSheet2 = "Automation Company Admin 1 Risk Format 10";
			OpenQuestionnaire(subSheet2);
			
			waitForElementToAppear(ReviewStep13, 3);
			verifyExists(ReviewStep13);
			click(ReviewStep13);
			
			
			TideFieldFilter_ReviewStep(ReviewStepTideFieldName);
			BordereauQuePage bordereauQue = new BordereauQuePage();
			waitForElementToAppear(SpecifyDefaultButton, 5);
			verifyMustExists(SpecifyDefaultButton, "Specify Default Button");
			click(SpecifyDefaultButton, "Specify Default Button");
			if (isVisible(DefaultValue) == true) {
				//Default Value
				waitForElementToAppear(DefaultValue, 5);
				verifyMustExists(DefaultValue, "DefaultValue");
				sendKeys(DefaultValue, DefaultvalueInput, "Enter Default Value");
				//conditionaDefaultvalue
				waitForElementToAppear(AddConditionalDefault, 5);
				verifyMustExists(AddConditionalDefault, "Add Conditional Default button");
				click(AddConditionalDefault, "Add Conditional Default button");
				String CoulmnName1 = "@xpath=//ul/li[text()='"+CoulmnName+"']";
				SelectDropDownValue(ColumnNameSelect, CoulmnName1); //parameter
				
				String Operator1 = "@xpath=//ul/li[contains(.,'"+Operator+"')]";
				SelectDropDownValue(OperatorNameSelect, Operator1); //parameter
				
				waitForElementToAppear(EntryValue, 5);
				verifyMustExists(EntryValue, "Entry Value");
				sendKeys(EntryValue, entry, "Entry Value");
				
				waitForElementToAppear(ConditionalDefaultValue, 5);
				verifyMustExists(ConditionalDefaultValue, "Conditional Defautl tValue");
				sendKeys(ConditionalDefaultValue, ConditionalDefaultvalueInput, "Conditional Defautl tValue");
				
				verifyMustExists(policy.ConditionalSave, "Conditional default SaveButton");
				click(policy.ConditionalSave, "Conditional default SaveButton");
				
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
				Report.LogInfo("ValidateExpectedScreen", "Apply Default Value screen", "FAIL");
				homePage.adminMenu();
			}
		}

//		==================================================================================================================================
		
		public void Other_fees_Description_TC1056() throws InterruptedException, Exception, Exception
		{
			
			String subSheet1 = "Automation Company Admin 1 Risk Format 10 (Lloyd's Property Schema)";
			String subSheet2 = "Automation Company Admin 1 Risk Format 10";
			
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
			policy.CreateContractwithInceptionDate2018();
			GetFormatID(subSheet2);		
			
		 //  applyFilterPolicy("650285JP");
		 applyFilterPolicy(policy.PolicyNumber);
		    
			openSelectedPolicy();
			SubmitBordereaux(subSheet1);
			
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"650285JP"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		try 
			{
				String fpath = new File(".").getCanonicalPath();
				Sheet5675Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_OtherFeesDescription.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(Sheet5675Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			 String Ufname = "S40501020180919.xlsx";	
		     int size = 25170;
		     String BordreauID = BQPage.FormatId;
	         String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	         String   ID = extractIDFromResponseinsideContract(response); 
	         String   payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	         addAsDraft(payload,DraftUrl);
		   	 refreshUploadedFile();
			String OtherFeesDescriptionCol="@xpath=//*[@data-field='Other_Fees_Description']";
			
			if(isVisible(ReviewBtn)==true){
				AssertBordereauStatusReview = getTextFrom(ReviewBtn);
				Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
				sleep(2000);
				verifyMustExists(ReviewBtn,"Review button");
				openDATALink();
				navigateToDATARiskTab();
				
				String OtherFeesDescriptionValue1="@xpath=//tr[1]//td[contains(@ng-click,'33') and contains(@ng-click,'Other_Fees_Description')]";
				String OtherFeesDescriptionValue2="@xpath=//tr[2]//td[contains(@ng-click,'33') and contains(@ng-click,'Other_Fees_Description')]";
				String OtherFeesDescriptionValue3="@xpath=//tr[3]//td[contains(@ng-click,'33') and contains(@ng-click,'Other_Fees_Description')]";
				waitForElementToAppear(OtherFeesDescriptionCol,20);
				mouseOverAction(OtherFeesDescriptionCol);
				verifyMustExists(OtherFeesDescriptionCol,"Other Fees Description column");
				sleep(2000);
				
				verifyExists(OtherFeesDescriptionValue1,"Other Fees Description value - borderau value ");
				mouseOverAction(OtherFeesDescriptionValue1);
				
				 Result_1056_01 = getTextFrom(OtherFeesDescriptionValue1);
					
					if(Result_1056_01.equals("Unknown"))
					{
						Report.LogInfo("DataField", " borderau value validation successful", "PASS");	
					}
					else
					{
						Report.LogInfo("DataField", " borderau value validation not successful", "FAIL	");	
					}
				sleep(2000);
				verifyExists(OtherFeesDescriptionValue2,"Other Fees Description value - default value ");
				mouseOverAction(OtherFeesDescriptionValue2);
				Result_1056_02 = getTextFrom(OtherFeesDescriptionValue2);
				
				if(Result_1056_02.equals("Default2"))
				{
					Report.LogInfo("DataField", " default value  validation successful", "PASS");	
				}
				else
				{
					Report.LogInfo("DataField", "default value  validation not successful", "FAIL	");	
				}
			
				sleep(2000);
				verifyExists(OtherFeesDescriptionValue3,"Other Fees Description value - Conditional default value");
				mouseOverAction(OtherFeesDescriptionValue3);
				Result_1056_03 = getTextFrom(OtherFeesDescriptionValue3);
				
				if(Result_1056_03.equals("Default3"))
				{
					Report.LogInfo("DataField", " Conditional default value validation successful", "PASS");	
				}
				else
				{
					Report.LogInfo("DataField", " Conditional default value validation not successful", "FAIL");	
				}
				
				
			}
			else{

				Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
				deleteBorderEAUX();
			}
				// not supplied selection
							}
				
				
		

		
		
		


	//---------------------------------------------------------Financial Fields------------------------------------------------------
	public String InvalidFinancialErrorScreentext;
	public void EnterCharacterFinantialfields_3373() throws Exception
	{
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String subSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="SP - First Sheet";
		policy.CreateContractwithInceptionDate2018();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3373Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_3373.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3373Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S30128720180604.xlsx";	
		int size = 22717;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);

			InvalidFinancialErrorScreentext = getTextFrom(InvalidFinancialErrorScreen);
			if(isVisible(CorrectedVal)==true){
				verifyMustExists(CorrectedVal,"Corrected Value textbox");
				sendKeys(CorrectedVal, "1000", "Corrected Value");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx, "Continue button");
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true){
					AssertBordereauStatusReview = getTextFrom(ReviewBtn);
					Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
					deleteBorderEAUX();
				}else{
					Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}
	}
	
	public String Row1Text;
	public String Row2Text;
	public String Row3Text;
	public String Row4Text;
	public String Row5Text;
	public String Row6Text;
	public String Row7Text;
	public String Row8Text;
	public String Row9Text;
	public String Row10Text;
	public void financialCalculation_GrossPremiumIncludingTax() throws Exception{
		String SubmitSheet="Bordereau Processing";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux("Bordereau Processing (kruthika test schema)");
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3441Path = fpath+"\\src\\test\\resources\\testdata\\Financial Calculation_TC_3441.xlsx";
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		File excelFile = new File(sheet3441Path);
		
		String Ufname = "S43560220180604.xlsx";	
		int size = 113653;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			selectRowNumberAscOrder();
			String GrossPremiumIncludingTax="@xpath=//*[@data-field='Gross_Premium_including_Tax']";
			String GrossPremiumTax1Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[1]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='100.00']";
			String GrossPremiumTax2Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[2]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='100.00']";
			String GrossPremiumTax3Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[3]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
			String GrossPremiumTax4Row="@xpath=//*[@data-field='Gross_Premium_including_Tax']//following::tr[4]//td[contains(@ng-click,'Gross_Premium_including_Tax')][text()='0.00']";
			
			waitForElementToAppear(GrossPremiumIncludingTax,5);
			mouseOverAction(GrossPremiumIncludingTax);
			verifyMustExists(GrossPremiumIncludingTax,"Gross Premium Including Tax column");
			sleep(2000);
			verifyExists(GrossPremiumTax1Row,"Gross Premium Including Tax-1 Value");
			verifyExists(GrossPremiumTax2Row,"Gross Premium Including Tax-2 Value");
			verifyExists(GrossPremiumTax3Row,"Gross Premium Including Tax-3 Value");
			verifyExists(GrossPremiumTax4Row,"Gross Premium Including Tax-4 Value");
			Row1Text = getTextFrom(GrossPremiumTax1Row);
			Row2Text = getTextFrom(GrossPremiumTax2Row);
			Row3Text = getTextFrom(GrossPremiumTax3Row);
			Row4Text = getTextFrom(GrossPremiumTax4Row);
			/*verifyExists(GrossPremiumTax5Row,"Gross Premium Including Tax-5 Value");
			verifyExists(GrossPremiumTax6Row,"Gross Premium Including Tax-6 Value");
			verifyExists(GrossPremiumTax7Row,"Gross Premium Including Tax-7 Value");
			verifyExists(GrossPremiumTax8Row,"Gross Premium Including Tax-8 Value");
			verifyExists(GrossPremiumTax9Row,"Gross Premium Including Tax-9 Value");
			verifyExists(GrossPremiumTax10Row,"Gross Premium Including Tax-10 Value");	*/
			sleep(2000);
		} 
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}		
	}

	public void financialCalculation_GrossPremium() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String GrossPremium1Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium2Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium3Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='0.00']";
				String GrossPremium4Row="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='0.00']";
				waitForElementToAppear(GrossPremium,5);
				mouseOverAction(GrossPremium);
				verifyMustExists(GrossPremium,"Gross Premium column");
				sleep(2000);
				verifyExists(GrossPremium1Row,"Gross Premium 1 Value");
				verifyExists(GrossPremium2Row,"Gross Premium 2 Value");
				verifyExists(GrossPremium3Row,"Gross Premium 3 Value");
				verifyExists(GrossPremium4Row,"Gross Premium 4 Value");
				Row1Text = getTextFrom(GrossPremium1Row);
				Row2Text = getTextFrom(GrossPremium2Row);
				Row3Text = getTextFrom(GrossPremium3Row);
				Row4Text = getTextFrom(GrossPremium4Row);
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_CoverholderCommission() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String CoverholderCommission1Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission2Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission3Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission4Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission5Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission6Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[6]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='24.50']";
				String CoverholderCommission7Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[7]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission8Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[8]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='0.00']";
				String CoverholderCommission9Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[9]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";
				String CoverholderCommission10Row="@xpath=//*[@data-field='Coverholder_Commission']//following::tr[10]//td[contains(@ng-click,'Coverholder_Commission')][1][text()='124.50']";							
				waitForElementToAppear(CoverholderCommission,5);
				mouseOverAction(CoverholderCommission);
				verifyMustExists(CoverholderCommission,"Coverholder Commission column");
				sleep(2000);
				verifyExists(CoverholderCommission1Row,"Coverholder Commission 1 Value");
			
				verifyExists(CoverholderCommission3Row,"Coverholder Commission 3 Value");
				verifyExists(CoverholderCommission4Row,"Coverholder Commission 4 Value");
				verifyExists(CoverholderCommission5Row,"Coverholder Commission 5 Value");
				Row1Text = getTextFrom(CoverholderCommission1Row);
				Row2Text = getTextFrom(CoverholderCommission3Row);
				Row3Text = getTextFrom(CoverholderCommission4Row);
				Row4Text = getTextFrom(CoverholderCommission5Row);
			
				sleep(2000); 
			}
		}
		else
		{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_CoverholderCommission_Percent() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String CoverholderCommissionPercent1Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50 %']";
				String CoverholderCommissionPercent2Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='124.50 %']";
				String CoverholderCommissionPercent3Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[3]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
				String CoverholderCommissionPercent4Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[4]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
				String CoverholderCommissionPercent5Row="@xpath=//*[@data-field='Coverholder_Commission_Percent']//following::tr[5]//td[contains(@ng-click,'Coverholder_Commission_Percent')][text()='0.00 %']";
		
				waitForElementToAppear(CoverholderCommissionPercent,5);
				mouseOverAction(CoverholderCommissionPercent);
				verifyMustExists(CoverholderCommissionPercent,"Coverholder Commission % column");
				sleep(2000);
				verifyExists(CoverholderCommissionPercent1Row,"Coverholder Commission % 1 Value");
				verifyExists(CoverholderCommissionPercent2Row,"Coverholder Commission % 2 Value");
				verifyExists(CoverholderCommissionPercent3Row,"Coverholder Commission % 3 Value");
				verifyExists(CoverholderCommissionPercent4Row,"Coverholder Commission % 4 Value");
				verifyExists(CoverholderCommissionPercent5Row,"Coverholder Commission % 5 Value");
				Row1Text = getTextFrom(CoverholderCommissionPercent1Row);
				Row2Text = getTextFrom(CoverholderCommissionPercent2Row);
				Row3Text = getTextFrom(CoverholderCommissionPercent3Row);
				Row4Text = getTextFrom(CoverholderCommissionPercent4Row);
			
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_NetPremium() throws Exception{
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String NetPreium1Row="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				String NetPreium2Row="@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				String NetPreium3Row="@xpath=//*[@data-field='Net_Premium']//following::tr[3]//td[contains(@ng-click,'Net_Premium')][text()='-124.50']";
				String NetPreium4Row="@xpath=//*[@data-field='Net_Premium']//following::tr[4]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPreium5Row="@xpath=//*[@data-field='Net_Premium']//following::tr[5]//td[contains(@ng-click,'Net_Premium')][text()='1,537.00']";
				String NetPreium6Row="@xpath=//*[@data-field='Net_Premium']//following::tr[6]//td[contains(@ng-click,'Net_Premium')][text()='75.50']";
				String NetPreium7Row="@xpath=//*[@data-field='Net_Premium']//following::tr[7]//td[contains(@ng-click,'Net_Premium')][text()='100.00']";
				String NetPreium8Row="@xpath=//*[@data-field='Net_Premium']//following::tr[8]//td[contains(@ng-click,'Net_Premium')][text()='0.00']";
				String NetPreium9Row="@xpath=//*[@data-field='Net_Premium']//following::tr[9]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				String NetPreium10Row="@xpath=//*[@data-field='Net_Premium']//following::tr[10]//td[contains(@ng-click,'Net_Premium')][text()='-24.50']";
				waitForElementToAppear(NetPremium,5);
				mouseOverAction(NetPremium);
				verifyMustExists(NetPremium,"Net Premium column");
				sleep(2000);
				verifyExists(NetPreium1Row,"Net Premium 1 Value");
				verifyExists(NetPreium2Row,"Net Premium 2 Value");
				verifyExists(NetPreium3Row,"Net Premium 3 Value");
				verifyExists(NetPreium4Row,"Net Premium 4 Value");
				verifyExists(NetPreium5Row,"Net Premium 5 Value");
				verifyExists(NetPreium6Row,"Net Premium 6 Value");
				verifyExists(NetPreium7Row,"Net Premium 7 Value");
				verifyExists(NetPreium8Row,"Net Premium 8 Value");
				verifyExists(NetPreium9Row,"Net Premium 9 Value");
				verifyExists(NetPreium10Row,"Net Premium 10 Value");
				Row1Text = getTextFrom(NetPreium1Row);
				Row2Text = getTextFrom(NetPreium2Row);
				 Row3Text = getTextFrom(NetPreium3Row);
				 Row4Text = getTextFrom(NetPreium4Row);
				 Row5Text = getTextFrom(NetPreium5Row);
				 Row6Text = getTextFrom(NetPreium6Row);
				 Row7Text = getTextFrom(NetPreium7Row);
				 Row8Text = getTextFrom(NetPreium8Row);
				 Row9Text = getTextFrom(NetPreium9Row);
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}

	}


	public void financialCalculation_Brokerage() throws Exception{	
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String LondonBrokerage1Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage2Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage3Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[3]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage4Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[4]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage5Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[5]//td[contains(@ng-click,'London_Brokerage')][text()='76.85']";
				String LondonBrokerage6Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[6]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage7Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[7]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage8Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[8]//td[contains(@ng-click,'London_Brokerage')][text()='20.00']";
				String LondonBrokerage9Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[9]//td[contains(@ng-click,'London_Brokerage')][text()='5.00']";
				String LondonBrokerage10Row="@xpath=//*[@data-field='London_Brokerage']//following::tr[10]//td[contains(@ng-click,'London_Brokerage')][text()='0.00']";
				waitForElementToAppear(LondonBrokerage,5);
				mouseOverAction(LondonBrokerage);
				verifyMustExists(LondonBrokerage,"London Brokerage column");
				sleep(2000);
				verifyExists(LondonBrokerage1Row,"London Brokerage 1 Value");
				verifyExists(LondonBrokerage2Row,"London Brokerage 2 Value");
				verifyExists(LondonBrokerage3Row,"London Brokerage 3 Value");
				verifyExists(LondonBrokerage4Row,"London Brokerage 4 Value");
				verifyExists(LondonBrokerage5Row,"London Brokerage 5 Value");
				verifyExists(LondonBrokerage6Row,"London Brokerage 6 Value");
				verifyExists(LondonBrokerage7Row,"London Brokerage 7 Value");
				verifyExists(LondonBrokerage8Row,"London Brokerage 8 Value");
				verifyExists(LondonBrokerage9Row,"London Brokerage 9 Value");
				verifyExists(LondonBrokerage10Row,"London Brokerage 10 Value");
				Row1Text = getTextFrom(LondonBrokerage1Row);
				Row2Text = getTextFrom(LondonBrokerage2Row);
				 Row3Text = getTextFrom(LondonBrokerage3Row);
				 Row4Text = getTextFrom(LondonBrokerage4Row);
				 Row5Text = getTextFrom(LondonBrokerage5Row);
				 Row6Text = getTextFrom(LondonBrokerage6Row);
				 Row7Text = getTextFrom(LondonBrokerage7Row);
				 Row8Text = getTextFrom(LondonBrokerage8Row);
				 Row9Text = getTextFrom(LondonBrokerage9Row);
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_BrokeragePercent() throws Exception{	
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String BrokeragePercent1Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[1]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent2Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[2]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent3Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[3]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				String BrokeragePercent4Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[4]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				String BrokeragePercent5Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[5]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent6Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[6]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent7Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[7]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent8Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[8]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				String BrokeragePercent9Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[9]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='5.00 %']";
				String BrokeragePercent10Row="@xpath=//*[@data-field='London_Brokerage_Percent']//following::tr[10]//td[contains(@ng-click,'London_Brokerage_Percent')][text()='0.00 %']";
				waitForElementToAppear(LondonBrokeragePercent,5);
				mouseOverAction(LondonBrokeragePercent);
				verifyMustExists(LondonBrokeragePercent,"London Brokerage percent column");
				sleep(2000);
				verifyExists(BrokeragePercent1Row,"London Brokerage percent 1 Value");
				verifyExists(BrokeragePercent2Row,"London Brokerage percent 2 Value");
				verifyExists(BrokeragePercent3Row,"London Brokerage percent 3 Value");
				verifyExists(BrokeragePercent4Row,"London Brokerage percent 4 Value");
				verifyExists(BrokeragePercent5Row,"London Brokerage percent 5 Value");
				verifyExists(BrokeragePercent6Row,"London Brokerage percent 6 Value");
				verifyExists(BrokeragePercent7Row,"London Brokerage percent 7 Value");
				verifyExists(BrokeragePercent8Row,"London Brokerage percent 8 Value");
				verifyExists(BrokeragePercent9Row,"London Brokerage percent 9 Value");
				verifyExists(BrokeragePercent10Row,"London Brokerage percent 10 Value");
				Row1Text = getTextFrom(BrokeragePercent1Row);
				Row2Text = getTextFrom(BrokeragePercent2Row);
				 Row3Text = getTextFrom(BrokeragePercent3Row);
				 Row4Text = getTextFrom(BrokeragePercent4Row);
				 Row5Text = getTextFrom(BrokeragePercent5Row);
				 Row6Text = getTextFrom(BrokeragePercent6Row);
				 Row7Text = getTextFrom(BrokeragePercent7Row);
				 Row8Text = getTextFrom(BrokeragePercent8Row);
				 Row9Text = getTextFrom(BrokeragePercent9Row);
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void financialCalculation_FinalNetPremium() throws Exception{	
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else
			{
				selectRowNumberAscOrder();
				String FinalNetPremium1Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
				String FinalNetPremium2Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
				String FinalNetPremium3Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[3]//td[contains(@ng-click,'Final_Net_Premium')][text()='-129.50']";
				String FinalNetPremium4Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[4]//td[contains(@ng-click,'Final_Net_Premium')][text()='-5.00']";
				String FinalNetPremium5Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[5]//td[contains(@ng-click,'Final_Net_Premium')][text()='1,460.15']";
				String FinalNetPremium6Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[6]//td[contains(@ng-click,'Final_Net_Premium')][text()='70.50']";
				String FinalNetPremium7Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[7]//td[contains(@ng-click,'Final_Net_Premium')][text()='95.00']";
				String FinalNetPremium8Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[8]//td[contains(@ng-click,'Final_Net_Premium')][text()='-20.00']";
				String FinalNetPremium9Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[9]//td[contains(@ng-click,'Final_Net_Premium')][text()='-29.50']";
				String FinalNetPremium10Row="@xpath=//*[@data-field='Final_Net_Premium']//following::tr[10]//td[contains(@ng-click,'Final_Net_Premium')][text()='-24.50']";
				waitForElementToAppear(FinalNetPremium,5);
				mouseOverAction(FinalNetPremium);
				verifyMustExists(FinalNetPremium,"Final Net Premium column");
				sleep(2000);
				verifyExists(FinalNetPremium1Row,"Final Net Premium 1 Value");
				verifyExists(FinalNetPremium2Row,"Final Net Premium 2 Value");
				verifyExists(FinalNetPremium3Row,"Final Net Premium 3 Value");
				verifyExists(FinalNetPremium4Row,"Final Net Premium 4 Value");
				verifyExists(FinalNetPremium5Row,"Final Net Premium 5 Value");
				verifyExists(FinalNetPremium6Row,"Final Net Premium 6 Value");
				verifyExists(FinalNetPremium7Row,"Final Net Premium 7 Value");
				verifyExists(FinalNetPremium8Row,"Final Net Premium 8 Value");
				verifyExists(FinalNetPremium9Row,"Final Net Premium 9 Value");
				verifyExists(FinalNetPremium10Row,"Final Net Premium 10 Value");
				
				Row1Text = getTextFrom(FinalNetPremium1Row);
				Row2Text = getTextFrom(FinalNetPremium2Row);
				 Row3Text = getTextFrom(FinalNetPremium3Row);
				 Row4Text = getTextFrom(FinalNetPremium4Row);
				 Row5Text = getTextFrom(FinalNetPremium5Row);
				 Row6Text = getTextFrom(FinalNetPremium6Row);
				 Row7Text = getTextFrom(FinalNetPremium7Row);
				 Row8Text = getTextFrom(FinalNetPremium8Row);
				 Row9Text = getTextFrom(FinalNetPremium9Row);
				sleep(2000); 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}


	public void financialCalculationGrossPremium() throws Exception{
		String ExpectedFirstRow ="0.00";
		String ExpectedSecondRow ="5.00";
		String ExpectedThirdRow ="5.00";

		//loginPage.tideLogin();
		sleep(3000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			//sleep(2000);
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
			}
			else{
				selectRowNumberAscOrder();
				verifyMustExists(TaxFirstRow,"TaxFirstRow");        
				//String ActualFirstRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[8]//td[48][@class='bgm-green']")).getText();
				String ActualFirstRow = getTextFrom(TaxFirstRow);
				sleep(2000);
				verifyMustExists(TaxSecondRow,"TaxSecondRow");
				//String ActualSecondRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[9]//td[48][@class='bgm-green']")).getText();
				String ActualSecondRow = getTextFrom(TaxSecondRow);
				sleep(2000);
				verifyMustExists(TaxThirdRow,"TaxThirdRow");
				//String ActualThirdRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[10]//td[48][@class='bgm-green']")).getText();
				String ActualThirdRow = getTextFrom(TaxThirdRow);
				sleep(2000);
				if(ActualFirstRow.equals(ExpectedFirstRow))
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records not validate successfully", "FAIL");
				}

				sleep(2000);
				if(ActualSecondRow.equals(ExpectedSecondRow))
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records not validate successfully", "FAIL");
				} 

				sleep(2000);
				if(ActualThirdRow.equals(ExpectedThirdRow))
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records not validate successfully", "FAIL");
				} 
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
		}
	}

	public void CoreFinancialCalculationValidationTax() throws Exception{
		String ExpectedFirstRow ="5.00 %";
		String ExpectedSecondRow ="5.00 %";
		String ExpectedThirdRow ="5.00 %";
		sleep(3000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.navigationOnBordereauxTab();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			//sleep(2000);
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
				policy.navigationOnBordereauxTab();
				deleteBorderEAUX();			   
			}else{
				selectRowNumberAscOrder();

				verifyMustExists(TaxPercentFirstRow,"TaxPercentFirstRow");
				//String ActualFirstRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[8]//td[49][@class='bgm-green']")).getText();
				String ActualFirstRow = getTextFrom(TaxPercentFirstRow);
				sleep(2000);
				verifyMustExists(TaxPercentSecondRow,"TaxPercentSecondRow");
				//String ActualSecondRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[9]//td[49][@class='bgm-green']")).getText();
				String ActualSecondRow = getTextFrom(TaxPercentSecondRow);
				sleep(2000);
				verifyMustExists(TaxPercentThirdRow,"TaxPercentSecondRow");
				//String ActualThirdRow = webDriver.findElement(By.xpath("//*[@id='grid']//tr[10]//td[49][@class='bgm-green']")).getText();
				String ActualThirdRow = getTextFrom(TaxPercentThirdRow);
				sleep(2000);
				if(ActualFirstRow.equals(ExpectedFirstRow))
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row from last three records not validate successfully", "FAIL");
				}
				sleep(2000);
				if(ActualSecondRow.equals(ExpectedSecondRow))
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedSecondRow", "Expected Second Row from last three records not validate successfully", "FAIL");
				} 
				sleep(2000);
				if(ActualThirdRow.equals(ExpectedThirdRow))
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records validate successfully", "PASS"); 
				}
				else
				{
					Report.LogInfo("ValidateExpectedThirdRow", "Expected Third Row from last three records not validate successfully", "FAIL");
				} 

				policy.navigationOnBordereauxTab();
				deleteBorderEAUX();
			}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail"); 
			policy.navigationOnBordereauxTab();
			deleteBorderEAUX();
		}
	}

	public void ProcessBorderoWithDefaulstRisk_3429() throws Exception
	{
		ArrayList<String> DataCapture1 = new ArrayList<String>();
		ArrayList<String> DataCapture2 = new ArrayList<String>();
		ArrayList<String> DataCapture3 = new ArrayList<String>();
		ArrayList<String> DataCapture4 = new ArrayList<String>();
		ArrayList<String> DataCapture5 = new ArrayList<String>();
		ArrayList<String> DataCapture6 = new ArrayList<String>();
		ArrayList<String> DataCapture7 = new ArrayList<String>();
		ArrayList<String> DataCapture8 = new ArrayList<String>();
		ArrayList<String> DataCapture9 = new ArrayList<String>();
		ArrayList<String> DataCapture10 = new ArrayList<String>();
		
		/*String ExpectedFirstRow ="1,326.02";
		String ExpectedSecondRow ="1,813.90";
		String ExpectedFirstRowGross ="622.50";
		String ExpectedSecondRowGross ="2,134.00";
		String ExpectedFirstRowCC ="62.25";
		String ExpectedSecondRowCC ="213.40";
		String ExpectedFirstRowNP ="1,404.05";
		String ExpectedSecondRowNP ="1,920.60";
		String ExpectedFirstRowLB ="78.03";
		String ExpectedSecondRowLB ="106.70";*/
		
		String FinalNetPremimumFirstRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[1]//td[contains(@ng-click,'Final_Net_Premium')]";
		String FinalNetPremimumSecondRow = "@xpath=//*[@data-field='Final_Net_Premium']//following::tr[2]//td[contains(@ng-click,'Final_Net_Premium')]";
		String GrossPremimumFirstRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2]";
		String GrossPremimumSecondRow = "@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2]";
		String ComissioncvCFirstRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[1]//td[contains(@ng-click,'Coverholder_Commission')][1]";
		String CovCommiSsionsecondRow = "@xpath=//*[@data-field='Coverholder_Commission']//following::tr[2]//td[contains(@ng-click,'Coverholder_Commission')][1]";
		String NetPremiumFirstRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1]";
		String NetPremiumSecondRow = "@xpath=//*[@data-field='Net_Premium']//following::tr[2]//td[contains(@ng-click,'Net_Premium')][1]";
		String LBrokerageFirstRow = "@xpath=//*[@data-field='London_Brokerage']//following::tr[1]//td[contains(@ng-click,'London_Brokerage')][1]";
		String LBrokerageSecondRow = "@xpath=//*[@data-field='London_Brokerage']//following::tr[2]//td[contains(@ng-click,'London_Brokerage')][1]";	
		String IncDate = "01/01/2018";
		String ExpDate = "31/12/2018";
		String subSheet = "Automation Risk Format 12(Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String QueName = "Automation Risk Format 12";
		
		policy.CreateContractwithInceptionDate2018();
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		//policy.EditCoverholder();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3429Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_3429.xlsx";
		} 

		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3429Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S75627520180428.xlsx";	
		int size = 22536;
		String BordreauID = "4543fde9-300f-4539-9c1d-0b5c9c475cd8";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_3429.xlsx\",\"UniqueFileName\":\"S75627520180428.xlsx\",\"BordereauFormatId\":\"4543fde9-300f-4539-9c1d-0b5c9c475cd8\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S75627520180428.xlsx\",\"Filesize\":22536,\"Path\":null,\"size\":22536,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";	
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			
			Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			sleep(2000);
			if(isVisible(DataLinkNoResult)==true)
			{
				Report.LogInfo("ValidateResult", "Result not display", "Fail");
				policy.navigationOnBordereauxTab();
				deleteBorderEAUX();			   
			}else{
				selectRowNumberAscOrder();
					DataCapture1 = RuleDataCapture(FinalNetPremimumFirstRow,"Final Net Premium","-","1,326.02","Calculate Final Net Premium");
					FinalNetPrmimOrgValue = DataCapture1.get(0);
					FinalNetPrmimChngVlue = DataCapture1.get(1);
					FinalNetPrmimRule = DataCapture1.get(2);
					Report.LogInfo("Final Net Premium First Row", ActualFirstRow, "PASS");
					sleep(2000);
					DataCapture2 = RuleDataCapture(FinalNetPremimumSecondRow,"Final Net Premium Second Row","-","1,813.90","Calculate Final Net Premium");
					FinalNetPrmimSecondOrgValue = DataCapture2.get(0);
					FinalNetPrmimSecondChngVlue = DataCapture2.get(1);
					FinalNetPrmimSecondRule = DataCapture2.get(2);
					Report.LogInfo("Final Net Premium Second Row", ActualSecondRow, "PASS");
					sleep(2000);
					DataCapture3 = RuleDataCapture(GrossPremimumFirstRow,"Gross Premium First Row","1245","622.50","Application of Risk Order % to financial fields");
					GrossPremiumFirstRowOrgValue = DataCapture3.get(0);
					GrossPremiumFirstRowChngVlue = DataCapture3.get(1);
					GrossPremiumFirstRowRule = DataCapture3.get(2);
					Report.LogInfo("Gross Premium First Row", ActualFirstRowGross, "PASS");
					sleep(2000);
					DataCapture4 = RuleDataCapture(GrossPremimumSecondRow,"Gross Premium Second Row","4268","2,134.00","Application of Risk Order % to financial fields");
					GrossPremimumSecondRowOrgValue = DataCapture4.get(0);
					GrossPremimumSecondRowChngValue = DataCapture4.get(1);
					GrossPremimumSecondRowRule = DataCapture4.get(2);
					Report.LogInfo("Gross Premium second Row", ActualSecondRowGross, "PASS");
					sleep(2000);
					
					DataCapture5 = RuleDataCapture(ComissioncvCFirstRow,"Coverholder First Commission","124.5","62.25","Application of Risk Order % to financial fields");
					ComissioncvCFirstRowOrgVlue = DataCapture5.get(0);
					ComissioncvCFirstRowChngVlue = DataCapture5.get(1);
					ComissioncvCFirstRowRule = DataCapture5.get(2);
					Report.LogInfo("Commission First Row", ActualFirstRowCC, "PASS");
					sleep(2000);
					DataCapture6 = RuleDataCapture(CovCommiSsionsecondRow,"Coverholder Second Commission","426.8","213.40","Application of Risk Order % to financial fields");
					ComissioncvCSecndRowOrgVlue = DataCapture6.get(0);
					ComissioncvCSecndRowChngVlue = DataCapture6.get(1);
					ComissioncvCSecndRowRule = DataCapture6.get(2);
					Report.LogInfo("Commission second Row", ActualSecondRowCC, "PASS");
					sleep(2000);
					
					DataCapture7 = RuleDataCapture(NetPremiumFirstRow,"Net Premium First Row","2808.09","1,404.05","Application of Risk Order % to financial fields");
					NetPremiumFirstRowOrgVlue = DataCapture7.get(0);
					NetPremiumFirstRowChngVlue = DataCapture7.get(1);
					NetPremiumFirstRowRule = DataCapture7.get(2);
					Report.LogInfo("Net Premium First Row", ActualFirstRowNP, "PASS");
					sleep(2000);

					DataCapture8 = RuleDataCapture(NetPremiumSecondRow,"Net Premium Second Row","3841.2","1,920.60","Application of Risk Order % to financial fields");
					NetPremiumSecondRowOrgVlue = DataCapture8.get(0);
					NetPremiumSecondRowChngVlue = DataCapture8.get(1);
					NetPremiumSecondRowRule = DataCapture8.get(2);
					Report.LogInfo("Net Premium Second Row", ActualSecondRowNP, "PASS");
					sleep(2000);

					DataCapture9 = RuleDataCapture(LBrokerageFirstRow,"Brockerage First Row","156.05","78.03","Application of Risk Order % to financial fields");
					LBrokerageFirstRowOrgVlue = DataCapture9.get(0);
					LBrokerageFirstRowChngVlue = DataCapture9.get(1);
					LBrokerageFirstRowRule = DataCapture9.get(2);
					Report.LogInfo("Brockerage First Row", ActualFirstRowLB, "PASS");
					sleep(2000);
					
					DataCapture10 = RuleDataCapture(LBrokerageSecondRow,"Brockerage Second Row","213.4","106.70","Application of Risk Order % to financial fields");
					LBrokerageSecondRowOrgVlue = DataCapture10.get(0);
					LBrokerageSecondRowChngVlue = DataCapture10.get(1);
					LBrokerageSecondRowRule = DataCapture10.get(2);
					Report.LogInfo("Brockerage second Row", ActualSecondRowLB, "PASS");
					sleep(2000);
			}
					policy.navigationOnBordereauxTab();
					if(isVisible(ReviewBtn)==true) {
						AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
						Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
				        deleteBorderEAUX(); 
			}else
				{
					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
					deleteBorderEAUX();
				}
		}
		}

	public void ProcessBorderoWithRisk_3430() throws Exception
	{

		
		ArrayList<String> DataCapture1 = new ArrayList<String>();		
		String ExpectedFirstRowRiskOrder ="80.00 %";
		String ExpectedSecondRowRiskOrder ="100.00 %";
		String ExpectedThirddRowRiskOrder ="60.00";

		String ExpectedFirstRowGrossPrem ="996.00";
		String ExpectedSecondRowGrossPrem ="4,268.00";
		String ExpectedThirddRowGrossPrem ="53,130.00";
		

		String ExpectedFirstRowCC ="99.60";
		String ExpectedSecondRowCC ="426.80";
		String ExpectedThirddRowCC ="5,313.00";

		String ExpectedFirstRowNP ="-2,246.47";
		String ExpectedSecondRowNP ="-3,841.20";
		String ExpectedThirddRowNP ="-47,817.00";
		
		String subSheet = "Automation Risk Format 10(Lloyd's Property Schema)";
		String QueName = "Automation Risk Format 10";
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		waitForElementToAppear(SignedBtn,10);
		policy.contractId = ReturnContractID();
		SubmitBordereaux(subSheet);
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3430Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_3430.xlsx";
		} 

		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3430Path); 
		//contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S82615620181119.xlsx"; //"S85057520180628.xlsx";	
		int size = 23988;
		String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_3430.xlsx\",\"UniqueFileName\":\"S85057520180628.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S85057520180628.xlsx\",\"Filesize\":22808,\"Path\":null,\"size\":22808,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);

			VerifyReferenceColumn();
			
			if(isVisible(EnrichedValueTxt)==true){
				verifyMustExists(EnrichedValueTxt,"Enriched Value textbox");
				sendKeys(EnrichedValueTxt, "60", "Enriched Value textbox");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx, "Continue button");
				waitForElementToAppear(CanBtn,5);
				verifyMustExists(CanBtn,"Cancel button");
				click(CanBtn, "Cancel button");
				refreshUploadedFile();
				verifyMustExists(ReviewBtn,"Review Button");
				AssertBordereauStatusReview = getTextFrom(ReviewBtn);
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				sleep(2000);
				openDATALink();
				//javaScriptclick(DATAlink,"Click on DATA link");
				navigateToDATARiskTab();
				sleep(2000);
				if(isVisible(DataLinkNoResult)==true)
				{
					Report.LogInfo("ValidateResult", "Result not display", "Fail");
					policy.navigationOnBordereauxTab();
					deleteBorderEAUX();			   
				}else{
					//selectRowNumberAscOrder();
			
					if(isVisible(RiskOrderFirstRow80)==true){
						verifyMustExists(RiskOrderFirstRow80,"Risk order First Row");
						String ActualFirstRowRO = getTextFrom(RiskOrderFirstRow80,"Risk order First Row");
						ActualFirstRO = getTextFrom(RiskOrderFirstRow80);
						Report.LogInfo("Risk order First Row", ActualFirstRO, "PASS");
						sleep(2000);
						verifyMustExists(RiskOrderSecondRow100,"Risk order second Row");
						String ActualSecondRowRO = getTextFrom(RiskOrderSecondRow100,"Risk order second Row");
						ActualSecondRO = getTextFrom(RiskOrderSecondRow100);
						Report.LogInfo("Risk order second Row", ActualSecondRO, "PASS");
						sleep(2000);
						
						verifyExists(RiskOrderThirdRow60,"1st value");
						ActualThirdRO60 =  "60.00";
						Report.LogInfo("Coverholder Commission Percentage Value",ActualThirdRO60 , "PASS");
						javaScriptclick(RiskOrderThirdRow60,"value");
						sleep(1500);
						waitForElementToAppear(Okbtn,10);
						verifyExists(OrgnlValueRule,"Coverholder Commission Percentage Original Value");
						RiskOrdeThrdRow60PrctOrgVlue = getTextFrom(OrgnlValueRule);
						Report.LogInfo("Coverholder Commission Original Percentage Value",RiskOrdeThrdRow60PrctOrgVlue , "PASS");
						sleep(1500);
						verifyMustExists(ChngdValueRule,"Coverholder commission Percentage Changed Value");
						RiskOrdeThrdRow60PrctChngVlue = getTextFrom(ChngdValueRule);
						Report.LogInfo("coverholder Commission Percentage Changed Value",RiskOrdeThrdRow60PrctChngVlue , "PASS");
						//click(GRPChngdVlu,"Gross Premium Changed Value");
						sleep(1500);
						verifyExists(RuleNameField,"Rule Name Field");
						RiskOrdeThrdRow60PrctRule =  getTextFrom(RuleNameField);
						Report.LogInfo("Rule Name Field", RiskOrdeThrdRow60PrctRule, "PASS");
						click(Okbtn,"ok Buttton");
						
						
						
						
					/*	DataCapture1 = RuleDataCapture(RiskOrderThirdRow60,"Risk Order %","120","60.00","Validate Percentage values");
						RiskOrderThirdRow60OrgValue = DataCapture1.get(0);
						RiskOrderThirdRow60ChngValue = DataCapture1.get(1);
						RiskOrderThirdRow60Rule = DataCapture1.get(2);
						Report.LogInfo("Risk Order %", ActualThirdRO60, "PASS");
						sleep(2000);*/
						
						if(ActualFirstRowRO.equals(ExpectedFirstRowRiskOrder))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Risk order First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Risk order First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowRO.equals(ExpectedSecondRowRiskOrder))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRO60.equals(ExpectedThirddRowRiskOrder))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Risk order Third record not validate successfully", "FAIL");
						} 
						sleep(2000);
						
						
						
						
						verifyMustExists(GrossPremFirstRow,"Gross Prem First Row");
						String ActualFirstRowGP = getTextFrom(GrossPremFirstRow,"Gross Prem First Row");
					    ActualFirstGP = getTextFrom(GrossPremFirstRow,"Gross Prem First Row");
						Report.LogInfo("Gross Prem First Row", ActualFirstGP, "PASS");
						sleep(2000);
						verifyMustExists(GrossPremSecondRow,"Gross Prem second Row");
						String ActualSecondRowGP = getTextFrom(GrossPremSecondRow,"Gross Prem second Row");
						ActualSecondGP = getTextFrom(GrossPremSecondRow,"Gross Prem second Row");
						Report.LogInfo("Gross Prem second Row", ActualSecondGP, "PASS");
						sleep(2000);
						verifyMustExists(GrossPremThirdRow,"Gross Prem Third Row");
						String ActualThirdRowGP = getTextFrom(GrossPremThirdRow,"Gross Prem Third Row");
						ActualThirdGP = getTextFrom(GrossPremThirdRow,"Gross Prem Third Row");
						Report.LogInfo("Gross Prem Third Row", ActualThirdGP, "PASS");
						sleep(2000);

						if(ActualFirstRowGP.equals(ExpectedFirstRowGrossPrem))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Gross Prem First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Gross Prem First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowGP.equals(ExpectedSecondRowGrossPrem))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRowGP.equals(ExpectedThirddRowGrossPrem))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Gross Prem Third record not validate successfully", "FAIL");
						} 

						verifyMustExists(CCFirstRow,"Commission First Row");
						String ActualFirstRowCC = getTextFrom(CCFirstRow,"Commission First Row");
						ActualFirstCC = getTextFrom(CCFirstRow,"Commission First Row");
						Report.LogInfo("Commission First Row", ActualFirstCC, "PASS");
						sleep(2000);
						verifyMustExists(CCSecondRow,"Commission second Row");
						String ActualSecondRowCC = getTextFrom(CCSecondRow,"Commission second Row");
						ActualSecondCC = getTextFrom(CCSecondRow,"Commission second Row");
						Report.LogInfo("Commission second Row", ActualSecondCC, "PASS");
						sleep(2000);
						verifyMustExists(CCThirdRow,"Commission Third Row");
						String ActualThirdRowCC = getTextFrom(CCThirdRow,"Commission Third Row");
						ActualThirdCC = getTextFrom(CCThirdRow,"Commission Third Row");
						Report.LogInfo("Commission Third Row", ActualThirdCC, "PASS");
						sleep(2000);

						if(ActualFirstRowCC.equals(ExpectedFirstRowCC))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowCC.equals(ExpectedSecondRowCC))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRowCC.equals(ExpectedThirddRowCC))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third record not validate successfully", "FAIL");
						} 

						/*verifyMustExists(NPFirstRow,"Net Premium First Row");
						String ActualFirstRowNP = getTextFrom(NPFirstRow,"Net Premium First Row");
						sleep(2000);
						verifyMustExists(NPSecondRow,"Net Premium second Row");
						String ActualSecondRowNP = getTextFrom(NPSecondRow,"Net Premium second Row");
						sleep(2000);
						verifyMustExists(NPThirdRow,"Net Premium Third Row");
						String ActualThirdRowNP = getTextFrom(NPThirdRow,"Net Premium Third Row");
						sleep(2000);

						if(ActualFirstRowNP.equals(ExpectedFirstRowNP))
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedFirstRow", "Expected Commission First Row record not validate successfully", "FAIL");
						}
						sleep(2000);
						if(ActualSecondRowNP.equals(ExpectedSecondRowNP))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Second record not validate successfully", "FAIL");
						} 
						sleep(2000);
						if(ActualThirdRowNP.equals(ExpectedThirddRowNP))
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third Row record validate successfully", "PASS"); 
						}
						else
						{
							Report.LogInfo("ValidateExpectedSecondRow", "Expected Commission Third record not validate successfully", "FAIL");
						} */

						/*verifyExists(FNPFirstRow,"FNP First Row");
						verifyExists(FNPSecondRow,"FNP Second Row");
						verifyExists(FNPThirdRow,"FNP Third Row");*/

						sleep(2000);

					}else{
						Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
						policy.navigationOnBordereauxTab();
						if(isVisible(ReviewBtn)==true) {
							AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
							Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
					        deleteBorderEAUX(); 
				}else
					{
						Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
					}
						//deleteBorderEAUX();
					}
				}
				//deleteBorderEAUX();

			}else{
				Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}		

	}

	//===========================================================YOA Sheet Processing===============================================================//

	public void yoaSheetProcessing_3754() throws Exception
	{
		String ExpectedRow="USD";
		String IncDate = "01/01/2018";
		String subSheet = "Automation Risk Format 15(Lloyd's Property Schema)";
		String ExpDate="31/12/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		policy.CreateContractwithInceptionDate2018();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.contractId = ReturnContractID();
		SubmitBordereaux(subSheet);	

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3754Path = fpath+"\\src\\test\\resources\\testdata\\YOA_Currency_TC3754.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3754Path); 
		
		String Ufname = "S72089320180929.xlsx";	
		int size = 18146;
		String BordreauID = "d6927d93-f65e-4bbc-a7b6-a607e4061f2b";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        

		// payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"YOA_Currency_TC3754.xlsx\",\"UniqueFileName\":\"S80444120180429.xlsx\",\"BordereauFormatId\":\"d6927d93-f65e-4bbc-a7b6-a607e4061f2b\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S80444120180429.xlsx\",\"Filesize\":18146,\"Path\":null,\"size\":18146,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(3000);
			if(isVisible(tidevaluedropdown)== true){
				verifyMustExists(PremiumCurrencyRef,"Premium currecy Ref Data Screen");
				CurrencyScreen = getTextFrom(PremiumCurrencyRef);
				Report.LogInfo("Premium currecy Ref Data Screen is open",CurrencyScreen, "PASS");
				verifyMustExists(tidevaluedropdown,"Tide value drop down");
				click(tidevaluedropdown,"Tide value drop down");
				javaScriptWait();
				verifyMustExists(tidevalueEUR,"EUR dropdown value");	
				click(tidevalueEUR,"EUR dropdown value");
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				verifyMustExists(RiskCurrencyRef,"Premium currecy Ref Data Screen");
				CurrencyScreen1 = getTextFrom(RiskCurrencyRef);
				Report.LogInfo("Risk currecy Ref Data Screen is open",CurrencyScreen1, "PASS");
				verifyMustExists(tidevaluedropdown,"Tide value drop down");
				click(tidevaluedropdown,"Tide value drop down");
				
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				waitForElementToAppear(Cancelbtn1,10);
				verifyMustExists(Cancelbtn1,"Cancel button");
				click(Cancelbtn1,"Cancel button");
				refreshUploadedFile();
				waitForElementToAppear(ReviewBtn,10);
				if (isVisible(ReviewBtn) == true) {
					AssertBordereauStatusReview = getTextFrom(ReviewBtn);
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
					deleteBorderEAUX();
				} else {
					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
				}
				// deleteBorderEAUX();
			}		
			else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
		}	

	}




	/*****************************************************************/

	//3714 Use set number of left characters from Risk Reference
	public void useLeftCharactersRiskReference() throws Exception
	{
		String IncDate = "01/01/2018";
		String ExpDate="01/01/2019";
		String subSheet = "Automation Risk Format 13 (Lloyd's Property Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet); 

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3714Path = fpath+"\\src\\test\\resources\\testdata\\UseLeftCharactersRiskReference_3714.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3714Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData); 
			String Ufname = "S26273720180927.xlsx";	
			int size = 19934;
			String BordreauID = "6379c8c4-0770-47fb-9447-d3cf02f68bc5";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//System.out.println(policy.contractId);
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"UseLeftCharactersRiskReference_3714.xlsx\",\"UniqueFileName\":\"S46728520180428.xlsx\",\"BordereauFormatId\":\"6379c8c4-0770-47fb-9447-d3cf02f68bc5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S46728520180428.xlsx\",\"Filesize\":19932,\"Path\":null,\"size\":19932,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				//selectRowNumberAscOrder();
				//Locators
				String RiskReferenceColumn ="@xpath=//*[@data-field='RiskReference']";
				String RiskReference1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference6 ="@xpath=//*[@data-field='RiskReference']//following::tr[6]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference7 ="@xpath=//*[@data-field='RiskReference']//following::tr[7]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference8 ="@xpath=//*[@data-field='RiskReference']//following::tr[8]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference9 ="@xpath=//*[@data-field='RiskReference']//following::tr[9]//td[contains(@ng-click,'RiskReference')]";
				String RiskReference10 ="@xpath=//*[@data-field='RiskReference']//following::tr[10]//td[contains(@ng-click,'RiskReference')]";
				waitForElementToAppear(RiskReferenceColumn,20);
				mouseOverAction(RiskReferenceColumn);
				verifyMustExists(RiskReferenceColumn,"Risk Reference Column");
				RiskReferenceColumnText = getTextFrom(RiskReferenceColumn);
				Report.LogInfo("Risk Reference Column", RiskReferenceColumnText, "PASS");
				sleep(2000);

				List<WebElement> YearOfAccount = webDriver.findElements(By.xpath("//*[@data-field='BordereauYear']//following::td[contains(@ng-click,'BordereauYear')][text()='2018']"));
				sleep(2000);
				if(YearOfAccount.size() == 10)
				{
					Report.LogInfo("YearOfAccount", "Year Of Account is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("YearOfAccount", "Year Of Account is Displayed wrong", "FAIL");
				}
				sleep(1000);

				verifyExists(RiskReference1,"1st value");
				RF1 = getTextFrom(RiskReference1);
				Report.LogInfo("1st value", RF1, "PASS");
				verifyExists(RiskReference2,"2nd value");
				RF2 = getTextFrom(RiskReference2);
				Report.LogInfo("2nd value", RF2, "PASS");
				verifyExists(RiskReference3,"3rd value");
				RF3 = getTextFrom(RiskReference3);
				Report.LogInfo("3rd value", RF3, "PASS");
				verifyExists(RiskReference4,"4th value");
				RF4 = getTextFrom(RiskReference4);
				Report.LogInfo("4th value", RF4, "PASS");
				verifyExists(RiskReference5,"5th value");
				RF5 = getTextFrom(RiskReference5);
				Report.LogInfo("5th value", RF5, "PASS");
				verifyExists(RiskReference6,"6th value");
				RF6 = getTextFrom(RiskReference6);
				Report.LogInfo("6th value", RF6, "PASS");
				verifyExists(RiskReference7,"7th value");
				RF7 = getTextFrom(RiskReference7);
				Report.LogInfo("7th value", RF7, "PASS");
				verifyExists(RiskReference8,"8th value");
				RF8 = getTextFrom(RiskReference8);
				Report.LogInfo("8th value", RF8, "PASS");
				verifyExists(RiskReference9,"9th value");
				RF9 = getTextFrom(RiskReference9);
				Report.LogInfo("9th value", RF9, "PASS");
				verifyExists(RiskReference10,"10th value");
				RF10 = getTextFrom(RiskReference10);
				Report.LogInfo("10th value", RF10, "PASS");
				
				sleep(1000);
				click(RiskReference2,"2nd field ");
				waitForElementToAppear(Okbtn,10);
				verifyExists(RuleNameField,"Rule Name Field");
				verifyExists(OriginalValue,"Original Value Field");
				verifyExists(ChangedValue,"Changed Value Field");
				click(Okbtn,"ok Buttton");
				sleep(3000);
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true) {
					AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
			        deleteBorderEAUX(); 
		}else
			{
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
			}
				//deleteBorderEAUX();
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}
	//3717 Delete rows based on single column being blank
	public void deleteRowsBasedSingleColumn() throws Exception
	{
		HomePage homePage = new HomePage();
		BordereauQuePage bordereauQue = new BordereauQuePage();
		String IncDate = "01/01/2018";
		String subSheet = "Automation Risk Format 13 (Lloyd's Property Schema)";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"581870RT\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3717Path = fpath+"\\src\\test\\resources\\testdata\\DeleteRowsBasedSingleColumn_3717.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			File excelFile = new File(sheet3717Path); 
			
			String Ufname = "S93017520180428.xlsx";	
			int size = 19903;
			String BordreauID = "6379c8c4-0770-47fb-9447-d3cf02f68bc5";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"DeleteRowsBasedSingleColumn_3717.xlsx\",\"UniqueFileName\":\"S93017520180428.xlsx\",\"BordereauFormatId\":\"6379c8c4-0770-47fb-9447-d3cf02f68bc5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S93017520180428.xlsx\",\"Filesize\":19903,\"Path\":null,\"size\":19903,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				List<WebElement> RowCount = webDriver.findElements(By.xpath("//*[@data-field='RowNumber']//following::tr"));
				sleep(2000);
				if(RowCount.size() == 9)
				{
					Report.LogInfo("RowCount", "Row Count is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("RowCount", "Row Count is Displayed wrong", "FAIL");
				}
				sleep(1000);
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true) {
					AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
			        deleteBorderEAUX(); 
		}else
			{
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
			}
				//deleteBorderEAUX();
				//String VerifyVersion1 ="@xpath=//*[@id='content']//td[contains(.,'Step-4 Bordereau format')]//following-sibling::td[1]";
				String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'Automation Risk Format 13')][1]";
				homePage.adminMenu();
				bordereauQue.bordereauQueLink();
				sleep(1000);
				bordereauQue.filterBordereauQuestionnaire("Automation Risk Format 13",SelectQuestionnaire);
				sleep(3000);
				verifyMustExists(bordereauQue.EditBtn,"Edit button");
				click(bordereauQue.EditBtn,"Edit button");
				sleep(2000);
				bordereauQue.nextStapeClick();
				bordereauQue.nextStapeClick();
				sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor)webDriver;
				jse.executeScript("scroll(0, 250);");
				WebElement RiskTextbox = webDriver.findElement(By.xpath("//*[@id='DiscardRisk_taglist']/following-sibling::input"));
				sleep(1000);
				Actions a = new Actions(webDriver);
				sleep(1000);
				a.click(RiskTextbox).build().perform();
				a.sendKeys(RiskTextbox, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE).build().perform();
				//a.sendKeys(RiskTextbox, Keys.BACK_SPACE).build().perform();
				sleep(1000);
				//click(ClearValues,"Clear Values (X) icon");
				//sleep(1000);
				click(RiskTxt,"Risk textbox");
				sleep(1000);
				click(NewOrRenewal,"New or Renewal");
				sleep(1000);
				click(RiskTxt,"Risk textbox");	
				sleep(1000);
			    click(NoBuildings,"No. Buildings");
				sleep(2000);
				bordereauQue.nextStapeClick();
				bordereauQue.FormatId = ReturnFormatID();
				verifyMustExists(bordereauQue.CancelBtn,"Cancel button");
				click(bordereauQue.CancelBtn,"Cancel button");

			}

			else
			{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed", "FAIL");
				deleteBorderEAUX();
			}

		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}

	//3719 Delete rows based on multiple columns being blank
	public void deleteRowsBasedMultipleColumn() throws Exception
	{
		HomePage homePage = new HomePage();
		BordereauQuePage bordereauQue = new BordereauQuePage();
		String subSheet = "Automation Risk Format 13 (Lloyd's Property Schema)";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			SubmitBordereaux(subSheet);	

			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//String GetData = Configuration.url+"/api/Contract/GetAllPage";
			//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\"581870RT\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3719Path = fpath+"\\src\\test\\resources\\testdata\\DeleteRowsBasedMultipleColumn_3719.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File excelFile = new File(sheet3719Path);
			
			String Ufname = "S69800820180428.xlsx";	
			int size = 19904;
			String BordreauID = "6379c8c4-0770-47fb-9447-d3cf02f68bc5";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"DeleteRowsBasedMultipleColumn_3719.xlsx\",\"UniqueFileName\":\"S69800820180428.xlsx\",\"BordereauFormatId\":\"6379c8c4-0770-47fb-9447-d3cf02f68bc5\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S69800820180428.xlsx\",\"Filesize\":19904,\"Path\":null,\"size\":19904,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				//Locators
				String RiskReferenceColumn ="@xpath=//*[@data-field='RiskReference']";
				String RiskReference1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')][text()='11']";
				String RiskReference2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')][text()='22']";
				String RiskReference3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')][text()='33']";
				String RiskReference4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')][text()='36']";
				String RiskReference5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')][text()='44']";
				String RiskReference6 ="@xpath=//*[@data-field='RiskReference']//following::tr[6]//td[contains(@ng-click,'RiskReference')][text()='55']";
				String RiskReference7 ="@xpath=//*[@data-field='RiskReference']//following::tr[7]//td[contains(@ng-click,'RiskReference')][text()='66']";
				String RiskReference8 ="@xpath=//*[@data-field='RiskReference']//following::tr[8]//td[contains(@ng-click,'RiskReference')][text()='77']";
				String RiskReference9 ="@xpath=//*[@data-field='RiskReference']//following::tr[9]//td[contains(@ng-click,'RiskReference')][text()='88']";
				waitForElementToAppear(RiskReferenceColumn,20);
				sleep(2000);
				mouseOverAction(RiskReferenceColumn);
				verifyMustExists(RiskReferenceColumn,"Risk Reference Column");
				sleep(2000);
				verifyExists(RiskReference1,"1st value");
				RF1 = getTextFrom(RiskReference1);
				Report.LogInfo("1st value", RF1, "PASS");
				verifyExists(RiskReference2,"2nd value");
				RF2 = getTextFrom(RiskReference2);
				Report.LogInfo("2nd value", RF2, "PASS");
				verifyExists(RiskReference3,"3rd value");
				RF3 = getTextFrom(RiskReference3);
				Report.LogInfo("3rd value", RF3, "PASS");
				verifyExists(RiskReference4,"4th value");
				RF4 = getTextFrom(RiskReference4);
				Report.LogInfo("4th value", RF4, "PASS");
				verifyExists(RiskReference5,"5th value");
				RF5 = getTextFrom(RiskReference5);
				Report.LogInfo("5th value", RF5, "PASS");
				verifyExists(RiskReference6,"6th value");
				RF6 = getTextFrom(RiskReference6);
				Report.LogInfo("6th value", RF6, "PASS");
				verifyExists(RiskReference7,"7th value");
				RF7 = getTextFrom(RiskReference7);
				Report.LogInfo("7th value", RF7, "PASS");
				verifyExists(RiskReference8,"8th value");
				RF8 = getTextFrom(RiskReference8);
				Report.LogInfo("8th value", RF8, "PASS");
				verifyExists(RiskReference9,"9th value");
				RF9 = getTextFrom(RiskReference9);
				Report.LogInfo("9th value", RF9, "PASS");
				sleep(1000);
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true) {
					AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
			        deleteBorderEAUX(); 
		}else
			{
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
			}
				//deleteBorderEAUX();
				String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'Automation Risk Format 13')][1]";
				homePage.adminMenu();
				bordereauQue.bordereauQueLink();
				bordereauQue.filterBordereauQuestionnaire("Automation Risk Format 13",SelectQuestionnaire);
				sleep(3000);
				verifyMustExists(bordereauQue.EditBtn,"Edit button");
				click(bordereauQue.EditBtn,"Edit button");
				sleep(2000);
				bordereauQue.nextStapeClick();
				bordereauQue.nextStapeClick();
				sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor)webDriver;
				jse.executeScript("scroll(0, 250);");
				WebElement RiskTextbox = webDriver.findElement(By.xpath("//*[@id='DiscardRisk_taglist']/following-sibling::input"));
				sleep(1000);
				Actions a = new Actions(webDriver);
				sleep(1000);
				a.click(RiskTextbox).build().perform();
				a.sendKeys(RiskTextbox, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE).build().perform();
				sleep(1000);
				click(RiskTxt,"Risk textbox");
				sleep(1000);
				click(PolicyNum,"Policy Number");
				bordereauQue.nextStapeClick();
				verifyMustExists(bordereauQue.CancelBtn,"Cancel button");
				click(bordereauQue.CancelBtn,"Cancel button");
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}	
	}

	//3727 Risk Bordereaux Currency based on Contract Currency lookup
	public void riskBordereauxonContractCurrencyLookup() throws Exception
	{
		HomePage homePage = new HomePage();
		BordereauQuePage bordereauQue = new BordereauQuePage();
		//applyFilterPolicy("844230DP");
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		String subSheet = "Automation Risk Format 10 (Lloyd's Property Schema)";
		waitForElementToAppear(SignedBtn,5);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			policy.navigationOnBordereauxTab();
			SubmitBordereaux(subSheet);
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3727Path = fpath+"\\src\\test\\resources\\testdata\\Currency_Contract_Lookup_3727.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File excelFile = new File(sheet3727Path);
			
			String Ufname = "S72829120180428.xlsx";	
			int size = 17769;
			String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Currency_Contract_Lookup_3727.xlsx\",\"UniqueFileName\":\"S72829120180428.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72829120180428.xlsx\",\"Filesize\":17769,\"Path\":null,\"size\":17769,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				String PremiumCurrencyColumn ="@xpath=//*[@data-field='Premium_Currency']";
				waitForElementToAppear(PremiumCurrencyColumn, 20);
				mouseOverAction(PremiumCurrencyColumn);
				PremiumCurColumn = getTextFrom(PremiumCurrencyColumn);
				Report.LogInfo("PremiumCurrencyColumn", PremiumCurColumn, "PASS");
				sleep(2000);
				List<WebElement> PremiumCurrency = webDriver.findElements(By.xpath("//*[@id='notification']//following::td[contains(@ng-click,'Premium_Currency')][text()='GBP']"));
				sleep(2000);
				
				if(PremiumCurrency.size() == 5)
				{
					Report.LogInfo("PremiumCurrency", "Premium Currency is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("PremiumCurrency", "Premium Currency is Displayed wrong", "FAIL");
				}
				sleep(1000);	
				String GrossPremium ="@xpath=//th[text()='Gross Premium']";
				String NetPremium ="@xpath=//th[text()='Net Premium']";
				mouseOverAction(GrossPremium);
				List<WebElement> RiskCurrency = webDriver.findElements(By.xpath("//*[@id='notification']//following::td[contains(@ng-click,'Risk_Currency')][text()='GBP']"));
				sleep(2000);
				if(RiskCurrency.size() == 5)
				{
					Report.LogInfo("RiskCurrency", "Risk Currency is Displayed properly", "PASS");
				}
				else
				{
					Report.LogInfo("RiskCurrency", "Risk Currency is Displayed wrong", "FAIL");
				}
				sleep(1000);	
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true) {
					AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
			        deleteBorderEAUX(); 
		}else
			{
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
			}
				//deleteBorderEAUX();
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}
		else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}

	}

	//3728 Advanced Options
	public void advancedOption() throws Exception
	{
		String SubmitSheet="Inherit from above";
		homePage.adminMenu();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		String subSheet = "Automation Risk Format 10 (Lloyd's Property Schema)";
		waitForElementToAppear(SignedBtn,8);
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			try
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3728Path = fpath+"\\src\\test\\resources\\testdata\\Period_of_cover_3728.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//StringSelection IdentificationSheet = new StringSelection(sheet3451Path);
			//UploadFile(IdentificationSheet);
			File excelFile = new File(sheet3728Path);
			
			String Ufname = "S15784520180428.xlsx";	
			int size = 17722;
			String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			
			// payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Period_of_cover_3728.xlsx\",\"UniqueFileName\":\"S15784520180428.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15784520180428.xlsx\",\"Filesize\":17722,\"Path\":null,\"size\":17722,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)== true){
				Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
				openDATALink();
				navigateToDATARiskTab();
				//Gross Premium locators
				String GrossPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String GrossPremium1 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[1]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium2 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[2]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium3 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[3]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium4 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[4]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				String GrossPremium5 ="@xpath=//*[@data-field='Gross_Premium']//following::tr[5]//td[contains(@ng-click,'Gross_Premium')][2][text()='100.00']";
				waitForElementToAppear(GrossPremiumColumn,8);
				mouseOverAction(GrossPremiumColumn);
				verifyMustExists(GrossPremiumColumn,"Gross Premium Column");
				sleep(2000);
				verifyExists(GrossPremium1,"1st value");
				GP1 = getTextFrom(GrossPremium1);
				Report.LogInfo("1st value", GrossPremium1, "PASS");
				verifyExists(GrossPremium2,"2nd value");
				GP2 = getTextFrom(GrossPremium2);
				Report.LogInfo("2nd value", GrossPremium2, "PASS");
				verifyExists(GrossPremium3,"3rd value");
				GP3 = getTextFrom(GrossPremium3);
				Report.LogInfo("3rd value", GrossPremium3, "PASS");
				verifyExists(GrossPremium4,"4th value");
				GP4 = getTextFrom(GrossPremium4);
				Report.LogInfo("4th value", GrossPremium4, "PASS");
				verifyExists(GrossPremium5,"5th value");
				GP5 = getTextFrom(GrossPremium5);
				Report.LogInfo("5th value", GrossPremium5, "PASS");
				sleep(2000);
				String TransationType2Row ="@xpath=//*[@data-field='Transaction_Type']//following::tr[2]//td[contains(@ng-click,'Transaction_Type')]";
				waitForElementToAppear(TransationType2Row,8);
				verifyExists(TransationType2Row,"Renewal value");
				verifyBackground(TransationType2Row,"rgba(0, 97, 0, 1)");
				sleep(2000);
				click(TransationType2Row,"Transation Type");
				String TransactionTypePopUp="@xpath=//*[@name='form.Enrichment']/preceding-sibling::h2";
				String RuleNameField="@xpath=//*[@ng-repeat='item in NewBCellEnrich']//td[6]";
				String OKbtn="@xpath=//*[@ng-click='cancel()']";
				if(isVisible(TransactionTypePopUp)== true){
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up displayed", "PASS");
					waitForElementToAppear(RuleNameField,8);
					verifyMustExists(RuleNameField,"Rule Name Field");
					verifyMustExists(OKbtn,"Ok Button");
					click(OKbtn,"Ok Button");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up not displayed", "Fail");	
				}
				//Net Premium locators
				String NetPremiumColumn ="@xpath=//*[@data-field='Gross_Premium']";
				String NetPremium1 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='212.10']";
				String NetPremium2 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='326.80']";
				String NetPremium3 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='8,755.00']";
				String NetPremium4 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='9,765.20']";
				String NetPremium5 ="@xpath=//*[@data-field='Net_Premium']//following::tr[1]//td[contains(@ng-click,'Net_Premium')][1][text()='24.50']";
				waitForElementToAppear(NetPremiumColumn,8);
				mouseOverAction(NetPremiumColumn);
				verifyMustExists(NetPremiumColumn,"Net Premium Column");
				sleep(2000);
				verifyExists(NetPremium1,"1st value");
				verifyBackground(NetPremium1,"rgba(0, 97, 0, 1)");
				sleep(2000);
				click(NetPremium1,"Net Premium 1 value");
				String NetPremiumPopUp="@xpath=//*[@name='form.Enrichment']/preceding-sibling::h2";
				if(isVisible(NetPremiumPopUp)== true){
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up displayed", "PASS");
					waitForElementToAppear(RuleNameField,8);
					verifyMustExists(RuleNameField,"Rule Name Field");
					verifyMustExists(OKbtn,"Ok Button");
					click(OKbtn,"Ok Button");
					sleep(2000);	
				}else{
					Report.LogInfo("ValidateTransactionType","TransactionType pop Up not displayed", "Fail");	
				}
				policy.navigationOnBordereauxTab();
				refreshUploadedFile();
				if(isVisible(ReviewBtn)==true) {
					AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
			        deleteBorderEAUX(); 
		}else
			{
				Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
			}
				//deleteBorderEAUX();
			}else{
				Report.LogInfo("reviewbuttonvalidation", "review Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}
	
	public void MultiContractbordereaux_TC5282() throws Exception
	{
		BProcessingRiskPremiumClaimPage BPRiskandPreClaim = new BProcessingRiskPremiumClaimPage();
		BordereauProcessPage BorProc = new  BordereauProcessPage();
			  String UniqueReferenceVal1 = "Automation 0145"+getCurrentDateTimeMS();
			  String UniqueReferenceVal2 = "Automation 0142"+getCurrentDateTimeMS();
			  String IncDate = "01/01/2017";
			  String ExpDate="31/12/2017";
			  String IncDate1 = "01/01/2018";
			  String ExpDate1="31/12/2018";
			  String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			  String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			  String subSheet = "Automation Risk Format 10";
			  homePage.adminMenu();
			  BQPage.bordereauQueLink();
			  BQPage.bordereauQuePage();
			  BQPage.filterBordereauQuestionnaire1(subSheet);
			  sleep(2000);
			  waitForElementToAppear(BQPage.EditBtn,5);
			  verifyMustExists(BQPage.EditBtn,"Edit button");
			  click(BQPage.EditBtn,"Edit button");
			  BQPage.nextStapeClick();
			  BQPage.FormatId = ReturnFormatID();
			  
			  policy.CreateContractwithInceptionDate2018();
			 
			  applyFilterPolicy(policy.PolicyNumber);
			  openSelectedPolicy();
			  policy.addSection2("Section_2_17","10","Property D&F (US binder)","GBP - British Pound","10","10","10","Low");
			  //policy.navigateToSectionTab2();
			  policy.navigateToRiskCodesTabOnSection();
			  policy.addRiskCodesOnSection2("D8 - Transactional Liability insurance Incl. US","100");
			  policy.navigateToMarketsTabOnSection();
			  policy.addMarketOnSection();
			  policy.navigateToContractDetailsTab();
			  waitForElementToAppear(MainEditdot,3);
			  verifyMustExists(MainEditdot,"Edit dot");
			  click(MainEditdot,"Edit dot");
			  waitForElementToAppear(CreateContract,3);
			  verifyMustExists(CreateContract,"Create Contract");
			  click(CreateContract,"Create Contract");
			  sleep(2000);
			  policy.CreateContractwith2017();
			  scrollUp();
			  policy.addSection2("Section_2_18","10","Property D&F (US binder)","GBP - British Pound","10","10","10","Low");
			  policy.navigateToRiskCodesTabOnSection();
			  policy.addRiskCodesOnSection2("2T - OVERSEAS LEG TERRORISM AVIATION","100");
			  policy.navigateToMarketsTabOnSection();
			  policy.addMarketOnSection();
			 
			  waitForElementToAppear(SelectDropDownforContract,3);
				verifyMustExists(SelectDropDownforContract,"Create Contract");
				click(SelectDropDownforContract,"Create Contract");
				
				waitForElementToAppear(SelectContract,3);
				verifyMustExists(SelectContract,"Create Contract");
				click(SelectContract,"Create Contract");
				policy.navigationOnBordereauxTab();
				SubmitBordereaux(subSheet);
				//String payload  ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_5282.xlsx\",\"UniqueFileName\":\"S73623320180507.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73623320180507.xlsx\",\"Filesize\":25112,\"Path\":null,\"size\":25112,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					SheetPath5282 = fpath+"\\src\\test\\resources\\testdata\\January 2017_5282.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				File excelFile = new File(SheetPath5282);
				String Ufname = "S93567520181004.xlsx";	
				int size = 25112;
				String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
		        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
		        String ID = extractIDFromResponseinsideContract(response); 
		        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
		        addAsDraft(payload,DraftUrl);
				//uploadFile(ReqUrl, excelFile, payload, DraftUrl);

				refreshUploadedFile();
				if(checkErrorReviewButton(ReviewError)== true)
				{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(2000);
					if(isVisible(TransformationErrorScreen)== true){
					    Report.LogInfo("ValidateExpectedScreen", "Expected Error Screen Displayed", "PASS");
					    verifyMustExists(TransformationErrorScreen,"Transformation Error Screen");
					    TransformationScreen = getTextFrom(TransformationErrorScreen);
						Report.LogInfo("Transformation Error Screen",TransformationScreen, "PASS");
						verifyMustExists(UMRWrdVerify,"Verify UMR in Error Screen");
						Report.LogInfo("UMR is verified on Error Screen","Unique Market Reference","PASS");
						sleep(1000);
						verifyMustExists(UMRMultiValue,"Verify Multi Contract UMR");
						Report.LogInfo("UMR value is verified on Error Screen","Unique Market Reference value","PASS");
					    waitForElementToAppear(YesBtn,3);
					    click(YesBtn,"Yes Radio button");
					    sleep(2000);
					    waitForElementToAppear(ContinueProcessingBodrBtn,3);
					    verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
					    click(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
					    refreshUploadedFile();
					}
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
						click(ReviewBtn,"Review Button");
						sleep(3000);
						waitForElementToAppear(SuRcdAssmnt,10);
						verifyMustExists(SuRcdAssmnt,"Submit recor for Assignment button");
						click(SuRcdAssmnt,"Submit recor for Assignment button");
						sleep(2000);
						if(isVisible(SectionAssignmentRuleScreenFor2017)==true){
							SectionAssig1 = getTextFrom(SectionAssignmentRuleScreenFor2017);
							Report.LogInfo("Section Assignment Rule Screen For2017 displayed", SectionAssig1, "PASS");
							Report.LogInfo("ValidateScreen", "Expected screen page displayed.", "PASS");
							verifyMustExists(UMRWrdVerify,"Verify UMR in Error Screen");
							Report.LogInfo("UMR is verified on Error Screen","Unique Market Reference","PASS");
							sleep(1000);
							verifyMustExists(UMRMultiValue,"Verify Multi Contract UMR");
							Report.LogInfo("UMR value is verified on Error Screen","Unique Market Reference value","PASS");
							sleep(1000);
							verifyMustExists(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,"Verify Bordereau Assignment Drop Down");
							javaScriptclick(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,"Click Borderea Assignment Drop Down");
							sleep(1000);
							verifyMustExists(BPRiskandPreClaim.BordereauAssignmentSectionDropDwnOption,"Verify Bordereau Assignment Value");
							javaScriptclick(BPRiskandPreClaim.BordereauAssignmentSectionDropDwnOption,"Select Bordereau Assignment Value");
							//SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BPRiskandPreClaim.BordereauAssignmentSectionDropDwnOption);
							sleep(1000);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							
							SelectDropDownValue(SectionIdDropDwn1,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn2,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn3,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn4,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn5,SectionIdDropDwnOption2);
							
							verifyMustExists(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							CompleteAssig = getTextFrom(BPRiskandPreClaim.CompleteAssignmentBtn);
							Report.LogInfo("Complete Assignment button",CompleteAssig, "PASS");
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							sleep(2000);
							
							verifyMustExists(RiskCodeRuleScreen2017,"Risk Code Rule Screen 2017");
							RiskAssign1 = getTextFrom(RiskCodeRuleScreen2017);
							Report.LogInfo("Risk code Assignment Rule Screen For2017 displayed", RiskAssign1, "PASS");
							
							SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BordereauAssignmentSectionDropDwnOptionRiskCode);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							scrollDown();
							SelectDropDownValue(SectionIdDropDwn1Risk1,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk2,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk3,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk4,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk5,BPRiskandPreClaim.SectionIdDropDwnOption1);
							
							sleep(2000);
							verifyMustExists(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							
							verifyMustExists(SectionAssignmentRuleScreenFor2018,"Section Assignment Rule Screen 2018");
							SectionAssig2 = getTextFrom(SectionAssignmentRuleScreenFor2018);
							Report.LogInfo("Section Assignment Rule Screen For2018 displayed", SectionAssig2, "PASS");
							
							SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BPRiskandPreClaim. BordereauAssignmentSectionDropDwnOption);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							scrollDown();
							SelectDropDownValue(SectionIdDropDwn1,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn2,SectionIdDropDwnOption2);
							SelectDropDownValue(SectionIdDropDwn3,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn4,SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn5,SectionIdDropDwnOption1);
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							sleep(2000);
							
							verifyMustExists(RiskCodeRuleScreen2018,"Risk Code Rule Screen 2018");
							RiskAssign2 = getTextFrom(RiskCodeRuleScreen2018);
							Report.LogInfo("Risk code Assignment Rule Screen For2018 displayed", RiskAssign2, "PASS");
							
							SelectDropDownValue(BPRiskandPreClaim.BordereauAssignmentSectionDropDwn,BordereauAssignmentSectionDropDwnOptionRiskCode);
							BPRiskandPreClaim.SetMapping("Risk Reference");
							if(isVisible(BPRiskandPreClaim.SetMappingRuleButton)==true){
								click(BPRiskandPreClaim.SetMappingRuleButton,"SetMappingRuleButton");
							}
							else{
								click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");
							}
							scrollDown();
							SelectDropDownValue(SectionIdDropDwn1Risk1,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk2,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk3,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk4,BPRiskandPreClaim.SectionIdDropDwnOption1);
							SelectDropDownValue(SectionIdDropDwn1Risk5,BPRiskandPreClaim.SectionIdDropDwnOption1);
							sleep(2000);
							click(BPRiskandPreClaim.CompleteAssignmentBtn,"Complete Assignment button");	
							sleep(2000);
							waitForElementToAppear(BorProc.FrApprovalbtn,10);
							verifyMustExists(BorProc.FrApprovalbtn,"For Approval button");
							click(BorProc.FrApprovalbtn,"For Approval button");
							//BorProc.refreshUploadedFileForApprovalStatus();
							BorProc.clickOnApproveBordBtn();
							BorProc.refreshUploadedFileApprovedStatus();

						}else{
							Report.LogInfo("ValidateScreen", "Expected screen page not displayed.", "FAIL");
						}
					}
						//deleteBorderEAUX();
					
				}else{
					Report.LogInfo("ReviewStatusValidation", "Review Status Button not displayed.", "FAIL");
					deleteBorderEAUX();
					//VerifyNotificationPopupAfterUpload();
				}
			  
	}


	//--------------------------SequenceRule-------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------//

	// TC_3448
	public String ErrorScreenVerification;
	public String verifyButtonText;
	public void AnotherBordereauSamePeriodNotYetApproved() throws Exception{
		String UnderlineVal = "Childs, Andy";
		String StatusValue="Uploaded";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.CreateContractwithInceptionDate2018();
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		SubmitBordereauxWithYesnoButtons1();

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3448Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3448.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet3448Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S32948920180603.xlsx";	
		int size = 22626;
		String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
        
		refreshUploadedFile();
		sleep(2000);
	
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		
        String response2 = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID2 = extractIDFromResponseinsideContract(response2); 
        String payload2 = GeneratePayloadForContract(contractId, BordreauID, ID2, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload2,DraftUrl);
        
	
			
		refreshAfterUploadedFileForReviewSatusAndUploadStatus();
		if(checkErrorReviewButton(ReviewError)==true){
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed", "PASS");
			verifyMustExists(ErrorScreen5,"Another bordereau of the same period is not yet approved");
       ErrorScreenVerification = getTextFrom(ErrorScreen5);

			if(isVisible(CancelStatusAndLeaveUploadingStatusButton)==true){
				Report.LogInfo("ValidateUploadedStatus", "Another bordereau of the same period is not yet approved Page opened ", "PASS");
				waitForElementToAppear(CancelStatusAndLeaveUploadingStatusButton,3);
				verifyMustExists(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
				verifyButtonText = getTextFrom(CancelStatusAndLeaveUploadingStatusButton);
				click(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
				
				sleep(2000);
				refreshAfterUploadedFileForReviewSatusAndUploadStatus();
				if(isVisible(UploadedButton)==true){
					AssertBordereauStatusUploaded = getTextFrom(UploadedButton);
					Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
					uploadedDeleteButton(StatusValue);
				}else{
					Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
					//deleteBorderEAUX();
				}

			}else{
				Report.LogInfo("ValidateUploadedStatus", "Another bordereau of the same period is not yet approved Page not opened ", "FAIL");
				goBack();				
			}
		}else{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed", "FAIL");
			//deleteBorderEAUX();
		}
	}

	// TC-3449


	public void PreviousBordereauNotYetApproved() throws Exception{
		String OnlySpPoliCyNum = "674931TI";

		String StatusValue="Uploaded";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";


		//loginPage.tideLogin();
		sleep(3000);
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons1();

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3449Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3449.xlsx";
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
			File excelFile = new File(sheet3449Path);  
			String Ufname = "S71597820180603.xlsx";	
			int size = 23340;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 2 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
			sleep(2000);
			refreshAfterUploadedFileForReviewSatusAndUploadStatus();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed", "PASS");
				  ErrorScreenVerification = getTextFrom(ErrorScreen3);
				if(isVisible(CancelStatusAndLeaveUploadingStatusButton)==true){
					Report.LogInfo("ValidatePreviousBordereauNotApprovedPage", "Previous bordereau not Approved page opened ", "PASS");
					waitForElementToAppear(CancelStatusAndLeaveUploadingStatusButton,3);
					verifyMustExists(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
					verifyButtonText = getTextFrom(CancelStatusAndLeaveUploadingStatusButton);
					click(CancelStatusAndLeaveUploadingStatusButton,"CancelStatusAndLeaveUploadingStatusButton");
					refreshAfterUploadedFileForReviewSatusAndUploadStatus();
					if(isVisible(UploadedButton)==true){
						AssertBordereauStatusUploaded = getTextFrom(UploadedButton);
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
						uploadedDeleteButton(StatusValue);
					}else{
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
					}

				}else{
					Report.LogInfo("ValidatePreviousBordereau", "Previous bordereau not Approved page not opened ", "FAIL");
					goBack();

				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed", "FAIL");

			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}
	}


	// TC-3450 - START
public String PauseBtnText;
public String ErrorScreenText;
	public void BordereauPeriodPriorToContractInception() throws Exception{
		String OnlySpPoliCyNum = "674931TI";
		String StatusValue="Review Errors";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereauxWithYesnoButtons1();
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3450Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC3450.xlsx";
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
			File excelFile = new File(sheet3450Path);  
			
			contractId = addNewBordereauFormatPolicy(payload1, GetData);	
		
			String Ufname = "S32948920180603.xlsx";	
			int size = 22626;
			String BordreauID = "27059303-902c-48ef-98cb-884977aea619";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 12 , "1", 2017);
	        addAsDraft(payload,DraftUrl);
	        
			
			sleep(2000);
			refreshAfterUploadedFileForReviewSatusAndUploadStatus();
			AssertBordereauStatusReviewError = getTextFrom(ReviewError);
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed", "PASS");
			
				if(isVisible(pauseButton)==true){
					Report.LogInfo("ValidateApprovedPage", "Previous bordereau not Approved page opened ", "PASS");
					waitForElementToAppear(pauseButton,3);
					verifyMustExists(pauseButton,"CancelStatusAndLeaveUploadingStatusButton");
					PauseBtnText = getTextFrom(pauseButton);
					ErrorScreenText = getTextFrom(ErrorScreen8);
					click(pauseButton,"CancelStatusAndLeaveUploadingStatusButton");
					refreshAfterUploadedFileForReviewSatusAndUploadStatus();
					if(isVisible(ReviewError)==true){
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
						
					}else{
						Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
					}

				}else{
					Report.LogInfo("ValidatePreviousBordereau", "Previous bordereau not Approved page not opened ", "FAIL");
					goBack();

				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed", "FAIL");

			}
		}else{
			Report.LogInfo("PolicyStatus", "Policy status not displayed as signed.", "FAIL");
			policy.changeStatusToSigned();
		}

	}

	public static final String ContinueProcessingBtn1 ="@xpath=//button[contains(.,'Process Bordereau')]";
	private static final String Status = null;

	public void  newcolumnsidentified_4470() throws Exception
	{
		String RiskSchemaName = "New column Identified schema";
		//String RiskSchemaName = "kruthika test schema";
		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		QuePage.sheetProcessingFirstSheet5(RiskSchemaName,QueName);
		String subSheet=QueName;
		String IncDate ="01/01/2018";
		String ExpDate="01/01/2019";
		String MonthDate="February 2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateContractwithInceptionDate2018();
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4470Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_4470.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4470Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);			
			String Ufname = "S46991920180929.xlsx";	
			int size = 17781;
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, QuePage.BFormatId, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);

			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_4470.xlsx\",\"UniqueFileName\":\"S60793720180611.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S60793720180611.xlsx\",\"Filesize\":17781,\"Path\":null,\"size\":17781,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(3000);	
				verifyMustExists(NewColumnIdentifided,"New Column Identifided screen");
		    	NewColumnscreen =  getTextFrom(NewColumnIdentifided);	
				Report.LogInfo("New Column Identifided screen is open", NewColumnscreen, "PASS");
				if(isVisible(ContinueProcessingbtn)==true){
					verifyMustExists(Pausebtn,"Pause  button");
					click(Pausebtn,"Pause  button");
					
					if(checkErrorReviewButton(ReviewError)==true){
						Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					
					verifyMustExists(ContinueProcessingbtn,"Continue Processing button");
					click(ContinueProcessingbtn,"Continue Processing button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						click(ReviewBtn,"Reviwe button");
						waitForElementToAppear(SuRcdAssmnt,10);
						verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
						click(SuRcdAssmnt,"Submit record assesment button");
						waitForElementToAppear(FrApprovalbtn,10);
						verifyMustExists(FrApprovalbtn,"For Approval button");
						click(FrApprovalbtn,"For Approval button");
						clickOnApproveBordBtn();
						refreshUploadedFileForApproved();
						if(isVisible(Approvedbtn)==true)
						{
							AssertBordereauStatusApproved =  getTextFrom(Approvedbtn);	
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed", "PASS");
							SubmitBordereauxWithYesnoButtons(MonthDate);
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4470SecondPath = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_4470second.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile1 = new File(sheet4470SecondPath);
							
							String Ufname1 = "S60156120180929.xlsx";	
							int size1 = 17797;
					        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
					        String ID1 = extractIDFromResponseinsideContract(response1); 
					        String payload2 = GeneratePayloadForContract(contractId, QuePage.BFormatId, ID1, Ufname1, size1, 2 , "1", 2018);
					        addAsDraft(payload2,DraftUrl);
					        
							//String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_4470second.xlsx\",\"UniqueFileName\":\"S70121820180611.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S70121820180611.xlsx\",\"Filesize\":17797,\"Path\":null,\"size\":17797,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
							refreshUploadedFile();
							if(isVisible(ReviewBtn)==true){
								AssertBordereauStatusReview =  getTextFrom(ReviewBtn);
								Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
								homePage.adminMenu();
								QuePage.bordereauQueLink();
								QuePage.bordereauQuePage();
								String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+QueName+"')][1]";
								sleep(2000);
								QuePage.filterBordereauQuestionnaire(QueName, SelectQuestionnaire);
								//BQPage.filterBordereauQuestionnaire1(QueName);
								waitForElementToAppear(QuePage.EditBtn,5);
								verifyMustExists(QuePage.EditBtn,"Edit button");
								click(QuePage.EditBtn,"Edit button");
								waitForElementToAppear(QuePage.nextStepBtn,5);
								QuePage.gotostep11();
								waitForElementToAppear(columnTab,5);
								verifyMustExists(columnTab,"Column Field");
								verifyMustExists(Cancelbtn1,"Cancel button");
								click(Cancelbtn1,"Edit button");	
							}else{
								Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");		
							}	
						}else{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
				}
				else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
					deleteBorderEAUX();
				}	
			}
			else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}	
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}	
	}

	public void newColumnsIdentified_4472() throws Exception{
		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(QueName);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		verifyMustExists(Version,"version number");
		version1= getTextFrom(Version,"version number");
		if(version1.equals("1"))
		{
			Report.LogInfo("ValidateVersion", "First version validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateVersion", "First version validate successfully", "Fail");
		}
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		String IncDate = "01/01/2018";
		String ExpDate = "01/01/2019";
		String subSheet1=QueName;
		
		policy.CreateContractwithInceptionDate2018();
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)==true){
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			SubmitBordereaux(subSheet1);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4472Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_4472.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4472Path);  
			policy.contractId = addNewBordereauFormatPolicy(payload1, GetData); 
			
			String Ufname = "S49266020180929.xlsx";	
			int size = 17829;
	        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(policy.contractId, BQPage.FormatId, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_4472.xlsx\",\"UniqueFileName\":\"S78189420180611.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S78189420180611.xlsx\",\"Filesize\":17829,\"Path\":null,\"size\":17829,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError) == true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				NewColumnscreen =  getTextFrom(NewColumnIdentifided);	
				Report.LogInfo("New Column Identifided screen is open", NewColumnscreen, "PASS");
				if(isVisible(EditQuestionNairebtn)== true){
					verifyMustExists(EditQuestionNairebtn,"EditQuestionnaire button");
					click(EditQuestionNairebtn,"EditQuestionnaire button");
					sleep(3000);
					QuePage.waitForElementToAppear(QuePage.nextStepBtn,5);
					QuePage.gotostep11();
					sleep(2000);
					String Test1RemoveIcon="@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/span//i";
					click(Test1RemoveIcon,"contents Remove Icon");
					String Test1Drag="@xpath=//button[contains(.,'Test1')]";
					String BuildingsValueDrop = "@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/div";
					String Test2RemoveIcon="@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/span//i";
					click(Test2RemoveIcon,"contents Remove Icon");
					sleep(2000);	
					String Test2Drag="@xpath=//button[contains(.,'Test2')]";
					String ContentsDrop = "@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/div";
					dragDropElement(Test1Drag,BuildingsValueDrop);
					sleep(1000);
					dragDropElement(Test2Drag,ContentsDrop);
					sleep(1000);
					
					QuePage.nextStapeClick();
					waitForElementToAppear(SaveAndReprocessBtn,8);
					verifyMustExists(SaveAndReprocessBtn,"Save And Reprocess button");
					click(SaveAndReprocessBtn,"Save And Reprocess button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview =  getTextFrom(ReviewBtn);
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						homePage.adminMenu();
						BQPage.bordereauQueLink();
						BQPage.bordereauQuePage();
						sleep(3000);
						BQPage.filterBordereauQuestionnaire1(QueName);
						waitForElementToAppear(BQPage.EditBtn,5);
						verifyMustExists(BQPage.EditBtn,"Edit button");
						verifyMustExists(Version,"version number");
						version2= getTextFrom(Version,"version number");
						if(version2.equals("2"))
						{
							Report.LogInfo("ValidateVersion", "Second version validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateVersion", "Second version validate successfully", "Fail");
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}	
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}	
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void expectedColumnsMissing_4473() throws Exception{

		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String IncDate = "01/01/2018";
		String ExpDate = "01/01/2019";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(subSheet);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4473Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_4473.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4473Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			String Ufname = "S52759920181001.xlsx";	
			int size = 17775;
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BQPage.FormatId, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_4473.xlsx\",\"UniqueFileName\":\"S49325420180611.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S49325420180611.xlsx\",\"Filesize\":17775,\"Path\":null,\"size\":17775,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				verifyExists(MissingColumns,"Missing Columns screen validate");
				MissingColumnsscreen =  getTextFrom(MissingColumns);	
				Report.LogInfo("Missing Columns screen is open", MissingColumnsscreen, "PASS");
				sleep(3000);
				
				verifyMustExists(Pausebtn," Pause button");
				click(Pausebtn,"Pause  button");
				
				if(checkErrorReviewButton(ReviewError)==true){
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(3000);
				if(isVisible(ContinuebtnOnErrorScreen)==true){
					sleep(3000);
					verifyMustExists(ContinuebtnOnErrorScreen,"Continue Processing button");
					click(ContinuebtnOnErrorScreen,"Continue Processing button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview =  getTextFrom(ReviewBtn);
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						deleteBorderEAUX();
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
				}else{
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void oneExpectedColumnsMissing_4474() throws Exception{

		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String IncDate = "01/01/2018";
		String ExpDate = "01/01/2019";
		String MonthDate="February 2019";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(subSheet);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();
		
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4474Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_4474.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4474Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			String Ufname = "S56010520180929.xlsx";	
			int size = 17772;
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BQPage.FormatId, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_4474.xlsx\",\"UniqueFileName\":\"S29410420180611.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29410420180611.xlsx\",\"Filesize\":17772,\"Path\":null,\"size\":17772,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				MissingColumnsscreen =  getTextFrom(MissingColumns);	
				Report.LogInfo("Missing Columns screen is open", MissingColumnsscreen, "PASS");
				sleep(2000);
				if(isVisible(EditQuestionNairebtn)==true){
					verifyMustExists(EditQuestionNairebtn,"Continue Processing button");
					EditQuestionnair =  getTextFrom(EditQuestionNairebtn);	
					Report.LogInfo("Edit Questionnair button is present", EditQuestionnair, "PASS");
					click(EditQuestionNairebtn,"Continue Processing button");
					sleep(2000);
					QuePage.waitForElementToAppear(QuePage.nextStepBtn,5);
					QuePage.gotostep11();
					sleep(2000);
					String Test1RemoveIcon="@xpath=//td[contains(.,'A - Buildings Value')]//preceding-sibling::td/div/span//i";
					String Test2RemoveIcon="@xpath=//td[contains(.,'C - Contents Value')]//preceding-sibling::td/div/span//i";
					click(Test1RemoveIcon,"Test 1 Remove Icon");
					sleep(1000);
					click(Test2RemoveIcon,"Test 2 Remove Icon");
					sleep(1000);
					QuePage.nextStapeClick();
					waitForElementToAppear(SaveAndReprocessBtn,8);
					verifyMustExists(SaveAndReprocessBtn,"Save And Reprocess button");
					click(SaveAndReprocessBtn,"Save And Reprocess button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview =  getTextFrom(ReviewBtn);
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						click(ReviewBtn,"Reviwe button");
						waitForElementToAppear(SuRcdAssmnt,10);
						verifyMustExists(SuRcdAssmnt,"Submit record assesment button");
						click(SuRcdAssmnt,"Submit record assesment button");
						waitForElementToAppear(FrApprovalbtn,10);
						verifyMustExists(FrApprovalbtn,"For Approval button");
						click(FrApprovalbtn,"For Approval button");
						clickOnApproveBordBtn();
						refreshUploadedFileForApproved();
						if(isVisible(Approvedbtn)==true)
						{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
							homePage.adminMenu();
							BQPage.bordereauQueLink();
							BQPage.bordereauQuePage();
							sleep(2000);
							BQPage.filterBordereauQuestionnaire1(subSheet);
							waitForElementToAppear(BQPage.EditBtn,5);
							verifyMustExists(BQPage.EditBtn,"Edit button");
							click(BQPage.EditBtn,"Edit button");
							BQPage.nextStapeClick();
							BQPage.FormatId = ReturnFormatID();
							applyFilterPolicy(policy.PolicyNumber);
							openSelectedPolicy();
							SubmitBordereauxWithYesnoButtons(MonthDate);
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4474SecondPath = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_4474Second.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile1 = new File(sheet4474SecondPath); 
							
							String Ufname1 = "S97727220180929.xlsx";	
							int size1 = 17798;
					        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
					        String ID1 = extractIDFromResponseinsideContract(response1); 
					        String payload2 = GeneratePayloadForContract(contractId, BQPage.FormatId, ID1, Ufname1, size1, 2 , "1", 2018);
					        addAsDraft(payload2,DraftUrl);
					        
							//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_4474Second.xlsx\",\"UniqueFileName\":\"S88043820180611.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S88043820180611.xlsx\",\"Filesize\":17798,\"Path\":null,\"size\":17798,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							//uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
							refreshUploadedFile();
							if(isVisible(ReviewBtn)==true){
								Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
							}else{
								Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
							}			
						}else{
							Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}


	public void downloadBordereaufile_4481() throws Exception{

		PolicyPage policy = new PolicyPage();
		BordereauQuePage QuePage = new BordereauQuePage();
		String IncDate = "01/01/2018";
		String ExpDate = "01/01/2019";
		String subSheet=QueName;
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		sleep(2000);
		BQPage.filterBordereauQuestionnaire1(subSheet);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		verifyMustExists(Version,"version number");
		String version3= getTextFrom(Version,"version number");
		if(version3.equals("3"))
		{
			Report.LogInfo("ValidateVersion", "Third version validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateVersion", "Third version validate successfully", "Fail");
		}
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");
			SubmitBordereaux(subSheet);	
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4481Path = fpath+"\\src\\test\\resources\\testdata\\January 2018_TC_4481.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4481Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			String Ufname = "S14764120180929.xlsx";	
			int size = 17878;
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BQPage.FormatId, ID, Ufname, size, 1 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_TC_4481.xlsx\",\"UniqueFileName\":\"S43118720180611.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S43118720180611.xlsx\",\"Filesize\":17878,\"Path\":null,\"size\":17878,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(checkErrorReviewButton(ReviewError)==true){
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				NewColumnscreen =  getTextFrom(NewColumnIdentifided);	
				Report.LogInfo("New Column Identifided screen is open", NewColumnscreen, "PASS");
				sleep(3000);
				if(isVisible(DownloadBorderEAU)==true){
					verifyMustExists(DownloadBorderEAU,"Download Bordereau button");
					DownloadBorderButton =  getTextFrom(DownloadBorderEAU);	
					Report.LogInfo("Download Bordereau button", DownloadBorderButton, "PASS");
					if(isEnable(DownloadBorderEAU)==true){		
						Report.LogInfo("ValidateDownloadBordereau", "Download Bordereau button is Enable", "PASS");
					}
					else
					{
						Report.LogInfo("ValidateDownloadBordereau", "Download Bordereau button is not Enable", "FAIL");	
					}
					waitForElementToAppear(TideField,3);
					SelectDropDownValue(TideField,ContentsValue);
					verifyMustExists(ContinueProcessingbtn,"Continue Processing button");
					click(ContinueProcessingbtn,"Continue Processing button");
					refreshUploadedFile();
					if(isVisible(ReviewBtn)==true){
						AssertBordereauStatusReview =  getTextFrom(ReviewBtn);
						Report.LogInfo("ValidateReviewStatus", "Review status displayed.", "PASS");
						homePage.adminMenu();
						BQPage.bordereauQueLink();
						BQPage.bordereauQuePage();
						sleep(2000);
						BQPage.filterBordereauQuestionnaire1(subSheet);
						waitForElementToAppear(BQPage.EditBtn,5);
						verifyMustExists(BQPage.EditBtn,"Edit button");
						verifyMustExists(Version,"version number");
						String version4= getTextFrom(Version,"version number");
						if(version4.equals("4"))
						{
							Report.LogInfo("ValidateVersion", "fourth version validate successfully", "PASS");	
						}
						else
						{
							Report.LogInfo("ValidateVersion", "Fourth version validate successfully", "Fail");
						}	
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "Fail");
					}		
				}else{
					Report.LogInfo("ValidateErrrorScreen", "expected Error Screen Not Displayed", "FAIL");
					goBack();
					deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("Signedbuttonvalidation", "Signed Button not Displayed", "FAIL");
		}
	}
	//---------FEATURE- Date Format Not Identified----START--------------------------------------------------------//
	//_____________________________________________________DateFormat-TC-3500-START___________________________//

	public void  DataFormatNotIdentified () throws Exception{
		String OnlySpPoliCyNum = "579652YC";
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		String UnderlineVal = "Childs, Andy";
		String SubmitSheet = "SP - First Sheet (Automation Schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";

		policy.addPolicy2(IncDate,ExpDate);
		verifyExists(DraftBtn,"Draft Status Button");
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		policy.changeStatusToSignedWithClaim();
		//TC 3532
		BQPage.addBordereauFormatClaim();
		String SubSheet = BQPage.ClaimBordereauText;
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(SubSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn, 5);
		verifyMustExists(BQPage.EditBtn, "Edit button");
		click(BQPage.EditBtn, "Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(SubSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3500Path = fpath+"\\src\\test\\resources\\testdata\\Jan-All sheets_TC3500.xlsx";
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		File excelFile = new File(sheet3500Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan-All sheets_TC3500.xlsx\",\"UniqueFileName\":\"S51792820180115.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S51792820180115.xlsx\",\"Filesize\":14102,\"Path\":null,\"size\":14102,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";

		uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(ReviewBtn,"Review button");
			openDATALink();
			navigateToDATAClaimTab();
			//Verify Inception date format
			String RiskInceptionDatecolumn="@xpath=//*[@data-field='RiskInceptionDate']";
			String RiskInceptionDate1="@xpath=//*[@data-field='RiskInceptionDate']//following::tr[1]//td[contains(@ng-click,'RiskInceptionDate')][text()='01/01/2017']";
			waitForElementToAppear(RiskInceptionDatecolumn,20);
			mouseOverAction(RiskInceptionDatecolumn);
			verifyMustExists(RiskInceptionDatecolumn,"Risk Inception Date column");
			sleep(2000);
			verifyExists(RiskInceptionDate1,"Inception Date is displayed in DD-MM-YYYY format");

			//Verify Expiry date format
			String RiskExpiryDatecolumn="@xpath=//*[@data-field='RiskExpiryDate']";
			String RiskExpiryDate1="@xpath=//*[@data-field='RiskExpiryDate']//following::tr[1]//td[contains(@ng-click,'RiskExpiryDate')][text()='28/04/2017']";
			waitForElementToAppear(RiskExpiryDatecolumn,20);
			mouseOverAction(RiskExpiryDatecolumn);
			verifyMustExists(RiskExpiryDatecolumn,"RiskExpiryDate column");
			sleep(2000);
			verifyExists(RiskExpiryDate1,"Expiry Date is displayed in DD-MM-YYYY format");
			//goBack();
			policy.navigationOnBordereauxTab();
			deleteBorderEAUX();

		}else{

			Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
			deleteBorderEAUX();
		}
	}

	//---------FEATURE- Date Format Not Identified----END--------------------------------------------------------//

	//============================================Renewal (Y/N) from Transaction Type =============================================================//


	public void renewalYNTransactionType_January_3759() throws Exception{
		String subSheet = "SP - First Sheet (Automation Schema)";
		String UniqueReferenceVal1 = "Automation Policy"+getCurrentDateTimeMS1();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String SubmitSheet="Automation Company Admin 1 Risk Format 2";
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
		policy.navigationOnPolicyTab();
		policy.CreateContractwithInceptionDate2018();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		SubmitBordereaux(subSheet);	
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3759PathFirst = fpath+"\\src\\test\\resources\\testdata\\Renewal_jan_3759First.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile1 = new File(sheet3759PathFirst);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Renewal_jan_3759First.xlsx\",\"UniqueFileName\":\"S20964320180612.xlsx\",\"BordereauFormatId\":\"b79e0d00-3952-4dc6-9821-c2b7fc5bbe33\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S20964320180612.xlsx\",\"Filesize\":17754,\"Path\":null,\"size\":17754,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		uploadFile(ReqUrl, excelFile1, payload2, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)==true){
			navigateToDATATab();
			navigateToDATARiskTab();
			String RenevalFirst = "@xpath=//tr[1]//td[contains(@ng-click,'IsRenewal')][text()='Yes']";
			String RuleName = "@xpath=//td//div[text()='New/Renewal (Y/N) completed based on the first Transaction Type reported for the risk.']";
			String Okbtn = "@xpath=//div[@ng-click='cancel()']";
			waitForElementToAppear(RenevalFirst,5);
			verifyExists(RenevalFirst,"Renewal Y/N first record");
			click(RenevalFirst,"Renewal Y/N first record");
			sleep(2000);
			waitForElementToAppear(RuleName,5);
			verifyExists(RuleName,"Rule name");
			waitForElementToAppear(Okbtn,5);
			verifyExists(Okbtn,"Ok button");
			click(Okbtn,"Ok button");
			sleep(2000);
		}else{
			Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
		}

		SubmitBordereaux(subSheet);	
	}

	public void mappingCount_3761() throws Exception{
		String OriginalValueName="Endorsement";		
		homePage.adminMenu();
		datasetPage.DatasetReferenceDataLink();
		datasetPage.DatasetReferenceDatapage();
		
		applyReferenceDataFilter("Boolean (Inclusion)");
		applyDataSetFilter("Risk");
		waitForElementToAppear(BooleanName,5);
		
		verifyExists(BooleanName,"Boolean Name");
		click(BooleanName,"Boolean Name");
		datasetPage.selectMappingsTab();
		datasetPage.applyOriginalNameFilter(OriginalValueName);
		waitForElementToAppear(MappingTotalCount,5);
		verifyExists(MappingTotalCount,"Mapping Total Count");
		Count = getTextFrom(MappingTotalCount);
		ActualCount = Integer.parseInt(Count);		
	}
public	String Expectedresp = "{\"ReturnData\":{\"Id\":\"00000000-0000-0000-0000-000000000000\",\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S73685620181003.xlsx\",\"UniqueFileName\":null,\"Filesize\":27136,\"Path\":null,\"size\":0,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":true,\"IsValidFileSize\":true,\"FileExtension\":0,\"IsValidFileType\":true,\"IsValidFileNameSizeLimit\":true,\"IsScanPerform\":true,\"Scanner\":{\"ScanStatus\":1,\"ScanProcessStatus\":0,\"ScanLogMessage\":\"Password Protected Document\"}},\"Status\":0,\"ReturnMessage\":[],\"Permissions\":[]}";
public String ErrorRes;
	public void PasswordProtectedFiles_3773() throws Exception
	{
		String SubmitSheet = "SP - First Sheet (Automation Schema)";
		String ReqURL = Configuration.url+"/api/FileStorage/UploadFile/1";
		policy.CreateContractwithInceptionDate2018();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(policy.SignedBtn)==true){
			SubmitBordereaux(SubmitSheet);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3773Path = fpath+"\\src\\test\\resources\\testdata\\Password_Protected_TC_3773.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			File excelFile = new File(sheet3773Path);
			String Fname = "S98501220180903.xlsx";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
	
			
			 ErrorRes = uploadFileAndCheckError(ReqURL,excelFile, Fname, contractId);
			if(Expectedresp.equalsIgnoreCase(ErrorRes))
			{
				Report.LogInfo("ErrorCheck", "Expected response message displayed", "PASS");
			}else{
				Report.LogInfo("ErrorCheck", "Expected response message not displayed", "PASS");
			}
		}
	}


	//--------------------------------------------------------------------------------------------------------------------------------------------//	
	//------------------------------------------------------- Reusable functions -----------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------------------------//	

	public void deleteBorderEAUX() {
		
		navigateOnProcessingTab();

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

	public void gotopolicy()
	{
		webDriver.navigate().refresh();
		click(PolicyHome,"Policy link");
		sleep(2000);
	}
	public void VerificationRcddCounts (int expectedCount){
		sleep(2000);

		waitForElementToAppear(ActualExpectedRowCount,5);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		int count = list.size();
		sleep(2000);
		if(count == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+count, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+count, "FAIL");
		}
		sleep(2000);
		goBack();
	}
	public int TC230Count;
	public void VerificationCounts (int expectedCount){
		sleep(2000);
		waitForElementToAppear(RiskTab,5);
		verifyMustExists(RiskTab,"Risk Tab");
		click(RiskTab,"Risk Tab");
		sleep(4000);
		waitForElementToAppear(ChangePageCountDropDn,4);
		verifyMustExists(ChangePageCountDropDn,"Change Page Count Dropdown");
		click(ChangePageCountDropDn,"Change Page Count Dropdown");
		sleep(2000);
		click(ChangePageCountTo,"Change Page Count To");
		sleep(4000);
		waitForElementToAppear(ActualExpectedRowCount,5);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		 TC230Count = list.size();
		sleep(2000);
		if(TC230Count == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+TC230Count, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+TC230Count, "FAIL");
		}
		sleep(2000);
		goBack();
	}

	public void applyFilterPolicy(String PolicyNumber) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNumber+"']";

		waitForElementToAppear(PolicyHome,5);
		verifyMustExists(PolicyHome,"Policy Link");
		click(PolicyHome,"Policy Link");
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(PolicyReferenceFilterIcon, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,PolicyNumber,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}
	
	public void applyFilterPolicy_ThankYouScreen(String PolicyNumber) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNumber+"']";
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(PolicyReferenceFilterIcon_Simplified, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,PolicyNumber,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void applyFilterPolicy1(String PolicyNumber) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+PolicyNumber+"']";

		waitForElementToAppear(PolicyHome,5);
		verifyMustExists(PolicyHome,"Policy Link");
		click(PolicyHome,"Policy Link");
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(PolicyReferenceFilterIcon, "Policy Reference Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,PolicyNumber,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<1);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void openSelectedPolicy(){
		waitForElementToAppear(SelectedPolicy,3);
		verifyMustExists(SelectedPolicy,"Selected Policy");
		click(SelectedPolicy,"Selected Policy");
		sleep(2500);
	}

	public void SubmitBordereaux(String SubmitSheet) throws Exception{
		waitForElementToAppear(BORDEREAUXLink,5);
		sleep(1500);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");
		sleep(2000);
		navigateOnProcessingTab();
		if (isVisible(BlankDetailsMsg)==true)
		{
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}else{
			sleep(2000);
			checkRecordsAndDeleteReviewError();
			sleep(2000);
			checkRecordsAndDeleteReview();
			
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}
		sleep(2000);
	}

	public void DeleteError(){
		if (isVisible(BlankDetailsMsg)==true)
		{
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}else{
			checkRecordsAndDeleteReviewError();
			sleep(2000);
			checkRecordsAndDeleteReview();
			sleep(3000);
			refreshPage();
		}
	}

	public void FilterPolicy(String PolicyNumber1FirstSheet){
		waitForElementToAppear(PolicyHome,2);
		verifyMustExists(PolicyHome,"Policy Link");
		click(PolicyHome,"Policy Link");
		verifyMustExists(PolicyReferenceFilterIcon,"Policy Reference Filter Icon");
		click(PolicyReferenceFilterIcon,"Policy Link");
		verifyMustExists(SearchText,"Search Textbox");
		sendKeys(SearchText,PolicyNumber1FirstSheet,"Search Textbox field.");
		sleep(2000);
		webDriver.findElement(By.cssSelector("[value='"+PolicyNumber1FirstSheet+"']")).click();
		sleep(2000);
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void SubmitBordereauxFirstSheet(String FirstSheet) throws Exception{
		waitForElementToAppear(BorderEAUXFirst,5);
		verifyMustExists(BorderEAUXFirst,"BorderEAUX First");
		click(BorderEAUXFirst,"BorderEAUX First");
		verifyMustExists(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		click(SubmitBordereauxDropdown,"Submit Bordereaux Dropdown");
		sleep(2000);
		verifyMustExists(SelectOptionRisk,"Select Option Risk");
		click(SelectOptionRisk,"Select Option Risk");
		sleep(2000);
		verifyMustExists(SelectNewquestionnaire,"Select New Questionnaire");
		javaScriptclick(SelectNewquestionnaire);
		sendKeys(EnterOptionToSelect,Questionnaire,"Option to select questionnaire.");
		sleep(4000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+FirstSheet+"')]")).click();
		verifyMustExists(CalenderFirstST,"Calender");
		click(CalenderFirstST,"Calender");
		sleep(4000);
		verifyMustExists(DateJan,"Date Jan");
		javaScriptclick(DateJan);
		sleep(2000);
	}

	public void UploadFile(StringSelection filePath) throws AWTException
	{
		verifyMustExists(UploadSection,"Upload File Section");
		click(UploadSection,"Upload File Section link");
		Robot robot = new Robot();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);		
	}

	public void refreshUploadedFile() throws Exception
	{
		navigateOnProcessingTab();
		sleep(2000);

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(ReviewError)==false) && (isVisible(ReviewBtn)==false) && (isVisible(UploadedBtn)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFile(String Error) throws Exception
	{
		navigateOnProcessingTab();

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(Error)==false) && (isVisible(ReviewBtn)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFileError() throws Exception
	{
		navigateOnProcessingTab();

		for(int i= 0; i<=15; i++)
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			if(isVisible(ReviewError)){
				//VerifyNotificationPopupAfterUpload();
				break;
			}
		}
	}

	public void EditSpecificText(String text){
		waitForElementToAppear(ToEditSpecificText,3);
		verifyMustExists(ToEditSpecificText,"To Edit Specific Text");
		sendKeys(ToEditSpecificText,text,"Textbox to Edit the Sheet.");
		sleep(2000);
		click(ProcessBorderEAuButton,"Process Bordereau Button");
		sleep(3000);
	}

	public void monthSelection()
	{		
		verifyMustExists(ProcessingTiem,"Processing time field");
		click(ProcessingTiem,"Processing time field");
		sleep(1000);
		verifyMustExists(May2017,"May 2017 option");
		click(May2017,"May 2017 option");
		sleep(1000);
		click(ErrorScreen,"Error Screen");
		sleep(2000);
		javaScriptclick(ProcessingTimeSecond,"Processing time field");
		sendKeys(ProcessingTimeSecond,"June 2017","Processing time field.");
		sleep(1000);
		verifyMustExists(June2017,"May 2017 option");
		click(June2017,"May 2017 option");
	}

	public void selectSheetForProcessingRadioAndDate(String year){
		verifyMustExists(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		click(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		sleep(1000);
		verifyMustExists(NoSingelContainProcessingTime,"No Singel Contain Processing Time drop down");
		click(NoSingelContainProcessingTime,"No Singel Contain Processing Time drop down");
		sleep(3000);
		webDriver.findElement(By.xpath("//div[@class='k-list-scroller']//li[text()='"+year+"']")).click();
		//verifyMustExists(Mar2017,"March value");
		//click(Mar2017,"March value");
		sleep(1000);
	}

	public boolean checkErrorReviewButton(String locator)
	{	
		if(!isBlankOrNull(locator))
		{
			try{
				setImplicitWaitTimeout(2);
				WebElement element=findWebElement(locator);
				setImplicitWaitTimeout(50000);
				if(element != null)
				{	
					verifyMustExists(locator,"Review Error Status");
					javaScriptclick(locator,"Review Error Status");
					sleep(2000);
					return true;
				}else{
					return false;
				}
			}catch (Exception e){
				setImplicitWaitTimeout(50000);
				return false;			
			}
		}else{
			Report.LogInfo("verifyMustExists","verify locator : \""+locator+"\" is not present", "INFO");
			return false;
		}
	}

	public void verifyErrormessage(String msg){	
		verifyExists(ErrorScreen,"Error Screen");
		 AcualErrorMsg = getTextFrom(ErrorScreen);
		if(AcualErrorMsg.equalsIgnoreCase(msg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message is as expected. Actual message is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message is not as expected. Actual message is: "+AcualErrorMsg, "FAIL");
		}
		sleep(2000);
	}

	public void verifyandClickProcessBorderEAuButton(){	
		waitForElementToAppear(ProcessBorderEAuButton,5);
		verifyMustExists(ProcessBorderEAuButton,"Process Bordereau Button");
		click(ProcessBorderEAuButton,"Process Bordereau Button");
		sleep(1000);
	}

	public void verifyandClickCancelAndDeleteProButton(){	
		verifyMustExists(cancelAndDeleteProBtn,"Cancel And Delete Processing button");
		click(cancelAndDeleteProBtn,"Cancel And Delete Processing button");
		sleep(4000);
	}	
    public String AcualErrorMsg;
	public void bordereauxProcessing(String ExpectedErrorMsg, String ExpSecondErrorMsg){
		sleep(3000);
	
		verifyMustExists(ErrorScreen,"Error Screen");
		 AcualErrorMsg = getTextFrom(ErrorScreen);

		if(AcualErrorMsg.equalsIgnoreCase(ExpectedErrorMsg)){
			Report.LogInfo("ValidateErrorMessage", "Validation Message displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		sleep(2000);
	}
	public String ExpectedErrorMsgRiskInceptionDate="Invalid Risk Inception Date values identified";

	public void verifyErrorScreen11() {	
		sleep(2000);	
			verifyMustExists(ErrorScreenRiskInception,"Error Screen");	
			 AcualErrorMsg = getTextFrom(ErrorScreenRiskInception);
				if(AcualErrorMsg.equalsIgnoreCase(ExpectedErrorMsgRiskInceptionDate)){

					Report.LogInfo("ValidateErrorMessage", "Validation Message displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
				}else{
					Report.LogInfo("ValidateErrorMessage", "Validation Message not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
				}
			
		}
public String AcualErrorMsg1;
	public void bordereauxProcessRemainUnchanged(String ExpectedErrorMsg, String year) {
		verifyMustExists(ErrorScreen,"Error Screen");
		 AcualErrorMsg1 = getTextFrom(ErrorScreen);
		if(AcualErrorMsg1.equalsIgnoreCase(ExpectedErrorMsg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message displayed as expected. Actual message displayed is: "+AcualErrorMsg1, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message not displayed as expected. Actual message displayed is: "+AcualErrorMsg1, "FAIL");
		}
		sleep(2000);
		verifyMustExists(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		click(RemainUnchangedRadioButton,"Remain Unchanged Radio Button");
		verifyMustExists(SelectDropDown,"Select DropDown");
		click(SelectDropDown,"Select DropDown");
		sleep(3000);
		webDriver.findElement(By.xpath("//li[contains(text(),'"+year+"')]")).click();
		sleep(3000);
		verifyMustExists(ProcessBorderEAuButton,"Process Bordereau Button");
		click(ProcessBorderEAuButton,"Process Bordereau Button");
	}

	public void cancelAndDeleteBoredereauByCatchingValidation(String ExpectedErrorMsg){
		//sleep(3000);
		if(isVisible(ErrorScreen)== true){
			verifyMustExists(ErrorScreen,"Error Screen");
			 AcualErrorMsg1 = getTextFrom(ErrorScreen);
			if(AcualErrorMsg1.equalsIgnoreCase(ExpectedErrorMsg)){
				Report.LogInfo("ValidateErrorMessage", "Validation Message is displayed as expected. Actual message displayed is: "+AcualErrorMsg1, "PASS");
			}else{
				Report.LogInfo("ValidateErrorMessage", "Validation Message is not displayed as expected. Actual message displayed is: "+AcualErrorMsg1, "FAIL");
			}
			verifyMustExists(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
			click(CancelAndDeleteBordereaux,"Cancel And Delete Bordereaux");
			sleep(4000);
		}else{
			Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
		}
	}
	public void passDate(String Date){
		verifyMustExists(DateTextBox0,"Date Textbox");
		sendKeys(DateTextBox0,Date,"Date Textbox.");
		verifyMustExists(DateTextBox1,"Date Textbox");
		sendKeys(DateTextBox1,Date,"Date Textbox.");
		verifyMustExists(DateTextBox2,"Date Textbox");
		sendKeys(DateTextBox2,Date,"Date Textbox.");
		sleep(2000);

	}
	public void verifyBackground(String locator,String colorcode ){
		String actuallcolor= findWebElement(locator).getCssValue("color"); 
		if(actuallcolor.equalsIgnoreCase(colorcode)){

			Report.LogInfo("Validatebackrgound", "Validation background displayed to green successfully.", "PASS");
		}else{
			Report.LogInfo("Validatebackrgound", "Validation background not displayed to green successfully.", "FAIL");
		}
		sleep(3000);
	}

	public boolean checkReviewButton(String locator)
	{ 
		if(!isBlankOrNull(locator))
		{
			try{
				setImplicitWaitTimeout(2);
				WebElement element=findWebElement(locator);
				setImplicitWaitTimeout(50000);
				if(element != null)
				{ 
					verifyMustExists(ReviewBtn,"Review Button");
					sleep(2000);
					return true;
				}else{
					return false;
				}
			}catch (Exception e){
				setImplicitWaitTimeout(50000);
				return false;   
			}
		}else{
			Report.LogInfo("verifyMustExists","verify locator : \""+locator+"\" is not present", "INFO");
			return false;
		}
	}

	public void selectSheetRadioAndVerifyErrorMessage(String errorsheetmsg){
		waitForElementToAppear(SheetNameRadioBtx,5);
		verifyMustExists(SheetNameRadioBtx,"Sheet Name radio button");
		click(SheetNameRadioBtx,"Sheet Name radio button");
		sleep(1000);
		verifyMustExists(ErrorScreen,"Error Screen");
		 AcualErrorMsg = getTextFrom(ErrorScreen);
		if(AcualErrorMsg.equalsIgnoreCase(errorsheetmsg)){

			Report.LogInfo("ValidateErrorMessage", "Validation Message is displayed as expected. Actual message displayed is: "+AcualErrorMsg, "PASS");
		}else{
			Report.LogInfo("ValidateErrorMessage", "Validation Message is not displayed as expected. Actual message displayed is: "+AcualErrorMsg, "FAIL");
		}
		sleep(2000);	 
	}
	public void monthselection() {
		verifyMustExists(sheetdropdown,"Sheet Dropdown");
		click(sheetdropdown,"Sheet Dropdown");
		sleep(3000);
		//waitForElementToAppear(April2017,5);
		verifyMustExists(April2017,"April 2017 Option");
		javaScriptclick(April2017,"April 2017 Option");
		sleep(3000);
	}   
	public void verifyvalidDateAndBackground()
	{
		clearTextBox(datefield);
		sendKeys(datefield,"11/01/2018","Date field.");  
		verifyMustExists(datefield,"Date field");
		verifyBackground(datefield,"rgba(0, 97, 0, 1)");
		sleep(2000);
		verifyMustExists(continuebtx,"Continue button");
		click(continuebtx,"Continue button");
	}
	public void processBordereauAccounterror() throws Exception
	{
		if(checkErrorReviewButton(ReviewError)== true)
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
			sleep(2000);
			//VerifyNotificationPopupAfterUpload();
			sleep(2000);
			if(isVisible(discardRecord)== true){
				verifyMustExists(discardRecord,"First discard record");
				click(discardRecord,"Discard record");
				
				verifyMustExists(RecordsNotImported,"Records did not import");
				verifyMustExists(ContractIndentifiedText,"Contract identified text verified");
				
				verifyMustExists(continuebtx,"Continue button");
				click(continuebtx,"Continue button");
				sleep(3000);
				verifyBackground(yearAccount,"rgba(156, 0, 6, 1)");
				verifyBackground(inceptionDate,"rgba(156, 0, 6, 1)");
				clearTextBox(yearAccount);
				sendKeys(yearAccount,"2018","Year Account field.");
				sleep(3000);
				verifyBackground(yearAccount,"rgba(0, 97, 0, 1)");
				//verifyBackground(inceptionDate,"rgba(0, 97, 0, 1)");
				verifyMustExists(continuebtn,"Continue button");
				click(continuebtn,"Continue button");
				refreshUploadedFile();
				verifyMustExists(ReviewBtn,"Review Status button");
				AssertBordereauStatusReview = getTextFrom(ReviewBtn);
				deleteBorderEAUX();
				
			}else{
				Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
				goBack();
				deleteBorderEAUX();				
			}
		} 
		else
		{
			Report.LogInfo("ValidateReviewErrorStatus", "Review Error status not displayed.", "FAIL");
			deleteBorderEAUX();
			//VerifyNotificationPopupAfterUpload();
		}
	}

	public void VerifyNotificationPopupAfterUpload() throws Exception{

		if(isVisible(SuccessNotificationMsgAfterUpload))
		{
			//Report.LogInfo("NotificationAfterUpload", "Success notification displayed after uploading bordereau.", "PASS");
			sleep(1000);
			click(OkButtonOnSuccessNotification,"Ok Button On Success Notification");
		}
		else if(isVisible(FailureNotificationMsgAfterUpload))
		{
			//Report.LogInfo("NotificationAfterUpload", "Failure notification displayed after uploading bordereau.", "PASS");
			sleep(1000);
			click(CancelButtonOnFailureNotification,"Cancel Button On Failure Notification");
		}
		/*else
		{
			Report.LogInfo("NotificationAfterUpload", "Success or Failure Notification not displayed after uploading bordereau.", "FAIL");
		}*/

	}

	public void checkRecordsAndDeleteReviewError(){
		navigateOnProcessingTab();

		waitForElementToAppear(filterIconRecords,3);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewErrorCheckBox)==true){
			click(ReviewErrorCheckBox,"ReviewErrorCheckBox");
			verifyMustExists(FilterButtonRecords,"FilterButtonRecords");
			click(FilterButtonRecords,"FilterButtonRecords");
			sleep(4000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			for(int i=1;i<=recordsCount;i++){
				deleteBorderEAUX();
			}
		}else{
			Report.LogInfo("ValidateRecords", "No older records found", "PASS");
		}
	}

	public void checkRecordsAndDeleteReview(){
		navigateOnProcessingTab();
		refreshPage();
		sleep(4000);
		waitForElementToAppear(filterIconRecords,8);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		if(isVisible(ReviewCheckBox)==true){
			click(ReviewCheckBox,"ReviewCheckBox");
			verifyMustExists(FilterButtonRecords,"FilterButtonRecords");
			click(FilterButtonRecords,"FilterButtonRecords");
			sleep(2000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			for(int i=1;i<=recordsCount;i++){				
				deleteBorderEAUX();
			}
			refreshPage();
			sleep(4000);
		}else{
			Report.LogInfo("ValidateRecords", "No older records found", "PASS");
		}
	}

	public void FilterRecordStatus(String RecordStatus){
		sleep(4000);
		
		waitForElementToAppear(filterIconRecords,8);
		verifyMustExists(filterIconRecords,"filterIconRecords");
		click(filterIconRecords,"filterIconRecords");
		
		String ReviewCheckBox = "@css=input[value='"+RecordStatus+"']";
		if(isVisible(ReviewCheckBox)==true){
			click(ReviewCheckBox,"ReviewCheckBox");
			verifyMustExists(FilterButtonRecords1,"FilterButtonRecords");
			click(FilterButtonRecords1,"FilterButtonRecords");
			sleep(2000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			Report.LogInfo("RecordCount", RecordStatus+" Status record Count is = "+recordsCount, "INFO");
		}else{
			Report.LogInfo("ValidateRecords", RecordStatus+" Status record not Found", "FAIL");
		}
	}
	
	
	public void FilterDaysOverdueColumn(String Date){
		sleep(4000);
		mouseOverAction(filterIconRecords_DaysOverdue);
		waitForElementToAppear(filterIconRecords_DaysOverdue,8);
		verifyMustExists(filterIconRecords_DaysOverdue,"filterIconRecords");
		click(filterIconRecords_DaysOverdue,"filterIconRecords");
		
		String ReviewCheckBox = "@css=input[value='"+Date+"']";
		if(isVisible(ReviewCheckBox)==true){
			click(ReviewCheckBox,"ReviewCheckBox");
			sleep(1000);
			verifyMustExists(FilterButtonRecords2,"FilterButtonRecords");
			click(FilterButtonRecords2,"FilterButtonRecords");
			sleep(2000);
			List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
			int recordsCount = totatRecords.size();
			Report.LogInfo("RecordCount", "For Filter "+Date+"   record Count is = "+recordsCount, "INFO");
		}else{
			Report.LogInfo("ValidateRecords", Date+"  Status record not Found", "FAIL");
		}
	}
	
	
	public int GetDueDate(String Duedate) throws ParseException
	{

			 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date d1 = df.parse(Duedate);
				Date dNow = new Date();
				java.util.Date d2 = df.parse(df.format(dNow));
					long numberOfDays =(long)(d2.getTime()-d1.getTime())/86400000;
					 int daysdifference = (int)numberOfDays;
					return daysdifference;
	}
	

	public void DeleteButtonCheckRowwise(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String uploadDeletebtn = "@xpath=//tr["+a+"]//button[text()='Uploaded']//following-sibling::span[1]/i";
			if(isVisible(uploadDeletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button display for updload status", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "Delete button is not display for updload status", "FAIL");
			}
		}
	}
public String DeletebuttonNotVisible;
	public void DeleteButtonCheckRowwiseforAllStatus(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//*[contains(@ng-click,'CanDelete')]";
			if(isVisible(Deletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button display for status", "PASS");
		
			}else{
				Report.LogInfo("ButtonCheck", "Delete button is not display for status", "FAIL");
				DeletebuttonNotVisible = "FAIL";
			}
		}
	}
public String DeleteOptionVisible;
	public void DeleteButtonCheckRowwiseforAllStatus1(){
		sleep(2000);
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//*[contains(@ng-click,'CanDelete')]";
			if(isVisible(Deletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button display for status", "FAIL");
				DeleteOptionVisible = "FAIL";
				
			}else{
				Report.LogInfo("ButtonCheck", "Delete button is not display for updload status", "PASS");
			}
		}
	}



	public void applyStatusFilter(String Status) throws InterruptedException{
		sleep(1000);
		int i=0;
		String RecordCheckbox ="@css=input[value='"+Status+"']";

		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(filterIconRecords,5);
			click(filterIconRecords, "Status Filter Icon");
			sleep(2000);
			waitForElementToAppear(SearchText,5);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		waitForElementToAppear(RecordCheckbox,5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Status+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
		//sleep(2000);
	}

	public void applyBordereauTypeFilter(String Status) throws InterruptedException{
		sleep(1000);
		int i=0;
		String RecordCheckbox ="@css=input[value='"+Status+"']";

		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(filterIconRecordsBodrTyp,5);
			click(filterIconRecordsBodrTyp, "Status Filter Icon");
			sleep(2000);
			waitForElementToAppear(SearchTextBDType,5);
			if(isVisible(SearchTextBDType))
			{
				verifyMustExists(SearchTextBDType,"Search Filter Textbox");	
				sendKeys(SearchTextBDType,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		waitForElementToAppear(RecordCheckbox,5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Status+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
		//sleep(2000);
	}

	public void refreshUploadedFileApprovedStatus1(String ApproveBtn) throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ApproveBtn)==false) && (totalTime < 180000));
	}

	public void applyMonthFilter(String Status) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=input[value='"+Status+"']";

		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(filterIconRecordsMonth,5);
			click(filterIconRecordsMonth, "Status Filter Icon");
			sleep(2000);
			waitForElementToAppear(SearchTextBDType,5);
			if(isVisible(SearchTextBDType))
			{
				verifyMustExists(SearchTextBDType,"Search Filter Textbox");	
				sendKeys(SearchTextBDType,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		waitForElementToAppear(RecordCheckbox,5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Status+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
		//sleep(2000);
	}
public String UnapproveBtnEnabled;
	public void applyTypefilterAndVerifyApprov(String Type, String Status) throws InterruptedException{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		int i=0;
		javaScriptWait();
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			waitForElementToAppear(BodrTypFilterIcon,5);
			click(BodrTypFilterIcon, "Status Filter Icon");
			sleep(2000);
			if(isVisible(Type))
			{
				verifyMustExists(Type,"Type Textbox");	
				click(Type, "Type Checkbox");
				//sendKeys(SearchText,Status,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(Type) && i<5);
		waitForElementToAppear(BodrFilterBtn,5);
		verifyMustExists(BodrFilterBtn,"Filter Button");
		click(BodrFilterBtn,"Filter Button");
		sleep(3000);
		applyStatusFilter(Status);
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			click(FrApprovalbtn,"For Approval btn");
			sleep(2000);
			if(isEnable(UnApprvBdrBtn)==false){
				Report.LogInfo("ButtonCheck", "Button is disable", "PASS");
				
			}else{
				Report.LogInfo("ButtonCheck", "Button is enable", "FAIL");
				UnapproveBtnEnabled = "FAIL";
			}
			goBack();
		}	
	}
public int count3207;
	public void verificationCountsAfterReviewButton(int expectedCount){

		waitForElementToAppear(RiskTabAfterReview,3);
		verifyMustExists(RiskTabAfterReview,"Risk Tab");
		click(RiskTabAfterReview,"Risk Tab");
		sleep(4000);
		waitForElementToAppear(ChangePageCountDropDn,4);
		verifyMustExists(ChangePageCountDropDn,"Change Page Count Dropdown");
		click(ChangePageCountDropDn,"Change Page Count Dropdown");
		sleep(2000);
		click(ChangePageCountTo,"Change Page Count To");
		sleep(3000);
		List <WebElement> list = findWebElements(ActualExpectedRowCount);
		 count3207 = list.size();
		sleep(2000);
		if(count3207 == expectedCount)
		{
			Report.LogInfo("ValidateRecords", "Records count matches with the records in the excel file. Actual records count is: "+count3207, "PASS");
		}else{
			Report.LogInfo("ValidateRecords", "Records count does not match with the records in the excel file. Actual records count is: "+count3207, "FAIL");
		}
		sleep(2000);
		goBack();		
	}
	public void CalDateSelection (String Date)
	{
		waitForElementToAppear(Calender,5);
		verifyMustExists(Calender,"Calender");
		click(Calender,"Calender");
		sleep(2000);
		sendKeys(CalenderInputBox,Date,"Select period of date");
		sleep(1000);
		click(Calender,"Calender");
		sleep(2000);
	}

	public void SubmitBordereauxWithYesnoButtons(String Date) throws Exception{
		//navigateOnProcessingTab();
		String SubBdrwBtn = "@xpath=//div[@ng-if='!isProcessingDisabled']";
		waitForElementToAppear(BORDEREAUXLink,5);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");		
		sleep(3000);
		navigateOnProcessingTab();
		if(isVisible(SubBdrwBtn)==false){
			verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
			javaScriptclick(BORDEREAUXLink,"BORDEREAUX Link");
			sleep(2000);
			navigateOnProcessingTab();
		}
	}

	public void SubmitBordereauxWithYesnoButtons1() throws Exception{
		//navigateOnProcessingTab();
		waitForElementToAppear(BORDEREAUXLink,5);
		verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
		click(BORDEREAUXLink,"BORDEREAUX Link");
		sleep(3000);
		navigateOnProcessingTab();
		if (isVisible(BlankDetailsMsg)==true)
		{
			Report.LogInfo("StatusCheck", "No status records found", "PASS");
		}else{
			//sleep(2000);
			checkRecordsAndDeleteReviewError();
			refreshPage();
			//sleep(2000;);
			//checkRecordsAndDeleteReview();
		}
		sleep(2000);
	}
     public void SelectPauseButton() {
    		waitForElementToAppear(PauseButton,3);
    		if(isVisible(PauseButton)== true){

    			verifyMustExists(PauseButton,"Pause Button Button");
    			PauseBtnText = getTextFrom(PauseButton);
    			click(PauseButton,"Pause Button");
    			sleep(3000); 
    		}else{
    			Report.LogInfo("ErrorScreen", "Expected button not displayed.", "FAIL");
    			goBack();
    		} 
     }
     
     public void SelectCancelAndDelete() {
 		waitForElementToAppear(CancelAndDeleteButton,3);
 		if(isVisible(CancelAndDeleteButton)== true){

 			verifyMustExists(CancelAndDeleteButton,"cancel and delete button Button Button");
 			PauseBtnText = getTextFrom(CancelAndDeleteButton);
 			click(CancelAndDeleteButton,"cancel and delete button Button Button");
 			
 			verifyMustExists(CancelAndDeleteButtonC,"cancel and delete button Button Button");
 			click(CancelAndDeleteButtonC,"cancel and delete button Button Button");
 			sleep(3000); 
 		}else{
 			Report.LogInfo("ErrorScreen", "Button not displayed.", "FAIL");
 			goBack();
 		} 
 		
 		
  }
	public void SelectYesNoAndDeleteProcessing(String YesNo){
		waitForElementToAppear(CancelProcessingButton,3);
		if(isVisible(CancelProcessingButton)== true){

			verifyMustExists(CancelProcessingButton,"Cancel Processing Button");
			click(CancelProcessingButton,"Cancel Processing Button");
			waitForElementToAppear(YesCancelProcessing,5);
		verifyMustExists(YesCancelProcessing,"Yes Cancel Processing button");
			click(YesCancelProcessing,"Yes Cancel Processing button");
			sleep(3000);
		}else{
			Report.LogInfo("ErrorScreen", "Expected error screen not displayed.", "FAIL");
			goBack();
		}
	}



	public void ApplyDueDateFilter(String Date, String DateValue){
		waitForElementToAppear(DuteDatefilterIcon,8);
		verifyMustExists(DuteDatefilterIcon,"Due Date filter");
		javaScriptclick(DuteDatefilterIcon,"Due Date filter");
		waitForElementToAppear(DuteDatefilterIconInputBox,5);
		verifyMustExists(DuteDatefilterIconInputBox,"Due Date filter Icon Input Box");
		sendKeys(DuteDatefilterIconInputBox,Date,"Due Date filter Icon Input Box");
		sleep(2000);
		if(isVisible(DueDateCheckbx)==true){
			webDriver.findElement(By.cssSelector(".k-reset.k-multicheck-wrap>li>label>input[value='"+DateValue+"']")).click();
			verifyMustExists(DueDateFiterBtn,"Due Date filter Button");
			click(DueDateFiterBtn,"Due Date filter Button");
			sleep(2000);
		}
	}
public String	ContinueProcessingBodrBtntext;
	public void SelectYesNoAndContinueProcessing(String YesNo){
		waitForElementToAppear(CancelAndDeleteBordereauxSp2,8);
		if(isVisible(By.xpath("//*[@id='content']//div[@class='top_error']//label["+YesNo+"]"))== true)
		{
			webDriver.findElement(By.xpath("//*[@id='content']//div[@class='top_error']//label["+YesNo+"]")).click();
		}else{
			Report.LogInfo("YesNoButtonsCheck", "Yes button is not present on screen", "PASS");
		}
		if(isVisible(ContinueProcessingBodrBtn)== true){
			ContinueProcessingBodrBtntext = getTextFrom(ContinueProcessingBodrBtn);
			verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing button");
			click(ContinueProcessingBodrBtn,"Continue Processing button");
		}else{
			goBack();
		}
	}
	public void clickOnSkipAllErrorBTN1(){
		waitForElementToAppear(SkippAllErroBtn1,10);
		verifyMustExists(SkippAllErroBtn1,"Skipp All Error Button");
		SkippAllErroBtnScreen = getTextFrom(SkippAllErroBtn1);
		Report.LogInfo("SkippAllErroBtn", SkippAllErroBtnScreen, "PASS");
		click(SkippAllErroBtn1,"Skipp All Error Button");
	}

	public void clickOnSkipAllErrorBTN2(){
		waitForElementToAppear(SkippAllErroBtn2,10);
		verifyMustExists(SkippAllErroBtn2,"Skipp All Error Button");
		SkippAllErroBtnScreen = getTextFrom(SkippAllErroBtn2);
		Report.LogInfo("SkippAllErroBtn", SkippAllErroBtnScreen, "PASS");
		click(SkippAllErroBtn2,"Skipp All Error Button");
		sleep(2000);
	}

	public void clickOnSkipAllErrorBTN(){
		waitForElementToAppear(SkippAllErroBtn,10);
		verifyMustExists(SkippAllErroBtn,"SKIP ALL ERRORS");
		SkippAllErroBtnScreen = getTextFrom(SkippAllErroBtn);
		Report.LogInfo("SkippAllErroBtn", SkippAllErroBtnScreen, "PASS");
		click(SkippAllErroBtn,"Skipp All Error Button");
	}

	public void clickOnSubProcessRcdBtn(){
		waitForElementToAppear(SubProcessRcdBtn,10);
		verifyMustExists(SubProcessRcdBtn,"Submit process record Button");
		SubProcessRcdsBtn = getTextFrom(SubProcessRcdBtn);
		Report.LogInfo("SubProcessRcdsBtn", SubProcessRcdsBtn, "PASS");
		click(SubProcessRcdBtn,"Submit process record Button");
	}

	public void clickOnSubAssesmntBtn(){
		waitForElementToAppear(SubAssesmntBtn,10);
		verifyMustExists(SubAssesmntBtn,"Submit Assesment Button");
		click(SubAssesmntBtn,"Submit Assesment Button");
	}

	public void clickOnApproveBordBtn(){
		waitForElementToAppear(ApproveBordBtn,10);
		verifyMustExists(ApproveBordBtn,"Approve Bordereau Button");
		
		click(ApproveBordBtn,"Approve Bordereau Button");
		sleep(2000);
	}
	
	public void clickOnForApprovalBtn(){
		waitForElementToAppear(ForApprovalBtn,10);
		verifyMustExists(ForApprovalBtn,"For Approval Bordereau Button");
		
		click(ForApprovalBtn,"For Approval Bordereau Button");
		sleep(2000);
	}

	public void clickOnApproveBordBtn1(){
		waitForElementToAppear(ApproveBordBtn,10);
		verifyMustExists(ApproveBordBtn,"Approve Bordereau Button");
		javaScriptclick(ApproveBordBtn,"Approve Bordereau Button");
		sleep(2000);
	}

	public static final String refFilter ="@xpath=//*[@id='grid']//tr[7]//td[39][@class='bgm-green']";

	public void verifyErrorScreen(String ExpectedErrorMsg )
	{
		verifyExists(ErrorScreenMsg,"Error Screen Message");
		String ActualErrorMsg=getTextFrom(ErrorScreenMsg);
		if(ActualErrorMsg.equals(ExpectedErrorMsg))
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message validate successfully", "PASS");	
			verifyMustExists(CancelProcessingBtn,"Cancel Processing And Delete Bordereau");
			click(CancelProcessingBtn," Click on Cancel Processing And Delete Bordereau");	
			sleep(3000);
		}
		else
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message not validate successfully", "Fail");
			goBack();
			sleep(3000);
			deleteBorderEAUX();				
		}

	}
	
	public void verifyErrorScreen1(String ExpectedErrorMsg )
	{
		verifyExists(ErrorScreenMsg1,"Error Screen Message");
		 ActualErrorMsg=getTextFrom(ErrorScreenMsg1);
		if(ActualErrorMsg.equals(ExpectedErrorMsg))
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message validate successfully", "PASS");	
			verifyMustExists(Pausebtn1,"Cancel Processing And Delete Bordereau");
			click(Pausebtn1," Click on Cancel Processing And Delete Bordereau");	
			sleep(3000);
		}
		else
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message not validate successfully", "Fail");
			goBack();
			sleep(3000);
			deleteBorderEAUX();				
		}

	}

	public void openDATALink()
	{
		waitForElementToAppear(DATAlink,5);
		verifyMustExists(DATAlink,"DATA Link");
		for(int i= 0; i<=5; i++)
		{
			click(DATAlink,"Data link");
			sleep(2000);
			if(isVisible(DATARiskTab)==true)
			{
				break;
			}
		}
	}

	public void navigateToDATATab()
	{
		String Summary = "@xpath=.//a[text()='Summary']";
		waitForElementToAppear(DATAlink,5);
		verifyMustExists(DATAlink,"Data Tab");
		click(DATAlink,"Click on Data Tab");
		sleep(3000);
		if(isVisible(Summary)==false){
			verifyMustExists(DATAlink,"Data Tab");
			javaScriptclick(DATAlink,"Click on Data Tab");
		}

	}

	public void navigateToDATAClaimTab()
	{
		waitForElementToAppear(DATAClaimTab,5);
		verifyMustExists(DATAClaimTab,"Claim Tab");
		click(DATAClaimTab,"Click on Claim Tab");
		sleep(3000);
	}

	public void navigateToDATAPremiumTab()
	{
		waitForElementToAppear(DATAPremiumTab,5);
		verifyMustExists(DATAPremiumTab,"Claim Tab");
		click(DATAPremiumTab,"Click on Claim Tab");
		sleep(3000);
	}

	public void  selectRowNumberAscOrder()
	{
		verifyMustExists(RowNumber,"Row Number");
		click(RowNumber,"Click on Row Number");
		sleep(3000);
		verifyMustExists(RowNumberAscIcon,"Row Number Ascending icon");  
		sleep(3000);
	}

	public void renewalYNTransactionType_February_3760() throws Exception{
		String DateMonth = "February 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			verifyExists(SignedBtn,"Signed Status Button");	
			SubmitBordereauxWithYesnoButtons(DateMonth);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3760Path = fpath+"\\src\\test\\resources\\testdata\\February 2017_TC_3760.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3760Path);  
			String payload ="{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2017,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017_TC_3760.xlsx\",\"UniqueFileName\":\"S46528420171113.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S46528420171113.xlsx\",\"Filesize\":20276,\"Path\":null,\"size\":20276,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			refreshUploadedFile();
			if(isVisible(ReviewBtn)==true){
				Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			}
			else{
				Report.LogInfo("ReviewStatusValidation", "Review Status Button not Displayed", "FAIL");
			}
		}else{
			Report.LogInfo("SignedStatusValidation", "Signed Status not displayed", "FAIL");
		}	
	}

	public void mappingIncrementalIncrease_3762() throws Exception{
		ActualCount=ActualCount+1;
		System.out.println(ActualCount);
		String OriginalValueName="Endorsement";	
		homePage.adminMenu();
		datasetPage.DatasetReferenceDataLink();
		datasetPage.DatasetReferenceDatapage();
		applyReferenceDataFilter("Boolean");
		waitForElementToAppear(BooleanName,5);
		verifyExists(BooleanName,"Boolean Name");
		click(BooleanName,"Boolean Name");
		datasetPage.selectMappingsTab();
		datasetPage.applyOriginalNameFilter(OriginalValueName);
		waitForElementToAppear(MappingTotalCount,5);
		verifyExists(MappingTotalCount,"Mapping Total Count");
		String ActualCount1 = getTextFrom(MappingTotalCount);
		int ActualCount2 = Integer.parseInt(ActualCount1);
		if(ActualCount2 == ActualCount)
		{
			Report.LogInfo("ValidateCount", "Increment Count validate successfully", "PASS");	
		}
		else
		{
			Report.LogInfo("ValidateCount", "Increment Count not validate successfully", "FAIL");
		}
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		if(isVisible(SignedBtn)== true){
			waitForElementToAppear(BORDEREAUXLink,5);
			verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
			click(BORDEREAUXLink,"BORDEREAUX Link");
			sleep(3000);
			deleteBorderEAUX();
		}
	}

	public void TC4476_CalculateTaxBySelecting_Yes_OnlyOne_option() throws Exception
	{
		String subSheet = "Automation Risk Format 17";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();

		String IncDate = "01/01/2018";
		String ExpDate = "31/12/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
		policy.CreateContractwithInceptionDate2018();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		SubmitBordereaux(subSheet);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4476Path = fpath+"\\src\\test\\resources\\testdata\\Taxes calculation_4476.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4476Path);  
		
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S69533820180927.xlsx";	
		int size = 23209;
		String BordreauID = "11b7a5bd-ac54-4efd-8845-fee9dbd85f67";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation_4476.xlsx\",\"UniqueFileName\":\"S91209620180501.xlsx\",\"BordereauFormatId\":\"11b7a5bd-ac54-4efd-8845-fee9dbd85f67\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S91209620180501.xlsx\",\"Filesize\":23209,\"Path\":null,\"size\":23209,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			sleep(2000);
			selectRowNumberAscOrder();

			//Total Tax % Column 
			String TotalTax_Percolumn="@xpath=//*[@data-field='Tax_Total_Percent']";
			String TotalTaxcolumn_Value1="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][1]";
			String TotalTaxcolumn_Value2="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][2]";
			String TotalTaxcolumn_Value3="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][3]";
			String TotalTaxcolumn_Value4="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][4]";
			String TotalTaxcolumn_Value5="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][5]";
			String TotalTaxcolumn_Value6="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][6]";
			String TotalTaxcolumn_Value7="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][7]";
			String TotalTaxcolumn_Value8="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][8]";
			String TotalTaxcolumn_Value9="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][9]";
			String TotalTaxcolumn_Value10="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][10]";
			String TotalTaxcolumn_Value11="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][11]";
			waitForElementToAppear(TotalTax_Percolumn,20);
			mouseOverAction(TotalTax_Percolumn);
			verifyMustExists(TotalTax_Percolumn,"Total Tax Percentage column");
			sleep(2000);
			verifyExists(TotalTaxcolumn_Value1,"1st value");
			TTax1 = getTextFrom(TotalTaxcolumn_Value1);
			Report.LogInfo("TotalTax 1st value", TTax1, "PASS");
			verifyExists(TotalTaxcolumn_Value2,"2nd value");
			TTax2 = getTextFrom(TotalTaxcolumn_Value2);
			Report.LogInfo("TotalTax 2nd value", TTax2, "PASS");
			verifyExists(TotalTaxcolumn_Value3,"3rd value");
			verifyExists(TotalTaxcolumn_Value4,"4th value");
			verifyExists(TotalTaxcolumn_Value5,"5th value");
			verifyExists(TotalTaxcolumn_Value6,"6th value");
			verifyExists(TotalTaxcolumn_Value7,"7th value");
			verifyExists(TotalTaxcolumn_Value8,"8th value");
			verifyExists(TotalTaxcolumn_Value9,"9th value");
			verifyExists(TotalTaxcolumn_Value10,"10th value");
			TTax10 = getTextFrom(TotalTaxcolumn_Value10);
			Report.LogInfo("TotalTax 10th value", TTax10, "PASS");
			verifyExists(TotalTaxcolumn_Value11,"11th value");
			TTax11 = getTextFrom(TotalTaxcolumn_Value11);
			Report.LogInfo("TotalTax 11th value", TTax11, "PASS");
			sleep(2000);

			//Tax Fixed Rate 1 Column
			String Tax_FixedRateColumn="@xpath=//*[@data-field='Tax_Fixed_Rate_1']";
			String Tax_FixedRateColumn_Value1="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][1]";
			String Tax_FixedRateColumn_Value2="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][2]";
			String Tax_FixedRateColumn_Value3="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][3]";
			String Tax_FixedRateColumn_Value4="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][4]";
			String Tax_FixedRateColumn_Value5="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][5]";
			String Tax_FixedRateColumn_Value6="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][6]";
			String Tax_FixedRateColumn_Value7="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][7]";
			String Tax_FixedRateColumn_Value8="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][8]";
			String Tax_FixedRateColumn_Value9="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][9]";
			String Tax_FixedRateColumn_Value10="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][10]";
			String Tax_FixedRateColumn_Value11="@xpath=//*[@data-field='Tax_Fixed_Rate_1']//following::td[contains(@ng-click,'Tax_Fixed_Rate_1')][11]";
			waitForElementToAppear(Tax_FixedRateColumn,20);
			mouseOverAction(Tax_FixedRateColumn);
			verifyMustExists(Tax_FixedRateColumn,"Tax Fixed Rate 1 column");
			sleep(2000);
			verifyExists(Tax_FixedRateColumn_Value1,"1st value");
			TFR1 = getTextFrom(Tax_FixedRateColumn_Value1);
			Report.LogInfo("Tax Fixed rate 1st value", TFR1, "PASS");
			verifyExists(Tax_FixedRateColumn_Value2,"2nd value");
			TFR2 = getTextFrom(Tax_FixedRateColumn_Value2);
			Report.LogInfo("Tax Fixed rate 2nd value", TFR2, "PASS");
			verifyExists(Tax_FixedRateColumn_Value3,"3rd value");
			verifyExists(Tax_FixedRateColumn_Value4,"4th value");
			verifyExists(Tax_FixedRateColumn_Value5,"5th value");
			verifyExists(Tax_FixedRateColumn_Value6,"6th value");
			verifyExists(Tax_FixedRateColumn_Value7,"7th value");
			verifyExists(Tax_FixedRateColumn_Value8,"8th value");
			verifyExists(Tax_FixedRateColumn_Value9,"9th value");
			verifyExists(Tax_FixedRateColumn_Value10,"10th value");
			TFR10 = getTextFrom(Tax_FixedRateColumn_Value10);
			Report.LogInfo("Tax Fixed rate 10th value", TFR10, "PASS");
			verifyExists(Tax_FixedRateColumn_Value11,"11th value");
			TFR11 = getTextFrom(Tax_FixedRateColumn_Value11);
			Report.LogInfo("Tax Fixed rate 11th value", TFR11, "PASS");
			sleep(2000);

			//Tax Multiplier 1 Column
			String Tax_MultiplierColumn="@xpath=//*[@data-field='Tax_Multiplier_1']";
			String Tax_MultiplierColumn_Value1="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][1]";
			String Tax_MultiplierColumn_Value2="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][2]";
			String Tax_MultiplierColumn_Value3="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][3]";
			String Tax_MultiplierColumn_Value4="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][4]";
			String Tax_MultiplierColumn_Value5="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][5]";
			String Tax_MultiplierColumn_Value6="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][6]";
			String Tax_MultiplierColumn_Value7="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][7]";
			String Tax_MultiplierColumn_Value8="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][8]";
			String Tax_MultiplierColumn_Value9="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][9]";
			String Tax_MultiplierColumn_Value10="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][10]";
			String Tax_MultiplierColumn_Value11="@xpath=//*[@data-field='Tax_Multiplier_1']//following::td[contains(@ng-click,'Tax_Multiplier_1')][11]";
			waitForElementToAppear(Tax_MultiplierColumn,20);
			mouseOverAction(Tax_MultiplierColumn);
			verifyMustExists(Tax_MultiplierColumn,"Tax Multiplier 1 column");
			sleep(2000);
			verifyExists(Tax_MultiplierColumn_Value1,"1st value");
			TM1 = getTextFrom(Tax_MultiplierColumn_Value1);
			Report.LogInfo("Tax Multipliere 1st value", TM1, "PASS");
			verifyExists(Tax_MultiplierColumn_Value2,"2nd value");
			TM2 = getTextFrom(Tax_MultiplierColumn_Value2);
			Report.LogInfo("Tax Multipliere 2nd value", TM2, "PASS");
			verifyExists(Tax_MultiplierColumn_Value3,"3rd value");
			verifyExists(Tax_MultiplierColumn_Value4,"4th value");
			verifyExists(Tax_MultiplierColumn_Value5,"5th value");
			verifyExists(Tax_MultiplierColumn_Value6,"6th value");
			verifyExists(Tax_MultiplierColumn_Value7,"7th value");
			verifyExists(Tax_MultiplierColumn_Value8,"8th value");
			verifyExists(Tax_MultiplierColumn_Value9,"9th value");
			TM9 = getTextFrom(Tax_MultiplierColumn_Value9);
			Report.LogInfo("Tax Multipliere 9th value", TM9, "PASS");
			verifyExists(Tax_MultiplierColumn_Value10,"10th value");
			TM10 = getTextFrom(Tax_MultiplierColumn_Value10);
			Report.LogInfo("Tax Multipliere 10th value", TM10, "PASS");
			verifyExists(Tax_MultiplierColumn_Value11,"11th value");
			TM11 = getTextFrom(Tax_MultiplierColumn_Value11);
			Report.LogInfo("Tax Multipliere value", TM11, "PASS");
			sleep(2000);

			//Taxable_Premium_1 Column
			String Taxable_Premium_Column="@xpath=//*[@data-field='Taxable_Premium_1']";
			String Taxable_Premium_1_Value1="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][1]";
			String Taxable_Premium_1_Value2="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][2]";
			String Taxable_Premium_1_Value3="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][3]";
			String Taxable_Premium_1_Value4="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][4]";
			String Taxable_Premium_1_Value5="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][5]";
			String Taxable_Premium_1_Value6="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][6]";
			String Taxable_Premium_1_Value7="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][7]";
			String Taxable_Premium_1_Value8="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][8]";
			String Taxable_Premium_1_Value9="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][9]";
			String Taxable_Premium_1_Value10="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][10]";
			String Taxable_Premium_1_Value11="@xpath=//*[@data-field='Taxable_Premium_1']//following::td[contains(@ng-click,'Taxable_Premium_1')][11]";
			waitForElementToAppear(Taxable_Premium_Column,20);
			mouseOverAction(Taxable_Premium_Column);
			verifyMustExists(Taxable_Premium_Column,"Taxable Premium Column");
			sleep(2000);
			verifyExists(Taxable_Premium_1_Value1,"1st value");
			TP1 = getTextFrom(Taxable_Premium_1_Value1);
			Report.LogInfo("Tax Premium 1st value", TP1, "PASS");
			verifyExists(Taxable_Premium_1_Value2,"2nd value");
			TP2 = getTextFrom(Taxable_Premium_1_Value1);
			Report.LogInfo("Tax Premium 2nd value", TP2, "PASS");
			verifyExists(Taxable_Premium_1_Value3,"3rd value");
			verifyExists(Taxable_Premium_1_Value4,"4th value");
			verifyExists(Taxable_Premium_1_Value5,"5th value");
			verifyExists(Taxable_Premium_1_Value6,"6th value");
			verifyExists(Taxable_Premium_1_Value7,"7th value");
			verifyExists(Taxable_Premium_1_Value8,"8th value");
			verifyExists(Taxable_Premium_1_Value9,"9th value");
			TP9 = getTextFrom(Taxable_Premium_1_Value9);
			Report.LogInfo("Tax Premium 9th value", TP9, "PASS");
			verifyExists(Taxable_Premium_1_Value10,"10th value");
			TP10 = getTextFrom(Taxable_Premium_1_Value10);
			Report.LogInfo("Tax Premium 10th value", TP10, "PASS");
			verifyExists(Taxable_Premium_1_Value11,"11th value");
			TP11 = getTextFrom(Taxable_Premium_1_Value11);
			Report.LogInfo("Tax Premium 11th value", TP11, "PASS");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			//deleteBorderEAUX();
			if(isVisible(ReviewBtn)==true) {
				AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
		        deleteBorderEAUX(); 
	}else
		{
			Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
		}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			//goBack();
			deleteBorderEAUX();				
		}
	}

	public void TC4477_CalculateTaxWithOutadditonalTax() throws Exception
	{
		String subSheet = "Automation Risk Format 18";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();

		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		policy.contractId = ReturnContractID();
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation_4477.xlsx\",\"UniqueFileName\":\"S48199420180501.xlsx\",\"BordereauFormatId\":\"bfb1179e-38d5-4be6-be5c-3d30713a6487\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48199420180501.xlsx\",\"Filesize\":23199,\"Path\":null,\"size\":23199,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4477Path = fpath+"\\src\\test\\resources\\testdata\\Taxes calculation_4477.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3216Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet4477Path);
		
		String Ufname = "S80922120180927.xlsx";	
		int size = 23199;
		String BordreauID = "bfb1179e-38d5-4be6-be5c-3d30713a6487";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();

			//Total Tax % Column 
			String TotalTax_Percolumn="@xpath=//*[@data-field='Tax_Total_Percent']";
			String TotalTaxcolumn_Value1="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][1]";
			String TotalTaxcolumn_Value2="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][2]";
			String TotalTaxcolumn_Value3="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][3]";
			String TotalTaxcolumn_Value4="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][4]";
			String TotalTaxcolumn_Value5="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][5]";
			String TotalTaxcolumn_Value6="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][6]";
			String TotalTaxcolumn_Value7="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][7]";
			String TotalTaxcolumn_Value8="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][8]";
			String TotalTaxcolumn_Value9="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][9]";
			String TotalTaxcolumn_Value10="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][10]";
			String TotalTaxcolumn_Value11="@xpath=//*[@data-field='Tax_Total_Percent']//following::td[contains(@ng-click,'Tax_Total_Percent')][11]";
			waitForElementToAppear(TotalTax_Percolumn,20);
			mouseOverAction(TotalTax_Percolumn);
			verifyMustExists(TotalTax_Percolumn,"Total Tax Percentage column");
			sleep(2000);
			verifyExists(TotalTaxcolumn_Value1,"1st value");
			verifyExists(TotalTaxcolumn_Value2,"2nd value");
			verifyExists(TotalTaxcolumn_Value3,"3rd value");
			verifyExists(TotalTaxcolumn_Value4,"4th value");
			verifyExists(TotalTaxcolumn_Value5,"5th value");
			verifyExists(TotalTaxcolumn_Value6,"6th value");
			verifyExists(TotalTaxcolumn_Value7,"7th value");
			verifyExists(TotalTaxcolumn_Value8,"8th value");
			verifyExists(TotalTaxcolumn_Value9,"9th value");
			verifyExists(TotalTaxcolumn_Value10,"10th value");
			verifyExists(TotalTaxcolumn_Value11,"11th value");
			sleep(2000);
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			//deleteBorderEAUX();
			if(isVisible(ReviewBtn)==true) {
				AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
		        deleteBorderEAUX(); 
	}else
		{
			Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
		}
		}
		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			goBack();
			deleteBorderEAUX();				
		}
	}

	public void CalculateTaxWithadditonalTax_TC4478() throws Exception
	{
		String subSheet = "Automation Risk Format 19";

		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();

		applyFilterPolicy(policy.PolicyNumber);
		//applyFilterPolicy("754992RB");

		openSelectedPolicy();
		policy.contractId = ReturnContractID();
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Taxes calculation -TC_4478.xlsx\",\"UniqueFileName\":\"S27018920180501.xlsx\",\"BordereauFormatId\":\"0643c0e3-3694-496a-b90c-ea0feba064f6\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S27018920180501.xlsx\",\"Filesize\":23202,\"Path\":null,\"size\":23202,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		SubmitBordereaux(subSheet);

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4478Path = fpath+"\\src\\test\\resources\\testdata\\Taxes calculation -TC_4478.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection filePath = new StringSelection(sheet3216Path);
		//UploadFile(filePath);
		File excelFile = new File(sheet4478Path);  
		
		String Ufname = "S67385720180927.xlsx";	
		int size = 23202;
		String BordreauID = "0643c0e3-3694-496a-b90c-ea0feba064f6";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(isVisible(ReviewBtn)== true){
			Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
			openDATALink();
			navigateToDATARiskTab();

			//Tax 1 Column 
			String Tax_1column="@xpath=//*[@data-field='Tax_1']";
			String Tax_1columnValue="@xpath=//*[@data-field='Tax_1']//following::tr[1]//td[contains(@ng-click,'Tax_1')]";
			String Tax_2columnValue="@xpath=//*[@data-field='Tax_2']//following::tr[1]//td[contains(@ng-click,'Tax_2')]";
			String TotalTaxcolumn_Value="@xpath=//*[@data-field='Tax_Total']//following::tr[1]//td[contains(@ng-click,'Tax_Total')]";

		
			TTax1 = getTextFrom(Tax_1columnValue);
			Report.LogInfo("TotalTax 2n value", TTax1, "PASS");
			
			TTax2 = getTextFrom(Tax_2columnValue);
			Report.LogInfo("TotalTax 2n value", TTax1, "PASS");
			
			sleep(2000);
			mouseOverAction(Tax_1columnValue);
			String Tax1 = getTextFrom(Tax_1columnValue).replace(".00", "");
			mouseOverAction(Tax_2columnValue);
			String Tax2 = getTextFrom(Tax_2columnValue).replace(".00", "");
			int Total_Tax = Integer.parseInt(Tax1)+Integer.parseInt(Tax2);
			//System.out.println(Tax1);
			//System.out.println(Tax2);
			//System.out.println(Total_Tax);
			mouseOverAction(TotalTaxcolumn_Value);
			String Total_TaxActualValue = getTextFrom(TotalTaxcolumn_Value).replace(".00", "");
			//System.out.println(Total_TaxActualValue);
			if(Integer.toString(Total_Tax).equals(Total_TaxActualValue))
			{
				Report.LogInfo("ValidateTotalTax", "Total Tax value is correct", "Pass");
			}
			else{
				Report.LogInfo("ValidateTotalTax", "Total Tax value is not correct", "Fail");
			}


			String Tax_1_Percentage_columnValue="@xpath=//*[@data-field='Tax_Percent_1']//following::tr[1]//td[contains(@ng-click,'Tax_Percent_1')]";
			String Tax_2_Percentage_columnValue="@xpath=//*[@data-field='Tax_Percent_2']//following::tr[1]//td[contains(@ng-click,'Tax_Percent_2')]";
			String TotalTax_Percent_columnValue="@xpath=//*[@data-field='Tax_Total_Percent']//following::tr[1]//td[contains(@ng-click,'Tax_Total_Percent')][text()='11.00 %']";

			mouseOverAction(Tax_1_Percentage_columnValue);
			String Tax1_per =getTextFrom(Tax_1_Percentage_columnValue).replace("%", "");
			mouseOverAction(Tax_2_Percentage_columnValue);
			String Tax2_per = getTextFrom(Tax_2_Percentage_columnValue).replace("%", "");
			float Total_Tax_per =Float.parseFloat(Tax1_per)+Float.parseFloat(Tax2_per);
			mouseOverAction(TotalTax_Percent_columnValue);
			String Total_Per_Tax = Float.toString(Total_Tax_per);
			String Total_Tax_perActualValue = getTextFrom(TotalTax_Percent_columnValue).replace("0 %", "");

			if(Total_Per_Tax.equals(Total_Tax_perActualValue))
			{
				Report.LogInfo("ValidateTotalTax", "Total Tax % value is correct", "Pass");
			}
			else{
				Report.LogInfo("ValidateTotalTax", "Total Tax % value is not correct", "Fail");
			}
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			//deleteBorderEAUX();	
			if(isVisible(ReviewBtn)==true) {
				AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
				Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
		        deleteBorderEAUX(); 
	}else
		{
			Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");	
		}
		}

		else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			policy.navigationOnBordereauxTab();
			refreshUploadedFile();
			deleteBorderEAUX();				
		}		
	}


	public void recordsinContract_5308() throws Exception{
		String UniqueReferenceVal1 = "Automation 11"+getCurrentDateTimeMS();
		String UniqueReferenceVal2 = "Automation 22"+getCurrentDateTimeMS();
		String IncDate = "01/01/2017";
		String ExpDate="31/12/2017";
		String IncDate1 = "01/01/2017";
		String ExpDate1="31/12/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String subSheet = "Automation Risk Format 10";
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(subSheet);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		BQPage.nextStapeClick();
		BQPage.FormatId = ReturnFormatID();
		policy.CreateContractwithInceptionDate2018();
		applyFilterPolicy(policy.PolicyNumber);
		openSelectedPolicy();
		waitForElementToAppear(MainEditdot,3);
		verifyMustExists(MainEditdot,"Edit dot");
		click(MainEditdot,"Edit dot");
		waitForElementToAppear(CreateContract,3);
		verifyMustExists(CreateContract,"Create Contract");
		click(CreateContract,"Create Contract");
		sleep(2000);
		policy.CreateContractwith2017();
		
		waitForElementToAppear(SelectDropDownforContract,3);
		verifyMustExists(SelectDropDownforContract,"Create Contract");
		click(SelectDropDownforContract,"Create Contract");
		
		waitForElementToAppear(SelectContract,3);
		verifyMustExists(SelectContract,"Create Contract");
		click(SelectContract,"Create Contract");
		policy.navigationOnBordereauxTab();
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5308Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5308.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5308Path);  
		
		String Ufname = "S84564820181001.xlsx";	
		int size = 25103;
		String BordreauID = "dbfdd51a-2436-4601-a8c3-5808ffc851f0";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
       
		//String payload ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5308.xlsx\",\"UniqueFileName\":\"S10353620180508.xlsx\",\"BordereauFormatId\":\"dbfdd51a-2436-4601-a8c3-5808ffc851f0\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+policy.contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10353620180508.xlsx\",\"Filesize\":25103,\"Path\":null,\"size\":25103,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		refreshUploadedFile();
		if(checkErrorReviewButton(ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error", "PASS");
			if(isVisible(TransformationErrorScreen)== true){
				Report.LogInfo("ValidateExpectedScreen", "Expected Error Screen Displayed", "PASS");
				verifyMustExists(TransformationErrorScreen,"Transformation Error Screen");
				TransformationScreen =  getTextFrom(TransformationErrorScreen);	
				Report.LogInfo("Transformation Error Screen", TransformationScreen, "PASS");
				sleep(1000);
				verifyMustExists(UMRWrdVerify,"Verify UMR in Error Screen");
				Report.LogInfo("UMR is verified on Error Screen","Unique Market Reference","PASS");
				sleep(1000);
				verifyMustExists(UMRMultiValue,"Verify Multi Contract UMR");
				Report.LogInfo("UMR value is verified on Error Screen","Unique Market Reference value","PASS");
				waitForElementToAppear(YesBtn,3);
				click(YesBtn,"Yes Radio button");
				sleep(2000);
				waitForElementToAppear(ContinueProcessingBodrBtn,3);
				verifyMustExists(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
				click(ContinueProcessingBodrBtn,"Continue Processing Bordereau");
				refreshUploadedFile();
				if(isVisible(ReviewBtn)== true){
					AssertBordereauStatusReview =  getTextFrom(ReviewBtn);	
					Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
					openDATALink();
					navigateToDATARiskTab();
					//Year OF Account
					String YearOfAccountColumn ="@xpath=//*[@data-field='YearOfAccount']";
					String YearOfAccountValue1 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[1]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue2 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[2]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue3 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[3]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue4 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[4]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					String YearOfAccountValue5 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[5]//td[contains(@ng-click,'YearOfAccount')][text()='2018']";
					waitForElementToAppear(YearOfAccountColumn,5);
					mouseOverAction(YearOfAccountColumn);
					verifyMustExists(YearOfAccountColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(YearOfAccountValue1,"1st value");
					YOA1 =  getTextFrom(YearOfAccountValue1);	
					verifyExists(YearOfAccountValue2,"2st value");
					YOA2 =  getTextFrom(YearOfAccountValue2);	
					verifyExists(YearOfAccountValue3,"3st value");
					YOA3 =  getTextFrom(YearOfAccountValue3);	
					verifyExists(YearOfAccountValue4,"4st value");
					verifyExists(YearOfAccountValue5,"5st value");
					sleep(2000);
					//Risk Reference 
					String RiskReferenceColumn ="@xpath=//*[@data-field='RiskReference']";
					String RiskReference1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')][text()='10']";
					String RiskReference2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')][text()='6']";
					String RiskReference3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')][text()='7']";
					String RiskReference4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')][text()='8']";
					String RiskReference5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')][text()='9']";
					waitForElementToAppear(RiskReferenceColumn,5);
					mouseOverAction(RiskReferenceColumn);
					verifyMustExists(RiskReferenceColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(RiskReference1,"1st value");
					RF1 =  getTextFrom(RiskReference1);	
					verifyExists(RiskReference2,"2st value");
					RF2 =  getTextFrom(RiskReference2);	
					verifyExists(RiskReference3,"3st value");
					RF3 =  getTextFrom(RiskReference3);	
					verifyExists(RiskReference4,"4st value");
					RF4 =  getTextFrom(RiskReference4);	
					verifyExists(RiskReference5,"5st value");
					RF5 =  getTextFrom(RiskReference5);	
					sleep(2000);
					policy.navigateContarctDetailsTab();
					sleep(2000);
					waitForElementToAppear(MultiContractBtn,5);
					verifyMustExists(MultiContractBtn,"Multicontract selection btn");
					click(MultiContractBtn,"Multicontract selection btn");
					waitForElementToAppear(Contract2017,5);
					verifyMustExists(Contract2017,"2017 contract option");
					click(Contract2017,"2017 contract option");
					sleep(2000);
					openDATALink();
					navigateToDATARiskTab();
					//Year OF Account
					String YearOfAccount2017Value1 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[1]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value2 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[2]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value3 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[3]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value4 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[4]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					String YearOfAccount2017Value5 ="@xpath=//*[@data-field='YearOfAccount']//following::tr[5]//td[contains(@ng-click,'YearOfAccount')][text()='2017']";
					waitForElementToAppear(YearOfAccountColumn,5);
					mouseOverAction(YearOfAccountColumn);
					verifyMustExists(YearOfAccountColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(YearOfAccount2017Value1,"1st value");
					YO1 =  getTextFrom(YearOfAccount2017Value1);	
					verifyExists(YearOfAccount2017Value2,"2st value");
					YO2 =  getTextFrom(YearOfAccount2017Value2);	
					verifyExists(YearOfAccount2017Value3,"3st value");
					YO3 =  getTextFrom(YearOfAccount2017Value3);	
					verifyExists(YearOfAccount2017Value4,"4st value");
					verifyExists(YearOfAccount2017Value5,"5st value");
					sleep(2000);
					//Risk Reference 
					String RiskReference2017value1 ="@xpath=//*[@data-field='RiskReference']//following::tr[1]//td[contains(@ng-click,'RiskReference')][text()='1']";
					String RiskReference2017value2 ="@xpath=//*[@data-field='RiskReference']//following::tr[2]//td[contains(@ng-click,'RiskReference')][text()='2']";
					String RiskReference2017value3 ="@xpath=//*[@data-field='RiskReference']//following::tr[3]//td[contains(@ng-click,'RiskReference')][text()='3']";
					String RiskReference2017value4 ="@xpath=//*[@data-field='RiskReference']//following::tr[4]//td[contains(@ng-click,'RiskReference')][text()='4']";
					String RiskReference2017value5 ="@xpath=//*[@data-field='RiskReference']//following::tr[5]//td[contains(@ng-click,'RiskReference')][text()='5']";
					waitForElementToAppear(RiskReferenceColumn,5);
					mouseOverAction(RiskReferenceColumn);
					verifyMustExists(RiskReferenceColumn,"Total Tax Percentage column");
					sleep(2000);
					verifyExists(RiskReference2017value1,"1st value");
					REF1 =  getTextFrom(RiskReference2017value1);	
					verifyExists(RiskReference2017value2,"2st value");
					REF2 =  getTextFrom(RiskReference2017value2);	
					verifyExists(RiskReference2017value3,"3st value");
					REF3 =  getTextFrom(RiskReference2017value3);	
					verifyExists(RiskReference2017value4,"4st value");
					REF4 =  getTextFrom(RiskReference2017value4);	
					verifyExists(RiskReference2017value5,"5st value");
					REF5 =  getTextFrom(RiskReference2017value5);	
					sleep(2000);
				}else{
					Report.LogInfo("StatusCheck", "Review status not displayed.", "FAIL");
				}
			}else{
				Report.LogInfo("ValidateExpectedScreen", "Expected Error Screen not Displayed", "FAIL");
				goBack();	
			}
		}else{
			Report.LogInfo("ValidateReviewError", "Review Error Status not displayed.", "FAIL");				
		}
	}

	//----------------------------------Reusable fuctions for Sequence Rule---------------------------------//
	//-------------------------------------------------------------------------------------------------------//


	public void refreshAfterUploadedFileForReviewSatusAndUploadStatus() throws Exception
	{
		navigateOnProcessingTab(); 

		for(int i= 0; i<=25; i++)
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			if(isVisible(ReviewError) || isVisible(UploadedButton)){
				//VerifyNotificationPopupAfterUpload();
				break;
			}
		}
	}

	public void uploadedDeleteButton(String status){
		verifyMustExists(UploadedDeleteButton,"UploadedDeleteButton");
		sleep(1500);
		webDriver.findElement(By.xpath("//button[text()='"+status+"']//following-sibling::span[1]/i")).click();
		waitForElementToAppear(UploadedDeleteYESButton,2);
		verifyMustExists(UploadedDeleteYESButton,"UploadedDeleteYESButton");
		click(UploadedDeleteYESButton,"UploadedDeleteYESButton");
		sleep(2000);
		Report.LogInfo("UploadedDeleteStatus", "UPLOADED status deleted successfully", "PASS");

	}

	public void navigateToDATARiskTab()
	{

		waitForElementToAppear(DATARiskTab,5);
		verifyMustExists(DATARiskTab,"Risk Tab");
		click(DATARiskTab,"Click on Risk Tab");
		sleep(3000);

	}

	public void yoaErrorScreenProcessing()
	{

		if(isVisible(discardRecords)== true){
			//verifyMustExists(discardRecords,"discard records button");
			verifyOptionalExists(ErrorScreenMsg,"Year of Account Errors");
			verifyMustExists(continuebtx,"Continue button");
			click(continuebtx,"Continue button");
			waitForElementToAppear(yearAccount,5);
			verifyMustExists(yearAccount,"Year Account field.");
			clearTextBox(yearAccount);//1 row
			sendKeys(yearAccount,"2017","Year Account field.");//1 row
			verifyMustExists(yearAccount1,"Year Account1 field.");
			clearTextBox(yearAccount1);//2 row
			sendKeys(yearAccount1,"2017","Year Account1 field.");//2 row
			sleep(2000);
			verifyBackground(yearAccount,"rgba(0, 97, 0, 1)");// 1 row
			verifyBackground(inceptionDate1,"rgba(0, 97, 0, 1)");
			verifyBackground(yearAccount1,"rgba(0, 97, 0, 1)");// 2 row
			verifyBackground(inceptionDate2,"rgba(0, 97, 0, 1)");
			verifyMustExists(continuebtn,"Continue button");
			click(continuebtn,"Continue button");
		}else{
			Report.LogInfo("ValidateErrorScreen", "Error screen page not displayed.", "FAIL");
			goBack();
			deleteBorderEAUX();		
		}

	}

	public static final String ApprovedButton = "@xpath=//button[text()='Approved']";
	public void refreshUploadedFileApprovedStatus() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(ApprovedButton)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFileForApproved() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(Approvedbtn)==false) && (totalTime < 90000));
	}

	public void refreshUploadedFileForApprovedScndRw() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ApprovedbtnSncdRw)==false) && (totalTime < 90000));
	}

	public void refreshUploadedFileForApprovedthirdRw() throws Exception
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ApprovedbtnThirdRw)==false) && (totalTime < 90000));
	}


	public void refreshUploadedFile1() throws Exception
	{
		St1.navigateOnProcessingTab();

		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload1,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(ReviewError)==false) && (isVisible(ReviewBtn)==false) && (totalTime < 180000));
	}

	public void OnViewDiscardedRecordsIcon()
	{
		waitForElementToAppear(ViewDiscardedRecordsIcon,10);
		verifyMustExists(ViewDiscardedRecordsIcon,"View Discarded Record's Icon");
		click(ViewDiscardedRecordsIcon,"View Discarded Record's Icon");
		sleep(3000); 
		
	}

	public void applyReferenceDataFilter(String DataName) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+DataName+"']";
		sleep(2000);
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(ReferenceDataFilterIcon, "Reference Data Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,DataName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}
	public void applyDataSetFilter(String DataName) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=[value='"+DataName+"']";
		sleep(2000);
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(ReferenceDataFilterIcon, "Reference Data Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,DataName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterButton,"Filter Button");
		click(FilterButton,"Filter Button");
		sleep(3000);
	}

	public void navigateOnProcessingTab(){
		waitForElementToAppear(Processingtab,5);
		verifyExists(Processingtab,"Processing Link");
		click(Processingtab,"Processing Link");
		sleep(2000); 
	}

	public void refreshAfterApproveFile(String ExpectedLocator) throws Exception
	{
		verifyExists(ApprovedTab,"Approved Tab");
		click(ApprovedTab,"Approved Tab");
		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;  
		do
		{
			sleep(3000);
			javaScriptclick(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;   
		}while((isVisible(ExpectedLocator)==false) && (totalTime < 180000));

	}


	public void refreshUploadedFileForApprovalStatus() throws Exception{
		sleep(1500);
		waitForElementToAppear(Processingtab,5);
		verifyExists(Processingtab,"Processing Link");
		javaScriptclick(Processingtab,"Processing Link");
		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;	
			sleep(1000);
		}while((isVisible(ForApprovalButton)==false) && (totalTime < 180000));
	}

	public void refreshUploadedFileForUploadedStatus() throws Exception{
		waitForElementToAppear(Processingtab,5);
		verifyExists(Processingtab,"Processing Link");
		click(Processingtab,"Processing Link");
		long startTime = System.currentTimeMillis();
		long endTime;
		long totalTime;		
		do
		{
			sleep(3000);
			click(RefreshAfterUpload,"Refresh After File Upload");
			//VerifyNotificationPopupAfterUpload();
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;			
		}while((isVisible(UploadedButton)==false) && (totalTime < 180000));
	}

	public void navigationOnRoleTab()
	{
		waitForElementToAppear(Roletab,5);
		verifyMustExists(Roletab,"Role Tab");
		click(Roletab,"Role Tab");
	}

	public static final String ReportingChannelfilterIcon="@xpath=//th[@data-field='ReportingChannelIdentifier']//span[@class='k-icon k-i-filter']";
	/*public void applyReportingChannelIdentifyFilter(String Channel) throws InterruptedException{
		 	sleep(1500);
		   int i=0;
		   String RecordCheckbox ="@css=input[value='"+Channel+"']";
		   javaScriptWait();
		   do
		   {
		    if(i>0)
		    {
		     refreshPage();
		     javaScriptWait();
		    }
		    clickAndWait(ReportingChannelfilterIcon, "Reporting Channel Identify Filter Icon");
		    sleep(2000);
		    if(isVisible(SearchText))
		    {
		     verifyMustExists(SearchText,"Search Filter Textbox"); 
		     sendKeys(SearchText,Channel,"Search Filter Textbox.");
		     sleep(2000);
		    }
		    i++;
		   }while(!isVisible(RecordCheckbox) && i<5);
		   click(RecordCheckbox, "Searched Record Checkbox");
		   String StatusfilterBtn = "@xpath=//input[@value='"+Channel+"']//following::button[@type='submit']";
		   verifyExists(StatusfilterBtn,"Filter Button");
		   click(StatusfilterBtn,"Filter Button");
		   sleep(3000);
		  }*/

	//public static final String ReportingChannelfilterIcon="@xpath=//th[@data-field='ReportingChannelIdentifier']//span[@class='k-icon k-i-filter']";
	public static final String DATACreditControlTab="@xpath=//*[text()='Credit Control']";
	



	public void checkDeleteButtonMissingRowwise(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//button//following-sibling::span[1]/i";
			if(isVisible(Deletebtn)==false)
			{
				Report.LogInfo("ButtonCheck", "Delete button not displayed", "PASS");
			
			}else{
				Report.LogInfo("ButtonCheck", "Delete button displayed", "FAIL");
				DeletebuttonNotVisible = "FAIL";
			}
		}
	}
public String DeleteButtonPresent;
	public void checkDeleteButtonpresentRowwise(){
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String Deletebtn = "@xpath=//tr["+a+"]//button//following-sibling::span[1]/i";
			if(isVisible(Deletebtn)==true)
			{
				Report.LogInfo("ButtonCheck", "Delete button displayed", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "Delete button not displayed", "FAIL");
				DeleteButtonPresent = "FAIL";
			}
		}
	}
public String StatusButtonClickable;
	public void statusButtonNotclickableCheckRowwise() throws InterruptedException{
		List <WebElement> totatRecords = findWebElements(TotalRowCountAfterFiltered);
		int recordsCount = totatRecords.size();
		for(int a=1;a<=recordsCount;a++){	
			String statusbtn = "@xpath=//tr["+a+"]//td[2]//button";
			click(statusbtn,"Status button");
			sleep(2000);
			if(isVisible(statusbtn)==true)
			{
				Report.LogInfo("ButtonCheck", "status button not clickable", "PASS");
			}else{
				Report.LogInfo("ButtonCheck", "status button clickable", "FAIL");
				StatusButtonClickable = "FAIL";
				goBack();
				//applyBordereauTypeFilter(type);
			}
		}
	}

	public void applyReportingChannelIdentifyFilter(String Channel) throws InterruptedException{

		int i=0;
		String RecordCheckbox ="@css=input[value='"+Channel+"']";
		javaScriptWait();
		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(ReportingChannelfilterIcon, "Reporting Channel Identify Filter Icon");
			sleep(2000);
			if(isVisible(SearchText))
			{
				verifyMustExists(SearchText,"Search Filter Textbox");	
				sendKeys(SearchText,Channel,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);
		click(RecordCheckbox, "Searched Record Checkbox");
		String StatusfilterBtn = "@xpath=//input[@value='"+Channel+"']//following::button[@type='submit']";
		verifyExists(StatusfilterBtn,"Filter Button");
		click(StatusfilterBtn,"Filter Button");
		sleep(3000);
	}

	public void navigateToDATACreditControlTab()
	{
		waitForElementToAppear(DATACreditControlTab,5);
		verifyMustExists(DATACreditControlTab,"Credit control Tab");
		click(DATACreditControlTab,"Click on credit control Tab");
		sleep(3000);
	}

	public void navigateToApprovedTab()
	{
		waitForElementToAppear(ApprovedTab,5);
		verifyMustExists(ApprovedTab,"Approve Tab");
		click(ApprovedTab,"Approve Tab");
		sleep(2000);
	}
	public void VerifyReferenceColumn(){
		
		verifyMustExists(RiskReferenceTxt,"Risk Reference");
		verifyMustExists(CellTxt,"Cell");
		verifyMustExists(ORIGINALVALUETxt,"ORIGINAL VALUE");
		verifyMustExists(Enrichedvaluetxt,"Enriched Value");
		
	}
	public String ActualErrorMsg;
	public void verifySequenceRuleErrorScreen(String ExpectedErrorMsg )
	{
		verifyExists(ErrorScreenMsg,"Error Screen Message");
		 ActualErrorMsg=getTextFrom(ErrorScreenMsg);
		if(ActualErrorMsg.equals(ExpectedErrorMsg))
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message validate successfully", "PASS");	
			verifyMustExists(RevertToUploaded,"Cancel Processing And Delete Bordereau");
			click(RevertToUploaded," Click on Cancel Processing And Delete Bordereau");	
			sleep(6000);
			refreshPage();
			deleteBorderEAUX();	
		}
		else
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message not validate successfully", "Fail");
			goBack();
			sleep(3000);
			deleteBorderEAUX();				
		}

	}
	
	public void verifyNoHeaderErrorScreen(String ExpectedErrorMsg )
	{
		
		verifyExists(ErrorScreenMsg,"Error Screen Message");
		 ActualErrorMsg=getTextFrom(ErrorScreenMsg);
		if(ActualErrorMsg.equals(ExpectedErrorMsg))
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message validate successfully", "PASS");	
			verifyMustExists(Pausebtn1,"Cancel Processing And Delete Bordereau");
			click(Pausebtn1," Click on Cancel Processing And Delete Bordereau");	
			sleep(6000);
			refreshPage();
			deleteBorderEAUX();	
		}
		else
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message not validate successfully", "Fail");
			goBack();
			sleep(3000);
			deleteBorderEAUX();				
		}

	}
	public void verifyNoHeaderErrorScreen2(String ExpectedErrorMsg )
	{
		
		verifyExists(ErrorScreenMsg3,"Error Screen Message");
		 ActualErrorMsg=getTextFrom(ErrorScreenMsg3);
		 
		 
		if(ActualErrorMsg.equals(ExpectedErrorMsg))
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message validate successfully", "PASS");	
			verifyMustExists(Pausebtn1,"Cancel Processing And Delete Bordereau");
			click(Pausebtn1," Click on Cancel Processing And Delete Bordereau");	
			sleep(6000);
			refreshPage();
			deleteBorderEAUX();	
		}
		else
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message not validate successfully", "Fail");
			goBack();
			sleep(3000);
			deleteBorderEAUX();				
		}

	}
	

	public void verifyNoHeaderErrorScreen1(String ExpectedErrorMsg )
	{
		verifyExists(ErrorScreenMsg3,"Error Screen Message");
		 ActualErrorMsg=getTextFrom(ErrorScreenMsg3);
		if(ActualErrorMsg.equals(ExpectedErrorMsg))
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message validate successfully", "PASS");	
			verifyMustExists(Pausebtn1,"Cancel Processing And Delete Bordereau");
			click(Pausebtn1," Click on Cancel Processing And Delete Bordereau");	
			sleep(6000);
			refreshPage();
			deleteBorderEAUX();	
		}
		else
		{
			Report.LogInfo("ValidateErrorMsg", "Error Message not validate successfully", "Fail");
			goBack();
			sleep(3000);
			deleteBorderEAUX();				
		}

	}
	public void VerifyApproved()
	{
	waitForElementToAppear(ApprovedTab,5);
	verifyMustExists(ApprovedTab,"Approve Tab");
	click(ApprovedTab,"Approve Tab");
	
	waitForElementToAppear(ApprovedButton,5);
	verifyMustExists(ApprovedButton,"Approve Tab");
	AssertBordereauStatusApproved =  getTextFrom(ApprovedButton);
	Report.LogInfo("Approved status dispalyed", AssertBordereauStatusApproved, "PASS");
	}
	

	
	
	public void IgnoreHiddenSheet_TC1075() throws Exception
	{
		
	String subSheet1 = "Automation Company Admin 1 Risk Format 13 (Lloyd's Property Schema)";
	String subSheet2 = "Automation Company Admin 1 Risk Format 13";
	String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
	policy.CreateContractwithInceptionDate2018();
	
	
    //applyFilterPolicy("958844QP");
  applyFilterPolicy(policy.PolicyNumber);
    
	openSelectedPolicy();
	SubmitBordereaux(subSheet1);
	
	String GetData = Configuration.url+"/api/Contract/GetAllPage";
	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"958844QP"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	try 
	{
		String fpath = new File(".").getCanonicalPath();
		Sheet1075Path = fpath+"\\src\\test\\resources\\testdata\\HiddenSheet_April_A.xlsx";
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	File excelFile = new File(Sheet1075Path);  
	contractId = addNewBordereauFormatPolicy(payload1, GetData);
	//Id\":\""+contractId+"\",\"Id\":\
	
	String Ufname = "S72540120180528.xlsx";	
	int size = 23807;
	String BordreauID = "bd8a6d34-a9a2-4548-a141-0a36faf8eb16";
    String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
    String ID = extractIDFromResponseinsideContract(response); 
    String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
    addAsDraft(payload,DraftUrl);
    
	refreshUploadedFile();
	String SheetName="@xpath=//*[@data-field='SheetName']";
	AssertBordereauStatusReview = getTextFrom(ReviewBtn);
	if(isVisible(ReviewBtn)==true){
		Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
		sleep(2000);
		verifyMustExists(ReviewBtn,"Review button");
		openDATALink();
		navigateToDATARiskTab();
		
		//String MissingSheet="@xpath=//*[@data-field='SheetName']//following::tr[1]//td[contains(@ng-click,'SheetName')][text()='April 2018']";
		
		waitForElementToAppear(SheetName,20);
		mouseOverAction(SheetName);
		verifyMustExists(SheetName,"Sheet name column");
		click(SheetName);
		Thread.sleep(2000);
		  String Sheetname= "@xpath=//tr[1]//td[contains(@ng-click,'2') and contains(@ng-click,'SheetName')]";
		  ExpectedResult_1075 = getTextFrom(Sheetname);
		if(ExpectedResult_1075.equals("April 2018"))
		{
			Report.LogInfo("Result", "Sheet April 2018 Found", "Fail");	
		}
		else
		{
			Report.LogInfo("Result", "Sheet April 2018 Not Found", "Pass");	
		}
	}
	else{

		Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
		deleteBorderEAUX();
	}
		
	}
	
//================================= TC 1072 Start ================================	
	
	public void HeaderWidestRow_TC1072() throws Exception
	{
		
	String subSheet1 = "Automation Company Admin 1 Risk Format 14 (Lloyd's Property Schema)";
	
	String subSheet2 = "Automation Company Admin 1 Risk Format 14";
	String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
	policy.CreateContractwithInceptionDate2018();
	
   // applyFilterPolicy("568217HX");
   applyFilterPolicy(policy.PolicyNumber);
    
	openSelectedPolicy();
	SubmitBordereaux(subSheet1);
	
	String GetData = Configuration.url+"/api/Contract/GetAllPage";
	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	//	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"568217HX"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
	try 
	{
		String fpath = new File(".").getCanonicalPath();
		Sheet1072Path = fpath+"\\src\\test\\resources\\testdata\\Widest_Row_TC1072_1.xlsx";
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	File excelFile = new File(Sheet1072Path);  
	contractId = addNewBordereauFormatPolicy(payload1, GetData);
	String Ufname = "S93136720180529.xlsx";	
	int size = 23682;
	String BordreauID = "f4f8a6d0-87de-4bac-894c-5688d5ba4f0c";
    String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
    String ID = extractIDFromResponseinsideContract(response); 
    String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
    addAsDraft(payload,DraftUrl);

	refreshUploadedFile();
	AssertBordereauStatusReview = getTextFrom(ReviewBtn);
	if(isVisible(ReviewBtn)==true){
		
		Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
		openDATALink();
		navigateToDATARiskTab();
		sleep(2000);
		String SecondRow="@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='2']";
		 Result_1072_01 = getTextFrom(SecondRow);
		
		if(Result_1072_01.equals("2"))
		{
			Report.LogInfo("Default header", "default header validation successful", "PASS");	
		}
		else
		{
			Report.LogInfo("Default header", "default header validation not successful", "FAIL");	
		}
		
	}
	else{

		Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
	}
	
	//==========================2nd sheet uploading will start====================
	
	SubmitBordereaux(subSheet1);
	
	try 
	{
		String fpath = new File(".").getCanonicalPath();
		Sheet1072Path = fpath+"\\src\\test\\resources\\testdata\\Widest_Row_TC1072_2.xlsx";
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	File excelFilee = new File(Sheet1072Path);  
	
	//String payloadd = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Widest_Row_TC1072_2.xlsx\",\"UniqueFileName\":\"S90661520180529.xlsx\",\"BordereauFormatId\":\"9013a773-c496-4737-b1b7-47b8fa138318\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S90661520180529.xlsx\",\"Filesize\":23714,\"Path\":null,\"size\":23714,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
	
	//HardCoded-> String payloadd = "{\"Bordereaux\":{\"ContractId\":\"c468b3f6-16d8-4c71-9c46-6f45ec955e34\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Widest_Row_TC1072_2.xlsx\",\"UniqueFileName\":\"S90661520180529.xlsx\",\"BordereauFormatId\":\"9013a773-c496-4737-b1b7-47b8fa138318\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S90661520180529.xlsx\",\"Filesize\":23714,\"Path\":null,\"size\":23714,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
	
	 Ufname = "S90661520180529.xlsx";	
	 size = 23714;
	 BordreauID = "f4f8a6d0-87de-4bac-894c-5688d5ba4f0c";
     response = uploadFileinContract(ReqUrl,excelFilee,contractId,Ufname);
     ID = extractIDFromResponseinsideContract(response); 
     payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
    addAsDraft(payload,DraftUrl);

    
    
	refreshUploadedFile();
	AssertBordereauStatusReview = getTextFrom(ReviewBtn);
	if(isVisible(ReviewBtn)==true){
		
		Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
		openDATALink();
		navigateToDATARiskTab();
		sleep(2000);
		String ThirdRow="@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='3']";
		 Result_1072_02 = getTextFrom(ThirdRow);
			
			if(Result_1072_02.equals("3"))
			{
				Report.LogInfo("header", "2nd row header validation successful", "PASS");	
			}
			else
			{
				Report.LogInfo("header", "2nd row header validation not successful", "FAIL");	
			}
		
	}
	else{

		Report.LogInfo("Validate Review Status", "Review status not displayed", "FAIL");
	}
	
	
	//==========================3rd sheet uploading will start====================
	
		
	    
		SubmitBordereaux(subSheet1);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			Sheet1072Path = fpath+"\\src\\test\\resources\\testdata\\Widest_Row_TC1072_3.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFilee2 = new File(Sheet1072Path);  
		
		 Ufname = "S36022520180529.xlsx";	
		 size = 23769;
		 BordreauID = "f4f8a6d0-87de-4bac-894c-5688d5ba4f0c";
	     response = uploadFileinContract(ReqUrl,excelFilee2,contractId,Ufname);
	     ID = extractIDFromResponseinsideContract(response); 
	     payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
	    addAsDraft(payload,DraftUrl);

	    
	    
		refreshUploadedFile();
		AssertBordereauStatusReview = getTextFrom(ReviewBtn);
		if(isVisible(ReviewBtn)==true){
			
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			openDATALink();
			navigateToDATARiskTab();
			sleep(2000);
			String FourthdRow="@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='4']";
			verifyExists(FourthdRow);
			Result_1072_03 = getTextFrom(FourthdRow);
			
			if(Result_1072_03.equals("4"))
			{
				Report.LogInfo("header", "3rd row header validation successful", "PASS");	
			}
			else
			{
				Report.LogInfo("header", "3rd row header validation not successful", "FAIL");	
			}
		}
		else{

			Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
		}
		
		//==========================4th sheet uploading will start====================
		
		
	    
			SubmitBordereaux(subSheet1);
				
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				Sheet1072Path = fpath+"\\src\\test\\resources\\testdata\\Widest_Row_TC1072_4.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	
			File excelFilee3 = new File(Sheet1072Path);  
			
			
			//String payloadd3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Widest_Row_TC1072_4.xlsx\",\"UniqueFileName\":\"S47222020180529.xlsx\",\"BordereauFormatId\":\"9013a773-c496-4737-b1b7-47b8fa138318\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47222020180529.xlsx\",\"Filesize\":23866,\"Path\":null,\"size\":23866,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			
			//HardCoded ->> String payloadd3 = "{\"Bordereaux\":{\"ContractId\":\"c468b3f6-16d8-4c71-9c46-6f45ec955e34\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Widest_Row_TC1072_4.xlsx\",\"UniqueFileName\":\"S47222020180529.xlsx\",\"BordereauFormatId\":\"9013a773-c496-4737-b1b7-47b8fa138318\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47222020180529.xlsx\",\"Filesize\":23866,\"Path\":null,\"size\":23866,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			 Ufname = "S47222020180529.xlsx";	
			 size = 23866;
			 BordreauID = "f4f8a6d0-87de-4bac-894c-5688d5ba4f0c";
		     response = uploadFileinContract(ReqUrl,excelFilee3,contractId,Ufname);
		     ID = extractIDFromResponseinsideContract(response); 
		     payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
		    addAsDraft(payload,DraftUrl);

		    
			refreshUploadedFile();
			
			String errorPage= "@xpath=//h2[@class='borderauSubtitle ng-binding'][text()='Header row(s) not identified']";
			
			AssertBordereauStatusReviewError = getTextFrom(ReviewError);
			if(checkErrorReviewButton(ReviewError)==true)
			{
				sleep(3000);
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error", "PASS");
				waitForElementToAppear(errorPage, 5);
				if(isVisible(errorPage)== true){
					errorPage_1072_03 = getTextFrom(errorPage);
				//	waitForElementToAppear(CancelAndDeleteBordereaux, 2);
					//verifyExists(CancelAndDeleteBordereaux);
				//	click(CancelAndDeleteBordereaux);
					verifyMustExists(input1072, "Header row number input location");
					
					sendKeys(input1072, "16","header row number");
					waitForElementToAppear(ContinueProcessingBtn, 5);
					verifyMustExists(ContinueProcessingBtn, "Process bordereaux button");
					click(ContinueProcessingBtn,"Process bordereaux button");
					Thread.sleep(1000);

					refreshUploadedFile();
					AssertBordereauStatusReview = getTextFrom(ReviewBtn);
					if(isVisible(ReviewBtn)==true){
						Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
						openDATALink();
						navigateToDATARiskTab();
						sleep(2000);
						String SeventeenthdRow="@xpath=//*[@data-field='RowNumber']//following::tr[1]//td[contains(@ng-click,'RowNumber')][text()='17']";
						
						Result_1072_04 = getTextFrom(SeventeenthdRow);
						if(Result_1072_04.equals("17"))
						{
							Report.LogInfo("header", "16th row header validation successful", "PASS");	
						}
						else
						{
							Report.LogInfo("header", "16th row header validation not successful", "FAIL");	
						}
					}
					else{

						Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
					}
	
					

					//Report.LogInfo("Validate header row not found screen", " header row not found screen displayed", "PASS");
				//	Report.LogInfo("16th widest row", "16th widest row validation successful", "PASS");
					
						                  }
										else{
											Report.LogInfo("Validate header row not found screen", " header row not found screen not displayed", "FAIL");
											deleteBorderEAUX();
											}
						}
						else {
							Report.LogInfo("review error status", "review error status not displayed", "FAIL");
							deleteBorderEAUX();
						}
			
			//==========================5th sheet uploading will start====================
			
			
			SubmitBordereaux(subSheet1);
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				Sheet1072Path = fpath+"\\src\\test\\resources\\testdata\\Widest_Row_TC1072_4.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFilee4 = new File(Sheet1072Path);  
			
			
		//	String payloadd4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Widest_Row_TC1072_4.xlsx\",\"UniqueFileName\":\"S47222020180529.xlsx\",\"BordereauFormatId\":\"9013a773-c496-4737-b1b7-47b8fa138318\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47222020180529.xlsx\",\"Filesize\":23866,\"Path\":null,\"size\":23866,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			
			//HardCoded->   String payloadd4 = "{\"Bordereaux\":{\"ContractId\":\"c468b3f6-16d8-4c71-9c46-6f45ec955e34\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Widest_Row_TC1072_4.xlsx\",\"UniqueFileName\":\"S47222020180529.xlsx\",\"BordereauFormatId\":\"9013a773-c496-4737-b1b7-47b8fa138318\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S47222020180529.xlsx\",\"Filesize\":23866,\"Path\":null,\"size\":23866,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			 Ufname = "S47222020180529.xlsx";	
			 size = 23866;
			 BordreauID = "f4f8a6d0-87de-4bac-894c-5688d5ba4f0c";
		     response = uploadFileinContract(ReqUrl,excelFilee3,contractId,Ufname);
		     ID = extractIDFromResponseinsideContract(response); 
		     payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
		    addAsDraft(payload,DraftUrl);

			refreshUploadedFile();
			
			String  errorPage1= "@xpath=//h2[@class='borderauSubtitle ng-binding'][text()='Header row(s) not identified']";
			 
			AssertBordereauStatusReviewError = getTextFrom(ReviewError);
			if(checkErrorReviewButton(ReviewError)==true)
			{
				
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error", "PASS");
				sleep(4000);
				waitForElementToAppear(errorPage1, 4);
				if(isVisible(errorPage1)== true){
					errorPage_1072_04 = getTextFrom(errorPage1); //for assert at test page
					waitForElementToAppear(pausebtn, 2);
					verifyMustExists(pausebtn, "Pause button");
				click(pausebtn,"Pause bordereau button");
				refreshUploadedFile();
				if (isVisible(ReviewError)==true)
				{
					Report.LogInfo("StatusCheck", "review error status found", "PASS");
				}else{
					Report.LogInfo("StatusCheck", "review error status not found", "FAIL");
				}
				
								 }
									else{
										Report.LogInfo("Validate header row not found screen", " header row not found screen not displayed", "FAIL");
										deleteBorderEAUX();
										}
						}
						else {
							Report.LogInfo("review error status", "review error status not displayed", "FAIL");
							deleteBorderEAUX();
						}
		        }
			
	
	public void GetFormatID(String QuestionnaireName) throws Exception
	{
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(QuestionnaireName);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		Thread.sleep(3000);
		 BQPage.FormatId = ReturnFormatID();
	}
	
	public void OpenQuestionnaire(String QuestionnaireName ) throws Exception
	{
		homePage.adminMenu();
		BQPage.bordereauQueLink();
		BQPage.bordereauQuePage();
		BQPage.filterBordereauQuestionnaire1(QuestionnaireName);
		sleep(2000);
		waitForElementToAppear(BQPage.EditBtn,5);
		verifyMustExists(BQPage.EditBtn,"Edit button");
		click(BQPage.EditBtn,"Edit button");
		Thread.sleep(3000);
	}
	
	public void ROE_TC1068() throws InterruptedException, Exception 
	{

		String subSheet1 = "Automation Company Admin 1 Claim Format 10 (Lloyd's Property Schema)";
		String subSheet2 = "Automation Company Admin 1 Claim Format 10";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateClaimContractwithInceptionDate2018();
		GetFormatID(subSheet2); // get format ID for specified sheet
		
	   // applyFilterPolicy("941029AC");
	    applyFilterPolicy(policy.PolicyNumber);
	    
		openSelectedPolicy();
		SubmitBordereaux(subSheet1);
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
    	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"941029AC"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			Sheet1068Path = fpath+"\\src\\test\\resources\\testdata\\ROE_CLAIM.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(Sheet1068Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//Id\":\""+contractId+"\",\"Id\":\
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_OtherFeesDescription.xlsx\",\"UniqueFileName\":\"S29916320180523.xlsx\",\"BordereauFormatId\":\"98cf018e-b38d-4086-ab3e-4359487cea40\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29916320180523.xlsx\",\"Filesize\":24158,\"Path\":null,\"size\":24158,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		
		String Ufname = "S44125020180527.xlsx";	
	    int size = 16037;
	    String BordreauID = BQPage.FormatId;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
       addAsDraft(payload,DraftUrl);
	
		
		refreshUploadedFile();
		String RateOfExchangeCol="@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']";

		if(checkErrorReviewButton(ReviewError)==true)
		{
			Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error", "PASS");
		
			if(isVisible(InvalidDecimalValue)== true){
				InvalidDecimaValErrorScreen = getTextFrom(InvalidDecimalValue);
				Report.LogInfo("ValidateExpectedScreen", "Expected Error Screen Displayed", "PASS");
				verifyMustExists(InvalidDecimalValue,"Invalid Decimal Value Error Screen");
				verifyMustExists(firstErrorROE, "ROE 1st row error ");  // error sscreen 1st error
				sendKeys(firstErrorROE, "10","ROE '10' value entered");
				verifyMustExists(SecondErrorROE, "ROE 2nd row error ");  // error sscreen 2st error
				sendKeys(SecondErrorROE, "20", "ROE '20' value entered");
				verifyMustExists(ThirdErrorROE, "ROE 3rd row error ");  // error sscreen 3st error
				sendKeys(ThirdErrorROE, "30", "ROE '30' value entered");
				
				verifyMustExists(continuebtx, "Continnue button of transformation error screen");
				click(continuebtx,"Continue button");
				waitForElementToAppear(Cancelbtn1, 5);
				verifyMustExists(Cancelbtn1, " cancel button of BDX summary screen");  // error sscreen 1st error
				click(Cancelbtn1,"Cancel button");
				refreshUploadedFile();
				sleep(3000);
				AssertBordereauStatusReview = getTextFrom(ReviewBtn);
					if(isVisible(ReviewBtn)== true){
						Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
						openDATALink();
						navigateToDATAClaimTab();
						waitForElementToAppear(RateOfExchangeCol,20);
						mouseOverAction(RateOfExchangeCol);
						verifyMustExists(RateOfExchangeCol,"Coverholder settlement ROE column");
						sleep(2000);
						mouseOverAction(SettlementROEValue1);
						//verifyExists(SettlementROEValue1,"Coverholder settlement ROE  - borderau value ");
						
						 Result_1068_01 = getTextFrom(SettlementROEValue1);
							
							if(Result_1068_01.equals("10.00"))
							{
								Report.LogInfo("DataField", " borderau value validation successful", "PASS");	
							}
							else
							{
								Report.LogInfo("DataField", " borderau value validation not successful", "FAIL	");	
							}
						
						
						sleep(2000);
						mouseOverAction(SettlementROEValue2);
						//verifyExists(SettlementROEValue2,"Coverholder settlement ROE - default value ");
						
						Result_1068_02 = getTextFrom(SettlementROEValue2);
						
						if(Result_1068_02.equals("20.00"))
						{
							Report.LogInfo("DataField", " default value  validation successful", "PASS");	
						}
						else
						{
							Report.LogInfo("DataField", "default value  validation not successful", "FAIL	");	
						}
						sleep(2000);
						mouseOverAction(SettlementROEValue3);
						//verifyExists(SettlementROEValue3,"Coverholder settlement ROE - Conditional default value");
						Result_1068_03 = getTextFrom(SettlementROEValue3);
						
						if(Result_1068_03.equals("30.00"))
						{
							Report.LogInfo("DataField", " Conditional default value  validation successful", "PASS");	
						}
						else
						{
							Report.LogInfo("DataField", " Conditional default value  validation not successful", "FAIL	");	
						}
						
					                  }
									else{
										Report.LogInfo("Validate ReviewError Status", "Review Error status not displayed", "FAIL");
										deleteBorderEAUX();
										}
					}
					else {
						Report.LogInfo("Transformation error screen", "Transformation error screen not displayed", "FAIL");
						deleteBorderEAUX();
					}
	        }
		else{

			Report.LogInfo("ValidateReviewErrorStatus", "Review status not displayed", "FAIL");
			deleteBorderEAUX();
		    }
		
		
			//SELECT rate of exchange option
			OpenQuestionnaire(subSheet2);
			BQPage.Step4_TC1068_ROE1(); ////SELECT rate of exchange option
			BQPage.nextStapeClick();
			BQPage.FormatId = ReturnFormatID();
		//	===========================================
			
			applyFilterPolicy(policy.PolicyNumber);
			//applyFilterPolicy("941029AC");

			openSelectedPolicy();
			policy.contractId = ReturnContractID();
			
			
			//  String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_OtherFeesDescription.xlsx\",\"UniqueFileName\":\"S89956220180527.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S89956220180527.xlsx\",\"Filesize\":24162,\"Path\":null,\"size\":24162,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			  //  String payload2 ="{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"ROE_CLAIM.xlsx\",\"UniqueFileName\":\"S44125020180527.xlsx\",\"BordereauFormatId\":\""+BQPage.FormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S44125020180527.xlsx\",\"Filesize\":16037,\"Path\":null,\"size\":16037,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			  
			  String ReqUrl1 = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl1 = Configuration.url+"/api/Bordereaux/AddAsDraft";
			SubmitBordereaux(subSheet1);

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				Sheet1068Path = fpath+"\\src\\test\\resources\\testdata\\ROE_CLAIM.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(Sheet1068Path);  
			
			
			
			String Ufname1 = "S44125020180527.xlsx";	
		    int size1 = 16037;
		    String BordreauID1 = BQPage.FormatId;
	        String response1 = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID1 = extractIDFromResponseinsideContract(response1); 
	        String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 1 , "3", 2018);
	       addAsDraft(payload2,DraftUrl);
			
			
			refreshUploadedFile();
		
				  
			AssertBordereauStatusReview = getTextFrom(ReviewBtn);
				if(isVisible(ReviewBtn)== true){
					
					Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
					openDATALink();
					navigateToDATAClaimTab();
					
					waitForElementToAppear(RateOfExchangeCol,20);
					mouseOverAction(RateOfExchangeCol);
					verifyMustExists(RateOfExchangeCol,"Rate of exchange column");
					sleep(2000);
					mouseOverAction(SettlementROEValue1);
							//verifyExists(SettlementROEValue1,"Rate of exchange value - borderau value ");
							
							 Result_1068_04 = getTextFrom(SettlementROEValue1);
								
								if(Result_1068_04.equals("30.00"))
								{
									Report.LogInfo("DataField", " borderau value validation successful", "PASS");	
								}
								else
								{
									Report.LogInfo("DataField", " borderau value validation not successful", "FAIL	");	
								}
							
							
							sleep(2000);
							mouseOverAction(SettlementROEValue2);
						//	verifyExists(SettlementROEValue2,"Rate of exchange value - default value ");
							
							Result_1068_05 = getTextFrom(SettlementROEValue2);
							
							if(Result_1068_05.equals("25.00"))
							{
								Report.LogInfo("DataField", " default value  validation successful", "PASS");	
							}
							else
							{
								Report.LogInfo("DataField", "default value  validation not successful", "FAIL	");	
							}
							sleep(2000);
							mouseOverAction(SettlementROEValue3);
						//	verifyExists(SettlementROEValue3,"Rate of exchange value - Conditional default value");
							Result_1068_06 = getTextFrom(SettlementROEValue3);
							
							if(Result_1068_06.equals("40.00"))
							{
								Report.LogInfo("DataField", " Conditional default value  validation successful", "PASS");	
							}
							else
							{
								Report.LogInfo("DataField", " Conditional default value  validation not successful", "FAIL	");	
							}
						}
								else{
									Report.LogInfo("Validate ReviewError Status", "Review Error status not displayed", "FAIL");
									deleteBorderEAUX();
									}
				
				// //SELECT Risk inception option.
				OpenQuestionnaire(subSheet2);
				BQPage.Step4_TC1068_ROE2();
				BQPage.nextStapeClick();	
	
	}

	
	
	public void ROE_TC1386() throws InterruptedException, Exception 
	{

		String subSheet1 = "Automation Company Admin 1 Claim Format 11 (Lloyd's Property Schema)";
		String subSheet2 = "Automation Company Admin 1 Claim Format 11";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.CreateClaimContractwithInceptionDate2018();
		policy.contractId = ReturnContractID();
		
	   //applyFilterPolicy("518118TV");
	   applyFilterPolicy(policy.PolicyNumber);
	    
		openSelectedPolicy();
		SubmitBordereaux(subSheet1);
		
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"518118TV"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"policy.PolicyNumber"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
    	
    	try 
		{
			String fpath = new File(".").getCanonicalPath();
			Sheet1386Path = fpath+"\\src\\test\\resources\\testdata\\ROE_CLAIM_ROE_TC1386.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(Sheet1386Path);  
		//contractId = addNewBordereauFormatPolicy(payload1, GetData);
		String Ufname = "S61979320181030.xlsx";	
	    int size = 16067;
	    String BordreauID = "4b7a6c66-ae83-425d-9d39-b4b5f9ec4bb2";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "3", 2018);
       addAsDraft(payload,DraftUrl);
	
       
		refreshUploadedFile();
		String CoverholderSettlementROECol="@xpath=//*[@data-field='Coverholder_Settlement_Currency_RoE']";

		AssertBordereauStatusReview = getTextFrom(ReviewBtn);
				if(isVisible(ReviewBtn)== true){
					Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
					openDATALink();
					navigateToDATAClaimTab();
					
					waitForElementToAppear(CoverholderSettlementROECol,20);
					mouseOverAction(CoverholderSettlementROECol);
					verifyMustExists(CoverholderSettlementROECol,"Coverholder settlement ROE column");
					sleep(2000);
					mouseOverAction(SettlementROEValue1);
					
					 Result_1386_01 = getTextFrom(SettlementROEValue1);
						
						if(Result_1386_01.equals("0.50"))
						{
							Report.LogInfo("DataField", " Default value validation successful", "PASS");	
						}
						else
						{
							Report.LogInfo("DataField", " Default value validation not successful", "FAIL	");	
						}
					
					
					sleep(2000);
					mouseOverAction(SettlementROEValue2);
					
					Result_1386_02 = getTextFrom(SettlementROEValue2);
					
					if(Result_1386_02.equals("0.60"))
					{
						Report.LogInfo("DataField", "Conditional default value  validation successful", "PASS");	
					}
					else
					{
						Report.LogInfo("DataField", "Conditional default value  validation not successful", "FAIL	");	
					}
					sleep(2000);
					mouseOverAction(SettlementROEValue3);
					Result_1386_03 = getTextFrom(SettlementROEValue3);
					
					if(Result_1386_03.equals("0.70"))
					{
						Report.LogInfo("DataField", " Conditional default value  validation successful", "PASS");	
					}
					else
					{
						Report.LogInfo("DataField", " Conditional default value  validation not successful", "FAIL	");	
					}

				                  }
								else{
									Report.LogInfo("Validate ReviewError Status", "Review Error status not displayed", "FAIL");
									deleteBorderEAUX();
									}
	
			}
	
	
	public void CompleteNewQuestionnaire_TC3798() throws InterruptedException, Exception 
	{
		ApprovalAutoApprovalandpartialsubmissionPage ss = new ApprovalAutoApprovalandpartialsubmissionPage();
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk";
		String freqVal = "Monthly";
		String subSheet = "Automation-Risk format 9 (Lloyd's Property Schema LOI)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String Schema = "Automation Schema";
		
		//Step 1
		policy.CreateContractwithInceptionDate2018();
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
		//policy.applyFilterPolicy("576954UM");
		//policy.openSelectedPolicy();
		
		//Step 2
		SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3 
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"576954UM"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3799Path = fpath+"\\src\\test\\resources\\testdata\\LunaProcessing_3798.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3799Path);
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S73264020181014.xlsx";	
		int size = 25782;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForCompleteNewQ(contractId, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
        refreshAfterUploadedFileForReviewSatusAndUploadStatus();
        
        CompleteNewQ("COMPLETE NEW QUESTIONNAIRE");
        		sleep(2000);
        		if(isVisible(Step2)==true)
				{
					Report.LogInfo("Validate Questionnare step 2", "Questionnaire screen displayed", "PASS");
					BQPage.LunaQuestionnaire(Schema);
					refreshUploadedFile();
					waitForElementToAppear(ReviewBtn, 5);
					if(isVisible(ReviewBtn)==true)
					{
						AssertBordereauStatusReview = getTextFrom(ReviewBtn);
						Report.LogInfo("Review status validation", "Review Status displayed", "PASS");
					}
					else
					{
						Report.LogInfo("Review status validation", "Review Status not displayed", "FAIL");
					}
				}
				else
				{
					Report.LogInfo("Validate Questionnare step 2", "Questionnaire screen not displayed", "FAIL");
				}
        		
	  }

	
	public void Luna_CreateNewQuestionnaire_TC3799() throws InterruptedException, Exception 
	{
		ApprovalAutoApprovalandpartialsubmissionPage ss = new ApprovalAutoApprovalandpartialsubmissionPage();
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk";
		String freqVal = "Monthly";
		String subSheet = "Automation-Risk format 9 (Lloyd's Property Schema LOI)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String Schema = "Automation Schema";
		
		//Step 1
		policy.CreateContractwithInceptionDate2018();
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
		
//		policy.applyFilterPolicy("708254LX");
//		policy.openSelectedPolicy();
		
		//Step 2
		SubmitBordereaux(subSheet);
		Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
		//Step 3 
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"708254LX"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet3799Path = fpath+"\\src\\test\\resources\\testdata\\LunaProcessing_3799.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet3799Path);
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		String Ufname = "S20846420181013.xlsx";	
		int size = 25779;
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForluna(contractId, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
        refreshAfterUploadedFileForReviewSatusAndUploadStatus();
        
        	sleep(3000);

        	ss.uploadLunaFile();
					
					//step 6
					waitForElementToAppear(CreateNewQuestionnaire,5);
					verifyExists(CreateNewQuestionnaire,"Create new Questionnaire button");
					click(CreateNewQuestionnaire,"Create new Questionnaire button");
					
					waitForElementToAppear(Step2,5);
					verifyMustExists(Step2, "Questionnaire step 2 displayed");
					if(isVisible(Step2)==true)
					{
						Report.LogInfo("Validate Questionnare step 2", "Questionnaire screen displayed", "PASS");
						BQPage.LunaQuestionnaire(Schema);
						
						policy.applyFilterPolicy(policy.PolicyNumber);
//						policy.applyFilterPolicy("708254LX");
						policy.openSelectedPolicy();
						Bordereaux_TAB();
						navigateOnProcessingTab();
						
						if(isVisible(ReviewBtn)==true)
						{
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("Review status validation", "Review Status displayed", "PASS");
						}
						else
						{
							Report.LogInfo("Review status validation", "Review Status not displayed", "FAIL");
						}
						
						
						
					}
					else
					{
						Report.LogInfo("Validate Questionnare step 2", "Questionnaire screen not displayed", "FAIL");
					}
				}
//	=============================================================================================================================
//	*TC 4198
//	*creating questionnaire without special character & Processing bordereau with special
//  * character , here all special character are removed & column matches hence bordereau goes to review status thats validation
//
//	=============================================================================================================================
	public void ProcessBordereau_SpecialCharacter_TC4198() throws InterruptedException, Exception 
	{
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk & Premium";
		String freqVal = "Monthly";
		String subSheet = "Automation-Risk format 23 (schema_SP)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String Schema = "schema_SP";
		
		//Step 1
		policy.CreateContractwithInceptionDate2018();
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
		
//		policy.applyFilterPolicy("697541YX");
//		policy.openSelectedPolicy();
	
		SubmitBordereaux(subSheet);
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
    	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"697541YX"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4198Path = fpath+"\\src\\test\\resources\\testdata\\	.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4198Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//Id\":\""+contractId+"\",\"Id\":\
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_OtherFeesDescription.xlsx\",\"UniqueFileName\":\"S29916320180523.xlsx\",\"BordereauFormatId\":\"98cf018e-b38d-4086-ab3e-4359487cea40\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29916320180523.xlsx\",\"Filesize\":24158,\"Path\":null,\"size\":24158,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		
		String Ufname = "S80224320181214.xlsx";	
	    int size = 19830;
	    String BordreauID = "c4ea8add-8bd4-4522-9ecc-e78847ac49be";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
        	sleep(3000);
						if(isVisible(ReviewBtn)==true)
						{
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("Review status validation", "Review Status displayed", "PASS");
						}
						else
						{
							Report.LogInfo("Review status validation", "Review Status not displayed", "FAIL");
						}
		}

//	=============================================================================================================================
//	*TC 4199
//	*creating questionnaire with special character & Processing bordereau with special
//  * character , here all special character are removed & column matches hence bordereau goes to review status thats validation
//	=============================================================================================================================
	
	public void Questionnaire_Bordereau_SpecialCharacter_TC4199() throws InterruptedException, Exception 
	{
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk & Premium";
		String freqVal = "Monthly";
		String subSheet = "Automation-Risk format 23 (schema_SP)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String Schema = "schema_SP";
		
		
		String RiskSchemaName="schema_SP";
		BQPage.addNewQuestionnaireTC4199(RiskSchemaName);
		
		policy.CreateContractwithInceptionDate2018();
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb("Risk And Premium","Monthly");
//		applyFilterPolicy("320555TG");
//		openSelectedPolicy();

		SubmitBordereaux(subSheet);
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
    	String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		//String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+"320555TG"+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4198Path = fpath+"\\src\\test\\resources\\testdata\\SpecialCharacter_4198.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4198Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		//Id\":\""+contractId+"\",\"Id\":\
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_OtherFeesDescription.xlsx\",\"UniqueFileName\":\"S29916320180523.xlsx\",\"BordereauFormatId\":\"98cf018e-b38d-4086-ab3e-4359487cea40\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29916320180523.xlsx\",\"Filesize\":24158,\"Path\":null,\"size\":24158,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		
		String Ufname = "S80224320181214.xlsx";	
	    int size = 19830;
	    String BordreauID = BQPage.BFormatId;
	  //  String BordreauID = "15a0f696-c7d8-44fa-ad52-7e87a09f4391";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
		refreshUploadedFile();
        	sleep(3000);
						if(isVisible(ReviewBtn)==true)
						{
							AssertBordereauStatusReview = getTextFrom(ReviewBtn);
							Report.LogInfo("Review status validation", "Review Status displayed", "PASS");
						}
						else
						{
							Report.LogInfo("Review status validation", "Review Status not displayed", "FAIL");
						}
		}
	
	
	
	public void simplified_TC2000() throws Exception
	{
		
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk & Premium";
		String freqVal = "Monthly";
		String subSheet = "Automation-Risk format 23 (schema_SP)";
		String ReqUrl_Simplified = Configuration.url+"/api/ReportingChannel/GetAllByContractIdsForSimplifiedUser";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String DraftUploadedUrl = Configuration.url+"/api/Bordereaux/AddBordereauxAsUploaded";
		String Schema = "schema_SP";
//		if(isVisible(SUploadScreen))
//		{
			Report.LogInfo("Validate Simplified Screen", "Simplified screen displayed", "PASS");
//			String PolicyNumber = "779677GS";
//			 String contractId=  webDriver.findElement(By.xpath("//select/option[contains(.,'"+PolicyNumber+"')]")).getAttribute("value");
//			 Report.LogInfo("contractId", contractId, "PASS");
//		try 
//		{
//			String fpath = new File(".").getCanonicalPath();
//			sheet4198Path = fpath+"\\src\\test\\resources\\testdata\\SpecialCharacter_4198.xlsx";
//		} 
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		File excelFile = new File(sheet4198Path); 
//		
//		//contractId = "4f589bd2-6611-49be-bebf-96376c058c84";
//		String payloadForRCID = "['"+contractId+"']";
//		String Ufname = "S35718020181122.xlsx";	
//	    int size = 19830;
//	    String Payload_Simplified = addAsDraft_Simplified(payloadForRCID,ReqUrl_Simplified);
//	    String ReportingChannelID = GetReportingchannelID(1, Payload_Simplified); // Here enter Appropriate reporting channel number to get ReportingChannelID.
//	    String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
//	    String ID = extractIDFromResponseinsideContract(response);
//	    String payload = GeneratePayloadForSimplified(contractId, ReportingChannelID, ID, Ufname, size, 1 ,2018);
//	    addAsDraft(payload,DraftUploadedUrl);
//		sleep(2000);
//		refreshPage();
		String URL = Configuration.url+"/#!/app/simplifiedBordereau/thankYouBordereauScreen";
		Report.LogInfo("URL", URL, "PASS");
		openurl(URL);
		sleep(3000);
		 
		 
		waitForElementToAppear(ThankYouScreen, 5);
		verifyMustExists(ThankYouScreen, "Simplified Thank you screen");
		if(isVisible(ThankYouScreen))
		{
			
			String PolicyNumber = "779677GS";
			Report.LogInfo("ThankYouScreen", "Thank You Screen displayed ", "PASS");
			applyFilterPolicy_ThankYouScreen(PolicyNumber);
			//For Approval   For Assignment    Review Uploaded Review Errors   Publishing   Error Processing
			FilterRecordStatus("Uploaded");
			//FilterDueDateColumn("02/03/2018");
			//FilterDaysOverdueColumn("270");
			
			sleep(3000);
			mouseOverAction(DueDate);
			String  ActualDueDate= getTextFrom(DueDate);
			Report.LogInfo("ActualDueDate", "ActualDueDate  = "+ActualDueDate, "INFO");
			int ss = GetDueDate(ActualDueDate);
			String ExpectedDaysOverdue = Integer.toString(ss);
			Report.LogInfo("ExpectedDaysOverdue", "ExpectedDaysOverdue  = "+ExpectedDaysOverdue, "INFO");
			mouseOverAction(DaysOverdue);
			String ActualDaysOverdue = getTextFrom(DaysOverdue);
			Report.LogInfo("ActualDaysOverdue", "ActualDaysOverdue = "+ActualDaysOverdue, "INFO");
			mouseOverAction(UploadedBy);
			String  ActualUploadedBy = getTextFrom(UploadedBy);
			Report.LogInfo("ActualUploadedBy", "ActualUploadedBy  = "+ActualUploadedBy, "INFO");
	//		String ExpectedUploadedBy   = st.AdminUsername;
	//		Report.LogInfo("ExpectedUploadedBy", "ExpectedUploadedBy  = "+ExpectedUploadedBy, "INFO");
			sleep(2000);
			
			loginPage.tideCompanyAdminLogOut();
			sleep(2000);
			loginPage.tideLogin("dev.admin@tideapp.co.uk","Yb0kMlJ;z8Ho33mO");
			sleep(2000);
			applyFilterPolicy(PolicyNumber);
			openSelectedPolicy();
			PropcessBordereau_FromUploaded("SimplifiedQuestionnaire");
			
			
			
			
		}
		else
		{
			Report.LogInfo("ThankYouScreen", "Thank You Screen not displayed ", "FAIL");
		}
		
//		}
//		else
//		{
//			Report.LogInfo("Validate Simplified Screen", "Simplified screen not displayed", "FAIL");
//		}
//		
	}
	
	 public void CompleteNewQ(String QuestionnaireName_WithSchemaName) throws Exception
		{
		 sleep(3000);
     	if(checkErrorReviewButton(UploadedButton)==true){
     		Report.LogInfo("ValidateUploadedStatus", "UPLOADED status displayed", "PASS");
				sleep(2000);
				String CoulmnName1 = "@xpath=//ul/li[text()='"+QuestionnaireName_WithSchemaName+"']";
				waitForElementToAppear(CoulmnName1, 5);
				SelectDropDownValue(SelectQDrpDown,CoulmnName1);
				verifyExists(NewQProcessBtn);
				click(NewQProcessBtn);
     	}
     	else
     	{
     		Report.LogInfo("ValidateUploadedStatus", "UPLOADED status not displayed", "FAIL");
     	}
     	}
		
	
	  public void KeyDetailsTAB()
	  {
		  waitForElementToAppear(KeyDetailsTAB, 5);
		  verifyExists(KeyDetailsTAB, "Key details TAB");
		  click(KeyDetailsTAB,"Key details TAB");
		  sleep(2000);
	  }
	  public void ErrorsAndWarningTAB()
	  {
		  waitForElementToAppear(ErrorsAndWarningTAB, 5);
		  verifyExists(ErrorsAndWarningTAB, "Errors And Warning TAB");
		  click(ErrorsAndWarningTAB,"Errors And Warning TAB");
		  sleep(2000);
	  }
	  public void BordereauStatisticsTAB()
	  {
		  waitForElementToAppear(BordereauStatisticsTAB, 5);
		  verifyExists(BordereauStatisticsTAB, "Bordereau Statistics TAB");
		  click(BordereauStatisticsTAB,"Bordereau Statistics TAB");
		  sleep(2000);
		  
	  }
	  public void NotesTAB()
	  {
		  waitForElementToAppear(NotesTAB, 5);
		  verifyExists(NotesTAB, "Notes TAB");
		  click(NotesTAB,"Notes TAB");
		  sleep(2000);
	  }
	  
	  public void ViewErrorRecordsToggle()
	  {
		  waitForElementToAppear(ViewErrorRecordsToggle, 5);
		  verifyExists(ViewErrorRecordsToggle, "View Error Records Toggle");
		  click(ViewErrorRecordsToggle,"View Error Records Toggle");
		  sleep(3000);
	  }
	  
	  public void ViewDiscardedRecordsToggle()
	  {
		  waitForElementToAppear(ViewDiscardedRecordsToggle, 5);
		  verifyExists(ViewDiscardedRecordsToggle, "View Discarded Records Toggle");
		  click(ViewDiscardedRecordsToggle,"View Discarded Records Toggle");
		  sleep(2000);
	  }
	  
	  public void ResolveErrorClick_ErrorsAndWarningTAB()
	  {
		 	sleep(2000);
			waitForElementToAppear(ResolveError_ErrorsAndWarningTAB,5);
			verifyMustExists(ResolveError_ErrorsAndWarningTAB, "Resolve error button");
			click(ResolveError_ErrorsAndWarningTAB,"Resolve error button at errors and warning TAB");
	  }
	
	  public void ReviewErrorClick_ProcessingTAB()
	  {
			sleep(2000);
			waitForElementToAppear(ReviewError,5);
			verifyMustExists(ReviewError,"Review Error Button");
			click(ReviewError,"Review error button"); 
	  }
	  public void ReviewClick_ProcessingTAB()
	  {
			sleep(2000);
			waitForElementToAppear(ReviewBtn,5);
			verifyMustExists(ReviewBtn,"Review Button");
			click(ReviewBtn,"Review button"); 
	  }
	  

	  public void Bordereaux_TAB()
	  {
			 waitForElementToAppear(BORDEREAUXLink,5);
			 sleep(1500);
			 verifyMustExists(BORDEREAUXLink,"BORDEREAUX Link");
			 click(BORDEREAUXLink,"BORDEREAUX Link");
			 sleep(2000);
	  }
		
	  public String KeyDetailsErrorCount()  throws Exception
	  {
		  Thread.sleep(1000);
		  String ErrorCount = getTextFrom(Error_Count) ; 
		  return ErrorCount;
	  }
	  public String KeyDetailsWarningCount()  throws Exception
	  {
		  Thread.sleep(1000);
		  String WarningCount = getTextFrom(Warning_Count) ; 
		  return WarningCount;
	  }
	  public String KeyDetailsPassedRecordsCount()  throws Exception
	  {
		  String PassedRecordsCount = getTextFrom(PassedRecords_Count) ; 
		  return PassedRecordsCount;
	  }
	  public String KeyDetailsTotalRecordsCount()  throws Exception
	  {
		  String TotalRecordsCount = getTextFrom(TotalRecords_Count) ; 
		  return TotalRecordsCount;
	  }
	  public String KeyDetailsNewRenewalRecordsCount()  throws Exception
	  {
		  String NewRenewalRecordsCount = getTextFrom(NewRenewalRecords_Count) ; 
		  return NewRenewalRecordsCount;
	  }
	  public String KeyDetailsEndorsementsRecordsCount()  throws Exception
	  {
		  String EndorsementsRecordsCount = getTextFrom(EndorsementsRecords_Count) ; 
		  return EndorsementsRecordsCount;
	  }
	  public String KeyDetailsCancellationRecordsCount()  throws Exception
	  {
		  String CancellationRecordsCount = getTextFrom(CancellationRecords_Count) ; 
		  return CancellationRecordsCount;
	  }
	  //Processing TAB Error Count
	  public String ProcessingTabErrorCount()  throws Exception
	  {
		  String ProcessingTabErrorCount = getTextFrom(ErrorCountProcessingTAB) ; 
		  return ProcessingTabErrorCount;
	  }
	  //Processing TAB Warning Count
	  public String ProcessingTabWarningCount()  throws Exception
	  {
		  String ProcessingTabWarningCount = getTextFrom(WarningCountProcessingTAB) ; 
		  return ProcessingTabWarningCount;
	  }
	  
		 public void ReverToUploadClick()
		 {
				sleep(2000);
				waitForElementToAppear(RevertToUpload,5);
				verifyMustExists(RevertToUpload,"Review Button");
				click(RevertToUpload,"Review button");
		 }
		
		 public ArrayList<String> RuleDataCapture(String Locator,String LocatorDiscription, String OriginalValue,String ChangedValue, String RuleName)
		 {
			 ArrayList<String> DataCapture = new ArrayList<String>();
				waitForElementToAppear(Locator,5);
				verifyMustExists(Locator,LocatorDiscription);
				click(Locator,LocatorDiscription);
			 String RDCOriginalValue ="@xpath=//td[3][contains(.,'"+OriginalValue+"')]";
					
				waitForElementToAppear(RDCOriginalValue,5);
				verifyMustExists(RDCOriginalValue,"Original Value");
				ActualOriginalValue = getTextFrom(RDCOriginalValue);
				 DataCapture.add(ActualOriginalValue);
			Report.LogInfo("RDOV", ActualOriginalValue, "PASS");
			
			if(OriginalValue.equalsIgnoreCase(ActualOriginalValue)== true) {
				Report.LogInfo("check", "Original Value Matches", "PASS");
				
			} else {
				Report.LogInfo("check", "Original Value does not Matches", "FAIL");
				 }
			 String ChangedValueFromRDC ="@xpath=//td[4][contains(.,'"+ChangedValue+"')]";
				
				waitForElementToAppear(ChangedValueFromRDC,5);
				verifyMustExists(ChangedValueFromRDC,"Changed Value");
				ActualChangedValue = getTextFrom(ChangedValueFromRDC);
				 DataCapture.add(ActualChangedValue);
			Report.LogInfo("RDOV", ActualChangedValue, "PASS");
			if(ChangedValue.equalsIgnoreCase(ActualChangedValue)== true) {
				Report.LogInfo("check", "Changed Value Matches", "PASS");
				
			} else {
				Report.LogInfo("check", "Changed Value does not Matches", "FAIL");
			}
			 String RuleNameFromRDC ="@xpath=//td[6][contains(.,'"+RuleName+"')]";
				
			verifyMustExists(RuleNameFromRDC,"Rule Name");
				ActualRuleNameValue = getTextFrom(RuleNameFromRDC);	
			Report.LogInfo("RDOV", ActualRuleNameValue, "PASS");
			 DataCapture.add(ActualRuleNameValue);
			if(RuleName.equalsIgnoreCase(ActualRuleNameValue)== true) {
				Report.LogInfo("check", "Rule Name Matches", "PASS");
				
			} else {
				Report.LogInfo("check", " Rule Name does not Matches", "FAIL");
			}
			verifyMustExists(Okbtn1,"ok button");
			click(Okbtn1,"ok button");
			
			return DataCapture;
			 }
		 
		 
		 public void RevertToUpload(String QuestionnaireName_WithSchemaName) throws Exception
			{
			 
			 Bordereaux_TAB();
			 navigateOnProcessingTab();
			if(checkErrorReviewButton(ReviewBtn)==true)
			{
				sleep(3000);
				ReverToUploadClick();
				
				refreshUploadedFile(UploadedBtn);
				if(checkErrorReviewButton(UploadedBtn)==true)
				{
					sleep(5000);
					
					String CoulmnName1 = "@xpath=//ul/li[contains(.,'"+QuestionnaireName_WithSchemaName+"')]";
					
					
					SelectDropDownValue(SelectQDrpDown,CoulmnName1);
					verifyExists(ProcessBordereauBtn);
					click(ProcessBordereauBtn);
					refreshUploadedFile();
				}
				else
				{
					Report.LogInfo("Uploaded Status", "Status not changed to Uploaded.", "FAIL");
				}
				
			}
			else
			{
				Report.LogInfo("ReviewStatusVal", "Status not changed to Review .", "FAIL");
			}
			
			
			
			}
		 public void PropcessBordereau_FromUploaded(String QuestionnaireName_WithSchemaName) throws Exception
			{
			 
			 Bordereaux_TAB();
			 navigateOnProcessingTab();
				sleep(3000);
				refreshUploadedFile(UploadedBtn);
				if(checkErrorReviewButton(UploadedBtn)==true)
				{
					sleep(2000);
					String CoulmnName1 = "@xpath=//ul/li[contains(.,'"+QuestionnaireName_WithSchemaName+"')]";
					SelectDropDownValue(SelectQDrpDown,CoulmnName1);
					verifyExists(ProcessBordereauBtn);
					click(ProcessBordereauBtn);
					refreshUploadedFile();
				}
				else
				{
					Report.LogInfo("Uploaded Status", "Status not changed to Uploaded.", "FAIL");
				}
			}
		 
		 

	
	
	  }
	
				
	
	
