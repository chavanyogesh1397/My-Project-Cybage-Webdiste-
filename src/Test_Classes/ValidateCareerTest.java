package Test_Classes;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom_Classes.BaseClass;
import pom_Classes.CareersPage;
import pom_Classes.HomePage;
import utility.UtilityClass;

public class ValidateCareerTest extends BaseClass
{
	CareersPage car;
	HomePage home;
	int Tid;
	
	@BeforeClass
	public void openBrowse()
	{
		BaseClass.openBrowser();
	}
	
	@Test(priority=0)
	public void verifyCareersLink()
	{
		home = new HomePage(driver);
		Tid = 100;
		boolean actResult = home.verifyCareerLink();
		Assert.assertTrue(actResult);
	}
	
	@Test(priority=1)
	public void verifyCareersPage() throws EncryptedDocumentException, IOException
	{
		home.clickCareerLink();	
		car = new CareersPage(driver);
		String actResult = car.verifyCareersPage(driver);
		String expResult = UtilityClass.TestData(3,6);
		Assert.assertEquals(actResult, expResult);
	}
	
	@Test(priority=2)
	public void verifyCurrentOpeningsTab() throws EncryptedDocumentException, IOException
	{
		String ActResult = car.verifyCurrentOpngsTab();
		String ExpResult = UtilityClass.TestData(4, 6);
		Assert.assertEquals(ActResult, ExpResult);
	}
	
	@Test(priority=3)
	public void validateSelectLocationDrop() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(1000);
		String ActResult = "India";
		List<WebElement> optns = car.verifySelLocationDropdown(driver);
		String ExpResult = UtilityClass.TestData(6,6);
		for(WebElement opt :optns)
		{
			String data = opt.getText();
			if(ActResult.equals(data))
			{
				opt.click();
			}
		}
	}
	
	

	@AfterMethod
	public void screenshot(ITestResult result) throws IOException
	{
		int screen = result.getStatus();
		if(screen == ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, Tid);
		}	
	}
	
	@AfterClass
	public void closeBrowse()
	{
		//BaseClass.closeBrowser();
	}
}
