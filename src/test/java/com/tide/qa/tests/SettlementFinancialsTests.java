package com.tide.qa.tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.SettlementFinancialsPage;
import com.tide.qa.utility.Report;

public class SettlementFinancialsTests extends TestBase {
	SettlementFinancialsPage settlement = new SettlementFinancialsPage();
	

	
	@Test(priority = 97, groups={"TC1367SettlementFinancialsPremium"})
	public void TC1367SettlementFinancialsPremium()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			//TC154_AddPremiumQuestionaire
			settlement.TC_1367_SettlementFinancial();
			softAssert.assertEquals(settlement.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(settlement.RN1, "3");
			softAssert.assertEquals(settlement.RN2, "4");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged, "USD");
			softAssert.assertEquals(settlement.ActualDPVCRuleName, "Derive Coverholder Settlement Currency from Premium Currency");
			softAssert.assertEquals(settlement.ActualDPVCOriginal1, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged1, "USD");
			softAssert.assertEquals(settlement.ActualDPVCRuleName1, "Derive Coverholder Settlement Currency from Premium Currency");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal2, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged2, "1.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName2, "Set Coverholder Settlement RoE as 1");
			softAssert.assertEquals(settlement.ActualDPVCOriginal3, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged3, "1.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName3, "Set Coverholder Settlement RoE as 1");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal4, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged4, "11,875.30");
			softAssert.assertEquals(settlement.ActualDPVCRuleName4, "Use Net Premium (Premium Currency) as Net Premium (Coverholder Settlement Currency)");
			softAssert.assertEquals(settlement.ActualDPVCOriginal5, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged5, "8,635.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName5, "Use Net Premium (Premium Currency) as Net Premium (Coverholder Settlement Currency)");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal6, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged6, "USD");
			softAssert.assertEquals(settlement.ActualDPVCRuleName6, "Derive Broker Settlement Currency from Coverholder Settlement Currency");
			softAssert.assertEquals(settlement.ActualDPVCOriginal7, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged7, "USD");
			softAssert.assertEquals(settlement.ActualDPVCRuleName7, "Derive Broker Settlement Currency from Coverholder Settlement Currency");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal8, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged8, "1.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName8, "Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			softAssert.assertEquals(settlement.ActualDPVCOriginal9, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged9, "1.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName9, "Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal10, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged10, "600.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName10, "Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			softAssert.assertEquals(settlement.ActualDPVCOriginal11, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged11, "600.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName11, "Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal12, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged12, "11,275.30");
			softAssert.assertEquals(settlement.ActualDPVCRuleName12, "Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
			softAssert.assertEquals(settlement.ActualDPVCOriginal13, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged13, "8,035.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName13, "Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
				
						
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1367SettlementFinancialsPremium "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 
	@Test(priority = 98, groups={"TC1368SettlementFinancialsPremium"})
	public void TC1368SettlementFinancialsPremium()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
		//	login.tideLogin(AdminUsername1, AdminPassword1);
			settlement.SettlementFinancial_1368();
			softAssert.assertEquals(settlement.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(settlement.RN11, "3");
			softAssert.assertEquals(settlement.RN12, "4");
			
			
			softAssert.assertEquals(settlement.CSC11, "USD");
			softAssert.assertEquals(settlement.CSC12, "USD");
			
			softAssert.assertEquals(settlement.CSCRoe11, "1.00");
			softAssert.assertEquals(settlement.CSCRoe12, "1.00");
			
			softAssert.assertEquals(settlement.NPCSC11, "11,875.30");
			softAssert.assertEquals(settlement.NPCSC12, "8,635.00");
			
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal6, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged6, "USD");
			softAssert.assertEquals(settlement.ActualDPVCRuleName6, "Derive Broker Settlement Currency from Coverholder Settlement Currency");
			softAssert.assertEquals(settlement.ActualDPVCOriginal7, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged7, "USD");
			softAssert.assertEquals(settlement.ActualDPVCRuleName7, "Derive Broker Settlement Currency from Coverholder Settlement Currency");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal8, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged8, "1.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName8, "Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			softAssert.assertEquals(settlement.ActualDPVCOriginal9, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged9, "1.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName9, "Use Coverholder Settlement Currency RoE as Broker Settlement Currency RoE");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal10, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged10, "600.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName10, "Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			softAssert.assertEquals(settlement.ActualDPVCOriginal11, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged11, "600.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName11, "Use Brokerage (Premium Currency) as Brokerage (Broker Settlement Currency)");
			
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal12, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged12, "11,275.30");
			softAssert.assertEquals(settlement.ActualDPVCRuleName12, "Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
			softAssert.assertEquals(settlement.ActualDPVCOriginal13, "-");
			softAssert.assertEquals(settlement.ActualDPVCChanged13, "8,035.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName13, "Use Final Net Premium (Premium Currency) as Final Net Premium (Broker Settlement Currency)");
			
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1368SettlementFinancialsPremium "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 
	
	@Test(priority = 99, groups={"TC1369SettlementFinancialsPremium"})
	public void TC1369SettlementFinancialsPremium()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
		//	login.tideLogin(AdminUsername1, AdminPassword1);
			settlement.SettlementFinancial_1369();
			softAssert.assertEquals(settlement.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(settlement.RN21, "3");
			softAssert.assertEquals(settlement.RN22, "4");
			softAssert.assertEquals(settlement.CSC21, "USD");
			softAssert.assertEquals(settlement.CSC22, "USD");
			softAssert.assertEquals(settlement.CSCRoe21, "1.00");
			softAssert.assertEquals(settlement.CSCRoe22, "1.00");
			softAssert.assertEquals(settlement.NPCSC21, "11,875.30");
			softAssert.assertEquals(settlement.NPCSC22, "8,635.00");
			softAssert.assertEquals(settlement.BSC21, "USD");
			softAssert.assertEquals(settlement.BSC22, "USD");
			softAssert.assertEquals(settlement.BSCRoe21, "1.00");
			softAssert.assertEquals(settlement.BSCRoe22, "1.00");
			softAssert.assertEquals(settlement.BBSC21, "1,050.00");
			softAssert.assertEquals(settlement.BBSC22, "512.00");
			softAssert.assertEquals(settlement.FNPBSC21, "250.00");
			softAssert.assertEquals(settlement.FNPBSC22, "712.00");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1369SettlementFinancialsPremium "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 
	
	@Test(priority = 100, groups={"TC3725SettlementFinancialsPremiumwithErros"})
	public void TC3725SettlementFinancialsPremiumwithErros()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
		//	login.tideLogin(AdminUsername1, AdminPassword1);
			settlement.SettlementFinancial_3725();
			
			
			softAssert.assertEquals(settlement.errorTitleValidate, "Invalid financial value translation required");
			softAssert.assertEquals(settlement.errorTitleValidate1, "Broker Settlement Currency reference data translation required");
			softAssert.assertEquals(settlement.errorTitleValidate2, "Coverholder Settlement Currency reference data translation required");
			softAssert.assertEquals(settlement.AssertBordereauStatusReview, "REVIEW");
			
			softAssert.assertEquals(settlement.RN31, "3");
			softAssert.assertEquals(settlement.RN32, "4");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal, "Test@1050");
			softAssert.assertEquals(settlement.ActualDPVCChanged, "GBP");
			softAssert.assertEquals(settlement.ActualDPVCRuleName, "Validate reference data values");
			softAssert.assertEquals(settlement.CSC, "GBP");
			/*softAssert.assertEquals(settlement.ActualDPVCOriginal1, "512");
			softAssert.assertEquals(settlement.ActualDPVCChanged1, "GBP");
			softAssert.assertEquals(settlement.ActualDPVCRuleName1, "Validate reference data values");*/
			
			softAssert.assertEquals(settlement.CSCRoe31, "1.00");
			softAssert.assertEquals(settlement.CSCRoe32, "1.00");
			
			
			softAssert.assertEquals(settlement.NPCSC31, "100.00");
			softAssert.assertEquals(settlement.NPCSC32, "100.00");
			
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal6, "Random Insured1");
			softAssert.assertEquals(settlement.ActualDPVCChanged6, "GBP");
			softAssert.assertEquals(settlement.ActualDPVCRuleName6, "Validate reference data values");
			softAssert.assertEquals(settlement.BSC32, "USD");
			
			
			softAssert.assertEquals(settlement.BSCRoe31, "1.00");
			softAssert.assertEquals(settlement.BSCRoe32, "1.00");
			
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal10, "es@1050");
			softAssert.assertEquals(settlement.ActualDPVCChanged10, "1,050.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName10, "Validate Financial values");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal11, "GBP");
			softAssert.assertEquals(settlement.ActualDPVCChanged11, "0.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName11, "Remove ISO currency code characters & symbols");
			
			softAssert.assertEquals(settlement.ActualDPVCOriginal12, "es@250");
			softAssert.assertEquals(settlement.ActualDPVCChanged12, "250.00");
			softAssert.assertEquals(settlement.ActualDPVCRuleName12, "Validate Financial values");
			softAssert.assertEquals(settlement.FNPBSC32, "712.00");
			
									
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC3725SettlementFinancialsPremium "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	} 
	
	
	
	
}
