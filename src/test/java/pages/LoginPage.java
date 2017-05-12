package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(id="account_sign_in_form_email_id") WebElement username;
	
	@FindBy(xpath=".//*[@id='account_sign_in_form_passwd_id']") WebElement password;
	@FindBy(xpath=".//*[@id='send2']") WebElement login_button;
	
	By signout=By.xpath("//a[@class='sign_out_link']");
public void loginpage(String user,String pass)
{
	username.sendKeys(user);
	password.sendKeys(pass);
	login_button.click();
}
public void verify_signoutlink()
{
	WebDriverWait wait=new WebDriverWait(driver,20);
WebElement ele=	wait.until(ExpectedConditions.presenceOfElementLocated(signout));
String text=ele.getText();
Assert.assertEquals(text, "Sign Out","signout link is not verified");
System.out.println("sign out link is verified");

}
}

