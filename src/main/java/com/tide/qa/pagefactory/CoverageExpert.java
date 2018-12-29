package com.tide.qa.pagefactory;


import java.io.File;
import java.io.IOException;



import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class CoverageExpert extends PageBase {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BordereauQuePage BQue = new BordereauQuePage();
	BordereauProcessPage Br = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	
	
	public static String PolicyNumber;
	public static String contractId;
	public String versionNumber;
	public static String EditName;
	
	public static String sheet1900Path = "";
	public static String sheet1903Path = "";
	public static String sheet1905Path = "";
	public static String sheet1911Path = "";
	public static String sheet3810Path = "";
	public static String sheet1912Path = "";
	
	
	public String EWaterflag;
	public String EWaterCurrency;
	public String EWaterTSI;
	public String EWaterLimit;
	public String EWaterType;
	public String EWaterAmount;
	public String EWaterPercent;
	public String EWaterBasis;
	public String EWaterPremium;

	public String TerrorismIFlag1;
	public String TerrorismCurrency1;
	public String TerrorismTSI1;
	public String TerrorismLimit1;
	public String TerrorismType1;
	public String TerrorismAmount1;
	public String TerrorismPercent1;
	public String TerrorismBasis1;
	public String TerrorismPremium1;
	
	public String EarthIFlag1;
	public String EarthCurrency1;
	public String EarthTSI1;
	public String EarthLimit1;
	public String EarthType1;
	public String EarthAmount1;
	public String EarthPercent1;
	public String EarthBasis1;
	public String EarthPremium1;
		
	public String CName1;
	public String ActualCName1;
	public String ActualCName2;
	public String ActualCref;
	public String ActualCref1;
	public String ActualCAdd1;
	public String ActualCAdd;
	public String ActualCState;
	public String ActualCState1;
	public String ActualCPostalCode;
	public String ActualCPostalCode1;
	public String ActualCCountry;
	public String ActualCCountry1;
	

	public String CName2;
	public String ActualCName_1;
	public String ActualCName_2;
	public String ActualCref2;
	public String ActualCref_1;
	public String ActualCAdd2;
	public String ActualCAdd_1;
	public String ActualCState2;
	public String ActualCState_1;
	public String ActualCPostalCode2;
	public String ActualCPostalCode_1;
	public String ActualCCountry2;
	public String ActualCCountry_1;
	
	
	
	
	// TC-1900----START
		public void BordereauProcessingaddCoverage_TC1900() throws Exception {
			String type1 = "Risk And Premium";
			String FreqVal1 = "Monthly";
			String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			
			String WaterIFlag = "@xpath=//*[@data-field='EscapeofWater_Coverage_Included_Flag']//following::tr[1]//td[contains(@ng-click,'Escape of Water Included Flag')]";
		    String WaterCurrency = "@xpath=//*[@data-field='EscapeofWater_Coverage_Currency']//following::tr[1]//td[contains(@ng-click,'Escape of Water Currency')]";
			String WaterTSI = "@xpath=//*[@data-field='EscapeofWater_Coverage_Total_Sums_Insured']//following::tr[1]//td[contains(@ng-click,'Escape of Water Total Sums Insured')]";
			String WaterLimit = "@xpath=//*[@data-field='EscapeofWater_Coverage_Limit']//following::tr[1]//td[contains(@ng-click,'EscapeofWater_Coverage_Limit')]";
			String WaterType = "@xpath=//*[@data-field='EscapeofWater_Coverage_Deductible_Or_Excess_Type']//following::tr[1]//td[contains(@ng-click,'EscapeofWater_Coverage_Deductible_Or_Excess_Type')]";
			String WaterAmount = "@xpath=//*[@data-field='EscapeofWater_Coverage_Deductible_Or_Excess_Amount']//following::tr[1]//td[contains(@ng-click,'EscapeofWater_Coverage_Deductible_Or_Excess_Amount')]";
			String WaterPercent = "@xpath=//*[@data-field='EscapeofWater_Coverage_Deductible_Or_Excess_Percentage']//following::tr[1]//td[contains(@ng-click,'EscapeofWater_Coverage_Deductible_Or_Excess_Percentage')]";
			String WaterBasis = "@xpath=//*[@data-field='EscapeofWater_Coverage_Deductible_Or_Excess_Basis']//following::tr[1]//td[contains(@ng-click,'EscapeofWater_Coverage_Deductible_Or_Excess_Basis')]";
			String WaterPremium = "@xpath=//*[@data-field='EscapeofWater_Coverage_Premium']//following::tr[1]//td[contains(@ng-click,'EscapeofWater_Coverage_Premium')]";
						
			//Step 1
		  	BQue.addcoverageQuestionnaire();
			
			Report.LogInfo("StepCheck", "Steps 1 completed", "PASS");
			
			
			// step 2
			policy.CreateContractwithInceptionDate2018();
			sleep(1000);
			policy.navigateToReportingChannelsTab();
		    policy.addReportingChannelForAnyComb(type1,FreqVal1);
		    Report.LogInfo("StepCheck", "Steps 2 completed", "PASS");
		    
		    //Step 3
		    Br.SubmitBordereaux(IncDate);
			
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet1900Path = fpath+"\\src\\test\\resources\\testdata\\Coverage_1900.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet1900Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			
			String Ufname = "S31742820181110.xlsx";	
			int size = 19110;
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BQue.BFormatId, ID, Ufname, size, 1 , "4", 2018);
	        addAsDraft(payload,DraftUrl);
			
			Br.refreshUploadedFile();
				
			 if(isVisible(Br.ReviewBtn)==true){
				 AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
	  				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
	  				Br.openDATALink();
	  				Br.navigateToDATARiskTab();
	  				sleep(2000);
	  				if(isVisible(Br.DataLinkNoResult)==true)
	  				{
	  					Report.LogInfo("ValidateResult", "Result not display", "Fail");
	  					policy.navigationOnBordereauxTab();
	  					Br.deleteBorderEAUX();			   
	  				}else{
	  					
	  					sleep(1000);
	  					 if(isVisible(WaterIFlag)==true){
	  						
	  						verifyMustExists(WaterIFlag,"Escape Water Flag First Row");
	  						EWaterflag = getTextFrom(WaterIFlag,"Escape Water Flag FirstRow");
	  						Report.LogInfo("Escape Water Flag FirstRow", EWaterflag, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterCurrency,"Escape Water Currency First Row");
	  						EWaterCurrency = getTextFrom(WaterCurrency,"Escape Water Currency First Row");
	  						Report.LogInfo("Escape Water Currency First Row", EWaterCurrency, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterTSI,"Escape Water TSI First Row");
	  						EWaterTSI = getTextFrom(WaterTSI,"Escape Water TSI First Row");
	  						Report.LogInfo("Escape Water TSI First Row", EWaterTSI, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterLimit,"Escape Water Limit First Row");
	  						EWaterLimit = getTextFrom(WaterLimit,"Escape Water Limit First Row");
	  						Report.LogInfo("Escape Water Limit First Row", EWaterLimit, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterType,"Escape Water Type First Row");
	  						EWaterType = getTextFrom(WaterType,"Escape Water Type FirstRow");
	  						Report.LogInfo("Escape Water Type Firs tRow", EWaterType, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterAmount,"Escape Water Amount First Row");
	  						EWaterAmount = getTextFrom(WaterAmount,"Escape Water Amount First Row");
	  						Report.LogInfo("Escape Water Amount First Row", EWaterAmount, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterPercent,"Escape Water percent First Row");
	  						EWaterPercent = getTextFrom(WaterPercent,"Escape Water percent FirstRow");
	  						Report.LogInfo("Escape Water percent FirstRow", EWaterPercent, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterBasis,"Escape Water Basis First Row");
	  						EWaterBasis = getTextFrom(WaterBasis,"Escape Water Basis FirstRow");
	  						Report.LogInfo("Escape Water Basis FirstRow", EWaterBasis, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(WaterPremium,"Escape Water Premium First Row");
	  						EWaterPremium = getTextFrom(WaterPremium,"Escape Water Premium FirstRow");
	  						Report.LogInfo("Escape Water Premium FirstRow", EWaterPremium, "PASS");
	  						sleep(2000);
	  			
	  					}else {
			            	Report.LogInfo("ErroScreenCheck", "Escape Water Flag column not displayed", "FAIL");
	  					}
	  				}
			    
	  				Report.LogInfo("StepCheck", "Steps 3 completed", "PASS");
	  				/* policy.navigationOnBordereauxTab();
	  				if(isVisible(Br.ReviewBtn)==true) {
	  					 AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
	  					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
	  					Br.deleteBorderEAUX();
	  				} else {
	  					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
	  				}*/
			 }else{
				 Report.LogInfo("validateReviewbutton", "Review Status Button not Displayed", "FAIL");
				 Br.deleteBorderEAUX();
			 }
		}
				 
		
		public void BordereauProcessaddEditCoverage_TC1903() throws Exception {
			String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			
			
			String EarthIFlag = "@xpath=//*[@data-field='Earthquake_Coverage_Included_Flag']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Included_Flag')]";
		    String EarthCurrency = "@xpath=//*[@data-field='Earthquake_Coverage_Currency']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Currency')]";
			String EarthTSI = "@xpath=//*[@data-field='Earthquake_Coverage_Total_Sums_Insured']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Total_Sums_Insured')]";
			String EarthLimit = "@xpath=//*[@data-field='Earthquake_Coverage_Limit']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Limit')]";
			String EarthType = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Type']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Type')]";
			String EarthAmount = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Amount']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Amount')]";
			String EarthPercent = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Percentage']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Percentage')]";
			String EarthBasis = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Basis']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Basis')]";
			String EarthPremium = "@xpath=//*[@data-field='Earthquake_Coverage_Premium']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Premium')]";
			
			String TerrorismIFlag = "@xpath=//*[@data-field='Terrorism_Coverage_Included_Flag']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Included_Flag')]";
		    String TerrorismCurrency = "@xpath=//*[@data-field='Terrorism_Coverage_Currency']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Currency')]";
			String TerrorismTSI = "@xpath=//*[@data-field='Terrorism_Coverage_Total_Sums_Insured']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Total_Sums_Insured')]";
			String TerrorismLimit = "@xpath=//*[@data-field='Terrorism_Coverage_Limit']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Limit')]";
			String TerrorismType = "@xpath=//*[@data-field='Terrorism_Coverage_Deductible_Or_Excess_Type']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Deductible_Or_Excess_Type')]";
			String TerrorismAmount = "@xpath=//*[@data-field='Terrorism_Coverage_Deductible_Or_Excess_Amount']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Deductible_Or_Excess_Amount')]";
			String TerrorismPercent = "@xpath=//*[@data-field='Terrorism_Coverage_Deductible_Or_Excess_Percentage']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Deductible_Or_Excess_Percentage')]";
			String TerrorismBasis = "@xpath=//*[@data-field='Terrorism_Coverage_Deductible_Or_Excess_Basis']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Deductible_Or_Excess_Basis')]";
			String TerrorismPremium = "@xpath=//*[@data-field='Terrorism_Coverage_Premium']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Premium')]";
			 
			
			//Step 1
			BQue.editcoverage();
			Report.LogInfo("StepCheck", "Steps 1 completed", "PASS");
		
			//Step 2
			Br.applyFilterPolicy(policy.PolicyNumber);
			Br.openSelectedPolicy();
			sleep(1000);
			Report.LogInfo("StepCheck", "Steps 2 completed", "PASS");
			
			
			 //Step 3
		    Br.SubmitBordereaux(IncDate);
			
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet1903Path = fpath+"\\src\\test\\resources\\testdata\\Coverage_1900.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet1903Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			
			String Ufname = "S31742820181110.xlsx";	
			int size = 19110;
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BQue.BFormatId, ID, Ufname, size, 1 , "4", 2018);
	        addAsDraft(payload,DraftUrl);
			
			Br.refreshUploadedFile();
				
			 if(isVisible(Br.ReviewBtn)==true){
				 AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
	  				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
	  				Br.openDATALink();
	  				Br.navigateToDATARiskTab();
	  				sleep(2000);
	  				Report.LogInfo("StepCheck", "Steps 3 completed", "PASS");
	  				if(isVisible(Br.DataLinkNoResult)==true)
	  				{
	  					Report.LogInfo("ValidateResult", "Result not display", "Fail");
	  					policy.navigationOnBordereauxTab();
	  					Br.deleteBorderEAUX();			   
	  				}else{
	  					
	  					sleep(1000);
	  					 if(isVisible(EarthIFlag)==true){
	  						
	  						verifyMustExists(EarthIFlag,"Earthquake Flag First Row");
	  						EarthIFlag1 = getTextFrom(EarthIFlag,"Earthquake Flag FirstRow");
	  						Report.LogInfo("Earthquake Flag FirstRow", EarthIFlag1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthCurrency,"Earthquake Currency First Row");
	  						EarthCurrency1 = getTextFrom(EarthCurrency,"Earthquake Currency First Row");
	  						Report.LogInfo("Earthquake Currency First Row", EarthCurrency1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthTSI,"Earthquake TSI First Row");
	  						EarthTSI1 = getTextFrom(EarthTSI,"Earthquake TSI First Row");
	  						Report.LogInfo("Earthquake TSI First Row", EarthTSI1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthLimit,"Earthquake Limit First Row");
	  						EarthLimit1 = getTextFrom(EarthLimit,"Earthquake Limit First Row");
	  						Report.LogInfo("Earthquake Limit First Row", EarthLimit1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthType,"Earthquake  Type First Row");
	  						EarthType1 = getTextFrom(EarthType,"Earthquake Type FirstRow");
	  						Report.LogInfo("Earthquake Type Firs tRow", EarthType1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthAmount,"Earthquake Amount First Row");
	  						EarthAmount1 = getTextFrom(EarthAmount,"Earthquake Amount First Row");
	  						Report.LogInfo("Earthquake Amount First Row", EarthAmount1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthPercent,"Earthquake percent First Row");
	  						EarthPercent1 = getTextFrom(EarthPercent,"Earthquake percent FirstRow");
	  						Report.LogInfo("Earthquake percent FirstRow", EarthPercent1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthBasis,"Earthquake Basis First Row");
	  						EarthBasis1 = getTextFrom(EarthBasis,"Earthquake Basis FirstRow");
	  						Report.LogInfo("Earthquake Basis FirstRow", EarthBasis1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(EarthPremium,"Earthquake Premium First Row");
	  						EarthPremium1 = getTextFrom(EarthPremium,"Earthquake Premium FirstRow");
	  						Report.LogInfo("EarthquakePremium FirstRow", EarthPremium1, "PASS");
	  						sleep(2000);
	  			
	  					}else {
			            	Report.LogInfo("ErroScreenCheck", "Earthquake Flag column not displayed", "FAIL");
	  					}
	  				}
	  				Report.LogInfo("StepCheck", "Steps 3 completed", "PASS");
	  				//Step 4
	  				 if(isVisible(TerrorismIFlag)==true){
	  						
	  						verifyMustExists(TerrorismIFlag,"Terrorism Flag First Row");
	  						TerrorismIFlag1 = getTextFrom(TerrorismIFlag,"Terrorism Flag FirstRow");
	  						Report.LogInfo("Terrorism Flag FirstRow", TerrorismIFlag1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismCurrency,"Terrorism Currency First Row");
	  						TerrorismCurrency1 = getTextFrom(TerrorismCurrency,"Terrorism Currency First Row");
	  						Report.LogInfo("Terrorism Currency First Row", TerrorismCurrency1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismTSI,"Terrorism TSI First Row");
	  						TerrorismTSI1 = getTextFrom(TerrorismTSI,"Terrorism TSI First Row");
	  						Report.LogInfo("Terrorism TSI First Row", TerrorismTSI1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismLimit,"Terrorism Limit First Row");
	  						TerrorismLimit1 = getTextFrom(TerrorismLimit,"Terrorism Limit First Row");
	  						Report.LogInfo("Terrorism Limit First Row", TerrorismLimit1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismType,"Terrorism  Type First Row");
	  						TerrorismType1 = getTextFrom(TerrorismType,"Terrorism Type FirstRow");
	  						Report.LogInfo("Terrorism Type Firs tRow", TerrorismType1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismAmount,"Terrorism Amount First Row");
	  						TerrorismAmount1 = getTextFrom(TerrorismAmount,"Terrorism Amount First Row");
	  						Report.LogInfo("Terrorism Amount First Row", TerrorismAmount1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismPercent,"Terrorism percent First Row");
	  						TerrorismPercent1 = getTextFrom(TerrorismPercent,"Terrorism percent FirstRow");
	  						Report.LogInfo("Terrorism percent FirstRow", TerrorismPercent1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismBasis,"Terrorism Basis First Row");
	  						TerrorismBasis1 = getTextFrom(TerrorismBasis,"Terrorism Basis FirstRow");
	  						Report.LogInfo("Terrorism Basis FirstRow", TerrorismBasis1, "PASS");
	  						sleep(2000);
	  						
	  						verifyMustExists(TerrorismPremium,"Terrorism Premium First Row");
	  						TerrorismPremium1 = getTextFrom(TerrorismPremium,"Terrorism Premium FirstRow");
	  						Report.LogInfo("Terrorism Premium FirstRow", TerrorismPremium1, "PASS");
	  						sleep(2000);
	  			
	  					}else {
			            	Report.LogInfo("ErroScreenCheck", "Terrorism Flag column not displayed", "FAIL");
	  					}
	  				
			    
	  				Report.LogInfo("StepCheck", "Steps 4 completed", "PASS");
	  				 policy.navigationOnBordereauxTab();
	  				if(isVisible(Br.ReviewBtn)==true) {
	  					 AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
	  					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");	
	  					Br.deleteBorderEAUX();
	  				} else {
	  					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
	  				}
			 }else{
				 Report.LogInfo("validateReviewbutton", "Review Status Button not Displayed", "FAIL");
				 Br.deleteBorderEAUX();
			 }
		}
				 
		
		public void BordereauProcessDeleteCoverage_TC1905() throws Exception {
			
			String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			
			
			String EarthIFlag = "@xpath=//*[@data-field='Earthquake_Coverage_Included_Flag']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Included_Flag')]";
		    String EarthCurrency = "@xpath=//*[@data-field='Earthquake_Coverage_Currency']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Currency')]";
			String EarthTSI = "@xpath=//*[@data-field='Earthquake_Coverage_Total_Sums_Insured']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Total_Sums_Insured')]";
			String EarthLimit = "@xpath=//*[@data-field='Earthquake_Coverage_Limit']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Limit')]";
			String EarthType = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Type']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Type')]]";
			String EarthAmount = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Amount']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Amount')]";
			String EarthPercent = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Percentage']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Percentage')]";
			String EarthBasis = "@xpath=//*[@data-field='Earthquake_Coverage_Deductible_Or_Excess_Basis']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Deductible_Or_Excess_Basis')]";
			String EarthPremium = "@xpath=//*[@data-field='Earthquake_Coverage_Premium']//following::tr[1]//td[contains(@ng-click,'Earthquake_Coverage_Premium')]";
			
			String TerrorismIFlag = "@xpath=//*[@data-field='Terrorism_Coverage_Included_Flag']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Included_Flag')]";
		    String TerrorismCurrency = "@xpath=//*[@data-field='Terrorism_Coverage_Currency']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Currency')]";
			String TerrorismTSI = "@xpath=//*[@data-field='Terrorism_Coverage_Total_Sums_Insured']//following::tr[1]//td[contains(@ng-click,'Terrorism_Coverage_Total_Sums_Insured')]";
			
			Br.applyFilterPolicy(policy.PolicyNumber);
			Br.openSelectedPolicy();
			  //Step 1
			  BQue.deletecoverage();
			  
			  Report.LogInfo("StepCheck", "Steps 1 completed", "PASS");
				
				//Step 2
				Br.applyFilterPolicy(policy.PolicyNumber);
				Br.openSelectedPolicy();
				sleep(1000);
				Report.LogInfo("StepCheck", "Steps 2 completed", "PASS");
				
				
				 //Step 3
			    Br.SubmitBordereaux(IncDate);
				
				String GetData = Configuration.url+"/api/Contract/GetAllPage";
				String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

				try 
				{
					String fpath = new File(".").getCanonicalPath();
					sheet1905Path = fpath+"\\src\\test\\resources\\testdata\\Coverage_1900.xlsx";
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File excelFile = new File(sheet1905Path);  
				contractId = addNewBordereauFormatPolicy(payload1, GetData);
				
				
				String Ufname = "S31742820181110.xlsx";	
				int size = 19110;
		        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
		        String ID = extractIDFromResponseinsideContract(response); 
		        String payload = GeneratePayloadForContract(contractId, BQue.BFormatId, ID, Ufname, size, 1 , "4", 2018);
		        addAsDraft(payload,DraftUrl);
				
				Br.refreshUploadedFile();
					
				 if(isVisible(Br.ReviewBtn)==true){
					    AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
		  				Report.LogInfo("StatusCheck", "Review status gets displayed.", "PASS");
		  				Br.openDATALink();
		  				Br.navigateToDATARiskTab();
		  				sleep(2000);
		  				if(isVisible(EarthIFlag)==true)
						{
							Report.LogInfo("ValidateResult", "EarthIFlag  Column  display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthIFlag Column Not display", "PASS");
						}
						
						if(isVisible(EarthCurrency)==true)
						{
							Report.LogInfo("ValidateResult", "EarthCurrency Column  display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthCurrency Column not display", "PASS");
						}
						
						if(isVisible(EarthTSI)==true)
						{
							Report.LogInfo("ValidateResult", "EarthTSI Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthTSI Column not display", "PASS");
						}
						
						if(isVisible(EarthLimit)==true)
						{
							Report.LogInfo("ValidateResult", "EarthLimit Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthLimit Column not display", "PASS");
						}

						if(isVisible(EarthType)==true)
						{
							Report.LogInfo("ValidateResult", "EarthType Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthType Column not display", "PASS");
							
						}
						
						if(isVisible(EarthAmount)==true)
						{
							Report.LogInfo("ValidateResult", "EarthAmount Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthAmount Column not display", "PASS");
							
						}
						
						if(isVisible(EarthPercent)==true)
						{
							Report.LogInfo("ValidateResult", "EarthPercent Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthPercent Column not display", "PASS");
							
						}
						
						if(isVisible(EarthBasis)==true)
						{
							Report.LogInfo("ValidateResult", "EarthBasis Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthBasis1 Column not display", "PASS");
							
						}
						
						if(isVisible(EarthPremium)==true)
						{
							Report.LogInfo("ValidateResult", "EarthPremium Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "EarthPremium Column not display", "PASS");
							
						}
						
						if(isVisible(TerrorismIFlag)==true)
						{
							Report.LogInfo("ValidateResult", "TerrorismIFlag  Column  display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "TerrorismIFlag Column Not display", "PASS");
						}
						
						if(isVisible(TerrorismCurrency)==true)
						{
							Report.LogInfo("ValidateResult", "TerrorismCurrency Column  display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "TerrorismCurrency Column not display", "PASS");
						}
						
						if(isVisible(TerrorismTSI)==true)
						{
							Report.LogInfo("ValidateResult", "TerrorismTSI Column display", "Fail");
							policy.navigationOnBordereauxTab();
							Br.deleteBorderEAUX();			   
						}else{
							Report.LogInfo("ValidateResult", "TerrorismTSI Column not display", "PASS");
						}
						
						 policy.navigationOnBordereauxTab();
						
			            	if (isVisible(Br.ReviewBtn) == true) {	
			            		 AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
					               Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
					            Br.deleteBorderEAUX();
				            }else {
					           Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");

			          	}
			       
						
						}else{
							Report.LogInfo("ValidateReviewErrorStatus", "Review  status not displayed.", "Fail");
						}
				}  
						
	
		
		public void ClaimBordereauProcessAddExperte_TC3810() throws Exception {
			
			
			//String EscapeWCompanyName = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name_1']";
		    String CompanyName1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name_1']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Name - 1')]";
			String CompanyName2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name_1']//following::tr[2]//td[contains(@ng-click,'Escape of Water Company Name - 1')]";
			//String CompanyRef = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Reference_1']";
			String CompanyRef1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Reference_1']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Reference - 1')]";
			//String CompanyAdd = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Address_1']";
			String CompanyAdd1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Address_1']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Address - 1')]";
			//String CompanyState = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_State_1']";
			String CompanyState1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_State_1']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company State - 1')]";
		   //String CompanyPostalCode = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Postal_Code_1']";
			String CompanyPostalCode1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Postal_Code_1']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Postal Code - 1')]";
			//String CompanyCountry = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Country_1']";
			String CompanyCountry1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Country_1']/following::tr[1]//td[contains(@ng-click,'Escape of Water Company Country - 1')]";
			
			
			String EscapeWCompanyName2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name_2']";
		    String CompanyName_1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name_2']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Name - 2')]";
			String CompanyName_2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name_2']//following::tr[2]//td[contains(@ng-click,'Escape of Water Company Name - 2')]";
			String CompanyRef2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Reference_2']";
			String CompanyRef_1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Reference_2']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Reference - 2')]";
			String CompanyAdd2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Address_2']";
			String CompanyAdd_1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Address_2']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Address - 2')]";
			String CompanyState2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_State_2']";
			String CompanyState_1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_State_2']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company State - 2')]";
			String CompanyPostalCode2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Postal_Code_2']";
			String CompanyPostalCode_1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Postal_Code_2']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Postal Code - 2')]";
			String CompanyCountry2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Country_2']";
			String CompanyCountry_1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Country_2']/following::tr[1]//td[contains(@ng-click,'Escape of Water Company Country - 2')]";
			
			
			
			String ReqUrl = Configuration.url + "/api/FileStorage/UploadFile/1";
			String DraftUrl = Configuration.url + "/api/Bordereaux/AddAsDraft";
			String IncDate = "01/01/2018";
			
			BQue.addExpertQuestionnaire();
			
			// step 1
			

			policy.CreateClaimContractwithInceptionDate2018();
			  		 
		    Br.SubmitBordereaux(IncDate);
			
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet3810Path = fpath+"\\src\\test\\resources\\testdata\\Claims Expert.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet3810Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			
			String Ufname = "S21235820181113.xlsx";	
			int size = 12762;
	        String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	        String ID = extractIDFromResponseinsideContract(response); 
	        String payload = GeneratePayloadForContract(contractId, BQue.FormatId, ID, Ufname, size, 1 , "3", 2018);
	        addAsDraft(payload,DraftUrl);
			
			Br.refreshUploadedFile();
			
					if(isVisible(Br.ReviewBtn)==true){
						
					Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
					sleep(2000);
	  				Br.openDATALink();
	  				Br.navigateToDATAClaimTab();
	  				sleep(2000);
	  				if(isVisible(Br.DataLinkNoResult)==true)
	  				{
	  					Report.LogInfo("ValidateResult", "Result not display", "Fail");
	  					policy.navigationOnBordereauxTab();
	  					Br.deleteBorderEAUX();			   
	  				}else{
	  					
	  					sleep(1000);
	  					 if(isVisible(CompanyName1)==true){
	  						/*verifyMustExists(EscapeWCompanyName,"Company Name 1 Column");
	  						String CName1 = getTextFrom(EscapeWCompanyName,"Company Name 1 Column");
	  						Report.LogInfo("Company Name column 1", CName1, "PASS");
	  						sleep(2000);*/
	  						verifyMustExists(CompanyName1,"Company Name 1 First Row");
	  						ActualCName1 = getTextFrom(CompanyName1,"Company Name 1 FirstRow");
	  						Report.LogInfo("Company Name 1 FirstRow", ActualCName1, "PASS");
	  						sleep(2000);
	  						verifyMustExists(CompanyName2,"Company Nam1e First Row");
	  						ActualCName2 = getTextFrom(CompanyName2,"Company Name1 SecRow");
	  						Report.LogInfo("Company Name 1 SecRow", ActualCName2, "PASS");
	  						sleep(2000);
	  						
	  						/*if(CName1.equals(ExpectedCName))
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Name 1 First Row record validate successfully", "PASS"); 
	  						}
	  						else
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Name 1 First Row record not validate successfully", "FAIL");
	  						}
	  						sleep(2000);
	  						
	  						
	  						verifyMustExists(CompanyRef,"Company reference 1 Column");
	  						String ActualCref = getTextFrom(CompanyRef,"Company reference 1 Column");
	  						Report.LogInfo("Company reference 1 Column", ActualCref, "PASS");
	  						sleep(2000);*/
	  						
	  						verifyMustExists(CompanyRef1,"Company reference 1 First Row");
	  						ActualCref1 = getTextFrom(CompanyRef1,"Company reference 1 FirstRow");
	  						Report.LogInfo("Company reference 1 FirstRow", ActualCref1, "PASS");
	  						sleep(2000);
	  					
	  						/*if(ActualCref.equals(ExpectedCRef))
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company reference 1 First Row record validate successfully", "PASS"); 
	  						}
	  						else
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company reference 1 First Row record not validate successfully", "FAIL");
	  						}
	  						sleep(2000);
	  						

	  						verifyMustExists(CompanyAdd,"Company Address 1 Column");
	  						String ActualCAdd = getTextFrom(CompanyAdd,"Company Address  1 Column");
	  						Report.LogInfo("Company Address 1 Column", ActualCAdd, "PASS");
	  						sleep(2000);
	  						*/
	  						verifyMustExists(CompanyAdd1,"Company Address 1 First Row");
	  						ActualCAdd1 = getTextFrom(CompanyAdd1,"Company Address 1 FirstRow");
	  						Report.LogInfo("Company Address 1 FirstRow", ActualCAdd1, "PASS");
	  						sleep(2000);
	  					
	  						/*if(ActualCAdd.equals(ExpectedCAdd))
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Address 1 First Row record validate successfully", "PASS"); 
	  						}
	  						else
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Address 1 First Row record not validate successfully", "FAIL");
	  						}
	  						sleep(2000);
	  						
	  						verifyMustExists(CompanyState,"Company State 1 Column");
	  						String ActualCState = getTextFrom(CompanyState,"Company State 1 Column");
	  						Report.LogInfo("Company State 1 Column", ActualCState, "PASS");
	  						sleep(2000);*/
	  						
	  						verifyMustExists(CompanyState1,"Company State 1 First Row");
	  						ActualCState1 = getTextFrom(CompanyState1,"Company State 1 FirstRow");
	  						Report.LogInfo("Company State 1 FirstRow", ActualCState1, "PASS");
	  						sleep(2000);
	  					
	  						/*if(ActualCState.equals(ExpectedCState))
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company State 1 First Row record validate successfully", "PASS"); 
	  						}
	  						else
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company State 1 First Row record not validate successfully", "FAIL");
	  						}
	  						sleep(2000);
	  						
	  						verifyMustExists(CompanyPostalCode,"Company Postal Code 1 Column");
	  						String ActualCPostalCode = getTextFrom(CompanyPostalCode,"Company Postal Code 1 Column");
	  						Report.LogInfo("Company Postal Code 1 Column", ActualCPostalCode, "PASS");
	  						sleep(2000);*/
	  						
	  						verifyMustExists(CompanyPostalCode1,"Company Postal Code 1 First Row");
	  						ActualCPostalCode1 = getTextFrom(CompanyPostalCode1,"Company Postal Code 1 FirstRow");
	  						Report.LogInfo("Company Postal Code 1 FirstRow", ActualCPostalCode1, "PASS");
	  						sleep(2000);
	  					
	  						/*if(ActualCPostalCode.equals(ExpectedCPostalCode))
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Postal Code1  First Row record validate successfully", "PASS"); 
	  						}
	  						else
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Postal Code 1 First Row record not validate successfully", "FAIL");
	  						}
	  						sleep(2000);
	  						
	  						verifyMustExists(CompanyCountry,"Company Country 1 Column");
	  						String ActualCCountry = getTextFrom(CompanyCountry,"Company Country 1 Column");
	  						Report.LogInfo("Company Country 1 Column", ActualCCountry, "PASS");
	  						sleep(2000);*/
	  						
	  						verifyMustExists(CompanyCountry1,"Company Country First Row");
	  						ActualCCountry1 = getTextFrom(CompanyCountry1,"Company Country 1 FirstRow");
	  						Report.LogInfo("Company Country 1 FirstRow", ActualCCountry1, "PASS");
	  						sleep(2000);
	  					
	  						/*if(ActualCCountry.equals(ExpectedCCountry))
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Country 1 First Row record validate successfully", "PASS"); 
	  						}
	  						else
	  						{
	  							Report.LogInfo("ValidateExpectedFirstRow", "Expected Company Country 1 First Row record not validate successfully", "FAIL");
	  						}
	  						sleep(2000);*/
	  						
	  		 				
	  						   } else {
				            	Report.LogInfo("ErroScreenCheck", "Escape Water Company Name 1 column not displayed", "FAIL");
				    
				        }

	  					
	  					
	  					//Sec Column Verify
	  					
	  					
	  					if(isVisible(CompanyName_1)==true){	  						
	  						verifyMustExists(CompanyName_1,"Company Name 2 First Row");
	  						ActualCName_1 = getTextFrom(CompanyName_1,"Company Name 2 FirstRow");
	  						Report.LogInfo("Company Name 2 FirstRow", ActualCName_1, "PASS");
	  						sleep(2000);
	  						verifyMustExists(CompanyName_2,"Company Name 2 First Row");
	  						ActualCName_2 = getTextFrom(CompanyName_2,"Company Name 2 SecRow");
	  						Report.LogInfo("Company Name 2 SecRow", ActualCName_2, "PASS");
	  						sleep(2000);
	  			
	  						
	  						verifyMustExists(CompanyRef_1,"Company reference 2 First Row");
	  						ActualCref_1 = getTextFrom(CompanyRef_1,"Company reference 2 FirstRow");
	  						Report.LogInfo("Company reference 2 FirstRow", ActualCref_1, "PASS");
	  						sleep(2000);
	  					
	
	  						verifyMustExists(CompanyAdd_1,"Company Address 2 First Row");
	  						ActualCAdd_1 = getTextFrom(CompanyAdd_1,"Company Address 2 FirstRow");
	  						Report.LogInfo("Company Address 2 FirstRow", ActualCAdd_1, "PASS");
	  						sleep(2000);
	
	  						
	  						verifyMustExists(CompanyState_1,"Company State 2 First Row");
	  						ActualCState_1 = getTextFrom(CompanyState_1,"Company State 2 FirstRow");
	  						Report.LogInfo("Company State 2 FirstRow", ActualCState_1, "PASS");
	  						sleep(2000);
	  					
	  					
	  						verifyMustExists(CompanyPostalCode_1,"Company Postal Code 2 First Row");
	  						ActualCPostalCode_1 = getTextFrom(CompanyPostalCode_1,"Company Postal Code 2 FirstRow");
	  						Report.LogInfo("Company Postal Code 2 FirstRow", ActualCPostalCode_1, "PASS");
	  						sleep(2000);
	  					
	  						
	  						verifyMustExists(CompanyCountry_1,"Company Country 2 First Row");
	  						ActualCCountry_1 = getTextFrom(CompanyCountry_1,"Company Country 2 FirstRow");
	  						Report.LogInfo("Company Country 1 FirstRow", ActualCCountry_1, "PASS");
	  						sleep(2000);
	  					
	 						
			        	} else {
			        		Report.LogInfo("ErroScreenCheck", "Escape Water Company Name 2 column not displayed", "FAIL");

				}

			}
	  				
	  				
			      sleep(2000);
	  				policy.navigationOnBordereauxTab();
				if (isVisible(Br.ReviewBtn) == true) {
					Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
					Br.deleteBorderEAUX();
				} else {
					Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");

				}
			} else {
				Report.LogInfo("validateReviewbutton", "Review Status Button not Displayed", "FAIL");
			}
		}					
							

	public void ClaimBordereauProcessEditExpert_TC1911() throws Exception {
		String IncDate = "01/01/2018";	
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		
	
	
	    String CompanyName1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Name')]";
		String CompanyName2 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name']//following::tr[2]//td[contains(@ng-click,'Escape of Water Company Name')]";		
		String CompanyRef1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Reference']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Reference')]";
		String CompanyAdd1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Address']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Address')]";
		String CompanyState1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_State']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company State')]";
		String CompanyPostalCode1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Postal_Code']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Postal Code')]";
		String CompanyCountry1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Country']/following::tr[1]//td[contains(@ng-click,'Escape of Water Company Country')]";
		
		

	    String CompanyName_1 = "@xpath=//*[@data-field='Flood_Expert_Company_Name']//following::tr[1]//td[contains(@ng-click,'Flood_Expert_Company_Name')]";
		String CompanyName_2 = "@xpath=//*[@data-field='Flood_Expert_Company_Name']//following::tr[2]//td[contains(@ng-click,'Flood_Expert_Company_Name')]";
		String CompanyRef_1 = "@xpath=//*[@data-field='Flood_Expert_Company_Reference']//following::tr[1]//td[contains(@ng-click,'Flood_Expert_Company_Reference')]";
		String CompanyAdd_1 = "@xpath=//*[@data-field='Flood_Expert_Company_Address']//following::tr[1]//td[contains(@ng-click,'Flood_Expert_Company_Address')]";
		String CompanyState_1 = "@xpath=//*[@data-field='Flood_Expert_Company_State']//following::tr[1]//td[contains(@ng-click,'Flood_Expert_Company_State')]";
		String CompanyPostalCode_1 = "@xpath=//*[@data-field='Flood_Expert_Company_Postal_Code']//following::tr[1]//td[contains(@ng-click,'Flood_Expert_Company_Postal_Code')]";
		String CompanyCountry_1 = "@xpath=//*[@data-field='Flood_Expert_Company_Country']/following::tr[1]//td[contains(@ng-click,'Flood_Expert_Company_Country')]";
		
		
		
	   	BQue.editExpert();  	
		
		Br.applyFilterPolicy(policy.PolicyNumber);
		Br.openSelectedPolicy();
		  
		  sleep(1000);
		 
	    
		   Br.SubmitBordereaux(IncDate);
		
		String GetData = Configuration.url+"/api/Contract/GetAllPage";
		String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

		try 
		{
			String fpath = new File(".").getCanonicalPath();
			sheet1911Path = fpath+"\\src\\test\\resources\\testdata\\Claims Expert.xlsx";
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File excelFile = new File(sheet1911Path);  
		contractId = addNewBordereauFormatPolicy(payload1, GetData);
		
		
		String Ufname = "S21235820181113.xlsx";	
		int size = 12762;
      String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
      String ID = extractIDFromResponseinsideContract(response); 
      String payload = GeneratePayloadForContract(contractId, BQue.BFormatId, ID, Ufname, size, 1 , "3", 2018);
      addAsDraft(payload,DraftUrl);
		
		Br.refreshUploadedFile();
		
				if(isVisible(Br.ReviewBtn)==true){
					
				Report.LogInfo("ValidateReviewErrorStatus", "Review Error status displayed.", "PASS");
				sleep(2000);
				Br.openDATALink();
				Br.navigateToDATAClaimTab();
				sleep(2000);
				if(isVisible(Br.DataLinkNoResult)==true)
				{
					Report.LogInfo("ValidateResult", "Result not display", "Fail");
					policy.navigationOnBordereauxTab();
					Br.deleteBorderEAUX();			   
				}else{
					//Br.selectRowNumberAscOrder();
					sleep(1000);

					 if(isVisible(CompanyName1)==true){
						verifyMustExists(CompanyName1,"Company Name 1 First Row");
						ActualCName1 = getTextFrom(CompanyName1,"Company Name 1 FirstRow");
						Report.LogInfo("Company Name 1 FirstRow", ActualCName1, "PASS");
						sleep(2000);
						verifyMustExists(CompanyName2,"Company Nam1e First Row");
						ActualCName2 = getTextFrom(CompanyName2,"Company Name1 SecRow");
						Report.LogInfo("Company Name 1 SecRow", ActualCName2, "PASS");
						sleep(2000);
	
						
						verifyMustExists(CompanyRef1,"Company reference 1 First Row");
						ActualCref1 = getTextFrom(CompanyRef1,"Company reference 1 FirstRow");
						Report.LogInfo("Company reference 1 FirstRow", ActualCref1, "PASS");
						sleep(2000);
					
						
						
						verifyMustExists(CompanyAdd1,"Company Address 1 First Row");
						ActualCAdd1 = getTextFrom(CompanyAdd1,"Company Address 1 FirstRow");
						Report.LogInfo("Company Address 1 FirstRow", ActualCAdd1, "PASS");
						sleep(2000);
					
						
						verifyMustExists(CompanyState1,"Company State 1 First Row");
						ActualCState1 = getTextFrom(CompanyState1,"Company State 1 FirstRow");
						Report.LogInfo("Company State 1 FirstRow", ActualCState1, "PASS");
						sleep(2000);
					
						
						verifyMustExists(CompanyPostalCode1,"Company Postal Code 1 First Row");
						ActualCPostalCode1 = getTextFrom(CompanyPostalCode1,"Company Postal Code 1 FirstRow");
						Report.LogInfo("Company Postal Code 1 FirstRow", ActualCPostalCode1, "PASS");
						sleep(2000);
					
						
						verifyMustExists(CompanyCountry1,"Company Country First Row");
						ActualCCountry1 = getTextFrom(CompanyCountry1,"Company Country 1 FirstRow");
						Report.LogInfo("Company Country 1 FirstRow", ActualCCountry1, "PASS");
						sleep(2000);
					
						
		 				
						    } else {
			            	Report.LogInfo("ErroScreenCheck", "Escape Water Company Name 1 column not displayed", "FAIL");
			    
			        }

					
					
					//Sec Column Verify
					
					
					if(isVisible(CompanyName1)==true){
	
						verifyMustExists(CompanyName_1,"Company Name 2 First Row");
						ActualCName_1 = getTextFrom(CompanyName_1,"Company Name 2 FirstRow");
						Report.LogInfo("Company Name 2 FirstRow", ActualCName_1, "PASS");
						sleep(2000);
						verifyMustExists(CompanyName_2,"Company Name 2 First Row");
						ActualCName_2 = getTextFrom(CompanyName_2,"Company Name 2 SecRow");
						Report.LogInfo("Company Name 2 SecRow", ActualCName_2, "PASS");
						sleep(2000);
	
						
						verifyMustExists(CompanyRef_1,"Company reference 2 First Row");
						ActualCref_1 = getTextFrom(CompanyRef_1,"Company reference 2 FirstRow");
						Report.LogInfo("Company reference 2 FirstRow", ActualCref_1, "PASS");
						sleep(2000);
					
						
						verifyMustExists(CompanyAdd_1,"Company Address 2 First Row");
						ActualCAdd_1 = getTextFrom(CompanyAdd_1,"Company Address 2 FirstRow");
						Report.LogInfo("Company Address 2 FirstRow", ActualCAdd_1, "PASS");
						sleep(2000);
					
						
						verifyMustExists(CompanyState_1,"Company State 2 First Row");
						ActualCState_1 = getTextFrom(CompanyState_1,"Company State 2 FirstRow");
						Report.LogInfo("Company State 2 FirstRow", ActualCState_1, "PASS");
						sleep(2000);		
						
						verifyMustExists(CompanyPostalCode_1,"Company Postal Code 2 First Row");
						ActualCPostalCode_1 = getTextFrom(CompanyPostalCode_1,"Company Postal Code 2 FirstRow");
						Report.LogInfo("Company Postal Code 2 FirstRow", ActualCPostalCode_1, "PASS");
						sleep(2000);
					

						verifyMustExists(CompanyCountry_1,"Company Country 2 First Row");
						ActualCCountry_1 = getTextFrom(CompanyCountry_1,"Company Country 2 FirstRow");
						Report.LogInfo("Company Country 1 FirstRow", ActualCCountry_1, "PASS");
						sleep(2000);
					
						
						
		 				
			        }else {
			            	Report.LogInfo("ErroScreenCheck", "Escape Water Company Name 2 column not displayed", "FAIL");
			    
			        }
				}
					
			             sleep(2000);
				         policy.navigationOnBordereauxTab();
		            	if (isVisible(Br.ReviewBtn) == true) {
		            		  AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
				               Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
				            Br.deleteBorderEAUX();
			            }else {
				           Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");
 
		          	}
		                 }else {
			                Report.LogInfo("validateReviewbutton", "Review Status Button not Displayed", "FAIL");

	               	}
        	
            }
	                     

	public void ClaimBordereauProcessDeleteExpert_TC1912() throws Exception {
		String IncDate = "01/01/2018";	
		String ReqUrl = Configuration.url+"/api/FileStorage/UploadFile/1";
		String DraftUrl = Configuration.url+"/api/Bordereaux/AddAsDraft";
		

	    String CompanyName1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Name']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Name')]";	
		String CompanyRef1 = "@xpath=//*[@data-field='EscapeofWater_Expert_Company_Reference']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Reference')]";
		String CompanyAdd_1 = "@xpath=//*[@data-field='Flood_Expert_Company_Address']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company Address')]";
		String CompanyState_1 = "@xpath=//*[@data-field='Flood_Expert_Company_State']//following::tr[1]//td[contains(@ng-click,'Escape of Water Company State')]";
		String CompanyCountry_1 = "@xpath=//*[@data-field='Flood_Expert_Company_Country']/following::tr[1]//td[contains(@ng-click,'Escape of Water Company Country')]";
		
		
		    BQue.deleteExpert();

		    Br.applyFilterPolicy(policy.PolicyNumber);
			Br.openSelectedPolicy();
			  
			sleep(1000);
			 
		   
			Br.SubmitBordereaux(IncDate);
			
			String GetData = Configuration.url+"/api/Contract/GetAllPage";
			String payload1 = "{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"or\",\"filters\":[{\"value\":\""+policy.PolicyNumber+"\",\"operator\":\"eq\",\"field\":\"FolderRandomNumber\"}]}}";

			try 
			{
				String fpath = new File(".").getCanonicalPath();
				sheet1912Path = fpath+"\\src\\test\\resources\\testdata\\Claims Expert.xlsx";
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File excelFile = new File(sheet1912Path);  
			contractId = addNewBordereauFormatPolicy(payload1, GetData);
			
			
			String Ufname = "S21235820181113.xlsx";	
			int size = 12762;
	      String response = uploadFileinContract(ReqUrl,excelFile,contractId,Ufname);
	      String ID = extractIDFromResponseinsideContract(response); 
	      String payload = GeneratePayloadForContract(contractId, BQue.FormatId, ID, Ufname, size, 1 , "3", 2018);
	      addAsDraft(payload,DraftUrl);
			
			Br.refreshUploadedFile();
			
					if(isVisible(Br.ReviewBtn)==true){
						
					Report.LogInfo("ValidateReviewErrorStatus", "Review  status displayed.", "PASS");
					sleep(2000);
					Br.openDATALink();
					Br.navigateToDATAClaimTab();
					sleep(2000);
					if(isVisible(CompanyName1)==true)
					{
						Report.LogInfo("ValidateResult", "Company Name1 Column  display", "Fail");
						policy.navigationOnBordereauxTab();
						Br.deleteBorderEAUX();			   
					}else{
						Report.LogInfo("ValidateResult", "Company Name1 Column Not display", "PASS");
					}
					
					if(isVisible(CompanyRef1)==true)
					{
						Report.LogInfo("ValidateResult", "Company Ref1 Column  display", "Fail");
						policy.navigationOnBordereauxTab();
						Br.deleteBorderEAUX();			   
					}else{
						Report.LogInfo("ValidateResult", "Company Ref1 Column not display", "PASS");
					}
					
					if(isVisible(CompanyAdd_1)==true)
					{
						Report.LogInfo("ValidateResult", "Company Add_1 Column display", "Fail");
						policy.navigationOnBordereauxTab();
						Br.deleteBorderEAUX();			   
					}else{
						Report.LogInfo("ValidateResult", "Company Add_1 Column not display", "PASS");
					}
					
					if(isVisible(CompanyState_1)==true)
					{
						Report.LogInfo("ValidateResult", "Company State_1 Column display", "Fail");
						policy.navigationOnBordereauxTab();
						Br.deleteBorderEAUX();			   
					}else{
						Report.LogInfo("ValidateResult", "Company State_1 Column not display", "PASS");
					}

					if(isVisible(CompanyCountry_1)==true)
					{
						Report.LogInfo("ValidateResult", "Company Country_1 Column display", "Fail");
						policy.navigationOnBordereauxTab();
						Br.deleteBorderEAUX();			   
					}else{
						Report.LogInfo("ValidateResult", "Company Country_1 Column not display", "PASS");
						
					}
					 policy.navigationOnBordereauxTab();
					
		            	if (isVisible(Br.ReviewBtn) == true) {
		            		   AssertBordereauStatusReview =  getTextFrom(Br.ReviewBtn);	
				               Report.LogInfo("ReviewStatus", AssertBordereauStatusReview, "PASS");
				            Br.deleteBorderEAUX();
			            }else {
				           Report.LogInfo("ErroScreenCheck", "Review  status not displayed", "FAIL");

		          	}
		       
					
					}else{
						Report.LogInfo("ValidateReviewErrorStatus", "Review  status not displayed.", "Fail");
					}
			}  
					
	
		
}