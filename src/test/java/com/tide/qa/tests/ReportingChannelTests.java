package com.tide.qa.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tide.qa.common.TestBase;
import com.tide.qa.pagefactory.BordereauProcessPage;
import com.tide.qa.pagefactory.LoginPage;
import com.tide.qa.pagefactory.PolicyPage;
import com.tide.qa.pagefactory.ReportingChannel;
import com.tide.qa.pagefactory.BordereauProcessPage;

import com.tide.qa.utility.Report;
@Listeners(com.tide.qa.utility.CustomTestListener.class)
public class ReportingChannelTests extends TestBase{
	public BordereauProcessPage BorderPg=null ;
	ReportingChannel channel = new ReportingChannel();
	LoginPage login = new LoginPage();
	PolicyPage policy = new PolicyPage();
	String AdminUsername1 = "companyadmin.brookes@aspen.co.uk";
	String AdminPassword1 = "Pa55word123";
	String AdminUsername = "admin@tide.com";
	String AdminPassword = "Systenics123@";
	
	@Test(priority =40, groups={"TC261_NoReportingChannelAvailable"})
	public void TC261_NoReportingChannelAvailable()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			
			channel.NoReportingChannelAvailable();
			softAssert.assertEquals(policy.ContractStatusText1, "SIGNED");
			softAssert.assertEquals(policy.AssertBordereauStatusReviewError, "REVIEW ERRORS");
			softAssert.assertEquals(policy.NoreportingchannelText, "No Reporting Channel identified");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC261_NoReportingChannelAvailable "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =340, groups={"TC259_SingleMatchingReportingChannel"})
	public void TC259_SingleMatchingReportingChannel()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.SingleMatchingReportingChannel();
			softAssert.assertEquals(channel.AssertBordereauStatusReview, "REVIEW");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC259_SingleMatchingReportingChannel "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority =341, groups={"TC262_AddingMAtchReportingChannel"})
	public void TC262_AddingMAtchReportingChannel()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.addMatchingReportingChannel();
			softAssert.assertEquals(channel.ChannelIdentifier1,channel.ExpectReportingChannelIdentifier);
			
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC262_AddingMAtchReportingChannel "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =342, groups={"TC264_BordereauxReportingChannelCance"})
	public void TC264_BordereauxReportingChannelCance()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.ProcessBordereauxMultipleReportingChannelCancel();
			
			softAssert.assertEquals(channel.ReportingChannelHeader,"More than one Reporting Channel identified");
			softAssert.assertEquals(channel.AssertBordereauStatusReview, "REVIEW ERRORS");
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC264_BordereauxReportingChannelCance "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =343, groups={"TC260_BordereauMatchingReportingChannel"})
	public void TC260_BordereauMatchingReportingChannel()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.ProcessBordereauMoreThanOneMatchingReportingChannel();
			softAssert.assertEquals(channel.ReportingChannelHeader,"More than one Reporting Channel identified");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC260_BordereauMatchingReportingChannel "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	
	@Test(priority =344, groups={"TC265_ProcessBordereauForMoreReportingChannel"})
	public void TC265_ProcessBordereauForMoreReportingChannel()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.ProcessBordereauForMoreReportingChannel();
			softAssert.assertEquals(channel.ReportingChannelHeader,"More than one Reporting Channel identified");
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC265_ProcessBordereauForMoreReportingChannel "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =345, groups={"TC263_DeleteReportingChannel"})
	public void TC263_DeleteReportingChannel()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.DeleteCreatedReportingChannel();
			softAssert.assertNull(channel.ReportingChannelExist);
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC263_DeleteReportingChannel "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =346, groups={"TC266_AddReportingChannelForQuarte"})
	public void TC266_AddReportingChannelForQuarte()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.AddReportingChannelForQuarter();	
			 softAssert.assertEquals(channel.ChannelIdentifier2,channel.ExpectReportingChannelIdentifier3);
				
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC266_AddReportingChannelForQuarte "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority =347, groups={"TC268_AddReportingchannelAnnually"})
	public void TC268_AddReportingchannelAnnually()
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			channel.AddReportingchannelAnnually();	
		 softAssert.assertEquals(channel.ChannelIdentifier11,channel.ExpectReportingChannelIdentifier1);
			
		}catch(Exception e)
		{
			Report.LogInfo("Exception", "Exception in TC268_AddReportingchannelAnnually "+e.getMessage(), "FAIL");
			softAssert.fail(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
		
}
