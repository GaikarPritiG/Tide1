package com.tide.qa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class MultiContractBordereauxAssignmentTest extends TestBase {
	
	BordereauProcessPage BPPage = new BordereauProcessPage();
	LoginPage login = new LoginPage();
	 String AdminUsername = "admin@tide.com";
	 String AdminPassword = "Systenics123@";
	
	@Test(priority = 82, groups={"TC371_MultiContractbordereaux"})
	public void TC371_MultiContractbordereaux()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			BPPage.MultiContractbordereaux_TC5282();
			softAssert.assertEquals(BPPage.TransformationScreen, "Bordereau Transformation");
			softAssert.assertEquals(BPPage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(BPPage.SectionAssig1, "Section Assignment Rule - 2017 Year of Account Contract (01/01/2017 - 31/12/2017)");
			softAssert.assertEquals(BPPage.CompleteAssig, "COMPLETE ASSIGNMENT");
			softAssert.assertEquals(BPPage.RiskAssign1, "Risk Code Assignment Rule - 2017 Year of Account Contract (01/01/2017 - 31/12/2017)");
			softAssert.assertEquals(BPPage.SectionAssig2, "Section Assignment Rule - 2018 Year of Account Contract (01/01/2018 - 31/12/2018)");
			softAssert.assertEquals(BPPage.RiskAssign2, "Risk Code Assignment Rule - 2018 Year of Account Contract (01/01/2018 - 31/12/2018)");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC371_MultiContractbordereaux"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

}
