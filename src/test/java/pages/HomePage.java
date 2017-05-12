package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	
	public  HomePage(WebDriver ldriver)
	
	{
		this.driver=ldriver;
	}
	@FindBy(xpath=(".//a[text()='Features']")) WebElement featureslink;
	@FindBy(xpath=(".//a[text()='Pricing']")) WebElement pricinglink;
	@FindBy(xpath=(".//a[text()='Contact Us']")) WebElement contactuslink;
	@FindBy(xpath=(".//a[text()='View Demo']")) WebElement viewdemolink;
	
	public void clickonfeatureslink()
	{
		featureslink.click();
	}
	
	public void clickonpricing()
	{
		pricinglink.click();
	}
	
	public void clickoncontactuslink()
	{
		contactuslink.click();
	}
	
	public void clickonviewdemolink()
	{
		viewdemolink.click();
	}
	public String getapplicationtitle()
	{
		
	return driver.getTitle();
	}
	
}
