package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import factory.BrowserFactory;
import factory.DataFactory;

public class VerifyHomePage {
	WebDriver driver;
@BeforeMethod
	public void setup()
{
driver=BrowserFactory.getbrowser("firefox");
	driver.get(DataFactory.getConfig().getapplicationurl());
	
}
	@Test
	
	public void testhomepage()
	{
	
	HomePage home=PageFactory.initElements(driver,HomePage.class);
	String title=home.getapplicationtitle();
	
//	System.out.println("application title is"+title);
	Assert.assertTrue(title.contains(" Demo Store"));
	
	
		
	}
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closebrowser(driver);
	}
}
