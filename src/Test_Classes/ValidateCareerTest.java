package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom_Classes.BaseClass;
import pom_Classes.HomePage;
import utility.UtilityClass;

public class ValidateCareerTest extends BaseClass
{
	HomePage home;
	
	@BeforeClass
	public void openBrowse()
	{
		BaseClass.openBrowser();
	}
	
	@Test
	public void verifyCareersLink()
	{
		home = new HomePage(driver);
		boolean actResult = home.verifyCareerLink();
		Assert.assertTrue(actResult);
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot();
		}
			
	}
	
	@AfterClass
	public void closeBrowse()
	{
		BaseClass.closeBrowser();
	}
}
