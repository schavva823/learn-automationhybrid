package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import factory.BrowserFactory;
import factory.DataFactory;

public class VerifyLoginPage {
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
		
	LoginPage login=PageFactory.initElements(driver,LoginPage.class);
	login.loginpage(DataFactory.getExcel().getdata(0, 0,0),DataFactory.getExcel().getdata(0, 0, 1));
	
//	System.out.println("application title is"+title);
	Assert.assertTrue(title.contains(" Demo Store"));
	login.verify_signoutlink();
	
		
	}
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closebrowser(driver);
	}
}
