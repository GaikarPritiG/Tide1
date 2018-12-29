package com.tide.qa.pagefactory;

import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class PolicyPageContractDataSummary extends PageBase
{
	LoginPage loginPage = new LoginPage();
	PolicyPage policy = new PolicyPage();
	BordereauProcessPage Br = new BordereauProcessPage();

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	public static String getCurrentDateTimeMS1() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMssddHHmm");
		String datetime = ft.format(dNow);
		return datetime;
	}
	String UniqueReferenceVal1 = "Automation Policy3"+getCurrentDateTimeMS1();
	String UniqueReferenceVal3 = "Automation Policy4"+getCurrentDateTimeMS();
	String CompanyReferenceval = "Automation Policy5"+getCurrentDateTimeMS();
	String UniqueReferenceVal2 = "Contract 2"+getCurrentDateTimeMS();
	static String  Rule = "AutoRule"+getCurrentDateTimeMS();
	static String  Rule1 = "AutoRule1"+getCurrentDateTimeMS();
	String BrokerageVal = "10";
	String Status1 = "Draft";
	String Status2 = "Quote";
	String Broker1 = "Alwen Hough Johnson Ltd - TBC";
	String Bline1 = "Property (D&F)";
	String Underline1 = "Abhi, Standard";
	//String Status2 = "Draft";
	String Broker2 = "Alwen Hough Johnson Ltd - TBC";
	String Broker3 = "AON - DUA team";
	String Bline2 = "Energy";
	String Underline2 = "Tide, Admin";
	String InceptionDate1 = "01/01/2017";
	String InceptionDate2 = "01/01/2018";
	static String PolicyNumber;
	String OpenPolicy;
	public static String contractId;
	public String Jan_V;
	public String Jan_T;
	public String Jan_V1;
	public String Jan_T1;
	public String Incure1;
	public String Incure2;
	public String Incure3;
	public String Incure4;
	public String WG1;
	public String WG2;
	public String WG3;
	public String GP1;
	public String GP2;
	public String GP3;
	public String GP4;
	public String GP5;

	public static String sheet4729Path = "";
	public static String sheet4729PathScnd = "";
	public static String sheet4729PathThird = "";
	public static String sheet4729PathFourth = "";
	public static String sheet4729PathFifth = "";
	public static String sheet4729PathSixth = "";
	public static String sheet4745Path = "";
	public static String sheet4745PathScnd = "";
	public static String sheet4745PathThird = "";
	public static String sheet4745PathFourth = "";
	public static String sheet4745PathFifth = "";
	public static String sheet4745PathSixth = "";
	public static String sheet4839Path = "";
	public static String sheet4839PathSecnd = "";
	public static String sheet4839Paththird = "";
	public static String sheet4757Path = "";
	public static String sheet4757PathScnd = "";
	public static String sheet4757PathThird = "";
	public static String sheet4757PathFourth = "";
	public static String sheet4757PathFifth = "";
	public static String sheet4757PathSixth = "";
	
	public static final String contractEditDots = "@xpath=//ul[@class='actions ng-scope']//a[@class='dropdown-toggle']";
	public static final String ContractEditbtn = "@xpath=//*[@ng-if='Permission.Edit || PermissionContractMainCompanyReference.Edit']";
	public static final String SectionconDrp = "@xpath=.//*[@ng-model='form.defaultSectionRiskCode']//preceding-sibling::span";

	//TC 4745 :- Contract Data Summary-Quartely Reporting
	public void ConDataSumMonthlyReporting_4729() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		String subSheet = "Automation Risk format 11 (Lloyd's Property Schema)";
		String Premium = "Automation Company Admin 1 Premium Format 1 (Lloyd's Premium Property schema)";
		String Claim = "Automation Claim Format 5 (Lloyd's Claim Property schema)";
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//contractId = ReturnContractID();
		//Step 1
		policy.CreateContractwithInceptionDate2018();
		
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		//Step 2, 3, 4
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForpremium();		
		Report.LogInfo("StepCheck", "Steps 2,3,4 completed", "PASS");

		//Step 5, 6, 7
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelClaim();
		Report.LogInfo("StepCheck", "Steps 5, 6, 7 completed", "PASS");
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload_1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		
		//Step 9, 10
		BordPage.SubmitBordereaux(IncDate);		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4729Path = fpath+"\\src\\test\\resources\\testdata\\TC4729_January 2017 Risk.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4729Path);
		contractId = addNewBordereauFormatPolicy(payload_1, GetData);
		
		String Ufname = "S54264520181003.xlsx";	
		int size = 25337;
		String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 1 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"TC4729_January 2017 Risk.xlsx\",\"UniqueFileName\":\"S29170720180611.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S29170720180611.xlsx\",\"Filesize\":25335,\"Path\":null,\"size\":25335,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false,\"isValidFileSize\":true},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordPage.refreshUploadedFile();
		Report.LogInfo("StepCheck", "Steps 8, 9 completed", "PASS");

		//Step 10
		BordPage.navigateToDATATab();
		Report.LogInfo("StepCheck", "Steps 10 completed", "PASS");

		//Step 11
		BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
		if(isVisible(BordPage.ReviewBtn)==true){
			AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
			ReviewToApprvdStatus();
			BordPage.refreshUploadedFileForApproved();
			Report.LogInfo("StepCheck", "Steps 12,13,14 completed", "PASS");
			
			//Step 15
			BordPage.navigateToDATATab();
			String Janavl = "@xpath=//tr[1]//td[text()='1,500.00']";
			String JanTotalVal = "@xpath=//tr[2]//td//span[text()='1,500.00']";
			verifyExists(Janavl,"Jan month value");
			Jan_V =  getTextFrom(Janavl);
			Report.LogInfo("Jan month value", Jan_V, "PASS");
			verifyExists(JanTotalVal,"Jan month total value");
			Jan_T =  getTextFrom(JanTotalVal);
			Report.LogInfo("Jan month total value", Jan_T, "PASS");
			Report.LogInfo("StepCheck", "Steps 15 completed", "PASS");
			

			//Step 16
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			Report.LogInfo("StepCheck", "Steps 16 completed", "PASS");

			//Step 17
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4729PathScnd = fpath+"\\src\\test\\resources\\testdata\\Jan2017Premium_TC4729.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4729PathScnd);
			
			String Ufname1 = "S49391720181003.xlsx";	
			int size1 = 18397;
			String BordreauID1 = "93a517f5-4051-4698-90db-0f5d9a808b20";
	        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
	        String ID1 = extractIDFromResponseinsideContract(response1); 
	        String payload1 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 1 , "2", 2018);
	        addAsDraft(payload1,DraftUrl);
	        
			//String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan2017Premium_TC4729.xlsx\",\"UniqueFileName\":\"S10635720180611.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10635720180611.xlsx\",\"Filesize\":18406,\"Path\":null,\"size\":18406,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 17 completed", "PASS");

			//step 18
			if(isVisible(BordPage.ReviewBtn)==true){
				AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
				ReviewToApprvdStatus();
				BordPage.refreshUploadedFileForApprovedScndRw();
				Report.LogInfo("StepCheck", "Steps 19,20,21 completed", "PASS");
				
				//Step 22
				BordPage.navigateToDATATab();
				String Janavl1 = "@xpath=//tr[1]//td[text()='1,000.00']";
				String JanTotalVal1 = "@xpath=//tr[2]//td//span[text()='1,000.00']";
				verifyExists(Janavl1,"Jan month value");
				Jan_V1 =  getTextFrom(Janavl1);
				Report.LogInfo("Jan month value", Jan_V1, "PASS");
				verifyExists(JanTotalVal1,"Jan month total value");
				Jan_T1 =  getTextFrom(JanTotalVal1);
				Report.LogInfo("Jan month value", Jan_T1, "PASS");
				Report.LogInfo("StepCheck", "Steps 22 completed", "PASS");

				//Step 23
				BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
				Report.LogInfo("StepCheck", "Steps 23 completed", "PASS");

				//Step 24
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4729PathThird = fpath+"\\src\\test\\resources\\testdata\\Jan2017-Claim_TC4729Third.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile2 = new File(sheet4729PathThird);
				
				String Ufname2 = "S69583720181003.xlsx";	
				int size2 = 17191;
				String BordreauID2 = "2d8e32db-3e06-4cc2-9f87-174fe7ba4066";
		        String response2 = uploadFileinContract(ReqUrl,excelFile2,contractId,Ufname2);
		        String ID2 = extractIDFromResponseinsideContract(response2); 
		        String payload2 = GeneratePayloadForContract(contractId, BordreauID2, ID2, Ufname2, size2, 1 , "3", 2018);
		        addAsDraft(payload2,DraftUrl);
		        
				//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":1,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Jan2017-Claim_TC4729Third.xlsx\",\"UniqueFileName\":\"S24258220180612.xlsx\",\"BordereauFormatId\":\"2d8e32db-3e06-4cc2-9f87-174fe7ba4066\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S24258220180612.xlsx\",\"Filesize\":17179,\"Path\":null,\"size\":17179,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
				BordPage.refreshUploadedFile();
				Report.LogInfo("StepCheck", "Steps 24 completed", "PASS");

				//step 25
				if(isVisible(BordPage.ReviewBtn)==true){
					AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
					ReviewToApprvdStatus();
					BordPage.refreshUploadedFileForApprovedScndRw();
					Report.LogInfo("StepCheck", "Steps 26,27,28 completed", "PASS");
					
					//Step 29
					BordPage.navigateToDATATab();
					String Incurred1 = "@xpath=//tr[1]//td[text()='900.00']";
					String Incurred2 = "@xpath=//tr[2]//td//span[text()='900.00']";
					//String Incurred3 = "@xpath=//tr[3]//td[text()='820.41']";
					String Incurred4 = "@xpath=//tr[4]//td//span[text()='900.00']";

					verifyExists(Incurred1,"Incured value");
					Incure1 =  getTextFrom(Incurred1);
					Report.LogInfo("Incured", Incure1, "PASS");
					verifyExists(Incurred2,"Incured value");
					Incure2 =  getTextFrom(Incurred2);
					Report.LogInfo("Incured", Incure2, "PASS");
					//verifyExists(Incurred3,"Incured value");
					verifyExists(Incurred4,"Incured value");
					Incure4 =  getTextFrom(Incurred4);
					Report.LogInfo("Incured", Incure4, "PASS");

					String WrittnGrossP1 = "@xpath=//tr[1]//td[text()='66.67%']";
					String WrittnGrossP2 = "@xpath=//tr[2]//td//span[text()='60.00%']";
					//String WrittnGrossP3 = "@xpath=//tr[3]//td[text()='91.10%']";
					String WrittnGrossP4 = "@xpath=//tr[4]//td//span[text()='60.00%']";

					verifyExists(WrittnGrossP1,"Written gross premium value");
					WG1 =  getTextFrom(WrittnGrossP1);
					Report.LogInfo("Written gross premium value", WG1, "PASS");
					verifyExists(WrittnGrossP2,"Written gross premium value");
					WG2 =  getTextFrom(WrittnGrossP2);
					Report.LogInfo("Written gross premium value", WG2, "PASS");
					//verifyExists(WrittnGrossP3,"Written gross premium value");
					verifyExists(WrittnGrossP4,"Written gross premium value");
					WG3 =  getTextFrom(WrittnGrossP4);
					Report.LogInfo("Written gross premium value", WG3, "PASS");

					Report.LogInfo("StepCheck", "Steps 29 completed", "PASS");

					//Step 30, 31, 32
					String ref = "BB";
					String BrockrageVal = "5";
					String ClassBval = "Cyber";
					String currencyVal = "USD - United States Dollar";
					String EPermiumIncome1 = "5";
					String GPermiumIncome1 = "3";
					String GPermiumLimit1 = "2";
					String ConductRiskRatingValue1 = "Medium";

					policy.addSection2(ref, BrockrageVal, ClassBval, currencyVal, EPermiumIncome1, GPermiumIncome1, GPermiumLimit1, ConductRiskRatingValue1);
					Report.LogInfo("StepCheck", "Steps 30, 31, 32 completed", "PASS");

					//Step 33, 34, 35
					String RiskCode1 = "1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY";
					policy.navigateToRiskCodesTabOnSection();
					policy.addRiskCodesOnSection(RiskCode1);
					Report.LogInfo("StepCheck", "Steps 33, 34, 35 completed", "PASS");

					//Step 36
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 36 completed", "PASS");

					//Step 37
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4729PathFourth = fpath+"\\src\\test\\resources\\testdata\\MArch2017 Risk_TC4729Fourth.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile3 = new File(sheet4729PathFourth);
					
					String Ufname3 = "S22469520181003.xlsx";	
					int size3 = 25048;
					String BordreauID3 = "0402b2e4-591d-4179-b539-fbed0dbefca2";
			        String response3 = uploadFileinContract(ReqUrl,excelFile3,contractId,Ufname3);
			        String ID3 = extractIDFromResponseinsideContract(response3); 
			        String payload3 = GeneratePayloadForContract(contractId, BordreauID3, ID3, Ufname3, size3, 3 , "1", 2018);
			        addAsDraft(payload3,DraftUrl);
			        
					//String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"MArch2017 Risk_TC4729Fourth.xlsx\",\"UniqueFileName\":\"S67207520180612.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S67207520180612.xlsx\",\"Filesize\":25047,\"Path\":null,\"size\":25047,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					//uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 37 completed", "PASS");

					//Step 38
					String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
					String YesBtn = "@xpath=.//*[@value='true']";
					if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
					{	
						Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
						//Step 39
						if(isVisible(ErrorScreen)== true){							
							if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
								javaScriptclick(YesBtn,"Yes button");
								verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								sleep(3000);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 39 completed", "PASS");
							}else{
								goBack();
							}
						}
						//step 40
						if(isVisible(BordPage.ReviewBtn)==true){
							AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
							ReviewtoApprd1();		
							BordPage.refreshUploadedFileForApproved();
							Report.LogInfo("StepCheck", "Steps 41,42,43 completed", "PASS");
							
							//Step 44
							BordPage.navigateToDATATab();
							String WGP1 = "@xpath=//tr[1]//td[text()='3,000.00']";
							String WGP2 = "@xpath=//tr[2]//td//span[text()='3,000.00']";

							verifyExists(WGP1,"Writtent gross premium value");
							GP1 =  getTextFrom(WGP1);
							Report.LogInfo("Written gross premium value", GP1, "PASS");
							verifyExists(WGP2,"Writtent gross premium value");
							GP2 =  getTextFrom(WGP2);
							Report.LogInfo("Written gross premium value", GP2, "PASS");
							Report.LogInfo("StepCheck", "Steps 44 completed", "PASS");

							//Step 45
							BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
							Report.LogInfo("StepCheck", "Steps 45 completed", "PASS");

							//Step 46
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4729PathFifth = fpath+"\\src\\test\\resources\\testdata\\March2017Premium_TC4729Fifth.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile4 = new File(sheet4729PathFifth);
							
							String Ufname4 = "S69901020181003.xlsx";	
							int size4 = 18369;
							String BordreauID4 = "93a517f5-4051-4698-90db-0f5d9a808b20";
					        String response4 = uploadFileinContract(ReqUrl,excelFile4,contractId,Ufname4);
					        String ID4 = extractIDFromResponseinsideContract(response4); 
					        String payload4 = GeneratePayloadForContract(contractId, BordreauID4, ID4, Ufname4, size4, 3 , "2", 2018);
					        addAsDraft(payload4,DraftUrl);
					        
							//String payload4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Premium_TC4729Fifth.xlsx\",\"UniqueFileName\":\"S93899620180612.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S93899620180612.xlsx\",\"Filesize\":18369,\"Path\":null,\"size\":18369,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							//uploadFile(ReqUrl, excelFile4, payload4, DraftUrl);
							BordPage.refreshUploadedFile();
							Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

							//Step 47
							if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
							{	
								Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
								//Step 48
								if(isVisible(ErrorScreen)== true){							
									if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
										javaScriptclick(YesBtn,"Yes button");
										verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										sleep(3000);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 48 completed", "PASS");
									}else{
										goBack();
									}
								}
								//step 49
								if(isVisible(BordPage.ReviewBtn)==true){
									AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
									ReviewtoApprd1();
									BordPage.refreshUploadedFileForApproved();
									//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
									Report.LogInfo("StepCheck", "Steps 50,51,52 completed", "PASS");
									
									//Step 53
									BordPage.navigateToDATATab();
									String WGP3 = "@xpath=//tr[1]//td[text()='4,500.00']";
									String WGP4 = "@xpath=//tr[2]//td//span[text()='4,500.00']";

									verifyExists(WGP3,"Writtent gross premium value");
									GP3 =  getTextFrom(WGP3);
									Report.LogInfo("Written gross premium value", GP3, "PASS");
									verifyExists(WGP4,"Writtent gross premium value");
									GP4 =  getTextFrom(WGP3);
									Report.LogInfo("Written gross premium value", GP4, "PASS");
									Report.LogInfo("StepCheck", "Steps 53 completed", "PASS");

									//Step 54
									BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
									Report.LogInfo("StepCheck", "Steps 54 completed", "PASS");

									//Step 55
									try 
									{
										String fpath = new File(".").getCanonicalPath();
										sheet4729PathSixth = fpath+"\\src\\test\\resources\\testdata\\March2017Claim_TC4729Sixth.xlsx";
									} 
									catch (IOException e) 
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									File excelFile5 = new File(sheet4729PathSixth);
									
									String Ufname5 = "S67918020181003.xlsx";	
									int size5 = 17861;
									String BordreauID5 = "2d8e32db-3e06-4cc2-9f87-174fe7ba4066";
							        String response5 = uploadFileinContract(ReqUrl,excelFile5,contractId,Ufname5);
							        String ID5 = extractIDFromResponseinsideContract(response5); 
							        String payload5 = GeneratePayloadForContract(contractId, BordreauID5, ID5, Ufname5, size5, 3 , "3", 2018);
							        addAsDraft(payload5,DraftUrl);
							        
									//String payload5 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Claim_TC4729Sixth.xlsx\",\"UniqueFileName\":\"S21769620180612.xlsx\",\"BordereauFormatId\":\"2d8e32db-3e06-4cc2-9f87-174fe7ba4066\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S21769620180612.xlsx\",\"Filesize\":17860,\"Path\":null,\"size\":17860,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
									//uploadFile(ReqUrl, excelFile5, payload5, DraftUrl);
									BordPage.refreshUploadedFile();
									Report.LogInfo("StepCheck", "Steps 55 completed", "PASS");


									//Step 56

									if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
									{	
										Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
										//Step 57
										if(isVisible(ErrorScreen)== true){							
											if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
												javaScriptclick(YesBtn,"Yes button");
												verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
												javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
												sleep(3000);
												BordPage.refreshUploadedFile();
												Report.LogInfo("StepCheck", "Steps 57 completed", "PASS");
											}else{
												goBack();
											}
										}
										//step 58
										if(isVisible(BordPage.ReviewBtn)==true){
										AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
										ReviewtoApprd1();
											BordPage.refreshUploadedFileForApproved();
											Report.LogInfo("StepCheck", "Steps 61 completed", "PASS");
											
											
											Report.LogInfo("StepCheck", "Steps 59,60,61 completed", "PASS");
											
											//Step 62
											BordPage.navigateToDATATab();
											
											String WGP_5 = "@xpath=//tr[1]//td[text()='150.00%']";
											
											verifyExists(WGP_5,"Writtent gross premium value");
											GP5 =  getTextFrom(WGP_5);
											Report.LogInfo("Written gross premium value", GP5, "PASS");
											
											
											String ShwFigrbtn = "@xpath=.//label[@class='ts-helper']";

											verifyExists(ShwFigrbtn,"Show Cumulative Figures");
											click(ShwFigrbtn,"Show Cumulative Figures");
											sleep(1000);
											Report.LogInfo("StepCheck", "Steps 62, 63 completed", "PASS");
										}else{
											Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
											//ApplyDueDateFilter(DueDate, Valuedate);
											BordPage.deleteBorderEAUX();
										}	
									}else
									{
										Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
										BordPage.deleteBorderEAUX();
									}	
								}else{
									Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}	
							}else
							{
								Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
								BordPage.deleteBorderEAUX();
							}
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}						
					}else
					{
						Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
						BordPage.deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
				BordPage.deleteBorderEAUX();
			}			
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			BordPage.deleteBorderEAUX();		
		}		
	}
	
	
	//TC 4745 :- Contract Data Summary-Quartely Reporting
	public void ConDataSumQuaterlyReporting_4745() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();

		String subSheet = "Automation Risk format 11 (Lloyd's Property Schema)";
		String subSheet1 = "Automation Company Admin 1 Premium Format 1 (Lloyd's Premium Property schema)";
		String subSheet2 = "Automation Claim Format 5 (Lloyd's Claim Property schema)";		
		String IncDate = "01/01/2018";
		String ExpDate="31/12/2018";
		String Type = "Risk";
		String freqVal = "Quarterly";		
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		//contractId = ReturnContractID();
		//Step 1
		policy.CreateContractwithInceptionDate2018();
		
		Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

		//Step 2, 3, 4
		String type1 = "Premium";
		String FreqVal1 = "Quarterly";
		policy.navigateToReportingChannelsTab();		
		policy.EditRiskQuarterly(FreqVal1);
		
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb(type1,FreqVal1);		
		Report.LogInfo("StepCheck", "Steps 2,3,4 completed", "PASS");

		//Step 5, 6, 7
		String type2 = "Claim";
		policy.navigateToReportingChannelsTab();
		policy.addReportingChannelForAnyComb(type2,FreqVal1);
		Report.LogInfo("StepCheck", "Steps 5, 6, 7 completed", "PASS");

		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload_1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		//Step 9, 10
		BordPage.SubmitBordereaux(IncDate);		

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet4745Path = fpath+"\\src\\test\\resources\\testdata\\February 2017 Risk_TC4745First.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet4745Path);
		contractId = addNewBordereauFormatPolicy(payload_1, GetData);
		
		String Ufname = "S71710820181003.xlsx";	
		int size = 18130;
		String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
        String ID = extractIDFromResponseinsideContract(response); 
        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 2 , "1", 2018);
        addAsDraft(payload,DraftUrl);
        
		//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017 Risk_TC4745First.xlsx\",\"UniqueFileName\":\"S98616820180612.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S98616820180612.xlsx\",\"Filesize\":18126,\"Path\":null,\"size\":18126,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
		//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
		BordPage.refreshUploadedFile();
		Report.LogInfo("StepCheck", "Steps 8, 9 completed", "PASS");

		//Step 10
		BordPage.navigateToDATATab();
		Report.LogInfo("StepCheck", "Steps 10 completed", "PASS");

		//Step 11
		BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
		if(isVisible(BordPage.ReviewBtn)==true){
			AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
			ReviewToApprvdStatus();
			BordPage.refreshUploadedFileForApproved();
			Report.LogInfo("StepCheck", "Steps 12,13,14 completed", "PASS");
			
			//Step 15
			BordPage.navigateToDATATab();
			String Janavl = "@xpath=//tr[1]//td[text()='200.00']";
			String JanTotalVal = "@xpath=//tr[2]//td//span[text()='200.00']";
			verifyExists(Janavl,"Match month value");
			Jan_V =  getTextFrom(Janavl);
			Report.LogInfo("Match month value", Jan_V, "PASS");
			verifyExists(JanTotalVal,"Match month total value");
			Jan_T =  getTextFrom(Janavl);
			Report.LogInfo("Match month value", Jan_T, "PASS");
			Report.LogInfo("StepCheck", "Steps 15 completed", "PASS");

			//Step 16
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			Report.LogInfo("StepCheck", "Steps 16 completed", "PASS");

			//Step 17
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4745PathScnd = fpath+"\\src\\test\\resources\\testdata\\February2017Premium_TC4745Secnd.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4745PathScnd);
			
			String Ufname1 = "S72621920181003.xlsx";	
			int size1 = 18186;
			String BordreauID1 = "93a517f5-4051-4698-90db-0f5d9a808b20";
	        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
	        String ID1 = extractIDFromResponseinsideContract(response1); 
	        String payload1 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 2 , "2", 2018);
	        addAsDraft(payload1,DraftUrl);
	        
			//String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017Premium_TC4745Secnd.xlsx\",\"UniqueFileName\":\"S89834420180612.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S89834420180612.xlsx\",\"Filesize\":18184,\"Path\":null,\"size\":18184,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 17 completed", "PASS");

			//step 18
			if(isVisible(BordPage.ReviewBtn)==true){
				AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
				ReviewToApprvdStatus();
				BordPage.refreshUploadedFileForApprovedScndRw();
				Report.LogInfo("StepCheck", "Steps 19,20,21 completed", "PASS");
				
				//Step 22
				BordPage.navigateToDATATab();
				String Janavl1 = "@xpath=//tr[1]//td[text()='400.00']";
				String JanTotalVal1 = "@xpath=//tr[2]//td//span[text()='400.00']";
				verifyExists(Janavl1,"March month value");
				Jan_V1 =  getTextFrom(Janavl1);
				Report.LogInfo("March month value", Jan_V1, "PASS");
				verifyExists(JanTotalVal1,"March month total value");
				Jan_T1 =  getTextFrom(JanTotalVal1);
				Report.LogInfo("March month value", Jan_T1, "PASS");
				Report.LogInfo("StepCheck", "Steps 22 completed", "PASS");

				//Step 23
				BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
				Report.LogInfo("StepCheck", "Steps 23 completed", "PASS");

				//Step 24
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4745PathThird = fpath+"\\src\\test\\resources\\testdata\\February2017-Claim_TC4745Third.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile2 = new File(sheet4745PathThird);
				
				String Ufname2 = "S50016020181003.xlsx";	
				int size2 = 17776;
				String BordreauID2 = "2d8e32db-3e06-4cc2-9f87-174fe7ba4066";
		        String response2 = uploadFileinContract(ReqUrl,excelFile2,contractId,Ufname2);
		        String ID2 = extractIDFromResponseinsideContract(response2); 
		        String payload2 = GeneratePayloadForContract(contractId, BordreauID2, ID2, Ufname2, size2, 2 , "3", 2018);
		        addAsDraft(payload2,DraftUrl);
		        
				//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017-Claim_TC4745Third.xlsx\",\"UniqueFileName\":\"S89273820180612.xlsx\",\"BordereauFormatId\":\"2d8e32db-3e06-4cc2-9f87-174fe7ba4066\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S89273820180612.xlsx\",\"Filesize\":17776,\"Path\":null,\"size\":17776,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
				BordPage.refreshUploadedFile();
				Report.LogInfo("StepCheck", "Steps 24 completed", "PASS");

				//step 25
				if(isVisible(BordPage.ReviewBtn)==true){
					AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
					ReviewToApprvdStatus();
					BordPage.refreshUploadedFileForApprovedScndRw();
					Report.LogInfo("StepCheck", "Steps 26,27,28 completed", "PASS");
					
					//Step 29
					BordPage.navigateToDATATab();
					String Incurred1 = "@xpath=//tr[1]//td[text()='900.00']";
					String Incurred2 = "@xpath=//tr[2]//td//span[text()='900.00']";
					
					verifyExists(Incurred1,"Incured value");
					Incure1 =  getTextFrom(Incurred1);
					Report.LogInfo("Incured value", Incure1, "PASS");
					verifyExists(Incurred2,"Incured value");
					Incure2 =  getTextFrom(Incurred2);
					Report.LogInfo("Incured value", Incure2, "PASS");
					
					String WrittnGrossP1 = "@xpath=//tr[1]//td[text()='450.00%']";
					String WrittnGrossP2 = "@xpath=//tr[2]//td//span[text()='450.00%']";
					
					verifyExists(WrittnGrossP1,"Written gross premium value");
					WG1 =  getTextFrom(WrittnGrossP1);
					Report.LogInfo("Written gross premium value", WG1, "PASS");
					verifyExists(WrittnGrossP2,"Written gross premium value");
					WG2 =  getTextFrom(WrittnGrossP2);
					Report.LogInfo("Written gross premium value", WG2, "PASS");
					
					Report.LogInfo("StepCheck", "Steps 29 completed", "PASS");
			
					//Step 30
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 36 completed", "PASS");

					//Step 31
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4745PathFourth = fpath+"\\src\\test\\resources\\testdata\\MArch2017 Risk_TC4745Fourth.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile3 = new File(sheet4745PathFourth);
					
					String Ufname3 = "S83206020181003.xlsx";	
					int size3 = 18070;
					String BordreauID3 = "0402b2e4-591d-4179-b539-fbed0dbefca2";
			        String response3 = uploadFileinContract(ReqUrl,excelFile3,contractId,Ufname3);
			        String ID3 = extractIDFromResponseinsideContract(response3); 
			        String payload3 = GeneratePayloadForContract(contractId, BordreauID3, ID3, Ufname3, size3, 3 , "1", 2018);
			        addAsDraft(payload3,DraftUrl);
			        
					//String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"MArch2017 Risk_TC4745Fourth.xlsx\",\"UniqueFileName\":\"S62011020180612.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S62011020180612.xlsx\",\"Filesize\":18069,\"Path\":null,\"size\":18069,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					//uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 31 completed", "PASS");

					//Step 32
					String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
					if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
					{	
						Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
						//Step 33
						if(isVisible(ErrorScreen)== true){							
							if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
								verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
								javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
								sleep(3000);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 33 completed", "PASS");
							}else{
								goBack();
							}
						}
						//step 34
						if(isVisible(BordPage.ReviewBtn)==true){
							AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
							ReviewToApprvdStatus();
							BordPage.refreshUploadedFileForApproved();
							Report.LogInfo("StepCheck", "Steps 34,35,36,37 completed", "PASS");
							
							//Step 38
							BordPage.navigateToDATATab();
							String WGP1 = "@xpath=//tr[1]//td[text()='1,200.00']";
							String WGP2 = "@xpath=//tr[2]//td//span[text()='1,200.00']";

							verifyExists(WGP1,"Writtent gross premium value");
							GP1 =  getTextFrom(WGP1);
							Report.LogInfo("Writtent gross premium value", GP1, "PASS");
							verifyExists(WGP2,"Writtent gross premium value");
							GP2 =  getTextFrom(WGP2);
							Report.LogInfo("Writtent gross premium value", GP2, "PASS");
							Report.LogInfo("StepCheck", "Steps 38 completed", "PASS");

							//Step 39
							BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
							Report.LogInfo("StepCheck", "Steps 39 completed", "PASS");

							//Step 40
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4745PathFifth = fpath+"\\src\\test\\resources\\testdata\\March2017Premium_TC4745Fifth.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile4 = new File(sheet4745PathFifth);
							
							String Ufname4 = "S82434220181003.xlsx";	
							int size4 = 18150;
							String BordreauID4 = "93a517f5-4051-4698-90db-0f5d9a808b20";
					        String response4 = uploadFileinContract(ReqUrl,excelFile4,contractId,Ufname4);
					        String ID4 = extractIDFromResponseinsideContract(response4); 
					        String payload4 = GeneratePayloadForContract(contractId, BordreauID4, ID4, Ufname4, size4, 3 , "2", 2018);
					        addAsDraft(payload4,DraftUrl);
					        
							//String payload4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Premium_TC4745Fifth.xlsx\",\"UniqueFileName\":\"S72789920180612.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S72789920180612.xlsx\",\"Filesize\":18144,\"Path\":null,\"size\":18144,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							//uploadFile(ReqUrl, excelFile4, payload4, DraftUrl);
							BordPage.refreshUploadedFile();
							Report.LogInfo("StepCheck", "Steps 40 completed", "PASS");

							//Step 41
							if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
							{	
								Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
								//Step 42
								if(isVisible(ErrorScreen)== true){							
									if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
										//javaScriptclick(YesBtn,"Yes button");
										verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
										javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
										sleep(3000);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 41,42 completed", "PASS");
									}else{
										goBack();
									}
								}
								//step 43
								if(isVisible(BordPage.ReviewBtn)==true){
									AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
									ReviewToApprvdStatus();
									BordPage.refreshUploadedFileForApproved();
									//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
									Report.LogInfo("StepCheck", "Steps 43,44,45 completed", "PASS");
									
									//Step 46
									BordPage.navigateToDATATab();
									String WGP3 = "@xpath=//tr[1]//td[text()='1,900.00']";
									String WGP4 = "@xpath=//tr[2]//td//span[text()='1,900.00']";

									verifyExists(WGP3,"Writtent gross premium value");
									GP3 =  getTextFrom(WGP3);
									Report.LogInfo("Writtent gross premium value", GP3, "PASS");
									verifyExists(WGP4,"Writtent gross premium value");
									GP4 =  getTextFrom(WGP4);
									Report.LogInfo("Writtent gross premium value", GP4, "PASS");
									Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

									//Step 47
									BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
									Report.LogInfo("StepCheck", "Steps 47 completed", "PASS");

									//Step 48
									try 
									{
										String fpath = new File(".").getCanonicalPath();
										sheet4745PathSixth = fpath+"\\src\\test\\resources\\testdata\\March2017Cliam_TC4745Sixth.xlsx";
									} 
									catch (IOException e) 
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									File excelFile5 = new File(sheet4745PathSixth);
									
									String Ufname5 = "S25810420181003.xlsx";	
									int size5 = 17838;
									String BordreauID5 = "2d8e32db-3e06-4cc2-9f87-174fe7ba4066";
							        String response5 = uploadFileinContract(ReqUrl,excelFile5,contractId,Ufname5);
							        String ID5 = extractIDFromResponseinsideContract(response5); 
							        String payload5 = GeneratePayloadForContract(contractId, BordreauID5, ID5, Ufname5, size5, 3 , "3", 2018);
							        addAsDraft(payload5,DraftUrl);
							        
									//String payload5 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":3,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"March2017Cliam_TC4745Sixth.xlsx\",\"UniqueFileName\":\"S99622420180613.xlsx\",\"BordereauFormatId\":\"2d8e32db-3e06-4cc2-9f87-174fe7ba4066\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S99622420180613.xlsx\",\"Filesize\":17838,\"Path\":null,\"size\":17838,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
									//uploadFile(ReqUrl, excelFile5, payload5, DraftUrl);
									BordPage.refreshUploadedFile();
									Report.LogInfo("StepCheck", "Steps 48 completed", "PASS");


									//Step 49

									if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
									{	
										Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
										//Step 50
										if(isVisible(ErrorScreen)== true){							
											if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
												//javaScriptclick(YesBtn,"Yes button");
												verifyMustExists(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
												javaScriptclick(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
												sleep(3000);
												BordPage.refreshUploadedFile();
												Report.LogInfo("StepCheck", "Steps 50 completed", "PASS");
											}else{
												goBack();
											}
										}
										//step 51
										if(isVisible(BordPage.ReviewBtn)==true){
											AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
											ReviewToApprvdStatus();
											BordPage.refreshUploadedFileForApproved();
											Report.LogInfo("StepCheck", "Steps 51,52,53,54 completed", "PASS");
											
											//Step 55
											BordPage.navigateToDATATab();
											String Incurred5 = "@xpath=//tr[1]//td[text()='1,800.00']";
											String Incurred6 = "@xpath=//tr[2]//td//span[text()='1,800.00']";
											
											verifyExists(Incurred5,"Incured value");
											Incure3 =  getTextFrom(Incurred5);
											Report.LogInfo("Incured value", Incure3, "PASS");
											verifyExists(Incurred6,"Incured value");
											Incure4 =  getTextFrom(Incurred6);
											Report.LogInfo("Incured value", Incure4, "PASS");
											sleep(1000);
											Report.LogInfo("StepCheck", "Steps 55 completed", "PASS");
											
											//Step 56, 57, 58
											String ref = "BB";
											String BrockrageVal = "5";
											String ClassBval = "Property D&F (non-US binder)";
											String currencyVal = "USD - United States Dollar";
											String EPermiumIncome1 = "5";
											String GPermiumIncome1 = "3";
											String GPermiumLimit1 = "2";
											String ConductRiskRatingValue1 = "Low";

											policy.addSection2(ref, BrockrageVal, ClassBval, currencyVal, EPermiumIncome1, GPermiumIncome1, GPermiumLimit1, ConductRiskRatingValue1);
											Report.LogInfo("StepCheck", "Steps 56, 57, 58 completed", "PASS");

											//Step 59, 60, 61
											String RiskCode1 = "1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY";
											String per1 = "40";
											policy.navigateToRiskCodesTabOnSection();
											policy.addRiskCodesOnSection(RiskCode1,per1);
											Report.LogInfo("StepCheck", "Steps 59, 60, 61 completed", "PASS");

											sleep(2000);
											//Step 62, 63, 64
											String per2 = "60";
											policy.navigateToRiskCodesTabOnSection();
											policy.addRiskCodesOnSection(RiskCode1,per2);
											Report.LogInfo("StepCheck", "Steps 62, 63, 64 completed", "PASS");
									
										}else{
											Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
											//ApplyDueDateFilter(DueDate, Valuedate);
											BordPage.deleteBorderEAUX();
										}	
									}else
									{
										Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
										BordPage.deleteBorderEAUX();
									}	
								}else{
									Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}	
							}else
							{
								Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
								BordPage.deleteBorderEAUX();
							}
						}else{
							Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}						
					}else
					{
						Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
						BordPage.deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
				BordPage.deleteBorderEAUX();
			}			
		}else{
			Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
			BordPage.deleteBorderEAUX();		
		}		
	}

	//TC 4839 :- Contract Data Summary-Quartely Reporting
		public void ConDataSumQuaterlyNil_4839() throws Exception
		{
			BordereauProcessPage BordPage = new BordereauProcessPage();

			String subSheet = "Automation Risk format 11 (Lloyd's Property Schema)";
			String subSheet1 = "Automation Company Admin 1 Premium Format 1 (Lloyd's Premium Property schema)";
			String subSheet2 = "Automation Claim Format 5 (Lloyd's Claim Property schema)";
			String IncDate = "01/01/2018";
			String ExpDate="31/12/2018";
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			BordPage.applyFilterPolicy(policy.PolicyNumber);
			//BordPage.applyFilterPolicy("159029HF");
			BordPage.openSelectedPolicy();
			contractId = ReturnContractID();
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload_1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			
			//Step 3
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			Report.LogInfo("StepCheck", "Steps 2 completed", "PASS");
			
			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4839Path = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017 Risk_TC4839First.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile1 = new File(sheet4839Path);
			contractId = addNewBordereauFormatPolicy(payload_1, GetData);
			
			String Ufname = "S33929920181003.xlsx";	
			int size = 24979;
			String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
	        String response = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 9 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017 Risk_TC4839First.xlsx\",\"UniqueFileName\":\"S15846020180613.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S15846020180613.xlsx\",\"Filesize\":24964,\"Path\":null,\"size\":24964,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 3 completed", "PASS");
			//Step 4
			if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
			{	
				Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
				//Step 5
				String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
				String YesBtn = "@xpath=.//*[@value='true']";

				if(isVisible(ErrorScreen)== true){							
					if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
						javaScriptclick(YesBtn,"Yes button");
						verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
						javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
						sleep(3000);
						BordPage.refreshUploadedFile();
						Report.LogInfo("StepCheck", "Steps 4,5 completed", "PASS");
					}else{
						goBack();
					}
				}
				//step 6,7,8,9,10
				if(isVisible(BordPage.ReviewBtn)==true){
					AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
					ReviewtoApprd2();
					BordPage.refreshUploadedFileForApproved();
					//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
					Report.LogInfo("StepCheck", "Steps 6,7,8,9,10 completed", "PASS");
					
					//Step 11
					BordPage.navigateToDATATab();
					String WGP3 = "@xpath=//tr[1]//td[text()='500.00']";
					String WGP4 = "@xpath=//tr[2]//td//span[text()='500.00']";

					verifyExists(WGP3,"Writtent gross premium value");
					WG2 =  getTextFrom(WGP3);
					Report.LogInfo("Writtent gross premium value", WG2, "PASS");
					verifyExists(WGP4,"Writtent gross premium value");
					WG3 =  getTextFrom(WGP4);
					Report.LogInfo("Writtent gross premium value", WG3, "PASS");
					Report.LogInfo("StepCheck", "Steps 11 completed", "PASS");
					
					//step 12
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 12 completed", "PASS");
										
					//Step 13
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4839PathSecnd = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017Premium_TC4839Secnd.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile2 = new File(sheet4839PathSecnd);
					
					String Ufname2 = "S83469020181003.xlsx";	
					int size2 = 18465;
					String BordreauID2 = "93a517f5-4051-4698-90db-0f5d9a808b20";
			        String response2 = uploadFileinContract(ReqUrl,excelFile2,contractId,Ufname2);
			        String ID2 = extractIDFromResponseinsideContract(response2); 
			        String payload2 = GeneratePayloadForContract(contractId, BordreauID2, ID2, Ufname2, size2, 9 , "2", 2018);
			        addAsDraft(payload2,DraftUrl);
			        
					//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017Premium_TC4839Secnd.xlsx\",\"UniqueFileName\":\"S10591520180613.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S10591520180613.xlsx\",\"Filesize\":18465,\"Path\":null,\"size\":18465,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					//uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 13 completed", "PASS");

					//Step 14
					if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
					{	
						Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
						//Step 15
						//String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
						//String YesBtn = "@xpath=.//*[@value='true']";

						if(isVisible(ErrorScreen)== true){							
							if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
								javaScriptclick(YesBtn,"Yes button");
								verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
								sleep(3000);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 14,15 completed", "PASS");
							}else{
								goBack();
							}
						}
						//step 16,17,18,19,20
						if(isVisible(BordPage.ReviewBtn)==true){
							AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
							ReviewtoApprd2();
							BordPage.refreshUploadedFileForApproved();
							//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
							Report.LogInfo("StepCheck", "Steps 16,17,18,19,20 completed", "PASS");
							
							//Step 21
							BordPage.navigateToDATATab();
							String WGP5 = "@xpath=//tr[1]//td[text()='1,000.00']";
							String WGP6 = "@xpath=//tr[2]//td//span[text()='1,000.00']";

							verifyExists(WGP5,"Writtent gross premium value");
							GP1 =  getTextFrom(WGP5);
							Report.LogInfo("Writtent gross premium value", GP1, "PASS");
							verifyExists(WGP6,"Writtent gross premium value");
							GP2 =  getTextFrom(WGP6);
							Report.LogInfo("Writtent gross premium value", GP2, "PASS");
							Report.LogInfo("StepCheck", "Steps 21 completed", "PASS");
							//****************************************************
							
							//step 22
							BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
							Report.LogInfo("StepCheck", "Steps 22 completed", "PASS");
												
							//Step 23
							try 
							{
								String fpath = new File(".").getCanonicalPath();
								sheet4839Paththird = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017-Claim_TC4839Third.xlsx";
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							File excelFile3 = new File(sheet4839Paththird);
							
							String Ufname3 = "S48632320181003.xlsx";	
							int size3 = 17806;
							String BordreauID3 = "2d8e32db-3e06-4cc2-9f87-174fe7ba4066";
					        String response3 = uploadFileinContract(ReqUrl,excelFile3,contractId,Ufname3);
					        String ID3 = extractIDFromResponseinsideContract(response3); 
					        String payload3 = GeneratePayloadForContract(contractId, BordreauID3, ID3, Ufname3, size3, 9 , "3", 2018);
					        addAsDraft(payload3,DraftUrl);
					        
							//String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017-Claim_TC4839Third.xlsx\",\"UniqueFileName\":\"S43818820180613.xlsx\",\"BordereauFormatId\":\"2d8e32db-3e06-4cc2-9f87-174fe7ba4066\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S43818820180613.xlsx\",\"Filesize\":17789,\"Path\":null,\"size\":17789,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
							//uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
							BordPage.refreshUploadedFile();
							Report.LogInfo("StepCheck", "Steps 23 completed", "PASS");

							//Step 24
							if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
							{	
								Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
								//Step 15
								//String ErrorScreen = "@xpath=.//h2[text()='Missing Bordereau periods']";
								//String YesBtn = "@xpath=.//*[@value='true']";

								if(isVisible(ErrorScreen)== true){							
									if(isVisible(BordPage.ContinueProcessingBodrBtn)== true){
										javaScriptclick(YesBtn,"Yes button");
										verifyMustExists(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										javaScriptclick(BordPage.ContinueProcessingBodrBtn,"Continue Processing button");
										sleep(3000);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 24,25 completed", "PASS");
									}else{
										goBack();
									}
								}
								//step 26,27,28,29,30
								if(isVisible(BordPage.ReviewBtn)==true){
									AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
									ReviewtoApprd2();
									BordPage.refreshUploadedFileForApproved();
									//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
									Report.LogInfo("StepCheck", "Steps 26,27,28,29,30 completed", "PASS");
									
									//Step 31
									BordPage.navigateToDATATab();
									String WGP7 = "@xpath=//tr[1]//td[text()='1,200.00']";
									String WGP8 = "@xpath=//tr[2]//td//span[text()='1,200.00']";

									verifyExists(WGP7,"Writtent gross premium value");
									GP3 =  getTextFrom(WGP7);
									Report.LogInfo("Writtent gross premium value", GP3, "PASS");
									verifyExists(WGP8,"Writtent gross premium value");
									GP4 =  getTextFrom(WGP8);
									Report.LogInfo("Writtent gross premium value", GP4, "PASS");
									Report.LogInfo("StepCheck", "Steps 31 completed", "PASS");
									
									
								}else{
									Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}
							}else{
									Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
									BordPage.deleteBorderEAUX();
								}	
							
							//***************************************************
						}else{
							Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}
					}else{
							Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
							BordPage.deleteBorderEAUX();
						}	
					
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}
			}else{
					Report.LogInfo("ValidateReviewStatus", "Review error status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}

		}
		
	
		//TC 4757 :- Contract Data Summary-Annually Reporting
		public void ConDataSumAnnuallyReporting_4757() throws Exception
		{
			BordereauProcessPage BordPage = new BordereauProcessPage();

			String subSheet = "Automation Risk format 11 (Lloyd's Property Schema)";
			String subSheet1 = "Automation Company Admin 1 Premium Format 1 (Lloyd's Premium Property schema)";
			String subSheet2 = "Automation Claim Format 5 (Lloyd's Claim Property schema)";
			String IncDate = "01/01/2017";
			String ExpDate="31/12/2017";
			String Type = "Risk";
			String freqVal = "Annually";		
			String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
			//contractId = ReturnContractID();
			//Step 1
			policy.CreateContractwithInceptionDate2018();
			/*Br.applyFilterPolicy("701770RG");
			Br.openSelectedPolicy();*/
			
			Report.LogInfo("StepCheck", "Step 1 completed", "PASS");

			//Step 2, 3, 4
			String type1 = "Premium";
			String FreqVal1 = "Annually";
			policy.navigateToReportingChannelsTab();		
			policy.EditRiskQuarterly(FreqVal1);
			
			policy.navigateToReportingChannelsTab();
			policy.addReportingChannelForAnyComb(type1,FreqVal1);		
			Report.LogInfo("StepCheck", "Steps 2,3,4 completed", "PASS");

			//Step 5, 6, 7
			String type2 = "Claim";
			policy.navigateToReportingChannelsTab();
			policy.addReportingChannelForAnyComb(type2,FreqVal1);
			Report.LogInfo("StepCheck", "Steps 5, 6, 7 completed", "PASS");
			
	
			//Step 9, 10, 11
			String ref = "BB";
			String BrockrageVal = "5";
			String ClassBval = "Property D&F (non-US binder)";
			String currencyVal = "USD - United States Dollar";
			String EPermiumIncome1 = "5";
			String GPermiumIncome1 = "3";
			String GPermiumLimit1 = "2";
			String ConductRiskRatingValue1 = "Medium";

			policy.addSection2(ref, BrockrageVal, ClassBval, currencyVal, EPermiumIncome1, GPermiumIncome1, GPermiumLimit1, ConductRiskRatingValue1);
			Report.LogInfo("StepCheck", "Steps 9, 10, 11 completed", "PASS");
			
			//Step 12,13,14
			policy.navigateToMarketsTabOnSection();
			policy.addMarketOnSection();
			Report.LogInfo("StepCheck", "Steps 12,13,14 completed", "PASS");
			
			//Step 15,16,17
			String RiskCode1 = "1E - OVERSEAS LEG TERRORISM ENERGY OFFSHORE PROPERTY";
			String per1 = "40";
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection(RiskCode1,per1);
			Report.LogInfo("StepCheck", "Steps 15,16,17 completed", "PASS");

			sleep(2000);
			//Step 18, 19, 20
			String per2 = "60";
			policy.navigateToRiskCodesTabOnSection();
			policy.addRiskCodesOnSection(RiskCode1,per2);
			Report.LogInfo("StepCheck", "Steps 18, 19, 20 completed", "PASS");

			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload_1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			//Step 21
			BordPage.SubmitBordereaux(subSheet);		

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet4757Path = fpath+"\\src\\test\\resources\\testdata\\February 2017 Risk_TC4757First.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet4757Path);
			contractId = addNewBordereauFormatPolicy(payload_1, GetData);
			
			String Ufname = "S52363620181003.xlsx";	
			int size = 24781;
			String BordreauID = "0402b2e4-591d-4179-b539-fbed0dbefca2";
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BordreauID, ID, Ufname, size, 2 , "1", 2018);
	        addAsDraft(payload,DraftUrl);
	        
			//String payload = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"February 2017 Risk_TC4757First.xlsx\",\"UniqueFileName\":\"S58364320180613.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S58364320180613.xlsx\",\"Filesize\":24781,\"Path\":null,\"size\":24781,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
			//uploadFile(ReqUrl, excelFile, payload, DraftUrl);
			BordPage.refreshUploadedFile();
			Report.LogInfo("StepCheck", "Steps 21, 22 completed", "PASS");

			//Step 23
			BordPage.navigateToDATATab();
			Report.LogInfo("StepCheck", "Steps 10 completed", "PASS");

			//Step 24
			BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
			if(isVisible(BordPage.ReviewBtn)==true){
				AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
				ReviewtoApprd2();
				BordPage.refreshUploadedFileForApproved();
				Report.LogInfo("StepCheck", "Steps 24 to 28 completed", "PASS");
				
				//Step 29
				BordPage.navigateToDATATab();
				String Janavl = "@xpath=//tr[1]//td[text()='200.00']";
				String JanTotalVal = "@xpath=//tr[2]//td//span[text()='200.00']";
				verifyExists(Janavl,"Match month value");
				Jan_V =  getTextFrom(Janavl);
				Report.LogInfo("March month value", Jan_V, "PASS");
				verifyExists(JanTotalVal,"Match month total value");
				Jan_T =  getTextFrom(JanTotalVal);
				Report.LogInfo("March month value", Jan_T, "PASS");
				Report.LogInfo("StepCheck", "Steps 15 completed", "PASS");

				//Step 30
				BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
				Report.LogInfo("StepCheck", "Steps 30 completed", "PASS");

				//Step 31
				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet4757PathScnd = fpath+"\\src\\test\\resources\\testdata\\February2017Premium_TC4757Second.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile1 = new File(sheet4757PathScnd);
				
				String Ufname1 = "S91668420181003.xlsx";	
				int size1 = 18203;
				String BordreauID1 = "93a517f5-4051-4698-90db-0f5d9a808b20";
		        String response1 = uploadFileinContract(ReqUrl,excelFile1,contractId,Ufname1);
		        String ID1 = extractIDFromResponseinsideContract(response1); 
		        String payload1 = GeneratePayloadForContract(contractId, BordreauID1, ID1, Ufname1, size1, 2 , "2", 2018);
		        addAsDraft(payload1,DraftUrl);
		        
				//String payload1 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017Premium_TC4757Second.xlsx\",\"UniqueFileName\":\"S49983520180613.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S49983520180613.xlsx\",\"Filesize\":18203,\"Path\":null,\"size\":18203,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
				//uploadFile(ReqUrl, excelFile1, payload1, DraftUrl);
				BordPage.refreshUploadedFile();
				Report.LogInfo("StepCheck", "Steps 31 completed", "PASS");

				//step 32
				if(isVisible(BordPage.ReviewBtn)==true){
					AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
					ReviewtoApprd2();
					BordPage.refreshUploadedFileForApprovedScndRw();
					Report.LogInfo("StepCheck", "Steps 32 to 36 completed", "PASS");
					
					//Step 37
					BordPage.navigateToDATATab();
					String Janavl1 = "@xpath=//tr[1]//td[text()='400.00']";
					String JanTotalVal1 = "@xpath=//tr[2]//td//span[text()='400.00']";
					verifyExists(Janavl1,"March month value");
					Jan_V1 =  getTextFrom(Janavl1);
					Report.LogInfo("March month value", Jan_V1, "PASS");
					verifyExists(JanTotalVal1,"March month total value");
					Jan_T1 =  getTextFrom(JanTotalVal1);
					Report.LogInfo("March month value", Jan_T1, "PASS");
					Report.LogInfo("StepCheck", "Steps 37 completed", "PASS");

					//Step 38
					BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
					Report.LogInfo("StepCheck", "Steps 38 completed", "PASS");

					//Step 39
					try 
					{
						String fpath = new File(".").getCanonicalPath();
						sheet4757PathThird = fpath+"\\src\\test\\resources\\testdata\\February2017-Claim_TC4757Third.xlsx";
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					File excelFile2 = new File(sheet4757PathThird);
					
					String Ufname2 = "S20492420181003.xlsx";	
					int size2 = 17791;
					String BordreauID2 = "2d8e32db-3e06-4cc2-9f87-174fe7ba4066";
			        String response2 = uploadFileinContract(ReqUrl,excelFile2,contractId,Ufname2);
			        String ID2 = extractIDFromResponseinsideContract(response2); 
			        String payload2 = GeneratePayloadForContract(contractId, BordreauID2, ID2, Ufname2, size2, 2 , "3", 2018);
			        addAsDraft(payload2,DraftUrl);
			        
					//String payload2 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":2,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"February2017-Claim_TC4757Third.xlsx\",\"UniqueFileName\":\"S48001820180613.xlsx\",\"BordereauFormatId\":\"2d8e32db-3e06-4cc2-9f87-174fe7ba4066\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S48001820180613.xlsx\",\"Filesize\":17791,\"Path\":null,\"size\":17791,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
					//uploadFile(ReqUrl, excelFile2, payload2, DraftUrl);
					BordPage.refreshUploadedFile();
					Report.LogInfo("StepCheck", "Steps 39 completed", "PASS");

					//step 40
					if(isVisible(BordPage.ReviewBtn)==true){
						AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
						ReviewtoApprd2();
						BordPage.refreshUploadedFileForApprovedScndRw();
						Report.LogInfo("StepCheck", "Steps 41 to 44 completed", "PASS");
						
						//Step 45
						BordPage.navigateToDATATab();
						String Incurred1 = "@xpath=//tr[1]//td[text()='900.00']";
						String Incurred2 = "@xpath=//tr[2]//td//span[text()='900.00']";
						
						verifyExists(Incurred1,"Incured value");
						Incure1 =  getTextFrom(Incurred1);
						Report.LogInfo("Incured value", Incure1, "PASS");
						verifyExists(Incurred2,"Incured value");
						Incure2 =  getTextFrom(Incurred2);
						Report.LogInfo("Incured value", Incure2, "PASS");
						
						String WrittnGrossP1 = "@xpath=//tr[1]//td[text()='200.00%']";
						String WrittnGrossP2 = "@xpath=//tr[2]//td//span[text()='450.00%']";
						
						verifyExists(WrittnGrossP1,"Written gross premium value");
						WG1 =  getTextFrom(WrittnGrossP1);
						Report.LogInfo("Written gross premium value", WG1, "PASS");						
						verifyExists(WrittnGrossP2,"Written gross premium value");
						WG2 =  getTextFrom(WrittnGrossP2);
						Report.LogInfo("Written gross premium value", WG2, "PASS");
						
						Report.LogInfo("StepCheck", "Steps 45 completed", "PASS");
				
						//Step 46
						BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
						Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

						//Step 47
						try 
						{
							String fpath = new File(".").getCanonicalPath();
							sheet4757PathFourth = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017 Risk_TC4757Fourth.xlsx";
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						File excelFile3 = new File(sheet4757PathFourth);
						
						String Ufname3 = "S70186020181003.xlsx";	
						int size3 = 25042;
						String BordreauID3 = "0402b2e4-591d-4179-b539-fbed0dbefca2";
				        String response3 = uploadFileinContract(ReqUrl,excelFile3,contractId,Ufname3);
				        String ID3 = extractIDFromResponseinsideContract(response3); 
				        String payload3 = GeneratePayloadForContract(contractId, BordreauID3, ID3, Ufname3, size3, 9 , "1", 2018);
				        addAsDraft(payload3,DraftUrl);
				        
						//String payload3 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"1\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017 Risk_TC4757Fourth.xlsx\",\"UniqueFileName\":\"S58947320180613.xlsx\",\"BordereauFormatId\":\"0402b2e4-591d-4179-b539-fbed0dbefca2\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S58947320180613.xlsx\",\"Filesize\":25042,\"Path\":null,\"size\":25042,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
						//uploadFile(ReqUrl, excelFile3, payload3, DraftUrl);
						BordPage.refreshUploadedFile();
						Report.LogInfo("StepCheck", "Steps 47 completed", "PASS");

						//Step 48
						String ErrorScreen = "@xpath=.//h2[text()='Approved bordereau already processed against the period selected']";
						if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
						{	
							Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
							//Step 49
							if(isVisible(ErrorScreen)== true){							
								if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
									verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
									javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
									sleep(3000);
									BordPage.refreshUploadedFile();
									Report.LogInfo("StepCheck", "Steps 48 completed", "PASS");
								}else{
									goBack();
								}
							}
							//step 50
							if(isVisible(BordPage.ReviewBtn)==true){
								AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
								ReviewToApprvdStatus();
								BordPage.refreshUploadedFileForApproved();
								Report.LogInfo("StepCheck", "Steps 50 to 53 completed", "PASS");
								
								//Step 54
								BordPage.navigateToDATATab();
								String WGP1 = "@xpath=//tr[1]//td[text()='700.00']";
								String WGP2 = "@xpath=//tr[2]//td//span[text()='700.00']";

								verifyExists(WGP1,"Writtent gross premium value");
								GP1 =  getTextFrom(WGP1);
								Report.LogInfo("Jan month value", GP1, "PASS");
								verifyExists(WGP2,"Writtent gross premium value");
								GP2 =  getTextFrom(WGP2);
								Report.LogInfo("Jan month value", GP2, "PASS");
								Report.LogInfo("StepCheck", "Steps 54 completed", "PASS");

								//Step 55
								BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
								Report.LogInfo("StepCheck", "Steps 55 completed", "PASS");

								//Step 56
								try 
								{
									String fpath = new File(".").getCanonicalPath();
									sheet4757PathFifth = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017Premium_TC4757Fifth.xlsx";
								} 
								catch (IOException e) 
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								File excelFile4 = new File(sheet4757PathFifth);
								
								String Ufname4 = "S63157120181003.xlsx";	
								int size4 = 18481;
								String BordreauID4 = "93a517f5-4051-4698-90db-0f5d9a808b20";
						        String response4 = uploadFileinContract(ReqUrl,excelFile4,contractId,Ufname4);
						        String ID4 = extractIDFromResponseinsideContract(response4); 
						        String payload4 = GeneratePayloadForContract(contractId, BordreauID4, ID4, Ufname4, size4, 9 , "2", 2018);
						        addAsDraft(payload4,DraftUrl);
						        
								//String payload4 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"2\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017Premium_TC4757Fifth.xlsx\",\"UniqueFileName\":\"S58644020180613.xlsx\",\"BordereauFormatId\":\"93a517f5-4051-4698-90db-0f5d9a808b20\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S58644020180613.xlsx\",\"Filesize\":18481,\"Path\":null,\"size\":18481,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
								//uploadFile(ReqUrl, excelFile4, payload4, DraftUrl);
								BordPage.refreshUploadedFile();
								Report.LogInfo("StepCheck", "Steps 56 completed", "PASS");

								//Step 57
								if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
								{	
									Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
									//Step 58
									if(isVisible(ErrorScreen)== true){							
										if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
											//javaScriptclick(YesBtn,"Yes button");
											verifyMustExists(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
											javaScriptclick(BordPage.ProcessAsAdditionalBtn,"PROCESS AS AN ADDITIONAL BORDEREAU button");
											sleep(3000);
											BordPage.refreshUploadedFile();
											Report.LogInfo("StepCheck", "Steps 58,59 completed", "PASS");
										}else{
											goBack();
										}
									}
									//step 60
									if(isVisible(BordPage.ReviewBtn)==true){
										AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
										ReviewToApprvdStatus();
										BordPage.refreshUploadedFileForApproved();
										//Report.LogInfo("StepCheck", "Steps 52 completed", "PASS");
										Report.LogInfo("StepCheck", "Steps 60 to 62 completed", "PASS");
										
										//Step 63
										BordPage.navigateToDATATab();
										String WGP3 = "@xpath=//tr[1]//td[text()='1,400.00']";
										String WGP4 = "@xpath=//tr[2]//td//span[text()='1,400.00']";

										verifyExists(WGP3,"Writtent gross premium value");
										GP3 =  getTextFrom(WGP3);
										Report.LogInfo("Jan month value", GP3, "PASS");
										verifyExists(WGP4,"Writtent gross premium value");
										GP4 =  getTextFrom(WGP4);
										Report.LogInfo("Jan month value", GP4, "PASS");
										Report.LogInfo("StepCheck", "Steps 46 completed", "PASS");

										//Step 64
										BordPage.SubmitBordereauxWithYesnoButtons(IncDate);
										Report.LogInfo("StepCheck", "Steps 64 completed", "PASS");

										//Step 65
										try 
										{
											String fpath = new File(".").getCanonicalPath();
											sheet4757PathSixth = fpath+"\\src\\test\\resources\\testdata\\Saptember 2017-Claim_TC4757Sixth.xlsx";
										} 
										catch (IOException e) 
										{
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										File excelFile5 = new File(sheet4757PathSixth);
										
										String Ufname5 = "S91409820181003.xlsx";	
										int size5 = 17763;
										String BordreauID5 = "2d8e32db-3e06-4cc2-9f87-174fe7ba4066";
								        String response5 = uploadFileinContract(ReqUrl,excelFile5,contractId,Ufname5);
								        String ID5 = extractIDFromResponseinsideContract(response5); 
								        String payload5 = GeneratePayloadForContract(contractId, BordreauID5, ID5, Ufname5, size5, 9 , "3", 2018);
								        addAsDraft(payload5,DraftUrl);
								        
										//String payload5 = "{\"Bordereaux\":{\"ContractId\":\""+contractId+"\",\"Id\":\"0\",\"BordereauMonth\":9,\"DataSetType\":\"3\",\"BordereauYear\":2018,\"FolderId\":\"0\",\"OriginalFileName\":\"Saptember 2017-Claim_TC4757Sixth.xlsx\",\"UniqueFileName\":\"S31330320180613.xlsx\",\"BordereauFormatId\":\"2d8e32db-3e06-4cc2-9f87-174fe7ba4066\",\"IsFolderRuleAmend\":false,\"IsLunaBordereaux\":false},\"BordereauContractReferenceList\":[{\"ContractId\":\""+contractId+"\"}],\"UploadFileVM\":{\"BordereauxId\":null,\"BordereauFormatId\":null,\"FileName\":\"S31330320180613.xlsx\",\"Filesize\":17763,\"Path\":null,\"size\":17763,\"ActiveSheetIndex\":0,\"HeaderIndex\":0,\"MultiHeaders\":null,\"SheetNames\":null,\"IsPasswordProtected\":false},\"IsUploadOnly\":false,\"BordereauFolder\":[]}";
										//uploadFile(ReqUrl, excelFile5, payload5, DraftUrl);
										BordPage.refreshUploadedFile();
										Report.LogInfo("StepCheck", "Steps 65 completed", "PASS");

										//Step 66

										if(BordPage.checkErrorReviewButton(BordPage.ReviewError)==true)
										{	
											Report.LogInfo("ReviewErrorStatusValidation", "Status changed to Review Error.", "PASS");
											//Step 67
											if(isVisible(ErrorScreen)== true){							
												if(isVisible(BordPage.ProcessAsAdditionalBtn)== true){
													//javaScriptclick(YesBtn,"Yes button");
													verifyMustExists(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
													javaScriptclick(BordPage.ProcessAsAdditionalBtn,"ProcessAsAdditionalBtn button");
													sleep(3000);
													BordPage.refreshUploadedFile();
													Report.LogInfo("StepCheck", "Steps 66,67 completed", "PASS");
												}else{
													goBack();
												}
											}
											//step 68
											if(isVisible(BordPage.ReviewBtn)==true){
												AssertBordereauStatusReview =  getTextFrom(BordPage.ReviewBtn);
												ReviewToApprvdStatus();
												BordPage.refreshUploadedFileForApproved();
												Report.LogInfo("StepCheck", "Steps 69 to 71 completed", "PASS");
												
												//Step 72
												BordPage.navigateToDATATab();
												String Incurred5 = "@xpath=//tr[1]//td[text()='1,800.00']";
												String Incurred6 = "@xpath=//tr[2]//td//span[text()='1,800.00']";
												
												verifyExists(Incurred5,"Incured value");
												Incure3 =  getTextFrom(Incurred5);
												Report.LogInfo("Incured value", Incure3, "PASS");
												verifyExists(Incurred6,"Incured value");
												Incure4 =  getTextFrom(Incurred6);
												Report.LogInfo("Incured value month value", Incure4, "PASS");
												sleep(1000);
												Report.LogInfo("StepCheck", "Steps 72 completed", "PASS");
																								
																						
											}else{
												Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
												//ApplyDueDateFilter(DueDate, Valuedate);
												BordPage.deleteBorderEAUX();
											}	
										}else
										{
											Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
											BordPage.deleteBorderEAUX();
										}	
									}else{
										Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
										BordPage.deleteBorderEAUX();
									}	
								}else
								{
									Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
									BordPage.deleteBorderEAUX();
								}
							}else{
								Report.LogInfo("ValidationReviewStatus", "Review Status not displayed.", "FAIL");
								BordPage.deleteBorderEAUX();
							}						
						}else
						{
							Report.LogInfo("ReviewErrorStatusValidation", "Status didn't change Review Error", "FAIL");
							BordPage.deleteBorderEAUX();
						}
					}else{
						Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
						BordPage.deleteBorderEAUX();
					}
				}else{
					Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
					BordPage.deleteBorderEAUX();
				}			
			}else{
				Report.LogInfo("ValidateReviewStatus", "Review status not displayed.", "FAIL");
				BordPage.deleteBorderEAUX();		
			}		
		}	
	
	//==================================Reusable functions=========================================
	public void contractEditUSd()
	{
		if(isVisible(contractEditDots)==true){
			waitForElementToAppear(contractEditDots,5);
			verifyMustExists(contractEditDots,"Contract Edit dots");
			click(contractEditDots,"Contract Edit dots");
			waitForElementToAppear(ContractEditbtn,5);
			verifyMustExists(ContractEditbtn,"Contract Edit link");
			click(ContractEditbtn,"Contract Edit link");
			SelectDropDownValue(policy.ContractCurrencyDrpDown,policy.ContractCurrencyDrpDownValueUSD);
			scrollDown();
			sleep(1000);
			verifyMustExists(policy.SaveBtn,"Save Button");
			click(policy.SaveBtn,"Save button");
			sleep(1000);
		}
	}
	
	public void ReviewToApprvdStatus() throws Exception
	{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		
		javaScriptclick(BordPage.ReviewBtn,"Reviwe button");
		//Report.LogInfo("StepCheck", "Steps 11 completed", "PASS");

		//Step 12
		waitForElementToAppear(BordPage.SuRcdAssmnt,5);
		verifyMustExists(BordPage.SuRcdAssmnt,"Submit record assesment button");
		click(BordPage.SuRcdAssmnt,"Submit record assesment button");
		//Report.LogInfo("StepCheck", "Steps 12 completed", "PASS");

		//step 13
		waitForElementToAppear(BordPage.FrApprovalbtn1,5);
		verifyMustExists(BordPage.FrApprovalbtn1,"For Approval button");
		click(BordPage.FrApprovalbtn1,"For Approval button");
		//Report.LogInfo("StepCheck", "Steps 13 completed", "PASS");

		//Step 14
		BordPage.clickOnApproveBordBtn();
		sleep(15000);
		//BordPage.refreshUploadedFileForApproved();
		//Report.LogInfo("StepCheck", "Steps 14 completed", "PASS");
	}
	
	public void ReviewtoApprd1() throws Exception{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		
		Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
		javaScriptclick(BordPage.ReviewBtn,"Review button");
		//Report.LogInfo("StepCheck", "Steps 40 completed", "PASS");

		//step 41			
		waitForElementToAppear(BordPage.SuRcdAssmnt,5);
		verifyMustExists(BordPage.SuRcdAssmnt,"Submit record assesment button");
		javaScriptclick(BordPage.SuRcdAssmnt,"Submit record assesment button");
		//Report.LogInfo("StepCheck", "Steps 41 completed", "PASS");

		//Step 42
		String DRpval = "@xpath=//li[contains(.,'Section 2')]";
		String ComplteAssgmnt = "@xpath=//*[@id='content']//button[@type='submit']";
		SelectDropDownValue(SectionconDrp,DRpval);
		verifyMustExists(ComplteAssgmnt,"Complete assginment button");
		javaScriptclick(ComplteAssgmnt,"Complete assginment button");
		//Report.LogInfo("StepCheck", "Steps 42 completed", "PASS");
		
		BordPage.clickOnForApprovalBtn();
		//Step 43
		BordPage.clickOnApproveBordBtn1();
		sleep(15000);
		//BordPage.refreshUploadedFileForApproved();
		//Report.LogInfo("StepCheck", "Steps 43 completed", "PASS");
	}
	
	public void ReviewtoApprd2() throws Exception{
		BordereauProcessPage BordPage = new BordereauProcessPage();
		
		Report.LogInfo("ValidationReviewStatus", "Review Status displayed successfully.", "PASS");
		javaScriptclick(BordPage.ReviewBtn,"Review button");
		//Report.LogInfo("StepCheck", "Steps 40 completed", "PASS");

		//step 41			
		waitForElementToAppear(BordPage.SuRcdAssmnt,5);
		verifyMustExists(BordPage.SuRcdAssmnt,"Submit record assesment button");
		javaScriptclick(BordPage.SuRcdAssmnt,"Submit record assesment button");
		//Report.LogInfo("StepCheck", "Steps 41 completed", "PASS");

		//Step 42
		String DRpval = "@xpath=//li[contains(.,'Section 2')]";
		String ComplteAssgmnt = "@xpath=//*[@id='content']//button[@type='submit']";
		SelectDropDownValue(SectionconDrp,DRpval);
		verifyMustExists(ComplteAssgmnt,"Complete assginment button");
		javaScriptclick(ComplteAssgmnt,"Complete assginment button");
		//Report.LogInfo("StepCheck", "Steps 42 completed", "PASS");
		
		//step 
		String DRpval1 = "@xpath=//li[contains(.,'Default all entries in the Bordereau to the primary Risk Code of the Section')]";
		SelectDropDownValue(SectionconDrp,DRpval1);
		verifyMustExists(ComplteAssgmnt,"Complete assginment button");
		javaScriptclick(ComplteAssgmnt,"Complete assginment button");
		BordPage.clickOnForApprovalBtn();
		//Step 43
		BordPage.clickOnApproveBordBtn1();
		sleep(15000);
		//BordPage.refreshUploadedFileForApproved();
		//Report.LogInfo("StepCheck", "Steps 43 completed", "PASS");
	}
}
