package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class RevertToUploadPage extends PageBase {
	public String errorTitleValidate1;
	public String submmitbordereautitle;
	public static String sheet6168PathScnd = "";
	public static final String skipthiserror ="@xpath=//button[@ng-click='SkipAndContinue()']";
	public static final String reverttoupload ="@xpath=//button[@ng-click='RevertToUploaded()']";
	public static final String UploadedBtn ="@xpath=//button[text()='Uploaded']";
	PolicyPage policy = new PolicyPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	SchemaPage schema = new SchemaPage();
	BordereauProcessPage BordereauProcess = new BordereauProcessPage();
	
public void TC_4216_RevertToUpload() throws Exception{
	
	
	policy.CreateContractwithInceptionDate2018();
	/*policy.PolicyNumber = "828215OQ";
	BordereauProcess.applyFilterPolicy(policy.PolicyNumber);
	BordereauProcess.openSelectedPolicy();*/
	
	String GetData = Configuration.url+"/api/Contract/GetAllPage";
	String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

	String subSheet = "Automation Endorsement Effective date is not supplied";
	String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
	String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
	policy.navigationOnBordereauxTab();
	//			BordereauProcess.SubmitBordereaux(subSheet);
	
	try 
	{
		String fpath = new File(".").getCanonicalPath();
		sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Jan2018_reverttoupload.xlsx";
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//StringSelection allSheets = new StringSelection(allSheetsPath);
	File excelFile = new File(sheet6168PathScnd);
	//policy.contractId="5c0a5e3a-afb5-4303-a400-035ad70fb1d4";
	policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
	
	//System.out.println(contractId);
	//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\"af045e74-8255-4451-99fe-34d112f092c7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
	Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
	
//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
	String Ufname = "S20340520181117.xlsx";	
	int size = 22369;
	String BordreauID = "34ba1e41-d8d7-4ae6-9870-d57e19a93aff";
    String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
    String ID = extractIDFromResponseinsideContract(response); 
    String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
    addAsDraft(payload,DraftUrl);
    
    
	BordereauPage.refreshUploadedFile();
	
	if(BordereauProcess.checkErrorReviewButton(BordereauProcess.ReviewError)==true) {
		
	
		Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
		
		String Errortitle= "@xpath=//*[@class='card']//h2[contains(.,'Location Sprinklers (Y/N) reference data translation required')]";
		
	
		if(isVisible(Errortitle)== true) {
			errorTitleValidate1 = getTextFrom(Errortitle);
			sleep(2000);
			
			/*SelectDropDownValue1(schema.Data0DD,Errortitle);
			sleep(2000);*/
			verifyMustExists(skipthiserror,"Skip this error button");
			click(skipthiserror,"Skip this error button");
			verifyMustExists(reverttoupload,"revert to upload button");
			click(reverttoupload, "revert to upload button");
			/*verifyMustExists(schema.CancelBtn,"Cancel button");
			click(schema.CancelBtn,"Cancel button");*/
						
		}
	}
			BordereauPage.refreshUploadedFile();
			if(isVisible(BordereauProcess.UploadedBtn)==true)
			{
				String submitbordereau = "@xpath=//*[@class='card-header ch-alt']//h2[contains(.,'Submit Bordereau')]";
				
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Uploaded.", "PASS");
				
				verifyMustExists(UploadedBtn,"Uploaded button");
				click(UploadedBtn, "Uploaded button");
				submmitbordereautitle = getTextFrom(submitbordereau);
				verifyMustExists(schema.CancelBtn,"Cancel button");
				click(schema.CancelBtn,"Cancel button");
				sleep(2000);
				
				BordereauPage.deleteBorderEAUX();
			} else {
				Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
				policy.navigationOnBordereauxTab();
				BordereauPage.deleteBorderEAUX();
			}
			}
			
	}		
		
	
	
	



