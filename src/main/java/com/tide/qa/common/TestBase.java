package com.tide.qa.common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.yaml.snakeyaml.Yaml;

import com.opera.core.systems.OperaDriver;
import com.tide.qa.utility.Configuration;
import com.tide.qa.utility.ReadingAndWritingTextFile;
import com.tide.qa.utility.RecordVideo;
import com.tide.qa.utility.Report;
import com.tide.qa.utility.SendEmail;
import com.tide.qa.utility.TideSSLSocketFactory;
import com.tide.qa.utility.Utilities;
import com.tide.qa.utility.ZipDirectory;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;


public class TestBase {
	public static Map<ITestResult, List<Throwable>> verificationFailuresMap = new HashMap<ITestResult, List<Throwable>>();
	public static WebDriver webDriver=null;
	public static String access_token = null;
	public static String conpany_Id = null;
	private static Utilities testSuite = new Utilities();
	public static final String EMPTY_KEYWORD = "{empty}";
	public static final String SPACE_KEYWORD = "{space}";
	public SendEmail email=new SendEmail();
	static PrintWriter write = new PrintWriter(System.out, true); 
	public static ReadingAndWritingTextFile file=new ReadingAndWritingTextFile();
	DesiredCapabilities capability;
	private static GlobalVariables g;
	private static Utilities suiteConfig = new Utilities();
	private static String gridMode =null;
	private static String videoFlag =null;
	protected static String timestamp=null;
	protected static Utilities util = new Utilities();

	


	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> setBasicInfomationForTestData(String fileName) 
	{
		HashMap<String, Object> basicInfoDataset=null;
		try
		{
			//Report.LogInfo("ReadBasicInfo", "Reading basic url information", "INFO");
			FileInputStream input = new FileInputStream(new File("./src/main/resources/URL_information.yml"));
			Yaml yaml = new Yaml();
			basicInfoDataset = ((HashMap<String, Object>) ((HashMap<String, Object>) yaml.load(input)).get(fileName));
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			JOptionPane.showMessageDialog(null, "Error in YML file loading,Check the syntax");
		}
		return basicInfoDataset;
	}
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> getUrlInfoDataset(HashMap<String, Object> ymlurlDataset, String urlTagName) throws FileNotFoundException 
	{
		return ((HashMap<String, Object>) ymlurlDataset.get(urlTagName));
	}
	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception
	{
		//	Report.LogInfo("BeforeSuite", "", "INFO");
		String path = new File(".").getCanonicalPath();
		g = new GlobalVariables();
		g.setRelativePath(path);
       	g.setBrowser(util.getValue("Browsers", "firefox").trim().split(",")[0]);
	    g.setGridMode(util.getValue("GridMode", "off").trim());		
		g.setVideoFlag(util.getValue("VideoFlag", "false").trim());
		g.setHubAddress("http://localhost:4444/wd/hub");
		g.setVSTSFlag(util.getValue("VSTSFlag", "false").trim());
        gridMode = g.getGridMode();
		timestamp = "RegressionSuite_"+suiteConfig.getCurrentDatenTime("MM-dd-yyyy")+"_"+suiteConfig.getCurrentDatenTime("hh-mm-ss_a");
        String resultPath = path+"\\Results\\"+timestamp;
		String ScreenshotsPath = resultPath+"//Screenshots";
		g.setResultFolderPath(resultPath);
		g.setTestSuitePath(path+"//src//test//resources//TestSuite.xls");
        new File(resultPath).mkdirs();
		new File(ScreenshotsPath).mkdirs();
		String SummaryReportfile = resultPath+"\\Index.html";
        Report.createSummaryReportHeader(SummaryReportfile);
		Report.createTestCaseReportHeader();
      	HashMap<String, Object> basicInfoDataset = setBasicInfomationForTestData("url_information");
		Configuration.setUrlInfoDataSet(getUrlInfoDataset(basicInfoDataset,Configuration.getURL()));
		videoFlag = g.getVideoFlag();
		
		if(videoFlag.equalsIgnoreCase("true"))
		{
		    String VideosPath = resultPath+"//Videos";
		    new File(VideosPath).mkdirs();			
		}
		
		initializeBrowser();


		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("Before Suite Run after exceution");
	}

	@AfterSuite(alwaysRun=true)
	public void tearDownWebDriver() throws Exception
	{
		Report.createTestCaseReportHeader();
		ZipDirectory zip = new ZipDirectory();
		File directoryToZip = new File(g.getResultFolderPath());
		List<File> fileList = new ArrayList<File>();
		System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
		zip.getAllFiles(directoryToZip, fileList);
		System.out.println("---Creating zip file");

		String zipOut=g.getResultFolderPath() +"//"+directoryToZip.getName() + ".zip";
		System.out.println(zipOut);
		zip.writeZipFile(directoryToZip, fileList,zipOut);
		System.out.println("---Done");

		closeWebdriver();

		zipOut=g.getResultFolderPath() +"//"+directoryToZip.getName() + ".zip";
		Report.createTestCaseReportFooter();
		Report.SummaryReportlog("After Suite Run after exceution");
		Report.createSummaryReportFooter();
		email.sendMessageWithAttachment("Regression test suite completed",file.readEntireFile(g.getResultFolderPath() +"//Index.html"),zipOut,true );
		
		
	}

	public void initializeBrowser() throws FileNotFoundException, IOException, InterruptedException 
	{
		openBrowser(g.getBrowser());
		open("");
	}
	public void openBrowser(String browser) {
		try {

			if (browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",g.getRelativePath()+"//src//main//resources//geckodriver.exe");
				capability= DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setJavascriptEnabled(true);
				capability.setPlatform(org.openqa.selenium.Platform.ANY);
				capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

				if(gridMode.equalsIgnoreCase("OFF"))
				{

					webDriver = new FirefoxDriver(capability);
				}else
				{
					webDriver= new RemoteWebDriver(new URL(g.getHubAddress()), capability);

				}
				webDriver.manage().window().maximize();

			}else if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",g.getRelativePath()+"//src//main//resources//chromedriver.exe");
				capability = DesiredCapabilities.chrome();
				
				if(gridMode.equalsIgnoreCase("OFF"))
				{
					webDriver =  new ChromeDriver(capability);
				}else
				{
					capability.setBrowserName("chrome");
					capability.setPlatform(Platform.ANY);
					RemoteWebDriver remoDriver= new RemoteWebDriver(new URL(g.getHubAddress()), capability);	
					webDriver = remoDriver;
				}
				webDriver.manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("chromeheadless"))
			{
				System.setProperty("webdriver.chrome.driver",g.getRelativePath()+"//src//main//resources//chromedriver.exe");
				capability = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--proxy-server='direct://'");  //BUGFIX https://github.com/Codeception/CodeceptJS/issues/561 
				options.addArguments("--proxy-bypass-list=*"); //BUGFIX https://github.com/Codeception/CodeceptJS/issues/561 

				capability.setCapability(ChromeOptions.CAPABILITY, options);

				if(gridMode.equalsIgnoreCase("OFF"))
				{
					webDriver =  new ChromeDriver(options);
				}else
				{
					capability.setBrowserName("chrome");
					capability.setPlatform(Platform.ANY);
					
					RemoteWebDriver remoDriver= new RemoteWebDriver(new URL(g.getHubAddress()), capability);	
					webDriver = remoDriver;
				}
				webDriver.manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("ie")) 
			{
				System.setProperty("webdriver.ie.driver",g.getRelativePath()+"//src//main//resources//IEDriverServer.exe");
				capability = DesiredCapabilities.internetExplorer();
				capability.setBrowserName("IE");
				capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				if(gridMode.equalsIgnoreCase("OFF"))
				{
					webDriver= new InternetExplorerDriver(capability);
				}else
				{

					RemoteWebDriver RemWebDrive= new RemoteWebDriver(new URL(g.getHubAddress()), capability);
					webDriver = RemWebDrive;
				}
			}
			else if(browser.equalsIgnoreCase("edge")) 
			{

				System.setProperty("webdriver.edge.driver",g.getRelativePath()+"//src//main//resources//MicrosoftWebDriver.exe");

				if(gridMode.equalsIgnoreCase("OFF"))
				{
					webDriver= new EdgeDriver();
				}else
				{

					RemoteWebDriver RemWebDrive= new RemoteWebDriver(new URL(g.getHubAddress()), capability);
					webDriver = RemWebDrive;
				}
			}
			else if(browser.equalsIgnoreCase("safari")) 
			{
				capability= DesiredCapabilities.safari();
				capability.setBrowserName("safari");
				capability.setJavascriptEnabled(true);
				capability.setPlatform(org.openqa.selenium.Platform.ANY);
				capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
				webDriver= new SafariDriver(capability);		 
			}

			else if(browser.equalsIgnoreCase("opera")) 
			{		
				capability= DesiredCapabilities.opera();
				capability.setCapability("opera.port", "-1");
				capability.setCapability("opera.profile", "");
				webDriver= new OperaDriver(capability);					 
			}

			webDriver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("Could not obtain webdriver for browser \n"	+ e.getMessage());
		}
	}


	public void closeWebdriver()
	{
		quit();
	}

	public static void info(String message)
	{
		write.println(message);
		
	}

	public WebDriver getWebDriver() {

		return webDriver;
	}


	public void setWebDriver(WebDriver webDriver) {
		TestBase.webDriver = webDriver;
	}

	/**
	 * This method will open the url given in param
	 * @param url
	 * @throws Exception 
	 */
	public void open(String url) 
	{
		try {
			if(url.endsWith("/"))
			{
				webDriver.get(Configuration.url+url);//+"?locale=" + Configuration.CULTURE);
			}
			else
			{
				webDriver.get(Configuration.url+url);//+"/?locale=" + Configuration.CULTURE);
			}
			setImplicitWaitTimeout(50000);
		}
		catch(RuntimeException e) {
			}
	
	}

	public static void openurl(String url) {

		try {

			webDriver.navigate().to(url);			 
		}
		catch(RuntimeException e) {
				}
	}
	
	public void close() {
		try {
			webDriver.close();
		}
		catch(RuntimeException e) {
				}
	}

	/**
	 * @throws Exception 
	 * @see #quit()
	 */
	public void quit() {
		try {
			webDriver.quit();
		}
		catch(RuntimeException e) {
			//	throw new Exception("WebDriver unable to handle the request to close browser!"+e.getMessage());
		}
	}

	/**
	 * @see Browser#setImplicitWaitTimeout(int)
	 */
	public void setImplicitWaitTimeout(long milliseconds) {
		if (milliseconds > 0) {
			webDriver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
		} else {
			webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		}
	}
	

	
	/*public void getAccessToken() throws ClientProtocolException, IOException, ServletException
	 {
		
		  Report.LogInfo("Response", "1" , "WARNING");
		 HttpSession ss = null;
		HttpServletRequest request = null;
	     HttpServletResponse response = null;
	    
	     HttpSession session = request.getSession(true);
	     System.out.print(session);
	     Report.LogInfo("Response", "2" , "WARNING");
	     String token = (String)session.getAttribute("adal.idtoken");
	     
	        ss=request.getSession(true);
	        Report.LogInfo("Response", "2" , "WARNING");
	        response.setContentType("text/html;charset=UTF-8");
	        Report.LogInfo("Response", "3" , "WARNING");
	      //  PrintWriter out = response.getWriter();
	       * getKeyFromSessionStorage
	        
		String responseToken= getItemFromSessionStorage("adal.idtoken");
	        Report.LogInfo("Response", "4" , "WARNING");

			  Report.LogInfo("Response", responseToken , "WARNING");
			  
			   String[] at1 = responseToken.split("\",\"token_type");
				String[] at2 = at1[0].split("access_token\":\"");
				access_token = at2[1];
				  Report.LogInfo("Response", access_token , "WARNING");
	 }   
	*/
		private static RecordVideo  recordVideo = new RecordVideo();
		
		//private static String videoFlag = null;
		private static String VideosPath = null;
		public void videoRecordingStart(String TestName)	
		{
			videoFlag = g.getVideoFlag();
			VideosPath = g.getResultFolderPath()+"\\Videos\\";
			if(videoFlag.equalsIgnoreCase("true"))
			{
				recordVideo.startVideoRecording(VideosPath, TestName);
			}
		}
		
		public void videoRecordingStop()	
		{
			videoFlag = g.getVideoFlag();
			VideosPath = g.getResultFolderPath()+"\\Videos\\";
			if(videoFlag.equalsIgnoreCase("true"))
			{
				recordVideo.stopVideoRecording();
			}
		}
	
}
