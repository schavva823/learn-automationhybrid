package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("./applicationdata/appdata.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
		
			System.out.println("exception is"+e.getMessage());;
		}
	}
	
	public String getdata(int sheetindex,int row,int column)
	{
    String data=wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();

	return data;	
	}
	public String getdata(String sheetname,int row,int column)
	{
    String data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();

	return data;	
	}
}
