package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String capturescreenshot(WebDriver driver,String screenshotname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination="C:\\hybridframeworkmukesh\\learn-automation.hybrid\\screenshots\\"+screenshotname+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e)
		{
		System.out.println("screen shot can be taken"+e.getMessage());	
			
		}
	return destination;
	}
}
