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

public class BreachManagmentPage extends PageBase{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQue = new BordereauQuePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	BProcessingRiskPremiumClaimPage BRPC = new BProcessingRiskPremiumClaimPage();
	SchedulePage Schedule = new SchedulePage();
	PolicyPage policy = new PolicyPage();

	public static String sheet5127Path = "";
	public static String sheet5128Path = "";
	public static String sheet5128PathScnd = "";
	public static String sheet5129Path = "";
	public static final String RiskRefranceA2 = "@xpath=//td[5]//a[@ng-click='openRiskReference(dataItem)'][text()='3']";
	public static final String RiskRefranceA1 = "@xpath=//td[5]//a[@ng-click='openRiskReference(dataItem)'][text()='2']";
	public static final String RiskRefranceA3 = "@xpath=//td[5]//a[@ng-click='openRiskReference(dataItem)'][text()='1']";
	public static final String BreachCount = "@xpath=//span[contains(text(),'1 - 3 of 3 items')]";	
	public static final String StringBreachRiskTab =  "@xpath=//li[2]/a[contains(.,'Risk')]";
	public static final String CurrentEntry =  "@xpath=//*[@id='grid']//td[text()='Current']";
	public String AddRuleBtn;
	public String Edit;
	public String RF3;
	public String RF2;
	public String RF1;
	public String BC1;
	
	public static String contractId;
	
	//Locators for TC-5127
	public static final String RuleHeaderLink = "@xpath=//a[text()='RULES']";

	//Locatior For TC -3649
	public static final String NorthAmericaExpandarrow = "@xpath=//*[text()='North America']/preceding-sibling::span";
	public static final String AlbertacheckBox = "@xpath=//*[text()='Alberta']/preceding-sibling::input[@type='checkbox']";
	public static final String CanadaExpandarrow = "@xpath=//tr[@class='k-alt k-treelist-group ng-scope']//td//span[@class='k-icon k-i-expand']";
	public static final String Canadacheckbox = "@xpath=//*[text()='Canada']/preceding-sibling::input[@type='checkbox']";
	public static final String BritishColumbiacheckBox = "@xpath=//*[text()='British Columbia']/preceding-sibling::input[@type='checkbox']";
	
	public void NoChangeToExistngBreach_5127() throws Exception{
		String MonthDate = "April 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		policy.CreateContractwithInceptionDate2018();
		String contractId = ReturnContractID();
		
       
		//Step 2
	    sleep(2000);
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn,"Add Rule button");
		click(policy.AddRulesBtn,"Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup,5);
		verifyMustExists(policy.AddRulesPopup,"Add Rules popup");
		verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
		sendKeys(policy.RuleNameTxt,"Gross Premium less than 400 is valid","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue1);
		verifyMustExists(policy.ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt,"4","ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD,policy.GrossPreVal);
		SelectDropDownValue(policy.OperatorDD,policy.LessThan);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"500","Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn,"Check button");
		click(policy.CheckBtn,"Check button");
		sleep(2000);

		waitForElementToAppear(policy.SaveBtn,5);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		sleep(2000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5127Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC5127.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5127Path); 
		  
		String Ufname = "S85888620181001.xlsx";	
		int size = 17629;
		String BordreauID = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		Br.refreshUploadedFile();
		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn,"Review button");
			click(Br.ReviewBtn,"Review button");
			waitForElementToAppear(Br.SuRcdAssmnt,5);
			verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn,5);
			verifyMustExists(Br.FrApprovalbtn,"For Approval button");
			click(Br.FrApprovalbtn,"For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileApprovedStatus();
			waitForElementToAppear(Br.Approvedbtn,5);
			verifyMustExists(Br.Approvedbtn," Approval button");
			if(isVisible(Br.Approvedbtn)==true)
			{
				AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
				Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
				policy.navigateRulesTab();
				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue1);
				sleep(2000);
				verifyExists(Br.RiskRefrance,"Referance value 3");
				RF3 =  getTextFrom(Br.RiskRefrance);	
				Report.LogInfo("Referance value 3", RF3, "PASS");

				policy.navigateRulesTab();
				verifyMustExists(policy.EditRulesBtn,"Edit Rule button");
				Edit =  getTextFrom(policy.EditRulesBtn);	
				Report.LogInfo("Edit Rule button", Edit, "PASS");
				
				click(policy.EditRulesBtn,"Edit Rule button");
				waitForElementToAppear(policy.AddRulesPopup,5);
				verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
				sendKeys(policy.RuleNameTxt,"Data is valid if the rule condition is met","Rules Name");

				waitForElementToAppear(policy.EditCondition,5);
				verifyExists(policy.EditCondition,"Edit condition button");
				click(policy.EditCondition,"Edit condition button");
				sleep(2000);
				verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
				sendKeys(policy.EntryOrSelectionTxt ,"480","Entry Or Selection textbox");
				verifyMustExists(policy.CheckBtn,"Check button");
				click(policy.CheckBtn,"Check button");
				sleep(2000);

				waitForElementToAppear(policy.SaveBtn,5);
				verifyMustExists(policy.SaveBtn,"Save button");
				click(policy.SaveBtn,"Save button");
				sleep(2000);
				if(isVisible(policy.ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(policy.SaveBtn3,"Save Button");
					click(policy.SaveBtn3,"Save Button");
					sleep(3000);
				}

				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue2);
				sleep(2000);
				verifyExists(Br.RiskRefrance,"Referance value 3");
				RF3 =  getTextFrom(Br.RiskRefrance);	
				Report.LogInfo("Edit Rule button", RF3, "PASS");

			}
		}else{
			Report.LogInfo("ValidateAprrrovedStatus", "Review Status not displayed.", "FAIL");
		}
	}


	public void UpdateToExistngBreach_5128() throws Exception{

		String MonthDate = "April 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		policy.CreateContractwithInceptionDate2018();
		String contractId = ReturnContractID();
         
  		
		//Step 2
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn,"Add Rule button");
		click(policy.AddRulesBtn,"Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup,5);
		verifyMustExists(policy.AddRulesPopup,"Add Rules popup");
		verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
		sendKeys(policy.RuleNameTxt,"Gross Premium less than 400 is valid","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue1);
		verifyMustExists(policy.ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt,"4","ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD,policy.GrossPreVal);
		SelectDropDownValue(policy.OperatorDD,policy.LessThan);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		verifyMustExists(policy.EntryOrSelectionTxt ,"Entry Or Selection textbox");
		sendKeys(policy.EntryOrSelectionTxt ,"400","Entry Or Selection textbox");
		verifyMustExists(policy.CheckBtn,"Check button");
		click(policy.CheckBtn,"Check button");
		sleep(2000);

		waitForElementToAppear(policy.SaveBtn,5);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		sleep(2000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}

		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5128Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC_5128.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5128Path); 
		
		String Ufname = "S55826720181001.xlsx";	
		int size = 17783;
		String BordreauID = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2017_TC_5128.xlsx\",\"UniqueFileName\":\"S16481120180522.xlsx\",\"BordereauFormatId\":\"87ff463a-ac88-4a6a-9b80-9e5e892aeb2d\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S16481120180522.xlsx\",\"Filesize\":17782,\"Path\":null,\"size\":17782,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		Br.refreshUploadedFile();
		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn,"Review button");
			click(Br.ReviewBtn,"Review button");
			waitForElementToAppear(Br.SuRcdAssmnt,5);
			verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn,5);
			verifyMustExists(Br.FrApprovalbtn,"For Approval button");
			click(Br.FrApprovalbtn,"For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileForApprovedScndRw();
			if(isVisible(Br.Approvedbtn)==true)
			{
				AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
				Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
				policy.navigateRulesTab();
				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue1);
				sleep(2000);				

				verifyExists(Br.RiskRefrance,"Referance value 3");
				RF3 =  getTextFrom(Br.RiskRefrance);	
				Report.LogInfo("Referance value 3", RF3, "PASS");
				verifyExists(Br.RiskRefranceA2,"Referance value 2");
				RF2 =  getTextFrom(Br.RiskRefranceA2);	
				Report.LogInfo("Referance value 2", RF2, "PASS");

				Br.SubmitBordereauxWithYesnoButtons(MonthDate);
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet5128PathScnd = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC5128_Scnd.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile1 = new File(sheet5128PathScnd); 

				//System.out.println(contractId);
				              
				String Ufname1 = "S76243920181001.xlsx";	
				int size1 = 17791;
				String BordreauID1 = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
		        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
		        String ID1 = extractIDFromResponseinsideContract(response1); 
		        String payload2 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 2 , "1", 2018);
		        addAsDraft(payload2,DraftUrl);
				Br.refreshUploadedFile();

				if(isVisible(Br.ReviewBtn)==true){
					Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
					sleep(2000);
					verifyMustExists(Br.ReviewBtn,"Review button");
					click(Br.ReviewBtn,"Review button");
					waitForElementToAppear(Br.SuRcdAssmnt,5);
					verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
					click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
					waitForElementToAppear(Br.FrApprovalbtn,5);
					verifyMustExists(Br.FrApprovalbtn,"For Approval button");
					click(Br.FrApprovalbtn,"For Approval button");
					Br.clickOnApproveBordBtn();
					Br.refreshUploadedFileApprovedStatus();
					if(isVisible(Br.Approvedbtn)==true)
					{
						Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
						Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
						policy.navigateRulesTab();
						policy.navigateBreachesTab();
						waitForElementToAppear(policy.RulesDD,3);
						verifyMustExists(policy.RulesDD,"Rules Drop Down");
						SelectDropDownValue(policy.RulesDD,policy.RulesDDValue1);
						sleep(2000);
						verifyExists(Br.RiskRefrance,"Referance value 3");
				     	verifyExists(Br.RiskRefranceA2,"Referance value 2");
						verifyExists(Br.Version1,"Version 1 row");
						verifyExists(Br.Version2,"Verison 2 second");
						verifyExists(Br.RuleConditionExists,"Validate Rule condition");
						

					}else{
						Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review Status not displayed.", "FAIL");
				}					
			}
		}else{
			Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
		}
	}


	public void AchiveOfPreviousBreach_5129() throws Exception{
        String MonthDate = "April 2017";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";		
		policy.CreateContractwithInceptionDate2018();
		String contractId = ReturnContractID();
	  
		policy.navigateRulesTab();
		verifyMustExists(policy.AddRulesBtn,"Add Rule button");
		click(policy.AddRulesBtn,"Add Rule button");
		waitForElementToAppear(policy.AddRulesPopup,5);
		verifyMustExists(policy.AddRulesPopup,"Add Rules popup");
		verifyMustExists(policy.RuleNameTxt,"Rules Name textbox");
		sendKeys(policy.RuleNameTxt,"Risk country equals to united states","Rules Name");
		SelectDropDownValue(policy.DatasetTypeDD,policy.RiskValue);
		SelectDropDownValue(policy.ApplicationConditionDD,policy.ConditionMetValue);
		SelectDropDownValue(policy.CurrencyDD,policy.ContractCurrencyDrpDownValue1);
		verifyMustExists(policy.ROEToleranceTxt,"ROE Tolerance textbox");
		sendKeys(policy.ROEToleranceTxt,"4","ROE Tolerance textbox");

		WebElement Section = webDriver.findElement(By.xpath("//dt//span[contains(.,'Applicable Section')]//following::input[1]"));
		Actions a = new Actions(webDriver);
		sleep(1000);
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.BACK_SPACE).build().perform();
		a.click(Section).build().perform();
		a.sendKeys(Section, Keys.ENTER).build().perform();
		sleep(1000);

		verifyMustExists(policy.AddRuleConditionBtn,"Add Rule Condition button");
		AddRuleBtn = getTextFrom(policy.AddRuleConditionBtn);
		Report.LogInfo("Add Rule Condition button", AddRuleBtn, "PASS");
		click(policy.AddRuleConditionBtn,"Add Rule Condition button");
		scrollDown();
		SelectDropDownValue(policy.FieldNameDD,policy.RiskCountryVal);
		SelectDropDownValue(policy.OperatorDD,policy.EqualToValue);
		SelectDropDownValue(policy.AppliedToDD,policy.Value);
		SelectDropDownValue(policy.EntryOrSelectionDD,policy.EntryOrSelectionValueUS);
		verifyMustExists(policy.CheckBtn,"Check button");
		click(policy.CheckBtn,"Check button");
		sleep(2000);

		waitForElementToAppear(policy.SaveBtn,5);
		verifyMustExists(policy.SaveBtn,"Save button");
		click(policy.SaveBtn,"Save button");
		sleep(2000);
		if(isVisible(policy.ConEndrsmntPopUp) == true)
		{
			sleep(1000);
			verifyExists(policy.SaveBtn3,"Save Button");
			click(policy.SaveBtn3,"Save Button");
			sleep(3000);
		}
		
		sleep(2000);
		Report.LogInfo("StepsCheck", "Step 2 completed", "PASS");
		scrollUp();
		Br.SubmitBordereauxWithYesnoButtons(MonthDate);
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet5129Path = fpath+"\\src\\test\\resources\\testdata\\January 2017_TC5129.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet5129Path); 

		String Ufname = "S65488320181001.xlsx";	
		int size = 17832;
		String BordreauID = "87ff463a-ac88-4a6a-9b80-9e5e892aeb2d";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
		Br.refreshUploadedFile();
		if(isVisible(Br.ReviewBtn)==true){
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			sleep(2000);
			verifyMustExists(Br.ReviewBtn,"Review button");
			click(Br.ReviewBtn,"Review button");
			waitForElementToAppear(Br.SuRcdAssmnt,5);
			verifyMustExists(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			click(Br.SuRcdAssmnt,"Submit recor for Assignment button");
			waitForElementToAppear(Br.FrApprovalbtn,5);
			verifyMustExists(Br.FrApprovalbtn,"For Approval button");
			click(Br.FrApprovalbtn,"For Approval button");
			Br.clickOnApproveBordBtn();
			Br.refreshUploadedFileForApproved();
			waitForElementToAppear(Br.Approvedbtn,5);
			verifyMustExists(Br.Approvedbtn,"Approve Tab");
			if(isVisible(Br.Approvedbtn)==true)
			{
				AssertBordereauStatusApproved =  getTextFrom(Br.ApprovedButton);	
				Report.LogInfo("Status Approved", AssertBordereauStatusApproved, "PASS");
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status  displayed.", "PASS");
				Report.LogInfo("StepsCheck", "Step 3 completed", "PASS");
				policy.navigateRulesTab();
				policy.navigateBreachesTab();
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue8);
				sleep(2000);				
				verifyExists(Br.RiskRefrance3,"Referance value 3");
				RF3 =  getTextFrom(Br.RiskRefrance3);	
				Report.LogInfo("Referance value 3", RF3, "PASS");
				
				sleep(2000);
				policy.navigateRulesTab();

				verifyMustExists(policy.EditRulesBtn,"Edit Rule button");
				click(policy.EditRulesBtn,"Edit Rule button");
				waitForElementToAppear(policy.AddRulesPopup,5);
				
				waitForElementToAppear(policy.EditCondition,5);
				verifyExists(policy.EditCondition,"Edit condition button");
				click(policy.EditCondition,"Edit condition button");
				sleep(2000);
				scrollDown();
				SelectDropDownValue(policy.EntryOrSelectionDD,policy.EntryOrSelectionValueUK);
				verifyMustExists(policy.CheckBtn,"Check button");
				click(policy.CheckBtn,"Check button");
				sleep(2000);

				waitForElementToAppear(policy.SaveBtn,5);
				verifyMustExists(policy.SaveBtn,"Save button");
				click(policy.SaveBtn,"Save button");
				sleep(2000);
				if(isVisible(policy.ConEndrsmntPopUp) == true)
				{
					sleep(1000);
					verifyExists(policy.SaveBtn3,"Save Button");
					click(policy.SaveBtn3,"Save Button");
					sleep(3000);
				}
				
				sleep(10000);
				scrollUp();
				policy.navigateBreachesTab();
				sleep(10000);
				waitForElementToAppear(policy.RulesDD,3);
				verifyMustExists(policy.RulesDD,"Rules Drop Down");
				SelectDropDownValue(policy.RulesDD,policy.RulesDDValue8);
				sleep(2000);
				waitForElementToAppear(BreachCount,3);
				
				verifyMustExists(BreachCount,"Breach count equal to 3");
				BC1 =  getTextFrom(BreachCount);	
				Report.LogInfo("Breach count equal to 3", BC1, "PASS");
				verifyMustExists(RiskRefranceA2, "Risk reference 2 exists");
				RF3 =  getTextFrom(RiskRefranceA2);	
				Report.LogInfo("Risk reference 2 exists", RF3, "PASS");
				verifyMustExists(RiskRefranceA1,"Risk reference 1 exists");
				RF2 =  getTextFrom(RiskRefranceA1);	
				Report.LogInfo("Risk reference 1 exists", RF2, "PASS");
				verifyMustExists(RiskRefranceA3,"Risk reference 3 exists");
				RF1 =  getTextFrom(RiskRefranceA3);	
				Report.LogInfo("Risk reference 3 exists", RF1, "PASS");
				/*if(isVisible(Br.RiskRefrance)==true)
				{
					Report.LogInfo("RecordCheck", "Referance record archive.", "PASS");
				}else{
					Report.LogInfo("RecordCheck", "Referance record not archive.", "Fail");
				}*/
				
					
			}else{
				Report.LogInfo("ValidateAprrrovedStatus", "Approved Status not displayed.", "FAIL");
			}
		}else{
			Report.LogInfo("ReviewStatus", "Review Status not displayed.", "FAIL");
		}
		click(RiskRefranceA2,"Click on risk reference");
		verifyMustExists(StringBreachRiskTab, "Navigated to risk Tab");
		verifyMustExists(CurrentEntry, "Verify current entry exists");
		
	}

	//---------------------------Reusable functions for 'Rules'------------------------------------------------------//
	//================================================================================================================//
	
}