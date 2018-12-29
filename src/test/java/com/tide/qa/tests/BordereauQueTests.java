package com.tide.qa.tests;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauQuePage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.Report;

@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class BordereauQueTests extends TestBase
{
	BordereauQuePage QuePage = new BordereauQuePage();
	LoginPage loginPage = new LoginPage();
	LoginPage login = new LoginPage();

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
	String AdminUsername = "dev.admin@tideapp.co.uk";
	String AdminPassword = "Yb0kMlJ;z8Ho33mO";

	String AdminUsername4 = "kruthika@systenics.net";
	String AdminPassword4 = "apple@4169";

	String AdminUsername1 = "broker01.ca@tideapp.co.uk";
	String AdminPassword1 = "HuCSbq7589wNU4M";

	String AdminUsername2 = "john.smith@coverholderinc.com";
	String AdminPassword2 = "Pa55word123";
	

	String StandatdUsername2 = "tushark@systenics.net";
	String StandardPassword2 = "test1234@";

	String AdminUsername3 = "readonly.jones@coverholderinc.com";
	String AdminPassword3 = "Pa55word123";
	
	String ReadOnlyUsername3 = "aarifa@systenics.net";
	String ReadonlyPassword3 = "test1234@";
    String QuestionaireNae = null;
	@Test(priority = 8, groups={"TC156_AddNewRiskQuestionnaireAllsheets"})
	public void TC156_AddNewRiskQuestionnaireAllsheets()

	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			QuePage.addNewQuestionnaire();
			softAssert.assertNotNull(QuePage.QuestionnaireName); //Check if we got the Saved Company Element
			softAssert.assertEquals(QuePage.RowCanNotChangeText_Actual, QuePage.RowCanNotChangeText_Expected);// Validate  header row cannot be chenged informing text.
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC156_AddNewRiskQuestionnaireAllsheets "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 9, groups={"TC1043_EditBordereauxQuestionaire"})
	public void TC1043_EditBordereauxQuestionaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			QuePage.editBordereauFormat();
			softAssert.assertEquals(QuePage.versionNumber, "2");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC1043_EditBordereauxQuestionaire "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 36, groups={"TC154_AddPremiumQuestionaire"})
	public void TC154_AddPremiumQuestionaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			QuePage.addPremiumQuestionaire();
			softAssert.assertNotNull(QuePage.PremiumBordereauText);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC154_AddPremiumQuestionaire "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
		
	}

	@Test(priority = 37, groups={"TC172_EditPremiumQuestionaire"})

	public void TC172_EditPremiumQuestionaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			QuePage.editPremiumQuestionaire();
			softAssert.assertEquals(QuePage.versionNumber, "2");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC172_EditPremiumQuestionaire "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}

	@Test(priority = 10, groups={"TC151_AddBordereauFormatClaim"})
	public void TC151_AddBordereauFormatClaim()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			QuePage.addBordereauFormatClaim();
			softAssert.assertNotNull(QuePage.ClaimBordereauText);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC151_AddBordereauFormatClaim "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	
	}

	@Test(priority = 11, groups={"TC153_EditBordereauFormatClaim"})

	public void TC153_EditBordereauFormatClaim()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			QuePage.editClaimQuestionaire();
			softAssert.assertEquals(QuePage.versionNumber, "2");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC153_EditBordereauFormatClaim "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
		
	}

	@Test(priority = 894, groups={"TC761_BordereauQuestionaireTideAdmin"})
	public void TC761_BordereauQuestionaireTideAdmin()
	{
		SoftAssert softAssert = new SoftAssert();
		try

		{
			
			login.tideLogin(rd.getDataFromCell(path, "TestData", 60, 3),rd.getDataFromCell(path, "TestData", 60, 5));
			QuePage.addBordereauFormatClaim();
			softAssert.assertNotNull(QuePage.ClaimBordereauText);

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC761_BordereauQuestionaireTideAdmin "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
			login.tideAdminLogOut();
		}
	}

	@Test(priority = 895, groups={"TC762_BordereauQuestionaireCompanyAdmin"})
	public void TC762_BordereauQuestionaireCompanyAdmin()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 37, 3),rd.getDataFromCell(path, "TestData", 37, 5));
			QuePage.addBordereauFormatClaim();
			softAssert.assertNotNull(QuePage.ClaimBordereauText);
		

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC4059_BordereauQuestionaireCompanyAdmin "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideCompanyAdminLogOut();
			softAssert.assertAll();
		}
		
	}

	@Test(priority = 896, groups={"TC763_BordereauQuestionaireStandardUSer"})
	public void TC763_BordereauQuestionaireStandardUSer()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 38, 3),rd.getDataFromCell(path, "TestData", 38, 5));
			QuePage.addBordereauFormatClaim();
			softAssert.assertNotNull(QuePage.ClaimBordereauText);
			

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC763_BordereauQuestionaireStandardUSer "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
		}
	}

	@Test(priority = 897, groups={"TC766_BordereauQuestionaireReadOnly"})
	public void TC766_BordereauQuestionaireReadOnly()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			login.tideLogin(rd.getDataFromCell(path, "TestData", 39, 3),rd.getDataFromCell(path, "TestData", 39, 5));
			QuePage.BordereauQuestionaireReadOnly_4061();
			
			softAssert.assertEquals(QuePage.adminTabVisible, "PASS");
	

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC766_BordereauQuestionaireReadOnly "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally
		{
			login.tideReadOnlyLogOut();
			softAssert.assertAll();
			}
	}

	@Test(priority = 643, groups={"TC158_AddBordereauQuestionaireNote"})
	public void TC158_AddBordereauQuestionaireNote()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			//login.tideReadOnlyLogOut();
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.AddBordereauQuestionaireNotes_4197();
			softAssert.assertNotNull(QuePage.QuestionnaireName);
			softAssert.assertEquals(QuePage.versionNumber,"1");
			softAssert.assertEquals(QuePage.NotePopupText,"Bordereau Questionnaire Notes");
			softAssert.assertEquals(QuePage.verisoncount1,"1");
			softAssert.assertEquals(QuePage.verisoncount2,"1");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC158_AddBordereauQuestionaireNote "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 83, groups={"TC161_StandardReferencesInQuestionnaire"})
	public void TC161_StandardReferencesInQuestionnaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{;
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.StandardReferencesInQuestionnaire_TC4199();
	
			softAssert.assertEquals(QuePage.Edit, "EDIT");
			//softAssert.assertEquals(QuePage.Savechanges, "SAVE CHANGES");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC161_StandardReferencesInQuestionnaire"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}

	@Test(priority = 84, groups={"TC149_ViewUsedQuestionnaire"})
	public void TC149_ViewUsedQuestionnaire()
	{
		SoftAssert softAssert = new SoftAssert();

		try
		{
			//login.tideLogin(AdminUsername, AdminPassword);
			QuePage.ViewUsedQuestionnaire_TC4303();
			softAssert.assertEquals(QuePage.Edit, "EDIT");
			softAssert.assertEquals(QuePage.AssertBordereauStatusReview, "REVIEW");
			softAssert.assertEquals(QuePage.ViewQB, "VIEW QUESTIONNAIRE");
			softAssert.assertEquals(QuePage.Note, "NOTES");
			softAssert.assertEquals(QuePage.OK, "OK");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC149_ViewUsedQuestionnaire "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 1178, groups={"TC5524_HeaderrowselectionQuestionnaire"})
	public void TC5524_HeaderrowselectionQuestionnaire()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
		//	login.tideLogin(AdminUsername, AdminPassword);
			QuePage.HeaderrowselectionQuestionnaire_TC5524();
			softAssert.assertNotNull(QuePage.QuestionnaireName1stSheet);
			softAssert.assertEquals(QuePage.Edit, "EDIT");
			softAssert.assertEquals(QuePage.Cancel, "CANCEL");
		
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC5524_HeaderrowselectionQuestionnaire "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}



@Test(priority = 402, groups={"TC3728_AddNewRiskAndPremiumQuestionnaireBlankColumn"})
public void TC3728_AddNewRiskAndPremiumQuestionnaireBlankColumn()

{
	SoftAssert softAssert = new SoftAssert();
	try
	{
		
		QuePage.addNewRiskandPremiumQuestionnaire();
		softAssert.assertNotNull(QuePage.QuestionnaireName); //Check if we got the Saved Company Element
	}catch(Exception e)
	{
		Report.LogInfo("Exception", "Exception in TC3728_AddNewRiskAndPremiumQuestionnaireBlankColumn "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}
	finally {
		softAssert.assertAll();
	}
}

@Test(priority = 403, groups={"TC3730_EditRiskandPremiumBordereauxQuestionaire"})
public void TC3730_EditRiskandPremiumBordereauxQuestionaire()
{
	SoftAssert softAssert = new SoftAssert();
	try
	{
		QuePage.editRiskAndPremiumBordereauFormat();
		softAssert.assertEquals(QuePage.versionNumber, "2");

	}catch(Exception e)
	{
		Report.LogInfo("Exception", "Exception in TC3730_EditRiskandPremiumBordereauxQuestionaire "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}finally {
		softAssert.assertAll();
	}
}
@Test(priority = 404, groups={"TC3732_AddNewRiskAndPremiumDraftStatusQuestionnaire"})
public void TC3732_AddNewRiskAndPremiumDraftStatusQuestionnaire()

{
	SoftAssert softAssert = new SoftAssert();
	try
	{
		
		QuePage.addNewRiskandPremiumForSaveAsDraftStatusQuestionnaire();
		softAssert.assertNotNull(QuePage.QuestionnaireName); //Check if we got the Saved Company Element
	}catch(Exception e)
	{
		Report.LogInfo("Exception", "Exception in TC3732_AddNewRiskAndPremiumDraftStatusQuestionnaire "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}
	finally {
		softAssert.assertAll();
	}
}

@Test(priority = 406, groups={"TC1895_BPOQuestionnaireRequestProcessRaiseRequest"})
public void TC1895_BPOQuestionnaireRequestProcessRaiseRequest()

{
	SoftAssert softAssert = new SoftAssert();
	try
	{
		QuestionaireNae = QuePage.BPOQuestionnaireRequestProcessRaiseRequest_TC1895();
		Report.LogInfo("Exception", QuestionaireNae, "PASS");
		
		loginPage.tideReadOnlyLogOut();
	}catch(Exception e)
	{
		Report.LogInfo("Exception", "Exception in TC1895_BPOQuestionnaireRequestProcessRaiseRequest "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}
	finally {
		softAssert.assertAll();
		
	}
}

@Test(priority = 407, groups={"TC1896_BPOQuestionnaireRequestProcessTaskComplete"})
public void TC1896_BPOQuestionnaireRequestProcessTaskComplete()

{
	SoftAssert softAssert = new SoftAssert();
	try
	{
		loginPage.tideLogin("bposervice01.ca@tideapp.co.uk","37r25zJbjQVH7eQ");
		QuePage.BPOQuestionnaireRequestProcessTaskComplete_TC1896(QuestionaireNae);
		loginPage.tideReadOnlyLogOut();
	}catch(Exception e)
	{
		Report.LogInfo("Exception", "Exception in TC1896_BPOQuestionnaireRequestProcessTaskComplete "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}
	finally {
		softAssert.assertAll();
	}
}

@Test(priority = 408, groups={"TC1897_BPOQuestionnaireRequestProcessRaiseRequest"})
public void TC1897_BPOQuestionnaireRequestProcessAdjustmentRequest()

{
	SoftAssert softAssert = new SoftAssert();
	try
	{
		loginPage.tideLogin("insurer01.ca@tideapp.co.uk","4KJT8KpeUTJZkNf");
		QuePage.BPOQuestionnaireRequestProcessAdjustmentRequest();
		loginPage.tideReadOnlyLogOut();
	}catch(Exception e)
	{
		Report.LogInfo("Exception", "Exception in TC1897_BPOQuestionnaireRequestProcessRaiseRequest "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}
	finally {
		softAssert.assertAll();
	}
}

@Test(priority = 409, groups={"TC1898_BPOQuestionnaireRequestProcessRaiseRequest"})
public void TC1898_BPOQuestionnaireAdjustmentrequestComplete()

{
	SoftAssert softAssert = new SoftAssert();
	try
	{
		loginPage.tideLogin("bposervice01.ca@tideapp.co.uk","37r25zJbjQVH7eQ");
		QuePage.BPOQuestionnaireAdjustmentrequestComplete();
		loginPage.tideReadOnlyLogOut();
		loginPage.tideLogin("insurer01.ca@tideapp.co.uk","4KJT8KpeUTJZkNf");
		Report.LogInfo("Exception", QuestionaireNae, "PASS");
		QuePage.BPOQuestionnaireRequestProcessAdjustmentRequestComplete(QuestionaireNae);
		
	}catch(Exception e)
	{
		Report.LogInfo("Exception", "Exception in TC1895_BPOQuestionnaireRequestProcessRaiseRequest "+e.getMessage(), "FAIL");
		softAssert.fail(e.getMessage());
	}
	finally {
		softAssert.assertAll();
	}
}

}

