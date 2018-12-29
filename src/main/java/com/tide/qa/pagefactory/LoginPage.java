package com.tide.qa.pagefactory;



import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;

import com.tide.qa.common.GlobalVariables;
import com.tide.qa.common.PageBase;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.Report;

public class LoginPage extends PageBase
{
	GlobalVariables globalVar;

	//Element Locators
	public static final String Username = "@xpath=//*[@id='i0116']";
	public static final String nextbtn = "@xpath=//*[@value='Next']";
	public static final String AddAccountBtn = "@xpath=//*[@id='otherTile']";
	
	public static final String Password = "@name=passwd";

	//Logout
	public static final String TideAdminLink = "@xpath=//*[@id='header']//span[@class='clearfix']/span[contains(.,'Tide Admin')]";
	public static final String CompanyAdminLink = "@xpath=//*[@id='header']//span[@class='clearfix']/span[contains(.,'Company Admin')]";
	public static final String LogoutLink = "@xpath=//*[@id='header']//a[contains(.,'Log Out')]";
	public static final String Profilecircle = "@xpath=//li[@ng-if='authentication.authenticated']";
	
	String URL = Configuration.url;
	
	public String  tideLogin(String UName, String Pass) throws InterruptedException, ClientProtocolException, IOException
	{
		
		String pageTitle = "";
		Actions action = new Actions(webDriver);
		
		if(isVisible(AddAccountBtn)) {
		
		
			javaScriptclick(AddAccountBtn,"click add another user account");
			
			}else {
			
		}
		sleep(2000);
		
		sendKeys(Username, UName, "Username Field (Valid Input");		
	
	
	
		sleep(3000);
		action.sendKeys(Keys.ENTER).build().perform();
		
		sleep(2000);
		sendKeys(Password, Pass, "Password Field (Valid Input).");
		sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(2000);
		javaScriptWait();
		sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(4000);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(4000);
		action.sendKeys(Keys.ENTER).build().perform();
		sleep(4000);
		action.sendKeys(Keys.ENTER).build().perform();
		pageTitle = webDriver.getTitle();
	
		Report.LogInfo("TestCheck", "Test case executed", "PASS");
		getAccessToken();
	//	GetcompanyData();
		return pageTitle;
		
		
	}

	public void tideAdminLogOut()
	{
		verifyMustExists(TideAdminLink,"Tide Admin Link");
		click(TideAdminLink,"Tide Admin Link", true);
		verifyMustExists(LogoutLink,"LogOut Link");
		click(LogoutLink,"LogOut Link",true);
		sleep(10000);
		openurl(URL);	 
	}

	public void tideCompanyAdminLogOut()
	{
		verifyMustExists(CompanyAdminLink,"Company Admin Link");
		click(CompanyAdminLink,"Company Admin Link",true);
		verifyMustExists(LogoutLink,"LogOut Link");
		click(LogoutLink,"LogOut Link",true);
		sleep(10000);
		  openurl(URL);	
	}

	public void tideReadOnlyLogOut()
	{
		verifyMustExists(Profilecircle,"Company Admin Link");
		click(Profilecircle,"Admin Link",true);
		verifyMustExists(LogoutLink,"LogOut Link");
		click(LogoutLink,"LogOut Link",true);

		Report.LogInfo("Check", "8", "PASS");
		openurl(URL);
		Report.LogInfo("Check", "9", "PASS");
	}


}