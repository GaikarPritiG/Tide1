package com.tide.qa.tests;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.DatasetReferenceDataPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.Permissions;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.RateOfExchangePage;
import com.tide.qa.pagefactory.Rules;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class PermissionsTest extends TestBase {
	
	String path;
	GlobalVariables g = new GlobalVariables();
	{ 
		try {
			String path = new File(".").getCanonicalPath();
			g = new GlobalVariables();
			g.setRelativePath(path);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		path = "./src/test/resources/TestData.xls";
	}
	ReadExcelFile rd = new ReadExcelFile();
	
	LoginPage login = new LoginPage();
	Permissions permission = new Permissions();
	Rules rule = new Rules();
	RateOfExchangePage exchange = new RateOfExchangePage();
	DatasetReferenceDataPage datasetReferenceData = new DatasetReferenceDataPage();
	PolicyPage policy = new PolicyPage();
	String Admin1Username1 = "dave.brit@brit.com";
	String Admin1Password1 ="Test123@";
	String AdminUsername = "nilesh1@otak.co.uk";
	String AdminPassword = "systenics123@";
	String Admin1Username2 = "kruthika@systenics.net";
	String Admin1Password2 ="apple@4169";
	String StandardUsername = "tushark@systenics.net";
	String StandardPassword = "test1234@";
	String ReadonlyUserCompanyTypeInsurerUserName = "readonly.brookes@aspen.co.uk";
	String ReadonlyUserCompanyTypeInsurerPassword = "Test123@";
	String CompanyAdminTypeBrokerUserNamae = "ankit@systenics.net";
	String CompanyAdminTypeBrokerPassword = "test1234@";
	String CompanyAdminTypeBrokerUserNama1 = "broker_ro@otak.co.uk";
	String CompanyAdminTypeBrokerPassword1 = "systenics123@";
	String StandardUserCompanyTypeBrokerUsername = "praniket@systenics.net";
	String StandardUserCompanyTypeBrokerPassword = "systenics123@";
	String ReadOnlyUserCompanyTypeInsuranceUsername = "aarifa@systenics.net";
	String ReadOnlyUserCompanyTypeInsurancePassword = "test1234@";
	String StandardUserTypeCoverholderUsername = "madhuri@systenics.net";
	String StandardUserTypeCoverholderPassword = "test1234@";
	String CompanyAdminTypeCoverholderUsername = "shruti@systenics.net";
	String CompanyAdminTypeCoverholderPassword = "test1234@";
	String ReadOnlyUserTypeCoverholderUsername = "atul@systenics.net";
	String ReadOnlyUserTypeCoverholderPassword = "test1234@";
	String CompanyAdminCompanyTypeTPAUsername = "shrutika@systenics.net";
	String CompanyAdminCompanyTypeTPAPassword = "test1234@";
	String StandardUserCompanyTypeTPAUsername = "aniket@systenics.net";
	String StandardUserCompanyTypeTPAPassword = "test1234@";
	String ReadUserCompanyTypeTPAUsername = "ankita@systenics.net";
	String ReadUserCompanyTypeTPAPassword = "systenics@123";
	String CompanyAdminTypeServiceProviderUsername = "nilesh@systenics.com";
	String CompanyAdminTypeServiceProviderPassword = "Test123@";
	String StandardUserTypeServiceProviderUsername = "shrutika09deshmukh@gmail.com";
	String StandardUserTypeServiceProviderPassword = "Test123@";
	String ReadUserTypeServiceProviderUsername = "tushar.driven@gmail.com";
	String ReadUserTypeServiceProviderPassword = "Systenics123@";
	//test
	
	@Test(priority = 864, groups={"TC706_ContractTideAdminPermission"})
	public void TC706_ContractTideAdminPermission
()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			login.tideLogin(rd.getDataFromCell(path, "TestData", 60, 3),rd.getDataFromCell(path, "TestData", 60, 5));
			permission.ContractTideAdminPermission_4141();
			
			softAssert.assertEquals(policy.CntractStatusSigned, "SIGNED");
			softAssert.assertEquals(permission.titleText, "Folder Details");			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC706_ContractTideAdminPermission"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			
			login.tideAdminLogOut();
			softAssert.assertAll();
		}
	
	}
	
	@Test(priority = 865, groups={"TC707_CompanyAdminPermissionCompanyTypeInsurer"})
	public void TC707_CompanyAdminPermissionCompanyTypeInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			login.tideLogin(rd.getDataFromCell(path, "TestData", 37, 3),rd.getDataFromCell(path, "TestData", 37, 5));
			permission.CompanyAdminPermissionForCompanyTypeInsurer_4142();
			softAssert.assertEquals(policy.CntractStatusSigned, "SIGNED");
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC707_CompanyAdminPermissionCompanyTypeInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideCompanyAdminLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 866, groups={"TC708_StandardUserPermissionCompanyInsurer"})
	public void TC708_StandardUserPermissionCompanyInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
		
			login.tideLogin(rd.getDataFromCell(path, "TestData", 38, 3),rd.getDataFromCell(path, "TestData", 38, 5));
			permission.StandardUserPermissionCompanyInsurer_4143();

			softAssert.assertEquals(policy.CntractStatusSigned, "SIGNED");
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC708_StandardUserPermissionCompanyInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 867, groups={"TC709_ReadOnlyPermissionCompanyTypeInsurer"})
	public void TC709_ReadOnlyPermissionCompanyTypeInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 39, 3),rd.getDataFromCell(path, "TestData", 39, 5));
			permission.ContractReadOnlyPermissionCompanyTypeInsurer_4144();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC709_ReadOnlyPermissionCompanyTypeInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 868, groups={"TC717_CompanyAdminPermissionCoverholder"})
	public void TC717_CompanyAdminPermissionCoverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 45, 3),rd.getDataFromCell(path, "TestData", 45, 5));
			permission.ContractCompanyAdminPermissionCompanyTypeCoverholder_4330();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC717_CompanyAdminPermissionCoverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}	
	
	@Test(priority = 869, groups={"TC747_StandardUserPermissionCoverholder"})
	public void TC747_StandardUserPermissionCoverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 46, 3),rd.getDataFromCell(path, "TestData", 46, 5));
			permission.ContractStandardUserPermissionCompanyTypeCoverholder_4329();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC747_StandardUserPermissionCoverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 870, groups={"TC752_ContractReadOnlyPermissionCoverholder"})
	public void TC752_ContractReadOnlyPermissionCoverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 47, 3),rd.getDataFromCell(path, "TestData", 47, 5));
			permission.ContractReadOnlyPermissionCompanyTypeCoverholder_4325();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC752_ContractReadOnlyPermissionCoverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}

	@Test(priority = 871, groups={"TC714_CompanyAdminPermissionCompanyTypeTPA"})
	public void TC714_CompanyAdminPermissionCompanyTypeTPA()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 53, 3),rd.getDataFromCell(path, "TestData", 53, 5));
			permission.CompanyAdminPermissionCompanyTypeTPA_4327();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC714_CompanyAdminPermissionCompanyTypeTPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}

	
	@Test(priority = 872, groups={"TC715_StandardUserPermissionCompanyTypeTPA"})
	public void TC715_StandardUserPermissionCompanyTypeTPA()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 54, 3),rd.getDataFromCell(path, "TestData", 54, 5));
			permission.StandardUserPermissionCompanyTypeTPA_4328();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC715_StandardUserPermissionCompanyTypeTPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 873, groups={"TC716_ReadOnlyPermissionForCompanyTypeTPA"})
	public void TC716_ReadOnlyPermissionForCompanyTypeTPA()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 55, 3),rd.getDataFromCell(path, "TestData", 55, 5));
			permission.ReadOnlyPermissionForCompanyTypeTPA_4326();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC716_ReadOnlyPermissionForCompanyTypeTPA "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	/*@Test(priority = 611, groups={"TC752_CompanyAdminPermissionServiceProvider"})
	public void TC752_CompanyAdminPermissionServiceProvider()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(CompanyAdminTypeServiceProviderUsername,CompanyAdminTypeServiceProviderPassword);
			permission.ContractCompanyAdminPermissionForCompanyTypeServiceProvider_4331();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC752_CompanyAdminPermissionServiceProvider "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	} 
	
	@Test(priority = 612, groups={"TC753_StandardUserPermissionServiceProvider"})
	public void TC753_StandardUserPermissionServiceProvider()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(StandardUserTypeServiceProviderUsername,StandardUserTypeServiceProviderPassword);
			permission.StandardUserPermissionForCompanyTypeServiceProvider_4332();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC753_StandardUserPermissionServiceProvider "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 613, groups={"TC754_ReadOnlyPermissionForCompanyTypeServiceProvider"})
	public void TC754_ReadOnlyPermissionForCompanyTypeServiceProvider()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(ReadUserTypeServiceProviderUsername,ReadUserTypeServiceProviderPassword);
			permission.ReadOnlyPermissionForCompanyTypeServiceProvider_4333();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC754_ReadOnlyPermissionForCompanyTypeServiceProvider "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			softAssert.assertAll();
		}
	}	
	*/
	
	
	@Test(priority = 874, groups={"TC711_CompanyAdminPermissionCompanyTypeBroker"})
	public void TC711_CompanyAdminPermissionCompanyTypeBroker()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 41, 3),rd.getDataFromCell(path, "TestData", 41, 5));
			permission.CompanyAdminPermissionCompanyTypeBroker_4148();
			softAssert.assertEquals(policy.CntractStatusSigned, "SIGNED");
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC711_CompanyAdminPermissionCompanyTypeBroker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 875, groups={"TC712_StandardUserPermissionCompanyTypeBroker"})
	public void TC712_StandardUserPermissionCompanyTypeBroker()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 42, 3),rd.getDataFromCell(path, "TestData", 42, 5));
			permission.StandardUserPermissionCompanyTypeBroker_4149();
			softAssert.assertEquals(policy.CntractStatusSigned, "SIGNED");
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC712_StandardUserPermissionCompanyTypeBroker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 876, groups={"TC755_ContractReadOnlyPermissionForCompanyTypeBroker"})
	public void TC755_ContractReadOnlyPermissionForCompanyTypeBroker()
	{
		SoftAssert softAssert = new SoftAssert();
		
		try
		{	
			login.tideLogin(rd.getDataFromCell(path, "TestData", 43, 3),rd.getDataFromCell(path, "TestData", 43, 5));
			permission.ContractReadOnlyPermissionForCompanyTypeBroker_4335();
			softAssert.assertEquals(permission.titleText, "Folder Details");
			softAssert.assertEquals(permission.IsSchemaEdit, "PASS");
			softAssert.assertEquals(permission.IsCompEdit, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC755_ContractReadOnlyPermissionForCompanyTypeBroker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}
		finally{
			login.tideReadOnlyLogOut();			
			softAssert.assertAll();
		}
	}

}
