package com.tide.qa.common;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;             
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tide.qa.utility.ReadExcelFile;
import com.tide.qa.utility.ReadingAndWritingTextFile;
import com.tide.qa.utility.Utilities;
class MainDriver 
{
	private static String testsuite=null;
	private static String RunBrowser=null;
	private static String Port=null;
	private static DocumentBuilderFactory dbFactory=null;
    private static DocumentBuilder dBuilder=null;
	private static Document doc=null;
	private static GlobalVariables g;

	private static String testScenario = null;
	private static Utilities testSuite = new Utilities();
	private static TestBase ini = new TestBase();
	private static ReadExcelFile readexcel = new ReadExcelFile();
	private static  ReadingAndWritingTextFile readText=new ReadingAndWritingTextFile();
																																																																																																																				
	public static void main(String[] args) throws IOException
	{	
		MainDriver m = new MainDriver();	
		String path = new File(".").getCanonicalPath();
		g = new GlobalVariables();
		g.setRelativePath(path);
		String gridMode= testSuite.getValue("GridMode", "OFF");
		if(gridMode.trim().equalsIgnoreCase("ON"))
		{  // TC1367SettlementFinancialsPremium

			try 
			{
				RunScript(g.getRelativePath()+"//Grid","Hub.bat");
				RunBrowser = testSuite.getValue("Browsers", "firefox");
				Port = testSuite.getValue("ports", "5555");
				
				String brwArray[] =RunBrowser.split(",");
				String portArray[] =Port.split(",");				
				for(int i=0;i<portArray.length;i++)
				{
					m.prepareNode(portArray[i],brwArray[i]);
					RunScript(g.getRelativePath()+"//Grid","node.bat");
					Thread.sleep(3000);
				}			
				
			 }
			
			catch (Exception e)
			{
			System.out.print(e);																																																					e.printStackTrace();
			}
			
		} else
		{
			RunBrowser = testSuite.getValue("Browsers", "firefox");
		}

		testsuite = testSuite.getValue("ExecutionSuite", "").trim();
		int totalrow = readexcel.getTotalRowsExcel(g.getRelativePath() +"//src//test//resources//"+testsuite+".xls", "Main");
		
		String ColName= "Execute";
		String sheet="Main";
		
		//delete all the testcases added in testng xml file
		m.checkndDeleteAllnodes(g.getRelativePath() +"//src//test//resources//testng.xml");
		
		for(int rowC=1;rowC<totalrow;rowC++)
		{
			
			testScenario = m.getTestScenarioName(g.getRelativePath()+"//src//test//resources//"+testsuite+".xls",sheet,rowC,ColName);

			if(testScenario!=null)
			{
				int totalcol = readexcel.getTotalColumnExcel(g.getRelativePath()+"//src//test//resources//"+testsuite+".xls", sheet);		
				String[] testDetails = getTestcaseDetails(g.getRelativePath()+"//src//test//resources//"+testsuite+".xls", sheet, totalcol, rowC);
			
				m.CreateTestngXml(g.getRelativePath() +"//src//test//resources//testng.xml",testDetails);
			}
		}

	for(int i=0;i<RunBrowser.split(",").length;i++)
	{
		//Running the Runscript batch file to Run the Maven
		try {
			RunScript(g.getRelativePath(),"RunScript.bat");
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	public void checkndDeleteAllnodes(String xmlPath)
	{
		try
		{
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xmlPath);
		
	    NodeList list = doc.getElementsByTagName("run");
	    for (int i = 0; i <  list.getLength(); i++) 
	    {  
	         // Get Node  
	         Node node =  list.item(i);  
	         System.out.println(node.getNodeName());
	         
	         NodeList childList = node.getChildNodes();  
	         // Look through all the children  
	        for (int x = 0; x < childList.getLength(); x++) 
	        {  
	             Node child = (Node) childList.item(x); 
	             if(child.getNodeName().equalsIgnoreCase("INCLUDE"))
	             {
	            	 child.getParentNode().removeChild(child);  
	             }
          }
	    }
	    
	    NodeList classlist = doc.getElementsByTagName("classes");
	    for (int i = 0; i <  classlist.getLength(); i++) 
	    {  
	         // Get Node  
	         Node node =  classlist.item(i);  
	         System.out.println(node.getNodeName());
	         
	         NodeList childList = node.getChildNodes();  
	         // Look through all the children  
	        for (int x = 0; x < childList.getLength(); x++) 
	        {  
	             Node child = (Node) childList.item(x); 
	             if(child.getNodeName().equalsIgnoreCase("CLASS"))
	             {
	            	 child.getParentNode().removeChild(child);  
	             }
          }
	    }
	    
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult streamResult =  new StreamResult(new File(xmlPath));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, streamResult);
        
        
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void CreateTestngXml(String xmlPath, String[] testDetails)
	{
			try
			{
				dbFactory = DocumentBuilderFactory.newInstance();
				dBuilder = dbFactory.newDocumentBuilder();
				doc = dBuilder.parse(xmlPath);
				
				
				//checkndDeleteAllnodes(xmlPath);
				
			    NodeList nodeList = doc.getElementsByTagName("run");
			    for(int i=0;i<nodeList.getLength();i++)
			    {
			    	Node node = nodeList.item(i);
		    		Element publisherElm = doc.createElement("include");
		    		publisherElm.setAttribute("name", testDetails[2]);
 	    		   	node.appendChild(publisherElm);
 	    		    
			    }
			    
			   
			    
			    NodeList classNodelist = doc.getElementsByTagName("classes");
			    for(int i=0;i<classNodelist.getLength();i++)
			    {
			    	Node node = classNodelist.item(i);
		    		Element publisherElm = doc.createElement("class");
		    		publisherElm.setAttribute("name", testDetails[0]+"."+testDetails[1]);
 	    		   	node.appendChild(publisherElm);
 	    		   
			    }
			   
			    
			    
			    doc.normalize();
	        	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult streamResult =  new StreamResult(new File(xmlPath));
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.transform(source, streamResult);
	        
		        
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
			
	}
	
	
	private static String[] getTestcaseDetails(String xlFilePath, String sheetName,int coloumn, int rowC)
	{
		String temp[]=new String[coloumn];
		
		for(int i=0;i<coloumn;i++)
		{
			temp[i] = readexcel.getDataFromCell(xlFilePath, sheetName, rowC, i);	
		}
		
		return temp;
	}

	public void prepareNode(String port,String browsertype)
	{
		BufferedReader br= null;
		BufferedWriter wr = null;
		String line=null;
		String nodeFile=g.getRelativePath()+"//Grid//Nodetemplate//nodeTemplate.bat";
		String tempFile=g.getRelativePath()+"//Grid//node.bat";
		try
		{
			br = new BufferedReader(new FileReader(nodeFile));
			wr = new BufferedWriter(new FileWriter(tempFile));
			
			while ((line = br.readLine()) != null)
			{
				if(line.indexOf("PORTNUM")>0)
				{
					line=line.replace("PORTNUM", port);
				}
				if(line.indexOf("BROWSERTYPE")>0)
				{
					String browser=null;
					if(browsertype.trim().equalsIgnoreCase("FIREFOX"))
					{
						browser = "browserName=firefox";
						
					}else if(browsertype.trim().equalsIgnoreCase("IE"))
					{
						browser = "browserName=iexplore";
					}else if(browsertype.trim().equalsIgnoreCase("CHROME"))
					{
						browser = "browserName=chrome";
					}
					else if(browsertype.trim().equalsIgnoreCase("CHROMEHEADLESS"))
					{
						browser = "browserName=chrome";
					}
					
					line =line.replace("BROWSERTYPE", browser);
				}
				if(line.indexOf("DRIVER")>0)
				{
					String driver=null;
					if(browsertype.trim().toUpperCase().equalsIgnoreCase("CHROME"))
					{
						driver = "-Dwebdriver.chrome.driver=%~dp0chromedriver.exe";
					}
					else
					{
						driver="";
					}
					
					//opera
					
					
					line =line.replace("DRIVER", driver);
				}
				//System.out.println(line);
				wr.write(line);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				br.close();
				wr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


	public static void RunScript(String path,String batchFile) throws Exception
	{
		
		  try
		  {
				//Runtime.getRuntime().exec("cmd /c start "+g.getRelativePath()+"//RunScript.bat");
				Process p =Runtime.getRuntime().exec("cmd /c start "+path+"//"+batchFile+"");
				p.waitFor();
				
		  }
		  catch (IOException e) 
		  {
			  System.out.println("Error While Executing RunScript batch file");
			  System.out.println(e.getMessage());
			  
		  }

	}
	
	//====================================================================================================
	// FunctionName    	: getTestcaseName
	// Description     	: Function to get the Scenario Name which need to execute based on execute flag
	// Input Parameter 	: testSuitepath- Testsuite Excel file path
	//					: sheetName- Sheet Name
	//					: row - row number
	//					: Col - Column name
	// Return Value    	: TestScenario Name
	//====================================================================================================	

	public String getTestScenarioName(String testSuitepath, String sheet , int row, String Col)
	{
		
		
		String flag = readexcel.getDataFromExcel(testSuitepath, sheet, Col, row);
		if(flag.trim().toUpperCase().equals("YES"))
		{
			return (readexcel.getDataFromExcel(testSuitepath, sheet, "Scenarios", row));
		}
		else
		{
			return null;	
		}
	}

	//====================================================================================================
		// FunctionName    	: getSmokeTestcaseName
		// Description     	: Function to get the Smoke Scenario Name which need to execute based on execute flag
		// Input Parameter 	: testSuitepath- Testsuite Excel file path
		//					: sheetName- Sheet Name
		//					: row - row number
		//					: Col - Column name
		// Return Value    	: TestScenario Name
		//====================================================================================================	

		public String getSmokeTestScenarioName(String testSuitepath, String sheet , int row, String Col)
		{
			
			
			String flag = readexcel.getDataFromExcel(testSuitepath, sheet, Col, row);
			if(flag.trim().toUpperCase().equals("Smoke"))
			{
				return (readexcel.getDataFromExcel(testSuitepath, sheet, "Scenarios", row));
			}
			else
			{
				return null;	
			}
		}
		
		//====================================================================================================
		// FunctionName    	: getRegressionTestcaseName
		// Description     	: Function to get the Regression Scenario Name which need to execute based on execute flag
		// Input Parameter 	: testSuitepath- Testsuite Excel file path
		//					: sheetName- Sheet Name
		//					: row - row number
		//					: Col - Column name
		// Return Value    	: TestScenario Name
		//====================================================================================================	

		public String getRegressionTestcaseName(String testSuitepath, String sheet , int row, String Col)
		{
			
			
			String flag = readexcel.getDataFromExcel(testSuitepath, sheet, Col, row);
			if(flag.trim().toUpperCase().equals("Regression"))
			{
				return (readexcel.getDataFromExcel(testSuitepath, sheet, "Scenarios", row));
			}
			else
			{
				return null;	
			}
		}
}