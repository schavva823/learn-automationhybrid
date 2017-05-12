package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	public ConfigDataProvider()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
		System.out.println("exeption is"+e.getMessage());
		}
	}
	
	public String getchromepath()
	{
		String path=pro.getProperty("chromepath");
		return path;
	}
	public String getIEpath()
	{
		String url=pro.getProperty("IEpath");
		return url;
	}
	public String firefoxpath()
	{
		String url=pro.getProperty("firefoxpath");
		return url;
	}
	public String getapplicationurl()
	{
		String url=pro.getProperty("url");
		return url;
	}
}
