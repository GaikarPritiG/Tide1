package com.tide.qa.pagefactory;

import java.io.File;
import java.io.IOException;

import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class RemoveCommasInHeaderRow extends PageBase {
	
	public static String sheet6168PathScnd = "";
	PolicyPage policy = new PolicyPage();
	BordereauQuePage QuePage = new BordereauQuePage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQ = new BordereauQuePage();

	BordereauProcessPage BordereauPage = new BordereauProcessPage();
	
	public void TC_1827_RemoveCommasInHeaderRow() throws Exception {
		
		/*homePage.adminMenu();
		BQ.bordereauQueLink();
		BQ.bordereauQuePage();
		QuePage.BFormatId = BQ.addsettlementQue();*/
		
		
		/*policy.CreateContractwithInceptionDate2018();
		
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForpremium();*/

		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String ContractPayload = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		String subSheet = "Bordereau Processing (tushar test schema)";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		policy.navigationOnBordereauxTab();
		//			BordereauProcess.SubmitBordereaux(subSheet);
		
		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet6168PathScnd = fpath+"\\src\\test\\resources\\testdata\\Removecommasinheaderrow_TC1827.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StringSelection allSheets = new StringSelection(allSheetsPath);
		File excelFile = new File(sheet6168PathScnd);
		policy.contractId = addNewBordereauFormatPolicy(ContractPayload, GetData);
		//System.out.println(contractId);
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"January 2018_3938.xlsx\",\"UniqueFileName\":\"S74841420180513.xlsx\",\"BordereauFormatId\":\"af045e74-8255-4451-99fe-34d112f092c7\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S74841420180513.xlsx\",\"Filesize\":18020,\"Path\":null,\"size\":18020,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		Report.LogInfo("formatCheck",QuePage.BFormatId , "PASS");
		
	//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Settlmentfincial_TC_6168.xlsx\",\"UniqueFileName\":\"S31789520180604.xlsx\",\"BordereauFormatId\":\""+QuePage.BFormatId+"\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31789520180604.xlsx\",\"Filesize\":18724,\"Path\":null,\"size\":18724,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		
	//	String payload = "{\"Bordereaux\":{\"ContractId\":\""+policy.contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"removecommasinheaderrow.xlsx\",\"UniqueFileName\":\"S58809220180619.xlsx\",\"BordereauFormatId\":\"19dcc68a-a3e4-4933-a325-bb11d32ffccb\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S58809220180619.xlsx\",\"UniqueFileName\":\"S58809220180619.xlsx\",\"Filesize\":15477,\"Path\":null,\"size\":15477,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true,\"fileExtension\":1},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		
		String Ufname = "S58809220180619.xlsx";	
		int size = 15477;
		String BordreauID = "19dcc68a-a3e4-4933-a325-bb11d32ffccb";
        String response = uploadFileinContract(ReqUrl,excelFile,policy.contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(policy.contractId, BordreauID, ID, Ufname, size, 1 , "2", 2018);
        addAsDraft(payload,DraftUrl);
        
		BordereauPage.refreshUploadedFile();
		
		if (isVisible(BordereauPage.ReviewBtn) == true) {
			AssertBordereauStatusReview = getTextFrom(BordereauPage.ReviewBtn);
			Report.LogInfo("ReviewStatusValidation", "Review Status Button Displayed", "PASS");
			BordereauPage.deleteBorderEAUX();
		}else {
			Report.LogInfo("ValidateExpectedFirstRow", "Expected First Row record not validate successfully", "FAIL");
			policy.navigationOnBordereauxTab();
			BordereauPage.deleteBorderEAUX();
		}
		
	}
	}
	


