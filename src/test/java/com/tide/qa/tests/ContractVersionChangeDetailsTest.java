package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.ContractVersionChangeDetailsPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class ContractVersionChangeDetailsTest extends TestBase {

	ContractVersionChangeDetailsPage ContractVersionPage = new ContractVersionChangeDetailsPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername1 = "priti@systenics.net";
	String AdminPassword1 = "test1234@";
	PolicyPage policy = new PolicyPage();
	@Test(priority = 66, groups={"TC414_VersionChanges_Settings"})
	public void TC414_VersionChanges_Settings()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			ContractVersionPage.VersionChanges_Settings_TC4402();
			softAssert.assertEquals(ContractVersionPage.ActualVersion, "1");
			softAssert.assertEquals(ContractVersionPage.ActualChangeType, "Settings");
			softAssert.assertEquals(ContractVersionPage.ActualCorrections, "-");
			softAssert.assertEquals(ContractVersionPage.ActualVersionChanges, "Reporting Channel Added - Claim Bordereaux");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC414_VersionChanges_Settings "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	@Test(priority = 67, groups={"TC415_VersionChanges_Contract"})
	public void TC415_VersionChanges_Contract()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			ContractVersionPage.VersionChanges_Contract_TC4406();
			softAssert.assertEquals(ContractVersionPage.Version2, "2");
			softAssert.assertEquals(ContractVersionPage.Status2, "Draft Endorsement");
			softAssert.assertEquals(ContractVersionPage.Version3, "3");
			softAssert.assertEquals(ContractVersionPage.Status3, "Signed");
			
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC415_VersionChanges_Contract "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	@Test(priority = 97, groups={"TC416_Version_Changes_ContractAndSettings"})
	public void TC416_Version_Changes_ContractAndSettings()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			ContractVersionPage.Version_Changes_ContractAndSettings_TC4414();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC416_Version_Changes_ContractAndSettings"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority = 109, groups={"TC4121_ClaimAuthority_Add_Edit_Delete"})
	public void TC4121_ClaimAuthority_Add_Edit_Delete()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			ContractVersionPage.ClaimAuthority_Add_Edit_Delete_TC4121();
			//softAssert.assertEquals(ContractVersionPage.Version2, "2");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4121_ClaimAuthority_Add_Edit_Delete"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
}
