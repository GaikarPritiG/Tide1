package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class CSVProcessing extends PageBase {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQue = new BordereauQuePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	
	
	public String Ascertainfromsheetname;
	public static final String currencydd ="@xpath=//*[@class='fg-line']//span[@class='k-icon k-i-arrow-60-down']";
	public static String sheet3752Path = "";
	
	
	
	public static final String uploadFile ="@xpath=//*[@class='drop-box dropzone ng-pristine ng-untouched ng-valid ng-empty']";
	public static final String splitBtn ="@xpath=//button[@class='btn btn-primary dropdown-toggle p-r-7']//span";
	public static final String RPQ ="@xpath=//ul//li//a[text()='Risk And Premium']";
	public static final String questionnaireNameTxt ="@xpath=//*[@aria-owns='formatUL_listbox']//span[2]";
	public static final String Datetext  ="@xpath=//*[@class='k-picker-wrap k-state-default']//input";
	
	// TC-3749----START
	public void CreateCSVQuestionnaire_TC3749() throws Exception {
		
		
		BQue.addNewCSVQuestionnaire3749();
			
		
	}

	public void AssertfromsheetnamemustnotbepresentforYOACCY_TC3750() throws Exception {

		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+BQue.CSVRiskAndPremium+"')][1]";

		BQue.filterBordereauQuestionnaire(BQue.EditName, SelectQuestionnaire);
		waitForElementToPresent(By.xpath(BQue.EditBtn), 3);
		verifyMustExists(BQue.EditBtn,"Edit button");
		click(BQue.EditBtn,"Edit button");
		sleep(3000);
		BQue.nextStapeClick();
		BQue.nextStapeClick();
		
		
		verifyMustExists(BQue.YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		click(BQue.YOAeachRiskSpecifiedDD,"YOA associated with each Risk specified? Dropdown");
		
		if(isVisible(BQue.Ascertainfromsheetname)==true){
		
			verifyExists(BQue.Ascertainfromsheetname,"Regulator Role Text");
			Ascertainfromsheetname =  getTextFrom(BQue.Ascertainfromsheetname);
			Report.LogInfo("Regulator Role Text", "Ascertain from sheetname Text visible", "Fail");
		}
		else
		{
			Report.LogInfo("Regulator Role Text", "Ascertain from sheet name Text not visible", "Pass");
							
		}
		BQue.nextStapeClick();//step4
		BQue.nextStapeClick();//step5
		BQue.nextStapeClick();//step6
		BQue.nextStapeClick();//step7
		
		verifyMustExists(currencydd,"What is the source of the currency value? Dropdown");
		click(currencydd,"What is the source of the currency value? Dropdown");
		
		if(isVisible(BQue.Ascertainfromsheetname)==true){
			
			verifyExists(BQue.Ascertainfromsheetname,"Regulator Role Text");
			Ascertainfromsheetname =  getTextFrom(BQue.Ascertainfromsheetname);
			Report.LogInfo("Regulator Role Text", "Ascertain from sheetname Text visible", "Fail");
		}
		else
		{
			Report.LogInfo("Regulator Role Text", "Ascertain from sheet name Text not visible", "Pass");
							
		}
	
		BQue.nextStapeClick();//step8
		verifyMustExists(BQue.CancelBtn,"Cancel button");
		click(BQue.CancelBtn,"Cancel button");
		
	}
	  
	public void CSVFileProcessusingcsvxlsxQuestionnaireformat_TC3752() throws Exception {
		String SelectQuestionnaire ="@xpath=//ul//li[contains(.,'"+BQue.CSVRiskAndPremium+"')][1]";
		String type1 = "Risk And Premium";
		String FreqVal1 = "Monthly";
		String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
		
		String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
		String subSheet = "Automation Risk And Premium Format 2 (Lloyd's Property Schema)";
		// step 1
		policy.CreateContractwithInceptionDate2018();
		/*policy.applyFilterPolicy("925741SS");
		policy.openSelectedPolicy();*/
		sleep(1000);
		policy.navigateToReportingChannelsTab();
	    policy.addReportingChannelForAnyComb(type1,FreqVal1);
	    Report.LogInfo("StepCheck", "Steps 1 completed", "PASS");
		
	    
	    policy.navigationOnBordereauxTab();
		String GetData = Configuration.url + "/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+ "\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";
		
		
		Br.SubmitBordereaux(subSheet);
		sleep(1000);
		verifyMustExists(splitBtn,"Select Premium Option");
		click(splitBtn,"Select Premium Option");
		sleep(2000);
		
		verifyMustExists(RPQ,"Select Premium Option");
		click(RPQ,"Select Premium Option");
		sleep(2000);
		
		verifyMustExists(questionnaireNameTxt,"Questionnaire Name Textbox");
		click(questionnaireNameTxt,"Questionnaire Name Textbox.");
		sendKeys(questionnaireNameTxt,SelectQuestionnaire,"Questionnaire Name Textbox.");
		WebElement webElement = null;
		webDriver.findElement(By.xpath("//*[@class='dz-default dz-message col-sm-12 col-xs-12 ng-scope']")).sendKeys(sheet3752Path);
		
		verifyMustExists(Datetext,"Date Textbox");
		sendKeys(Datetext,"January 2018","Date Textbox");
		
		try {
			String fpath = new File(".").getCanonicalPath();
			sheet3752Path = fpath + "\\src\\test\\resources\\testdata\\Stage 2 TC_3915.xlsx";
		} catch (IOException e) {
			e.printStackTrace();
		}
		File excelFile = new File(sheet3752Path);
		policy.contractId = addNewBordereauFormatPolicy(payload1, GetData);

		String Ufname = "S31277820181105.xlsx";	
		int size = 18841;
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BQue.BFormatId, ID, Ufname, size, 1 , "4", 2018);
        addAsDraft(payload,DraftUrl);
        
		Br.refreshUploadedFile();
	
	}
	
	public void XMLFileProcessingwithcontractdoesnotexist_TC3764() throws Exception {
		//WebElement webElement = null;
		String URLname = Configuration.url+"/#!/app/fileupload";
		String requestURL = Configuration.url + "api/SchemaAPI/UploadFile/true";
		openurl(URLname);	
		sleep(2000);
		//click(uploadFile,"Bordereau Type Dropdown");
		sleep(2000);
		//webElement.sendKeys("C:\\Users\\tester\\git1\\TideAutomation\\src\\test\\resources\\testdata\\XMLContract.xml");
	     //sendKeys("C:\\Users\\tester\\git1\\TideAutomation\\src\\test\\resources\\testdata\\XMLContract.xml","","");
	     
	    
		//sendKeys("C:\\Users\\tester\\git1\\TideAutomation\\src\\test\\resources\\testdata\\XMLContract.xml","Senk kye");
	/*	// verifyMustExists(uploadFile,"Upload File");
		// click(uploadFile,"Upload File");
		
		 */
		 
		 try {
				String fpath = new File(".").getCanonicalPath();
				sheet3752Path = fpath + "\\src\\test\\resources\\testdata\\XMLContract.xml";
			} catch (IOException e) {
				e.printStackTrace();
			}
			File excelFile = new File(sheet3752Path);
			
			WebElement upload =  webDriver.findElement(By.xpath("//*[@class='drop-box dropzone ng-pristine ng-untouched ng-valid ng-empty']"));
					//webDriver.findElement(By.xpath("//*[@class='drop-box dropzone ng-pristine ng-untouched ng-valid ng-empty']")).click();
			 upload.sendKeys("C:\\Users\\tester\\git1\\TideAutomation\\src\\test\\resources\\testdata\\XMLContract.xml");
	    		 Thread.sleep(5000);  
			//String response = uploadFileQueNew(requestURL, excelFile, Filename);
		/*	String payload = "[{\"time\":\"2018-11-05T09:32:33.253Z\",\"iKey\":\"95233c50-1819-4ceb-87a8-786174289ea1\",\"name\":\"Microsoft.ApplicationInsights.95233c5018194ceb87a8786174289ea1.RemoteDependency\",\"tags\":{\"ai.session.id\":\"GDlET\",\"ai.device.id\":\"browser\",\"ai.device.type\":\"Browser\",\"ai.internal.sdkVersion\":\"javascript:1.0.20\",\"ai.user.id\":\"SP8se\",\"ai.operation.id\":\"rcJnr\",\"ai.operation.name\":\"/\"},\"data\":{\"baseType\":\"RemoteDependencyData\",\"baseData\":{\"id\":\"|rcJnr.VRyGd\",\"ver\":2,\"name\":\"POST /api/Contract/GetAllPage\",\"resultCode\":\"200\",\"duration\":\"00:00:04.310\",\"success\":true,\"data\":\"POST ./api/Contract/GetAllPage\",\"target\":\"dev.theinsurancedataexchange.com | cid-v1:3307a2c5-5782-42ea-a439-f4484fb7c302\",\"type\":\"Ajax\"}}},{\"time\":\"2018-11-05T09:32:46.343Z\",\"iKey\":\"95233c50-1819-4ceb-87a8-786174289ea1\",\"name\":\"Microsoft.ApplicationInsights.95233c5018194ceb87a8786174289ea1.RemoteDependency\",\"tags\":{\"ai.session.id\":\"GDlET\",\"ai.device.id\":\"browser\",\"ai.device.type\":\"Browser\",\"ai.internal.sdkVersion\":\"javascript:1.0.20\",\"ai.user.id\":\"SP8se\",\"ai.operation.id\":\"rcJnr\",\"ai.operation.name\":\"/\"},\"data\":{\"baseType\":\"RemoteDependencyData\",\"baseData\":{\"id\":\"|rcJnr.sPqlT\",\"ver\":2,\"name\":\"PUT /api/SchemaAPI/UploadFile/true\",\"resultCode\":\"200\",\"duration\":\"00:00:05.027\",\"success\":true,\"data\":\"PUT ./api/SchemaAPI/UploadFile/true\",\"target\":\"dev.theinsurancedataexchange.com | cid-v1:3307a2c5-5782-42ea-a439-f4484fb7c302\",\"type\":\"Ajax\"}}}]";
		   
		  //  String formatId = addNewBordereauFormat(payload, URLname);
		    uploadFileQue(requestURL, excelFile, payload, URLname);
		 sleep(3000);
		 addNewBordereauFormat(payload, URLname);*/
	}

	


		
}
