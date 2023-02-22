package Module1_Home_TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilityClass;
import Module1_Home.Insurance_Broker_Insurance_Webpage;
import Module1_Home.Insurance_Login;

public class Insurance_TestNG_TestClass extends BaseClass
{
	Insurance_Login Login;
	Insurance_Broker_Insurance_Webpage Broker;
	
	@BeforeClass
	public void OpenBrowser()
	{
	InitializeBrowser();	
	//create object of POM 1
	Login=new Insurance_Login(driver);
	
	//CREATE OBJECT OF POM 2
    Broker=new Insurance_Broker_Insurance_Webpage(driver);
	
	
	}
	
	@BeforeMethod
	public void LoginToApp() throws IOException
	{
	   Login.EnterEmail(UtilityClass.getDatafromPF("EM"));
	   
	   Login.EnterPassword(UtilityClass.getDatafromPF("PSW"));
	   
	   Login.ClickLoginBtn();
		
	}
	
	@Test(priority=1)
	public void verifyEmailAddress() throws EncryptedDocumentException, IOException 
	{
	//verify email address
		String ActualEmail =Broker.getEmail();
		String ExpectedEmail=UtilityClass.getdatafromExcelsheet(2, 0);	
		
		Assert.assertEquals(ActualEmail,ExpectedEmail);
	}
	@Test(priority=2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException 
	{
		//Assert.fail();
		String ActualTitle=driver.getTitle();
		String ExpectedTitle=UtilityClass.getdatafromExcelsheet(3, 0);
		
		Assert.assertEquals(ActualTitle,ExpectedTitle);
	
	}
	
	
	@AfterMethod
	public void LogoutFromApp(ITestResult Result) throws IOException 
	{
		
		if(Result.getStatus()==ITestResult.FAILURE) 
		{
			UtilityClass.CaptureScreenshot(driver);
		}
		
		
		
		
		Broker.ClickLogoutBtn();
	}
	
	@AfterClass
	public void CloseBrowser() 
	{
		driver.close();
	}

}
