package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.jprotractor.NgBy;
import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

public class CompanyPage extends PageBase
{
	String path;
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
	}
	ReadExcelFile rd = new ReadExcelFile();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ddMMssMs");
		String datetime = ft.format(dNow);
		return datetime;
	}
	
	public String actualcompnayname;
	public String actualTradingName;
	public String actualTelephone;
	public String actualAddress1;
	public String actualCity;
	public String actualpostalcode;
	public String actualstate;
	public String actualcountry;
	public String actualAddress2;
	
	public String expectedcompanyname;
	public String expectedTradingName;
	public String expectedAddress1;
	public String expectedTelephone;
	public String expectedAddress2;
	public String expectedCity;
	public String expectedpostalcode;
	public String expectedstate;
	public String expectedcountry;
	
	public String ActualTeamsTitleInDivision;
	public String ActualDivisionTitle;
	public String ExpectedDivisionTitle;
	public String ExpectedDivisionTitle1;
	public String RegulatorRoleVerify;
	public static String DivisionReferenceDup;
	public static String SubDivisionReferenceDup;
	public static String TeamsIndivisionVerify;
	public static String TeamClassofBusiness;
	public static String UserTabInTeamVerify;
	public static String RoleInUserTab;
	public static String TeamsUserRole;
	public static String TeamsUserEditPopUp;
	public static String TeamsEditedUserRole;
	public static String RemovePopupMessage;
	public static String TeamValueInUserTab;
	public static String BlnkValueInTeamcolumnInUserTab;
	
	String CompanyName1= "Allied World Managing Agency Limited";
	String CompanyName = "Systenics12"+getCurrentDateTimeMS();
	String CompanyNameDup = "Systenics12"+getCurrentDateTimeMS();
	String CompanyNameCovrholder = "SystenicsTest12"+getCurrentDateTimeMS();
	String EditCompanyName = "Systenics1EditName"+getCurrentDateTimeMS();
	static String DivisionName = "Systenics INC"+getCurrentDateTimeMS();
	static String DivisionNameDupl = "Systenics INC"+getCurrentDateTimeMS();
	String DivisionRef = "Automation"+getCurrentDateTimeMS();
	String DivisionRefDupl = "Automation"+getCurrentDateTimeMS(); //DivisionRefDuplicate
	String SubDivision = "Systenics Sub Division"+getCurrentDateTimeMS();
	String SubDivisionDupl = "Systenics Sub Division"+getCurrentDateTimeMS();
	String SubDivisionRef = "Systenics Sub Division"+getCurrentDateTimeMS();
	String SubDivisionRefDupl = "Systenics Sub Division"+getCurrentDateTimeMS(); //SubDivisionRefDuplicate
	String TeamsName = "TestAutomationTeam1";
	String TeamsName1 = "TestAutomation";
	String DivisionNameforTeam = "SystenicsTeam"+getCurrentDateTimeMS();
	String DivisionRefforTeam = "TeamSystenics"+getCurrentDateTimeMS();
	String DivisionNameForUserInTeam = "TestDivision"+getCurrentDateTimeMS();
	String DivisionRefForUserInTeam = "TestDivisionRef"+getCurrentDateTimeMS();
	
	
	String UserEmail ="tboult1"+getCurrentDateTimeMS()+"@gmail.com";

	public String expRefTitle = "SystenicsDIV1"+getCurrentDateTimeMS();
	public String expAddress1 = "Pune";
	public String expAddress2 = "Vashi";
	public String Addres2 = "NewMumbai";
	public String expCity = "Satara";
	public String expPostalCode = "542211";
	public String expState = "Goa";
	public String expTelNo = "8586552455";
	public String Address2MainDivisn = "Vile Parle";
	
	public String actualDivisionRef;
	public String actualEdDivisionAdd1;
	public String actalEdDivisionAdd2;
	public String actualEdDivisionCity;
	public String actualEdDivisionPostsalCd;
	public String actualEdDivisionState;
	public String actualEdDivisionTelNo;

	String EditSubDivisionName = "SysDIV12"+getCurrentDateTimeMS();
	public String SubDivisionReference = "SubDivision"+getCurrentDateTimeMS();
	public String SubDivisionReferenceEdit = "SDinEdit"+getCurrentDateTimeMS();
	public String SubDivisionAddress1 = "MorajTest";
	public String SubDivisionCity = "Mumbai";
	public String SubDivisionPostalCode = "4001238";
	public String SubDivisionState = "Maharashtra";
	public String SubDivisionPHNumber = "9998989899";

	//Variable for Verification
	String edExpAddress1 = "MorajTest";
	String edExpCity = "Mumbai";
	String edExpPostalCode = "4001238";
	String edExpState = "Maharashtra";
	String edExpTelNo = "9998989899";
	String edExpRefTitle = "SubDivisionTest";
	String FirstName = "Time";

	String UpdateUserName = "firstTest5";
	String UpdateUserLastName = "lastTest5";
	String UpdateMobilePhone = "9898990098";
	String UpdateWorkPhone = "689905";

	//Variables for verification of edited user
	public String ExpectedPhoneNumber = "9898990098";
	public String ExpectedWorkPnone = "689905";
	public String ExpectedFullName= "firstTest5 lastTest5";
	public String ActualFullName;
	public String ActualMPhoneNumber;
	public String ActualWorkPnone;
	public String actualSubDivisionRef;
	public String actualEdSubDivisionAdd1;
	public String actualEdSubDivisionCity;
	public String actualEdSubDivisionPostsalCd;
	public String actualEdSubDivisionState;
	public String actualEdSubDivisionTelNo;
	public String ActualMobileNumber ="9999999990";
	public String EditedMobileno;
	public String actualClassofBusinessToEdit;
	
	
	//Class objects
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	PolicyPage Ppage = new PolicyPage();
	//Element Locators
	//Select Company link from Admin dropdown
	public static final String CompaniesLnk = "@linkText=Companies";

	//Verify Company page
	public static final String CompanyPageLbl = "@css=.lead.f-Size-24.m-b-15";

	//Add company Button
	public static final String AddNewCompanyBtn = "@xpath=//button[contains(.,'Add New Company')]";

	//Add company Main Details section
		public static final String CompanyNameTxt="@model=companyData.DisplayName";
		public static final String TradingNameTxt="@model=companyData.TradingName";
		public static final String CompanyTypeDD="@css=.k-header.ng-scope.ng-empty";
		public static final String InsurerDDValue = "@xpath=//li[contains(text(),'Insurer')]";
		public static final String BrokerDDValue = "@xpath=//li[contains(.,'Broker')]";
		public static final String RegulatorRoleValue = "@xpath=//li[contains(text(),'Regulator Role ')]";
		public static final String ServiceProviderValue= "@xpath=//li[contains(text(),'Service Provider ')]";
		public static final String TPAValue="@xpath=//li[contains(text(),'TPA')]";
		public static final String CoverholderValue = "@xpath=//li[contains(text(),'Coverholder')]";
		public static final String LoyldYesBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][1]";
		public static final String LoyldNoBtn = "@xpath=//dd[@class='p-t-10']//descendant::label[@class='radio radio-inline m-r-20'][2]";
		public String underConsTitle;

	//Add company Contact Information section
	public static final String TelephoneTxt="@model=companyData.Telephone";
	public static final String Address_1Txt="@model=companyData.Address1";
	public static final String Address_2Txt="@model=companyData.Address2";
	public static final String CityTxt="@model=companyData.City";
	public static final String PostalCodeTxt="@model=companyData.PostalCode";
	public static final String StateTxt="@model=companyData.State";
	public static final String CountryDD="@xpath=//preceding::dt[text()='Country']//following::dd//span[@class='k-input ng-scope']";
	public static final String IndiaDDValue ="@css=ul > li:nth-child(96)";

	//Save company details
		public static final String SaveBtn="@buttonText=Save";
		public static final String VerifyAddedCompany ="@css=.lead.m-b-10.ng-binding";
		public static final String VerifyDuplicateError ="@xpath=//div[contains(text(),'Company Name is duplicate')]";
		public static final String VerifyAboutTab="@xpath=//a[@data-ui-sref='app.companydetails.companyabout']";
		public static final String VerifyDivisionTab="@xpath=//a[@data-ui-sref='app.companydetails.companydivisions({DivisionSubDivisionType: 1})']";
		public static final String VerifyUserTabIncompany="@xpath=//a[@data-ui-sref='app.companydetails.companyusers']";
		public static final String VerifyConfigurationTabInCompany="@xpath=//a[@data-ui-sref='app.companydetails.companyconfiguration']";
		public static final String VerifyAdminTabInCompany="@xpath=//a[@data-ui-sref='app.companydetails.companyadmin']";
		public static final String VerifyFrstNameInCompanyUser="@xpath=//div[@class='k-grid-content k-auto-scrollable']//td[1]";
		public static final String VerifyTeamsClmInUser="@xpath=//div[@class='k-grid-content k-auto-scrollable']//td[3]";
		public static final String VerifyRoleClmInUser="@xpath=//div[@class='k-grid-content k-auto-scrollable']//td[6]";
		

	//Company Name Filter
	public static final String CompanyNameFilter ="@xpath=//th[@data-title='Company Name']//a//span";
	public static final String SearchFilterTxt ="@css=[placeholder='Search']";
	public static final String FilterBtn="@buttonText=Filter";

	//Contract Administrator Filter
	public static final String ContractNameFilter ="@xpath=//th[@data-title='Contract Administrator']//a//span";
	
	// company name after filter
	public static final String FiltedCompanyName="@css=.k-selectable tbody td:nth-of-type(2)";

	public static final String AddNewUserBtx="@buttonText=Add New User";
	//Add new user locator 
	public static final String FirstNameTxt="@model=userDetails.FirstName";
	public static final String LastNameTxt="@model=userDetails.LastName";
	public static final String RoleDD="@css=.k-dropdown";
	public static final String CompanyAdminRole="@css=.k-list.k-reset li:nth-child(3)";
	public static final String EmailAddresstxt="@model=userDetails.Email";
	public static final String MobilePhoneTxt="@model=userDetails.PhoneNumber";
	public static final String WorkPhonetxt="@model=userDetails.WorkPhoneNumber";
	public static final String VerificationFail="@css=.alert.alert-danger.m-15";
	public static final String UsernotFoundText="@xpath=//form/div[contains(.,'User not found')]";
	public static final String EmailFiltericon="@css=.k-grid-header-wrap [data-field=Email] .k-grid-filter";
	public static final String EmailFiltersearchtxt="@css=.k-textbox.k-space-right>input";
	public static final String checkEmailID="@css=.k-reset.k-multicheck-wrap";
	public static final String selectuser="@css=.ng-scope>td:nth-child(1)";

	//Added user locator for verification
	public static final String UserDeactivatedmsg="@xpath=//div[contains(text(),'This user is deactivated')]";
	public static final String EmailnotVerifiedmsg="@xpath=//div[contains(text(),'Email is not verified by this user')]";
	public static final String FullName="@xpath=//dt[text()='Full Name']/../dd";
	public static final String Role="@xpath=//dt[text()='Role']/../dd";
	public static final String Company="@xpath=//dt[text()='Company']/../dd";
	public static final String EmailID="@xpath=//dt[text()='Email ID']/../dd";
	public static final String PhoneNumber1="@xpath=//dt[text()='Phone Number']/../dd";
	public static final String WorkPhoneNumber="@xpath=//dt[text()='Work Phone Number']/../dd";
	public static final String BacktoCompanybtn="@css=.btn-primary.pull-right.ng-scope";
	public static final String PolicyHome = "@css=a[href='#!/app/contractlist']";
	public static final String DivisionNameVerify = "@xpath=//*[@id='profile-main']/div[2]/data/div[2]/div[2]/div/dl[1]/dd";
	public static final String DivivsionRefVerify = "@xpath=//*[@id='profile-main']/div[2]/data/div[2]/div[2]/div/dl[2]/dd";

	//Locators to edit the user after filtered it
	public static final String SelectedUser = "@css=[role='rowgroup'] tr:nth-child(3)>td:nth-child(1)";
	public static final String KegalButtonEdit = "@css=#profile-main .dropdown-toggle";
	public static final String EditSelectedUserLink ="@xpath=//*[@id='profile-main']//li//a//i";
	public static final String EditLink ="@xpath=//*[@id='profile-main']//li//a[contains(.,'Edit')]";
	//Locators for Edit user(Main Details) 
	public static final String UserFirstName = "@model=userDetails.FirstName";
	public static final String UserLastName = "@model=userDetails.LastName";
	//Lacators for Edit User Contact Information
	public static final String UserMobilePhoneNumber = "@model=userDetails.PhoneNumber";
	public static final String UserWorkPhone = "@model=userDetails.WorkPhoneNumber";
	// Locators for Save and Verification of edited user.
	public static final String SaveButtonUser = "@partialButtonText=Save Changes";
	public static final String EditedWorkPhoneNumber = "@xpath=//dt[text()='Work Phone Number']/../dd[@class='ng-binding']";
	public static final String EditedPhoneNumber ="@xpath=//dt[text()='Phone Number']/../dd[@class='ng-binding']";
	public static final String EditedFullName = "@xpath=//dt[text()='Full Name']/../dd[@class='ng-binding']";

	// company name after filter
	public static final String SystenicsCompanyName="@xpath=//td[@role='gridcell'][2]";
	public static final String CompanyTypeDD1="@xpath=(//div[@class='pmbb-body p-l-30']//dl)[3]//div[@class='form-group']";
	// Edit icon
	public static final String EditKebabIcon="@css=.pmbb-header .actions.hidden-xs.ng-scope";
	public static final String EditoptionLink="@css=.dropdown-menu.dropdown-menu-right";
	public static final String CompanyTypeBroker="@xpath=//li[text()='Broker']";
	public static final String UnitedStateDDValue = "@xpath=//li[text()='Ukraine']";      // "@css=ul > li:nth-child(230)";
	//li[text()='Ukraine']
	public static final String SaveChangesBtn ="@buttonText=Save Changes";

	// locator after edit company details
	public static final String Editedcompanyname ="@xpath=//dt[text()='Company Name']/../dd[@class='ng-binding']";
	public static final String EditedTradingname ="@xpath=//dt[text()='Trading Name']/../dd[@class='ng-binding']";
	public static final String Editedcompanytype ="@xpath=//dt[text()='Company Type']/../dd[@class='ng-binding']";
	public static final String EditedTelephone ="@xpath=//dt[text()='Telephone']/../dd[@class='ng-binding']";
	public static final String Editedaddress1 ="@xpath=//dt[text()='Address 1']/../dd[@class='ng-binding']";
	public static final String Editedaddress2 ="@xpath=//dt[text()='Address 2']/../dd[@class='ng-binding']";
	public static final String Editedcity="@xpath=//dt[text()='City']/../dd[@class='ng-binding']";
	public static final String Editedpostalcode="@xpath=//dt[text()='Postal Code']/../dd[@class='ng-binding']";
	public static final String Editedstate="@xpath=//dt[text()='State']/../dd[@class='ng-binding']";
	public static final String Editedcountry="@xpath=//dt[text()='County']/../dd[@class='ng-binding']";

	//Add Division
	public static final String Division = "@css=.btn-wave.ng-scope>a[data-ui-sref='app.companydetails.companydivisions({DivisionSubDivisionType: 1})']";
	public static final String Add_new_Division_Button ="@partialButtonText=Add New Division";
	public static final String Division_Name = "@model=divisionDetail.DivisionName";
	public static final String Division_Reference= "@model=divisionDetail.DivisionReference";
	public static final String Added_Division_Name = "@xpath=//*[@id='profile-main']/div/data/div[2]/div/div/div[2]/table/tbody/tr[1]";
	public static final String Added_Sub_Division = "@xpath=//*[@id='profile-main']/div/data/div[2]/div/div/div[2]/table/tbody/tr[1]";
	public static final String ExistingSubDivision = "@xpath=//*[@class='lead m-b-0 ng-binding']";
	public static final String ExistingDivisionTitle = "@xpath=//*[@class='lead m-b-0 ng-binding']";
	public static final String DupDivisionRefErrorMessage= "@xpath=//div[contains(text(),'Division Reference already exist in this division')]";
	public static final String CancelButtonforDuplDevRef= "@xpath=//button[@class='btn btn-default cancel btn-space']";
	public static final String Division_Type = "@css=.k-input.ng-scope";
	public static final String EnterDivisionType = "@css=.k-animation-container span:nth-child(1)";
	public static final String Division_Insure ="@xpath=//li[text()='Insurer']";
	public static final String Regulator_Role ="@xpath=//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String RegulatorRole_Value ="@xpath=//li[text()='Regulator Division - Regulator Division']";
	public static final String Address1 = "@xpath=//input[@data-ng-model='divisionDetail.Address1']"; //"@model=divisionDetail.Address1";
	public static final String Address2 = "@xpath=//input[@data-ng-model='divisionDetail.Address2']";	//"@model=divisionDetail.Address2";
	public static final String City = "@xpath=//input[@data-ng-model='divisionDetail.City']"; //"@model=divisionDetail.City";
	public static final String PostalCode = "@xpath=//input[@data-ng-model='divisionDetail.PostalCode']"; //"@model=divisionDetail.PostalCode";
	public static final String  Country_Dropdown ="@xpath=//dt[contains(text(),'Country')]/following-sibling::dd/descendant::span[@class='k-icon k-i-arrow-60-down']";
	public static final String Country_Option = "@xpath=//li[text()='India']";
	public static final String EnterOption = "@css=.k-textbox";
	public static final String PhoneNumber = "@xpath=//input[@data-ng-model='divisionDetail.Telephone']"; //"@model=divisionDetail.Telephone";
	public static final String Save_Button= "@buttonText=Save";
	public static final String State = "@xpath=//input[@data-ng-model='divisionDetail.State']"; //"@model=divisionDetail.State";
	public static final String DivisionTitle ="@xpath=//*[@id=\"profile-main\"]/div/div";
	public static final String BackToCompanyBtn ="@xpath=//*[@id='content']//button[contains(.,'BACK TO COMPANY')]";
	public static final String IsLloydsYesBtn ="@xpath=//*[@name='form.Division']//div/dl[4]/dd/label[1]";
	public static final String cancelbtn ="@xpath=//*[@data-ng-click='cancel()']";
	public static final String CompanyTitle ="@xpath=//div[@class='lead m-b-10 ng-binding']";
	public static final String CompanyAboutTab = "@xpath=//a[@data-ui-sref='app.companydetails.companyabout']";
	public static final String BacktoDivisionBtn = "@xpath=//button[@ng-click='BackToDivision()']";
	
	
	//Locators for Edit Sub-Division
	public static final String SubDivisionNameFilterIcon = "@css=[data-field='DivisionName'] span:nth-child(1)";
	public static final String SubDivisionNameSearch = "@css=.k-textbox.k-space-right>input";
	public static final String SubDivisionSearch = "@css=input[placeholder='Search']";	
	public static final String SelectCheckbox = "@css= [value='"+DivisionName+"']";
	public static final String FilterButton = "@css=.k-button.k-primary";
	public static final String CancelButtonforDuplSubDev = "@xpath=//button[@class='btn btn-default cancel btn-space']";

	//Locators to edit the subDivision after filtered it.
	public static final String FirstRecord = "@css=.k-grid-content [role=grid]";
	public static final String KegalButtonToEdit = "@css=#profile-main .dropdown-toggle";
	public static final String EditSubDivisionLink ="@css=#profile-main .dropdown-menu li.ng-scope>a";

	//Locators Edit Mode 
	public static final String EdSubDivisionName = "@model=divisionDetail.DivisionName";
	public static final String EdSubDivisionReference = "@model=divisionDetail.DivisionReference";
	public static final String EdAddress1 = "@model=divisionDetail.Address1";
	public static final String EdSubDivisionCity= "@model=divisionDetail.City";
	public static final String EdSubDivisionPostalCode = "@model=divisionDetail.PostalCode";
	public static final String EdSubDivisionState = "@model=divisionDetail.State";
	public static final String EdSubDivisionTelephone = "@model=divisionDetail.Telephone";
	
	
	public static final String EdAddress11 = "@xpath=//*[@id='profile-main']//div/dl[3]/dd";
	public static final String EdSubDivisionCity1=  "@xpath=//*[@id='profile-main']//div/dl[5]/dd";
	public static final String EdSubDivisionPostalCode1 =  "@xpath=//*[@id='profile-main']//div/dl[6]/dd";
	public static final String EdSubDivisionState1 = "@xpath=//*[@id='profile-main']//div/dl[7]/dd";

	//Locator to SAVE edit data
	public static final String SaveButton = "@buttonText=Save";

	//Locators to verification
	public static final String RefSubDivisionTitle = "@css=.lead.m-b-0.ng-binding small:nth-child(1)";
	public static final String DivisionFilterIcon = "@css=.k-grid-header [data-field=DivisionName] a";
	public static final String DivisionSearchBox = "@css=.k-textbox.k-space-right>input";
	public static final String DivisionCheckBox = "@xpath=//input[@name='DivisionName']"; //"@css=.k-label [value='"+DivisionName+"']";
	public static final String DivisionFilterLink = "@css=.k-button.k-primary";
	public static final String DivisionFirstRecrd = "@xpath=//*[@role='grid']//td[1]";
	public static final String EditKegelDots ="@css=#profile-main .dropdown-toggle";
	public static final String EditDivisionLink ="@css=#profile-main .dropdown-menu li.ng-scope>a";
	public static final String EditbtnTeam = "@xpath=//a[@ng-click='edit()']";
	public static final String DivisionRefFieldInDivisions = "@css=.k-grid-header [data-field=DivisionReference]";

	//Edit fields Division
	public static final String EdDivisionRefName = "@model=divisionDetail.DivisionReference";
	public static final String EdDivisionAdd1 = "@xpath=//input[@data-ng-model='divisionDetail.Address1']"; //"@model=divisionDetail.Address1";
	public static final String EdDivisionAdd2 = "@xpath=//input[@data-ng-model='divisionDetail.Address2']";
	public static final String EdDivisionCity = "@xpath=//input[@data-ng-model='divisionDetail.City']";  //@model=divisionDetail.City";
	public static final String EdDivisionPostsalCd = "@xpath=//input[@data-ng-model='divisionDetail.PostalCode']"; //@model=divisionDetail.PostalCode";
	public static final String EdDivisionState = "@xpath=//input[@data-ng-model='divisionDetail.State']"; //@model=divisionDetail.State";
	public static final String EdDivisionTelNo = "@xpath=//input[@data-ng-model='divisionDetail.Telephone']"; //@model=divisionDetail.Telephone";
	
	public static final String EditDivisionRef = "@xpath= //*[@id='profile-main']//div/dl[2]/dd";
	public static final String EdDivisionAdd11 = "@xpath=//*[@id='profile-main']//div/dl[5]/dd";
	public static final String EdDivisionAddLin2 = "@xpath=//*[@id='profile-main']//div/dl[6]/dd";
	public static final String EdDivisionCity1 = "@xpath=//*[@id='profile-main']//div/dl[7]/dd";
	public static final String EdDivisionPostsalCd1 = "@xpath=//*[@id='profile-main']//div/dl[8]/dd";
	public static final String EdDivisionState1 =  "@xpath=//*[@id='profile-main']//div/dl[9]/dd";
	//Save
	public static final String EditSaveBtn ="@buttonText=Save";
	public static final String DivisionRefTitle ="@css=.lead.m-b-0.ng-binding .ng-binding";
	public static final String DivisionAddLine1 ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][2]//dd";
	public static final String DivisionCity ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][4]//dd";
	public static final String DivisionPostalCode ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][5]//dd";
	public static final String DivisionState ="@xpath=//*[@id='profile-main']//dl[@class='dl-horizontal'][6]//dd";
	public static final String DivisionTelNo ="@xpath=//*[@id='profile-main']/div[2]/data/div[2]/div[4]/div/dl/dd";

	//Add Subdivision
	public static final String SUBDivision = "@css=.btn-wave.ng-scope>a[data-ui-sref='app.companydetails.companydivisions({DivisionSubDivisionType: 2})']";
	public static final String Add_New_SubDivision_Button ="@partialButtonText=Add New Sub Division";
	public static final String SubDivisionName = "@model=divisionDetail.DivisionName";
	public static final String SubDivisionRefName = "@model=divisionDetail.DivisionReference";
	public static final String Division_Broker ="@xpath=//li[text()='Broker']";
	public static final String DupSubDivisionRefErrorMessage = "@xpath=//div[contains(text(),'Sub-Division Reference already exist in this division')]";
	public static final String RegulatorRoleTextVerify ="@xpath=//dt[contains(.,'Regulator Role')]";

	//Teams in Division
	public static final String ExistingDivisionName="@xpath=//td[text()='TestDivisionRef2412271227']";
	public static final String DivisionTab = "@css=.btn-wave.ng-scope>a[data-ui-sref='app.companydetails.companydivisions({DivisionSubDivisionType: 1})']";
	public static final String AddedDivisnRef = "@xpath=//div[@class='lead m-b-0 ng-binding']";
	public static final String DivisnAboutTab = "@xpath=//a[@data-ui-sref='app.division.about']";
	public static final String TeamsInDivision = "@xpath=//a[@data-ui-sref='app.division.teams']";
	public static final String AddNewTeamBtn = "@partialButtonText=Add New Team";
	public static final String AddTeamPopUpMssg = "@xpath=//h2[@class='lead m-t-0 ng-binding']";
	public static final String TeamName = "@xpath=//input[@ng-model='teamVm.Name']";
	public static final String ClassofBusnessinTeams = "@xpath=//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String ClssOfBsnsValue = "@xpath=//li[text()='Aviation Products/ Airport Liabilities']";
	public static final String AddTeamBtnToSave = "@xpath=//button[@ng-click='addTeam()']";
	public static final String VerifyAddedTeam = "@xpath=//td[@role='gridcell']";
	public static final String DuplctTeamname = "@xpath=//div[@class='alert alert-danger m-15 m-b-0 ng-binding ng-scope']";
	public static final String clssofbsns2ndVlue = "@xpath=//li[text()='Aviation War']";
	public static final String BckToCompnyBtn = "@xpath=//button[@ng-click='BackToCompany()']";
	public static final String TeamFltrIcon = "@xpath=//a[@aria-label='Filter']";
	public static final String TeamSearch = "@css=input[placeholder='Search']";	
	public static final String SelectChkBoxInTeam = "@xpath=//input[@value='TestAutomationTeam']";
	public static final String ClsofBusnsClck = "@xpath=//td[text()='Aviation Products/ Airport Liabilities']";
	public static final String TeamsAboutTab = "@xpath=//a[@data-ui-sref='app.team.about']";
	public static final String EditTeamBtnToSave = "@xpath=//button[@ng-click='editTeam()']";
	public static final String EditTeamName = "@xpath=//input[@ng-model='TeamData.Name']";
	public static final String UserTabInTeam ="@xpath=//a[@data-ui-sref='app.team.user']";
	public static final String AddNewUserInTeam = "@xpath=//button[@ng-click='openUserPopup(null)']";
	public static final String BackToDivisionBtn="@css=.btn-primary.pull-right.ng-scope";
	public static final String VerifyAddUserHeader="@xpath=//h2[@class='lead m-t-0 ng-binding ng-scope']";
	public static final String SelectUserDDInTeam="@css=body > div.modal.fade.ng-isolate-scope.animated.fadeIn.in > div > div > div > form > dl:nth-child(2) > dd > div > div > span > span.k-dropdown-wrap.k-state-default > span.k-input.ng-scope";
	public static final String SelectUserDDValueInTeam="@xpath=//li[text()='StandardSunny Standard']";
	public static final String VerifyAddedUserWhileEditing="@xpath=//*[text()='StandardSunny Standard']";
	public static final String SelectRoleDDInTeam="@css=body > div.modal.fade.ng-isolate-scope.animated.fadeIn.in > div > div > div > form > dl:nth-child(3) > dd > div > div > span > span > span.k-input.ng-scope";
	public static final String SelectRoleDDValue="@xpath=//li[@class='k-item ng-scope'][contains(text(),'Standard')]";
	public static final String SaveBtnToAddUserInTeam="@xpath=//button[@ng-if='isAddNewUser']";
	public static final String FirstNameUserinTeam="@xpath=//a[contains(.,'First Name')]";
	public static final String VerifyAddedFrstName="@xpath=//div[@class='k-grid-content k-auto-scrollable']//td[1]";
	public static final String VerifyRoleOfUserInTeam="@xpath=//div[@class='k-grid-content k-auto-scrollable']//td[5]";
	public static final String VerifyTeamsUserEditBtn="@xpath=//button[@class='btn btn-default edit-btn ng-scope']";
	public static final String VerifyEditUserPopUp="@xpath=//h2[@ng-if='!isAddNewUser']";
	public static final String VerifyTeamsUsersRemoveBtn="@xpath=//button[@class='btn btn-sm btn-danger btn-wide ng-scope']";
	public static final String VerifyTeamsName="@xpath=//div[@class='lead m-b-0 ng-binding']";
	public static final String SelectReadOnlyRoleVlueInTeam="@path=//li[@class='k-item ng-scope'][contains(text(),'ReadOnly')]";
	public static final String TeamsUsereditSaveBtn="@xpath=//button[@ng-if='!isAddNewUser']";
	public static final String RemoveUserPopupMessage="@xpath=//h2[@ng-if='!hasError']";
	public static final String RemoveBtnOnRemovePopUp="@xpath=//button[@ng-click='ok()']";
	
	
	
	//Activate / Deactivate user
	public static final String SelectedCom ="@css=.ng-scope[role='row']";
	public static final String UserTab = "@xpath=//*[@id='profile-main']//li//a[contains(.,'Users')]";
	public static final String Deactivatebtn = "@xpath=//button[contains(.,'Deactivate')][1]";
	public static final String ConfirmDeactivatebtn = "@xpath=//button[contains(.,'Yes, Deactivate it')]";
	public static final String DeActiveStatus = "@css=.text-danger";
	public static final String ActiveStatus = "@css=.text-success";
	public static final String Activatebtn = "@xpath=//a[contains(.,'Activate')]";
	
	public static final String DeactivateBtn = "@xpath=//a[contains(.,'Deactivate')]";
	public static final String ConfirmActivatebtn = "@xpath=//button[contains(.,'Yes, Activate it')]";
	public static final String ActivateUser = "@xpath=//*[@id='profile-main']//a[contains(.,'Activate')]";
	public static final String YesActivateUserButton = "@xpath=//button[contains(.,'Yes, Activate it!')]";
	public static final String YesDActivateUserButton = "@xpath=//button[contains(.,'Yes, Deactivate it!')]";
	 
	public static final String ExistingFirstUser  = "@xpath=//*[@id='profile-main']//table/tbody/tr/td[1]";
	public static final String EditExistingUser  = "@xpath=//*[@id='profile-main']//i[@class='zmdi zmdi-more-vert zmdi-hc-fw']";
	/**************Add User to Division*********************/
	public static final String SelectDivision = "@xpath=//tbody//td[1]";
	public static final String UsersTab = "@xpath=//*[@id='profile-main']//a[contains(.,'Users')]";
	public static final String AddNewUserButton = "@buttonText=Add New User";
	public static final String AddUsersPopUp = "@xpath=//h2[contains(.,'Add users to')]";
	public static final String AddUsersDropdown = "@xpath=//*[@ng-model='User']//preceding-sibling::span[1]";
	public static final String NoDataFoundValue = "@xpath=//div[@class='k-animation-container']//div[@class='k-nodata ng-scope']/div[contains(.,'No data found.')]";
	public static final String SelectUserValue = "@xpath=//div[@class='k-animation-container']//ul//li[1]";
	public static final String AddUserButton = "@xpath=//button[contains(.,'Add User')]";
	public static final String CancelButton = "@xpath=//div[contains(.,'Cancel')]";
	public String AddedUserToDivision = "@xpath=//tbody//tr[contains(.,'"+UpdateUserName+"')]";

	public static final String CompanyUser = "@xpath=//tbody//td[1]";

	//TC 4062
	public static final String TideAdminProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Tide Admin']";
	public static final String ComAdminProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Company Admin']";
	public static final String StandardUserProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Standard']";
	public static final String ReadyOnlyUserProfile = "@xpath=//li[@ng-if='authentication.authenticated']//*[text()='Read Only']";

	
	public static final String profilelink ="@xpath=//ul[@class='dropdown-menu dm-icon']//li[1]";
	public static final String EditIcondropdown ="@xpath=//ul[@class='actions hidden-xs']//li[1]//a[@class='dropdown-toggle']";
	public static final String EditIcon ="@xpath=//*[@ng-if='Permission.Edit']";
	public static final String EditMobileNo ="@xpath=//*[@data-ng-model='userDetails.PhoneNumber']";
	public static final String EditWorkPhoneNo="@xpath=//*[@data-ng-model='userDetails.WorkPhoneNumber']";
	public static final String SavechangesBtn="@xpath=//*[text()='Save Changes']";
	public static final String verifyprofileeditpage = "@xpath=//h2[contains(.,'Main Details')]";
	public static final String verifyMobileNo="@xpath=//*[@class='pm-body clearfix']/div[2]//dl[2]//dd[@class='ng-binding']";
	public static final String verifyWorkPhoneNo="@xpath=//*[@class='pm-body clearfix']/div[2]//div/dl[3]";
	
	public static final String RemoveBtnUser="@xpath=//*[@id='profile-main']//tr[1]//button[@ng-show='Permission.Delete']";
	public static final String RemoveBtn="@xpath=//button[@ng-click='removeData()']";
	
	public static final String ExistingDivision="@xpath=//*[@id='profile-main']//tr[1]//span[@ng-bind='dataItem.DivisionName']";
	public static final String ExistingDivisionWithYes="@xpath=//*[@id='profile-main']//tr/td[text()='4713']";
	public static final String ExistingDivisionWithNo="@xpath=//*[@id='profile-main']//tr//td[text()='4714']";
	public static final String EditDots = "@xpath=.//*[@id='profile-main']//li/a[@class='dropdown-toggle']";
	
	public static final String ExistingUser ="@xpath=//*[@id='profile-main']//tr[1]//span[@ng-bind='dataItem.FirstName']";
	public static final String SelectSubDivision ="@xpath=//*[@id='profile-main']//tr[1]//span[@ng-bind='dataItem.FirstName']";
	public static final String ExistingUserFromDivision = "@xpath=//*[@id='profile-main']//tr//span[@ng-bind='dataItem.DivisionName'][contains(.,'SystenicsTest')]";
	public String expDeactive = "Inactive";
	public String expActive = "Active";
	public String actualActivetxt;
	public String actualDeactivetxt;

	public String actualEmailID;
	public String expectedEmailID;
	public String actualPhoneNumber;
	public String expectedPhoneNumber;	
	public String actualWorkPhoneNumber;
	public String expectedWorkPhoneNumber;	
	public String UserAddedToDivision;	
	
	/****************************************************************************/

	public WebElement addCompany() throws InterruptedException
	{
		WebElement element = null;
		//loginPage.tideLogin();
		homePage.adminMenu();
		companyLink();
		addCompanyPage();
		sleep(2000);
		addNewCompany();
		sleep(2000);
		addCompanyMainDetails();
		addCompanyContactInformation();
		element = saveNewCompanyDetails();
		VerifyAllCompanyTab();
		homePage.adminMenu();
		companyLink();
		addCompanyPage();
		sleep(2000);
		addNewCompany();
		sleep(2000);
		addCompanyMainDetailsDup();
		element = saveNewCompanyDetailsDup();
		homePage.adminMenu();
		companyLink();
		addCompanyPage();
		return element;
	}
	
	public WebElement addBrokerCompany() throws InterruptedException
	{
		WebElement element = null;
		//loginPage.tideLogin();
		homePage.adminMenu();
		companyLink();
		addCompanyPage();
		sleep(2000);
		addNewCompany();
		sleep(2000);
		BrokerCoMainDetails();
		element = saveNewBrokerCompanyDetails();
		return element;
	}	

	public void editCompany() throws InterruptedException
	{
		applyCompanyNameFilter(CompanyName);
		openRecordInEditMode();
		editCompanyNameDetails();
		SaveAndVerifyEditOperation();
	}

	public void addDivision() throws Exception{
		MainDetailsAddDivision();
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(DivisionTitle,40);
		 ActualDivisionTitle = getTextFrom(DivisionTitle);
		 ExpectedDivisionTitle = DivisionName;
		 ExpectedDivisionTitle1 =  DivisionName +" "+DivisionRef;
		if(ActualDivisionTitle.contains(ExpectedDivisionTitle))
		{
			Report.LogInfo("CreatedDivisionTitle", "Division created successfully.", "PASS");
		}else{
			Report.LogInfo("CreatedDivisionTitle", "Division not created successfully.", "FAIL");
		}
		
		sleep(1000);
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		NavigateToDivision();	
		sleep(3000);
		verifyMustExists(Added_Division_Name,"get Added Division name");
		click(Added_Division_Name,"Click Existing Division Name");
		sleep(2000);
		waitForElementToAppear(ExistingDivisionTitle,5);
		sleep(3000);
		verifyMustExists(EditKegelDots,"Edit Dots");
		click(EditKegelDots,"Edit dots");
		verifyMustExists(EditDivisionLink,"Edit link of division");
		click(EditDivisionLink,"Edit Link of division");
		sleep(2000);
		
		DivisionReferenceDup = getTextFrom(Division_Reference,DivisionRef);
		Report.LogInfo("ValidateCountry", DivisionReferenceDup, "PASS");
		//System.out.println(DivisionReferenceDup);
		sleep(2000);
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		NavigateToDivision();		
		verifyMustExists(Add_new_Division_Button,"Add New Division Button");
		javaScriptclick(Add_new_Division_Button,"Add New Division Button");
		sleep(3000);
		verifyMustExists(Division_Name,"Division Name field");
		sendKeys(Division_Name, DivisionName,"Division Name field");
		sleep(2000);
		verifyMustExists(Division_Reference,"Division Reference field");
		sendKeys(Division_Reference, DivisionRef, "Division Reference field");
		sleep(2000);
		Ppage.SelectDropDownValue(Division_Type, Division_Insure);
		sleep(1000);
		saveDupDivision();
		verifyMustExists(cancelbtn,"Cancel button");
		click(cancelbtn,"Cancel button");
		sleep(1000);
		waitForElementToAppear(CompanyTitle,5);
		verifyMustExists(CompanyTitle, "Company Tiltle");
			}
	
	public void addDivisionForBroker() throws Exception{
		MainDetailsAddDivisionForBroker();
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(DivisionTitle,40);
		 ActualDivisionTitle = getTextFrom(DivisionTitle);
		 ExpectedDivisionTitle = DivisionName;
		 ExpectedDivisionTitle1 =  DivisionName +" "+DivisionRef;
		if(ActualDivisionTitle.contains(ExpectedDivisionTitle))
		{
			Report.LogInfo("CreatedDivisionTitle", "Division created successfully.", "PASS");
		}else{
			Report.LogInfo("CreatedDivisionTitle", "Division not created successfully.", "FAIL");
		}
		sleep(2000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
		sleep(2000);
		NavigateToDivision();
	}
	
	public void addDivision1() throws Exception{
		MainDetailsAddDivision();
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(DivisionTitle,40);
		String ActualDivisionTitle = getTextFrom(DivisionTitle);
		String ExpectedDivisionTitle = DivisionName;
		if(ActualDivisionTitle.contains(ExpectedDivisionTitle))
		{
			Report.LogInfo("CreatedDivisionTitle", "Division created successfully.", "PASS");
		}else{
			Report.LogInfo("CreatedDivisionTitle", "Division not created successfully.", "FAIL");
		}
		sleep(2000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
		sleep(2000);
		NavigateToDivision();
	}
	public void openExistingUser()
	{
		if(isVisible(ExistingUser)==true){
			waitForElementToAppear(ExistingUser,3);
			verifyMustExists(ExistingUser,"Existing User record");
			click(ExistingUser,"Existing User record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing User not available.", "FAIL");
		}
	}
	
	public void openExistingDivision()
	{
		if(isVisible(ExistingDivision)==true){
			waitForElementToAppear(ExistingDivision,3);
			verifyMustExists(ExistingDivision,"Existing division record");
			click(ExistingDivision,"Existing division record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
		}
	}	
	public void openExistingDivisionWithIsLloyds()
	{
		if(isVisible(ExistingDivisionWithYes)==true){
			waitForElementToAppear(ExistingDivisionWithYes,3);
			verifyMustExists(ExistingDivisionWithYes,"Existing division record");
			click(ExistingDivisionWithYes,"Existing division record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
	}	
	}
	public void openExistingDivisionWithIsLloydsNo()
	{
		if(isVisible(ExistingDivisionWithNo)==true){
			waitForElementToAppear(ExistingDivisionWithNo,3);
			verifyMustExists(ExistingDivisionWithNo,"Existing division record");
			click(ExistingDivisionWithNo,"Existing division record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
		}
		if(isVisible(EditDots)==true){
			verifyMustExists(EditDots,"Edit dots");
		}
	}
	
	public void VerifyExistingDivisionWithIsLoyedYes()
	{
		waitForElementToAppear(IsLloydsYesBtn,3);
		if(isVisible(IsLloydsYesBtn)==true){
			verifyMustExists(IsLloydsYesBtn,"Existing division record");
			sleep(1000);
			verifyMustExists(cancelbtn,"Cancel Button");
			click(cancelbtn,"Cancel Button");			
		}else{
			Report.LogInfo("RecordCheck", "Existing division not available.", "FAIL");
		}
		
	}
	public void editDivision() throws InterruptedException
	{
		
		applyDivisionNameFilter();	
		openRecordInEditMode1();
		EditDivisionFields();
		sleep(1000);
		SaveAndVerifyEditOperation1();
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		sleep(2000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
	}

	public void addNewTeamsInDivision() throws Exception
	{
		addCompany();
		applyCompanyNameFilter(CompanyName);
		openRecordInEditMode();
		MainDetailsAddDivision();
		sleep(1000);
		verifyMustExists(AddedDivisnRef,"Verify Division Reference and Division Name");
		sleep(1000);
		verifyMustExists(DivisnAboutTab,"Verify Division's About Tab");
		sleep(1000);
		verifyMustExists(BckToCompnyBtn,"Verify Back to company Button");
		sleep(1000);
		TeamsDetailsInDivision();
		verifyMustExists(AddNewTeamBtn,"Verify Add New Team Button");
		javaScriptclick(AddNewTeamBtn,"Click on Add New Team Button");
		sleep(1000);
		waitForElementToAppear(AddTeamPopUpMssg, 5);
		verifyMustExists(TeamName,"Verify Team Name");
		sendKeys(TeamName, TeamsName,"Teams Name field.");
		sleep(1000);
		verifyMustExists(ClassofBusnessinTeams,"class of Business Drop Down");
		javaScriptclick(ClassofBusnessinTeams,"Click class of Business Drop Down");
		sleep(1000);
		javaScriptclick(ClssOfBsnsValue,"Class of Business Value");
		sleep(2500);
		javaScriptclick(AddTeamBtnToSave,"Click Add Team Button to Save Details");
		sleep(1500);
		verifyMustExists(DuplctTeamname,"Verify Duplicate Name of Team");
		sleep(1000);
		verifyMustExists(TeamName,"Verify Team Name");
		sendKeys(TeamName, TeamsName1,"other Teams Name field.");
		sleep(1000);
		javaScriptclick(AddTeamBtnToSave,"Click Add Team Button to Save Details");
		sleep(1500);
		verifyMustExists(DuplctTeamname,"Verify Duplicate Name of Class of Business");
		sleep(1000);
		verifyMustExists(ClassofBusnessinTeams,"class of Business Drop Down");
		javaScriptclick(ClassofBusnessinTeams,"Click class of Business Drop Down");
		sleep(1000);
		javaScriptclick(clssofbsns2ndVlue,"Class of Business Second Value");
		sleep(2500);
		javaScriptclick(AddTeamBtnToSave,"Click Add Team Button to Save Details");	
		verifyMustExists(BckToCompnyBtn,"Verify Back to company Button");
		javaScriptclick(BckToCompnyBtn,"click on Back to Company Button");
			}

	public void editTeamInDivision() throws Exception{	
		//navigationOnSubDivision();
		MainDetailsAddDivisionforTeams();
		sleep(1000);
		verifyMustExists(AddedDivisnRef,"Verify Division Reference and Division Name");
		sleep(1000);
		verifyMustExists(DivisnAboutTab,"Verify Division's About Tab");
		sleep(1000);
		TeamsDetailsInDivision();
		sleep(1000);
		verifyMustExists(DivisnAboutTab,"Verify Division's About Tab");
		javaScriptclick(DivisnAboutTab,"Click on Division About Tab");
		sleep(1000);
		verifyMustExists(TeamsInDivision,"Verify Team Text");
		javaScriptclick(TeamsInDivision,"Click on Teams Tab");
		sleep(1000);
		if(isVisible(ClsofBusnsClck)==true)
		{
			verifyExists(ClsofBusnsClck,"class of Business");
			actualClassofBusinessToEdit =  getTextFrom(ClsofBusnsClck);
			Report.LogInfo("Verify Class of Business", "Verify Class Business", "Pass");
			javaScriptclick(ClsofBusnsClck,"Click on Class of Business");
			}
		else
		{
			Report.LogInfo("Teams Text", "Teams Text not visible", "Fail");
							
		}
		//sleep(1000);
		//verifyMustExists(ClsofBusnsClck,"Verify Class of Business Name");
		//javaScriptclick(ClsofBusnsClck,"Click Class of Business to Edit");
		sleep(1000);
		verifyMustExists(TeamsAboutTab,"Verify Team's About Tab");
		sleep(1000);
		verifyMustExists(EditKegelDots,"Edit Dots");
		javaScriptclick(EditKegelDots,"Edit dots");
		sleep(1000);
		verifyMustExists(EditbtnTeam,"Edit Button");
		javaScriptclick(EditbtnTeam,"Click Edit Button");
		sleep(1000);
		verifyMustExists(EditTeamName,"Verify Team Name");
		sendKeys(EditTeamName, TeamsName1,"Enter other Teams Name field.");
		sleep(1000);
		verifyMustExists(EditTeamBtnToSave,"Verify Edit Save Button");
		javaScriptclick(EditTeamBtnToSave,"Click Edit Save Button");
		//applyFilterInTeamsInDivisionName();
		sleep(1000);
		verifyMustExists(BacktoDivisionBtn,"Verify Back to Division button");
		javaScriptclick(BacktoDivisionBtn,"Click Verify Back to Division Button");
		sleep(1000);
		verifyMustExists(BackToCompanyBtn,"Back To Company Button");
		click(BackToCompanyBtn,"Back To Company Button");
	}

	public void addNewUserForCompany() throws InterruptedException
	{
		clickonUserTabAndUserButton();
		addUserDetails();
		
	}

	public void addNewUserForCompany1() throws InterruptedException
	{
		clickonUserTabAndUserButton();
		addUserDetails();
		verifyAddedUserDetails1();
	}

	public void editNewUser() throws InterruptedException{
		openSelectedUserInEditMode();
		EditMainDetailsUser();
		EditContactInformationUser();
		saveAndVerification();
	}

	public void AddEditRemoveUserInTeams() throws Exception{
		//addCompany();
		homePage.adminMenu();
		companyLink();
		addCompanyPage();
		sleep(2000);
		applyCompanyNameFilter("1 Answer Insurance Services Ltd");
		openRecordInEditMode();
		NavigateToDivision();
		sleep(1000);
		verifyMustExists(ExistingDivisionName, "division name");
		javaScriptclick(ExistingDivisionName);
		//MainDetailsAddDivisionforAddUserInTeams();
		sleep(1000);
		verifyMustExists(AddedDivisnRef,"Verify Division Reference and Division Name");
		sleep(1000);
		verifyMustExists(DivisnAboutTab,"Verify Division's About Tab");
		sleep(1000);
		verifyMustExists(BacktoCompanybtn,"Verify Back to Company Button");
		sleep(1000);
		verifyMustExists(DivisnAboutTab,"Verify Division's About Tab");
		javaScriptclick(DivisnAboutTab,"Click on Division About Tab");
		sleep(1000);
		verifyMustExists(TeamsInDivision,"Verify Team Text");
		javaScriptclick(TeamsInDivision,"Click on Teams Tab");
		sleep(1000);
		verifyMustExists(ClsofBusnsClck,"Verify Class of Business Name");
		javaScriptclick(ClsofBusnsClck,"Click Class of Business to Edit");
		sleep(1000);
		verifyMustExists(TeamsAboutTab,"Verify Team's About Tab");
		sleep(1000);
		verifyMustExists(BackToDivisionBtn,"Verify Back to Division Button");
		sleep(1000);
		if(isVisible(UserTabInTeam)==true)
		{verifyExists(UserTabInTeam,"User Tab");
			UserTabInTeamVerify =  getTextFrom(UserTabInTeam);
			Report.LogInfo("User Tab  Division", "User Tab visible", "Pass");
			javaScriptclick(UserTabInTeam,"Click on User Tab");
			sleep(1000);
		}else
	{
		Report.LogInfo("User Tab", "User Tab not visible", "Fail");
		}
			verifyMustExists(AddNewUserInTeam,"Verify Add New User Button");
			javaScriptclick(AddNewUserInTeam,"Click on Add New User Button");
			sleep(1000);
			waitForElementToAppear(VerifyAddUserHeader, 5);
			verifyMustExists(VerifyAddUserHeader,"Verify Team Name Field");
			sleep(1000);
			SelectDropDownValue(SelectUserDDInTeam,SelectUserDDValueInTeam);
			sleep(1000);
			waitForElementToAppear(SaveBtnToAddUserInTeam, 5);
			javaScriptclick(SaveBtnToAddUserInTeam,"Click Add User Button to Add User in Team");
			sleep(1000);
			verifyMustExists(VerifyTeamsName, "Verify Teams Name");
			sleep(1000);
			verifyMustExists(FirstNameUserinTeam, "Verify Added User First Name");
			Report.LogInfo("Verify Teams Name in User tab", FirstNameUserinTeam, "PASS");
			sleep(2000);
			verifyMustExists(VerifyRoleOfUserInTeam, "Verify Team's User Role");
			TeamsUserRole =  getTextFrom(VerifyRoleOfUserInTeam);
			Report.LogInfo("RoleColumnInTeamsUserTab", VerifyRoleOfUserInTeam, "Pass");
			sleep(1000);
			verifyMustExists(VerifyAddedFrstName, "Verify Added User First Name");
			sleep(1000);
			verifyMustExists(VerifyTeamsUserEditBtn, "Verify Edit User Button in Team");
			sleep(1000);
			verifyMustExists(VerifyTeamsUsersRemoveBtn, "Verif Remove Button in Team");
			javaScriptclick(BackToDivisionBtn,"Click Vack to Division Button");
			sleep(1000);
			javaScriptclick(BckToCompnyBtn,"Click Back to Company Button");
			sleep(1000);
			VerifyTeamsUserInCompanyUser();
			verifyMustExists(VerifyTeamsClmInUser, "Verify Team Column in User Tab");
			TeamValueInUserTab =  getTextFrom(VerifyTeamsClmInUser);
			Report.LogInfo("Team Value in User Tab", VerifyTeamsClmInUser, "Pass");
			EditandRemoveUserFromTeam();
			VerifyTeamsUserInCompanyUser();
			verifyMustExists(VerifyTeamsClmInUser, "Verify Team Column in User Tab");
			BlnkValueInTeamcolumnInUserTab =  getTextFrom(VerifyTeamsClmInUser);
			Report.LogInfo("Team Value in User Tab is blank", VerifyTeamsClmInUser, "Pass");
						
			/*click(VerifyTeamsUsersRemoveBtn,"Click Vack to Division Button");
			javaScriptclick(BackToDivisionBtn,"Click Vack to Division Button");*/
			}	
			
	
	public void removeAddedUserToDivision() throws Exception{
		NavigateToDivision();
		selectAddedDivision();
		selectUsersTab();
		waitForElementToAppear(RemoveBtnUser,3);
		if(isVisible(RemoveBtnUser)==true){			
			verifyMustExists(RemoveBtnUser,"Remove button");
			click(RemoveBtnUser,"Remove button");
			waitForElementToAppear(RemoveBtn,3);
			verifyMustExists(RemoveBtn,"Are you sure Remove button");
			click(RemoveBtn,"Are you sure Remove button");
			sleep(2000);
		}
		scrollUp();
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		sleep(2000);
	}
	public void selectAddedSubDivision()
	{
		waitForElementToAppear(SelectDivision,5);
		verifyMustExists(SelectDivision,"Division exists");
		click(selectuser,"Select Division");
	}
	public void removeAddedUserToExistingDivision() throws Exception{
		waitForElementToAppear(RemoveBtnUser,3);
		if(isVisible(RemoveBtnUser)==true){			
			verifyMustExists(RemoveBtnUser,"Remove button");
			click(RemoveBtnUser,"Remove button");
			waitForElementToAppear(RemoveBtn,3);
			verifyMustExists(RemoveBtn,"Are you sure Remove button");
			click(RemoveBtn,"Are you sure Remove button");
			sleep(2000);
		}
		scrollUp();
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		sleep(2000);
	}

	public void addUserToSubDivision() throws Exception{
		//navigationOnSubDivision();
		openRecordInEditModeSubDivision();
		selectUsersTab();
		sleep(2000);
		createNewUserUnderDivision();
	}
	public void removeUserToSubDivision() throws Exception{
		//navigationOnSubDivision();
		selectAddedSubDivision();		
		selectUsersTab();
		sleep(2000);
		//createNewUserUnderDivision();
		waitForElementToAppear(RemoveBtnUser,3);
		if(isVisible(RemoveBtnUser)==true){			
			verifyMustExists(RemoveBtnUser,"Remove button");
			click(RemoveBtnUser,"Remove button");
			waitForElementToAppear(RemoveBtn,3);
			verifyMustExists(RemoveBtn,"Are you sure Remove button");
			click(RemoveBtn,"Are you sure Remove button");
			sleep(2000);
		}
		scrollUp();
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		sleep(2000);
	}
	//3163 Activate a User
	public void activateNewUser() throws Exception
	{
		navigationOnUserTab();
		activateUser();
		checkActiveStatus();
	}

	//3164 Deactivate a User
	public void deactivateNewUser() throws Exception
	{
		deactivateUser();
		checkDeactiveStatus();
	}

	public void Edit_UserProfile_Of_User_4062() throws Exception
	{
		
		//waitForElementToAppear(TideAdminProfile,4);
		sleep(2000);
		if(isVisible(TideAdminProfile)==true){
			verifyMustExists(TideAdminProfile,"Tide Admin");
			click(TideAdminProfile,"TideA dmin");
		}
		if(isVisible(ComAdminProfile)==true){
			verifyMustExists(ComAdminProfile,"Tide Admin");
			click(ComAdminProfile,"TideA dmin");
		}
		
		waitForElementToAppear(profilelink,4);
		verifyMustExists(profilelink,"Pofile");
		click(profilelink,"Profile");
		verifyMustExists(EditIcondropdown,"Edit User drop down");
		click(EditIcondropdown,"Click on Edit drop down");
		verifyMustExists(EditIcon,"Edit Pofile");
		click(EditIcon,"Edit Profile");
		waitForElementToAppear(EditMobileNo,4);
		verifyMustExists(EditMobileNo,"Edit Mobile No.");
		sendKeys(EditMobileNo,ActualMobileNumber,"Edit Mobile No.");
		verifyMustExists(SavechangesBtn,"Save Edited changes");
		click(SavechangesBtn,"Save Edited changes");
		sleep(5000);
		verifyExists(verifyprofileeditpage, "Verify profile edit page");
		mouseOverAction(verifyMobileNo);
		verifyExists(verifyMobileNo, "Verify Mobile no field");
		 EditedMobileno = getTextFrom(verifyMobileNo);

		if(ActualMobileNumber.equalsIgnoreCase(EditedMobileno)){

			Report.LogInfo("ValidateEdit", "Phone Number updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Phone Number not updated successfully.", "FAIL");
		}

		sleep(2000);
	}

	/******************************************************************************/
	public void StandardUserProfile() throws Exception
	{
		sleep(2000);
		if(isVisible(StandardUserProfile)==true){
			verifyMustExists(StandardUserProfile,"Tide Admin");
			click(StandardUserProfile,"TideA dmin");
			waitForElementToAppear(profilelink,4);
			verifyMustExists(profilelink,"Pofile");
			click(profilelink,"Profile");
			sleep(2000);			
		}
	}
	
	public void ReadOnlyUserProfile() throws Exception
	{
		sleep(2000);
		if(isVisible(ReadyOnlyUserProfile)==true){
			verifyMustExists(ReadyOnlyUserProfile,"Read only");
			click(ReadyOnlyUserProfile,"Read only");
			waitForElementToAppear(profilelink,4);
			verifyMustExists(profilelink,"Pofile");
			click(profilelink,"Profile");
			sleep(2000);			
		}
	}
	
	public void companyLink()
	{
		waitForElementToAppear(CompaniesLnk,5);
		//verifyMustExists(CompaniesLnk,"Company Link");
		click(CompaniesLnk,"Company Link",true);
	}



	public void addCompanyPage()
	{
		waitForElementToAppear(CompanyPageLbl,5);
		verifyExists(CompanyPageLbl,"Companies Label");	
	}

	public void addNewCompany()
	{
		waitForElementToAppear(AddNewCompanyBtn,5);
		//verifyMustExists(AddNewCompanyBtn,"Add New Company Button");	
		click(AddNewCompanyBtn,"Add New Company Button",true);
	}
	
	
	public void addCompanyMainDetails()
	{
		waitForElementToAppear(CompanyNameTxt,5);
		verifyMustExists(CompanyNameTxt,"Company Name Textbox");	
		sendKeys(CompanyNameTxt,CompanyName,"Company Name field.");
		verifyMustExists(TradingNameTxt,"Trading Name Textbox");	
		sendKeys(TradingNameTxt,rd.getDataFromCell(path, "TestData", 6, 1), "Trading Name textbox.");
		sleep(1000);
		verifyMustExists(CompanyTypeDD,"Verify Company type Drop down");
		javaScriptclick(CompanyTypeDD,"Click Company type Drop down");
		//SelectDropDownValue(CompanyTypeDD,InsurerDDValue);
		sleep(1000);
		verifyMustExists(RegulatorRoleValue,"Verify Regulator Role Company Type");
		Report.LogInfo("Verify Regulator Role Option", "Verify Regulator Role Company Type is visible", "PASS");
		sleep(1000);
		verifyMustExists(ServiceProviderValue,"Verify Service Provide Company Type");
		Report.LogInfo("Verify Service Provider Option", "Verify Service Provider Role Company Type is visible", "PASS");
		sleep(1000);
		verifyMustExists(TPAValue,"Verify TPA Company Type");
		Report.LogInfo("Verify TPA Option", "Verify TPA Role Company Type is visible", "PASS");
		sleep(1000);
		verifyMustExists(CoverholderValue,"Verify Coverholder Company Type");
		Report.LogInfo("Verify Cover Holder Option", "Verify Cover Holder Role Company Type is visible", "PASS");
		sleep(1000);
		verifyMustExists(BrokerDDValue,"Verify Broker Company Type");
		Report.LogInfo("Verify Broker Option", "Verify Broker Role Company Type is visible", "PASS");
		sleep(1000);
		verifyMustExists(InsurerDDValue,"Verify Insurer Company Type");
		Report.LogInfo("Verify Insurer Option", "Verify Insurer Role Company Type is visible", "PASS");
		javaScriptclick(InsurerDDValue,"Insurer Dropdown Value");
		Report.LogInfo("Clicked Insurer Option", " Clicked Insurer Role Company Type Successfully", "PASS");
		sleep(1000);
		verifyMustExists(LoyldYesBtn,"Verify Is Lioyd's button");
		Report.LogInfo("Verify IsLioyd's Button", " Verify Is Liyod's Button is Visible", "PASS");
		sleep(1000);
		verifyMustExists(LoyldNoBtn,"Verify Is Lioyd's No Button");
		Report.LogInfo("Verify IsLioyd's No Button", " Verify Is Liyod's No Button is Visible", "PASS");
		click(LoyldNoBtn,"Click Is Lioyd's No Button");
		Report.LogInfo("Clicked IsLioyd's No Button", " Clicked Is Liyod's No Button Sucessfully", "PASS");
		sleep(1000);
		verifyMustExists(LoyldYesBtn,"Verify Is Lioyd's button");
		Report.LogInfo("Verify IsLioyd's Button", " Verify Is Liyod's Button is Visible", "PASS");
		click(LoyldYesBtn,"Clicked Is Lioyd's button");
		Report.LogInfo("Clicked IsLioyd's Yes Button", " Clicked Is Liyod's Yes Button Sucessfully", "PASS");
			/*verifyMustExists(CompanyTypeDD,"Company Dropdown");	
		click(CompanyTypeDD,"Company Dropdown");
		javaScriptWait();
		verifyMustExists(InsurerDDValue,"Insurer Dropdown Value");	
		*/
	}
	
	public void addCompanyMainDetailsDup()
	{
		waitForElementToAppear(CompanyNameTxt,5);
		verifyMustExists(CompanyNameTxt,"Company Name Textbox");	
		sendKeys(CompanyNameTxt,CompanyNameDup,"Company Name field.");
		verifyMustExists(TradingNameTxt,"Trading Name Textbox");	
		sendKeys(TradingNameTxt,rd.getDataFromCell(path, "TestData", 6, 1), "Trading Name textbox.");
		SelectDropDownValue(CompanyTypeDD,InsurerDDValue);
	}
	
	public void BrokerCoMainDetails()
	{
		waitForElementToAppear(CompanyNameTxt,5);
		verifyMustExists(CompanyNameTxt,"Company Name Textbox");
		sendKeys(CompanyNameTxt,CompanyNameCovrholder,"Company Name field");
		verifyMustExists(TradingNameTxt,"Trading Name Textbox");
		sendKeys(TradingNameTxt,rd.getDataFromCell(path, "TestData", 6, 1),"Trading Name textbox.");
		SelectDropDownValue(CompanyTypeDD,BrokerDDValue);
		
	}
	
	
	public void addCompanyContactInformation()
	{
		waitForElementToAppear(TelephoneTxt,5);
		verifyMustExists(TelephoneTxt,"Telephone textbox");	
		sendKeys(TelephoneTxt,rd.getDataFromCell(path, "TestData", 9, 0), "Telephone textbox.");
		verifyMustExists(Address_1Txt,"Address 1 textbox");	
		sendKeys(Address_1Txt,rd.getDataFromCell(path, "TestData", 9, 1), "Address1 textbox.");
		verifyMustExists(Address_2Txt,"Address 2 textbox");	
		sendKeys(Address_2Txt,rd.getDataFromCell(path, "TestData", 9, 2), "Address2 textbox.");
		verifyMustExists(CityTxt,"City textbox");	
		sendKeys(CityTxt,rd.getDataFromCell(path, "TestData", 9, 3), "City textbox.");
		verifyMustExists(PostalCodeTxt,"Postal Code textbox");	
		sendKeys(PostalCodeTxt,rd.getDataFromCell(path, "TestData", 9, 4), "Postal Code textbox.");
		verifyMustExists(StateTxt,"State textbox");	
		sendKeys(StateTxt,rd.getDataFromCell(path, "TestData", 9, 5), "State textbox.");
		SelectDropDownValue(CountryDD,IndiaDDValue);
	}

	public WebElement saveNewCompanyDetails()
	{
		WebElement element = null;
		waitForElementToAppear(SaveBtn,5);
		//verifyMustExists(SaveBtn,"Save button");	
		click(SaveBtn,"Save button");
		waitForElementToAppear(VerifyAddedCompany,5);
		//verifyExists(VerifyAddedCompany,"Added Company");
		element = findWebElement(VerifyAddedCompany); // check if the element for "Added Company Exist"
		return element;
	}
	
	public WebElement saveNewCompanyDetailsDup()
		{
		WebElement element = null;
		waitForElementToAppear(SaveBtn,5);
		//verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
		waitForElementToAppear(VerifyDuplicateError,5);	
		verifyMustExists(VerifyDuplicateError,"'Company Name is duplicate'");	
		element = findWebElement(VerifyDuplicateError); // check if the element for "Duplicate Error"
		return element;
}
	
	public WebElement saveNewBrokerCompanyDetails()
	{
		WebElement element = null;
		waitForElementToAppear(SaveBtn,5);
		//verifyMustExists(SaveBtn,"Save button");	
		click(SaveBtn,"Save button");
		waitForElementToAppear(VerifyAddedCompany,5);
		//verifyExists(VerifyAddedCompany,"Added Company");
		element = findWebElement(VerifyAddedCompany); // check if the element for "Added Company Exist"
		return element;
	}
	
	public void applyCompanyNameFilter(String ComName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+ComName+"')]";
		//sleep(3000);
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			clickAndWait(CompanyNameFilter, "Company Name Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,ComName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void openRecordInEditMode() throws InterruptedException
	{	
		sleep(3000);
		waitForElementToAppear(SystenicsCompanyName,5);
		verifyMustExists(SystenicsCompanyName,"Filtered record");
		click(SystenicsCompanyName,"Filtered record");
		//sleep(2000);
		waitForElementToAppear(EditKebabIcon,5);
		verifyMustExists(EditKebabIcon,"Edit dots");
		click(EditKebabIcon,"Edit dots");
		verifyMustExists(EditoptionLink,"Edit link");
		click(EditoptionLink,"Edit link");
	}

	public void editCompanyNameDetails() throws InterruptedException
	{
		waitForElementToAppear(CompanyNameTxt,5);
		clearTextBox(CompanyNameTxt);
		sleep(3000);
		sendKeys(CompanyNameTxt,EditCompanyName, "Company Name Textbox.");
		sleep(3000);
		clearTextBox(TradingNameTxt);
		sendKeys(TradingNameTxt,rd.getDataFromCell(path, "TestData",14,1), "Trading Name Textbox.");
		verifyMustExists(CompanyTypeDD1,"Company Type DD record"); 
		click(CompanyTypeDD1,"Country Type Button");
		click(InsurerDDValue,"Insurer Option");
		clearTextBox(TelephoneTxt);
		sendKeys(TelephoneTxt,rd.getDataFromCell(path, "TestData",17,0), "Telephone Textbox.");
		clearTextBox(Address_1Txt);
		sendKeys(Address_1Txt,rd.getDataFromCell(path, "TestData",17,1), "Address1 Textbox.");
		clearTextBox(Address_2Txt);
		sendKeys(Address_2Txt,rd.getDataFromCell(path, "TestData",17,2), "Address2 Textbox.");
		clearTextBox(CityTxt); 
		sendKeys(CityTxt,rd.getDataFromCell(path, "TestData",17,3), "City Textbox.");
		clearTextBox(PostalCodeTxt);
		sendKeys(PostalCodeTxt,rd.getDataFromCell(path, "TestData",17,4), "Postal Code Textbox.");
		clearTextBox(StateTxt);
		sendKeys(StateTxt,rd.getDataFromCell(path, "TestData",17,5), "State Textbox.");
		SelectDropDownValue(CountryDD,UnitedStateDDValue);
		sleep(1500);
	}

	public void SaveAndVerifyEditOperation() throws InterruptedException
	{
		
		waitForElementToAppear(SaveChangesBtn,5);
		verifyMustExists(SaveChangesBtn,"Save button");
		click(SaveChangesBtn,"Save button");
		javaScriptWait();
		waitToPageLoad();
		waitForElementToAppear(Editedcountry,20);
		 expectedcompanyname =rd.getDataFromCell(path,"TestData",14,0);
		 actualcompnayname = getTextFrom(Editedcompanyname);
		/*if(actualcompnayname.equals(expectedcompanyname))
		{
			Report.LogInfo("ValidateCompanyName", "Company Name edited successfully.", "PASS");
		}else
		{
			Report.LogInfo("ValidateCompanyName", "Company Name not edited successfully.", "FAIL");
		}*/
		 actualTradingName=getTextFrom(EditedTradingname);
		  expectedTradingName=rd.getDataFromCell(path, "TestData",14,1);
		if(actualTradingName.equals(expectedTradingName))
		{
			Report.LogInfo("ValidateTradingName", "Trading Name edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateTradingName", "Trading Name not edited successfully.", "FAIL");
		}

		 actualTelephone=getTextFrom(EditedTelephone);
		  expectedTelephone=rd.getDataFromCell(path, "TestData",17,0);
		if(actualTelephone.equals(expectedTelephone))
		{
			Report.LogInfo("ValidateTelephone", "Telephone edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateTelephone", "Telephone not edited successfully.", "FAIL");
		}
		 actualAddress1=getTextFrom(Editedaddress1);
		 expectedAddress1=rd.getDataFromCell(path, "TestData",17,1);
		if(actualAddress1.equals(expectedAddress1))
		{
			Report.LogInfo("ValidateAddress1", "Address1 edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateAddress1", "Address1 not edited successfully.", "FAIL");
		}
		 actualAddress2=getTextFrom(Editedaddress2);
		  expectedAddress2=rd.getDataFromCell(path, "TestData",17,2);
		if(actualAddress2.equals(expectedAddress2))
		{
			Report.LogInfo("ValidateAddress2", "Address2 edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateAddress2", "Address2 not edited successfully.", "FAIL");
		}
		 actualCity=getTextFrom(Editedcity);
		 expectedCity=rd.getDataFromCell(path, "TestData",17,3);
		if(actualCity.equals(expectedCity))
		{
			Report.LogInfo("ValidateCity", "City edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateCity", "City not edited successfully.", "FAIL");
		}			 
		 actualpostalcode=getTextFrom(Editedpostalcode);
		 expectedpostalcode=rd.getDataFromCell(path, "TestData",17,4);
		if(actualpostalcode.equals(expectedpostalcode))
		{
			Report.LogInfo("ValidatePostalCode", "Postal code edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidatePostalCode", "Postal code not edited successfully.", "FAIL");
		}	
		 actualstate=getTextFrom(Editedstate);
		 expectedstate=rd.getDataFromCell(path, "TestData",17,5);
		if(actualstate.equals(expectedstate))
		{
			Report.LogInfo("Validatestate", "State edited successfully.", "PASS");
		}else{
			Report.LogInfo("Validatestate", "State not edited successfully.", "FAIL");
		}	
		 actualcountry=getTextFrom(Editedcountry);
		 expectedcountry=rd.getDataFromCell(path, "TestData",17,6);

		if(actualcountry.equalsIgnoreCase(expectedcountry))
		{
			Report.LogInfo("ValidateCountry", "Country edited successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateCountry", "Country not edited successfully.", "FAIL");
		}	
	}

	public void contactInformation(String number)
	{
		waitForElementToAppear(PhoneNumber,5);
		verifyMustExists(PhoneNumber,"Phone Number field");
		sendKeys(PhoneNumber, number, "Phone Number Field.");
	}

	public void MainDetailsAddDivision() throws Exception
	{
		String Country = "India";
		String PhoneNumber= "9999999999";
		NavigateToDivision();
		sleep(2000);
		verifyMustExists(Add_new_Division_Button,"Add New Division Button");
		javaScriptclick(Add_new_Division_Button,"Add New Division Button");
		sleep(3000);
		verifyMustExists(Division_Name,"Division Name field");
		sendKeys(Division_Name, DivisionName, "Division Name field.");
		verifyMustExists(Division_Reference,"Division Reference field");
		sendKeys(Division_Reference,DivisionRef,"Division Reference field.");
		/*verifyMustExists(Division_Type,"Division Type field");
		click(Division_Type,"Division Type");
		sleep(1000);
		click(Division_Insure,"Division Insurer option");*/
		sleep(2000);
		Ppage.SelectDropDownValue(Division_Type, Division_Insure);
		sleep(2000);
		//SelectDropDownValue(Regulator_Role, RegulatorRole_Value);
		verifyMustExists(Regulator_Role,"Click Regulator Role Vlue");
		click(Regulator_Role,"Click Regulator Role Vlue");
		verifyMustExists(RegulatorRole_Value,"Click Regulator Role Vlue");
		click(RegulatorRole_Value,"Click Regulator Role Vlue");
		sleep(1000);
		verifyMustExists(Address1,"Address1 field");
		sendKeys(Address1, rd.getDataFromCell(path, "TestData",20 ,2 ), "Address1 Field.");
		sleep(1000);
		verifyMustExists(Address2,"Address2 field");
		//sendKeys(Address2,Addres2,"Division New Address2 field.");
		sendKeys(Address2,Address2MainDivisn , "Address2 Field.");
		sleep(1000);
		verifyMustExists(City,"City field");
		sendKeys(City, rd.getDataFromCell(path, "TestData",20 ,3 ), "City Field.");
		sleep(1000);
		verifyMustExists(PostalCode,"PostalCode field");
		sendKeys(PostalCode, rd.getDataFromCell(path, "TestData",20 ,4), "Postal Code Field.");
		sleep(1500);
		verifyMustExists(State,"State field");
		sendKeys(State, rd.getDataFromCell(path, "TestData",20 ,5), "State Field.");
		sleep(2000);
		Ppage.SelectDropDownValue(Country_Dropdown, Country_Option);
		contactInformation(PhoneNumber);
		saveAddedDivision();

	}
	
	public void MainDetailsAddDivisionForBroker() throws Exception
	{
		NavigateToDivision();
		sleep(2000);
		verifyMustExists(Add_new_Division_Button,"Add New Division Button");
		javaScriptclick(Add_new_Division_Button,"Add New Division Button");
		sleep(3000);
		verifyMustExists(Division_Name,"Division Name field");
		sendKeys(Division_Name, DivisionName, "Division Name field.");
		verifyMustExists(Division_Reference,"Division Reference field");
		sendKeys(Division_Reference,DivisionRef,"Division Reference field.");
		/*verifyMustExists(Division_Type,"Division Type field");
		click(Division_Type,"Division Type");
		sleep(1000);
		click(Division_Insure,"Division Insurer option");*/
		sleep(2000);
		Ppage.SelectDropDownValue(Division_Type, Division_Broker);
		sleep(2000);
		if(isVisible(RegulatorRoleTextVerify)==true)
		{
			verifyExists(RegulatorRoleTextVerify,"Regulator Role Text");
			RegulatorRoleVerify =  getTextFrom(RegulatorRoleTextVerify);
			Report.LogInfo("Regulator Role Text", "Regulator Role Text visible", "Fail");
		}
		else
		{
			Report.LogInfo("Regulator Role Text", "Regulator Role Text not visible", "pass");
							
		}
		sleep(2000);
		javaScriptWait();
		
		saveAddedDivision();
	
	}

	public void MainDetailsAddDivision1() throws Exception
	{
		String Country = "India";
		String PhoneNumber= "9999999999";
		NavigateToDivision();
		sleep(2000);
		verifyMustExists(Add_new_Division_Button,"Add New Division Button");
		javaScriptclick(Add_new_Division_Button,"Add New Division Button");
		sleep(3000);
		verifyMustExists(Division_Name,"Division Name field");
		sendKeys(Division_Name, DivisionName, "Division Name field.");
		verifyMustExists(Division_Reference,"Division Reference field");
		sendKeys(Division_Reference,DivisionRef,"Division Reference field.");
		sleep(2000);
		Ppage.SelectDropDownValue(Division_Type, Division_Insure);
		sleep(1000);
		verifyMustExists(IsLloydsYesBtn,"Is Lloyds Yes Btn");
		javaScriptclick(IsLloydsYesBtn,"Is Lloyds Yes Btn");
		verifyMustExists(Address1,"Address1 field");
		sendKeys(Address1, rd.getDataFromCell(path, "TestData",30 ,2 ), "Address1 Field.");
		verifyMustExists(City,"City field");
		sendKeys(City, rd.getDataFromCell(path, "TestData",30 ,3 ), "Address1 Field.");
		verifyMustExists(PostalCode,"PostalCode field");
		sendKeys(PostalCode, rd.getDataFromCell(path, "TestData",30 ,4), "Postal Code Field.");
		verifyMustExists(State,"State field");
		sendKeys(State, rd.getDataFromCell(path, "TestData",30 ,5), "State Field.");
		sleep(2000);
		Ppage.SelectDropDownValue(Country_Dropdown, Country_Option);
		contactInformation(PhoneNumber);
		saveAddedDivision();
	}
	public void saveAddedDivision() throws Exception{
		waitForElementToAppear(Save_Button,5);
		verifyMustExists(Save_Button,"Save Button field");
		click(Save_Button,"Save Button");
		sleep(3000);
	}
	
	
	public WebElement saveDupDivision()
	{
	WebElement element = null;
	waitForElementToAppear(Save_Button,5);
	verifyMustExists(Save_Button,"Save Button field");
	click(Save_Button,"Save Button");
	sleep(3000);
	waitForElementToAppear(DupDivisionRefErrorMessage,5);	
	verifyMustExists(DupDivisionRefErrorMessage,"Division Reference already exist in this division");	
	element = findWebElement(DupDivisionRefErrorMessage); // check if the element for "Duplicate Error"
	return element;
			
	}
	
	
	

	public void NavigateToDivision() throws Exception{
		waitForElementToAppear(Division,5);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		verifyMustExists(Division,"Division Tab");
		click(Division,"Division Tab");
		sleep(2000);
	}
	public void applyDivisionNameFilter() throws InterruptedException
	{
		
		waitForElementToAppear(DivisionFilterIcon,5);
		verifyMustExists(DivisionFilterIcon,"Division Filter Icon");
		click(DivisionFilterIcon,"Division Filter Icon");
		sleep(2000);
		sendKeys(DivisionSearchBox, DivisionName,  "Division SearchBox field.");
		verifyMustExists(DivisionCheckBox,"Division Checkbox");
		click(DivisionCheckBox,"Division Checkbox");
		verifyMustExists(DivisionFilterLink,"Division Filter Link");
		click(DivisionFilterLink,"Division Filter Link");		
	}

	public void openRecordInEditMode1() throws InterruptedException
	{	
		/*waitForElementToAppear(CompanyNameFilter,5);
		click(CompanyNameFilter,"Company Name Filter");
		sleep(2000);*/
		waitForElementToAppear(DivisionFirstRecrd,5);
		verifyMustExists(DivisionFirstRecrd,"Division Filter Record");
		click(DivisionFirstRecrd,"Division Filter Record");
		verifyMustExists(EditKegelDots,"Edit Dots");
		click(EditKegelDots,"Edit dots");
		verifyMustExists(EditDivisionLink,"Edit link of division");
		click(EditDivisionLink,"Edit Link of division");
	}

	public void EditDivisionFields() throws InterruptedException
	{	
		waitForElementToAppear(EdDivisionRefName,5);
		clearTextBox(EdDivisionRefName);
		sendKeys(EdDivisionRefName,expRefTitle, "Division Reference Name field.");
		clearTextBox(EdDivisionAdd1);
		sleep(1000);
		sendKeys(EdDivisionAdd1,expAddress1,"Division Address1 field.");
		clearTextBox(EdDivisionAdd2);
		sleep(1000);
		sendKeys(EdDivisionAdd2,expAddress2,"Division Address2 field.");
		clearTextBox(EdDivisionCity);
		sleep(1000);
		sendKeys(EdDivisionCity,expCity,"Division City field.");
		clearTextBox(EdDivisionPostsalCd);
		sleep(1000);
		sendKeys(EdDivisionPostsalCd,expPostalCode,"Division Postal Code field.");
		clearTextBox(EdDivisionState);
		sendKeys(EdDivisionState,expState,"Division State field.");		
		clearTextBox(EdDivisionTelNo);
		sleep(1000);
		sendKeys(EdDivisionTelNo,expTelNo,"Division Telephone Number field.");		
	}

	public void SaveAndVerifyEditOperation1() throws InterruptedException
	{
		waitForElementToAppear(EditSaveBtn,5);
		verifyMustExists(EditSaveBtn,"Save button");
		click(EditSaveBtn,"Save button");	
		javaScriptWait();
		waitToPageLoad();
		
		actualDivisionRef =	getTextFrom(EditDivisionRef);
		Report.LogInfo("ValidatedivisionReference", actualDivisionRef, "PASS");
		Report.LogInfo("ValidateDivisionReference", expRefTitle, "PASS");
		if(actualDivisionRef.equals(expRefTitle))
		{
			Report.LogInfo("Validate Division Reference", "Div Reference edited successfully.", "PASS");
		}else
		{
			Report.LogInfo("Validate Division Reference", "Div Reference not edited successfully.", "FAIL");
		}sleep(1000);
		
	actualEdDivisionAdd1 =	getTextFrom(EdDivisionAdd11);
	Report.LogInfo("ValidateAddress1", actualEdDivisionAdd1, "PASS");
	Report.LogInfo("ValidateAddress1", expAddress1, "PASS");
	if(actualEdDivisionAdd1.equals(expAddress1))
	{
		Report.LogInfo("Validate Address1", "Div Address  edited successfully.", "PASS");
	}else
	{
		Report.LogInfo("Validate Address1", "Div Address not edited successfully.", "FAIL");
	}sleep(1000);
	actalEdDivisionAdd2 = getTextFrom(EdDivisionAddLin2);
	Report.LogInfo("ValidateAddress2", actalEdDivisionAdd2, "PASS");
	Report.LogInfo("ValidateAddress2", expAddress2, "PASS");
	if(actalEdDivisionAdd2.equals(expAddress2))
	{
		Report.LogInfo("ValidateAddress2", "Div Address2 Edited successfully.", "PASS");
	}else
	{
		Report.LogInfo("Validate Address2", "Div Address2 not edited successfully.", "FAIL");
	}sleep(1000);
	actualEdDivisionCity =	getTextFrom(EdDivisionCity1);
	Report.LogInfo("Validate City name", actualEdDivisionCity, "PASS");
	Report.LogInfo("Validate City name", expCity, "PASS");
	if(actualEdDivisionCity.equals(expCity))
	{
		Report.LogInfo("Validate City Name", "Div city  edited successfully.", "PASS");
	}else
	{
		Report.LogInfo("Validate City Name", "Div city not edited successfully.", "FAIL");
	}sleep(1000);
	actualEdDivisionPostsalCd = getTextFrom(EdDivisionPostsalCd1);
	Report.LogInfo("Validate postal code", actualEdDivisionPostsalCd, "PASS");
	Report.LogInfo("Validate postal code", expPostalCode, "PASS");
	if(actualEdDivisionPostsalCd.equals(expPostalCode))
	{
		Report.LogInfo("Validate Postal Code", "Div Postal code edited successfully.", "PASS");
	}else
	{
		Report.LogInfo("Validate Postal Code", "Div Postal code not edited successfully.", "FAIL");
	}sleep(1000);
	actualEdDivisionState =	getTextFrom(EdDivisionState1);
	Report.LogInfo("Validate State", actualEdDivisionState, "PASS");
	Report.LogInfo("Validate State", expState, "PASS");
	if(actualEdDivisionState.equals(expState))
	{
		Report.LogInfo("Validate State", "Div state  edited successfully.", "PASS");
	}else
	{
		Report.LogInfo("Validate State", "Div State not edited successfully.", "FAIL");
	}
		
	}

	public void navigationOnDivision() throws InterruptedException
	{
		waitForElementToAppear(DivisionTab,5);
		verifyMustExists(DivisionTab,"Sub division tab");
		click(DivisionTab,"Sub division tab");		
	}

	public void openAddNewSubDivisionPage() throws InterruptedException
	{	
		waitForElementToAppear(Add_New_SubDivision_Button,5);
		verifyMustExists(Add_New_SubDivision_Button,"Add new sub division button");
		click(Add_New_SubDivision_Button,"Add new sub division button");		
	}

	public void MainDetailsAddSubDivision() throws Exception{
		String Country = "India";
		sleep(2000);
		waitForElementToAppear(SubDivisionName,5);
		verifyMustExists(SubDivisionName,"Division Name field");
		sendKeys(SubDivisionName, SubDivision,"Division Name field.");
		verifyMustExists(SubDivisionRefName,"Division Reference field");
		sendKeys(SubDivisionRefName, SubDivisionRef,"Division Reference field.");
		verifyMustExists(Division_Type,"Division Type field");
		click(Division_Type,"Division Type");
		sleep(1000);
		click(Division_Broker,"Division Broker option");
		sleep(2000);
		if(isVisible(RegulatorRoleTextVerify)==true)
		{
			verifyExists(RegulatorRoleTextVerify,"Regulator Role Text");
			RegulatorRoleVerify =  getTextFrom(RegulatorRoleTextVerify);
			Report.LogInfo("Regulator Role Text", "Regulator Role Text not visible", "Fail");
		}
		else
		{
			Report.LogInfo("Regulator Role Text", "Regulator Role Text not visible", "pass");
							
		}				
			sleep(2000);
		verifyMustExists(Address1,"Address1 field");
		sendKeys(Address1, rd.getDataFromCell(path, "TestData",23 ,2 ), "Address1 Field.");
		verifyMustExists(City,"City field");
		sendKeys(City, rd.getDataFromCell(path, "TestData",23 ,3 ), "Address1 Field.");
		verifyMustExists(PostalCode,"Postal Code field");
		sendKeys(PostalCode, rd.getDataFromCell(path, "TestData",23 ,4), "Postal Code Field.");
		verifyMustExists(State,"State field");
		sendKeys(State, rd.getDataFromCell(path, "TestData",23 ,5), "State Field.");
		//verifyMustExists(Country_Dropdown,"Country field");
	//	click(Country_Dropdown,"Country field");
	//	sleep(2000);
	//	sendKeys(EnterOption, Country, "Country option search Field.");
		sleep(3000);
	//	click(Country_Option,"Country option");
		javaScriptWait();
	}
	public void saveAddedSubDivision() throws Exception
	{
		waitForElementToAppear(Save_Button,5);
		verifyMustExists(Save_Button,"Save Button");
		click(Save_Button,"Save Button");
		sleep(3000);
	}

	public void verifyAddedTeamsInDivision() throws Exception
	{
		ActualTeamsTitleInDivision = getTextFrom(ClssOfBsnsValue);
		 ExpectedDivisionTitle = "Aviation Products/ Airport Liabilities";

		if(ActualTeamsTitleInDivision.contains(ExpectedDivisionTitle))
		{
			Report.LogInfo("TeamsTitleInDivision", "Teams get created successfully in Division.", "PASS");
		}else{
			Report.LogInfo("TeamsTitleInDivision", "Teams Not get created successfully in Division.", "FAIL");
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		/*waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");*/
	}

	/*public void applyFilterInTeamsInDivisionName () throws InterruptedException{
		waitForElementToAppear(TeamFltrIcon,5);
		verifyMustExists(TeamFltrIcon,"Verify Filter Icon");
		click(TeamFltrIcon,"Verify Filter Icon");
		sleep(2000);
		ActualTeamsTitleInDivision = getTextFrom(ClssOfBsnsValue);
		TeamClassofBusiness=ActualTeamsTitleInDivision;
		sendKeys(TeamSearch,TeamClassofBusiness);
		verifyMustExists(SelectChkBoxInTeam,"Team checkbox");
		click(SelectChkBoxInTeam,"Team checkbox");
		verifyMustExists(FilterButton,"Team Filter link");
		click(FilterButton,"Team Filter link");
	}*/

	public void openRecordInEditModeSubDivision(){
		waitForElementToAppear(FirstRecord,5);
		verifyMustExists(FirstRecord,"Fitered Record");
		click(FirstRecord,"Fitered Record");
		verifyMustExists(KegalButtonToEdit,"Edit dots");
		click(KegalButtonToEdit,"Edit dots");
		waitForElementToAppear(EditSubDivisionLink,5);
		verifyMustExists(EditSubDivisionLink,"Edit link of Subdivision");
		click(EditSubDivisionLink,"Edit link of subdivision");
	}

	//Edit Sub-Division Fields
	public void EditSubDivisionFields(){
		waitForElementToAppear(EdSubDivisionName,5);
		clearTextBox(EdSubDivisionName);
		sendKeys(EdSubDivisionName,EditSubDivisionName,"Sub-Division Name field.");
		clearTextBox(EdSubDivisionReference);
		sendKeys(EdSubDivisionReference,SubDivisionReferenceEdit,"Sub-Division Reference field.");
		clearTextBox(EdAddress1);
		sendKeys(EdAddress1,SubDivisionAddress1,"Sub-Division Address1 field.");
		clearTextBox(EdSubDivisionCity);
		sendKeys(EdSubDivisionCity,SubDivisionCity,"Sub-Division City field.");
		clearTextBox(EdSubDivisionPostalCode);
		sendKeys(EdSubDivisionPostalCode,SubDivisionPostalCode,"Sub-Division Postal Code field.");
		clearTextBox(EdSubDivisionState);
		sendKeys(EdSubDivisionState,SubDivisionState,"Sub-Division State field.");
		clearTextBox(EdSubDivisionTelephone);
		sendKeys(EdSubDivisionTelephone,SubDivisionPHNumber,"Sub-Division Telephone field.");			
	}

	// Save and verification of edited data
	public void SaveAndVerifyEditOperationSubDivision() throws InterruptedException
	{
		
		
		verifyMustExists(SaveButton,"Save button");
		click(SaveButton,"Save button");	
		sleep(2000);		
		actualEdSubDivisionAdd1 =	getTextFrom(EdAddress11);
		actualEdSubDivisionCity =	getTextFrom(EdSubDivisionCity1);
		actualEdSubDivisionPostsalCd = getTextFrom(EdSubDivisionPostalCode1);
		actualEdSubDivisionState =	getTextFrom(EdSubDivisionState1);
	
		
		if(actualEdSubDivisionAdd1.equals(SubDivisionAddress1))
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited successfully.", "PASS");
		}else
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited not edited successfully.", "FAIL");
		}
		if(actualEdSubDivisionCity.equals(SubDivisionCity))
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited successfully.", "PASS");
		}else
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited not edited successfully.", "FAIL");
		}
		if(actualEdSubDivisionPostsalCd.equals(SubDivisionPostalCode))
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited successfully.", "PASS");
		}else
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited not edited successfully.", "FAIL");
		}
		if(actualEdSubDivisionState.equals(SubDivisionState))
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited successfully.", "PASS");
		}else
		{
			Report.LogInfo("ValidateCompanyName", "DivRef  edited not edited successfully.", "FAIL");
		}
	}

	public void openSelectedCompny() throws InterruptedException
	{
		sleep(2000);
		waitForElementToAppear(SelectedCom,5);
		verifyMustExists(SelectedCom,"Selected company"); 
		click(SelectedCom,"Selected company");
		sleep(2000);
	}

	public void navigationOnUserTab() throws InterruptedException
	{
		waitForElementToAppear(UserTab,5);
		verifyMustExists(UserTab,"User tab");
		click(UserTab,"User tab");	
		sleep(2000);
	}



	public void deactivateUser() throws InterruptedException
	{
		waitForElementToAppear(ExistingFirstUser,5);
		verifyMustExists(ExistingFirstUser,"Existing User");
		click(ExistingFirstUser,"Existing User");
		
		
		waitForElementToAppear(EditExistingUser,5);
		verifyMustExists(EditExistingUser,"Existing User");
		click(EditExistingUser,"Existing User");
		
		waitForElementToAppear(DeactivateBtn,5);
		verifyMustExists(DeactivateBtn,"DActivate button");
		click(DeactivateBtn,"DActivateUser button");
		sleep(1000);
		waitForElementToAppear(YesDActivateUserButton,5);
		verifyMustExists(YesDActivateUserButton,"Activate button");
		click(YesDActivateUserButton,"ActivateUser button");
		
		goBack();
	} 

	public void checkDeactiveStatus() throws InterruptedException
	{
		waitForElementToAppear(DeActiveStatus,5);
		 actualDeactivetxt = getTextFrom(DeActiveStatus);
		if(actualDeactivetxt.equalsIgnoreCase(expDeactive))
		{
			Report.LogInfo("StatusCheck", "User deactivated successfully or is already inactive.", "PASS");
		}
		else
		{
			Report.LogInfo("StatusCheck", "User not deactivated successfully, status not shown as inactive.", "FAIL");
		}
	}

	public void activateUser() throws InterruptedException
	{
		
		
		waitForElementToAppear(ExistingFirstUser,5);
		verifyMustExists(ExistingFirstUser,"Existing First User Click");
		click(ExistingFirstUser,"Existing First User Click");
		
		
		waitForElementToAppear(EditExistingUser,5);
		verifyMustExists(EditExistingUser,"Existing User");
		click(EditExistingUser,"Edit Existing User");
		
		waitForElementToAppear(Activatebtn,5);
		verifyMustExists(Activatebtn,"Activate button");
		click(Activatebtn,"ActivateUser button");
		
		waitForElementToAppear(YesActivateUserButton,5);
		verifyMustExists(YesActivateUserButton,"Activate button");
		click(YesActivateUserButton,"ActivateUser button");
		
		goBack();
	
	} 

	public void checkActiveStatus() throws InterruptedException
	{
		waitForElementToAppear(ActiveStatus,5);
		 actualActivetxt = getTextFrom(ActiveStatus);
		if(actualActivetxt.equalsIgnoreCase(expActive))
		{
			Report.LogInfo("StatusCheck", "User Activated successfully or is already active.", "PASS");
		}
		else
		{
			Report.LogInfo("StatusCheck", "User not activated successfully, status not shown as active.", "FAIL");
		}
	}

	public void openrecord()throws InterruptedException
	{
		sleep(3000);
		verifyMustExists(FiltedCompanyName,"Filtered Company Name");
		click(FiltedCompanyName,"Filtered Company Name");
		sleep(2000);
	}

	public void clickonUserTabAndUserButton() throws InterruptedException
	{
		waitForElementToAppear(UserTab,5);
		verifyMustExists(UserTab,"User Tab");
		sleep(1000);
		click(UserTab,"User Tab");
		sleep(2000);
		verifyMustExists(AddNewUserBtx,"User Tab");
		click(AddNewUserBtx,"User Tab");
		sleep(3000);
	}

	public void addUserDetails() throws InterruptedException
	{
		waitForElementToAppear(FirstNameTxt,5);
		verifyMustExists(FirstNameTxt,"First Name text field");
		sendKeys(FirstNameTxt,rd.getDataFromCell(path, "TestData",30,0),"First Name text field.");
		verifyMustExists(LastNameTxt,"Last Name text field");
		sendKeys(LastNameTxt,rd.getDataFromCell(path, "TestData",30,1),"Last Name text field.");
		verifyMustExists(RoleDD,"Role drop-down");
		click(RoleDD,"Role drop-down");
		click(CompanyAdminRole,"Role drop-down");
		verifyMustExists(EmailAddresstxt,"Email Address text field");
		sendKeys(EmailAddresstxt,UserEmail,"Email Address text field.");
		waitForElementToAppear(SaveBtn,5);	
		verifyMustExists(SaveBtn,"Save button");
		click(SaveBtn,"Save button");
		
		waitForElementToAppear(UsernotFoundText,5);	
		verifyMustExists(UsernotFoundText,"user not found message");
		click(UsernotFoundText,"user not found message");
		goBack();		
	}

	public void verifyAddedUserDetails() throws InterruptedException
	{
		if(isVisible(VerificationFail)==true)
		{	
			Report.LogInfo("VerificationFailed", "Verification failed message displayed.", "FAIL");
		}
		else
		{
			verifyMustExists(UserDeactivatedmsg,"User Deactivated message");
			verifyExists(EmailnotVerifiedmsg,"Email not verified message");

			 actualEmailID=getTextFrom(EmailID);
			 expectedEmailID=UserEmail;
			 
			if(actualEmailID.equalsIgnoreCase(expectedEmailID))
			{
				Report.LogInfo("ValidateEmailAddress", "Email ID added successfully.", "PASS");
			}else{
				Report.LogInfo("ValidateEmailAddress", "Email ID not added successfully.", "FAIL");
			}

			 actualPhoneNumber=getTextFrom(PhoneNumber1);
			 expectedPhoneNumber=rd.getDataFromCell(path, "TestData",33,1);	
			if(actualPhoneNumber.equalsIgnoreCase(expectedPhoneNumber))
			{
				Report.LogInfo("ValidatePhoneNumber", "Phone number added successfully.", "PASS");
			}else{
				Report.LogInfo("ValidatePhoneNumber", "Phone number not added successfully.", "FAIL");
			}

			 actualWorkPhoneNumber=getTextFrom(WorkPhoneNumber);
			 expectedWorkPhoneNumber=rd.getDataFromCell(path, "TestData",33,2);	
			if(actualWorkPhoneNumber.equalsIgnoreCase(expectedWorkPhoneNumber))
			{
				Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number added successfully.", "PASS");
			}else{
				Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number not added successfully.", "FAIL");
			}
			sleep(2000);

		}
	}

	public void verifyAddedUserDetails1() throws InterruptedException
	{		CompanyPermissionPage CPP = new CompanyPermissionPage();
	if(isVisible(VerificationFail)==true)
	{	
		Report.LogInfo("VerificationFailed", "Verification failed message displayed.", "FAIL");
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		if(isVisible(CPP.BackCom)==true){
			waitForElementToAppear(CPP.BackCom,5);
			verifyMustExists(CPP.BackCom,"Back To Company Button");
			javaScriptclick(CPP.BackCom,"Back To Company Button");
		}else{
			refreshPage();
			sleep(2000);
			goBack();
		}
	}
	else
	{
		verifyMustExists(UserDeactivatedmsg,"User Deactivated message");
		verifyExists(EmailnotVerifiedmsg,"Email not verified message");

		String actualEmailID=getTextFrom(EmailID);
		String expectedEmailID=UserEmail;	
		if(actualEmailID.equalsIgnoreCase(expectedEmailID))
		{
			Report.LogInfo("ValidateEmailAddress", "Email ID added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateEmailAddress", "Email ID not added successfully.", "FAIL");
		}

		String actualPhoneNumber=getTextFrom(PhoneNumber1);
		String expectedPhoneNumber=rd.getDataFromCell(path, "TestData",33,1);	
		if(actualPhoneNumber.equalsIgnoreCase(expectedPhoneNumber))
		{
			Report.LogInfo("ValidatePhoneNumber", "Phone number added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidatePhoneNumber", "Phone number not added successfully.", "FAIL");
		}

		String actualWorkPhoneNumber=getTextFrom(WorkPhoneNumber);
		String expectedWorkPhoneNumber=rd.getDataFromCell(path, "TestData",33,2);	
		if(actualWorkPhoneNumber.equalsIgnoreCase(expectedWorkPhoneNumber))
		{
			Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number added successfully.", "PASS");
		}else{
			Report.LogInfo("ValidateWorkPhoneNumber", "Work Phone Number not added successfully.", "FAIL");
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		if(isVisible(CPP.BackCom)==true){
			waitForElementToAppear(CPP.BackCom,5);
			verifyMustExists(CPP.BackCom,"Back To Company Button");
			javaScriptclick(CPP.BackCom,"Back To Company Button");
		}else{
			refreshPage();
			sleep(2000);
			goBack();			
		}			
	}
	}

	public void openSelectedUserInEditMode(){
		waitForElementToAppear(EditSelectedUserLink,5);
		click(EditSelectedUserLink,"Edit Selected User Link");
		verifyMustExists(EditLink,"Edit User");
		click(EditLink,"Edit User");
		sleep(2000);
	}

	public void EditMainDetailsUser(){
		waitForElementToAppear(UserFirstName,5);
		verifyMustExists(UserFirstName,"User First Name");
		clearTextBox(UserFirstName);
		sendKeys(UserFirstName,UpdateUserName,"User First Name field.");
		verifyMustExists(UserLastName,"User Last Name");
		clearTextBox(UserLastName);
		sendKeys(UserLastName,UpdateUserLastName,"User Last Name field.");
	}

	public void EditContactInformationUser(){
		waitForElementToAppear(UserMobilePhoneNumber,5);
		verifyMustExists(UserMobilePhoneNumber,"User Mobile Phone Number");
		clearTextBox(UserMobilePhoneNumber);
		sendKeys(UserMobilePhoneNumber,UpdateMobilePhone,"User Mobile Phone Number field.");
		verifyMustExists(UserWorkPhone,"User Work Phone");
		clearTextBox(UserWorkPhone);
		sendKeys(UserWorkPhone,UpdateWorkPhone, "User Work Phone Number field.");
	}

	public void saveAndVerification(){

		waitForElementToAppear(SaveButtonUser,5);
		verifyMustExists(SaveButtonUser,"User Save Button");
		click(SaveButtonUser,"User Save Button");

		javaScriptWait();
		waitToPageLoad();
		sleep(6000);
		waitForElementToAppear(EditedWorkPhoneNumber,5);

		 ActualFullName = getTextFrom(EditedFullName);
		 ActualMPhoneNumber = getTextFrom(EditedPhoneNumber);
		 ActualWorkPnone = getTextFrom(EditedWorkPhoneNumber);

		if(ActualFullName.equalsIgnoreCase(ExpectedFullName)){

			Report.LogInfo("ValidateEdit", "Full Name updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Full Name not updated successfully.", "FAIL");
		}

		if(ActualMPhoneNumber.equalsIgnoreCase(ExpectedPhoneNumber)){

			Report.LogInfo("ValidateEdit", "Phone Number updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Phone Number not updated successfully.", "FAIL");
		}

		if(ActualWorkPnone.equalsIgnoreCase(ExpectedWorkPnone)){

			Report.LogInfo("ValidateEdit", "Work Phone Number updated successfully.", "PASS");

		}else{

			Report.LogInfo("ValidateEdit", "Work Phone Number not updated successfully.", "FAIL");
		}

		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
	}

	public void  applyFilterByUserName(String firstName)
	{

		int j=0;

		verifyMustExists(UserTab,"User Tab");
		click(UserTab,"User Tab");

		javaScriptWait();
		verifyMustExists(EmailFiltericon,"Email Filter icon");

		do
		{
			if(j>0)
			{
				refreshPage();
				javaScriptWait();
			}
			click(EmailFiltericon,"Email Filter icon");
			sleep(2000);
			if(isVisible(EmailFiltersearchtxt))
			{
				verifyMustExists(EmailFiltersearchtxt,"Email search text field");
				sendKeys(EmailFiltersearchtxt,rd.getDataFromCell(path, "TestData",33,0),"Email search text field.");
				sleep(2000);
			}
			j++;
		}while(!isVisible(checkEmailID) && j<5);

		click(checkEmailID,"Email ID check box");
		verifyMustExists(FilterBtn,"Filter button");
		click(FilterBtn,"Filter button");
		verifyMustExists(selectuser,"User First Name");
		click(selectuser,"User First Name");
	}


	/**************Add User to Division*********************/
	public void selectAddedDivision()
	{
		waitForElementToAppear(SelectDivision,5);
		verifyMustExists(SelectDivision,"Division exists");
		click(SelectDivision,"Select Division");
	}

	public void selectUsersTab()
	{
		waitForElementToAppear(UsersTab,5);
		verifyMustExists(UsersTab,"Users Tab");
		click(UsersTab,"Users Tab");
	}

	public void createNewUserUnderDivision()
	{
		waitForElementToAppear(AddNewUserButton,5);
		verifyMustExists(AddNewUserButton,"Add New User button");
		click(AddNewUserButton,"Add New User button");
		waitForElementToAppear(AddUsersPopUp,5);
		verifyOptionalExists(AddUsersPopUp,"Add Users pop up");
		sleep(2000);
		if(isVisible(NoDataFoundValue) == true)
		{
			Report.LogInfo("NoUserFound", "No users added for company", "FAIL");
			verifyMustExists(CancelButton,"Cancel button");
			click(CancelButton,"Cancel button");
		}
		else
		{
			Report.LogInfo("NoUserFound", "No users added for company", "PASS");	
			Ppage.SelectDropDownValue(AddUsersDropdown, SelectUserValue);
			verifyMustExists(AddUserButton,"Add User button");
			click(AddUserButton,"Add User button");
			verifyOptionalExists(AddedUserToDivision,"Added User");
			UserAddedToDivision = getTextFrom(AddedUserToDivision);
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		waitForElementToAppear(BacktoCompanybtn,5);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
	}
	
	public void createNewUserUnderDivisionPermission()
	{
		waitForElementToAppear(AddNewUserButton,5);
		verifyMustExists(AddNewUserButton,"Add New User button");
		click(AddNewUserButton,"Add New User button");
		waitForElementToAppear(AddUsersPopUp,5);
		verifyOptionalExists(AddUsersPopUp,"Add Users pop up");
		verifyMustExists(AddUsersDropdown,"Add Users dropdown");
		click(AddUsersDropdown,"Add Users dropdown");
		sleep(2000);
		if(isVisible(NoDataFoundValue) == true)
		{
			Report.LogInfo("NoUserFound", "No users added for company", "FAIL");
			verifyMustExists(CancelButton,"Cancel button");
			click(CancelButton,"Cancel button");
		}
		else
		{
			verifyMustExists(SelectUserValue,"Users");
			click(SelectUserValue,"Users");
			verifyMustExists(AddUserButton,"Add User button");
			click(AddUserButton,"Add User button");
			//verifyOptionalExists(AddedUserToDivision,"Added User");
		}
		sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("scroll(0, -250);");
		/*waitForElementToAppear(BacktoCompanybtn,30);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");*/
	}
	
	public void BackToComBtn()
	{
		if(isVisible(BacktoCompanybtn)==true){
		waitForElementToAppear(BacktoCompanybtn,3);
		verifyMustExists(BacktoCompanybtn,"Back to company button");
		click(BacktoCompanybtn,"Back to company button");
		}
	}
	public void VerifyEditBtnHidden()
	{
		if(isVisible(EditDots) == true)
		{
			Report.LogInfo("NoUserFound", "Edit User not hidden", "FAIL");
		}
		else
		{
			Report.LogInfo("NoUserFound", "Edit User is hidden", "PASS");
		}
	}
	public void applyContractAdministratorFilter(String ContractName){
		int i=0;
		String RecordCheckbox ="@xpath=//li//span[contains(text(),'"+ContractName+"')]";
		//sleep(3000);
		javaScriptWait();

		do
		{
			if(i>0)
			{
				refreshPage();
				javaScriptWait();
			}
			verifyExists(ContractNameFilter, "Contract Name Filter");
			click(ContractNameFilter, "Contract Name Filter");
			sleep(2000);
			if(isVisible(SearchFilterTxt))
			{
				verifyMustExists(SearchFilterTxt,"Search Filter Textbox");	
				sendKeys(SearchFilterTxt,ContractName,"Search Filter Textbox.");
				sleep(2000);
			}
			i++;
		}while(!isVisible(RecordCheckbox) && i<5);

		click(RecordCheckbox, "Searched Record Checkbox");
		verifyMustExists(FilterBtn,"Filter Button");	
		click(FilterBtn,"Filter Button");
	}

	public void openContractAdministrator() throws InterruptedException
	{	
		sleep(3000);
		waitForElementToAppear(SystenicsCompanyName,5);
		verifyMustExists(SystenicsCompanyName,"Filtered record");
		click(SystenicsCompanyName,"Filtered record");
		//sleep(2000);
		waitForElementToAppear(EditKebabIcon,5);
		verifyMustExists(EditKebabIcon,"Edit dots");
		click(EditKebabIcon,"Edit dots");
		verifyMustExists(EditoptionLink,"Edit link");
		click(EditoptionLink,"Edit link");
	}
	public void openExistingUserFromDivision()
	{
		if(isVisible(ExistingUser)==true){
			waitForElementToAppear(ExistingUser,3);
			verifyMustExists(ExistingUser,"Existing User record");
			click(ExistingUser,"Existing User record");			
		}else{
			Report.LogInfo("RecordCheck", "Existing User not available.", "FAIL");
		}
	}
	public void selectExistingSubDivision()
	{
		waitForElementToAppear(ExistingUserFromDivision,5);
		verifyMustExists(ExistingUserFromDivision,"Sub Division exists");
		click(ExistingUserFromDivision,"Select Sub Division");
	}

	public void TeamsDetailsInDivision()throws Exception
	{
		if(isVisible(TeamsInDivision)==true)
		{
			verifyExists(TeamsInDivision,"Teams Text");
			TeamsIndivisionVerify =  getTextFrom(TeamsInDivision);
			Report.LogInfo("Teams Text in Division", "Teams Text visible", "Pass");
			javaScriptclick(TeamsInDivision,"Click on Teams");
			sleep(1000);
			verifyMustExists(AddNewTeamBtn,"Verify Add New Team Button");
			javaScriptclick(AddNewTeamBtn,"Click on Add New Team Button");
			sleep(1000);
			waitForElementToAppear(AddTeamPopUpMssg, 5);
			verifyMustExists(TeamName,"Verify Team Name Field");
			sendKeys(TeamName, TeamsName,"Teams Name field.");
			sleep(1000);
			verifyMustExists(ClassofBusnessinTeams,"class of Business Drop Down");
			javaScriptclick(ClassofBusnessinTeams,"Click class of Business Drop Down");
			sleep(1000);
			javaScriptclick(ClssOfBsnsValue,"Class of Business Value");
			sleep(2500);
			javaScriptclick(AddTeamBtnToSave,"Click Add Team Button to Save Details");
			sleep(1500);
			//verifyAddedTeamsInDivision();
		//waitForElementToAppear(VerifyAddedTeam, 5);
			sleep(1000);
			
		}
		else
		{
			Report.LogInfo("Teams Text", "Teams Text not visible", "Fail");
							
		}
		}
	public void MainDetailsAddDivisionforTeams() throws Exception
	{	
		NavigateToDivision();
		sleep(2000);
		verifyMustExists(Add_new_Division_Button,"Add New Division Button");
		javaScriptclick(Add_new_Division_Button,"Add New Division Button");
		sleep(3000);
		verifyMustExists(Division_Name,"Division Name field");
		sendKeys(Division_Name,DivisionNameforTeam, "Division Name field.");
		verifyMustExists(Division_Reference,"Division Reference field");
		sendKeys(Division_Reference,DivisionRefforTeam,"Division Reference field.");
		sleep(2000);
		Ppage.SelectDropDownValue(Division_Type, Division_Insure);
		sleep(2000);
		//SelectDropDownValue(Regulator_Role, RegulatorRole_Value);
		verifyMustExists(Regulator_Role,"Click Regulator Role Vlue");
		click(Regulator_Role,"Click Regulator Role Vlue");
		verifyMustExists(RegulatorRole_Value,"Click Regulator Role Vlue");
		click(RegulatorRole_Value,"Click Regulator Role Vlue");
		sleep(1000);
		saveAddedDivision();
	}
	public void MainDetailsAddDivisionforAddUserInTeams() throws Exception{	
	NavigateToDivision();
	sleep(2000);
	verifyMustExists(Add_new_Division_Button,"Add New Division Button");
	javaScriptclick(Add_new_Division_Button,"Add New Division Button");
	sleep(3000);
	verifyMustExists(Division_Name,"Division Name field");
	sendKeys(Division_Name,DivisionNameForUserInTeam, "Division Name field.");
	verifyMustExists(Division_Reference,"Division Reference field");
	sendKeys(Division_Reference,DivisionRefForUserInTeam,"Division Reference field.");
	sleep(2000);
	Ppage.SelectDropDownValue(Division_Type, Division_Insure);
	sleep(2000);
	verifyMustExists(Regulator_Role,"Click Regulator Role Vlue");//SelectDropDownValue(Regulator_Role, RegulatorRole_Value);
	click(Regulator_Role,"Click Regulator Role Vlue");
	verifyMustExists(RegulatorRole_Value,"Click Regulator Role Vlue");
	click(RegulatorRole_Value,"Click Regulator Role Vlue");
	sleep(1000);
	saveAddedDivision();
}
	public void VerifyAllCompanyTab()
	{
		waitForElementToAppear(VerifyAboutTab,5);
		verifyMustExists(VerifyAboutTab,"Verify Company About Tab");
		Report.LogInfo("Verify Company About Tab", "Verified Company About Tab", "PASS");
		sleep(1000);
		verifyMustExists(VerifyDivisionTab,"Verify Division Tab");
		Report.LogInfo("Verify Company Division Tab", "Verified Company Division Tab", "PASS");
		sleep(1000);
		verifyMustExists(VerifyUserTabIncompany,"Verify User Tab in Company");
		Report.LogInfo("Verify Company User Tab", "Verified Company User Tab", "PASS");
		sleep(1000);
		verifyMustExists(VerifyConfigurationTabInCompany,"Verify Configuration Tab in Company");
		Report.LogInfo("Verify Company Configuration Tab", "Verified Company Configuration Tab", "PASS");
		sleep(1000);
		verifyMustExists(VerifyAdminTabInCompany,"Verify Admin Tab in Company");
		Report.LogInfo("Verify Company Admin Tab", "Verified Company Admin Tab", "PASS");
		}
	public void VerifyTeamsUserInCompanyUser() throws Exception{	
		waitForElementToAppear(VerifyUserTabIncompany,5);
		verifyMustExists(VerifyUserTabIncompany,"User Tab");
		click(VerifyUserTabIncompany,"User Tab");
		sleep(2000);
		verifyMustExists(VerifyFrstNameInCompanyUser, "Verify Comapny Users First Name");
		sleep(1000);
		verifyMustExists(VerifyRoleClmInUser, "Verify Role Column in User Tab");
		RoleInUserTab =  getTextFrom(VerifyRoleClmInUser);
		Report.LogInfo("RoleColumnInUserTab", VerifyRoleClmInUser, "Pass");
		sleep(1000);
	}
	public void EditandRemoveUserFromTeam() throws Exception{
		NavigateToDivision();
		sleep(1000);
		javaScriptclick(ExistingDivisionName);
		sleep(1000);
		verifyMustExists(TeamsInDivision,"Verify Team Text");
		javaScriptclick(TeamsInDivision,"Click on Teams Tab");
		sleep(1000);
		verifyMustExists(ClsofBusnsClck,"Verify Class of Business Name");
		javaScriptclick(ClsofBusnsClck,"Click Class of Business");
		sleep(1000);
		javaScriptclick(UserTabInTeam, "Click User Tab in Teams");
		sleep(1000);
		verifyMustExists(VerifyTeamsUserEditBtn, "Verify Edit User Button in Team");
		javaScriptclick(VerifyTeamsUserEditBtn);
		sleep(1000);
		verifyMustExists(VerifyEditUserPopUp, "Verify Edit user Popup message");
		TeamsUserEditPopUp =  getTextFrom(VerifyEditUserPopUp);
		Report.LogInfo("Edit button in Teams User Tab", VerifyEditUserPopUp, "Pass");
		sleep(1000);
		verifyMustExists(VerifyAddedUserWhileEditing, "Verify User Name");
		sleep(1000);
		SelectDropDownValue(SelectRoleDDInTeam,SelectReadOnlyRoleVlueInTeam);
		waitForElementToAppear(TeamsUsereditSaveBtn, 5);
		click(TeamsUsereditSaveBtn, "Click Save button to save edited changes");
		sleep(1000);
		verifyMustExists(VerifyRoleOfUserInTeam, "Verify Read Only Role in Teams User tab");
		TeamsEditedUserRole =  getTextFrom(VerifyRoleOfUserInTeam);
		Report.LogInfo("User Tab  Division", VerifyRoleOfUserInTeam, "Pass");
		sleep(1000);
		verifyMustExists(VerifyTeamsUsersRemoveBtn, "Verif Remove Button in Team");
		javaScriptclick(VerifyTeamsUsersRemoveBtn,"Click Remove Button");
		sleep(1000);
		waitForElementToAppear(RemoveUserPopupMessage, 5);
		verifyMustExists(RemoveUserPopupMessage, "Verify Remove User Pop Up Message");
		RemovePopupMessage =  getTextFrom(RemoveUserPopupMessage);
		Report.LogInfo("Remove Pop up Message in Teams User Tab", RemoveUserPopupMessage, "Pass");
		sleep(1000);
		verifyMustExists(RemoveBtnOnRemovePopUp, "Verify Remove Button on Remove Error Pop up");
		click(RemoveBtnOnRemovePopUp,"Click Remove Button");
		sleep(1000);
		verifyMustExists(BackToDivisionBtn,"Verify Back to Division Button");
		click(BackToDivisionBtn,"Click Back to Divison Button");
		sleep(1000);
		verifyMustExists(BckToCompnyBtn,"Verify Back to Company Button");
		click(BckToCompnyBtn,"Click Back to Company Button");
		sleep(1000);
		waitForElementToAppear(VerifyUserTabIncompany,5);
		verifyMustExists(VerifyUserTabIncompany,"User Tab");
		click(VerifyUserTabIncompany,"User Tab");
		sleep(2000);
		verifyMustExists(VerifyFrstNameInCompanyUser, "Verify Comapny Users First Name");
		sleep(1000);
		
			}
}