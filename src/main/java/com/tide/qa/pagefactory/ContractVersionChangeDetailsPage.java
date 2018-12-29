package com.tide.qa.pagefactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class ContractVersionChangeDetailsPage extends PageBase{
	
	LoginPage loginPage = new LoginPage();
	BordereauQuePage BQPage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	DatasetReferenceDataPage datasetPage = new DatasetReferenceDataPage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	
	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	
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

	
	// ============================Locators===========================================//
	
	//Check version status is set to singed
		public static final String VersionTab ="@xpath=//*[@id='content']//li//a[contains(.,'Versions')]";
		public static final String VerifySignedVerion ="@xpath=//*[@id='grid']//table//td//span[contains(.,'Signed')]";

		//Contract Role Edit_TC
		public static final String Roletab="@xpath=//a[text()='Roles']";
		public static final String CompanyRole ="@xpath=//div[@class='table-responsive ng-scope']//tr[1]/td[3]";
		public static final String ContractAdministratorPopup ="@xpath=//h2[contains(.,'Contract Contract Administrator')]";
		public static final String CompanyAdministratoropdwn ="@xpath=//*[@ng-model='form.dataId']//preceding-sibling::span[1]";
		public static final String CompanyAdministratoroddvalue ="@xpath=//ul/li[@role='option'][1]";
		public static final String SaveCompany ="@xpath=//*[@ng-click='save()']";
		public static final String SignedContractChange ="@xpath=//*[@class='table table-hover table-vmiddle']//tr[1]//td[3]";
		public static final String SaveCompanyContract ="@xpath=//*[@class='btn btn-primary p-lr-lg save ng-scope']";
	
		public static final String VerifyVersion ="@xpath=//*[@class='k-selectable']//tr[1]//td[1][contains(.,'1')]";
		public static final String VerifyVersion2 ="@xpath=//*[@class='k-selectable']//tr[1]//td[1][contains(.,'2')]";
		public static final String VerifyVersion1 ="@xpath=//*[@class='k-selectable']//tr[1]//td[1][contains(.,'1')]";
		public static final String EffectiveDate ="@xpath=//th[contains(.,'Effective Date')]";
		public static final String VerifyVersion3 ="@xpath=//*[@class='k-selectable']//tr[1]//td[1][contains(.,'3')]";
		public static final String VerifyVersion4 ="@xpath=//*[@class='k-selectable']//tr[1]//td[1][contains(.,'4')]";
		public static final String VerifyVersion5 ="@xpath=//*[@class='k-selectable']//tr[1]//td[1][contains(.,'5')]";
		public static final String VerifyChangeType ="@xpath=//*[@class='k-selectable']//tr[1]//td[2][contains(.,'Settings')]";
		public static final String VerifyChangeTypeContract ="@xpath=//*[@class='k-selectable']//tr[1]//td[2][contains(.,'Contract')]";
		public static final String VerifyChangeType_ ="@xpath=//*[@class='k-selectable']//tr[1]//td[2][contains(.,'-')]";
		public static final String VerifyAddedNote ="@xpath=//*[@class='k-selectable']//tr[1]//td[9][contains(.,'-')]";
		public static final String VerifyAddedNote1 ="@xpath=//*[@class='k-selectable']//tr[1]//td[9][contains(.,'Test')]";
		
		public static final String VerifyVersionChanges ="@xpath=//*[@class='k-selectable']//tr[1]//td[contains(.,'Reporting Channel Added')]";
		public static final String VerifyVersionChanges1 ="@xpath=//*[@class='k-selectable']//tr[1]//td[contains(.,'Reporting Channel Edited: Reporting Channel Identifier')]";
		public static final String VerifyVersionChanges2 ="@xpath=//*[@class='k-selectable']//tr[1]//td[contains(.,'Reporting Channel Deleted')]";
		public static final String VerifyVersionChangesMarketAdded ="@xpath=//*[@class='k-selectable']//tr[1]//td[8][contains(.,'Market')]";
		public static final String VerifyVersionNO ="@xpath=//*[@class='k-selectable']//tr[1]//td[8][contains(.,'No Change')]";		
		public static final String Corrections ="@xpath=//*[@class='k-selectable']//tr[1]//td[3][contains(.,'-')]";
		public static final String CorrectionsYES ="@xpath=//*[@class='k-selectable']//tr[1]//td[3][contains(.,'Yes')]";
		public static final String CorrectionsNo ="@xpath=//*[@class='k-selectable']//tr[1]//td[3][contains(.,'No')]";
		public static final String verifyStatus = "@xpath=//*[@class='k-selectable']//tr[1]//td[4][contains(.,'Signed')]";
		public static final String verifyStatus2 = "@xpath=//*[@class='k-selectable']//tr[1]//td[4][contains(.,'Draft Endorsement')]";
		public static final String verifyCorrection = "@xpath=//*[@class='k-selectable']//tr[1]//td[3]";
		public static final String DraftEndorsement ="@xpath=//*[@id='profile-main']//dl//dd//button[contains(.,'Draft Endorsement')]";
		public static final String VerifyVersionChangesRiskCodeAdded ="@xpath=//*[@class='k-selectable']//tr[1]//td[contains(.,'Risk Code Added')]";
		
		public static final String AddClaimAutho1 ="@xpath=//*[@class='k-selectable']//tr[1]//td[contains(.,'Claims Authority Added: Claim Authority')]";
		public static final String DeleteClaimAutho ="@xpath=//*[@class='k-selectable']//tr[1]//td[contains(.,'Claims Authority Deleted')]";
		public static final String ReportingPremium ="@xpath=//*[@class='k-selectable']//tr[1]//td[contains(.,'Reporting Channel Added')]";
		
		public static final String EditContractDetails ="@xpath=//*[@class='actions ng-scope']";
		public static final String EditDetails ="@xpath=//*[text()='Edit']";
		public static final String SaveEditedChanges ="@xpath=//*[@ng-click='edit()']";
		public static final String CancelBtn ="@xpath=//form[@name='form.SignedContractChanged']//div//div[6]//button[1]";
		
		
		public static final String editMarket ="@xpath=//tr[2][@ng-click='details(data)']//td[2]";
		public static final String editMarket1 ="@xpath=//tr[1][@ng-click='details(data)']//td[2]";
		public static final String VerifyeditMarket ="@xpath=//h2[text()='Edit Market']";
		public static final String DeleteMarket ="@xpath=//*[@ng-click='callDeleteMarket(data)']";
		public static final String ConfirmDeleteMarket ="@xpath=//*[@ng-click='deleteMarket()']";
		
		public static final String Broker ="@xpath=//*[@ng-model='data.BrokerDivisionId']//preceding-sibling::span[1]";
		public static final String BrokerValue ="@xpath=//ul/li[contains(.,'Alwen Hough Johnson Ltd - TBC')]";
		public static final String BrokerContact ="@xpath=//*[@ng-model='data.BrokerContactId']//preceding-sibling::span[1]";
		public static final String BrokerContactValue ="@xpath=//ul/li[contains(.,'AON Standard')]";
		public static final String UnderwriterDrpDown = "@xpath=//*[@ng-model='data.Underwriter']//preceding-sibling::span[1]";
		public static final String UnderwriterDrpDownValue = "@xpath=//div[@class='k-animation-container']//ul[@aria-hidden='false']//li[1]";
		public static final String UnderwriterDrpDownValue2 = "@xpath=//div[@class='k-animation-container']//ul[@aria-hidden='false']//li[2]";

		public static final String EditCoverholderContactdropdwn ="@xpath=//*[@ng-model='data.CoverholderContactId']//preceding-sibling::span[1]";
		public static final String EditCoverholderContactdropdwnValue ="@xpath=//ul/li[contains(.,'-- Select --')]";
		public static final String ThirdSectionPopUp ="@xpath=//h2[contains(.,'Contract Settings Update')]";
		public static final String SaveBtn1 ="@xpath=//div[contains(.,'Cancel')]/following-sibling::button[contains(text(),'Save')]";
		
		public static final String ContractCurrencyDrpDown = "@xpath=//*[@id='profile-main']//*[@k-data-source='currencyList']//preceding-sibling::span[1]";
		public static final String ContractCurrencyDrpDownValue = "@xpath=//ul[@class='k-list k-reset']//*[contains(.,'CAD - Canadian Dollar')]";
		public static final String ContractCurrencyDrpDownValue1 = "@xpath=//ul[@class='k-list k-reset']//*[contains(.,'GBP - British Pound')]";
		public static final String BrokerValue2 ="@xpath=//ul/li[contains(.,'AON - DUA team')]";
		
		public static final String EditClaimsAuthority ="@xpath=//*[@class='table table-hover table-vmiddle']//tr[1]//td[2]";
		public static final String EditClaimsAuthoritytab ="@xpath=//h2[contains(.,'Edit Claims Authority')]";
		public static final String DeleteClaimsAuthority ="@xpath=//button[@ng-click='callDeleteClaimsAuthority(data)']";
		public static final String DeleteIt ="@xpath=//*[@ng-click='deleteClaimsAuthority()']";
		
		
        public String ActualVersion;
        public String ActualChangeType;
        public String ActualCorrections;
        public String Version3;
        public String Version2;
        public String Status2;
        public String Status3;
        public String ActualVersionChanges;
        
		public void VersionChanges_Settings_TC4402() throws Exception

		{
	    policy.CreateContractwithInceptionDate2018();

		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelClaim1();
		sleep(2000);
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(3000);
		verifyMustExists(VerifyVersion,"Verify Version is 1");
		verifyMustExists(VerifyChangeType,"Verify ChangeType is Setting");
		verifyMustExists(Corrections,"- Displayed");
		verifyMustExists(VerifyVersionChanges,"Verify Add reporting Version Changes Displayed");
		verifyMustExists(VerifyAddedNote1,"Test note is added");
		
		ActualVersion = getTextFrom(VerifyVersion,"Signed Verion");
		ActualChangeType = getTextFrom(VerifyChangeType,"Signed Verion");
	    ActualCorrections = getTextFrom(Corrections,"Correction ");
	    ActualVersionChanges = getTextFrom(VerifyVersionChanges,"Version Changes");
	    
	    // Edit reporting channel
		policy.navigateToReportingChannelsTab();
		policy.editReportingChannelOfContractForPer();
		
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(3000);
		verifyMustExists(VerifyVersion,"Verify Version is 1");
		verifyMustExists(VerifyChangeType,"Verify ChangeType is Setting");
		verifyMustExists(Corrections,"- Displayed");
		verifyMustExists(VerifyVersionChanges1,"Verify Edit Reporting cahnnel  Version Changes Displayed");
		
		//Delete Reporting Channel
		policy.navigateToReportingChannelsTab();
		policy.deleteReportingChannelOfContract();
		
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(2000);
		verifyMustExists(VerifyVersion,"Verify Version is 1");
		verifyMustExists(VerifyChangeType,"Verify ChangeType is Setting");
		verifyMustExists(Corrections,"- Displayed");
		verifyMustExists(VerifyVersionChanges2,"Verify Delete Reporting cahnnel  Version Changes Displayed");
		
	}
	public void VersionChanges_Contract_TC4406() throws Exception
	{
		String ref = "BB";
		String BrockrageVal = "5";
		String ClassBval = "Property D&F (non-US binder)";
		String currencyVal = "USD - United States Dollar";
		String EPermiumIncome1 = "5";
		String GPermiumIncome1 = "3";
		String GPermiumLimit1 = "2";
		String ConductRiskRatingValue1 = "Low";

		
		policy.CreateContractwithInceptionDate2018();
		
		policy.navigateToSectionTab();
		policy.addSection2(ref, BrockrageVal, ClassBval, currencyVal, EPermiumIncome1, GPermiumIncome1, GPermiumLimit1, ConductRiskRatingValue1);
		String RiskCode1 = "1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY";
		String per1 = "40";
		
		//Step 1
		policy.navigateToRiskCodesTabOnSection();
		policy.addRiskCodesOnSection(RiskCode1,per1);
		policy.navigateToMarketsTabOnSection();
		policy.addMarketOnSection1();
		sleep(2000);
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(2000);
		verifyMustExists(EffectiveDate,"Effective date column exists");
		
		verifyMustExists(CorrectionsNo,"- Displayed");
		verifyMustExists(VerifyVersion2,"Verify Version No. is 2 Changed");
		Version2 = getTextFrom(VerifyVersion2,"Verify Version No. is 2 Changed");
		verifyMustExists(verifyStatus2,"Status changed as'Draft Endorsement'");
		Status2 = getTextFrom(verifyStatus2,"Status changed as'Draft Endorsement'");
		verifyMustExists(VerifyVersionChangesMarketAdded,"Verify Version Changes Tab");
		String Status="Draft Endorsement";
		String getstatus = getTextFrom(verifyStatus2);
		if(getstatus.equals(Status)){
		Report.LogInfo("ValidateStatus", "Status is'Draft Endorsement'", "Pass");
		}
		else{
			Report.LogInfo("ValidateStatus", "Status is not 'Draft Endorsement'", "Fail");
		}
		Report.LogInfo("StepCheck", "Steps 1 completed", "PASS");
		
		//Step 2
		policy.navigateContarctDetailsTab();
		sleep(1000);
		verifyMustExists(DraftEndorsement,"Draft Endorsement");
		sleep(1000);
		click(DraftEndorsement,"Draft Endorsement");
		sleep(1000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			javaScriptclick(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(2000);
		
		verifyMustExists(VerifyVersion2,"Verify Version No. is 2 Changed");
		verifyMustExists(VerifyChangeType_,"Verify ChangeType is -");	
		verifyMustExists(Corrections,"Corrections - displayed");
		verifyMustExists(VerifyVersionNO,"Verify Version No Changes Tab");
		String SignStatus="Signed";
		String getSignstatus = getTextFrom(verifyStatus);
		if(getSignstatus.equals(SignStatus)){
		Report.LogInfo("ValidateStatus", "Status is'Signed'", "Pass");
		}
		else{
			Report.LogInfo("ValidateStatus", "Status is not 'Signed'", "Fail");
		}
		Report.LogInfo("StepCheck", "Steps 2 completed", "PASS");
		
		//step 3
		policy.navigateToSectionTab();
		policy.navigateToMarketsTabOnSection();
		sleep(2000);
		
		verifyMustExists(editMarket1,"Edit Market");
		click(editMarket1,"Edit Market");
		policy.editMarketPopup();
		sleep(2000);
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		click(VersionTab,"Version Tab");
		sleep(2000);
		
		verifyMustExists(VerifyVersion3,"Verify Version is 3");
		Version3 = getTextFrom(VerifyVersion3,"Verify Version is 3");
		verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
		verifyMustExists(verifyStatus,"verify Status is signed");
		Status3 = getTextFrom(verifyStatus,"verify Status is signed");
		verifyMustExists(VerifyAddedNote1,"New note is added");
		verifyMustExists(CorrectionsYES,"Yes displayed");
		String SignStatus1="Signed";
		String getSignstatus1 = getTextFrom(verifyStatus);
		if(getSignstatus1.equals(SignStatus1)){
		Report.LogInfo("ValidateStatus", "Status is'Signed'", "Pass");
		}
		else{
			Report.LogInfo("ValidateStatus", "Status is not 'Signed'", "Fail");
		}
		Report.LogInfo("StepCheck", "Steps 3 completed", "PASS");
		
		//Step 4
		
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelClaim1();
		sleep(2000);
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(3000);
		verifyMustExists(VerifyVersion3,"Verify Version is 3");
		verifyMustExists(VerifyChangeType,"Verify ChangeType is Setting");
		verifyMustExists(Corrections,"- Displayed");
		verifyMustExists(VerifyVersionChanges,"Verify Add reporting Version Changes Displayed");
		verifyMustExists(VerifyAddedNote1,"Test note is added");
		
		Report.LogInfo("StepCheck", "Steps 4 completed", "PASS");
		
	    //Step 4
	    
	    
		policy.navigateToSectionTab();
		//policy.navigateToMarketsTabOnSection();
		policy.navigateToRiskCodesTabOnSection();
		policy.addRiskCodesOnSection();
		
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(3000);
		verifyMustExists(VerifyVersion4,"Verify Version is 4");
		verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
		verifyMustExists(CorrectionsNo,"Correction Status is 'No'");
		verifyMustExists(verifyStatus,"verify Status");
		verifyMustExists(VerifyVersionChangesRiskCodeAdded,"verify Status");
		//verifyMustExists(VerifyAddedNote1,"Verify Added Note is 'Test3'");
		
		

	


		
	}
	
	public void Version_Changes_ContractAndSettings_TC4414() throws Exception
	{
		String IncDate = "01/01/2017";
		String ExpDate = "31/12/2017";
		policy.addPolicy3(IncDate,ExpDate);
		verifyExists(BordereauPage.DraftBtn,"Draft Status Button");
		//policy.changeStatusToQuote();
		//policy.changeStatusToWritten();
		policy.changeStatusToSigned();
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		//BordereauPage.applyFilterPolicy("149850PC");
		BordereauPage.openSelectedPolicy();
		sleep(2000);
		EditContract();
		SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue);
		sleep(1000);
		SelectDropDownValue(Broker,BrokerValue);
		sleep(1000);
		//SelectDropDownValue(BrokerContact,BrokerContactValue);
		SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue);
		sleep(1000);
		SelectDropDownValue(policy.TechnicianDrpDown,policy.TechnicianDrpDownValue);
		verifyMustExists(SaveEditedChanges,"Save Edited Changes");
		click(SaveEditedChanges,"Save Edited Changes");
		sleep(2000);
		waitForElementToAppear(policy.SecondDraftEndoresmentPopUp,5);
		verifyMustExists(CancelBtn,"Cancel Button");
		click(CancelBtn,"Cancel Button");
		sleep(2000);
		verifyMustExists(SaveEditedChanges,"Save Edited Changes");
		click(SaveEditedChanges,"Save Edited Changes");
		if(isVisible(policy.secondContractEndorsementPopUp) == true)
		{
			sleep(1000);
			verifyMustExists(policy.YesRadioBtn,"Yes Radio Button");
			javaScriptclick(policy.YesRadioBtn,"Yes Radio Button");
			sleep(1000);
			verifyMustExists(policy.FirstEnterText,"First Enter Text");
			sendKeys(policy.FirstEnterText,"Test3","First Enter Text");
			sleep(1000);
			verifyMustExists(policy.firstYesBtn,"Yes Radio Button");
			javaScriptclick(policy.firstYesBtn,"Yes Radio Button");
			sleep(1000);
			if(isVisible(policy.SecondDraftEndoresmentPopUp) == true)
			{
			verifyMustExists(policy.SecondDraftEndoresmentPopUp,"Second Draft Endoresment PopUp");
			sleep(1000);
			verifyMustExists(policy.SecondPopUpSaveBtn,"Second PopUp Save Button");
			javaScriptclick(policy.SecondPopUpSaveBtn,"Second PopUp Save Button");
			sleep(1000);
			}
			else{
				Report.LogInfo("ElementCheck", "Second Draft Endoresment PopUp not found", "FAIL");
				}
			}
		else{
			Report.LogInfo("ElementCheck", "second Contract Endorsement PopUp not found", "FAIL");
		}
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(2000);
		verifyMustExists(VerifyVersion,"Verify Version is 2");
		verifyMustExists(VerifyChangeType,"Verify ChangeType is Contract & Settings");
		verifyMustExists(verifyStatus,"verify Status is 'Draft Entoresment");
		verifyMustExists(VerifyVersionChanges,"verify Version Changes");
		sleep(2000);
		policy.navigateToContractDetailsTab();
		sleep(3000);
		EditContract();
		SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue1);
		sleep(1000);
		SelectDropDownValue(Broker,BrokerValue2);
		sleep(1000);
		//SelectDropDownValue(BrokerContact,BrokerContactValue);
		sleep(1000);
		SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue2);
		SelectDropDownValue(policy.TechnicianDrpDown,policy.TechnicianDrpDownValue1);
		verifyMustExists(SaveEditedChanges,"Save Edited Changes");
		click(SaveEditedChanges,"Save Edited Changes");
		sleep(2000);
		waitForElementToAppear(policy.secondContractEndorsementPopUp,5);
		if(isVisible(policy.secondContractEndorsementPopUp) == true)
		{
			verifyMustExists(policy.FirstEnterText,"First Enter Text");
			sendKeys(policy.FirstEnterText,"Test4","First Enter Text");
			sleep(1000);
			verifyMustExists(policy.SaveBtn4,"Save Button");
			javaScriptclick(policy.SaveBtn4,"Save Button");
			sleep(1000);
		}
		else{
			Report.LogInfo("ElementCheck", "Second Draft Endoresment PopUp not found", "FAIL");
		    }
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(2000);
		verifyMustExists(VerifyVersion,"Verify Version is 2");
		verifyMustExists(VerifyChangeType,"Verify ChangeType is Contract & Settings");
		verifyMustExists(verifyStatus,"verify Status is 'Signed'");
		verifyMustExists(VerifyVersionChanges,"verify Version Changes");
		verifyMustExists(VerifyAddedNote,"Verify Added Note");
		sleep(2000);
		policy.navigateToContractDetailsTab();
		sleep(3000);
		EditContract();
		
		SelectDropDownValue(ContractCurrencyDrpDown,ContractCurrencyDrpDownValue);
		sleep(1000);
		SelectDropDownValue(Broker,BrokerValue);
		sleep(1000);
	//	SelectDropDownValue(BrokerContact,BrokerContactValue);
		sleep(1000);
		SelectDropDownValue(UnderwriterDrpDown,UnderwriterDrpDownValue);
		SelectDropDownValue(policy.TechnicianDrpDown,policy.TechnicianDrpDownValue);
		verifyMustExists(SaveEditedChanges,"Save Edited Changes");
		click(SaveEditedChanges,"Save Edited Changes");
		sleep(2000);
		waitForElementToAppear(policy.secondContractEndorsementPopUp,5);
		if(isVisible(policy.secondContractEndorsementPopUp) == true)
		{
			verifyMustExists(policy.SaveBtn4,"Save Button");
			javaScriptclick(policy.SaveBtn4,"Save Button");
			sleep(1000);
		}
		else{
			Report.LogInfo("ElementCheck", "second Contract Endorsement PopUp not found", "FAIL");
		    }
		waitForElementToAppear(VersionTab,5);
		verifyMustExists(VersionTab,"Version Tab");
		javaScriptclick(VersionTab,"Version Tab");
		sleep(2000);
		verifyMustExists(VerifyVersion,"Verify Version is 3");
		verifyMustExists(VerifyChangeType,"Verify ChangeType is Contract & Settings");
		verifyMustExists(verifyStatus,"verify Status is 'Signed'");
		verifyMustExists(VerifyVersionChanges,"verify Version Changes");
		sleep(2000);
	}
	//*****************************Reuseable Function******************
	public void EditContract() throws Exception
	{
		verifyMustExists(EditContractDetails,"Edit Details Tab Icon");
		click(EditContractDetails,"Edit Details Tab Icon");
		verifyMustExists(EditDetails,"Edit Details Tab");
		click(EditDetails,"Edit Details Tab");
		sleep(3000);
	}
	
	
	public void ClaimAuthority_Add_Edit_Delete_TC4121() throws Exception
	{
		
		           //Step 1
		policy.CreateContractwithInceptionDate2018();
		BordereauPage.applyFilterPolicy(policy.PolicyNumber);
		//BordereauPage.applyFilterPolicy("116676IH");
		BordereauPage.openSelectedPolicy();	
		
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");
				
				
		policy.navigateToSectionTab();		
		policy.navigateToClaimsAuthorityTabOnSection();
		policy.addClaimsAuthorityOnSection();
		verifyExists(policy.TeamIcon,"TeamIcon");
		sleep(1000);
		verifyExists(policy.ClaimAuthority,"Verify Added Claim Authority");
		sleep(1000);
		verifyExists(policy.AUTHORITYLIMIT,"Verify Added AUTHORITY LIMIT");
		sleep(1000);
		verifyExists(policy.AuthorityType,"Verify Added AUTHORITY Type");
		sleep(1000);
		
		
		//step5
				//Step 2
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion2,"Verify Version is 2");
				verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
				verifyMustExists(CorrectionsNo,"Verify Correction is No");
				verifyMustExists(verifyStatus,"verify Status is 'Signed");
				verifyMustExists(AddClaimAutho1,"Add Claim Authority 1");
				sleep(2000);		
				Report.LogInfo("StepCheck", "Step 2 completed", "PASS");
				//step6
				//Step 3
				policy.navigateToSectionTab();		
				policy.navigateToClaimsAuthorityTabOnSection();
				policy.addClaimsAuthority1OnSection();
				
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion3,"Verify Version is 3");
				verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
				verifyMustExists(CorrectionsYES,"Verify Correction is Yes");
				verifyMustExists(verifyStatus2,"verify Status is 'Draft Entoresment");
				verifyMustExists(AddClaimAutho1,"Add Claim Authority 1");
				Report.LogInfo("StepCheck", "Step 3 completed", "PASS");
				sleep(2000);
				//step10
				//step 4
				policy.navigateToSectionTab();		
				policy.navigateToClaimsAuthorityTabOnSection();
				//Edit Claim Authority
				waitForElementToAppear(EditClaimsAuthority,5);
				verifyMustExists(EditClaimsAuthority,"Edit Claims Authority  on Section");
				click(EditClaimsAuthority,"Edit Claims Authority  on Section");	
				verifyMustExists(EditClaimsAuthoritytab,"Edit Claims Authority tab on Section");	
				verifyMustExists(policy.SaveChangesBtn,"Click on Save changes button");
				click(policy.SaveChangesBtn,"Click on Save changes button");
				sleep(2000);
				Report.LogInfo("StepCheck", "Step 4 completed", "PASS");
				//step11
				//step 5
				waitForElementToAppear(EditClaimsAuthority,5);
				verifyMustExists(EditClaimsAuthority,"Edit Claims Authority  on Section");
				click(EditClaimsAuthority,"Edit Claims Authority  on Section");	
				verifyMustExists(EditClaimsAuthoritytab,"Edit Claims Authority tab on Section");
				
				waitForElementToAppear(policy.ClaimAuthorityDropdown,5);
				verifyMustExists(policy.ClaimAuthorityDropdown,"Authority Dropdown");
				click(policy.ClaimAuthorityDropdown,"Authority Dropdown");
				
				waitForElementToAppear(policy.AuthorityDDValue,5);
				verifyMustExists(policy.AuthorityDDValue,"Authority Dropdown Value");
				click(policy.AuthorityDDValue,"Authority Dropdown Value");
				
				verifyMustExists(policy.AuthorityLimitTBox,"Authority Limit  Textbox");
				sendKeys(policy.AuthorityLimitTBox, "70", "Authority Limit  Textbox");

				sleep(2000);
				SelectDropDownValue(policy.AuthorityCurrencyDropdown,policy.AuthorityCurrencyINR);
				
				verifyMustExists(policy.SaveChangesBtn,"Click on Save changes button");
				click(policy.SaveChangesBtn,"Click on Save changes button");
				sleep(2000);
				
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion3,"Verify Version is 3");
				verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
				verifyMustExists(CorrectionsYES,"Verify Correction is Yes");
				verifyMustExists(verifyStatus2,"verify Status is 'Draft Entoresment");
				verifyMustExists(AddClaimAutho1,"Add Claim Authority 1");
				Report.LogInfo("StepCheck", "Step 5 completed", "PASS");
				//step15
				//step 6
				policy.navigateContarctDetailsTab();
				sleep(1000);
				verifyMustExists(DraftEndorsement,"Draft Endorsement");
				sleep(1000);
				click(DraftEndorsement,"Draft Endorsement");
				sleep(1000);
				
				if(isVisible(policy.ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(policy.CancelBtn,"Cancel Button");
					javaScriptclick(policy.CancelBtn,"Cancel Button");
					sleep(3000);
				}
				
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion3,"Verify Version is 3");
				verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
				verifyMustExists(CorrectionsYES,"Verify Correction is Yes");
				verifyMustExists(verifyStatus2,"verify Status is 'Draft Entoresment");
				verifyMustExists(AddClaimAutho1,"Add Claim Authority 1");
				Report.LogInfo("StepCheck", "Step 6 completed", "PASS");
				
				//step 7
				policy.navigateContarctDetailsTab();
				sleep(1000);
				verifyMustExists(DraftEndorsement,"Draft Endorsement");
				sleep(1000);
				click(DraftEndorsement,"Draft Endorsement");
				sleep(1000);
				if(isVisible(policy.ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(policy.SaveBtn3,"Save Button");
					javaScriptclick(policy.SaveBtn3,"Save Button");
					sleep(3000);
				}
				
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion3,"Verify Version is 3");
				verifyMustExists(VerifyChangeType_,"Verify ChangeType is -");
				verifyMustExists(Corrections,"Corrections - displayed");
				verifyMustExists(VerifyVersionNO,"Verify Version No Changes Tab");
				String SignStatus="Signed";
				String getSignstatus = getTextFrom(verifyStatus);
				if(getSignstatus.equals(SignStatus)){
				Report.LogInfo("ValidateStatus", "Status is'Signed'", "Pass");
				}
				else{
					Report.LogInfo("ValidateStatus", "Status is not 'Signed'", "Fail");
				}
				Report.LogInfo("StepCheck", "Step 7 completed", "PASS");
				//step20
				//Step 8
				policy.navigateToSectionTab();		
				policy.navigateToClaimsAuthorityTabOnSection();
				//Delete Claim Authority
				DeleteClaimAuthorityDraftEndors();
				
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion4,"Verify Version is 4");
				verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
				verifyMustExists(CorrectionsYES,"Verify Correction is Yes");
				verifyMustExists(verifyStatus2,"verify Status is 'Draft Entoresment");
				verifyMustExists(DeleteClaimAutho,"Delete Claim Authority");
				Report.LogInfo("StepCheck", "Step 8 completed", "PASS");
				//step24
				
				//Step 9
				policy.navigateContarctDetailsTab();
				sleep(1000);
				verifyMustExists(DraftEndorsement,"Draft Endorsement");
				sleep(1000);
				click(DraftEndorsement,"Draft Endorsement");
				sleep(1000);
				
				if(isVisible(policy.ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(policy.CancelBtn,"Cancel Button");
					javaScriptclick(policy.CancelBtn,"Cancel Button");
					sleep(3000);
				}
				policy.navigateToReportingChannelsTab();
				policy.addReportingChannelForpremium();	
				
				
				
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion4,"Verify Version is 4");
				verifyMustExists(VerifyChangeType,"Verify ChangeType is Setting");
				verifyMustExists(Corrections,"Verify Correction is -");
				verifyMustExists(verifyStatus,"verify Status is 'Signed");
				verifyMustExists(ReportingPremium,"Added Reporting premium channel");
				Report.LogInfo("StepCheck", "Step 9 completed", "PASS");
				
				policy.navigateToSectionTab();		
				policy.navigateToClaimsAuthorityTabOnSection();
				policy.addClaimsAuthorityOnSection();
				
				waitForElementToAppear(VersionTab,5);
				verifyMustExists(VersionTab,"Version Tab");
				javaScriptclick(VersionTab,"Version Tab");
				sleep(2000);
				verifyMustExists(VerifyVersion5,"Verify Version is 5");
				verifyMustExists(VerifyChangeTypeContract,"Verify ChangeType is Contract");
				verifyMustExists(CorrectionsNo,"Verify Correction is No");
				verifyMustExists(verifyStatus,"verify Status is 'Signed");
				verifyMustExists(AddClaimAutho1,"Add Claim Authority 1");
				Report.LogInfo("StepCheck", "Step 10 completed", "PASS");
			}
			

		public void DeleteClaimAuthorityDraftEndors() throws InterruptedException
			{
				policy.navigateToSectionTab();		
				policy.navigateToClaimsAuthorityTabOnSection();
				//Delete Claim Authority
				waitForElementToAppear(EditClaimsAuthority,5);
				verifyMustExists(EditClaimsAuthority,"Edit Claims Authority  on Section");
				click(EditClaimsAuthority,"Edit Claims Authority  on Section");	
				verifyMustExists(EditClaimsAuthoritytab,"Edit Claims Authority tab on Section");
				verifyMustExists(DeleteClaimsAuthority,"Delete Claims Authority  on Section");
				click(DeleteClaimsAuthority,"Delete Claims Authority  on Section");
				verifyMustExists(DeleteIt,"Yes, Delete it!");
				click(DeleteIt,"Yes, Delete it!");
				sleep(1000);
				if(isVisible(policy.secondContractEndorsementPopUp) == true)
				{
					sleep(1000);
					verifyMustExists(policy.YesRadioBtn,"Yes Radio Button");
					javaScriptclick(policy.YesRadioBtn,"Yes Radio Button");
					sleep(1000);
					verifyMustExists(policy.firstYesBtn,"Yes Radio Button");
					javaScriptclick(policy.firstYesBtn,"Yes Radio Button");
					sleep(1000);
					if(isVisible(policy.SecondDraftEndoresmentPopUp) == true)
					{
					verifyMustExists(policy.SecondDraftEndoresmentPopUp,"Second Draft Endoresment PopUp");
					sleep(1000);
					verifyMustExists(policy.SecondPopUpSaveBtn,"Second PopUp Save Button");
					javaScriptclick(policy.SecondPopUpSaveBtn,"Second PopUp Save Button");
					sleep(1000);
					}
					else{
						Report.LogInfo("ElementCheck", "Second Draft Endoresment PopUp not found", "FAIL");
						}
					
				}
		
		
	}
}
