package com.tide.qa.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.DatasetReferenceDataPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.utility.Report;

@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class DatasetReferenceDataTests extends TestBase {
	DatasetReferenceDataPage datasetReferenceData = new DatasetReferenceDataPage();
	LoginPage login = new LoginPage();
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";

	@Test(priority = 58, groups={"TC785_AddDatasetReferenceData"})
	public void TC785_AddDatasetReferenceData()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			datasetReferenceData.addDatasetReference_3381();
			softAssert.assertNotNull(datasetReferenceData.DatasetReferenceDataName);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC785_AddDatasetReferenceData"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority = 59, groups={"TC786_AddValue_existingDataset"},dependsOnMethods={"TC785_AddDatasetReferenceData"})

	public void TC786_AddValue_existingDataset()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			datasetReferenceData.addvalueDatasetReference_3382();
			softAssert.assertEquals(datasetReferenceData.ActualValue1, "Autovalue 1");

		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC786_AddValue_existingDataset "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

	@Test(priority = 60, groups={"TC787_AddNewValueMapping"})
	public void TC787_AddNewValueMapping()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			datasetReferenceData.mappingReferenceDataset_3383();
			softAssert.assertEquals(datasetReferenceData.ActualMapping1, "Mapping Value");


		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC787_AddNewValueMapping"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}	

	@Test(priority = 85, groups={"TC789_AddClaimFields"})
	public void TC789_AddClaimFields()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			datasetReferenceData.AddClaimFields_4027();
			softAssert.assertNotNull(datasetReferenceData.FieldName);
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC789_AddClaimFields"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}
	
	@Test(priority = 61, groups={"TC791_AddRiskPremiumFields"})
	public void TC791_AddRiskPremiumFields()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			datasetReferenceData.AddRiskPremiumFields_4023();
			softAssert.assertNotNull(datasetReferenceData.FieldName);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC791_AddRiskPremiumFields"+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		
		}
	}

}