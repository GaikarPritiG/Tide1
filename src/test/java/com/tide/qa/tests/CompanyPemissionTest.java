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
import com.tide.qa.pagefactory.CompanyPage;
import com.tide.qa.pagefactory.CompanyPermissionPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.OutputFormatPage;
import com.tide.qa.pagefactory.Stage2Page;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class CompanyPemissionTest extends TestBase
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
	CompanyPage companyPage = new CompanyPage();
	CompanyPermissionPage CP = new CompanyPermissionPage();
	String AdminUsername = "nilesh1@otak.co.uk";
	String AdminPassword = "systenics123@";
	
	String AdminUsername1 = "kruthika@systenics.net";
	String AdminPassword1 = "apple@4169";
	
	String AdminUsername1Std = "tushark@systenics.net";
	String AdminPassword1Std = "test1234@";
	
	String AdminUsername1ReadOnly = "aarifa@systenics.net";
	String AdminPassword1ReadOnly = "test1234@";
	
	@Test(priority =890, groups={"TC771_CompanyPermissionTideAdmin"})
	public void TC771_CompanyPermissionTideAdmin()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
		
			login.tideLogin(rd.getDataFromCell(path, "TestData", 60, 3),rd.getDataFromCell(path, "TestData", 60, 5));
			CP.CompanyPermissionTideAdmin_4050();
			softAssert.assertEquals(companyPage.actualcompnayname,companyPage.expectedcompanyname,"Company Name Not edited " );	
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC771_CompanyPermissionTideAdmin "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
	
	@Test(priority =891, groups={"TC772_CompanyPermissionCompanyAdmin"})
	public void TC772_CompanyPermissionCompanyAdmin()
	{
		SoftAssert softAssert = new SoftAssert();
			try
		{
		
			login.tideLogin(rd.getDataFromCell(path, "TestData", 37, 3),rd.getDataFromCell(path, "TestData", 37, 5));
			CP.CompanyUserComAdmin_4051();
			softAssert.assertEquals(companyPage.actualActivetxt,companyPage.expActive,"User status not activated" );
			softAssert.assertEquals(companyPage.actualDeactivetxt,companyPage.expDeactive,"User status not inactive");
			 softAssert.assertEquals(companyPage.ActualMobileNumber,companyPage.EditedMobileno,"User status not inactive"); 


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC772_CompanyPermissionCompanyAdmin "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}
	
	@Test(priority =892, groups={"TC774_CompanyStandardUser"})
	public void TC774_CompanyStandardUser()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 38, 3),rd.getDataFromCell(path, "TestData", 38, 5));
			CP.CompanyStandardUser_4052();
			softAssert.assertEquals(CP.Add_new_Division_ButtonVisible, "PASS");
			softAssert.assertEquals(CP.AddNewUserButtonVisible, "PASS");
			softAssert.assertEquals(CP.Add_New_SubDivision_ButtonVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC774_CompanyStandardUser "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
			}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}
	
	@Test(priority =893, groups={"TC775_CompanyReadOnlyUser"})
	public void TC775_CompanyReadOnlyUser()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 39, 3),rd.getDataFromCell(path, "TestData", 39, 5));
			CP.CompanyReadOnlyUser_4053();
			softAssert.assertEquals(CP.Add_new_Division_ButtonVisible, "PASS");
			softAssert.assertEquals(CP.AddNewUserButtonVisible, "PASS");
			softAssert.assertEquals(CP.Add_New_SubDivision_ButtonVisible, "PASS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC775_CompanyReadOnlyUser "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}
}
