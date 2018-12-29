package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.RecordVideo;
import com.tide.qa.utility.Report;

@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class InitializerTest extends TestBase
{
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage = new LoginPage();
	String AdminUsername = "dev.admin@tideapp.co.uk";
	String AdminPassword = "Yb0kMlJ;z8Ho33mO";
	
	String AdminUsername1 = "insurer01.ca@tideapp.co.uk";
	String AdminPassword1 = "4KJT8KpeUTJZkNf";
	
	String AdminUsername2 = "broker01.ca@tideapp.co.uk";
	String AdminPassword2= "HuCSbq7589wNU4M";
		
	@Test(priority = 1, groups={"LoginToTideAdmin"})
	public void LoginToTideAdmin()
	{
	// 706	
		SoftAssert softAssert = new SoftAssert();	
		try
		{
			
		String page =	loginPage.tideLogin(AdminUsername, AdminPassword);	
		softAssert.assertNotNull(page);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 17, groups={"ReLoginToTideAdmin"})
	public void ReLoginToTideAdmin()
	{
		

		try
		{
			
			loginPage.tideLogin(AdminUsername, AdminPassword);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in ReLoginToTideAdmin"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 13, groups={"LoginToTideCompanyAdmin"})
	public void LoginToTideCompanyAdmin()
	{
	

		try
		{
			
			loginPage.tideLogin(AdminUsername1, AdminPassword1);
			System.out.println("Test Case One in " + getClass().getSimpleName()
					+ " with Thread Id:- " + Thread.currentThread().getId());

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
	
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 301, groups={"LoginToTideCompanyAdmin2"})
	public void LoginToTideCompanyAdmin2()
	{

		try
		{
		
			loginPage.tideLogin(AdminUsername1, AdminPassword1);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTideCompanyAdmin2"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority = 610, groups={"LoginToTideAdmin2"})
	public void LoginToTideAdmin2()
	{

		try
		{
			loginPage.tideLogin(AdminUsername2, AdminPassword2);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 3000, groups={"LogOut"})
	public void LogOut()
	{
		try
		{
			
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in LoginToTide"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 12, groups={"TideAdminLogOut"})
	public void TideAdminLogOut()
	{

		try
		{
			
			loginPage.tideReadOnlyLogOut();
			System.out.println("Test Case One in " + getClass().getSimpleName()
					+ " with Thread Id:- " + Thread.currentThread().getId());

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TideAdminLogOut"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 300, groups={"TideAdminLogout2"})
	public void TideAdminLogout2()  
	{

		try
		{
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =863, groups={"TideAdminLogout3"})
	public void TideAdminLogOut3()
	{

		try
		{
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TideAdminLogout3"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 16, groups={"CompanyAdminLogout"})
	public void CompanyAdminLogout()
	{

		try
		{
			loginPage.tideReadOnlyLogOut();
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in CompanyAdminLogout"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 609, groups={"CompanyAdminLogout2"})
	public void CompanyAdminLogout2()
	{
		try
		{
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in CompanyAdminLogout2"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
}
	@Test(priority = 1176, groups={"ReLoginToTideAdmin2"})
	public void ReLoginToTideAdmin2()
	{
		

		try
		{
			
			loginPage.tideLogin(AdminUsername, AdminPassword);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in ReLoginToTideAdmin2"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 819, groups={"ReLoginToTideAdmin3"})
	public void ReLoginToTideAdmin3()
	{
		

		try
		{
			
			loginPage.tideLogin(AdminUsername, AdminPassword);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in ReLoginToTideAdmin3"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}


	@Test(priority =1515, groups={"TideAdminLogOut4"})
	public void TideAdminLogOut4()
	{

		try
		{
			loginPage.tideReadOnlyLogOut();

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TideAdminLogout3"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	}
