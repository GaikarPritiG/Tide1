package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BProcessingRiskPremiumClaimPage;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.utility.Report;

@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BProcessingRiskPremiumClaimTest extends TestBase
{
	BProcessingRiskPremiumClaimPage BProcessRPC = new BProcessingRiskPremiumClaimPage();
	BordereauProcessPage BorProc = new BordereauProcessPage();
	PolicyPage policy = new PolicyPage();
	LoginPage login = new LoginPage();
	
	String AdminUsername = "nilesh1@otak.co.uk";
	String AdminPassword = "systenics123@";
	
	String AdminUsername1 = "dave.brit@brit.com";
	String AdminPassword1 = "systenics123@";
	
	String AdminInsureRead = "aarifa@systenics.net";
	String AdminInsurePassRead = "test1234@";
	
	String BrokerRead = "shruti@systenics.com";
	String BrokerPassRead = "2bnHmk$f";
	
	String CoverholderRead = "readonly.jones@coverholderinc.com";
	String CoverholderReadPass = "Pa55word123";
	
	String TPARead_Only = "nohid@systenics.com";
	String TPA_Read_Passwd = "2ceM$aig";
	
	String AdminUsername3 = "readonly.jones@coverholderinc.com";
	String AdminPassword3 = "Pa55word123";
	
	String RegulatorStd = "user9notification009@gmail.com";
	String RegulatorPWD = "Test123@";
	
	String RegulatorReadonly = "user7notification007@gmail.com";
	
	
	
	@Test(priority = 641, groups={"TC4438_BordereauProcessingForRisk"})
	public void TC4438_BordereauProcessingForRisk()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			videoRecordingStart("TC4438_BordereauProcessingForRisk");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.bordereauProcessingForRisk_4438();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4438_BordereauProcessingForRisk "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Processing for Risk Verification");
		videoRecordingStop();
	}
		
	@Test(priority = 642, groups={"TC4510_BordereauProcessingForClaim"})
	public void TC4510_BordereauProcessingForClaim()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4510_BordereauProcessingForClaim");
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.bordereauProcessingForClaim_4510();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4510_BordereauProcessingForClaim "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Processing for claim Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 643, groups={"TC4511_BordereauProcessingForPremium"})
	public void TC4511_BordereauProcessingForPremium()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC4511_BordereauProcessingForPremium");
			//login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.bordereauProcessingForPremium_4511();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4511_BordereauProcessingForPremium "+e.getMessage(), "FAIL");
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Bordereau Processing for premium Verification");
		videoRecordingStop();
	}
	
	@Test(priority = 644, groups={"TC5356_TaskAndNotes"})
	public void TC5356_TaskAndNotes()
	{
		Report.createTestCaseReportHeader();

		try
		{
			videoRecordingStart("TC5356_TaskAndNotes");
			//login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.TaskAndNotes_TC5356();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5356_TaskAndNotes "+e.getMessage(), "FAIL");
		}finally{
			
			login.tideReadOnlyLogOut();
		}
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Tasks and notes");
		videoRecordingStop();
	}
		
	@Test(priority = 645, groups={"TC905_ActivityRole_ContractAdministrator_Standard_Insurer"})
	public void TC905_ActivityRole_ContractAdministrator_Standard_Insurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ChangeRole_CA_Insurer();
			BProcessRPC.ContractRoleCA_Insurer("Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened" );
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.CanEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL","1");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL","2");
			softAssert.assertNotEquals(BorProc.DeleteButtonPresent, "FAIL","3");
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL","4");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL","5");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS","6");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS","7");
			
	}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC905_ActivityRole_ContractAdministrator_Standard_Insurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
		
	@Test(priority = 646, groups={"TC906_ActivityRole_ContractAdministrator_ReadOnly_Insure"})
	public void TC906_ActivityRole_ContractAdministrator_ReadOnly_Insure()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.ContractAdminReadOnly_TC4515("Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordereau,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC906_ActivityRole_ContractAdministrator_ReadOnly_Insure "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}finally{
			
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 647, groups={"TC908_RiskTransformationStandrdInsirerUser"})
	public void TC908_RiskTransformationStandrdInsirerUser()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.Change_role_Insurer_RiskTransformation();
			BProcessRPC.RiskInformationStandrdInsirerUser_TC4516("Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 15 of 22 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");
			
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC908_RiskTransformationStandrdInsirerUser "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}finally{
			
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 648, groups={"TC909_RiskTransformationReadonly"})
	public void TC909_RiskTransformationReadonly()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Transformation","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC909_RiskTransformationReadonly "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}finally{
			
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 649, groups={"TC910_RiskAssignmentStandrdInsirerUser"})
	public void TC910_RiskAssignmentStandrdInsirerUser()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskAssignmentRoleChange_Insurer();
			BProcessRPC.RiskAssignmentStandrdInsirerUser_TC4779("Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC910_RiskAssignmentStandrdInsirerUser "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}

	
	@Test(priority = 650, groups={"TC911_RiskAssignmentReadOnlyUser"})
	public void TC911_RiskAssignmentReadOnlyUser()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Assignment","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC911_RiskAssignmentReadOnlyUser "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 651, groups={"TC913_RiskApprovalStandardInsurer"})
	public void TC913_RiskApprovalStandardInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);	
			BProcessRPC.RiskApprovalRoleChange_Insurer();
			BProcessRPC.riskApprovalStandardInsurer_TC4789("Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 8 of 8 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC913_RiskApprovalStandardInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	} 
	
	@Test(priority = 652, groups={"TC914_RiskApprovalReadOnlyInsurer"})
	public void TC914_RiskApprovalReadOnlyInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);		
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Approval","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC914_RiskApprovalReadOnlyInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority = 653, groups={"TC915_PremiumTransformationStandardInsurer"})
	public void TC915_PremiumTransformationStandardInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumTransformationRoleChange_Insurer();
			BProcessRPC.premiumTransformationStandardInsurer_TC4797("Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");
			
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BProcessRPC.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC915_PremiumTransformationStandardInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 654, groups={"TC916_PremiumTransformationReadonlyInsurer"})
	public void TC916_PremiumTransformationReadonlyInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Transformation","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC916_PremiumTransformationReadonlyInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 655, groups={"TC917_PremiumAssignmentStandardInsurer"})
	public void TC917_PremiumAssignmentStandardInsurer()
	{	
		SoftAssert softAssert = new SoftAssert();
	
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumAssignmentRoleChange_Insurer();
			BProcessRPC.premiumAssignmentStandardInsurer_TC4806("Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC917_PremiumAssignmentStandardInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	} 
	
	@Test(priority = 656, groups={"TC918_PremiumAssignmentReadOnlyInsurer"})
	public void TC918_PremiumAssignmentReadOnlyInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Assignment","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC918_PremiumAssignmentReadOnlyInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 657, groups={"TC920_PremiumApprovalStandardInsurer"})
	public void TC920_PremiumApprovalStandardInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumApprovalRoleChange_Insurer();
			BProcessRPC.premiumApprovalStandardInsurer_TC4815("Insurer");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC920_PremiumApprovalStandardInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 658, groups={"TC921_PremiumApprovalReadOnlyInsurer"})
	public void TC921_PremiumApprovalReadOnlyInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Approval","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC921_PremiumApprovalReadOnlyInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 659, groups={"TC922_ClaimTransformationStandard_Insurer"})
	public void TC922_ClaimTransformationStandard_Insurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsTransformationRoleChange_Insurer();
			BProcessRPC.ClaimTransformationStandard_Insurer_TC4821("Insurer");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC922_ClaimTransformationStandard_Insurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}	
	@Test(priority = 660, groups={"TC923_ClaimTransformation_ReadOnly_Insurer"})
	public void TC923_ClaimTransformation_ReadOnly_Insurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Transformation","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC923_ClaimTransformation_ReadOnly_Insurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 661, groups={"TC925_ClaimAssignment_Standard_Insurer"})
	public void TC925_ClaimAssignment_Standard_Insurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsAssignmentRoleChange_Insurer();
			BProcessRPC.ClaimAssignment_Standard_Insurer_TC4824("Insurer");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC925_ClaimAssignment_Standard_Insurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 662, groups={"TC926_ClaimAssignment_ReadOnly_Insurer"})
	public void TC926_ClaimAssignment_ReadOnly_Insurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Assignment","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC926_ClaimAssignment_ReadOnly_Insurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 663, groups={"TC930_ClaimApproval_Standard_Insurer"})
	public void TC930_ClaimApproval_Standard_Insurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsApprovalRoleChange_Insurer();
			BProcessRPC.ClaimApproval_Standard_Insurer_TC4827("Insurer");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC930_ClaimApproval_Standard_Insurer"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 664, groups={"TC931_ClaimApproval_ReadOnly_Insurer"})
	public void TC931_ClaimApproval_ReadOnly_Insurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Approval","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC931_ClaimApproval_ReadOnly_Insurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 665, groups={"TC877_Activity_Role_ContractAdmintrator_Standarduser_Broker"})
	public void TC877_Activity_Role_ContractAdmintrator_Standarduser_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ChangeRole_CA_Broker();
			BProcessRPC.ContractRoleCA_Insurer("Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened" );
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.CanEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			softAssert.assertNotEquals(BorProc.DeleteButtonPresent, "FAIL");
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(policy.IsvisibleUndewriteronMarket, "PASS");
			softAssert.assertEquals(policy.IsVisibleAddRiskCode, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC877_Activity_Role_ContractAdmintrator_Standarduser_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}

	@Test(priority = 666, groups={"TC878_Activity_Role_ContractAdmintrator_Readonlyduser_Broker"})
	public void TC878_Activity_Role_ContractAdmintrator_Readonlyduser_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.ContractAdminReadOnly_TC4515("Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordereau,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC878_Activity_Role_ContractAdmintrator_Readonlyduser_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 667, groups={"TC879_ActivityRole_RiskTransformation_Standard_Broker"})
	public void TC879_ActivityRole_RiskTransformation_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.Change_role_Broker_RiskTransformation();
			BProcessRPC.RiskInformationStandrdInsirerUser_TC4516("Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 15 of 22 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");
			
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC879_ActivityRole_RiskTransformation_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 668, groups={"TC882_ActivityRole_RiskTransformation_ReadOnly_Broker"})
	public void TC882_ActivityRole_RiskTransformation_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Transformation","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC882_ActivityRole_RiskTransformation_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 669, groups={"TC883_ActivityRole_RiskAssignment_Standard_Broker"})
	public void TC883_ActivityRole_RiskAssignment_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskAssignmentRoleChange_Broker();
			BProcessRPC.RiskAssignmentStandrdInsirerUser_TC4779("Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC883_ActivityRole_RiskAssignment_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 670, groups={"TC884_ActivityRole_RiskAssignment_ReadOnly_Broker"})
	public void TC884_ActivityRole_RiskAssignment_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Assignment","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC884_ActivityRole_RiskAssignment_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 671, groups={"TC885_ActivityRole_RiskApproval_Standard_Broker"})
	public void TC885_ActivityRole_RiskApproval_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskApprovalRoleChange_Broker();
			BProcessRPC.riskApprovalStandardInsurer_TC4789("Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 8 of 8 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC885_ActivityRole_RiskApproval_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 672, groups={"TC6638_ActivityRole_RiskApproval_ReadOnly_Broker"})
	public void TC886_ActivityRole_RiskApproval_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Approval","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC6638_ActivityRole_RiskApproval_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 673, groups={"TC887_ActivityRole_PremiumTransformation_Standard_Broker"})
	public void TC887_ActivityRole_PremiumTransformation_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumTransformationRoleChange_Broker();
			BProcessRPC.premiumTransformationStandardInsurer_TC4797("Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");
			
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BProcessRPC.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC887_ActivityRole_PremiumTransformation_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 674, groups={"TC888_ActivityRole_PremiumTransformation_ReadOnly_Broker"})
	public void TC888_ActivityRole_PremiumTransformation_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Transformation","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC888_ActivityRole_PremiumTransformation_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 675, groups={"TC889_ActivityRole_PremiumAssignment_Standard_Broker"})
	public void TC889_ActivityRole_PremiumAssignment_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumAssignmentRoleChange_Broker();
			BProcessRPC.premiumAssignmentStandardInsurer_TC4806("Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC889_ActivityRole_PremiumAssignment_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 676, groups={"TC890_ActivityRole_PremiumAssignment_ReadOnly_Broker"})
	public void TC890_ActivityRole_PremiumAssignment_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Assignment","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC890_ActivityRole_PremiumAssignment_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 677, groups={"TC891_ActivityRole_PremiumApproval_Standard_Broker"})
	public void TC891_ActivityRole_PremiumApproval_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumApprovalRoleChange_Broker();
			BProcessRPC.premiumApprovalStandardInsurer_TC4815("Broker");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC891_ActivityRole_PremiumApproval_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 678, groups={"TC892_ActivityRole_PremiumApproval_ReadOnly_Broker"})
	public void TC892_ActivityRole_PremiumApproval_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Approval","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC892_ActivityRole_PremiumApproval_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 679, groups={"TC893_ActivityRole_ClaimsTransformation_Standard_Broker"})
	public void TC893_ActivityRole_ClaimsTransformation_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsTransformationRoleChange_Broker();
			BProcessRPC.ClaimTransformationStandard_Insurer_TC4821("Broker");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC893_ActivityRole_ClaimsTransformation_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 680, groups={"TC894_ActivityRole_ClaimsTransformation_ReadOnly_Broker"})
	public void TC894_ActivityRole_ClaimsTransformation_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Transformation","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC894_ActivityRole_ClaimsTransformation_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 681, groups={"TC895_ActivityRole_ClaimAssignment_Standard_Broker"})
	public void TC895_ActivityRole_ClaimAssignment_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsAssignmentRoleChange_Broker();
			BProcessRPC.ClaimAssignment_Standard_Insurer_TC4824("Broker");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC895_ActivityRole_ClaimAssignment_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 682, groups={"TC896_ActivityRole_ClaimAssignment_ReadOnly_Broker"})
	public void TC896_ActivityRole_ClaimAssignment_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Assignment","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC896_ActivityRole_ClaimAssignment_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 683, groups={"TC897_ActivityRole_ClaimApproval_Standard_Broker"})
	public void TC897_ActivityRole_ClaimApproval_Standard_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsApprovalRoleChange_Broker();
			BProcessRPC.ClaimApproval_Standard_Insurer_TC4827("Broker");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC897_ActivityRole_ClaimApproval_Standard_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 684, groups={"TC898_ActivityRole_ClaimApproval_ReadOnly_Broker"})
	public void TC898_ActivityRole_ClaimApproval_ReadOnly_Broker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Approval","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC898_ActivityRole_ClaimApproval_ReadOnly_Broker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	//*******************************************************************Coverholder************************************************************
	
	
	@Test(priority = 685, groups={"TC748_ActivityRole_RiskTransformation_Standard_Coverholderr"})
	public void TC748_ActivityRole_RiskTransformation_Standard_Coverholderr()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.Change_role_Coverholder_RiskTransformation();
			BProcessRPC.RiskInformationStandrdInsirerUser_TC4516("Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 15 of 22 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");
			
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC748_ActivityRole_RiskTransformation_Standard_Coverholderr "+e.getMessage(), "FAIL");
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 686, groups={"TC749_ActivityRole_RiskTransformation_ReadOnly_Coverholder"})
	public void TC749_ActivityRole_RiskTransformation_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Transformation","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC749_ActivityRole_RiskTransformation_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 687, groups={"TC750_ActivityRole_RiskAssignment_Standard_Coverholder"})
	public void TC750_ActivityRole_RiskAssignment_Standard_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskAssignmentRoleChange_Coverholder();
			BProcessRPC.RiskAssignmentStandrdInsirerUser_TC4779("Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC750_ActivityRole_RiskAssignment_Standard_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 688, groups={"TC751_ActivityRole_RiskAssignment_ReadOnly_Coverholder"})
	public void TC751_ActivityRole_RiskAssignment_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Assignment","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC751_ActivityRole_RiskAssignment_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 689, groups={"TC756_ActivityRole_RiskApproval_Standard_Coverholder"})
	public void TC756_ActivityRole_RiskApproval_Standard_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.RiskApprovalRoleChange_Coverholder();
			BProcessRPC.riskApprovalStandardInsurer_TC4789("Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 8 of 8 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC756_ActivityRole_RiskApproval_Standard_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 690, groups={"TC757_ActivityRole_RiskApproval_ReadOnly_Coverholder"})
	public void TC757_ActivityRole_RiskApproval_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Risk_Approval","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC757_ActivityRole_RiskApproval_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 691, groups={"TC759_ActivityRole_PremiumTransformation_Standard_Coverholder"})
	public void TC759_ActivityRole_PremiumTransformation_Standard_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumTransformationRoleChange_Coverholder();
			BProcessRPC.premiumTransformationStandardInsurer_TC4797("Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");
			
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BProcessRPC.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC759_ActivityRole_PremiumTransformation_Standard_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 692, groups={"TC760_ActivityRole_PremiumTransformation_ReadOnly_Coverholder"})
	public void TC760_ActivityRole_PremiumTransformation_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Transformation","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC760_ActivityRole_PremiumTransformation_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 693, groups={"TC764_ActivityRole_PremiumAssignment_Standard_Coverholder"})
	public void TC764_ActivityRole_PremiumAssignment_Standard_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumAssignmentRoleChange_Coverholder();
			BProcessRPC.premiumAssignmentStandardInsurer_TC4806("Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.userableToEditContractDetails,"PASS","Policy not edited" );
			softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.RiskRecordCount,"1 - 12 of 12 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.PremiumRecordCount,"1 - 2 of 2 items","wrong record Count" );
			softAssert.assertEquals(BProcessRPC.ClaimRecirdCount,"1 - 1 of 1 items","wrong record Count" );
			
			softAssert.assertEquals(BProcessRPC.ClaimOptionVisible,"PASS","user can not view Claim option" );			
			softAssert.assertEquals(BProcessRPC.PremiumOptionVisible,"PASS","user can not view Premium option" );
			softAssert.assertEquals(BProcessRPC.RiskOptionVisible,"PASS","user can not view Risk option" );
			softAssert.assertEquals(BProcessRPC.RiskAndPremiumOptionVisible,"PASS","user can not view Risk and Premium option");
			
			softAssert.assertEquals(BProcessRPC.VerifyOverDueAction, "PASS");			
			softAssert.assertNotEquals(BorProc.DeletebuttonNotVisible, "FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC764_ActivityRole_PremiumAssignment_Standard_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 694, groups={"TC765_ActivityRole_PremiumAssignment_ReadOnly_Coverholder"})
	public void TC765_ActivityRole_PremiumAssignment_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Assignment","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC765_ActivityRole_PremiumAssignment_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 695, groups={"TC768_ActivityRole_PremiumApproval_Standard_Coverholder"})
	public void TC768_ActivityRole_PremiumApproval_Standard_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.PremiumApprovalRoleChange_Coverholder();
			BProcessRPC.premiumApprovalStandardInsurer_TC4815("Coverholder");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC768_ActivityRole_PremiumApproval_Standard_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 696, groups={"TC769_ActivityRole_PremiumApproval_ReadOnly_Coverholder"})
	public void TC769_ActivityRole_PremiumApproval_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Premium_Approval","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC769_ActivityRole_PremiumApproval_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 697, groups={"TC770_ActivityRole_ClaimsTransformation_Standard_Coverholde"})
	public void TC770_ActivityRole_ClaimsTransformation_Standard_Coverholde()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsTransformationRoleChange_Coverholder();
			BProcessRPC.ClaimTransformationStandard_Insurer_TC4821("Coverholder");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC770_ActivityRole_ClaimsTransformation_Standard_Coverholde "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 698, groups={"TC773_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder"})
	public void TC773_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Transformation","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC773_ActivityRole_ClaimsTransformation_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 699, groups={"TC776_ActivityRole_ClaimAssignment_Standard_Coverholder"})
	public void TC776_ActivityRole_ClaimAssignment_Standard_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsAssignmentRoleChange_Coverholder();
			BProcessRPC.ClaimAssignment_Standard_Insurer_TC4824("Coverholder");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC776_ActivityRole_ClaimAssignment_Standard_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 700, groups={"TC777_ActivityRole_ClaimAssignment_ReadOnly_Coverholder"})
	public void TC777_ActivityRole_ClaimAssignment_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Assignment","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC777_ActivityRole_ClaimAssignment_ReadOnly_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 701, groups={"TC778_ActivityRole_ClaimApproval_Standard_Coverholder"})
	public void TC778_ActivityRole_ClaimApproval_Standard_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsApprovalRoleChange_Coverholder();
			BProcessRPC.ClaimApproval_Standard_Insurer_TC4827("Coverholder");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC778_ActivityRole_ClaimApproval_Standard_Coverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 702, groups={"TC779_ActivityRole_ClaimApproval_ReadOnly_Coverholder"})
	public void TC779_ActivityRole_ClaimApproval_ReadOnly_Coverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Approval","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC779_ActivityRole_ClaimApproval_ReadOnly_Coverholder"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority = 703, groups={"TC734_ActivityRole_ClaimsTransformation_Standard_TPA"})
	public void TC734_ActivityRole_ClaimsTransformation_Standard_TPA
()
	{
		SoftAssert softAssert = new SoftAssert();
		try
 		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsTransformationRoleChange_TPA();
			BProcessRPC.ClaimTransformationStandard_Insurer_TC4821("TPA");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC734_ActivityRole_ClaimsTransformation_Standard_TPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 704, groups={"TC735_ActivityRole_ClaimsTransformation_ReadOnly_TPA"})
	public void TC735_ActivityRole_ClaimsTransformation_ReadOnly_TPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(TPARead_Only, TPA_Read_Passwd);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Transformation","TPA");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC735_ActivityRole_ClaimsTransformation_ReadOnly_TPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 705, groups={"TC736_ActivityRole_ClaimAssignment_Standard_TPA"})
	public void TC736_ActivityRole_ClaimAssignment_Standard_TPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsAssignmentRoleChange_TPA();
			BProcessRPC.ClaimAssignment_Standard_Insurer_TC4824("TPA");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC736_ActivityRole_ClaimAssignment_Standard_TPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 706, groups={"TC737_ActivityRole_ClaimAssignment_ReadOnly_TPA"})
	public void TC737_ActivityRole_ClaimAssignment_ReadOnly_TPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(TPARead_Only, TPA_Read_Passwd);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Assignment","TPA");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC737_ActivityRole_ClaimAssignment_ReadOnly_TPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 707, groups={"TC738_ActivityRole_ClaimApproval_Standard_TPA"})
	public void TC738_ActivityRole_ClaimApproval_Standard_TPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminUsername, AdminPassword);
			BProcessRPC.ClaimsApprovalRoleChange_TPA();
			BProcessRPC.ClaimApproval_Standard_Insurer_TC4827("TPA");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC738_ActivityRole_ClaimApproval_Standard_TPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 708, groups={"TC739_ActivityRole_ClaimApproval_ReadOnly_TPA"})
	public void TC739_ActivityRole_ClaimApproval_ReadOnly_TPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(TPARead_Only, TPA_Read_Passwd);
			BProcessRPC.Read_Only_User_ActivityRole("Claim_Approval","TPA");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC739_ActivityRole_ClaimApproval_ReadOnly_TPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 709, groups={"TC731_ContractRole_Insurer_Standard"})
	public void TC731_ContractRole_Insurer_Standard()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin("standard.brookes@aspen.co.uk", "Test123@");
			BProcessRPC.Contract_Role_For_Company_Type("Insurer");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC731_ContractRole_Insurer_Standard "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 710, groups={"TC732_ContractRole_Insurer_ReadOnly"})
	public void TC732_ContractRole_Insurer_ReadOnly()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(AdminInsureRead, AdminInsurePassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Insurer","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC732_ContractRole_Insurer_ReadOnly "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 711, groups={"TC728_ContractRole_Broker_Standard"})
	public void TC728_ContractRole_Broker_Standard()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin("tk.tester007@gmail.com", "Test123@");
			BProcessRPC.Contract_Role_For_Company_Type("Broker");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC728_ContractRole_Broker_Standard "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 712, groups={"TC729_ContractRole_Broker_ReadOnly"})
	public void TC729_ContractRole_Broker_ReadOnly()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(BrokerRead, BrokerPassRead);
			BProcessRPC.Read_Only_User_ActivityRole("Broker","Broker");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC729_ContractRole_Broker_ReadOnly "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 713, groups={"TC725_ContractRole_Coverholder_Standard"})
	public void TC725_ContractRole_Coverholder_Standard()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin("john.smith@coverholderinc.com", "Pa55word123");
			BProcessRPC.Contract_Role_For_Company_Type("Coverholder");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC725_ContractRole_Coverholder_Standard "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 714, groups={"TC726_ContractRole_Coverholder_ReadOnly"})
	public void TC726_ContractRole_Coverholder_ReadOnly()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(CoverholderRead, CoverholderReadPass);
			BProcessRPC.Read_Only_User_ActivityRole("Coverholder","Coverholder");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC726_ContractRole_Coverholder_ReadOnly "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 715, groups={"TC721_ContractRole_TPA_Standard"})
	public void TC721_ContractRole_TPA_Standard()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin("standarduser@test.com", "Test123@");
			BProcessRPC.Contract_Role_For_Company_Type("TPA");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC721_ContractRole_TPA_Standard "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 716, groups={"TC722_ContractRole_TPA_ReadOnly"})
	public void TC722_ContractRole_TPA_ReadOnly()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(TPARead_Only, TPA_Read_Passwd);
			BProcessRPC.Read_Only_User_ActivityRole("TPA","TPA");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC722_ContractRole_TPA_ReadOnly "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	@Test(priority = 717, groups={"TC722_ContractRole_TPA_ReadOnly"})
	public void TC1860_InurerSection_assignment()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(TPARead_Only, TPA_Read_Passwd);
			BProcessRPC.Read_Only_User_ActivityRole("TPA","TPA");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC722_ContractRole_TPA_ReadOnly "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 718, groups={"TC1657_ContractRole_RegulatorRole_Standard"})
	public void TC1657_ContractRole_RegulatorRole_Standard()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(RegulatorStd, RegulatorPWD);
			BProcessRPC.Read_Only_User_ActivityRole("Insurer","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1657_ContractRole_RegulatorRole_Standard "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}

	@Test(priority = 719, groups={"TC1657_ContractRole_RegulatorRole_Standard"})
	public void TC1657_ContractRole_RegulatorRole_ReadOnly()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(RegulatorReadonly, RegulatorPWD);
			BProcessRPC.Read_Only_User_ActivityRole("Insurer","Insurer");
			softAssert.assertEquals(BProcessRPC.Verifypolicyopened,"PASS","Policy not opened");
			softAssert.assertEquals(BProcessRPC.policyEditOptionHidden,"PASS","Policy can be edited");
            softAssert.assertEquals(BProcessRPC.VerifyCannotEditRole,"PASS","user can not edit role" );
			
			softAssert.assertEquals(BProcessRPC.IsVisibleSubmitBordButton1,"PASS","Submit bordereau visible");			
		
			softAssert.assertNotEquals(BProcessRPC.OverdueActionAllowed, "FAIL");
			
			
			softAssert.assertNotEquals(BorProc.DeleteOptionVisible, "FAIL");
			softAssert.assertNotEquals(BorProc.StatusButtonClickable,"FAIL");
			
			softAssert.assertNotEquals(BorProc.UnapproveBtnEnabled, "FAIL");
			softAssert.assertNotEquals(BProcessRPC.VerifyViewonlySectionAssignmentButton, "FAIL");
			softAssert.assertEquals(BProcessRPC.AddReportingChannelVisible, "PASS");
			softAssert.assertEquals(BProcessRPC.EditReportingChannelVisible, "PASS");
	
			
			softAssert.assertEquals(BProcessRPC.IsvisibleBreachStatus, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsVisibleAddFile, "PASS");
			
			softAssert.assertEquals(BProcessRPC.IsvisibleAddMarket, "PASS");
			softAssert.assertEquals(BProcessRPC.ISVisibleAddRiskCode, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1657_ContractRole_RegulatorRole_Standard "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
}