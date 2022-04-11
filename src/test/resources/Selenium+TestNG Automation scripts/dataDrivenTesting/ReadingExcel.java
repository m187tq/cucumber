package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("C://SeleniumPractice/data3.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rownum=sheet.getLastRowNum(); // returns number of rows present in excel sheet
		int colcount=sheet.getRow(0).getLastCellNum(); // returns number of cells present in a row
		
		for(int i=0;i<=rownum;i++)
		{
			XSSFRow row=sheet.getRow(i);
			
			for(int j=0;j<colcount;j++)
			{
				String value=row.getCell(j).toString(); // reading the data from cell
				System.out.print(value+" ");
					
			}
			
			System.out.println();
			
		}

	}

}
