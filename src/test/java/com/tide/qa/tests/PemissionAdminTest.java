package com.tide.qa.tests;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.AdminPermissionPage;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.DatasetReferenceDataPage;
//import com.tide.qa.pagefactory.CompanyPermissionPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.OutputFormatPage;
import com.tide.qa.pagefactory.RateOfExchangePage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class PemissionAdminTest extends TestBase
{

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
	BordereauProcessPage sheets = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	//CompanyPermissionPage CP = new CompanyPermissionPage();
	AdminPermissionPage AP = new AdminPermissionPage();
	RateOfExchangePage exchange = new RateOfExchangePage();
	DatasetReferenceDataPage datasetReferenceData = new DatasetReferenceDataPage();
	String AdminUsername = "nilesh1@otak.co.uk";
	String AdminPassword = "systenics123@";
	
	String AdminUsername1 = "kruthika@systenics.net";
	String AdminPassword1 = "apple@4169";
	
	String AdminUsername1Std = "tushark@systenics.net";
	String AdminPassword1Std = "test1234@";
	
	String AdminUsername1ReadOnly = "aarifa@systenics.net";
	String AdminPassword1ReadOnly = "test1234@";
	
	String AdminUsername1CompBrocker = "ankit@systenics.net";
	String AdminPassword1CompBrocker = "test1234@";
	
	String AdminUsername1StandrdBrocker = "praniket@systenics.net";
	String AdminPassword1StandrdBrocker = "systenics123@";
	
	String AdminUsername1ReadOnlyBrok = "broker_ro@otak.co.uk";
	String AdminPassword1ReadOnlyBrok = "systenics123@";
	
	String AdminUsernameCoverHolder = "shruti@systenics.net";
	String AdminPasswordCoverHolder = "test1234@";
	
	String AdminUsernameStandrdCoverHolder = "madhuri@systenics.net";
	String AdminPasswordStandrdCoverHolder =  "test1234@";
	
	String AdminUsernameReadOnlyCoverHolder = "atul@systenics.net";
	String AdminPasswordReadOnlyCoverHolder ="test1234@";
	
	String AdminUsernameTPA = "shrutika@systenics.net";
	String AdminPasswordTPA = "test1234@";
	
	String AdminUsernameStandardTPA = "aniket@systenics.net";
	String AdminPasswordStandardTPA = "test1234@";
	
	String AdminUsernameReadoTPA = "ankita@systenics.net";
	String AdminPasswordReadoTPA = "systenics@123";
	
	String AdminUsernameServicePrvd = "nilesh@systenics.com";
	String AdminPasswordServicePrvd = "Test123@";
	
	String StandrdUsernameServicePrvd = "shrutika09deshmukh@gmail.com";
	String StandrdPasswordServicePrvd = "Test123@";
	
	String ReadOnlyUsernameTypServicePrvd = "tushar.driven@gmail.com";
	String ReadOnlyPasswordTypServicePrvd = "Systenics123@";
			
	@Test(priority =877, groups={"TC690_AdminOperations"})
	public void TC690_AdminOperations()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 60, 3),rd.getDataFromCell(path, "TestData", 60, 5));
			AP.AdminPermission_4174();
			softAssert.assertNotNull(datasetReferenceData.DatasetReferenceDataName);
			//softAssert.assertEquals(datasetReferenceData.ActualValue1, "Autovalue 1");
		//	softAssert.assertEquals(datasetReferenceData.ActualMapping1, "Mapping Value");
		//	softAssert.assertNotNull(exchange.Actualvalue);
			softAssert.assertEquals(exchange.ActualError, exchange.ExpectedError);
		//	softAssert.assertNotNull(exchange.TideExchangRateValue);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC690_AdminOperations "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =878, groups={"TC691_AdminTypeInsurer"})
	public void TC691_AdminTypeInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 37, 3),rd.getDataFromCell(path, "TestData", 37, 5));
			AP.ComAdminTypeInsurer_4175();
			softAssert.assertEquals(AP.AddDatasetReferenceDataBtnVisible, "PASS");
			softAssert.assertEquals(AP.AddValueBtnVisible, "PASS");
			softAssert.assertEquals(AP.NewMappingBtnVisible, "PASS");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC691_AdminTypeInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =879, groups={"TC696_StandardUserTypeInsurer"})
	public void TC696_StandardUserTypeInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 38, 3),rd.getDataFromCell(path, "TestData", 38, 5));
			AP.StandardUserTypeInsurer_4180();
			softAssert.assertEquals(AP.DatasetReferenceDataLinkVisible, "PASS");
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC696_StandardUserTypeInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =880, groups={"TC701_ReadOnlyUserTypeInsurer"})
	public void TC701_ReadOnlyUserTypeInsurer()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 39, 3),rd.getDataFromCell(path, "TestData", 39, 5));
			AP.ReadOnlyUserTypeInsurer_4185();
			softAssert.assertEquals(AP.adminDropdownVisible, "PASS");
			}
		catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC701_ReadOnlyUserTypeInsurer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}
	
	@Test(priority =881, groups={"TC692_CompAdminTypeBrocker"})
	public void TC692_CompAdminTypeBrocker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 41, 3),rd.getDataFromCell(path, "TestData", 41, 5));
			AP.ComAdminTypeBrocker_4176();
			softAssert.assertEquals(AP.AddDatasetReferenceDataBtnVisible, "PASS");
			softAssert.assertEquals(AP.AddValueBtnVisible, "PASS");
			softAssert.assertEquals(AP.NewMappingBtnVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC692_CompAdminTypeBrocker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}
	
	@Test(priority =882, groups={"TC697_StandrdUserTypeBrocker"})
	public void TC697_StandrdUserTypeBrocker()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 42, 3),rd.getDataFromCell(path, "TestData", 42, 5));
			AP.StandardUserTypeBroker_4181();
			softAssert.assertEquals(AP.DatasetReferenceDataLinkVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC697_StandrdUserTypeBrocker "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =883, groups={"TC702_ReadOnlyUserTypeBrocker"})
	public void TC702_ReadOnlyUserTypeBrocker()
	{
		SoftAssert softAssert = new SoftAssert();
		try{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 43, 3),rd.getDataFromCell(path, "TestData", 43, 5));
			AP.ReadOnlyUserTypeBrocker_4186();
			softAssert.assertEquals(AP.adminDropdownVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC702_ReadOnlyUserTypeBrocker "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =884, groups={"TC693_ComAdminTypeCoverholder"})
	public void TC693_ComAdminTypeCoverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 45, 3),rd.getDataFromCell(path, "TestData", 45, 5));
			AP.ComAdminTypeCoverHolder_4177();
			softAssert.assertEquals(AP.AddDatasetReferenceDataBtnVisible, "PASS");
			softAssert.assertEquals(AP.AddValueBtnVisible, "PASS");
			softAssert.assertEquals(AP.NewMappingBtnVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC693_ComAdminTypeCoverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =885, groups={"TC698_StanduserTypeCoverholder"})
	public void TC698_StanduserTypeCoverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 46, 3),rd.getDataFromCell(path, "TestData", 46, 5));
			AP.StandardUserTypeCoverHolder_4182();
			softAssert.assertEquals(AP.DatasetReferenceDataLinkVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC698_StanduserTypeCoverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =886, groups={"TC703_ReadOnlyTypeCoverholder"})
	public void TC703_ReadOnlyTypeCoverholder()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 47, 3),rd.getDataFromCell(path, "TestData", 47, 5));
			AP.ReadOnlyUserTypeCoverHolder_4187();
			softAssert.assertEquals(AP.adminDropdownVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC703_ReadOnlyTypeCoverholder "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}

	@Test(priority =887, groups={"TC694_CompAdminTypeTPA"})
	public void TC694_CompAdminTypeTPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 53, 3),rd.getDataFromCell(path, "TestData", 53, 5));
			AP.ComAdminTypeTPA_4178();
			softAssert.assertEquals(AP.AddDatasetReferenceDataBtnVisible, "PASS");
			softAssert.assertEquals(AP.AddValueBtnVisible, "PASS");
			softAssert.assertEquals(AP.NewMappingBtnVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC694_CompAdminTypeTPA"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
		
	@Test(priority =888, groups={"TC699_StandardUserTypeTPA"})
	public void TC699_StandardUserTypeTPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 54, 3),rd.getDataFromCell(path, "TestData", 54, 5));
			AP.StandardUserTypeTPA_4183();
			softAssert.assertEquals(AP.DatasetReferenceDataLinkVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC699_StandardUserTypeTPA"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally 
		{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}

	@Test(priority =889, groups={"TC705_ReadOnlyTypeTPA"})
	public void TC705_ReadOnlyTypeTPA()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 55, 3),rd.getDataFromCell(path, "TestData", 55, 5));
			AP.ReadOnlyUserTypeTPA_4189();
			softAssert.assertEquals(AP.adminDropdownVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC705_ReadOnlyTypeTPA"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			
		}finally
		{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}

/*	@Test(priority =630, groups={"TC695_CompAdminTypeServiceProvider"})
	public void TC695_CompAdminTypeServiceProvider()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			login.tideLogin(AdminUsernameServicePrvd, AdminPasswordServicePrvd);
			AP.CompAdminUserTypeServiceProvdr_4179();
			softAssert.assertEquals(AP.AddDatasetReferenceDataBtnVisible, "PASS");
			softAssert.assertEquals(AP.AddValueBtnVisible, "PASS");
			softAssert.assertEquals(AP.NewMappingBtnVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC695_CompAdminTypeServiceProvider"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}
	
	@Test(priority =631, groups={"TC700_StandrdUserTypeServiceProvider"})
	public void TC700_StandrdUserTypeServiceProvider()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			login.tideLogin(StandrdUsernameServicePrvd, StandrdPasswordServicePrvd);
			AP.StandardUserTypeServiceProdr_4184();
			softAssert.assertEquals(AP.DatasetReferenceDataLinkVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC700_StandrdUserTypeServiceProvider"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =632, groups={"TC704_ReadOnlyUserTypeServiceProvider"})
	public void TC704_ReadOnlyUserTypeServiceProvider()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(ReadOnlyUsernameTypServicePrvd, ReadOnlyPasswordTypServicePrvd);
			AP.ReadOnlyUserTypeServicePro_4188();
			softAssert.assertEquals(AP.adminDropdownVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC704_ReadOnlyUserTypeServiceProvider"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	*/
}
