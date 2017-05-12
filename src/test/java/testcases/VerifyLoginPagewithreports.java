package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;
import factory.BrowserFactory;
import factory.DataFactory;

public class VerifyLoginPagewithreports {
	WebDriver driver;
	com.relevantcodes.extentreports.ExtentReports report;
	com.relevantcodes.extentreports.ExtentTest logger;
	
@BeforeMethod
	public void setup()
{
report=new com.relevantcodes.extentreports.ExtentReports("./Reports/loginreports.html",true);
logger=report.startTest("verify test login");
	
driver=BrowserFactory.getbrowser("firefox");
driver.get(DataFactory.getConfig().getapplicationurl());
logger.log(LogStatus.INFO,"application is running");
	
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
	logger.log(LogStatus.PASS, "home page loaded and verified");
	login.verify_signoutlink();
	logger.log(LogStatus.PASS, "sign out link is present");
	
		
	}
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closebrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
