package com.tide.qa.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.tide.qa.common.PageBase;

import com.tide.qa.pagefactory.CompanyPage;
import com.tide.qa.pagefactory.LoginPage;

import com.tide.qa.utility.Report;
import org.testng.asserts.SoftAssert;
import junit.framework.Assert;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class CompanyTests extends PageBase
{	
	CompanyPage companyPage = new CompanyPage();
	LoginPage login = new LoginPage();
	 String AdminUsername = "admin@tide.com";
	 String AdminPassword = "Test123@";
		
	
	@Test(priority = 2, groups={"TC108_AddCompany"})
	public void TC108_AddCompany()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			WebElement element = companyPage.addCompany();
			
			softAssert.assertNotNull(element); //Check if we got the Saved Company Element
		
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC108_AddCompany"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
		
	}

	@Test(priority = 3, groups={"TC110_EditCompany"},dependsOnMethods={"TC108_AddCompany"})

	public void TC110_EditCompany()
	{
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Test Case One in " + getClass().getSimpleName()
				+ " with Thread Id:- " + Thread.currentThread().getId());
		try
		{
			
			companyPage.editCompany();
			
			softAssert.assertEquals(companyPage.actualTradingName,companyPage.expectedTradingName,"Trading Name not edited successfully" );
			softAssert.assertEquals(companyPage.actualTelephone,companyPage.expectedTelephone,"Telephone not edited successfully." );
			softAssert.assertEquals(companyPage.actualAddress1,companyPage.expectedAddress1,"Address1 not edited successfully." );
			softAssert.assertEquals(companyPage.actualAddress2,companyPage.expectedAddress2,"Address2 not edited successfully." );
			softAssert.assertEquals(companyPage.actualCity,companyPage.expectedCity,"City not edited successfully." );
			softAssert.assertEquals(companyPage.actualpostalcode,companyPage.expectedpostalcode,"Postal code not edited successfully." );
			softAssert.assertEquals(companyPage.actualstate,companyPage.expectedstate,"State not edited successfully." );
			softAssert.assertEquals(companyPage.actualcountry,companyPage.expectedcountry,"Country edited successfully." );
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC110_EditCompany "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
	
	}


	@Test(priority = 4, groups={"TC112_AddDivision"},dependsOnMethods={"TC110_EditCompany"})
	public void TC112_AddDivision()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			
			companyPage.addDivision();
	
			softAssert.assertNotNull(companyPage.ActualDivisionTitle,"Division not created successfully");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC112_AddDivision "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}
	

	@Test(priority = 5, groups={"TC113_EditDivision"},dependsOnMethods={"TC112_AddDivision"})
	public void TC113_EditDivision()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			companyPage.editDivision();
			softAssert.assertEquals(companyPage.actualEdDivisionAdd1,companyPage.expAddress1,"Division Address not edited");
			softAssert.assertEquals(companyPage.actualEdDivisionCity,companyPage.expCity,"City not edited");
			softAssert.assertEquals(companyPage.actualEdDivisionPostsalCd,companyPage.expPostalCode,"Postal code not edited");
			softAssert.assertEquals(companyPage.actualEdDivisionState,companyPage.expState,"Division State not edited");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC113_EditDivision "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}


	@Test(priority = 18, groups={"TC115_AddTeamsinDivision"})
	public void TC115_AddTeamsinDivision()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			
			companyPage.addNewTeamsInDivision();
			softAssert.assertNotNull(companyPage.TeamsIndivisionVerify,"Teams created successfully" );
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC115_AddTeamsinDivision "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}


	@Test(priority = 19, groups={"TC116_EditTeamsAboutTab"})
	public void TC116_EditTeamsAboutTab()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			companyPage.editTeamInDivision();
			
			//softAssert.assertEquals(companyPage.actualClassofBusinessToEdit,"Company Class of Business selected successfully to Edit" );
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC116_EditTeamsAboutTab "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
		
	}

	@Test(priority = 20, groups={"TC118_AddUserForCompany"})
	public void TC118_AddUserForCompany()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			companyPage.addNewUserForCompany();
			softAssert.assertEquals(companyPage.actualEmailID,companyPage.expectedEmailID,"Company Sub Division created successfully" );
			softAssert.assertEquals(companyPage.actualPhoneNumber,companyPage.expectedPhoneNumber,"Company Sub Division created successfully" );
			softAssert.assertEquals(companyPage.actualWorkPhoneNumber,companyPage.expectedWorkPhoneNumber,"Company Sub Division created successfully" );
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC118_AddUserForCompany "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		}
	
	@Test(priority = 110, groups={"TC124_AddEditandRemoveUSerToTeamsInDivision"})
	public void TC124_AddEditandRemoveUSerToTeamsInDivision()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			companyPage.AddEditRemoveUserInTeams();
			softAssert.assertNotNull(companyPage.UserTabInTeamVerify,"User Tab Verified successfully");
			softAssert.assertEquals(companyPage.TeamsUserRole, "Standard");
			softAssert.assertEquals(companyPage.TeamValueInUserTab, " TestAutomationTeam1 - TestDivision2412271227 (TestDivisionRef2412271227) ");
			softAssert.assertEquals(companyPage.RoleInUserTab, "Company Admin");
			softAssert.assertEquals(companyPage.TeamsUserEditPopUp, "Edit User");
			softAssert.assertEquals(companyPage.RemovePopupMessage, "Are you sure you wish to remove this user?");
			softAssert.assertEquals(companyPage.BlnkValueInTeamcolumnInUserTab, "-");
			
			}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC124_AddEditandRemoveUSerToTeamsInDivision "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}
	
	@Test(priority = 25, groups={"TC125_AddUserToSubDivision"})
	public void TC125_AddUserToSubDivision()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			companyPage.addUserToSubDivision();
			softAssert.assertNotNull(companyPage.UserAddedToDivision,"Division not created successfully");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC125_AddUserToSubDivision "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}
	
	@Test(priority = 26, groups={"TC121_ActivateUser"})
	public void TC121_ActivateUser()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			companyPage.activateNewUser();
			softAssert.assertEquals(companyPage.actualActivetxt,companyPage.expActive,"User status not activated" );

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC121_ActivateUser "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 27, groups={"TC145_DectivateUser"})
	public void TC145_DectivateUser()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			companyPage.deactivateNewUser();
			softAssert.assertEquals(companyPage.actualDeactivetxt,companyPage.expDeactive,"User status not inactive");


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC145_DectivateUser "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 28, groups={"TC133_Edit_UserProfile_Of_User"})
	  public void TC133_Edit_UserProfile_Of_User()
	  {
		SoftAssert softAssert = new SoftAssert();
	   try
	   {
		   companyPage.Edit_UserProfile_Of_User_4062();
		   softAssert.assertEquals(companyPage.ActualMobileNumber,companyPage.EditedMobileno,"User status not inactive"); 

	   }catch(Exception e)
	   {
	    Report.LogInfo("Exception", "Exception in TC133_Edit_UserProfile_Of_User"+e.getMessage(), "FAIL");
	    softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	
	  }
	
	@Test(priority = 1213, groups={"TC1370_AddNewBrokerCompany"})
	public void TC1370_AddNewBrokerCompany()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			WebElement element = companyPage.addBrokerCompany();
			
			softAssert.assertNotNull(element); //Check if we got the Saved Company Element
		
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1370_AddNewBrokerCompany"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		
		finally {
			softAssert.assertAll();
		}
		
	}
	
	@Test(priority = 1214, groups={"TC1371_AddDivisionForBroker"},dependsOnMethods={"TC1370_AddNewBrokerCompany"})
	public void TC1371_AddDivisionForBroker()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			
			companyPage.addDivisionForBroker();
	
			softAssert.assertNotNull(companyPage.ActualDivisionTitle,"Division not created successfully");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1371_AddDivisionForBroker "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}
	
	
	
}
