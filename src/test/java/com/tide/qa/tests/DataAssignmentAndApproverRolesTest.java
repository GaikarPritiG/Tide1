package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.DataAssignmentAndApproverRolesPage;
import com.tide.qa.utility.Report;

@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class DataAssignmentAndApproverRolesTest  extends TestBase
{

	DataAssignmentAndApproverRolesPage assignment = new DataAssignmentAndApproverRolesPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	String AdminUsername2 = "dave.brit@brit.com";
	String AdminPassword2 = "Test123@";
	

	@Test(priority =649, groups={"TC459_AutomaticAssignment"})
	public void TC459_AutomaticAssignment()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{		
			assignment.automaticAssignment_4661();
			softAssert.assertEquals(assignment.AssertBordereauStatusApproved, "APPROVED");
			softAssert.assertEquals(assignment.SectionAssignment, "Section Data Assignment");
			softAssert.assertEquals(assignment.RiskCode, "Risk Code Data Assignment");
			//softAssert.assertEquals(assignment.AssertBordereauStatusReview, "REVIEW");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC459_AutomaticAssignment"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =650, groups={"TC457_SectionAndRiskCode"})
	public void TC457_SectionAndRiskCode()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			assignment.sectionAndRiskCode_4427();
			softAssert.assertEquals(assignment.RiskCode, "Risk Code Data Assignment");
			softAssert.assertEquals(assignment.SectionAssignment, "Section Data Assignment");
			softAssert.assertEquals(assignment.ViewMappingButton, "VIEW ASSIGNMENT RULE");
			softAssert.assertEquals(assignment.SectionR1, "1");
			softAssert.assertEquals(assignment.RiskR1,"1");
			softAssert.assertEquals(assignment.SectionR2,"1");
			softAssert.assertEquals(assignment.RiskR2,"2");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC457_SectionAndRiskCode"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =651, groups={"TC458_UpdateAssignmentMapping"})
	public void TC458_UpdateAssignmentMapping()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			assignment.updateAssignmentMapping_4559();
			softAssert.assertEquals(assignment.AssignmentRule,"Section Assignment Rules");
			softAssert.assertEquals(assignment.AssignmentRule1,"ASSIGNMENT RULES");
			softAssert.assertEquals(assignment.UpdateAssignment,"YES, UPDATE FIELD ASSIGNMENT");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC458_UpdateAssignmentMapping"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =665, groups={"TC4053_SectionandRiskCodeAssignment"})
	public void TC4053_SectionandRiskCodeAssignment()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			assignment.SectionandRiskCodeAssignment_4053();
			softAssert.assertEquals(assignment.AssignmentRule,"Section Assignment Rules");
			softAssert.assertEquals(assignment.AssignmentRule1,"ASSIGNMENT RULES");
			softAssert.assertEquals(assignment.UpdateAssignment,"YES, UPDATE FIELD ASSIGNMENT");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4053_SectionandRiskCodeAssignment"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	

}
